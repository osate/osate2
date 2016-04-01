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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INTEGER_LIT", "RULE_REAL_LIT", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_BASED_INTEGER", "RULE_EXTENDED_DIGIT", "RULE_WS", "':'", "'{'", "'}'", "'['", "']'", "'in'", "'modes'", "'('", "','", "')'", "'complete'", "'<->'", "'->'", "'transitions'", "'flow'", "'end'", "'to'", "'initial'", "'derived'", "'mode'", "'='", "'transition'", "'som'", "'=>'", "'/'", "'reference'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'dataAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'featureConnection'", "'accessConnection'", "'parameterConnection'", "'portConnection'", "'featureGroupConnection'", "'::'", "'.'", "'#'", "'parent'", "'connection'", "'property'", "'+=>'", "'constant'", "'applies'", "'binding'", "';'", "'true'", "'false'", "'compute'", "'classifier'", "'+'", "'-'", "'..'", "'delta'", "'*'"
    };
    public static final int T__50=50;
    public static final int RULE_INT_EXPONENT=11;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_BASED_INTEGER=12;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_DIGIT=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int RULE_INTEGER_LIT=6;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_REAL_LIT=7;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=14;
    public static final int RULE_EXPONENT=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__88=88;
    public static final int RULE_EXTENDED_DIGIT=13;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
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
    public String getGrammarFileName() { return "../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g"; }



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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:97:1: entryRuleSystemInstance returns [EObject current=null] : iv_ruleSystemInstance= ruleSystemInstance EOF ;
    public final EObject entryRuleSystemInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:98:2: (iv_ruleSystemInstance= ruleSystemInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:99:2: iv_ruleSystemInstance= ruleSystemInstance EOF
            {
             newCompositeNode(grammarAccess.getSystemInstanceRule()); 
            pushFollow(FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance75);
            iv_ruleSystemInstance=ruleSystemInstance();

            state._fsp--;

             current =iv_ruleSystemInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemInstance85); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:106:1: ruleSystemInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}' ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:109:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:110:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:110:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:110:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleImplRef ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )* otherlv_14= '}'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:110:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:111:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:111:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:112:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleSystemInstance131);
            lv_category_0_0=ruleComponentCategory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"ComponentCategory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:128:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:129:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:129:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:130:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemInstance148); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSystemInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleSystemInstance165); 

                	newLeafNode(otherlv_2, grammarAccess.getSystemInstanceAccess().getColonKeyword_2());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:150:1: ( ( ruleImplRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:151:1: ( ruleImplRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:151:1: ( ruleImplRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:152:3: ruleImplRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleImplRef_in_ruleSystemInstance188);
            ruleImplRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,16,FOLLOW_16_in_ruleSystemInstance200); 

                	newLeafNode(otherlv_4, grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:169:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )*
            loop1:
            do {
                int alt1=10;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:169:2: ( (lv_featureInstance_5_0= ruleFeatureInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:169:2: ( (lv_featureInstance_5_0= ruleFeatureInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:170:1: (lv_featureInstance_5_0= ruleFeatureInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:170:1: (lv_featureInstance_5_0= ruleFeatureInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:171:3: lv_featureInstance_5_0= ruleFeatureInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleSystemInstance222);
            	    lv_featureInstance_5_0=ruleFeatureInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"featureInstance",
            	            		lv_featureInstance_5_0, 
            	            		"FeatureInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:188:6: ( (lv_componentInstance_6_0= ruleComponentInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:188:6: ( (lv_componentInstance_6_0= ruleComponentInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:189:1: (lv_componentInstance_6_0= ruleComponentInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:189:1: (lv_componentInstance_6_0= ruleComponentInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:190:3: lv_componentInstance_6_0= ruleComponentInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleSystemInstance249);
            	    lv_componentInstance_6_0=ruleComponentInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"componentInstance",
            	            		lv_componentInstance_6_0, 
            	            		"ComponentInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:207:6: ( (lv_connectionInstance_7_0= ruleConnectionInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:207:6: ( (lv_connectionInstance_7_0= ruleConnectionInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:208:1: (lv_connectionInstance_7_0= ruleConnectionInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:208:1: (lv_connectionInstance_7_0= ruleConnectionInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:209:3: lv_connectionInstance_7_0= ruleConnectionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleSystemInstance276);
            	    lv_connectionInstance_7_0=ruleConnectionInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionInstance",
            	            		lv_connectionInstance_7_0, 
            	            		"ConnectionInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:226:6: ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:226:6: ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:227:1: (lv_flowSpecification_8_0= ruleFlowSpecificationInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:227:1: (lv_flowSpecification_8_0= ruleFlowSpecificationInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:228:3: lv_flowSpecification_8_0= ruleFlowSpecificationInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_5_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_ruleSystemInstance303);
            	    lv_flowSpecification_8_0=ruleFlowSpecificationInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"flowSpecification",
            	            		lv_flowSpecification_8_0, 
            	            		"FlowSpecificationInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:245:6: ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:245:6: ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:246:1: (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:246:1: (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:247:3: lv_endToEndFlow_9_0= ruleEndToEndFlowInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_5_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_ruleSystemInstance330);
            	    lv_endToEndFlow_9_0=ruleEndToEndFlowInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"endToEndFlow",
            	            		lv_endToEndFlow_9_0, 
            	            		"EndToEndFlowInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:264:6: ( (lv_modeInstance_10_0= ruleModeInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:264:6: ( (lv_modeInstance_10_0= ruleModeInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:265:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:265:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:266:3: lv_modeInstance_10_0= ruleModeInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getModeInstanceModeInstanceParserRuleCall_5_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModeInstance_in_ruleSystemInstance357);
            	    lv_modeInstance_10_0=ruleModeInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modeInstance",
            	            		lv_modeInstance_10_0, 
            	            		"ModeInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:283:6: ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:283:6: ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:284:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:284:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:285:3: lv_modeTransitionInstance_11_0= ruleModeTransitionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_5_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModeTransitionInstance_in_ruleSystemInstance384);
            	    lv_modeTransitionInstance_11_0=ruleModeTransitionInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modeTransitionInstance",
            	            		lv_modeTransitionInstance_11_0, 
            	            		"ModeTransitionInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:302:6: ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:302:6: ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:303:1: (lv_systemOperationMode_12_0= ruleSystemOperationMode )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:303:1: (lv_systemOperationMode_12_0= ruleSystemOperationMode )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:304:3: lv_systemOperationMode_12_0= ruleSystemOperationMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance411);
            	    lv_systemOperationMode_12_0=ruleSystemOperationMode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systemOperationMode",
            	            		lv_systemOperationMode_12_0, 
            	            		"SystemOperationMode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:321:6: ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:321:6: ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:322:1: (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:322:1: (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:323:3: lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_5_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleSystemInstance438);
            	    lv_ownedPropertyAssociation_13_0=rulePropertyAssociationInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedPropertyAssociation",
            	            		lv_ownedPropertyAssociation_13_0, 
            	            		"PropertyAssociationInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_14=(Token)match(input,17,FOLLOW_17_in_ruleSystemInstance452); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:351:1: entryRuleFeatureInstance returns [EObject current=null] : iv_ruleFeatureInstance= ruleFeatureInstance EOF ;
    public final EObject entryRuleFeatureInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:352:2: (iv_ruleFeatureInstance= ruleFeatureInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:353:2: iv_ruleFeatureInstance= ruleFeatureInstance EOF
            {
             newCompositeNode(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance488);
            iv_ruleFeatureInstance=ruleFeatureInstance();

            state._fsp--;

             current =iv_ruleFeatureInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance498); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:360:1: ruleFeatureInstance returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )? ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:363:28: ( ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:364:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:364:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:364:2: ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:364:2: ( (lv_direction_0_0= ruleDirectionType ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:365:1: (lv_direction_0_0= ruleDirectionType )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:365:1: (lv_direction_0_0= ruleDirectionType )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:366:3: lv_direction_0_0= ruleDirectionType
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDirectionType_in_ruleFeatureInstance544);
            lv_direction_0_0=ruleDirectionType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"direction",
                    		lv_direction_0_0, 
                    		"DirectionType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:382:2: ( (lv_category_1_0= ruleFeatureCategory ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:383:1: (lv_category_1_0= ruleFeatureCategory )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:383:1: (lv_category_1_0= ruleFeatureCategory )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:384:3: lv_category_1_0= ruleFeatureCategory
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance565);
            lv_category_1_0=ruleFeatureCategory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_1_0, 
                    		"FeatureCategory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:400:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:401:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:401:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:402:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance582); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFeatureInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:418:2: (otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==18) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:418:4: otherlv_3= '[' ( (lv_index_4_0= ruleLong ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleFeatureInstance600); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:422:1: ( (lv_index_4_0= ruleLong ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:423:1: (lv_index_4_0= ruleLong )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:423:1: (lv_index_4_0= ruleLong )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:424:3: lv_index_4_0= ruleLong
                    {
                     
                    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getIndexLongParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLong_in_ruleFeatureInstance621);
                    lv_index_4_0=ruleLong();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_4_0, 
                            		"Long");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleFeatureInstance633); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleFeatureInstance647); 

                	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:448:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:449:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:449:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:450:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleFeatureInstance670);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:463:2: (otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:463:4: otherlv_8= '{' ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )* otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleFeatureInstance683); 

                        	newLeafNode(otherlv_8, grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_6_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:467:1: ( ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) | ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==20||LA3_0==41) ) {
                            alt3=1;
                        }
                        else if ( (LA3_0==RULE_ID) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:467:2: ( (lv_featureInstance_9_0= ruleFeatureInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:467:2: ( (lv_featureInstance_9_0= ruleFeatureInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:468:1: (lv_featureInstance_9_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:468:1: (lv_featureInstance_9_0= ruleFeatureInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:469:3: lv_featureInstance_9_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance705);
                    	    lv_featureInstance_9_0=ruleFeatureInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureInstance",
                    	            		lv_featureInstance_9_0, 
                    	            		"FeatureInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:486:6: ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:486:6: ( (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:487:1: (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:487:1: (lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:488:3: lv_ownedPropertyAssociation_10_0= rulePropertyAssociationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleFeatureInstance732);
                    	    lv_ownedPropertyAssociation_10_0=rulePropertyAssociationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedPropertyAssociation",
                    	            		lv_ownedPropertyAssociation_10_0, 
                    	            		"PropertyAssociationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleFeatureInstance746); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:516:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:517:2: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:518:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance784);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance794); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:525:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleDeclarativeRef ) ) (otherlv_14= '{' ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )* otherlv_23= '}' )? ) ;
    public final EObject ruleComponentInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;

        EObject lv_featureInstance_15_0 = null;

        EObject lv_componentInstance_16_0 = null;

        EObject lv_connectionInstance_17_0 = null;

        EObject lv_flowSpecification_18_0 = null;

        EObject lv_endToEndFlow_19_0 = null;

        EObject lv_modeInstance_20_0 = null;

        EObject lv_modeTransitionInstance_21_0 = null;

        EObject lv_ownedPropertyAssociation_22_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:528:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleDeclarativeRef ) ) (otherlv_14= '{' ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )* otherlv_23= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:529:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleDeclarativeRef ) ) (otherlv_14= '{' ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )* otherlv_23= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:529:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleDeclarativeRef ) ) (otherlv_14= '{' ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )* otherlv_23= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:529:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleDeclarativeRef ) ) (otherlv_14= '{' ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )* otherlv_23= '}' )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:529:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:530:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:530:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:531:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleComponentInstance840);
            lv_category_0_0=ruleComponentCategory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"ComponentCategory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:547:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:548:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:548:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:549:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance857); 

            			newLeafNode(lv_name_1_0, grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:565:2: (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:565:4: otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']'
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance875); 

            	        	newLeafNode(otherlv_2, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0());
            	        
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:569:1: ( (lv_index_3_0= ruleLong ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:570:1: (lv_index_3_0= ruleLong )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:570:1: (lv_index_3_0= ruleLong )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:571:3: lv_index_3_0= ruleLong
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getIndexLongParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLong_in_ruleComponentInstance896);
            	    lv_index_3_0=ruleLong();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"index",
            	            		lv_index_3_0, 
            	            		"Long");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleComponentInstance908); 

            	        	newLeafNode(otherlv_4, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:591:3: (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:591:5: otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')'
                    {
                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleComponentInstance923); 

                        	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getInKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleComponentInstance935); 

                        	newLeafNode(otherlv_6, grammarAccess.getComponentInstanceAccess().getModesKeyword_3_1());
                        
                    otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleComponentInstance947); 

                        	newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_3_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:603:1: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:604:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:604:1: (otherlv_8= RULE_ID )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:605:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance967); 

                    		newLeafNode(otherlv_8, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_3_3_0()); 
                    	

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:616:2: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==23) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:616:4: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_23_in_ruleComponentInstance980); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getComponentInstanceAccess().getCommaKeyword_3_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:620:1: ( (otherlv_10= RULE_ID ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:621:1: (otherlv_10= RULE_ID )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:621:1: (otherlv_10= RULE_ID )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:622:3: otherlv_10= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance1000); 

                    	    		newLeafNode(otherlv_10, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_3_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,24,FOLLOW_24_in_ruleComponentInstance1014); 

                        	newLeafNode(otherlv_11, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_3_5());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance1028); 

                	newLeafNode(otherlv_12, grammarAccess.getComponentInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:641:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:642:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:642:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:643:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleComponentInstance1051);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:656:2: (otherlv_14= '{' ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )* otherlv_23= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:656:4: otherlv_14= '{' ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )* otherlv_23= '}'
                    {
                    otherlv_14=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1064); 

                        	newLeafNode(otherlv_14, grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_6_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:660:1: ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )*
                    loop8:
                    do {
                        int alt8=9;
                        alt8 = dfa8.predict(input);
                        switch (alt8) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:660:2: ( (lv_featureInstance_15_0= ruleFeatureInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:660:2: ( (lv_featureInstance_15_0= ruleFeatureInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:661:1: (lv_featureInstance_15_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:661:1: (lv_featureInstance_15_0= ruleFeatureInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:662:3: lv_featureInstance_15_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1086);
                    	    lv_featureInstance_15_0=ruleFeatureInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureInstance",
                    	            		lv_featureInstance_15_0, 
                    	            		"FeatureInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:679:6: ( (lv_componentInstance_16_0= ruleComponentInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:679:6: ( (lv_componentInstance_16_0= ruleComponentInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:680:1: (lv_componentInstance_16_0= ruleComponentInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:680:1: (lv_componentInstance_16_0= ruleComponentInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:681:3: lv_componentInstance_16_0= ruleComponentInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_6_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleComponentInstance1113);
                    	    lv_componentInstance_16_0=ruleComponentInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"componentInstance",
                    	            		lv_componentInstance_16_0, 
                    	            		"ComponentInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:698:6: ( (lv_connectionInstance_17_0= ruleConnectionInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:698:6: ( (lv_connectionInstance_17_0= ruleConnectionInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:699:1: (lv_connectionInstance_17_0= ruleConnectionInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:699:1: (lv_connectionInstance_17_0= ruleConnectionInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:700:3: lv_connectionInstance_17_0= ruleConnectionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_6_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1140);
                    	    lv_connectionInstance_17_0=ruleConnectionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connectionInstance",
                    	            		lv_connectionInstance_17_0, 
                    	            		"ConnectionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:717:6: ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:717:6: ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:718:1: (lv_flowSpecification_18_0= ruleFlowSpecificationInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:718:1: (lv_flowSpecification_18_0= ruleFlowSpecificationInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:719:3: lv_flowSpecification_18_0= ruleFlowSpecificationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_6_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1167);
                    	    lv_flowSpecification_18_0=ruleFlowSpecificationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"flowSpecification",
                    	            		lv_flowSpecification_18_0, 
                    	            		"FlowSpecificationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:736:6: ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:736:6: ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:737:1: (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:737:1: (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:738:3: lv_endToEndFlow_19_0= ruleEndToEndFlowInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_6_1_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance1194);
                    	    lv_endToEndFlow_19_0=ruleEndToEndFlowInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"endToEndFlow",
                    	            		lv_endToEndFlow_19_0, 
                    	            		"EndToEndFlowInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 6 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:755:6: ( (lv_modeInstance_20_0= ruleModeInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:755:6: ( (lv_modeInstance_20_0= ruleModeInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:756:1: (lv_modeInstance_20_0= ruleModeInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:756:1: (lv_modeInstance_20_0= ruleModeInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:757:3: lv_modeInstance_20_0= ruleModeInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_6_1_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModeInstance_in_ruleComponentInstance1221);
                    	    lv_modeInstance_20_0=ruleModeInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeInstance",
                    	            		lv_modeInstance_20_0, 
                    	            		"ModeInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 7 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:774:6: ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:774:6: ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:775:1: (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:775:1: (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:776:3: lv_modeTransitionInstance_21_0= ruleModeTransitionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_6_1_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance1248);
                    	    lv_modeTransitionInstance_21_0=ruleModeTransitionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeTransitionInstance",
                    	            		lv_modeTransitionInstance_21_0, 
                    	            		"ModeTransitionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 8 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:793:6: ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:793:6: ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:794:1: (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:794:1: (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:795:3: lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_6_1_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleComponentInstance1275);
                    	    lv_ownedPropertyAssociation_22_0=rulePropertyAssociationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedPropertyAssociation",
                    	            		lv_ownedPropertyAssociation_22_0, 
                    	            		"PropertyAssociationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_23=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1289); 

                        	newLeafNode(otherlv_23, grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_6_2());
                        

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:823:1: entryRuleConnectionInstance returns [EObject current=null] : iv_ruleConnectionInstance= ruleConnectionInstance EOF ;
    public final EObject entryRuleConnectionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:824:2: (iv_ruleConnectionInstance= ruleConnectionInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:825:2: iv_ruleConnectionInstance= ruleConnectionInstance EOF
            {
             newCompositeNode(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1327);
            iv_ruleConnectionInstance=ruleConnectionInstance();

            state._fsp--;

             current =iv_ruleConnectionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance1337); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:832:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' ) ;
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
        Token otherlv_12=null;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:835:28: ( ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:836:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:836:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:836:2: ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:836:2: ( (lv_complete_0_0= 'complete' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:837:1: (lv_complete_0_0= 'complete' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:837:1: (lv_complete_0_0= 'complete' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:838:3: lv_complete_0_0= 'complete'
                    {
                    lv_complete_0_0=(Token)match(input,25,FOLLOW_25_in_ruleConnectionInstance1380); 

                            newLeafNode(lv_complete_0_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "complete", true, "complete");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:851:3: ( (lv_kind_1_0= ruleConnectionKind ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:852:1: (lv_kind_1_0= ruleConnectionKind )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:852:1: (lv_kind_1_0= ruleConnectionKind )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:853:3: lv_kind_1_0= ruleConnectionKind
            {
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1415);
            lv_kind_1_0=ruleConnectionKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"kind",
                    		lv_kind_1_0, 
                    		"ConnectionKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:869:2: ( (lv_name_2_0= RULE_STRING ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:870:1: (lv_name_2_0= RULE_STRING )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:870:1: (lv_name_2_0= RULE_STRING )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:871:3: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConnectionInstance1432); 

            			newLeafNode(lv_name_2_0, grammarAccess.getConnectionInstanceAccess().getNameSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleConnectionInstance1449); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getColonKeyword_3());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:891:1: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:892:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:892:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:893:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionInstance1472);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:906:2: ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==26) ) {
                alt11=1;
            }
            else if ( (LA11_0==27) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:906:3: ( (lv_bidirectional_5_0= '<->' ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:906:3: ( (lv_bidirectional_5_0= '<->' ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:907:1: (lv_bidirectional_5_0= '<->' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:907:1: (lv_bidirectional_5_0= '<->' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:908:3: lv_bidirectional_5_0= '<->'
                    {
                    lv_bidirectional_5_0=(Token)match(input,26,FOLLOW_26_in_ruleConnectionInstance1491); 

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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:922:7: otherlv_6= '->'
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleConnectionInstance1522); 

                        	newLeafNode(otherlv_6, grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1());
                        

                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:926:2: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:927:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:927:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:928:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionInstance1546);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:941:2: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==21) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:941:4: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleConnectionInstance1559); 

                        	newLeafNode(otherlv_8, grammarAccess.getConnectionInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleConnectionInstance1571); 

                        	newLeafNode(otherlv_9, grammarAccess.getConnectionInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance1583); 

                        	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:953:1: ( ( ruleSomRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:954:1: ( ruleSomRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:954:1: ( ruleSomRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:955:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSomRef_in_ruleConnectionInstance1606);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:968:2: (otherlv_12= ',' ( ( ruleSomRef ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==23) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:968:4: otherlv_12= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleConnectionInstance1619); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:972:1: ( ( ruleSomRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:973:1: ( ruleSomRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:973:1: ( ruleSomRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:974:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSomRef_in_ruleConnectionInstance1642);
                    	    ruleSomRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleConnectionInstance1656); 

                        	newLeafNode(otherlv_14, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:991:3: (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:991:5: otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')'
                    {
                    otherlv_15=(Token)match(input,20,FOLLOW_20_in_ruleConnectionInstance1671); 

                        	newLeafNode(otherlv_15, grammarAccess.getConnectionInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_16=(Token)match(input,28,FOLLOW_28_in_ruleConnectionInstance1683); 

                        	newLeafNode(otherlv_16, grammarAccess.getConnectionInstanceAccess().getTransitionsKeyword_8_1());
                        
                    otherlv_17=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance1695); 

                        	newLeafNode(otherlv_17, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_8_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1003:1: ( ( ruleTransitionRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1004:1: ( ruleTransitionRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1004:1: ( ruleTransitionRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1005:3: ruleTransitionRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTransitionRef_in_ruleConnectionInstance1718);
                    ruleTransitionRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1018:2: (otherlv_19= ',' ( ( ruleTransitionRef ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==23) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1018:4: otherlv_19= ',' ( ( ruleTransitionRef ) )
                    	    {
                    	    otherlv_19=(Token)match(input,23,FOLLOW_23_in_ruleConnectionInstance1731); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_8_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1022:1: ( ( ruleTransitionRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1023:1: ( ruleTransitionRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1023:1: ( ruleTransitionRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1024:3: ruleTransitionRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTransitionRef_in_ruleConnectionInstance1754);
                    	    ruleTransitionRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_21=(Token)match(input,24,FOLLOW_24_in_ruleConnectionInstance1768); 

                        	newLeafNode(otherlv_21, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_8_5());
                        

                    }
                    break;

            }

            otherlv_22=(Token)match(input,16,FOLLOW_16_in_ruleConnectionInstance1782); 

                	newLeafNode(otherlv_22, grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_9());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1045:1: ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=3;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=72 && LA16_0<=73)) ) {
                    alt16=1;
                }
                else if ( (LA16_0==RULE_ID) ) {
                    int LA16_3 = input.LA(2);

                    if ( (LA16_3==18||LA16_3==27||LA16_3==70) ) {
                        alt16=1;
                    }
                    else if ( (LA16_3==38||LA16_3==69) ) {
                        alt16=2;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1045:2: ( (lv_connectionReference_23_0= ruleConnectionReference ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1045:2: ( (lv_connectionReference_23_0= ruleConnectionReference ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1046:1: (lv_connectionReference_23_0= ruleConnectionReference )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1046:1: (lv_connectionReference_23_0= ruleConnectionReference )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1047:3: lv_connectionReference_23_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_10_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionReference_in_ruleConnectionInstance1804);
            	    lv_connectionReference_23_0=ruleConnectionReference();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionReference",
            	            		lv_connectionReference_23_0, 
            	            		"ConnectionReference");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1064:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1064:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1065:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1065:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1066:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleConnectionInstance1831);
            	    lv_ownedPropertyAssociation_24_0=rulePropertyAssociationInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedPropertyAssociation",
            	            		lv_ownedPropertyAssociation_24_0, 
            	            		"PropertyAssociationInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            otherlv_25=(Token)match(input,17,FOLLOW_17_in_ruleConnectionInstance1845); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1094:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1095:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1096:2: iv_ruleConnectionReference= ruleConnectionReference EOF
            {
             newCompositeNode(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference1881);
            iv_ruleConnectionReference=ruleConnectionReference();

            state._fsp--;

             current =iv_ruleConnectionReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference1891); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1103:1: ruleConnectionReference returns [EObject current=null] : ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1106:28: ( ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1107:1: ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1107:1: ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1107:2: ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1107:2: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1108:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1108:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1109:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionReference1939);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleConnectionReference1951); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1126:1: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1127:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1127:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1128:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionReference1974);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleConnectionReference1986); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionReferenceAccess().getColonKeyword_3());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1145:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1146:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1146:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1147:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleConnectionReference2009);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleConnectionReference2021); 

                	newLeafNode(otherlv_5, grammarAccess.getConnectionReferenceAccess().getInKeyword_5());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1164:1: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1165:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1165:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1166:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionReference2044);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1187:1: entryRuleFlowSpecificationInstance returns [EObject current=null] : iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF ;
    public final EObject entryRuleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecificationInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1188:2: (iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1189:2: iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF
            {
             newCompositeNode(grammarAccess.getFlowSpecificationInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2080);
            iv_ruleFlowSpecificationInstance=ruleFlowSpecificationInstance();

            state._fsp--;

             current =iv_ruleFlowSpecificationInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2090); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1196:1: ruleFlowSpecificationInstance returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1199:28: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1200:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1200:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1200:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleFlowSpecificationInstance2127); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1204:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1205:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1205:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1206:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2144); 

            			newLeafNode(lv_name_1_0, grammarAccess.getFlowSpecificationInstanceAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecificationInstance2161); 

                	newLeafNode(otherlv_2, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1226:1: ( ( ruleInstanceRef ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||(LA17_0>=72 && LA17_0<=73)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1227:1: ( ruleInstanceRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1227:1: ( ruleInstanceRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1228:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstanceRef_in_ruleFlowSpecificationInstance2184);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleFlowSpecificationInstance2197); 

                	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1245:1: ( ( ruleInstanceRef ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||(LA18_0>=72 && LA18_0<=73)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1246:1: ( ruleInstanceRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1246:1: ( ruleInstanceRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1247:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstanceRef_in_ruleFlowSpecificationInstance2220);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2233); 

                	newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1264:1: (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==20) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==21) ) {
                    alt20=1;
                }
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1264:3: otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleFlowSpecificationInstance2246); 

                        	newLeafNode(otherlv_7, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleFlowSpecificationInstance2258); 

                        	newLeafNode(otherlv_8, grammarAccess.getFlowSpecificationInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_9=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecificationInstance2270); 

                        	newLeafNode(otherlv_9, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1276:1: ( (otherlv_10= RULE_ID ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1277:1: (otherlv_10= RULE_ID )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1277:1: (otherlv_10= RULE_ID )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1278:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2290); 

                    		newLeafNode(otherlv_10, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_3_0()); 
                    	

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1289:2: (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==23) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1289:4: otherlv_11= ',' ( (otherlv_12= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,23,FOLLOW_23_in_ruleFlowSpecificationInstance2303); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1293:1: ( (otherlv_12= RULE_ID ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1294:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1294:1: (otherlv_12= RULE_ID )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1295:3: otherlv_12= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2323); 

                    	    		newLeafNode(otherlv_12, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2337); 

                        	newLeafNode(otherlv_13, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1310:3: (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==20) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1310:5: otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')'
                    {
                    otherlv_14=(Token)match(input,20,FOLLOW_20_in_ruleFlowSpecificationInstance2352); 

                        	newLeafNode(otherlv_14, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_15=(Token)match(input,28,FOLLOW_28_in_ruleFlowSpecificationInstance2364); 

                        	newLeafNode(otherlv_15, grammarAccess.getFlowSpecificationInstanceAccess().getTransitionsKeyword_8_1());
                        
                    otherlv_16=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecificationInstance2376); 

                        	newLeafNode(otherlv_16, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_8_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1322:1: ( ( ruleTransitionRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1323:1: ( ruleTransitionRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1323:1: ( ruleTransitionRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1324:3: ruleTransitionRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTransitionRef_in_ruleFlowSpecificationInstance2399);
                    ruleTransitionRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1337:2: (otherlv_18= ',' ( ( ruleTransitionRef ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==23) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1337:4: otherlv_18= ',' ( ( ruleTransitionRef ) )
                    	    {
                    	    otherlv_18=(Token)match(input,23,FOLLOW_23_in_ruleFlowSpecificationInstance2412); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_8_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1341:1: ( ( ruleTransitionRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1342:1: ( ruleTransitionRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1342:1: ( ruleTransitionRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1343:3: ruleTransitionRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTransitionRef_in_ruleFlowSpecificationInstance2435);
                    	    ruleTransitionRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2449); 

                        	newLeafNode(otherlv_20, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_8_5());
                        

                    }
                    break;

            }

            otherlv_21=(Token)match(input,15,FOLLOW_15_in_ruleFlowSpecificationInstance2463); 

                	newLeafNode(otherlv_21, grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_9());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1364:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1365:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1365:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1366:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_10_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleFlowSpecificationInstance2486);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1379:2: (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==16) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1379:4: otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}'
                    {
                    otherlv_23=(Token)match(input,16,FOLLOW_16_in_ruleFlowSpecificationInstance2499); 

                        	newLeafNode(otherlv_23, grammarAccess.getFlowSpecificationInstanceAccess().getLeftCurlyBracketKeyword_11_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1383:1: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_ID) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1384:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1384:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1385:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleFlowSpecificationInstance2520);
                    	    lv_ownedPropertyAssociation_24_0=rulePropertyAssociationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedPropertyAssociation",
                    	            		lv_ownedPropertyAssociation_24_0, 
                    	            		"PropertyAssociationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    otherlv_25=(Token)match(input,17,FOLLOW_17_in_ruleFlowSpecificationInstance2533); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1413:1: entryRuleEndToEndFlowInstance returns [EObject current=null] : iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF ;
    public final EObject entryRuleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndToEndFlowInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1414:2: (iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1415:2: iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF
            {
             newCompositeNode(grammarAccess.getEndToEndFlowInstanceRule()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance2571);
            iv_ruleEndToEndFlowInstance=ruleEndToEndFlowInstance();

            state._fsp--;

             current =iv_ruleEndToEndFlowInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndToEndFlowInstance2581); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1422:1: ruleEndToEndFlowInstance returns [EObject current=null] : (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? ) ;
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
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_ownedPropertyAssociation_18_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1425:28: ( (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1426:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1426:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1426:3: otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleEndToEndFlowInstance2618); 

                	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0());
                
            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleEndToEndFlowInstance2630); 

                	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1());
                
            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleEndToEndFlowInstance2642); 

                	newLeafNode(otherlv_2, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2());
                
            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleEndToEndFlowInstance2654); 

                	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1442:1: ( (lv_name_4_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1443:1: (lv_name_4_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1443:1: (lv_name_4_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1444:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance2671); 

            			newLeafNode(lv_name_4_0, grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1460:2: ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||(LA26_0>=72 && LA26_0<=73)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1460:3: ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )*
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1460:3: ( ( ruleInstanceRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1461:1: ( ruleInstanceRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1461:1: ( ruleInstanceRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1462:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstanceRef_in_ruleEndToEndFlowInstance2700);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1475:2: (otherlv_6= '->' ( ( ruleInstanceRef ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==27) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1475:4: otherlv_6= '->' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleEndToEndFlowInstance2713); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1479:1: ( ( ruleInstanceRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1480:1: ( ruleInstanceRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1480:1: ( ruleInstanceRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1481:3: ruleInstanceRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleInstanceRef_in_ruleEndToEndFlowInstance2736);
                    	    ruleInstanceRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1494:6: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==20) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1494:8: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleEndToEndFlowInstance2753); 

                        	newLeafNode(otherlv_8, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleEndToEndFlowInstance2765); 

                        	newLeafNode(otherlv_9, grammarAccess.getEndToEndFlowInstanceAccess().getModesKeyword_6_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleEndToEndFlowInstance2777); 

                        	newLeafNode(otherlv_10, grammarAccess.getEndToEndFlowInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1506:1: ( ( ruleSomRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1507:1: ( ruleSomRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1507:1: ( ruleSomRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1508:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSomRef_in_ruleEndToEndFlowInstance2800);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1521:2: (otherlv_12= ',' ( ( ruleSomRef ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==23) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1521:4: otherlv_12= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleEndToEndFlowInstance2813); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getEndToEndFlowInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1525:1: ( ( ruleSomRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1526:1: ( ruleSomRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1526:1: ( ruleSomRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1527:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSomRef_in_ruleEndToEndFlowInstance2836);
                    	    ruleSomRef();

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

                    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleEndToEndFlowInstance2850); 

                        	newLeafNode(otherlv_14, grammarAccess.getEndToEndFlowInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            otherlv_15=(Token)match(input,15,FOLLOW_15_in_ruleEndToEndFlowInstance2864); 

                	newLeafNode(otherlv_15, grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_7());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1548:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1549:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1549:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1550:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleEndToEndFlowInstance2887);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1563:2: (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==16) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1563:4: otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}'
                    {
                    otherlv_17=(Token)match(input,16,FOLLOW_16_in_ruleEndToEndFlowInstance2900); 

                        	newLeafNode(otherlv_17, grammarAccess.getEndToEndFlowInstanceAccess().getLeftCurlyBracketKeyword_9_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1567:1: ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1568:1: (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1568:1: (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1569:3: lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleEndToEndFlowInstance2921);
                    lv_ownedPropertyAssociation_18_0=rulePropertyAssociationInstance();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedPropertyAssociation",
                            		lv_ownedPropertyAssociation_18_0, 
                            		"PropertyAssociationInstance");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_19=(Token)match(input,17,FOLLOW_17_in_ruleEndToEndFlowInstance2933); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1597:1: entryRuleModeInstance returns [EObject current=null] : iv_ruleModeInstance= ruleModeInstance EOF ;
    public final EObject entryRuleModeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1598:2: (iv_ruleModeInstance= ruleModeInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1599:2: iv_ruleModeInstance= ruleModeInstance EOF
            {
             newCompositeNode(grammarAccess.getModeInstanceRule()); 
            pushFollow(FOLLOW_ruleModeInstance_in_entryRuleModeInstance2971);
            iv_ruleModeInstance=ruleModeInstance();

            state._fsp--;

             current =iv_ruleModeInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeInstance2981); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1606:1: ruleModeInstance returns [EObject current=null] : ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1609:28: ( ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1610:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1610:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1610:2: ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1610:2: ( (lv_initial_0_0= 'initial' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==32) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1611:1: (lv_initial_0_0= 'initial' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1611:1: (lv_initial_0_0= 'initial' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1612:3: lv_initial_0_0= 'initial'
                    {
                    lv_initial_0_0=(Token)match(input,32,FOLLOW_32_in_ruleModeInstance3024); 

                            newLeafNode(lv_initial_0_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1625:3: ( (lv_derived_1_0= 'derived' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1626:1: (lv_derived_1_0= 'derived' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1626:1: (lv_derived_1_0= 'derived' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1627:3: lv_derived_1_0= 'derived'
                    {
                    lv_derived_1_0=(Token)match(input,33,FOLLOW_33_in_ruleModeInstance3056); 

                            newLeafNode(lv_derived_1_0, grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "derived");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleModeInstance3082); 

                	newLeafNode(otherlv_2, grammarAccess.getModeInstanceAccess().getModeKeyword_2());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1644:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1645:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1645:1: (lv_name_3_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1646:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3099); 

            			newLeafNode(lv_name_3_0, grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1662:2: (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==35) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1662:4: otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleModeInstance3117); 

                        	newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getEqualsSignKeyword_4_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1666:1: ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( (LA33_0==RULE_ID) ) {
                        alt33=1;
                    }
                    else if ( (LA33_0==22) ) {
                        alt33=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 0, input);

                        throw nvae;
                    }
                    switch (alt33) {
                        case 1 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1666:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1666:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1667:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1667:1: (otherlv_5= RULE_ID )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1668:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3138); 

                            		newLeafNode(otherlv_5, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1680:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1680:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1680:8: otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')'
                            {
                            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleModeInstance3157); 

                                	newLeafNode(otherlv_6, grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_4_1_1_0());
                                
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1684:1: ( (otherlv_7= RULE_ID ) )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1685:1: (otherlv_7= RULE_ID )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1685:1: (otherlv_7= RULE_ID )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1686:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3177); 

                            		newLeafNode(otherlv_7, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_1_0()); 
                            	

                            }


                            }

                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1697:2: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+
                            int cnt32=0;
                            loop32:
                            do {
                                int alt32=2;
                                int LA32_0 = input.LA(1);

                                if ( (LA32_0==23) ) {
                                    alt32=1;
                                }


                                switch (alt32) {
                            	case 1 :
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1697:4: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                            	    {
                            	    otherlv_8=(Token)match(input,23,FOLLOW_23_in_ruleModeInstance3190); 

                            	        	newLeafNode(otherlv_8, grammarAccess.getModeInstanceAccess().getCommaKeyword_4_1_1_2_0());
                            	        
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1701:1: ( (otherlv_9= RULE_ID ) )
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1702:1: (otherlv_9= RULE_ID )
                            	    {
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1702:1: (otherlv_9= RULE_ID )
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1703:3: otherlv_9= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	    	        }
                            	            
                            	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3210); 

                            	    		newLeafNode(otherlv_9, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt32 >= 1 ) break loop32;
                                        EarlyExitException eee =
                                            new EarlyExitException(32, input);
                                        throw eee;
                                }
                                cnt32++;
                            } while (true);

                            otherlv_10=(Token)match(input,24,FOLLOW_24_in_ruleModeInstance3224); 

                                	newLeafNode(otherlv_10, grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_4_1_1_3());
                                

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_ruleModeInstance3240); 

                	newLeafNode(otherlv_11, grammarAccess.getModeInstanceAccess().getColonKeyword_5());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1722:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1723:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1723:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1724:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleModeInstance3263);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1737:2: (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1737:4: otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}'
                    {
                    otherlv_13=(Token)match(input,16,FOLLOW_16_in_ruleModeInstance3276); 

                        	newLeafNode(otherlv_13, grammarAccess.getModeInstanceAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1741:1: ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1742:1: (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1742:1: (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1743:3: lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleModeInstance3297);
                    lv_ownedPropertyAssociation_14_0=rulePropertyAssociationInstance();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModeInstanceRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedPropertyAssociation",
                            		lv_ownedPropertyAssociation_14_0, 
                            		"PropertyAssociationInstance");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_15=(Token)match(input,17,FOLLOW_17_in_ruleModeInstance3309); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1771:1: entryRuleModeTransitionInstance returns [EObject current=null] : iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF ;
    public final EObject entryRuleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransitionInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1772:2: (iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1773:2: iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionInstanceRule()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance3347);
            iv_ruleModeTransitionInstance=ruleModeTransitionInstance();

            state._fsp--;

             current =iv_ruleModeTransitionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransitionInstance3357); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1780:1: ruleModeTransitionInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? ) ;
    public final EObject ruleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ownedPropertyAssociation_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1783:28: ( (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1784:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1784:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1784:3: otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleModeTransitionInstance3394); 

                	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleModeTransitionInstance3406); 

                	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1792:1: ( (lv_name_2_0= ruleModeTransitionName ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1793:1: (lv_name_2_0= ruleModeTransitionName )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1793:1: (lv_name_2_0= ruleModeTransitionName )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1794:3: lv_name_2_0= ruleModeTransitionName
            {
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getNameModeTransitionNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleModeTransitionName_in_ruleModeTransitionInstance3427);
            lv_name_2_0=ruleModeTransitionName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModeTransitionInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ModeTransitionName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1810:2: ( (otherlv_3= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1811:1: (otherlv_3= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1811:1: (otherlv_3= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1812:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance3447); 

            		newLeafNode(otherlv_3, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleModeTransitionInstance3459); 

                	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1827:1: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1828:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1828:1: (otherlv_5= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1829:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance3479); 

            		newLeafNode(otherlv_5, grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleModeTransitionInstance3491); 

                	newLeafNode(otherlv_6, grammarAccess.getModeTransitionInstanceAccess().getColonKeyword_6());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1844:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1845:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1845:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1846:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleModeTransitionInstance3514);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1859:2: (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==16) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1859:4: otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleModeTransitionInstance3527); 

                        	newLeafNode(otherlv_8, grammarAccess.getModeTransitionInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1863:1: ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1864:1: (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1864:1: (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1865:3: lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleModeTransitionInstance3548);
                    lv_ownedPropertyAssociation_9_0=rulePropertyAssociationInstance();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModeTransitionInstanceRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedPropertyAssociation",
                            		lv_ownedPropertyAssociation_9_0, 
                            		"PropertyAssociationInstance");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleModeTransitionInstance3560); 

                        	newLeafNode(otherlv_10, grammarAccess.getModeTransitionInstanceAccess().getRightCurlyBracketKeyword_8_2());
                        

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1893:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1894:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1895:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode3598);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode3608); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1902:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1905:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1906:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1906:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1906:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleSystemOperationMode3645); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1910:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1911:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1911:1: (lv_name_1_0= RULE_STRING )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1912:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSystemOperationMode3662); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSystemOperationModeAccess().getNameSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1928:2: ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=72 && LA38_0<=73)) ) {
                alt38=1;
            }
            else if ( (LA38_0==RULE_ID) ) {
                int LA38_2 = input.LA(2);

                if ( (LA38_2==EOF||LA38_2==RULE_ID||(LA38_2>=17 && LA38_2<=18)||LA38_2==20||LA38_2==23||LA38_2==25||(LA38_2>=29 && LA38_2<=30)||(LA38_2>=32 && LA38_2<=34)||LA38_2==37||LA38_2==41||(LA38_2>=52 && LA38_2<=59)||(LA38_2>=61 && LA38_2<=68)||LA38_2==70) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1928:3: ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1928:3: ( ( ruleInstanceRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1929:1: ( ruleInstanceRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1929:1: ( ruleInstanceRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1930:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstanceRef_in_ruleSystemOperationMode3691);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1943:2: (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==23) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1943:4: otherlv_3= ',' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleSystemOperationMode3704); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1947:1: ( ( ruleInstanceRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1948:1: ( ruleInstanceRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1948:1: ( ruleInstanceRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1949:3: ruleInstanceRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleInstanceRef_in_ruleSystemOperationMode3727);
                    	    ruleInstanceRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1970:1: entryRulePropertyAssociationInstance returns [EObject current=null] : iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF ;
    public final EObject entryRulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociationInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1971:2: (iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1972:2: iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF
            {
             newCompositeNode(grammarAccess.getPropertyAssociationInstanceRule()); 
            pushFollow(FOLLOW_rulePropertyAssociationInstance_in_entryRulePropertyAssociationInstance3767);
            iv_rulePropertyAssociationInstance=rulePropertyAssociationInstance();

            state._fsp--;

             current =iv_rulePropertyAssociationInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAssociationInstance3777); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1979:1: rulePropertyAssociationInstance returns [EObject current=null] : ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) ;
    public final EObject rulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedValue_2_0 = null;

        EObject lv_ownedValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1982:28: ( ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1983:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1983:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1983:2: ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1983:2: ( ( ruleQPREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1984:1: ( ruleQPREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1984:1: ( ruleQPREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1985:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQPREF_in_rulePropertyAssociationInstance3825);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_rulePropertyAssociationInstance3837); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationInstanceAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2002:1: ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2003:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2003:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2004:3: lv_ownedValue_2_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_rulePropertyAssociationInstance3858);
            lv_ownedValue_2_0=ruleOptionalModalPropertyValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                   		add(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_2_0, 
                    		"OptionalModalPropertyValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2020:2: (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==23) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2020:4: otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_rulePropertyAssociationInstance3871); 

            	        	newLeafNode(otherlv_3, grammarAccess.getPropertyAssociationInstanceAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2024:1: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2025:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2025:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2026:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_rulePropertyAssociationInstance3892);
            	    lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPropertyAssociationInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedValue",
            	            		lv_ownedValue_4_0, 
            	            		"OptionalModalPropertyValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_rulePropertyAssociationInstance3906); 

                	newLeafNode(otherlv_5, grammarAccess.getPropertyAssociationInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2046:1: ( ( rulePropertyAssociationRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2047:1: ( rulePropertyAssociationRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2047:1: ( rulePropertyAssociationRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2048:3: rulePropertyAssociationRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationPropertyAssociationCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyAssociationRef_in_rulePropertyAssociationInstance3929);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2069:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2070:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2071:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); 
            pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_entryRuleOptionalModalPropertyValue3965);
            iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue();

            state._fsp--;

             current =iv_ruleOptionalModalPropertyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptionalModalPropertyValue3975); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2078:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? ) ;
    public final EObject ruleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2081:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2082:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2082:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2082:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2082:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2083:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2083:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2084:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleOptionalModalPropertyValue4021);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOptionalModalPropertyValueRule());
            	        }
                   		set(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_0_0, 
                    		"PropertyExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2100:2: (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==20) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==21) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2100:4: otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleOptionalModalPropertyValue4034); 

                        	newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleOptionalModalPropertyValue4046); 

                        	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleOptionalModalPropertyValue4058); 

                        	newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2112:1: ( ( ruleSomRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2113:1: ( ruleSomRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2113:1: ( ruleSomRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2114:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSomRef_in_ruleOptionalModalPropertyValue4081);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2127:2: (otherlv_5= ',' ( ( ruleSomRef ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==23) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2127:4: otherlv_5= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleOptionalModalPropertyValue4094); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2131:1: ( ( ruleSomRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2132:1: ( ruleSomRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2132:1: ( ruleSomRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2133:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSomRef_in_ruleOptionalModalPropertyValue4117);
                    	    ruleSomRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleOptionalModalPropertyValue4131); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2158:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2159:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2160:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression4169);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;

             current =iv_rulePropertyExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyExpression4179); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2167:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2170:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2171:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2171:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            int alt42=12;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2172:5: this_RecordTerm_0= ruleRecordTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRecordTerm_in_rulePropertyExpression4226);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;

                     
                            current = this_RecordTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2182:5: this_ReferenceTerm_1= ruleReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleReferenceTerm_in_rulePropertyExpression4253);
                    this_ReferenceTerm_1=ruleReferenceTerm();

                    state._fsp--;

                     
                            current = this_ReferenceTerm_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2192:5: this_InstanceReferenceValue_2= ruleInstanceReferenceValue
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getInstanceReferenceValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInstanceReferenceValue_in_rulePropertyExpression4280);
                    this_InstanceReferenceValue_2=ruleInstanceReferenceValue();

                    state._fsp--;

                     
                            current = this_InstanceReferenceValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2202:5: this_ComponentClassifierTerm_3= ruleComponentClassifierTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression4307);
                    this_ComponentClassifierTerm_3=ruleComponentClassifierTerm();

                    state._fsp--;

                     
                            current = this_ComponentClassifierTerm_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2212:5: this_ComputedTerm_4= ruleComputedTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleComputedTerm_in_rulePropertyExpression4334);
                    this_ComputedTerm_4=ruleComputedTerm();

                    state._fsp--;

                     
                            current = this_ComputedTerm_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2222:5: this_StringTerm_5= ruleStringTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleStringTerm_in_rulePropertyExpression4361);
                    this_StringTerm_5=ruleStringTerm();

                    state._fsp--;

                     
                            current = this_StringTerm_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2232:5: this_NumericRangeTerm_6= ruleNumericRangeTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression4388);
                    this_NumericRangeTerm_6=ruleNumericRangeTerm();

                    state._fsp--;

                     
                            current = this_NumericRangeTerm_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2242:5: this_RealTerm_7= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleRealTerm_in_rulePropertyExpression4415);
                    this_RealTerm_7=ruleRealTerm();

                    state._fsp--;

                     
                            current = this_RealTerm_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2252:5: this_IntegerTerm_8= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleIntegerTerm_in_rulePropertyExpression4442);
                    this_IntegerTerm_8=ruleIntegerTerm();

                    state._fsp--;

                     
                            current = this_IntegerTerm_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2262:5: this_ListTerm_9= ruleListTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleListTerm_in_rulePropertyExpression4469);
                    this_ListTerm_9=ruleListTerm();

                    state._fsp--;

                     
                            current = this_ListTerm_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2272:5: this_BooleanLiteral_10= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rulePropertyExpression4496);
                    this_BooleanLiteral_10=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2282:5: this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleLiteralorReferenceTerm_in_rulePropertyExpression4523);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2298:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2299:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2300:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            pushFollow(FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement4558);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;

             current =iv_ruleContainmentPathElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPathElement4568); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2307:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2310:28: ( ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2311:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2311:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2311:2: ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2311:2: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2312:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2312:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2313:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleContainmentPathElement4616);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2326:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==18) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2327:1: (lv_arrayRange_1_0= ruleArrayRange )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2327:1: (lv_arrayRange_1_0= ruleArrayRange )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2328:3: lv_arrayRange_1_0= ruleArrayRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayRange_in_ruleContainmentPathElement4637);
                    lv_arrayRange_1_0=ruleArrayRange();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                    	        }
                           		add(
                           			current, 
                           			"arrayRange",
                            		lv_arrayRange_1_0, 
                            		"ArrayRange");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2344:3: (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==39) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2344:5: otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleContainmentPathElement4651); 

                        	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getSolidusKeyword_2_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2348:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2349:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2349:1: (lv_path_3_0= ruleContainmentPathElement )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2350:3: lv_path_3_0= ruleContainmentPathElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleContainmentPathElement4672);
                    lv_path_3_0=ruleContainmentPathElement();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainmentPathElementRule());
                    	        }
                           		set(
                           			current, 
                           			"path",
                            		lv_path_3_0, 
                            		"ContainmentPathElement");
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2374:1: entryRuleInstanceReferenceValue returns [EObject current=null] : iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF ;
    public final EObject entryRuleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceReferenceValue = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2375:2: (iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2376:2: iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF
            {
             newCompositeNode(grammarAccess.getInstanceReferenceValueRule()); 
            pushFollow(FOLLOW_ruleInstanceReferenceValue_in_entryRuleInstanceReferenceValue4710);
            iv_ruleInstanceReferenceValue=ruleInstanceReferenceValue();

            state._fsp--;

             current =iv_ruleInstanceReferenceValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceReferenceValue4720); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2383:1: ruleInstanceReferenceValue returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) ;
    public final EObject ruleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2386:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2387:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2387:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2387:3: otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleInstanceReferenceValue4757); 

                	newLeafNode(otherlv_0, grammarAccess.getInstanceReferenceValueAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleInstanceReferenceValue4769); 

                	newLeafNode(otherlv_1, grammarAccess.getInstanceReferenceValueAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2395:1: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2396:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2396:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2397:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInstanceReferenceValueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleInstanceReferenceValue4792);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleInstanceReferenceValue4804); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2422:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2423:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2424:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType4841);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType4852); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2431:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2434:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2435:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2435:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt45=3;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==20) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==41) ) {
                    alt45=3;
                }
                else if ( (LA45_1==EOF||(LA45_1>=42 && LA45_1<=51)) ) {
                    alt45=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA45_0==41) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2436:2: kw= 'in'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleDirectionType4890); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2443:2: kw= 'out'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleDirectionType4909); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2449:6: (kw= 'in' kw= 'out' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2449:6: (kw= 'in' kw= 'out' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2450:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleDirectionType4929); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleDirectionType4942); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2469:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2470:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2471:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory4984);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory4995); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2478:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2481:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2482:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2482:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            int alt46=10;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt46=1;
                }
                break;
            case 43:
                {
                alt46=2;
                }
                break;
            case 44:
                {
                alt46=3;
                }
                break;
            case 45:
                {
                alt46=4;
                }
                break;
            case 46:
                {
                alt46=5;
                }
                break;
            case 47:
                {
                alt46=6;
                }
                break;
            case 48:
                {
                alt46=7;
                }
                break;
            case 49:
                {
                alt46=8;
                }
                break;
            case 50:
                {
                alt46=9;
                }
                break;
            case 51:
                {
                alt46=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }

            switch (alt46) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2483:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleFeatureCategory5033); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2490:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleFeatureCategory5052); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2497:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleFeatureCategory5071); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2504:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleFeatureCategory5090); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2511:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleFeatureCategory5109); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2518:2: kw= 'dataAccess'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleFeatureCategory5128); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2525:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleFeatureCategory5147); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2532:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleFeatureCategory5166); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2539:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleFeatureCategory5185); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2546:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleFeatureCategory5204); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2559:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2560:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2561:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory5245);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory5256); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2568:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2571:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2572:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2572:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt47=14;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2573:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleComponentCategory5294); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2580:2: kw= 'bus'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleComponentCategory5313); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2587:2: kw= 'data'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleComponentCategory5332); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2594:2: kw= 'device'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleComponentCategory5351); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2601:2: kw= 'memory'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleComponentCategory5370); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2608:2: kw= 'process'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleComponentCategory5389); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2615:2: kw= 'processor'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleComponentCategory5408); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2622:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleComponentCategory5427); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2628:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2628:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2629:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleComponentCategory5447); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleComponentCategory5460); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2642:2: kw= 'system'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleComponentCategory5480); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2648:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2648:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2649:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleComponentCategory5500); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleComponentCategory5513); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2662:2: kw= 'thread'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleComponentCategory5533); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2668:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2668:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2669:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleComponentCategory5553); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleComponentCategory5566); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2681:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2681:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2682:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleComponentCategory5587); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleComponentCategory5600); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2701:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2702:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2703:2: iv_ruleConnectionKind= ruleConnectionKind EOF
            {
             newCompositeNode(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind5642);
            iv_ruleConnectionKind=ruleConnectionKind();

            state._fsp--;

             current =iv_ruleConnectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind5653); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2710:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2713:28: ( (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2714:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2714:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            int alt48=5;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt48=1;
                }
                break;
            case 65:
                {
                alt48=2;
                }
                break;
            case 66:
                {
                alt48=3;
                }
                break;
            case 67:
                {
                alt48=4;
                }
                break;
            case 68:
                {
                alt48=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2715:2: kw= 'featureConnection'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleConnectionKind5691); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2722:2: kw= 'accessConnection'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleConnectionKind5710); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2729:2: kw= 'parameterConnection'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleConnectionKind5729); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2736:2: kw= 'portConnection'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleConnectionKind5748); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2743:2: kw= 'featureGroupConnection'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleConnectionKind5767); 

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


    // $ANTLR start "entryRuleImplRef"
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2756:1: entryRuleImplRef returns [String current=null] : iv_ruleImplRef= ruleImplRef EOF ;
    public final String entryRuleImplRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2757:2: (iv_ruleImplRef= ruleImplRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2758:2: iv_ruleImplRef= ruleImplRef EOF
            {
             newCompositeNode(grammarAccess.getImplRefRule()); 
            pushFollow(FOLLOW_ruleImplRef_in_entryRuleImplRef5808);
            iv_ruleImplRef=ruleImplRef();

            state._fsp--;

             current =iv_ruleImplRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplRef5819); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2765:1: ruleImplRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleImplRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2768:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2769:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2769:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2769:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2769:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    int LA49_1 = input.LA(2);

                    if ( (LA49_1==69) ) {
                        alt49=1;
                    }


                }


                switch (alt49) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2769:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImplRef5860); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_ruleImplRef5878); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getImplRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImplRef5895); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,70,FOLLOW_70_in_ruleImplRef5913); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getImplRefAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImplRef5928); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2810:1: entryRuleDeclarativeRef returns [String current=null] : iv_ruleDeclarativeRef= ruleDeclarativeRef EOF ;
    public final String entryRuleDeclarativeRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeclarativeRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2811:2: (iv_ruleDeclarativeRef= ruleDeclarativeRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2812:2: iv_ruleDeclarativeRef= ruleDeclarativeRef EOF
            {
             newCompositeNode(grammarAccess.getDeclarativeRefRule()); 
            pushFollow(FOLLOW_ruleDeclarativeRef_in_entryRuleDeclarativeRef5974);
            iv_ruleDeclarativeRef=ruleDeclarativeRef();

            state._fsp--;

             current =iv_ruleDeclarativeRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarativeRef5985); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2819:1: ruleDeclarativeRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2822:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2823:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2823:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2823:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2823:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    int LA50_1 = input.LA(2);

                    if ( (LA50_1==69) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2823:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclarativeRef6026); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_ruleDeclarativeRef6044); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclarativeRef6061); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2843:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==70) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2844:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleDeclarativeRef6080); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclarativeRef6095); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_15_in_ruleDeclarativeRef6115); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonKeyword_3()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2862:1: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==36) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_ID) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2862:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2862:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2863:2: kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleDeclarativeRef6130); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getTransitionKeyword_4_0_0()); 
                        
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleDeclarativeRef6143); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getNumberSignKeyword_4_0_1()); 
                        
                    this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleDeclarativeRef6158); 

                    		current.merge(this_INTEGER_LIT_8);
                        
                     
                        newLeafNode(this_INTEGER_LIT_8, grammarAccess.getDeclarativeRefAccess().getINTEGER_LITTerminalRuleCall_4_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2882:10: this_ID_9= RULE_ID
                    {
                    this_ID_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclarativeRef6185); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2897:1: entryRuleInstanceRef returns [String current=null] : iv_ruleInstanceRef= ruleInstanceRef EOF ;
    public final String entryRuleInstanceRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInstanceRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2898:2: (iv_ruleInstanceRef= ruleInstanceRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2899:2: iv_ruleInstanceRef= ruleInstanceRef EOF
            {
             newCompositeNode(grammarAccess.getInstanceRefRule()); 
            pushFollow(FOLLOW_ruleInstanceRef_in_entryRuleInstanceRef6232);
            iv_ruleInstanceRef=ruleInstanceRef();

            state._fsp--;

             current =iv_ruleInstanceRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceRef6243); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2906:1: ruleInstanceRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2909:28: ( (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2910:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2910:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==72) ) {
                alt57=1;
            }
            else if ( (LA57_0==RULE_ID||LA57_0==73) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2911:2: kw= 'parent'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleInstanceRef6281); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getParentKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2917:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2917:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2917:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2917:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*
                    loop54:
                    do {
                        int alt54=2;
                        alt54 = dfa54.predict(input);
                        switch (alt54) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2917:12: this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.'
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstanceRef6304); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_0_0()); 
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2924:1: (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )*
                    	    loop53:
                    	    do {
                    	        int alt53=2;
                    	        int LA53_0 = input.LA(1);

                    	        if ( (LA53_0==18) ) {
                    	            alt53=1;
                    	        }


                    	        switch (alt53) {
                    	    	case 1 :
                    	    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2925:2: kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']'
                    	    	    {
                    	    	    kw=(Token)match(input,18,FOLLOW_18_in_ruleInstanceRef6323); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_0_1_0()); 
                    	    	        
                    	    	    this_INTEGER_LIT_3=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6338); 

                    	    	    		current.merge(this_INTEGER_LIT_3);
                    	    	        
                    	    	     
                    	    	        newLeafNode(this_INTEGER_LIT_3, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_0_1_1()); 
                    	    	        
                    	    	    kw=(Token)match(input,19,FOLLOW_19_in_ruleInstanceRef6356); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_0_1_2()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop53;
                    	        }
                    	    } while (true);

                    	    kw=(Token)match(input,70,FOLLOW_70_in_ruleInstanceRef6371); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop54;
                        }
                    } while (true);

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2949:3: ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    int alt56=2;
                    int LA56_0 = input.LA(1);

                    if ( (LA56_0==73) ) {
                        alt56=1;
                    }
                    else if ( (LA56_0==RULE_ID) ) {
                        alt56=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 56, 0, input);

                        throw nvae;
                    }
                    switch (alt56) {
                        case 1 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2949:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2949:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2950:2: kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,73,FOLLOW_73_in_ruleInstanceRef6388); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getConnectionKeyword_1_1_0_0()); 
                                
                            kw=(Token)match(input,71,FOLLOW_71_in_ruleInstanceRef6401); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getNumberSignKeyword_1_1_0_1()); 
                                
                            this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6416); 

                            		current.merge(this_INTEGER_LIT_8);
                                
                             
                                newLeafNode(this_INTEGER_LIT_8, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_0_2()); 
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2969:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2969:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2969:11: this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            {
                            this_ID_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstanceRef6444); 

                            		current.merge(this_ID_9);
                                
                             
                                newLeafNode(this_ID_9, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_1_1_0()); 
                                
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2976:1: (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            loop55:
                            do {
                                int alt55=2;
                                int LA55_0 = input.LA(1);

                                if ( (LA55_0==18) ) {
                                    alt55=1;
                                }


                                switch (alt55) {
                            	case 1 :
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2977:2: kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']'
                            	    {
                            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleInstanceRef6463); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_1_1_1_0()); 
                            	        
                            	    this_INTEGER_LIT_11=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6478); 

                            	    		current.merge(this_INTEGER_LIT_11);
                            	        
                            	     
                            	        newLeafNode(this_INTEGER_LIT_11, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_1_1_1()); 
                            	        
                            	    kw=(Token)match(input,19,FOLLOW_19_in_ruleInstanceRef6496); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_1_1_1_2()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop55;
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


    // $ANTLR start "entryRuleSomRef"
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3003:1: entryRuleSomRef returns [String current=null] : iv_ruleSomRef= ruleSomRef EOF ;
    public final String entryRuleSomRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSomRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3004:2: (iv_ruleSomRef= ruleSomRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3005:2: iv_ruleSomRef= ruleSomRef EOF
            {
             newCompositeNode(grammarAccess.getSomRefRule()); 
            pushFollow(FOLLOW_ruleSomRef_in_entryRuleSomRef6542);
            iv_ruleSomRef=ruleSomRef();

            state._fsp--;

             current =iv_ruleSomRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSomRef6553); 

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
    // $ANTLR end "entryRuleSomRef"


    // $ANTLR start "ruleSomRef"
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3012:1: ruleSomRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSomRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3015:28: ( (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3016:1: (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3016:1: (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3017:2: kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            kw=(Token)match(input,37,FOLLOW_37_in_ruleSomRef6591); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSomRefAccess().getSomKeyword_0()); 
                
            kw=(Token)match(input,71,FOLLOW_71_in_ruleSomRef6604); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSomRefAccess().getNumberSignKeyword_1()); 
                
            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleSomRef6619); 

            		current.merge(this_INTEGER_LIT_2);
                
             
                newLeafNode(this_INTEGER_LIT_2, grammarAccess.getSomRefAccess().getINTEGER_LITTerminalRuleCall_2()); 
                

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
    // $ANTLR end "ruleSomRef"


    // $ANTLR start "entryRuleTransitionRef"
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3043:1: entryRuleTransitionRef returns [String current=null] : iv_ruleTransitionRef= ruleTransitionRef EOF ;
    public final String entryRuleTransitionRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTransitionRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3044:2: (iv_ruleTransitionRef= ruleTransitionRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3045:2: iv_ruleTransitionRef= ruleTransitionRef EOF
            {
             newCompositeNode(grammarAccess.getTransitionRefRule()); 
            pushFollow(FOLLOW_ruleTransitionRef_in_entryRuleTransitionRef6665);
            iv_ruleTransitionRef=ruleTransitionRef();

            state._fsp--;

             current =iv_ruleTransitionRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionRef6676); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3052:1: ruleTransitionRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleTransitionRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3055:28: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3056:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3056:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3057:2: kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            kw=(Token)match(input,36,FOLLOW_36_in_ruleTransitionRef6714); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTransitionRefAccess().getTransitionKeyword_0()); 
                
            kw=(Token)match(input,71,FOLLOW_71_in_ruleTransitionRef6727); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTransitionRefAccess().getNumberSignKeyword_1()); 
                
            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleTransitionRef6742); 

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


    // $ANTLR start "entryRuleModeTransitionName"
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3083:1: entryRuleModeTransitionName returns [String current=null] : iv_ruleModeTransitionName= ruleModeTransitionName EOF ;
    public final String entryRuleModeTransitionName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModeTransitionName = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3084:2: (iv_ruleModeTransitionName= ruleModeTransitionName EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3085:2: iv_ruleModeTransitionName= ruleModeTransitionName EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionNameRule()); 
            pushFollow(FOLLOW_ruleModeTransitionName_in_entryRuleModeTransitionName6788);
            iv_ruleModeTransitionName=ruleModeTransitionName();

            state._fsp--;

             current =iv_ruleModeTransitionName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransitionName6799); 

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
    // $ANTLR end "entryRuleModeTransitionName"


    // $ANTLR start "ruleModeTransitionName"
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3092:1: ruleModeTransitionName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModeTransitionName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3095:28: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3096:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3096:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3096:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionName6839); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,70,FOLLOW_70_in_ruleModeTransitionName6857); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getModeTransitionNameAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionName6872); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_2()); 
                
            kw=(Token)match(input,70,FOLLOW_70_in_ruleModeTransitionName6890); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getModeTransitionNameAccess().getFullStopKeyword_3()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionName6905); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_4()); 
                

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
    // $ANTLR end "ruleModeTransitionName"


    // $ANTLR start "entryRulePropertyAssociationRef"
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3137:1: entryRulePropertyAssociationRef returns [String current=null] : iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF ;
    public final String entryRulePropertyAssociationRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePropertyAssociationRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3138:2: (iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3139:2: iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF
            {
             newCompositeNode(grammarAccess.getPropertyAssociationRefRule()); 
            pushFollow(FOLLOW_rulePropertyAssociationRef_in_entryRulePropertyAssociationRef6951);
            iv_rulePropertyAssociationRef=rulePropertyAssociationRef();

            state._fsp--;

             current =iv_rulePropertyAssociationRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAssociationRef6962); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3146:1: rulePropertyAssociationRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3149:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3150:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3150:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3150:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3150:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt58=0;
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    int LA58_1 = input.LA(2);

                    if ( (LA58_1==69) ) {
                        alt58=1;
                    }


                }


                switch (alt58) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3150:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociationRef7003); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_rulePropertyAssociationRef7021); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt58 >= 1 ) break loop58;
                        EarlyExitException eee =
                            new EarlyExitException(58, input);
                        throw eee;
                }
                cnt58++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociationRef7038); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3170:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==70) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3171:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_rulePropertyAssociationRef7057); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociationRef7072); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_15_in_rulePropertyAssociationRef7092); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_3()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3189:1: ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ID||LA61_0==36) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3189:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':'
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3189:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) )
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==RULE_ID) ) {
                        alt60=1;
                    }
                    else if ( (LA60_0==36) ) {
                        alt60=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 0, input);

                        throw nvae;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3189:7: this_ID_6= RULE_ID
                            {
                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociationRef7109); 

                            		current.merge(this_ID_6);
                                
                             
                                newLeafNode(this_ID_6, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3197:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3197:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3198:2: kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,36,FOLLOW_36_in_rulePropertyAssociationRef7134); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getTransitionKeyword_4_0_1_0()); 
                                
                            kw=(Token)match(input,71,FOLLOW_71_in_rulePropertyAssociationRef7147); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_4_0_1_1()); 
                                
                            this_INTEGER_LIT_9=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_rulePropertyAssociationRef7162); 

                            		current.merge(this_INTEGER_LIT_9);
                                
                             
                                newLeafNode(this_INTEGER_LIT_9, grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_4_0_1_2()); 
                                

                            }


                            }
                            break;

                    }

                    kw=(Token)match(input,15,FOLLOW_15_in_rulePropertyAssociationRef7182); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_4_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,74,FOLLOW_74_in_rulePropertyAssociationRef7197); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getPropertyKeyword_5()); 
                
            kw=(Token)match(input,71,FOLLOW_71_in_rulePropertyAssociationRef7210); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_6()); 
                
            this_INTEGER_LIT_13=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_rulePropertyAssociationRef7225); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3249:1: entryRuleLong returns [String current=null] : iv_ruleLong= ruleLong EOF ;
    public final String entryRuleLong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLong = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3250:2: (iv_ruleLong= ruleLong EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3251:2: iv_ruleLong= ruleLong EOF
            {
             newCompositeNode(grammarAccess.getLongRule()); 
            pushFollow(FOLLOW_ruleLong_in_entryRuleLong7271);
            iv_ruleLong=ruleLong();

            state._fsp--;

             current =iv_ruleLong.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLong7282); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3258:1: ruleLong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleLong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3261:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3262:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleLong7321); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3279:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3280:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3281:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation7367);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;

             current =iv_ruleContainedPropertyAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainedPropertyAssociation7377); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3288:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' ) ;
    public final EObject ruleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_append_2_0=null;
        Token lv_constant_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        EObject lv_ownedValue_4_0 = null;

        EObject lv_ownedValue_6_0 = null;

        EObject lv_appliesTo_9_0 = null;

        EObject lv_appliesTo_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3291:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3292:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3292:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3292:2: ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3292:2: ( ( ruleQPREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3293:1: ( ruleQPREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3293:1: ( ruleQPREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3294:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQPREF_in_ruleContainedPropertyAssociation7425);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3307:2: (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==38) ) {
                alt62=1;
            }
            else if ( (LA62_0==75) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3307:4: otherlv_1= '=>'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleContainedPropertyAssociation7438); 

                        	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3312:6: ( (lv_append_2_0= '+=>' ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3312:6: ( (lv_append_2_0= '+=>' ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3313:1: (lv_append_2_0= '+=>' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3313:1: (lv_append_2_0= '+=>' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3314:3: lv_append_2_0= '+=>'
                    {
                    lv_append_2_0=(Token)match(input,75,FOLLOW_75_in_ruleContainedPropertyAssociation7462); 

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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3327:3: ( (lv_constant_3_0= 'constant' ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==76) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3328:1: (lv_constant_3_0= 'constant' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3328:1: (lv_constant_3_0= 'constant' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3329:3: lv_constant_3_0= 'constant'
                    {
                    lv_constant_3_0=(Token)match(input,76,FOLLOW_76_in_ruleContainedPropertyAssociation7494); 

                            newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "constant", true, "constant");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3342:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3342:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3342:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3343:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3343:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3344:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
            	    
            pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation7530);
            lv_ownedValue_4_0=ruleOptionalModalPropertyValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	        }
                   		add(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_4_0, 
                    		"OptionalModalPropertyValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3360:2: (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==23) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3360:4: otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleContainedPropertyAssociation7543); 

            	        	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	        
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3364:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3365:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3365:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3366:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation7564);
            	    lv_ownedValue_6_0=ruleOptionalModalPropertyValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedValue",
            	            		lv_ownedValue_6_0, 
            	            		"OptionalModalPropertyValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop64;
                }
            } while (true);


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3382:5: (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==77) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3382:7: otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    {
                    otherlv_7=(Token)match(input,77,FOLLOW_77_in_ruleContainedPropertyAssociation7580); 

                        	newLeafNode(otherlv_7, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());
                        
                    otherlv_8=(Token)match(input,31,FOLLOW_31_in_ruleContainedPropertyAssociation7592); 

                        	newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3390:1: ( (lv_appliesTo_9_0= ruleContainmentPath ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3391:1: (lv_appliesTo_9_0= ruleContainmentPath )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3391:1: (lv_appliesTo_9_0= ruleContainmentPath )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3392:3: lv_appliesTo_9_0= ruleContainmentPath
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation7613);
                    lv_appliesTo_9_0=ruleContainmentPath();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		add(
                           			current, 
                           			"appliesTo",
                            		lv_appliesTo_9_0, 
                            		"ContainmentPath");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3408:2: (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==23) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3408:4: otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_10=(Token)match(input,23,FOLLOW_23_in_ruleContainedPropertyAssociation7626); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3412:1: ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3413:1: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3413:1: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3414:3: lv_appliesTo_11_0= ruleContainmentPath
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation7647);
                    	    lv_appliesTo_11_0=ruleContainmentPath();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"appliesTo",
                    	            		lv_appliesTo_11_0, 
                    	            		"ContainmentPath");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3430:6: (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==20) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3430:8: otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')'
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_20_in_ruleContainedPropertyAssociation7664); 

                        	newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getInKeyword_5_0());
                        
                    otherlv_13=(Token)match(input,78,FOLLOW_78_in_ruleContainedPropertyAssociation7676); 

                        	newLeafNode(otherlv_13, grammarAccess.getContainedPropertyAssociationAccess().getBindingKeyword_5_1());
                        
                    otherlv_14=(Token)match(input,22,FOLLOW_22_in_ruleContainedPropertyAssociation7688); 

                        	newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3442:1: ( ( ruleQCREF ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3443:1: ( ruleQCREF )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3443:1: ( ruleQCREF )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3444:3: ruleQCREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQCREF_in_ruleContainedPropertyAssociation7711);
                    ruleQCREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_16=(Token)match(input,24,FOLLOW_24_in_ruleContainedPropertyAssociation7723); 

                        	newLeafNode(otherlv_16, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_17=(Token)match(input,79,FOLLOW_79_in_ruleContainedPropertyAssociation7737); 

                	newLeafNode(otherlv_17, grammarAccess.getContainedPropertyAssociationAccess().getSemicolonKeyword_6());
                

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3477:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3478:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3479:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathRule()); 
            pushFollow(FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath7777);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;

             current =iv_ruleContainmentPath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPath7787); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3486:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3489:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3490:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3490:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3491:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3491:1: (lv_path_0_0= ruleContainmentPathElement )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3492:3: lv_path_0_0= ruleContainmentPathElement
            {
             
            	        newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath7832);
            lv_path_0_0=ruleContainmentPathElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getContainmentPathRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_0_0, 
                    		"ContainmentPathElement");
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3518:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3519:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3520:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueRule()); 
            pushFollow(FOLLOW_rulePropertyValue_in_entryRulePropertyValue7869);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;

             current =iv_rulePropertyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyValue7879); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3527:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3530:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3531:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3531:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3532:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3532:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3533:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyExpression_in_rulePropertyValue7924);
            lv_ownedValue_0_0=rulePropertyExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPropertyValueRule());
            	        }
                   		set(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_0_0, 
                    		"PropertyExpression");
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3557:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3558:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3559:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            pushFollow(FOLLOW_ruleLiteralorReferenceTerm_in_entryRuleLiteralorReferenceTerm7959);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;

             current =iv_ruleLiteralorReferenceTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralorReferenceTerm7969); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3566:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3569:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3570:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3570:1: ( ( ruleQPREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3571:1: ( ruleQPREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3571:1: ( ruleQPREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3572:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQPREF_in_ruleLiteralorReferenceTerm8016);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3593:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3594:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3595:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8051);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral8061); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3602:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3605:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3606:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3606:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3606:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3606:2: ()
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3607:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3612:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==80) ) {
                alt68=1;
            }
            else if ( (LA68_0==81) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3612:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3612:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3613:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3613:1: (lv_value_1_0= 'true' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3614:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,80,FOLLOW_80_in_ruleBooleanLiteral8114); 

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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3628:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,81,FOLLOW_81_in_ruleBooleanLiteral8145); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3640:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3641:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3642:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_ruleConstantValue_in_entryRuleConstantValue8182);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantValue8192); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3649:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3652:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3653:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3653:1: ( ( ruleQPREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3654:1: ( ruleQPREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3654:1: ( ruleQPREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3655:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantValueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQPREF_in_ruleConstantValue8239);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3676:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3677:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3678:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getReferenceTermRule()); 
            pushFollow(FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm8274);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;

             current =iv_ruleReferenceTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceTerm8284); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3685:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3688:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3689:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3689:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3689:3: otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleReferenceTerm8321); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleReferenceTerm8333); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3697:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3698:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3698:1: (lv_path_2_0= ruleContainmentPathElement )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3699:3: lv_path_2_0= ruleContainmentPathElement
            {
             
            	        newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8354);
            lv_path_2_0=ruleContainmentPathElement();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceTermRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_2_0, 
                    		"ContainmentPathElement");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleReferenceTerm8366); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3727:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3728:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3729:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
             newCompositeNode(grammarAccess.getRecordTermRule()); 
            pushFollow(FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm8402);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;

             current =iv_ruleRecordTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordTerm8412); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3736:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3739:28: ( (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3740:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3740:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3740:3: otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleRecordTerm8449); 

                	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3744:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt69=0;
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==RULE_ID) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3745:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3745:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3746:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm8470);
            	    lv_ownedFieldValue_1_0=ruleFieldPropertyAssociation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRecordTermRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedFieldValue",
            	            		lv_ownedFieldValue_1_0, 
            	            		"FieldPropertyAssociation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt69 >= 1 ) break loop69;
                        EarlyExitException eee =
                            new EarlyExitException(69, input);
                        throw eee;
                }
                cnt69++;
            } while (true);

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleRecordTerm8483); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3776:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3777:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3778:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
             newCompositeNode(grammarAccess.getComputedTermRule()); 
            pushFollow(FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm8521);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;

             current =iv_ruleComputedTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComputedTerm8531); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3785:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3788:28: ( (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3789:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3789:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3789:3: otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleComputedTerm8568); 

                	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleComputedTerm8580); 

                	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3797:1: ( (lv_function_2_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3798:1: (lv_function_2_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3798:1: (lv_function_2_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3799:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComputedTerm8597); 

            			newLeafNode(lv_function_2_0, grammarAccess.getComputedTermAccess().getFunctionIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getComputedTermRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"function",
                    		lv_function_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleComputedTerm8614); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3827:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3828:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3829:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
             newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            pushFollow(FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm8650);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;

             current =iv_ruleComponentClassifierTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentClassifierTerm8660); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3836:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3839:28: ( (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3840:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3840:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3840:3: otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_83_in_ruleComponentClassifierTerm8697); 

                	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleComponentClassifierTerm8709); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3848:1: ( ( ruleQCREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3849:1: ( ruleQCREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3849:1: ( ruleQCREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3850:3: ruleQCREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentClassifierTermRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm8732);
            ruleQCREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleComponentClassifierTerm8744); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3875:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3876:2: (iv_ruleListTerm= ruleListTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3877:2: iv_ruleListTerm= ruleListTerm EOF
            {
             newCompositeNode(grammarAccess.getListTermRule()); 
            pushFollow(FOLLOW_ruleListTerm_in_entryRuleListTerm8780);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;

             current =iv_ruleListTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListTerm8790); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3884:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3887:28: ( ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3888:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3888:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3888:2: () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3888:2: ()
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3889:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListTermAccess().getListValueAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleListTerm8836); 

                	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3898:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=RULE_ID && LA71_0<=RULE_REAL_LIT)||LA71_0==18||LA71_0==22||LA71_0==40||(LA71_0>=80 && LA71_0<=85)) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3898:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3898:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3899:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3899:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3900:3: lv_ownedListElement_2_0= rulePropertyExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyExpression_in_ruleListTerm8858);
                    lv_ownedListElement_2_0=rulePropertyExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getListTermRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedListElement",
                            		lv_ownedListElement_2_0, 
                            		"PropertyExpression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3916:2: (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop70:
                    do {
                        int alt70=2;
                        int LA70_0 = input.LA(1);

                        if ( (LA70_0==23) ) {
                            alt70=1;
                        }


                        switch (alt70) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3916:4: otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleListTerm8871); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3920:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3921:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3921:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3922:3: lv_ownedListElement_4_0= rulePropertyExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyExpression_in_ruleListTerm8892);
                    	    lv_ownedListElement_4_0=rulePropertyExpression();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getListTermRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedListElement",
                    	            		lv_ownedListElement_4_0, 
                    	            		"PropertyExpression");
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
                    break;

            }

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleListTerm8908); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3950:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3951:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3952:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            pushFollow(FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation8944);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;

             current =iv_ruleFieldPropertyAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFieldPropertyAssociation8954); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3959:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3962:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3963:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3963:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3963:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3963:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3964:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3964:1: (otherlv_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3965:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation8999); 

            		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleFieldPropertyAssociation9011); 

                	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3980:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3981:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3981:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3982:3: lv_ownedValue_2_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation9032);
            lv_ownedValue_2_0=rulePropertyExpression();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFieldPropertyAssociationRule());
            	        }
                   		set(
                   			current, 
                   			"ownedValue",
                    		lv_ownedValue_2_0, 
                    		"PropertyExpression");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,79,FOLLOW_79_in_ruleFieldPropertyAssociation9044); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4012:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4013:2: (iv_rulePlusMinus= rulePlusMinus EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4014:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
             newCompositeNode(grammarAccess.getPlusMinusRule()); 
            pushFollow(FOLLOW_rulePlusMinus_in_entryRulePlusMinus9083);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;

             current =iv_rulePlusMinus.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlusMinus9094); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4021:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4024:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4025:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4025:1: (kw= '+' | kw= '-' )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==84) ) {
                alt72=1;
            }
            else if ( (LA72_0==85) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4026:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_rulePlusMinus9132); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4033:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_rulePlusMinus9151); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4046:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4047:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4048:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm9191);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm9201); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4055:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4058:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4059:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4059:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4060:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4060:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4061:3: lv_value_0_0= ruleNoQuoteString
            {
             
            	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm9246);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStringTermRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"NoQuoteString");
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4085:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4086:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4087:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
             newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString9282);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;

             current =iv_ruleNoQuoteString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString9293); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4094:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4097:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4098:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString9332); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4113:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4114:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4115:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
             newCompositeNode(grammarAccess.getArrayRangeRule()); 
            pushFollow(FOLLOW_ruleArrayRange_in_entryRuleArrayRange9376);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;

             current =iv_ruleArrayRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayRange9386); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4122:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4125:28: ( ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4126:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4126:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4126:2: () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4126:2: ()
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4127:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleArrayRange9432); 

                	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4136:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4137:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4137:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4138:3: lv_lowerBound_2_0= ruleINTVALUE
            {
             
            	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleINTVALUE_in_ruleArrayRange9453);
            lv_lowerBound_2_0=ruleINTVALUE();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
            	        }
                   		set(
                   			current, 
                   			"lowerBound",
                    		lv_lowerBound_2_0, 
                    		"INTVALUE");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4154:2: (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==86) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4154:4: otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,86,FOLLOW_86_in_ruleArrayRange9466); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4158:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4159:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4159:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4160:3: lv_upperBound_4_0= ruleINTVALUE
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINTVALUE_in_ruleArrayRange9487);
                    lv_upperBound_4_0=ruleINTVALUE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getArrayRangeRule());
                    	        }
                           		set(
                           			current, 
                           			"upperBound",
                            		lv_upperBound_4_0, 
                            		"INTVALUE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrayRange9501); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4188:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4189:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4190:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
             newCompositeNode(grammarAccess.getSignedConstantRule()); 
            pushFollow(FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant9537);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;

             current =iv_ruleSignedConstant; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedConstant9547); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4197:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4200:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4201:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4201:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4201:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4201:2: ( (lv_op_0_0= rulePlusMinus ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4202:1: (lv_op_0_0= rulePlusMinus )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4202:1: (lv_op_0_0= rulePlusMinus )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4203:3: lv_op_0_0= rulePlusMinus
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePlusMinus_in_ruleSignedConstant9593);
            lv_op_0_0=rulePlusMinus();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
            	        }
                   		set(
                   			current, 
                   			"op",
                    		lv_op_0_0, 
                    		"PlusMinus");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4219:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4220:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4220:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4221:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleConstantValue_in_ruleSignedConstant9614);
            lv_ownedPropertyExpression_1_0=ruleConstantValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSignedConstantRule());
            	        }
                   		add(
                   			current, 
                   			"ownedPropertyExpression",
                    		lv_ownedPropertyExpression_1_0, 
                    		"ConstantValue");
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4245:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4246:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4247:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm9650);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm9660); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4254:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4257:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4258:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4258:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4258:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4258:2: ( (lv_value_0_0= ruleSignedInt ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4259:1: (lv_value_0_0= ruleSignedInt )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4259:1: (lv_value_0_0= ruleSignedInt )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4260:3: lv_value_0_0= ruleSignedInt
            {
             
            	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSignedInt_in_ruleIntegerTerm9706);
            lv_value_0_0=ruleSignedInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIntegerTermRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"SignedInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4276:2: ( (otherlv_1= RULE_ID ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4277:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4277:1: (otherlv_1= RULE_ID )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4278:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntegerTermRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerTerm9726); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4297:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4298:2: (iv_ruleSignedInt= ruleSignedInt EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4299:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
             newCompositeNode(grammarAccess.getSignedIntRule()); 
            pushFollow(FOLLOW_ruleSignedInt_in_entryRuleSignedInt9764);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;

             current =iv_ruleSignedInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInt9775); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4306:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4309:28: ( ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4310:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4310:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4310:2: (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4310:2: (kw= '+' | kw= '-' )?
            int alt75=3;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==84) ) {
                alt75=1;
            }
            else if ( (LA75_0==85) ) {
                alt75=2;
            }
            switch (alt75) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4311:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleSignedInt9814); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4318:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleSignedInt9833); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleSignedInt9850); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4338:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4339:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4340:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm9895);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm9905); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4347:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4350:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4351:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4351:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4351:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4351:2: ( (lv_value_0_0= ruleSignedReal ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4352:1: (lv_value_0_0= ruleSignedReal )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4352:1: (lv_value_0_0= ruleSignedReal )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4353:3: lv_value_0_0= ruleSignedReal
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSignedReal_in_ruleRealTerm9951);
            lv_value_0_0=ruleSignedReal();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRealTermRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"SignedReal");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4369:2: ( (otherlv_1= RULE_ID ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4370:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4370:1: (otherlv_1= RULE_ID )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4371:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRealTermRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealTerm9971); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4390:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4391:2: (iv_ruleSignedReal= ruleSignedReal EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4392:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
             newCompositeNode(grammarAccess.getSignedRealRule()); 
            pushFollow(FOLLOW_ruleSignedReal_in_entryRuleSignedReal10009);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;

             current =iv_ruleSignedReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedReal10020); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4399:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4402:28: ( ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4403:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4403:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4403:2: (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4403:2: (kw= '+' | kw= '-' )?
            int alt77=3;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==84) ) {
                alt77=1;
            }
            else if ( (LA77_0==85) ) {
                alt77=2;
            }
            switch (alt77) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4404:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleSignedReal10059); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4411:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleSignedReal10078); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_REAL_LIT_2=(Token)match(input,RULE_REAL_LIT,FOLLOW_RULE_REAL_LIT_in_ruleSignedReal10095); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4431:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4432:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4433:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
             newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            pushFollow(FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm10140);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;

             current =iv_ruleNumericRangeTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericRangeTerm10150); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4440:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4443:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4444:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4444:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4444:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4444:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4445:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4445:1: (lv_minimum_0_0= ruleNumAlt )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4446:3: lv_minimum_0_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10196);
            lv_minimum_0_0=ruleNumAlt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
            	        }
                   		set(
                   			current, 
                   			"minimum",
                    		lv_minimum_0_0, 
                    		"NumAlt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,86,FOLLOW_86_in_ruleNumericRangeTerm10208); 

                	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4466:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4467:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4467:1: (lv_maximum_2_0= ruleNumAlt )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4468:3: lv_maximum_2_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10229);
            lv_maximum_2_0=ruleNumAlt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
            	        }
                   		set(
                   			current, 
                   			"maximum",
                    		lv_maximum_2_0, 
                    		"NumAlt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4484:2: (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==87) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4484:4: otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,87,FOLLOW_87_in_ruleNumericRangeTerm10242); 

                        	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4488:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4489:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4489:1: (lv_delta_4_0= ruleNumAlt )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4490:3: lv_delta_4_0= ruleNumAlt
                    {
                     
                    	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10263);
                    lv_delta_4_0=ruleNumAlt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNumericRangeTermRule());
                    	        }
                           		set(
                           			current, 
                           			"delta",
                            		lv_delta_4_0, 
                            		"NumAlt");
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4514:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4515:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4516:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
             newCompositeNode(grammarAccess.getNumAltRule()); 
            pushFollow(FOLLOW_ruleNumAlt_in_entryRuleNumAlt10301);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;

             current =iv_ruleNumAlt; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumAlt10311); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4523:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4526:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4527:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4527:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt79=4;
            switch ( input.LA(1) ) {
            case 84:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt79=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt79=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt79=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;
                }

                }
                break;
            case 85:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt79=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt79=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt79=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt79=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt79=2;
                }
                break;
            case RULE_ID:
                {
                alt79=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }

            switch (alt79) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4528:5: this_RealTerm_0= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleNumAlt10358);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;

                     
                            current = this_RealTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4538:5: this_IntegerTerm_1= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleNumAlt10385);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;

                     
                            current = this_IntegerTerm_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4548:5: this_SignedConstant_2= ruleSignedConstant
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleNumAlt10412);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;

                     
                            current = this_SignedConstant_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4558:5: this_ConstantValue_3= ruleConstantValue
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleNumAlt10439);
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


    // $ANTLR start "entryRuleINTVALUE"
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4574:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4575:2: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4576:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
             newCompositeNode(grammarAccess.getINTVALUERule()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE10475);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;

             current =iv_ruleINTVALUE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTVALUE10486); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4583:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4586:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4587:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE10525); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4604:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4605:2: (iv_ruleQPREF= ruleQPREF EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4606:2: iv_ruleQPREF= ruleQPREF EOF
            {
             newCompositeNode(grammarAccess.getQPREFRule()); 
            pushFollow(FOLLOW_ruleQPREF_in_entryRuleQPREF10572);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;

             current =iv_ruleQPREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQPREF10583); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4613:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4616:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4617:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4617:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4617:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQPREF10623); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4624:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==69) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4625:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleQPREF10642); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQPREF10657); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4645:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4646:2: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4647:2: iv_ruleQCREF= ruleQCREF EOF
            {
             newCompositeNode(grammarAccess.getQCREFRule()); 
            pushFollow(FOLLOW_ruleQCREF_in_entryRuleQCREF10705);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;

             current =iv_ruleQCREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQCREF10716); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4654:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4657:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4658:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4658:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4658:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4658:2: (this_ID_0= RULE_ID kw= '::' )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==RULE_ID) ) {
                    int LA81_1 = input.LA(2);

                    if ( (LA81_1==69) ) {
                        alt81=1;
                    }


                }


                switch (alt81) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4658:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF10757); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_ruleQCREF10775); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF10792); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4678:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==70) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4679:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleQCREF10811); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF10826); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4699:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4700:2: (iv_ruleSTAR= ruleSTAR EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4701:2: iv_ruleSTAR= ruleSTAR EOF
            {
             newCompositeNode(grammarAccess.getSTARRule()); 
            pushFollow(FOLLOW_ruleSTAR_in_entryRuleSTAR10874);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;

             current =iv_ruleSTAR.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTAR10885); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4708:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '*' ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4711:28: (kw= '*' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4713:2: kw= '*'
            {
            kw=(Token)match(input,88,FOLLOW_88_in_ruleSTAR10922); 

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
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA54 dfa54 = new DFA54(this);
    static final String DFA1_eotS =
        "\14\uffff";
    static final String DFA1_eofS =
        "\14\uffff";
    static final String DFA1_minS =
        "\1\4\7\uffff\1\4\3\uffff";
    static final String DFA1_maxS =
        "\1\104\7\uffff\1\44\3\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\11\1\7";
    static final String DFA1_specialS =
        "\14\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\12\14\uffff\1\1\2\uffff\1\2\4\uffff\1\4\3\uffff\1\5\1\6\1\uffff\2\7\1\10\2\uffff\1\11\3\uffff\1\2\12\uffff\10\3\1\uffff\3\3\5\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\7\37\uffff\1\13",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "()* loopback of 169:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) | ( (lv_ownedPropertyAssociation_13_0= rulePropertyAssociationInstance ) ) )*";
        }
    }
    static final String DFA8_eotS =
        "\13\uffff";
    static final String DFA8_eofS =
        "\13\uffff";
    static final String DFA8_minS =
        "\1\4\7\uffff\1\4\2\uffff";
    static final String DFA8_maxS =
        "\1\104\7\uffff\1\44\2\uffff";
    static final String DFA8_acceptS =
        "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\7";
    static final String DFA8_specialS =
        "\13\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\11\14\uffff\1\1\2\uffff\1\2\4\uffff\1\4\3\uffff\1\5\1\6\1\uffff\2\7\1\10\6\uffff\1\2\12\uffff\10\3\1\uffff\3\3\5\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\7\37\uffff\1\12",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "()* loopback of 660:1: ( ( (lv_featureInstance_15_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_16_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_17_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_18_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_19_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_20_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_21_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_22_0= rulePropertyAssociationInstance ) ) )*";
        }
    }
    static final String DFA42_eotS =
        "\31\uffff";
    static final String DFA42_eofS =
        "\10\uffff\1\20\1\22\1\24\4\uffff\1\20\1\uffff\1\22\5\uffff\1\24\1\uffff";
    static final String DFA42_minS =
        "\1\4\1\uffff\1\26\3\uffff\4\4\1\17\2\uffff\1\4\1\uffff\1\17\1\uffff\1\17\1\uffff\1\4\2\uffff\1\22\1\17\1\uffff";
    static final String DFA42_maxS =
        "\1\125\1\uffff\1\26\3\uffff\2\7\3\126\2\uffff\1\111\1\uffff\1\126\1\uffff\1\126\1\uffff\1\4\2\uffff\1\106\1\126\1\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\5\uffff\1\12\1\13\1\uffff\1\7\1\uffff\1\10\1\uffff\1\11\1\uffff\1\14\1\3\2\uffff\1\2";
    static final String DFA42_specialS =
        "\31\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\12\1\5\1\11\1\10\12\uffff\1\1\3\uffff\1\13\21\uffff\1\2\47\uffff\2\14\1\4\1\3\1\6\1\7",
            "",
            "\1\15",
            "",
            "",
            "",
            "\1\16\1\uffff\1\11\1\10",
            "\1\16\1\uffff\1\11\1\10",
            "\1\17\12\uffff\1\20\4\uffff\1\20\2\uffff\2\20\64\uffff\1\20\1\uffff\1\20\6\uffff\1\16",
            "\1\21\12\uffff\1\22\4\uffff\1\22\2\uffff\2\22\64\uffff\1\22\1\uffff\1\22\6\uffff\1\16",
            "\1\24\4\uffff\1\24\2\uffff\2\24\54\uffff\1\23\7\uffff\1\24\1\uffff\1\24\6\uffff\1\16",
            "",
            "",
            "\1\26\103\uffff\2\25",
            "",
            "\1\20\4\uffff\1\20\2\uffff\2\20\64\uffff\1\20\1\uffff\1\20\6\uffff\1\16",
            "",
            "\1\22\4\uffff\1\22\2\uffff\2\22\64\uffff\1\22\1\uffff\1\22\6\uffff\1\16",
            "",
            "\1\27",
            "",
            "",
            "\1\25\5\uffff\1\25\54\uffff\1\30\1\25",
            "\1\24\4\uffff\1\24\2\uffff\2\24\64\uffff\1\24\1\uffff\1\24\6\uffff\1\16",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "2171:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )";
        }
    }
    static final String DFA47_eotS =
        "\22\uffff";
    static final String DFA47_eofS =
        "\10\uffff\1\15\1\uffff\1\17\7\uffff";
    static final String DFA47_minS =
        "\1\64\7\uffff\1\4\1\uffff\1\4\1\65\6\uffff";
    static final String DFA47_maxS =
        "\1\77\7\uffff\1\74\1\uffff\1\74\1\72\6\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\11\1\10\1\13\1\14\1\16\1\15";
    static final String DFA47_specialS =
        "\22\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\67\uffff\1\14",
            "",
            "\1\17\67\uffff\1\16",
            "\1\21\4\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "2572:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String DFA54_eotS =
        "\7\uffff";
    static final String DFA54_eofS =
        "\2\uffff\1\1\3\uffff\1\1";
    static final String DFA54_minS =
        "\1\4\1\uffff\1\4\1\6\1\uffff\1\23\1\4";
    static final String DFA54_maxS =
        "\1\111\1\uffff\1\111\1\6\1\uffff\1\23\1\111";
    static final String DFA54_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA54_specialS =
        "\7\uffff}>";
    static final String[] DFA54_transitionS = {
            "\1\2\104\uffff\1\1",
            "",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\1\uffff\2\1\1\uffff\3\1\2\uffff\1\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1",
            "\1\5",
            "",
            "\1\6",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\1\uffff\2\1\1\uffff\3\1\2\uffff\1\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1"
    };

    static final short[] DFA54_eot = DFA.unpackEncodedString(DFA54_eotS);
    static final short[] DFA54_eof = DFA.unpackEncodedString(DFA54_eofS);
    static final char[] DFA54_min = DFA.unpackEncodedStringToUnsignedChars(DFA54_minS);
    static final char[] DFA54_max = DFA.unpackEncodedStringToUnsignedChars(DFA54_maxS);
    static final short[] DFA54_accept = DFA.unpackEncodedString(DFA54_acceptS);
    static final short[] DFA54_special = DFA.unpackEncodedString(DFA54_specialS);
    static final short[][] DFA54_transition;

    static {
        int numStates = DFA54_transitionS.length;
        DFA54_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA54_transition[i] = DFA.unpackEncodedString(DFA54_transitionS[i]);
        }
    }

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = DFA54_eot;
            this.eof = DFA54_eof;
            this.min = DFA54_min;
            this.max = DFA54_max;
            this.accept = DFA54_accept;
            this.special = DFA54_special;
            this.transition = DFA54_transition;
        }
        public String getDescription() {
            return "()* loopback of 2917:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleSystemInstance131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemInstance148 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleSystemInstance165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleImplRef_in_ruleSystemInstance188 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSystemInstance200 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleSystemInstance222 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleSystemInstance249 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleSystemInstance276 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleSystemInstance303 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleSystemInstance330 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleSystemInstance357 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_ruleSystemInstance384 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance411 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleSystemInstance438 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_17_in_ruleSystemInstance452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance488 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_ruleFeatureInstance544 = new BitSet(new long[]{0x000FFC0000000000L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance565 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance582 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureInstance600 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleLong_in_ruleFeatureInstance621 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleFeatureInstance633 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureInstance647 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleFeatureInstance670 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFeatureInstance683 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance705 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleFeatureInstance732 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_17_in_ruleFeatureInstance746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance784 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleComponentInstance840 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance857 = new BitSet(new long[]{0x0000000000148000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance875 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleLong_in_ruleComponentInstance896 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleComponentInstance908 = new BitSet(new long[]{0x0000000000148000L});
    public static final BitSet FOLLOW_20_in_ruleComponentInstance923 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleComponentInstance935 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleComponentInstance947 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance967 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleComponentInstance980 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance1000 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleComponentInstance1014 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance1028 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleComponentInstance1051 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1064 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1086 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleComponentInstance1113 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1140 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1167 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance1194 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleComponentInstance1221 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance1248 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleComponentInstance1275 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleConnectionInstance1380 = new BitSet(new long[]{0x0000000002000000L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1415 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConnectionInstance1432 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConnectionInstance1449 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionInstance1472 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleConnectionInstance1491 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_27_in_ruleConnectionInstance1522 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionInstance1546 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleConnectionInstance1559 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleConnectionInstance1571 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance1583 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleConnectionInstance1606 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleConnectionInstance1619 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleConnectionInstance1642 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleConnectionInstance1656 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleConnectionInstance1671 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleConnectionInstance1683 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance1695 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_ruleConnectionInstance1718 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleConnectionInstance1731 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_ruleConnectionInstance1754 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleConnectionInstance1768 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConnectionInstance1782 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000031FL});
    public static final BitSet FOLLOW_ruleConnectionReference_in_ruleConnectionInstance1804 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000031FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleConnectionInstance1831 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000031FL});
    public static final BitSet FOLLOW_17_in_ruleConnectionInstance1845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference1881 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference1891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionReference1939 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleConnectionReference1951 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionReference1974 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConnectionReference1986 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleConnectionReference2009 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConnectionReference2021 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionReference2044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleFlowSpecificationInstance2127 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2144 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecificationInstance2161 = new BitSet(new long[]{0x0000000008000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleFlowSpecificationInstance2184 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleFlowSpecificationInstance2197 = new BitSet(new long[]{0x0000000001000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleFlowSpecificationInstance2220 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2233 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleFlowSpecificationInstance2246 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleFlowSpecificationInstance2258 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecificationInstance2270 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2290 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleFlowSpecificationInstance2303 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2323 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2337 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleFlowSpecificationInstance2352 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleFlowSpecificationInstance2364 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecificationInstance2376 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_ruleFlowSpecificationInstance2399 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleFlowSpecificationInstance2412 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_ruleFlowSpecificationInstance2435 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2449 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFlowSpecificationInstance2463 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleFlowSpecificationInstance2486 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFlowSpecificationInstance2499 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleFlowSpecificationInstance2520 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_17_in_ruleFlowSpecificationInstance2533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance2571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndToEndFlowInstance2581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleEndToEndFlowInstance2618 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleEndToEndFlowInstance2630 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleEndToEndFlowInstance2642 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleEndToEndFlowInstance2654 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance2671 = new BitSet(new long[]{0x0000000000108010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleEndToEndFlowInstance2700 = new BitSet(new long[]{0x0000000008108000L});
    public static final BitSet FOLLOW_27_in_ruleEndToEndFlowInstance2713 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleEndToEndFlowInstance2736 = new BitSet(new long[]{0x0000000008108000L});
    public static final BitSet FOLLOW_20_in_ruleEndToEndFlowInstance2753 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEndToEndFlowInstance2765 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEndToEndFlowInstance2777 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleEndToEndFlowInstance2800 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleEndToEndFlowInstance2813 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleEndToEndFlowInstance2836 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleEndToEndFlowInstance2850 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEndToEndFlowInstance2864 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleEndToEndFlowInstance2887 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleEndToEndFlowInstance2900 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleEndToEndFlowInstance2921 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEndToEndFlowInstance2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_entryRuleModeInstance2971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeInstance2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleModeInstance3024 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleModeInstance3056 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleModeInstance3082 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3099 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_ruleModeInstance3117 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3138 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_22_in_ruleModeInstance3157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3177 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleModeInstance3190 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3210 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleModeInstance3224 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModeInstance3240 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleModeInstance3263 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleModeInstance3276 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleModeInstance3297 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModeInstance3309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance3347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransitionInstance3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleModeTransitionInstance3394 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleModeTransitionInstance3406 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleModeTransitionName_in_ruleModeTransitionInstance3427 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance3447 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleModeTransitionInstance3459 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance3479 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModeTransitionInstance3491 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleModeTransitionInstance3514 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleModeTransitionInstance3527 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleModeTransitionInstance3548 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModeTransitionInstance3560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode3598 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode3608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSystemOperationMode3645 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSystemOperationMode3662 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleSystemOperationMode3691 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleSystemOperationMode3704 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleSystemOperationMode3727 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_entryRulePropertyAssociationInstance3767 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAssociationInstance3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_rulePropertyAssociationInstance3825 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_rulePropertyAssociationInstance3837 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_rulePropertyAssociationInstance3858 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_23_in_rulePropertyAssociationInstance3871 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_rulePropertyAssociationInstance3892 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_15_in_rulePropertyAssociationInstance3906 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePropertyAssociationRef_in_rulePropertyAssociationInstance3929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_entryRuleOptionalModalPropertyValue3965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptionalModalPropertyValue3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleOptionalModalPropertyValue4021 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleOptionalModalPropertyValue4034 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleOptionalModalPropertyValue4046 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOptionalModalPropertyValue4058 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleOptionalModalPropertyValue4081 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleOptionalModalPropertyValue4094 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleOptionalModalPropertyValue4117 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleOptionalModalPropertyValue4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression4169 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression4179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_rulePropertyExpression4226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceTerm_in_rulePropertyExpression4253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceReferenceValue_in_rulePropertyExpression4280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression4307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_rulePropertyExpression4334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_rulePropertyExpression4361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression4388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_rulePropertyExpression4415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_rulePropertyExpression4442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_rulePropertyExpression4469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rulePropertyExpression4496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_rulePropertyExpression4523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement4558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPathElement4568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleContainmentPathElement4616 = new BitSet(new long[]{0x0000008000040002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_ruleContainmentPathElement4637 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleContainmentPathElement4651 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPathElement4672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceReferenceValue_in_entryRuleInstanceReferenceValue4710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceReferenceValue4720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleInstanceReferenceValue4757 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleInstanceReferenceValue4769 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleInstanceReferenceValue4792 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleInstanceReferenceValue4804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType4841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType4852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDirectionType4890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleDirectionType4909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDirectionType4929 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleDirectionType4942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory4984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory4995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleFeatureCategory5033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleFeatureCategory5052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFeatureCategory5071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFeatureCategory5090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleFeatureCategory5109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFeatureCategory5128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleFeatureCategory5147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleFeatureCategory5166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleFeatureCategory5185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleFeatureCategory5204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory5245 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory5256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleComponentCategory5294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleComponentCategory5313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleComponentCategory5332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleComponentCategory5351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleComponentCategory5370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleComponentCategory5389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleComponentCategory5408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleComponentCategory5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleComponentCategory5447 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleComponentCategory5460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleComponentCategory5480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleComponentCategory5500 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleComponentCategory5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleComponentCategory5533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleComponentCategory5553 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleComponentCategory5566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleComponentCategory5587 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleComponentCategory5600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind5642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind5653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleConnectionKind5691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleConnectionKind5710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleConnectionKind5729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleConnectionKind5748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleConnectionKind5767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplRef_in_entryRuleImplRef5808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplRef5819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImplRef5860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleImplRef5878 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImplRef5895 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleImplRef5913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImplRef5928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_entryRuleDeclarativeRef5974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarativeRef5985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclarativeRef6026 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleDeclarativeRef6044 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclarativeRef6061 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleDeclarativeRef6080 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclarativeRef6095 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDeclarativeRef6115 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_36_in_ruleDeclarativeRef6130 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleDeclarativeRef6143 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleDeclarativeRef6158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclarativeRef6185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_entryRuleInstanceRef6232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceRef6243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleInstanceRef6281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstanceRef6304 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000040L});
    public static final BitSet FOLLOW_18_in_ruleInstanceRef6323 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6338 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleInstanceRef6356 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleInstanceRef6371 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleInstanceRef6388 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleInstanceRef6401 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstanceRef6444 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleInstanceRef6463 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6478 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleInstanceRef6496 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleSomRef_in_entryRuleSomRef6542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSomRef6553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSomRef6591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleSomRef6604 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleSomRef6619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_entryRuleTransitionRef6665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRef6676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleTransitionRef6714 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleTransitionRef6727 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleTransitionRef6742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionName_in_entryRuleModeTransitionName6788 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransitionName6799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionName6839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleModeTransitionName6857 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionName6872 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleModeTransitionName6890 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionName6905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAssociationRef_in_entryRulePropertyAssociationRef6951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAssociationRef6962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociationRef7003 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_rulePropertyAssociationRef7021 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociationRef7038 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_rulePropertyAssociationRef7057 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociationRef7072 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePropertyAssociationRef7092 = new BitSet(new long[]{0x0000001000000010L,0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociationRef7109 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_36_in_rulePropertyAssociationRef7134 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_rulePropertyAssociationRef7147 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_rulePropertyAssociationRef7162 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePropertyAssociationRef7182 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_rulePropertyAssociationRef7197 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_rulePropertyAssociationRef7210 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_rulePropertyAssociationRef7225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLong_in_entryRuleLong7271 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLong7282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleLong7321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation7367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainedPropertyAssociation7377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleContainedPropertyAssociation7425 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_38_in_ruleContainedPropertyAssociation7438 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F101FL});
    public static final BitSet FOLLOW_75_in_ruleContainedPropertyAssociation7462 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F101FL});
    public static final BitSet FOLLOW_76_in_ruleContainedPropertyAssociation7494 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation7530 = new BitSet(new long[]{0x0000000000900000L,0x000000000000A000L});
    public static final BitSet FOLLOW_23_in_ruleContainedPropertyAssociation7543 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation7564 = new BitSet(new long[]{0x0000000000900000L,0x000000000000A000L});
    public static final BitSet FOLLOW_77_in_ruleContainedPropertyAssociation7580 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleContainedPropertyAssociation7592 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation7613 = new BitSet(new long[]{0x0000000000900000L,0x0000000000008000L});
    public static final BitSet FOLLOW_23_in_ruleContainedPropertyAssociation7626 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation7647 = new BitSet(new long[]{0x0000000000900000L,0x0000000000008000L});
    public static final BitSet FOLLOW_20_in_ruleContainedPropertyAssociation7664 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleContainedPropertyAssociation7676 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleContainedPropertyAssociation7688 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleContainedPropertyAssociation7711 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleContainedPropertyAssociation7723 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleContainedPropertyAssociation7737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath7777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPath7787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath7832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyValue_in_entryRulePropertyValue7869 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyValue7879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyValue7924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_entryRuleLiteralorReferenceTerm7959 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralorReferenceTerm7969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleLiteralorReferenceTerm8016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8051 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral8061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleBooleanLiteral8114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleBooleanLiteral8145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue8182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue8192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleConstantValue8239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm8274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceTerm8284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleReferenceTerm8321 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleReferenceTerm8333 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8354 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleReferenceTerm8366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm8402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordTerm8412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRecordTerm8449 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm8470 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_ruleRecordTerm8483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm8521 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComputedTerm8531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleComputedTerm8568 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleComputedTerm8580 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComputedTerm8597 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComputedTerm8614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm8650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentClassifierTerm8660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleComponentClassifierTerm8697 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleComponentClassifierTerm8709 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm8732 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComponentClassifierTerm8744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_entryRuleListTerm8780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListTerm8790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleListTerm8836 = new BitSet(new long[]{0xEFF00327635400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm8858 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleListTerm8871 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm8892 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleListTerm8908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation8944 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldPropertyAssociation8954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation8999 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleFieldPropertyAssociation9011 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation9032 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleFieldPropertyAssociation9044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusMinus_in_entryRulePlusMinus9083 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlusMinus9094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_rulePlusMinus9132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_rulePlusMinus9151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm9191 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm9201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm9246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString9282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString9293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString9332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_entryRuleArrayRange9376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayRange9386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleArrayRange9432 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_ruleArrayRange9453 = new BitSet(new long[]{0x0000000000080000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleArrayRange9466 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_ruleArrayRange9487 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrayRange9501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant9537 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedConstant9547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusMinus_in_ruleSignedConstant9593 = new BitSet(new long[]{0xEFF00227621000D0L,0x000000000030001FL});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleSignedConstant9614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm9650 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm9660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInt_in_ruleIntegerTerm9706 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm9726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInt_in_entryRuleSignedInt9764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInt9775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleSignedInt9814 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_85_in_ruleSignedInt9833 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleSignedInt9850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm9895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm9905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedReal_in_ruleRealTerm9951 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm9971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedReal_in_entryRuleSignedReal10009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedReal10020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleSignedReal10059 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_85_in_ruleSignedReal10078 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleSignedReal10095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm10140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericRangeTerm10150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10196 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleNumericRangeTerm10208 = new BitSet(new long[]{0xEFF00227621000D0L,0x000000000030001FL});
    public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10229 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ruleNumericRangeTerm10242 = new BitSet(new long[]{0xEFF00227621000D0L,0x000000000030001FL});
    public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumAlt_in_entryRuleNumAlt10301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumAlt10311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumAlt10358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumAlt10385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumAlt10412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumAlt10439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE10475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTVALUE10486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE10525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_entryRuleQPREF10572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQPREF10583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF10623 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleQPREF10642 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF10657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF10705 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQCREF10716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF10757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleQCREF10775 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF10792 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleQCREF10811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF10826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSTAR_in_entryRuleSTAR10874 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTAR10885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleSTAR10922 = new BitSet(new long[]{0x0000000000000002L});

}