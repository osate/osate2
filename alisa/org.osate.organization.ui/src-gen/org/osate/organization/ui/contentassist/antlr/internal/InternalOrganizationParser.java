package org.osate.organization.ui.contentassist.antlr.internal; 

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
import org.osate.organization.services.OrganizationGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalOrganizationParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'organization'", "'stakeholder'", "'['", "']'", "'title'", "'description'", "'role'", "'email'", "'phone'", "'.'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalOrganizationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOrganizationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOrganizationParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g"; }


     
     	private OrganizationGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(OrganizationGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleOrganization"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:60:1: entryRuleOrganization : ruleOrganization EOF ;
    public final void entryRuleOrganization() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:61:1: ( ruleOrganization EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:62:1: ruleOrganization EOF
            {
             before(grammarAccess.getOrganizationRule()); 
            pushFollow(FOLLOW_ruleOrganization_in_entryRuleOrganization61);
            ruleOrganization();

            state._fsp--;

             after(grammarAccess.getOrganizationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrganization68); 

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
    // $ANTLR end "entryRuleOrganization"


    // $ANTLR start "ruleOrganization"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:69:1: ruleOrganization : ( ( rule__Organization__Group__0 ) ) ;
    public final void ruleOrganization() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:73:2: ( ( ( rule__Organization__Group__0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:74:1: ( ( rule__Organization__Group__0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:74:1: ( ( rule__Organization__Group__0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:75:1: ( rule__Organization__Group__0 )
            {
             before(grammarAccess.getOrganizationAccess().getGroup()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:76:1: ( rule__Organization__Group__0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:76:2: rule__Organization__Group__0
            {
            pushFollow(FOLLOW_rule__Organization__Group__0_in_ruleOrganization94);
            rule__Organization__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrganizationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrganization"


    // $ANTLR start "entryRuleStakeholder"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:88:1: entryRuleStakeholder : ruleStakeholder EOF ;
    public final void entryRuleStakeholder() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:89:1: ( ruleStakeholder EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:90:1: ruleStakeholder EOF
            {
             before(grammarAccess.getStakeholderRule()); 
            pushFollow(FOLLOW_ruleStakeholder_in_entryRuleStakeholder121);
            ruleStakeholder();

            state._fsp--;

             after(grammarAccess.getStakeholderRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStakeholder128); 

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
    // $ANTLR end "entryRuleStakeholder"


    // $ANTLR start "ruleStakeholder"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:97:1: ruleStakeholder : ( ( rule__Stakeholder__Group__0 ) ) ;
    public final void ruleStakeholder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:101:2: ( ( ( rule__Stakeholder__Group__0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:102:1: ( ( rule__Stakeholder__Group__0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:102:1: ( ( rule__Stakeholder__Group__0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:103:1: ( rule__Stakeholder__Group__0 )
            {
             before(grammarAccess.getStakeholderAccess().getGroup()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:104:1: ( rule__Stakeholder__Group__0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:104:2: rule__Stakeholder__Group__0
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__0_in_ruleStakeholder154);
            rule__Stakeholder__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStakeholder"


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:118:1: entryRuleDescription : ruleDescription EOF ;
    public final void entryRuleDescription() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:119:1: ( ruleDescription EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:120:1: ruleDescription EOF
            {
             before(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription183);
            ruleDescription();

            state._fsp--;

             after(grammarAccess.getDescriptionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription190); 

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:127:1: ruleDescription : ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) ) ;
    public final void ruleDescription() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:131:2: ( ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:132:1: ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:132:1: ( ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:133:1: ( ( rule__Description__DescriptionAssignment ) ) ( ( rule__Description__DescriptionAssignment )* )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:133:1: ( ( rule__Description__DescriptionAssignment ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:134:1: ( rule__Description__DescriptionAssignment )
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:135:1: ( rule__Description__DescriptionAssignment )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:135:2: rule__Description__DescriptionAssignment
            {
            pushFollow(FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription218);
            rule__Description__DescriptionAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 

            }

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:138:1: ( ( rule__Description__DescriptionAssignment )* )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:139:1: ( rule__Description__DescriptionAssignment )*
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionAssignment()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:140:1: ( rule__Description__DescriptionAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:140:2: rule__Description__DescriptionAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription230);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:153:1: entryRuleDescriptionElement : ruleDescriptionElement EOF ;
    public final void entryRuleDescriptionElement() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:154:1: ( ruleDescriptionElement EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:155:1: ruleDescriptionElement EOF
            {
             before(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement260);
            ruleDescriptionElement();

            state._fsp--;

             after(grammarAccess.getDescriptionElementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement267); 

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:162:1: ruleDescriptionElement : ( ( rule__DescriptionElement__Alternatives ) ) ;
    public final void ruleDescriptionElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:166:2: ( ( ( rule__DescriptionElement__Alternatives ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:167:1: ( ( rule__DescriptionElement__Alternatives ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:167:1: ( ( rule__DescriptionElement__Alternatives ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:168:1: ( rule__DescriptionElement__Alternatives )
            {
             before(grammarAccess.getDescriptionElementAccess().getAlternatives()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:169:1: ( rule__DescriptionElement__Alternatives )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:169:2: rule__DescriptionElement__Alternatives
            {
            pushFollow(FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement293);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:181:1: entryRuleReferencePath : ruleReferencePath EOF ;
    public final void entryRuleReferencePath() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:182:1: ( ruleReferencePath EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:183:1: ruleReferencePath EOF
            {
             before(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath320);
            ruleReferencePath();

            state._fsp--;

             after(grammarAccess.getReferencePathRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath327); 

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:190:1: ruleReferencePath : ( ( rule__ReferencePath__Group__0 ) ) ;
    public final void ruleReferencePath() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:194:2: ( ( ( rule__ReferencePath__Group__0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:195:1: ( ( rule__ReferencePath__Group__0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:195:1: ( ( rule__ReferencePath__Group__0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:196:1: ( rule__ReferencePath__Group__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:197:1: ( rule__ReferencePath__Group__0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:197:2: rule__ReferencePath__Group__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath353);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:209:1: entryRuleValueString : ruleValueString EOF ;
    public final void entryRuleValueString() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:210:1: ( ruleValueString EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:211:1: ruleValueString EOF
            {
             before(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString380);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getValueStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString387); 

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:218:1: ruleValueString : ( RULE_STRING ) ;
    public final void ruleValueString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:222:2: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:223:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:223:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:224:1: RULE_STRING
            {
             before(grammarAccess.getValueStringAccess().getSTRINGTerminalRuleCall()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString413); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:243:1: rule__DescriptionElement__Alternatives : ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) );
    public final void rule__DescriptionElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:247:1: ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) )
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:248:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:248:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:249:1: ( rule__DescriptionElement__TextAssignment_0 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:250:1: ( rule__DescriptionElement__TextAssignment_0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:250:2: rule__DescriptionElement__TextAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives454);
                    rule__DescriptionElement__TextAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:254:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:254:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:255:1: ( rule__DescriptionElement__RefAssignment_1 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getRefAssignment_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:256:1: ( rule__DescriptionElement__RefAssignment_1 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:256:2: rule__DescriptionElement__RefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives472);
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


    // $ANTLR start "rule__Organization__Group__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:267:1: rule__Organization__Group__0 : rule__Organization__Group__0__Impl rule__Organization__Group__1 ;
    public final void rule__Organization__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:271:1: ( rule__Organization__Group__0__Impl rule__Organization__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:272:2: rule__Organization__Group__0__Impl rule__Organization__Group__1
            {
            pushFollow(FOLLOW_rule__Organization__Group__0__Impl_in_rule__Organization__Group__0503);
            rule__Organization__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Organization__Group__1_in_rule__Organization__Group__0506);
            rule__Organization__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Organization__Group__0"


    // $ANTLR start "rule__Organization__Group__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:279:1: rule__Organization__Group__0__Impl : ( 'organization' ) ;
    public final void rule__Organization__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:283:1: ( ( 'organization' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:284:1: ( 'organization' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:284:1: ( 'organization' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:285:1: 'organization'
            {
             before(grammarAccess.getOrganizationAccess().getOrganizationKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Organization__Group__0__Impl534); 
             after(grammarAccess.getOrganizationAccess().getOrganizationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Organization__Group__0__Impl"


    // $ANTLR start "rule__Organization__Group__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:298:1: rule__Organization__Group__1 : rule__Organization__Group__1__Impl rule__Organization__Group__2 ;
    public final void rule__Organization__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:302:1: ( rule__Organization__Group__1__Impl rule__Organization__Group__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:303:2: rule__Organization__Group__1__Impl rule__Organization__Group__2
            {
            pushFollow(FOLLOW_rule__Organization__Group__1__Impl_in_rule__Organization__Group__1565);
            rule__Organization__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Organization__Group__2_in_rule__Organization__Group__1568);
            rule__Organization__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Organization__Group__1"


    // $ANTLR start "rule__Organization__Group__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:310:1: rule__Organization__Group__1__Impl : ( ( rule__Organization__NameAssignment_1 ) ) ;
    public final void rule__Organization__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:314:1: ( ( ( rule__Organization__NameAssignment_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:315:1: ( ( rule__Organization__NameAssignment_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:315:1: ( ( rule__Organization__NameAssignment_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:316:1: ( rule__Organization__NameAssignment_1 )
            {
             before(grammarAccess.getOrganizationAccess().getNameAssignment_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:317:1: ( rule__Organization__NameAssignment_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:317:2: rule__Organization__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Organization__NameAssignment_1_in_rule__Organization__Group__1__Impl595);
            rule__Organization__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOrganizationAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Organization__Group__1__Impl"


    // $ANTLR start "rule__Organization__Group__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:327:1: rule__Organization__Group__2 : rule__Organization__Group__2__Impl ;
    public final void rule__Organization__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:331:1: ( rule__Organization__Group__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:332:2: rule__Organization__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Organization__Group__2__Impl_in_rule__Organization__Group__2625);
            rule__Organization__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Organization__Group__2"


    // $ANTLR start "rule__Organization__Group__2__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:338:1: rule__Organization__Group__2__Impl : ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) ) ;
    public final void rule__Organization__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:342:1: ( ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:343:1: ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:343:1: ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:344:1: ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:344:1: ( ( rule__Organization__StakeholderAssignment_2 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:345:1: ( rule__Organization__StakeholderAssignment_2 )
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:346:1: ( rule__Organization__StakeholderAssignment_2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:346:2: rule__Organization__StakeholderAssignment_2
            {
            pushFollow(FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl654);
            rule__Organization__StakeholderAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 

            }

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:349:1: ( ( rule__Organization__StakeholderAssignment_2 )* )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:350:1: ( rule__Organization__StakeholderAssignment_2 )*
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:351:1: ( rule__Organization__StakeholderAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:351:2: rule__Organization__StakeholderAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl666);
            	    rule__Organization__StakeholderAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 

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
    // $ANTLR end "rule__Organization__Group__2__Impl"


    // $ANTLR start "rule__Stakeholder__Group__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:368:1: rule__Stakeholder__Group__0 : rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1 ;
    public final void rule__Stakeholder__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:372:1: ( rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:373:2: rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__0__Impl_in_rule__Stakeholder__Group__0705);
            rule__Stakeholder__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__1_in_rule__Stakeholder__Group__0708);
            rule__Stakeholder__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__0"


    // $ANTLR start "rule__Stakeholder__Group__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:380:1: rule__Stakeholder__Group__0__Impl : ( 'stakeholder' ) ;
    public final void rule__Stakeholder__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:384:1: ( ( 'stakeholder' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:385:1: ( 'stakeholder' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:385:1: ( 'stakeholder' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:386:1: 'stakeholder'
            {
             before(grammarAccess.getStakeholderAccess().getStakeholderKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__Stakeholder__Group__0__Impl736); 
             after(grammarAccess.getStakeholderAccess().getStakeholderKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:399:1: rule__Stakeholder__Group__1 : rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2 ;
    public final void rule__Stakeholder__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:403:1: ( rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:404:2: rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__1__Impl_in_rule__Stakeholder__Group__1767);
            rule__Stakeholder__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__2_in_rule__Stakeholder__Group__1770);
            rule__Stakeholder__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__1"


    // $ANTLR start "rule__Stakeholder__Group__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:411:1: rule__Stakeholder__Group__1__Impl : ( ( rule__Stakeholder__NameAssignment_1 ) ) ;
    public final void rule__Stakeholder__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:415:1: ( ( ( rule__Stakeholder__NameAssignment_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:416:1: ( ( rule__Stakeholder__NameAssignment_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:416:1: ( ( rule__Stakeholder__NameAssignment_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:417:1: ( rule__Stakeholder__NameAssignment_1 )
            {
             before(grammarAccess.getStakeholderAccess().getNameAssignment_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:418:1: ( rule__Stakeholder__NameAssignment_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:418:2: rule__Stakeholder__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__NameAssignment_1_in_rule__Stakeholder__Group__1__Impl797);
            rule__Stakeholder__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:428:1: rule__Stakeholder__Group__2 : rule__Stakeholder__Group__2__Impl rule__Stakeholder__Group__3 ;
    public final void rule__Stakeholder__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:432:1: ( rule__Stakeholder__Group__2__Impl rule__Stakeholder__Group__3 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:433:2: rule__Stakeholder__Group__2__Impl rule__Stakeholder__Group__3
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__2__Impl_in_rule__Stakeholder__Group__2827);
            rule__Stakeholder__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__3_in_rule__Stakeholder__Group__2830);
            rule__Stakeholder__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__2"


    // $ANTLR start "rule__Stakeholder__Group__2__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:440:1: rule__Stakeholder__Group__2__Impl : ( '[' ) ;
    public final void rule__Stakeholder__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:444:1: ( ( '[' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:445:1: ( '[' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:445:1: ( '[' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:446:1: '['
            {
             before(grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__Stakeholder__Group__2__Impl858); 
             after(grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__2__Impl"


    // $ANTLR start "rule__Stakeholder__Group__3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:459:1: rule__Stakeholder__Group__3 : rule__Stakeholder__Group__3__Impl rule__Stakeholder__Group__4 ;
    public final void rule__Stakeholder__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:463:1: ( rule__Stakeholder__Group__3__Impl rule__Stakeholder__Group__4 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:464:2: rule__Stakeholder__Group__3__Impl rule__Stakeholder__Group__4
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__3__Impl_in_rule__Stakeholder__Group__3889);
            rule__Stakeholder__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__4_in_rule__Stakeholder__Group__3892);
            rule__Stakeholder__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__3"


    // $ANTLR start "rule__Stakeholder__Group__3__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:471:1: rule__Stakeholder__Group__3__Impl : ( ( rule__Stakeholder__UnorderedGroup_3 ) ) ;
    public final void rule__Stakeholder__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:475:1: ( ( ( rule__Stakeholder__UnorderedGroup_3 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:476:1: ( ( rule__Stakeholder__UnorderedGroup_3 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:476:1: ( ( rule__Stakeholder__UnorderedGroup_3 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:477:1: ( rule__Stakeholder__UnorderedGroup_3 )
            {
             before(grammarAccess.getStakeholderAccess().getUnorderedGroup_3()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:478:1: ( rule__Stakeholder__UnorderedGroup_3 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:478:2: rule__Stakeholder__UnorderedGroup_3
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3_in_rule__Stakeholder__Group__3__Impl919);
            rule__Stakeholder__UnorderedGroup_3();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getUnorderedGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__3__Impl"


    // $ANTLR start "rule__Stakeholder__Group__4"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:488:1: rule__Stakeholder__Group__4 : rule__Stakeholder__Group__4__Impl ;
    public final void rule__Stakeholder__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:492:1: ( rule__Stakeholder__Group__4__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:493:2: rule__Stakeholder__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__4__Impl_in_rule__Stakeholder__Group__4949);
            rule__Stakeholder__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__4"


    // $ANTLR start "rule__Stakeholder__Group__4__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:499:1: rule__Stakeholder__Group__4__Impl : ( ']' ) ;
    public final void rule__Stakeholder__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:503:1: ( ( ']' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:504:1: ( ']' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:504:1: ( ']' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:505:1: ']'
            {
             before(grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__Stakeholder__Group__4__Impl977); 
             after(grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group__4__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_0__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:528:1: rule__Stakeholder__Group_3_0__0 : rule__Stakeholder__Group_3_0__0__Impl rule__Stakeholder__Group_3_0__1 ;
    public final void rule__Stakeholder__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:532:1: ( rule__Stakeholder__Group_3_0__0__Impl rule__Stakeholder__Group_3_0__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:533:2: rule__Stakeholder__Group_3_0__0__Impl rule__Stakeholder__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__0__Impl_in_rule__Stakeholder__Group_3_0__01018);
            rule__Stakeholder__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__1_in_rule__Stakeholder__Group_3_0__01021);
            rule__Stakeholder__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_0__0"


    // $ANTLR start "rule__Stakeholder__Group_3_0__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:540:1: rule__Stakeholder__Group_3_0__0__Impl : ( 'title' ) ;
    public final void rule__Stakeholder__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:544:1: ( ( 'title' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:545:1: ( 'title' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:545:1: ( 'title' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:546:1: 'title'
            {
             before(grammarAccess.getStakeholderAccess().getTitleKeyword_3_0_0()); 
            match(input,15,FOLLOW_15_in_rule__Stakeholder__Group_3_0__0__Impl1049); 
             after(grammarAccess.getStakeholderAccess().getTitleKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_0__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_0__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:559:1: rule__Stakeholder__Group_3_0__1 : rule__Stakeholder__Group_3_0__1__Impl ;
    public final void rule__Stakeholder__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:563:1: ( rule__Stakeholder__Group_3_0__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:564:2: rule__Stakeholder__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__1__Impl_in_rule__Stakeholder__Group_3_0__11080);
            rule__Stakeholder__Group_3_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_0__1"


    // $ANTLR start "rule__Stakeholder__Group_3_0__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:570:1: rule__Stakeholder__Group_3_0__1__Impl : ( ( rule__Stakeholder__TitleAssignment_3_0_1 ) ) ;
    public final void rule__Stakeholder__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:574:1: ( ( ( rule__Stakeholder__TitleAssignment_3_0_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:575:1: ( ( rule__Stakeholder__TitleAssignment_3_0_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:575:1: ( ( rule__Stakeholder__TitleAssignment_3_0_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:576:1: ( rule__Stakeholder__TitleAssignment_3_0_1 )
            {
             before(grammarAccess.getStakeholderAccess().getTitleAssignment_3_0_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:577:1: ( rule__Stakeholder__TitleAssignment_3_0_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:577:2: rule__Stakeholder__TitleAssignment_3_0_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__TitleAssignment_3_0_1_in_rule__Stakeholder__Group_3_0__1__Impl1107);
            rule__Stakeholder__TitleAssignment_3_0_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getTitleAssignment_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_0__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:591:1: rule__Stakeholder__Group_3_1__0 : rule__Stakeholder__Group_3_1__0__Impl rule__Stakeholder__Group_3_1__1 ;
    public final void rule__Stakeholder__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:595:1: ( rule__Stakeholder__Group_3_1__0__Impl rule__Stakeholder__Group_3_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:596:2: rule__Stakeholder__Group_3_1__0__Impl rule__Stakeholder__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_1__0__Impl_in_rule__Stakeholder__Group_3_1__01141);
            rule__Stakeholder__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_1__1_in_rule__Stakeholder__Group_3_1__01144);
            rule__Stakeholder__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_1__0"


    // $ANTLR start "rule__Stakeholder__Group_3_1__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:603:1: rule__Stakeholder__Group_3_1__0__Impl : ( 'description' ) ;
    public final void rule__Stakeholder__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:607:1: ( ( 'description' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:608:1: ( 'description' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:608:1: ( 'description' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:609:1: 'description'
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionKeyword_3_1_0()); 
            match(input,16,FOLLOW_16_in_rule__Stakeholder__Group_3_1__0__Impl1172); 
             after(grammarAccess.getStakeholderAccess().getDescriptionKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_1__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_1__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:622:1: rule__Stakeholder__Group_3_1__1 : rule__Stakeholder__Group_3_1__1__Impl ;
    public final void rule__Stakeholder__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:626:1: ( rule__Stakeholder__Group_3_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:627:2: rule__Stakeholder__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_1__1__Impl_in_rule__Stakeholder__Group_3_1__11203);
            rule__Stakeholder__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_1__1"


    // $ANTLR start "rule__Stakeholder__Group_3_1__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:633:1: rule__Stakeholder__Group_3_1__1__Impl : ( ( rule__Stakeholder__DescriptionAssignment_3_1_1 ) ) ;
    public final void rule__Stakeholder__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:637:1: ( ( ( rule__Stakeholder__DescriptionAssignment_3_1_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:638:1: ( ( rule__Stakeholder__DescriptionAssignment_3_1_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:638:1: ( ( rule__Stakeholder__DescriptionAssignment_3_1_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:639:1: ( rule__Stakeholder__DescriptionAssignment_3_1_1 )
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionAssignment_3_1_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:640:1: ( rule__Stakeholder__DescriptionAssignment_3_1_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:640:2: rule__Stakeholder__DescriptionAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__DescriptionAssignment_3_1_1_in_rule__Stakeholder__Group_3_1__1__Impl1230);
            rule__Stakeholder__DescriptionAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getDescriptionAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_1__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_2__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:654:1: rule__Stakeholder__Group_3_2__0 : rule__Stakeholder__Group_3_2__0__Impl rule__Stakeholder__Group_3_2__1 ;
    public final void rule__Stakeholder__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:658:1: ( rule__Stakeholder__Group_3_2__0__Impl rule__Stakeholder__Group_3_2__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:659:2: rule__Stakeholder__Group_3_2__0__Impl rule__Stakeholder__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_2__0__Impl_in_rule__Stakeholder__Group_3_2__01264);
            rule__Stakeholder__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_2__1_in_rule__Stakeholder__Group_3_2__01267);
            rule__Stakeholder__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_2__0"


    // $ANTLR start "rule__Stakeholder__Group_3_2__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:666:1: rule__Stakeholder__Group_3_2__0__Impl : ( 'role' ) ;
    public final void rule__Stakeholder__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:670:1: ( ( 'role' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:671:1: ( 'role' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:671:1: ( 'role' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:672:1: 'role'
            {
             before(grammarAccess.getStakeholderAccess().getRoleKeyword_3_2_0()); 
            match(input,17,FOLLOW_17_in_rule__Stakeholder__Group_3_2__0__Impl1295); 
             after(grammarAccess.getStakeholderAccess().getRoleKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_2__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_2__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:685:1: rule__Stakeholder__Group_3_2__1 : rule__Stakeholder__Group_3_2__1__Impl ;
    public final void rule__Stakeholder__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:689:1: ( rule__Stakeholder__Group_3_2__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:690:2: rule__Stakeholder__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_2__1__Impl_in_rule__Stakeholder__Group_3_2__11326);
            rule__Stakeholder__Group_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_2__1"


    // $ANTLR start "rule__Stakeholder__Group_3_2__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:696:1: rule__Stakeholder__Group_3_2__1__Impl : ( ( rule__Stakeholder__RoleAssignment_3_2_1 ) ) ;
    public final void rule__Stakeholder__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:700:1: ( ( ( rule__Stakeholder__RoleAssignment_3_2_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:701:1: ( ( rule__Stakeholder__RoleAssignment_3_2_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:701:1: ( ( rule__Stakeholder__RoleAssignment_3_2_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:702:1: ( rule__Stakeholder__RoleAssignment_3_2_1 )
            {
             before(grammarAccess.getStakeholderAccess().getRoleAssignment_3_2_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:703:1: ( rule__Stakeholder__RoleAssignment_3_2_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:703:2: rule__Stakeholder__RoleAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__RoleAssignment_3_2_1_in_rule__Stakeholder__Group_3_2__1__Impl1353);
            rule__Stakeholder__RoleAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getRoleAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_2__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_3__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:717:1: rule__Stakeholder__Group_3_3__0 : rule__Stakeholder__Group_3_3__0__Impl rule__Stakeholder__Group_3_3__1 ;
    public final void rule__Stakeholder__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:721:1: ( rule__Stakeholder__Group_3_3__0__Impl rule__Stakeholder__Group_3_3__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:722:2: rule__Stakeholder__Group_3_3__0__Impl rule__Stakeholder__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_3__0__Impl_in_rule__Stakeholder__Group_3_3__01387);
            rule__Stakeholder__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_3__1_in_rule__Stakeholder__Group_3_3__01390);
            rule__Stakeholder__Group_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_3__0"


    // $ANTLR start "rule__Stakeholder__Group_3_3__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:729:1: rule__Stakeholder__Group_3_3__0__Impl : ( 'email' ) ;
    public final void rule__Stakeholder__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:733:1: ( ( 'email' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:734:1: ( 'email' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:734:1: ( 'email' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:735:1: 'email'
            {
             before(grammarAccess.getStakeholderAccess().getEmailKeyword_3_3_0()); 
            match(input,18,FOLLOW_18_in_rule__Stakeholder__Group_3_3__0__Impl1418); 
             after(grammarAccess.getStakeholderAccess().getEmailKeyword_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_3__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_3__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:748:1: rule__Stakeholder__Group_3_3__1 : rule__Stakeholder__Group_3_3__1__Impl ;
    public final void rule__Stakeholder__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:752:1: ( rule__Stakeholder__Group_3_3__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:753:2: rule__Stakeholder__Group_3_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_3__1__Impl_in_rule__Stakeholder__Group_3_3__11449);
            rule__Stakeholder__Group_3_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_3__1"


    // $ANTLR start "rule__Stakeholder__Group_3_3__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:759:1: rule__Stakeholder__Group_3_3__1__Impl : ( ( rule__Stakeholder__EmailAssignment_3_3_1 ) ) ;
    public final void rule__Stakeholder__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:763:1: ( ( ( rule__Stakeholder__EmailAssignment_3_3_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:764:1: ( ( rule__Stakeholder__EmailAssignment_3_3_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:764:1: ( ( rule__Stakeholder__EmailAssignment_3_3_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:765:1: ( rule__Stakeholder__EmailAssignment_3_3_1 )
            {
             before(grammarAccess.getStakeholderAccess().getEmailAssignment_3_3_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:766:1: ( rule__Stakeholder__EmailAssignment_3_3_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:766:2: rule__Stakeholder__EmailAssignment_3_3_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__EmailAssignment_3_3_1_in_rule__Stakeholder__Group_3_3__1__Impl1476);
            rule__Stakeholder__EmailAssignment_3_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getEmailAssignment_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_3__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_4__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:780:1: rule__Stakeholder__Group_3_4__0 : rule__Stakeholder__Group_3_4__0__Impl rule__Stakeholder__Group_3_4__1 ;
    public final void rule__Stakeholder__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:784:1: ( rule__Stakeholder__Group_3_4__0__Impl rule__Stakeholder__Group_3_4__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:785:2: rule__Stakeholder__Group_3_4__0__Impl rule__Stakeholder__Group_3_4__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_4__0__Impl_in_rule__Stakeholder__Group_3_4__01510);
            rule__Stakeholder__Group_3_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_4__1_in_rule__Stakeholder__Group_3_4__01513);
            rule__Stakeholder__Group_3_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_4__0"


    // $ANTLR start "rule__Stakeholder__Group_3_4__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:792:1: rule__Stakeholder__Group_3_4__0__Impl : ( 'phone' ) ;
    public final void rule__Stakeholder__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:796:1: ( ( 'phone' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:797:1: ( 'phone' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:797:1: ( 'phone' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:798:1: 'phone'
            {
             before(grammarAccess.getStakeholderAccess().getPhoneKeyword_3_4_0()); 
            match(input,19,FOLLOW_19_in_rule__Stakeholder__Group_3_4__0__Impl1541); 
             after(grammarAccess.getStakeholderAccess().getPhoneKeyword_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_4__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_4__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:811:1: rule__Stakeholder__Group_3_4__1 : rule__Stakeholder__Group_3_4__1__Impl ;
    public final void rule__Stakeholder__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:815:1: ( rule__Stakeholder__Group_3_4__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:816:2: rule__Stakeholder__Group_3_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_4__1__Impl_in_rule__Stakeholder__Group_3_4__11572);
            rule__Stakeholder__Group_3_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_4__1"


    // $ANTLR start "rule__Stakeholder__Group_3_4__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:822:1: rule__Stakeholder__Group_3_4__1__Impl : ( ( rule__Stakeholder__PhoneAssignment_3_4_1 ) ) ;
    public final void rule__Stakeholder__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:826:1: ( ( ( rule__Stakeholder__PhoneAssignment_3_4_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:827:1: ( ( rule__Stakeholder__PhoneAssignment_3_4_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:827:1: ( ( rule__Stakeholder__PhoneAssignment_3_4_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:828:1: ( rule__Stakeholder__PhoneAssignment_3_4_1 )
            {
             before(grammarAccess.getStakeholderAccess().getPhoneAssignment_3_4_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:829:1: ( rule__Stakeholder__PhoneAssignment_3_4_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:829:2: rule__Stakeholder__PhoneAssignment_3_4_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__PhoneAssignment_3_4_1_in_rule__Stakeholder__Group_3_4__1__Impl1599);
            rule__Stakeholder__PhoneAssignment_3_4_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getPhoneAssignment_3_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_4__1__Impl"


    // $ANTLR start "rule__ReferencePath__Group__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:843:1: rule__ReferencePath__Group__0 : rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 ;
    public final void rule__ReferencePath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:847:1: ( rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:848:2: rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__01633);
            rule__ReferencePath__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__01636);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:855:1: rule__ReferencePath__Group__0__Impl : ( ( rule__ReferencePath__RefAssignment_0 ) ) ;
    public final void rule__ReferencePath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:859:1: ( ( ( rule__ReferencePath__RefAssignment_0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:860:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:860:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:861:1: ( rule__ReferencePath__RefAssignment_0 )
            {
             before(grammarAccess.getReferencePathAccess().getRefAssignment_0()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:862:1: ( rule__ReferencePath__RefAssignment_0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:862:2: rule__ReferencePath__RefAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl1663);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:872:1: rule__ReferencePath__Group__1 : rule__ReferencePath__Group__1__Impl ;
    public final void rule__ReferencePath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:876:1: ( rule__ReferencePath__Group__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:877:2: rule__ReferencePath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__11693);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:883:1: rule__ReferencePath__Group__1__Impl : ( ( rule__ReferencePath__Group_1__0 ) ) ;
    public final void rule__ReferencePath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:887:1: ( ( ( rule__ReferencePath__Group_1__0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:888:1: ( ( rule__ReferencePath__Group_1__0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:888:1: ( ( rule__ReferencePath__Group_1__0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:889:1: ( rule__ReferencePath__Group_1__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:890:1: ( rule__ReferencePath__Group_1__0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:890:2: rule__ReferencePath__Group_1__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl1720);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:904:1: rule__ReferencePath__Group_1__0 : rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 ;
    public final void rule__ReferencePath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:908:1: ( rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:909:2: rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__01754);
            rule__ReferencePath__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__01757);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:916:1: rule__ReferencePath__Group_1__0__Impl : ( '.' ) ;
    public final void rule__ReferencePath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:920:1: ( ( '.' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:921:1: ( '.' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:921:1: ( '.' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:922:1: '.'
            {
             before(grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__ReferencePath__Group_1__0__Impl1785); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:935:1: rule__ReferencePath__Group_1__1 : rule__ReferencePath__Group_1__1__Impl ;
    public final void rule__ReferencePath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:939:1: ( rule__ReferencePath__Group_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:940:2: rule__ReferencePath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__11816);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:946:1: rule__ReferencePath__Group_1__1__Impl : ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) ;
    public final void rule__ReferencePath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:950:1: ( ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:951:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:951:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:952:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            {
             before(grammarAccess.getReferencePathAccess().getSubpathAssignment_1_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:953:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:953:2: rule__ReferencePath__SubpathAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl1843);
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


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:974:1: rule__Stakeholder__UnorderedGroup_3 : ( rule__Stakeholder__UnorderedGroup_3__0 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:979:1: ( ( rule__Stakeholder__UnorderedGroup_3__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:980:2: ( rule__Stakeholder__UnorderedGroup_3__0 )?
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:980:2: ( rule__Stakeholder__UnorderedGroup_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( LA4_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt4=1;
            }
            else if ( LA4_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt4=1;
            }
            else if ( LA4_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt4=1;
            }
            else if ( LA4_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt4=1;
            }
            else if ( LA4_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:980:2: rule__Stakeholder__UnorderedGroup_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__0_in_rule__Stakeholder__UnorderedGroup_31884);
                    rule__Stakeholder__UnorderedGroup_3__0();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:990:1: rule__Stakeholder__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) ) ) ;
    public final void rule__Stakeholder__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:995:1: ( ( ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:996:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:996:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) ) )
            int alt5=5;
            int LA5_0 = input.LA(1);

            if ( LA5_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt5=1;
            }
            else if ( LA5_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt5=2;
            }
            else if ( LA5_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt5=3;
            }
            else if ( LA5_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt5=4;
            }
            else if ( LA5_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt5=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:998:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:998:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:999:5: {...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:999:108: ( ( ( rule__Stakeholder__Group_3_0__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1000:6: ( ( rule__Stakeholder__Group_3_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1006:6: ( ( rule__Stakeholder__Group_3_0__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1008:7: ( rule__Stakeholder__Group_3_0__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1009:7: ( rule__Stakeholder__Group_3_0__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1009:8: rule__Stakeholder__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1971);
                    rule__Stakeholder__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_3_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1015:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1015:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1016:5: {...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1016:108: ( ( ( rule__Stakeholder__Group_3_1__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1017:6: ( ( rule__Stakeholder__Group_3_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1023:6: ( ( rule__Stakeholder__Group_3_1__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1025:7: ( rule__Stakeholder__Group_3_1__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1026:7: ( rule__Stakeholder__Group_3_1__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1026:8: rule__Stakeholder__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_1__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2062);
                    rule__Stakeholder__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_3_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1032:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1032:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1033:5: {...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1033:108: ( ( ( rule__Stakeholder__Group_3_2__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1034:6: ( ( rule__Stakeholder__Group_3_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1040:6: ( ( rule__Stakeholder__Group_3_2__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1042:7: ( rule__Stakeholder__Group_3_2__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_2()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1043:7: ( rule__Stakeholder__Group_3_2__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1043:8: rule__Stakeholder__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_2__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2153);
                    rule__Stakeholder__Group_3_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_3_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1049:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1049:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1050:5: {...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1050:108: ( ( ( rule__Stakeholder__Group_3_3__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1051:6: ( ( rule__Stakeholder__Group_3_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1057:6: ( ( rule__Stakeholder__Group_3_3__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1059:7: ( rule__Stakeholder__Group_3_3__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_3()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1060:7: ( rule__Stakeholder__Group_3_3__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1060:8: rule__Stakeholder__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_3__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2244);
                    rule__Stakeholder__Group_3_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_3_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1066:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1066:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1067:5: {...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1067:108: ( ( ( rule__Stakeholder__Group_3_4__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1068:6: ( ( rule__Stakeholder__Group_3_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1074:6: ( ( rule__Stakeholder__Group_3_4__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1076:7: ( rule__Stakeholder__Group_3_4__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_4()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1077:7: ( rule__Stakeholder__Group_3_4__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1077:8: rule__Stakeholder__Group_3_4__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_4__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2335);
                    rule__Stakeholder__Group_3_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_3_4()); 

                    }


                    }


                    }


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	if (selected)
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3__Impl"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1092:1: rule__Stakeholder__UnorderedGroup_3__0 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__1 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1096:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__1 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1097:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__02394);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1098:2: ( rule__Stakeholder__UnorderedGroup_3__1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( LA6_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt6=1;
            }
            else if ( LA6_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt6=1;
            }
            else if ( LA6_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt6=1;
            }
            else if ( LA6_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt6=1;
            }
            else if ( LA6_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1098:2: rule__Stakeholder__UnorderedGroup_3__1
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__1_in_rule__Stakeholder__UnorderedGroup_3__02397);
                    rule__Stakeholder__UnorderedGroup_3__1();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3__0"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1105:1: rule__Stakeholder__UnorderedGroup_3__1 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__2 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1109:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__2 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1110:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__2 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__12422);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1111:2: ( rule__Stakeholder__UnorderedGroup_3__2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt7=1;
            }
            else if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt7=1;
            }
            else if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt7=1;
            }
            else if ( LA7_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1111:2: rule__Stakeholder__UnorderedGroup_3__2
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__2_in_rule__Stakeholder__UnorderedGroup_3__12425);
                    rule__Stakeholder__UnorderedGroup_3__2();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3__1"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1118:1: rule__Stakeholder__UnorderedGroup_3__2 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__3 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1122:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__3 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1123:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__3 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__22450);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1124:2: ( rule__Stakeholder__UnorderedGroup_3__3 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt8=1;
            }
            else if ( LA8_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1124:2: rule__Stakeholder__UnorderedGroup_3__3
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__3_in_rule__Stakeholder__UnorderedGroup_3__22453);
                    rule__Stakeholder__UnorderedGroup_3__3();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3__2"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3__3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1131:1: rule__Stakeholder__UnorderedGroup_3__3 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__4 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1135:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__4 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1136:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__4 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__32478);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1137:2: ( rule__Stakeholder__UnorderedGroup_3__4 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( LA9_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt9=1;
            }
            else if ( LA9_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt9=1;
            }
            else if ( LA9_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt9=1;
            }
            else if ( LA9_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1137:2: rule__Stakeholder__UnorderedGroup_3__4
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__4_in_rule__Stakeholder__UnorderedGroup_3__32481);
                    rule__Stakeholder__UnorderedGroup_3__4();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3__3"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3__4"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1144:1: rule__Stakeholder__UnorderedGroup_3__4 : rule__Stakeholder__UnorderedGroup_3__Impl ;
    public final void rule__Stakeholder__UnorderedGroup_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1148:1: ( rule__Stakeholder__UnorderedGroup_3__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1149:2: rule__Stakeholder__UnorderedGroup_3__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__42506);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3__4"


    // $ANTLR start "rule__Organization__NameAssignment_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1166:1: rule__Organization__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Organization__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1170:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1171:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1171:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1172:1: RULE_ID
            {
             before(grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12544); 
             after(grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Organization__NameAssignment_1"


    // $ANTLR start "rule__Organization__StakeholderAssignment_2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1181:1: rule__Organization__StakeholderAssignment_2 : ( ruleStakeholder ) ;
    public final void rule__Organization__StakeholderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1185:1: ( ( ruleStakeholder ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1186:1: ( ruleStakeholder )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1186:1: ( ruleStakeholder )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1187:1: ruleStakeholder
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22575);
            ruleStakeholder();

            state._fsp--;

             after(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Organization__StakeholderAssignment_2"


    // $ANTLR start "rule__Stakeholder__NameAssignment_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1196:1: rule__Stakeholder__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stakeholder__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1200:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1201:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1201:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1202:1: RULE_ID
            {
             before(grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12606); 
             after(grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__NameAssignment_1"


    // $ANTLR start "rule__Stakeholder__TitleAssignment_3_0_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1211:1: rule__Stakeholder__TitleAssignment_3_0_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__TitleAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1215:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1216:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1216:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1217:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getTitleValueStringParserRuleCall_3_0_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__TitleAssignment_3_0_12637);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getTitleValueStringParserRuleCall_3_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__TitleAssignment_3_0_1"


    // $ANTLR start "rule__Stakeholder__DescriptionAssignment_3_1_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1226:1: rule__Stakeholder__DescriptionAssignment_3_1_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__DescriptionAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1230:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1231:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1231:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1232:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionValueStringParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__DescriptionAssignment_3_1_12668);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getDescriptionValueStringParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__DescriptionAssignment_3_1_1"


    // $ANTLR start "rule__Stakeholder__RoleAssignment_3_2_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1241:1: rule__Stakeholder__RoleAssignment_3_2_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__RoleAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1245:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1246:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1246:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1247:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getRoleValueStringParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__RoleAssignment_3_2_12699);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getRoleValueStringParserRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__RoleAssignment_3_2_1"


    // $ANTLR start "rule__Stakeholder__EmailAssignment_3_3_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1256:1: rule__Stakeholder__EmailAssignment_3_3_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__EmailAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1260:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1261:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1261:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1262:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getEmailValueStringParserRuleCall_3_3_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__EmailAssignment_3_3_12730);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getEmailValueStringParserRuleCall_3_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__EmailAssignment_3_3_1"


    // $ANTLR start "rule__Stakeholder__PhoneAssignment_3_4_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1271:1: rule__Stakeholder__PhoneAssignment_3_4_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__PhoneAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1275:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1276:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1276:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1277:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getPhoneValueStringParserRuleCall_3_4_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__PhoneAssignment_3_4_12761);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getPhoneValueStringParserRuleCall_3_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__PhoneAssignment_3_4_1"


    // $ANTLR start "rule__Description__DescriptionAssignment"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1287:1: rule__Description__DescriptionAssignment : ( ruleDescriptionElement ) ;
    public final void rule__Description__DescriptionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1291:1: ( ( ruleDescriptionElement ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1292:1: ( ruleDescriptionElement )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1292:1: ( ruleDescriptionElement )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1293:1: ruleDescriptionElement
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment2793);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1302:1: rule__DescriptionElement__TextAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DescriptionElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1306:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1307:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1307:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1308:1: RULE_STRING
            {
             before(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_02824); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1317:1: rule__DescriptionElement__RefAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DescriptionElement__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1321:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1322:1: ( ( RULE_ID ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1322:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1323:1: ( RULE_ID )
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1324:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1325:1: RULE_ID
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_12859); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1336:1: rule__ReferencePath__RefAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferencePath__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1340:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1341:1: ( ( RULE_ID ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1341:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1342:1: ( RULE_ID )
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1343:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1344:1: RULE_ID
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_02898); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1355:1: rule__ReferencePath__SubpathAssignment_1_1 : ( ruleReferencePath ) ;
    public final void rule__ReferencePath__SubpathAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1359:1: ( ( ruleReferencePath ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1360:1: ( ruleReferencePath )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1360:1: ( ruleReferencePath )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1361:1: ruleReferencePath
            {
             before(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_12933);
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


 

    public static final BitSet FOLLOW_ruleOrganization_in_entryRuleOrganization61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrganization68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__0_in_ruleOrganization94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_entryRuleStakeholder121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholder128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__0_in_ruleStakeholder154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription218 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_rule__Description__DescriptionAssignment_in_ruleDescription230 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement260 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__Alternatives_in_ruleDescriptionElement293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0_in_ruleReferencePath353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__0__Impl_in_rule__Organization__Group__0503 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Organization__Group__1_in_rule__Organization__Group__0506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Organization__Group__0__Impl534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__1__Impl_in_rule__Organization__Group__1565 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Organization__Group__2_in_rule__Organization__Group__1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__NameAssignment_1_in_rule__Organization__Group__1__Impl595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__2__Impl_in_rule__Organization__Group__2625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl654 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl666 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__0__Impl_in_rule__Stakeholder__Group__0705 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__1_in_rule__Stakeholder__Group__0708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Stakeholder__Group__0__Impl736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__1__Impl_in_rule__Stakeholder__Group__1767 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__2_in_rule__Stakeholder__Group__1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__NameAssignment_1_in_rule__Stakeholder__Group__1__Impl797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__2__Impl_in_rule__Stakeholder__Group__2827 = new BitSet(new long[]{0x00000000000F8000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__3_in_rule__Stakeholder__Group__2830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Stakeholder__Group__2__Impl858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__3__Impl_in_rule__Stakeholder__Group__3889 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__4_in_rule__Stakeholder__Group__3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3_in_rule__Stakeholder__Group__3__Impl919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__4__Impl_in_rule__Stakeholder__Group__4949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Stakeholder__Group__4__Impl977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__0__Impl_in_rule__Stakeholder__Group_3_0__01018 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__1_in_rule__Stakeholder__Group_3_0__01021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Stakeholder__Group_3_0__0__Impl1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__1__Impl_in_rule__Stakeholder__Group_3_0__11080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__TitleAssignment_3_0_1_in_rule__Stakeholder__Group_3_0__1__Impl1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_1__0__Impl_in_rule__Stakeholder__Group_3_1__01141 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_1__1_in_rule__Stakeholder__Group_3_1__01144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Stakeholder__Group_3_1__0__Impl1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_1__1__Impl_in_rule__Stakeholder__Group_3_1__11203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__DescriptionAssignment_3_1_1_in_rule__Stakeholder__Group_3_1__1__Impl1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_2__0__Impl_in_rule__Stakeholder__Group_3_2__01264 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_2__1_in_rule__Stakeholder__Group_3_2__01267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Stakeholder__Group_3_2__0__Impl1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_2__1__Impl_in_rule__Stakeholder__Group_3_2__11326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__RoleAssignment_3_2_1_in_rule__Stakeholder__Group_3_2__1__Impl1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_3__0__Impl_in_rule__Stakeholder__Group_3_3__01387 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_3__1_in_rule__Stakeholder__Group_3_3__01390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Stakeholder__Group_3_3__0__Impl1418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_3__1__Impl_in_rule__Stakeholder__Group_3_3__11449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__EmailAssignment_3_3_1_in_rule__Stakeholder__Group_3_3__1__Impl1476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_4__0__Impl_in_rule__Stakeholder__Group_3_4__01510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_4__1_in_rule__Stakeholder__Group_3_4__01513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Stakeholder__Group_3_4__0__Impl1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_4__1__Impl_in_rule__Stakeholder__Group_3_4__11572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__PhoneAssignment_3_4_1_in_rule__Stakeholder__Group_3_4__1__Impl1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__01633 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__01636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl1663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__11693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__01754 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__01757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ReferencePath__Group_1__0__Impl1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__11816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__0_in_rule__Stakeholder__UnorderedGroup_31884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_1__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_2__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_3__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_4__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__02394 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__1_in_rule__Stakeholder__UnorderedGroup_3__02397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__12422 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__2_in_rule__Stakeholder__UnorderedGroup_3__12425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__22450 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__3_in_rule__Stakeholder__UnorderedGroup_3__22453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__32478 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__4_in_rule__Stakeholder__UnorderedGroup_3__32481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__42506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__TitleAssignment_3_0_12637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__DescriptionAssignment_3_1_12668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__RoleAssignment_3_2_12699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__EmailAssignment_3_3_12730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__PhoneAssignment_3_4_12761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_02824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_12859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_02898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_12933 = new BitSet(new long[]{0x0000000000000002L});

}
