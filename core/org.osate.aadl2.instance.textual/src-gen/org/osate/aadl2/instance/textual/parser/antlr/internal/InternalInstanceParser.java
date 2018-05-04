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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INTEGER_LIT", "RULE_REAL_LIT", "RULE_SL_COMMENT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_BASED_INTEGER", "RULE_EXTENDED_DIGIT", "RULE_WS", "':'", "'{'", "'}'", "'['", "']'", "'in'", "'modes'", "'('", "','", "')'", "'complete'", "'<->'", "'->'", "'transitions'", "'reverse'", "'flow'", "'end'", "'to'", "'initial'", "'derived'", "'mode'", "'='", "'transition'", "'som'", "'=>'", "'/'", "'reference'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'dataAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'featureConnection'", "'accessConnection'", "'parameterConnection'", "'portConnection'", "'featureGroupConnection'", "'::'", "'.'", "'#'", "'parent'", "'connection'", "'property'", "'+=>'", "'constant'", "';'", "'true'", "'false'", "'compute'", "'classifier'", "'+'", "'-'", "'..'", "'delta'", "'applies'", "'binding'", "'*'"
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
    public static final int T__89=89;
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

                        if ( (LA3_0==20||LA3_0==42) ) {
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

                if ( (LA5_1==70) ) {
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

                if ( ((LA17_0>=73 && LA17_0<=74)) ) {
                    alt17=1;
                }
                else if ( (LA17_0==RULE_ID) ) {
                    int LA17_3 = input.LA(2);

                    if ( (LA17_3==39||LA17_3==70) ) {
                        alt17=2;
                    }
                    else if ( (LA17_3==18||LA17_3==27||LA17_3==71) ) {
                        alt17=1;
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

            if ( (LA19_0==RULE_ID||(LA19_0>=73 && LA19_0<=74)) ) {
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

            if ( (LA20_0==RULE_ID||(LA20_0>=73 && LA20_0<=74)) ) {
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

            if ( (LA28_0==RULE_ID||(LA28_0>=73 && LA28_0<=74)) ) {
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
    // InternalInstance.g:1802:1: ruleModeTransitionInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? ) ;
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
            // InternalInstance.g:1805:28: ( (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? ) )
            // InternalInstance.g:1806:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? )
            {
            // InternalInstance.g:1806:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )? )
            // InternalInstance.g:1806:3: otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleModeTransitionName ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleDeclarativeRef ) ) (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_22); 

                	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,37,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
                
            // InternalInstance.g:1814:1: ( (lv_name_2_0= ruleModeTransitionName ) )
            // InternalInstance.g:1815:1: (lv_name_2_0= ruleModeTransitionName )
            {
            // InternalInstance.g:1815:1: (lv_name_2_0= ruleModeTransitionName )
            // InternalInstance.g:1816:3: lv_name_2_0= ruleModeTransitionName
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

            // InternalInstance.g:1832:2: ( (otherlv_3= RULE_ID ) )
            // InternalInstance.g:1833:1: (otherlv_3= RULE_ID )
            {
            // InternalInstance.g:1833:1: (otherlv_3= RULE_ID )
            // InternalInstance.g:1834:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_25); 

            		newLeafNode(otherlv_3, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,27,FOLLOW_3); 

                	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // InternalInstance.g:1849:1: ( (otherlv_5= RULE_ID ) )
            // InternalInstance.g:1850:1: (otherlv_5= RULE_ID )
            {
            // InternalInstance.g:1850:1: (otherlv_5= RULE_ID )
            // InternalInstance.g:1851:3: otherlv_5= RULE_ID
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
                
            // InternalInstance.g:1866:1: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:1867:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:1867:1: ( ruleDeclarativeRef )
            // InternalInstance.g:1868:3: ruleDeclarativeRef
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

            // InternalInstance.g:1881:2: (otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==16) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalInstance.g:1881:4: otherlv_8= '{' ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) ) otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_32); 

                        	newLeafNode(otherlv_8, grammarAccess.getModeTransitionInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // InternalInstance.g:1885:1: ( (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance ) )
                    // InternalInstance.g:1886:1: (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance )
                    {
                    // InternalInstance.g:1886:1: (lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance )
                    // InternalInstance.g:1887:3: lv_ownedPropertyAssociation_9_0= rulePropertyAssociationInstance
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
    // InternalInstance.g:1915:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // InternalInstance.g:1916:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // InternalInstance.g:1917:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
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
    // InternalInstance.g:1924:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:1927:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? ) )
            // InternalInstance.g:1928:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            {
            // InternalInstance.g:1928:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )? )
            // InternalInstance.g:1928:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            {
            otherlv_0=(Token)match(input,38,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // InternalInstance.g:1932:1: ( (lv_name_1_0= RULE_STRING ) )
            // InternalInstance.g:1933:1: (lv_name_1_0= RULE_STRING )
            {
            // InternalInstance.g:1933:1: (lv_name_1_0= RULE_STRING )
            // InternalInstance.g:1934:3: lv_name_1_0= RULE_STRING
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

            // InternalInstance.g:1950:2: ( ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=73 && LA40_0<=74)) ) {
                alt40=1;
            }
            else if ( (LA40_0==RULE_ID) ) {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==EOF||LA40_2==RULE_ID||(LA40_2>=17 && LA40_2<=18)||LA40_2==20||LA40_2==23||LA40_2==25||(LA40_2>=30 && LA40_2<=31)||(LA40_2>=33 && LA40_2<=35)||LA40_2==38||LA40_2==42||(LA40_2>=53 && LA40_2<=60)||(LA40_2>=62 && LA40_2<=69)||LA40_2==71) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // InternalInstance.g:1950:3: ( ( ruleInstanceRef ) ) (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    {
                    // InternalInstance.g:1950:3: ( ( ruleInstanceRef ) )
                    // InternalInstance.g:1951:1: ( ruleInstanceRef )
                    {
                    // InternalInstance.g:1951:1: ( ruleInstanceRef )
                    // InternalInstance.g:1952:3: ruleInstanceRef
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

                    // InternalInstance.g:1965:2: (otherlv_3= ',' ( ( ruleInstanceRef ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==23) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalInstance.g:1965:4: otherlv_3= ',' ( ( ruleInstanceRef ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_18); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalInstance.g:1969:1: ( ( ruleInstanceRef ) )
                    	    // InternalInstance.g:1970:1: ( ruleInstanceRef )
                    	    {
                    	    // InternalInstance.g:1970:1: ( ruleInstanceRef )
                    	    // InternalInstance.g:1971:3: ruleInstanceRef
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
                    	    break loop39;
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
    // InternalInstance.g:1992:1: entryRulePropertyAssociationInstance returns [EObject current=null] : iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF ;
    public final EObject entryRulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAssociationInstance = null;


        try {
            // InternalInstance.g:1993:2: (iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF )
            // InternalInstance.g:1994:2: iv_rulePropertyAssociationInstance= rulePropertyAssociationInstance EOF
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
    // InternalInstance.g:2001:1: rulePropertyAssociationInstance returns [EObject current=null] : ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) ;
    public final EObject rulePropertyAssociationInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedValue_2_0 = null;

        EObject lv_ownedValue_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:2004:28: ( ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) ) )
            // InternalInstance.g:2005:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            {
            // InternalInstance.g:2005:1: ( ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) ) )
            // InternalInstance.g:2005:2: ( ( ruleQPREF ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) ) (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )* otherlv_5= ':' ( ( rulePropertyAssociationRef ) )
            {
            // InternalInstance.g:2005:2: ( ( ruleQPREF ) )
            // InternalInstance.g:2006:1: ( ruleQPREF )
            {
            // InternalInstance.g:2006:1: ( ruleQPREF )
            // InternalInstance.g:2007:3: ruleQPREF
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

            otherlv_1=(Token)match(input,39,FOLLOW_47); 

                	newLeafNode(otherlv_1, grammarAccess.getPropertyAssociationInstanceAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // InternalInstance.g:2024:1: ( (lv_ownedValue_2_0= ruleOptionalModalPropertyValue ) )
            // InternalInstance.g:2025:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            {
            // InternalInstance.g:2025:1: (lv_ownedValue_2_0= ruleOptionalModalPropertyValue )
            // InternalInstance.g:2026:3: lv_ownedValue_2_0= ruleOptionalModalPropertyValue
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

            // InternalInstance.g:2042:2: (otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==23) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalInstance.g:2042:4: otherlv_3= ',' ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_47); 

            	        	newLeafNode(otherlv_3, grammarAccess.getPropertyAssociationInstanceAccess().getCommaKeyword_3_0());
            	        
            	    // InternalInstance.g:2046:1: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            	    // InternalInstance.g:2047:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalInstance.g:2047:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            	    // InternalInstance.g:2048:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
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
            	    break loop41;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_3); 

                	newLeafNode(otherlv_5, grammarAccess.getPropertyAssociationInstanceAccess().getColonKeyword_4());
                
            // InternalInstance.g:2068:1: ( ( rulePropertyAssociationRef ) )
            // InternalInstance.g:2069:1: ( rulePropertyAssociationRef )
            {
            // InternalInstance.g:2069:1: ( rulePropertyAssociationRef )
            // InternalInstance.g:2070:3: rulePropertyAssociationRef
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
    // InternalInstance.g:2091:1: entryRuleOptionalModalPropertyValue returns [EObject current=null] : iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF ;
    public final EObject entryRuleOptionalModalPropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOptionalModalPropertyValue = null;


        try {
            // InternalInstance.g:2092:2: (iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF )
            // InternalInstance.g:2093:2: iv_ruleOptionalModalPropertyValue= ruleOptionalModalPropertyValue EOF
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
    // InternalInstance.g:2100:1: ruleOptionalModalPropertyValue returns [EObject current=null] : ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? ) ;
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
            // InternalInstance.g:2103:28: ( ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? ) )
            // InternalInstance.g:2104:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? )
            {
            // InternalInstance.g:2104:1: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )? )
            // InternalInstance.g:2104:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) ) (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )?
            {
            // InternalInstance.g:2104:2: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalInstance.g:2105:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalInstance.g:2105:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalInstance.g:2106:3: lv_ownedValue_0_0= rulePropertyExpression
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

            // InternalInstance.g:2122:2: (otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==20) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==21) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalInstance.g:2122:4: otherlv_1= 'in' otherlv_2= 'modes' otherlv_3= '(' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= ')'
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_13); 

                        	newLeafNode(otherlv_1, grammarAccess.getOptionalModalPropertyValueAccess().getInKeyword_1_0());
                        
                    otherlv_2=(Token)match(input,21,FOLLOW_14); 

                        	newLeafNode(otherlv_2, grammarAccess.getOptionalModalPropertyValueAccess().getModesKeyword_1_1());
                        
                    otherlv_3=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_3, grammarAccess.getOptionalModalPropertyValueAccess().getLeftParenthesisKeyword_1_2());
                        
                    // InternalInstance.g:2134:1: ( (otherlv_4= RULE_ID ) )
                    // InternalInstance.g:2135:1: (otherlv_4= RULE_ID )
                    {
                    // InternalInstance.g:2135:1: (otherlv_4= RULE_ID )
                    // InternalInstance.g:2136:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOptionalModalPropertyValueRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_15); 

                    		newLeafNode(otherlv_4, grammarAccess.getOptionalModalPropertyValueAccess().getInModeModeCrossReference_1_3_0()); 
                    	

                    }


                    }

                    // InternalInstance.g:2147:2: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==23) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // InternalInstance.g:2147:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
                    	    {
                    	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_5, grammarAccess.getOptionalModalPropertyValueAccess().getCommaKeyword_1_4_0());
                    	        
                    	    // InternalInstance.g:2151:1: ( (otherlv_6= RULE_ID ) )
                    	    // InternalInstance.g:2152:1: (otherlv_6= RULE_ID )
                    	    {
                    	    // InternalInstance.g:2152:1: (otherlv_6= RULE_ID )
                    	    // InternalInstance.g:2153:3: otherlv_6= RULE_ID
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
                    	    break loop42;
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
    // InternalInstance.g:2176:1: entryRulePropertyExpression returns [EObject current=null] : iv_rulePropertyExpression= rulePropertyExpression EOF ;
    public final EObject entryRulePropertyExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyExpression = null;


        try {
            // InternalInstance.g:2177:2: (iv_rulePropertyExpression= rulePropertyExpression EOF )
            // InternalInstance.g:2178:2: iv_rulePropertyExpression= rulePropertyExpression EOF
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
    // InternalInstance.g:2185:1: rulePropertyExpression returns [EObject current=null] : (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) ;
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
            // InternalInstance.g:2188:28: ( (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm ) )
            // InternalInstance.g:2189:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            {
            // InternalInstance.g:2189:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )
            int alt44=12;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // InternalInstance.g:2190:5: this_RecordTerm_0= ruleRecordTerm
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
                    // InternalInstance.g:2200:5: this_ReferenceTerm_1= ruleReferenceTerm
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
                    // InternalInstance.g:2210:5: this_InstanceReferenceValue_2= ruleInstanceReferenceValue
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
                    // InternalInstance.g:2220:5: this_ComponentClassifierTerm_3= ruleComponentClassifierTerm
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
                    // InternalInstance.g:2230:5: this_ComputedTerm_4= ruleComputedTerm
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
                    // InternalInstance.g:2240:5: this_StringTerm_5= ruleStringTerm
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
                    // InternalInstance.g:2250:5: this_NumericRangeTerm_6= ruleNumericRangeTerm
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
                    // InternalInstance.g:2260:5: this_RealTerm_7= ruleRealTerm
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
                    // InternalInstance.g:2270:5: this_IntegerTerm_8= ruleIntegerTerm
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
                    // InternalInstance.g:2280:5: this_ListTerm_9= ruleListTerm
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
                    // InternalInstance.g:2290:5: this_BooleanLiteral_10= ruleBooleanLiteral
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
                    // InternalInstance.g:2300:5: this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm
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
    // InternalInstance.g:2316:1: entryRuleContainmentPathElement returns [EObject current=null] : iv_ruleContainmentPathElement= ruleContainmentPathElement EOF ;
    public final EObject entryRuleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPathElement = null;


        try {
            // InternalInstance.g:2317:2: (iv_ruleContainmentPathElement= ruleContainmentPathElement EOF )
            // InternalInstance.g:2318:2: iv_ruleContainmentPathElement= ruleContainmentPathElement EOF
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
    // InternalInstance.g:2325:1: ruleContainmentPathElement returns [EObject current=null] : ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) ;
    public final EObject ruleContainmentPathElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_arrayRange_1_0 = null;

        EObject lv_path_3_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:2328:28: ( ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? ) )
            // InternalInstance.g:2329:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            {
            // InternalInstance.g:2329:1: ( ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )? )
            // InternalInstance.g:2329:2: ( ( ruleDeclarativeRef ) ) ( (lv_arrayRange_1_0= ruleArrayRange ) )? (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            {
            // InternalInstance.g:2329:2: ( ( ruleDeclarativeRef ) )
            // InternalInstance.g:2330:1: ( ruleDeclarativeRef )
            {
            // InternalInstance.g:2330:1: ( ruleDeclarativeRef )
            // InternalInstance.g:2331:3: ruleDeclarativeRef
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

            // InternalInstance.g:2344:2: ( (lv_arrayRange_1_0= ruleArrayRange ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==18) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalInstance.g:2345:1: (lv_arrayRange_1_0= ruleArrayRange )
                    {
                    // InternalInstance.g:2345:1: (lv_arrayRange_1_0= ruleArrayRange )
                    // InternalInstance.g:2346:3: lv_arrayRange_1_0= ruleArrayRange
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

            // InternalInstance.g:2362:3: (otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==40) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalInstance.g:2362:5: otherlv_2= '/' ( (lv_path_3_0= ruleContainmentPathElement ) )
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_3); 

                        	newLeafNode(otherlv_2, grammarAccess.getContainmentPathElementAccess().getSolidusKeyword_2_0());
                        
                    // InternalInstance.g:2366:1: ( (lv_path_3_0= ruleContainmentPathElement ) )
                    // InternalInstance.g:2367:1: (lv_path_3_0= ruleContainmentPathElement )
                    {
                    // InternalInstance.g:2367:1: (lv_path_3_0= ruleContainmentPathElement )
                    // InternalInstance.g:2368:3: lv_path_3_0= ruleContainmentPathElement
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
    // InternalInstance.g:2392:1: entryRuleInstanceReferenceValue returns [EObject current=null] : iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF ;
    public final EObject entryRuleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstanceReferenceValue = null;


        try {
            // InternalInstance.g:2393:2: (iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF )
            // InternalInstance.g:2394:2: iv_ruleInstanceReferenceValue= ruleInstanceReferenceValue EOF
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
    // InternalInstance.g:2401:1: ruleInstanceReferenceValue returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) ;
    public final EObject ruleInstanceReferenceValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2404:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' ) )
            // InternalInstance.g:2405:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:2405:1: (otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')' )
            // InternalInstance.g:2405:3: otherlv_0= 'reference' otherlv_1= '(' ( ( ruleInstanceRef ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getInstanceReferenceValueAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_18); 

                	newLeafNode(otherlv_1, grammarAccess.getInstanceReferenceValueAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:2413:1: ( ( ruleInstanceRef ) )
            // InternalInstance.g:2414:1: ( ruleInstanceRef )
            {
            // InternalInstance.g:2414:1: ( ruleInstanceRef )
            // InternalInstance.g:2415:3: ruleInstanceRef
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
    // InternalInstance.g:2440:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // InternalInstance.g:2441:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // InternalInstance.g:2442:2: iv_ruleDirectionType= ruleDirectionType EOF
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
    // InternalInstance.g:2449:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2452:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // InternalInstance.g:2453:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // InternalInstance.g:2453:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt47=3;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==20) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==42) ) {
                    alt47=3;
                }
                else if ( (LA47_1==EOF||(LA47_1>=43 && LA47_1<=52)) ) {
                    alt47=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA47_0==42) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalInstance.g:2454:2: kw= 'in'
                    {
                    kw=(Token)match(input,20,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2461:2: kw= 'out'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2467:6: (kw= 'in' kw= 'out' )
                    {
                    // InternalInstance.g:2467:6: (kw= 'in' kw= 'out' )
                    // InternalInstance.g:2468:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,20,FOLLOW_52); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,42,FOLLOW_2); 

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
    // InternalInstance.g:2487:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // InternalInstance.g:2488:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // InternalInstance.g:2489:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
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
    // InternalInstance.g:2496:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2499:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // InternalInstance.g:2500:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // InternalInstance.g:2500:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'dataAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            int alt48=10;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt48=1;
                }
                break;
            case 44:
                {
                alt48=2;
                }
                break;
            case 45:
                {
                alt48=3;
                }
                break;
            case 46:
                {
                alt48=4;
                }
                break;
            case 47:
                {
                alt48=5;
                }
                break;
            case 48:
                {
                alt48=6;
                }
                break;
            case 49:
                {
                alt48=7;
                }
                break;
            case 50:
                {
                alt48=8;
                }
                break;
            case 51:
                {
                alt48=9;
                }
                break;
            case 52:
                {
                alt48=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalInstance.g:2501:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2508:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2515:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2522:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2529:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalInstance.g:2536:2: kw= 'dataAccess'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalInstance.g:2543:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalInstance.g:2550:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalInstance.g:2557:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // InternalInstance.g:2564:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

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
    // InternalInstance.g:2577:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // InternalInstance.g:2578:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // InternalInstance.g:2579:2: iv_ruleComponentCategory= ruleComponentCategory EOF
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
    // InternalInstance.g:2586:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2589:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // InternalInstance.g:2590:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // InternalInstance.g:2590:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt49=14;
            alt49 = dfa49.predict(input);
            switch (alt49) {
                case 1 :
                    // InternalInstance.g:2591:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2598:2: kw= 'bus'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2605:2: kw= 'data'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2612:2: kw= 'device'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2619:2: kw= 'memory'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // InternalInstance.g:2626:2: kw= 'process'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // InternalInstance.g:2633:2: kw= 'processor'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // InternalInstance.g:2640:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // InternalInstance.g:2646:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // InternalInstance.g:2646:6: (kw= 'subprogram' kw= 'group' )
                    // InternalInstance.g:2647:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,60,FOLLOW_53); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,61,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // InternalInstance.g:2660:2: kw= 'system'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // InternalInstance.g:2666:6: (kw= 'thread' kw= 'group' )
                    {
                    // InternalInstance.g:2666:6: (kw= 'thread' kw= 'group' )
                    // InternalInstance.g:2667:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,63,FOLLOW_53); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,61,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // InternalInstance.g:2680:2: kw= 'thread'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // InternalInstance.g:2686:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // InternalInstance.g:2686:6: (kw= 'virtual' kw= 'bus' )
                    // InternalInstance.g:2687:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,64,FOLLOW_54); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,54,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // InternalInstance.g:2699:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // InternalInstance.g:2699:6: (kw= 'virtual' kw= 'processor' )
                    // InternalInstance.g:2700:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,64,FOLLOW_55); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,59,FOLLOW_2); 

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
    // InternalInstance.g:2719:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // InternalInstance.g:2720:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // InternalInstance.g:2721:2: iv_ruleConnectionKind= ruleConnectionKind EOF
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
    // InternalInstance.g:2728:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2731:28: ( (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' ) )
            // InternalInstance.g:2732:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            {
            // InternalInstance.g:2732:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'featureGroupConnection' )
            int alt50=5;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt50=1;
                }
                break;
            case 66:
                {
                alt50=2;
                }
                break;
            case 67:
                {
                alt50=3;
                }
                break;
            case 68:
                {
                alt50=4;
                }
                break;
            case 69:
                {
                alt50=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalInstance.g:2733:2: kw= 'featureConnection'
                    {
                    kw=(Token)match(input,65,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2740:2: kw= 'accessConnection'
                    {
                    kw=(Token)match(input,66,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // InternalInstance.g:2747:2: kw= 'parameterConnection'
                    {
                    kw=(Token)match(input,67,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // InternalInstance.g:2754:2: kw= 'portConnection'
                    {
                    kw=(Token)match(input,68,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // InternalInstance.g:2761:2: kw= 'featureGroupConnection'
                    {
                    kw=(Token)match(input,69,FOLLOW_2); 

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
    // InternalInstance.g:2774:1: entryRuleClassifierRef returns [String current=null] : iv_ruleClassifierRef= ruleClassifierRef EOF ;
    public final String entryRuleClassifierRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleClassifierRef = null;


        try {
            // InternalInstance.g:2775:2: (iv_ruleClassifierRef= ruleClassifierRef EOF )
            // InternalInstance.g:2776:2: iv_ruleClassifierRef= ruleClassifierRef EOF
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
    // InternalInstance.g:2783:1: ruleClassifierRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleClassifierRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2786:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalInstance.g:2787:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalInstance.g:2787:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // InternalInstance.g:2787:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // InternalInstance.g:2787:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    int LA51_1 = input.LA(2);

                    if ( (LA51_1==70) ) {
                        alt51=1;
                    }


                }


                switch (alt51) {
            	case 1 :
            	    // InternalInstance.g:2787:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,70,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getClassifierRefAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_57); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getClassifierRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:2807:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==71) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalInstance.g:2808:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,71,FOLLOW_3); 

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
    // InternalInstance.g:2828:1: entryRuleImplRef returns [String current=null] : iv_ruleImplRef= ruleImplRef EOF ;
    public final String entryRuleImplRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImplRef = null;


        try {
            // InternalInstance.g:2829:2: (iv_ruleImplRef= ruleImplRef EOF )
            // InternalInstance.g:2830:2: iv_ruleImplRef= ruleImplRef EOF
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
    // InternalInstance.g:2837:1: ruleImplRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleImplRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:2840:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // InternalInstance.g:2841:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // InternalInstance.g:2841:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // InternalInstance.g:2841:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // InternalInstance.g:2841:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    int LA53_1 = input.LA(2);

                    if ( (LA53_1==70) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // InternalInstance.g:2841:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,70,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getImplRefAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_58); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getImplRefAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,71,FOLLOW_3); 

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
    // InternalInstance.g:2882:1: entryRuleDeclarativeRef returns [String current=null] : iv_ruleDeclarativeRef= ruleDeclarativeRef EOF ;
    public final String entryRuleDeclarativeRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDeclarativeRef = null;


        try {
            // InternalInstance.g:2883:2: (iv_ruleDeclarativeRef= ruleDeclarativeRef EOF )
            // InternalInstance.g:2884:2: iv_ruleDeclarativeRef= ruleDeclarativeRef EOF
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
    // InternalInstance.g:2891:1: ruleDeclarativeRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) ;
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
            // InternalInstance.g:2894:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) ) )
            // InternalInstance.g:2895:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            {
            // InternalInstance.g:2895:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID ) )
            // InternalInstance.g:2895:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            {
            // InternalInstance.g:2895:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID) ) {
                    int LA54_1 = input.LA(2);

                    if ( (LA54_1==70) ) {
                        alt54=1;
                    }


                }


                switch (alt54) {
            	case 1 :
            	    // InternalInstance.g:2895:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,70,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_59); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDeclarativeRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:2915:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==71) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalInstance.g:2916:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,71,FOLLOW_3); 

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
                
            // InternalInstance.g:2934:1: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | this_ID_9= RULE_ID )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==37) ) {
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
                    // InternalInstance.g:2934:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    {
                    // InternalInstance.g:2934:2: (kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                    // InternalInstance.g:2935:2: kw= 'transition' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                    {
                    kw=(Token)match(input,37,FOLLOW_61); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getTransitionKeyword_4_0_0()); 
                        
                    kw=(Token)match(input,72,FOLLOW_9); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDeclarativeRefAccess().getNumberSignKeyword_4_0_1()); 
                        
                    this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

                    		current.merge(this_INTEGER_LIT_8);
                        
                     
                        newLeafNode(this_INTEGER_LIT_8, grammarAccess.getDeclarativeRefAccess().getINTEGER_LITTerminalRuleCall_4_0_2()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalInstance.g:2954:10: this_ID_9= RULE_ID
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
    // InternalInstance.g:2969:1: entryRuleInstanceRef returns [String current=null] : iv_ruleInstanceRef= ruleInstanceRef EOF ;
    public final String entryRuleInstanceRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInstanceRef = null;


        try {
            // InternalInstance.g:2970:2: (iv_ruleInstanceRef= ruleInstanceRef EOF )
            // InternalInstance.g:2971:2: iv_ruleInstanceRef= ruleInstanceRef EOF
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
    // InternalInstance.g:2978:1: ruleInstanceRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) ;
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
            // InternalInstance.g:2981:28: ( (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) ) )
            // InternalInstance.g:2982:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            {
            // InternalInstance.g:2982:1: (kw= 'parent' | ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==73) ) {
                alt61=1;
            }
            else if ( (LA61_0==RULE_ID||LA61_0==74) ) {
                alt61=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalInstance.g:2983:2: kw= 'parent'
                    {
                    kw=(Token)match(input,73,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getParentKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:2989:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    {
                    // InternalInstance.g:2989:6: ( (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) ) )
                    // InternalInstance.g:2989:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )* ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    {
                    // InternalInstance.g:2989:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*
                    loop58:
                    do {
                        int alt58=2;
                        alt58 = dfa58.predict(input);
                        switch (alt58) {
                    	case 1 :
                    	    // InternalInstance.g:2989:12: this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.'
                    	    {
                    	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_62); 

                    	    		current.merge(this_ID_1);
                    	        
                    	     
                    	        newLeafNode(this_ID_1, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_0_0()); 
                    	        
                    	    // InternalInstance.g:2996:1: (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )*
                    	    loop57:
                    	    do {
                    	        int alt57=2;
                    	        int LA57_0 = input.LA(1);

                    	        if ( (LA57_0==18) ) {
                    	            alt57=1;
                    	        }


                    	        switch (alt57) {
                    	    	case 1 :
                    	    	    // InternalInstance.g:2997:2: kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']'
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
                    	    	    break loop57;
                    	        }
                    	    } while (true);

                    	    kw=(Token)match(input,71,FOLLOW_63); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getInstanceRefAccess().getFullStopKeyword_1_0_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    // InternalInstance.g:3021:3: ( (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT ) | (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* ) )
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==74) ) {
                        alt60=1;
                    }
                    else if ( (LA60_0==RULE_ID) ) {
                        alt60=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 0, input);

                        throw nvae;
                    }
                    switch (alt60) {
                        case 1 :
                            // InternalInstance.g:3021:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            {
                            // InternalInstance.g:3021:4: (kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT )
                            // InternalInstance.g:3022:2: kw= 'connection' kw= '#' this_INTEGER_LIT_8= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,74,FOLLOW_61); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getConnectionKeyword_1_1_0_0()); 
                                
                            kw=(Token)match(input,72,FOLLOW_9); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getInstanceRefAccess().getNumberSignKeyword_1_1_0_1()); 
                                
                            this_INTEGER_LIT_8=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_2); 

                            		current.merge(this_INTEGER_LIT_8);
                                
                             
                                newLeafNode(this_INTEGER_LIT_8, grammarAccess.getInstanceRefAccess().getINTEGER_LITTerminalRuleCall_1_1_0_2()); 
                                

                            }


                            }
                            break;
                        case 2 :
                            // InternalInstance.g:3041:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            {
                            // InternalInstance.g:3041:6: (this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )* )
                            // InternalInstance.g:3041:11: this_ID_9= RULE_ID (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            {
                            this_ID_9=(Token)match(input,RULE_ID,FOLLOW_64); 

                            		current.merge(this_ID_9);
                                
                             
                                newLeafNode(this_ID_9, grammarAccess.getInstanceRefAccess().getIDTerminalRuleCall_1_1_1_0()); 
                                
                            // InternalInstance.g:3048:1: (kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']' )*
                            loop59:
                            do {
                                int alt59=2;
                                int LA59_0 = input.LA(1);

                                if ( (LA59_0==18) ) {
                                    alt59=1;
                                }


                                switch (alt59) {
                            	case 1 :
                            	    // InternalInstance.g:3049:2: kw= '[' this_INTEGER_LIT_11= RULE_INTEGER_LIT kw= ']'
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
                            	    break loop59;
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
    // InternalInstance.g:3075:1: entryRuleTransitionRef returns [String current=null] : iv_ruleTransitionRef= ruleTransitionRef EOF ;
    public final String entryRuleTransitionRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTransitionRef = null;


        try {
            // InternalInstance.g:3076:2: (iv_ruleTransitionRef= ruleTransitionRef EOF )
            // InternalInstance.g:3077:2: iv_ruleTransitionRef= ruleTransitionRef EOF
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
    // InternalInstance.g:3084:1: ruleTransitionRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleTransitionRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3087:28: ( (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalInstance.g:3088:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:3088:1: (kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalInstance.g:3089:2: kw= 'transition' kw= '#' this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            kw=(Token)match(input,37,FOLLOW_61); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getTransitionRefAccess().getTransitionKeyword_0()); 
                
            kw=(Token)match(input,72,FOLLOW_9); 

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
    // InternalInstance.g:3115:1: entryRuleModeTransitionName returns [String current=null] : iv_ruleModeTransitionName= ruleModeTransitionName EOF ;
    public final String entryRuleModeTransitionName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModeTransitionName = null;


        try {
            // InternalInstance.g:3116:2: (iv_ruleModeTransitionName= ruleModeTransitionName EOF )
            // InternalInstance.g:3117:2: iv_ruleModeTransitionName= ruleModeTransitionName EOF
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
    // InternalInstance.g:3124:1: ruleModeTransitionName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleModeTransitionName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3127:28: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // InternalInstance.g:3128:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // InternalInstance.g:3128:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // InternalInstance.g:3128:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_58); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,71,FOLLOW_3); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getModeTransitionNameAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_58); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getModeTransitionNameAccess().getIDTerminalRuleCall_2()); 
                
            kw=(Token)match(input,71,FOLLOW_3); 

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
    // InternalInstance.g:3169:1: entryRulePropertyAssociationRef returns [String current=null] : iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF ;
    public final String entryRulePropertyAssociationRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePropertyAssociationRef = null;


        try {
            // InternalInstance.g:3170:2: (iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF )
            // InternalInstance.g:3171:2: iv_rulePropertyAssociationRef= rulePropertyAssociationRef EOF
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
    // InternalInstance.g:3178:1: rulePropertyAssociationRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) ;
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
            // InternalInstance.g:3181:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT ) )
            // InternalInstance.g:3182:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:3182:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT )
            // InternalInstance.g:3182:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= ':' ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )? kw= 'property' kw= '#' this_INTEGER_LIT_13= RULE_INTEGER_LIT
            {
            // InternalInstance.g:3182:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID) ) {
                    int LA62_1 = input.LA(2);

                    if ( (LA62_1==70) ) {
                        alt62=1;
                    }


                }


                switch (alt62) {
            	case 1 :
            	    // InternalInstance.g:3182:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,70,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_59); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:3202:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==71) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalInstance.g:3203:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,71,FOLLOW_3); 

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
                
            // InternalInstance.g:3221:1: ( (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID||LA65_0==37) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalInstance.g:3221:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) ) kw= ':'
                    {
                    // InternalInstance.g:3221:2: (this_ID_6= RULE_ID | (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT ) )
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==RULE_ID) ) {
                        alt64=1;
                    }
                    else if ( (LA64_0==37) ) {
                        alt64=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 64, 0, input);

                        throw nvae;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalInstance.g:3221:7: this_ID_6= RULE_ID
                            {
                            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_4); 

                            		current.merge(this_ID_6);
                                
                             
                                newLeafNode(this_ID_6, grammarAccess.getPropertyAssociationRefAccess().getIDTerminalRuleCall_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // InternalInstance.g:3229:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            {
                            // InternalInstance.g:3229:6: (kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT )
                            // InternalInstance.g:3230:2: kw= 'transition' kw= '#' this_INTEGER_LIT_9= RULE_INTEGER_LIT
                            {
                            kw=(Token)match(input,37,FOLLOW_61); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getTransitionKeyword_4_0_1_0()); 
                                
                            kw=(Token)match(input,72,FOLLOW_9); 

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

            kw=(Token)match(input,75,FOLLOW_61); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getPropertyAssociationRefAccess().getPropertyKeyword_5()); 
                
            kw=(Token)match(input,72,FOLLOW_9); 

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
    // InternalInstance.g:3281:1: entryRuleLong returns [String current=null] : iv_ruleLong= ruleLong EOF ;
    public final String entryRuleLong() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLong = null;


        try {
            // InternalInstance.g:3282:2: (iv_ruleLong= ruleLong EOF )
            // InternalInstance.g:3283:2: iv_ruleLong= ruleLong EOF
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
    // InternalInstance.g:3290:1: ruleLong returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleLong() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3293:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalInstance.g:3294:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalInstance.g:3311:1: entryRuleContainedPropertyAssociation returns [EObject current=null] : iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF ;
    public final EObject entryRuleContainedPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainedPropertyAssociation = null;


        try {
            // InternalInstance.g:3312:2: (iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF )
            // InternalInstance.g:3313:2: iv_ruleContainedPropertyAssociation= ruleContainedPropertyAssociation EOF
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
    // InternalInstance.g:3320:1: ruleContainedPropertyAssociation returns [EObject current=null] : ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' ) ;
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
            // InternalInstance.g:3323:28: ( ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' ) )
            // InternalInstance.g:3324:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' )
            {
            // InternalInstance.g:3324:1: ( ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';' )
            // InternalInstance.g:3324:2: ( ( ruleQPREF ) ) (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) ) ( (lv_constant_3_0= 'constant' ) )? ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* ) ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )? ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )? otherlv_15= ';'
            {
            // InternalInstance.g:3324:2: ( ( ruleQPREF ) )
            // InternalInstance.g:3325:1: ( ruleQPREF )
            {
            // InternalInstance.g:3325:1: ( ruleQPREF )
            // InternalInstance.g:3326:3: ruleQPREF
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

            // InternalInstance.g:3339:2: (otherlv_1= '=>' | ( (lv_append_2_0= '+=>' ) ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==39) ) {
                alt66=1;
            }
            else if ( (LA66_0==76) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalInstance.g:3339:4: otherlv_1= '=>'
                    {
                    otherlv_1=(Token)match(input,39,FOLLOW_68); 

                        	newLeafNode(otherlv_1, grammarAccess.getContainedPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1_0());
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:3344:6: ( (lv_append_2_0= '+=>' ) )
                    {
                    // InternalInstance.g:3344:6: ( (lv_append_2_0= '+=>' ) )
                    // InternalInstance.g:3345:1: (lv_append_2_0= '+=>' )
                    {
                    // InternalInstance.g:3345:1: (lv_append_2_0= '+=>' )
                    // InternalInstance.g:3346:3: lv_append_2_0= '+=>'
                    {
                    lv_append_2_0=(Token)match(input,76,FOLLOW_68); 

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

            // InternalInstance.g:3359:3: ( (lv_constant_3_0= 'constant' ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==77) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalInstance.g:3360:1: (lv_constant_3_0= 'constant' )
                    {
                    // InternalInstance.g:3360:1: (lv_constant_3_0= 'constant' )
                    // InternalInstance.g:3361:3: lv_constant_3_0= 'constant'
                    {
                    lv_constant_3_0=(Token)match(input,77,FOLLOW_47); 

                            newLeafNode(lv_constant_3_0, grammarAccess.getContainedPropertyAssociationAccess().getConstantConstantKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getContainedPropertyAssociationRule());
                    	        }
                           		setWithLastConsumed(current, "constant", true, "constant");
                    	    

                    }


                    }
                    break;

            }

            // InternalInstance.g:3374:3: ( ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )* )
            // InternalInstance.g:3374:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) ) (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            {
            // InternalInstance.g:3374:4: ( (lv_ownedValue_4_0= ruleOptionalModalPropertyValue ) )
            // InternalInstance.g:3375:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            {
            // InternalInstance.g:3375:1: (lv_ownedValue_4_0= ruleOptionalModalPropertyValue )
            // InternalInstance.g:3376:3: lv_ownedValue_4_0= ruleOptionalModalPropertyValue
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

            // InternalInstance.g:3392:2: (otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) ) )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==23) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalInstance.g:3392:4: otherlv_5= ',' ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_47); 

            	        	newLeafNode(otherlv_5, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_3_1_0());
            	        
            	    // InternalInstance.g:3396:1: ( (lv_ownedValue_6_0= ruleOptionalModalPropertyValue ) )
            	    // InternalInstance.g:3397:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    {
            	    // InternalInstance.g:3397:1: (lv_ownedValue_6_0= ruleOptionalModalPropertyValue )
            	    // InternalInstance.g:3398:3: lv_ownedValue_6_0= ruleOptionalModalPropertyValue
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
            	    break loop68;
                }
            } while (true);


            }

            // InternalInstance.g:3414:5: ( ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )* )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==87) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalInstance.g:3415:5: ruleAppliesToKeywords ( (lv_appliesTo_8_0= ruleContainmentPath ) ) (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    {
                     
                            newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToKeywordsParserRuleCall_4_0()); 
                        
                    pushFollow(FOLLOW_3);
                    ruleAppliesToKeywords();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalInstance.g:3422:1: ( (lv_appliesTo_8_0= ruleContainmentPath ) )
                    // InternalInstance.g:3423:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    {
                    // InternalInstance.g:3423:1: (lv_appliesTo_8_0= ruleContainmentPath )
                    // InternalInstance.g:3424:3: lv_appliesTo_8_0= ruleContainmentPath
                    {
                     
                    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_70);
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

                    // InternalInstance.g:3440:2: (otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) ) )*
                    loop69:
                    do {
                        int alt69=2;
                        int LA69_0 = input.LA(1);

                        if ( (LA69_0==23) ) {
                            alt69=1;
                        }


                        switch (alt69) {
                    	case 1 :
                    	    // InternalInstance.g:3440:4: otherlv_9= ',' ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    {
                    	    otherlv_9=(Token)match(input,23,FOLLOW_3); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getContainedPropertyAssociationAccess().getCommaKeyword_4_2_0());
                    	        
                    	    // InternalInstance.g:3444:1: ( (lv_appliesTo_10_0= ruleContainmentPath ) )
                    	    // InternalInstance.g:3445:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    {
                    	    // InternalInstance.g:3445:1: (lv_appliesTo_10_0= ruleContainmentPath )
                    	    // InternalInstance.g:3446:3: lv_appliesTo_10_0= ruleContainmentPath
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getAppliesToContainmentPathParserRuleCall_4_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_70);
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
                    	    break loop69;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalInstance.g:3462:6: ( ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==20) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalInstance.g:3463:5: ruleInBindingKeywords otherlv_12= '(' ( ( ruleQCREF ) ) otherlv_14= ')'
                    {
                     
                            newCompositeNode(grammarAccess.getContainedPropertyAssociationAccess().getInBindingKeywordsParserRuleCall_5_0()); 
                        
                    pushFollow(FOLLOW_14);
                    ruleInBindingKeywords();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_12=(Token)match(input,22,FOLLOW_3); 

                        	newLeafNode(otherlv_12, grammarAccess.getContainedPropertyAssociationAccess().getLeftParenthesisKeyword_5_1());
                        
                    // InternalInstance.g:3474:1: ( ( ruleQCREF ) )
                    // InternalInstance.g:3475:1: ( ruleQCREF )
                    {
                    // InternalInstance.g:3475:1: ( ruleQCREF )
                    // InternalInstance.g:3476:3: ruleQCREF
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

                    otherlv_14=(Token)match(input,24,FOLLOW_71); 

                        	newLeafNode(otherlv_14, grammarAccess.getContainedPropertyAssociationAccess().getRightParenthesisKeyword_5_3());
                        

                    }
                    break;

            }

            otherlv_15=(Token)match(input,78,FOLLOW_2); 

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
    // InternalInstance.g:3509:1: entryRuleContainmentPath returns [EObject current=null] : iv_ruleContainmentPath= ruleContainmentPath EOF ;
    public final EObject entryRuleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContainmentPath = null;


        try {
            // InternalInstance.g:3510:2: (iv_ruleContainmentPath= ruleContainmentPath EOF )
            // InternalInstance.g:3511:2: iv_ruleContainmentPath= ruleContainmentPath EOF
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
    // InternalInstance.g:3518:1: ruleContainmentPath returns [EObject current=null] : ( (lv_path_0_0= ruleContainmentPathElement ) ) ;
    public final EObject ruleContainmentPath() throws RecognitionException {
        EObject current = null;

        EObject lv_path_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3521:28: ( ( (lv_path_0_0= ruleContainmentPathElement ) ) )
            // InternalInstance.g:3522:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            {
            // InternalInstance.g:3522:1: ( (lv_path_0_0= ruleContainmentPathElement ) )
            // InternalInstance.g:3523:1: (lv_path_0_0= ruleContainmentPathElement )
            {
            // InternalInstance.g:3523:1: (lv_path_0_0= ruleContainmentPathElement )
            // InternalInstance.g:3524:3: lv_path_0_0= ruleContainmentPathElement
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
    // InternalInstance.g:3550:1: entryRulePropertyValue returns [EObject current=null] : iv_rulePropertyValue= rulePropertyValue EOF ;
    public final EObject entryRulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyValue = null;


        try {
            // InternalInstance.g:3551:2: (iv_rulePropertyValue= rulePropertyValue EOF )
            // InternalInstance.g:3552:2: iv_rulePropertyValue= rulePropertyValue EOF
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
    // InternalInstance.g:3559:1: rulePropertyValue returns [EObject current=null] : ( (lv_ownedValue_0_0= rulePropertyExpression ) ) ;
    public final EObject rulePropertyValue() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedValue_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3562:28: ( ( (lv_ownedValue_0_0= rulePropertyExpression ) ) )
            // InternalInstance.g:3563:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            {
            // InternalInstance.g:3563:1: ( (lv_ownedValue_0_0= rulePropertyExpression ) )
            // InternalInstance.g:3564:1: (lv_ownedValue_0_0= rulePropertyExpression )
            {
            // InternalInstance.g:3564:1: (lv_ownedValue_0_0= rulePropertyExpression )
            // InternalInstance.g:3565:3: lv_ownedValue_0_0= rulePropertyExpression
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
    // InternalInstance.g:3589:1: entryRuleLiteralorReferenceTerm returns [EObject current=null] : iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF ;
    public final EObject entryRuleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralorReferenceTerm = null;


        try {
            // InternalInstance.g:3590:2: (iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF )
            // InternalInstance.g:3591:2: iv_ruleLiteralorReferenceTerm= ruleLiteralorReferenceTerm EOF
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
    // InternalInstance.g:3598:1: ruleLiteralorReferenceTerm returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleLiteralorReferenceTerm() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3601:28: ( ( ( ruleQPREF ) ) )
            // InternalInstance.g:3602:1: ( ( ruleQPREF ) )
            {
            // InternalInstance.g:3602:1: ( ( ruleQPREF ) )
            // InternalInstance.g:3603:1: ( ruleQPREF )
            {
            // InternalInstance.g:3603:1: ( ruleQPREF )
            // InternalInstance.g:3604:3: ruleQPREF
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
    // InternalInstance.g:3625:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalInstance.g:3626:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalInstance.g:3627:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
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
    // InternalInstance.g:3634:1: ruleBooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3637:28: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalInstance.g:3638:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalInstance.g:3638:1: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalInstance.g:3638:2: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalInstance.g:3638:2: ()
            // InternalInstance.g:3639:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
                        current);
                

            }

            // InternalInstance.g:3644:2: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==79) ) {
                alt72=1;
            }
            else if ( (LA72_0==80) ) {
                alt72=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // InternalInstance.g:3644:3: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalInstance.g:3644:3: ( (lv_value_1_0= 'true' ) )
                    // InternalInstance.g:3645:1: (lv_value_1_0= 'true' )
                    {
                    // InternalInstance.g:3645:1: (lv_value_1_0= 'true' )
                    // InternalInstance.g:3646:3: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,79,FOLLOW_2); 

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
                    // InternalInstance.g:3660:7: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,80,FOLLOW_2); 

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
    // InternalInstance.g:3672:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalInstance.g:3673:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalInstance.g:3674:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalInstance.g:3681:1: ruleConstantValue returns [EObject current=null] : ( ( ruleQPREF ) ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3684:28: ( ( ( ruleQPREF ) ) )
            // InternalInstance.g:3685:1: ( ( ruleQPREF ) )
            {
            // InternalInstance.g:3685:1: ( ( ruleQPREF ) )
            // InternalInstance.g:3686:1: ( ruleQPREF )
            {
            // InternalInstance.g:3686:1: ( ruleQPREF )
            // InternalInstance.g:3687:3: ruleQPREF
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
    // InternalInstance.g:3708:1: entryRuleReferenceTerm returns [EObject current=null] : iv_ruleReferenceTerm= ruleReferenceTerm EOF ;
    public final EObject entryRuleReferenceTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceTerm = null;


        try {
            // InternalInstance.g:3709:2: (iv_ruleReferenceTerm= ruleReferenceTerm EOF )
            // InternalInstance.g:3710:2: iv_ruleReferenceTerm= ruleReferenceTerm EOF
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
    // InternalInstance.g:3717:1: ruleReferenceTerm returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) ;
    public final EObject ruleReferenceTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3720:28: ( (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3721:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3721:1: (otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')' )
            // InternalInstance.g:3721:3: otherlv_0= 'reference' otherlv_1= '(' ( (lv_path_2_0= ruleContainmentPathElement ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceTermAccess().getReferenceKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3729:1: ( (lv_path_2_0= ruleContainmentPathElement ) )
            // InternalInstance.g:3730:1: (lv_path_2_0= ruleContainmentPathElement )
            {
            // InternalInstance.g:3730:1: (lv_path_2_0= ruleContainmentPathElement )
            // InternalInstance.g:3731:3: lv_path_2_0= ruleContainmentPathElement
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
    // InternalInstance.g:3759:1: entryRuleRecordTerm returns [EObject current=null] : iv_ruleRecordTerm= ruleRecordTerm EOF ;
    public final EObject entryRuleRecordTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRecordTerm = null;


        try {
            // InternalInstance.g:3760:2: (iv_ruleRecordTerm= ruleRecordTerm EOF )
            // InternalInstance.g:3761:2: iv_ruleRecordTerm= ruleRecordTerm EOF
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
    // InternalInstance.g:3768:1: ruleRecordTerm returns [EObject current=null] : (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) ;
    public final EObject ruleRecordTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_ownedFieldValue_1_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3771:28: ( (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' ) )
            // InternalInstance.g:3772:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            {
            // InternalInstance.g:3772:1: (otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']' )
            // InternalInstance.g:3772:3: otherlv_0= '[' ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+ otherlv_2= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_3); 

                	newLeafNode(otherlv_0, grammarAccess.getRecordTermAccess().getLeftSquareBracketKeyword_0());
                
            // InternalInstance.g:3776:1: ( (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation ) )+
            int cnt73=0;
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_ID) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // InternalInstance.g:3777:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    {
            	    // InternalInstance.g:3777:1: (lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation )
            	    // InternalInstance.g:3778:3: lv_ownedFieldValue_1_0= ruleFieldPropertyAssociation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRecordTermAccess().getOwnedFieldValueFieldPropertyAssociationParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_72);
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
            	    if ( cnt73 >= 1 ) break loop73;
                        EarlyExitException eee =
                            new EarlyExitException(73, input);
                        throw eee;
                }
                cnt73++;
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
    // InternalInstance.g:3808:1: entryRuleComputedTerm returns [EObject current=null] : iv_ruleComputedTerm= ruleComputedTerm EOF ;
    public final EObject entryRuleComputedTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComputedTerm = null;


        try {
            // InternalInstance.g:3809:2: (iv_ruleComputedTerm= ruleComputedTerm EOF )
            // InternalInstance.g:3810:2: iv_ruleComputedTerm= ruleComputedTerm EOF
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
    // InternalInstance.g:3817:1: ruleComputedTerm returns [EObject current=null] : (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleComputedTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_function_2_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3820:28: ( (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3821:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3821:1: (otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')' )
            // InternalInstance.g:3821:3: otherlv_0= 'compute' otherlv_1= '(' ( (lv_function_2_0= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,81,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getComputedTermAccess().getComputeKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getComputedTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3829:1: ( (lv_function_2_0= RULE_ID ) )
            // InternalInstance.g:3830:1: (lv_function_2_0= RULE_ID )
            {
            // InternalInstance.g:3830:1: (lv_function_2_0= RULE_ID )
            // InternalInstance.g:3831:3: lv_function_2_0= RULE_ID
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
    // InternalInstance.g:3859:1: entryRuleComponentClassifierTerm returns [EObject current=null] : iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF ;
    public final EObject entryRuleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentClassifierTerm = null;


        try {
            // InternalInstance.g:3860:2: (iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF )
            // InternalInstance.g:3861:2: iv_ruleComponentClassifierTerm= ruleComponentClassifierTerm EOF
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
    // InternalInstance.g:3868:1: ruleComponentClassifierTerm returns [EObject current=null] : (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) ;
    public final EObject ruleComponentClassifierTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:3871:28: ( (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' ) )
            // InternalInstance.g:3872:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            {
            // InternalInstance.g:3872:1: (otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')' )
            // InternalInstance.g:3872:3: otherlv_0= 'classifier' otherlv_1= '(' ( ( ruleQCREF ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_14); 

                	newLeafNode(otherlv_0, grammarAccess.getComponentClassifierTermAccess().getClassifierKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_3); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentClassifierTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3880:1: ( ( ruleQCREF ) )
            // InternalInstance.g:3881:1: ( ruleQCREF )
            {
            // InternalInstance.g:3881:1: ( ruleQCREF )
            // InternalInstance.g:3882:3: ruleQCREF
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
    // InternalInstance.g:3907:1: entryRuleListTerm returns [EObject current=null] : iv_ruleListTerm= ruleListTerm EOF ;
    public final EObject entryRuleListTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListTerm = null;


        try {
            // InternalInstance.g:3908:2: (iv_ruleListTerm= ruleListTerm EOF )
            // InternalInstance.g:3909:2: iv_ruleListTerm= ruleListTerm EOF
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
    // InternalInstance.g:3916:1: ruleListTerm returns [EObject current=null] : ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleListTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedListElement_2_0 = null;

        EObject lv_ownedListElement_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3919:28: ( ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalInstance.g:3920:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalInstance.g:3920:1: ( () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')' )
            // InternalInstance.g:3920:2: () otherlv_1= '(' ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalInstance.g:3920:2: ()
            // InternalInstance.g:3921:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListTermAccess().getListValueAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,22,FOLLOW_73); 

                	newLeafNode(otherlv_1, grammarAccess.getListTermAccess().getLeftParenthesisKeyword_1());
                
            // InternalInstance.g:3930:1: ( ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )* )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( ((LA75_0>=RULE_ID && LA75_0<=RULE_REAL_LIT)||LA75_0==18||LA75_0==22||LA75_0==41||(LA75_0>=79 && LA75_0<=84)) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalInstance.g:3930:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) ) (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    {
                    // InternalInstance.g:3930:2: ( (lv_ownedListElement_2_0= rulePropertyExpression ) )
                    // InternalInstance.g:3931:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    {
                    // InternalInstance.g:3931:1: (lv_ownedListElement_2_0= rulePropertyExpression )
                    // InternalInstance.g:3932:3: lv_ownedListElement_2_0= rulePropertyExpression
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

                    // InternalInstance.g:3948:2: (otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) ) )*
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==23) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalInstance.g:3948:4: otherlv_3= ',' ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,23,FOLLOW_47); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getListTermAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // InternalInstance.g:3952:1: ( (lv_ownedListElement_4_0= rulePropertyExpression ) )
                    	    // InternalInstance.g:3953:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    {
                    	    // InternalInstance.g:3953:1: (lv_ownedListElement_4_0= rulePropertyExpression )
                    	    // InternalInstance.g:3954:3: lv_ownedListElement_4_0= rulePropertyExpression
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
                    	    break loop74;
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
    // InternalInstance.g:3982:1: entryRuleFieldPropertyAssociation returns [EObject current=null] : iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF ;
    public final EObject entryRuleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFieldPropertyAssociation = null;


        try {
            // InternalInstance.g:3983:2: (iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF )
            // InternalInstance.g:3984:2: iv_ruleFieldPropertyAssociation= ruleFieldPropertyAssociation EOF
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
    // InternalInstance.g:3991:1: ruleFieldPropertyAssociation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleFieldPropertyAssociation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_ownedValue_2_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:3994:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' ) )
            // InternalInstance.g:3995:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            {
            // InternalInstance.g:3995:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';' )
            // InternalInstance.g:3995:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=>' ( (lv_ownedValue_2_0= rulePropertyExpression ) ) otherlv_3= ';'
            {
            // InternalInstance.g:3995:2: ( (otherlv_0= RULE_ID ) )
            // InternalInstance.g:3996:1: (otherlv_0= RULE_ID )
            {
            // InternalInstance.g:3996:1: (otherlv_0= RULE_ID )
            // InternalInstance.g:3997:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFieldPropertyAssociationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_46); 

            		newLeafNode(otherlv_0, grammarAccess.getFieldPropertyAssociationAccess().getPropertyBasicPropertyCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_47); 

                	newLeafNode(otherlv_1, grammarAccess.getFieldPropertyAssociationAccess().getEqualsSignGreaterThanSignKeyword_1());
                
            // InternalInstance.g:4012:1: ( (lv_ownedValue_2_0= rulePropertyExpression ) )
            // InternalInstance.g:4013:1: (lv_ownedValue_2_0= rulePropertyExpression )
            {
            // InternalInstance.g:4013:1: (lv_ownedValue_2_0= rulePropertyExpression )
            // InternalInstance.g:4014:3: lv_ownedValue_2_0= rulePropertyExpression
            {
             
            	        newCompositeNode(grammarAccess.getFieldPropertyAssociationAccess().getOwnedValuePropertyExpressionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_71);
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

            otherlv_3=(Token)match(input,78,FOLLOW_2); 

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
    // InternalInstance.g:4044:1: entryRulePlusMinus returns [String current=null] : iv_rulePlusMinus= rulePlusMinus EOF ;
    public final String entryRulePlusMinus() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePlusMinus = null;


        try {
            // InternalInstance.g:4045:2: (iv_rulePlusMinus= rulePlusMinus EOF )
            // InternalInstance.g:4046:2: iv_rulePlusMinus= rulePlusMinus EOF
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
    // InternalInstance.g:4053:1: rulePlusMinus returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken rulePlusMinus() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4056:28: ( (kw= '+' | kw= '-' ) )
            // InternalInstance.g:4057:1: (kw= '+' | kw= '-' )
            {
            // InternalInstance.g:4057:1: (kw= '+' | kw= '-' )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==83) ) {
                alt76=1;
            }
            else if ( (LA76_0==84) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalInstance.g:4058:2: kw= '+'
                    {
                    kw=(Token)match(input,83,FOLLOW_2); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPlusMinusAccess().getPlusSignKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4065:2: kw= '-'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

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
    // InternalInstance.g:4078:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalInstance.g:4079:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalInstance.g:4080:2: iv_ruleStringTerm= ruleStringTerm EOF
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
    // InternalInstance.g:4087:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4090:28: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalInstance.g:4091:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalInstance.g:4091:1: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalInstance.g:4092:1: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalInstance.g:4092:1: (lv_value_0_0= ruleNoQuoteString )
            // InternalInstance.g:4093:3: lv_value_0_0= ruleNoQuoteString
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
    // InternalInstance.g:4117:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalInstance.g:4118:2: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalInstance.g:4119:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
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
    // InternalInstance.g:4126:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4129:28: (this_STRING_0= RULE_STRING )
            // InternalInstance.g:4130:5: this_STRING_0= RULE_STRING
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
    // InternalInstance.g:4145:1: entryRuleArrayRange returns [EObject current=null] : iv_ruleArrayRange= ruleArrayRange EOF ;
    public final EObject entryRuleArrayRange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayRange = null;


        try {
            // InternalInstance.g:4146:2: (iv_ruleArrayRange= ruleArrayRange EOF )
            // InternalInstance.g:4147:2: iv_ruleArrayRange= ruleArrayRange EOF
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
    // InternalInstance.g:4154:1: ruleArrayRange returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) ;
    public final EObject ruleArrayRange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_lowerBound_2_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4157:28: ( ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' ) )
            // InternalInstance.g:4158:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            {
            // InternalInstance.g:4158:1: ( () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']' )
            // InternalInstance.g:4158:2: () otherlv_1= '[' ( (lv_lowerBound_2_0= ruleINTVALUE ) ) (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )? otherlv_5= ']'
            {
            // InternalInstance.g:4158:2: ()
            // InternalInstance.g:4159:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getArrayRangeAccess().getArrayRangeAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,18,FOLLOW_9); 

                	newLeafNode(otherlv_1, grammarAccess.getArrayRangeAccess().getLeftSquareBracketKeyword_1());
                
            // InternalInstance.g:4168:1: ( (lv_lowerBound_2_0= ruleINTVALUE ) )
            // InternalInstance.g:4169:1: (lv_lowerBound_2_0= ruleINTVALUE )
            {
            // InternalInstance.g:4169:1: (lv_lowerBound_2_0= ruleINTVALUE )
            // InternalInstance.g:4170:3: lv_lowerBound_2_0= ruleINTVALUE
            {
             
            	        newCompositeNode(grammarAccess.getArrayRangeAccess().getLowerBoundINTVALUEParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_74);
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

            // InternalInstance.g:4186:2: (otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==85) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalInstance.g:4186:4: otherlv_3= '..' ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    {
                    otherlv_3=(Token)match(input,85,FOLLOW_9); 

                        	newLeafNode(otherlv_3, grammarAccess.getArrayRangeAccess().getFullStopFullStopKeyword_3_0());
                        
                    // InternalInstance.g:4190:1: ( (lv_upperBound_4_0= ruleINTVALUE ) )
                    // InternalInstance.g:4191:1: (lv_upperBound_4_0= ruleINTVALUE )
                    {
                    // InternalInstance.g:4191:1: (lv_upperBound_4_0= ruleINTVALUE )
                    // InternalInstance.g:4192:3: lv_upperBound_4_0= ruleINTVALUE
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
    // InternalInstance.g:4220:1: entryRuleSignedConstant returns [EObject current=null] : iv_ruleSignedConstant= ruleSignedConstant EOF ;
    public final EObject entryRuleSignedConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSignedConstant = null;


        try {
            // InternalInstance.g:4221:2: (iv_ruleSignedConstant= ruleSignedConstant EOF )
            // InternalInstance.g:4222:2: iv_ruleSignedConstant= ruleSignedConstant EOF
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
    // InternalInstance.g:4229:1: ruleSignedConstant returns [EObject current=null] : ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) ;
    public final EObject ruleSignedConstant() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_op_0_0 = null;

        EObject lv_ownedPropertyExpression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4232:28: ( ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) ) )
            // InternalInstance.g:4233:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            {
            // InternalInstance.g:4233:1: ( ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) ) )
            // InternalInstance.g:4233:2: ( (lv_op_0_0= rulePlusMinus ) ) ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            {
            // InternalInstance.g:4233:2: ( (lv_op_0_0= rulePlusMinus ) )
            // InternalInstance.g:4234:1: (lv_op_0_0= rulePlusMinus )
            {
            // InternalInstance.g:4234:1: (lv_op_0_0= rulePlusMinus )
            // InternalInstance.g:4235:3: lv_op_0_0= rulePlusMinus
            {
             
            	        newCompositeNode(grammarAccess.getSignedConstantAccess().getOpPlusMinusParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_75);
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

            // InternalInstance.g:4251:2: ( (lv_ownedPropertyExpression_1_0= ruleConstantValue ) )
            // InternalInstance.g:4252:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            {
            // InternalInstance.g:4252:1: (lv_ownedPropertyExpression_1_0= ruleConstantValue )
            // InternalInstance.g:4253:3: lv_ownedPropertyExpression_1_0= ruleConstantValue
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
    // InternalInstance.g:4277:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // InternalInstance.g:4278:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // InternalInstance.g:4279:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
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
    // InternalInstance.g:4286:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4289:28: ( ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalInstance.g:4290:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalInstance.g:4290:1: ( ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalInstance.g:4290:2: ( (lv_value_0_0= ruleSignedInt ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalInstance.g:4290:2: ( (lv_value_0_0= ruleSignedInt ) )
            // InternalInstance.g:4291:1: (lv_value_0_0= ruleSignedInt )
            {
            // InternalInstance.g:4291:1: (lv_value_0_0= ruleSignedInt )
            // InternalInstance.g:4292:3: lv_value_0_0= ruleSignedInt
            {
             
            	        newCompositeNode(grammarAccess.getIntegerTermAccess().getValueSignedIntParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_76);
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

            // InternalInstance.g:4308:2: ( (otherlv_1= RULE_ID ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalInstance.g:4309:1: (otherlv_1= RULE_ID )
                    {
                    // InternalInstance.g:4309:1: (otherlv_1= RULE_ID )
                    // InternalInstance.g:4310:3: otherlv_1= RULE_ID
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
    // InternalInstance.g:4329:1: entryRuleSignedInt returns [String current=null] : iv_ruleSignedInt= ruleSignedInt EOF ;
    public final String entryRuleSignedInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedInt = null;


        try {
            // InternalInstance.g:4330:2: (iv_ruleSignedInt= ruleSignedInt EOF )
            // InternalInstance.g:4331:2: iv_ruleSignedInt= ruleSignedInt EOF
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
    // InternalInstance.g:4338:1: ruleSignedInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INTEGER_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4341:28: ( ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT ) )
            // InternalInstance.g:4342:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            {
            // InternalInstance.g:4342:1: ( (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT )
            // InternalInstance.g:4342:2: (kw= '+' | kw= '-' )? this_INTEGER_LIT_2= RULE_INTEGER_LIT
            {
            // InternalInstance.g:4342:2: (kw= '+' | kw= '-' )?
            int alt79=3;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==83) ) {
                alt79=1;
            }
            else if ( (LA79_0==84) ) {
                alt79=2;
            }
            switch (alt79) {
                case 1 :
                    // InternalInstance.g:4343:2: kw= '+'
                    {
                    kw=(Token)match(input,83,FOLLOW_9); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedIntAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4350:2: kw= '-'
                    {
                    kw=(Token)match(input,84,FOLLOW_9); 

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
    // InternalInstance.g:4370:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // InternalInstance.g:4371:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // InternalInstance.g:4372:2: iv_ruleRealTerm= ruleRealTerm EOF
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
    // InternalInstance.g:4379:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4382:28: ( ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? ) )
            // InternalInstance.g:4383:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            {
            // InternalInstance.g:4383:1: ( ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )? )
            // InternalInstance.g:4383:2: ( (lv_value_0_0= ruleSignedReal ) ) ( (otherlv_1= RULE_ID ) )?
            {
            // InternalInstance.g:4383:2: ( (lv_value_0_0= ruleSignedReal ) )
            // InternalInstance.g:4384:1: (lv_value_0_0= ruleSignedReal )
            {
            // InternalInstance.g:4384:1: (lv_value_0_0= ruleSignedReal )
            // InternalInstance.g:4385:3: lv_value_0_0= ruleSignedReal
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueSignedRealParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_76);
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

            // InternalInstance.g:4401:2: ( (otherlv_1= RULE_ID ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==RULE_ID) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalInstance.g:4402:1: (otherlv_1= RULE_ID )
                    {
                    // InternalInstance.g:4402:1: (otherlv_1= RULE_ID )
                    // InternalInstance.g:4403:3: otherlv_1= RULE_ID
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
    // InternalInstance.g:4422:1: entryRuleSignedReal returns [String current=null] : iv_ruleSignedReal= ruleSignedReal EOF ;
    public final String entryRuleSignedReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSignedReal = null;


        try {
            // InternalInstance.g:4423:2: (iv_ruleSignedReal= ruleSignedReal EOF )
            // InternalInstance.g:4424:2: iv_ruleSignedReal= ruleSignedReal EOF
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
    // InternalInstance.g:4431:1: ruleSignedReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) ;
    public final AntlrDatatypeRuleToken ruleSignedReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_REAL_LIT_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4434:28: ( ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT ) )
            // InternalInstance.g:4435:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            {
            // InternalInstance.g:4435:1: ( (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT )
            // InternalInstance.g:4435:2: (kw= '+' | kw= '-' )? this_REAL_LIT_2= RULE_REAL_LIT
            {
            // InternalInstance.g:4435:2: (kw= '+' | kw= '-' )?
            int alt81=3;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==83) ) {
                alt81=1;
            }
            else if ( (LA81_0==84) ) {
                alt81=2;
            }
            switch (alt81) {
                case 1 :
                    // InternalInstance.g:4436:2: kw= '+'
                    {
                    kw=(Token)match(input,83,FOLLOW_77); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSignedRealAccess().getPlusSignKeyword_0_0()); 
                        

                    }
                    break;
                case 2 :
                    // InternalInstance.g:4443:2: kw= '-'
                    {
                    kw=(Token)match(input,84,FOLLOW_77); 

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
    // InternalInstance.g:4463:1: entryRuleNumericRangeTerm returns [EObject current=null] : iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF ;
    public final EObject entryRuleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericRangeTerm = null;


        try {
            // InternalInstance.g:4464:2: (iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF )
            // InternalInstance.g:4465:2: iv_ruleNumericRangeTerm= ruleNumericRangeTerm EOF
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
    // InternalInstance.g:4472:1: ruleNumericRangeTerm returns [EObject current=null] : ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) ;
    public final EObject ruleNumericRangeTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_minimum_0_0 = null;

        EObject lv_maximum_2_0 = null;

        EObject lv_delta_4_0 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4475:28: ( ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? ) )
            // InternalInstance.g:4476:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            {
            // InternalInstance.g:4476:1: ( ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )? )
            // InternalInstance.g:4476:2: ( (lv_minimum_0_0= ruleNumAlt ) ) otherlv_1= '..' ( (lv_maximum_2_0= ruleNumAlt ) ) (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            {
            // InternalInstance.g:4476:2: ( (lv_minimum_0_0= ruleNumAlt ) )
            // InternalInstance.g:4477:1: (lv_minimum_0_0= ruleNumAlt )
            {
            // InternalInstance.g:4477:1: (lv_minimum_0_0= ruleNumAlt )
            // InternalInstance.g:4478:3: lv_minimum_0_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMinimumNumAltParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_78);
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

            otherlv_1=(Token)match(input,85,FOLLOW_75); 

                	newLeafNode(otherlv_1, grammarAccess.getNumericRangeTermAccess().getFullStopFullStopKeyword_1());
                
            // InternalInstance.g:4498:1: ( (lv_maximum_2_0= ruleNumAlt ) )
            // InternalInstance.g:4499:1: (lv_maximum_2_0= ruleNumAlt )
            {
            // InternalInstance.g:4499:1: (lv_maximum_2_0= ruleNumAlt )
            // InternalInstance.g:4500:3: lv_maximum_2_0= ruleNumAlt
            {
             
            	        newCompositeNode(grammarAccess.getNumericRangeTermAccess().getMaximumNumAltParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_79);
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

            // InternalInstance.g:4516:2: (otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==86) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalInstance.g:4516:4: otherlv_3= 'delta' ( (lv_delta_4_0= ruleNumAlt ) )
                    {
                    otherlv_3=(Token)match(input,86,FOLLOW_75); 

                        	newLeafNode(otherlv_3, grammarAccess.getNumericRangeTermAccess().getDeltaKeyword_3_0());
                        
                    // InternalInstance.g:4520:1: ( (lv_delta_4_0= ruleNumAlt ) )
                    // InternalInstance.g:4521:1: (lv_delta_4_0= ruleNumAlt )
                    {
                    // InternalInstance.g:4521:1: (lv_delta_4_0= ruleNumAlt )
                    // InternalInstance.g:4522:3: lv_delta_4_0= ruleNumAlt
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
    // InternalInstance.g:4546:1: entryRuleNumAlt returns [EObject current=null] : iv_ruleNumAlt= ruleNumAlt EOF ;
    public final EObject entryRuleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumAlt = null;


        try {
            // InternalInstance.g:4547:2: (iv_ruleNumAlt= ruleNumAlt EOF )
            // InternalInstance.g:4548:2: iv_ruleNumAlt= ruleNumAlt EOF
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
    // InternalInstance.g:4555:1: ruleNumAlt returns [EObject current=null] : (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) ;
    public final EObject ruleNumAlt() throws RecognitionException {
        EObject current = null;

        EObject this_RealTerm_0 = null;

        EObject this_IntegerTerm_1 = null;

        EObject this_SignedConstant_2 = null;

        EObject this_ConstantValue_3 = null;


         enterRule(); 
            
        try {
            // InternalInstance.g:4558:28: ( (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue ) )
            // InternalInstance.g:4559:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            {
            // InternalInstance.g:4559:1: (this_RealTerm_0= ruleRealTerm | this_IntegerTerm_1= ruleIntegerTerm | this_SignedConstant_2= ruleSignedConstant | this_ConstantValue_3= ruleConstantValue )
            int alt83=4;
            switch ( input.LA(1) ) {
            case 83:
                {
                switch ( input.LA(2) ) {
                case RULE_REAL_LIT:
                    {
                    alt83=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt83=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt83=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 1, input);

                    throw nvae;
                }

                }
                break;
            case 84:
                {
                switch ( input.LA(2) ) {
                case RULE_ID:
                    {
                    alt83=3;
                    }
                    break;
                case RULE_REAL_LIT:
                    {
                    alt83=1;
                    }
                    break;
                case RULE_INTEGER_LIT:
                    {
                    alt83=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 2, input);

                    throw nvae;
                }

                }
                break;
            case RULE_REAL_LIT:
                {
                alt83=1;
                }
                break;
            case RULE_INTEGER_LIT:
                {
                alt83=2;
                }
                break;
            case RULE_ID:
                {
                alt83=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // InternalInstance.g:4560:5: this_RealTerm_0= ruleRealTerm
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
                    // InternalInstance.g:4570:5: this_IntegerTerm_1= ruleIntegerTerm
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
                    // InternalInstance.g:4580:5: this_SignedConstant_2= ruleSignedConstant
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
                    // InternalInstance.g:4590:5: this_ConstantValue_3= ruleConstantValue
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
    // InternalInstance.g:4606:1: entryRuleAppliesToKeywords returns [String current=null] : iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF ;
    public final String entryRuleAppliesToKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAppliesToKeywords = null;


        try {
            // InternalInstance.g:4607:2: (iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF )
            // InternalInstance.g:4608:2: iv_ruleAppliesToKeywords= ruleAppliesToKeywords EOF
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
    // InternalInstance.g:4615:1: ruleAppliesToKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'applies' kw= 'to' ) ;
    public final AntlrDatatypeRuleToken ruleAppliesToKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4618:28: ( (kw= 'applies' kw= 'to' ) )
            // InternalInstance.g:4619:1: (kw= 'applies' kw= 'to' )
            {
            // InternalInstance.g:4619:1: (kw= 'applies' kw= 'to' )
            // InternalInstance.g:4620:2: kw= 'applies' kw= 'to'
            {
            kw=(Token)match(input,87,FOLLOW_33); 

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
    // InternalInstance.g:4639:1: entryRuleInBindingKeywords returns [String current=null] : iv_ruleInBindingKeywords= ruleInBindingKeywords EOF ;
    public final String entryRuleInBindingKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInBindingKeywords = null;


        try {
            // InternalInstance.g:4640:2: (iv_ruleInBindingKeywords= ruleInBindingKeywords EOF )
            // InternalInstance.g:4641:2: iv_ruleInBindingKeywords= ruleInBindingKeywords EOF
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
    // InternalInstance.g:4648:1: ruleInBindingKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' kw= 'binding' ) ;
    public final AntlrDatatypeRuleToken ruleInBindingKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4651:28: ( (kw= 'in' kw= 'binding' ) )
            // InternalInstance.g:4652:1: (kw= 'in' kw= 'binding' )
            {
            // InternalInstance.g:4652:1: (kw= 'in' kw= 'binding' )
            // InternalInstance.g:4653:2: kw= 'in' kw= 'binding'
            {
            kw=(Token)match(input,20,FOLLOW_80); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getInBindingKeywordsAccess().getInKeyword_0()); 
                
            kw=(Token)match(input,88,FOLLOW_2); 

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
    // InternalInstance.g:4672:1: entryRuleInModesKeywords returns [String current=null] : iv_ruleInModesKeywords= ruleInModesKeywords EOF ;
    public final String entryRuleInModesKeywords() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInModesKeywords = null;


        try {
            // InternalInstance.g:4673:2: (iv_ruleInModesKeywords= ruleInModesKeywords EOF )
            // InternalInstance.g:4674:2: iv_ruleInModesKeywords= ruleInModesKeywords EOF
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
    // InternalInstance.g:4681:1: ruleInModesKeywords returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' kw= 'modes' ) ;
    public final AntlrDatatypeRuleToken ruleInModesKeywords() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4684:28: ( (kw= 'in' kw= 'modes' ) )
            // InternalInstance.g:4685:1: (kw= 'in' kw= 'modes' )
            {
            // InternalInstance.g:4685:1: (kw= 'in' kw= 'modes' )
            // InternalInstance.g:4686:2: kw= 'in' kw= 'modes'
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
    // InternalInstance.g:4705:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // InternalInstance.g:4706:2: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // InternalInstance.g:4707:2: iv_ruleINTVALUE= ruleINTVALUE EOF
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
    // InternalInstance.g:4714:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4717:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // InternalInstance.g:4718:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
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
    // InternalInstance.g:4735:1: entryRuleQPREF returns [String current=null] : iv_ruleQPREF= ruleQPREF EOF ;
    public final String entryRuleQPREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQPREF = null;


        try {
            // InternalInstance.g:4736:2: (iv_ruleQPREF= ruleQPREF EOF )
            // InternalInstance.g:4737:2: iv_ruleQPREF= ruleQPREF EOF
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
    // InternalInstance.g:4744:1: ruleQPREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQPREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4747:28: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // InternalInstance.g:4748:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // InternalInstance.g:4748:1: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // InternalInstance.g:4748:6: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_81); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQPREFAccess().getIDTerminalRuleCall_0()); 
                
            // InternalInstance.g:4755:1: (kw= '::' this_ID_2= RULE_ID )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==70) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalInstance.g:4756:2: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,70,FOLLOW_3); 

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
    // InternalInstance.g:4776:1: entryRuleQCREF returns [String current=null] : iv_ruleQCREF= ruleQCREF EOF ;
    public final String entryRuleQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQCREF = null;


        try {
            // InternalInstance.g:4777:2: (iv_ruleQCREF= ruleQCREF EOF )
            // InternalInstance.g:4778:2: iv_ruleQCREF= ruleQCREF EOF
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
    // InternalInstance.g:4785:1: ruleQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4788:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // InternalInstance.g:4789:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // InternalInstance.g:4789:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // InternalInstance.g:4789:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // InternalInstance.g:4789:2: (this_ID_0= RULE_ID kw= '::' )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==RULE_ID) ) {
                    int LA85_1 = input.LA(2);

                    if ( (LA85_1==70) ) {
                        alt85=1;
                    }


                }


                switch (alt85) {
            	case 1 :
            	    // InternalInstance.g:4789:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_56); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,70,FOLLOW_3); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQCREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_57); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // InternalInstance.g:4809:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==71) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalInstance.g:4810:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,71,FOLLOW_3); 

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
    // InternalInstance.g:4830:1: entryRuleSTAR returns [String current=null] : iv_ruleSTAR= ruleSTAR EOF ;
    public final String entryRuleSTAR() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTAR = null;


        try {
            // InternalInstance.g:4831:2: (iv_ruleSTAR= ruleSTAR EOF )
            // InternalInstance.g:4832:2: iv_ruleSTAR= ruleSTAR EOF
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
    // InternalInstance.g:4839:1: ruleSTAR returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '*' ;
    public final AntlrDatatypeRuleToken ruleSTAR() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // InternalInstance.g:4842:28: (kw= '*' )
            // InternalInstance.g:4844:2: kw= '*'
            {
            kw=(Token)match(input,89,FOLLOW_2); 

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
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA58 dfa58 = new DFA58(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\4\7\uffff\1\4\3\uffff";
    static final String dfa_3s = "\1\105\7\uffff\1\45\3\uffff";
    static final String dfa_4s = "\1\uffff\1\12\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\11\1\7";
    static final String dfa_5s = "\14\uffff}>";
    static final String[] dfa_6s = {
            "\1\12\14\uffff\1\1\2\uffff\1\2\4\uffff\1\4\4\uffff\1\5\1\6\1\uffff\2\7\1\10\2\uffff\1\11\3\uffff\1\2\12\uffff\10\3\1\uffff\3\3\5\4",
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
    static final String dfa_9s = "\1\105\7\uffff\1\45\2\uffff";
    static final String dfa_10s = "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\7";
    static final String dfa_11s = "\13\uffff}>";
    static final String[] dfa_12s = {
            "\1\11\14\uffff\1\1\2\uffff\1\2\4\uffff\1\4\4\uffff\1\5\1\6\1\uffff\2\7\1\10\6\uffff\1\2\12\uffff\10\3\1\uffff\3\3\5\4",
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
    static final String dfa_16s = "\1\124\1\uffff\1\26\3\uffff\2\7\3\127\2\uffff\1\112\1\uffff\1\127\1\uffff\1\127\1\uffff\1\4\2\uffff\1\107\1\127\1\uffff";
    static final String dfa_17s = "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\5\uffff\1\12\1\13\1\uffff\1\7\1\uffff\1\10\1\uffff\1\11\1\uffff\1\14\1\3\2\uffff\1\2";
    static final String dfa_18s = "\31\uffff}>";
    static final String[] dfa_19s = {
            "\1\12\1\5\1\11\1\10\12\uffff\1\1\3\uffff\1\13\22\uffff\1\2\45\uffff\2\14\1\4\1\3\1\6\1\7",
            "",
            "\1\15",
            "",
            "",
            "",
            "\1\16\1\uffff\1\11\1\10",
            "\1\16\1\uffff\1\11\1\10",
            "\1\17\12\uffff\1\20\4\uffff\1\20\2\uffff\2\20\65\uffff\1\20\6\uffff\1\16\1\uffff\1\20",
            "\1\21\12\uffff\1\22\4\uffff\1\22\2\uffff\2\22\65\uffff\1\22\6\uffff\1\16\1\uffff\1\22",
            "\1\24\4\uffff\1\24\2\uffff\2\24\55\uffff\1\23\7\uffff\1\24\6\uffff\1\16\1\uffff\1\24",
            "",
            "",
            "\1\26\104\uffff\2\25",
            "",
            "\1\20\4\uffff\1\20\2\uffff\2\20\65\uffff\1\20\6\uffff\1\16\1\uffff\1\20",
            "",
            "\1\22\4\uffff\1\22\2\uffff\2\22\65\uffff\1\22\6\uffff\1\16\1\uffff\1\22",
            "",
            "\1\27",
            "",
            "",
            "\1\25\5\uffff\1\25\55\uffff\1\30\1\25",
            "\1\24\4\uffff\1\24\2\uffff\2\24\65\uffff\1\24\6\uffff\1\16\1\uffff\1\24",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "2189:1: (this_RecordTerm_0= ruleRecordTerm | this_ReferenceTerm_1= ruleReferenceTerm | this_InstanceReferenceValue_2= ruleInstanceReferenceValue | this_ComponentClassifierTerm_3= ruleComponentClassifierTerm | this_ComputedTerm_4= ruleComputedTerm | this_StringTerm_5= ruleStringTerm | this_NumericRangeTerm_6= ruleNumericRangeTerm | this_RealTerm_7= ruleRealTerm | this_IntegerTerm_8= ruleIntegerTerm | this_ListTerm_9= ruleListTerm | this_BooleanLiteral_10= ruleBooleanLiteral | this_LiteralorReferenceTerm_11= ruleLiteralorReferenceTerm )";
        }
    }
    static final String dfa_20s = "\22\uffff";
    static final String dfa_21s = "\10\uffff\1\15\1\uffff\1\17\7\uffff";
    static final String dfa_22s = "\1\65\7\uffff\1\4\1\uffff\1\4\1\66\6\uffff";
    static final String dfa_23s = "\1\100\7\uffff\1\75\1\uffff\1\75\1\73\6\uffff";
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
            "\1\15\70\uffff\1\14",
            "",
            "\1\17\70\uffff\1\16",
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

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "2590:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String dfa_27s = "\7\uffff";
    static final String dfa_28s = "\2\uffff\1\1\3\uffff\1\1";
    static final String dfa_29s = "\1\4\1\uffff\1\4\1\6\1\uffff\1\23\1\4";
    static final String dfa_30s = "\1\112\1\uffff\1\112\1\6\1\uffff\1\23\1\112";
    static final String dfa_31s = "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String dfa_32s = "\7\uffff}>";
    static final String[] dfa_33s = {
            "\1\2\105\uffff\1\1",
            "",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\2\uffff\2\1\1\uffff\3\1\2\uffff\1\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1",
            "\1\5",
            "",
            "\1\6",
            "\1\1\12\uffff\3\1\1\3\1\uffff\1\1\2\uffff\5\1\2\uffff\2\1\1\uffff\3\1\2\uffff\1\1\3\uffff\1\1\12\uffff\10\1\1\uffff\10\1\1\uffff\1\4\1\uffff\2\1"
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final char[] dfa_30 = DFA.unpackEncodedStringToUnsignedChars(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[][] dfa_33 = unpackEncodedStringArray(dfa_33s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_27;
            this.eof = dfa_28;
            this.min = dfa_29;
            this.max = dfa_30;
            this.accept = dfa_31;
            this.special = dfa_32;
            this.transition = dfa_33;
        }
        public String getDescription() {
            return "()* loopback of 2989:7: (this_ID_1= RULE_ID (kw= '[' this_INTEGER_LIT_3= RULE_INTEGER_LIT kw= ']' )* kw= '.' )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0xDFE0044EC2120010L,0x000000000000003FL});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x001FF80000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000148000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002000000L,0x000000000000003EL});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000600L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xDFE0044EC2100010L,0x000000000000063FL});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0xDFE0044EC2120010L,0x000000000000063FL});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000008000010L,0x0000000000000600L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000001000010L,0x0000000000000600L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0xDFE0044EC2100010L,0x000000000000003FL});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000108010L,0x0000000000000600L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000008108000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000C00000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000001000008000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000012L,0x0000000000000600L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0xDFE0064EC25400F0L,0x00000000001F803FL});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000808000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000010000040002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000008000L,0x0000000000000080L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000002000000010L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000080L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000400L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000002000000010L,0x0000000000000800L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000008000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0xDFE0064EC25400F0L,0x00000000001FA03FL});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000900000L,0x0000000000804000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000900000L,0x0000000000004000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0xDFE0064EC35400F0L,0x00000000001F803FL});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000080000L,0x0000000000200000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0xDFE0044EC21000D0L,0x000000000018003FL});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000002L,0x0000000000400000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});

}