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

                        if ( (LA3_0==20||LA3_0==41) ) {
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

                if ( (LA5_1==69) ) {
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
    // InternalInstance.g:847:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' ) ;
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
            // InternalInstance.g:850:28: ( ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' ) )
            // InternalInstance.g:851:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' )
            {
            // InternalInstance.g:851:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}' )
            // InternalInstance.g:851:2: ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleInstanceRef ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleInstanceRef ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )? otherlv_22= '{' ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+ otherlv_25= '}'
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

            // InternalInstance.g:956:2: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )?
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
                    // InternalInstance.g:956:4: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_8, grammarAccess.getConnectionInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_9, grammarAccess.getConnectionInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_21); 

                        	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // InternalInstance.g:968:1: ( ( ruleSomRef ) )
                    // InternalInstance.g:969:1: ( ruleSomRef )
                    {
                    // InternalInstance.g:969:1: ( ruleSomRef )
                    // InternalInstance.g:970:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_3_0()); 
                    	    
                    pushFollow(FOLLOW_15);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:983:2: (otherlv_12= ',' ( ( ruleSomRef ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==23) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalInstance.g:983:4: otherlv_12= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_21); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // InternalInstance.g:987:1: ( ( ruleSomRef ) )
                    	    // InternalInstance.g:988:1: ( ruleSomRef )
                    	    {
                    	    // InternalInstance.g:988:1: ( ruleSomRef )
                    	    // InternalInstance.g:989:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_15);
                    	    ruleSomRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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

            // InternalInstance.g:1006:3: (otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==20) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalInstance.g:1006:5: otherlv_15= 'in' otherlv_16= 'transitions' otherlv_17= '(' ( ( ruleTransitionRef ) ) (otherlv_19= ',' ( ( ruleTransitionRef ) ) )* otherlv_21= ')'
                    {
                    otherlv_15=(Token)match(input,20,FOLLOW_22); 

                        	newLeafNode(otherlv_15, grammarAccess.getConnectionInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_16=(Token)match(input,28,FOLLOW_14); 

                        	newLeafNode(otherlv_16, grammarAccess.getConnectionInstanceAccess().getTransitionsKeyword_8_1());
                        
                    otherlv_17=(Token)match(input,22,FOLLOW_23); 

                        	newLeafNode(otherlv_17, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_8_2());
                        
                    // InternalInstance.g:1018:1: ( ( ruleTransitionRef ) )
                    // InternalInstance.g:1019:1: ( ruleTransitionRef )
                    {
                    // InternalInstance.g:1019:1: ( ruleTransitionRef )
                    // InternalInstance.g:1020:3: ruleTransitionRef
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

                    // InternalInstance.g:1033:2: (otherlv_19= ',' ( ( ruleTransitionRef ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==23) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalInstance.g:1033:4: otherlv_19= ',' ( ( ruleTransitionRef ) )
                    	    {
                    	    otherlv_19=(Token)match(input,23,FOLLOW_23); 

                    	        	newLeafNode(otherlv_19, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_8_4_0());
                    	        
                    	    // InternalInstance.g:1037:1: ( ( ruleTransitionRef ) )
                    	    // InternalInstance.g:1038:1: ( ruleTransitionRef )
                    	    {
                    	    // InternalInstance.g:1038:1: ( ruleTransitionRef )
                    	    // InternalInstance.g:1039:3: ruleTransitionRef
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

            otherlv_22=(Token)match(input,16,FOLLOW_24); 

                	newLeafNode(otherlv_22, grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_9());
                
            // InternalInstance.g:1060:1: ( ( (lv_connectionReference_23_0= ruleConnectionReference ) ) | ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) ) )+
            int cnt17=0;
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=72 && LA17_0<=73)) ) {
                    alt17=1;
                }
                else if ( (LA17_0==RULE_ID) ) {
                    int LA17_3 = input.LA(2);

                    if ( (LA17_3==18||LA17_3==27||LA17_3==70) ) {
                        alt17=1;
                    }
                    else if ( (LA17_3==38||LA17_3==69) ) {
                        alt17=2;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // InternalInstance.g:1060:2: ( (lv_connectionReference_23_0= ruleConnectionReference ) )
            	    {
            	    // InternalInstance.g:1060:2: ( (lv_connectionReference_23_0= ruleConnectionReference ) )
            	    // InternalInstance.g:1061:1: (lv_connectionReference_23_0= ruleConnectionReference )
            	    {
            	    // InternalInstance.g:1061:1: (lv_connectionReference_23_0= ruleConnectionReference )
            	    // InternalInstance.g:1062:3: lv_connectionReference_23_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_10_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_25);
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
            	    // InternalInstance.g:1079:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
            	    {
            	    // InternalInstance.g:1079:6: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )
            	    // InternalInstance.g:1080:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
            	    {
            	    // InternalInstance.g:1080:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
            	    // InternalInstance.g:1081:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_25);
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
    // InternalInstance.g:1109:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // InternalInstance.g:1110:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // InternalInstance.g:1111:2: iv_ruleConnectionReference= ruleConnectionReference EOF
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
    // InternalInstance.g:1118:1: ruleConnectionReference returns [EObject current=null] : ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:1121:28: ( ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) ) )
            // InternalInstance.g:1122:1: ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) )
            {
            // InternalInstance.g:1122:1: ( ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) ) )
            // InternalInstance.g:1122:2: ( ( ruleInstanceRef ) ) otherlv_1= '->' ( ( ruleInstanceRef ) ) otherlv_3= ':' ( ( ruleDeclarativeRef ) ) otherlv_5= 'in' ( ( ruleInstanceRef ) )
            {
            // InternalInstance.g:1122:2: ( ( ruleInstanceRef ) )
            // InternalInstance.g:1123:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:1123:1: ( ruleInstanceRef )
            // InternalInstance.g:1124:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_26);
            ruleInstanceRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,27,FOLLOW_18); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
                
            // InternalInstance.g:1141:1: ( ( ruleInstanceRef ) )
            // InternalInstance.g:1142:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:1142:1: ( ruleInstanceRef )
            // InternalInstance.g:1143:3: ruleInstanceRef
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

            otherlv_3=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionReferenceAccess().getColonKeyword_3());
                
            // InternalInstance.g:1160:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1161:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1161:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1162:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_27);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_18); 

                	newLeafNode(otherlv_5, grammarAccess.getConnectionReferenceAccess().getInKeyword_5());
                
            // InternalInstance.g:1179:1: ( ( ruleInstanceRef ) )
            // InternalInstance.g:1180:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:1180:1: ( ruleInstanceRef )
            // InternalInstance.g:1181:3: ruleInstanceRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 
            	    
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
    // InternalInstance.g:1202:1: entryRuleFlowSpecificationInstance returns [EObject current=null] : iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF ;
    public final EObject entryRuleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecificationInstance = null;


        try {
            // InternalInstance.g:1203:2: (iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF )
            // InternalInstance.g:1204:2: iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF
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
    // InternalInstance.g:1211:1: ruleFlowSpecificationInstance returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? ) ;
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
            // InternalInstance.g:1214:28: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? ) )
            // InternalInstance.g:1215:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? )
            {
            // InternalInstance.g:1215:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )? )
            // InternalInstance.g:1215:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleInstanceRef ) )? otherlv_4= '->' ( ( ruleInstanceRef ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )? otherlv_21= ':' ( ( ruleDeclarativeRef ) ) (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0());
                
            // InternalInstance.g:1219:1: ( (lv_name_1_0= RULE_ID ) )
            // InternalInstance.g:1220:1: (lv_name_1_0= RULE_ID )
            {
            // InternalInstance.g:1220:1: (lv_name_1_0= RULE_ID )
            // InternalInstance.g:1221:3: lv_name_1_0= RULE_ID
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
                
            // InternalInstance.g:1241:1: ( ( ruleInstanceRef ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID||(LA18_0>=72 && LA18_0<=73)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalInstance.g:1242:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1242:1: ( ruleInstanceRef )
                    // InternalInstance.g:1243:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
                    	    
                    pushFollow(FOLLOW_26);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FOLLOW_29); 

                	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalInstance.g:1260:1: ( ( ruleInstanceRef ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID||(LA19_0>=72 && LA19_0<=73)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalInstance.g:1261:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1261:1: ( ruleInstanceRef )
                    // InternalInstance.g:1262:3: ruleInstanceRef
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
                
            // InternalInstance.g:1279:1: (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==20) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==21) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalInstance.g:1279:3: otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_7, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_8=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_8, grammarAccess.getFlowSpecificationInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_9=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_9, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // InternalInstance.g:1291:1: ( (otherlv_10= RULE_ID ) )
                    // InternalInstance.g:1292:1: (otherlv_10= RULE_ID )
                    {
                    // InternalInstance.g:1292:1: (otherlv_10= RULE_ID )
                    // InternalInstance.g:1293:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_15); 

                    		newLeafNode(otherlv_10, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_3_0()); 
                    	

                    }


                    }

                    // InternalInstance.g:1304:2: (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==23) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalInstance.g:1304:4: otherlv_11= ',' ( (otherlv_12= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // InternalInstance.g:1308:1: ( (otherlv_12= RULE_ID ) )
                    	    // InternalInstance.g:1309:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // InternalInstance.g:1309:1: (otherlv_12= RULE_ID )
                    	    // InternalInstance.g:1310:3: otherlv_12= RULE_ID
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
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,24,FOLLOW_31); 

                        	newLeafNode(otherlv_13, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // InternalInstance.g:1325:3: (otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==20) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalInstance.g:1325:5: otherlv_14= 'in' otherlv_15= 'transitions' otherlv_16= '(' ( ( ruleTransitionRef ) ) (otherlv_18= ',' ( ( ruleTransitionRef ) ) )* otherlv_20= ')'
                    {
                    otherlv_14=(Token)match(input,20,FOLLOW_22); 

                        	newLeafNode(otherlv_14, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_15=(Token)match(input,28,FOLLOW_14); 

                        	newLeafNode(otherlv_15, grammarAccess.getFlowSpecificationInstanceAccess().getTransitionsKeyword_8_1());
                        
                    otherlv_16=(Token)match(input,22,FOLLOW_23); 

                        	newLeafNode(otherlv_16, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_8_2());
                        
                    // InternalInstance.g:1337:1: ( ( ruleTransitionRef ) )
                    // InternalInstance.g:1338:1: ( ruleTransitionRef )
                    {
                    // InternalInstance.g:1338:1: ( ruleTransitionRef )
                    // InternalInstance.g:1339:3: ruleTransitionRef
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

                    // InternalInstance.g:1352:2: (otherlv_18= ',' ( ( ruleTransitionRef ) ) )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==23) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalInstance.g:1352:4: otherlv_18= ',' ( ( ruleTransitionRef ) )
                    	    {
                    	    otherlv_18=(Token)match(input,23,FOLLOW_23); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_8_4_0());
                    	        
                    	    // InternalInstance.g:1356:1: ( ( ruleTransitionRef ) )
                    	    // InternalInstance.g:1357:1: ( ruleTransitionRef )
                    	    {
                    	    // InternalInstance.g:1357:1: ( ruleTransitionRef )
                    	    // InternalInstance.g:1358:3: ruleTransitionRef
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
                    	    break loop22;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,24,FOLLOW_4); 

                        	newLeafNode(otherlv_20, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_8_5());
                        

                    }
                    break;

            }

            otherlv_21=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_21, grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_9());
                
            // InternalInstance.g:1379:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1380:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1380:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1381:3: ruleDeclarativeRef
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

            // InternalInstance.g:1394:2: (otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==16) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalInstance.g:1394:4: otherlv_23= '{' ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+ otherlv_25= '}'
                    {
                    otherlv_23=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_23, grammarAccess.getFlowSpecificationInstanceAccess().getLeftCurlyBracketKeyword_11_0());
                        
                    // InternalInstance.g:1398:1: ( (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance ) )+
                    int cnt24=0;
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==RULE_ID) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalInstance.g:1399:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    {
                    	    // InternalInstance.g:1399:1: (lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance )
                    	    // InternalInstance.g:1400:3: lv_ownedPropertyAssociation_24_0= rulePropertyAssociationInstance
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
                    	    if ( cnt24 >= 1 ) break loop24;
                                EarlyExitException eee =
                                    new EarlyExitException(24, input);
                                throw eee;
                        }
                        cnt24++;
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
    // InternalInstance.g:1428:1: entryRuleEndToEndFlowInstance returns [EObject current=null] : iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF ;
    public final EObject entryRuleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndToEndFlowInstance = null;


        try {
            // InternalInstance.g:1429:2: (iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF )
            // InternalInstance.g:1430:2: iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF
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
    // InternalInstance.g:1437:1: ruleEndToEndFlowInstance returns [EObject current=null] : (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? ) ;
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
            // InternalInstance.g:1440:28: ( (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? ) )
            // InternalInstance.g:1441:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? )
            {
            // InternalInstance.g:1441:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )? )
            // InternalInstance.g:1441:3: otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleDeclarativeRef ) ) (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_33); 

                	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0());
                
            otherlv_1=(Token)match(input,31,FOLLOW_34); 

                	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1());
                
            otherlv_2=(Token)match(input,30,FOLLOW_35); 

                	newLeafNode(otherlv_2, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2());
                
            otherlv_3=(Token)match(input,29,FOLLOW_3); 

                	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3());
                
            // InternalInstance.g:1457:1: ( (lv_name_4_0= RULE_ID ) )
            // InternalInstance.g:1458:1: (lv_name_4_0= RULE_ID )
            {
            // InternalInstance.g:1458:1: (lv_name_4_0= RULE_ID )
            // InternalInstance.g:1459:3: lv_name_4_0= RULE_ID
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

            // InternalInstance.g:1475:2: ( ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID||(LA27_0>=72 && LA27_0<=73)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalInstance.g:1475:3: ( ( ruleInstanceRef ) ) (otherlv_6= '->' ( ( ruleInstanceRef ) ) )*
                    {
                    // InternalInstance.g:1475:3: ( ( ruleInstanceRef ) )
                    // InternalInstance.g:1476:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1476:1: ( ruleInstanceRef )
                    // InternalInstance.g:1477:3: ruleInstanceRef
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

                    // InternalInstance.g:1490:2: (otherlv_6= '->' ( ( ruleInstanceRef ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==27) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalInstance.g:1490:4: otherlv_6= '->' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_6=(Token)match(input,27,FOLLOW_18); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0());
                    	        
                    	    // InternalInstance.g:1494:1: ( ( ruleInstanceRef ) )
                    	    // InternalInstance.g:1495:1: ( ruleInstanceRef )
                    	    {
                    	    // InternalInstance.g:1495:1: ( ruleInstanceRef )
                    	    // InternalInstance.g:1496:3: ruleInstanceRef
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
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalInstance.g:1509:6: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==20) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalInstance.g:1509:8: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSomRef ) ) (otherlv_12= ',' ( ( ruleSomRef ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_8, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_9, grammarAccess.getEndToEndFlowInstanceAccess().getModesKeyword_6_1());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_21); 

                        	newLeafNode(otherlv_10, grammarAccess.getEndToEndFlowInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // InternalInstance.g:1521:1: ( ( ruleSomRef ) )
                    // InternalInstance.g:1522:1: ( ruleSomRef )
                    {
                    // InternalInstance.g:1522:1: ( ruleSomRef )
                    // InternalInstance.g:1523:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_15);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:1536:2: (otherlv_12= ',' ( ( ruleSomRef ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==23) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalInstance.g:1536:4: otherlv_12= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_21); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getEndToEndFlowInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // InternalInstance.g:1540:1: ( ( ruleSomRef ) )
                    	    // InternalInstance.g:1541:1: ( ruleSomRef )
                    	    {
                    	    // InternalInstance.g:1541:1: ( ruleSomRef )
                    	    // InternalInstance.g:1542:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_15);
                    	    ruleSomRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,24,FOLLOW_4); 

                        	newLeafNode(otherlv_14, grammarAccess.getEndToEndFlowInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            otherlv_15=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_15, grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_7());
                
            // InternalInstance.g:1563:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1564:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1564:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1565:3: ruleDeclarativeRef
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

            // InternalInstance.g:1578:2: (otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==16) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalInstance.g:1578:4: otherlv_17= '{' ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) ) otherlv_19= '}'
                    {
                    otherlv_17=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_17, grammarAccess.getEndToEndFlowInstanceAccess().getLeftCurlyBracketKeyword_9_0());
                        
                    // InternalInstance.g:1582:1: ( (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance ) )
                    // InternalInstance.g:1583:1: (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance )
                    {
                    // InternalInstance.g:1583:1: (lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance )
                    // InternalInstance.g:1584:3: lv_ownedPropertyAssociation_18_0= rulePropertyAssociationInstance
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
    // InternalInstance.g:1612:1: entryRuleModeInstance returns [EObject current=null] : iv_ruleModeInstance= ruleModeInstance EOF ;
    public final EObject entryRuleModeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeInstance = null;


        try {
            // InternalInstance.g:1613:2: (iv_ruleModeInstance= ruleModeInstance EOF )
            // InternalInstance.g:1614:2: iv_ruleModeInstance= ruleModeInstance EOF
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
    // InternalInstance.g:1621:1: ruleModeInstance returns [EObject current=null] : ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? ) ;
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
            // InternalInstance.g:1624:28: ( ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? ) )
            // InternalInstance.g:1625:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? )
            {
            // InternalInstance.g:1625:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )? )
            // InternalInstance.g:1625:2: ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? otherlv_11= ':' ( ( ruleDeclarativeRef ) ) (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )?
            {
            // InternalInstance.g:1625:2: ( (lv_initial_0_0= 'initial' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==32) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalInstance.g:1626:1: (lv_initial_0_0= 'initial' )
                    {
                    // InternalInstance.g:1626:1: (lv_initial_0_0= 'initial' )
                    // InternalInstance.g:1627:3: lv_initial_0_0= 'initial'
                    {
                    lv_initial_0_0=(Token)match(input,32,FOLLOW_39); 

                            newLeafNode(lv_initial_0_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:1640:3: ( (lv_derived_1_0= 'derived' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==33) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalInstance.g:1641:1: (lv_derived_1_0= 'derived' )
                    {
                    // InternalInstance.g:1641:1: (lv_derived_1_0= 'derived' )
                    // InternalInstance.g:1642:3: lv_derived_1_0= 'derived'
                    {
                    lv_derived_1_0=(Token)match(input,33,FOLLOW_40); 

                            newLeafNode(lv_derived_1_0, grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "derived");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,34,FOLLOW_3); 

                	newLeafNode(otherlv_2, grammarAccess.getModeInstanceAccess().getModeKeyword_2());
                
            // InternalInstance.g:1659:1: ( (lv_name_3_0= RULE_ID ) )
            // InternalInstance.g:1660:1: (lv_name_3_0= RULE_ID )
            {
            // InternalInstance.g:1660:1: (lv_name_3_0= RULE_ID )
            // InternalInstance.g:1661:3: lv_name_3_0= RULE_ID
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

            // InternalInstance.g:1677:2: (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==35) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalInstance.g:1677:4: otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    {
                    otherlv_4=(Token)match(input,35,FOLLOW_42); 

                        	newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getEqualsSignKeyword_4_0());
                        
                    // InternalInstance.g:1681:1: ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==RULE_ID) ) {
                        alt34=1;
                    }
                    else if ( (LA34_0==22) ) {
                        alt34=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 34, 0, input);

                        throw nvae;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalInstance.g:1681:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // InternalInstance.g:1681:2: ( (otherlv_5= RULE_ID ) )
                            // InternalInstance.g:1682:1: (otherlv_5= RULE_ID )
                            {
                            // InternalInstance.g:1682:1: (otherlv_5= RULE_ID )
                            // InternalInstance.g:1683:3: otherlv_5= RULE_ID
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
                            // InternalInstance.g:1695:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            {
                            // InternalInstance.g:1695:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            // InternalInstance.g:1695:8: otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')'
                            {
                            otherlv_6=(Token)match(input,22,FOLLOW_3); 

                                	newLeafNode(otherlv_6, grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_4_1_1_0());
                                
                            // InternalInstance.g:1699:1: ( (otherlv_7= RULE_ID ) )
                            // InternalInstance.g:1700:1: (otherlv_7= RULE_ID )
                            {
                            // InternalInstance.g:1700:1: (otherlv_7= RULE_ID )
                            // InternalInstance.g:1701:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_43); 

                            		newLeafNode(otherlv_7, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_1_0()); 
                            	

                            }


                            }

                            // InternalInstance.g:1712:2: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+
                            int cnt33=0;
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==23) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // InternalInstance.g:1712:4: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                            	    {
                            	    otherlv_8=(Token)match(input,23,FOLLOW_3); 

                            	        	newLeafNode(otherlv_8, grammarAccess.getModeInstanceAccess().getCommaKeyword_4_1_1_2_0());
                            	        
                            	    // InternalInstance.g:1716:1: ( (otherlv_9= RULE_ID ) )
                            	    // InternalInstance.g:1717:1: (otherlv_9= RULE_ID )
                            	    {
                            	    // InternalInstance.g:1717:1: (otherlv_9= RULE_ID )
                            	    // InternalInstance.g:1718:3: otherlv_9= RULE_ID
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
                            	    if ( cnt33 >= 1 ) break loop33;
                                        EarlyExitException eee =
                                            new EarlyExitException(33, input);
                                        throw eee;
                                }
                                cnt33++;
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
                
            // InternalInstance.g:1737:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1738:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1738:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1739:3: ruleDeclarativeRef
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

            // InternalInstance.g:1752:2: (otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==16) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalInstance.g:1752:4: otherlv_13= '{' ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) ) otherlv_15= '}'
                    {
                    otherlv_13=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_13, grammarAccess.getModeInstanceAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // InternalInstance.g:1756:1: ( (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance ) )
                    // InternalInstance.g:1757:1: (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance )
                    {
                    // InternalInstance.g:1757:1: (lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance )
                    // InternalInstance.g:1758:3: lv_ownedPropertyAssociation_14_0= rulePropertyAssociationInstance
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
    // InternalInstance.g:1786:1: entryRuleModeTransitionInstance returns [EObject current=null] : iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF ;
    public final EObject entryRuleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransitionInstance = null;


        try {
            // InternalInstance.g:1787:2: (iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF )
            // InternalInstance.g:1788:2: iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF
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
    // InternalInstance.g:1795:1: ruleModeTransitionInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? ) ;
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
            // InternalInstance.g:1798:28: ( (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? ) )
            // InternalInstance.g:1799:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? )
            {
            // InternalInstance.g:1799:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? )
            // InternalInstance.g:1799:3: otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,34,FOLLOW_23); 

                	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,36,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
                
            // InternalInstance.g:1807:1: ( (lv_name_2_0= ruleModeTransitionName ) )
            // InternalInstance.g:1808:1: (lv_name_2_0= ruleModeTransitionName )
            {
            // InternalInstance.g:1808:1: (lv_name_2_0= ruleModeTransitionName )
            // InternalInstance.g:1809:3: lv_name_2_0= ruleModeTransitionName
            {
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getNameModeTransitionNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleModeTransitionName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModeTransitionInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"org.osate.aadl2.instance.textual.Instance.ModeTransitionName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:1825:2: ( (otherlv_3= RULE_ID ) )
            // InternalInstance.g:1826:1: (otherlv_3= RULE_ID )
            {
            // InternalInstance.g:1826:1: (otherlv_3= RULE_ID )
            // InternalInstance.g:1827:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_26); 

            		newLeafNode(otherlv_3, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,27,FOLLOW_3); 

                	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalInstance.g:1842:1: ( (otherlv_5= RULE_ID ) )
            // InternalInstance.g:1843:1: (otherlv_5= RULE_ID )
            {
            // InternalInstance.g:1843:1: (otherlv_5= RULE_ID )
            // InternalInstance.g:1844:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_4); 

            		newLeafNode(otherlv_5, grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_6, grammarAccess.getModeTransitionInstanceAccess().getColonKeyword_6());
                
            // InternalInstance.g:1859:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1860:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1860:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1861:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_11);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:1874:2: (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==16) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalInstance.g:1874:4: otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_8, grammarAccess.getModeTransitionInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // InternalInstance.g:1878:1: ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) )
                    // InternalInstance.g:1879:1: (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance )
                    {
                    // InternalInstance.g:1879:1: (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance )
                    // InternalInstance.g:1880:3: lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance
                    {
                     
                    	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getOwnedPropertyAssociationPropertyAssociationInstanceParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_38);
                    lv_ownedPropertyAssociation_9_0=rulePropertyAssociationInstance();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModeTransitionInstanceRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedPropertyAssociation",
                            		lv_ownedPropertyAssociation_9_0, 
                            		"org.osate.aadl2.instance.textual.Instance.PropertyAssociationInstance");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,17,FOLLOW_2); 

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
    // InternalInstance.g:1908:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // InternalInstance.g:1909:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // InternalInstance.g:1910:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
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
    // InternalInstance.g:1917:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:1920:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) )
            // InternalInstance.g:1921:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            {
            // InternalInstance.g:1921:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            // InternalInstance.g:1921:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // InternalInstance.g:1925:1: ( (lv_name_1_0= RULE_STRING ) )
            // InternalInstance.g:1926:1: (lv_name_1_0= RULE_STRING )
            {
            // InternalInstance.g:1926:1: (lv_name_1_0= RULE_STRING )
            // InternalInstance.g:1927:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_44); 

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

            // InternalInstance.g:1943:2: ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=72 && LA39_0<=73)) ) {
                alt39=1;
            }
            else if ( (LA39_0==RULE_ID) ) {
                int LA39_2 = input.LA(2);

                if ( (LA39_2==EOF||LA39_2==RULE_ID||(LA39_2>=17 && LA39_2<=18)||LA39_2==20||LA39_2==23||LA39_2==25||(LA39_2>=29 && LA39_2<=30)||(LA39_2>=32 && LA39_2<=34)||LA39_2==37||LA39_2==41||(LA39_2>=52 && LA39_2<=59)||(LA39_2>=61 && LA39_2<=68)||LA39_2==70) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalInstance.g:1943:3: ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    {
                    // InternalInstance.g:1943:3: ( ( ruleInstanceRef ) )
                    // InternalInstance.g:1944:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1944:1: ( ruleInstanceRef )
                    // InternalInstance.g:1945:3: ruleInstanceRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_45);
                    ruleInstanceRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:1958:2: (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==23) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // InternalInstance.g:1958:4: otherlv_3= ',' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_18); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalInstance.g:1962:1: ( ( ruleInstanceRef ) )
                    	    // InternalInstance.g:1963:1: ( ruleInstanceRef )
                    	    {
                    	    // InternalInstance.g:1963:1: ( ruleInstanceRef )
                    	    // InternalInstance.g:1964:3: ruleInstanceRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_45);
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
    // InternalInstance.g:1985:1: entryRulePropertyAssociationInstance returns [EObject current=null] : iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF ;
    public final EObject entryRulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociationInstance = null;


        try {
            // InternalInstance.g:1986:2: (iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF )
            // InternalInstance.g:1987:2: iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF
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
    // InternalInstance.g:1994:1: rulePropertyAssociationInstance returns [EObject current=null] : ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) ;
    public final EObject rulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedValue_2_0 = null;

        EObject lv_ownedValue_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:1997:28: ( ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) )
            // InternalInstance.g:1998:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            {
            // InternalInstance.g:1998:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            // InternalInstance.g:1998:2: ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) )
            {
            // InternalInstance.g:1998:2: ( ( ruleQPREF ) )
            // InternalInstance.g:1999:1: ( ruleQPREF )
            {
            // InternalInstance.g:1999:1: ( ruleQPREF )
            // InternalInstance.g:2000:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPropertyAssociationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_46);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_47); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationInstanceAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // InternalInstance.g:2017:1: ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) )
            // InternalInstance.g:2018:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            {
            // InternalInstance.g:2018:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            // InternalInstance.g:2019:3: lv_ownedValue_2_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_48);
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

            // InternalInstance.g:2035:2: (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==23) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalInstance.g:2035:4: otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_47); 

            	        	newLeafNode(otherlv_3, grammarAccess.getPropertyAssociationInstanceAccess().getCommaKeyword_3_0());
            	        
            	    // InternalInstance.g:2039:1: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    // InternalInstance.g:2040:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalInstance.g:2040:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    // InternalInstance.g:2041:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPropertyAssociationInstanceAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_48);
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
            	    break loop40;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_5, grammarAccess.getPropertyAssociationInstanceAccess().getColonKeyword_4());
                
            // InternalInstance.g:2061:1: ( ( rulePropertyAssociationRef ) )
            // InternalInstance.g:2062:1: ( rulePropertyAssociationRef )
            {
            // InternalInstance.g:2062:1: ( rulePropertyAssociationRef )
            // InternalInstance.g:2063:3: rulePropertyAssociationRef
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
    // InternalInstance.g:2084:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalInstance.g:2085:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalInstance.g:2086:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalInstance.g:2093:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? ) ;
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
            // InternalInstance.g:2096:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? ) )
            // InternalInstance.g:2097:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? )
            {
            // InternalInstance.g:2097:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )? )
            // InternalInstance.g:2097:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )?
            {
            // InternalInstance.g:2097:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalInstance.g:2098:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalInstance.g:2098:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalInstance.g:2099:3: lv_ownedValue_0_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getOwnedValuePropertyExpressionParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_49);
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

            // InternalInstance.g:2115:2: (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==20) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==21) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalInstance.g:2115:4: otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( ( ruleSomRef ) ) (otherlv_5= ',' ( ( ruleSomRef ) ) )* otherlv_7= ')'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,22,FOLLOW_21); 

                        	newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
                        
                    // InternalInstance.g:2127:1: ( ( ruleSomRef ) )
                    // InternalInstance.g:2128:1: ( ruleSomRef )
                    {
                    // InternalInstance.g:2128:1: ( ruleSomRef )
                    // InternalInstance.g:2129:3: ruleSomRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_15);
                    ruleSomRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:2142:2: (otherlv_5= ',' ( ( ruleSomRef ) ) )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==23) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // InternalInstance.g:2142:4: otherlv_5= ',' ( ( ruleSomRef ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_21); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // InternalInstance.g:2146:1: ( ( ruleSomRef ) )
                    	    // InternalInstance.g:2147:1: ( ruleSomRef )
                    	    {
                    	    // InternalInstance.g:2147:1: ( ruleSomRef )
                    	    // InternalInstance.g:2148:3: ruleSomRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_15);
                    	    ruleSomRef();

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
    // InternalInstance.g:2173:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalInstance.g:2174:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalInstance.g:2175:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalInstance.g:2182:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) ;
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
            // InternalInstance.g:2185:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) )
            // InternalInstance.g:2186:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            {
            // InternalInstance.g:2186:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            int alt43=12;
            alt43 = dfa43.predict(input);
            switch (alt43) {
                case 1 :
                    // InternalInstance.g:2187:5: this_RecordTerm_0= ruleRecordTerm
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
                    // InternalInstance.g:2197:5: this_ReferenceTerm_1= ruleReferenceTerm
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
                    // InternalInstance.g:2207:5: this_InstanceReferenceValue_2= ruleInstanceReferenceValue
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
                    // InternalInstance.g:2217:5: this_ComponentClassifierTerm_3= ruleComponentClassifierTerm
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
                    // InternalInstance.g:2227:5: this_ComputedTerm_4= ruleComputedTerm
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
                    // InternalInstance.g:2237:5: this_StringTerm_5= ruleStringTerm
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
                    // InternalInstance.g:2247:5: this_NumericRangeTerm_6= ruleNumericRangeTerm
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
                    // InternalInstance.g:2257:5: this_RealTerm_7= ruleRealTerm
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
                    // InternalInstance.g:2267:5: this_IntegerTerm_8= ruleIntegerTerm
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
                    // InternalInstance.g:2277:5: this_ListTerm_9= ruleListTerm
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
                    // InternalInstance.g:2287:5: this_BooleanLiteral_10= ruleBooleanLiteral
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
                    // InternalInstance.g:2297:5: this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm
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
    // InternalInstance.g:2313:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalInstance.g:2314:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalInstance.g:2315:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalInstance.g:2322:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:2325:28: ( ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalInstance.g:2326:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalInstance.g:2326:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalInstance.g:2326:2: ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalInstance.g:2326:2: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:2327:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:2327:1: ( ruleDeclarativeRef )
            // InternalInstance.g:2328:3: ruleDeclarativeRef
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainmentPathElementRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getNamedElementNamedElementCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_50);
            ruleDeclarativeRef();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:2341:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==18) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalInstance.g:2342:1: (lv_arrayRange_1_0= ruleArrayRange )
                    {
                    // InternalInstance.g:2342:1: (lv_arrayRange_1_0= ruleArrayRange )
                    // InternalInstance.g:2343:3: lv_arrayRange_1_0= ruleArrayRange
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainmentPathElementAccess().getArrayRangeArrayRangeParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_51);
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

            // InternalInstance.g:2359:3: (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==39) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalInstance.g:2359:5: otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getSolidusKeyword_2_0());
                        
                    // InternalInstance.g:2363:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalInstance.g:2364:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalInstance.g:2364:1: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalInstance.g:2365:3: lv_path_3_0= ruleContainmentPathElement
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
    // InternalInstance.g:2389:1: entryRuleInstanceReferenceValue returns [EObject current=null] : iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF ;
    public final EObject entryRuleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceReferenceValue = null;


        try {
            // InternalInstance.g:2390:2: (iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF )
            // InternalInstance.g:2391:2: iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF
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
    // InternalInstance.g:2398:1: ruleInstanceReferenceValue returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) ;
    public final EObject ruleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2401:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) )
            // InternalInstance.g:2402:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:2402:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            // InternalInstance.g:2402:3: otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getInstanceReferenceValueAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_18); 

                	newLeafNode(otherlv_1, grammarAccess.getInstanceReferenceValueAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:2410:1: ( ( ruleInstanceRef ) )
            // InternalInstance.g:2411:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:2411:1: ( ruleInstanceRef )
            // InternalInstance.g:2412:3: ruleInstanceRef
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
    // InternalInstance.g:2437:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // InternalInstance.g:2438:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // InternalInstance.g:2439:2: iv_ruleDirectionType= ruleDirectionType EOF
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
    // InternalInstance.g:2446:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2449:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // InternalInstance.g:2450:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // InternalInstance.g:2450:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt46=3;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==20) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==41) ) {
                    alt46=3;
                }
                else if ( (LA46_1==EOF||(LA46_1>=42 && LA46_1<=51)) ) {
                    alt46=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA46_0==41) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalInstance.g:2451:2: kw= 'in'
                    {
                    kw=(Token)match(input,20,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2458:2: kw= 'out'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2464:6: (kw= 'in' kw= 'out' )
                    {
                    // InternalInstance.g:2464:6: (kw= 'in' kw= 'out' )
                    // InternalInstance.g:2465:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,20,FOLLOW_52); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,41,FOLLOW_2); 

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
    // InternalInstance.g:2484:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // InternalInstance.g:2485:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // InternalInstance.g:2486:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
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
    // InternalInstance.g:2493:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2496:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // InternalInstance.g:2497:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // InternalInstance.g:2497:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            int alt47=10;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt47=1;
                }
                break;
            case 43:
                {
                alt47=2;
                }
                break;
            case 44:
                {
                alt47=3;
                }
                break;
            case 45:
                {
                alt47=4;
                }
                break;
            case 46:
                {
                alt47=5;
                }
                break;
            case 47:
                {
                alt47=6;
                }
                break;
            case 48:
                {
                alt47=7;
                }
                break;
            case 49:
                {
                alt47=8;
                }
                break;
            case 50:
                {
                alt47=9;
                }
                break;
            case 51:
                {
                alt47=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalInstance.g:2498:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2505:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2512:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2519:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2526:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalInstance.g:2533:2: kw= 'dataAccess'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalInstance.g:2540:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalInstance.g:2547:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalInstance.g:2554:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalInstance.g:2561:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

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
    // InternalInstance.g:2574:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // InternalInstance.g:2575:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // InternalInstance.g:2576:2: iv_ruleComponentCategory= ruleComponentCategory EOF
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
    // InternalInstance.g:2583:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2586:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // InternalInstance.g:2587:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // InternalInstance.g:2587:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt48=14;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // InternalInstance.g:2588:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2595:2: kw= 'bus'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2602:2: kw= 'data'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2609:2: kw= 'device'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2616:2: kw= 'memory'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalInstance.g:2623:2: kw= 'process'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalInstance.g:2630:2: kw= 'processor'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalInstance.g:2637:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalInstance.g:2643:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // InternalInstance.g:2643:6: (kw= 'subprogram' kw= 'group' )
                    // InternalInstance.g:2644:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,59,FOLLOW_53); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,60,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalInstance.g:2657:2: kw= 'system'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalInstance.g:2663:6: (kw= 'thread' kw= 'group' )
                    {
                    // InternalInstance.g:2663:6: (kw= 'thread' kw= 'group' )
                    // InternalInstance.g:2664:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,62,FOLLOW_53); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,60,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // InternalInstance.g:2677:2: kw= 'thread'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // InternalInstance.g:2683:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // InternalInstance.g:2683:6: (kw= 'virtual' kw= 'bus' )
                    // InternalInstance.g:2684:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,63,FOLLOW_54); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,53,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // InternalInstance.g:2696:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // InternalInstance.g:2696:6: (kw= 'virtual' kw= 'processor' )
                    // InternalInstance.g:2697:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,63,FOLLOW_55); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,58,FOLLOW_2); 

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
    // InternalInstance.g:2716:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // InternalInstance.g:2717:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // InternalInstance.g:2718:2: iv_ruleConnectionKind= ruleConnectionKind EOF
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
    // InternalInstance.g:2725:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2728:28: ( (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) )
            // InternalInstance.g:2729:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            {
            // InternalInstance.g:2729:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            int alt49=5;
            switch ( input.LA(1) ) {
            case 64:
                {
                alt49=1;
                }
                break;
            case 65:
                {
                alt49=2;
                }
                break;
            case 66:
                {
                alt49=3;
                }
                break;
            case 67:
                {
                alt49=4;
                }
                break;
            case 68:
                {
                alt49=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // InternalInstance.g:2730:2: kw= 'featureConnection'
                    {
                    kw=(Token)match(input,64,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2737:2: kw= 'accessConnection'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2744:2: kw= 'parameterConnection'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2751:2: kw= 'portConnection'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2758:2: kw= 'featureGroupConnection'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

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
    // InternalInstance.g:2771:1: entryRuleClassifierRef returns [String current=null] : iv_ruleClassifierRef= ruleClassifierRef EOF ;
    public final String entryRuleClassifierRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleClassifierRef = null;


        try {
            // InternalInstance.g:2772:2: (iv_ruleClassifierRef= ruleClassifierRef EOF )
            // InternalInstance.g:2773:2: iv_ruleClassifierRef= ruleClassifierRef EOF
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
    // InternalInstance.g:2780:1: ruleClassifierRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleClassifierRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2783:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalInstance.g:2784:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalInstance.g:2784:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // InternalInstance.g:2784:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // InternalInstance.g:2784:2: (this_ID_0= RULE_ID kw= '::' )+
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
            	    // InternalInstance.g:2784:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getClassifierRefAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_57); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:2804:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==70) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalInstance.g:2805:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_3); 

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
    // InternalInstance.g:2825:1: entryRuleImplRef returns [String current=null] : iv_ruleImplRef= ruleImplRef EOF ;
    public final String entryRuleImplRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplRef = null;


        try {
            // InternalInstance.g:2826:2: (iv_ruleImplRef= ruleImplRef EOF )
            // InternalInstance.g:2827:2: iv_ruleImplRef= ruleImplRef EOF
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
    // InternalInstance.g:2834:1: ruleImplRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleImplRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2837:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // InternalInstance.g:2838:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // InternalInstance.g:2838:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // InternalInstance.g:2838:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // InternalInstance.g:2838:2: (this_ID_0= RULE_ID kw= '::' )+
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
            	    // InternalInstance.g:2838:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getImplRefAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_58); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,70,FOLLOW_3); 

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
    // InternalInstance.g:2879:1: entryRuleDeclarativeRef returns [String current=null] : iv_ruleDeclarativeRef= ruleDeclarativeRef EOF ;
    public final String entryRuleDeclarativeRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeclarativeRef = null;


        try {
            // InternalInstance.g:2880:2: (iv_ruleDeclarativeRef= ruleDeclarativeRef EOF )
            // InternalInstance.g:2881:2: iv_ruleDeclarativeRef= ruleDeclarativeRef EOF
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
    // InternalInstance.g:2888:1: ruleDeclarativeRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) ;
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
            // InternalInstance.g:2891:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) )
            // InternalInstance.g:2892:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            {
            // InternalInstance.g:2892:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            // InternalInstance.g:2892:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            {
            // InternalInstance.g:2892:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    int LA53_1 = input.LA(2);

                    if ( (LA53_1==69) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalInstance.g:2892:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_59); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:2912:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==70) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalInstance.g:2913:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_3); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_4); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_60); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonKeyword_3()); 
                
            // InternalInstance.g:2931:1: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==36) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_ID) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalInstance.g:2931:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    {
                    // InternalInstance.g:2931:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    // InternalInstance.g:2932:2: kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                    {
                    kw=(Token)match(input,36,FOLLOW_61); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getTransitionKeyword_4_0_0()); 
                        
                    kw=(Token)match(input,71,FOLLOW_9); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getNumberSignKeyword_4_0_1()); 
                        
                    this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

                    		current.merge(this_INTEGER_LIT_8);
                        
                     
                        newLeafNode(this_INTEGER_LIT_8, grammarAccess.getDeclarativeRefAccess().getINTEGER_LITTerminalRuleCall_4_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalInstance.g:2951:10: this_ID_9= RULE_ID
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
    // InternalInstance.g:2966:1: entryRuleInstanceRef returns [String current=null] : iv_ruleInstanceRef= ruleInstanceRef EOF ;
    public final String entryRuleInstanceRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInstanceRef = null;


        try {
            // InternalInstance.g:2967:2: (iv_ruleInstanceRef= ruleInstanceRef EOF )
            // InternalInstance.g:2968:2: iv_ruleInstanceRef= ruleInstanceRef EOF
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
    // InternalInstance.g:2975:1: ruleInstanceRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) ;
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
            // InternalInstance.g:2978:28: ( (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) )
            // InternalInstance.g:2979:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            {
            // InternalInstance.g:2979:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==72) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_ID||LA60_0==73) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalInstance.g:2980:2: kw= 'parent'
                    {
                    kw=(Token)match(input,72,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getParentKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2986:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    {
                    // InternalInstance.g:2986:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    // InternalInstance.g:2986:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    {
                    // InternalInstance.g:2986:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*
                    loop57:
                    do {
                        int alt57=2;
                        alt57 = dfa57.predict(input);
                        switch (alt57) {
                    	case 1 :
                    	    // InternalInstance.g:2986:12: this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.'
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_62); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_0_0()); 
                    	        
                    	    // InternalInstance.g:2993:1: (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )*
                    	    loop56:
                    	    do {
                    	        int alt56=2;
                    	        int LA56_0 = input.LA(1);

                    	        if ( (LA56_0==18) ) {
                    	            alt56=1;
                    	        }


                    	        switch (alt56) {
                    	    	case 1 :
                    	    	    // InternalInstance.g:2994:2: kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']'
                    	    	    {
                    	    	    kw=(Token)match(input,18,FOLLOW_9); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_0_1_0()); 
                    	    	        
                    	    	    this_INTEGER_LIT_3=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_10); 

                    	    	    		current.merge(this_INTEGER_LIT_3);
                    	    	        
                    	    	     
                    	    	        newLeafNode(this_INTEGER_LIT_3, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_0_1_1()); 
                    	    	        
                    	    	    kw=(Token)match(input,19,FOLLOW_62); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_0_1_2()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop56;
                    	        }
                    	    } while (true);

                    	    kw=(Token)match(input,70,FOLLOW_63); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);

                    // InternalInstance.g:3018:3: ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==73) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==RULE_ID) ) {
                        alt59=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalInstance.g:3018:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            {
                            // InternalInstance.g:3018:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            // InternalInstance.g:3019:2: kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,73,FOLLOW_61); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getConnectionKeyword_1_1_0_0()); 
                                
                            kw=(Token)match(input,71,FOLLOW_9); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getNumberSignKeyword_1_1_0_1()); 
                                
                            this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

                            		current.merge(this_INTEGER_LIT_8);
                                
                             
                                newLeafNode(this_INTEGER_LIT_8, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_0_2()); 
                                

                            }


                            }
                            break;
                        case 2 :
                            // InternalInstance.g:3038:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            {
                            // InternalInstance.g:3038:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            // InternalInstance.g:3038:11: this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            {
                            this_ID_9=(Token)match(input,RULE_ID,FOLLOW_64); 

                            		current.merge(this_ID_9);
                                
                             
                                newLeafNode(this_ID_9, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_1_1_0()); 
                                
                            // InternalInstance.g:3045:1: (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            loop58:
                            do {
                                int alt58=2;
                                int LA58_0 = input.LA(1);

                                if ( (LA58_0==18) ) {
                                    alt58=1;
                                }


                                switch (alt58) {
                            	case 1 :
                            	    // InternalInstance.g:3046:2: kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']'
                            	    {
                            	    kw=(Token)match(input,18,FOLLOW_9); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getLeftSquareBracketKeyword_1_1_1_1_0()); 
                            	        
                            	    this_INTEGER_LIT_11=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_10); 

                            	    		current.merge(this_INTEGER_LIT_11);
                            	        
                            	     
                            	        newLeafNode(this_INTEGER_LIT_11, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_1_1_1()); 
                            	        
                            	    kw=(Token)match(input,19,FOLLOW_64); 

                            	            current.merge(kw);
                            	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getRightSquareBracketKeyword_1_1_1_1_2()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop58;
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
    // InternalInstance.g:3072:1: entryRuleSomRef returns [String current=null] : iv_ruleSomRef= ruleSomRef EOF ;
    public final String entryRuleSomRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSomRef = null;


        try {
            // InternalInstance.g:3073:2: (iv_ruleSomRef= ruleSomRef EOF )
            // InternalInstance.g:3074:2: iv_ruleSomRef= ruleSomRef EOF
            {
             newCompositeNode(grammarAccess.getSomRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSomRef=ruleSomRef();

            state._fsp--;

             current =iv_ruleSomRef.getText(); 
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
    // $ANTLR end "entryRuleSomRef"


    // $ANTLR start "ruleSomRef"
    // InternalInstance.g:3081:1: ruleSomRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSomRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3084:28: ( (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalInstance.g:3085:1: (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:3085:1: (kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalInstance.g:3086:2: kw= 'som' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            kw=(Token)match(input,37,FOLLOW_61); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSomRefAccess().getSomKeyword_0()); 
                
            kw=(Token)match(input,71,FOLLOW_9); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSomRefAccess().getNumberSignKeyword_1()); 
                
            this_INTEGER_LIT_2=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

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
    // InternalInstance.g:3112:1: entryRuleTransitionRef returns [String current=null] : iv_ruleTransitionRef= ruleTransitionRef EOF ;
    public final String entryRuleTransitionRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTransitionRef = null;


        try {
            // InternalInstance.g:3113:2: (iv_ruleTransitionRef= ruleTransitionRef EOF )
            // InternalInstance.g:3114:2: iv_ruleTransitionRef= ruleTransitionRef EOF
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
    // InternalInstance.g:3121:1: ruleTransitionRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleTransitionRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3124:28: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalInstance.g:3125:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:3125:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalInstance.g:3126:2: kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            kw=(Token)match(input,36,FOLLOW_61); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTransitionRefAccess().getTransitionKeyword_0()); 
                
            kw=(Token)match(input,71,FOLLOW_9); 

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


    // $ANTLR start "entryRuleModeTransitionName"
    // InternalInstance.g:3152:1: entryRuleModeTransitionName returns [String current=null] : iv_ruleModeTransitionName= ruleModeTransitionName EOF ;
    public final String entryRuleModeTransitionName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModeTransitionName = null;


        try {
            // InternalInstance.g:3153:2: (iv_ruleModeTransitionName= ruleModeTransitionName EOF )
            // InternalInstance.g:3154:2: iv_ruleModeTransitionName= ruleModeTransitionName EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModeTransitionName=ruleModeTransitionName();

            state._fsp--;

             current =iv_ruleModeTransitionName.getText(); 
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
    // $ANTLR end "entryRuleModeTransitionName"


    // $ANTLR start "ruleModeTransitionName"
    // InternalInstance.g:3161:1: ruleModeTransitionName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModeTransitionName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3164:28: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // InternalInstance.g:3165:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // InternalInstance.g:3165:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // InternalInstance.g:3165:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_58); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,70,FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getModeTransitionNameAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_58); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_2()); 
                
            kw=(Token)match(input,70,FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getModeTransitionNameAccess().getFullStopKeyword_3()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalInstance.g:3206:1: entryRulePropertyAssociationRef returns [String current=null] : iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF ;
    public final String entryRulePropertyAssociationRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePropertyAssociationRef = null;


        try {
            // InternalInstance.g:3207:2: (iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF )
            // InternalInstance.g:3208:2: iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF
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
    // InternalInstance.g:3215:1: rulePropertyAssociationRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) ;
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
            // InternalInstance.g:3218:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) )
            // InternalInstance.g:3219:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:3219:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            // InternalInstance.g:3219:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT
            {
            // InternalInstance.g:3219:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt61=0;
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_ID) ) {
                    int LA61_1 = input.LA(2);

                    if ( (LA61_1==69) ) {
                        alt61=1;
                    }


                }


                switch (alt61) {
            	case 1 :
            	    // InternalInstance.g:3219:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt61 >= 1 ) break loop61;
                        EarlyExitException eee =
                            new EarlyExitException(61, input);
                        throw eee;
                }
                cnt61++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_59); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:3239:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==70) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalInstance.g:3240:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_3); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_4); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,15,FOLLOW_65); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_3()); 
                
            // InternalInstance.g:3258:1: ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==RULE_ID||LA64_0==36) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalInstance.g:3258:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':'
                    {
                    // InternalInstance.g:3258:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) )
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==RULE_ID) ) {
                        alt63=1;
                    }
                    else if ( (LA63_0==36) ) {
                        alt63=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalInstance.g:3258:7: this_ID_6= RULE_ID
                            {
                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_4); 

                            		current.merge(this_ID_6);
                                
                             
                                newLeafNode(this_ID_6, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalInstance.g:3266:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            {
                            // InternalInstance.g:3266:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            // InternalInstance.g:3267:2: kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,36,FOLLOW_61); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getTransitionKeyword_4_0_1_0()); 
                                
                            kw=(Token)match(input,71,FOLLOW_9); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getNumberSignKeyword_4_0_1_1()); 
                                
                            this_INTEGER_LIT_9=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_4); 

                            		current.merge(this_INTEGER_LIT_9);
                                
                             
                                newLeafNode(this_INTEGER_LIT_9, grammarAccess.getPropertyAssociationRefAccess().getINTEGER_LITTerminalRuleCall_4_0_1_2()); 
                                

                            }


                            }
                            break;

                    }

                    kw=(Token)match(input,15,FOLLOW_66); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonKeyword_4_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,74,FOLLOW_61); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getPropertyKeyword_5()); 
                
            kw=(Token)match(input,71,FOLLOW_9); 

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
    // InternalInstance.g:3318:1: entryRuleLong returns [String current=null] : iv_ruleLong= ruleLong EOF ;
    public final String entryRuleLong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLong = null;


        try {
            // InternalInstance.g:3319:2: (iv_ruleLong= ruleLong EOF )
            // InternalInstance.g:3320:2: iv_ruleLong= ruleLong EOF
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
    // InternalInstance.g:3327:1: ruleLong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleLong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3330:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalInstance.g:3331:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalInstance.g:3348:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalInstance.g:3349:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalInstance.g:3350:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalInstance.g:3357:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' ) ;
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
            // InternalInstance.g:3360:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' ) )
            // InternalInstance.g:3361:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' )
            {
            // InternalInstance.g:3361:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';' )
            // InternalInstance.g:3361:2: ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )? (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )? otherlv_17= ';'
            {
            // InternalInstance.g:3361:2: ( ( ruleQPREF ) )
            // InternalInstance.g:3362:1: ( ruleQPREF )
            {
            // InternalInstance.g:3362:1: ( ruleQPREF )
            // InternalInstance.g:3363:3: ruleQPREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getPropertyPropertyCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_67);
            ruleQPREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalInstance.g:3376:2: (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) )
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==38) ) {
                alt65=1;
            }
            else if ( (LA65_0==75) ) {
                alt65=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }
            switch (alt65) {
                case 1 :
                    // InternalInstance.g:3376:4: otherlv_1= '=>'
                    {
                    otherlv_1=(Token)match(input,38,FOLLOW_68); 

                        	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:3381:6: ( (lv_append_2_0= '+=>' ) )
                    {
                    // InternalInstance.g:3381:6: ( (lv_append_2_0= '+=>' ) )
                    // InternalInstance.g:3382:1: (lv_append_2_0= '+=>' )
                    {
                    // InternalInstance.g:3382:1: (lv_append_2_0= '+=>' )
                    // InternalInstance.g:3383:3: lv_append_2_0= '+=>'
                    {
                    lv_append_2_0=(Token)match(input,75,FOLLOW_68); 

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

            // InternalInstance.g:3396:3: ( (lv_constant_3_0= 'constant' ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==76) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalInstance.g:3397:1: (lv_constant_3_0= 'constant' )
                    {
                    // InternalInstance.g:3397:1: (lv_constant_3_0= 'constant' )
                    // InternalInstance.g:3398:3: lv_constant_3_0= 'constant'
                    {
                    lv_constant_3_0=(Token)match(input,76,FOLLOW_47); 

                            newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "constant", true, "constant");
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:3411:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalInstance.g:3411:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalInstance.g:3411:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalInstance.g:3412:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalInstance.g:3412:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalInstance.g:3413:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
            {
             
            	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_0_0()); 
            	    
            pushFollow(FOLLOW_69);
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

            // InternalInstance.g:3429:2: (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==23) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalInstance.g:3429:4: otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_47); 

            	        	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	        
            	    // InternalInstance.g:3433:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalInstance.g:3434:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalInstance.g:3434:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalInstance.g:3435:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getOwnedValueOptionalModalPropertyValueParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_69);
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
            	    break loop67;
                }
            } while (true);


            }

            // InternalInstance.g:3451:5: (otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )* )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==77) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalInstance.g:3451:7: otherlv_7= 'applies' otherlv_8= 'to' ( (lv_appliesTo_9_0= ruleContainmentPath ) ) (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    {
                    otherlv_7=(Token)match(input,77,FOLLOW_33); 

                        	newLeafNode(otherlv_7, grammarAccess.getContainedPropertyAssociationAccess().getAppliesKeyword_4_0());
                        
                    otherlv_8=(Token)match(input,31,FOLLOW_3); 

                        	newLeafNode(otherlv_8, grammarAccess.getContainedPropertyAssociationAccess().getToKeyword_4_1());
                        
                    // InternalInstance.g:3459:1: ( (lv_appliesTo_9_0= ruleContainmentPath ) )
                    // InternalInstance.g:3460:1: (lv_appliesTo_9_0= ruleContainmentPath )
                    {
                    // InternalInstance.g:3460:1: (lv_appliesTo_9_0= ruleContainmentPath )
                    // InternalInstance.g:3461:3: lv_appliesTo_9_0= ruleContainmentPath
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_70);
                    lv_appliesTo_9_0=ruleContainmentPath();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		add(
                           			current, 
                           			"appliesTo",
                            		lv_appliesTo_9_0, 
                            		"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // InternalInstance.g:3477:2: (otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) ) )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==23) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // InternalInstance.g:3477:4: otherlv_10= ',' ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_10=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // InternalInstance.g:3481:1: ( (lv_appliesTo_11_0= ruleContainmentPath ) )
                    	    // InternalInstance.g:3482:1: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    {
                    	    // InternalInstance.g:3482:1: (lv_appliesTo_11_0= ruleContainmentPath )
                    	    // InternalInstance.g:3483:3: lv_appliesTo_11_0= ruleContainmentPath
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_70);
                    	    lv_appliesTo_11_0=ruleContainmentPath();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getContainedPropertyAssociationRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"appliesTo",
                    	            		lv_appliesTo_11_0, 
                    	            		"org.osate.xtext.aadl2.properties.Properties.ContainmentPath");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalInstance.g:3499:6: (otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==20) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalInstance.g:3499:8: otherlv_12= 'in' otherlv_13= 'binding' otherlv_14= '(' ( ( ruleQCREF ) ) otherlv_16= ')'
                    {
                    otherlv_12=(Token)match(input,20,FOLLOW_71); 

                        	newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getInKeyword_5_0());
                        
                    otherlv_13=(Token)match(input,78,FOLLOW_14); 

                        	newLeafNode(otherlv_13, grammarAccess.getContainedPropertyAssociationAccess().getBindingKeyword_5_1());
                        
                    otherlv_14=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_2());
                        
                    // InternalInstance.g:3511:1: ( ( ruleQCREF ) )
                    // InternalInstance.g:3512:1: ( ruleQCREF )
                    {
                    // InternalInstance.g:3512:1: ( ruleQCREF )
                    // InternalInstance.g:3513:3: ruleQCREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingClassifierCrossReference_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_30);
                    ruleQCREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_16=(Token)match(input,24,FOLLOW_72); 

                        	newLeafNode(otherlv_16, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_17=(Token)match(input,79,FOLLOW_2); 

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
    // InternalInstance.g:3546:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalInstance.g:3547:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalInstance.g:3548:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalInstance.g:3555:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3558:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalInstance.g:3559:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalInstance.g:3559:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalInstance.g:3560:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalInstance.g:3560:1: (lv_path_0_0= ruleContainmentPathElement )
            // InternalInstance.g:3561:3: lv_path_0_0= ruleContainmentPathElement
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
    // InternalInstance.g:3587:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalInstance.g:3588:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalInstance.g:3589:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalInstance.g:3596:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3599:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalInstance.g:3600:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalInstance.g:3600:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalInstance.g:3601:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalInstance.g:3601:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalInstance.g:3602:3: lv_ownedValue_0_0= rulePropertyExpression
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
    // InternalInstance.g:3626:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalInstance.g:3627:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalInstance.g:3628:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
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
    // InternalInstance.g:3635:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3638:28: ( ( ( ruleQPREF ) ) )
            // InternalInstance.g:3639:1: ( ( ruleQPREF ) )
            {
            // InternalInstance.g:3639:1: ( ( ruleQPREF ) )
            // InternalInstance.g:3640:1: ( ruleQPREF )
            {
            // InternalInstance.g:3640:1: ( ruleQPREF )
            // InternalInstance.g:3641:3: ruleQPREF
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
    // InternalInstance.g:3662:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalInstance.g:3663:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalInstance.g:3664:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalInstance.g:3671:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3674:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalInstance.g:3675:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalInstance.g:3675:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalInstance.g:3675:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalInstance.g:3675:2: ()
            // InternalInstance.g:3676:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalInstance.g:3681:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==80) ) {
                alt71=1;
            }
            else if ( (LA71_0==81) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalInstance.g:3681:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalInstance.g:3681:3: ( (lv_value_1_0= 'true' ) )
                    // InternalInstance.g:3682:1: (lv_value_1_0= 'true' )
                    {
                    // InternalInstance.g:3682:1: (lv_value_1_0= 'true' )
                    // InternalInstance.g:3683:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,80,FOLLOW_2); 

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
                    // InternalInstance.g:3697:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,81,FOLLOW_2); 

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
    // InternalInstance.g:3709:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalInstance.g:3710:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalInstance.g:3711:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalInstance.g:3718:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3721:28: ( ( ( ruleQPREF ) ) )
            // InternalInstance.g:3722:1: ( ( ruleQPREF ) )
            {
            // InternalInstance.g:3722:1: ( ( ruleQPREF ) )
            // InternalInstance.g:3723:1: ( ruleQPREF )
            {
            // InternalInstance.g:3723:1: ( ruleQPREF )
            // InternalInstance.g:3724:3: ruleQPREF
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
    // InternalInstance.g:3745:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalInstance.g:3746:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalInstance.g:3747:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
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
    // InternalInstance.g:3754:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3757:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3758:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3758:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            // InternalInstance.g:3758:3: otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3766:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalInstance.g:3767:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalInstance.g:3767:1: (lv_path_2_0= ruleContainmentPathElement )
            // InternalInstance.g:3768:3: lv_path_2_0= ruleContainmentPathElement
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
    // InternalInstance.g:3796:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalInstance.g:3797:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalInstance.g:3798:2: iv_ruleRecordTerm= ruleRecordTerm EOF
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
    // InternalInstance.g:3805:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3808:28: ( (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) )
            // InternalInstance.g:3809:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            {
            // InternalInstance.g:3809:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            // InternalInstance.g:3809:3: otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                
            // InternalInstance.g:3813:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt72=0;
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==RULE_ID) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalInstance.g:3814:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalInstance.g:3814:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalInstance.g:3815:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_73);
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
            	    if ( cnt72 >= 1 ) break loop72;
                        EarlyExitException eee =
                            new EarlyExitException(72, input);
                        throw eee;
                }
                cnt72++;
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
    // InternalInstance.g:3845:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalInstance.g:3846:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalInstance.g:3847:2: iv_ruleComputedTerm= ruleComputedTerm EOF
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
    // InternalInstance.g:3854:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3857:28: ( (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3858:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3858:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalInstance.g:3858:3: otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3866:1: ( (lv_function_2_0= RULE_ID ) )
            // InternalInstance.g:3867:1: (lv_function_2_0= RULE_ID )
            {
            // InternalInstance.g:3867:1: (lv_function_2_0= RULE_ID )
            // InternalInstance.g:3868:3: lv_function_2_0= RULE_ID
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
    // InternalInstance.g:3896:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalInstance.g:3897:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalInstance.g:3898:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
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
    // InternalInstance.g:3905:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3908:28: ( (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3909:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3909:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            // InternalInstance.g:3909:3: otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3917:1: ( ( ruleQCREF ) )
            // InternalInstance.g:3918:1: ( ruleQCREF )
            {
            // InternalInstance.g:3918:1: ( ruleQCREF )
            // InternalInstance.g:3919:3: ruleQCREF
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
    // InternalInstance.g:3944:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalInstance.g:3945:2: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalInstance.g:3946:2: iv_ruleListTerm= ruleListTerm EOF
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
    // InternalInstance.g:3953:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3956:28: ( ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalInstance.g:3957:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalInstance.g:3957:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            // InternalInstance.g:3957:2: () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalInstance.g:3957:2: ()
            // InternalInstance.g:3958:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListTermAccess().getListValueAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_74); 

                	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3967:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( ((LA74_0>=RULE_ID && LA74_0<=RULE_REAL_LIT)||LA74_0==18||LA74_0==22||LA74_0==40||(LA74_0>=80 && LA74_0<=85)) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalInstance.g:3967:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalInstance.g:3967:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalInstance.g:3968:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalInstance.g:3968:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalInstance.g:3969:3: lv_ownedListElement_2_0= rulePropertyExpression
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

                    // InternalInstance.g:3985:2: (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==23) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalInstance.g:3985:4: otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_47); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalInstance.g:3989:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalInstance.g:3990:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalInstance.g:3990:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalInstance.g:3991:3: lv_ownedListElement_4_0= rulePropertyExpression
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
                    	    break loop73;
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
    // InternalInstance.g:4019:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalInstance.g:4020:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalInstance.g:4021:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalInstance.g:4028:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4031:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) )
            // InternalInstance.g:4032:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            {
            // InternalInstance.g:4032:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            // InternalInstance.g:4032:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';'
            {
            // InternalInstance.g:4032:2: ( (otherlv_0= RULE_ID ) )
            // InternalInstance.g:4033:1: (otherlv_0= RULE_ID )
            {
            // InternalInstance.g:4033:1: (otherlv_0= RULE_ID )
            // InternalInstance.g:4034:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_46); 

            		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,38,FOLLOW_47); 

                	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // InternalInstance.g:4049:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalInstance.g:4050:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalInstance.g:4050:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalInstance.g:4051:3: lv_ownedValue_2_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_72);
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

            otherlv_3=(Token)match(input,79,FOLLOW_2); 

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
    // InternalInstance.g:4081:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalInstance.g:4082:2: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalInstance.g:4083:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalInstance.g:4090:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4093:28: ( (kw= '+' | kw= '-' ) )
            // InternalInstance.g:4094:1: (kw= '+' | kw= '-' )
            {
            // InternalInstance.g:4094:1: (kw= '+' | kw= '-' )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==84) ) {
                alt75=1;
            }
            else if ( (LA75_0==85) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalInstance.g:4095:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4102:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

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
    // InternalInstance.g:4115:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalInstance.g:4116:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalInstance.g:4117:2: iv_ruleStringTerm= ruleStringTerm EOF
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
    // InternalInstance.g:4124:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4127:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalInstance.g:4128:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalInstance.g:4128:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalInstance.g:4129:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalInstance.g:4129:1: (lv_value_0_0= ruleNoQuoteString )
            // InternalInstance.g:4130:3: lv_value_0_0= ruleNoQuoteString
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
    // InternalInstance.g:4154:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalInstance.g:4155:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalInstance.g:4156:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalInstance.g:4163:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4166:28: (this_STRING_0= RULE_STRING )
            // InternalInstance.g:4167:5: this_STRING_0= RULE_STRING
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
    // InternalInstance.g:4182:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalInstance.g:4183:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalInstance.g:4184:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalInstance.g:4191:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4194:28: ( ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) )
            // InternalInstance.g:4195:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            {
            // InternalInstance.g:4195:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            // InternalInstance.g:4195:2: () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']'
            {
            // InternalInstance.g:4195:2: ()
            // InternalInstance.g:4196:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                
            // InternalInstance.g:4205:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalInstance.g:4206:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalInstance.g:4206:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalInstance.g:4207:3: lv_lowerBound_2_0= ruleINTVALUE
            {
             
            	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_75);
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

            // InternalInstance.g:4223:2: (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==86) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalInstance.g:4223:4: otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,86,FOLLOW_9); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                        
                    // InternalInstance.g:4227:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalInstance.g:4228:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalInstance.g:4228:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalInstance.g:4229:3: lv_upperBound_4_0= ruleINTVALUE
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
    // InternalInstance.g:4257:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalInstance.g:4258:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalInstance.g:4259:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalInstance.g:4266:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4269:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalInstance.g:4270:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalInstance.g:4270:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalInstance.g:4270:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalInstance.g:4270:2: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalInstance.g:4271:1: (lv_op_0_0= rulePlusMinus )
            {
            // InternalInstance.g:4271:1: (lv_op_0_0= rulePlusMinus )
            // InternalInstance.g:4272:3: lv_op_0_0= rulePlusMinus
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_76);
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

            // InternalInstance.g:4288:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalInstance.g:4289:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalInstance.g:4289:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalInstance.g:4290:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalInstance.g:4314:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalInstance.g:4315:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalInstance.g:4316:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalInstance.g:4323:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4326:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalInstance.g:4327:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalInstance.g:4327:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalInstance.g:4327:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalInstance.g:4327:2: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalInstance.g:4328:1: (lv_value_0_0= ruleSignedInt )
            {
            // InternalInstance.g:4328:1: (lv_value_0_0= ruleSignedInt )
            // InternalInstance.g:4329:3: lv_value_0_0= ruleSignedInt
            {
             
            	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_77);
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

            // InternalInstance.g:4345:2: ( (otherlv_1= RULE_ID ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalInstance.g:4346:1: (otherlv_1= RULE_ID )
                    {
                    // InternalInstance.g:4346:1: (otherlv_1= RULE_ID )
                    // InternalInstance.g:4347:3: otherlv_1= RULE_ID
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
    // InternalInstance.g:4366:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalInstance.g:4367:2: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalInstance.g:4368:2: iv_ruleSignedInt= ruleSignedInt EOF
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
    // InternalInstance.g:4375:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4378:28: ( ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalInstance.g:4379:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:4379:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalInstance.g:4379:2: (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalInstance.g:4379:2: (kw= '+' | kw= '-' )?
            int alt78=3;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==84) ) {
                alt78=1;
            }
            else if ( (LA78_0==85) ) {
                alt78=2;
            }
            switch (alt78) {
                case 1 :
                    // InternalInstance.g:4380:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_9); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4387:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_9); 

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
    // InternalInstance.g:4407:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalInstance.g:4408:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalInstance.g:4409:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalInstance.g:4416:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4419:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalInstance.g:4420:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalInstance.g:4420:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalInstance.g:4420:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalInstance.g:4420:2: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalInstance.g:4421:1: (lv_value_0_0= ruleSignedReal )
            {
            // InternalInstance.g:4421:1: (lv_value_0_0= ruleSignedReal )
            // InternalInstance.g:4422:3: lv_value_0_0= ruleSignedReal
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_77);
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

            // InternalInstance.g:4438:2: ( (otherlv_1= RULE_ID ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_ID) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalInstance.g:4439:1: (otherlv_1= RULE_ID )
                    {
                    // InternalInstance.g:4439:1: (otherlv_1= RULE_ID )
                    // InternalInstance.g:4440:3: otherlv_1= RULE_ID
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
    // InternalInstance.g:4459:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalInstance.g:4460:2: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalInstance.g:4461:2: iv_ruleSignedReal= ruleSignedReal EOF
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
    // InternalInstance.g:4468:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4471:28: ( ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalInstance.g:4472:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalInstance.g:4472:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalInstance.g:4472:2: (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalInstance.g:4472:2: (kw= '+' | kw= '-' )?
            int alt80=3;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==84) ) {
                alt80=1;
            }
            else if ( (LA80_0==85) ) {
                alt80=2;
            }
            switch (alt80) {
                case 1 :
                    // InternalInstance.g:4473:2: kw= '+'
                    {
                    kw=(Token)match(input,84,FOLLOW_78); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4480:2: kw= '-'
                    {
                    kw=(Token)match(input,85,FOLLOW_78); 

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
    // InternalInstance.g:4500:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalInstance.g:4501:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalInstance.g:4502:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
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
    // InternalInstance.g:4509:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4512:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalInstance.g:4513:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalInstance.g:4513:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalInstance.g:4513:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalInstance.g:4513:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalInstance.g:4514:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalInstance.g:4514:1: (lv_minimum_0_0= ruleNumAlt )
            // InternalInstance.g:4515:3: lv_minimum_0_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_79);
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

            otherlv_1=(Token)match(input,86,FOLLOW_76); 

                	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                
            // InternalInstance.g:4535:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalInstance.g:4536:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalInstance.g:4536:1: (lv_maximum_2_0= ruleNumAlt )
            // InternalInstance.g:4537:3: lv_maximum_2_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_80);
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

            // InternalInstance.g:4553:2: (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==87) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalInstance.g:4553:4: otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,87,FOLLOW_76); 

                        	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                        
                    // InternalInstance.g:4557:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalInstance.g:4558:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalInstance.g:4558:1: (lv_delta_4_0= ruleNumAlt )
                    // InternalInstance.g:4559:3: lv_delta_4_0= ruleNumAlt
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
    // InternalInstance.g:4583:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalInstance.g:4584:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalInstance.g:4585:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalInstance.g:4592:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4595:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalInstance.g:4596:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalInstance.g:4596:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt82=4;
            switch ( input.LA(1) ) {
            case 84:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt82=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt82=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt82=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 1, input);

                    throw nvae;
                }

                }
                break;
            case 85:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt82=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt82=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt82=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt82=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt82=2;
                }
                break;
            case RULE_ID:
                {
                alt82=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // InternalInstance.g:4597:5: this_RealTerm_0= ruleRealTerm
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
                    // InternalInstance.g:4607:5: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalInstance.g:4617:5: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalInstance.g:4627:5: this_ConstantValue_3= ruleConstantValue
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


    // $ANTLR start "entryRuleINTVALUE"
    // InternalInstance.g:4643:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalInstance.g:4644:2: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalInstance.g:4645:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalInstance.g:4652:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4655:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalInstance.g:4656:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalInstance.g:4673:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalInstance.g:4674:2: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalInstance.g:4675:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalInstance.g:4682:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4685:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // InternalInstance.g:4686:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // InternalInstance.g:4686:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // InternalInstance.g:4686:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_81); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                
            // InternalInstance.g:4693:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==69) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalInstance.g:4694:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,69,FOLLOW_3); 

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
    // InternalInstance.g:4714:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalInstance.g:4715:2: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalInstance.g:4716:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalInstance.g:4723:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4726:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalInstance.g:4727:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalInstance.g:4727:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // InternalInstance.g:4727:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // InternalInstance.g:4727:2: (this_ID_0= RULE_ID kw= '::' )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==RULE_ID) ) {
                    int LA84_1 = input.LA(2);

                    if ( (LA84_1==69) ) {
                        alt84=1;
                    }


                }


                switch (alt84) {
            	case 1 :
            	    // InternalInstance.g:4727:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,69,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_57); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:4747:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==70) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalInstance.g:4748:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_3); 

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
    // InternalInstance.g:4768:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalInstance.g:4769:2: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalInstance.g:4770:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalInstance.g:4777:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '*' ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4780:28: (kw= '*' )
            // InternalInstance.g:4782:2: kw= '*'
            {
            kw=(Token)match(input,88,FOLLOW_2); 

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
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA57 dfa57 = new DFA57(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\4\7\uffff\1\4\3\uffff";
    static final String dfa_3s = "\1\104\7\uffff\1\44\3\uffff";
    static final String dfa_4s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\11\1\7";
    static final String dfa_5s = "\14\uffff}>";
    static final String[] dfa_6s = {
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
    static final String dfa_9s = "\1\104\7\uffff\1\44\2\uffff";
    static final String dfa_10s = "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\7";
    static final String dfa_11s = "\13\uffff}>";
    static final String[] dfa_12s = {
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
    static final String dfa_16s = "\1\125\1\uffff\1\26\3\uffff\2\7\3\126\2\uffff\1\111\1\uffff\1\126\1\uffff\1\126\1\uffff\1\4\2\uffff\1\106\1\126\1\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\5\uffff\1\12\1\13\1\uffff\1\7\1\uffff\1\10\1\uffff\1\11\1\uffff\1\14\1\3\2\uffff\1\2";
    static final String dfa_18s = "\31\uffff}>";
    static final String[] dfa_19s = {
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

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "2186:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )";
        }
    }
    static final String dfa_20s = "\22\uffff";
    static final String dfa_21s = "\10\uffff\1\15\1\uffff\1\17\7\uffff";
    static final String dfa_22s = "\1\64\7\uffff\1\4\1\uffff\1\4\1\65\6\uffff";
    static final String dfa_23s = "\1\77\7\uffff\1\74\1\uffff\1\74\1\72\6\uffff";
    static final String dfa_24s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\11\1\10\1\13\1\14\1\16\1\15";
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

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "2587:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String dfa_27s = "\7\uffff";
    static final String dfa_28s = "\2\uffff\1\1\3\uffff\1\1";
    static final String dfa_29s = "\1\4\1\uffff\1\4\1\6\1\uffff\1\23\1\4";
    static final String dfa_30s = "\1\111\1\uffff\1\111\1\6\1\uffff\1\23\1\111";
    static final String dfa_31s = "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String dfa_32s = "\7\uffff}>";
    static final String[] dfa_33s = {
            "\1\2\104\uffff\1\1",
            "",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\1\uffff\2\1\1\uffff\3\1\2\uffff\1\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1",
            "\1\5",
            "",
            "\1\6",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\1\uffff\2\1\1\uffff\3\1\2\uffff\1\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1"
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "()* loopback of 2986:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000001FL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000FFC0000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000148000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L,0x000000000000001FL});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000031FL});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0xEFF0022762120010L,0x000000000000031FL});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000001000010L,0x0000000000000300L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xEFF0022762100010L,0x000000000000001FL});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000108010L,0x0000000000000300L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000008108000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000300L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000008000040002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000040L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000001000000010L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000040L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000200L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000001000000010L,0x0000000000000400L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000004000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0xEFF00327625400F0L,0x00000000003F101FL});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000900000L,0x000000000000A000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000900000L,0x0000000000008000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0xEFF00327635400F0L,0x00000000003F001FL});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000080000L,0x0000000000400000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0xEFF00227621000D0L,0x000000000030001FL});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});

}