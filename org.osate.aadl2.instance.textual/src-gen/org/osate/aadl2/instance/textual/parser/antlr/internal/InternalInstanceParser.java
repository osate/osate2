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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:525:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleClassifierRef ) ) otherlv_14= ',' ( ( ruleDeclarativeRef ) ) (otherlv_16= '{' ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )* otherlv_25= '}' )? ) ;
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
        Token otherlv_16=null;
        Token otherlv_25=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;

        EObject lv_featureInstance_17_0 = null;

        EObject lv_componentInstance_18_0 = null;

        EObject lv_connectionInstance_19_0 = null;

        EObject lv_flowSpecification_20_0 = null;

        EObject lv_endToEndFlow_21_0 = null;

        EObject lv_modeInstance_22_0 = null;

        EObject lv_modeTransitionInstance_23_0 = null;

        EObject lv_ownedPropertyAssociation_24_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:528:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleClassifierRef ) ) otherlv_14= ',' ( ( ruleDeclarativeRef ) ) (otherlv_16= '{' ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )* otherlv_25= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:529:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleClassifierRef ) ) otherlv_14= ',' ( ( ruleDeclarativeRef ) ) (otherlv_16= '{' ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )* otherlv_25= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:529:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleClassifierRef ) ) otherlv_14= ',' ( ( ruleDeclarativeRef ) ) (otherlv_16= '{' ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )* otherlv_25= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:529:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= ruleLong ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleClassifierRef ) ) otherlv_14= ',' ( ( ruleDeclarativeRef ) ) (otherlv_16= '{' ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )* otherlv_25= '}' )?
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
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:641:1: ( ( ruleClassifierRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:642:1: ( ruleClassifierRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:642:1: ( ruleClassifierRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:643:3: ruleClassifierRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getClassifierComponentClassifierCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleClassifierRef_in_ruleComponentInstance1051);
            ruleClassifierRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_14=(Token)match(input,23,FOLLOW_23_in_ruleComponentInstance1063); 

                	newLeafNode(otherlv_14, grammarAccess.getComponentInstanceAccess().getCommaKeyword_6());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:660:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:661:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:661:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:662:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleComponentInstance1086);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:675:2: (otherlv_16= '{' ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )* otherlv_25= '}' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==16) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:675:4: otherlv_16= '{' ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )* otherlv_25= '}'
                    {
                    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1099); 

                        	newLeafNode(otherlv_16, grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:679:1: ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )*
                    loop8:
                    do {
                        int alt8=9;
                        alt8 = dfa8.predict(input);
                        switch (alt8) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:679:2: ( (lv_featureInstance_17_0= ruleFeatureInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:679:2: ( (lv_featureInstance_17_0= ruleFeatureInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:680:1: (lv_featureInstance_17_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:680:1: (lv_featureInstance_17_0= ruleFeatureInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:681:3: lv_featureInstance_17_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1121);
                    	    lv_featureInstance_17_0=ruleFeatureInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureInstance",
                    	            		lv_featureInstance_17_0, 
                    	            		"FeatureInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:698:6: ( (lv_componentInstance_18_0= ruleComponentInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:698:6: ( (lv_componentInstance_18_0= ruleComponentInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:699:1: (lv_componentInstance_18_0= ruleComponentInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:699:1: (lv_componentInstance_18_0= ruleComponentInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:700:3: lv_componentInstance_18_0= ruleComponentInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_8_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleComponentInstance1148);
                    	    lv_componentInstance_18_0=ruleComponentInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"componentInstance",
                    	            		lv_componentInstance_18_0, 
                    	            		"ComponentInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:717:6: ( (lv_connectionInstance_19_0= ruleConnectionInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:717:6: ( (lv_connectionInstance_19_0= ruleConnectionInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:718:1: (lv_connectionInstance_19_0= ruleConnectionInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:718:1: (lv_connectionInstance_19_0= ruleConnectionInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:719:3: lv_connectionInstance_19_0= ruleConnectionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_8_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1175);
                    	    lv_connectionInstance_19_0=ruleConnectionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connectionInstance",
                    	            		lv_connectionInstance_19_0, 
                    	            		"ConnectionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:736:6: ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:736:6: ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:737:1: (lv_flowSpecification_20_0= ruleFlowSpecificationInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:737:1: (lv_flowSpecification_20_0= ruleFlowSpecificationInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:738:3: lv_flowSpecification_20_0= ruleFlowSpecificationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_8_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1202);
                    	    lv_flowSpecification_20_0=ruleFlowSpecificationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"flowSpecification",
                    	            		lv_flowSpecification_20_0, 
                    	            		"FlowSpecificationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:755:6: ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:755:6: ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:756:1: (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:756:1: (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:757:3: lv_endToEndFlow_21_0= ruleEndToEndFlowInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_8_1_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance1229);
                    	    lv_endToEndFlow_21_0=ruleEndToEndFlowInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"endToEndFlow",
                    	            		lv_endToEndFlow_21_0, 
                    	            		"EndToEndFlowInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 6 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:774:6: ( (lv_modeInstance_22_0= ruleModeInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:774:6: ( (lv_modeInstance_22_0= ruleModeInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:775:1: (lv_modeInstance_22_0= ruleModeInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:775:1: (lv_modeInstance_22_0= ruleModeInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:776:3: lv_modeInstance_22_0= ruleModeInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_8_1_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModeInstance_in_ruleComponentInstance1256);
                    	    lv_modeInstance_22_0=ruleModeInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeInstance",
                    	            		lv_modeInstance_22_0, 
                    	            		"ModeInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 7 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:793:6: ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:793:6: ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:794:1: (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:794:1: (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:795:3: lv_modeTransitionInstance_23_0= ruleModeTransitionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_8_1_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance1283);
                    	    lv_modeTransitionInstance_23_0=ruleModeTransitionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeTransitionInstance",
                    	            		lv_modeTransitionInstance_23_0, 
                    	            		"ModeTransitionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 8 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:812:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:812:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:813:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:813:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:814:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_7_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleComponentInstance1310);
                    	    lv_ownedPropertyAssociation_24_0=rulePropertyAssociationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
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
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_25=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1324); 

                        	newLeafNode(otherlv_25, grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_8_2());
                        

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:842:1: entryRuleConnectionInstance returns [EObject current=null] : iv_ruleConnectionInstance= ruleConnectionInstance EOF ;
    public final EObject entryRuleConnectionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:843:2: (iv_ruleConnectionInstance= ruleConnectionInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:844:2: iv_ruleConnectionInstance= ruleConnectionInstance EOF
            {
             newCompositeNode(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1362);
            iv_ruleConnectionInstance=ruleConnectionInstance();

            state._fsp--;

             current =iv_ruleConnectionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance1372); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:851:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:854:28: ( ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:855:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:855:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:855:2: ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:855:2: ( (lv_complete_0_0= 'complete' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==25) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:856:1: (lv_complete_0_0= 'complete' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:856:1: (lv_complete_0_0= 'complete' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:857:3: lv_complete_0_0= 'complete'
                    {
                    lv_complete_0_0=(Token)match(input,25,FOLLOW_25_in_ruleConnectionInstance1415); 

                            newLeafNode(lv_complete_0_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "complete", true, "complete");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:870:3: ( (lv_kind_1_0= ruleConnectionKind ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:871:1: (lv_kind_1_0= ruleConnectionKind )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:871:1: (lv_kind_1_0= ruleConnectionKind )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:872:3: lv_kind_1_0= ruleConnectionKind
            {
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1450);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:888:2: ( (lv_name_2_0= RULE_STRING ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:889:1: (lv_name_2_0= RULE_STRING )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:889:1: (lv_name_2_0= RULE_STRING )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:890:3: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConnectionInstance1467); 

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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleConnectionInstance1484); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getColonKeyword_3());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:910:1: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:911:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:911:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:912:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionInstance1507);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:925:2: ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' )
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:925:3: ( (lv_bidirectional_5_0= '<->' ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:925:3: ( (lv_bidirectional_5_0= '<->' ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:926:1: (lv_bidirectional_5_0= '<->' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:926:1: (lv_bidirectional_5_0= '<->' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:927:3: lv_bidirectional_5_0= '<->'
                    {
                    lv_bidirectional_5_0=(Token)match(input,26,FOLLOW_26_in_ruleConnectionInstance1526); 

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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:941:7: otherlv_6= '->'
                    {
                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleConnectionInstance1557); 

                        	newLeafNode(otherlv_6, grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1());
                        

                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:945:2: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:946:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:946:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:947:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionInstance1581);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:960:2: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )?
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:960:4: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleConnectionInstance1594); 

                        	newLeafNode(otherlv_8, grammarAccess.getConnectionInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleConnectionInstance1606); 

                        	newLeafNode(otherlv_9, grammarAccess.getConnectionInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance1618); 

                        	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:972:1: ( ( ruleSomRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:973:1: ( ruleSomRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:973:1: ( ruleSomRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:974:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSomRef_in_ruleConnectionInstance1641);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:987:2: (otherlv_12= ',' ( ( ruleSomRef ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==23) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:987:4: otherlv_12= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleConnectionInstance1654); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:991:1: ( ( ruleSomRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:992:1: ( ruleSomRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:992:1: ( ruleSomRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:993:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSomRef_in_ruleConnectionInstance1677);
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

                    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleConnectionInstance1691); 

                        	newLeafNode(otherlv_14, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1010:3: (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1010:5: otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')'
                    {
                    otherlv_15=(Token)match(input,20,FOLLOW_20_in_ruleConnectionInstance1706); 

                        	newLeafNode(otherlv_15, grammarAccess.getConnectionInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_16=(Token)match(input,28,FOLLOW_28_in_ruleConnectionInstance1718); 

                        	newLeafNode(otherlv_16, grammarAccess.getConnectionInstanceAccess().getTransitionsKeyword_8_1());
                        
                    otherlv_17=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance1730); 

                        	newLeafNode(otherlv_17, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_8_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1022:1: ( ( ruleTransitionRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1023:1: ( ruleTransitionRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1023:1: ( ruleTransitionRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1024:3: ruleTransitionRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTransitionRef_in_ruleConnectionInstance1753);
                    ruleTransitionRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1037:2: (otherlv_19= ',' ( ( ruleTransitionRef ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==23) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1037:4: otherlv_19= ',' ( ( ruleTransitionRef ) )
                    	    {
                    	    otherlv_19=(Token)match(input,23,FOLLOW_23_in_ruleConnectionInstance1766); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_8_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1041:1: ( ( ruleTransitionRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1042:1: ( ruleTransitionRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1042:1: ( ruleTransitionRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1043:3: ruleTransitionRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTransitionRef_in_ruleConnectionInstance1789);
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

                    otherlv_21=(Token)match(input,24,FOLLOW_24_in_ruleConnectionInstance1803); 

                        	newLeafNode(otherlv_21, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_8_5());
                        

                    }
                    break;

            }

            otherlv_22=(Token)match(input,16,FOLLOW_16_in_ruleConnectionInstance1817); 

                	newLeafNode(otherlv_22, grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_9());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1064:1: ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+
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

                    if ( (LA16_3==38||LA16_3==69) ) {
                        alt16=2;
                    }
                    else if ( (LA16_3==18||LA16_3==27||LA16_3==70) ) {
                        alt16=1;
                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1064:2: ( (lv_connectionReference_23_0= ruleConnectionReference ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1064:2: ( (lv_connectionReference_23_0= ruleConnectionReference ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1065:1: (lv_connectionReference_23_0= ruleConnectionReference )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1065:1: (lv_connectionReference_23_0= ruleConnectionReference )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1066:3: lv_connectionReference_23_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_10_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionReference_in_ruleConnectionInstance1839);
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
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1083:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1083:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1084:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1084:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1085:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleConnectionInstance1866);
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

            otherlv_25=(Token)match(input,17,FOLLOW_17_in_ruleConnectionInstance1880); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1113:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1114:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1115:2: iv_ruleConnectionReference= ruleConnectionReference EOF
            {
             newCompositeNode(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference1916);
            iv_ruleConnectionReference=ruleConnectionReference();

            state._fsp--;

             current =iv_ruleConnectionReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference1926); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1122:1: ruleConnectionReference returns [EObject current=null] : ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1125:28: ( ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1126:1: ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1126:1: ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1126:2: ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1126:2: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1127:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1127:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1128:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionReference1974);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleConnectionReference1986); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1145:1: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1146:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1146:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1147:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionReference2009);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleConnectionReference2021); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionReferenceAccess().getColonKeyword_3());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1164:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1165:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1165:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1166:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleConnectionReference2044);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleConnectionReference2056); 

                	newLeafNode(otherlv_5, grammarAccess.getConnectionReferenceAccess().getInKeyword_5());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1183:1: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1184:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1184:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1185:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleConnectionReference2079);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1206:1: entryRuleFlowSpecificationInstance returns [EObject current=null] : iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF ;
    public final EObject entryRuleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecificationInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1207:2: (iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1208:2: iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF
            {
             newCompositeNode(grammarAccess.getFlowSpecificationInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2115);
            iv_ruleFlowSpecificationInstance=ruleFlowSpecificationInstance();

            state._fsp--;

             current =iv_ruleFlowSpecificationInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2125); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1215:1: ruleFlowSpecificationInstance returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1218:28: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1219:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1219:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1219:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleFlowSpecificationInstance2162); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1223:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1224:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1224:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1225:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2179); 

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

            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecificationInstance2196); 

                	newLeafNode(otherlv_2, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1245:1: ( ( ruleInstanceRef ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID||(LA17_0>=72 && LA17_0<=73)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1246:1: ( ruleInstanceRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1246:1: ( ruleInstanceRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1247:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstanceRef_in_ruleFlowSpecificationInstance2219);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleFlowSpecificationInstance2232); 

                	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1264:1: ( ( ruleInstanceRef ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||(LA18_0>=72 && LA18_0<=73)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1265:1: ( ruleInstanceRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1265:1: ( ruleInstanceRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1266:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstanceRef_in_ruleFlowSpecificationInstance2255);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2268); 

                	newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1283:1: (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )?
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1283:3: otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleFlowSpecificationInstance2281); 

                        	newLeafNode(otherlv_7, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleFlowSpecificationInstance2293); 

                        	newLeafNode(otherlv_8, grammarAccess.getFlowSpecificationInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_9=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecificationInstance2305); 

                        	newLeafNode(otherlv_9, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1295:1: ( (otherlv_10= RULE_ID ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1296:1: (otherlv_10= RULE_ID )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1296:1: (otherlv_10= RULE_ID )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1297:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2325); 

                    		newLeafNode(otherlv_10, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_3_0()); 
                    	

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1308:2: (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==23) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1308:4: otherlv_11= ',' ( (otherlv_12= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,23,FOLLOW_23_in_ruleFlowSpecificationInstance2338); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1312:1: ( (otherlv_12= RULE_ID ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1313:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1313:1: (otherlv_12= RULE_ID )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1314:3: otherlv_12= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2358); 

                    	    		newLeafNode(otherlv_12, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2372); 

                        	newLeafNode(otherlv_13, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1329:3: (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==20) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1329:5: otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')'
                    {
                    otherlv_14=(Token)match(input,20,FOLLOW_20_in_ruleFlowSpecificationInstance2387); 

                        	newLeafNode(otherlv_14, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_15=(Token)match(input,28,FOLLOW_28_in_ruleFlowSpecificationInstance2399); 

                        	newLeafNode(otherlv_15, grammarAccess.getFlowSpecificationInstanceAccess().getTransitionsKeyword_8_1());
                        
                    otherlv_16=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecificationInstance2411); 

                        	newLeafNode(otherlv_16, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_8_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1341:1: ( ( ruleTransitionRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1342:1: ( ruleTransitionRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1342:1: ( ruleTransitionRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1343:3: ruleTransitionRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTransitionRef_in_ruleFlowSpecificationInstance2434);
                    ruleTransitionRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1356:2: (otherlv_18= ',' ( ( ruleTransitionRef ) ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==23) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1356:4: otherlv_18= ',' ( ( ruleTransitionRef ) )
                    	    {
                    	    otherlv_18=(Token)match(input,23,FOLLOW_23_in_ruleFlowSpecificationInstance2447); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_8_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1360:1: ( ( ruleTransitionRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1361:1: ( ruleTransitionRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1361:1: ( ruleTransitionRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1362:3: ruleTransitionRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTransitionRef_in_ruleFlowSpecificationInstance2470);
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

                    otherlv_20=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2484); 

                        	newLeafNode(otherlv_20, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_8_5());
                        

                    }
                    break;

            }

            otherlv_21=(Token)match(input,15,FOLLOW_15_in_ruleFlowSpecificationInstance2498); 

                	newLeafNode(otherlv_21, grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_9());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1383:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1384:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1384:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1385:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_10_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleFlowSpecificationInstance2521);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1398:2: (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==16) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1398:4: otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}'
                    {
                    otherlv_23=(Token)match(input,16,FOLLOW_16_in_ruleFlowSpecificationInstance2534); 

                        	newLeafNode(otherlv_23, grammarAccess.getFlowSpecificationInstanceAccess().getLeftCurlyBracketKeyword_11_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1402:1: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+
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
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1403:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1403:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1404:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_11_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleFlowSpecificationInstance2555);
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

                    otherlv_25=(Token)match(input,17,FOLLOW_17_in_ruleFlowSpecificationInstance2568); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1432:1: entryRuleEndToEndFlowInstance returns [EObject current=null] : iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF ;
    public final EObject entryRuleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndToEndFlowInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1433:2: (iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1434:2: iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF
            {
             newCompositeNode(grammarAccess.getEndToEndFlowInstanceRule()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance2606);
            iv_ruleEndToEndFlowInstance=ruleEndToEndFlowInstance();

            state._fsp--;

             current =iv_ruleEndToEndFlowInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndToEndFlowInstance2616); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1441:1: ruleEndToEndFlowInstance returns [EObject current=null] : (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1444:28: ( (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1445:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1445:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1445:3: otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleEndToEndFlowInstance2653); 

                	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0());
                
            otherlv_1=(Token)match(input,31,FOLLOW_31_in_ruleEndToEndFlowInstance2665); 

                	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1());
                
            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleEndToEndFlowInstance2677); 

                	newLeafNode(otherlv_2, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2());
                
            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleEndToEndFlowInstance2689); 

                	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1461:1: ( (lv_name_4_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1462:1: (lv_name_4_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1462:1: (lv_name_4_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1463:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance2706); 

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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1479:2: ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID||(LA26_0>=72 && LA26_0<=73)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1479:3: ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )*
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1479:3: ( ( ruleInstanceRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1480:1: ( ruleInstanceRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1480:1: ( ruleInstanceRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1481:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstanceRef_in_ruleEndToEndFlowInstance2735);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1494:2: (otherlv_6= '->' ( ( ruleInstanceRef ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==27) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1494:4: otherlv_6= '->' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleEndToEndFlowInstance2748); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1498:1: ( ( ruleInstanceRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1499:1: ( ruleInstanceRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1499:1: ( ruleInstanceRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1500:3: ruleInstanceRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleInstanceRef_in_ruleEndToEndFlowInstance2771);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1513:6: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==20) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1513:8: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleEndToEndFlowInstance2788); 

                        	newLeafNode(otherlv_8, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleEndToEndFlowInstance2800); 

                        	newLeafNode(otherlv_9, grammarAccess.getEndToEndFlowInstanceAccess().getModesKeyword_6_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleEndToEndFlowInstance2812); 

                        	newLeafNode(otherlv_10, grammarAccess.getEndToEndFlowInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1525:1: ( ( ruleSomRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1526:1: ( ruleSomRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1526:1: ( ruleSomRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1527:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSomRef_in_ruleEndToEndFlowInstance2835);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1540:2: (otherlv_12= ',' ( ( ruleSomRef ) ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==23) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1540:4: otherlv_12= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleEndToEndFlowInstance2848); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getEndToEndFlowInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1544:1: ( ( ruleSomRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1545:1: ( ruleSomRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1545:1: ( ruleSomRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1546:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSomRef_in_ruleEndToEndFlowInstance2871);
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

                    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleEndToEndFlowInstance2885); 

                        	newLeafNode(otherlv_14, grammarAccess.getEndToEndFlowInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            otherlv_15=(Token)match(input,15,FOLLOW_15_in_ruleEndToEndFlowInstance2899); 

                	newLeafNode(otherlv_15, grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_7());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1567:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1568:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1568:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1569:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleEndToEndFlowInstance2922);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1582:2: (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==16) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1582:4: otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}'
                    {
                    otherlv_17=(Token)match(input,16,FOLLOW_16_in_ruleEndToEndFlowInstance2935); 

                        	newLeafNode(otherlv_17, grammarAccess.getEndToEndFlowInstanceAccess().getLeftCurlyBracketKeyword_9_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1586:1: ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1587:1: (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1587:1: (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1588:3: lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_9_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleEndToEndFlowInstance2956);
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

                    otherlv_19=(Token)match(input,17,FOLLOW_17_in_ruleEndToEndFlowInstance2968); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1616:1: entryRuleModeInstance returns [EObject current=null] : iv_ruleModeInstance= ruleModeInstance EOF ;
    public final EObject entryRuleModeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1617:2: (iv_ruleModeInstance= ruleModeInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1618:2: iv_ruleModeInstance= ruleModeInstance EOF
            {
             newCompositeNode(grammarAccess.getModeInstanceRule()); 
            pushFollow(FOLLOW_ruleModeInstance_in_entryRuleModeInstance3006);
            iv_ruleModeInstance=ruleModeInstance();

            state._fsp--;

             current =iv_ruleModeInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeInstance3016); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1625:1: ruleModeInstance returns [EObject current=null] : ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1628:28: ( ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1629:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1629:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1629:2: ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1629:2: ( (lv_initial_0_0= 'initial' ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==32) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1630:1: (lv_initial_0_0= 'initial' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1630:1: (lv_initial_0_0= 'initial' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1631:3: lv_initial_0_0= 'initial'
                    {
                    lv_initial_0_0=(Token)match(input,32,FOLLOW_32_in_ruleModeInstance3059); 

                            newLeafNode(lv_initial_0_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1644:3: ( (lv_derived_1_0= 'derived' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==33) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1645:1: (lv_derived_1_0= 'derived' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1645:1: (lv_derived_1_0= 'derived' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1646:3: lv_derived_1_0= 'derived'
                    {
                    lv_derived_1_0=(Token)match(input,33,FOLLOW_33_in_ruleModeInstance3091); 

                            newLeafNode(lv_derived_1_0, grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "derived");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleModeInstance3117); 

                	newLeafNode(otherlv_2, grammarAccess.getModeInstanceAccess().getModeKeyword_2());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1663:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1664:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1664:1: (lv_name_3_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1665:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3134); 

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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1681:2: (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==35) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1681:4: otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_35_in_ruleModeInstance3152); 

                        	newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getEqualsSignKeyword_4_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1685:1: ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
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
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1685:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1685:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1686:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1686:1: (otherlv_5= RULE_ID )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1687:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3173); 

                            		newLeafNode(otherlv_5, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1699:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1699:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1699:8: otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')'
                            {
                            otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleModeInstance3192); 

                                	newLeafNode(otherlv_6, grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_4_1_1_0());
                                
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1703:1: ( (otherlv_7= RULE_ID ) )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1704:1: (otherlv_7= RULE_ID )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1704:1: (otherlv_7= RULE_ID )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1705:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3212); 

                            		newLeafNode(otherlv_7, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_1_0()); 
                            	

                            }


                            }

                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1716:2: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+
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
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1716:4: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                            	    {
                            	    otherlv_8=(Token)match(input,23,FOLLOW_23_in_ruleModeInstance3225); 

                            	        	newLeafNode(otherlv_8, grammarAccess.getModeInstanceAccess().getCommaKeyword_4_1_1_2_0());
                            	        
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1720:1: ( (otherlv_9= RULE_ID ) )
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1721:1: (otherlv_9= RULE_ID )
                            	    {
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1721:1: (otherlv_9= RULE_ID )
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1722:3: otherlv_9= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	    	        }
                            	            
                            	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3245); 

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

                            otherlv_10=(Token)match(input,24,FOLLOW_24_in_ruleModeInstance3259); 

                                	newLeafNode(otherlv_10, grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_4_1_1_3());
                                

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,15,FOLLOW_15_in_ruleModeInstance3275); 

                	newLeafNode(otherlv_11, grammarAccess.getModeInstanceAccess().getColonKeyword_5());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1741:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1742:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1742:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1743:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleModeInstance3298);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1756:2: (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==16) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1756:4: otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}'
                    {
                    otherlv_13=(Token)match(input,16,FOLLOW_16_in_ruleModeInstance3311); 

                        	newLeafNode(otherlv_13, grammarAccess.getModeInstanceAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1760:1: ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1761:1: (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1761:1: (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1762:3: lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getModeInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_7_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleModeInstance3332);
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

                    otherlv_15=(Token)match(input,17,FOLLOW_17_in_ruleModeInstance3344); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1790:1: entryRuleModeTransitionInstance returns [EObject current=null] : iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF ;
    public final EObject entryRuleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransitionInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1791:2: (iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1792:2: iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionInstanceRule()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance3382);
            iv_ruleModeTransitionInstance=ruleModeTransitionInstance();

            state._fsp--;

             current =iv_ruleModeTransitionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransitionInstance3392); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1799:1: ruleModeTransitionInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1802:28: ( (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1803:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1803:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1803:3: otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleModeTransitionInstance3429); 

                	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleModeTransitionInstance3441); 

                	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1811:1: ( (lv_name_2_0= ruleModeTransitionName ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1812:1: (lv_name_2_0= ruleModeTransitionName )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1812:1: (lv_name_2_0= ruleModeTransitionName )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1813:3: lv_name_2_0= ruleModeTransitionName
            {
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getNameModeTransitionNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleModeTransitionName_in_ruleModeTransitionInstance3462);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1829:2: ( (otherlv_3= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1830:1: (otherlv_3= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1830:1: (otherlv_3= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1831:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance3482); 

            		newLeafNode(otherlv_3, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,27,FOLLOW_27_in_ruleModeTransitionInstance3494); 

                	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1846:1: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1847:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1847:1: (otherlv_5= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1848:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance3514); 

            		newLeafNode(otherlv_5, grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleModeTransitionInstance3526); 

                	newLeafNode(otherlv_6, grammarAccess.getModeTransitionInstanceAccess().getColonKeyword_6());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1863:1: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1864:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1864:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1865:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleModeTransitionInstance3549);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1878:2: (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==16) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1878:4: otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleModeTransitionInstance3562); 

                        	newLeafNode(otherlv_8, grammarAccess.getModeTransitionInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1882:1: ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1883:1: (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1883:1: (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1884:3: lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyAssociationInstance_in_ruleModeTransitionInstance3583);
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

                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleModeTransitionInstance3595); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1912:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1913:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1914:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode3633);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode3643); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1921:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1924:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1925:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1925:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1925:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleSystemOperationMode3680); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1929:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1930:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1930:1: (lv_name_1_0= RULE_STRING )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1931:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSystemOperationMode3697); 

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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1947:2: ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1947:3: ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1947:3: ( ( ruleInstanceRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1948:1: ( ruleInstanceRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1948:1: ( ruleInstanceRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1949:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleInstanceRef_in_ruleSystemOperationMode3726);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1962:2: (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==23) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1962:4: otherlv_3= ',' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleSystemOperationMode3739); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1966:1: ( ( ruleInstanceRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1967:1: ( ruleInstanceRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1967:1: ( ruleInstanceRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1968:3: ruleInstanceRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleInstanceRef_in_ruleSystemOperationMode3762);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1989:1: entryRulePropertyAssociationInstance returns [EObject current=null] : iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF ;
    public final EObject entryRulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociationInstance = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1990:2: (iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1991:2: iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF
            {
             newCompositeNode(grammarAccess.getPropertyAssociationInstanceRule()); 
            pushFollow(FOLLOW_rulePropertyAssociationInstance_in_entryRulePropertyAssociationInstance3802);
            iv_rulePropertyAssociationInstance=rulePropertyAssociationInstance();

            state._fsp--;

             current =iv_rulePropertyAssociationInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAssociationInstance3812); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:1998:1: rulePropertyAssociationInstance returns [EObject current=null] : ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) ;
    public final EObject rulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedValue_2_0 = null;

        EObject lv_ownedValue_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2001:28: ( ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2002:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2002:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2002:2: ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2002:2: ( ( ruleQPREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2003:1: ( ruleQPREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2003:1: ( ruleQPREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2004:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQPREF_in_rulePropertyAssociationInstance3860);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_rulePropertyAssociationInstance3872); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationInstanceAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2021:1: ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2022:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2022:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2023:3: lv_ownedValue_2_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_rulePropertyAssociationInstance3893);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2039:2: (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==23) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2039:4: otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_rulePropertyAssociationInstance3906); 

            	        	newLeafNode(otherlv_3, grammarAccess.getPropertyAssociationInstanceAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2043:1: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2044:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2044:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2045:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_rulePropertyAssociationInstance3927);
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

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_rulePropertyAssociationInstance3941); 

                	newLeafNode(otherlv_5, grammarAccess.getPropertyAssociationInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2065:1: ( ( rulePropertyAssociationRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2066:1: ( rulePropertyAssociationRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2066:1: ( rulePropertyAssociationRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2067:3: rulePropertyAssociationRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyAssociationPropertyAssociationCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyAssociationRef_in_rulePropertyAssociationInstance3964);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2088:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2089:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2090:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
            {
             newCompositeNode(grammarAccess.getOptionalModalPropertyValueRule()); 
            pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_entryRuleOptionalModalPropertyValue4000);
            iv_ruleOptionalModalPropertyValue=ruleOptionalModalPropertyValue();

            state._fsp--;

             current =iv_ruleOptionalModalPropertyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOptionalModalPropertyValue4010); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2097:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2100:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2101:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2101:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2101:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2101:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2102:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2102:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2103:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleOptionalModalPropertyValue4056);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2119:2: (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )?
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2119:4: otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleOptionalModalPropertyValue4069); 

                        	newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleOptionalModalPropertyValue4081); 

                        	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,22,FOLLOW_22_in_ruleOptionalModalPropertyValue4093); 

                        	newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2131:1: ( ( ruleSomRef ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2132:1: ( ruleSomRef )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2132:1: ( ruleSomRef )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2133:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSomRef_in_ruleOptionalModalPropertyValue4116);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2146:2: (otherlv_5= ',' ( ( ruleSomRef ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==23) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2146:4: otherlv_5= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleOptionalModalPropertyValue4129); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2150:1: ( ( ruleSomRef ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2151:1: ( ruleSomRef )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2151:1: ( ruleSomRef )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2152:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSomRef_in_ruleOptionalModalPropertyValue4152);
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

                    otherlv_7=(Token)match(input,24,FOLLOW_24_in_ruleOptionalModalPropertyValue4166); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2177:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2178:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2179:2: iv_rulePropertyExpression= rulePropertyExpression EOF
            {
             newCompositeNode(grammarAccess.getPropertyExpressionRule()); 
            pushFollow(FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression4204);
            iv_rulePropertyExpression=rulePropertyExpression();

            state._fsp--;

             current =iv_rulePropertyExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyExpression4214); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2186:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2189:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2190:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2190:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            int alt42=12;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2191:5: this_RecordTerm_0= ruleRecordTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRecordTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRecordTerm_in_rulePropertyExpression4261);
                    this_RecordTerm_0=ruleRecordTerm();

                    state._fsp--;

                     
                            current = this_RecordTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2201:5: this_ReferenceTerm_1= ruleReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getReferenceTermParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleReferenceTerm_in_rulePropertyExpression4288);
                    this_ReferenceTerm_1=ruleReferenceTerm();

                    state._fsp--;

                     
                            current = this_ReferenceTerm_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2211:5: this_InstanceReferenceValue_2= ruleInstanceReferenceValue
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getInstanceReferenceValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleInstanceReferenceValue_in_rulePropertyExpression4315);
                    this_InstanceReferenceValue_2=ruleInstanceReferenceValue();

                    state._fsp--;

                     
                            current = this_InstanceReferenceValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2221:5: this_ComponentClassifierTerm_3= ruleComponentClassifierTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComponentClassifierTermParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression4342);
                    this_ComponentClassifierTerm_3=ruleComponentClassifierTerm();

                    state._fsp--;

                     
                            current = this_ComponentClassifierTerm_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2231:5: this_ComputedTerm_4= ruleComputedTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getComputedTermParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleComputedTerm_in_rulePropertyExpression4369);
                    this_ComputedTerm_4=ruleComputedTerm();

                    state._fsp--;

                     
                            current = this_ComputedTerm_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2241:5: this_StringTerm_5= ruleStringTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getStringTermParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleStringTerm_in_rulePropertyExpression4396);
                    this_StringTerm_5=ruleStringTerm();

                    state._fsp--;

                     
                            current = this_StringTerm_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2251:5: this_NumericRangeTerm_6= ruleNumericRangeTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getNumericRangeTermParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression4423);
                    this_NumericRangeTerm_6=ruleNumericRangeTerm();

                    state._fsp--;

                     
                            current = this_NumericRangeTerm_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2261:5: this_RealTerm_7= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getRealTermParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleRealTerm_in_rulePropertyExpression4450);
                    this_RealTerm_7=ruleRealTerm();

                    state._fsp--;

                     
                            current = this_RealTerm_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2271:5: this_IntegerTerm_8= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getIntegerTermParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleIntegerTerm_in_rulePropertyExpression4477);
                    this_IntegerTerm_8=ruleIntegerTerm();

                    state._fsp--;

                     
                            current = this_IntegerTerm_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2281:5: this_ListTerm_9= ruleListTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getListTermParserRuleCall_9()); 
                        
                    pushFollow(FOLLOW_ruleListTerm_in_rulePropertyExpression4504);
                    this_ListTerm_9=ruleListTerm();

                    state._fsp--;

                     
                            current = this_ListTerm_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2291:5: this_BooleanLiteral_10= ruleBooleanLiteral
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getBooleanLiteralParserRuleCall_10()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rulePropertyExpression4531);
                    this_BooleanLiteral_10=ruleBooleanLiteral();

                    state._fsp--;

                     
                            current = this_BooleanLiteral_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 12 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2301:5: this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm
                    {
                     
                            newCompositeNode(grammarAccess.getPropertyExpressionAccess().getLiteralorReferenceTermParserRuleCall_11()); 
                        
                    pushFollow(FOLLOW_ruleLiteralorReferenceTerm_in_rulePropertyExpression4558);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2317:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2318:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2319:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathElementRule()); 
            pushFollow(FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement4593);
            iv_ruleContainmentPathElement=ruleContainmentPathElement();

            state._fsp--;

             current =iv_ruleContainmentPathElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPathElement4603); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2326:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2329:28: ( ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2330:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2330:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2330:2: ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2330:2: ( ( ruleDeclarativeRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2331:1: ( ruleDeclarativeRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2331:1: ( ruleDeclarativeRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2332:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDeclarativeRef_in_ruleContainmentPathElement4651);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2345:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==18) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2346:1: (lv_arrayRange_1_0= ruleArrayRange )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2346:1: (lv_arrayRange_1_0= ruleArrayRange )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2347:3: lv_arrayRange_1_0= ruleArrayRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleArrayRange_in_ruleContainmentPathElement4672);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2363:3: (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==39) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2363:5: otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_39_in_ruleContainmentPathElement4686); 

                        	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getSolidusKeyword_2_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2367:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2368:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2368:1: (lv_path_3_0= ruleContainmentPathElement )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2369:3: lv_path_3_0= ruleContainmentPathElement
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getPathContainmentPathElementParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleContainmentPathElement4707);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2393:1: entryRuleInstanceReferenceValue returns [EObject current=null] : iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF ;
    public final EObject entryRuleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceReferenceValue = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2394:2: (iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2395:2: iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF
            {
             newCompositeNode(grammarAccess.getInstanceReferenceValueRule()); 
            pushFollow(FOLLOW_ruleInstanceReferenceValue_in_entryRuleInstanceReferenceValue4745);
            iv_ruleInstanceReferenceValue=ruleInstanceReferenceValue();

            state._fsp--;

             current =iv_ruleInstanceReferenceValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceReferenceValue4755); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2402:1: ruleInstanceReferenceValue returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) ;
    public final EObject ruleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2405:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2406:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2406:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2406:3: otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleInstanceReferenceValue4792); 

                	newLeafNode(otherlv_0, grammarAccess.getInstanceReferenceValueAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleInstanceReferenceValue4804); 

                	newLeafNode(otherlv_1, grammarAccess.getInstanceReferenceValueAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2414:1: ( ( ruleInstanceRef ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2415:1: ( ruleInstanceRef )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2415:1: ( ruleInstanceRef )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2416:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getInstanceReferenceValueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getInstanceReferenceValueAccess().getReferencedInstanceObjectInstanceObjectCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleInstanceRef_in_ruleInstanceReferenceValue4827);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleInstanceReferenceValue4839); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2441:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2442:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2443:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType4876);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType4887); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2450:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2453:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2454:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2454:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2455:2: kw= 'in'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleDirectionType4925); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2462:2: kw= 'out'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleDirectionType4944); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2468:6: (kw= 'in' kw= 'out' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2468:6: (kw= 'in' kw= 'out' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2469:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleDirectionType4964); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleDirectionType4977); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2488:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2489:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2490:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory5019);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory5030); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2497:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2500:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2501:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2501:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2502:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleFeatureCategory5068); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2509:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleFeatureCategory5087); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2516:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleFeatureCategory5106); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2523:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleFeatureCategory5125); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2530:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleFeatureCategory5144); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2537:2: kw= 'dataAccess'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleFeatureCategory5163); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2544:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleFeatureCategory5182); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2551:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleFeatureCategory5201); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2558:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleFeatureCategory5220); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2565:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleFeatureCategory5239); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2578:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2579:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2580:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory5280);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory5291); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2587:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2590:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2591:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2591:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt47=14;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2592:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleComponentCategory5329); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2599:2: kw= 'bus'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleComponentCategory5348); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2606:2: kw= 'data'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleComponentCategory5367); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2613:2: kw= 'device'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleComponentCategory5386); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2620:2: kw= 'memory'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleComponentCategory5405); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2627:2: kw= 'process'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleComponentCategory5424); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2634:2: kw= 'processor'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleComponentCategory5443); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2641:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleComponentCategory5462); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2647:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2647:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2648:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleComponentCategory5482); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleComponentCategory5495); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2661:2: kw= 'system'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleComponentCategory5515); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2667:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2667:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2668:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleComponentCategory5535); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleComponentCategory5548); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2681:2: kw= 'thread'
                    {
                    kw=(Token)match(input,62,FOLLOW_62_in_ruleComponentCategory5568); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2687:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2687:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2688:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleComponentCategory5588); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleComponentCategory5601); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2700:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2700:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2701:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleComponentCategory5622); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleComponentCategory5635); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2720:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2721:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2722:2: iv_ruleConnectionKind= ruleConnectionKind EOF
            {
             newCompositeNode(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind5677);
            iv_ruleConnectionKind=ruleConnectionKind();

            state._fsp--;

             current =iv_ruleConnectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind5688); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2729:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2732:28: ( (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2733:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2733:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2734:2: kw= 'featureConnection'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleConnectionKind5726); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2741:2: kw= 'accessConnection'
                    {
                    kw=(Token)match(input,65,FOLLOW_65_in_ruleConnectionKind5745); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2748:2: kw= 'parameterConnection'
                    {
                    kw=(Token)match(input,66,FOLLOW_66_in_ruleConnectionKind5764); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2755:2: kw= 'portConnection'
                    {
                    kw=(Token)match(input,67,FOLLOW_67_in_ruleConnectionKind5783); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2762:2: kw= 'featureGroupConnection'
                    {
                    kw=(Token)match(input,68,FOLLOW_68_in_ruleConnectionKind5802); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2775:1: entryRuleClassifierRef returns [String current=null] : iv_ruleClassifierRef= ruleClassifierRef EOF ;
    public final String entryRuleClassifierRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleClassifierRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2776:2: (iv_ruleClassifierRef= ruleClassifierRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2777:2: iv_ruleClassifierRef= ruleClassifierRef EOF
            {
             newCompositeNode(grammarAccess.getClassifierRefRule()); 
            pushFollow(FOLLOW_ruleClassifierRef_in_entryRuleClassifierRef5843);
            iv_ruleClassifierRef=ruleClassifierRef();

            state._fsp--;

             current =iv_ruleClassifierRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassifierRef5854); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2784:1: ruleClassifierRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleClassifierRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2787:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2788:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2788:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2788:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2788:2: (this_ID_0= RULE_ID kw= '::' )+
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
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2788:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassifierRef5895); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_ruleClassifierRef5913); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getClassifierRefAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassifierRef5930); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2808:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==70) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2809:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleClassifierRef5949); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getClassifierRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleClassifierRef5964); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2829:1: entryRuleImplRef returns [String current=null] : iv_ruleImplRef= ruleImplRef EOF ;
    public final String entryRuleImplRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2830:2: (iv_ruleImplRef= ruleImplRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2831:2: iv_ruleImplRef= ruleImplRef EOF
            {
             newCompositeNode(grammarAccess.getImplRefRule()); 
            pushFollow(FOLLOW_ruleImplRef_in_entryRuleImplRef6012);
            iv_ruleImplRef=ruleImplRef();

            state._fsp--;

             current =iv_ruleImplRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImplRef6023); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2838:1: ruleImplRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleImplRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2841:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2842:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2842:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2842:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2842:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    int LA51_1 = input.LA(2);

                    if ( (LA51_1==69) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2842:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImplRef6064); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_ruleImplRef6082); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getImplRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImplRef6099); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,70,FOLLOW_70_in_ruleImplRef6117); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getImplRefAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleImplRef6132); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2883:1: entryRuleDeclarativeRef returns [String current=null] : iv_ruleDeclarativeRef= ruleDeclarativeRef EOF ;
    public final String entryRuleDeclarativeRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeclarativeRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2884:2: (iv_ruleDeclarativeRef= ruleDeclarativeRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2885:2: iv_ruleDeclarativeRef= ruleDeclarativeRef EOF
            {
             newCompositeNode(grammarAccess.getDeclarativeRefRule()); 
            pushFollow(FOLLOW_ruleDeclarativeRef_in_entryRuleDeclarativeRef6178);
            iv_ruleDeclarativeRef=ruleDeclarativeRef();

            state._fsp--;

             current =iv_ruleDeclarativeRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDeclarativeRef6189); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2892:1: ruleDeclarativeRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2895:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2896:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2896:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2896:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2896:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    int LA52_1 = input.LA(2);

                    if ( (LA52_1==69) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2896:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclarativeRef6230); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_ruleDeclarativeRef6248); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclarativeRef6265); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2916:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==70) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2917:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleDeclarativeRef6284); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclarativeRef6299); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_15_in_ruleDeclarativeRef6319); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonKeyword_3()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2935:1: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==36) ) {
                alt54=1;
            }
            else if ( (LA54_0==RULE_ID) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2935:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2935:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2936:2: kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleDeclarativeRef6334); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getTransitionKeyword_4_0_0()); 
                        
                    kw=(Token)match(input,71,FOLLOW_71_in_ruleDeclarativeRef6347); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getNumberSignKeyword_4_0_1()); 
                        
                    this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleDeclarativeRef6362); 

                    		current.merge(this_INTEGER_LIT_8);
                        
                     
                        newLeafNode(this_INTEGER_LIT_8, grammarAccess.getDeclarativeRefAccess().getINTEGER_LITTerminalRuleCall_4_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2955:10: this_ID_9= RULE_ID
                    {
                    this_ID_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDeclarativeRef6389); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2970:1: entryRuleInstanceRef returns [String current=null] : iv_ruleInstanceRef= ruleInstanceRef EOF ;
    public final String entryRuleInstanceRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInstanceRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2971:2: (iv_ruleInstanceRef= ruleInstanceRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2972:2: iv_ruleInstanceRef= ruleInstanceRef EOF
            {
             newCompositeNode(grammarAccess.getInstanceRefRule()); 
            pushFollow(FOLLOW_ruleInstanceRef_in_entryRuleInstanceRef6436);
            iv_ruleInstanceRef=ruleInstanceRef();

            state._fsp--;

             current =iv_ruleInstanceRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInstanceRef6447); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2979:1: ruleInstanceRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2982:28: ( (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2983:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2983:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==72) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_ID||LA59_0==73) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2984:2: kw= 'parent'
                    {
                    kw=(Token)match(input,72,FOLLOW_72_in_ruleInstanceRef6485); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getParentKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2990:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2990:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2990:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2990:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*
                    loop56:
                    do {
                        int alt56=2;
                        alt56 = dfa56.predict(input);
                        switch (alt56) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2990:12: this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.'
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstanceRef6508); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_0_0()); 
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2997:1: (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )*
                    	    loop55:
                    	    do {
                    	        int alt55=2;
                    	        int LA55_0 = input.LA(1);

                    	        if ( (LA55_0==18) ) {
                    	            alt55=1;
                    	        }


                    	        switch (alt55) {
                    	    	case 1 :
                    	    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:2998:2: kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']'
                    	    	    {
                    	    	    kw=(Token)match(input,18,FOLLOW_18_in_ruleInstanceRef6527); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_0_1_0()); 
                    	    	        
                    	    	    this_INTEGER_LIT_3=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6542); 

                    	    	    		current.merge(this_INTEGER_LIT_3);
                    	    	        
                    	    	     
                    	    	        newLeafNode(this_INTEGER_LIT_3, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_0_1_1()); 
                    	    	        
                    	    	    kw=(Token)match(input,19,FOLLOW_19_in_ruleInstanceRef6560); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_0_1_2()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop55;
                    	        }
                    	    } while (true);

                    	    kw=(Token)match(input,70,FOLLOW_70_in_ruleInstanceRef6575); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop56;
                        }
                    } while (true);

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3022:3: ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==73) ) {
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
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3022:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3022:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3023:2: kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,73,FOLLOW_73_in_ruleInstanceRef6592); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getConnectionKeyword_1_1_0_0()); 
                                
                            kw=(Token)match(input,71,FOLLOW_71_in_ruleInstanceRef6605); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getNumberSignKeyword_1_1_0_1()); 
                                
                            this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6620); 

                            		current.merge(this_INTEGER_LIT_8);
                                
                             
                                newLeafNode(this_INTEGER_LIT_8, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_0_2()); 
                                

                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3042:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3042:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3042:11: this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            {
                            this_ID_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleInstanceRef6648); 

                            		current.merge(this_ID_9);
                                
                             
                                newLeafNode(this_ID_9, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_1_1_0()); 
                                
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3049:1: (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            loop57:
                            do {
                                int alt57=2;
                                int LA57_0 = input.LA(1);

                                if ( (LA57_0==18) ) {
                                    alt57=1;
                                }


                                switch (alt57) {
                            	case 1 :
                            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3050:2: kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']'
                            	    {
                            	    kw=(Token)match(input,18,FOLLOW_18_in_ruleInstanceRef6667); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_1_1_1_0()); 
                            	        
                            	    this_INTEGER_LIT_11=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6682); 

                            	    		current.merge(this_INTEGER_LIT_11);
                            	        
                            	     
                            	        newLeafNode(this_INTEGER_LIT_11, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_1_1_1()); 
                            	        
                            	    kw=(Token)match(input,19,FOLLOW_19_in_ruleInstanceRef6700); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_1_1_1_2()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop57;
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3076:1: entryRuleSomRef returns [String current=null] : iv_ruleSomRef= ruleSomRef EOF ;
    public final String entryRuleSomRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSomRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3077:2: (iv_ruleSomRef= ruleSomRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3078:2: iv_ruleSomRef= ruleSomRef EOF
            {
             newCompositeNode(grammarAccess.getSomRefRule()); 
            pushFollow(FOLLOW_ruleSomRef_in_entryRuleSomRef6746);
            iv_ruleSomRef=ruleSomRef();

            state._fsp--;

             current =iv_ruleSomRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSomRef6757); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3085:1: ruleSomRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSomRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3088:28: ( (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3089:1: (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3089:1: (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3090:2: kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            kw=(Token)match(input,37,FOLLOW_37_in_ruleSomRef6795); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSomRefAccess().getSomKeyword_0()); 
                
            kw=(Token)match(input,71,FOLLOW_71_in_ruleSomRef6808); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSomRefAccess().getNumberSignKeyword_1()); 
                
            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleSomRef6823); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3116:1: entryRuleTransitionRef returns [String current=null] : iv_ruleTransitionRef= ruleTransitionRef EOF ;
    public final String entryRuleTransitionRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTransitionRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3117:2: (iv_ruleTransitionRef= ruleTransitionRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3118:2: iv_ruleTransitionRef= ruleTransitionRef EOF
            {
             newCompositeNode(grammarAccess.getTransitionRefRule()); 
            pushFollow(FOLLOW_ruleTransitionRef_in_entryRuleTransitionRef6869);
            iv_ruleTransitionRef=ruleTransitionRef();

            state._fsp--;

             current =iv_ruleTransitionRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransitionRef6880); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3125:1: ruleTransitionRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleTransitionRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3128:28: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3129:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3129:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3130:2: kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            kw=(Token)match(input,36,FOLLOW_36_in_ruleTransitionRef6918); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTransitionRefAccess().getTransitionKeyword_0()); 
                
            kw=(Token)match(input,71,FOLLOW_71_in_ruleTransitionRef6931); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTransitionRefAccess().getNumberSignKeyword_1()); 
                
            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleTransitionRef6946); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3156:1: entryRuleModeTransitionName returns [String current=null] : iv_ruleModeTransitionName= ruleModeTransitionName EOF ;
    public final String entryRuleModeTransitionName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModeTransitionName = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3157:2: (iv_ruleModeTransitionName= ruleModeTransitionName EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3158:2: iv_ruleModeTransitionName= ruleModeTransitionName EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionNameRule()); 
            pushFollow(FOLLOW_ruleModeTransitionName_in_entryRuleModeTransitionName6992);
            iv_ruleModeTransitionName=ruleModeTransitionName();

            state._fsp--;

             current =iv_ruleModeTransitionName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransitionName7003); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3165:1: ruleModeTransitionName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModeTransitionName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3168:28: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3169:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3169:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3169:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionName7043); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,70,FOLLOW_70_in_ruleModeTransitionName7061); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getModeTransitionNameAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionName7076); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_2()); 
                
            kw=(Token)match(input,70,FOLLOW_70_in_ruleModeTransitionName7094); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getModeTransitionNameAccess().getFullStopKeyword_3()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionName7109); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3210:1: entryRulePropertyAssociationRef returns [String current=null] : iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF ;
    public final String entryRulePropertyAssociationRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePropertyAssociationRef = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3211:2: (iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3212:2: iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF
            {
             newCompositeNode(grammarAccess.getPropertyAssociationRefRule()); 
            pushFollow(FOLLOW_rulePropertyAssociationRef_in_entryRulePropertyAssociationRef7155);
            iv_rulePropertyAssociationRef=rulePropertyAssociationRef();

            state._fsp--;

             current =iv_rulePropertyAssociationRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAssociationRef7166); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3219:1: rulePropertyAssociationRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3222:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3223:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3223:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3223:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3223:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt60=0;
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    int LA60_1 = input.LA(2);

                    if ( (LA60_1==69) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3223:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociationRef7207); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_rulePropertyAssociationRef7225); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt60 >= 1 ) break loop60;
                        EarlyExitException eee =
                            new EarlyExitException(60, input);
                        throw eee;
                }
                cnt60++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociationRef7242); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3243:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==70) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3244:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_rulePropertyAssociationRef7261); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociationRef7276); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_15_in_rulePropertyAssociationRef7296); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_3()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3262:1: ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID||LA63_0==36) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3262:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':'
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3262:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==RULE_ID) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==36) ) {
                        alt62=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3262:7: this_ID_6= RULE_ID
                            {
                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAssociationRef7313); 

                            		current.merge(this_ID_6);
                                
                             
                                newLeafNode(this_ID_6, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3270:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            {
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3270:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3271:2: kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,36,FOLLOW_36_in_rulePropertyAssociationRef7338); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getTransitionKeyword_4_0_1_0()); 
                                
                            kw=(Token)match(input,71,FOLLOW_71_in_rulePropertyAssociationRef7351); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_4_0_1_1()); 
                                
                            this_INTEGER_LIT_9=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_rulePropertyAssociationRef7366); 

                            		current.merge(this_INTEGER_LIT_9);
                                
                             
                                newLeafNode(this_INTEGER_LIT_9, grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_4_0_1_2()); 
                                

                            }


                            }
                            break;

                    }

                    kw=(Token)match(input,15,FOLLOW_15_in_rulePropertyAssociationRef7386); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_4_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,74,FOLLOW_74_in_rulePropertyAssociationRef7401); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getPropertyKeyword_5()); 
                
            kw=(Token)match(input,71,FOLLOW_71_in_rulePropertyAssociationRef7414); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_6()); 
                
            this_INTEGER_LIT_13=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_rulePropertyAssociationRef7429); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3322:1: entryRuleLong returns [String current=null] : iv_ruleLong= ruleLong EOF ;
    public final String entryRuleLong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLong = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3323:2: (iv_ruleLong= ruleLong EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3324:2: iv_ruleLong= ruleLong EOF
            {
             newCompositeNode(grammarAccess.getLongRule()); 
            pushFollow(FOLLOW_ruleLong_in_entryRuleLong7475);
            iv_ruleLong=ruleLong();

            state._fsp--;

             current =iv_ruleLong.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLong7486); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3331:1: ruleLong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleLong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3334:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3335:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleLong7525); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3352:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3353:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3354:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getContainedPropertyAssociationRule()); 
            pushFollow(FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation7571);
            iv_ruleContainedPropertyAssociation=ruleContainedPropertyAssociation();

            state._fsp--;

             current =iv_ruleContainedPropertyAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainedPropertyAssociation7581); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3361:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' ) ;
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
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3364:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3365:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3365:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3365:2: ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3365:2: ( ( ruleQPREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3366:1: ( ruleQPREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3366:1: ( ruleQPREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3367:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQPREF_in_ruleContainedPropertyAssociation7629);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3380:2: (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==38) ) {
                alt64=1;
            }
            else if ( (LA64_0==75) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3380:4: otherlv_1= '=>'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleContainedPropertyAssociation7642); 

                        	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3385:6: ( (lv_append_2_0= '+=>' ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3385:6: ( (lv_append_2_0= '+=>' ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3386:1: (lv_append_2_0= '+=>' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3386:1: (lv_append_2_0= '+=>' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3387:3: lv_append_2_0= '+=>'
                    {
                    lv_append_2_0=(Token)match(input,75,FOLLOW_75_in_ruleContainedPropertyAssociation7666); 

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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3400:3: ( (lv_constant_3_0= 'constant' ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==76) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3401:1: (lv_constant_3_0= 'constant' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3401:1: (lv_constant_3_0= 'constant' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3402:3: lv_constant_3_0= 'constant'
                    {
                    lv_constant_3_0=(Token)match(input,76,FOLLOW_76_in_ruleContainedPropertyAssociation7698); 

                            newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "constant", true, "constant");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3415:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3415:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3415:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3416:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3416:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3417:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
            	    
            pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation7734);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3433:2: (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==23) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3433:4: otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleContainedPropertyAssociation7747); 

            	        	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	        
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3437:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3438:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3438:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3439:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation7768);
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
            	    break loop66;
                }
            } while (true);


            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3455:5: (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==77) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3455:7: otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    {
                    otherlv_7=(Token)match(input,77,FOLLOW_77_in_ruleContainedPropertyAssociation7784); 

                        	newLeafNode(otherlv_7, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());
                        
                    otherlv_8=(Token)match(input,31,FOLLOW_31_in_ruleContainedPropertyAssociation7796); 

                        	newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3463:1: ( (lv_appliesTo_9_0= ruleContainmentPath ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3464:1: (lv_appliesTo_9_0= ruleContainmentPath )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3464:1: (lv_appliesTo_9_0= ruleContainmentPath )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3465:3: lv_appliesTo_9_0= ruleContainmentPath
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation7817);
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

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3481:2: (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    loop67:
                    do {
                        int alt67=2;
                        int LA67_0 = input.LA(1);

                        if ( (LA67_0==23) ) {
                            alt67=1;
                        }


                        switch (alt67) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3481:4: otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_10=(Token)match(input,23,FOLLOW_23_in_ruleContainedPropertyAssociation7830); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3485:1: ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3486:1: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3486:1: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3487:3: lv_appliesTo_11_0= ruleContainmentPath
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation7851);
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
                    	    break loop67;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3503:6: (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==20) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3503:8: otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')'
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_20_in_ruleContainedPropertyAssociation7868); 

                        	newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getInKeyword_5_0());
                        
                    otherlv_13=(Token)match(input,78,FOLLOW_78_in_ruleContainedPropertyAssociation7880); 

                        	newLeafNode(otherlv_13, grammarAccess.getContainedPropertyAssociationAccess().getBindingKeyword_5_1());
                        
                    otherlv_14=(Token)match(input,22,FOLLOW_22_in_ruleContainedPropertyAssociation7892); 

                        	newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_2());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3515:1: ( ( ruleQCREF ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3516:1: ( ruleQCREF )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3516:1: ( ruleQCREF )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3517:3: ruleQCREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQCREF_in_ruleContainedPropertyAssociation7915);
                    ruleQCREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_16=(Token)match(input,24,FOLLOW_24_in_ruleContainedPropertyAssociation7927); 

                        	newLeafNode(otherlv_16, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_17=(Token)match(input,79,FOLLOW_79_in_ruleContainedPropertyAssociation7941); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3550:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3551:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3552:2: iv_ruleContainmentPath= ruleContainmentPath EOF
            {
             newCompositeNode(grammarAccess.getContainmentPathRule()); 
            pushFollow(FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath7981);
            iv_ruleContainmentPath=ruleContainmentPath();

            state._fsp--;

             current =iv_ruleContainmentPath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContainmentPath7991); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3559:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3562:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3563:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3563:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3564:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3564:1: (lv_path_0_0= ruleContainmentPathElement )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3565:3: lv_path_0_0= ruleContainmentPathElement
            {
             
            	        newCompositeNode(grammarAccess.getContainmentPathAccess().getPathContainmentPathElementParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath8036);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3591:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3592:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3593:2: iv_rulePropertyValue= rulePropertyValue EOF
            {
             newCompositeNode(grammarAccess.getPropertyValueRule()); 
            pushFollow(FOLLOW_rulePropertyValue_in_entryRulePropertyValue8073);
            iv_rulePropertyValue=rulePropertyValue();

            state._fsp--;

             current =iv_rulePropertyValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyValue8083); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3600:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3603:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3604:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3604:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3605:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3605:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3606:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyExpression_in_rulePropertyValue8128);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3630:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3631:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3632:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getLiteralorReferenceTermRule()); 
            pushFollow(FOLLOW_ruleLiteralorReferenceTerm_in_entryRuleLiteralorReferenceTerm8163);
            iv_ruleLiteralorReferenceTerm=ruleLiteralorReferenceTerm();

            state._fsp--;

             current =iv_ruleLiteralorReferenceTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralorReferenceTerm8173); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3639:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3642:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3643:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3643:1: ( ( ruleQPREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3644:1: ( ruleQPREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3644:1: ( ruleQPREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3645:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getLiteralorReferenceTermRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getLiteralorReferenceTermAccess().getNamedValueAbstractNamedValueCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQPREF_in_ruleLiteralorReferenceTerm8220);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3666:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3667:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3668:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8255);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral8265); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3675:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3678:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3679:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3679:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3679:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3679:2: ()
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3680:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3685:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==80) ) {
                alt70=1;
            }
            else if ( (LA70_0==81) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3685:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3685:3: ( (lv_value_1_0= 'true' ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3686:1: (lv_value_1_0= 'true' )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3686:1: (lv_value_1_0= 'true' )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3687:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,80,FOLLOW_80_in_ruleBooleanLiteral8318); 

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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3701:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,81,FOLLOW_81_in_ruleBooleanLiteral8349); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3713:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3714:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3715:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_ruleConstantValue_in_entryRuleConstantValue8386);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantValue8396); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3722:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3725:28: ( ( ( ruleQPREF ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3726:1: ( ( ruleQPREF ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3726:1: ( ( ruleQPREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3727:1: ( ruleQPREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3727:1: ( ruleQPREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3728:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantValueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConstantValueAccess().getNamedValuePropertyConstantCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQPREF_in_ruleConstantValue8443);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3749:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3750:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3751:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
            {
             newCompositeNode(grammarAccess.getReferenceTermRule()); 
            pushFollow(FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm8478);
            iv_ruleReferenceTerm=ruleReferenceTerm();

            state._fsp--;

             current =iv_ruleReferenceTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceTerm8488); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3758:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3761:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3762:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3762:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3762:3: otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleReferenceTerm8525); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleReferenceTerm8537); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3770:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3771:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3771:1: (lv_path_2_0= ruleContainmentPathElement )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3772:3: lv_path_2_0= ruleContainmentPathElement
            {
             
            	        newCompositeNode(grammarAccess.getReferenceTermAccess().getPathContainmentPathElementParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8558);
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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleReferenceTerm8570); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3800:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3801:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3802:2: iv_ruleRecordTerm= ruleRecordTerm EOF
            {
             newCompositeNode(grammarAccess.getRecordTermRule()); 
            pushFollow(FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm8606);
            iv_ruleRecordTerm=ruleRecordTerm();

            state._fsp--;

             current =iv_ruleRecordTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRecordTerm8616); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3809:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3812:28: ( (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3813:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3813:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3813:3: otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleRecordTerm8653); 

                	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3817:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt71=0;
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_ID) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3818:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3818:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3819:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm8674);
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
            	    if ( cnt71 >= 1 ) break loop71;
                        EarlyExitException eee =
                            new EarlyExitException(71, input);
                        throw eee;
                }
                cnt71++;
            } while (true);

            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleRecordTerm8687); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3849:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3850:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3851:2: iv_ruleComputedTerm= ruleComputedTerm EOF
            {
             newCompositeNode(grammarAccess.getComputedTermRule()); 
            pushFollow(FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm8725);
            iv_ruleComputedTerm=ruleComputedTerm();

            state._fsp--;

             current =iv_ruleComputedTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComputedTerm8735); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3858:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3861:28: ( (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3862:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3862:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3862:3: otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_82_in_ruleComputedTerm8772); 

                	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleComputedTerm8784); 

                	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3870:1: ( (lv_function_2_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3871:1: (lv_function_2_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3871:1: (lv_function_2_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3872:3: lv_function_2_0= RULE_ID
            {
            lv_function_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComputedTerm8801); 

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

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleComputedTerm8818); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3900:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3901:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3902:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
            {
             newCompositeNode(grammarAccess.getComponentClassifierTermRule()); 
            pushFollow(FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm8854);
            iv_ruleComponentClassifierTerm=ruleComponentClassifierTerm();

            state._fsp--;

             current =iv_ruleComponentClassifierTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentClassifierTerm8864); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3909:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3912:28: ( (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3913:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3913:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3913:3: otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_83_in_ruleComponentClassifierTerm8901); 

                	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleComponentClassifierTerm8913); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3921:1: ( ( ruleQCREF ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3922:1: ( ruleQCREF )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3922:1: ( ruleQCREF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3923:3: ruleQCREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentClassifierTermRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentClassifierTermAccess().getClassifierComponentClassifierCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm8936);
            ruleQCREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleComponentClassifierTerm8948); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3948:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3949:2: (iv_ruleListTerm= ruleListTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3950:2: iv_ruleListTerm= ruleListTerm EOF
            {
             newCompositeNode(grammarAccess.getListTermRule()); 
            pushFollow(FOLLOW_ruleListTerm_in_entryRuleListTerm8984);
            iv_ruleListTerm=ruleListTerm();

            state._fsp--;

             current =iv_ruleListTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleListTerm8994); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3957:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3960:28: ( ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3961:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3961:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3961:2: () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3961:2: ()
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3962:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListTermAccess().getListValueAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleListTerm9040); 

                	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3971:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=RULE_ID && LA73_0<=RULE_REAL_LIT)||LA73_0==18||LA73_0==22||LA73_0==40||(LA73_0>=80 && LA73_0<=85)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3971:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3971:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3972:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3972:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3973:3: lv_ownedListElement_2_0= rulePropertyExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_rulePropertyExpression_in_ruleListTerm9062);
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

                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3989:2: (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop72:
                    do {
                        int alt72=2;
                        int LA72_0 = input.LA(1);

                        if ( (LA72_0==23) ) {
                            alt72=1;
                        }


                        switch (alt72) {
                    	case 1 :
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3989:4: otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleListTerm9075); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3993:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3994:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3994:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:3995:3: lv_ownedListElement_4_0= rulePropertyExpression
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getListTermAccess().getOwnedListElementPropertyExpressionParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePropertyExpression_in_ruleListTerm9096);
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
                    	    break loop72;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,24,FOLLOW_24_in_ruleListTerm9112); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4023:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4024:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4025:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
            {
             newCompositeNode(grammarAccess.getFieldPropertyAssociationRule()); 
            pushFollow(FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation9148);
            iv_ruleFieldPropertyAssociation=ruleFieldPropertyAssociation();

            state._fsp--;

             current =iv_ruleFieldPropertyAssociation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFieldPropertyAssociation9158); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4032:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4035:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4036:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4036:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4036:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4036:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4037:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4037:1: (otherlv_0= RULE_ID )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4038:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation9203); 

            		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleFieldPropertyAssociation9215); 

                	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4053:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4054:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4054:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4055:3: lv_ownedValue_2_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation9236);
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

            otherlv_3=(Token)match(input,79,FOLLOW_79_in_ruleFieldPropertyAssociation9248); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4085:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4086:2: (iv_rulePlusMinus= rulePlusMinus EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4087:2: iv_rulePlusMinus= rulePlusMinus EOF
            {
             newCompositeNode(grammarAccess.getPlusMinusRule()); 
            pushFollow(FOLLOW_rulePlusMinus_in_entryRulePlusMinus9287);
            iv_rulePlusMinus=rulePlusMinus();

            state._fsp--;

             current =iv_rulePlusMinus.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePlusMinus9298); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4094:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4097:28: ( (kw= '+' | kw= '-' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4098:1: (kw= '+' | kw= '-' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4098:1: (kw= '+' | kw= '-' )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==84) ) {
                alt74=1;
            }
            else if ( (LA74_0==85) ) {
                alt74=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4099:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_rulePlusMinus9336); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4106:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_rulePlusMinus9355); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4119:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4120:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4121:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm9395);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm9405); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4128:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4131:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4132:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4132:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4133:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4133:1: (lv_value_0_0= ruleNoQuoteString )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4134:3: lv_value_0_0= ruleNoQuoteString
            {
             
            	        newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleNoQuoteString_in_ruleStringTerm9450);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4158:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4159:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4160:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
             newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            pushFollow(FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString9486);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;

             current =iv_ruleNoQuoteString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNoQuoteString9497); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4167:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4170:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4171:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNoQuoteString9536); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4186:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4187:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4188:2: iv_ruleArrayRange= ruleArrayRange EOF
            {
             newCompositeNode(grammarAccess.getArrayRangeRule()); 
            pushFollow(FOLLOW_ruleArrayRange_in_entryRuleArrayRange9580);
            iv_ruleArrayRange=ruleArrayRange();

            state._fsp--;

             current =iv_ruleArrayRange; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayRange9590); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4195:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4198:28: ( ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4199:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4199:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4199:2: () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']'
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4199:2: ()
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4200:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleArrayRange9636); 

                	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4209:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4210:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4210:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4211:3: lv_lowerBound_2_0= ruleINTVALUE
            {
             
            	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleINTVALUE_in_ruleArrayRange9657);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4227:2: (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==86) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4227:4: otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,86,FOLLOW_86_in_ruleArrayRange9670); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4231:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4232:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4232:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4233:3: lv_upperBound_4_0= ruleINTVALUE
                    {
                     
                    	        newCompositeNode(grammarAccess.getArrayRangeAccess().getUpperBoundINTVALUEParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINTVALUE_in_ruleArrayRange9691);
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

            otherlv_5=(Token)match(input,19,FOLLOW_19_in_ruleArrayRange9705); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4261:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4262:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4263:2: iv_ruleSignedConstant= ruleSignedConstant EOF
            {
             newCompositeNode(grammarAccess.getSignedConstantRule()); 
            pushFollow(FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant9741);
            iv_ruleSignedConstant=ruleSignedConstant();

            state._fsp--;

             current =iv_ruleSignedConstant; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedConstant9751); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4270:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4273:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4274:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4274:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4274:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4274:2: ( (lv_op_0_0= rulePlusMinus ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4275:1: (lv_op_0_0= rulePlusMinus )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4275:1: (lv_op_0_0= rulePlusMinus )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4276:3: lv_op_0_0= rulePlusMinus
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_rulePlusMinus_in_ruleSignedConstant9797);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4292:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4293:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4293:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4294:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOwnedPropertyExpressionConstantValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleConstantValue_in_ruleSignedConstant9818);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4318:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4319:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4320:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm9854);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm9864); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4327:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4330:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4331:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4331:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4331:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4331:2: ( (lv_value_0_0= ruleSignedInt ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4332:1: (lv_value_0_0= ruleSignedInt )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4332:1: (lv_value_0_0= ruleSignedInt )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4333:3: lv_value_0_0= ruleSignedInt
            {
             
            	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSignedInt_in_ruleIntegerTerm9910);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4349:2: ( (otherlv_1= RULE_ID ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4350:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4350:1: (otherlv_1= RULE_ID )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4351:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntegerTermRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerTerm9930); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4370:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4371:2: (iv_ruleSignedInt= ruleSignedInt EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4372:2: iv_ruleSignedInt= ruleSignedInt EOF
            {
             newCompositeNode(grammarAccess.getSignedIntRule()); 
            pushFollow(FOLLOW_ruleSignedInt_in_entryRuleSignedInt9968);
            iv_ruleSignedInt=ruleSignedInt();

            state._fsp--;

             current =iv_ruleSignedInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedInt9979); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4379:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4382:28: ( ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4383:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4383:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4383:2: (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4383:2: (kw= '+' | kw= '-' )?
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
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4384:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleSignedInt10018); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4391:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleSignedInt10037); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleSignedInt10054); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4411:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4412:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4413:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm10099);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm10109); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4420:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4423:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4424:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4424:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4424:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4424:2: ( (lv_value_0_0= ruleSignedReal ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4425:1: (lv_value_0_0= ruleSignedReal )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4425:1: (lv_value_0_0= ruleSignedReal )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4426:3: lv_value_0_0= ruleSignedReal
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleSignedReal_in_ruleRealTerm10155);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4442:2: ( (otherlv_1= RULE_ID ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4443:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4443:1: (otherlv_1= RULE_ID )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4444:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRealTermRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealTerm10175); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4463:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4464:2: (iv_ruleSignedReal= ruleSignedReal EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4465:2: iv_ruleSignedReal= ruleSignedReal EOF
            {
             newCompositeNode(grammarAccess.getSignedRealRule()); 
            pushFollow(FOLLOW_ruleSignedReal_in_entryRuleSignedReal10213);
            iv_ruleSignedReal=ruleSignedReal();

            state._fsp--;

             current =iv_ruleSignedReal.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSignedReal10224); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4472:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4475:28: ( ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4476:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4476:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4476:2: (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4476:2: (kw= '+' | kw= '-' )?
            int alt79=3;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==84) ) {
                alt79=1;
            }
            else if ( (LA79_0==85) ) {
                alt79=2;
            }
            switch (alt79) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4477:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_84_in_ruleSignedReal10263); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4484:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_85_in_ruleSignedReal10282); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getHyphenMinusKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_REAL_LIT_2=(Token)match(input,RULE_REAL_LIT,FOLLOW_RULE_REAL_LIT_in_ruleSignedReal10299); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4504:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4505:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4506:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
            {
             newCompositeNode(grammarAccess.getNumericRangeTermRule()); 
            pushFollow(FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm10344);
            iv_ruleNumericRangeTerm=ruleNumericRangeTerm();

            state._fsp--;

             current =iv_ruleNumericRangeTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumericRangeTerm10354); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4513:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4516:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4517:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4517:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4517:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4517:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4518:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4518:1: (lv_minimum_0_0= ruleNumAlt )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4519:3: lv_minimum_0_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10400);
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

            otherlv_1=(Token)match(input,86,FOLLOW_86_in_ruleNumericRangeTerm10412); 

                	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4539:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4540:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4540:1: (lv_maximum_2_0= ruleNumAlt )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4541:3: lv_maximum_2_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10433);
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

            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4557:2: (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==87) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4557:4: otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,87,FOLLOW_87_in_ruleNumericRangeTerm10446); 

                        	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                        
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4561:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4562:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4562:1: (lv_delta_4_0= ruleNumAlt )
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4563:3: lv_delta_4_0= ruleNumAlt
                    {
                     
                    	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getDeltaNumAltParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10467);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4587:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4588:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4589:2: iv_ruleNumAlt= ruleNumAlt EOF
            {
             newCompositeNode(grammarAccess.getNumAltRule()); 
            pushFollow(FOLLOW_ruleNumAlt_in_entryRuleNumAlt10505);
            iv_ruleNumAlt=ruleNumAlt();

            state._fsp--;

             current =iv_ruleNumAlt; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumAlt10515); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4596:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4599:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4600:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4600:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt81=4;
            switch ( input.LA(1) ) {
            case 84:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt81=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt81=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt81=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 1, input);

                    throw nvae;
                }

                }
                break;
            case 85:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt81=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt81=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt81=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 81, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt81=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt81=2;
                }
                break;
            case RULE_ID:
                {
                alt81=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4601:5: this_RealTerm_0= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getRealTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleNumAlt10562);
                    this_RealTerm_0=ruleRealTerm();

                    state._fsp--;

                     
                            current = this_RealTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4611:5: this_IntegerTerm_1= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getIntegerTermParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleNumAlt10589);
                    this_IntegerTerm_1=ruleIntegerTerm();

                    state._fsp--;

                     
                            current = this_IntegerTerm_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4621:5: this_SignedConstant_2= ruleSignedConstant
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getSignedConstantParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSignedConstant_in_ruleNumAlt10616);
                    this_SignedConstant_2=ruleSignedConstant();

                    state._fsp--;

                     
                            current = this_SignedConstant_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4631:5: this_ConstantValue_3= ruleConstantValue
                    {
                     
                            newCompositeNode(grammarAccess.getNumAltAccess().getConstantValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleConstantValue_in_ruleNumAlt10643);
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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4647:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4648:2: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4649:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
             newCompositeNode(grammarAccess.getINTVALUERule()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE10679);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;

             current =iv_ruleINTVALUE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTVALUE10690); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4656:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4659:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4660:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE10729); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4677:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4678:2: (iv_ruleQPREF= ruleQPREF EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4679:2: iv_ruleQPREF= ruleQPREF EOF
            {
             newCompositeNode(grammarAccess.getQPREFRule()); 
            pushFollow(FOLLOW_ruleQPREF_in_entryRuleQPREF10776);
            iv_ruleQPREF=ruleQPREF();

            state._fsp--;

             current =iv_ruleQPREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQPREF10787); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4686:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4689:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4690:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4690:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4690:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQPREF10827); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4697:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==69) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4698:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,69,FOLLOW_69_in_ruleQPREF10846); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQPREFAccess().getColonColonKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQPREF10861); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4718:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4719:2: (iv_ruleQCREF= ruleQCREF EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4720:2: iv_ruleQCREF= ruleQCREF EOF
            {
             newCompositeNode(grammarAccess.getQCREFRule()); 
            pushFollow(FOLLOW_ruleQCREF_in_entryRuleQCREF10909);
            iv_ruleQCREF=ruleQCREF();

            state._fsp--;

             current =iv_ruleQCREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQCREF10920); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4727:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4730:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4731:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4731:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4731:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4731:2: (this_ID_0= RULE_ID kw= '::' )*
            loop83:
            do {
                int alt83=2;
                int LA83_0 = input.LA(1);

                if ( (LA83_0==RULE_ID) ) {
                    int LA83_1 = input.LA(2);

                    if ( (LA83_1==69) ) {
                        alt83=1;
                    }


                }


                switch (alt83) {
            	case 1 :
            	    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4731:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF10961); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_69_in_ruleQCREF10979); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop83;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF10996); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4751:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==70) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4752:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_70_in_ruleQCREF11015); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQCREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQCREF11030); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4772:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4773:2: (iv_ruleSTAR= ruleSTAR EOF )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4774:2: iv_ruleSTAR= ruleSTAR EOF
            {
             newCompositeNode(grammarAccess.getSTARRule()); 
            pushFollow(FOLLOW_ruleSTAR_in_entryRuleSTAR11078);
            iv_ruleSTAR=ruleSTAR();

            state._fsp--;

             current =iv_ruleSTAR.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSTAR11089); 

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
    // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4781:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '*' ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4784:28: (kw= '*' )
            // ../org.osate.aadl2.instance.textual/src-gen/org/osate/aadl2/instance/textual/parser/antlr/internal/InternalInstance.g:4786:2: kw= '*'
            {
            kw=(Token)match(input,88,FOLLOW_88_in_ruleSTAR11126); 

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
    protected DFA56 dfa56 = new DFA56(this);
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
            return "()* loopback of 679:1: ( ( (lv_featureInstance_17_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_18_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_19_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_20_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_21_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_22_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_23_0= ruleModeTransitionInstance ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )*";
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
            return "2190:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )";
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
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\11\1\10\1\13\1\14\1\15\1\16";
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
            "\1\20\4\uffff\1\21",
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
            return "2591:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String DFA56_eotS =
        "\7\uffff";
    static final String DFA56_eofS =
        "\2\uffff\1\1\3\uffff\1\1";
    static final String DFA56_minS =
        "\1\4\1\uffff\1\4\1\6\1\uffff\1\23\1\4";
    static final String DFA56_maxS =
        "\1\111\1\uffff\1\111\1\6\1\uffff\1\23\1\111";
    static final String DFA56_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA56_specialS =
        "\7\uffff}>";
    static final String[] DFA56_transitionS = {
            "\1\2\104\uffff\1\1",
            "",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\1\uffff\2\1\1\uffff\3\1\2\uffff\1\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1",
            "\1\5",
            "",
            "\1\6",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\1\uffff\2\1\1\uffff\3\1\2\uffff\1\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1"
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "()* loopback of 2990:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*";
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
    public static final BitSet FOLLOW_ruleClassifierRef_in_ruleComponentInstance1051 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleComponentInstance1063 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleComponentInstance1086 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1099 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1121 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleComponentInstance1148 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1175 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1202 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance1229 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleComponentInstance1256 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance1283 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleComponentInstance1310 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleConnectionInstance1415 = new BitSet(new long[]{0x0000000002000000L,0x000000000000001FL});
    public static final BitSet FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1450 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConnectionInstance1467 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConnectionInstance1484 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionInstance1507 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_26_in_ruleConnectionInstance1526 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_27_in_ruleConnectionInstance1557 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionInstance1581 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleConnectionInstance1594 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleConnectionInstance1606 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance1618 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleConnectionInstance1641 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleConnectionInstance1654 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleConnectionInstance1677 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleConnectionInstance1691 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_20_in_ruleConnectionInstance1706 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleConnectionInstance1718 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance1730 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_ruleConnectionInstance1753 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleConnectionInstance1766 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_ruleConnectionInstance1789 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleConnectionInstance1803 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConnectionInstance1817 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000031FL});
    public static final BitSet FOLLOW_ruleConnectionReference_in_ruleConnectionInstance1839 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000031FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleConnectionInstance1866 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000031FL});
    public static final BitSet FOLLOW_17_in_ruleConnectionInstance1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference1916 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionReference1974 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleConnectionReference1986 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionReference2009 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConnectionReference2021 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleConnectionReference2044 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConnectionReference2056 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleConnectionReference2079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2115 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleFlowSpecificationInstance2162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2179 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecificationInstance2196 = new BitSet(new long[]{0x0000000008000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleFlowSpecificationInstance2219 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleFlowSpecificationInstance2232 = new BitSet(new long[]{0x0000000001000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleFlowSpecificationInstance2255 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2268 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleFlowSpecificationInstance2281 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleFlowSpecificationInstance2293 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecificationInstance2305 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2325 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleFlowSpecificationInstance2338 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2358 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2372 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleFlowSpecificationInstance2387 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleFlowSpecificationInstance2399 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecificationInstance2411 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_ruleFlowSpecificationInstance2434 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleFlowSpecificationInstance2447 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_ruleFlowSpecificationInstance2470 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2484 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFlowSpecificationInstance2498 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleFlowSpecificationInstance2521 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleFlowSpecificationInstance2534 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleFlowSpecificationInstance2555 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_17_in_ruleFlowSpecificationInstance2568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance2606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndToEndFlowInstance2616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleEndToEndFlowInstance2653 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleEndToEndFlowInstance2665 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleEndToEndFlowInstance2677 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleEndToEndFlowInstance2689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance2706 = new BitSet(new long[]{0x0000000000108010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleEndToEndFlowInstance2735 = new BitSet(new long[]{0x0000000008108000L});
    public static final BitSet FOLLOW_27_in_ruleEndToEndFlowInstance2748 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleEndToEndFlowInstance2771 = new BitSet(new long[]{0x0000000008108000L});
    public static final BitSet FOLLOW_20_in_ruleEndToEndFlowInstance2788 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEndToEndFlowInstance2800 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEndToEndFlowInstance2812 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleEndToEndFlowInstance2835 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleEndToEndFlowInstance2848 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleEndToEndFlowInstance2871 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleEndToEndFlowInstance2885 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEndToEndFlowInstance2899 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleEndToEndFlowInstance2922 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleEndToEndFlowInstance2935 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleEndToEndFlowInstance2956 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEndToEndFlowInstance2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_entryRuleModeInstance3006 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeInstance3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleModeInstance3059 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33_in_ruleModeInstance3091 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleModeInstance3117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3134 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35_in_ruleModeInstance3152 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3173 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_22_in_ruleModeInstance3192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3212 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleModeInstance3225 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3245 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleModeInstance3259 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModeInstance3275 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleModeInstance3298 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleModeInstance3311 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleModeInstance3332 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModeInstance3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance3382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransitionInstance3392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleModeTransitionInstance3429 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleModeTransitionInstance3441 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleModeTransitionName_in_ruleModeTransitionInstance3462 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance3482 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleModeTransitionInstance3494 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance3514 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModeTransitionInstance3526 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleModeTransitionInstance3549 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleModeTransitionInstance3562 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_ruleModeTransitionInstance3583 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModeTransitionInstance3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode3633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSystemOperationMode3680 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSystemOperationMode3697 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleSystemOperationMode3726 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_23_in_ruleSystemOperationMode3739 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleSystemOperationMode3762 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rulePropertyAssociationInstance_in_entryRulePropertyAssociationInstance3802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAssociationInstance3812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_rulePropertyAssociationInstance3860 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_rulePropertyAssociationInstance3872 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_rulePropertyAssociationInstance3893 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_23_in_rulePropertyAssociationInstance3906 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_rulePropertyAssociationInstance3927 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_15_in_rulePropertyAssociationInstance3941 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rulePropertyAssociationRef_in_rulePropertyAssociationInstance3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_entryRuleOptionalModalPropertyValue4000 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOptionalModalPropertyValue4010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleOptionalModalPropertyValue4056 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleOptionalModalPropertyValue4069 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleOptionalModalPropertyValue4081 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleOptionalModalPropertyValue4093 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleOptionalModalPropertyValue4116 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleOptionalModalPropertyValue4129 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ruleSomRef_in_ruleOptionalModalPropertyValue4152 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleOptionalModalPropertyValue4166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_entryRulePropertyExpression4204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyExpression4214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_rulePropertyExpression4261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceTerm_in_rulePropertyExpression4288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceReferenceValue_in_rulePropertyExpression4315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_rulePropertyExpression4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_rulePropertyExpression4369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_rulePropertyExpression4396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_rulePropertyExpression4423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_rulePropertyExpression4450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_rulePropertyExpression4477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_rulePropertyExpression4504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rulePropertyExpression4531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_rulePropertyExpression4558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_entryRuleContainmentPathElement4593 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPathElement4603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_ruleContainmentPathElement4651 = new BitSet(new long[]{0x0000008000040002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_ruleContainmentPathElement4672 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleContainmentPathElement4686 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPathElement4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceReferenceValue_in_entryRuleInstanceReferenceValue4745 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceReferenceValue4755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleInstanceReferenceValue4792 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleInstanceReferenceValue4804 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_ruleInstanceReferenceValue4827 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleInstanceReferenceValue4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType4876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType4887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDirectionType4925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleDirectionType4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDirectionType4964 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleDirectionType4977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory5019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory5030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleFeatureCategory5068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleFeatureCategory5087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFeatureCategory5106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFeatureCategory5125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleFeatureCategory5144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFeatureCategory5163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleFeatureCategory5182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleFeatureCategory5201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleFeatureCategory5220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleFeatureCategory5239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory5280 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory5291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleComponentCategory5329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleComponentCategory5348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleComponentCategory5367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleComponentCategory5386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleComponentCategory5405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleComponentCategory5424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleComponentCategory5443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleComponentCategory5462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleComponentCategory5482 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleComponentCategory5495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleComponentCategory5515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleComponentCategory5535 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleComponentCategory5548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleComponentCategory5568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleComponentCategory5588 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleComponentCategory5601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleComponentCategory5622 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleComponentCategory5635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind5677 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind5688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleConnectionKind5726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleConnectionKind5745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleConnectionKind5764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleConnectionKind5783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_68_in_ruleConnectionKind5802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifierRef_in_entryRuleClassifierRef5843 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassifierRef5854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassifierRef5895 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleClassifierRef5913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassifierRef5930 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleClassifierRef5949 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleClassifierRef5964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImplRef_in_entryRuleImplRef6012 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImplRef6023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImplRef6064 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleImplRef6082 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImplRef6099 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleImplRef6117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleImplRef6132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDeclarativeRef_in_entryRuleDeclarativeRef6178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDeclarativeRef6189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclarativeRef6230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleDeclarativeRef6248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclarativeRef6265 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleDeclarativeRef6284 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclarativeRef6299 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleDeclarativeRef6319 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_36_in_ruleDeclarativeRef6334 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleDeclarativeRef6347 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleDeclarativeRef6362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDeclarativeRef6389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInstanceRef_in_entryRuleInstanceRef6436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInstanceRef6447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleInstanceRef6485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstanceRef6508 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000040L});
    public static final BitSet FOLLOW_18_in_ruleInstanceRef6527 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6542 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleInstanceRef6560 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleInstanceRef6575 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleInstanceRef6592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleInstanceRef6605 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleInstanceRef6648 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleInstanceRef6667 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleInstanceRef6682 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleInstanceRef6700 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleSomRef_in_entryRuleSomRef6746 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSomRef6757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSomRef6795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleSomRef6808 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleSomRef6823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransitionRef_in_entryRuleTransitionRef6869 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransitionRef6880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleTransitionRef6918 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_ruleTransitionRef6931 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleTransitionRef6946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionName_in_entryRuleModeTransitionName6992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransitionName7003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionName7043 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleModeTransitionName7061 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionName7076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleModeTransitionName7094 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionName7109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAssociationRef_in_entryRulePropertyAssociationRef7155 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAssociationRef7166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociationRef7207 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_rulePropertyAssociationRef7225 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociationRef7242 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_rulePropertyAssociationRef7261 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociationRef7276 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePropertyAssociationRef7296 = new BitSet(new long[]{0x0000001000000010L,0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAssociationRef7313 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_36_in_rulePropertyAssociationRef7338 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_rulePropertyAssociationRef7351 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_rulePropertyAssociationRef7366 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulePropertyAssociationRef7386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_rulePropertyAssociationRef7401 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_71_in_rulePropertyAssociationRef7414 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_rulePropertyAssociationRef7429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLong_in_entryRuleLong7475 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLong7486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleLong7525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainedPropertyAssociation_in_entryRuleContainedPropertyAssociation7571 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainedPropertyAssociation7581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleContainedPropertyAssociation7629 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_38_in_ruleContainedPropertyAssociation7642 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F101FL});
    public static final BitSet FOLLOW_75_in_ruleContainedPropertyAssociation7666 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F101FL});
    public static final BitSet FOLLOW_76_in_ruleContainedPropertyAssociation7698 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation7734 = new BitSet(new long[]{0x0000000000900000L,0x000000000000A000L});
    public static final BitSet FOLLOW_23_in_ruleContainedPropertyAssociation7747 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_ruleOptionalModalPropertyValue_in_ruleContainedPropertyAssociation7768 = new BitSet(new long[]{0x0000000000900000L,0x000000000000A000L});
    public static final BitSet FOLLOW_77_in_ruleContainedPropertyAssociation7784 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleContainedPropertyAssociation7796 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation7817 = new BitSet(new long[]{0x0000000000900000L,0x0000000000008000L});
    public static final BitSet FOLLOW_23_in_ruleContainedPropertyAssociation7830 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPath_in_ruleContainedPropertyAssociation7851 = new BitSet(new long[]{0x0000000000900000L,0x0000000000008000L});
    public static final BitSet FOLLOW_20_in_ruleContainedPropertyAssociation7868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_ruleContainedPropertyAssociation7880 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleContainedPropertyAssociation7892 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleContainedPropertyAssociation7915 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleContainedPropertyAssociation7927 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleContainedPropertyAssociation7941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPath_in_entryRuleContainmentPath7981 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContainmentPath7991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleContainmentPath8036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyValue_in_entryRulePropertyValue8073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyValue8083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyExpression_in_rulePropertyValue8128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralorReferenceTerm_in_entryRuleLiteralorReferenceTerm8163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralorReferenceTerm8173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleLiteralorReferenceTerm8220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral8255 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral8265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_ruleBooleanLiteral8318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_81_in_ruleBooleanLiteral8349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue8386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue8396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_ruleConstantValue8443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceTerm_in_entryRuleReferenceTerm8478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceTerm8488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleReferenceTerm8525 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleReferenceTerm8537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleContainmentPathElement_in_ruleReferenceTerm8558 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleReferenceTerm8570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRecordTerm_in_entryRuleRecordTerm8606 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRecordTerm8616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleRecordTerm8653 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_ruleRecordTerm8674 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_19_in_ruleRecordTerm8687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComputedTerm_in_entryRuleComputedTerm8725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComputedTerm8735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_82_in_ruleComputedTerm8772 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleComputedTerm8784 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComputedTerm8801 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComputedTerm8818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentClassifierTerm_in_entryRuleComponentClassifierTerm8854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentClassifierTerm8864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_83_in_ruleComponentClassifierTerm8901 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleComponentClassifierTerm8913 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQCREF_in_ruleComponentClassifierTerm8936 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleComponentClassifierTerm8948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleListTerm_in_entryRuleListTerm8984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleListTerm8994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleListTerm9040 = new BitSet(new long[]{0xEFF00327635400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm9062 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleListTerm9075 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleListTerm9096 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_24_in_ruleListTerm9112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFieldPropertyAssociation_in_entryRuleFieldPropertyAssociation9148 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFieldPropertyAssociation9158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFieldPropertyAssociation9203 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleFieldPropertyAssociation9215 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_rulePropertyExpression_in_ruleFieldPropertyAssociation9236 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_ruleFieldPropertyAssociation9248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusMinus_in_entryRulePlusMinus9287 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePlusMinus9298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_rulePlusMinus9336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_85_in_rulePlusMinus9355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm9395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm9405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_ruleStringTerm9450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNoQuoteString_in_entryRuleNoQuoteString9486 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNoQuoteString9497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNoQuoteString9536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayRange_in_entryRuleArrayRange9580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayRange9590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleArrayRange9636 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_ruleArrayRange9657 = new BitSet(new long[]{0x0000000000080000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleArrayRange9670 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_ruleArrayRange9691 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleArrayRange9705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_entryRuleSignedConstant9741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedConstant9751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePlusMinus_in_ruleSignedConstant9797 = new BitSet(new long[]{0xEFF00227621000D0L,0x000000000030001FL});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleSignedConstant9818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm9854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm9864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInt_in_ruleIntegerTerm9910 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm9930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedInt_in_entryRuleSignedInt9968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedInt9979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleSignedInt10018 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_85_in_ruleSignedInt10037 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleSignedInt10054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm10099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm10109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedReal_in_ruleRealTerm10155 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm10175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedReal_in_entryRuleSignedReal10213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSignedReal10224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_84_in_ruleSignedReal10263 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_85_in_ruleSignedReal10282 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_REAL_LIT_in_ruleSignedReal10299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumericRangeTerm_in_entryRuleNumericRangeTerm10344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumericRangeTerm10354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10400 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_86_in_ruleNumericRangeTerm10412 = new BitSet(new long[]{0xEFF00227621000D0L,0x000000000030001FL});
    public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10433 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_87_in_ruleNumericRangeTerm10446 = new BitSet(new long[]{0xEFF00227621000D0L,0x000000000030001FL});
    public static final BitSet FOLLOW_ruleNumAlt_in_ruleNumericRangeTerm10467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumAlt_in_entryRuleNumAlt10505 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumAlt10515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleNumAlt10562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleNumAlt10589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSignedConstant_in_ruleNumAlt10616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleNumAlt10643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE10679 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTVALUE10690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE10729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQPREF_in_entryRuleQPREF10776 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQPREF10787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF10827 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleQPREF10846 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQPREF10861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQCREF_in_entryRuleQCREF10909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQCREF10920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF10961 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_ruleQCREF10979 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF10996 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleQCREF11015 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQCREF11030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSTAR_in_entryRuleSTAR11078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSTAR11089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_ruleSTAR11126 = new BitSet(new long[]{0x0000000000000002L});

}