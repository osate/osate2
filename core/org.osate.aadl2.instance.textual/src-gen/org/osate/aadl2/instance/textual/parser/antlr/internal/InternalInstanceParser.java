/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.instance.textual.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.aadl2.instance.textual.services.InstanceGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalInstanceParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INTEGER_LIT", "RULE_REAL_LIT", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_BASED_INTEGER", "RULE_EXTENDED_DIGIT", "RULE_WS", "':'", "'{'", "'}'", "'['", "']'", "'in'", "'modes'", "'('", "','", "')'", "'complete'", "'<->'", "'->'", "'transitions'", "'reverse'", "'flow'", "'end'", "'to'", "'initial'", "'derived'", "'mode'", "'='", "'transition'", "'-['", "']->'", "'som'", "'=>'", "'/'", "'reference'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'dataAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'featureConnection'", "'accessConnection'", "'parameterConnection'", "'portConnection'", "'featureGroupConnection'", "'::'", "'.'", "'#'", "'parent'", "'connection'", "'property'", "'+=>'", "'constant'", "';'", "'true'", "'false'", "'compute'", "'classifier'", "'+'", "'-'", "'..'", "'delta'", "'applies'", "'binding'", "'*'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_DIGIT=9;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_REAL_LIT=7;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_EXPONENT=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_EXTENDED_DIGIT=13;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__90=90;
    public static final int RULE_INT_EXPONENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int RULE_BASED_INTEGER=12;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int RULE_INTEGER_LIT=6;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=14;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalInstanceParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalInstanceParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalInstanceParser.tokenNames; }
    public String getGrammarFileName() { return "InternalInstance.g"; }



     	private InstanceGrammarAccess grammarAccess;
     	
        public InternalInstanceParser(TokenStream input, InstanceGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "SystemInstance";	
       	}
       	
       	@Override
       	protected InstanceGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleSystemInstance"
    // InternalInstance.g:97:1: entryRuleSystemInstance returns [EObject current=null] : iv_ruleSystemInstance= ruleSystemInstance EOF ;
    public final EObject entryRuleSystemInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemInstance = null;


        try {
            // InternalInstance.g:98:2: (iv_ruleSystemInstance= ruleSystemInstance EOF )
            // InternalInstance.g:99:2: iv_ruleSystemInstance= ruleSystemInstance EOF
            {
             newCompositeNode(grammarAccess.getSystemInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystemInstance=ruleSystemInstance();

            state._fsp--;

             current =iv_ruleSystemInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystemInstance"


    // $ANTLR start "ruleSystemInstance"
    // InternalInstance.g:106:1: ruleSystemInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}' ) ;
    public final EObject ruleSystemInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_5_0 = null;

        EObject lv_componentInstance_6_0 = null;

        EObject lv_connectionInstance_7_0 = null;

        EObject lv_flowSpecification_8_0 = null;

        EObject lv_endToEndFlow_9_0 = null;

        EObject lv_modeInstance_10_0 = null;

        EObject lv_modeTransitionInstance_11_0 = null;

        EObject lv_systemOperationMode_12_0 = null;

        EObject lv_ownedPropertyAssociation_13_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:109:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}' ) )
            // InternalInstance.g:110:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}' )
            {
            // InternalInstance.g:110:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}' )
            // InternalInstance.g:110:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}'
            {
            // InternalInstance.g:110:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // InternalInstance.g:111:1: (lv_category_0_0= ruleComponentCategory )
            {
            // InternalInstance.g:111:1: (lv_category_0_0= ruleComponentCategory )
            // InternalInstance.g:112:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_3);
            lv_category_0_0=ruleComponentCategory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"org.osate.aadl2.instance.textual.Instance.ComponentCategory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:128:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalInstance.g:129:1: (lv_name_1_0= RULE_ID )
            {
            // InternalInstance.g:129:1: (lv_name_1_0= RULE_ID )
            // InternalInstance.g:130:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getSystemInstanceAccess().getColonKeyword_2());
                
            // InternalInstance.g:150:1: ( ( ruleImplRef ) )
            // InternalInstance.g:151:1: ( ruleImplRef )
            {
            // InternalInstance.g:151:1: ( ruleImplRef )
            // InternalInstance.g:152:3: ruleImplRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_5);
            ruleImplRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_6); 

                	newLeafNode(otherlv_4, grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4());
                
            // InternalInstance.g:169:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )*
            loop1:
            do {
                int alt1=10;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // InternalInstance.g:169:2: ( (lv_featureInstance_5_0= ruleFeatureInstance ) )
            	    {
            	    // InternalInstance.g:169:2: ( (lv_featureInstance_5_0= ruleFeatureInstance ) )
            	    // InternalInstance.g:170:1: (lv_featureInstance_5_0= ruleFeatureInstance )
            	    {
            	    // InternalInstance.g:170:1: (lv_featureInstance_5_0= ruleFeatureInstance )
            	    // InternalInstance.g:171:3: lv_featureInstance_5_0= ruleFeatureInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_featureInstance_5_0=ruleFeatureInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"featureInstance",
            	            		lv_featureInstance_5_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.FeatureInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalInstance.g:188:6: ( (lv_componentInstance_6_0= ruleComponentInstance ) )
            	    {
            	    // InternalInstance.g:188:6: ( (lv_componentInstance_6_0= ruleComponentInstance ) )
            	    // InternalInstance.g:189:1: (lv_componentInstance_6_0= ruleComponentInstance )
            	    {
            	    // InternalInstance.g:189:1: (lv_componentInstance_6_0= ruleComponentInstance )
            	    // InternalInstance.g:190:3: lv_componentInstance_6_0= ruleComponentInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_componentInstance_6_0=ruleComponentInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"componentInstance",
            	            		lv_componentInstance_6_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.ComponentInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalInstance.g:207:6: ( (lv_connectionInstance_7_0= ruleConnectionInstance ) )
            	    {
            	    // InternalInstance.g:207:6: ( (lv_connectionInstance_7_0= ruleConnectionInstance ) )
            	    // InternalInstance.g:208:1: (lv_connectionInstance_7_0= ruleConnectionInstance )
            	    {
            	    // InternalInstance.g:208:1: (lv_connectionInstance_7_0= ruleConnectionInstance )
            	    // InternalInstance.g:209:3: lv_connectionInstance_7_0= ruleConnectionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_connectionInstance_7_0=ruleConnectionInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionInstance",
            	            		lv_connectionInstance_7_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.ConnectionInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalInstance.g:226:6: ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) )
            	    {
            	    // InternalInstance.g:226:6: ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) )
            	    // InternalInstance.g:227:1: (lv_flowSpecification_8_0= ruleFlowSpecificationInstance )
            	    {
            	    // InternalInstance.g:227:1: (lv_flowSpecification_8_0= ruleFlowSpecificationInstance )
            	    // InternalInstance.g:228:3: lv_flowSpecification_8_0= ruleFlowSpecificationInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_flowSpecification_8_0=ruleFlowSpecificationInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"flowSpecification",
            	            		lv_flowSpecification_8_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.FlowSpecificationInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalInstance.g:245:6: ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) )
            	    {
            	    // InternalInstance.g:245:6: ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) )
            	    // InternalInstance.g:246:1: (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance )
            	    {
            	    // InternalInstance.g:246:1: (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance )
            	    // InternalInstance.g:247:3: lv_endToEndFlow_9_0= ruleEndToEndFlowInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_5_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_endToEndFlow_9_0=ruleEndToEndFlowInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"endToEndFlow",
            	            		lv_endToEndFlow_9_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.EndToEndFlowInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalInstance.g:264:6: ( (lv_modeInstance_10_0= ruleModeInstance ) )
            	    {
            	    // InternalInstance.g:264:6: ( (lv_modeInstance_10_0= ruleModeInstance ) )
            	    // InternalInstance.g:265:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    {
            	    // InternalInstance.g:265:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    // InternalInstance.g:266:3: lv_modeInstance_10_0= ruleModeInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getModeInstanceModeInstanceParserRuleCall_5_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_modeInstance_10_0=ruleModeInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modeInstance",
            	            		lv_modeInstance_10_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.ModeInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalInstance.g:283:6: ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )
            	    {
            	    // InternalInstance.g:283:6: ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )
            	    // InternalInstance.g:284:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    {
            	    // InternalInstance.g:284:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    // InternalInstance.g:285:3: lv_modeTransitionInstance_11_0= ruleModeTransitionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_5_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_modeTransitionInstance_11_0=ruleModeTransitionInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modeTransitionInstance",
            	            		lv_modeTransitionInstance_11_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.ModeTransitionInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalInstance.g:302:6: ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )
            	    {
            	    // InternalInstance.g:302:6: ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )
            	    // InternalInstance.g:303:1: (lv_systemOperationMode_12_0= ruleSystemOperationMode )
            	    {
            	    // InternalInstance.g:303:1: (lv_systemOperationMode_12_0= ruleSystemOperationMode )
            	    // InternalInstance.g:304:3: lv_systemOperationMode_12_0= ruleSystemOperationMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_systemOperationMode_12_0=ruleSystemOperationMode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systemOperationMode",
            	            		lv_systemOperationMode_12_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.SystemOperationMode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalInstance.g:321:6: ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) )
            	    {
            	    // InternalInstance.g:321:6: ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) )
            	    // InternalInstance.g:322:1: (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance )
            	    {
            	    // InternalInstance.g:322:1: (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance )
            	    // InternalInstance.g:323:3: lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_5_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_ownedPropertyAssociation_13_0=rulePropertyAssociationInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedPropertyAssociation",
            	            		lv_ownedPropertyAssociation_13_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_14=(Token)match(input,17,FOLLOW_2); 

                	newLeafNode(otherlv_14, grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemInstance"


    // $ANTLR start "entryRuleFeatureInstance"
    // InternalInstance.g:351:1: entryRuleFeatureInstance returns [EObject current=null] : iv_ruleFeatureInstance= ruleFeatureInstance EOF ;
    public final EObject entryRuleFeatureInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureInstance = null;


        try {
            // InternalInstance.g:352:2: (iv_ruleFeatureInstance= ruleFeatureInstance EOF )
            // InternalInstance.g:353:2: iv_ruleFeatureInstance= ruleFeatureInstance EOF
            {
             newCompositeNode(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureInstance=ruleFeatureInstance();

            state._fsp--;

             current =iv_ruleFeatureInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureInstance"


    // $ANTLR start "ruleFeatureInstance"
    // InternalInstance.g:360:1: ruleFeatureInstance returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )? ) ;
    public final EObject ruleFeatureInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_direction_0_0 = null;

        AntlrDatatypeRuleToken lv_category_1_0 = null;

        AntlrDatatypeRuleToken lv_index_4_0 = null;

        EObject lv_featureInstance_9_0 = null;

        EObject lv_ownedPropertyAssociation_10_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:363:28: ( ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )? ) )
            // InternalInstance.g:364:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )? )
            {
            // InternalInstance.g:364:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )? )
            // InternalInstance.g:364:2: ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )?
            {
            // InternalInstance.g:364:2: ( (lv_direction_0_0= ruleDirectionType ) )
            // InternalInstance.g:365:1: (lv_direction_0_0= ruleDirectionType )
            {
            // InternalInstance.g:365:1: (lv_direction_0_0= ruleDirectionType )
            // InternalInstance.g:366:3: lv_direction_0_0= ruleDirectionType
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_7);
            lv_direction_0_0=ruleDirectionType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"direction",
                    		lv_direction_0_0, 
                    		"org.osate.aadl2.instance.textual.Instance.DirectionType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:382:2: ( (lv_category_1_0= ruleFeatureCategory ) )
            // InternalInstance.g:383:1: (lv_category_1_0= ruleFeatureCategory )
            {
            // InternalInstance.g:383:1: (lv_category_1_0= ruleFeatureCategory )
            // InternalInstance.g:384:3: lv_category_1_0= ruleFeatureCategory
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_3);
            lv_category_1_0=ruleFeatureCategory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_1_0, 
                    		"org.osate.aadl2.instance.textual.Instance.FeatureCategory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:400:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalInstance.g:401:1: (lv_name_2_0= RULE_ID )
            {
            // InternalInstance.g:401:1: (lv_name_2_0= RULE_ID )
            // InternalInstance.g:402:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ID");
            	    

            }


            }

            // InternalInstance.g:418:2: (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalInstance.g:418:4: otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_9); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // InternalInstance.g:422:1: ( (lv_index_4_0= ruleLong ) )
                    // InternalInstance.g:423:1: (lv_index_4_0= ruleLong )
                    {
                    // InternalInstance.g:423:1: (lv_index_4_0= ruleLong )
                    // InternalInstance.g:424:3: lv_index_4_0= ruleLong
                    {
                     
                    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getIndexLongParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_10);
                    lv_index_4_0=ruleLong();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_4_0, 
                            		"org.osate.aadl2.instance.textual.Instance.Long");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_4); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getColonKeyword_4());
                
            // InternalInstance.g:448:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:449:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:449:1: ( ruleDeclarativeRef )
            // InternalInstance.g:450:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_11);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:463:2: (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalInstance.g:463:4: otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_6); 

                        	newLeafNode(otherlv_8, grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_6_0());
                        
                    // InternalInstance.g:467:1: ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==20||LA3_0==44) ) {
                            alt3=1;
                        }
                        else if ( (LA3_0==RULE_ID) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalInstance.g:467:2: ( (lv_featureInstance_9_0= ruleFeatureInstance ) )
                    	    {
                    	    // InternalInstance.g:467:2: ( (lv_featureInstance_9_0= ruleFeatureInstance ) )
                    	    // InternalInstance.g:468:1: (lv_featureInstance_9_0= ruleFeatureInstance )
                    	    {
                    	    // InternalInstance.g:468:1: (lv_featureInstance_9_0= ruleFeatureInstance )
                    	    // InternalInstance.g:469:3: lv_featureInstance_9_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_featureInstance_9_0=ruleFeatureInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureInstance",
                    	            		lv_featureInstance_9_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.FeatureInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalInstance.g:486:6: ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) )
                    	    {
                    	    // InternalInstance.g:486:6: ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) )
                    	    // InternalInstance.g:487:1: (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance )
                    	    {
                    	    // InternalInstance.g:487:1: (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance )
                    	    // InternalInstance.g:488:3: lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_ownedPropertyAssociation_10_0=rulePropertyAssociationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedPropertyAssociation",
                    	            		lv_ownedPropertyAssociation_10_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,17,FOLLOW_2); 

                        	newLeafNode(otherlv_11, grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_6_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureInstance"


    // $ANTLR start "entryRuleComponentInstance"
    // InternalInstance.g:516:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // InternalInstance.g:517:2: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // InternalInstance.g:518:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentInstance"


    // $ANTLR start "ruleComponentInstance"
    // InternalInstance.g:525:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( ( ruleClassifierRef ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )* (otherlv_6= 'in' otherlv_7= 'modes' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= ':' ( ( ruleDeclarativeRef ) ) (otherlv_15= '{' ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )* otherlv_24= '}' )? ) ;
    public final EObject ruleComponentInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_24=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        AntlrDatatypeRuleToken lv_index_4_0 = null;

        EObject lv_featureInstance_16_0 = null;

        EObject lv_componentInstance_17_0 = null;

        EObject lv_connectionInstance_18_0 = null;

        EObject lv_flowSpecification_19_0 = null;

        EObject lv_endToEndFlow_20_0 = null;

        EObject lv_modeInstance_21_0 = null;

        EObject lv_modeTransitionInstance_22_0 = null;

        EObject lv_ownedPropertyAssociation_23_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:528:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( ( ruleClassifierRef ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )* (otherlv_6= 'in' otherlv_7= 'modes' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= ':' ( ( ruleDeclarativeRef ) ) (otherlv_15= '{' ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )* otherlv_24= '}' )? ) )
            // InternalInstance.g:529:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( ( ruleClassifierRef ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )* (otherlv_6= 'in' otherlv_7= 'modes' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= ':' ( ( ruleDeclarativeRef ) ) (otherlv_15= '{' ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )* otherlv_24= '}' )? )
            {
            // InternalInstance.g:529:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( ( ruleClassifierRef ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )* (otherlv_6= 'in' otherlv_7= 'modes' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= ':' ( ( ruleDeclarativeRef ) ) (otherlv_15= '{' ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )* otherlv_24= '}' )? )
            // InternalInstance.g:529:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( ( ruleClassifierRef ) )? ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )* (otherlv_6= 'in' otherlv_7= 'modes' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= ':' ( ( ruleDeclarativeRef ) ) (otherlv_15= '{' ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )* otherlv_24= '}' )?
            {
            // InternalInstance.g:529:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // InternalInstance.g:530:1: (lv_category_0_0= ruleComponentCategory )
            {
            // InternalInstance.g:530:1: (lv_category_0_0= ruleComponentCategory )
            // InternalInstance.g:531:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_3);
            lv_category_0_0=ruleComponentCategory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"org.osate.aadl2.instance.textual.Instance.ComponentCategory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:547:2: ( ( ruleClassifierRef ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==72) ) {
                    alt5=1;
                }
            }
            switch (alt5) {
                case 1 :
                    // InternalInstance.g:548:1: ( ruleClassifierRef )
                    {
                    // InternalInstance.g:548:1: ( ruleClassifierRef )
                    // InternalInstance.g:549:3: ruleClassifierRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getClassifierComponentClassifierCrossReference_1_0()); 
                    	    
                    pushFollow(FOLLOW_3);
                    ruleClassifierRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:562:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalInstance.g:563:1: (lv_name_2_0= RULE_ID )
            {
            // InternalInstance.g:563:1: (lv_name_2_0= RULE_ID )
            // InternalInstance.g:564:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            			newLeafNode(lv_name_2_0, grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ID");
            	    

            }


            }

            // InternalInstance.g:580:2: (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalInstance.g:580:4: otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']'
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_9); 

            	        	newLeafNode(otherlv_3, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0());
            	        
            	    // InternalInstance.g:584:1: ( (lv_index_4_0= ruleLong ) )
            	    // InternalInstance.g:585:1: (lv_index_4_0= ruleLong )
            	    {
            	    // InternalInstance.g:585:1: (lv_index_4_0= ruleLong )
            	    // InternalInstance.g:586:3: lv_index_4_0= ruleLong
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getIndexLongParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_10);
            	    lv_index_4_0=ruleLong();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"index",
            	            		lv_index_4_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.Long");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_5=(Token)match(input,19,FOLLOW_12); 

            	        	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalInstance.g:606:3: (otherlv_6= 'in' otherlv_7= 'modes' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalInstance.g:606:5: otherlv_6= 'in' otherlv_7= 'modes' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')'
                    {
                    otherlv_6=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_6, grammarAccess.getComponentInstanceAccess().getInKeyword_4_0());
                        
                    otherlv_7=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getModesKeyword_4_1());
                        
                    otherlv_8=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_8, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_4_2());
                        
                    // InternalInstance.g:618:1: ( (otherlv_9= RULE_ID ) )
                    // InternalInstance.g:619:1: (otherlv_9= RULE_ID )
                    {
                    // InternalInstance.g:619:1: (otherlv_9= RULE_ID )
                    // InternalInstance.g:620:3: otherlv_9= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_15); 

                    		newLeafNode(otherlv_9, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_4_3_0()); 
                    	

                    }


                    }

                    // InternalInstance.g:631:2: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==23) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalInstance.g:631:4: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getComponentInstanceAccess().getCommaKeyword_4_4_0());
                    	        
                    	    // InternalInstance.g:635:1: ( (otherlv_11= RULE_ID ) )
                    	    // InternalInstance.g:636:1: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalInstance.g:636:1: (otherlv_11= RULE_ID )
                    	    // InternalInstance.g:637:3: otherlv_11= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_15); 

                    	    		newLeafNode(otherlv_11, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_4_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,24,FOLLOW_4); 

                        	newLeafNode(otherlv_12, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_4_5());
                        

                    }
                    break;

            }

            otherlv_13=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_13, grammarAccess.getComponentInstanceAccess().getColonKeyword_5());
                
            // InternalInstance.g:656:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:657:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:657:1: ( ruleDeclarativeRef )
            // InternalInstance.g:658:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_11);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:671:2: (otherlv_15= '{' ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )* otherlv_24= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalInstance.g:671:4: otherlv_15= '{' ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )* otherlv_24= '}'
                    {
                    otherlv_15=(Token)match(input,16,FOLLOW_6); 

                        	newLeafNode(otherlv_15, grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalInstance.g:675:1: ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )*
                    loop9:
                    do {
                        int alt9=9;
                        alt9 = dfa9.predict(input);
                        switch (alt9) {
                    	case 1 :
                    	    // InternalInstance.g:675:2: ( (lv_featureInstance_16_0= ruleFeatureInstance ) )
                    	    {
                    	    // InternalInstance.g:675:2: ( (lv_featureInstance_16_0= ruleFeatureInstance ) )
                    	    // InternalInstance.g:676:1: (lv_featureInstance_16_0= ruleFeatureInstance )
                    	    {
                    	    // InternalInstance.g:676:1: (lv_featureInstance_16_0= ruleFeatureInstance )
                    	    // InternalInstance.g:677:3: lv_featureInstance_16_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_featureInstance_16_0=ruleFeatureInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureInstance",
                    	            		lv_featureInstance_16_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.FeatureInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalInstance.g:694:6: ( (lv_componentInstance_17_0= ruleComponentInstance ) )
                    	    {
                    	    // InternalInstance.g:694:6: ( (lv_componentInstance_17_0= ruleComponentInstance ) )
                    	    // InternalInstance.g:695:1: (lv_componentInstance_17_0= ruleComponentInstance )
                    	    {
                    	    // InternalInstance.g:695:1: (lv_componentInstance_17_0= ruleComponentInstance )
                    	    // InternalInstance.g:696:3: lv_componentInstance_17_0= ruleComponentInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_componentInstance_17_0=ruleComponentInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"componentInstance",
                    	            		lv_componentInstance_17_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.ComponentInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // InternalInstance.g:713:6: ( (lv_connectionInstance_18_0= ruleConnectionInstance ) )
                    	    {
                    	    // InternalInstance.g:713:6: ( (lv_connectionInstance_18_0= ruleConnectionInstance ) )
                    	    // InternalInstance.g:714:1: (lv_connectionInstance_18_0= ruleConnectionInstance )
                    	    {
                    	    // InternalInstance.g:714:1: (lv_connectionInstance_18_0= ruleConnectionInstance )
                    	    // InternalInstance.g:715:3: lv_connectionInstance_18_0= ruleConnectionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_connectionInstance_18_0=ruleConnectionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connectionInstance",
                    	            		lv_connectionInstance_18_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.ConnectionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // InternalInstance.g:732:6: ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) )
                    	    {
                    	    // InternalInstance.g:732:6: ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) )
                    	    // InternalInstance.g:733:1: (lv_flowSpecification_19_0= ruleFlowSpecificationInstance )
                    	    {
                    	    // InternalInstance.g:733:1: (lv_flowSpecification_19_0= ruleFlowSpecificationInstance )
                    	    // InternalInstance.g:734:3: lv_flowSpecification_19_0= ruleFlowSpecificationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_7_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_flowSpecification_19_0=ruleFlowSpecificationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"flowSpecification",
                    	            		lv_flowSpecification_19_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.FlowSpecificationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // InternalInstance.g:751:6: ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) )
                    	    {
                    	    // InternalInstance.g:751:6: ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) )
                    	    // InternalInstance.g:752:1: (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance )
                    	    {
                    	    // InternalInstance.g:752:1: (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance )
                    	    // InternalInstance.g:753:3: lv_endToEndFlow_20_0= ruleEndToEndFlowInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_7_1_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_endToEndFlow_20_0=ruleEndToEndFlowInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"endToEndFlow",
                    	            		lv_endToEndFlow_20_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.EndToEndFlowInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 6 :
                    	    // InternalInstance.g:770:6: ( (lv_modeInstance_21_0= ruleModeInstance ) )
                    	    {
                    	    // InternalInstance.g:770:6: ( (lv_modeInstance_21_0= ruleModeInstance ) )
                    	    // InternalInstance.g:771:1: (lv_modeInstance_21_0= ruleModeInstance )
                    	    {
                    	    // InternalInstance.g:771:1: (lv_modeInstance_21_0= ruleModeInstance )
                    	    // InternalInstance.g:772:3: lv_modeInstance_21_0= ruleModeInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_7_1_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_modeInstance_21_0=ruleModeInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeInstance",
                    	            		lv_modeInstance_21_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.ModeInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 7 :
                    	    // InternalInstance.g:789:6: ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) )
                    	    {
                    	    // InternalInstance.g:789:6: ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) )
                    	    // InternalInstance.g:790:1: (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance )
                    	    {
                    	    // InternalInstance.g:790:1: (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance )
                    	    // InternalInstance.g:791:3: lv_modeTransitionInstance_22_0= ruleModeTransitionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_7_1_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_modeTransitionInstance_22_0=ruleModeTransitionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeTransitionInstance",
                    	            		lv_modeTransitionInstance_22_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.ModeTransitionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 8 :
                    	    // InternalInstance.g:808:6: ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) )
                    	    {
                    	    // InternalInstance.g:808:6: ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) )
                    	    // InternalInstance.g:809:1: (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance )
                    	    {
                    	    // InternalInstance.g:809:1: (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance )
                    	    // InternalInstance.g:810:3: lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_ownedPropertyAssociation_23_0=rulePropertyAssociationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedPropertyAssociation",
                    	            		lv_ownedPropertyAssociation_23_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,17,FOLLOW_2); 

                        	newLeafNode(otherlv_24, grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentInstance"


    // $ANTLR start "entryRuleConnectionInstance"
    // InternalInstance.g:838:1: entryRuleConnectionInstance returns [EObject current=null] : iv_ruleConnectionInstance= ruleConnectionInstance EOF ;
    public final EObject entryRuleConnectionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionInstance = null;


        try {
            // InternalInstance.g:839:2: (iv_ruleConnectionInstance= ruleConnectionInstance EOF )
            // InternalInstance.g:840:2: iv_ruleConnectionInstance= ruleConnectionInstance EOF
            {
             newCompositeNode(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConnectionInstance=ruleConnectionInstance();

            state._fsp--;

             current =iv_ruleConnectionInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionInstance"


    // $ANTLR start "ruleConnectionInstance"
    // InternalInstance.g:847:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' ) ;
    public final EObject ruleConnectionInstance() throws RecognitionException {
        EObject current = null;

        Token lv_complete_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_bidirectional_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_25=null;
        AntlrDatatypeRuleToken lv_kind_1_0 = null;

        EObject lv_connectionReference_23_0 = null;

        EObject lv_ownedPropertyAssociation_24_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:850:28: ( ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' ) )
            // InternalInstance.g:851:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' )
            {
            // InternalInstance.g:851:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' )
            // InternalInstance.g:851:2: ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}'
            {
            // InternalInstance.g:851:2: ( (lv_complete_0_0= 'complete' ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalInstance.g:852:1: (lv_complete_0_0= 'complete' )
                    {
                    // InternalInstance.g:852:1: (lv_complete_0_0= 'complete' )
                    // InternalInstance.g:853:3: lv_complete_0_0= 'complete'
                    {
                    lv_complete_0_0=(Token)match(input,25,FOLLOW_16); 

                            newLeafNode(lv_complete_0_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "complete", true, "complete");
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:866:3: ( (lv_kind_1_0= ruleConnectionKind ) )
            // InternalInstance.g:867:1: (lv_kind_1_0= ruleConnectionKind )
            {
            // InternalInstance.g:867:1: (lv_kind_1_0= ruleConnectionKind )
            // InternalInstance.g:868:3: lv_kind_1_0= ruleConnectionKind
            {
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_17);
            lv_kind_1_0=ruleConnectionKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"kind",
                    		lv_kind_1_0, 
                    		"org.osate.aadl2.instance.textual.Instance.ConnectionKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:884:2: ( (lv_name_2_0= RULE_STRING ) )
            // InternalInstance.g:885:1: (lv_name_2_0= RULE_STRING )
            {
            // InternalInstance.g:885:1: (lv_name_2_0= RULE_STRING )
            // InternalInstance.g:886:3: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

            			newLeafNode(lv_name_2_0, grammarAccess.getConnectionInstanceAccess().getNameSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_18); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getColonKeyword_3());
                
            // InternalInstance.g:906:1: ( ( ruleInstanceRef ) )
            // InternalInstance.g:907:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:907:1: ( ruleInstanceRef )
            // InternalInstance.g:908:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_19);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:921:2: ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            else if ( (LA12_0==27) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalInstance.g:921:3: ( (lv_bidirectional_5_0= '<->' ) )
                    {
                    // InternalInstance.g:921:3: ( (lv_bidirectional_5_0= '<->' ) )
                    // InternalInstance.g:922:1: (lv_bidirectional_5_0= '<->' )
                    {
                    // InternalInstance.g:922:1: (lv_bidirectional_5_0= '<->' )
                    // InternalInstance.g:923:3: lv_bidirectional_5_0= '<->'
                    {
                    lv_bidirectional_5_0=(Token)match(input,26,FOLLOW_18); 

                            newLeafNode(lv_bidirectional_5_0, grammarAccess.getConnectionInstanceAccess().getBidirectionalLessThanSignHyphenMinusGreaterThanSignKeyword_5_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "bidirectional", true, "<->");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalInstance.g:937:7: otherlv_6= '->'
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_18); 

                        	newLeafNode(otherlv_6, grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1());
                        

                    }
                    break;

            }

            // InternalInstance.g:941:2: ( ( ruleInstanceRef ) )
            // InternalInstance.g:942:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:942:1: ( ruleInstanceRef )
            // InternalInstance.g:943:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_20);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:956:2: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==20) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==21) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalInstance.g:956:4: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_8, grammarAccess.getConnectionInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_9, grammarAccess.getConnectionInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // InternalInstance.g:968:1: ( (otherlv_11= RULE_ID ) )
                    // InternalInstance.g:969:1: (otherlv_11= RULE_ID )
                    {
                    // InternalInstance.g:969:1: (otherlv_11= RULE_ID )
                    // InternalInstance.g:970:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_15); 

                    		newLeafNode(otherlv_11, grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_3_0()); 
                    	

                    }


                    }

                    // InternalInstance.g:981:2: (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==23) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalInstance.g:981:4: otherlv_12= ',' ( (otherlv_13= RULE_ID ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // InternalInstance.g:985:1: ( (otherlv_13= RULE_ID ) )
                    	    // InternalInstance.g:986:1: (otherlv_13= RULE_ID )
                    	    {
                    	    // InternalInstance.g:986:1: (otherlv_13= RULE_ID )
                    	    // InternalInstance.g:987:3: otherlv_13= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_15); 

                    	    		newLeafNode(otherlv_13, grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,24,FOLLOW_20); 

                        	newLeafNode(otherlv_14, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // InternalInstance.g:1002:3: (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalInstance.g:1002:5: otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')'
                    {
                    otherlv_15=(Token)match(input,20,FOLLOW_21); 

                        	newLeafNode(otherlv_15, grammarAccess.getConnectionInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_16=(Token)match(input,28,FOLLOW_14); 

                        	newLeafNode(otherlv_16, grammarAccess.getConnectionInstanceAccess().getTransitionsKeyword_8_1());
                        
                    otherlv_17=(Token)match(input,22,FOLLOW_22); 

                        	newLeafNode(otherlv_17, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_8_2());
                        
                    // InternalInstance.g:1014:1: ( ( ruleTransitionRef ) )
                    // InternalInstance.g:1015:1: ( ruleTransitionRef )
                    {
                    // InternalInstance.g:1015:1: ( ruleTransitionRef )
                    // InternalInstance.g:1016:3: ruleTransitionRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); 
                    	    
                    pushFollow(FOLLOW_15);
                    ruleTransitionRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:1029:2: (otherlv_19= ',' ( ( ruleTransitionRef ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==23) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalInstance.g:1029:4: otherlv_19= ',' ( ( ruleTransitionRef ) )
                    	    {
                    	    otherlv_19=(Token)match(input,23,FOLLOW_22); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_8_4_0());
                    	        
                    	    // InternalInstance.g:1033:1: ( ( ruleTransitionRef ) )
                    	    // InternalInstance.g:1034:1: ( ruleTransitionRef )
                    	    {
                    	    // InternalInstance.g:1034:1: ( ruleTransitionRef )
                    	    // InternalInstance.g:1035:3: ruleTransitionRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_15);
                    	    ruleTransitionRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,24,FOLLOW_5); 

                        	newLeafNode(otherlv_21, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_8_5());
                        

                    }
                    break;

            }

            otherlv_22=(Token)match(input,16,FOLLOW_23); 

                	newLeafNode(otherlv_22, grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_9());
                
            // InternalInstance.g:1056:1: ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=75 && LA17_0<=76)) ) {
                    alt17=1;
                }
                else if ( (LA17_0==RULE_ID) ) {
                    int LA17_3 = input.LA(2);

                    if ( (LA17_3==18||LA17_3==27||LA17_3==73) ) {
                        alt17=1;
                    }
                    else if ( (LA17_3==41||LA17_3==72) ) {
                        alt17=2;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // InternalInstance.g:1056:2: ( (lv_connectionReference_23_0= ruleConnectionReference ) )
            	    {
            	    // InternalInstance.g:1056:2: ( (lv_connectionReference_23_0= ruleConnectionReference ) )
            	    // InternalInstance.g:1057:1: (lv_connectionReference_23_0= ruleConnectionReference )
            	    {
            	    // InternalInstance.g:1057:1: (lv_connectionReference_23_0= ruleConnectionReference )
            	    // InternalInstance.g:1058:3: lv_connectionReference_23_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_10_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_24);
            	    lv_connectionReference_23_0=ruleConnectionReference();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionReference",
            	            		lv_connectionReference_23_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.ConnectionReference");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalInstance.g:1075:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
            	    {
            	    // InternalInstance.g:1075:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
            	    // InternalInstance.g:1076:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
            	    {
            	    // InternalInstance.g:1076:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
            	    // InternalInstance.g:1077:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_24);
            	    lv_ownedPropertyAssociation_24_0=rulePropertyAssociationInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedPropertyAssociation",
            	            		lv_ownedPropertyAssociation_24_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);

            otherlv_25=(Token)match(input,17,FOLLOW_2); 

                	newLeafNode(otherlv_25, grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_11());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionInstance"


    // $ANTLR start "entryRuleConnectionReference"
    // InternalInstance.g:1105:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // InternalInstance.g:1106:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // InternalInstance.g:1107:2: iv_ruleConnectionReference= ruleConnectionReference EOF
            {
             newCompositeNode(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConnectionReference=ruleConnectionReference();

            state._fsp--;

             current =iv_ruleConnectionReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionReference"


    // $ANTLR start "ruleConnectionReference"
    // InternalInstance.g:1114:1: ruleConnectionReference returns [EObject current=null] : ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( (lv_reverse_4_0= 'reverse' ) )? ( ( ruleDeclarativeRef ) ) otherlv_6= 'in' ( ( ruleInstanceRef ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token lv_reverse_4_0=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:1117:28: ( ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( (lv_reverse_4_0= 'reverse' ) )? ( ( ruleDeclarativeRef ) ) otherlv_6= 'in' ( ( ruleInstanceRef ) ) ) )
            // InternalInstance.g:1118:1: ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( (lv_reverse_4_0= 'reverse' ) )? ( ( ruleDeclarativeRef ) ) otherlv_6= 'in' ( ( ruleInstanceRef ) ) )
            {
            // InternalInstance.g:1118:1: ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( (lv_reverse_4_0= 'reverse' ) )? ( ( ruleDeclarativeRef ) ) otherlv_6= 'in' ( ( ruleInstanceRef ) ) )
            // InternalInstance.g:1118:2: ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( (lv_reverse_4_0= 'reverse' ) )? ( ( ruleDeclarativeRef ) ) otherlv_6= 'in' ( ( ruleInstanceRef ) )
            {
            // InternalInstance.g:1118:2: ( ( ruleInstanceRef ) )
            // InternalInstance.g:1119:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:1119:1: ( ruleInstanceRef )
            // InternalInstance.g:1120:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_25);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_18); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
                
            // InternalInstance.g:1137:1: ( ( ruleInstanceRef ) )
            // InternalInstance.g:1138:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:1138:1: ( ruleInstanceRef )
            // InternalInstance.g:1139:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_4);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_26); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionReferenceAccess().getColonKeyword_3());
                
            // InternalInstance.g:1156:1: ( (lv_reverse_4_0= 'reverse' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==29) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalInstance.g:1157:1: (lv_reverse_4_0= 'reverse' )
                    {
                    // InternalInstance.g:1157:1: (lv_reverse_4_0= 'reverse' )
                    // InternalInstance.g:1158:3: lv_reverse_4_0= 'reverse'
                    {
                    lv_reverse_4_0=(Token)match(input,29,FOLLOW_3); 

                            newLeafNode(lv_reverse_4_0, grammarAccess.getConnectionReferenceAccess().getReverseReverseKeyword_4_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
                    	        }
                           		setWithLastConsumed(current, "reverse", true, "reverse");
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:1171:3: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1172:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1172:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1173:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_27);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,20,FOLLOW_18); 

                	newLeafNode(otherlv_6, grammarAccess.getConnectionReferenceAccess().getInKeyword_6());
                
            // InternalInstance.g:1190:1: ( ( ruleInstanceRef ) )
            // InternalInstance.g:1191:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:1191:1: ( ruleInstanceRef )
            // InternalInstance.g:1192:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_2);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionReference"


    // $ANTLR start "entryRuleFlowSpecificationInstance"
    // InternalInstance.g:1213:1: entryRuleFlowSpecificationInstance returns [EObject current=null] : iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF ;
    public final EObject entryRuleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecificationInstance = null;


        try {
            // InternalInstance.g:1214:2: (iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF )
            // InternalInstance.g:1215:2: iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF
            {
             newCompositeNode(grammarAccess.getFlowSpecificationInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFlowSpecificationInstance=ruleFlowSpecificationInstance();

            state._fsp--;

             current =iv_ruleFlowSpecificationInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSpecificationInstance"


    // $ANTLR start "ruleFlowSpecificationInstance"
    // InternalInstance.g:1222:1: ruleFlowSpecificationInstance returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? ) ;
    public final EObject ruleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        EObject lv_ownedPropertyAssociation_24_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:1225:28: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? ) )
            // InternalInstance.g:1226:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? )
            {
            // InternalInstance.g:1226:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? )
            // InternalInstance.g:1226:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0());
                
            // InternalInstance.g:1230:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalInstance.g:1231:1: (lv_name_1_0= RULE_ID )
            {
            // InternalInstance.g:1231:1: (lv_name_1_0= RULE_ID )
            // InternalInstance.g:1232:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFlowSpecificationInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_28); 

                	newLeafNode(otherlv_2, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2());
                
            // InternalInstance.g:1252:1: ( ( ruleInstanceRef ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID||(LA19_0>=75 && LA19_0<=76)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalInstance.g:1253:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1253:1: ( ruleInstanceRef )
                    // InternalInstance.g:1254:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
                    	    
                    pushFollow(FOLLOW_25);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FOLLOW_29); 

                	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalInstance.g:1271:1: ( ( ruleInstanceRef ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID||(LA20_0>=75 && LA20_0<=76)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalInstance.g:1272:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1272:1: ( ruleInstanceRef )
                    // InternalInstance.g:1273:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_31); 

                	newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6());
                
            // InternalInstance.g:1290:1: (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==20) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==21) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // InternalInstance.g:1290:3: otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_7, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_8=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_8, grammarAccess.getFlowSpecificationInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_9=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_9, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // InternalInstance.g:1302:1: ( (otherlv_10= RULE_ID ) )
                    // InternalInstance.g:1303:1: (otherlv_10= RULE_ID )
                    {
                    // InternalInstance.g:1303:1: (otherlv_10= RULE_ID )
                    // InternalInstance.g:1304:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_15); 

                    		newLeafNode(otherlv_10, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_3_0()); 
                    	

                    }


                    }

                    // InternalInstance.g:1315:2: (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==23) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalInstance.g:1315:4: otherlv_11= ',' ( (otherlv_12= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // InternalInstance.g:1319:1: ( (otherlv_12= RULE_ID ) )
                    	    // InternalInstance.g:1320:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // InternalInstance.g:1320:1: (otherlv_12= RULE_ID )
                    	    // InternalInstance.g:1321:3: otherlv_12= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_15); 

                    	    		newLeafNode(otherlv_12, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,24,FOLLOW_31); 

                        	newLeafNode(otherlv_13, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // InternalInstance.g:1336:3: (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==20) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalInstance.g:1336:5: otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')'
                    {
                    otherlv_14=(Token)match(input,20,FOLLOW_21); 

                        	newLeafNode(otherlv_14, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_15=(Token)match(input,28,FOLLOW_14); 

                        	newLeafNode(otherlv_15, grammarAccess.getFlowSpecificationInstanceAccess().getTransitionsKeyword_8_1());
                        
                    otherlv_16=(Token)match(input,22,FOLLOW_22); 

                        	newLeafNode(otherlv_16, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_8_2());
                        
                    // InternalInstance.g:1348:1: ( ( ruleTransitionRef ) )
                    // InternalInstance.g:1349:1: ( ruleTransitionRef )
                    {
                    // InternalInstance.g:1349:1: ( ruleTransitionRef )
                    // InternalInstance.g:1350:3: ruleTransitionRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); 
                    	    
                    pushFollow(FOLLOW_15);
                    ruleTransitionRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:1363:2: (otherlv_18= ',' ( ( ruleTransitionRef ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==23) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalInstance.g:1363:4: otherlv_18= ',' ( ( ruleTransitionRef ) )
                    	    {
                    	    otherlv_18=(Token)match(input,23,FOLLOW_22); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_8_4_0());
                    	        
                    	    // InternalInstance.g:1367:1: ( ( ruleTransitionRef ) )
                    	    // InternalInstance.g:1368:1: ( ruleTransitionRef )
                    	    {
                    	    // InternalInstance.g:1368:1: ( ruleTransitionRef )
                    	    // InternalInstance.g:1369:3: ruleTransitionRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_15);
                    	    ruleTransitionRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,24,FOLLOW_4); 

                        	newLeafNode(otherlv_20, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_8_5());
                        

                    }
                    break;

            }

            otherlv_21=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_21, grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_9());
                
            // InternalInstance.g:1390:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1391:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1391:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1392:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_10_0()); 
            	    
            pushFollow(FOLLOW_11);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:1405:2: (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==16) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalInstance.g:1405:4: otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}'
                    {
                    otherlv_23=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_23, grammarAccess.getFlowSpecificationInstanceAccess().getLeftCurlyBracketKeyword_11_0());
                        
                    // InternalInstance.g:1409:1: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==RULE_ID) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalInstance.g:1410:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    {
                    	    // InternalInstance.g:1410:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    // InternalInstance.g:1411:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_6);
                    	    lv_ownedPropertyAssociation_24_0=rulePropertyAssociationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedPropertyAssociation",
                    	            		lv_ownedPropertyAssociation_24_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);

                    otherlv_25=(Token)match(input,17,FOLLOW_2); 

                        	newLeafNode(otherlv_25, grammarAccess.getFlowSpecificationInstanceAccess().getRightCurlyBracketKeyword_11_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlowSpecificationInstance"


    // $ANTLR start "entryRuleEndToEndFlowInstance"
    // InternalInstance.g:1439:1: entryRuleEndToEndFlowInstance returns [EObject current=null] : iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF ;
    public final EObject entryRuleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndToEndFlowInstance = null;


        try {
            // InternalInstance.g:1440:2: (iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF )
            // InternalInstance.g:1441:2: iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF
            {
             newCompositeNode(grammarAccess.getEndToEndFlowInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndToEndFlowInstance=ruleEndToEndFlowInstance();

            state._fsp--;

             current =iv_ruleEndToEndFlowInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndToEndFlowInstance"


    // $ANTLR start "ruleEndToEndFlowInstance"
    // InternalInstance.g:1448:1: ruleEndToEndFlowInstance returns [EObject current=null] : (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? ) ;
    public final EObject ruleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_ownedPropertyAssociation_18_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:1451:28: ( (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? ) )
            // InternalInstance.g:1452:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? )
            {
            // InternalInstance.g:1452:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? )
            // InternalInstance.g:1452:3: otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_33); 

                	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0());
                
            otherlv_1=(Token)match(input,32,FOLLOW_34); 

                	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1());
                
            otherlv_2=(Token)match(input,31,FOLLOW_35); 

                	newLeafNode(otherlv_2, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2());
                
            otherlv_3=(Token)match(input,30,FOLLOW_3); 

                	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3());
                
            // InternalInstance.g:1468:1: ( (lv_name_4_0= RULE_ID ) )
            // InternalInstance.g:1469:1: (lv_name_4_0= RULE_ID )
            {
            // InternalInstance.g:1469:1: (lv_name_4_0= RULE_ID )
            // InternalInstance.g:1470:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_36); 

            			newLeafNode(lv_name_4_0, grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ID");
            	    

            }


            }

            // InternalInstance.g:1486:2: ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID||(LA28_0>=75 && LA28_0<=76)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalInstance.g:1486:3: ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )*
                    {
                    // InternalInstance.g:1486:3: ( ( ruleInstanceRef ) )
                    // InternalInstance.g:1487:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1487:1: ( ruleInstanceRef )
                    // InternalInstance.g:1488:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_37);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:1501:2: (otherlv_6= '->' ( ( ruleInstanceRef ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==27) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalInstance.g:1501:4: otherlv_6= '->' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_6=(Token)match(input,27,FOLLOW_18); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0());
                    	        
                    	    // InternalInstance.g:1505:1: ( ( ruleInstanceRef ) )
                    	    // InternalInstance.g:1506:1: ( ruleInstanceRef )
                    	    {
                    	    // InternalInstance.g:1506:1: ( ruleInstanceRef )
                    	    // InternalInstance.g:1507:3: ruleInstanceRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_37);
                    	    ruleInstanceRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalInstance.g:1520:6: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==20) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalInstance.g:1520:8: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( (otherlv_11= RULE_ID ) ) (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_8, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_9, grammarAccess.getEndToEndFlowInstanceAccess().getModesKeyword_6_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_10, grammarAccess.getEndToEndFlowInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // InternalInstance.g:1532:1: ( (otherlv_11= RULE_ID ) )
                    // InternalInstance.g:1533:1: (otherlv_11= RULE_ID )
                    {
                    // InternalInstance.g:1533:1: (otherlv_11= RULE_ID )
                    // InternalInstance.g:1534:3: otherlv_11= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_15); 

                    		newLeafNode(otherlv_11, grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_3_0()); 
                    	

                    }


                    }

                    // InternalInstance.g:1545:2: (otherlv_12= ',' ( (otherlv_13= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==23) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalInstance.g:1545:4: otherlv_12= ',' ( (otherlv_13= RULE_ID ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getEndToEndFlowInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // InternalInstance.g:1549:1: ( (otherlv_13= RULE_ID ) )
                    	    // InternalInstance.g:1550:1: (otherlv_13= RULE_ID )
                    	    {
                    	    // InternalInstance.g:1550:1: (otherlv_13= RULE_ID )
                    	    // InternalInstance.g:1551:3: otherlv_13= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_15); 

                    	    		newLeafNode(otherlv_13, grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,24,FOLLOW_4); 

                        	newLeafNode(otherlv_14, grammarAccess.getEndToEndFlowInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            otherlv_15=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_15, grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_7());
                
            // InternalInstance.g:1570:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1571:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1571:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1572:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_11);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:1585:2: (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==16) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalInstance.g:1585:4: otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}'
                    {
                    otherlv_17=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_17, grammarAccess.getEndToEndFlowInstanceAccess().getLeftCurlyBracketKeyword_9_0());
                        
                    // InternalInstance.g:1589:1: ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) )
                    // InternalInstance.g:1590:1: (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance )
                    {
                    // InternalInstance.g:1590:1: (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance )
                    // InternalInstance.g:1591:3: lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_38);
                    lv_ownedPropertyAssociation_18_0=rulePropertyAssociationInstance();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedPropertyAssociation",
                            		lv_ownedPropertyAssociation_18_0, 
                            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_19=(Token)match(input,17,FOLLOW_2); 

                        	newLeafNode(otherlv_19, grammarAccess.getEndToEndFlowInstanceAccess().getRightCurlyBracketKeyword_9_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndToEndFlowInstance"


    // $ANTLR start "entryRuleModeInstance"
    // InternalInstance.g:1619:1: entryRuleModeInstance returns [EObject current=null] : iv_ruleModeInstance= ruleModeInstance EOF ;
    public final EObject entryRuleModeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeInstance = null;


        try {
            // InternalInstance.g:1620:2: (iv_ruleModeInstance= ruleModeInstance EOF )
            // InternalInstance.g:1621:2: iv_ruleModeInstance= ruleModeInstance EOF
            {
             newCompositeNode(grammarAccess.getModeInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModeInstance=ruleModeInstance();

            state._fsp--;

             current =iv_ruleModeInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModeInstance"


    // $ANTLR start "ruleModeInstance"
    // InternalInstance.g:1628:1: ruleModeInstance returns [EObject current=null] : ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? ) ;
    public final EObject ruleModeInstance() throws RecognitionException {
        EObject current = null;

        Token lv_initial_0_0=null;
        Token lv_derived_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        EObject lv_ownedPropertyAssociation_14_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:1631:28: ( ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? ) )
            // InternalInstance.g:1632:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? )
            {
            // InternalInstance.g:1632:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? )
            // InternalInstance.g:1632:2: ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )?
            {
            // InternalInstance.g:1632:2: ( (lv_initial_0_0= 'initial' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==33) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalInstance.g:1633:1: (lv_initial_0_0= 'initial' )
                    {
                    // InternalInstance.g:1633:1: (lv_initial_0_0= 'initial' )
                    // InternalInstance.g:1634:3: lv_initial_0_0= 'initial'
                    {
                    lv_initial_0_0=(Token)match(input,33,FOLLOW_39); 

                            newLeafNode(lv_initial_0_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:1647:3: ( (lv_derived_1_0= 'derived' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==34) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalInstance.g:1648:1: (lv_derived_1_0= 'derived' )
                    {
                    // InternalInstance.g:1648:1: (lv_derived_1_0= 'derived' )
                    // InternalInstance.g:1649:3: lv_derived_1_0= 'derived'
                    {
                    lv_derived_1_0=(Token)match(input,34,FOLLOW_40); 

                            newLeafNode(lv_derived_1_0, grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "derived");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,35,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getModeInstanceAccess().getModeKeyword_2());
                
            // InternalInstance.g:1666:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalInstance.g:1667:1: (lv_name_3_0= RULE_ID )
            {
            // InternalInstance.g:1667:1: (lv_name_3_0= RULE_ID )
            // InternalInstance.g:1668:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_41); 

            			newLeafNode(lv_name_3_0, grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ID");
            	    

            }


            }

            // InternalInstance.g:1684:2: (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==36) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalInstance.g:1684:4: otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    {
                    otherlv_4=(Token)match(input,36,FOLLOW_42); 

                        	newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getEqualsSignKeyword_4_0());
                        
                    // InternalInstance.g:1688:1: ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_ID) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==22) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalInstance.g:1688:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // InternalInstance.g:1688:2: ( (otherlv_5= RULE_ID ) )
                            // InternalInstance.g:1689:1: (otherlv_5= RULE_ID )
                            {
                            // InternalInstance.g:1689:1: (otherlv_5= RULE_ID )
                            // InternalInstance.g:1690:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_4); 

                            		newLeafNode(otherlv_5, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalInstance.g:1702:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            {
                            // InternalInstance.g:1702:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            // InternalInstance.g:1702:8: otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')'
                            {
                            otherlv_6=(Token)match(input,22,FOLLOW_3); 

                                	newLeafNode(otherlv_6, grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_4_1_1_0());
                                
                            // InternalInstance.g:1706:1: ( (otherlv_7= RULE_ID ) )
                            // InternalInstance.g:1707:1: (otherlv_7= RULE_ID )
                            {
                            // InternalInstance.g:1707:1: (otherlv_7= RULE_ID )
                            // InternalInstance.g:1708:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_43); 

                            		newLeafNode(otherlv_7, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_1_0()); 
                            	

                            }


                            }

                            // InternalInstance.g:1719:2: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+
                            int cnt34=0;
                            loop34:
                            do {
                                int alt34=2;
                                int LA34_0 = input.LA(1);

                                if ( (LA34_0==23) ) {
                                    alt34=1;
                                }


                                switch (alt34) {
                            	case 1 :
                            	    // InternalInstance.g:1719:4: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                            	    {
                            	    otherlv_8=(Token)match(input,23,FOLLOW_3); 

                            	        	newLeafNode(otherlv_8, grammarAccess.getModeInstanceAccess().getCommaKeyword_4_1_1_2_0());
                            	        
                            	    // InternalInstance.g:1723:1: ( (otherlv_9= RULE_ID ) )
                            	    // InternalInstance.g:1724:1: (otherlv_9= RULE_ID )
                            	    {
                            	    // InternalInstance.g:1724:1: (otherlv_9= RULE_ID )
                            	    // InternalInstance.g:1725:3: otherlv_9= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	    	        }
                            	            
                            	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_15); 

                            	    		newLeafNode(otherlv_9, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt34 >= 1 ) break loop34;
                                        EarlyExitException eee =
                                            new EarlyExitException(34, input);
                                        throw eee;
                                }
                                cnt34++;
                            } while (true);

                            otherlv_10=(Token)match(input,24,FOLLOW_4); 

                                	newLeafNode(otherlv_10, grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_4_1_1_3());
                                

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_11, grammarAccess.getModeInstanceAccess().getColonKeyword_5());
                
            // InternalInstance.g:1744:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1745:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1745:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1746:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_11);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:1759:2: (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==16) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalInstance.g:1759:4: otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}'
                    {
                    otherlv_13=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_13, grammarAccess.getModeInstanceAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalInstance.g:1763:1: ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) )
                    // InternalInstance.g:1764:1: (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance )
                    {
                    // InternalInstance.g:1764:1: (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance )
                    // InternalInstance.g:1765:3: lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_38);
                    lv_ownedPropertyAssociation_14_0=rulePropertyAssociationInstance();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModeInstanceRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedPropertyAssociation",
                            		lv_ownedPropertyAssociation_14_0, 
                            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_15=(Token)match(input,17,FOLLOW_2); 

                        	newLeafNode(otherlv_15, grammarAccess.getModeInstanceAccess().getRightCurlyBracketKeyword_7_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModeInstance"


    // $ANTLR start "entryRuleModeTransitionInstance"
    // InternalInstance.g:1793:1: entryRuleModeTransitionInstance returns [EObject current=null] : iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF ;
    public final EObject entryRuleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransitionInstance = null;


        try {
            // InternalInstance.g:1794:2: (iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF )
            // InternalInstance.g:1795:2: iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModeTransitionInstance=ruleModeTransitionInstance();

            state._fsp--;

             current =iv_ruleModeTransitionInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModeTransitionInstance"


    // $ANTLR start "ruleModeTransitionInstance"
    // InternalInstance.g:1802:1: ruleModeTransitionInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '-[' ( ( ( ruleInstanceRef ) ) (otherlv_6= ',' ( ( ruleInstanceRef ) ) )* )? otherlv_8= ']->' ( (otherlv_9= RULE_ID ) ) otherlv_10= ':' ( ( ruleDeclarativeRef ) ) (otherlv_12= '{' ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) otherlv_14= '}' )? ) ;
    public final EObject ruleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_ownedPropertyAssociation_13_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:1805:28: ( (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '-[' ( ( ( ruleInstanceRef ) ) (otherlv_6= ',' ( ( ruleInstanceRef ) ) )* )? otherlv_8= ']->' ( (otherlv_9= RULE_ID ) ) otherlv_10= ':' ( ( ruleDeclarativeRef ) ) (otherlv_12= '{' ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) otherlv_14= '}' )? ) )
            // InternalInstance.g:1806:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '-[' ( ( ( ruleInstanceRef ) ) (otherlv_6= ',' ( ( ruleInstanceRef ) ) )* )? otherlv_8= ']->' ( (otherlv_9= RULE_ID ) ) otherlv_10= ':' ( ( ruleDeclarativeRef ) ) (otherlv_12= '{' ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) otherlv_14= '}' )? )
            {
            // InternalInstance.g:1806:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '-[' ( ( ( ruleInstanceRef ) ) (otherlv_6= ',' ( ( ruleInstanceRef ) ) )* )? otherlv_8= ']->' ( (otherlv_9= RULE_ID ) ) otherlv_10= ':' ( ( ruleDeclarativeRef ) ) (otherlv_12= '{' ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) otherlv_14= '}' )? )
            // InternalInstance.g:1806:3: otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= RULE_ID ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '-[' ( ( ( ruleInstanceRef ) ) (otherlv_6= ',' ( ( ruleInstanceRef ) ) )* )? otherlv_8= ']->' ( (otherlv_9= RULE_ID ) ) otherlv_10= ':' ( ( ruleDeclarativeRef ) ) (otherlv_12= '{' ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) otherlv_14= '}' )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_22); 

                	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,37,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
                
            // InternalInstance.g:1814:1: ( (lv_name_2_0= RULE_ID ) )
            // InternalInstance.g:1815:1: (lv_name_2_0= RULE_ID )
            {
            // InternalInstance.g:1815:1: (lv_name_2_0= RULE_ID )
            // InternalInstance.g:1816:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            			newLeafNode(lv_name_2_0, grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ID");
            	    

            }


            }

            // InternalInstance.g:1832:2: ( (otherlv_3= RULE_ID ) )
            // InternalInstance.g:1833:1: (otherlv_3= RULE_ID )
            {
            // InternalInstance.g:1833:1: (otherlv_3= RULE_ID )
            // InternalInstance.g:1834:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_44); 

            		newLeafNode(otherlv_3, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,38,FOLLOW_45); 

                	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusLeftSquareBracketKeyword_4());
                
            // InternalInstance.g:1849:1: ( ( ( ruleInstanceRef ) ) (otherlv_6= ',' ( ( ruleInstanceRef ) ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_ID||(LA39_0>=75 && LA39_0<=76)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalInstance.g:1849:2: ( ( ruleInstanceRef ) ) (otherlv_6= ',' ( ( ruleInstanceRef ) ) )*
                    {
                    // InternalInstance.g:1849:2: ( ( ruleInstanceRef ) )
                    // InternalInstance.g:1850:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1850:1: ( ruleInstanceRef )
                    // InternalInstance.g:1851:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceCrossReference_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_46);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:1864:2: (otherlv_6= ',' ( ( ruleInstanceRef ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==23) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalInstance.g:1864:4: otherlv_6= ',' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_18); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getModeTransitionInstanceAccess().getCommaKeyword_5_1_0());
                    	        
                    	    // InternalInstance.g:1868:1: ( ( ruleInstanceRef ) )
                    	    // InternalInstance.g:1869:1: ( ruleInstanceRef )
                    	    {
                    	    // InternalInstance.g:1869:1: ( ruleInstanceRef )
                    	    // InternalInstance.g:1870:3: ruleInstanceRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getTriggerFeatureInstanceCrossReference_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_46);
                    	    ruleInstanceRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,39,FOLLOW_3); 

                	newLeafNode(otherlv_8, grammarAccess.getModeTransitionInstanceAccess().getRightSquareBracketHyphenMinusGreaterThanSignKeyword_6());
                
            // InternalInstance.g:1887:1: ( (otherlv_9= RULE_ID ) )
            // InternalInstance.g:1888:1: (otherlv_9= RULE_ID )
            {
            // InternalInstance.g:1888:1: (otherlv_9= RULE_ID )
            // InternalInstance.g:1889:3: otherlv_9= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_4); 

            		newLeafNode(otherlv_9, grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_7_0()); 
            	

            }


            }

            otherlv_10=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_10, grammarAccess.getModeTransitionInstanceAccess().getColonKeyword_8());
                
            // InternalInstance.g:1904:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1905:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1905:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1906:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_9_0()); 
            	    
            pushFollow(FOLLOW_11);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:1919:2: (otherlv_12= '{' ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) otherlv_14= '}' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==16) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalInstance.g:1919:4: otherlv_12= '{' ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) otherlv_14= '}'
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_12, grammarAccess.getModeTransitionInstanceAccess().getLeftCurlyBracketKeyword_10_0());
                        
                    // InternalInstance.g:1923:1: ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) )
                    // InternalInstance.g:1924:1: (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance )
                    {
                    // InternalInstance.g:1924:1: (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance )
                    // InternalInstance.g:1925:3: lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); 
                    	    
                    pushFollow(FOLLOW_38);
                    lv_ownedPropertyAssociation_13_0=rulePropertyAssociationInstance();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModeTransitionInstanceRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedPropertyAssociation",
                            		lv_ownedPropertyAssociation_13_0, 
                            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_14=(Token)match(input,17,FOLLOW_2); 

                        	newLeafNode(otherlv_14, grammarAccess.getModeTransitionInstanceAccess().getRightCurlyBracketKeyword_10_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModeTransitionInstance"


    // $ANTLR start "entryRuleSystemOperationMode"
    // InternalInstance.g:1953:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // InternalInstance.g:1954:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // InternalInstance.g:1955:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSystemOperationMode"


    // $ANTLR start "ruleSystemOperationMode"
    // InternalInstance.g:1962:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:1965:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) )
            // InternalInstance.g:1966:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            {
            // InternalInstance.g:1966:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            // InternalInstance.g:1966:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            {
            otherlv_0=(Token)match(input,40,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // InternalInstance.g:1970:1: ( (lv_name_1_0= RULE_STRING ) )
            // InternalInstance.g:1971:1: (lv_name_1_0= RULE_STRING )
            {
            // InternalInstance.g:1971:1: (lv_name_1_0= RULE_STRING )
            // InternalInstance.g:1972:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_47); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.STRING");
            	    

            }


            }

            // InternalInstance.g:1988:2: ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( ((LA42_0>=75 && LA42_0<=76)) ) {
                alt42=1;
            }
            else if ( (LA42_0==RULE_ID) ) {
                int LA42_2 = input.LA(2);

                if ( (LA42_2==EOF||LA42_2==RULE_ID||(LA42_2>=17 && LA42_2<=18)||LA42_2==20||LA42_2==23||LA42_2==25||(LA42_2>=30 && LA42_2<=31)||(LA42_2>=33 && LA42_2<=35)||LA42_2==40||LA42_2==44||(LA42_2>=55 && LA42_2<=62)||(LA42_2>=64 && LA42_2<=71)||LA42_2==73) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalInstance.g:1988:3: ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    {
                    // InternalInstance.g:1988:3: ( ( ruleInstanceRef ) )
                    // InternalInstance.g:1989:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1989:1: ( ruleInstanceRef )
                    // InternalInstance.g:1990:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_48);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:2003:2: (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==23) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalInstance.g:2003:4: otherlv_3= ',' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_18); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalInstance.g:2007:1: ( ( ruleInstanceRef ) )
                    	    // InternalInstance.g:2008:1: ( ruleInstanceRef )
                    	    {
                    	    // InternalInstance.g:2008:1: ( ruleInstanceRef )
                    	    // InternalInstance.g:2009:3: ruleInstanceRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_48);
                    	    ruleInstanceRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSystemOperationMode"


    // $ANTLR start "entryRulePropertyAssociationInstance"
    // InternalInstance.g:2030:1: entryRulePropertyAssociationInstance returns [EObject current=null] : iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF ;
    public final EObject entryRulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociationInstance = null;


        try {
            // InternalInstance.g:2031:2: (iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF )
            // InternalInstance.g:2032:2: iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF
            {
             newCompositeNode(grammarAccess.getPropertyAssociationInstanceRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyAssociationInstance=rulePropertyAssociationInstance();

            state._fsp--;

             current =iv_rulePropertyAssociationInstance; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyAssociationInstance"


    // $ANTLR start "rulePropertyAssociationInstance"
    // InternalInstance.g:2039:1: rulePropertyAssociationInstance returns [EObject current=null] : ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) ;
    public final EObject rulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedValue_2_0 = null;

        EObject lv_ownedValue_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:2042:28: ( ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) )
            // InternalInstance.g:2043:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            {
            // InternalInstance.g:2043:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            // InternalInstance.g:2043:2: ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) )
            {
            // InternalInstance.g:2043:2: ( ( ruleQPREF ) )
            // InternalInstance.g:2044:1: ( ruleQPREF )
            {
            // InternalInstance.g:2044:1: ( ruleQPREF )
            // InternalInstance.g:2045:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_49);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_50); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationInstanceAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // InternalInstance.g:2062:1: ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) )
            // InternalInstance.g:2063:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            {
            // InternalInstance.g:2063:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            // InternalInstance.g:2064:3: lv_ownedValue_2_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_51);
            lv_ownedValue_2_0=ruleOptionalModalPropertyValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                   		add(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_2_0, 
                    		"org.osate.aadl2.instance.textual.Instance.OptionalModalPropertyValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:2080:2: (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==23) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalInstance.g:2080:4: otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_50); 

            	        	newLeafNode(otherlv_3, grammarAccess.getPropertyAssociationInstanceAccess().getCommaKeyword_3_0());
            	        
            	    // InternalInstance.g:2084:1: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    // InternalInstance.g:2085:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalInstance.g:2085:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    // InternalInstance.g:2086:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_51);
            	    lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPropertyAssociationInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedValue",
            	            		lv_ownedValue_4_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.OptionalModalPropertyValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_5, grammarAccess.getPropertyAssociationInstanceAccess().getColonKeyword_4());
                
            // InternalInstance.g:2106:1: ( ( rulePropertyAssociationRef ) )
            // InternalInstance.g:2107:1: ( rulePropertyAssociationRef )
            {
            // InternalInstance.g:2107:1: ( rulePropertyAssociationRef )
            // InternalInstance.g:2108:3: rulePropertyAssociationRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationPropertyAssociationCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_2);
            rulePropertyAssociationRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyAssociationInstance"


    // $ANTLR start "entryRuleOptionalModalPropertyValue"
    // InternalInstance.g:2129:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalInstance.g:2130:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalInstance.g:2131:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue();

            state._fsp--;

             current =iv_ruleOptionalModalPropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOptionalModalPropertyValue"


    // $ANTLR start "ruleOptionalModalPropertyValue"
    // InternalInstance.g:2138:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? ) ;
    public final EObject ruleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:2141:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? ) )
            // InternalInstance.g:2142:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? )
            {
            // InternalInstance.g:2142:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? )
            // InternalInstance.g:2142:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )?
            {
            // InternalInstance.g:2142:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalInstance.g:2143:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalInstance.g:2143:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalInstance.g:2144:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_52);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
            	        }
                   		set(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_0_0, 
                    		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:2160:2: (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==20) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==21) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalInstance.g:2160:4: otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
                        
                    // InternalInstance.g:2172:1: ( (otherlv_4= RULE_ID ) )
                    // InternalInstance.g:2173:1: (otherlv_4= RULE_ID )
                    {
                    // InternalInstance.g:2173:1: (otherlv_4= RULE_ID )
                    // InternalInstance.g:2174:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_15); 

                    		newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); 
                    	

                    }


                    }

                    // InternalInstance.g:2185:2: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==23) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // InternalInstance.g:2185:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // InternalInstance.g:2189:1: ( (otherlv_6= RULE_ID ) )
                    	    // InternalInstance.g:2190:1: (otherlv_6= RULE_ID )
                    	    {
                    	    // InternalInstance.g:2190:1: (otherlv_6= RULE_ID )
                    	    // InternalInstance.g:2191:3: otherlv_6= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	    	        }
                    	            
                    	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_15); 

                    	    		newLeafNode(otherlv_6, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,24,FOLLOW_2); 

                        	newLeafNode(otherlv_7, grammarAccess.getOptionalModalPropertyValueAccess().getRightParenthesisKeyword_1_5());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOptionalModalPropertyValue"


    // $ANTLR start "entryRulePropertyExpression"
    // InternalInstance.g:2214:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalInstance.g:2215:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalInstance.g:2216:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;

             current =iv_rulePropertyExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyExpression"


    // $ANTLR start "rulePropertyExpression"
    // InternalInstance.g:2223:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) ;
    public final EObject rulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RecordTerm_0 = null;

        EObject this_ReferenceTerm_1 = null;

        EObject this_InstanceReferenceValue_2 = null;

        EObject this_ComponentClassifierTerm_3 = null;

        EObject this_ComputedTerm_4 = null;

        EObject this_StringTerm_5 = null;

        EObject this_NumericRangeTerm_6 = null;

        EObject this_RealTerm_7 = null;

        EObject this_IntegerTerm_8 = null;

        EObject this_ListTerm_9 = null;

        EObject this_BooleanLiteral_10 = null;

        EObject this_LiteralorReferenceTerm_11 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:2226:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) )
            // InternalInstance.g:2227:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            {
            // InternalInstance.g:2227:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            int alt46=12;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // InternalInstance.g:2228:5: this_RecordTerm_0= ruleRecordTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;

                     
                            current = this_RecordTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2238:5: this_ReferenceTerm_1= ruleReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ReferenceTerm_1=ruleReferenceTerm();

                    state._fsp--;

                     
                            current = this_ReferenceTerm_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2248:5: this_InstanceReferenceValue_2= ruleInstanceReferenceValue
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getInstanceReferenceValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_InstanceReferenceValue_2=ruleInstanceReferenceValue();

                    state._fsp--;

                     
                            current = this_InstanceReferenceValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2258:5: this_ComponentClassifierTerm_3= ruleComponentClassifierTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ComponentClassifierTerm_3=ruleComponentClassifierTerm();

                    state._fsp--;

                     
                            current = this_ComponentClassifierTerm_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2268:5: this_ComputedTerm_4= ruleComputedTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ComputedTerm_4=ruleComputedTerm();

                    state._fsp--;

                     
                            current = this_ComputedTerm_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalInstance.g:2278:5: this_StringTerm_5= ruleStringTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StringTerm_5=ruleStringTerm();

                    state._fsp--;

                     
                            current = this_StringTerm_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalInstance.g:2288:5: this_NumericRangeTerm_6= ruleNumericRangeTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NumericRangeTerm_6=ruleNumericRangeTerm();

                    state._fsp--;

                     
                            current = this_NumericRangeTerm_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalInstance.g:2298:5: this_RealTerm_7= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_2);
                    this_RealTerm_7=ruleRealTerm();

                    state._fsp--;

                     
                            current = this_RealTerm_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // InternalInstance.g:2308:5: this_IntegerTerm_8= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntegerTerm_8=ruleIntegerTerm();

                    state._fsp--;

                     
                            current = this_IntegerTerm_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // InternalInstance.g:2318:5: this_ListTerm_9= ruleListTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ListTerm_9=ruleListTerm();

                    state._fsp--;

                     
                            current = this_ListTerm_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // InternalInstance.g:2328:5: this_BooleanLiteral_10= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_10=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // InternalInstance.g:2338:5: this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_2);
                    this_LiteralorReferenceTerm_11=ruleLiteralorReferenceTerm();

                    state._fsp--;

                     
                            current = this_LiteralorReferenceTerm_11; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyExpression"


    // $ANTLR start "entryRuleContainmentPathElement"
    // InternalInstance.g:2354:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalInstance.g:2355:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalInstance.g:2356:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;

             current =iv_ruleContainmentPathElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPathElement"


    // $ANTLR start "ruleContainmentPathElement"
    // InternalInstance.g:2363:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:2366:28: ( ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalInstance.g:2367:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalInstance.g:2367:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalInstance.g:2367:2: ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalInstance.g:2367:2: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:2368:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:2368:1: ( ruleDeclarativeRef )
            // InternalInstance.g:2369:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_53);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:2382:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==18) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalInstance.g:2383:1: (lv_arrayRange_1_0= ruleArrayRange )
                    {
                    // InternalInstance.g:2383:1: (lv_arrayRange_1_0= ruleArrayRange )
                    // InternalInstance.g:2384:3: lv_arrayRange_1_0= ruleArrayRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_54);
                    lv_arrayRange_1_0=ruleArrayRange();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                    	        }
                           		add(
                           			current, 
                           			"arrayRange",
                            		lv_arrayRange_1_0, 
                            		"org.osate.xtext.aadl2.properties.Properties.ArrayRange");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:2400:3: (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==42) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalInstance.g:2400:5: otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,42,FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getSolidusKeyword_2_0());
                        
                    // InternalInstance.g:2404:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalInstance.g:2405:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalInstance.g:2405:1: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalInstance.g:2406:3: lv_path_3_0= ruleContainmentPathElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_path_3_0=ruleContainmentPathElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_3_0, 
                            		"org.osate.aadl2.instance.textual.Instance.ContainmentPathElement");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPathElement"


    // $ANTLR start "entryRuleInstanceReferenceValue"
    // InternalInstance.g:2430:1: entryRuleInstanceReferenceValue returns [EObject current=null] : iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF ;
    public final EObject entryRuleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceReferenceValue = null;


        try {
            // InternalInstance.g:2431:2: (iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF )
            // InternalInstance.g:2432:2: iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF
            {
             newCompositeNode(grammarAccess.getInstanceReferenceValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstanceReferenceValue=ruleInstanceReferenceValue();

            state._fsp--;

             current =iv_ruleInstanceReferenceValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceReferenceValue"


    // $ANTLR start "ruleInstanceReferenceValue"
    // InternalInstance.g:2439:1: ruleInstanceReferenceValue returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) ;
    public final EObject ruleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2442:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) )
            // InternalInstance.g:2443:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:2443:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            // InternalInstance.g:2443:3: otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getInstanceReferenceValueAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_18); 

                	newLeafNode(otherlv_1, grammarAccess.getInstanceReferenceValueAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:2451:1: ( ( ruleInstanceRef ) )
            // InternalInstance.g:2452:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:2452:1: ( ruleInstanceRef )
            // InternalInstance.g:2453:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInstanceReferenceValueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_30);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getInstanceReferenceValueAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceReferenceValue"


    // $ANTLR start "entryRuleDirectionType"
    // InternalInstance.g:2478:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // InternalInstance.g:2479:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // InternalInstance.g:2480:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDirectionType"


    // $ANTLR start "ruleDirectionType"
    // InternalInstance.g:2487:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2490:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // InternalInstance.g:2491:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // InternalInstance.g:2491:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt49=3;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==20) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==44) ) {
                    alt49=3;
                }
                else if ( (LA49_1==EOF||(LA49_1>=45 && LA49_1<=54)) ) {
                    alt49=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA49_0==44) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalInstance.g:2492:2: kw= 'in'
                    {
                    kw=(Token)match(input,20,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2499:2: kw= 'out'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2505:6: (kw= 'in' kw= 'out' )
                    {
                    // InternalInstance.g:2505:6: (kw= 'in' kw= 'out' )
                    // InternalInstance.g:2506:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,20,FOLLOW_55); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,44,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_2_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirectionType"


    // $ANTLR start "entryRuleFeatureCategory"
    // InternalInstance.g:2525:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // InternalInstance.g:2526:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // InternalInstance.g:2527:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCategory"


    // $ANTLR start "ruleFeatureCategory"
    // InternalInstance.g:2534:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2537:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // InternalInstance.g:2538:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // InternalInstance.g:2538:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            int alt50=10;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt50=1;
                }
                break;
            case 46:
                {
                alt50=2;
                }
                break;
            case 47:
                {
                alt50=3;
                }
                break;
            case 48:
                {
                alt50=4;
                }
                break;
            case 49:
                {
                alt50=5;
                }
                break;
            case 50:
                {
                alt50=6;
                }
                break;
            case 51:
                {
                alt50=7;
                }
                break;
            case 52:
                {
                alt50=8;
                }
                break;
            case 53:
                {
                alt50=9;
                }
                break;
            case 54:
                {
                alt50=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalInstance.g:2539:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2546:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2553:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2560:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2567:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalInstance.g:2574:2: kw= 'dataAccess'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalInstance.g:2581:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalInstance.g:2588:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalInstance.g:2595:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalInstance.g:2602:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_9()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCategory"


    // $ANTLR start "entryRuleComponentCategory"
    // InternalInstance.g:2615:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // InternalInstance.g:2616:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // InternalInstance.g:2617:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentCategory"


    // $ANTLR start "ruleComponentCategory"
    // InternalInstance.g:2624:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2627:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // InternalInstance.g:2628:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // InternalInstance.g:2628:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt51=14;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalInstance.g:2629:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2636:2: kw= 'bus'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2643:2: kw= 'data'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2650:2: kw= 'device'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2657:2: kw= 'memory'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalInstance.g:2664:2: kw= 'process'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalInstance.g:2671:2: kw= 'processor'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalInstance.g:2678:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalInstance.g:2684:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // InternalInstance.g:2684:6: (kw= 'subprogram' kw= 'group' )
                    // InternalInstance.g:2685:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,62,FOLLOW_56); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,63,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalInstance.g:2698:2: kw= 'system'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalInstance.g:2704:6: (kw= 'thread' kw= 'group' )
                    {
                    // InternalInstance.g:2704:6: (kw= 'thread' kw= 'group' )
                    // InternalInstance.g:2705:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,65,FOLLOW_56); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,63,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // InternalInstance.g:2718:2: kw= 'thread'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // InternalInstance.g:2724:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // InternalInstance.g:2724:6: (kw= 'virtual' kw= 'bus' )
                    // InternalInstance.g:2725:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,66,FOLLOW_57); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,56,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // InternalInstance.g:2737:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // InternalInstance.g:2737:6: (kw= 'virtual' kw= 'processor' )
                    // InternalInstance.g:2738:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,66,FOLLOW_58); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,61,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_13_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentCategory"


    // $ANTLR start "entryRuleConnectionKind"
    // InternalInstance.g:2757:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // InternalInstance.g:2758:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // InternalInstance.g:2759:2: iv_ruleConnectionKind= ruleConnectionKind EOF
            {
             newCompositeNode(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConnectionKind=ruleConnectionKind();

            state._fsp--;

             current =iv_ruleConnectionKind.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnectionKind"


    // $ANTLR start "ruleConnectionKind"
    // InternalInstance.g:2766:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2769:28: ( (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) )
            // InternalInstance.g:2770:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            {
            // InternalInstance.g:2770:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            int alt52=5;
            switch ( input.LA(1) ) {
            case 67:
                {
                alt52=1;
                }
                break;
            case 68:
                {
                alt52=2;
                }
                break;
            case 69:
                {
                alt52=3;
                }
                break;
            case 70:
                {
                alt52=4;
                }
                break;
            case 71:
                {
                alt52=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalInstance.g:2771:2: kw= 'featureConnection'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2778:2: kw= 'accessConnection'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2785:2: kw= 'parameterConnection'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2792:2: kw= 'portConnection'
                    {
                    kw=(Token)match(input,70,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2799:2: kw= 'featureGroupConnection'
                    {
                    kw=(Token)match(input,71,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureGroupConnectionKeyword_4()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnectionKind"


    // $ANTLR start "entryRuleClassifierRef"
    // InternalInstance.g:2812:1: entryRuleClassifierRef returns [String current=null] : iv_ruleClassifierRef= ruleClassifierRef EOF ;
    public final String entryRuleClassifierRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleClassifierRef = null;


        try {
            // InternalInstance.g:2813:2: (iv_ruleClassifierRef= ruleClassifierRef EOF )
            // InternalInstance.g:2814:2: iv_ruleClassifierRef= ruleClassifierRef EOF
            {
             newCompositeNode(grammarAccess.getClassifierRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleClassifierRef=ruleClassifierRef();

            state._fsp--;

             current =iv_ruleClassifierRef.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClassifierRef"


    // $ANTLR start "ruleClassifierRef"
    // InternalInstance.g:2821:1: ruleClassifierRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleClassifierRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2824:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalInstance.g:2825:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalInstance.g:2825:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // InternalInstance.g:2825:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // InternalInstance.g:2825:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    int LA53_1 = input.LA(2);

                    if ( (LA53_1==72) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalInstance.g:2825:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_59); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,72,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getClassifierRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_60); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:2845:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==73) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalInstance.g:2846:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,73,FOLLOW_3); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getClassifierRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClassifierRef"


    // $ANTLR start "entryRuleImplRef"
    // InternalInstance.g:2866:1: entryRuleImplRef returns [String current=null] : iv_ruleImplRef= ruleImplRef EOF ;
    public final String entryRuleImplRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplRef = null;


        try {
            // InternalInstance.g:2867:2: (iv_ruleImplRef= ruleImplRef EOF )
            // InternalInstance.g:2868:2: iv_ruleImplRef= ruleImplRef EOF
            {
             newCompositeNode(grammarAccess.getImplRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImplRef=ruleImplRef();

            state._fsp--;

             current =iv_ruleImplRef.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImplRef"


    // $ANTLR start "ruleImplRef"
    // InternalInstance.g:2875:1: ruleImplRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleImplRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2878:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // InternalInstance.g:2879:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // InternalInstance.g:2879:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // InternalInstance.g:2879:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // InternalInstance.g:2879:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt55=0;
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==RULE_ID) ) {
                    int LA55_1 = input.LA(2);

                    if ( (LA55_1==72) ) {
                        alt55=1;
                    }


                }


                switch (alt55) {
            	case 1 :
            	    // InternalInstance.g:2879:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_59); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,72,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getImplRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt55 >= 1 ) break loop55;
                        EarlyExitException eee =
                            new EarlyExitException(55, input);
                        throw eee;
                }
                cnt55++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_61); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,73,FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getImplRefAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImplRef"


    // $ANTLR start "entryRuleDeclarativeRef"
    // InternalInstance.g:2920:1: entryRuleDeclarativeRef returns [String current=null] : iv_ruleDeclarativeRef= ruleDeclarativeRef EOF ;
    public final String entryRuleDeclarativeRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeclarativeRef = null;


        try {
            // InternalInstance.g:2921:2: (iv_ruleDeclarativeRef= ruleDeclarativeRef EOF )
            // InternalInstance.g:2922:2: iv_ruleDeclarativeRef= ruleDeclarativeRef EOF
            {
             newCompositeNode(grammarAccess.getDeclarativeRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclarativeRef=ruleDeclarativeRef();

            state._fsp--;

             current =iv_ruleDeclarativeRef.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclarativeRef"


    // $ANTLR start "ruleDeclarativeRef"
    // InternalInstance.g:2929:1: ruleDeclarativeRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) ;
    public final AntlrDatatypeRuleToken ruleDeclarativeRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_INTEGER_LIT_8=null;
        Token this_ID_9=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2932:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) )
            // InternalInstance.g:2933:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            {
            // InternalInstance.g:2933:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            // InternalInstance.g:2933:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            {
            // InternalInstance.g:2933:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_ID) ) {
                    int LA56_1 = input.LA(2);

                    if ( (LA56_1==72) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // InternalInstance.g:2933:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_59); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,72,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_62); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:2953:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==73) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalInstance.g:2954:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,73,FOLLOW_3); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_4); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_63); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonKeyword_3()); 
                
            // InternalInstance.g:2972:1: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==37) ) {
                alt58=1;
            }
            else if ( (LA58_0==RULE_ID) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalInstance.g:2972:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    {
                    // InternalInstance.g:2972:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    // InternalInstance.g:2973:2: kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                    {
                    kw=(Token)match(input,37,FOLLOW_64); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getTransitionKeyword_4_0_0()); 
                        
                    kw=(Token)match(input,74,FOLLOW_9); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getNumberSignKeyword_4_0_1()); 
                        
                    this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

                    		current.merge(this_INTEGER_LIT_8);
                        
                     
                        newLeafNode(this_INTEGER_LIT_8, grammarAccess.getDeclarativeRefAccess().getINTEGER_LITTerminalRuleCall_4_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalInstance.g:2992:10: this_ID_9= RULE_ID
                    {
                    this_ID_9=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		current.merge(this_ID_9);
                        
                     
                        newLeafNode(this_ID_9, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_4_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclarativeRef"


    // $ANTLR start "entryRuleInstanceRef"
    // InternalInstance.g:3007:1: entryRuleInstanceRef returns [String current=null] : iv_ruleInstanceRef= ruleInstanceRef EOF ;
    public final String entryRuleInstanceRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInstanceRef = null;


        try {
            // InternalInstance.g:3008:2: (iv_ruleInstanceRef= ruleInstanceRef EOF )
            // InternalInstance.g:3009:2: iv_ruleInstanceRef= ruleInstanceRef EOF
            {
             newCompositeNode(grammarAccess.getInstanceRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstanceRef=ruleInstanceRef();

            state._fsp--;

             current =iv_ruleInstanceRef.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstanceRef"


    // $ANTLR start "ruleInstanceRef"
    // InternalInstance.g:3016:1: ruleInstanceRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) ;
    public final AntlrDatatypeRuleToken ruleInstanceRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        Token this_INTEGER_LIT_3=null;
        Token this_INTEGER_LIT_8=null;
        Token this_ID_9=null;
        Token this_INTEGER_LIT_11=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3019:28: ( (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) )
            // InternalInstance.g:3020:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            {
            // InternalInstance.g:3020:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==75) ) {
                alt63=1;
            }
            else if ( (LA63_0==RULE_ID||LA63_0==76) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalInstance.g:3021:2: kw= 'parent'
                    {
                    kw=(Token)match(input,75,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getParentKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:3027:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    {
                    // InternalInstance.g:3027:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    // InternalInstance.g:3027:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    {
                    // InternalInstance.g:3027:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*
                    loop60:
                    do {
                        int alt60=2;
                        alt60 = dfa60.predict(input);
                        switch (alt60) {
                    	case 1 :
                    	    // InternalInstance.g:3027:12: this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.'
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_65); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_0_0()); 
                    	        
                    	    // InternalInstance.g:3034:1: (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )*
                    	    loop59:
                    	    do {
                    	        int alt59=2;
                    	        int LA59_0 = input.LA(1);

                    	        if ( (LA59_0==18) ) {
                    	            alt59=1;
                    	        }


                    	        switch (alt59) {
                    	    	case 1 :
                    	    	    // InternalInstance.g:3035:2: kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']'
                    	    	    {
                    	    	    kw=(Token)match(input,18,FOLLOW_9); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_0_1_0()); 
                    	    	        
                    	    	    this_INTEGER_LIT_3=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_10); 

                    	    	    		current.merge(this_INTEGER_LIT_3);
                    	    	        
                    	    	     
                    	    	        newLeafNode(this_INTEGER_LIT_3, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_0_1_1()); 
                    	    	        
                    	    	    kw=(Token)match(input,19,FOLLOW_65); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_0_1_2()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop59;
                    	        }
                    	    } while (true);

                    	    kw=(Token)match(input,73,FOLLOW_66); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop60;
                        }
                    } while (true);

                    // InternalInstance.g:3059:3: ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==76) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==RULE_ID) ) {
                        alt62=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalInstance.g:3059:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            {
                            // InternalInstance.g:3059:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            // InternalInstance.g:3060:2: kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,76,FOLLOW_64); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getConnectionKeyword_1_1_0_0()); 
                                
                            kw=(Token)match(input,74,FOLLOW_9); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getNumberSignKeyword_1_1_0_1()); 
                                
                            this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

                            		current.merge(this_INTEGER_LIT_8);
                                
                             
                                newLeafNode(this_INTEGER_LIT_8, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_0_2()); 
                                

                            }


                            }
                            break;
                        case 2 :
                            // InternalInstance.g:3079:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            {
                            // InternalInstance.g:3079:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            // InternalInstance.g:3079:11: this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            {
                            this_ID_9=(Token)match(input,RULE_ID,FOLLOW_67); 

                            		current.merge(this_ID_9);
                                
                             
                                newLeafNode(this_ID_9, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_1_1_0()); 
                                
                            // InternalInstance.g:3086:1: (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            loop61:
                            do {
                                int alt61=2;
                                int LA61_0 = input.LA(1);

                                if ( (LA61_0==18) ) {
                                    alt61=1;
                                }


                                switch (alt61) {
                            	case 1 :
                            	    // InternalInstance.g:3087:2: kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']'
                            	    {
                            	    kw=(Token)match(input,18,FOLLOW_9); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_1_1_1_0()); 
                            	        
                            	    this_INTEGER_LIT_11=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_10); 

                            	    		current.merge(this_INTEGER_LIT_11);
                            	        
                            	     
                            	        newLeafNode(this_INTEGER_LIT_11, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_1_1_1()); 
                            	        
                            	    kw=(Token)match(input,19,FOLLOW_67); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_1_1_1_2()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop61;
                                }
                            } while (true);


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstanceRef"


    // $ANTLR start "entryRuleTransitionRef"
    // InternalInstance.g:3113:1: entryRuleTransitionRef returns [String current=null] : iv_ruleTransitionRef= ruleTransitionRef EOF ;
    public final String entryRuleTransitionRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTransitionRef = null;


        try {
            // InternalInstance.g:3114:2: (iv_ruleTransitionRef= ruleTransitionRef EOF )
            // InternalInstance.g:3115:2: iv_ruleTransitionRef= ruleTransitionRef EOF
            {
             newCompositeNode(grammarAccess.getTransitionRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTransitionRef=ruleTransitionRef();

            state._fsp--;

             current =iv_ruleTransitionRef.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransitionRef"


    // $ANTLR start "ruleTransitionRef"
    // InternalInstance.g:3122:1: ruleTransitionRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleTransitionRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3125:28: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalInstance.g:3126:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:3126:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalInstance.g:3127:2: kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            kw=(Token)match(input,37,FOLLOW_64); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTransitionRefAccess().getTransitionKeyword_0()); 
                
            kw=(Token)match(input,74,FOLLOW_9); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTransitionRefAccess().getNumberSignKeyword_1()); 
                
            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

            		current.merge(this_INTEGER_LIT_2);
                
             
                newLeafNode(this_INTEGER_LIT_2, grammarAccess.getTransitionRefAccess().getINTEGER_LITTerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransitionRef"


    // $ANTLR start "entryRulePropertyAssociationRef"
    // InternalInstance.g:3153:1: entryRulePropertyAssociationRef returns [String current=null] : iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF ;
    public final String entryRulePropertyAssociationRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePropertyAssociationRef = null;


        try {
            // InternalInstance.g:3154:2: (iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF )
            // InternalInstance.g:3155:2: iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF
            {
             newCompositeNode(grammarAccess.getPropertyAssociationRefRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyAssociationRef=rulePropertyAssociationRef();

            state._fsp--;

             current =iv_rulePropertyAssociationRef.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyAssociationRef"


    // $ANTLR start "rulePropertyAssociationRef"
    // InternalInstance.g:3162:1: rulePropertyAssociationRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken rulePropertyAssociationRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;
        Token this_INTEGER_LIT_9=null;
        Token this_INTEGER_LIT_13=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3165:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) )
            // InternalInstance.g:3166:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:3166:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            // InternalInstance.g:3166:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT
            {
            // InternalInstance.g:3166:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt64=0;
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    int LA64_1 = input.LA(2);

                    if ( (LA64_1==72) ) {
                        alt64=1;
                    }


                }


                switch (alt64) {
            	case 1 :
            	    // InternalInstance.g:3166:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_59); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,72,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt64 >= 1 ) break loop64;
                        EarlyExitException eee =
                            new EarlyExitException(64, input);
                        throw eee;
                }
                cnt64++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_62); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:3186:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==73) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalInstance.g:3187:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,73,FOLLOW_3); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_4); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_68); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_3()); 
                
            // InternalInstance.g:3205:1: ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID||LA67_0==37) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalInstance.g:3205:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':'
                    {
                    // InternalInstance.g:3205:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) )
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==RULE_ID) ) {
                        alt66=1;
                    }
                    else if ( (LA66_0==37) ) {
                        alt66=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 66, 0, input);

                        throw nvae;
                    }
                    switch (alt66) {
                        case 1 :
                            // InternalInstance.g:3205:7: this_ID_6= RULE_ID
                            {
                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_4); 

                            		current.merge(this_ID_6);
                                
                             
                                newLeafNode(this_ID_6, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalInstance.g:3213:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            {
                            // InternalInstance.g:3213:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            // InternalInstance.g:3214:2: kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,37,FOLLOW_64); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getTransitionKeyword_4_0_1_0()); 
                                
                            kw=(Token)match(input,74,FOLLOW_9); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_4_0_1_1()); 
                                
                            this_INTEGER_LIT_9=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_4); 

                            		current.merge(this_INTEGER_LIT_9);
                                
                             
                                newLeafNode(this_INTEGER_LIT_9, grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_4_0_1_2()); 
                                

                            }


                            }
                            break;

                    }

                    kw=(Token)match(input,15,FOLLOW_69); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_4_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,77,FOLLOW_64); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getPropertyKeyword_5()); 
                
            kw=(Token)match(input,74,FOLLOW_9); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_6()); 
                
            this_INTEGER_LIT_13=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

            		current.merge(this_INTEGER_LIT_13);
                
             
                newLeafNode(this_INTEGER_LIT_13, grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_7()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyAssociationRef"


    // $ANTLR start "entryRuleLong"
    // InternalInstance.g:3265:1: entryRuleLong returns [String current=null] : iv_ruleLong= ruleLong EOF ;
    public final String entryRuleLong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLong = null;


        try {
            // InternalInstance.g:3266:2: (iv_ruleLong= ruleLong EOF )
            // InternalInstance.g:3267:2: iv_ruleLong= ruleLong EOF
            {
             newCompositeNode(grammarAccess.getLongRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLong=ruleLong();

            state._fsp--;

             current =iv_ruleLong.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLong"


    // $ANTLR start "ruleLong"
    // InternalInstance.g:3274:1: ruleLong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleLong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3277:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalInstance.g:3278:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

            		current.merge(this_INTEGER_LIT_0);
                
             
                newLeafNode(this_INTEGER_LIT_0, grammarAccess.getLongAccess().getINTEGER_LITTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLong"


    // $ANTLR start "entryRuleContainedPropertyAssociation"
    // InternalInstance.g:3295:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalInstance.g:3296:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalInstance.g:3297:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;

             current =iv_ruleContainedPropertyAssociation; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainedPropertyAssociation"


    // $ANTLR start "ruleContainedPropertyAssociation"
    // InternalInstance.g:3304:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;

        EObject lv_appliesTo_8_0 = null;

        EObject lv_appliesTo_10_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3307:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' ) )
            // InternalInstance.g:3308:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' )
            {
            // InternalInstance.g:3308:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' )
            // InternalInstance.g:3308:2: ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';'
            {
            // InternalInstance.g:3308:2: ( ( ruleQPREF ) )
            // InternalInstance.g:3309:1: ( ruleQPREF )
            {
            // InternalInstance.g:3309:1: ( ruleQPREF )
            // InternalInstance.g:3310:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_70);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:3323:2: (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==41) ) {
                alt68=1;
            }
            else if ( (LA68_0==78) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalInstance.g:3323:4: otherlv_1= '=>'
                    {
                    otherlv_1=(Token)match(input,41,FOLLOW_71); 

                        	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:3328:6: ( (lv_append_2_0= '+=>' ) )
                    {
                    // InternalInstance.g:3328:6: ( (lv_append_2_0= '+=>' ) )
                    // InternalInstance.g:3329:1: (lv_append_2_0= '+=>' )
                    {
                    // InternalInstance.g:3329:1: (lv_append_2_0= '+=>' )
                    // InternalInstance.g:3330:3: lv_append_2_0= '+=>'
                    {
                    lv_append_2_0=(Token)match(input,78,FOLLOW_71); 

                            newLeafNode(lv_append_2_0, grammarAccess.getContainedPropertyAssociationAccess().getAppendPlusSignEqualsSignGreaterThanSignKeyword_1_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "append", true, "+=>");
                    	    

                    }


                    }


                    }
                    break;

            }

            // InternalInstance.g:3343:3: ( (lv_constant_3_0= 'constant' ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==79) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalInstance.g:3344:1: (lv_constant_3_0= 'constant' )
                    {
                    // InternalInstance.g:3344:1: (lv_constant_3_0= 'constant' )
                    // InternalInstance.g:3345:3: lv_constant_3_0= 'constant'
                    {
                    lv_constant_3_0=(Token)match(input,79,FOLLOW_50); 

                            newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "constant", true, "constant");
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:3358:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalInstance.g:3358:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalInstance.g:3358:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalInstance.g:3359:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalInstance.g:3359:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalInstance.g:3360:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
            	    
            pushFollow(FOLLOW_72);
            lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	        }
                   		add(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_4_0, 
                    		"org.osate.aadl2.instance.textual.Instance.OptionalModalPropertyValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:3376:2: (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==23) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // InternalInstance.g:3376:4: otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_50); 

            	        	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	        
            	    // InternalInstance.g:3380:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalInstance.g:3381:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalInstance.g:3381:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalInstance.g:3382:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_72);
            	    lv_ownedValue_6_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedValue",
            	            		lv_ownedValue_6_0, 
            	            		"org.osate.aadl2.instance.textual.Instance.OptionalModalPropertyValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);


            }

            // InternalInstance.g:3398:5: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==89) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalInstance.g:3399:5: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    {
                     
                            newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0()); 
                        
                    pushFollow(FOLLOW_3);
                    ruleAppliesToKeywords();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalInstance.g:3406:1: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalInstance.g:3407:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalInstance.g:3407:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalInstance.g:3408:3: lv_appliesTo_8_0= ruleContainmentPath
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_73);
                    lv_appliesTo_8_0=ruleContainmentPath();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		add(
                           			current, 
                           			"appliesTo",
                            		lv_appliesTo_8_0, 
                            		"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:3424:2: (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop71:
                    do {
                        int alt71=2;
                        int LA71_0 = input.LA(1);

                        if ( (LA71_0==23) ) {
                            alt71=1;
                        }


                        switch (alt71) {
                    	case 1 :
                    	    // InternalInstance.g:3424:4: otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // InternalInstance.g:3428:1: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalInstance.g:3429:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalInstance.g:3429:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalInstance.g:3430:3: lv_appliesTo_10_0= ruleContainmentPath
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_73);
                    	    lv_appliesTo_10_0=ruleContainmentPath();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"appliesTo",
                    	            		lv_appliesTo_10_0, 
                    	            		"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop71;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalInstance.g:3446:6: ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==20) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalInstance.g:3447:5: ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')'
                    {
                     
                            newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); 
                        
                    pushFollow(FOLLOW_14);
                    ruleInBindingKeywords();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_12=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
                        
                    // InternalInstance.g:3458:1: ( ( ruleQCREF ) )
                    // InternalInstance.g:3459:1: ( ruleQCREF )
                    {
                    // InternalInstance.g:3459:1: ( ruleQCREF )
                    // InternalInstance.g:3460:3: ruleQCREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    ruleQCREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_14=(Token)match(input,24,FOLLOW_74); 

                        	newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
                        

                    }
                    break;

            }

            otherlv_15=(Token)match(input,80,FOLLOW_2); 

                	newLeafNode(otherlv_15, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainedPropertyAssociation"


    // $ANTLR start "entryRuleContainmentPath"
    // InternalInstance.g:3493:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalInstance.g:3494:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalInstance.g:3495:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;

             current =iv_ruleContainmentPath; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContainmentPath"


    // $ANTLR start "ruleContainmentPath"
    // InternalInstance.g:3502:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3505:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalInstance.g:3506:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalInstance.g:3506:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalInstance.g:3507:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalInstance.g:3507:1: (lv_path_0_0= ruleContainmentPathElement )
            // InternalInstance.g:3508:3: lv_path_0_0= ruleContainmentPathElement
            {
             
            	        newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_path_0_0=ruleContainmentPathElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContainmentPathRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_0_0, 
                    		"org.osate.aadl2.instance.textual.Instance.ContainmentPathElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContainmentPath"


    // $ANTLR start "entryRulePropertyValue"
    // InternalInstance.g:3534:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalInstance.g:3535:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalInstance.g:3536:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;

             current =iv_rulePropertyValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePropertyValue"


    // $ANTLR start "rulePropertyValue"
    // InternalInstance.g:3543:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3546:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalInstance.g:3547:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalInstance.g:3547:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalInstance.g:3548:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalInstance.g:3548:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalInstance.g:3549:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyValueRule());
            	        }
                   		set(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_0_0, 
                    		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePropertyValue"


    // $ANTLR start "entryRuleLiteralorReferenceTerm"
    // InternalInstance.g:3573:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalInstance.g:3574:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalInstance.g:3575:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;

             current =iv_ruleLiteralorReferenceTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralorReferenceTerm"


    // $ANTLR start "ruleLiteralorReferenceTerm"
    // InternalInstance.g:3582:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3585:28: ( ( ( ruleQPREF ) ) )
            // InternalInstance.g:3586:1: ( ( ruleQPREF ) )
            {
            // InternalInstance.g:3586:1: ( ( ruleQPREF ) )
            // InternalInstance.g:3587:1: ( ruleQPREF )
            {
            // InternalInstance.g:3587:1: ( ruleQPREF )
            // InternalInstance.g:3588:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); 
            	    
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteralorReferenceTerm"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalInstance.g:3609:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalInstance.g:3610:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalInstance.g:3611:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalInstance.g:3618:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3621:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalInstance.g:3622:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalInstance.g:3622:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalInstance.g:3622:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalInstance.g:3622:2: ()
            // InternalInstance.g:3623:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalInstance.g:3628:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==81) ) {
                alt74=1;
            }
            else if ( (LA74_0==82) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // InternalInstance.g:3628:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalInstance.g:3628:3: ( (lv_value_1_0= 'true' ) )
                    // InternalInstance.g:3629:1: (lv_value_1_0= 'true' )
                    {
                    // InternalInstance.g:3629:1: (lv_value_1_0= 'true' )
                    // InternalInstance.g:3630:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,81,FOLLOW_2); 

                            newLeafNode(lv_value_1_0, grammarAccess.getBooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanLiteralRule());
                    	        }
                           		setWithLastConsumed(current, "value", true, "true");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalInstance.g:3644:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,82,FOLLOW_2); 

                        	newLeafNode(otherlv_2, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRuleConstantValue"
    // InternalInstance.g:3656:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalInstance.g:3657:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalInstance.g:3658:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // InternalInstance.g:3665:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3668:28: ( ( ( ruleQPREF ) ) )
            // InternalInstance.g:3669:1: ( ( ruleQPREF ) )
            {
            // InternalInstance.g:3669:1: ( ( ruleQPREF ) )
            // InternalInstance.g:3670:1: ( ruleQPREF )
            {
            // InternalInstance.g:3670:1: ( ruleQPREF )
            // InternalInstance.g:3671:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantValueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); 
            	    
            pushFollow(FOLLOW_2);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleReferenceTerm"
    // InternalInstance.g:3692:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalInstance.g:3693:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalInstance.g:3694:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getReferenceTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;

             current =iv_ruleReferenceTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceTerm"


    // $ANTLR start "ruleReferenceTerm"
    // InternalInstance.g:3701:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3704:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3705:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3705:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            // InternalInstance.g:3705:3: otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,43,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3713:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalInstance.g:3714:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalInstance.g:3714:1: (lv_path_2_0= ruleContainmentPathElement )
            // InternalInstance.g:3715:3: lv_path_2_0= ruleContainmentPathElement
            {
             
            	        newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_30);
            lv_path_2_0=ruleContainmentPathElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceTermRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_2_0, 
                    		"org.osate.aadl2.instance.textual.Instance.ContainmentPathElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getReferenceTermAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceTerm"


    // $ANTLR start "entryRuleRecordTerm"
    // InternalInstance.g:3743:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalInstance.g:3744:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalInstance.g:3745:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
             newCompositeNode(grammarAccess.getRecordTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;

             current =iv_ruleRecordTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRecordTerm"


    // $ANTLR start "ruleRecordTerm"
    // InternalInstance.g:3752:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3755:28: ( (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) )
            // InternalInstance.g:3756:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            {
            // InternalInstance.g:3756:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            // InternalInstance.g:3756:3: otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                
            // InternalInstance.g:3760:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_ID) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalInstance.g:3761:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalInstance.g:3761:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalInstance.g:3762:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_75);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRecordTermRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedFieldValue",
            	            		lv_ownedFieldValue_1_0, 
            	            		"org.osate.xtext.aadl2.properties.Properties.FieldPropertyAssociation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
            } while (true);

            otherlv_2=(Token)match(input,19,FOLLOW_2); 

                	newLeafNode(otherlv_2, grammarAccess.getRecordTermAccess().getRightSquareBracketKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRecordTerm"


    // $ANTLR start "entryRuleComputedTerm"
    // InternalInstance.g:3792:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalInstance.g:3793:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalInstance.g:3794:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
             newCompositeNode(grammarAccess.getComputedTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;

             current =iv_ruleComputedTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComputedTerm"


    // $ANTLR start "ruleComputedTerm"
    // InternalInstance.g:3801:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3804:28: ( (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3805:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3805:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalInstance.g:3805:3: otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3813:1: ( (lv_function_2_0= RULE_ID ) )
            // InternalInstance.g:3814:1: (lv_function_2_0= RULE_ID )
            {
            // InternalInstance.g:3814:1: (lv_function_2_0= RULE_ID )
            // InternalInstance.g:3815:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            			newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getComputedTermRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"function",
                    		lv_function_2_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getComputedTermAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComputedTerm"


    // $ANTLR start "entryRuleComponentClassifierTerm"
    // InternalInstance.g:3843:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalInstance.g:3844:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalInstance.g:3845:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
             newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;

             current =iv_ruleComponentClassifierTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentClassifierTerm"


    // $ANTLR start "ruleComponentClassifierTerm"
    // InternalInstance.g:3852:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3855:28: ( (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3856:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3856:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            // InternalInstance.g:3856:3: otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,84,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3864:1: ( ( ruleQCREF ) )
            // InternalInstance.g:3865:1: ( ruleQCREF )
            {
            // InternalInstance.g:3865:1: ( ruleQCREF )
            // InternalInstance.g:3866:3: ruleQCREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentClassifierTermRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_30);
            ruleQCREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getComponentClassifierTermAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentClassifierTerm"


    // $ANTLR start "entryRuleListTerm"
    // InternalInstance.g:3891:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalInstance.g:3892:2: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalInstance.g:3893:2: iv_ruleListTerm= ruleListTerm EOF
            {
             newCompositeNode(grammarAccess.getListTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;

             current =iv_ruleListTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListTerm"


    // $ANTLR start "ruleListTerm"
    // InternalInstance.g:3900:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3903:28: ( ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalInstance.g:3904:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalInstance.g:3904:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            // InternalInstance.g:3904:2: () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalInstance.g:3904:2: ()
            // InternalInstance.g:3905:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListTermAccess().getListValueAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_76); 

                	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3914:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=RULE_ID && LA77_0<=RULE_REAL_LIT)||LA77_0==18||LA77_0==22||LA77_0==43||(LA77_0>=81 && LA77_0<=86)) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalInstance.g:3914:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalInstance.g:3914:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalInstance.g:3915:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalInstance.g:3915:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalInstance.g:3916:3: lv_ownedListElement_2_0= rulePropertyExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_15);
                    lv_ownedListElement_2_0=rulePropertyExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getListTermRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedListElement",
                            		lv_ownedListElement_2_0, 
                            		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:3932:2: (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop76:
                    do {
                        int alt76=2;
                        int LA76_0 = input.LA(1);

                        if ( (LA76_0==23) ) {
                            alt76=1;
                        }


                        switch (alt76) {
                    	case 1 :
                    	    // InternalInstance.g:3932:4: otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_50); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalInstance.g:3936:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalInstance.g:3937:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalInstance.g:3937:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalInstance.g:3938:3: lv_ownedListElement_4_0= rulePropertyExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_15);
                    	    lv_ownedListElement_4_0=rulePropertyExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getListTermRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedListElement",
                    	            		lv_ownedListElement_4_0, 
                    	            		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop76;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,24,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getListTermAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListTerm"


    // $ANTLR start "entryRuleFieldPropertyAssociation"
    // InternalInstance.g:3966:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalInstance.g:3967:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalInstance.g:3968:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;

             current =iv_ruleFieldPropertyAssociation; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFieldPropertyAssociation"


    // $ANTLR start "ruleFieldPropertyAssociation"
    // InternalInstance.g:3975:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3978:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) )
            // InternalInstance.g:3979:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            {
            // InternalInstance.g:3979:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            // InternalInstance.g:3979:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';'
            {
            // InternalInstance.g:3979:2: ( (otherlv_0= RULE_ID ) )
            // InternalInstance.g:3980:1: (otherlv_0= RULE_ID )
            {
            // InternalInstance.g:3980:1: (otherlv_0= RULE_ID )
            // InternalInstance.g:3981:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_49); 

            		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_50); 

                	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // InternalInstance.g:3996:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalInstance.g:3997:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalInstance.g:3997:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalInstance.g:3998:3: lv_ownedValue_2_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_74);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
            	        }
                   		set(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_2_0, 
                    		"org.osate.aadl2.instance.textual.Instance.PropertyExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,80,FOLLOW_2); 

                	newLeafNode(otherlv_3, grammarAccess.getFieldPropertyAssociationAccess().getSemicolonKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFieldPropertyAssociation"


    // $ANTLR start "entryRulePlusMinus"
    // InternalInstance.g:4028:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalInstance.g:4029:2: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalInstance.g:4030:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
             newCompositeNode(grammarAccess.getPlusMinusRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;

             current =iv_rulePlusMinus.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusMinus"


    // $ANTLR start "rulePlusMinus"
    // InternalInstance.g:4037:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4040:28: ( (kw= '+' | kw= '-' ) )
            // InternalInstance.g:4041:1: (kw= '+' | kw= '-' )
            {
            // InternalInstance.g:4041:1: (kw= '+' | kw= '-' )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==85) ) {
                alt78=1;
            }
            else if ( (LA78_0==86) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalInstance.g:4042:2: kw= '+'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4049:2: kw= '-'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getHyphenMinusKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusMinus"


    // $ANTLR start "entryRuleStringTerm"
    // InternalInstance.g:4062:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalInstance.g:4063:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalInstance.g:4064:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // InternalInstance.g:4071:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4074:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalInstance.g:4075:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalInstance.g:4075:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalInstance.g:4076:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalInstance.g:4076:1: (lv_value_0_0= ruleNoQuoteString )
            // InternalInstance.g:4077:3: lv_value_0_0= ruleNoQuoteString
            {
             
            	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStringTermRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.NoQuoteString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalInstance.g:4101:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalInstance.g:4102:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalInstance.g:4103:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
             newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;

             current =iv_ruleNoQuoteString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // InternalInstance.g:4110:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4113:28: (this_STRING_0= RULE_STRING )
            // InternalInstance.g:4114:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleArrayRange"
    // InternalInstance.g:4129:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalInstance.g:4130:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalInstance.g:4131:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
             newCompositeNode(grammarAccess.getArrayRangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;

             current =iv_ruleArrayRange; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrayRange"


    // $ANTLR start "ruleArrayRange"
    // InternalInstance.g:4138:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4141:28: ( ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) )
            // InternalInstance.g:4142:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            {
            // InternalInstance.g:4142:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            // InternalInstance.g:4142:2: () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']'
            {
            // InternalInstance.g:4142:2: ()
            // InternalInstance.g:4143:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                
            // InternalInstance.g:4152:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalInstance.g:4153:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalInstance.g:4153:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalInstance.g:4154:3: lv_lowerBound_2_0= ruleINTVALUE
            {
             
            	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_77);
            lv_lowerBound_2_0=ruleINTVALUE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
            	        }
                   		set(
                   			current, 
                   			"lowerBound",
                    		lv_lowerBound_2_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:4170:2: (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==87) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalInstance.g:4170:4: otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,87,FOLLOW_9); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                        
                    // InternalInstance.g:4174:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalInstance.g:4175:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalInstance.g:4175:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalInstance.g:4176:3: lv_upperBound_4_0= ruleINTVALUE
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_10);
                    lv_upperBound_4_0=ruleINTVALUE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                    	        }
                           		set(
                           			current, 
                           			"upperBound",
                            		lv_upperBound_4_0, 
                            		"org.osate.xtext.aadl2.properties.Properties.INTVALUE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

                	newLeafNode(otherlv_5, grammarAccess.getArrayRangeAccess().getRightSquareBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrayRange"


    // $ANTLR start "entryRuleSignedConstant"
    // InternalInstance.g:4204:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalInstance.g:4205:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalInstance.g:4206:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
             newCompositeNode(grammarAccess.getSignedConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;

             current =iv_ruleSignedConstant; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedConstant"


    // $ANTLR start "ruleSignedConstant"
    // InternalInstance.g:4213:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4216:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalInstance.g:4217:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalInstance.g:4217:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalInstance.g:4217:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalInstance.g:4217:2: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalInstance.g:4218:1: (lv_op_0_0= rulePlusMinus )
            {
            // InternalInstance.g:4218:1: (lv_op_0_0= rulePlusMinus )
            // InternalInstance.g:4219:3: lv_op_0_0= rulePlusMinus
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_78);
            lv_op_0_0=rulePlusMinus();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_0_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.PlusMinus");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:4235:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalInstance.g:4236:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalInstance.g:4236:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalInstance.g:4237:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_ownedPropertyExpression_1_0=ruleConstantValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
            	        }
                   		add(
                   			current, 
                   			"ownedPropertyExpression",
                    		lv_ownedPropertyExpression_1_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.ConstantValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedConstant"


    // $ANTLR start "entryRuleIntegerTerm"
    // InternalInstance.g:4261:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalInstance.g:4262:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalInstance.g:4263:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerTerm"


    // $ANTLR start "ruleIntegerTerm"
    // InternalInstance.g:4270:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4273:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalInstance.g:4274:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalInstance.g:4274:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalInstance.g:4274:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalInstance.g:4274:2: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalInstance.g:4275:1: (lv_value_0_0= ruleSignedInt )
            {
            // InternalInstance.g:4275:1: (lv_value_0_0= ruleSignedInt )
            // InternalInstance.g:4276:3: lv_value_0_0= ruleSignedInt
            {
             
            	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_79);
            lv_value_0_0=ruleSignedInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntegerTermRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.SignedInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:4292:2: ( (otherlv_1= RULE_ID ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalInstance.g:4293:1: (otherlv_1= RULE_ID )
                    {
                    // InternalInstance.g:4293:1: (otherlv_1= RULE_ID )
                    // InternalInstance.g:4294:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntegerTermRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		newLeafNode(otherlv_1, grammarAccess.getIntegerTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerTerm"


    // $ANTLR start "entryRuleSignedInt"
    // InternalInstance.g:4313:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalInstance.g:4314:2: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalInstance.g:4315:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
             newCompositeNode(grammarAccess.getSignedIntRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;

             current =iv_ruleSignedInt.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedInt"


    // $ANTLR start "ruleSignedInt"
    // InternalInstance.g:4322:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4325:28: ( ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalInstance.g:4326:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:4326:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalInstance.g:4326:2: (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalInstance.g:4326:2: (kw= '+' | kw= '-' )?
            int alt81=3;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==85) ) {
                alt81=1;
            }
            else if ( (LA81_0==86) ) {
                alt81=2;
            }
            switch (alt81) {
                case 1 :
                    // InternalInstance.g:4327:2: kw= '+'
                    {
                    kw=(Token)match(input,85,FOLLOW_9); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4334:2: kw= '-'
                    {
                    kw=(Token)match(input,86,FOLLOW_9); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

            		current.merge(this_INTEGER_LIT_2);
                
             
                newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSignedIntAccess().getINTEGER_LITTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedInt"


    // $ANTLR start "entryRuleRealTerm"
    // InternalInstance.g:4354:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalInstance.g:4355:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalInstance.g:4356:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealTerm"


    // $ANTLR start "ruleRealTerm"
    // InternalInstance.g:4363:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4366:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalInstance.g:4367:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalInstance.g:4367:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalInstance.g:4367:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalInstance.g:4367:2: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalInstance.g:4368:1: (lv_value_0_0= ruleSignedReal )
            {
            // InternalInstance.g:4368:1: (lv_value_0_0= ruleSignedReal )
            // InternalInstance.g:4369:3: lv_value_0_0= ruleSignedReal
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_79);
            lv_value_0_0=ruleSignedReal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRealTermRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.SignedReal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:4385:2: ( (otherlv_1= RULE_ID ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==RULE_ID) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalInstance.g:4386:1: (otherlv_1= RULE_ID )
                    {
                    // InternalInstance.g:4386:1: (otherlv_1= RULE_ID )
                    // InternalInstance.g:4387:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRealTermRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		newLeafNode(otherlv_1, grammarAccess.getRealTermAccess().getUnitUnitLiteralCrossReference_1_0()); 
                    	

                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealTerm"


    // $ANTLR start "entryRuleSignedReal"
    // InternalInstance.g:4406:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalInstance.g:4407:2: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalInstance.g:4408:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
             newCompositeNode(grammarAccess.getSignedRealRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;

             current =iv_ruleSignedReal.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSignedReal"


    // $ANTLR start "ruleSignedReal"
    // InternalInstance.g:4415:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4418:28: ( ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalInstance.g:4419:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalInstance.g:4419:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalInstance.g:4419:2: (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalInstance.g:4419:2: (kw= '+' | kw= '-' )?
            int alt83=3;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==85) ) {
                alt83=1;
            }
            else if ( (LA83_0==86) ) {
                alt83=2;
            }
            switch (alt83) {
                case 1 :
                    // InternalInstance.g:4420:2: kw= '+'
                    {
                    kw=(Token)match(input,85,FOLLOW_80); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4427:2: kw= '-'
                    {
                    kw=(Token)match(input,86,FOLLOW_80); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_REAL_LIT_2=(Token)match(input,RULE_REAL_LIT,FOLLOW_2); 

            		current.merge(this_REAL_LIT_2);
                
             
                newLeafNode(this_REAL_LIT_2, grammarAccess.getSignedRealAccess().getREAL_LITTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSignedReal"


    // $ANTLR start "entryRuleNumericRangeTerm"
    // InternalInstance.g:4447:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalInstance.g:4448:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalInstance.g:4449:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
             newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;

             current =iv_ruleNumericRangeTerm; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumericRangeTerm"


    // $ANTLR start "ruleNumericRangeTerm"
    // InternalInstance.g:4456:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4459:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalInstance.g:4460:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalInstance.g:4460:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalInstance.g:4460:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalInstance.g:4460:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalInstance.g:4461:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalInstance.g:4461:1: (lv_minimum_0_0= ruleNumAlt )
            // InternalInstance.g:4462:3: lv_minimum_0_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_81);
            lv_minimum_0_0=ruleNumAlt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
            	        }
                   		set(
                   			current, 
                   			"minimum",
                    		lv_minimum_0_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,87,FOLLOW_78); 

                	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                
            // InternalInstance.g:4482:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalInstance.g:4483:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalInstance.g:4483:1: (lv_maximum_2_0= ruleNumAlt )
            // InternalInstance.g:4484:3: lv_maximum_2_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_82);
            lv_maximum_2_0=ruleNumAlt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
            	        }
                   		set(
                   			current, 
                   			"maximum",
                    		lv_maximum_2_0, 
                    		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:4500:2: (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==88) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalInstance.g:4500:4: otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,88,FOLLOW_78); 

                        	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                        
                    // InternalInstance.g:4504:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalInstance.g:4505:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalInstance.g:4505:1: (lv_delta_4_0= ruleNumAlt )
                    // InternalInstance.g:4506:3: lv_delta_4_0= ruleNumAlt
                    {
                     
                    	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_delta_4_0=ruleNumAlt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                    	        }
                           		set(
                           			current, 
                           			"delta",
                            		lv_delta_4_0, 
                            		"org.osate.xtext.aadl2.properties.Properties.NumAlt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumericRangeTerm"


    // $ANTLR start "entryRuleNumAlt"
    // InternalInstance.g:4530:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalInstance.g:4531:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalInstance.g:4532:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
             newCompositeNode(grammarAccess.getNumAltRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;

             current =iv_ruleNumAlt; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumAlt"


    // $ANTLR start "ruleNumAlt"
    // InternalInstance.g:4539:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4542:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalInstance.g:4543:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalInstance.g:4543:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt85=4;
            switch ( input.LA(1) ) {
            case 85:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt85=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt85=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt85=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 85, 1, input);

                    throw nvae;
                }

                }
                break;
            case 86:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt85=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt85=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt85=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 85, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt85=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt85=2;
                }
                break;
            case RULE_ID:
                {
                alt85=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // InternalInstance.g:4544:5: this_RealTerm_0= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;

                     
                            current = this_RealTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4554:5: this_IntegerTerm_1= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;

                     
                            current = this_IntegerTerm_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:4564:5: this_SignedConstant_2= ruleSignedConstant
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;

                     
                            current = this_SignedConstant_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:4574:5: this_ConstantValue_3= ruleConstantValue
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ConstantValue_3=ruleConstantValue();

                    state._fsp--;

                     
                            current = this_ConstantValue_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumAlt"


    // $ANTLR start "entryRuleAppliesToKeywords"
    // InternalInstance.g:4590:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalInstance.g:4591:2: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalInstance.g:4592:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
            {
             newCompositeNode(grammarAccess.getAppliesToKeywordsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAppliesToKeywords=ruleAppliesToKeywords();

            state._fsp--;

             current =iv_ruleAppliesToKeywords.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAppliesToKeywords"


    // $ANTLR start "ruleAppliesToKeywords"
    // InternalInstance.g:4599:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'applies' kw= 'to' ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4602:28: ( (kw= 'applies' kw= 'to' ) )
            // InternalInstance.g:4603:1: (kw= 'applies' kw= 'to' )
            {
            // InternalInstance.g:4603:1: (kw= 'applies' kw= 'to' )
            // InternalInstance.g:4604:2: kw= 'applies' kw= 'to'
            {
            kw=(Token)match(input,89,FOLLOW_33); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getAppliesKeyword_0()); 
                
            kw=(Token)match(input,32,FOLLOW_2); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getAppliesToKeywordsAccess().getToKeyword_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAppliesToKeywords"


    // $ANTLR start "entryRuleInBindingKeywords"
    // InternalInstance.g:4623:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalInstance.g:4624:2: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalInstance.g:4625:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
            {
             newCompositeNode(grammarAccess.getInBindingKeywordsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInBindingKeywords=ruleInBindingKeywords();

            state._fsp--;

             current =iv_ruleInBindingKeywords.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInBindingKeywords"


    // $ANTLR start "ruleInBindingKeywords"
    // InternalInstance.g:4632:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' kw= 'binding' ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4635:28: ( (kw= 'in' kw= 'binding' ) )
            // InternalInstance.g:4636:1: (kw= 'in' kw= 'binding' )
            {
            // InternalInstance.g:4636:1: (kw= 'in' kw= 'binding' )
            // InternalInstance.g:4637:2: kw= 'in' kw= 'binding'
            {
            kw=(Token)match(input,20,FOLLOW_83); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); 
                
            kw=(Token)match(input,90,FOLLOW_2); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getBindingKeyword_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInBindingKeywords"


    // $ANTLR start "entryRuleInModesKeywords"
    // InternalInstance.g:4656:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalInstance.g:4657:2: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalInstance.g:4658:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
            {
             newCompositeNode(grammarAccess.getInModesKeywordsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInModesKeywords=ruleInModesKeywords();

            state._fsp--;

             current =iv_ruleInModesKeywords.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInModesKeywords"


    // $ANTLR start "ruleInModesKeywords"
    // InternalInstance.g:4665:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' kw= 'modes' ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4668:28: ( (kw= 'in' kw= 'modes' ) )
            // InternalInstance.g:4669:1: (kw= 'in' kw= 'modes' )
            {
            // InternalInstance.g:4669:1: (kw= 'in' kw= 'modes' )
            // InternalInstance.g:4670:2: kw= 'in' kw= 'modes'
            {
            kw=(Token)match(input,20,FOLLOW_13); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getInKeyword_0()); 
                
            kw=(Token)match(input,21,FOLLOW_2); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getInModesKeywordsAccess().getModesKeyword_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInModesKeywords"


    // $ANTLR start "entryRuleINTVALUE"
    // InternalInstance.g:4689:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalInstance.g:4690:2: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalInstance.g:4691:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
             newCompositeNode(grammarAccess.getINTVALUERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;

             current =iv_ruleINTVALUE.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINTVALUE"


    // $ANTLR start "ruleINTVALUE"
    // InternalInstance.g:4698:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4701:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalInstance.g:4702:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

            		current.merge(this_INTEGER_LIT_0);
                
             
                newLeafNode(this_INTEGER_LIT_0, grammarAccess.getINTVALUEAccess().getINTEGER_LITTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINTVALUE"


    // $ANTLR start "entryRuleQPREF"
    // InternalInstance.g:4719:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalInstance.g:4720:2: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalInstance.g:4721:2: iv_ruleQPREF= ruleQPREF EOF
            {
             newCompositeNode(grammarAccess.getQPREFRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;

             current =iv_ruleQPREF.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQPREF"


    // $ANTLR start "ruleQPREF"
    // InternalInstance.g:4728:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4731:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // InternalInstance.g:4732:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // InternalInstance.g:4732:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // InternalInstance.g:4732:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_84); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                
            // InternalInstance.g:4739:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==72) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalInstance.g:4740:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,72,FOLLOW_3); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		current.merge(this_ID_2);
                        
                     
                        newLeafNode(this_ID_2, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_1_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQPREF"


    // $ANTLR start "entryRuleQCREF"
    // InternalInstance.g:4760:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalInstance.g:4761:2: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalInstance.g:4762:2: iv_ruleQCREF= ruleQCREF EOF
            {
             newCompositeNode(grammarAccess.getQCREFRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;

             current =iv_ruleQCREF.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQCREF"


    // $ANTLR start "ruleQCREF"
    // InternalInstance.g:4769:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4772:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalInstance.g:4773:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalInstance.g:4773:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // InternalInstance.g:4773:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // InternalInstance.g:4773:2: (this_ID_0= RULE_ID kw= '::' )*
            loop87:
            do {
                int alt87=2;
                int LA87_0 = input.LA(1);

                if ( (LA87_0==RULE_ID) ) {
                    int LA87_1 = input.LA(2);

                    if ( (LA87_1==72) ) {
                        alt87=1;
                    }


                }


                switch (alt87) {
            	case 1 :
            	    // InternalInstance.g:4773:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_59); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,72,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop87;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_60); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:4793:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==73) ) {
                alt88=1;
            }
            switch (alt88) {
                case 1 :
                    // InternalInstance.g:4794:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,73,FOLLOW_3); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQCREF"


    // $ANTLR start "entryRuleSTAR"
    // InternalInstance.g:4814:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalInstance.g:4815:2: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalInstance.g:4816:2: iv_ruleSTAR= ruleSTAR EOF
            {
             newCompositeNode(grammarAccess.getSTARRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;

             current =iv_ruleSTAR.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTAR"


    // $ANTLR start "ruleSTAR"
    // InternalInstance.g:4823:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '*' ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4826:28: (kw= '*' )
            // InternalInstance.g:4828:2: kw= '*'
            {
            kw=(Token)match(input,91,FOLLOW_2); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSTARAccess().getAsteriskKeyword()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTAR"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA60 dfa60 = new DFA60(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\4\7\uffff\1\4\3\uffff";
    static final String dfa_3s = "\1\107\7\uffff\1\45\3\uffff";
    static final String dfa_4s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\11\1\7";
    static final String dfa_5s = "\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\12\14\uffff\1\1\2\uffff\1\2\4\uffff\1\4\4\uffff\1\5\1\6\1\uffff\2\7\1\10\4\uffff\1\11\3\uffff\1\2\12\uffff\10\3\1\uffff\3\3\5\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\7\40\uffff\1\13",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 169:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )*";
        }
    }
    static final String dfa_7s = "\13\uffff";
    static final String dfa_8s = "\1\4\7\uffff\1\4\2\uffff";
    static final String dfa_9s = "\1\107\7\uffff\1\45\2\uffff";
    static final String dfa_10s = "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\7";
    static final String dfa_11s = "\13\uffff}>";
    static final String[] dfa_12s = {
            "\1\11\14\uffff\1\1\2\uffff\1\2\4\uffff\1\4\4\uffff\1\5\1\6\1\uffff\2\7\1\10\10\uffff\1\2\12\uffff\10\3\1\uffff\3\3\5\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\7\40\uffff\1\12",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "()* loopback of 675:1: ( ( (lv_featureInstance_16_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_17_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_18_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_19_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_20_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_21_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_22_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_23_0= rulePropertyAssociationInstance ) ) )*";
        }
    }
    static final String dfa_13s = "\31\uffff";
    static final String dfa_14s = "\10\uffff\1\20\1\22\1\24\4\uffff\1\20\1\uffff\1\22\5\uffff\1\24\1\uffff";
    static final String dfa_15s = "\1\4\1\uffff\1\26\3\uffff\4\4\1\17\2\uffff\1\4\1\uffff\1\17\1\uffff\1\17\1\uffff\1\4\2\uffff\1\22\1\17\1\uffff";
    static final String dfa_16s = "\1\126\1\uffff\1\26\3\uffff\2\7\3\131\2\uffff\1\114\1\uffff\1\131\1\uffff\1\131\1\uffff\1\4\2\uffff\1\111\1\131\1\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\5\uffff\1\12\1\13\1\uffff\1\7\1\uffff\1\10\1\uffff\1\11\1\uffff\1\14\1\3\2\uffff\1\2";
    static final String dfa_18s = "\31\uffff}>";
    static final String[] dfa_19s = {
            "\1\12\1\5\1\11\1\10\12\uffff\1\1\3\uffff\1\13\24\uffff\1\2\45\uffff\2\14\1\4\1\3\1\6\1\7",
            "",
            "\1\15",
            "",
            "",
            "",
            "\1\16\1\uffff\1\11\1\10",
            "\1\16\1\uffff\1\11\1\10",
            "\1\17\12\uffff\1\20\4\uffff\1\20\2\uffff\2\20\67\uffff\1\20\6\uffff\1\16\1\uffff\1\20",
            "\1\21\12\uffff\1\22\4\uffff\1\22\2\uffff\2\22\67\uffff\1\22\6\uffff\1\16\1\uffff\1\22",
            "\1\24\4\uffff\1\24\2\uffff\2\24\57\uffff\1\23\7\uffff\1\24\6\uffff\1\16\1\uffff\1\24",
            "",
            "",
            "\1\26\106\uffff\2\25",
            "",
            "\1\20\4\uffff\1\20\2\uffff\2\20\67\uffff\1\20\6\uffff\1\16\1\uffff\1\20",
            "",
            "\1\22\4\uffff\1\22\2\uffff\2\22\67\uffff\1\22\6\uffff\1\16\1\uffff\1\22",
            "",
            "\1\27",
            "",
            "",
            "\1\25\5\uffff\1\25\57\uffff\1\30\1\25",
            "\1\24\4\uffff\1\24\2\uffff\2\24\67\uffff\1\24\6\uffff\1\16\1\uffff\1\24",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "2227:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )";
        }
    }
    static final String dfa_20s = "\22\uffff";
    static final String dfa_21s = "\10\uffff\1\15\1\uffff\1\17\7\uffff";
    static final String dfa_22s = "\1\67\7\uffff\1\4\1\uffff\1\4\1\70\6\uffff";
    static final String dfa_23s = "\1\102\7\uffff\1\77\1\uffff\1\77\1\75\6\uffff";
    static final String dfa_24s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\11\1\10\1\13\1\14\1\15\1\16";
    static final String dfa_25s = "\22\uffff}>";
    static final String[] dfa_26s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\72\uffff\1\14",
            "",
            "\1\17\72\uffff\1\16",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "2628:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String dfa_27s = "\7\uffff";
    static final String dfa_28s = "\2\uffff\1\1\3\uffff\1\1";
    static final String dfa_29s = "\1\4\1\uffff\1\4\1\6\1\uffff\1\23\1\4";
    static final String dfa_30s = "\1\114\1\uffff\1\114\1\6\1\uffff\1\23\1\114";
    static final String dfa_31s = "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String dfa_32s = "\7\uffff}>";
    static final String[] dfa_33s = {
            "\1\2\107\uffff\1\1",
            "",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\2\uffff\2\1\1\uffff\3\1\3\uffff\2\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1",
            "\1\5",
            "",
            "\1\6",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\2\uffff\2\1\1\uffff\3\1\3\uffff\2\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1"
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "()* loopback of 3027:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x7F80110EC2120010L,0x00000000000000FFL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x007FE00000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000148000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L,0x00000000000000F8L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000010L,0x0000000000001800L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x7F80110EC2100010L,0x00000000000018FFL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x7F80110EC2120010L,0x00000000000018FFL});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008000010L,0x0000000000001800L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000001000010L,0x0000000000001800L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x7F80110EC2100010L,0x00000000000000FFL});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000108010L,0x0000000000001800L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000008108000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000001000008000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000008000000010L,0x0000000000001800L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000008000800000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000012L,0x0000000000001800L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x7F80190EC25400F0L,0x00000000007E00FFL});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000040000040002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000200L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000200L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000010L,0x0000000000001000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000002000000010L,0x0000000000002000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000020000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x7F80190EC25400F0L,0x00000000007E80FFL});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000900000L,0x0000000002010000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000900000L,0x0000000000010000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x7F80190EC35400F0L,0x00000000007E00FFL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000080000L,0x0000000000800000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x7F80110EC21000D0L,0x00000000006000FFL});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});

}