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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'organization'", "'stakeholder'", "'['", "']'", "'title'", "'description'", "'role'", "'email'", "'phone'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
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


    // $ANTLR start "rule__Organization__Group__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:118:1: rule__Organization__Group__0 : rule__Organization__Group__0__Impl rule__Organization__Group__1 ;
    public final void rule__Organization__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:122:1: ( rule__Organization__Group__0__Impl rule__Organization__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:123:2: rule__Organization__Group__0__Impl rule__Organization__Group__1
            {
            pushFollow(FOLLOW_rule__Organization__Group__0__Impl_in_rule__Organization__Group__0188);
            rule__Organization__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Organization__Group__1_in_rule__Organization__Group__0191);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:130:1: rule__Organization__Group__0__Impl : ( 'organization' ) ;
    public final void rule__Organization__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:134:1: ( ( 'organization' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:135:1: ( 'organization' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:135:1: ( 'organization' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:136:1: 'organization'
            {
             before(grammarAccess.getOrganizationAccess().getOrganizationKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Organization__Group__0__Impl219); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:149:1: rule__Organization__Group__1 : rule__Organization__Group__1__Impl rule__Organization__Group__2 ;
    public final void rule__Organization__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:153:1: ( rule__Organization__Group__1__Impl rule__Organization__Group__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:154:2: rule__Organization__Group__1__Impl rule__Organization__Group__2
            {
            pushFollow(FOLLOW_rule__Organization__Group__1__Impl_in_rule__Organization__Group__1250);
            rule__Organization__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Organization__Group__2_in_rule__Organization__Group__1253);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:161:1: rule__Organization__Group__1__Impl : ( ( rule__Organization__NameAssignment_1 ) ) ;
    public final void rule__Organization__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:165:1: ( ( ( rule__Organization__NameAssignment_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:166:1: ( ( rule__Organization__NameAssignment_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:166:1: ( ( rule__Organization__NameAssignment_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:167:1: ( rule__Organization__NameAssignment_1 )
            {
             before(grammarAccess.getOrganizationAccess().getNameAssignment_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:168:1: ( rule__Organization__NameAssignment_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:168:2: rule__Organization__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Organization__NameAssignment_1_in_rule__Organization__Group__1__Impl280);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:178:1: rule__Organization__Group__2 : rule__Organization__Group__2__Impl ;
    public final void rule__Organization__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:182:1: ( rule__Organization__Group__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:183:2: rule__Organization__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Organization__Group__2__Impl_in_rule__Organization__Group__2310);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:189:1: rule__Organization__Group__2__Impl : ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) ) ;
    public final void rule__Organization__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:193:1: ( ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:194:1: ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:194:1: ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:195:1: ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:195:1: ( ( rule__Organization__StakeholderAssignment_2 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:196:1: ( rule__Organization__StakeholderAssignment_2 )
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:197:1: ( rule__Organization__StakeholderAssignment_2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:197:2: rule__Organization__StakeholderAssignment_2
            {
            pushFollow(FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl339);
            rule__Organization__StakeholderAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 

            }

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:200:1: ( ( rule__Organization__StakeholderAssignment_2 )* )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:201:1: ( rule__Organization__StakeholderAssignment_2 )*
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:202:1: ( rule__Organization__StakeholderAssignment_2 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==12) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:202:2: rule__Organization__StakeholderAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl351);
            	    rule__Organization__StakeholderAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:219:1: rule__Stakeholder__Group__0 : rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1 ;
    public final void rule__Stakeholder__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:223:1: ( rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:224:2: rule__Stakeholder__Group__0__Impl rule__Stakeholder__Group__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__0__Impl_in_rule__Stakeholder__Group__0390);
            rule__Stakeholder__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__1_in_rule__Stakeholder__Group__0393);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:231:1: rule__Stakeholder__Group__0__Impl : ( 'stakeholder' ) ;
    public final void rule__Stakeholder__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:235:1: ( ( 'stakeholder' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:236:1: ( 'stakeholder' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:236:1: ( 'stakeholder' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:237:1: 'stakeholder'
            {
             before(grammarAccess.getStakeholderAccess().getStakeholderKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__Stakeholder__Group__0__Impl421); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:250:1: rule__Stakeholder__Group__1 : rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2 ;
    public final void rule__Stakeholder__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:254:1: ( rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:255:2: rule__Stakeholder__Group__1__Impl rule__Stakeholder__Group__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__1__Impl_in_rule__Stakeholder__Group__1452);
            rule__Stakeholder__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__2_in_rule__Stakeholder__Group__1455);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:262:1: rule__Stakeholder__Group__1__Impl : ( ( rule__Stakeholder__NameAssignment_1 ) ) ;
    public final void rule__Stakeholder__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:266:1: ( ( ( rule__Stakeholder__NameAssignment_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:267:1: ( ( rule__Stakeholder__NameAssignment_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:267:1: ( ( rule__Stakeholder__NameAssignment_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:268:1: ( rule__Stakeholder__NameAssignment_1 )
            {
             before(grammarAccess.getStakeholderAccess().getNameAssignment_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:269:1: ( rule__Stakeholder__NameAssignment_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:269:2: rule__Stakeholder__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__NameAssignment_1_in_rule__Stakeholder__Group__1__Impl482);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:279:1: rule__Stakeholder__Group__2 : rule__Stakeholder__Group__2__Impl ;
    public final void rule__Stakeholder__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:283:1: ( rule__Stakeholder__Group__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:284:2: rule__Stakeholder__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__2__Impl_in_rule__Stakeholder__Group__2512);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:290:1: rule__Stakeholder__Group__2__Impl : ( ( rule__Stakeholder__Group_2__0 )? ) ;
    public final void rule__Stakeholder__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:294:1: ( ( ( rule__Stakeholder__Group_2__0 )? ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:295:1: ( ( rule__Stakeholder__Group_2__0 )? )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:295:1: ( ( rule__Stakeholder__Group_2__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:296:1: ( rule__Stakeholder__Group_2__0 )?
            {
             before(grammarAccess.getStakeholderAccess().getGroup_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:297:1: ( rule__Stakeholder__Group_2__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==13) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:297:2: rule__Stakeholder__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2__0_in_rule__Stakeholder__Group__2__Impl539);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:313:1: rule__Stakeholder__Group_2__0 : rule__Stakeholder__Group_2__0__Impl rule__Stakeholder__Group_2__1 ;
    public final void rule__Stakeholder__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:317:1: ( rule__Stakeholder__Group_2__0__Impl rule__Stakeholder__Group_2__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:318:2: rule__Stakeholder__Group_2__0__Impl rule__Stakeholder__Group_2__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2__0__Impl_in_rule__Stakeholder__Group_2__0576);
            rule__Stakeholder__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2__1_in_rule__Stakeholder__Group_2__0579);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:325:1: rule__Stakeholder__Group_2__0__Impl : ( '[' ) ;
    public final void rule__Stakeholder__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:329:1: ( ( '[' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:330:1: ( '[' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:330:1: ( '[' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:331:1: '['
            {
             before(grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2_0()); 
            match(input,13,FOLLOW_13_in_rule__Stakeholder__Group_2__0__Impl607); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:344:1: rule__Stakeholder__Group_2__1 : rule__Stakeholder__Group_2__1__Impl rule__Stakeholder__Group_2__2 ;
    public final void rule__Stakeholder__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:348:1: ( rule__Stakeholder__Group_2__1__Impl rule__Stakeholder__Group_2__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:349:2: rule__Stakeholder__Group_2__1__Impl rule__Stakeholder__Group_2__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2__1__Impl_in_rule__Stakeholder__Group_2__1638);
            rule__Stakeholder__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2__2_in_rule__Stakeholder__Group_2__1641);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:356:1: rule__Stakeholder__Group_2__1__Impl : ( ( rule__Stakeholder__UnorderedGroup_2_1 ) ) ;
    public final void rule__Stakeholder__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:360:1: ( ( ( rule__Stakeholder__UnorderedGroup_2_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:361:1: ( ( rule__Stakeholder__UnorderedGroup_2_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:361:1: ( ( rule__Stakeholder__UnorderedGroup_2_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:362:1: ( rule__Stakeholder__UnorderedGroup_2_1 )
            {
             before(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:363:1: ( rule__Stakeholder__UnorderedGroup_2_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:363:2: rule__Stakeholder__UnorderedGroup_2_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1_in_rule__Stakeholder__Group_2__1__Impl668);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:373:1: rule__Stakeholder__Group_2__2 : rule__Stakeholder__Group_2__2__Impl ;
    public final void rule__Stakeholder__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:377:1: ( rule__Stakeholder__Group_2__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:378:2: rule__Stakeholder__Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2__2__Impl_in_rule__Stakeholder__Group_2__2698);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:384:1: rule__Stakeholder__Group_2__2__Impl : ( ']' ) ;
    public final void rule__Stakeholder__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:388:1: ( ( ']' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:389:1: ( ']' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:389:1: ( ']' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:390:1: ']'
            {
             before(grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_2_2()); 
            match(input,14,FOLLOW_14_in_rule__Stakeholder__Group_2__2__Impl726); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:409:1: rule__Stakeholder__Group_2_1_0__0 : rule__Stakeholder__Group_2_1_0__0__Impl rule__Stakeholder__Group_2_1_0__1 ;
    public final void rule__Stakeholder__Group_2_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:413:1: ( rule__Stakeholder__Group_2_1_0__0__Impl rule__Stakeholder__Group_2_1_0__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:414:2: rule__Stakeholder__Group_2_1_0__0__Impl rule__Stakeholder__Group_2_1_0__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__0__Impl_in_rule__Stakeholder__Group_2_1_0__0763);
            rule__Stakeholder__Group_2_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__1_in_rule__Stakeholder__Group_2_1_0__0766);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:421:1: rule__Stakeholder__Group_2_1_0__0__Impl : ( 'title' ) ;
    public final void rule__Stakeholder__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:425:1: ( ( 'title' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:426:1: ( 'title' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:426:1: ( 'title' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:427:1: 'title'
            {
             before(grammarAccess.getStakeholderAccess().getTitleKeyword_2_1_0_0()); 
            match(input,15,FOLLOW_15_in_rule__Stakeholder__Group_2_1_0__0__Impl794); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:440:1: rule__Stakeholder__Group_2_1_0__1 : rule__Stakeholder__Group_2_1_0__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:444:1: ( rule__Stakeholder__Group_2_1_0__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:445:2: rule__Stakeholder__Group_2_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__1__Impl_in_rule__Stakeholder__Group_2_1_0__1825);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:451:1: rule__Stakeholder__Group_2_1_0__1__Impl : ( ( rule__Stakeholder__TitleAssignment_2_1_0_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:455:1: ( ( ( rule__Stakeholder__TitleAssignment_2_1_0_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:456:1: ( ( rule__Stakeholder__TitleAssignment_2_1_0_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:456:1: ( ( rule__Stakeholder__TitleAssignment_2_1_0_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:457:1: ( rule__Stakeholder__TitleAssignment_2_1_0_1 )
            {
             before(grammarAccess.getStakeholderAccess().getTitleAssignment_2_1_0_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:458:1: ( rule__Stakeholder__TitleAssignment_2_1_0_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:458:2: rule__Stakeholder__TitleAssignment_2_1_0_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__TitleAssignment_2_1_0_1_in_rule__Stakeholder__Group_2_1_0__1__Impl852);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:472:1: rule__Stakeholder__Group_2_1_1__0 : rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1 ;
    public final void rule__Stakeholder__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:476:1: ( rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:477:2: rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__0__Impl_in_rule__Stakeholder__Group_2_1_1__0886);
            rule__Stakeholder__Group_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__1_in_rule__Stakeholder__Group_2_1_1__0889);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:484:1: rule__Stakeholder__Group_2_1_1__0__Impl : ( 'description' ) ;
    public final void rule__Stakeholder__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:488:1: ( ( 'description' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:489:1: ( 'description' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:489:1: ( 'description' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:490:1: 'description'
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionKeyword_2_1_1_0()); 
            match(input,16,FOLLOW_16_in_rule__Stakeholder__Group_2_1_1__0__Impl917); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:503:1: rule__Stakeholder__Group_2_1_1__1 : rule__Stakeholder__Group_2_1_1__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:507:1: ( rule__Stakeholder__Group_2_1_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:508:2: rule__Stakeholder__Group_2_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__1__Impl_in_rule__Stakeholder__Group_2_1_1__1948);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:514:1: rule__Stakeholder__Group_2_1_1__1__Impl : ( ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:518:1: ( ( ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:519:1: ( ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:519:1: ( ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:520:1: ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 )
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionAssignment_2_1_1_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:521:1: ( rule__Stakeholder__DescriptionAssignment_2_1_1_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:521:2: rule__Stakeholder__DescriptionAssignment_2_1_1_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__DescriptionAssignment_2_1_1_1_in_rule__Stakeholder__Group_2_1_1__1__Impl975);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:535:1: rule__Stakeholder__Group_2_1_2__0 : rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1 ;
    public final void rule__Stakeholder__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:539:1: ( rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:540:2: rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__0__Impl_in_rule__Stakeholder__Group_2_1_2__01009);
            rule__Stakeholder__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__1_in_rule__Stakeholder__Group_2_1_2__01012);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:547:1: rule__Stakeholder__Group_2_1_2__0__Impl : ( 'role' ) ;
    public final void rule__Stakeholder__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:551:1: ( ( 'role' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:552:1: ( 'role' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:552:1: ( 'role' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:553:1: 'role'
            {
             before(grammarAccess.getStakeholderAccess().getRoleKeyword_2_1_2_0()); 
            match(input,17,FOLLOW_17_in_rule__Stakeholder__Group_2_1_2__0__Impl1040); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:566:1: rule__Stakeholder__Group_2_1_2__1 : rule__Stakeholder__Group_2_1_2__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:570:1: ( rule__Stakeholder__Group_2_1_2__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:571:2: rule__Stakeholder__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__1__Impl_in_rule__Stakeholder__Group_2_1_2__11071);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:577:1: rule__Stakeholder__Group_2_1_2__1__Impl : ( ( rule__Stakeholder__RoleAssignment_2_1_2_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:581:1: ( ( ( rule__Stakeholder__RoleAssignment_2_1_2_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:582:1: ( ( rule__Stakeholder__RoleAssignment_2_1_2_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:582:1: ( ( rule__Stakeholder__RoleAssignment_2_1_2_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:583:1: ( rule__Stakeholder__RoleAssignment_2_1_2_1 )
            {
             before(grammarAccess.getStakeholderAccess().getRoleAssignment_2_1_2_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:584:1: ( rule__Stakeholder__RoleAssignment_2_1_2_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:584:2: rule__Stakeholder__RoleAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__RoleAssignment_2_1_2_1_in_rule__Stakeholder__Group_2_1_2__1__Impl1098);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:598:1: rule__Stakeholder__Group_2_1_3__0 : rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1 ;
    public final void rule__Stakeholder__Group_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:602:1: ( rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:603:2: rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__0__Impl_in_rule__Stakeholder__Group_2_1_3__01132);
            rule__Stakeholder__Group_2_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__1_in_rule__Stakeholder__Group_2_1_3__01135);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:610:1: rule__Stakeholder__Group_2_1_3__0__Impl : ( 'email' ) ;
    public final void rule__Stakeholder__Group_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:614:1: ( ( 'email' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:615:1: ( 'email' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:615:1: ( 'email' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:616:1: 'email'
            {
             before(grammarAccess.getStakeholderAccess().getEmailKeyword_2_1_3_0()); 
            match(input,18,FOLLOW_18_in_rule__Stakeholder__Group_2_1_3__0__Impl1163); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:629:1: rule__Stakeholder__Group_2_1_3__1 : rule__Stakeholder__Group_2_1_3__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:633:1: ( rule__Stakeholder__Group_2_1_3__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:634:2: rule__Stakeholder__Group_2_1_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__1__Impl_in_rule__Stakeholder__Group_2_1_3__11194);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:640:1: rule__Stakeholder__Group_2_1_3__1__Impl : ( ( rule__Stakeholder__EmailAssignment_2_1_3_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:644:1: ( ( ( rule__Stakeholder__EmailAssignment_2_1_3_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:645:1: ( ( rule__Stakeholder__EmailAssignment_2_1_3_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:645:1: ( ( rule__Stakeholder__EmailAssignment_2_1_3_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:646:1: ( rule__Stakeholder__EmailAssignment_2_1_3_1 )
            {
             before(grammarAccess.getStakeholderAccess().getEmailAssignment_2_1_3_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:647:1: ( rule__Stakeholder__EmailAssignment_2_1_3_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:647:2: rule__Stakeholder__EmailAssignment_2_1_3_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__EmailAssignment_2_1_3_1_in_rule__Stakeholder__Group_2_1_3__1__Impl1221);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:661:1: rule__Stakeholder__Group_2_1_4__0 : rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1 ;
    public final void rule__Stakeholder__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:665:1: ( rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:666:2: rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__0__Impl_in_rule__Stakeholder__Group_2_1_4__01255);
            rule__Stakeholder__Group_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__1_in_rule__Stakeholder__Group_2_1_4__01258);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:673:1: rule__Stakeholder__Group_2_1_4__0__Impl : ( 'phone' ) ;
    public final void rule__Stakeholder__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:677:1: ( ( 'phone' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:678:1: ( 'phone' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:678:1: ( 'phone' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:679:1: 'phone'
            {
             before(grammarAccess.getStakeholderAccess().getPhoneKeyword_2_1_4_0()); 
            match(input,19,FOLLOW_19_in_rule__Stakeholder__Group_2_1_4__0__Impl1286); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:692:1: rule__Stakeholder__Group_2_1_4__1 : rule__Stakeholder__Group_2_1_4__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:696:1: ( rule__Stakeholder__Group_2_1_4__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:697:2: rule__Stakeholder__Group_2_1_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__1__Impl_in_rule__Stakeholder__Group_2_1_4__11317);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:703:1: rule__Stakeholder__Group_2_1_4__1__Impl : ( ( rule__Stakeholder__PhoneAssignment_2_1_4_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:707:1: ( ( ( rule__Stakeholder__PhoneAssignment_2_1_4_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:708:1: ( ( rule__Stakeholder__PhoneAssignment_2_1_4_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:708:1: ( ( rule__Stakeholder__PhoneAssignment_2_1_4_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:709:1: ( rule__Stakeholder__PhoneAssignment_2_1_4_1 )
            {
             before(grammarAccess.getStakeholderAccess().getPhoneAssignment_2_1_4_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:710:1: ( rule__Stakeholder__PhoneAssignment_2_1_4_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:710:2: rule__Stakeholder__PhoneAssignment_2_1_4_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__PhoneAssignment_2_1_4_1_in_rule__Stakeholder__Group_2_1_4__1__Impl1344);
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


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:725:1: rule__Stakeholder__UnorderedGroup_2_1 : ( rule__Stakeholder__UnorderedGroup_2_1__0 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:730:1: ( ( rule__Stakeholder__UnorderedGroup_2_1__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:731:2: ( rule__Stakeholder__UnorderedGroup_2_1__0 )?
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:731:2: ( rule__Stakeholder__UnorderedGroup_2_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( LA3_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt3=1;
            }
            else if ( LA3_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt3=1;
            }
            else if ( LA3_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt3=1;
            }
            else if ( LA3_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt3=1;
            }
            else if ( LA3_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:731:2: rule__Stakeholder__UnorderedGroup_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__0_in_rule__Stakeholder__UnorderedGroup_2_11379);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:741:1: rule__Stakeholder__UnorderedGroup_2_1__Impl : ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) ) ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:746:1: ( ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:747:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:747:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) )
            int alt4=5;
            int LA4_0 = input.LA(1);

            if ( LA4_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt4=1;
            }
            else if ( LA4_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt4=2;
            }
            else if ( LA4_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt4=3;
            }
            else if ( LA4_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt4=4;
            }
            else if ( LA4_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt4=5;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:749:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:749:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:750:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:750:110: ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:751:6: ( ( rule__Stakeholder__Group_2_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:757:6: ( ( rule__Stakeholder__Group_2_1_0__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:759:7: ( rule__Stakeholder__Group_2_1_0__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:760:7: ( rule__Stakeholder__Group_2_1_0__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:760:8: rule__Stakeholder__Group_2_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1466);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:766:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:766:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:767:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:767:110: ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:768:6: ( ( rule__Stakeholder__Group_2_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:774:6: ( ( rule__Stakeholder__Group_2_1_1__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:776:7: ( rule__Stakeholder__Group_2_1_1__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:777:7: ( rule__Stakeholder__Group_2_1_1__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:777:8: rule__Stakeholder__Group_2_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1557);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:783:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:783:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:784:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:784:110: ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:785:6: ( ( rule__Stakeholder__Group_2_1_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:791:6: ( ( rule__Stakeholder__Group_2_1_2__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:793:7: ( rule__Stakeholder__Group_2_1_2__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_2()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:794:7: ( rule__Stakeholder__Group_2_1_2__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:794:8: rule__Stakeholder__Group_2_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1648);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:800:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:800:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:801:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:801:110: ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:802:6: ( ( rule__Stakeholder__Group_2_1_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:808:6: ( ( rule__Stakeholder__Group_2_1_3__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:810:7: ( rule__Stakeholder__Group_2_1_3__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_3()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:811:7: ( rule__Stakeholder__Group_2_1_3__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:811:8: rule__Stakeholder__Group_2_1_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1739);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:817:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:817:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:818:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:818:110: ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:819:6: ( ( rule__Stakeholder__Group_2_1_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:825:6: ( ( rule__Stakeholder__Group_2_1_4__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:827:7: ( rule__Stakeholder__Group_2_1_4__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_4()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:828:7: ( rule__Stakeholder__Group_2_1_4__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:828:8: rule__Stakeholder__Group_2_1_4__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1830);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:843:1: rule__Stakeholder__UnorderedGroup_2_1__0 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:847:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:848:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__01889);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:849:2: ( rule__Stakeholder__UnorderedGroup_2_1__1 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( LA5_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt5=1;
            }
            else if ( LA5_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt5=1;
            }
            else if ( LA5_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt5=1;
            }
            else if ( LA5_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt5=1;
            }
            else if ( LA5_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:849:2: rule__Stakeholder__UnorderedGroup_2_1__1
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__1_in_rule__Stakeholder__UnorderedGroup_2_1__01892);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:856:1: rule__Stakeholder__UnorderedGroup_2_1__1 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:860:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:861:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__11917);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:862:2: ( rule__Stakeholder__UnorderedGroup_2_1__2 )?
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:862:2: rule__Stakeholder__UnorderedGroup_2_1__2
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__2_in_rule__Stakeholder__UnorderedGroup_2_1__11920);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:869:1: rule__Stakeholder__UnorderedGroup_2_1__2 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:873:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:874:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__21945);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:875:2: ( rule__Stakeholder__UnorderedGroup_2_1__3 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==16 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt7=1;
            }
            else if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt7=1;
            }
            else if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt7=1;
            }
            else if ( LA7_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:875:2: rule__Stakeholder__UnorderedGroup_2_1__3
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__3_in_rule__Stakeholder__UnorderedGroup_2_1__21948);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:882:1: rule__Stakeholder__UnorderedGroup_2_1__3 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:886:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:887:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__31973);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:888:2: ( rule__Stakeholder__UnorderedGroup_2_1__4 )?
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:888:2: rule__Stakeholder__UnorderedGroup_2_1__4
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__4_in_rule__Stakeholder__UnorderedGroup_2_1__31976);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:895:1: rule__Stakeholder__UnorderedGroup_2_1__4 : rule__Stakeholder__UnorderedGroup_2_1__Impl ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:899:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:900:2: rule__Stakeholder__UnorderedGroup_2_1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__42001);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:917:1: rule__Organization__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Organization__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:921:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:922:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:922:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:923:1: RULE_ID
            {
             before(grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12039); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:932:1: rule__Organization__StakeholderAssignment_2 : ( ruleStakeholder ) ;
    public final void rule__Organization__StakeholderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:936:1: ( ( ruleStakeholder ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:937:1: ( ruleStakeholder )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:937:1: ( ruleStakeholder )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:938:1: ruleStakeholder
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22070);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:947:1: rule__Stakeholder__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stakeholder__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:951:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:952:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:952:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:953:1: RULE_ID
            {
             before(grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12101); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:962:1: rule__Stakeholder__TitleAssignment_2_1_0_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__TitleAssignment_2_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:966:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:967:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:967:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:968:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_2_1_0_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__TitleAssignment_2_1_0_12132); 
             after(grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_2_1_0_1_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:977:1: rule__Stakeholder__DescriptionAssignment_2_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__DescriptionAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:981:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:982:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:982:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:983:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_2_1_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__DescriptionAssignment_2_1_1_12163); 
             after(grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_2_1_1_1_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:992:1: rule__Stakeholder__RoleAssignment_2_1_2_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__RoleAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:996:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:997:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:997:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:998:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_2_1_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__RoleAssignment_2_1_2_12194); 
             after(grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_2_1_2_1_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1007:1: rule__Stakeholder__EmailAssignment_2_1_3_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__EmailAssignment_2_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1011:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1012:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1012:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1013:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_2_1_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__EmailAssignment_2_1_3_12225); 
             after(grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_2_1_3_1_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1022:1: rule__Stakeholder__PhoneAssignment_2_1_4_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__PhoneAssignment_2_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1026:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1027:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1027:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1028:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_2_1_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__PhoneAssignment_2_1_4_12256); 
             after(grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_2_1_4_1_0()); 

            }


            }

        }
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleOrganization_in_entryRuleOrganization61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrganization68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__0_in_ruleOrganization94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_entryRuleStakeholder121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholder128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__0_in_ruleStakeholder154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__0__Impl_in_rule__Organization__Group__0188 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Organization__Group__1_in_rule__Organization__Group__0191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Organization__Group__0__Impl219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__1__Impl_in_rule__Organization__Group__1250 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Organization__Group__2_in_rule__Organization__Group__1253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__NameAssignment_1_in_rule__Organization__Group__1__Impl280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__2__Impl_in_rule__Organization__Group__2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl339 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl351 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__0__Impl_in_rule__Stakeholder__Group__0390 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__1_in_rule__Stakeholder__Group__0393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Stakeholder__Group__0__Impl421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__1__Impl_in_rule__Stakeholder__Group__1452 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__2_in_rule__Stakeholder__Group__1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__NameAssignment_1_in_rule__Stakeholder__Group__1__Impl482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__2__Impl_in_rule__Stakeholder__Group__2512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__0_in_rule__Stakeholder__Group__2__Impl539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__0__Impl_in_rule__Stakeholder__Group_2__0576 = new BitSet(new long[]{0x00000000000F8000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__1_in_rule__Stakeholder__Group_2__0579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Stakeholder__Group_2__0__Impl607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__1__Impl_in_rule__Stakeholder__Group_2__1638 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__2_in_rule__Stakeholder__Group_2__1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1_in_rule__Stakeholder__Group_2__1__Impl668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__2__Impl_in_rule__Stakeholder__Group_2__2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Stakeholder__Group_2__2__Impl726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__0__Impl_in_rule__Stakeholder__Group_2_1_0__0763 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__1_in_rule__Stakeholder__Group_2_1_0__0766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Stakeholder__Group_2_1_0__0__Impl794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__1__Impl_in_rule__Stakeholder__Group_2_1_0__1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__TitleAssignment_2_1_0_1_in_rule__Stakeholder__Group_2_1_0__1__Impl852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__0__Impl_in_rule__Stakeholder__Group_2_1_1__0886 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__1_in_rule__Stakeholder__Group_2_1_1__0889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Stakeholder__Group_2_1_1__0__Impl917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__1__Impl_in_rule__Stakeholder__Group_2_1_1__1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__DescriptionAssignment_2_1_1_1_in_rule__Stakeholder__Group_2_1_1__1__Impl975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__0__Impl_in_rule__Stakeholder__Group_2_1_2__01009 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__1_in_rule__Stakeholder__Group_2_1_2__01012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Stakeholder__Group_2_1_2__0__Impl1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__1__Impl_in_rule__Stakeholder__Group_2_1_2__11071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__RoleAssignment_2_1_2_1_in_rule__Stakeholder__Group_2_1_2__1__Impl1098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__0__Impl_in_rule__Stakeholder__Group_2_1_3__01132 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__1_in_rule__Stakeholder__Group_2_1_3__01135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Stakeholder__Group_2_1_3__0__Impl1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__1__Impl_in_rule__Stakeholder__Group_2_1_3__11194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__EmailAssignment_2_1_3_1_in_rule__Stakeholder__Group_2_1_3__1__Impl1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__0__Impl_in_rule__Stakeholder__Group_2_1_4__01255 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__1_in_rule__Stakeholder__Group_2_1_4__01258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Stakeholder__Group_2_1_4__0__Impl1286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__1__Impl_in_rule__Stakeholder__Group_2_1_4__11317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__PhoneAssignment_2_1_4_1_in_rule__Stakeholder__Group_2_1_4__1__Impl1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__0_in_rule__Stakeholder__UnorderedGroup_2_11379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__01889 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__1_in_rule__Stakeholder__UnorderedGroup_2_1__01892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__11917 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__2_in_rule__Stakeholder__UnorderedGroup_2_1__11920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__21945 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__3_in_rule__Stakeholder__UnorderedGroup_2_1__21948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__31973 = new BitSet(new long[]{0x00000000000F8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__4_in_rule__Stakeholder__UnorderedGroup_2_1__31976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__42001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__TitleAssignment_2_1_0_12132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__DescriptionAssignment_2_1_1_12163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__RoleAssignment_2_1_2_12194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__EmailAssignment_2_1_3_12225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__PhoneAssignment_2_1_4_12256 = new BitSet(new long[]{0x0000000000000002L});

}
