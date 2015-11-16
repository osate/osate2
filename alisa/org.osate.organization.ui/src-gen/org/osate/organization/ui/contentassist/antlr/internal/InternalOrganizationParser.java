package org.osate.organization.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

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

/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
@SuppressWarnings("all")
public class InternalOrganizationParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Organization", "Description", "Stakeholder", "Supervisor", "Email", "Phone", "Title", "Full", "Name", "Role", "FullStop", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Organization=4;
    public static final int Description=5;
    public static final int Email=8;
    public static final int RULE_STRING=19;
    public static final int Full=11;
    public static final int Name=12;
    public static final int RULE_SL_COMMENT=21;
    public static final int Stakeholder=6;
    public static final int Phone=9;
    public static final int EOF=-1;
    public static final int RightSquareBracket=16;
    public static final int Supervisor=7;
    public static final int FullStop=14;
    public static final int RULE_ID=17;
    public static final int RULE_WS=22;
    public static final int Title=10;
    public static final int RULE_ANY_OTHER=23;
    public static final int Role=13;
    public static final int RULE_INT=18;
    public static final int RULE_ML_COMMENT=20;
    public static final int LeftSquareBracket=15;

    // delegates
    // delegators


        public InternalOrganizationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalOrganizationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalOrganizationParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g"; }


     
     	private OrganizationGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
    		tokenNameToValue.put("Full", "'full'");
    		tokenNameToValue.put("Name", "'name'");
    		tokenNameToValue.put("Role", "'role'");
    		tokenNameToValue.put("Email", "'email'");
    		tokenNameToValue.put("Phone", "'phone'");
    		tokenNameToValue.put("Title", "'title'");
    		tokenNameToValue.put("Supervisor", "'supervisor'");
    		tokenNameToValue.put("Description", "'description'");
    		tokenNameToValue.put("Stakeholder", "'stakeholder'");
    		tokenNameToValue.put("Organization", "'organization'");
     	}
     	
        public void setGrammarAccess(OrganizationGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRuleOrganization"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:88:1: entryRuleOrganization : ruleOrganization EOF ;
    public final void entryRuleOrganization() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:89:1: ( ruleOrganization EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:90:1: ruleOrganization EOF
            {
             before(grammarAccess.getOrganizationRule()); 
            pushFollow(FOLLOW_ruleOrganization_in_entryRuleOrganization54);
            ruleOrganization();

            state._fsp--;

             after(grammarAccess.getOrganizationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrganization61); 

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:97:1: ruleOrganization : ( ( rule__Organization__Group__0 ) ) ;
    public final void ruleOrganization() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:101:5: ( ( ( rule__Organization__Group__0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:102:1: ( ( rule__Organization__Group__0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:102:1: ( ( rule__Organization__Group__0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:103:1: ( rule__Organization__Group__0 )
            {
             before(grammarAccess.getOrganizationAccess().getGroup()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:104:1: ( rule__Organization__Group__0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:104:2: rule__Organization__Group__0
            {
            pushFollow(FOLLOW_rule__Organization__Group__0_in_ruleOrganization91);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:116:1: entryRuleStakeholder : ruleStakeholder EOF ;
    public final void entryRuleStakeholder() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:117:1: ( ruleStakeholder EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:118:1: ruleStakeholder EOF
            {
             before(grammarAccess.getStakeholderRule()); 
            pushFollow(FOLLOW_ruleStakeholder_in_entryRuleStakeholder118);
            ruleStakeholder();

            state._fsp--;

             after(grammarAccess.getStakeholderRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStakeholder125); 

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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:125:1: ruleStakeholder : ( ( rule__Stakeholder__UnorderedGroup ) ) ;
    public final void ruleStakeholder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:129:5: ( ( ( rule__Stakeholder__UnorderedGroup ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:130:1: ( ( rule__Stakeholder__UnorderedGroup ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:130:1: ( ( rule__Stakeholder__UnorderedGroup ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:131:1: ( rule__Stakeholder__UnorderedGroup )
            {
             before(grammarAccess.getStakeholderAccess().getUnorderedGroup()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:132:1: ( rule__Stakeholder__UnorderedGroup )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:132:2: rule__Stakeholder__UnorderedGroup
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_in_ruleStakeholder155);
            rule__Stakeholder__UnorderedGroup();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getUnorderedGroup()); 

            }


            }

        }
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


    // $ANTLR start "entryRuleQID"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:144:1: entryRuleQID : ruleQID EOF ;
    public final void entryRuleQID() throws RecognitionException {
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:145:1: ( ruleQID EOF )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:146:1: ruleQID EOF
            {
             before(grammarAccess.getQIDRule()); 
            pushFollow(FOLLOW_ruleQID_in_entryRuleQID182);
            ruleQID();

            state._fsp--;

             after(grammarAccess.getQIDRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQID189); 

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
    // $ANTLR end "entryRuleQID"


    // $ANTLR start "ruleQID"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:153:1: ruleQID : ( ( rule__QID__Group__0 ) ) ;
    public final void ruleQID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:157:5: ( ( ( rule__QID__Group__0 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:158:1: ( ( rule__QID__Group__0 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:158:1: ( ( rule__QID__Group__0 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:159:1: ( rule__QID__Group__0 )
            {
             before(grammarAccess.getQIDAccess().getGroup()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:160:1: ( rule__QID__Group__0 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:160:2: rule__QID__Group__0
            {
            pushFollow(FOLLOW_rule__QID__Group__0_in_ruleQID219);
            rule__QID__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQIDAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQID"


    // $ANTLR start "rule__Organization__Group__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:174:1: rule__Organization__Group__0 : rule__Organization__Group__0__Impl rule__Organization__Group__1 ;
    public final void rule__Organization__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:178:1: ( rule__Organization__Group__0__Impl rule__Organization__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:179:2: rule__Organization__Group__0__Impl rule__Organization__Group__1
            {
            pushFollow(FOLLOW_rule__Organization__Group__0__Impl_in_rule__Organization__Group__0253);
            rule__Organization__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Organization__Group__1_in_rule__Organization__Group__0256);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:186:1: rule__Organization__Group__0__Impl : ( Organization ) ;
    public final void rule__Organization__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:190:1: ( ( Organization ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:191:1: ( Organization )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:191:1: ( Organization )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:192:1: Organization
            {
             before(grammarAccess.getOrganizationAccess().getOrganizationKeyword_0()); 
            match(input,Organization,FOLLOW_Organization_in_rule__Organization__Group__0__Impl284); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:205:1: rule__Organization__Group__1 : rule__Organization__Group__1__Impl rule__Organization__Group__2 ;
    public final void rule__Organization__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:209:1: ( rule__Organization__Group__1__Impl rule__Organization__Group__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:210:2: rule__Organization__Group__1__Impl rule__Organization__Group__2
            {
            pushFollow(FOLLOW_rule__Organization__Group__1__Impl_in_rule__Organization__Group__1315);
            rule__Organization__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Organization__Group__2_in_rule__Organization__Group__1318);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:217:1: rule__Organization__Group__1__Impl : ( ( rule__Organization__NameAssignment_1 ) ) ;
    public final void rule__Organization__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:221:1: ( ( ( rule__Organization__NameAssignment_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:222:1: ( ( rule__Organization__NameAssignment_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:222:1: ( ( rule__Organization__NameAssignment_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:223:1: ( rule__Organization__NameAssignment_1 )
            {
             before(grammarAccess.getOrganizationAccess().getNameAssignment_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:224:1: ( rule__Organization__NameAssignment_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:224:2: rule__Organization__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Organization__NameAssignment_1_in_rule__Organization__Group__1__Impl345);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:234:1: rule__Organization__Group__2 : rule__Organization__Group__2__Impl ;
    public final void rule__Organization__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:238:1: ( rule__Organization__Group__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:239:2: rule__Organization__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Organization__Group__2__Impl_in_rule__Organization__Group__2375);
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:245:1: rule__Organization__Group__2__Impl : ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) ) ;
    public final void rule__Organization__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:249:1: ( ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:250:1: ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:250:1: ( ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:251:1: ( ( rule__Organization__StakeholderAssignment_2 ) ) ( ( rule__Organization__StakeholderAssignment_2 )* )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:251:1: ( ( rule__Organization__StakeholderAssignment_2 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:252:1: ( rule__Organization__StakeholderAssignment_2 )
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:253:1: ( rule__Organization__StakeholderAssignment_2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:253:2: rule__Organization__StakeholderAssignment_2
            {
            pushFollow(FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl404);
            rule__Organization__StakeholderAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 

            }

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:256:1: ( ( rule__Organization__StakeholderAssignment_2 )* )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:257:1: ( rule__Organization__StakeholderAssignment_2 )*
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderAssignment_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:258:1: ( rule__Organization__StakeholderAssignment_2 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Stakeholder && LA1_0<=Supervisor)||LA1_0==RightSquareBracket) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:258:2: rule__Organization__StakeholderAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl416);
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


    // $ANTLR start "rule__Stakeholder__Group_0__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:275:1: rule__Stakeholder__Group_0__0 : rule__Stakeholder__Group_0__0__Impl rule__Stakeholder__Group_0__1 ;
    public final void rule__Stakeholder__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:279:1: ( rule__Stakeholder__Group_0__0__Impl rule__Stakeholder__Group_0__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:280:2: rule__Stakeholder__Group_0__0__Impl rule__Stakeholder__Group_0__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0__0__Impl_in_rule__Stakeholder__Group_0__0455);
            rule__Stakeholder__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0__1_in_rule__Stakeholder__Group_0__0458);
            rule__Stakeholder__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0__0"


    // $ANTLR start "rule__Stakeholder__Group_0__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:287:1: rule__Stakeholder__Group_0__0__Impl : ( Stakeholder ) ;
    public final void rule__Stakeholder__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:291:1: ( ( Stakeholder ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:292:1: ( Stakeholder )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:292:1: ( Stakeholder )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:293:1: Stakeholder
            {
             before(grammarAccess.getStakeholderAccess().getStakeholderKeyword_0_0()); 
            match(input,Stakeholder,FOLLOW_Stakeholder_in_rule__Stakeholder__Group_0__0__Impl486); 
             after(grammarAccess.getStakeholderAccess().getStakeholderKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:306:1: rule__Stakeholder__Group_0__1 : rule__Stakeholder__Group_0__1__Impl rule__Stakeholder__Group_0__2 ;
    public final void rule__Stakeholder__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:310:1: ( rule__Stakeholder__Group_0__1__Impl rule__Stakeholder__Group_0__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:311:2: rule__Stakeholder__Group_0__1__Impl rule__Stakeholder__Group_0__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0__1__Impl_in_rule__Stakeholder__Group_0__1517);
            rule__Stakeholder__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0__2_in_rule__Stakeholder__Group_0__1520);
            rule__Stakeholder__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0__1"


    // $ANTLR start "rule__Stakeholder__Group_0__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:318:1: rule__Stakeholder__Group_0__1__Impl : ( ( rule__Stakeholder__NameAssignment_0_1 ) ) ;
    public final void rule__Stakeholder__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:322:1: ( ( ( rule__Stakeholder__NameAssignment_0_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:323:1: ( ( rule__Stakeholder__NameAssignment_0_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:323:1: ( ( rule__Stakeholder__NameAssignment_0_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:324:1: ( rule__Stakeholder__NameAssignment_0_1 )
            {
             before(grammarAccess.getStakeholderAccess().getNameAssignment_0_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:325:1: ( rule__Stakeholder__NameAssignment_0_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:325:2: rule__Stakeholder__NameAssignment_0_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__NameAssignment_0_1_in_rule__Stakeholder__Group_0__1__Impl547);
            rule__Stakeholder__NameAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getNameAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:335:1: rule__Stakeholder__Group_0__2 : rule__Stakeholder__Group_0__2__Impl rule__Stakeholder__Group_0__3 ;
    public final void rule__Stakeholder__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:339:1: ( rule__Stakeholder__Group_0__2__Impl rule__Stakeholder__Group_0__3 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:340:2: rule__Stakeholder__Group_0__2__Impl rule__Stakeholder__Group_0__3
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0__2__Impl_in_rule__Stakeholder__Group_0__2577);
            rule__Stakeholder__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0__3_in_rule__Stakeholder__Group_0__2580);
            rule__Stakeholder__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0__2"


    // $ANTLR start "rule__Stakeholder__Group_0__2__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:347:1: rule__Stakeholder__Group_0__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__Stakeholder__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:351:1: ( ( LeftSquareBracket ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:352:1: ( LeftSquareBracket )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:352:1: ( LeftSquareBracket )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:353:1: LeftSquareBracket
            {
             before(grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_0_2()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__Stakeholder__Group_0__2__Impl608); 
             after(grammarAccess.getStakeholderAccess().getLeftSquareBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0__2__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0__3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:366:1: rule__Stakeholder__Group_0__3 : rule__Stakeholder__Group_0__3__Impl ;
    public final void rule__Stakeholder__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:370:1: ( rule__Stakeholder__Group_0__3__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:371:2: rule__Stakeholder__Group_0__3__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0__3__Impl_in_rule__Stakeholder__Group_0__3639);
            rule__Stakeholder__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0__3"


    // $ANTLR start "rule__Stakeholder__Group_0__3__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:377:1: rule__Stakeholder__Group_0__3__Impl : ( ( rule__Stakeholder__UnorderedGroup_0_3 ) ) ;
    public final void rule__Stakeholder__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:381:1: ( ( ( rule__Stakeholder__UnorderedGroup_0_3 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:382:1: ( ( rule__Stakeholder__UnorderedGroup_0_3 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:382:1: ( ( rule__Stakeholder__UnorderedGroup_0_3 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:383:1: ( rule__Stakeholder__UnorderedGroup_0_3 )
            {
             before(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:384:1: ( rule__Stakeholder__UnorderedGroup_0_3 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:384:2: rule__Stakeholder__UnorderedGroup_0_3
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3_in_rule__Stakeholder__Group_0__3__Impl666);
            rule__Stakeholder__UnorderedGroup_0_3();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0__3__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_0__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:402:1: rule__Stakeholder__Group_0_3_0__0 : rule__Stakeholder__Group_0_3_0__0__Impl rule__Stakeholder__Group_0_3_0__1 ;
    public final void rule__Stakeholder__Group_0_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:406:1: ( rule__Stakeholder__Group_0_3_0__0__Impl rule__Stakeholder__Group_0_3_0__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:407:2: rule__Stakeholder__Group_0_3_0__0__Impl rule__Stakeholder__Group_0_3_0__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_0__0__Impl_in_rule__Stakeholder__Group_0_3_0__0704);
            rule__Stakeholder__Group_0_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_0__1_in_rule__Stakeholder__Group_0_3_0__0707);
            rule__Stakeholder__Group_0_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_0__0"


    // $ANTLR start "rule__Stakeholder__Group_0_3_0__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:414:1: rule__Stakeholder__Group_0_3_0__0__Impl : ( Full ) ;
    public final void rule__Stakeholder__Group_0_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:418:1: ( ( Full ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:419:1: ( Full )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:419:1: ( Full )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:420:1: Full
            {
             before(grammarAccess.getStakeholderAccess().getFullKeyword_0_3_0_0()); 
            match(input,Full,FOLLOW_Full_in_rule__Stakeholder__Group_0_3_0__0__Impl735); 
             after(grammarAccess.getStakeholderAccess().getFullKeyword_0_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_0__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_0__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:433:1: rule__Stakeholder__Group_0_3_0__1 : rule__Stakeholder__Group_0_3_0__1__Impl rule__Stakeholder__Group_0_3_0__2 ;
    public final void rule__Stakeholder__Group_0_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:437:1: ( rule__Stakeholder__Group_0_3_0__1__Impl rule__Stakeholder__Group_0_3_0__2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:438:2: rule__Stakeholder__Group_0_3_0__1__Impl rule__Stakeholder__Group_0_3_0__2
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_0__1__Impl_in_rule__Stakeholder__Group_0_3_0__1766);
            rule__Stakeholder__Group_0_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_0__2_in_rule__Stakeholder__Group_0_3_0__1769);
            rule__Stakeholder__Group_0_3_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_0__1"


    // $ANTLR start "rule__Stakeholder__Group_0_3_0__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:445:1: rule__Stakeholder__Group_0_3_0__1__Impl : ( Name ) ;
    public final void rule__Stakeholder__Group_0_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:449:1: ( ( Name ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:450:1: ( Name )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:450:1: ( Name )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:451:1: Name
            {
             before(grammarAccess.getStakeholderAccess().getNameKeyword_0_3_0_1()); 
            match(input,Name,FOLLOW_Name_in_rule__Stakeholder__Group_0_3_0__1__Impl797); 
             after(grammarAccess.getStakeholderAccess().getNameKeyword_0_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_0__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_0__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:464:1: rule__Stakeholder__Group_0_3_0__2 : rule__Stakeholder__Group_0_3_0__2__Impl ;
    public final void rule__Stakeholder__Group_0_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:468:1: ( rule__Stakeholder__Group_0_3_0__2__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:469:2: rule__Stakeholder__Group_0_3_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_0__2__Impl_in_rule__Stakeholder__Group_0_3_0__2828);
            rule__Stakeholder__Group_0_3_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_0__2"


    // $ANTLR start "rule__Stakeholder__Group_0_3_0__2__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:475:1: rule__Stakeholder__Group_0_3_0__2__Impl : ( ( rule__Stakeholder__FullnameAssignment_0_3_0_2 ) ) ;
    public final void rule__Stakeholder__Group_0_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:479:1: ( ( ( rule__Stakeholder__FullnameAssignment_0_3_0_2 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:480:1: ( ( rule__Stakeholder__FullnameAssignment_0_3_0_2 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:480:1: ( ( rule__Stakeholder__FullnameAssignment_0_3_0_2 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:481:1: ( rule__Stakeholder__FullnameAssignment_0_3_0_2 )
            {
             before(grammarAccess.getStakeholderAccess().getFullnameAssignment_0_3_0_2()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:482:1: ( rule__Stakeholder__FullnameAssignment_0_3_0_2 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:482:2: rule__Stakeholder__FullnameAssignment_0_3_0_2
            {
            pushFollow(FOLLOW_rule__Stakeholder__FullnameAssignment_0_3_0_2_in_rule__Stakeholder__Group_0_3_0__2__Impl855);
            rule__Stakeholder__FullnameAssignment_0_3_0_2();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getFullnameAssignment_0_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_0__2__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:498:1: rule__Stakeholder__Group_0_3_1__0 : rule__Stakeholder__Group_0_3_1__0__Impl rule__Stakeholder__Group_0_3_1__1 ;
    public final void rule__Stakeholder__Group_0_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:502:1: ( rule__Stakeholder__Group_0_3_1__0__Impl rule__Stakeholder__Group_0_3_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:503:2: rule__Stakeholder__Group_0_3_1__0__Impl rule__Stakeholder__Group_0_3_1__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_1__0__Impl_in_rule__Stakeholder__Group_0_3_1__0891);
            rule__Stakeholder__Group_0_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_1__1_in_rule__Stakeholder__Group_0_3_1__0894);
            rule__Stakeholder__Group_0_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_1__0"


    // $ANTLR start "rule__Stakeholder__Group_0_3_1__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:510:1: rule__Stakeholder__Group_0_3_1__0__Impl : ( Title ) ;
    public final void rule__Stakeholder__Group_0_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:514:1: ( ( Title ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:515:1: ( Title )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:515:1: ( Title )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:516:1: Title
            {
             before(grammarAccess.getStakeholderAccess().getTitleKeyword_0_3_1_0()); 
            match(input,Title,FOLLOW_Title_in_rule__Stakeholder__Group_0_3_1__0__Impl922); 
             after(grammarAccess.getStakeholderAccess().getTitleKeyword_0_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_1__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_1__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:529:1: rule__Stakeholder__Group_0_3_1__1 : rule__Stakeholder__Group_0_3_1__1__Impl ;
    public final void rule__Stakeholder__Group_0_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:533:1: ( rule__Stakeholder__Group_0_3_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:534:2: rule__Stakeholder__Group_0_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_1__1__Impl_in_rule__Stakeholder__Group_0_3_1__1953);
            rule__Stakeholder__Group_0_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_1__1"


    // $ANTLR start "rule__Stakeholder__Group_0_3_1__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:540:1: rule__Stakeholder__Group_0_3_1__1__Impl : ( ( rule__Stakeholder__TitleAssignment_0_3_1_1 ) ) ;
    public final void rule__Stakeholder__Group_0_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:544:1: ( ( ( rule__Stakeholder__TitleAssignment_0_3_1_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:545:1: ( ( rule__Stakeholder__TitleAssignment_0_3_1_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:545:1: ( ( rule__Stakeholder__TitleAssignment_0_3_1_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:546:1: ( rule__Stakeholder__TitleAssignment_0_3_1_1 )
            {
             before(grammarAccess.getStakeholderAccess().getTitleAssignment_0_3_1_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:547:1: ( rule__Stakeholder__TitleAssignment_0_3_1_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:547:2: rule__Stakeholder__TitleAssignment_0_3_1_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__TitleAssignment_0_3_1_1_in_rule__Stakeholder__Group_0_3_1__1__Impl980);
            rule__Stakeholder__TitleAssignment_0_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getTitleAssignment_0_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_1__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_2__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:561:1: rule__Stakeholder__Group_0_3_2__0 : rule__Stakeholder__Group_0_3_2__0__Impl rule__Stakeholder__Group_0_3_2__1 ;
    public final void rule__Stakeholder__Group_0_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:565:1: ( rule__Stakeholder__Group_0_3_2__0__Impl rule__Stakeholder__Group_0_3_2__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:566:2: rule__Stakeholder__Group_0_3_2__0__Impl rule__Stakeholder__Group_0_3_2__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_2__0__Impl_in_rule__Stakeholder__Group_0_3_2__01014);
            rule__Stakeholder__Group_0_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_2__1_in_rule__Stakeholder__Group_0_3_2__01017);
            rule__Stakeholder__Group_0_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_2__0"


    // $ANTLR start "rule__Stakeholder__Group_0_3_2__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:573:1: rule__Stakeholder__Group_0_3_2__0__Impl : ( Description ) ;
    public final void rule__Stakeholder__Group_0_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:577:1: ( ( Description ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:578:1: ( Description )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:578:1: ( Description )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:579:1: Description
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionKeyword_0_3_2_0()); 
            match(input,Description,FOLLOW_Description_in_rule__Stakeholder__Group_0_3_2__0__Impl1045); 
             after(grammarAccess.getStakeholderAccess().getDescriptionKeyword_0_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_2__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_2__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:592:1: rule__Stakeholder__Group_0_3_2__1 : rule__Stakeholder__Group_0_3_2__1__Impl ;
    public final void rule__Stakeholder__Group_0_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:596:1: ( rule__Stakeholder__Group_0_3_2__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:597:2: rule__Stakeholder__Group_0_3_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_2__1__Impl_in_rule__Stakeholder__Group_0_3_2__11076);
            rule__Stakeholder__Group_0_3_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_2__1"


    // $ANTLR start "rule__Stakeholder__Group_0_3_2__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:603:1: rule__Stakeholder__Group_0_3_2__1__Impl : ( ( rule__Stakeholder__DescriptionAssignment_0_3_2_1 ) ) ;
    public final void rule__Stakeholder__Group_0_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:607:1: ( ( ( rule__Stakeholder__DescriptionAssignment_0_3_2_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:608:1: ( ( rule__Stakeholder__DescriptionAssignment_0_3_2_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:608:1: ( ( rule__Stakeholder__DescriptionAssignment_0_3_2_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:609:1: ( rule__Stakeholder__DescriptionAssignment_0_3_2_1 )
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionAssignment_0_3_2_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:610:1: ( rule__Stakeholder__DescriptionAssignment_0_3_2_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:610:2: rule__Stakeholder__DescriptionAssignment_0_3_2_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__DescriptionAssignment_0_3_2_1_in_rule__Stakeholder__Group_0_3_2__1__Impl1103);
            rule__Stakeholder__DescriptionAssignment_0_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getDescriptionAssignment_0_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_2__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_3__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:624:1: rule__Stakeholder__Group_0_3_3__0 : rule__Stakeholder__Group_0_3_3__0__Impl rule__Stakeholder__Group_0_3_3__1 ;
    public final void rule__Stakeholder__Group_0_3_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:628:1: ( rule__Stakeholder__Group_0_3_3__0__Impl rule__Stakeholder__Group_0_3_3__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:629:2: rule__Stakeholder__Group_0_3_3__0__Impl rule__Stakeholder__Group_0_3_3__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_3__0__Impl_in_rule__Stakeholder__Group_0_3_3__01137);
            rule__Stakeholder__Group_0_3_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_3__1_in_rule__Stakeholder__Group_0_3_3__01140);
            rule__Stakeholder__Group_0_3_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_3__0"


    // $ANTLR start "rule__Stakeholder__Group_0_3_3__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:636:1: rule__Stakeholder__Group_0_3_3__0__Impl : ( Role ) ;
    public final void rule__Stakeholder__Group_0_3_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:640:1: ( ( Role ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:641:1: ( Role )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:641:1: ( Role )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:642:1: Role
            {
             before(grammarAccess.getStakeholderAccess().getRoleKeyword_0_3_3_0()); 
            match(input,Role,FOLLOW_Role_in_rule__Stakeholder__Group_0_3_3__0__Impl1168); 
             after(grammarAccess.getStakeholderAccess().getRoleKeyword_0_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_3__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_3__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:655:1: rule__Stakeholder__Group_0_3_3__1 : rule__Stakeholder__Group_0_3_3__1__Impl ;
    public final void rule__Stakeholder__Group_0_3_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:659:1: ( rule__Stakeholder__Group_0_3_3__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:660:2: rule__Stakeholder__Group_0_3_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_3__1__Impl_in_rule__Stakeholder__Group_0_3_3__11199);
            rule__Stakeholder__Group_0_3_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_3__1"


    // $ANTLR start "rule__Stakeholder__Group_0_3_3__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:666:1: rule__Stakeholder__Group_0_3_3__1__Impl : ( ( rule__Stakeholder__RoleAssignment_0_3_3_1 ) ) ;
    public final void rule__Stakeholder__Group_0_3_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:670:1: ( ( ( rule__Stakeholder__RoleAssignment_0_3_3_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:671:1: ( ( rule__Stakeholder__RoleAssignment_0_3_3_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:671:1: ( ( rule__Stakeholder__RoleAssignment_0_3_3_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:672:1: ( rule__Stakeholder__RoleAssignment_0_3_3_1 )
            {
             before(grammarAccess.getStakeholderAccess().getRoleAssignment_0_3_3_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:673:1: ( rule__Stakeholder__RoleAssignment_0_3_3_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:673:2: rule__Stakeholder__RoleAssignment_0_3_3_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__RoleAssignment_0_3_3_1_in_rule__Stakeholder__Group_0_3_3__1__Impl1226);
            rule__Stakeholder__RoleAssignment_0_3_3_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getRoleAssignment_0_3_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_3__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_4__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:687:1: rule__Stakeholder__Group_0_3_4__0 : rule__Stakeholder__Group_0_3_4__0__Impl rule__Stakeholder__Group_0_3_4__1 ;
    public final void rule__Stakeholder__Group_0_3_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:691:1: ( rule__Stakeholder__Group_0_3_4__0__Impl rule__Stakeholder__Group_0_3_4__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:692:2: rule__Stakeholder__Group_0_3_4__0__Impl rule__Stakeholder__Group_0_3_4__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_4__0__Impl_in_rule__Stakeholder__Group_0_3_4__01260);
            rule__Stakeholder__Group_0_3_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_4__1_in_rule__Stakeholder__Group_0_3_4__01263);
            rule__Stakeholder__Group_0_3_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_4__0"


    // $ANTLR start "rule__Stakeholder__Group_0_3_4__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:699:1: rule__Stakeholder__Group_0_3_4__0__Impl : ( Email ) ;
    public final void rule__Stakeholder__Group_0_3_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:703:1: ( ( Email ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:704:1: ( Email )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:704:1: ( Email )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:705:1: Email
            {
             before(grammarAccess.getStakeholderAccess().getEmailKeyword_0_3_4_0()); 
            match(input,Email,FOLLOW_Email_in_rule__Stakeholder__Group_0_3_4__0__Impl1291); 
             after(grammarAccess.getStakeholderAccess().getEmailKeyword_0_3_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_4__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_4__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:718:1: rule__Stakeholder__Group_0_3_4__1 : rule__Stakeholder__Group_0_3_4__1__Impl ;
    public final void rule__Stakeholder__Group_0_3_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:722:1: ( rule__Stakeholder__Group_0_3_4__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:723:2: rule__Stakeholder__Group_0_3_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_4__1__Impl_in_rule__Stakeholder__Group_0_3_4__11322);
            rule__Stakeholder__Group_0_3_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_4__1"


    // $ANTLR start "rule__Stakeholder__Group_0_3_4__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:729:1: rule__Stakeholder__Group_0_3_4__1__Impl : ( ( rule__Stakeholder__EmailAssignment_0_3_4_1 ) ) ;
    public final void rule__Stakeholder__Group_0_3_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:733:1: ( ( ( rule__Stakeholder__EmailAssignment_0_3_4_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:734:1: ( ( rule__Stakeholder__EmailAssignment_0_3_4_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:734:1: ( ( rule__Stakeholder__EmailAssignment_0_3_4_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:735:1: ( rule__Stakeholder__EmailAssignment_0_3_4_1 )
            {
             before(grammarAccess.getStakeholderAccess().getEmailAssignment_0_3_4_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:736:1: ( rule__Stakeholder__EmailAssignment_0_3_4_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:736:2: rule__Stakeholder__EmailAssignment_0_3_4_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__EmailAssignment_0_3_4_1_in_rule__Stakeholder__Group_0_3_4__1__Impl1349);
            rule__Stakeholder__EmailAssignment_0_3_4_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getEmailAssignment_0_3_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_4__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_5__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:750:1: rule__Stakeholder__Group_0_3_5__0 : rule__Stakeholder__Group_0_3_5__0__Impl rule__Stakeholder__Group_0_3_5__1 ;
    public final void rule__Stakeholder__Group_0_3_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:754:1: ( rule__Stakeholder__Group_0_3_5__0__Impl rule__Stakeholder__Group_0_3_5__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:755:2: rule__Stakeholder__Group_0_3_5__0__Impl rule__Stakeholder__Group_0_3_5__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_5__0__Impl_in_rule__Stakeholder__Group_0_3_5__01383);
            rule__Stakeholder__Group_0_3_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_5__1_in_rule__Stakeholder__Group_0_3_5__01386);
            rule__Stakeholder__Group_0_3_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_5__0"


    // $ANTLR start "rule__Stakeholder__Group_0_3_5__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:762:1: rule__Stakeholder__Group_0_3_5__0__Impl : ( Phone ) ;
    public final void rule__Stakeholder__Group_0_3_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:766:1: ( ( Phone ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:767:1: ( Phone )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:767:1: ( Phone )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:768:1: Phone
            {
             before(grammarAccess.getStakeholderAccess().getPhoneKeyword_0_3_5_0()); 
            match(input,Phone,FOLLOW_Phone_in_rule__Stakeholder__Group_0_3_5__0__Impl1414); 
             after(grammarAccess.getStakeholderAccess().getPhoneKeyword_0_3_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_5__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_0_3_5__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:781:1: rule__Stakeholder__Group_0_3_5__1 : rule__Stakeholder__Group_0_3_5__1__Impl ;
    public final void rule__Stakeholder__Group_0_3_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:785:1: ( rule__Stakeholder__Group_0_3_5__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:786:2: rule__Stakeholder__Group_0_3_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_5__1__Impl_in_rule__Stakeholder__Group_0_3_5__11445);
            rule__Stakeholder__Group_0_3_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_5__1"


    // $ANTLR start "rule__Stakeholder__Group_0_3_5__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:792:1: rule__Stakeholder__Group_0_3_5__1__Impl : ( ( rule__Stakeholder__PhoneAssignment_0_3_5_1 ) ) ;
    public final void rule__Stakeholder__Group_0_3_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:796:1: ( ( ( rule__Stakeholder__PhoneAssignment_0_3_5_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:797:1: ( ( rule__Stakeholder__PhoneAssignment_0_3_5_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:797:1: ( ( rule__Stakeholder__PhoneAssignment_0_3_5_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:798:1: ( rule__Stakeholder__PhoneAssignment_0_3_5_1 )
            {
             before(grammarAccess.getStakeholderAccess().getPhoneAssignment_0_3_5_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:799:1: ( rule__Stakeholder__PhoneAssignment_0_3_5_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:799:2: rule__Stakeholder__PhoneAssignment_0_3_5_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__PhoneAssignment_0_3_5_1_in_rule__Stakeholder__Group_0_3_5__1__Impl1472);
            rule__Stakeholder__PhoneAssignment_0_3_5_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getPhoneAssignment_0_3_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_0_3_5__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:813:1: rule__Stakeholder__Group_1__0 : rule__Stakeholder__Group_1__0__Impl rule__Stakeholder__Group_1__1 ;
    public final void rule__Stakeholder__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:817:1: ( rule__Stakeholder__Group_1__0__Impl rule__Stakeholder__Group_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:818:2: rule__Stakeholder__Group_1__0__Impl rule__Stakeholder__Group_1__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_1__0__Impl_in_rule__Stakeholder__Group_1__01506);
            rule__Stakeholder__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_1__1_in_rule__Stakeholder__Group_1__01509);
            rule__Stakeholder__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_1__0"


    // $ANTLR start "rule__Stakeholder__Group_1__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:825:1: rule__Stakeholder__Group_1__0__Impl : ( ( rule__Stakeholder__Group_1_0__0 )? ) ;
    public final void rule__Stakeholder__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:829:1: ( ( ( rule__Stakeholder__Group_1_0__0 )? ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:830:1: ( ( rule__Stakeholder__Group_1_0__0 )? )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:830:1: ( ( rule__Stakeholder__Group_1_0__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:831:1: ( rule__Stakeholder__Group_1_0__0 )?
            {
             before(grammarAccess.getStakeholderAccess().getGroup_1_0()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:832:1: ( rule__Stakeholder__Group_1_0__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Supervisor) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:832:2: rule__Stakeholder__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_1_0__0_in_rule__Stakeholder__Group_1__0__Impl1536);
                    rule__Stakeholder__Group_1_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStakeholderAccess().getGroup_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_1__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_1__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:842:1: rule__Stakeholder__Group_1__1 : rule__Stakeholder__Group_1__1__Impl ;
    public final void rule__Stakeholder__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:846:1: ( rule__Stakeholder__Group_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:847:2: rule__Stakeholder__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_1__1__Impl_in_rule__Stakeholder__Group_1__11567);
            rule__Stakeholder__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_1__1"


    // $ANTLR start "rule__Stakeholder__Group_1__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:853:1: rule__Stakeholder__Group_1__1__Impl : ( RightSquareBracket ) ;
    public final void rule__Stakeholder__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:857:1: ( ( RightSquareBracket ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:858:1: ( RightSquareBracket )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:858:1: ( RightSquareBracket )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:859:1: RightSquareBracket
            {
             before(grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_1_1()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__Stakeholder__Group_1__1__Impl1595); 
             after(grammarAccess.getStakeholderAccess().getRightSquareBracketKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_1__1__Impl"


    // $ANTLR start "rule__Stakeholder__Group_1_0__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:876:1: rule__Stakeholder__Group_1_0__0 : rule__Stakeholder__Group_1_0__0__Impl rule__Stakeholder__Group_1_0__1 ;
    public final void rule__Stakeholder__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:880:1: ( rule__Stakeholder__Group_1_0__0__Impl rule__Stakeholder__Group_1_0__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:881:2: rule__Stakeholder__Group_1_0__0__Impl rule__Stakeholder__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_1_0__0__Impl_in_rule__Stakeholder__Group_1_0__01630);
            rule__Stakeholder__Group_1_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Stakeholder__Group_1_0__1_in_rule__Stakeholder__Group_1_0__01633);
            rule__Stakeholder__Group_1_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_1_0__0"


    // $ANTLR start "rule__Stakeholder__Group_1_0__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:888:1: rule__Stakeholder__Group_1_0__0__Impl : ( Supervisor ) ;
    public final void rule__Stakeholder__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:892:1: ( ( Supervisor ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:893:1: ( Supervisor )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:893:1: ( Supervisor )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:894:1: Supervisor
            {
             before(grammarAccess.getStakeholderAccess().getSupervisorKeyword_1_0_0()); 
            match(input,Supervisor,FOLLOW_Supervisor_in_rule__Stakeholder__Group_1_0__0__Impl1661); 
             after(grammarAccess.getStakeholderAccess().getSupervisorKeyword_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_1_0__0__Impl"


    // $ANTLR start "rule__Stakeholder__Group_1_0__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:907:1: rule__Stakeholder__Group_1_0__1 : rule__Stakeholder__Group_1_0__1__Impl ;
    public final void rule__Stakeholder__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:911:1: ( rule__Stakeholder__Group_1_0__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:912:2: rule__Stakeholder__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__Group_1_0__1__Impl_in_rule__Stakeholder__Group_1_0__11692);
            rule__Stakeholder__Group_1_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_1_0__1"


    // $ANTLR start "rule__Stakeholder__Group_1_0__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:918:1: rule__Stakeholder__Group_1_0__1__Impl : ( ( rule__Stakeholder__SupervisorAssignment_1_0_1 ) ) ;
    public final void rule__Stakeholder__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:922:1: ( ( ( rule__Stakeholder__SupervisorAssignment_1_0_1 ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:923:1: ( ( rule__Stakeholder__SupervisorAssignment_1_0_1 ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:923:1: ( ( rule__Stakeholder__SupervisorAssignment_1_0_1 ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:924:1: ( rule__Stakeholder__SupervisorAssignment_1_0_1 )
            {
             before(grammarAccess.getStakeholderAccess().getSupervisorAssignment_1_0_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:925:1: ( rule__Stakeholder__SupervisorAssignment_1_0_1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:925:2: rule__Stakeholder__SupervisorAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__Stakeholder__SupervisorAssignment_1_0_1_in_rule__Stakeholder__Group_1_0__1__Impl1719);
            rule__Stakeholder__SupervisorAssignment_1_0_1();

            state._fsp--;


            }

             after(grammarAccess.getStakeholderAccess().getSupervisorAssignment_1_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__Group_1_0__1__Impl"


    // $ANTLR start "rule__QID__Group__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:939:1: rule__QID__Group__0 : rule__QID__Group__0__Impl rule__QID__Group__1 ;
    public final void rule__QID__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:943:1: ( rule__QID__Group__0__Impl rule__QID__Group__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:944:2: rule__QID__Group__0__Impl rule__QID__Group__1
            {
            pushFollow(FOLLOW_rule__QID__Group__0__Impl_in_rule__QID__Group__01753);
            rule__QID__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QID__Group__1_in_rule__QID__Group__01756);
            rule__QID__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group__0"


    // $ANTLR start "rule__QID__Group__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:951:1: rule__QID__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QID__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:955:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:956:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:956:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:957:1: RULE_ID
            {
             before(grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QID__Group__0__Impl1783); 
             after(grammarAccess.getQIDAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group__0__Impl"


    // $ANTLR start "rule__QID__Group__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:968:1: rule__QID__Group__1 : rule__QID__Group__1__Impl ;
    public final void rule__QID__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:972:1: ( rule__QID__Group__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:973:2: rule__QID__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QID__Group__1__Impl_in_rule__QID__Group__11812);
            rule__QID__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group__1"


    // $ANTLR start "rule__QID__Group__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:979:1: rule__QID__Group__1__Impl : ( ( rule__QID__Group_1__0 )? ) ;
    public final void rule__QID__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:983:1: ( ( ( rule__QID__Group_1__0 )? ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:984:1: ( ( rule__QID__Group_1__0 )? )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:984:1: ( ( rule__QID__Group_1__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:985:1: ( rule__QID__Group_1__0 )?
            {
             before(grammarAccess.getQIDAccess().getGroup_1()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:986:1: ( rule__QID__Group_1__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==FullStop) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:986:2: rule__QID__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__QID__Group_1__0_in_rule__QID__Group__1__Impl1839);
                    rule__QID__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getQIDAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group__1__Impl"


    // $ANTLR start "rule__QID__Group_1__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1000:1: rule__QID__Group_1__0 : rule__QID__Group_1__0__Impl rule__QID__Group_1__1 ;
    public final void rule__QID__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1004:1: ( rule__QID__Group_1__0__Impl rule__QID__Group_1__1 )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1005:2: rule__QID__Group_1__0__Impl rule__QID__Group_1__1
            {
            pushFollow(FOLLOW_rule__QID__Group_1__0__Impl_in_rule__QID__Group_1__01874);
            rule__QID__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QID__Group_1__1_in_rule__QID__Group_1__01877);
            rule__QID__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group_1__0"


    // $ANTLR start "rule__QID__Group_1__0__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1012:1: rule__QID__Group_1__0__Impl : ( FullStop ) ;
    public final void rule__QID__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1016:1: ( ( FullStop ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1017:1: ( FullStop )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1017:1: ( FullStop )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1018:1: FullStop
            {
             before(grammarAccess.getQIDAccess().getFullStopKeyword_1_0()); 
            match(input,FullStop,FOLLOW_FullStop_in_rule__QID__Group_1__0__Impl1905); 
             after(grammarAccess.getQIDAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group_1__0__Impl"


    // $ANTLR start "rule__QID__Group_1__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1031:1: rule__QID__Group_1__1 : rule__QID__Group_1__1__Impl ;
    public final void rule__QID__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1035:1: ( rule__QID__Group_1__1__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1036:2: rule__QID__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QID__Group_1__1__Impl_in_rule__QID__Group_1__11936);
            rule__QID__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group_1__1"


    // $ANTLR start "rule__QID__Group_1__1__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1042:1: rule__QID__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QID__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1046:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1047:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1047:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1048:1: RULE_ID
            {
             before(grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QID__Group_1__1__Impl1963); 
             after(grammarAccess.getQIDAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QID__Group_1__1__Impl"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1064:1: rule__Stakeholder__UnorderedGroup : rule__Stakeholder__UnorderedGroup__0 {...}?;
    public final void rule__Stakeholder__UnorderedGroup() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup());
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1069:1: ( rule__Stakeholder__UnorderedGroup__0 {...}?)
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1070:2: rule__Stakeholder__UnorderedGroup__0 {...}?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup__0_in_rule__Stakeholder__UnorderedGroup1997);
            rule__Stakeholder__UnorderedGroup__0();

            state._fsp--;

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getStakeholderAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup", "getUnorderedGroupHelper().canLeave(grammarAccess.getStakeholderAccess().getUnorderedGroup())");
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1081:1: rule__Stakeholder__UnorderedGroup__Impl : ( ({...}? => ( ( ( rule__Stakeholder__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_1__0 ) ) ) ) ) ;
    public final void rule__Stakeholder__UnorderedGroup__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1086:1: ( ( ({...}? => ( ( ( rule__Stakeholder__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_1__0 ) ) ) ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1087:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_1__0 ) ) ) ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1087:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_1__0 ) ) ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( LA4_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0) ) {
                alt4=1;
            }
            else if ( (LA4_0==Supervisor||LA4_0==RightSquareBracket) && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1089:4: ({...}? => ( ( ( rule__Stakeholder__Group_0__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1089:4: ({...}? => ( ( ( rule__Stakeholder__Group_0__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1090:5: {...}? => ( ( ( rule__Stakeholder__Group_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1090:106: ( ( ( rule__Stakeholder__Group_0__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1091:6: ( ( rule__Stakeholder__Group_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1097:6: ( ( rule__Stakeholder__Group_0__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1099:7: ( rule__Stakeholder__Group_0__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1100:7: ( rule__Stakeholder__Group_0__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1100:8: rule__Stakeholder__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_0__0_in_rule__Stakeholder__UnorderedGroup__Impl2086);
                    rule__Stakeholder__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_0()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup());
                    	 				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1109:4: ({...}? => ( ( ( rule__Stakeholder__Group_1__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1109:4: ({...}? => ( ( ( rule__Stakeholder__Group_1__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1110:5: {...}? => ( ( ( rule__Stakeholder__Group_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1110:106: ( ( ( rule__Stakeholder__Group_1__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1111:6: ( ( rule__Stakeholder__Group_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1117:6: ( ( rule__Stakeholder__Group_1__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1119:7: ( rule__Stakeholder__Group_1__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1120:7: ( rule__Stakeholder__Group_1__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1120:8: rule__Stakeholder__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_1__0_in_rule__Stakeholder__UnorderedGroup__Impl2184);
                    rule__Stakeholder__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_1()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup());
                    	 				

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup__Impl"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1138:1: rule__Stakeholder__UnorderedGroup__0 : rule__Stakeholder__UnorderedGroup__Impl ( rule__Stakeholder__UnorderedGroup__1 )? ;
    public final void rule__Stakeholder__UnorderedGroup__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1142:1: ( rule__Stakeholder__UnorderedGroup__Impl ( rule__Stakeholder__UnorderedGroup__1 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1143:2: rule__Stakeholder__UnorderedGroup__Impl ( rule__Stakeholder__UnorderedGroup__1 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup__Impl_in_rule__Stakeholder__UnorderedGroup__02250);
            rule__Stakeholder__UnorderedGroup__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1144:2: ( rule__Stakeholder__UnorderedGroup__1 )?
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1144:2: rule__Stakeholder__UnorderedGroup__1
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup__1_in_rule__Stakeholder__UnorderedGroup__02253);
                    rule__Stakeholder__UnorderedGroup__1();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup__0"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1151:1: rule__Stakeholder__UnorderedGroup__1 : rule__Stakeholder__UnorderedGroup__Impl ;
    public final void rule__Stakeholder__UnorderedGroup__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1155:1: ( rule__Stakeholder__UnorderedGroup__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1156:2: rule__Stakeholder__UnorderedGroup__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup__Impl_in_rule__Stakeholder__UnorderedGroup__12278);
            rule__Stakeholder__UnorderedGroup__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup__1"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_0_3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1167:1: rule__Stakeholder__UnorderedGroup_0_3 : ( rule__Stakeholder__UnorderedGroup_0_3__0 )? ;
    public final void rule__Stakeholder__UnorderedGroup_0_3() throws RecognitionException {

            	int stackSize = keepStackSize();
        		getUnorderedGroupHelper().enter(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1172:1: ( ( rule__Stakeholder__UnorderedGroup_0_3__0 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1173:2: ( rule__Stakeholder__UnorderedGroup_0_3__0 )?
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1173:2: ( rule__Stakeholder__UnorderedGroup_0_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( LA6_0 ==Full && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Role && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Email && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
                alt6=1;
            }
            else if ( LA6_0 ==Phone && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1173:2: rule__Stakeholder__UnorderedGroup_0_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__0_in_rule__Stakeholder__UnorderedGroup_0_32306);
                    rule__Stakeholder__UnorderedGroup_0_3__0();

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

            	getUnorderedGroupHelper().leave(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_0_3"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_0_3__Impl"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1183:1: rule__Stakeholder__UnorderedGroup_0_3__Impl : ( ({...}? => ( ( ( rule__Stakeholder__Group_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_5__0 ) ) ) ) ) ;
    public final void rule__Stakeholder__UnorderedGroup_0_3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        		boolean selected = false;
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1188:1: ( ( ({...}? => ( ( ( rule__Stakeholder__Group_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_5__0 ) ) ) ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1189:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_5__0 ) ) ) ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1189:3: ( ({...}? => ( ( ( rule__Stakeholder__Group_0_3_0__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_1__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_2__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_3__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_4__0 ) ) ) ) | ({...}? => ( ( ( rule__Stakeholder__Group_0_3_5__0 ) ) ) ) )
            int alt7=6;
            int LA7_0 = input.LA(1);

            if ( LA7_0 ==Full && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
                alt7=1;
            }
            else if ( LA7_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
                alt7=2;
            }
            else if ( LA7_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
                alt7=3;
            }
            else if ( LA7_0 ==Role && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
                alt7=4;
            }
            else if ( LA7_0 ==Email && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
                alt7=5;
            }
            else if ( LA7_0 ==Phone && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
                alt7=6;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1191:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_0__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1191:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_0__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1192:5: {...}? => ( ( ( rule__Stakeholder__Group_0_3_0__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1192:110: ( ( ( rule__Stakeholder__Group_0_3_0__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1193:6: ( ( rule__Stakeholder__Group_0_3_0__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1199:6: ( ( rule__Stakeholder__Group_0_3_0__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1201:7: ( rule__Stakeholder__Group_0_3_0__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_0_3_0()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1202:7: ( rule__Stakeholder__Group_0_3_0__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1202:8: rule__Stakeholder__Group_0_3_0__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_0__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2393);
                    rule__Stakeholder__Group_0_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_0_3_0()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
                    	 				

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1211:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_1__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1211:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_1__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1212:5: {...}? => ( ( ( rule__Stakeholder__Group_0_3_1__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1212:110: ( ( ( rule__Stakeholder__Group_0_3_1__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1213:6: ( ( rule__Stakeholder__Group_0_3_1__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1219:6: ( ( rule__Stakeholder__Group_0_3_1__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1221:7: ( rule__Stakeholder__Group_0_3_1__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_0_3_1()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1222:7: ( rule__Stakeholder__Group_0_3_1__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1222:8: rule__Stakeholder__Group_0_3_1__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_1__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2491);
                    rule__Stakeholder__Group_0_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_0_3_1()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
                    	 				

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1231:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_2__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1231:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_2__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1232:5: {...}? => ( ( ( rule__Stakeholder__Group_0_3_2__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1232:110: ( ( ( rule__Stakeholder__Group_0_3_2__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1233:6: ( ( rule__Stakeholder__Group_0_3_2__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1239:6: ( ( rule__Stakeholder__Group_0_3_2__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1241:7: ( rule__Stakeholder__Group_0_3_2__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_0_3_2()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1242:7: ( rule__Stakeholder__Group_0_3_2__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1242:8: rule__Stakeholder__Group_0_3_2__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_2__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2589);
                    rule__Stakeholder__Group_0_3_2__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_0_3_2()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
                    	 				

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1251:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_3__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1251:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_3__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1252:5: {...}? => ( ( ( rule__Stakeholder__Group_0_3_3__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1252:110: ( ( ( rule__Stakeholder__Group_0_3_3__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1253:6: ( ( rule__Stakeholder__Group_0_3_3__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1259:6: ( ( rule__Stakeholder__Group_0_3_3__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1261:7: ( rule__Stakeholder__Group_0_3_3__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_0_3_3()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1262:7: ( rule__Stakeholder__Group_0_3_3__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1262:8: rule__Stakeholder__Group_0_3_3__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_3__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2687);
                    rule__Stakeholder__Group_0_3_3__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_0_3_3()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
                    	 				

                    }


                    }


                    }
                    break;
                case 5 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1271:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_4__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1271:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_4__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1272:5: {...}? => ( ( ( rule__Stakeholder__Group_0_3_4__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1272:110: ( ( ( rule__Stakeholder__Group_0_3_4__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1273:6: ( ( rule__Stakeholder__Group_0_3_4__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1279:6: ( ( rule__Stakeholder__Group_0_3_4__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1281:7: ( rule__Stakeholder__Group_0_3_4__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_0_3_4()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1282:7: ( rule__Stakeholder__Group_0_3_4__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1282:8: rule__Stakeholder__Group_0_3_4__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_4__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2785);
                    rule__Stakeholder__Group_0_3_4__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_0_3_4()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
                    	 				

                    }


                    }


                    }
                    break;
                case 6 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1291:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_5__0 ) ) ) )
                    {
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1291:4: ({...}? => ( ( ( rule__Stakeholder__Group_0_3_5__0 ) ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1292:5: {...}? => ( ( ( rule__Stakeholder__Group_0_3_5__0 ) ) )
                    {
                    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
                        throw new FailedPredicateException(input, "rule__Stakeholder__UnorderedGroup_0_3__Impl", "getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5)");
                    }
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1292:110: ( ( ( rule__Stakeholder__Group_0_3_5__0 ) ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1293:6: ( ( rule__Stakeholder__Group_0_3_5__0 ) )
                    {
                     
                    	 				  getUnorderedGroupHelper().select(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5);
                    	 				

                    	 				  selected = true;
                    	 				
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1299:6: ( ( rule__Stakeholder__Group_0_3_5__0 ) )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1301:7: ( rule__Stakeholder__Group_0_3_5__0 )
                    {
                     before(grammarAccess.getStakeholderAccess().getGroup_0_3_5()); 
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1302:7: ( rule__Stakeholder__Group_0_3_5__0 )
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1302:8: rule__Stakeholder__Group_0_3_5__0
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__Group_0_3_5__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2883);
                    rule__Stakeholder__Group_0_3_5__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getStakeholderAccess().getGroup_0_3_5()); 

                    }

                     
                    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
                    	 				

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
            		getUnorderedGroupHelper().returnFromSelection(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3());
            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_0_3__Impl"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_0_3__0"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1320:1: rule__Stakeholder__UnorderedGroup_0_3__0 : rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__1 )? ;
    public final void rule__Stakeholder__UnorderedGroup_0_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1324:1: ( rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__1 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1325:2: rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__1 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__02949);
            rule__Stakeholder__UnorderedGroup_0_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1326:2: ( rule__Stakeholder__UnorderedGroup_0_3__1 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( LA8_0 ==Full && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Role && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Email && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
                alt8=1;
            }
            else if ( LA8_0 ==Phone && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1326:2: rule__Stakeholder__UnorderedGroup_0_3__1
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__1_in_rule__Stakeholder__UnorderedGroup_0_3__02952);
                    rule__Stakeholder__UnorderedGroup_0_3__1();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_0_3__0"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_0_3__1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1333:1: rule__Stakeholder__UnorderedGroup_0_3__1 : rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__2 )? ;
    public final void rule__Stakeholder__UnorderedGroup_0_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1337:1: ( rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__2 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1338:2: rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__2 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__12977);
            rule__Stakeholder__UnorderedGroup_0_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1339:2: ( rule__Stakeholder__UnorderedGroup_0_3__2 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( LA9_0 ==Full && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Role && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Email && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
                alt9=1;
            }
            else if ( LA9_0 ==Phone && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1339:2: rule__Stakeholder__UnorderedGroup_0_3__2
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__2_in_rule__Stakeholder__UnorderedGroup_0_3__12980);
                    rule__Stakeholder__UnorderedGroup_0_3__2();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_0_3__1"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_0_3__2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1346:1: rule__Stakeholder__UnorderedGroup_0_3__2 : rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__3 )? ;
    public final void rule__Stakeholder__UnorderedGroup_0_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1350:1: ( rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__3 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1351:2: rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__3 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__23005);
            rule__Stakeholder__UnorderedGroup_0_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1352:2: ( rule__Stakeholder__UnorderedGroup_0_3__3 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( LA10_0 ==Full && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Role && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Email && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
                alt10=1;
            }
            else if ( LA10_0 ==Phone && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1352:2: rule__Stakeholder__UnorderedGroup_0_3__3
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__3_in_rule__Stakeholder__UnorderedGroup_0_3__23008);
                    rule__Stakeholder__UnorderedGroup_0_3__3();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_0_3__2"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_0_3__3"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1359:1: rule__Stakeholder__UnorderedGroup_0_3__3 : rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__4 )? ;
    public final void rule__Stakeholder__UnorderedGroup_0_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1363:1: ( rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__4 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1364:2: rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__4 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__33033);
            rule__Stakeholder__UnorderedGroup_0_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1365:2: ( rule__Stakeholder__UnorderedGroup_0_3__4 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( LA11_0 ==Full && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Role && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Email && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
                alt11=1;
            }
            else if ( LA11_0 ==Phone && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1365:2: rule__Stakeholder__UnorderedGroup_0_3__4
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__4_in_rule__Stakeholder__UnorderedGroup_0_3__33036);
                    rule__Stakeholder__UnorderedGroup_0_3__4();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_0_3__3"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_0_3__4"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1372:1: rule__Stakeholder__UnorderedGroup_0_3__4 : rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__5 )? ;
    public final void rule__Stakeholder__UnorderedGroup_0_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1376:1: ( rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__5 )? )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1377:2: rule__Stakeholder__UnorderedGroup_0_3__Impl ( rule__Stakeholder__UnorderedGroup_0_3__5 )?
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__43061);
            rule__Stakeholder__UnorderedGroup_0_3__Impl();

            state._fsp--;

            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1378:2: ( rule__Stakeholder__UnorderedGroup_0_3__5 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( LA12_0 ==Full && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 0) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 1) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 2) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Role && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 3) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Email && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 4) ) {
                alt12=1;
            }
            else if ( LA12_0 ==Phone && getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup_0_3(), 5) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1378:2: rule__Stakeholder__UnorderedGroup_0_3__5
                    {
                    pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__5_in_rule__Stakeholder__UnorderedGroup_0_3__43064);
                    rule__Stakeholder__UnorderedGroup_0_3__5();

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
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_0_3__4"


    // $ANTLR start "rule__Stakeholder__UnorderedGroup_0_3__5"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1385:1: rule__Stakeholder__UnorderedGroup_0_3__5 : rule__Stakeholder__UnorderedGroup_0_3__Impl ;
    public final void rule__Stakeholder__UnorderedGroup_0_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1389:1: ( rule__Stakeholder__UnorderedGroup_0_3__Impl )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1390:2: rule__Stakeholder__UnorderedGroup_0_3__Impl
            {
            pushFollow(FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__53089);
            rule__Stakeholder__UnorderedGroup_0_3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__UnorderedGroup_0_3__5"


    // $ANTLR start "rule__Organization__NameAssignment_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1409:1: rule__Organization__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Organization__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1413:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1414:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1414:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1415:1: RULE_ID
            {
             before(grammarAccess.getOrganizationAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_13129); 
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
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1424:1: rule__Organization__StakeholderAssignment_2 : ( ruleStakeholder ) ;
    public final void rule__Organization__StakeholderAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1428:1: ( ( ruleStakeholder ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1429:1: ( ruleStakeholder )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1429:1: ( ruleStakeholder )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1430:1: ruleStakeholder
            {
             before(grammarAccess.getOrganizationAccess().getStakeholderStakeholderParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_23160);
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


    // $ANTLR start "rule__Stakeholder__NameAssignment_0_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1439:1: rule__Stakeholder__NameAssignment_0_1 : ( RULE_ID ) ;
    public final void rule__Stakeholder__NameAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1443:1: ( ( RULE_ID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1444:1: ( RULE_ID )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1444:1: ( RULE_ID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1445:1: RULE_ID
            {
             before(grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_0_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_0_13191); 
             after(grammarAccess.getStakeholderAccess().getNameIDTerminalRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__NameAssignment_0_1"


    // $ANTLR start "rule__Stakeholder__FullnameAssignment_0_3_0_2"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1454:1: rule__Stakeholder__FullnameAssignment_0_3_0_2 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__FullnameAssignment_0_3_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1458:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1459:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1459:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1460:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getFullnameSTRINGTerminalRuleCall_0_3_0_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__FullnameAssignment_0_3_0_23222); 
             after(grammarAccess.getStakeholderAccess().getFullnameSTRINGTerminalRuleCall_0_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__FullnameAssignment_0_3_0_2"


    // $ANTLR start "rule__Stakeholder__TitleAssignment_0_3_1_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1469:1: rule__Stakeholder__TitleAssignment_0_3_1_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__TitleAssignment_0_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1473:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1474:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1474:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1475:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_0_3_1_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__TitleAssignment_0_3_1_13253); 
             after(grammarAccess.getStakeholderAccess().getTitleSTRINGTerminalRuleCall_0_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__TitleAssignment_0_3_1_1"


    // $ANTLR start "rule__Stakeholder__DescriptionAssignment_0_3_2_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1484:1: rule__Stakeholder__DescriptionAssignment_0_3_2_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__DescriptionAssignment_0_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1488:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1489:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1489:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1490:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_0_3_2_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__DescriptionAssignment_0_3_2_13284); 
             after(grammarAccess.getStakeholderAccess().getDescriptionSTRINGTerminalRuleCall_0_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__DescriptionAssignment_0_3_2_1"


    // $ANTLR start "rule__Stakeholder__RoleAssignment_0_3_3_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1499:1: rule__Stakeholder__RoleAssignment_0_3_3_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__RoleAssignment_0_3_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1503:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1504:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1504:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1505:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_0_3_3_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__RoleAssignment_0_3_3_13315); 
             after(grammarAccess.getStakeholderAccess().getRoleSTRINGTerminalRuleCall_0_3_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__RoleAssignment_0_3_3_1"


    // $ANTLR start "rule__Stakeholder__EmailAssignment_0_3_4_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1514:1: rule__Stakeholder__EmailAssignment_0_3_4_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__EmailAssignment_0_3_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1518:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1519:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1519:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1520:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_0_3_4_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__EmailAssignment_0_3_4_13346); 
             after(grammarAccess.getStakeholderAccess().getEmailSTRINGTerminalRuleCall_0_3_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__EmailAssignment_0_3_4_1"


    // $ANTLR start "rule__Stakeholder__PhoneAssignment_0_3_5_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1529:1: rule__Stakeholder__PhoneAssignment_0_3_5_1 : ( RULE_STRING ) ;
    public final void rule__Stakeholder__PhoneAssignment_0_3_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1533:1: ( ( RULE_STRING ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1534:1: ( RULE_STRING )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1534:1: ( RULE_STRING )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1535:1: RULE_STRING
            {
             before(grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_0_3_5_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Stakeholder__PhoneAssignment_0_3_5_13377); 
             after(grammarAccess.getStakeholderAccess().getPhoneSTRINGTerminalRuleCall_0_3_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__PhoneAssignment_0_3_5_1"


    // $ANTLR start "rule__Stakeholder__SupervisorAssignment_1_0_1"
    // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1544:1: rule__Stakeholder__SupervisorAssignment_1_0_1 : ( ( ruleQID ) ) ;
    public final void rule__Stakeholder__SupervisorAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1548:1: ( ( ( ruleQID ) ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1549:1: ( ( ruleQID ) )
            {
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1549:1: ( ( ruleQID ) )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1550:1: ( ruleQID )
            {
             before(grammarAccess.getStakeholderAccess().getSupervisorStakeholderCrossReference_1_0_1_0()); 
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1551:1: ( ruleQID )
            // ../org.osate.organization.ui/src-gen/org/osate/organization/ui/contentassist/antlr/internal/InternalOrganizationParser.g:1552:1: ruleQID
            {
             before(grammarAccess.getStakeholderAccess().getSupervisorStakeholderQIDParserRuleCall_1_0_1_0_1()); 
            pushFollow(FOLLOW_ruleQID_in_rule__Stakeholder__SupervisorAssignment_1_0_13412);
            ruleQID();

            state._fsp--;

             after(grammarAccess.getStakeholderAccess().getSupervisorStakeholderQIDParserRuleCall_1_0_1_0_1()); 

            }

             after(grammarAccess.getStakeholderAccess().getSupervisorStakeholderCrossReference_1_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Stakeholder__SupervisorAssignment_1_0_1"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\13\uffff";
    static final String DFA5_eofS =
        "\1\4\12\uffff";
    static final String DFA5_minS =
        "\1\6\2\21\1\0\1\uffff\1\17\1\16\1\uffff\1\0\1\21\1\20";
    static final String DFA5_maxS =
        "\1\20\2\21\1\0\1\uffff\1\17\1\20\1\uffff\1\0\1\21\1\20";
    static final String DFA5_acceptS =
        "\4\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA5_specialS =
        "\3\uffff\1\1\4\uffff\1\0\2\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\1\1\2\10\uffff\1\3",
            "\1\5",
            "\1\6",
            "\1\uffff",
            "",
            "\1\10",
            "\1\11\1\uffff\1\3",
            "",
            "\1\uffff",
            "\1\12",
            "\1\3"
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
            return "1144:2: ( rule__Stakeholder__UnorderedGroup__1 )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA5_8 = input.LA(1);

                         
                        int index5_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 0) ) {s = 7;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getStakeholderAccess().getUnorderedGroup()) ) {s = 4;}

                         
                        input.seek(index5_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA5_3 = input.LA(1);

                         
                        int index5_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getStakeholderAccess().getUnorderedGroup(), 1) ) {s = 7;}

                        else if ( getUnorderedGroupHelper().canLeave(grammarAccess.getStakeholderAccess().getUnorderedGroup()) ) {s = 4;}

                         
                        input.seek(index5_3);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 5, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleOrganization_in_entryRuleOrganization54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrganization61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__0_in_ruleOrganization91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_entryRuleStakeholder118 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholder125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_in_ruleStakeholder155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_entryRuleQID182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQID189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group__0_in_ruleQID219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__0__Impl_in_rule__Organization__Group__0253 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Organization__Group__1_in_rule__Organization__Group__0256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Organization_in_rule__Organization__Group__0__Impl284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__1__Impl_in_rule__Organization__Group__1315 = new BitSet(new long[]{0x00000000000100C0L});
    public static final BitSet FOLLOW_rule__Organization__Group__2_in_rule__Organization__Group__1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__NameAssignment_1_in_rule__Organization__Group__1__Impl345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__Group__2__Impl_in_rule__Organization__Group__2375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl404 = new BitSet(new long[]{0x00000000000100C2L});
    public static final BitSet FOLLOW_rule__Organization__StakeholderAssignment_2_in_rule__Organization__Group__2__Impl416 = new BitSet(new long[]{0x00000000000100C2L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0__0__Impl_in_rule__Stakeholder__Group_0__0455 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0__1_in_rule__Stakeholder__Group_0__0458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Stakeholder_in_rule__Stakeholder__Group_0__0__Impl486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0__1__Impl_in_rule__Stakeholder__Group_0__1517 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0__2_in_rule__Stakeholder__Group_0__1520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__NameAssignment_0_1_in_rule__Stakeholder__Group_0__1__Impl547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0__2__Impl_in_rule__Stakeholder__Group_0__2577 = new BitSet(new long[]{0x0000000000002F20L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0__3_in_rule__Stakeholder__Group_0__2580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__Stakeholder__Group_0__2__Impl608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0__3__Impl_in_rule__Stakeholder__Group_0__3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3_in_rule__Stakeholder__Group_0__3__Impl666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_0__0__Impl_in_rule__Stakeholder__Group_0_3_0__0704 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_0__1_in_rule__Stakeholder__Group_0_3_0__0707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Full_in_rule__Stakeholder__Group_0_3_0__0__Impl735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_0__1__Impl_in_rule__Stakeholder__Group_0_3_0__1766 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_0__2_in_rule__Stakeholder__Group_0_3_0__1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Name_in_rule__Stakeholder__Group_0_3_0__1__Impl797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_0__2__Impl_in_rule__Stakeholder__Group_0_3_0__2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__FullnameAssignment_0_3_0_2_in_rule__Stakeholder__Group_0_3_0__2__Impl855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_1__0__Impl_in_rule__Stakeholder__Group_0_3_1__0891 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_1__1_in_rule__Stakeholder__Group_0_3_1__0894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Title_in_rule__Stakeholder__Group_0_3_1__0__Impl922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_1__1__Impl_in_rule__Stakeholder__Group_0_3_1__1953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__TitleAssignment_0_3_1_1_in_rule__Stakeholder__Group_0_3_1__1__Impl980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_2__0__Impl_in_rule__Stakeholder__Group_0_3_2__01014 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_2__1_in_rule__Stakeholder__Group_0_3_2__01017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Description_in_rule__Stakeholder__Group_0_3_2__0__Impl1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_2__1__Impl_in_rule__Stakeholder__Group_0_3_2__11076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__DescriptionAssignment_0_3_2_1_in_rule__Stakeholder__Group_0_3_2__1__Impl1103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_3__0__Impl_in_rule__Stakeholder__Group_0_3_3__01137 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_3__1_in_rule__Stakeholder__Group_0_3_3__01140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Role_in_rule__Stakeholder__Group_0_3_3__0__Impl1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_3__1__Impl_in_rule__Stakeholder__Group_0_3_3__11199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__RoleAssignment_0_3_3_1_in_rule__Stakeholder__Group_0_3_3__1__Impl1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_4__0__Impl_in_rule__Stakeholder__Group_0_3_4__01260 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_4__1_in_rule__Stakeholder__Group_0_3_4__01263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Email_in_rule__Stakeholder__Group_0_3_4__0__Impl1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_4__1__Impl_in_rule__Stakeholder__Group_0_3_4__11322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__EmailAssignment_0_3_4_1_in_rule__Stakeholder__Group_0_3_4__1__Impl1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_5__0__Impl_in_rule__Stakeholder__Group_0_3_5__01383 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_5__1_in_rule__Stakeholder__Group_0_3_5__01386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Phone_in_rule__Stakeholder__Group_0_3_5__0__Impl1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_5__1__Impl_in_rule__Stakeholder__Group_0_3_5__11445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__PhoneAssignment_0_3_5_1_in_rule__Stakeholder__Group_0_3_5__1__Impl1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_1__0__Impl_in_rule__Stakeholder__Group_1__01506 = new BitSet(new long[]{0x00000000000100C0L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_1__1_in_rule__Stakeholder__Group_1__01509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_1_0__0_in_rule__Stakeholder__Group_1__0__Impl1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_1__1__Impl_in_rule__Stakeholder__Group_1__11567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__Stakeholder__Group_1__1__Impl1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_1_0__0__Impl_in_rule__Stakeholder__Group_1_0__01630 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_1_0__1_in_rule__Stakeholder__Group_1_0__01633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Supervisor_in_rule__Stakeholder__Group_1_0__0__Impl1661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_1_0__1__Impl_in_rule__Stakeholder__Group_1_0__11692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__SupervisorAssignment_1_0_1_in_rule__Stakeholder__Group_1_0__1__Impl1719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group__0__Impl_in_rule__QID__Group__01753 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__QID__Group__1_in_rule__QID__Group__01756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QID__Group__0__Impl1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group__1__Impl_in_rule__QID__Group__11812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group_1__0_in_rule__QID__Group__1__Impl1839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group_1__0__Impl_in_rule__QID__Group_1__01874 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__QID__Group_1__1_in_rule__QID__Group_1__01877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStop_in_rule__QID__Group_1__0__Impl1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QID__Group_1__1__Impl_in_rule__QID__Group_1__11936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QID__Group_1__1__Impl1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup__0_in_rule__Stakeholder__UnorderedGroup1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0__0_in_rule__Stakeholder__UnorderedGroup__Impl2086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_1__0_in_rule__Stakeholder__UnorderedGroup__Impl2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup__Impl_in_rule__Stakeholder__UnorderedGroup__02250 = new BitSet(new long[]{0x00000000000100C2L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup__1_in_rule__Stakeholder__UnorderedGroup__02253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup__Impl_in_rule__Stakeholder__UnorderedGroup__12278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__0_in_rule__Stakeholder__UnorderedGroup_0_32306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_0__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_1__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_2__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_3__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_4__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__Group_0_3_5__0_in_rule__Stakeholder__UnorderedGroup_0_3__Impl2883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__02949 = new BitSet(new long[]{0x0000000000002F22L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__1_in_rule__Stakeholder__UnorderedGroup_0_3__02952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__12977 = new BitSet(new long[]{0x0000000000002F22L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__2_in_rule__Stakeholder__UnorderedGroup_0_3__12980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__23005 = new BitSet(new long[]{0x0000000000002F22L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__3_in_rule__Stakeholder__UnorderedGroup_0_3__23008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__33033 = new BitSet(new long[]{0x0000000000002F22L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__4_in_rule__Stakeholder__UnorderedGroup_0_3__33036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__43061 = new BitSet(new long[]{0x0000000000002F22L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__5_in_rule__Stakeholder__UnorderedGroup_0_3__43064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Stakeholder__UnorderedGroup_0_3__Impl_in_rule__Stakeholder__UnorderedGroup_0_3__53089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Organization__NameAssignment_13129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholder_in_rule__Organization__StakeholderAssignment_23160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Stakeholder__NameAssignment_0_13191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__FullnameAssignment_0_3_0_23222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__TitleAssignment_0_3_1_13253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__DescriptionAssignment_0_3_2_13284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__RoleAssignment_0_3_3_13315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__EmailAssignment_0_3_4_13346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Stakeholder__PhoneAssignment_0_3_5_13377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQID_in_rule__Stakeholder__SupervisorAssignment_1_0_13412 = new BitSet(new long[]{0x0000000000000002L});

}
