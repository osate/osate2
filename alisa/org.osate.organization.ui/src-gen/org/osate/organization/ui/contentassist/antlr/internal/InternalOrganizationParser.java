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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'organization'", "'stakeholder'", "'['", "']'", "'full'", "'name'", "'title'", "'description'", "'role'", "'email'", "'phone'"
    };
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:279:1: rule__Stakeholder__Group__2 : rule__Stakeholder__Group__2__Impl rule__Stakeholder__Group__3 ;
    public final void rule__Stakeholder__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:283:1: ( rule__Stakeholder__Group__2__Impl rule__Stakeholder__Group__3 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:284:2: rule__Stakeholder__Group__2__Impl rule__Stakeholder__Group__3
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__2__Impl_in_rule__Stakeholder__Group__2512);
            rule__Stakeholder__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__3_in_rule__Stakeholder__Group__2515);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:291:1: rule__Stakeholder__Group__2__Impl : ( '[' ) ;
    public final void rule__Stakeholder__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:295:1: ( ( '[' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:296:1: ( '[' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:296:1: ( '[' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:297:1: '['
            {
             before(grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_2()); 
            match(input,13,FOLLOW_13_in_rule__Stakeholder__Group__2__Impl543); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:310:1: rule__Stakeholder__Group__3 : rule__Stakeholder__Group__3__Impl rule__Stakeholder__Group__4 ;
    public final void rule__Stakeholder__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:314:1: ( rule__Stakeholder__Group__3__Impl rule__Stakeholder__Group__4 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:315:2: rule__Stakeholder__Group__3__Impl rule__Stakeholder__Group__4
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__3__Impl_in_rule__Stakeholder__Group__3574);
            rule__Stakeholder__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group__4_in_rule__Stakeholder__Group__3577);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:322:1: rule__Stakeholder__Group__3__Impl : ( ( rule__Stakeholder__UnorderedGroup_3 ) ) ;
    public final void rule__Stakeholder__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:326:1: ( ( ( rule__Stakeholder__UnorderedGroup_3 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:327:1: ( ( rule__Stakeholder__UnorderedGroup_3 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:327:1: ( ( rule__Stakeholder__UnorderedGroup_3 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:328:1: ( rule__Stakeholder__UnorderedGroup_3 )
            {
             before(grammarAccess.getStakeholderAccess().getUnorderedGroup_3()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:329:1: ( rule__Stakeholder__UnorderedGroup_3 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:329:2: rule__Stakeholder__UnorderedGroup_3
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3_in_rule__Stakeholder__Group__3__Impl604);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:339:1: rule__Stakeholder__Group__4 : rule__Stakeholder__Group__4__Impl ;
    public final void rule__Stakeholder__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:343:1: ( rule__Stakeholder__Group__4__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:344:2: rule__Stakeholder__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group__4__Impl_in_rule__Stakeholder__Group__4634);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:350:1: rule__Stakeholder__Group__4__Impl : ( ']' ) ;
    public final void rule__Stakeholder__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:354:1: ( ( ']' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:355:1: ( ']' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:355:1: ( ']' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:356:1: ']'
            {
             before(grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__Stakeholder__Group__4__Impl662); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:379:1: rule__Stakeholder__Group_3_0__0 : rule__Stakeholder__Group_3_0__0__Impl rule__Stakeholder__Group_3_0__1 ;
    public final void rule__Stakeholder__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:383:1: ( rule__Stakeholder__Group_3_0__0__Impl rule__Stakeholder__Group_3_0__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:384:2: rule__Stakeholder__Group_3_0__0__Impl rule__Stakeholder__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__0__Impl_in_rule__Stakeholder__Group_3_0__0703);
            rule__Stakeholder__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__1_in_rule__Stakeholder__Group_3_0__0706);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:391:1: rule__Stakeholder__Group_3_0__0__Impl : ( 'full' ) ;
    public final void rule__Stakeholder__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:395:1: ( ( 'full' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:396:1: ( 'full' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:396:1: ( 'full' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:397:1: 'full'
            {
             before(grammarAccess.getStakeholderAccess().getFullKeyword_3_0_0()); 
            match(input,15,FOLLOW_15_in_rule__Stakeholder__Group_3_0__0__Impl734); 
             after(grammarAccess.getStakeholderAccess().getFullKeyword_3_0_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:410:1: rule__Stakeholder__Group_3_0__1 : rule__Stakeholder__Group_3_0__1__Impl rule__Stakeholder__Group_3_0__2 ;
    public final void rule__Stakeholder__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:414:1: ( rule__Stakeholder__Group_3_0__1__Impl rule__Stakeholder__Group_3_0__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:415:2: rule__Stakeholder__Group_3_0__1__Impl rule__Stakeholder__Group_3_0__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__1__Impl_in_rule__Stakeholder__Group_3_0__1765);
            rule__Stakeholder__Group_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__2_in_rule__Stakeholder__Group_3_0__1768);
            rule__Stakeholder__Group_3_0__2();

            state._fsp--;


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:422:1: rule__Stakeholder__Group_3_0__1__Impl : ( 'name' ) ;
    public final void rule__Stakeholder__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:426:1: ( ( 'name' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:427:1: ( 'name' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:427:1: ( 'name' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:428:1: 'name'
            {
             before(grammarAccess.getStakeholderAccess().getNameKeyword_3_0_1()); 
            match(input,16,FOLLOW_16_in_rule__Stakeholder__Group_3_0__1__Impl796); 
             after(grammarAccess.getStakeholderAccess().getNameKeyword_3_0_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Stakeholder__Group_3_0__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:441:1: rule__Stakeholder__Group_3_0__2 : rule__Stakeholder__Group_3_0__2__Impl ;
    public final void rule__Stakeholder__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:445:1: ( rule__Stakeholder__Group_3_0__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:446:2: rule__Stakeholder__Group_3_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__2__Impl_in_rule__Stakeholder__Group_3_0__2827);
            rule__Stakeholder__Group_3_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_0__2"


    // $ANTLR start "rule__Stakeholder__Group_3_0__2__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:452:1: rule__Stakeholder__Group_3_0__2__Impl : ( ( rule__Stakeholder__FullnameAssignment_3_0_2 ) ) ;
    public final void rule__Stakeholder__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:456:1: ( ( ( rule__Stakeholder__FullnameAssignment_3_0_2 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:457:1: ( ( rule__Stakeholder__FullnameAssignment_3_0_2 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:457:1: ( ( rule__Stakeholder__FullnameAssignment_3_0_2 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:458:1: ( rule__Stakeholder__FullnameAssignment_3_0_2 )
            {
             before(grammarAccess.getStakeholderAccess().getFullnameAssignment_3_0_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:459:1: ( rule__Stakeholder__FullnameAssignment_3_0_2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:459:2: rule__Stakeholder__FullnameAssignment_3_0_2
            {
            pushFollow(FOLLOW_rule__Stakeholder__FullnameAssignment_3_0_2_in_rule__Stakeholder__Group_3_0__2__Impl854);
            rule__Stakeholder__FullnameAssignment_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getFullnameAssignment_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_0__2__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:475:1: rule__Stakeholder__Group_3_1__0 : rule__Stakeholder__Group_3_1__0__Impl rule__Stakeholder__Group_3_1__1 ;
    public final void rule__Stakeholder__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:479:1: ( rule__Stakeholder__Group_3_1__0__Impl rule__Stakeholder__Group_3_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:480:2: rule__Stakeholder__Group_3_1__0__Impl rule__Stakeholder__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_1__0__Impl_in_rule__Stakeholder__Group_3_1__0890);
            rule__Stakeholder__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_1__1_in_rule__Stakeholder__Group_3_1__0893);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:487:1: rule__Stakeholder__Group_3_1__0__Impl : ( 'title' ) ;
    public final void rule__Stakeholder__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:491:1: ( ( 'title' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:492:1: ( 'title' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:492:1: ( 'title' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:493:1: 'title'
            {
             before(grammarAccess.getStakeholderAccess().getTitleKeyword_3_1_0()); 
            match(input,17,FOLLOW_17_in_rule__Stakeholder__Group_3_1__0__Impl921); 
             after(grammarAccess.getStakeholderAccess().getTitleKeyword_3_1_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:506:1: rule__Stakeholder__Group_3_1__1 : rule__Stakeholder__Group_3_1__1__Impl ;
    public final void rule__Stakeholder__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:510:1: ( rule__Stakeholder__Group_3_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:511:2: rule__Stakeholder__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_1__1__Impl_in_rule__Stakeholder__Group_3_1__1952);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:517:1: rule__Stakeholder__Group_3_1__1__Impl : ( ( rule__Stakeholder__TitleAssignment_3_1_1 ) ) ;
    public final void rule__Stakeholder__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:521:1: ( ( ( rule__Stakeholder__TitleAssignment_3_1_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:522:1: ( ( rule__Stakeholder__TitleAssignment_3_1_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:522:1: ( ( rule__Stakeholder__TitleAssignment_3_1_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:523:1: ( rule__Stakeholder__TitleAssignment_3_1_1 )
            {
             before(grammarAccess.getStakeholderAccess().getTitleAssignment_3_1_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:524:1: ( rule__Stakeholder__TitleAssignment_3_1_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:524:2: rule__Stakeholder__TitleAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__TitleAssignment_3_1_1_in_rule__Stakeholder__Group_3_1__1__Impl979);
            rule__Stakeholder__TitleAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getTitleAssignment_3_1_1()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:538:1: rule__Stakeholder__Group_3_2__0 : rule__Stakeholder__Group_3_2__0__Impl rule__Stakeholder__Group_3_2__1 ;
    public final void rule__Stakeholder__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:542:1: ( rule__Stakeholder__Group_3_2__0__Impl rule__Stakeholder__Group_3_2__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:543:2: rule__Stakeholder__Group_3_2__0__Impl rule__Stakeholder__Group_3_2__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_2__0__Impl_in_rule__Stakeholder__Group_3_2__01013);
            rule__Stakeholder__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_2__1_in_rule__Stakeholder__Group_3_2__01016);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:550:1: rule__Stakeholder__Group_3_2__0__Impl : ( 'description' ) ;
    public final void rule__Stakeholder__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:554:1: ( ( 'description' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:555:1: ( 'description' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:555:1: ( 'description' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:556:1: 'description'
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionKeyword_3_2_0()); 
            match(input,18,FOLLOW_18_in_rule__Stakeholder__Group_3_2__0__Impl1044); 
             after(grammarAccess.getStakeholderAccess().getDescriptionKeyword_3_2_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:569:1: rule__Stakeholder__Group_3_2__1 : rule__Stakeholder__Group_3_2__1__Impl ;
    public final void rule__Stakeholder__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:573:1: ( rule__Stakeholder__Group_3_2__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:574:2: rule__Stakeholder__Group_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_2__1__Impl_in_rule__Stakeholder__Group_3_2__11075);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:580:1: rule__Stakeholder__Group_3_2__1__Impl : ( ( rule__Stakeholder__DescriptionAssignment_3_2_1 ) ) ;
    public final void rule__Stakeholder__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:584:1: ( ( ( rule__Stakeholder__DescriptionAssignment_3_2_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:585:1: ( ( rule__Stakeholder__DescriptionAssignment_3_2_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:585:1: ( ( rule__Stakeholder__DescriptionAssignment_3_2_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:586:1: ( rule__Stakeholder__DescriptionAssignment_3_2_1 )
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionAssignment_3_2_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:587:1: ( rule__Stakeholder__DescriptionAssignment_3_2_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:587:2: rule__Stakeholder__DescriptionAssignment_3_2_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__DescriptionAssignment_3_2_1_in_rule__Stakeholder__Group_3_2__1__Impl1102);
            rule__Stakeholder__DescriptionAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getDescriptionAssignment_3_2_1()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:601:1: rule__Stakeholder__Group_3_3__0 : rule__Stakeholder__Group_3_3__0__Impl rule__Stakeholder__Group_3_3__1 ;
    public final void rule__Stakeholder__Group_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:605:1: ( rule__Stakeholder__Group_3_3__0__Impl rule__Stakeholder__Group_3_3__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:606:2: rule__Stakeholder__Group_3_3__0__Impl rule__Stakeholder__Group_3_3__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_3__0__Impl_in_rule__Stakeholder__Group_3_3__01136);
            rule__Stakeholder__Group_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_3__1_in_rule__Stakeholder__Group_3_3__01139);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:613:1: rule__Stakeholder__Group_3_3__0__Impl : ( 'role' ) ;
    public final void rule__Stakeholder__Group_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:617:1: ( ( 'role' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:618:1: ( 'role' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:618:1: ( 'role' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:619:1: 'role'
            {
             before(grammarAccess.getStakeholderAccess().getRoleKeyword_3_3_0()); 
            match(input,19,FOLLOW_19_in_rule__Stakeholder__Group_3_3__0__Impl1167); 
             after(grammarAccess.getStakeholderAccess().getRoleKeyword_3_3_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:632:1: rule__Stakeholder__Group_3_3__1 : rule__Stakeholder__Group_3_3__1__Impl ;
    public final void rule__Stakeholder__Group_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:636:1: ( rule__Stakeholder__Group_3_3__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:637:2: rule__Stakeholder__Group_3_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_3__1__Impl_in_rule__Stakeholder__Group_3_3__11198);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:643:1: rule__Stakeholder__Group_3_3__1__Impl : ( ( rule__Stakeholder__RoleAssignment_3_3_1 ) ) ;
    public final void rule__Stakeholder__Group_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:647:1: ( ( ( rule__Stakeholder__RoleAssignment_3_3_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:648:1: ( ( rule__Stakeholder__RoleAssignment_3_3_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:648:1: ( ( rule__Stakeholder__RoleAssignment_3_3_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:649:1: ( rule__Stakeholder__RoleAssignment_3_3_1 )
            {
             before(grammarAccess.getStakeholderAccess().getRoleAssignment_3_3_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:650:1: ( rule__Stakeholder__RoleAssignment_3_3_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:650:2: rule__Stakeholder__RoleAssignment_3_3_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__RoleAssignment_3_3_1_in_rule__Stakeholder__Group_3_3__1__Impl1225);
            rule__Stakeholder__RoleAssignment_3_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getRoleAssignment_3_3_1()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:664:1: rule__Stakeholder__Group_3_4__0 : rule__Stakeholder__Group_3_4__0__Impl rule__Stakeholder__Group_3_4__1 ;
    public final void rule__Stakeholder__Group_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:668:1: ( rule__Stakeholder__Group_3_4__0__Impl rule__Stakeholder__Group_3_4__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:669:2: rule__Stakeholder__Group_3_4__0__Impl rule__Stakeholder__Group_3_4__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_4__0__Impl_in_rule__Stakeholder__Group_3_4__01259);
            rule__Stakeholder__Group_3_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_4__1_in_rule__Stakeholder__Group_3_4__01262);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:676:1: rule__Stakeholder__Group_3_4__0__Impl : ( 'email' ) ;
    public final void rule__Stakeholder__Group_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:680:1: ( ( 'email' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:681:1: ( 'email' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:681:1: ( 'email' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:682:1: 'email'
            {
             before(grammarAccess.getStakeholderAccess().getEmailKeyword_3_4_0()); 
            match(input,20,FOLLOW_20_in_rule__Stakeholder__Group_3_4__0__Impl1290); 
             after(grammarAccess.getStakeholderAccess().getEmailKeyword_3_4_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:695:1: rule__Stakeholder__Group_3_4__1 : rule__Stakeholder__Group_3_4__1__Impl ;
    public final void rule__Stakeholder__Group_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:699:1: ( rule__Stakeholder__Group_3_4__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:700:2: rule__Stakeholder__Group_3_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_4__1__Impl_in_rule__Stakeholder__Group_3_4__11321);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:706:1: rule__Stakeholder__Group_3_4__1__Impl : ( ( rule__Stakeholder__EmailAssignment_3_4_1 ) ) ;
    public final void rule__Stakeholder__Group_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:710:1: ( ( ( rule__Stakeholder__EmailAssignment_3_4_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:711:1: ( ( rule__Stakeholder__EmailAssignment_3_4_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:711:1: ( ( rule__Stakeholder__EmailAssignment_3_4_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:712:1: ( rule__Stakeholder__EmailAssignment_3_4_1 )
            {
             before(grammarAccess.getStakeholderAccess().getEmailAssignment_3_4_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:713:1: ( rule__Stakeholder__EmailAssignment_3_4_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:713:2: rule__Stakeholder__EmailAssignment_3_4_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__EmailAssignment_3_4_1_in_rule__Stakeholder__Group_3_4__1__Impl1348);
            rule__Stakeholder__EmailAssignment_3_4_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getEmailAssignment_3_4_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Stakeholder__Group_3_5__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:727:1: rule__Stakeholder__Group_3_5__0 : rule__Stakeholder__Group_3_5__0__Impl rule__Stakeholder__Group_3_5__1 ;
    public final void rule__Stakeholder__Group_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:731:1: ( rule__Stakeholder__Group_3_5__0__Impl rule__Stakeholder__Group_3_5__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:732:2: rule__Stakeholder__Group_3_5__0__Impl rule__Stakeholder__Group_3_5__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_5__0__Impl_in_rule__Stakeholder__Group_3_5__01382);
            rule__Stakeholder__Group_3_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_3_5__1_in_rule__Stakeholder__Group_3_5__01385);
            rule__Stakeholder__Group_3_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_5__0"


    // $ANTLR start "rule__Stakeholder__Group_3_5__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:739:1: rule__Stakeholder__Group_3_5__0__Impl : ( 'phone' ) ;
    public final void rule__Stakeholder__Group_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:743:1: ( ( 'phone' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:744:1: ( 'phone' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:744:1: ( 'phone' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:745:1: 'phone'
            {
             before(grammarAccess.getStakeholderAccess().getPhoneKeyword_3_5_0()); 
            match(input,21,FOLLOW_21_in_rule__Stakeholder__Group_3_5__0__Impl1413); 
             after(grammarAccess.getStakeholderAccess().getPhoneKeyword_3_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_5__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_3_5__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:758:1: rule__Stakeholder__Group_3_5__1 : rule__Stakeholder__Group_3_5__1__Impl ;
    public final void rule__Stakeholder__Group_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:762:1: ( rule__Stakeholder__Group_3_5__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:763:2: rule__Stakeholder__Group_3_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_3_5__1__Impl_in_rule__Stakeholder__Group_3_5__11444);
            rule__Stakeholder__Group_3_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_5__1"


    // $ANTLR start "rule__Stakeholder__Group_3_5__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:769:1: rule__Stakeholder__Group_3_5__1__Impl : ( ( rule__Stakeholder__PhoneAssignment_3_5_1 ) ) ;
    public final void rule__Stakeholder__Group_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:773:1: ( ( ( rule__Stakeholder__PhoneAssignment_3_5_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:774:1: ( ( rule__Stakeholder__PhoneAssignment_3_5_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:774:1: ( ( rule__Stakeholder__PhoneAssignment_3_5_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:775:1: ( rule__Stakeholder__PhoneAssignment_3_5_1 )
            {
             before(grammarAccess.getStakeholderAccess().getPhoneAssignment_3_5_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:776:1: ( rule__Stakeholder__PhoneAssignment_3_5_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:776:2: rule__Stakeholder__PhoneAssignment_3_5_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__PhoneAssignment_3_5_1_in_rule__Stakeholder__Group_3_5__1__Impl1471);
            rule__Stakeholder__PhoneAssignment_3_5_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getPhoneAssignment_3_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_3_5__1__Impl"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:791:1: rule__Stakeholder__UnorderedGroup_3 : ( rule__Stakeholder__UnorderedGroup_3__0 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_3());
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:796:1: ( ( rule__Stakeholder__UnorderedGroup_3__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:797:2: ( rule__Stakeholder__UnorderedGroup_3__0 )?
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:797:2: ( rule__Stakeholder__UnorderedGroup_3__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( LA2_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt2=1;
            }
            else if ( LA2_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt2=1;
            }
            else if ( LA2_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt2=1;
            }
            else if ( LA2_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt2=1;
            }
            else if ( LA2_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt2=1;
            }
            else if ( LA2_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:797:2: rule__Stakeholder__UnorderedGroup_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__0_in_rule__Stakeholder__UnorderedGroup_31506);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:807:1: rule__Stakeholder__UnorderedGroup_3__Impl : ( ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_5__0 ) ) ) ) ) ;
    public final void rule__Stakeholder__UnorderedGroup_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:812:1: ( ( ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_5__0 ) ) ) ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:813:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_5__0 ) ) ) ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:813:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_3_5__0 ) ) ) ) )
            int alt3=6;
            int LA3_0 = input.LA(1);

            if ( LA3_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt3=1;
            }
            else if ( LA3_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt3=2;
            }
            else if ( LA3_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt3=3;
            }
            else if ( LA3_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt3=4;
            }
            else if ( LA3_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt3=5;
            }
            else if ( LA3_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                alt3=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:815:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:815:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:816:5: {...}? => ( ( ( rule__Stakeholder__Group_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:816:108: ( ( ( rule__Stakeholder__Group_3_0__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:817:6: ( ( rule__Stakeholder__Group_3_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:823:6: ( ( rule__Stakeholder__Group_3_0__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:825:7: ( rule__Stakeholder__Group_3_0__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:826:7: ( rule__Stakeholder__Group_3_0__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:826:8: rule__Stakeholder__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_0__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1593);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:832:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:832:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:833:5: {...}? => ( ( ( rule__Stakeholder__Group_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:833:108: ( ( ( rule__Stakeholder__Group_3_1__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:834:6: ( ( rule__Stakeholder__Group_3_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:840:6: ( ( rule__Stakeholder__Group_3_1__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:842:7: ( rule__Stakeholder__Group_3_1__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:843:7: ( rule__Stakeholder__Group_3_1__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:843:8: rule__Stakeholder__Group_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_1__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1684);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:849:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:849:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:850:5: {...}? => ( ( ( rule__Stakeholder__Group_3_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:850:108: ( ( ( rule__Stakeholder__Group_3_2__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:851:6: ( ( rule__Stakeholder__Group_3_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:857:6: ( ( rule__Stakeholder__Group_3_2__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:859:7: ( rule__Stakeholder__Group_3_2__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_2()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:860:7: ( rule__Stakeholder__Group_3_2__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:860:8: rule__Stakeholder__Group_3_2__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_2__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1775);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:866:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:866:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:867:5: {...}? => ( ( ( rule__Stakeholder__Group_3_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:867:108: ( ( ( rule__Stakeholder__Group_3_3__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:868:6: ( ( rule__Stakeholder__Group_3_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:874:6: ( ( rule__Stakeholder__Group_3_3__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:876:7: ( rule__Stakeholder__Group_3_3__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_3()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:877:7: ( rule__Stakeholder__Group_3_3__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:877:8: rule__Stakeholder__Group_3_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_3__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1866);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:883:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:883:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:884:5: {...}? => ( ( ( rule__Stakeholder__Group_3_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:884:108: ( ( ( rule__Stakeholder__Group_3_4__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:885:6: ( ( rule__Stakeholder__Group_3_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:891:6: ( ( rule__Stakeholder__Group_3_4__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:893:7: ( rule__Stakeholder__Group_3_4__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_4()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:894:7: ( rule__Stakeholder__Group_3_4__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:894:8: rule__Stakeholder__Group_3_4__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_4__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1957);
                    rule__Stakeholder__Group_3_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_3_4()); 

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:900:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_5__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:900:4: ({...}? => ( ( ( rule__Stakeholder__Group_3_5__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:901:5: {...}? => ( ( ( rule__Stakeholder__Group_3_5__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:901:108: ( ( ( rule__Stakeholder__Group_3_5__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:902:6: ( ( rule__Stakeholder__Group_3_5__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:908:6: ( ( rule__Stakeholder__Group_3_5__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:910:7: ( rule__Stakeholder__Group_3_5__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_3_5()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:911:7: ( rule__Stakeholder__Group_3_5__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:911:8: rule__Stakeholder__Group_3_5__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_3_5__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2048);
                    rule__Stakeholder__Group_3_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_3_5()); 

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:926:1: rule__Stakeholder__UnorderedGroup_3__0 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__1 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:930:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__1 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:931:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__1 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__02107);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:932:2: ( rule__Stakeholder__UnorderedGroup_3__1 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( LA4_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt4=1;
            }
            else if ( LA4_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt4=1;
            }
            else if ( LA4_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt4=1;
            }
            else if ( LA4_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt4=1;
            }
            else if ( LA4_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt4=1;
            }
            else if ( LA4_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:932:2: rule__Stakeholder__UnorderedGroup_3__1
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__1_in_rule__Stakeholder__UnorderedGroup_3__02110);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:939:1: rule__Stakeholder__UnorderedGroup_3__1 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__2 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:943:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__2 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:944:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__2 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__12135);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:945:2: ( rule__Stakeholder__UnorderedGroup_3__2 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( LA5_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt5=1;
            }
            else if ( LA5_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt5=1;
            }
            else if ( LA5_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt5=1;
            }
            else if ( LA5_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt5=1;
            }
            else if ( LA5_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt5=1;
            }
            else if ( LA5_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:945:2: rule__Stakeholder__UnorderedGroup_3__2
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__2_in_rule__Stakeholder__UnorderedGroup_3__12138);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:952:1: rule__Stakeholder__UnorderedGroup_3__2 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__3 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:956:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__3 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:957:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__3 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__22163);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:958:2: ( rule__Stakeholder__UnorderedGroup_3__3 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( LA6_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt6=1;
            }
            else if ( LA6_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt6=1;
            }
            else if ( LA6_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt6=1;
            }
            else if ( LA6_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt6=1;
            }
            else if ( LA6_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt6=1;
            }
            else if ( LA6_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:958:2: rule__Stakeholder__UnorderedGroup_3__3
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__3_in_rule__Stakeholder__UnorderedGroup_3__22166);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:965:1: rule__Stakeholder__UnorderedGroup_3__3 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__4 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:969:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__4 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:970:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__4 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__32191);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:971:2: ( rule__Stakeholder__UnorderedGroup_3__4 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt7=1;
            }
            else if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt7=1;
            }
            else if ( LA7_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt7=1;
            }
            else if ( LA7_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt7=1;
            }
            else if ( LA7_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:971:2: rule__Stakeholder__UnorderedGroup_3__4
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__4_in_rule__Stakeholder__UnorderedGroup_3__32194);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:978:1: rule__Stakeholder__UnorderedGroup_3__4 : rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__5 )? ;
    public final void rule__Stakeholder__UnorderedGroup_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:982:1: ( rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__5 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:983:2: rule__Stakeholder__UnorderedGroup_3__Impl ( rule__Stakeholder__UnorderedGroup_3__5 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__42219);
            rule__Stakeholder__UnorderedGroup_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:984:2: ( rule__Stakeholder__UnorderedGroup_3__5 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 3) ) {
                alt8=1;
            }
            else if ( LA8_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 4) ) {
                alt8=1;
            }
            else if ( LA8_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_3(), 5) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:984:2: rule__Stakeholder__UnorderedGroup_3__5
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__5_in_rule__Stakeholder__UnorderedGroup_3__42222);
                    rule__Stakeholder__UnorderedGroup_3__5();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3__4"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_3__5"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:991:1: rule__Stakeholder__UnorderedGroup_3__5 : rule__Stakeholder__UnorderedGroup_3__Impl ;
    public final void rule__Stakeholder__UnorderedGroup_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:995:1: ( rule__Stakeholder__UnorderedGroup_3__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:996:2: rule__Stakeholder__UnorderedGroup_3__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__52247);
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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_3__5"


    // $ANTLR start "rule__Organization__NameAssignment_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1015:1: rule__Organization__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Organization__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1019:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1020:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1020:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1021:1: RULE_ID
            {
             before(grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12287); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1030:1: rule__Organization__StakeholderAssignment_2 : ( ruleStakeholder ) ;
    public final void rule__Organization__StakeholderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1034:1: ( ( ruleStakeholder ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1035:1: ( ruleStakeholder )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1035:1: ( ruleStakeholder )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1036:1: ruleStakeholder
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22318);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1045:1: rule__Stakeholder__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stakeholder__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1049:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1050:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1050:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1051:1: RULE_ID
            {
             before(grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12349); 
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


    // $ANTLR start "rule__Stakeholder__FullnameAssignment_3_0_2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1060:1: rule__Stakeholder__FullnameAssignment_3_0_2 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__FullnameAssignment_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1064:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1065:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1065:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1066:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getFullnameSTRINGTerminalRuleCall_3_0_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__FullnameAssignment_3_0_22380); 
             after(grammarAccess.getStakeholderAccess().getFullnameSTRINGTerminalRuleCall_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__FullnameAssignment_3_0_2"


    // $ANTLR start "rule__Stakeholder__TitleAssignment_3_1_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1075:1: rule__Stakeholder__TitleAssignment_3_1_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__TitleAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1079:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1080:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1080:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1081:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_3_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__TitleAssignment_3_1_12411); 
             after(grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__TitleAssignment_3_1_1"


    // $ANTLR start "rule__Stakeholder__DescriptionAssignment_3_2_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1090:1: rule__Stakeholder__DescriptionAssignment_3_2_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__DescriptionAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1094:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1095:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1095:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1096:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_3_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__DescriptionAssignment_3_2_12442); 
             after(grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__DescriptionAssignment_3_2_1"


    // $ANTLR start "rule__Stakeholder__RoleAssignment_3_3_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1105:1: rule__Stakeholder__RoleAssignment_3_3_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__RoleAssignment_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1109:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1110:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1110:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1111:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_3_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__RoleAssignment_3_3_12473); 
             after(grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_3_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__RoleAssignment_3_3_1"


    // $ANTLR start "rule__Stakeholder__EmailAssignment_3_4_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1120:1: rule__Stakeholder__EmailAssignment_3_4_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__EmailAssignment_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1124:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1125:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1125:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1126:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_3_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__EmailAssignment_3_4_12504); 
             after(grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_3_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__EmailAssignment_3_4_1"


    // $ANTLR start "rule__Stakeholder__PhoneAssignment_3_5_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1135:1: rule__Stakeholder__PhoneAssignment_3_5_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__PhoneAssignment_3_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1139:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1140:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1140:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1141:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_3_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__PhoneAssignment_3_5_12535); 
             after(grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_3_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__PhoneAssignment_3_5_1"

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
    public static final BitSet FOLLOW_rule__Stakeholder__Group__2__Impl_in_rule__Stakeholder__Group__2512 = new BitSet(new long[]{0x00000000003E8000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__3_in_rule__Stakeholder__Group__2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Stakeholder__Group__2__Impl543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__3__Impl_in_rule__Stakeholder__Group__3574 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__4_in_rule__Stakeholder__Group__3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3_in_rule__Stakeholder__Group__3__Impl604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group__4__Impl_in_rule__Stakeholder__Group__4634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Stakeholder__Group__4__Impl662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__0__Impl_in_rule__Stakeholder__Group_3_0__0703 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__1_in_rule__Stakeholder__Group_3_0__0706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Stakeholder__Group_3_0__0__Impl734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__1__Impl_in_rule__Stakeholder__Group_3_0__1765 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__2_in_rule__Stakeholder__Group_3_0__1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Stakeholder__Group_3_0__1__Impl796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__2__Impl_in_rule__Stakeholder__Group_3_0__2827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__FullnameAssignment_3_0_2_in_rule__Stakeholder__Group_3_0__2__Impl854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_1__0__Impl_in_rule__Stakeholder__Group_3_1__0890 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_1__1_in_rule__Stakeholder__Group_3_1__0893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Stakeholder__Group_3_1__0__Impl921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_1__1__Impl_in_rule__Stakeholder__Group_3_1__1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__TitleAssignment_3_1_1_in_rule__Stakeholder__Group_3_1__1__Impl979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_2__0__Impl_in_rule__Stakeholder__Group_3_2__01013 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_2__1_in_rule__Stakeholder__Group_3_2__01016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Stakeholder__Group_3_2__0__Impl1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_2__1__Impl_in_rule__Stakeholder__Group_3_2__11075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__DescriptionAssignment_3_2_1_in_rule__Stakeholder__Group_3_2__1__Impl1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_3__0__Impl_in_rule__Stakeholder__Group_3_3__01136 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_3__1_in_rule__Stakeholder__Group_3_3__01139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Stakeholder__Group_3_3__0__Impl1167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_3__1__Impl_in_rule__Stakeholder__Group_3_3__11198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__RoleAssignment_3_3_1_in_rule__Stakeholder__Group_3_3__1__Impl1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_4__0__Impl_in_rule__Stakeholder__Group_3_4__01259 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_4__1_in_rule__Stakeholder__Group_3_4__01262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Stakeholder__Group_3_4__0__Impl1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_4__1__Impl_in_rule__Stakeholder__Group_3_4__11321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__EmailAssignment_3_4_1_in_rule__Stakeholder__Group_3_4__1__Impl1348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_5__0__Impl_in_rule__Stakeholder__Group_3_5__01382 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_5__1_in_rule__Stakeholder__Group_3_5__01385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Stakeholder__Group_3_5__0__Impl1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_5__1__Impl_in_rule__Stakeholder__Group_3_5__11444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__PhoneAssignment_3_5_1_in_rule__Stakeholder__Group_3_5__1__Impl1471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__0_in_rule__Stakeholder__UnorderedGroup_31506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_0__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_1__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_2__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_3__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_4__0_in_rule__Stakeholder__UnorderedGroup_3__Impl1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_3_5__0_in_rule__Stakeholder__UnorderedGroup_3__Impl2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__02107 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__1_in_rule__Stakeholder__UnorderedGroup_3__02110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__12135 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__2_in_rule__Stakeholder__UnorderedGroup_3__12138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__22163 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__3_in_rule__Stakeholder__UnorderedGroup_3__22166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__32191 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__4_in_rule__Stakeholder__UnorderedGroup_3__32194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__42219 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__5_in_rule__Stakeholder__UnorderedGroup_3__42222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_3__Impl_in_rule__Stakeholder__UnorderedGroup_3__52247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__FullnameAssignment_3_0_22380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__TitleAssignment_3_1_12411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__DescriptionAssignment_3_2_12442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__RoleAssignment_3_3_12473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__EmailAssignment_3_4_12504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__PhoneAssignment_3_5_12535 = new BitSet(new long[]{0x0000000000000002L});

}
