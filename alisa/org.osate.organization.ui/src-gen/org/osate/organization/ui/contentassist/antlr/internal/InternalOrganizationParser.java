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
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:421:1: rule__Stakeholder__Group_2_1_0__0__Impl : ( 'full' ) ;
    public final void rule__Stakeholder__Group_2_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:425:1: ( ( 'full' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:426:1: ( 'full' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:426:1: ( 'full' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:427:1: 'full'
            {
             before(grammarAccess.getStakeholderAccess().getFullKeyword_2_1_0_0()); 
            match(input,15,FOLLOW_15_in_rule__Stakeholder__Group_2_1_0__0__Impl794); 
             after(grammarAccess.getStakeholderAccess().getFullKeyword_2_1_0_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:440:1: rule__Stakeholder__Group_2_1_0__1 : rule__Stakeholder__Group_2_1_0__1__Impl rule__Stakeholder__Group_2_1_0__2 ;
    public final void rule__Stakeholder__Group_2_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:444:1: ( rule__Stakeholder__Group_2_1_0__1__Impl rule__Stakeholder__Group_2_1_0__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:445:2: rule__Stakeholder__Group_2_1_0__1__Impl rule__Stakeholder__Group_2_1_0__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__1__Impl_in_rule__Stakeholder__Group_2_1_0__1825);
            rule__Stakeholder__Group_2_1_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__2_in_rule__Stakeholder__Group_2_1_0__1828);
            rule__Stakeholder__Group_2_1_0__2();

            state._fsp--;


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:452:1: rule__Stakeholder__Group_2_1_0__1__Impl : ( 'name' ) ;
    public final void rule__Stakeholder__Group_2_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:456:1: ( ( 'name' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:457:1: ( 'name' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:457:1: ( 'name' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:458:1: 'name'
            {
             before(grammarAccess.getStakeholderAccess().getNameKeyword_2_1_0_1()); 
            match(input,16,FOLLOW_16_in_rule__Stakeholder__Group_2_1_0__1__Impl856); 
             after(grammarAccess.getStakeholderAccess().getNameKeyword_2_1_0_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Stakeholder__Group_2_1_0__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:471:1: rule__Stakeholder__Group_2_1_0__2 : rule__Stakeholder__Group_2_1_0__2__Impl rule__Stakeholder__Group_2_1_0__3 ;
    public final void rule__Stakeholder__Group_2_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:475:1: ( rule__Stakeholder__Group_2_1_0__2__Impl rule__Stakeholder__Group_2_1_0__3 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:476:2: rule__Stakeholder__Group_2_1_0__2__Impl rule__Stakeholder__Group_2_1_0__3
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__2__Impl_in_rule__Stakeholder__Group_2_1_0__2887);
            rule__Stakeholder__Group_2_1_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__3_in_rule__Stakeholder__Group_2_1_0__2890);
            rule__Stakeholder__Group_2_1_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_0__2"


    // $ANTLR start "rule__Stakeholder__Group_2_1_0__2__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:483:1: rule__Stakeholder__Group_2_1_0__2__Impl : ( ( rule__Stakeholder__FirstAssignment_2_1_0_2 ) ) ;
    public final void rule__Stakeholder__Group_2_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:487:1: ( ( ( rule__Stakeholder__FirstAssignment_2_1_0_2 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:488:1: ( ( rule__Stakeholder__FirstAssignment_2_1_0_2 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:488:1: ( ( rule__Stakeholder__FirstAssignment_2_1_0_2 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:489:1: ( rule__Stakeholder__FirstAssignment_2_1_0_2 )
            {
             before(grammarAccess.getStakeholderAccess().getFirstAssignment_2_1_0_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:490:1: ( rule__Stakeholder__FirstAssignment_2_1_0_2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:490:2: rule__Stakeholder__FirstAssignment_2_1_0_2
            {
            pushFollow(FOLLOW_rule__Stakeholder__FirstAssignment_2_1_0_2_in_rule__Stakeholder__Group_2_1_0__2__Impl917);
            rule__Stakeholder__FirstAssignment_2_1_0_2();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getFirstAssignment_2_1_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_0__2__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_0__3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:500:1: rule__Stakeholder__Group_2_1_0__3 : rule__Stakeholder__Group_2_1_0__3__Impl ;
    public final void rule__Stakeholder__Group_2_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:504:1: ( rule__Stakeholder__Group_2_1_0__3__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:505:2: rule__Stakeholder__Group_2_1_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__3__Impl_in_rule__Stakeholder__Group_2_1_0__3947);
            rule__Stakeholder__Group_2_1_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_0__3"


    // $ANTLR start "rule__Stakeholder__Group_2_1_0__3__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:511:1: rule__Stakeholder__Group_2_1_0__3__Impl : ( ( rule__Stakeholder__LastAssignment_2_1_0_3 ) ) ;
    public final void rule__Stakeholder__Group_2_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:515:1: ( ( ( rule__Stakeholder__LastAssignment_2_1_0_3 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:516:1: ( ( rule__Stakeholder__LastAssignment_2_1_0_3 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:516:1: ( ( rule__Stakeholder__LastAssignment_2_1_0_3 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:517:1: ( rule__Stakeholder__LastAssignment_2_1_0_3 )
            {
             before(grammarAccess.getStakeholderAccess().getLastAssignment_2_1_0_3()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:518:1: ( rule__Stakeholder__LastAssignment_2_1_0_3 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:518:2: rule__Stakeholder__LastAssignment_2_1_0_3
            {
            pushFollow(FOLLOW_rule__Stakeholder__LastAssignment_2_1_0_3_in_rule__Stakeholder__Group_2_1_0__3__Impl974);
            rule__Stakeholder__LastAssignment_2_1_0_3();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getLastAssignment_2_1_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_0__3__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:536:1: rule__Stakeholder__Group_2_1_1__0 : rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1 ;
    public final void rule__Stakeholder__Group_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:540:1: ( rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:541:2: rule__Stakeholder__Group_2_1_1__0__Impl rule__Stakeholder__Group_2_1_1__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__0__Impl_in_rule__Stakeholder__Group_2_1_1__01012);
            rule__Stakeholder__Group_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__1_in_rule__Stakeholder__Group_2_1_1__01015);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:548:1: rule__Stakeholder__Group_2_1_1__0__Impl : ( 'title' ) ;
    public final void rule__Stakeholder__Group_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:552:1: ( ( 'title' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:553:1: ( 'title' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:553:1: ( 'title' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:554:1: 'title'
            {
             before(grammarAccess.getStakeholderAccess().getTitleKeyword_2_1_1_0()); 
            match(input,17,FOLLOW_17_in_rule__Stakeholder__Group_2_1_1__0__Impl1043); 
             after(grammarAccess.getStakeholderAccess().getTitleKeyword_2_1_1_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:567:1: rule__Stakeholder__Group_2_1_1__1 : rule__Stakeholder__Group_2_1_1__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:571:1: ( rule__Stakeholder__Group_2_1_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:572:2: rule__Stakeholder__Group_2_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__1__Impl_in_rule__Stakeholder__Group_2_1_1__11074);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:578:1: rule__Stakeholder__Group_2_1_1__1__Impl : ( ( rule__Stakeholder__TitleAssignment_2_1_1_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:582:1: ( ( ( rule__Stakeholder__TitleAssignment_2_1_1_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:583:1: ( ( rule__Stakeholder__TitleAssignment_2_1_1_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:583:1: ( ( rule__Stakeholder__TitleAssignment_2_1_1_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:584:1: ( rule__Stakeholder__TitleAssignment_2_1_1_1 )
            {
             before(grammarAccess.getStakeholderAccess().getTitleAssignment_2_1_1_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:585:1: ( rule__Stakeholder__TitleAssignment_2_1_1_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:585:2: rule__Stakeholder__TitleAssignment_2_1_1_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__TitleAssignment_2_1_1_1_in_rule__Stakeholder__Group_2_1_1__1__Impl1101);
            rule__Stakeholder__TitleAssignment_2_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getTitleAssignment_2_1_1_1()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:599:1: rule__Stakeholder__Group_2_1_2__0 : rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1 ;
    public final void rule__Stakeholder__Group_2_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:603:1: ( rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:604:2: rule__Stakeholder__Group_2_1_2__0__Impl rule__Stakeholder__Group_2_1_2__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__0__Impl_in_rule__Stakeholder__Group_2_1_2__01135);
            rule__Stakeholder__Group_2_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__1_in_rule__Stakeholder__Group_2_1_2__01138);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:611:1: rule__Stakeholder__Group_2_1_2__0__Impl : ( 'description' ) ;
    public final void rule__Stakeholder__Group_2_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:615:1: ( ( 'description' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:616:1: ( 'description' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:616:1: ( 'description' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:617:1: 'description'
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionKeyword_2_1_2_0()); 
            match(input,18,FOLLOW_18_in_rule__Stakeholder__Group_2_1_2__0__Impl1166); 
             after(grammarAccess.getStakeholderAccess().getDescriptionKeyword_2_1_2_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:630:1: rule__Stakeholder__Group_2_1_2__1 : rule__Stakeholder__Group_2_1_2__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:634:1: ( rule__Stakeholder__Group_2_1_2__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:635:2: rule__Stakeholder__Group_2_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__1__Impl_in_rule__Stakeholder__Group_2_1_2__11197);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:641:1: rule__Stakeholder__Group_2_1_2__1__Impl : ( ( rule__Stakeholder__DescriptionAssignment_2_1_2_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:645:1: ( ( ( rule__Stakeholder__DescriptionAssignment_2_1_2_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:646:1: ( ( rule__Stakeholder__DescriptionAssignment_2_1_2_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:646:1: ( ( rule__Stakeholder__DescriptionAssignment_2_1_2_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:647:1: ( rule__Stakeholder__DescriptionAssignment_2_1_2_1 )
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionAssignment_2_1_2_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:648:1: ( rule__Stakeholder__DescriptionAssignment_2_1_2_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:648:2: rule__Stakeholder__DescriptionAssignment_2_1_2_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__DescriptionAssignment_2_1_2_1_in_rule__Stakeholder__Group_2_1_2__1__Impl1224);
            rule__Stakeholder__DescriptionAssignment_2_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getDescriptionAssignment_2_1_2_1()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:662:1: rule__Stakeholder__Group_2_1_3__0 : rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1 ;
    public final void rule__Stakeholder__Group_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:666:1: ( rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:667:2: rule__Stakeholder__Group_2_1_3__0__Impl rule__Stakeholder__Group_2_1_3__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__0__Impl_in_rule__Stakeholder__Group_2_1_3__01258);
            rule__Stakeholder__Group_2_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__1_in_rule__Stakeholder__Group_2_1_3__01261);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:674:1: rule__Stakeholder__Group_2_1_3__0__Impl : ( 'role' ) ;
    public final void rule__Stakeholder__Group_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:678:1: ( ( 'role' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:679:1: ( 'role' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:679:1: ( 'role' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:680:1: 'role'
            {
             before(grammarAccess.getStakeholderAccess().getRoleKeyword_2_1_3_0()); 
            match(input,19,FOLLOW_19_in_rule__Stakeholder__Group_2_1_3__0__Impl1289); 
             after(grammarAccess.getStakeholderAccess().getRoleKeyword_2_1_3_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:693:1: rule__Stakeholder__Group_2_1_3__1 : rule__Stakeholder__Group_2_1_3__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:697:1: ( rule__Stakeholder__Group_2_1_3__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:698:2: rule__Stakeholder__Group_2_1_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__1__Impl_in_rule__Stakeholder__Group_2_1_3__11320);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:704:1: rule__Stakeholder__Group_2_1_3__1__Impl : ( ( rule__Stakeholder__RoleAssignment_2_1_3_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:708:1: ( ( ( rule__Stakeholder__RoleAssignment_2_1_3_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:709:1: ( ( rule__Stakeholder__RoleAssignment_2_1_3_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:709:1: ( ( rule__Stakeholder__RoleAssignment_2_1_3_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:710:1: ( rule__Stakeholder__RoleAssignment_2_1_3_1 )
            {
             before(grammarAccess.getStakeholderAccess().getRoleAssignment_2_1_3_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:711:1: ( rule__Stakeholder__RoleAssignment_2_1_3_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:711:2: rule__Stakeholder__RoleAssignment_2_1_3_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__RoleAssignment_2_1_3_1_in_rule__Stakeholder__Group_2_1_3__1__Impl1347);
            rule__Stakeholder__RoleAssignment_2_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getRoleAssignment_2_1_3_1()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:725:1: rule__Stakeholder__Group_2_1_4__0 : rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1 ;
    public final void rule__Stakeholder__Group_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:729:1: ( rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:730:2: rule__Stakeholder__Group_2_1_4__0__Impl rule__Stakeholder__Group_2_1_4__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__0__Impl_in_rule__Stakeholder__Group_2_1_4__01381);
            rule__Stakeholder__Group_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__1_in_rule__Stakeholder__Group_2_1_4__01384);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:737:1: rule__Stakeholder__Group_2_1_4__0__Impl : ( 'email' ) ;
    public final void rule__Stakeholder__Group_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:741:1: ( ( 'email' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:742:1: ( 'email' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:742:1: ( 'email' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:743:1: 'email'
            {
             before(grammarAccess.getStakeholderAccess().getEmailKeyword_2_1_4_0()); 
            match(input,20,FOLLOW_20_in_rule__Stakeholder__Group_2_1_4__0__Impl1412); 
             after(grammarAccess.getStakeholderAccess().getEmailKeyword_2_1_4_0()); 

            }


            }

        }
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:756:1: rule__Stakeholder__Group_2_1_4__1 : rule__Stakeholder__Group_2_1_4__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:760:1: ( rule__Stakeholder__Group_2_1_4__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:761:2: rule__Stakeholder__Group_2_1_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__1__Impl_in_rule__Stakeholder__Group_2_1_4__11443);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:767:1: rule__Stakeholder__Group_2_1_4__1__Impl : ( ( rule__Stakeholder__EmailAssignment_2_1_4_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:771:1: ( ( ( rule__Stakeholder__EmailAssignment_2_1_4_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:772:1: ( ( rule__Stakeholder__EmailAssignment_2_1_4_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:772:1: ( ( rule__Stakeholder__EmailAssignment_2_1_4_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:773:1: ( rule__Stakeholder__EmailAssignment_2_1_4_1 )
            {
             before(grammarAccess.getStakeholderAccess().getEmailAssignment_2_1_4_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:774:1: ( rule__Stakeholder__EmailAssignment_2_1_4_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:774:2: rule__Stakeholder__EmailAssignment_2_1_4_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__EmailAssignment_2_1_4_1_in_rule__Stakeholder__Group_2_1_4__1__Impl1470);
            rule__Stakeholder__EmailAssignment_2_1_4_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getEmailAssignment_2_1_4_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Stakeholder__Group_2_1_5__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:788:1: rule__Stakeholder__Group_2_1_5__0 : rule__Stakeholder__Group_2_1_5__0__Impl rule__Stakeholder__Group_2_1_5__1 ;
    public final void rule__Stakeholder__Group_2_1_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:792:1: ( rule__Stakeholder__Group_2_1_5__0__Impl rule__Stakeholder__Group_2_1_5__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:793:2: rule__Stakeholder__Group_2_1_5__0__Impl rule__Stakeholder__Group_2_1_5__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_5__0__Impl_in_rule__Stakeholder__Group_2_1_5__01504);
            rule__Stakeholder__Group_2_1_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_5__1_in_rule__Stakeholder__Group_2_1_5__01507);
            rule__Stakeholder__Group_2_1_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_5__0"


    // $ANTLR start "rule__Stakeholder__Group_2_1_5__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:800:1: rule__Stakeholder__Group_2_1_5__0__Impl : ( 'phone' ) ;
    public final void rule__Stakeholder__Group_2_1_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:804:1: ( ( 'phone' ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:805:1: ( 'phone' )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:805:1: ( 'phone' )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:806:1: 'phone'
            {
             before(grammarAccess.getStakeholderAccess().getPhoneKeyword_2_1_5_0()); 
            match(input,21,FOLLOW_21_in_rule__Stakeholder__Group_2_1_5__0__Impl1535); 
             after(grammarAccess.getStakeholderAccess().getPhoneKeyword_2_1_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_5__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_2_1_5__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:819:1: rule__Stakeholder__Group_2_1_5__1 : rule__Stakeholder__Group_2_1_5__1__Impl ;
    public final void rule__Stakeholder__Group_2_1_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:823:1: ( rule__Stakeholder__Group_2_1_5__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:824:2: rule__Stakeholder__Group_2_1_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_5__1__Impl_in_rule__Stakeholder__Group_2_1_5__11566);
            rule__Stakeholder__Group_2_1_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_5__1"


    // $ANTLR start "rule__Stakeholder__Group_2_1_5__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:830:1: rule__Stakeholder__Group_2_1_5__1__Impl : ( ( rule__Stakeholder__PhoneAssignment_2_1_5_1 ) ) ;
    public final void rule__Stakeholder__Group_2_1_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:834:1: ( ( ( rule__Stakeholder__PhoneAssignment_2_1_5_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:835:1: ( ( rule__Stakeholder__PhoneAssignment_2_1_5_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:835:1: ( ( rule__Stakeholder__PhoneAssignment_2_1_5_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:836:1: ( rule__Stakeholder__PhoneAssignment_2_1_5_1 )
            {
             before(grammarAccess.getStakeholderAccess().getPhoneAssignment_2_1_5_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:837:1: ( rule__Stakeholder__PhoneAssignment_2_1_5_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:837:2: rule__Stakeholder__PhoneAssignment_2_1_5_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__PhoneAssignment_2_1_5_1_in_rule__Stakeholder__Group_2_1_5__1__Impl1593);
            rule__Stakeholder__PhoneAssignment_2_1_5_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getPhoneAssignment_2_1_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_2_1_5__1__Impl"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:852:1: rule__Stakeholder__UnorderedGroup_2_1 : ( rule__Stakeholder__UnorderedGroup_2_1__0 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1());
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:857:1: ( ( rule__Stakeholder__UnorderedGroup_2_1__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:858:2: ( rule__Stakeholder__UnorderedGroup_2_1__0 )?
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:858:2: ( rule__Stakeholder__UnorderedGroup_2_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( LA3_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt3=1;
            }
            else if ( LA3_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt3=1;
            }
            else if ( LA3_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt3=1;
            }
            else if ( LA3_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt3=1;
            }
            else if ( LA3_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt3=1;
            }
            else if ( LA3_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:858:2: rule__Stakeholder__UnorderedGroup_2_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__0_in_rule__Stakeholder__UnorderedGroup_2_11628);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:868:1: rule__Stakeholder__UnorderedGroup_2_1__Impl : ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_5__0 ) ) ) ) ) ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:873:1: ( ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_5__0 ) ) ) ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:874:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_5__0 ) ) ) ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:874:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_2_1_5__0 ) ) ) ) )
            int alt4=6;
            int LA4_0 = input.LA(1);

            if ( LA4_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt4=1;
            }
            else if ( LA4_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt4=2;
            }
            else if ( LA4_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt4=3;
            }
            else if ( LA4_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt4=4;
            }
            else if ( LA4_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt4=5;
            }
            else if ( LA4_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5) ) {
                alt4=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:876:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:876:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:877:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:877:110: ( ( ( rule__Stakeholder__Group_2_1_0__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:878:6: ( ( rule__Stakeholder__Group_2_1_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:884:6: ( ( rule__Stakeholder__Group_2_1_0__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:886:7: ( rule__Stakeholder__Group_2_1_0__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:887:7: ( rule__Stakeholder__Group_2_1_0__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:887:8: rule__Stakeholder__Group_2_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_0__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1715);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:893:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:893:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:894:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:894:110: ( ( ( rule__Stakeholder__Group_2_1_1__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:895:6: ( ( rule__Stakeholder__Group_2_1_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:901:6: ( ( rule__Stakeholder__Group_2_1_1__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:903:7: ( rule__Stakeholder__Group_2_1_1__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:904:7: ( rule__Stakeholder__Group_2_1_1__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:904:8: rule__Stakeholder__Group_2_1_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_1__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1806);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:910:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:910:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:911:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:911:110: ( ( ( rule__Stakeholder__Group_2_1_2__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:912:6: ( ( rule__Stakeholder__Group_2_1_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:918:6: ( ( rule__Stakeholder__Group_2_1_2__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:920:7: ( rule__Stakeholder__Group_2_1_2__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_2()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:921:7: ( rule__Stakeholder__Group_2_1_2__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:921:8: rule__Stakeholder__Group_2_1_2__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_2__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1897);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:927:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:927:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:928:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:928:110: ( ( ( rule__Stakeholder__Group_2_1_3__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:929:6: ( ( rule__Stakeholder__Group_2_1_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:935:6: ( ( rule__Stakeholder__Group_2_1_3__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:937:7: ( rule__Stakeholder__Group_2_1_3__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_3()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:938:7: ( rule__Stakeholder__Group_2_1_3__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:938:8: rule__Stakeholder__Group_2_1_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_3__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1988);
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
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:944:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:944:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:945:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:945:110: ( ( ( rule__Stakeholder__Group_2_1_4__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:946:6: ( ( rule__Stakeholder__Group_2_1_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:952:6: ( ( rule__Stakeholder__Group_2_1_4__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:954:7: ( rule__Stakeholder__Group_2_1_4__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_4()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:955:7: ( rule__Stakeholder__Group_2_1_4__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:955:8: rule__Stakeholder__Group_2_1_4__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_4__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2079);
                    rule__Stakeholder__Group_2_1_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_2_1_4()); 

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:961:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_5__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:961:4: ({...}? => ( ( ( rule__Stakeholder__Group_2_1_5__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:962:5: {...}? => ( ( ( rule__Stakeholder__Group_2_1_5__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_2_1__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:962:110: ( ( ( rule__Stakeholder__Group_2_1_5__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:963:6: ( ( rule__Stakeholder__Group_2_1_5__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:969:6: ( ( rule__Stakeholder__Group_2_1_5__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:971:7: ( rule__Stakeholder__Group_2_1_5__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_2_1_5()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:972:7: ( rule__Stakeholder__Group_2_1_5__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:972:8: rule__Stakeholder__Group_2_1_5__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_2_1_5__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2170);
                    rule__Stakeholder__Group_2_1_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_2_1_5()); 

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:987:1: rule__Stakeholder__UnorderedGroup_2_1__0 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:991:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:992:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__1 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__02229);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:993:2: ( rule__Stakeholder__UnorderedGroup_2_1__1 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( LA5_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt5=1;
            }
            else if ( LA5_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt5=1;
            }
            else if ( LA5_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt5=1;
            }
            else if ( LA5_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt5=1;
            }
            else if ( LA5_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt5=1;
            }
            else if ( LA5_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:993:2: rule__Stakeholder__UnorderedGroup_2_1__1
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__1_in_rule__Stakeholder__UnorderedGroup_2_1__02232);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1000:1: rule__Stakeholder__UnorderedGroup_2_1__1 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1004:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1005:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__2 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__12257);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1006:2: ( rule__Stakeholder__UnorderedGroup_2_1__2 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( LA6_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt6=1;
            }
            else if ( LA6_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt6=1;
            }
            else if ( LA6_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt6=1;
            }
            else if ( LA6_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt6=1;
            }
            else if ( LA6_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt6=1;
            }
            else if ( LA6_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1006:2: rule__Stakeholder__UnorderedGroup_2_1__2
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__2_in_rule__Stakeholder__UnorderedGroup_2_1__12260);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1013:1: rule__Stakeholder__UnorderedGroup_2_1__2 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1017:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1018:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__3 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__22285);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1019:2: ( rule__Stakeholder__UnorderedGroup_2_1__3 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt7=1;
            }
            else if ( LA7_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt7=1;
            }
            else if ( LA7_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt7=1;
            }
            else if ( LA7_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt7=1;
            }
            else if ( LA7_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1019:2: rule__Stakeholder__UnorderedGroup_2_1__3
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__3_in_rule__Stakeholder__UnorderedGroup_2_1__22288);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1026:1: rule__Stakeholder__UnorderedGroup_2_1__3 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1030:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1031:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__4 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__32313);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1032:2: ( rule__Stakeholder__UnorderedGroup_2_1__4 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt8=1;
            }
            else if ( LA8_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt8=1;
            }
            else if ( LA8_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1032:2: rule__Stakeholder__UnorderedGroup_2_1__4
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__4_in_rule__Stakeholder__UnorderedGroup_2_1__32316);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1039:1: rule__Stakeholder__UnorderedGroup_2_1__4 : rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__5 )? ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1043:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__5 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1044:2: rule__Stakeholder__UnorderedGroup_2_1__Impl ( rule__Stakeholder__UnorderedGroup_2_1__5 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__42341);
            rule__Stakeholder__UnorderedGroup_2_1__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1045:2: ( rule__Stakeholder__UnorderedGroup_2_1__5 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( LA9_0 ==15 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 1) ) {
                alt9=1;
            }
            else if ( LA9_0 ==18 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 2) ) {
                alt9=1;
            }
            else if ( LA9_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 3) ) {
                alt9=1;
            }
            else if ( LA9_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 4) ) {
                alt9=1;
            }
            else if ( LA9_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_2_1(), 5) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1045:2: rule__Stakeholder__UnorderedGroup_2_1__5
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__5_in_rule__Stakeholder__UnorderedGroup_2_1__42344);
                    rule__Stakeholder__UnorderedGroup_2_1__5();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1__4"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_2_1__5"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1052:1: rule__Stakeholder__UnorderedGroup_2_1__5 : rule__Stakeholder__UnorderedGroup_2_1__Impl ;
    public final void rule__Stakeholder__UnorderedGroup_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1056:1: ( rule__Stakeholder__UnorderedGroup_2_1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1057:2: rule__Stakeholder__UnorderedGroup_2_1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__52369);
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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_2_1__5"


    // $ANTLR start "rule__Organization__NameAssignment_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1076:1: rule__Organization__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Organization__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1080:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1081:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1081:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1082:1: RULE_ID
            {
             before(grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12409); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1091:1: rule__Organization__StakeholderAssignment_2 : ( ruleStakeholder ) ;
    public final void rule__Organization__StakeholderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1095:1: ( ( ruleStakeholder ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1096:1: ( ruleStakeholder )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1096:1: ( ruleStakeholder )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1097:1: ruleStakeholder
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22440);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1106:1: rule__Stakeholder__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Stakeholder__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1110:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1111:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1111:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1112:1: RULE_ID
            {
             before(grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12471); 
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


    // $ANTLR start "rule__Stakeholder__FirstAssignment_2_1_0_2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1121:1: rule__Stakeholder__FirstAssignment_2_1_0_2 : ( RULE_ID ) ;
    public final void rule__Stakeholder__FirstAssignment_2_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1125:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1126:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1126:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1127:1: RULE_ID
            {
             before(grammarAccess.getStakeholderAccess().getFirstIDTerminalRuleCall_2_1_0_2_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stakeholder__FirstAssignment_2_1_0_22502); 
             after(grammarAccess.getStakeholderAccess().getFirstIDTerminalRuleCall_2_1_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__FirstAssignment_2_1_0_2"


    // $ANTLR start "rule__Stakeholder__LastAssignment_2_1_0_3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1136:1: rule__Stakeholder__LastAssignment_2_1_0_3 : ( RULE_ID ) ;
    public final void rule__Stakeholder__LastAssignment_2_1_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1140:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1141:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1141:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1142:1: RULE_ID
            {
             before(grammarAccess.getStakeholderAccess().getLastIDTerminalRuleCall_2_1_0_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stakeholder__LastAssignment_2_1_0_32533); 
             after(grammarAccess.getStakeholderAccess().getLastIDTerminalRuleCall_2_1_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__LastAssignment_2_1_0_3"


    // $ANTLR start "rule__Stakeholder__TitleAssignment_2_1_1_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1151:1: rule__Stakeholder__TitleAssignment_2_1_1_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__TitleAssignment_2_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1155:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1156:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1156:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1157:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_2_1_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__TitleAssignment_2_1_1_12564); 
             after(grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__TitleAssignment_2_1_1_1"


    // $ANTLR start "rule__Stakeholder__DescriptionAssignment_2_1_2_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1166:1: rule__Stakeholder__DescriptionAssignment_2_1_2_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__DescriptionAssignment_2_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1170:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1171:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1171:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1172:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_2_1_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__DescriptionAssignment_2_1_2_12595); 
             after(grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_2_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__DescriptionAssignment_2_1_2_1"


    // $ANTLR start "rule__Stakeholder__RoleAssignment_2_1_3_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1181:1: rule__Stakeholder__RoleAssignment_2_1_3_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__RoleAssignment_2_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1185:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1186:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1186:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1187:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_2_1_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__RoleAssignment_2_1_3_12626); 
             after(grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_2_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__RoleAssignment_2_1_3_1"


    // $ANTLR start "rule__Stakeholder__EmailAssignment_2_1_4_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1196:1: rule__Stakeholder__EmailAssignment_2_1_4_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__EmailAssignment_2_1_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1200:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1201:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1201:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1202:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_2_1_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__EmailAssignment_2_1_4_12657); 
             after(grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_2_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__EmailAssignment_2_1_4_1"


    // $ANTLR start "rule__Stakeholder__PhoneAssignment_2_1_5_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1211:1: rule__Stakeholder__PhoneAssignment_2_1_5_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__PhoneAssignment_2_1_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1215:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1216:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1216:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganization.g:1217:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_2_1_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__PhoneAssignment_2_1_5_12688); 
             after(grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_2_1_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__PhoneAssignment_2_1_5_1"

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
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__0__Impl_in_rule__Stakeholder__Group_2__0576 = new BitSet(new long[]{0x00000000003E8000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__1_in_rule__Stakeholder__Group_2__0579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Stakeholder__Group_2__0__Impl607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__1__Impl_in_rule__Stakeholder__Group_2__1638 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__2_in_rule__Stakeholder__Group_2__1641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1_in_rule__Stakeholder__Group_2__1__Impl668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2__2__Impl_in_rule__Stakeholder__Group_2__2698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Stakeholder__Group_2__2__Impl726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__0__Impl_in_rule__Stakeholder__Group_2_1_0__0763 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__1_in_rule__Stakeholder__Group_2_1_0__0766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Stakeholder__Group_2_1_0__0__Impl794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__1__Impl_in_rule__Stakeholder__Group_2_1_0__1825 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__2_in_rule__Stakeholder__Group_2_1_0__1828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Stakeholder__Group_2_1_0__1__Impl856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__2__Impl_in_rule__Stakeholder__Group_2_1_0__2887 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__3_in_rule__Stakeholder__Group_2_1_0__2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__FirstAssignment_2_1_0_2_in_rule__Stakeholder__Group_2_1_0__2__Impl917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__3__Impl_in_rule__Stakeholder__Group_2_1_0__3947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__LastAssignment_2_1_0_3_in_rule__Stakeholder__Group_2_1_0__3__Impl974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__0__Impl_in_rule__Stakeholder__Group_2_1_1__01012 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__1_in_rule__Stakeholder__Group_2_1_1__01015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Stakeholder__Group_2_1_1__0__Impl1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__1__Impl_in_rule__Stakeholder__Group_2_1_1__11074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__TitleAssignment_2_1_1_1_in_rule__Stakeholder__Group_2_1_1__1__Impl1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__0__Impl_in_rule__Stakeholder__Group_2_1_2__01135 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__1_in_rule__Stakeholder__Group_2_1_2__01138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Stakeholder__Group_2_1_2__0__Impl1166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__1__Impl_in_rule__Stakeholder__Group_2_1_2__11197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__DescriptionAssignment_2_1_2_1_in_rule__Stakeholder__Group_2_1_2__1__Impl1224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__0__Impl_in_rule__Stakeholder__Group_2_1_3__01258 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__1_in_rule__Stakeholder__Group_2_1_3__01261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Stakeholder__Group_2_1_3__0__Impl1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__1__Impl_in_rule__Stakeholder__Group_2_1_3__11320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__RoleAssignment_2_1_3_1_in_rule__Stakeholder__Group_2_1_3__1__Impl1347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__0__Impl_in_rule__Stakeholder__Group_2_1_4__01381 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__1_in_rule__Stakeholder__Group_2_1_4__01384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Stakeholder__Group_2_1_4__0__Impl1412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__1__Impl_in_rule__Stakeholder__Group_2_1_4__11443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__EmailAssignment_2_1_4_1_in_rule__Stakeholder__Group_2_1_4__1__Impl1470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_5__0__Impl_in_rule__Stakeholder__Group_2_1_5__01504 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_5__1_in_rule__Stakeholder__Group_2_1_5__01507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Stakeholder__Group_2_1_5__0__Impl1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_5__1__Impl_in_rule__Stakeholder__Group_2_1_5__11566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__PhoneAssignment_2_1_5_1_in_rule__Stakeholder__Group_2_1_5__1__Impl1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__0_in_rule__Stakeholder__UnorderedGroup_2_11628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_0__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_1__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_2__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_3__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_4__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_2_1_5__0_in_rule__Stakeholder__UnorderedGroup_2_1__Impl2170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__02229 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__1_in_rule__Stakeholder__UnorderedGroup_2_1__02232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__12257 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__2_in_rule__Stakeholder__UnorderedGroup_2_1__12260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__22285 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__3_in_rule__Stakeholder__UnorderedGroup_2_1__22288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__32313 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__4_in_rule__Stakeholder__UnorderedGroup_2_1__32316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__42341 = new BitSet(new long[]{0x00000000003E8002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__5_in_rule__Stakeholder__UnorderedGroup_2_1__42344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_2_1__Impl_in_rule__Stakeholder__UnorderedGroup_2_1__52369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_12409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_22440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_12471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stakeholder__FirstAssignment_2_1_0_22502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stakeholder__LastAssignment_2_1_0_32533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__TitleAssignment_2_1_1_12564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__DescriptionAssignment_2_1_2_12595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__RoleAssignment_2_1_3_12626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__EmailAssignment_2_1_4_12657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__PhoneAssignment_2_1_5_12688 = new BitSet(new long[]{0x0000000000000002L});

}
