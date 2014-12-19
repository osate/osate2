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


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:237:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:238:1: ( ruleQualifiedName EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:239:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName439);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName446); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:246:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:250:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:251:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:251:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:252:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:253:1: ( rule__QualifiedName__Group__0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:253:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName472);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "rule__DescriptionElement__Alternatives"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:271:1: rule__DescriptionElement__Alternatives : ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) );
    public final void rule__DescriptionElement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:275:1: ( ( ( rule__DescriptionElement__TextAssignment_0 ) ) | ( ( rule__DescriptionElement__RefAssignment_1 ) ) )
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:276:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:276:1: ( ( rule__DescriptionElement__TextAssignment_0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:277:1: ( rule__DescriptionElement__TextAssignment_0 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:278:1: ( rule__DescriptionElement__TextAssignment_0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:278:2: rule__DescriptionElement__TextAssignment_0
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives514);
                    rule__DescriptionElement__TextAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getDescriptionElementAccess().getTextAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:282:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:282:6: ( ( rule__DescriptionElement__RefAssignment_1 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:283:1: ( rule__DescriptionElement__RefAssignment_1 )
                    {
                     before(grammarAccess.getDescriptionElementAccess().getRefAssignment_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:284:1: ( rule__DescriptionElement__RefAssignment_1 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:284:2: rule__DescriptionElement__RefAssignment_1
                    {
                    pushFollow(FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives532);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:295:1: rule__Organization__Group__0 : rule__Organization__Group__0__Impl rule__Organization__Group__1 ;
    public final void rule__Organization__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:299:1: ( rule__Organization__Group__0__Impl rule__Organization__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:300:2: rule__Organization__Group__0__Impl rule__Organization__Group__1
            {
            pushFollow(FOLLOW_rule__Organization__Group__0__Impl_in_rule__Organization__Group__0563);
            rule__Organization__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Organization__Group__1_in_rule__Organization__Group__0566);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:307:1: rule__Organization__Group__0__Impl : ( 'organization' ) ;
    public final void rule__Organization__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:311:1: ( ( 'organization' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:312:1: ( 'organization' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:312:1: ( 'organization' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:313:1: 'organization'
            {
             before(grammarAccess.getOrganizationAccess().getOrganizationKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Organization__Group__0__Impl594); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:326:1: rule__Organization__Group__1 : rule__Organization__Group__1__Impl rule__Organization__Group__2 ;
    public final void rule__Organization__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:330:1: ( rule__Organization__Group__1__Impl rule__Organization__Group__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:331:2: rule__Organization__Group__1__Impl rule__Organization__Group__2
            {
            pushFollow(FOLLOW_rule__Organization__Group__1__Impl_in_rule__Organization__Group__1625);
            rule__Organization__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Organization__Group__2_in_rule__Organization__Group__1628);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:338:1: rule__Organization__Group__1__Impl : ( ( rule__Organization__NameAssignment_1 ) ) ;
    public final void rule__Organization__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:342:1: ( ( ( rule__Organization__NameAssignment_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:343:1: ( ( rule__Organization__NameAssignment_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:343:1: ( ( rule__Organization__NameAssignment_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:344:1: ( rule__Organization__NameAssignment_1 )
            {
             before(grammarAccess.getOrganizationAccess().getNameAssignment_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:345:1: ( rule__Organization__NameAssignment_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:345:2: rule__Organization__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Organization__NameAssignment_1_in_rule__Organization__Group__1__Impl655);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:355:1: rule__Organization__Group__2 : rule__Organization__Group__2__Impl ;
    public final void rule__Organization__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:359:1: ( rule__Organization__Group__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:360:2: rule__Organization__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Organization__Group__2__Impl_in_rule__Organization__Group__2685);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:366:1: rule__Organization__Group__2__Impl : ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) ) ;
    public final void rule__Organization__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:370:1: ( ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:371:1: ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:371:1: ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:372:1: ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:372:1: ( ( rule__Organization__StakeholderAssignment_2 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:373:1: ( rule__Organization__StakeholderAssignment_2 )
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:374:1: ( rule__Organization__StakeholderAssignment_2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:374:2: rule__Organization__StakeholderAssignment_2
            {
            pushFollow(FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl714);
            rule__Organization__StakeholderAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 

            }

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:377:1: ( ( rule__Organization__StakeholderAssignment_2 )* )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:378:1: ( rule__Organization__StakeholderAssignment_2 )*
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:379:1: ( rule__Organization__StakeholderAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:379:2: rule__Organization__StakeholderAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl726);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:396:1: rule__Stakeholder__Group__0 : rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1 ;
    public final void rule__Stakeholder__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:400:1: ( rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:401:2: rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__0__Impl_in_rule__Stakeholder__Group__0765);
            rule__Stakeholder__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__1_in_rule__Stakeholder__Group__0768);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:408:1: rule__Stakeholder__Group__0__Impl : ( 'stakeholder' ) ;
    public final void rule__Stakeholder__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:412:1: ( ( 'stakeholder' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:413:1: ( 'stakeholder' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:413:1: ( 'stakeholder' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:414:1: 'stakeholder'
            {
             before(grammarAccess.getStakeholderAccess().getStakeholderKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__Stakeholder__Group__0__Impl796); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:427:1: rule__Stakeholder__Group__1 : rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2 ;
    public final void rule__Stakeholder__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:431:1: ( rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:432:2: rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__1__Impl_in_rule__Stakeholder__Group__1827);
            rule__Stakeholder__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__2_in_rule__Stakeholder__Group__1830);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:439:1: rule__Stakeholder__Group__1__Impl : ( ( rule__Stakeholder__NameAssignment_1 ) ) ;
    public final void rule__Stakeholder__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:443:1: ( ( ( rule__Stakeholder__NameAssignment_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:444:1: ( ( rule__Stakeholder__NameAssignment_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:444:1: ( ( rule__Stakeholder__NameAssignment_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:445:1: ( rule__Stakeholder__NameAssignment_1 )
            {
             before(grammarAccess.getStakeholderAccess().getNameAssignment_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:446:1: ( rule__Stakeholder__NameAssignment_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:446:2: rule__Stakeholder__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__NameAssignment_1_in_rule__Stakeholder__Group__1__Impl857);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:456:1: rule__Stakeholder__Group__2 : rule__Stakeholder__Group__2__Impl ;
    public final void rule__Stakeholder__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:460:1: ( rule__Stakeholder__Group__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:461:2: rule__Stakeholder__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__2__Impl_in_rule__Stakeholder__Group__2887);
            rule__Stakeholder__Group__2__Impl();

            state._fsp--;


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:467:1: rule__Stakeholder__Group__2__Impl : ( ( rule__Stakeholder__Group_2__0 )? ) ;
    public final void rule__Stakeholder__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:471:1: ( ( ( rule__Stakeholder__Group_2__0 )? ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:472:1: ( ( rule__Stakeholder__Group_2__0 )? )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:472:1: ( ( rule__Stakeholder__Group_2__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:473:1: ( rule__Stakeholder__Group_2__0 )?
            {
             before(grammarAccess.getStakeholderAccess().getGroup_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:474:1: ( rule__Stakeholder__Group_2__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:474:2: rule__Stakeholder__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2__0_in_rule__Stakeholder__Group__2__Impl914);
                    rule__Stakeholder__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStakeholderAccess().getGroup_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Stakeholder__Group_2__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:490:1: rule__Stakeholder__Group_2__0 : rule__Stakeholder__Group_2__0__Impl rule__Stakeholder__Group_2__1 ;
    public final void rule__Stakeholder__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:494:1: ( rule__Stakeholder__Group_2__0__Impl rule__Stakeholder__Group_2__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:495:2: rule__Stakeholder__Group_2__0__Impl rule__Stakeholder__Group_2__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2__0__Impl_in_rule__Stakeholder__Group_2__0951);
            rule__Stakeholder__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2__1_in_rule__Stakeholder__Group_2__0954);
            rule__Stakeholder__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2__0"


    // $ANTLR start "rule__Stakeholder__Group_2__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:502:1: rule__Stakeholder__Group_2__0__Impl : ( '[' ) ;
    public final void rule__Stakeholder__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:506:1: ( ( '[' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:507:1: ( '[' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:507:1: ( '[' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:508:1: '['
            {
             before(grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,13,FOLLOW_13_in_rule__Stakeholder__Group_2__0__Impl982); 
             after(grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:521:1: rule__Stakeholder__Group_2__1 : rule__Stakeholder__Group_2__1__Impl rule__Stakeholder__Group_2__2 ;
    public final void rule__Stakeholder__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:525:1: ( rule__Stakeholder__Group_2__1__Impl rule__Stakeholder__Group_2__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:526:2: rule__Stakeholder__Group_2__1__Impl rule__Stakeholder__Group_2__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2__1__Impl_in_rule__Stakeholder__Group_2__11013);
            rule__Stakeholder__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2__2_in_rule__Stakeholder__Group_2__11016);
            rule__Stakeholder__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2__1"


    // $ANTLR start "rule__Stakeholder__Group_2__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:533:1: rule__Stakeholder__Group_2__1__Impl : ( ( rule__Stakeholder__UnorderedGroup_2_1 ) ) ;
    public final void rule__Stakeholder__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:537:1: ( ( ( rule__Stakeholder__UnorderedGroup_2_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:538:1: ( ( rule__Stakeholder__UnorderedGroup_2_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:538:1: ( ( rule__Stakeholder__UnorderedGroup_2_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:539:1: ( rule__Stakeholder__UnorderedGroup_2_1 )
            {
             before(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:540:1: ( rule__Stakeholder__UnorderedGroup_2_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:540:2: rule__Stakeholder__UnorderedGroup_2_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1_in_rule__Stakeholder__Group_2__1__Impl1043);
            rule__Stakeholder__UnorderedGroup_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:550:1: rule__Stakeholder__Group_2__2 : rule__Stakeholder__Group_2__2__Impl ;
    public final void rule__Stakeholder__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:554:1: ( rule__Stakeholder__Group_2__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:555:2: rule__Stakeholder__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2__2__Impl_in_rule__Stakeholder__Group_2__21073);
            rule__Stakeholder__Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2__2"


    // $ANTLR start "rule__Stakeholder__Group_2__2__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:561:1: rule__Stakeholder__Group_2__2__Impl : ( ']' ) ;
    public final void rule__Stakeholder__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:565:1: ( ( ']' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:566:1: ( ']' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:566:1: ( ']' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:567:1: ']'
            {
             before(grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_2_2()); 
            match(input,14,FOLLOW_14_in_rule__Stakeholder__Group_2__2__Impl1101); 
             after(grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2__2__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_0__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:586:1: rule__Stakeholder__Group_2_1_0__0 : rule__Stakeholder__Group_2_1_0__0__Impl rule__Stakeholder__Group_2_1_0__1 ;
    public final void rule__Stakeholder__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:590:1: ( rule__Stakeholder__Group_2_1_0__0__Impl rule__Stakeholder__Group_2_1_0__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:591:2: rule__Stakeholder__Group_2_1_0__0__Impl rule__Stakeholder__Group_2_1_0__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__0__Impl_in_rule__Stakeholder__Group_2_1_0__01138);
            rule__Stakeholder__Group_2_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__1_in_rule__Stakeholder__Group_2_1_0__01141);
            rule__Stakeholder__Group_2_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_0__0"


    // $ANTLR start "rule__Stakeholder__Group_2_1_0__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:598:1: rule__Stakeholder__Group_2_1_0__0__Impl : ( 'title' ) ;
    public final void rule__Stakeholder__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:602:1: ( ( 'title' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:603:1: ( 'title' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:603:1: ( 'title' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:604:1: 'title'
            {
             before(grammarAccess.getStakeholderAccess().getTitleKeyword_2_1_0_0()); 
            match(input,15,FOLLOW_15_in_rule__Stakeholder__Group_2_1_0__0__Impl1169); 
             after(grammarAccess.getStakeholderAccess().getTitleKeyword_2_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_0__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_0__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:617:1: rule__Stakeholder__Group_2_1_0__1 : rule__Stakeholder__Group_2_1_0__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:621:1: ( rule__Stakeholder__Group_2_1_0__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:622:2: rule__Stakeholder__Group_2_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__1__Impl_in_rule__Stakeholder__Group_2_1_0__11200);
            rule__Stakeholder__Group_2_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_0__1"


    // $ANTLR start "rule__Stakeholder__Group_2_1_0__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:628:1: rule__Stakeholder__Group_2_1_0__1__Impl : ( ( rule__Stakeholder__TitleAssignment_2_1_0_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:632:1: ( ( ( rule__Stakeholder__TitleAssignment_2_1_0_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:633:1: ( ( rule__Stakeholder__TitleAssignment_2_1_0_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:633:1: ( ( rule__Stakeholder__TitleAssignment_2_1_0_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:634:1: ( rule__Stakeholder__TitleAssignment_2_1_0_1 )
            {
             before(grammarAccess.getStakeholderAccess().getTitleAssignment_2_1_0_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:635:1: ( rule__Stakeholder__TitleAssignment_2_1_0_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:635:2: rule__Stakeholder__TitleAssignment_2_1_0_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__TitleAssignment_2_1_0_1_in_rule__Stakeholder__Group_2_1_0__1__Impl1227);
            rule__Stakeholder__TitleAssignment_2_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getTitleAssignment_2_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_0__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:649:1: rule__Stakeholder__Group_2_1_1__0 : rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1 ;
    public final void rule__Stakeholder__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:653:1: ( rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:654:2: rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__0__Impl_in_rule__Stakeholder__Group_2_1_1__01261);
            rule__Stakeholder__Group_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__1_in_rule__Stakeholder__Group_2_1_1__01264);
            rule__Stakeholder__Group_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_1__0"


    // $ANTLR start "rule__Stakeholder__Group_2_1_1__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:661:1: rule__Stakeholder__Group_2_1_1__0__Impl : ( 'description' ) ;
    public final void rule__Stakeholder__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:665:1: ( ( 'description' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:666:1: ( 'description' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:666:1: ( 'description' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:667:1: 'description'
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionKeyword_2_1_1_0()); 
            match(input,16,FOLLOW_16_in_rule__Stakeholder__Group_2_1_1__0__Impl1292); 
             after(grammarAccess.getStakeholderAccess().getDescriptionKeyword_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_1__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_1__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:680:1: rule__Stakeholder__Group_2_1_1__1 : rule__Stakeholder__Group_2_1_1__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:684:1: ( rule__Stakeholder__Group_2_1_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:685:2: rule__Stakeholder__Group_2_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__1__Impl_in_rule__Stakeholder__Group_2_1_1__11323);
            rule__Stakeholder__Group_2_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_1__1"


    // $ANTLR start "rule__Stakeholder__Group_2_1_1__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:691:1: rule__Stakeholder__Group_2_1_1__1__Impl : ( ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:695:1: ( ( ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:696:1: ( ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:696:1: ( ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:697:1: ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 )
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionAssignment_2_1_1_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:698:1: ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:698:2: rule__Stakeholder__DescriptionAssignment_2_1_1_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__DescriptionAssignment_2_1_1_1_in_rule__Stakeholder__Group_2_1_1__1__Impl1350);
            rule__Stakeholder__DescriptionAssignment_2_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getDescriptionAssignment_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_1__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_2__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:712:1: rule__Stakeholder__Group_2_1_2__0 : rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1 ;
    public final void rule__Stakeholder__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:716:1: ( rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:717:2: rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__0__Impl_in_rule__Stakeholder__Group_2_1_2__01384);
            rule__Stakeholder__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__1_in_rule__Stakeholder__Group_2_1_2__01387);
            rule__Stakeholder__Group_2_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_2__0"


    // $ANTLR start "rule__Stakeholder__Group_2_1_2__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:724:1: rule__Stakeholder__Group_2_1_2__0__Impl : ( 'role' ) ;
    public final void rule__Stakeholder__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:728:1: ( ( 'role' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:729:1: ( 'role' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:729:1: ( 'role' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:730:1: 'role'
            {
             before(grammarAccess.getStakeholderAccess().getRoleKeyword_2_1_2_0()); 
            match(input,17,FOLLOW_17_in_rule__Stakeholder__Group_2_1_2__0__Impl1415); 
             after(grammarAccess.getStakeholderAccess().getRoleKeyword_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_2__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_2__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:743:1: rule__Stakeholder__Group_2_1_2__1 : rule__Stakeholder__Group_2_1_2__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:747:1: ( rule__Stakeholder__Group_2_1_2__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:748:2: rule__Stakeholder__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__1__Impl_in_rule__Stakeholder__Group_2_1_2__11446);
            rule__Stakeholder__Group_2_1_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_2__1"


    // $ANTLR start "rule__Stakeholder__Group_2_1_2__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:754:1: rule__Stakeholder__Group_2_1_2__1__Impl : ( ( rule__Stakeholder__RoleAssignment_2_1_2_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:758:1: ( ( ( rule__Stakeholder__RoleAssignment_2_1_2_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:759:1: ( ( rule__Stakeholder__RoleAssignment_2_1_2_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:759:1: ( ( rule__Stakeholder__RoleAssignment_2_1_2_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:760:1: ( rule__Stakeholder__RoleAssignment_2_1_2_1 )
            {
             before(grammarAccess.getStakeholderAccess().getRoleAssignment_2_1_2_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:761:1: ( rule__Stakeholder__RoleAssignment_2_1_2_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:761:2: rule__Stakeholder__RoleAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__RoleAssignment_2_1_2_1_in_rule__Stakeholder__Group_2_1_2__1__Impl1473);
            rule__Stakeholder__RoleAssignment_2_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getRoleAssignment_2_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_2__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_3__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:775:1: rule__Stakeholder__Group_2_1_3__0 : rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1 ;
    public final void rule__Stakeholder__Group_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:779:1: ( rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:780:2: rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__0__Impl_in_rule__Stakeholder__Group_2_1_3__01507);
            rule__Stakeholder__Group_2_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__1_in_rule__Stakeholder__Group_2_1_3__01510);
            rule__Stakeholder__Group_2_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_3__0"


    // $ANTLR start "rule__Stakeholder__Group_2_1_3__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:787:1: rule__Stakeholder__Group_2_1_3__0__Impl : ( 'email' ) ;
    public final void rule__Stakeholder__Group_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:791:1: ( ( 'email' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:792:1: ( 'email' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:792:1: ( 'email' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:793:1: 'email'
            {
             before(grammarAccess.getStakeholderAccess().getEmailKeyword_2_1_3_0()); 
            match(input,18,FOLLOW_18_in_rule__Stakeholder__Group_2_1_3__0__Impl1538); 
             after(grammarAccess.getStakeholderAccess().getEmailKeyword_2_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_3__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_3__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:806:1: rule__Stakeholder__Group_2_1_3__1 : rule__Stakeholder__Group_2_1_3__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:810:1: ( rule__Stakeholder__Group_2_1_3__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:811:2: rule__Stakeholder__Group_2_1_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__1__Impl_in_rule__Stakeholder__Group_2_1_3__11569);
            rule__Stakeholder__Group_2_1_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_3__1"


    // $ANTLR start "rule__Stakeholder__Group_2_1_3__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:817:1: rule__Stakeholder__Group_2_1_3__1__Impl : ( ( rule__Stakeholder__EmailAssignment_2_1_3_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:821:1: ( ( ( rule__Stakeholder__EmailAssignment_2_1_3_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:822:1: ( ( rule__Stakeholder__EmailAssignment_2_1_3_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:822:1: ( ( rule__Stakeholder__EmailAssignment_2_1_3_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:823:1: ( rule__Stakeholder__EmailAssignment_2_1_3_1 )
            {
             before(grammarAccess.getStakeholderAccess().getEmailAssignment_2_1_3_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:824:1: ( rule__Stakeholder__EmailAssignment_2_1_3_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:824:2: rule__Stakeholder__EmailAssignment_2_1_3_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__EmailAssignment_2_1_3_1_in_rule__Stakeholder__Group_2_1_3__1__Impl1596);
            rule__Stakeholder__EmailAssignment_2_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getEmailAssignment_2_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_3__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_4__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:838:1: rule__Stakeholder__Group_2_1_4__0 : rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1 ;
    public final void rule__Stakeholder__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:842:1: ( rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:843:2: rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__0__Impl_in_rule__Stakeholder__Group_2_1_4__01630);
            rule__Stakeholder__Group_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__1_in_rule__Stakeholder__Group_2_1_4__01633);
            rule__Stakeholder__Group_2_1_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_4__0"


    // $ANTLR start "rule__Stakeholder__Group_2_1_4__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:850:1: rule__Stakeholder__Group_2_1_4__0__Impl : ( 'phone' ) ;
    public final void rule__Stakeholder__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:854:1: ( ( 'phone' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:855:1: ( 'phone' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:855:1: ( 'phone' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:856:1: 'phone'
            {
             before(grammarAccess.getStakeholderAccess().getPhoneKeyword_2_1_4_0()); 
            match(input,19,FOLLOW_19_in_rule__Stakeholder__Group_2_1_4__0__Impl1661); 
             after(grammarAccess.getStakeholderAccess().getPhoneKeyword_2_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_4__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_4__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:869:1: rule__Stakeholder__Group_2_1_4__1 : rule__Stakeholder__Group_2_1_4__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:873:1: ( rule__Stakeholder__Group_2_1_4__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:874:2: rule__Stakeholder__Group_2_1_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__1__Impl_in_rule__Stakeholder__Group_2_1_4__11692);
            rule__Stakeholder__Group_2_1_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_4__1"


    // $ANTLR start "rule__Stakeholder__Group_2_1_4__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:880:1: rule__Stakeholder__Group_2_1_4__1__Impl : ( ( rule__Stakeholder__PhoneAssignment_2_1_4_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:884:1: ( ( ( rule__Stakeholder__PhoneAssignment_2_1_4_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:885:1: ( ( rule__Stakeholder__PhoneAssignment_2_1_4_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:885:1: ( ( rule__Stakeholder__PhoneAssignment_2_1_4_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:886:1: ( rule__Stakeholder__PhoneAssignment_2_1_4_1 )
            {
             before(grammarAccess.getStakeholderAccess().getPhoneAssignment_2_1_4_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:887:1: ( rule__Stakeholder__PhoneAssignment_2_1_4_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:887:2: rule__Stakeholder__PhoneAssignment_2_1_4_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__PhoneAssignment_2_1_4_1_in_rule__Stakeholder__Group_2_1_4__1__Impl1719);
            rule__Stakeholder__PhoneAssignment_2_1_4_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getPhoneAssignment_2_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_4__1__Impl"


    // $ANTLR start "rule__ReferencePath__Group__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:901:1: rule__ReferencePath__Group__0 : rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 ;
    public final void rule__ReferencePath__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:905:1: ( rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:906:2: rule__ReferencePath__Group__0__Impl rule__ReferencePath__Group__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__01753);
            rule__ReferencePath__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__01756);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:913:1: rule__ReferencePath__Group__0__Impl : ( ( rule__ReferencePath__RefAssignment_0 ) ) ;
    public final void rule__ReferencePath__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:917:1: ( ( ( rule__ReferencePath__RefAssignment_0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:918:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:918:1: ( ( rule__ReferencePath__RefAssignment_0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:919:1: ( rule__ReferencePath__RefAssignment_0 )
            {
             before(grammarAccess.getReferencePathAccess().getRefAssignment_0()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:920:1: ( rule__ReferencePath__RefAssignment_0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:920:2: rule__ReferencePath__RefAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl1783);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:930:1: rule__ReferencePath__Group__1 : rule__ReferencePath__Group__1__Impl ;
    public final void rule__ReferencePath__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:934:1: ( rule__ReferencePath__Group__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:935:2: rule__ReferencePath__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__11813);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:941:1: rule__ReferencePath__Group__1__Impl : ( ( rule__ReferencePath__Group_1__0 ) ) ;
    public final void rule__ReferencePath__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:945:1: ( ( ( rule__ReferencePath__Group_1__0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:946:1: ( ( rule__ReferencePath__Group_1__0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:946:1: ( ( rule__ReferencePath__Group_1__0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:947:1: ( rule__ReferencePath__Group_1__0 )
            {
             before(grammarAccess.getReferencePathAccess().getGroup_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:948:1: ( rule__ReferencePath__Group_1__0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:948:2: rule__ReferencePath__Group_1__0
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl1840);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:962:1: rule__ReferencePath__Group_1__0 : rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 ;
    public final void rule__ReferencePath__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:966:1: ( rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:967:2: rule__ReferencePath__Group_1__0__Impl rule__ReferencePath__Group_1__1
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__01874);
            rule__ReferencePath__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__01877);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:974:1: rule__ReferencePath__Group_1__0__Impl : ( '.' ) ;
    public final void rule__ReferencePath__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:978:1: ( ( '.' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:979:1: ( '.' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:979:1: ( '.' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:980:1: '.'
            {
             before(grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__ReferencePath__Group_1__0__Impl1905); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:993:1: rule__ReferencePath__Group_1__1 : rule__ReferencePath__Group_1__1__Impl ;
    public final void rule__ReferencePath__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:997:1: ( rule__ReferencePath__Group_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:998:2: rule__ReferencePath__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__11936);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1004:1: rule__ReferencePath__Group_1__1__Impl : ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) ;
    public final void rule__ReferencePath__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1008:1: ( ( ( rule__ReferencePath__SubpathAssignment_1_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1009:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1009:1: ( ( rule__ReferencePath__SubpathAssignment_1_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1010:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            {
             before(grammarAccess.getReferencePathAccess().getSubpathAssignment_1_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1011:1: ( rule__ReferencePath__SubpathAssignment_1_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1011:2: rule__ReferencePath__SubpathAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl1963);
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1025:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1029:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1030:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01997);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02000);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1037:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1041:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1042:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1042:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1043:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl2027); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1054:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1058:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1059:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12056);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1065:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1069:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1070:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1070:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1071:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1072:1: ( rule__QualifiedName__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1072:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2083);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1086:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1090:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1091:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02118);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02121);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1098:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1102:1: ( ( '.' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1103:1: ( '.' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1103:1: ( '.' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1104:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,20,FOLLOW_20_in_rule__QualifiedName__Group_1__0__Impl2149); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1117:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1121:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1122:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12180);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1128:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1132:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1133:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1133:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1134:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2207); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1154:1: rule__Stakeholder__UnorderedGroup_2_1 : ( rule__Stakeholder__UnorderedGroup_2_1__0 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1159:1: ( ( rule__Stakeholder__UnorderedGroup_2_1__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1160:2: ( rule__Stakeholder__UnorderedGroup_2_1__0 )?
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1160:2: ( rule__Stakeholder__UnorderedGroup_2_1__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( LA6_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt6=1;
            }
            else if ( LA6_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt6=1;
            }
            else if ( LA6_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt6=1;
            }
            else if ( LA6_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt6=1;
            }
            else if ( LA6_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1160:2: rule__Stakeholder__UnorderedGroup_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__0_in_rule__Stakeholder__UnorderedGroup_2_12245);
                    rule__Stakeholder__UnorderedGroup_2_1__0();

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

            	getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1170:1: rule__Stakeholder__UnorderedGroup_2_1__Impl : ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) ) ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1175:1: ( ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1176:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1176:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) )
            int alt7=5;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt7=2;
            }
            else if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt7=3;
            }
            else if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt7=4;
            }
            else if ( LA7_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt7=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1178:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1178:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1179:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1179:110: ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1180:6: ( ( rule__Stakeholder__Group_2_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1186:6: ( ( rule__Stakeholder__Group_2_1_0__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1188:7: ( rule__Stakeholder__Group_2_1_0__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1189:7: ( rule__Stakeholder__Group_2_1_0__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1189:8: rule__Stakeholder__Group_2_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2332);
                    rule__Stakeholder__Group_2_1_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_2_1_0()); 

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1195:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1195:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1196:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1196:110: ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1197:6: ( ( rule__Stakeholder__Group_2_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1203:6: ( ( rule__Stakeholder__Group_2_1_1__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1205:7: ( rule__Stakeholder__Group_2_1_1__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1206:7: ( rule__Stakeholder__Group_2_1_1__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1206:8: rule__Stakeholder__Group_2_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2423);
                    rule__Stakeholder__Group_2_1_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_2_1_1()); 

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1212:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1212:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1213:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1213:110: ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1214:6: ( ( rule__Stakeholder__Group_2_1_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1220:6: ( ( rule__Stakeholder__Group_2_1_2__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1222:7: ( rule__Stakeholder__Group_2_1_2__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_2()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1223:7: ( rule__Stakeholder__Group_2_1_2__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1223:8: rule__Stakeholder__Group_2_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2514);
                    rule__Stakeholder__Group_2_1_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_2_1_2()); 

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1229:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1229:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1230:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1230:110: ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1231:6: ( ( rule__Stakeholder__Group_2_1_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1237:6: ( ( rule__Stakeholder__Group_2_1_3__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1239:7: ( rule__Stakeholder__Group_2_1_3__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_3()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1240:7: ( rule__Stakeholder__Group_2_1_3__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1240:8: rule__Stakeholder__Group_2_1_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2605);
                    rule__Stakeholder__Group_2_1_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_2_1_3()); 

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1246:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1246:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1247:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1247:110: ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1248:6: ( ( rule__Stakeholder__Group_2_1_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1254:6: ( ( rule__Stakeholder__Group_2_1_4__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1256:7: ( rule__Stakeholder__Group_2_1_4__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_4()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1257:7: ( rule__Stakeholder__Group_2_1_4__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1257:8: rule__Stakeholder__Group_2_1_4__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2696);
                    rule__Stakeholder__Group_2_1_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_2_1_4()); 

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1__Impl"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1272:1: rule__Stakeholder__UnorderedGroup_2_1__0 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1276:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1277:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__02755);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1278:2: ( rule__Stakeholder__UnorderedGroup_2_1__1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt8=1;
            }
            else if ( LA8_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1278:2: rule__Stakeholder__UnorderedGroup_2_1__1
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__1_in_rule__Stakeholder__UnorderedGroup_2_1__02758);
                    rule__Stakeholder__UnorderedGroup_2_1__1();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1__0"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1285:1: rule__Stakeholder__UnorderedGroup_2_1__1 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1289:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1290:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__12783);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1291:2: ( rule__Stakeholder__UnorderedGroup_2_1__2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( LA9_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt9=1;
            }
            else if ( LA9_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt9=1;
            }
            else if ( LA9_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt9=1;
            }
            else if ( LA9_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1291:2: rule__Stakeholder__UnorderedGroup_2_1__2
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__2_in_rule__Stakeholder__UnorderedGroup_2_1__12786);
                    rule__Stakeholder__UnorderedGroup_2_1__2();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1__1"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1298:1: rule__Stakeholder__UnorderedGroup_2_1__2 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1302:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1303:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__22811);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1304:2: ( rule__Stakeholder__UnorderedGroup_2_1__3 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt10=1;
            }
            else if ( LA10_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1304:2: rule__Stakeholder__UnorderedGroup_2_1__3
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__3_in_rule__Stakeholder__UnorderedGroup_2_1__22814);
                    rule__Stakeholder__UnorderedGroup_2_1__3();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1__2"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1__3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1311:1: rule__Stakeholder__UnorderedGroup_2_1__3 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1315:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1316:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__32839);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1317:2: ( rule__Stakeholder__UnorderedGroup_2_1__4 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt11=1;
            }
            else if ( LA11_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1317:2: rule__Stakeholder__UnorderedGroup_2_1__4
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__4_in_rule__Stakeholder__UnorderedGroup_2_1__32842);
                    rule__Stakeholder__UnorderedGroup_2_1__4();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1__3"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1__4"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1324:1: rule__Stakeholder__UnorderedGroup_2_1__4 : rule__Stakeholder__UnorderedGroup_2_1__Impl ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1328:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1329:2: rule__Stakeholder__UnorderedGroup_2_1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__42867);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1__4"


    // $ANTLR start "rule__Organization__NameAssignment_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1346:1: rule__Organization__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Organization__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1350:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1351:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1351:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1352:1: RULE_ID
            {
             before(grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12905); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1361:1: rule__Organization__StakeholderAssignment_2 : ( ruleStakeholder ) ;
    public final void rule__Organization__StakeholderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1365:1: ( ( ruleStakeholder ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1366:1: ( ruleStakeholder )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1366:1: ( ruleStakeholder )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1367:1: ruleStakeholder
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22936);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1376:1: rule__Stakeholder__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stakeholder__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1380:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1381:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1381:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1382:1: RULE_ID
            {
             before(grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12967); 
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


    // $ANTLR start "rule__Stakeholder__TitleAssignment_2_1_0_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1391:1: rule__Stakeholder__TitleAssignment_2_1_0_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__TitleAssignment_2_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1395:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1396:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1396:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1397:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getTitleValueStringParserRuleCall_2_1_0_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__TitleAssignment_2_1_0_12998);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getTitleValueStringParserRuleCall_2_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__TitleAssignment_2_1_0_1"


    // $ANTLR start "rule__Stakeholder__DescriptionAssignment_2_1_1_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1406:1: rule__Stakeholder__DescriptionAssignment_2_1_1_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__DescriptionAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1410:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1411:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1411:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1412:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionValueStringParserRuleCall_2_1_1_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__DescriptionAssignment_2_1_1_13029);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getDescriptionValueStringParserRuleCall_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__DescriptionAssignment_2_1_1_1"


    // $ANTLR start "rule__Stakeholder__RoleAssignment_2_1_2_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1421:1: rule__Stakeholder__RoleAssignment_2_1_2_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__RoleAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1425:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1426:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1426:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1427:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getRoleValueStringParserRuleCall_2_1_2_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__RoleAssignment_2_1_2_13060);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getRoleValueStringParserRuleCall_2_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__RoleAssignment_2_1_2_1"


    // $ANTLR start "rule__Stakeholder__EmailAssignment_2_1_3_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1436:1: rule__Stakeholder__EmailAssignment_2_1_3_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__EmailAssignment_2_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1440:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1441:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1441:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1442:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getEmailValueStringParserRuleCall_2_1_3_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__EmailAssignment_2_1_3_13091);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getEmailValueStringParserRuleCall_2_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__EmailAssignment_2_1_3_1"


    // $ANTLR start "rule__Stakeholder__PhoneAssignment_2_1_4_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1451:1: rule__Stakeholder__PhoneAssignment_2_1_4_1 : ( ruleValueString ) ;
    public final void rule__Stakeholder__PhoneAssignment_2_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1455:1: ( ( ruleValueString ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1456:1: ( ruleValueString )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1456:1: ( ruleValueString )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1457:1: ruleValueString
            {
             before(grammarAccess.getStakeholderAccess().getPhoneValueStringParserRuleCall_2_1_4_1_0()); 
            pushFollow(FOLLOW_ruleValueString_in_rule__Stakeholder__PhoneAssignment_2_1_4_13122);
            ruleValueString();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getPhoneValueStringParserRuleCall_2_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__PhoneAssignment_2_1_4_1"


    // $ANTLR start "rule__Description__DescriptionAssignment"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1467:1: rule__Description__DescriptionAssignment : ( ruleDescriptionElement ) ;
    public final void rule__Description__DescriptionAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1471:1: ( ( ruleDescriptionElement ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1472:1: ( ruleDescriptionElement )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1472:1: ( ruleDescriptionElement )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1473:1: ruleDescriptionElement
            {
             before(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment3154);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1482:1: rule__DescriptionElement__TextAssignment_0 : ( RULE_STRING ) ;
    public final void rule__DescriptionElement__TextAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1486:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1487:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1487:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1488:1: RULE_STRING
            {
             before(grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_03185); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1497:1: rule__DescriptionElement__RefAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__DescriptionElement__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1501:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1502:1: ( ( RULE_ID ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1502:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1503:1: ( RULE_ID )
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1504:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1505:1: RULE_ID
            {
             before(grammarAccess.getDescriptionElementAccess().getRefEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_13220); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1516:1: rule__ReferencePath__RefAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__ReferencePath__RefAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1520:1: ( ( ( RULE_ID ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1521:1: ( ( RULE_ID ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1521:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1522:1: ( RULE_ID )
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1523:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1524:1: RULE_ID
            {
             before(grammarAccess.getReferencePathAccess().getRefEObjectIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_03259); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1535:1: rule__ReferencePath__SubpathAssignment_1_1 : ( ruleReferencePath ) ;
    public final void rule__ReferencePath__SubpathAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1539:1: ( ( ruleReferencePath ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1540:1: ( ruleReferencePath )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1540:1: ( ruleReferencePath )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1541:1: ruleReferencePath
            {
             before(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_13294);
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
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__TextAssignment_0_in_rule__DescriptionElement__Alternatives514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DescriptionElement__RefAssignment_1_in_rule__DescriptionElement__Alternatives532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__0__Impl_in_rule__Organization__Group__0563 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Organization__Group__1_in_rule__Organization__Group__0566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Organization__Group__0__Impl594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__1__Impl_in_rule__Organization__Group__1625 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Organization__Group__2_in_rule__Organization__Group__1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__NameAssignment_1_in_rule__Organization__Group__1__Impl655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__2__Impl_in_rule__Organization__Group__2685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl714 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl726 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__0__Impl_in_rule__Stakeholder__Group__0765 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__1_in_rule__Stakeholder__Group__0768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Stakeholder__Group__0__Impl796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__1__Impl_in_rule__Stakeholder__Group__1827 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__2_in_rule__Stakeholder__Group__1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__NameAssignment_1_in_rule__Stakeholder__Group__1__Impl857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__2__Impl_in_rule__Stakeholder__Group__2887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__0_in_rule__Stakeholder__Group__2__Impl914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__0__Impl_in_rule__Stakeholder__Group_2__0951 = new BitSet(new long[]{0x00000000000F8000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__1_in_rule__Stakeholder__Group_2__0954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Stakeholder__Group_2__0__Impl982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__1__Impl_in_rule__Stakeholder__Group_2__11013 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__2_in_rule__Stakeholder__Group_2__11016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1_in_rule__Stakeholder__Group_2__1__Impl1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__2__Impl_in_rule__Stakeholder__Group_2__21073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Stakeholder__Group_2__2__Impl1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__0__Impl_in_rule__Stakeholder__Group_2_1_0__01138 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__1_in_rule__Stakeholder__Group_2_1_0__01141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Stakeholder__Group_2_1_0__0__Impl1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__1__Impl_in_rule__Stakeholder__Group_2_1_0__11200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__TitleAssignment_2_1_0_1_in_rule__Stakeholder__Group_2_1_0__1__Impl1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__0__Impl_in_rule__Stakeholder__Group_2_1_1__01261 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__1_in_rule__Stakeholder__Group_2_1_1__01264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Stakeholder__Group_2_1_1__0__Impl1292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__1__Impl_in_rule__Stakeholder__Group_2_1_1__11323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__DescriptionAssignment_2_1_1_1_in_rule__Stakeholder__Group_2_1_1__1__Impl1350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__0__Impl_in_rule__Stakeholder__Group_2_1_2__01384 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__1_in_rule__Stakeholder__Group_2_1_2__01387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Stakeholder__Group_2_1_2__0__Impl1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__1__Impl_in_rule__Stakeholder__Group_2_1_2__11446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__RoleAssignment_2_1_2_1_in_rule__Stakeholder__Group_2_1_2__1__Impl1473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__0__Impl_in_rule__Stakeholder__Group_2_1_3__01507 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__1_in_rule__Stakeholder__Group_2_1_3__01510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Stakeholder__Group_2_1_3__0__Impl1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__1__Impl_in_rule__Stakeholder__Group_2_1_3__11569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__EmailAssignment_2_1_3_1_in_rule__Stakeholder__Group_2_1_3__1__Impl1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__0__Impl_in_rule__Stakeholder__Group_2_1_4__01630 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__1_in_rule__Stakeholder__Group_2_1_4__01633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Stakeholder__Group_2_1_4__0__Impl1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__1__Impl_in_rule__Stakeholder__Group_2_1_4__11692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__PhoneAssignment_2_1_4_1_in_rule__Stakeholder__Group_2_1_4__1__Impl1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__0__Impl_in_rule__ReferencePath__Group__01753 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1_in_rule__ReferencePath__Group__01756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__RefAssignment_0_in_rule__ReferencePath__Group__0__Impl1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group__1__Impl_in_rule__ReferencePath__Group__11813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0_in_rule__ReferencePath__Group__1__Impl1840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__0__Impl_in_rule__ReferencePath__Group_1__01874 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1_in_rule__ReferencePath__Group_1__01877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ReferencePath__Group_1__0__Impl1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__Group_1__1__Impl_in_rule__ReferencePath__Group_1__11936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferencePath__SubpathAssignment_1_1_in_rule__ReferencePath__Group_1__1__Impl1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01997 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl2027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2083 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02118 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__QualifiedName__Group_1__0__Impl2149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__0_in_rule__Stakeholder__UnorderedGroup_2_12245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__02755 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__1_in_rule__Stakeholder__UnorderedGroup_2_1__02758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__12783 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__2_in_rule__Stakeholder__UnorderedGroup_2_1__12786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__22811 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__3_in_rule__Stakeholder__UnorderedGroup_2_1__22814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__32839 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__4_in_rule__Stakeholder__UnorderedGroup_2_1__32842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__42867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__TitleAssignment_2_1_0_12998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__DescriptionAssignment_2_1_1_13029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__RoleAssignment_2_1_2_13060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__EmailAssignment_2_1_3_13091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_rule__Stakeholder__PhoneAssignment_2_1_4_13122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_rule__Description__DescriptionAssignment3154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__DescriptionElement__TextAssignment_03185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__DescriptionElement__RefAssignment_13220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferencePath__RefAssignment_03259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_rule__ReferencePath__SubpathAssignment_1_13294 = new BitSet(new long[]{0x0000000000000002L});

}
