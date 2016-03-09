package org.osate.xtext.aadl2.instance.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.xtext.aadl2.instance.services.InstanceGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalInstanceParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_LONG", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "':'", "'{'", "'}'", "'['", "']'", "'source'", "'of'", "'('", "','", "')'", "'destination'", "'in'", "'modes'", "'complete'", "'<->'", "'->'", "'flow'", "'end'", "'to'", "'initial'", "'derived'", "'mode'", "'='", "'transition'", "'som'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'featureConnection'", "'accessConnection'", "'parameterConnection'", "'portConnection'", "'modeTransitionConnection'", "'featureGroupConnection'", "'::'", "'.'", "'parent'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__10=10;
    public static final int T__54=54;
    public static final int T__9=9;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=7;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=8;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int RULE_LONG=5;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalInstanceParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalInstanceParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalInstanceParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g"; }



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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:67:1: entryRuleSystemInstance returns [EObject current=null] : iv_ruleSystemInstance= ruleSystemInstance EOF ;
    public final EObject entryRuleSystemInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:68:2: (iv_ruleSystemInstance= ruleSystemInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:69:2: iv_ruleSystemInstance= ruleSystemInstance EOF
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:76:1: ruleSystemInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) )* otherlv_13= '}' ) ;
    public final EObject ruleSystemInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_5_0 = null;

        EObject lv_componentInstance_6_0 = null;

        EObject lv_connectionInstance_7_0 = null;

        EObject lv_flowSpecification_8_0 = null;

        EObject lv_endToEndFlow_9_0 = null;

        EObject lv_modeInstance_10_0 = null;

        EObject lv_modeTransitionInstance_11_0 = null;

        EObject lv_systemOperationMode_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:79:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) )* otherlv_13= '}' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) )* otherlv_13= '}' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) )* otherlv_13= '}' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) )* otherlv_13= '}'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:81:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:81:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:82:3: lv_category_0_0= ruleComponentCategory
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:98:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:99:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:99:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:100:3: lv_name_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,9,FOLLOW_9_in_ruleSystemInstance165); 

                	newLeafNode(otherlv_2, grammarAccess.getSystemInstanceAccess().getColonKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:120:1: ( ( ruleIMPLREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:121:1: ( ruleIMPLREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:121:1: ( ruleIMPLREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:122:3: ruleIMPLREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleIMPLREF_in_ruleSystemInstance188);
            ruleIMPLREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,10,FOLLOW_10_in_ruleSystemInstance200); 

                	newLeafNode(otherlv_4, grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:139:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) )*
            loop1:
            do {
                int alt1=9;
                alt1 = dfa1.predict(input);
                switch (alt1) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:139:2: ( (lv_featureInstance_5_0= ruleFeatureInstance ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:139:2: ( (lv_featureInstance_5_0= ruleFeatureInstance ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:140:1: (lv_featureInstance_5_0= ruleFeatureInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:140:1: (lv_featureInstance_5_0= ruleFeatureInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:141:3: lv_featureInstance_5_0= ruleFeatureInstance
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:158:6: ( (lv_componentInstance_6_0= ruleComponentInstance ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:158:6: ( (lv_componentInstance_6_0= ruleComponentInstance ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:159:1: (lv_componentInstance_6_0= ruleComponentInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:159:1: (lv_componentInstance_6_0= ruleComponentInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:160:3: lv_componentInstance_6_0= ruleComponentInstance
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:177:6: ( (lv_connectionInstance_7_0= ruleConnectionInstance ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:177:6: ( (lv_connectionInstance_7_0= ruleConnectionInstance ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:178:1: (lv_connectionInstance_7_0= ruleConnectionInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:178:1: (lv_connectionInstance_7_0= ruleConnectionInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:179:3: lv_connectionInstance_7_0= ruleConnectionInstance
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:196:6: ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:196:6: ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:197:1: (lv_flowSpecification_8_0= ruleFlowSpecificationInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:197:1: (lv_flowSpecification_8_0= ruleFlowSpecificationInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:198:3: lv_flowSpecification_8_0= ruleFlowSpecificationInstance
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:215:6: ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:215:6: ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:216:1: (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:216:1: (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:217:3: lv_endToEndFlow_9_0= ruleEndToEndFlowInstance
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:234:6: ( (lv_modeInstance_10_0= ruleModeInstance ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:234:6: ( (lv_modeInstance_10_0= ruleModeInstance ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:235:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:235:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:236:3: lv_modeInstance_10_0= ruleModeInstance
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:253:6: ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:253:6: ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:254:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:254:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:255:3: lv_modeTransitionInstance_11_0= ruleModeTransitionInstance
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:272:6: ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:272:6: ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:273:1: (lv_systemOperationMode_12_0= ruleSystemOperationMode )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:273:1: (lv_systemOperationMode_12_0= ruleSystemOperationMode )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:274:3: lv_systemOperationMode_12_0= ruleSystemOperationMode
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

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_13=(Token)match(input,11,FOLLOW_11_in_ruleSystemInstance425); 

                	newLeafNode(otherlv_13, grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:302:1: entryRuleFeatureInstance returns [EObject current=null] : iv_ruleFeatureInstance= ruleFeatureInstance EOF ;
    public final EObject entryRuleFeatureInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:303:2: (iv_ruleFeatureInstance= ruleFeatureInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:304:2: iv_ruleFeatureInstance= ruleFeatureInstance EOF
            {
             newCompositeNode(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance461);
            iv_ruleFeatureInstance=ruleFeatureInstance();

            state._fsp--;

             current =iv_ruleFeatureInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance471); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:311:1: ruleFeatureInstance returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? ) ;
    public final EObject ruleFeatureInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_index_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        AntlrDatatypeRuleToken lv_direction_0_0 = null;

        AntlrDatatypeRuleToken lv_category_1_0 = null;

        EObject lv_featureInstance_27_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:314:28: ( ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:315:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:315:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:315:2: ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:315:2: ( (lv_direction_0_0= ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:316:1: (lv_direction_0_0= ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:316:1: (lv_direction_0_0= ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:317:3: lv_direction_0_0= ruleDirectionType
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDirectionType_in_ruleFeatureInstance517);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:333:2: ( (lv_category_1_0= ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:334:1: (lv_category_1_0= ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:334:1: (lv_category_1_0= ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:335:3: lv_category_1_0= ruleFeatureCategory
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance538);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:351:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:352:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:352:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:353:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance555); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:369:2: (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:369:4: otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleFeatureInstance573); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:373:1: ( (lv_index_4_0= RULE_LONG ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:374:1: (lv_index_4_0= RULE_LONG )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:374:1: (lv_index_4_0= RULE_LONG )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:375:3: lv_index_4_0= RULE_LONG
                    {
                    lv_index_4_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFeatureInstance590); 

                    			newLeafNode(lv_index_4_0, grammarAccess.getFeatureInstanceAccess().getIndexLONGTerminalRuleCall_3_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"index",
                            		lv_index_4_0, 
                            		"LONG");
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleFeatureInstance607); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,9,FOLLOW_9_in_ruleFeatureInstance621); 

                	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:399:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:400:1: ( ruleFEATREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:400:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:401:3: ruleFEATREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFEATREF_in_ruleFeatureInstance644);
            ruleFEATREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:414:2: (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:414:4: otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')'
                    {
                    otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleFeatureInstance657); 

                        	newLeafNode(otherlv_8, grammarAccess.getFeatureInstanceAccess().getSourceKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleFeatureInstance669); 

                        	newLeafNode(otherlv_9, grammarAccess.getFeatureInstanceAccess().getOfKeyword_6_1());
                        
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleFeatureInstance681); 

                        	newLeafNode(otherlv_10, grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:426:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==RULE_LONG) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==RULE_ID) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:426:2: ( ( ruleCONNINSTREF ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:426:2: ( ( ruleCONNINSTREF ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:427:1: ( ruleCONNINSTREF )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:427:1: ( ruleCONNINSTREF )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:428:3: ruleCONNINSTREF
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance705);
                            ruleCONNINSTREF();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:442:6: ( (otherlv_12= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:442:6: ( (otherlv_12= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:443:1: (otherlv_12= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:443:1: (otherlv_12= RULE_ID )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:444:3: otherlv_12= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                            otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance731); 

                            		newLeafNode(otherlv_12, grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceCrossReference_6_3_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:455:3: (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==17) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:455:5: otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) )
                    	    {
                    	    otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleFeatureInstance745); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getFeatureInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:459:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) )
                    	    int alt4=2;
                    	    int LA4_0 = input.LA(1);

                    	    if ( (LA4_0==RULE_LONG) ) {
                    	        alt4=1;
                    	    }
                    	    else if ( (LA4_0==RULE_ID) ) {
                    	        alt4=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 4, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt4) {
                    	        case 1 :
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:459:2: ( ( ruleCONNINSTREF ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:459:2: ( ( ruleCONNINSTREF ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:460:1: ( ruleCONNINSTREF )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:460:1: ( ruleCONNINSTREF )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:461:3: ruleCONNINSTREF
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_4_1_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance769);
                    	            ruleCONNINSTREF();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:475:6: ( (otherlv_15= RULE_ID ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:475:6: ( (otherlv_15= RULE_ID ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:476:1: (otherlv_15= RULE_ID )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:476:1: (otherlv_15= RULE_ID )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:477:3: otherlv_15= RULE_ID
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	            otherlv_15=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance795); 

                    	            		newLeafNode(otherlv_15, grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceCrossReference_6_4_1_1_0()); 
                    	            	

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_16=(Token)match(input,18,FOLLOW_18_in_ruleFeatureInstance810); 

                        	newLeafNode(otherlv_16, grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:492:3: (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:492:5: otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')'
                    {
                    otherlv_17=(Token)match(input,19,FOLLOW_19_in_ruleFeatureInstance825); 

                        	newLeafNode(otherlv_17, grammarAccess.getFeatureInstanceAccess().getDestinationKeyword_7_0());
                        
                    otherlv_18=(Token)match(input,15,FOLLOW_15_in_ruleFeatureInstance837); 

                        	newLeafNode(otherlv_18, grammarAccess.getFeatureInstanceAccess().getOfKeyword_7_1());
                        
                    otherlv_19=(Token)match(input,16,FOLLOW_16_in_ruleFeatureInstance849); 

                        	newLeafNode(otherlv_19, grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:504:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) )
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==RULE_LONG) ) {
                        alt7=1;
                    }
                    else if ( (LA7_0==RULE_ID) ) {
                        alt7=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 0, input);

                        throw nvae;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:504:2: ( ( ruleCONNINSTREF ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:504:2: ( ( ruleCONNINSTREF ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:505:1: ( ruleCONNINSTREF )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:505:1: ( ruleCONNINSTREF )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:506:3: ruleCONNINSTREF
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance873);
                            ruleCONNINSTREF();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:520:6: ( (otherlv_21= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:520:6: ( (otherlv_21= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:521:1: (otherlv_21= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:521:1: (otherlv_21= RULE_ID )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:522:3: otherlv_21= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                            otherlv_21=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance899); 

                            		newLeafNode(otherlv_21, grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceCrossReference_7_3_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:533:3: (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==17) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:533:5: otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) )
                    	    {
                    	    otherlv_22=(Token)match(input,17,FOLLOW_17_in_ruleFeatureInstance913); 

                    	        	newLeafNode(otherlv_22, grammarAccess.getFeatureInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:537:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) )
                    	    int alt8=2;
                    	    int LA8_0 = input.LA(1);

                    	    if ( (LA8_0==RULE_LONG) ) {
                    	        alt8=1;
                    	    }
                    	    else if ( (LA8_0==RULE_ID) ) {
                    	        alt8=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 8, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt8) {
                    	        case 1 :
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:537:2: ( ( ruleCONNINSTREF ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:537:2: ( ( ruleCONNINSTREF ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:538:1: ( ruleCONNINSTREF )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:538:1: ( ruleCONNINSTREF )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:539:3: ruleCONNINSTREF
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_4_1_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance937);
                    	            ruleCONNINSTREF();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:553:6: ( (otherlv_24= RULE_ID ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:553:6: ( (otherlv_24= RULE_ID ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:554:1: (otherlv_24= RULE_ID )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:554:1: (otherlv_24= RULE_ID )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:555:3: otherlv_24= RULE_ID
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	            otherlv_24=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance963); 

                    	            		newLeafNode(otherlv_24, grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceCrossReference_7_4_1_1_0()); 
                    	            	

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_25=(Token)match(input,18,FOLLOW_18_in_ruleFeatureInstance978); 

                        	newLeafNode(otherlv_25, grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:570:3: (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==10) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:570:5: otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}'
                    {
                    otherlv_26=(Token)match(input,10,FOLLOW_10_in_ruleFeatureInstance993); 

                        	newLeafNode(otherlv_26, grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:574:1: ( (lv_featureInstance_27_0= ruleFeatureInstance ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==20||LA11_0==34) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:575:1: (lv_featureInstance_27_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:575:1: (lv_featureInstance_27_0= ruleFeatureInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:576:3: lv_featureInstance_27_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance1014);
                    	    lv_featureInstance_27_0=ruleFeatureInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureInstance",
                    	            		lv_featureInstance_27_0, 
                    	            		"FeatureInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_28=(Token)match(input,11,FOLLOW_11_in_ruleFeatureInstance1027); 

                        	newLeafNode(otherlv_28, grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_8_2());
                        

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:604:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:605:2: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:606:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance1065);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance1075); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:613:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleSUBREF ) ) (otherlv_14= 'source' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= 'destination' otherlv_22= 'of' otherlv_23= '(' ( ( ruleCONNINSTREF ) ) (otherlv_25= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_27= ')' )? (otherlv_28= '{' ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )* otherlv_36= '}' )? ) ;
    public final EObject ruleComponentInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_index_3_0=null;
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
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_36=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_29_0 = null;

        EObject lv_componentInstance_30_0 = null;

        EObject lv_connectionInstance_31_0 = null;

        EObject lv_flowSpecification_32_0 = null;

        EObject lv_endToEndFlow_33_0 = null;

        EObject lv_modeInstance_34_0 = null;

        EObject lv_modeTransitionInstance_35_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:616:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleSUBREF ) ) (otherlv_14= 'source' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= 'destination' otherlv_22= 'of' otherlv_23= '(' ( ( ruleCONNINSTREF ) ) (otherlv_25= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_27= ')' )? (otherlv_28= '{' ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )* otherlv_36= '}' )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:617:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleSUBREF ) ) (otherlv_14= 'source' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= 'destination' otherlv_22= 'of' otherlv_23= '(' ( ( ruleCONNINSTREF ) ) (otherlv_25= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_27= ')' )? (otherlv_28= '{' ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )* otherlv_36= '}' )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:617:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleSUBREF ) ) (otherlv_14= 'source' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= 'destination' otherlv_22= 'of' otherlv_23= '(' ( ( ruleCONNINSTREF ) ) (otherlv_25= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_27= ')' )? (otherlv_28= '{' ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )* otherlv_36= '}' )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:617:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )? otherlv_12= ':' ( ( ruleSUBREF ) ) (otherlv_14= 'source' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= 'destination' otherlv_22= 'of' otherlv_23= '(' ( ( ruleCONNINSTREF ) ) (otherlv_25= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_27= ')' )? (otherlv_28= '{' ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )* otherlv_36= '}' )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:617:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:618:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:618:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:619:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleComponentInstance1121);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:635:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:636:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:636:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:637:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance1138); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:653:2: (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==12) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:653:4: otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']'
            	    {
            	    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleComponentInstance1156); 

            	        	newLeafNode(otherlv_2, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0());
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:657:1: ( (lv_index_3_0= RULE_LONG ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:658:1: (lv_index_3_0= RULE_LONG )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:658:1: (lv_index_3_0= RULE_LONG )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:659:3: lv_index_3_0= RULE_LONG
            	    {
            	    lv_index_3_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleComponentInstance1173); 

            	    			newLeafNode(lv_index_3_0, grammarAccess.getComponentInstanceAccess().getIndexLONGTerminalRuleCall_2_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"index",
            	            		lv_index_3_0, 
            	            		"LONG");
            	    	    

            	    }


            	    }

            	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleComponentInstance1190); 

            	        	newLeafNode(otherlv_4, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:679:3: (otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==20) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:679:5: otherlv_5= 'in' otherlv_6= 'modes' otherlv_7= '(' ( (otherlv_8= RULE_ID ) ) (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )* otherlv_11= ')'
                    {
                    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleComponentInstance1205); 

                        	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getInKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleComponentInstance1217); 

                        	newLeafNode(otherlv_6, grammarAccess.getComponentInstanceAccess().getModesKeyword_3_1());
                        
                    otherlv_7=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1229); 

                        	newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_3_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:691:1: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:692:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:692:1: (otherlv_8= RULE_ID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:693:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance1249); 

                    		newLeafNode(otherlv_8, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_3_3_0()); 
                    	

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:704:2: (otherlv_9= ',' ( (otherlv_10= RULE_ID ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:704:4: otherlv_9= ',' ( (otherlv_10= RULE_ID ) )
                    	    {
                    	    otherlv_9=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1262); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getComponentInstanceAccess().getCommaKeyword_3_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:708:1: ( (otherlv_10= RULE_ID ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:709:1: (otherlv_10= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:709:1: (otherlv_10= RULE_ID )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:710:3: otherlv_10= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance1282); 

                    	    		newLeafNode(otherlv_10, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_3_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance1296); 

                        	newLeafNode(otherlv_11, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_3_5());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,9,FOLLOW_9_in_ruleComponentInstance1310); 

                	newLeafNode(otherlv_12, grammarAccess.getComponentInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:729:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:730:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:730:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:731:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleComponentInstance1333);
            ruleSUBREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:744:2: (otherlv_14= 'source' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==14) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:744:4: otherlv_14= 'source' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')'
                    {
                    otherlv_14=(Token)match(input,14,FOLLOW_14_in_ruleComponentInstance1346); 

                        	newLeafNode(otherlv_14, grammarAccess.getComponentInstanceAccess().getSourceKeyword_6_0());
                        
                    otherlv_15=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance1358); 

                        	newLeafNode(otherlv_15, grammarAccess.getComponentInstanceAccess().getOfKeyword_6_1());
                        
                    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1370); 

                        	newLeafNode(otherlv_16, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:756:1: ( ( ruleCONNINSTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:757:1: ( ruleCONNINSTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:757:1: ( ruleCONNINSTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:758:3: ruleCONNINSTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1393);
                    ruleCONNINSTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:771:2: (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==17) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:771:4: otherlv_18= ',' ( ( ruleCONNINSTREF ) )
                    	    {
                    	    otherlv_18=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1406); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getComponentInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:775:1: ( ( ruleCONNINSTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:776:1: ( ruleCONNINSTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:776:1: ( ruleCONNINSTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:777:3: ruleCONNINSTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1429);
                    	    ruleCONNINSTREF();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_20=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance1443); 

                        	newLeafNode(otherlv_20, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:794:3: (otherlv_21= 'destination' otherlv_22= 'of' otherlv_23= '(' ( ( ruleCONNINSTREF ) ) (otherlv_25= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_27= ')' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==19) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:794:5: otherlv_21= 'destination' otherlv_22= 'of' otherlv_23= '(' ( ( ruleCONNINSTREF ) ) (otherlv_25= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_27= ')'
                    {
                    otherlv_21=(Token)match(input,19,FOLLOW_19_in_ruleComponentInstance1458); 

                        	newLeafNode(otherlv_21, grammarAccess.getComponentInstanceAccess().getDestinationKeyword_7_0());
                        
                    otherlv_22=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance1470); 

                        	newLeafNode(otherlv_22, grammarAccess.getComponentInstanceAccess().getOfKeyword_7_1());
                        
                    otherlv_23=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1482); 

                        	newLeafNode(otherlv_23, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:806:1: ( ( ruleCONNINSTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:807:1: ( ruleCONNINSTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:807:1: ( ruleCONNINSTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:808:3: ruleCONNINSTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1505);
                    ruleCONNINSTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:821:2: (otherlv_25= ',' ( ( ruleCONNINSTREF ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==17) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:821:4: otherlv_25= ',' ( ( ruleCONNINSTREF ) )
                    	    {
                    	    otherlv_25=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1518); 

                    	        	newLeafNode(otherlv_25, grammarAccess.getComponentInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:825:1: ( ( ruleCONNINSTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:826:1: ( ruleCONNINSTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:826:1: ( ruleCONNINSTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:827:3: ruleCONNINSTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1541);
                    	    ruleCONNINSTREF();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance1555); 

                        	newLeafNode(otherlv_27, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:844:3: (otherlv_28= '{' ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )* otherlv_36= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==10) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:844:5: otherlv_28= '{' ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )* otherlv_36= '}'
                    {
                    otherlv_28=(Token)match(input,10,FOLLOW_10_in_ruleComponentInstance1570); 

                        	newLeafNode(otherlv_28, grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:848:1: ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )*
                    loop20:
                    do {
                        int alt20=8;
                        alt20 = dfa20.predict(input);
                        switch (alt20) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:848:2: ( (lv_featureInstance_29_0= ruleFeatureInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:848:2: ( (lv_featureInstance_29_0= ruleFeatureInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:849:1: (lv_featureInstance_29_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:849:1: (lv_featureInstance_29_0= ruleFeatureInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:850:3: lv_featureInstance_29_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1592);
                    	    lv_featureInstance_29_0=ruleFeatureInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureInstance",
                    	            		lv_featureInstance_29_0, 
                    	            		"FeatureInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:867:6: ( (lv_componentInstance_30_0= ruleComponentInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:867:6: ( (lv_componentInstance_30_0= ruleComponentInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:868:1: (lv_componentInstance_30_0= ruleComponentInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:868:1: (lv_componentInstance_30_0= ruleComponentInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:869:3: lv_componentInstance_30_0= ruleComponentInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_8_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleComponentInstance1619);
                    	    lv_componentInstance_30_0=ruleComponentInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"componentInstance",
                    	            		lv_componentInstance_30_0, 
                    	            		"ComponentInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:886:6: ( (lv_connectionInstance_31_0= ruleConnectionInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:886:6: ( (lv_connectionInstance_31_0= ruleConnectionInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:887:1: (lv_connectionInstance_31_0= ruleConnectionInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:887:1: (lv_connectionInstance_31_0= ruleConnectionInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:888:3: lv_connectionInstance_31_0= ruleConnectionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_8_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1646);
                    	    lv_connectionInstance_31_0=ruleConnectionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connectionInstance",
                    	            		lv_connectionInstance_31_0, 
                    	            		"ConnectionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:905:6: ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:905:6: ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:906:1: (lv_flowSpecification_32_0= ruleFlowSpecificationInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:906:1: (lv_flowSpecification_32_0= ruleFlowSpecificationInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:907:3: lv_flowSpecification_32_0= ruleFlowSpecificationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_8_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1673);
                    	    lv_flowSpecification_32_0=ruleFlowSpecificationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"flowSpecification",
                    	            		lv_flowSpecification_32_0, 
                    	            		"FlowSpecificationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:924:6: ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:924:6: ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:925:1: (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:925:1: (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:926:3: lv_endToEndFlow_33_0= ruleEndToEndFlowInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_8_1_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance1700);
                    	    lv_endToEndFlow_33_0=ruleEndToEndFlowInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"endToEndFlow",
                    	            		lv_endToEndFlow_33_0, 
                    	            		"EndToEndFlowInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 6 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:943:6: ( (lv_modeInstance_34_0= ruleModeInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:943:6: ( (lv_modeInstance_34_0= ruleModeInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:944:1: (lv_modeInstance_34_0= ruleModeInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:944:1: (lv_modeInstance_34_0= ruleModeInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:945:3: lv_modeInstance_34_0= ruleModeInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_8_1_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModeInstance_in_ruleComponentInstance1727);
                    	    lv_modeInstance_34_0=ruleModeInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeInstance",
                    	            		lv_modeInstance_34_0, 
                    	            		"ModeInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 7 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:962:6: ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:962:6: ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:963:1: (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:963:1: (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:964:3: lv_modeTransitionInstance_35_0= ruleModeTransitionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_8_1_6_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance1754);
                    	    lv_modeTransitionInstance_35_0=ruleModeTransitionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeTransitionInstance",
                    	            		lv_modeTransitionInstance_35_0, 
                    	            		"ModeTransitionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_36=(Token)match(input,11,FOLLOW_11_in_ruleComponentInstance1768); 

                        	newLeafNode(otherlv_36, grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_8_2());
                        

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:992:1: entryRuleConnectionInstance returns [EObject current=null] : iv_ruleConnectionInstance= ruleConnectionInstance EOF ;
    public final EObject entryRuleConnectionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:993:2: (iv_ruleConnectionInstance= ruleConnectionInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:994:2: iv_ruleConnectionInstance= ruleConnectionInstance EOF
            {
             newCompositeNode(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1806);
            iv_ruleConnectionInstance=ruleConnectionInstance();

            state._fsp--;

             current =iv_ruleConnectionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance1816); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1001:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= '{' ( (lv_connectionReference_16_0= ruleConnectionReference ) )+ otherlv_17= '}' ) ;
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
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_kind_1_0 = null;

        EObject lv_connectionReference_16_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1004:28: ( ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= '{' ( (lv_connectionReference_16_0= ruleConnectionReference ) )+ otherlv_17= '}' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1005:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= '{' ( (lv_connectionReference_16_0= ruleConnectionReference ) )+ otherlv_17= '}' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1005:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= '{' ( (lv_connectionReference_16_0= ruleConnectionReference ) )+ otherlv_17= '}' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1005:2: ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= '{' ( (lv_connectionReference_16_0= ruleConnectionReference ) )+ otherlv_17= '}'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1005:2: ( (lv_complete_0_0= 'complete' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==22) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1006:1: (lv_complete_0_0= 'complete' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1006:1: (lv_complete_0_0= 'complete' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1007:3: lv_complete_0_0= 'complete'
                    {
                    lv_complete_0_0=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance1859); 

                            newLeafNode(lv_complete_0_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "complete", true, "complete");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1020:3: ( (lv_kind_1_0= ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1021:1: (lv_kind_1_0= ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1021:1: (lv_kind_1_0= ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1022:3: lv_kind_1_0= ruleConnectionKind
            {
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1894);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1038:2: ( (lv_name_2_0= RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1039:1: (lv_name_2_0= RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1039:1: (lv_name_2_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1040:3: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConnectionInstance1911); 

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

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleConnectionInstance1928); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1060:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1061:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1061:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1062:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1951);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1075:2: ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==23) ) {
                alt23=1;
            }
            else if ( (LA23_0==24) ) {
                alt23=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1075:3: ( (lv_bidirectional_5_0= '<->' ) )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1075:3: ( (lv_bidirectional_5_0= '<->' ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1076:1: (lv_bidirectional_5_0= '<->' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1076:1: (lv_bidirectional_5_0= '<->' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1077:3: lv_bidirectional_5_0= '<->'
                    {
                    lv_bidirectional_5_0=(Token)match(input,23,FOLLOW_23_in_ruleConnectionInstance1970); 

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
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1091:7: otherlv_6= '->'
                    {
                    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleConnectionInstance2001); 

                        	newLeafNode(otherlv_6, grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1095:2: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1096:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1096:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1097:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2025);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1110:2: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==20) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1110:4: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleConnectionInstance2038); 

                        	newLeafNode(otherlv_8, grammarAccess.getConnectionInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleConnectionInstance2050); 

                        	newLeafNode(otherlv_9, grammarAccess.getConnectionInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleConnectionInstance2062); 

                        	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1122:1: ( ( ruleSOMREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1123:1: ( ruleSOMREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1123:1: ( ruleSOMREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1124:3: ruleSOMREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSOMREF_in_ruleConnectionInstance2085);
                    ruleSOMREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1137:2: (otherlv_12= ',' ( ( ruleSOMREF ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==17) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1137:4: otherlv_12= ',' ( ( ruleSOMREF ) )
                    	    {
                    	    otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleConnectionInstance2098); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getConnectionInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1141:1: ( ( ruleSOMREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1142:1: ( ruleSOMREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1142:1: ( ruleSOMREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1143:3: ruleSOMREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSOMREF_in_ruleConnectionInstance2121);
                    	    ruleSOMREF();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,18,FOLLOW_18_in_ruleConnectionInstance2135); 

                        	newLeafNode(otherlv_14, grammarAccess.getConnectionInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            otherlv_15=(Token)match(input,10,FOLLOW_10_in_ruleConnectionInstance2149); 

                	newLeafNode(otherlv_15, grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_8());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1164:1: ( (lv_connectionReference_16_0= ruleConnectionReference ) )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1165:1: (lv_connectionReference_16_0= ruleConnectionReference )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1165:1: (lv_connectionReference_16_0= ruleConnectionReference )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1166:3: lv_connectionReference_16_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionReference_in_ruleConnectionInstance2170);
            	    lv_connectionReference_16_0=ruleConnectionReference();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionReference",
            	            		lv_connectionReference_16_0, 
            	            		"ConnectionReference");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);

            otherlv_17=(Token)match(input,11,FOLLOW_11_in_ruleConnectionInstance2183); 

                	newLeafNode(otherlv_17, grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_10());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1194:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1195:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1196:2: iv_ruleConnectionReference= ruleConnectionReference EOF
            {
             newCompositeNode(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference2219);
            iv_ruleConnectionReference=ruleConnectionReference();

            state._fsp--;

             current =iv_ruleConnectionReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference2229); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1203:1: ruleConnectionReference returns [EObject current=null] : ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1206:28: ( ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1207:1: ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1207:1: ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1207:2: ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1207:2: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1208:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1208:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1209:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2277);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleConnectionReference2289); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1226:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1227:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1227:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1228:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2312);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleConnectionReference2324); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionReferenceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1245:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1246:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1246:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1247:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleConnectionReference2347);
            ruleSUBREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleConnectionReference2359); 

                	newLeafNode(otherlv_5, grammarAccess.getConnectionReferenceAccess().getInKeyword_5());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1264:1: ( ( ruleINSTANCEREFWITHPARENT ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1265:1: ( ruleINSTANCEREFWITHPARENT )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1265:1: ( ruleINSTANCEREFWITHPARENT )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1266:3: ruleINSTANCEREFWITHPARENT
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_ruleConnectionReference2382);
            ruleINSTANCEREFWITHPARENT();

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1287:1: entryRuleFlowSpecificationInstance returns [EObject current=null] : iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF ;
    public final EObject entryRuleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecificationInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1288:2: (iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1289:2: iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF
            {
             newCompositeNode(grammarAccess.getFlowSpecificationInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2418);
            iv_ruleFlowSpecificationInstance=ruleFlowSpecificationInstance();

            state._fsp--;

             current =iv_ruleFlowSpecificationInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2428); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1296:1: ruleFlowSpecificationInstance returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? otherlv_14= ':' ( ( ruleFEATREF ) ) ) ;
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

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1299:28: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? otherlv_14= ':' ( ( ruleFEATREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1300:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? otherlv_14= ':' ( ( ruleFEATREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1300:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? otherlv_14= ':' ( ( ruleFEATREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1300:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )? otherlv_14= ':' ( ( ruleFEATREF ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleFlowSpecificationInstance2465); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1304:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1305:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1305:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1306:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2482); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFlowSpecificationInstance2499); 

                	newLeafNode(otherlv_2, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1326:1: ( ( ruleSIMPLEINSTANCEREF ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1327:1: ( ruleSIMPLEINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1327:1: ( ruleSIMPLEINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1328:3: ruleSIMPLEINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2522);
                    ruleSIMPLEINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2535); 

                	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1345:1: ( ( ruleSIMPLEINSTANCEREF ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1346:1: ( ruleSIMPLEINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1346:1: ( ruleSIMPLEINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1347:3: ruleSIMPLEINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2558);
                    ruleSIMPLEINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleFlowSpecificationInstance2571); 

                	newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1364:1: (otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==20) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1364:3: otherlv_7= 'in' otherlv_8= 'modes' otherlv_9= '(' ( (otherlv_10= RULE_ID ) ) (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )* otherlv_13= ')'
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleFlowSpecificationInstance2584); 

                        	newLeafNode(otherlv_7, grammarAccess.getFlowSpecificationInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleFlowSpecificationInstance2596); 

                        	newLeafNode(otherlv_8, grammarAccess.getFlowSpecificationInstanceAccess().getModesKeyword_7_1());
                        
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleFlowSpecificationInstance2608); 

                        	newLeafNode(otherlv_9, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1376:1: ( (otherlv_10= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1377:1: (otherlv_10= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1377:1: (otherlv_10= RULE_ID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1378:3: otherlv_10= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                    otherlv_10=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2628); 

                    		newLeafNode(otherlv_10, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_3_0()); 
                    	

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1389:2: (otherlv_11= ',' ( (otherlv_12= RULE_ID ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==17) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1389:4: otherlv_11= ',' ( (otherlv_12= RULE_ID ) )
                    	    {
                    	    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleFlowSpecificationInstance2641); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getFlowSpecificationInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1393:1: ( (otherlv_12= RULE_ID ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1394:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1394:1: (otherlv_12= RULE_ID )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1395:3: otherlv_12= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	    	        }
                    	            
                    	    otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2661); 

                    	    		newLeafNode(otherlv_12, grammarAccess.getFlowSpecificationInstanceAccess().getInModeModeInstanceCrossReference_7_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,18,FOLLOW_18_in_ruleFlowSpecificationInstance2675); 

                        	newLeafNode(otherlv_13, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            otherlv_14=(Token)match(input,9,FOLLOW_9_in_ruleFlowSpecificationInstance2689); 

                	newLeafNode(otherlv_14, grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_8());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1414:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1415:1: ( ruleFEATREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1415:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1416:3: ruleFEATREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_9_0()); 
            	    
            pushFollow(FOLLOW_ruleFEATREF_in_ruleFlowSpecificationInstance2712);
            ruleFEATREF();

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
    // $ANTLR end "ruleFlowSpecificationInstance"


    // $ANTLR start "entryRuleEndToEndFlowInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1437:1: entryRuleEndToEndFlowInstance returns [EObject current=null] : iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF ;
    public final EObject entryRuleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndToEndFlowInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1438:2: (iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1439:2: iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF
            {
             newCompositeNode(grammarAccess.getEndToEndFlowInstanceRule()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance2748);
            iv_ruleEndToEndFlowInstance=ruleEndToEndFlowInstance();

            state._fsp--;

             current =iv_ruleEndToEndFlowInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndToEndFlowInstance2758); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1446:1: ruleEndToEndFlowInstance returns [EObject current=null] : (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleSUBREF ) ) ) ;
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

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1449:28: ( (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleSUBREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1450:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleSUBREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1450:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleSUBREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1450:3: otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )? otherlv_15= ':' ( ( ruleSUBREF ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleEndToEndFlowInstance2795); 

                	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0());
                
            otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleEndToEndFlowInstance2807); 

                	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1());
                
            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleEndToEndFlowInstance2819); 

                	newLeafNode(otherlv_2, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2());
                
            otherlv_3=(Token)match(input,25,FOLLOW_25_in_ruleEndToEndFlowInstance2831); 

                	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1466:1: ( (lv_name_4_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1467:1: (lv_name_4_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1467:1: (lv_name_4_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1468:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance2848); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1484:2: ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_ID && LA32_0<=RULE_LONG)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1484:3: ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1484:3: ( ( ruleFLOWELEMENTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1485:1: ( ruleFLOWELEMENTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1485:1: ( ruleFLOWELEMENTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1486:3: ruleFLOWELEMENTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFLOWELEMENTREF_in_ruleEndToEndFlowInstance2877);
                    ruleFLOWELEMENTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1499:2: (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==24) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1499:4: otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) )
                    	    {
                    	    otherlv_6=(Token)match(input,24,FOLLOW_24_in_ruleEndToEndFlowInstance2890); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1503:1: ( ( ruleFLOWELEMENTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1504:1: ( ruleFLOWELEMENTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1504:1: ( ruleFLOWELEMENTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1505:3: ruleFLOWELEMENTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFLOWELEMENTREF_in_ruleEndToEndFlowInstance2913);
                    	    ruleFLOWELEMENTREF();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1518:6: (otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==20) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1518:8: otherlv_8= 'in' otherlv_9= 'modes' otherlv_10= '(' ( ( ruleSOMREF ) ) (otherlv_12= ',' ( ( ruleSOMREF ) ) )* otherlv_14= ')'
                    {
                    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleEndToEndFlowInstance2930); 

                        	newLeafNode(otherlv_8, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,21,FOLLOW_21_in_ruleEndToEndFlowInstance2942); 

                        	newLeafNode(otherlv_9, grammarAccess.getEndToEndFlowInstanceAccess().getModesKeyword_6_1());
                        
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleEndToEndFlowInstance2954); 

                        	newLeafNode(otherlv_10, grammarAccess.getEndToEndFlowInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1530:1: ( ( ruleSOMREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1531:1: ( ruleSOMREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1531:1: ( ruleSOMREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1532:3: ruleSOMREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSOMREF_in_ruleEndToEndFlowInstance2977);
                    ruleSOMREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1545:2: (otherlv_12= ',' ( ( ruleSOMREF ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==17) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1545:4: otherlv_12= ',' ( ( ruleSOMREF ) )
                    	    {
                    	    otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleEndToEndFlowInstance2990); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getEndToEndFlowInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1549:1: ( ( ruleSOMREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1550:1: ( ruleSOMREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1550:1: ( ruleSOMREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1551:3: ruleSOMREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSOMREF_in_ruleEndToEndFlowInstance3013);
                    	    ruleSOMREF();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,18,FOLLOW_18_in_ruleEndToEndFlowInstance3027); 

                        	newLeafNode(otherlv_14, grammarAccess.getEndToEndFlowInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            otherlv_15=(Token)match(input,9,FOLLOW_9_in_ruleEndToEndFlowInstance3041); 

                	newLeafNode(otherlv_15, grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_7());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1572:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1573:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1573:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1574:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleEndToEndFlowInstance3064);
            ruleSUBREF();

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
    // $ANTLR end "ruleEndToEndFlowInstance"


    // $ANTLR start "entryRuleModeInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1595:1: entryRuleModeInstance returns [EObject current=null] : iv_ruleModeInstance= ruleModeInstance EOF ;
    public final EObject entryRuleModeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1596:2: (iv_ruleModeInstance= ruleModeInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1597:2: iv_ruleModeInstance= ruleModeInstance EOF
            {
             newCompositeNode(grammarAccess.getModeInstanceRule()); 
            pushFollow(FOLLOW_ruleModeInstance_in_entryRuleModeInstance3100);
            iv_ruleModeInstance=ruleModeInstance();

            state._fsp--;

             current =iv_ruleModeInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeInstance3110); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1604:1: ruleModeInstance returns [EObject current=null] : ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? (otherlv_11= 'source' otherlv_12= 'of' otherlv_13= '(' ( ( ruleSOMREF ) ) (otherlv_15= ',' ( ( ruleSOMREF ) ) )* otherlv_17= ')' )? (otherlv_18= 'destination' otherlv_19= 'of' otherlv_20= '(' ( ( ruleSOMREF ) ) (otherlv_22= ',' ( ( ruleSOMREF ) ) )* otherlv_24= ')' )? otherlv_25= ':' ( ( ruleMODEREF ) ) ) ;
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
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1607:28: ( ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? (otherlv_11= 'source' otherlv_12= 'of' otherlv_13= '(' ( ( ruleSOMREF ) ) (otherlv_15= ',' ( ( ruleSOMREF ) ) )* otherlv_17= ')' )? (otherlv_18= 'destination' otherlv_19= 'of' otherlv_20= '(' ( ( ruleSOMREF ) ) (otherlv_22= ',' ( ( ruleSOMREF ) ) )* otherlv_24= ')' )? otherlv_25= ':' ( ( ruleMODEREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1608:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? (otherlv_11= 'source' otherlv_12= 'of' otherlv_13= '(' ( ( ruleSOMREF ) ) (otherlv_15= ',' ( ( ruleSOMREF ) ) )* otherlv_17= ')' )? (otherlv_18= 'destination' otherlv_19= 'of' otherlv_20= '(' ( ( ruleSOMREF ) ) (otherlv_22= ',' ( ( ruleSOMREF ) ) )* otherlv_24= ')' )? otherlv_25= ':' ( ( ruleMODEREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1608:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? (otherlv_11= 'source' otherlv_12= 'of' otherlv_13= '(' ( ( ruleSOMREF ) ) (otherlv_15= ',' ( ( ruleSOMREF ) ) )* otherlv_17= ')' )? (otherlv_18= 'destination' otherlv_19= 'of' otherlv_20= '(' ( ( ruleSOMREF ) ) (otherlv_22= ',' ( ( ruleSOMREF ) ) )* otherlv_24= ')' )? otherlv_25= ':' ( ( ruleMODEREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1608:2: ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )? (otherlv_11= 'source' otherlv_12= 'of' otherlv_13= '(' ( ( ruleSOMREF ) ) (otherlv_15= ',' ( ( ruleSOMREF ) ) )* otherlv_17= ')' )? (otherlv_18= 'destination' otherlv_19= 'of' otherlv_20= '(' ( ( ruleSOMREF ) ) (otherlv_22= ',' ( ( ruleSOMREF ) ) )* otherlv_24= ')' )? otherlv_25= ':' ( ( ruleMODEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1608:2: ( (lv_initial_0_0= 'initial' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==28) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1609:1: (lv_initial_0_0= 'initial' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1609:1: (lv_initial_0_0= 'initial' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1610:3: lv_initial_0_0= 'initial'
                    {
                    lv_initial_0_0=(Token)match(input,28,FOLLOW_28_in_ruleModeInstance3153); 

                            newLeafNode(lv_initial_0_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1623:3: ( (lv_derived_1_0= 'derived' ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==29) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1624:1: (lv_derived_1_0= 'derived' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1624:1: (lv_derived_1_0= 'derived' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1625:3: lv_derived_1_0= 'derived'
                    {
                    lv_derived_1_0=(Token)match(input,29,FOLLOW_29_in_ruleModeInstance3185); 

                            newLeafNode(lv_derived_1_0, grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "derived");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleModeInstance3211); 

                	newLeafNode(otherlv_2, grammarAccess.getModeInstanceAccess().getModeKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1642:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1643:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1643:1: (lv_name_3_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1644:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3228); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1660:2: (otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==31) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1660:4: otherlv_4= '=' ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    {
                    otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleModeInstance3246); 

                        	newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getEqualsSignKeyword_4_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1664:1: ( ( (otherlv_5= RULE_ID ) ) | (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' ) )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_ID) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==16) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1664:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1664:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1665:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1665:1: (otherlv_5= RULE_ID )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1666:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3267); 

                            		newLeafNode(otherlv_5, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1678:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1678:6: (otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')' )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1678:8: otherlv_6= '(' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+ otherlv_10= ')'
                            {
                            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleModeInstance3286); 

                                	newLeafNode(otherlv_6, grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_4_1_1_0());
                                
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1682:1: ( (otherlv_7= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1683:1: (otherlv_7= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1683:1: (otherlv_7= RULE_ID )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1684:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3306); 

                            		newLeafNode(otherlv_7, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_1_0()); 
                            	

                            }


                            }

                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1695:2: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )+
                            int cnt37=0;
                            loop37:
                            do {
                                int alt37=2;
                                int LA37_0 = input.LA(1);

                                if ( (LA37_0==17) ) {
                                    alt37=1;
                                }


                                switch (alt37) {
                            	case 1 :
                            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1695:4: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                            	    {
                            	    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleModeInstance3319); 

                            	        	newLeafNode(otherlv_8, grammarAccess.getModeInstanceAccess().getCommaKeyword_4_1_1_2_0());
                            	        
                            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1699:1: ( (otherlv_9= RULE_ID ) )
                            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1700:1: (otherlv_9= RULE_ID )
                            	    {
                            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1700:1: (otherlv_9= RULE_ID )
                            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1701:3: otherlv_9= RULE_ID
                            	    {

                            	    			if (current==null) {
                            	    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                            	    	        }
                            	            
                            	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance3339); 

                            	    		newLeafNode(otherlv_9, grammarAccess.getModeInstanceAccess().getParentModeInstanceCrossReference_4_1_1_2_1_0()); 
                            	    	

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    if ( cnt37 >= 1 ) break loop37;
                                        EarlyExitException eee =
                                            new EarlyExitException(37, input);
                                        throw eee;
                                }
                                cnt37++;
                            } while (true);

                            otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleModeInstance3353); 

                                	newLeafNode(otherlv_10, grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_4_1_1_3());
                                

                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1716:5: (otherlv_11= 'source' otherlv_12= 'of' otherlv_13= '(' ( ( ruleSOMREF ) ) (otherlv_15= ',' ( ( ruleSOMREF ) ) )* otherlv_17= ')' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==14) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1716:7: otherlv_11= 'source' otherlv_12= 'of' otherlv_13= '(' ( ( ruleSOMREF ) ) (otherlv_15= ',' ( ( ruleSOMREF ) ) )* otherlv_17= ')'
                    {
                    otherlv_11=(Token)match(input,14,FOLLOW_14_in_ruleModeInstance3370); 

                        	newLeafNode(otherlv_11, grammarAccess.getModeInstanceAccess().getSourceKeyword_5_0());
                        
                    otherlv_12=(Token)match(input,15,FOLLOW_15_in_ruleModeInstance3382); 

                        	newLeafNode(otherlv_12, grammarAccess.getModeInstanceAccess().getOfKeyword_5_1());
                        
                    otherlv_13=(Token)match(input,16,FOLLOW_16_in_ruleModeInstance3394); 

                        	newLeafNode(otherlv_13, grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_5_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1728:1: ( ( ruleSOMREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1729:1: ( ruleSOMREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1729:1: ( ruleSOMREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1730:3: ruleSOMREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getModeInstanceAccess().getSrcModeTransitionModeTransitionInstanceCrossReference_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSOMREF_in_ruleModeInstance3417);
                    ruleSOMREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1743:2: (otherlv_15= ',' ( ( ruleSOMREF ) ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==17) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1743:4: otherlv_15= ',' ( ( ruleSOMREF ) )
                    	    {
                    	    otherlv_15=(Token)match(input,17,FOLLOW_17_in_ruleModeInstance3430); 

                    	        	newLeafNode(otherlv_15, grammarAccess.getModeInstanceAccess().getCommaKeyword_5_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1747:1: ( ( ruleSOMREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1748:1: ( ruleSOMREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1748:1: ( ruleSOMREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1749:3: ruleSOMREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getModeInstanceAccess().getSrcModeTransitionModeTransitionInstanceCrossReference_5_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSOMREF_in_ruleModeInstance3453);
                    	    ruleSOMREF();

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

                    otherlv_17=(Token)match(input,18,FOLLOW_18_in_ruleModeInstance3467); 

                        	newLeafNode(otherlv_17, grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_5_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1766:3: (otherlv_18= 'destination' otherlv_19= 'of' otherlv_20= '(' ( ( ruleSOMREF ) ) (otherlv_22= ',' ( ( ruleSOMREF ) ) )* otherlv_24= ')' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==19) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1766:5: otherlv_18= 'destination' otherlv_19= 'of' otherlv_20= '(' ( ( ruleSOMREF ) ) (otherlv_22= ',' ( ( ruleSOMREF ) ) )* otherlv_24= ')'
                    {
                    otherlv_18=(Token)match(input,19,FOLLOW_19_in_ruleModeInstance3482); 

                        	newLeafNode(otherlv_18, grammarAccess.getModeInstanceAccess().getDestinationKeyword_6_0());
                        
                    otherlv_19=(Token)match(input,15,FOLLOW_15_in_ruleModeInstance3494); 

                        	newLeafNode(otherlv_19, grammarAccess.getModeInstanceAccess().getOfKeyword_6_1());
                        
                    otherlv_20=(Token)match(input,16,FOLLOW_16_in_ruleModeInstance3506); 

                        	newLeafNode(otherlv_20, grammarAccess.getModeInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1778:1: ( ( ruleSOMREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1779:1: ( ruleSOMREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1779:1: ( ruleSOMREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1780:3: ruleSOMREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getModeInstanceAccess().getDstModeTransitionModeTransitionInstanceCrossReference_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSOMREF_in_ruleModeInstance3529);
                    ruleSOMREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1793:2: (otherlv_22= ',' ( ( ruleSOMREF ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==17) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1793:4: otherlv_22= ',' ( ( ruleSOMREF ) )
                    	    {
                    	    otherlv_22=(Token)match(input,17,FOLLOW_17_in_ruleModeInstance3542); 

                    	        	newLeafNode(otherlv_22, grammarAccess.getModeInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1797:1: ( ( ruleSOMREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1798:1: ( ruleSOMREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1798:1: ( ruleSOMREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1799:3: ruleSOMREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getModeInstanceAccess().getDstModeTransitionModeTransitionInstanceCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleSOMREF_in_ruleModeInstance3565);
                    	    ruleSOMREF();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    otherlv_24=(Token)match(input,18,FOLLOW_18_in_ruleModeInstance3579); 

                        	newLeafNode(otherlv_24, grammarAccess.getModeInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            otherlv_25=(Token)match(input,9,FOLLOW_9_in_ruleModeInstance3593); 

                	newLeafNode(otherlv_25, grammarAccess.getModeInstanceAccess().getColonKeyword_7());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1820:1: ( ( ruleMODEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1821:1: ( ruleMODEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1821:1: ( ruleMODEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1822:3: ruleMODEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_ruleMODEREF_in_ruleModeInstance3616);
            ruleMODEREF();

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
    // $ANTLR end "ruleModeInstance"


    // $ANTLR start "entryRuleModeTransitionInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1843:1: entryRuleModeTransitionInstance returns [EObject current=null] : iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF ;
    public final EObject entryRuleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransitionInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1844:2: (iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1845:2: iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionInstanceRule()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance3652);
            iv_ruleModeTransitionInstance=ruleModeTransitionInstance();

            state._fsp--;

             current =iv_ruleModeTransitionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransitionInstance3662); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1852:1: ruleModeTransitionInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleMTNAME ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleMODEREF ) ) ) ;
    public final EObject ruleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1855:28: ( (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleMTNAME ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleMODEREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1856:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleMTNAME ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleMODEREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1856:1: (otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleMTNAME ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleMODEREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1856:3: otherlv_0= 'mode' otherlv_1= 'transition' ( (lv_name_2_0= ruleMTNAME ) ) ( (otherlv_3= RULE_ID ) ) otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) otherlv_6= ':' ( ( ruleMODEREF ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleModeTransitionInstance3699); 

                	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleModeTransitionInstance3711); 

                	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1864:1: ( (lv_name_2_0= ruleMTNAME ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1865:1: (lv_name_2_0= ruleMTNAME )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1865:1: (lv_name_2_0= ruleMTNAME )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1866:3: lv_name_2_0= ruleMTNAME
            {
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getNameMTNAMEParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleMTNAME_in_ruleModeTransitionInstance3732);
            lv_name_2_0=ruleMTNAME();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModeTransitionInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"MTNAME");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1882:2: ( (otherlv_3= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1883:1: (otherlv_3= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1883:1: (otherlv_3= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1884:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance3752); 

            		newLeafNode(otherlv_3, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,24,FOLLOW_24_in_ruleModeTransitionInstance3764); 

                	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1899:1: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1900:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1900:1: (otherlv_5= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1901:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance3784); 

            		newLeafNode(otherlv_5, grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,9,FOLLOW_9_in_ruleModeTransitionInstance3796); 

                	newLeafNode(otherlv_6, grammarAccess.getModeTransitionInstanceAccess().getColonKeyword_6());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1916:1: ( ( ruleMODEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1917:1: ( ruleMODEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1917:1: ( ruleMODEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1918:3: ruleMODEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleMODEREF_in_ruleModeTransitionInstance3819);
            ruleMODEREF();

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
    // $ANTLR end "ruleModeTransitionInstance"


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1939:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1940:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1941:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode3855);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode3865); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1948:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )? ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1951:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1952:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1952:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1952:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleSystemOperationMode3902); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1956:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1957:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1957:1: (lv_name_1_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1958:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSystemOperationMode3919); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1974:2: ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1974:3: ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1974:3: ( ( ruleMODEINSTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1975:1: ( ruleMODEINSTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1975:1: ( ruleMODEINSTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1976:3: ruleMODEINSTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMODEINSTREF_in_ruleSystemOperationMode3948);
                    ruleMODEINSTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1989:2: (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )*
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==17) ) {
                            alt44=1;
                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1989:4: otherlv_3= ',' ( ( ruleMODEINSTREF ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleSystemOperationMode3961); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1993:1: ( ( ruleMODEINSTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1994:1: ( ruleMODEINSTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1994:1: ( ruleMODEINSTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1995:3: ruleMODEINSTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMODEINSTREF_in_ruleSystemOperationMode3984);
                    	    ruleMODEINSTREF();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop44;
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


    // $ANTLR start "entryRuleDirectionType"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2016:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2017:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2018:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType4025);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType4036); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2025:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2028:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2029:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2029:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt46=3;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==20) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==34) ) {
                    alt46=3;
                }
                else if ( (LA46_1==EOF||(LA46_1>=35 && LA46_1<=43)) ) {
                    alt46=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA46_0==34) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2030:2: kw= 'in'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleDirectionType4074); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2037:2: kw= 'out'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleDirectionType4093); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2043:6: (kw= 'in' kw= 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2043:6: (kw= 'in' kw= 'out' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2044:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleDirectionType4113); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleDirectionType4126); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2063:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2064:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2065:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory4168);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory4179); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2072:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2075:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2076:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2076:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            int alt47=9;
            switch ( input.LA(1) ) {
            case 35:
                {
                alt47=1;
                }
                break;
            case 36:
                {
                alt47=2;
                }
                break;
            case 37:
                {
                alt47=3;
                }
                break;
            case 38:
                {
                alt47=4;
                }
                break;
            case 39:
                {
                alt47=5;
                }
                break;
            case 40:
                {
                alt47=6;
                }
                break;
            case 41:
                {
                alt47=7;
                }
                break;
            case 42:
                {
                alt47=8;
                }
                break;
            case 43:
                {
                alt47=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2077:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleFeatureCategory4217); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2084:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleFeatureCategory4236); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2091:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleFeatureCategory4255); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2098:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleFeatureCategory4274); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2105:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleFeatureCategory4293); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2112:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleFeatureCategory4312); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2119:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleFeatureCategory4331); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2126:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleFeatureCategory4350); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2133:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleFeatureCategory4369); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getAbstractFeatureKeyword_8()); 
                        

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2146:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2147:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2148:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory4410);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory4421); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2155:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2158:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2159:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2159:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt48=14;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2160:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleComponentCategory4459); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2167:2: kw= 'bus'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleComponentCategory4478); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2174:2: kw= 'data'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleComponentCategory4497); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2181:2: kw= 'device'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleComponentCategory4516); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2188:2: kw= 'memory'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleComponentCategory4535); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2195:2: kw= 'process'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleComponentCategory4554); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2202:2: kw= 'processor'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleComponentCategory4573); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2209:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleComponentCategory4592); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2215:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2215:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2216:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleComponentCategory4612); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleComponentCategory4625); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2229:2: kw= 'system'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleComponentCategory4645); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2235:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2235:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2236:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleComponentCategory4665); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleComponentCategory4678); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2249:2: kw= 'thread'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleComponentCategory4698); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2255:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2255:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2256:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleComponentCategory4718); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleComponentCategory4731); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2268:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2268:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2269:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleComponentCategory4752); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleComponentCategory4765); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2288:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2289:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2290:2: iv_ruleConnectionKind= ruleConnectionKind EOF
            {
             newCompositeNode(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind4807);
            iv_ruleConnectionKind=ruleConnectionKind();

            state._fsp--;

             current =iv_ruleConnectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind4818); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2297:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2300:28: ( (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2301:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2301:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' )
            int alt49=6;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt49=1;
                }
                break;
            case 57:
                {
                alt49=2;
                }
                break;
            case 58:
                {
                alt49=3;
                }
                break;
            case 59:
                {
                alt49=4;
                }
                break;
            case 60:
                {
                alt49=5;
                }
                break;
            case 61:
                {
                alt49=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2302:2: kw= 'featureConnection'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleConnectionKind4856); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2309:2: kw= 'accessConnection'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleConnectionKind4875); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2316:2: kw= 'parameterConnection'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleConnectionKind4894); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2323:2: kw= 'portConnection'
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleConnectionKind4913); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2330:2: kw= 'modeTransitionConnection'
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleConnectionKind4932); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getModeTransitionConnectionKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2337:2: kw= 'featureGroupConnection'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleConnectionKind4951); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureGroupConnectionKeyword_5()); 
                        

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


    // $ANTLR start "entryRuleIMPLREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2350:1: entryRuleIMPLREF returns [String current=null] : iv_ruleIMPLREF= ruleIMPLREF EOF ;
    public final String entryRuleIMPLREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMPLREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2351:2: (iv_ruleIMPLREF= ruleIMPLREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2352:2: iv_ruleIMPLREF= ruleIMPLREF EOF
            {
             newCompositeNode(grammarAccess.getIMPLREFRule()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF4992);
            iv_ruleIMPLREF=ruleIMPLREF();

            state._fsp--;

             current =iv_ruleIMPLREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMPLREF5003); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIMPLREF"


    // $ANTLR start "ruleIMPLREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2359:1: ruleIMPLREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMPLREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2362:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2363:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2363:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2363:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2363:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    int LA50_1 = input.LA(2);

                    if ( (LA50_1==62) ) {
                        alt50=1;
                    }


                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2363:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF5044); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,62,FOLLOW_62_in_ruleIMPLREF5062); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF5079); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,63,FOLLOW_63_in_ruleIMPLREF5097); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF5112); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIMPLREF"


    // $ANTLR start "entryRuleFEATREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2404:1: entryRuleFEATREF returns [String current=null] : iv_ruleFEATREF= ruleFEATREF EOF ;
    public final String entryRuleFEATREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFEATREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2405:2: (iv_ruleFEATREF= ruleFEATREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2406:2: iv_ruleFEATREF= ruleFEATREF EOF
            {
             newCompositeNode(grammarAccess.getFEATREFRule()); 
            pushFollow(FOLLOW_ruleFEATREF_in_entryRuleFEATREF5158);
            iv_ruleFEATREF=ruleFEATREF();

            state._fsp--;

             current =iv_ruleFEATREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFEATREF5169); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFEATREF"


    // $ANTLR start "ruleFEATREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2413:1: ruleFEATREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleFEATREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2416:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2417:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2417:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2417:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2417:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_ID) ) {
                    int LA51_1 = input.LA(2);

                    if ( (LA51_1==62) ) {
                        int LA51_2 = input.LA(3);

                        if ( (LA51_2==RULE_ID) ) {
                            int LA51_3 = input.LA(4);

                            if ( (LA51_3==62) ) {
                                alt51=1;
                            }


                        }


                    }


                }


                switch (alt51) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2417:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF5210); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,62,FOLLOW_62_in_ruleFEATREF5228); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFEATREFAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF5245); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,62,FOLLOW_62_in_ruleFEATREF5263); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getFEATREFAccess().getColonColonKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF5278); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_3()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFEATREF"


    // $ANTLR start "entryRuleSUBREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2458:1: entryRuleSUBREF returns [String current=null] : iv_ruleSUBREF= ruleSUBREF EOF ;
    public final String entryRuleSUBREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSUBREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2459:2: (iv_ruleSUBREF= ruleSUBREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2460:2: iv_ruleSUBREF= ruleSUBREF EOF
            {
             newCompositeNode(grammarAccess.getSUBREFRule()); 
            pushFollow(FOLLOW_ruleSUBREF_in_entryRuleSUBREF5324);
            iv_ruleSUBREF=ruleSUBREF();

            state._fsp--;

             current =iv_ruleSUBREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSUBREF5335); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSUBREF"


    // $ANTLR start "ruleSUBREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2467:1: ruleSUBREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSUBREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2470:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2471:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2471:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2471:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2471:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    int LA52_1 = input.LA(2);

                    if ( (LA52_1==62) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2471:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF5376); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,62,FOLLOW_62_in_ruleSUBREF5394); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF5411); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,63,FOLLOW_63_in_ruleSUBREF5429); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF5444); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 
                
            kw=(Token)match(input,62,FOLLOW_62_in_ruleSUBREF5462); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 
                
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF5477); 

            		current.merge(this_ID_6);
                
             
                newLeafNode(this_ID_6, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_5()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSUBREF"


    // $ANTLR start "entryRuleMODEREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2525:1: entryRuleMODEREF returns [String current=null] : iv_ruleMODEREF= ruleMODEREF EOF ;
    public final String entryRuleMODEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMODEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2526:2: (iv_ruleMODEREF= ruleMODEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2527:2: iv_ruleMODEREF= ruleMODEREF EOF
            {
             newCompositeNode(grammarAccess.getMODEREFRule()); 
            pushFollow(FOLLOW_ruleMODEREF_in_entryRuleMODEREF5523);
            iv_ruleMODEREF=ruleMODEREF();

            state._fsp--;

             current =iv_ruleMODEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMODEREF5534); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMODEREF"


    // $ANTLR start "ruleMODEREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2534:1: ruleMODEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleMODEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2537:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2538:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2538:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2538:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2538:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    int LA53_1 = input.LA(2);

                    if ( (LA53_1==62) ) {
                        int LA53_3 = input.LA(3);

                        if ( (LA53_3==RULE_ID) ) {
                            int LA53_4 = input.LA(4);

                            if ( ((LA53_4>=62 && LA53_4<=63)) ) {
                                alt53=1;
                            }


                        }


                    }


                }


                switch (alt53) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2538:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEREF5575); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getMODEREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,62,FOLLOW_62_in_ruleMODEREF5593); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getMODEREFAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEREF5610); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getMODEREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2558:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==63) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2559:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleMODEREF5629); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMODEREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEREF5644); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getMODEREFAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,62,FOLLOW_62_in_ruleMODEREF5664); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMODEREFAccess().getColonColonKeyword_3()); 
                
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEREF5679); 

            		current.merge(this_ID_6);
                
             
                newLeafNode(this_ID_6, grammarAccess.getMODEREFAccess().getIDTerminalRuleCall_4()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMODEREF"


    // $ANTLR start "entryRuleINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2592:1: entryRuleINSTANCEREF returns [String current=null] : iv_ruleINSTANCEREF= ruleINSTANCEREF EOF ;
    public final String entryRuleINSTANCEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINSTANCEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2593:2: (iv_ruleINSTANCEREF= ruleINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2594:2: iv_ruleINSTANCEREF= ruleINSTANCEREF EOF
            {
             newCompositeNode(grammarAccess.getINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF5725);
            iv_ruleINSTANCEREF=ruleINSTANCEREF();

            state._fsp--;

             current =iv_ruleINSTANCEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREF5736); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINSTANCEREF"


    // $ANTLR start "ruleINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2601:1: ruleINSTANCEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* ) ;
    public final AntlrDatatypeRuleToken ruleINSTANCEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_ID_5=null;
        Token this_LONG_7=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2604:28: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2605:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2605:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2605:6: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF5776); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2612:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==12) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2613:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
            	    {
            	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREF5795); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
            	        
            	    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREF5810); 

            	    		current.merge(this_LONG_2);
            	        
            	     
            	        newLeafNode(this_LONG_2, grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
            	        
            	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREF5828); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop55;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2631:3: (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==63) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2632:2: kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )*
            	    {
            	    kw=(Token)match(input,63,FOLLOW_63_in_ruleINSTANCEREF5844); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            	        
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF5859); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2644:1: (kw= '[' this_LONG_7= RULE_LONG kw= ']' )*
            	    loop56:
            	    do {
            	        int alt56=2;
            	        int LA56_0 = input.LA(1);

            	        if ( (LA56_0==12) ) {
            	            alt56=1;
            	        }


            	        switch (alt56) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2645:2: kw= '[' this_LONG_7= RULE_LONG kw= ']'
            	    	    {
            	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREF5878); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            	    	        
            	    	    this_LONG_7=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREF5893); 

            	    	    		current.merge(this_LONG_7);
            	    	        
            	    	     
            	    	        newLeafNode(this_LONG_7, grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            	    	        
            	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREF5911); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop56;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleINSTANCEREF"


    // $ANTLR start "entryRuleSIMPLEINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2671:1: entryRuleSIMPLEINSTANCEREF returns [String current=null] : iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF ;
    public final String entryRuleSIMPLEINSTANCEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSIMPLEINSTANCEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2672:2: (iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2673:2: iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF
            {
             newCompositeNode(grammarAccess.getSIMPLEINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_entryRuleSIMPLEINSTANCEREF5956);
            iv_ruleSIMPLEINSTANCEREF=ruleSIMPLEINSTANCEREF();

            state._fsp--;

             current =iv_ruleSIMPLEINSTANCEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSIMPLEINSTANCEREF5967); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSIMPLEINSTANCEREF"


    // $ANTLR start "ruleSIMPLEINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2680:1: ruleSIMPLEINSTANCEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* ) ;
    public final AntlrDatatypeRuleToken ruleSIMPLEINSTANCEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_ID_5=null;
        Token this_LONG_7=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2683:28: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2684:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2684:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2684:6: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF6007); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2691:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==12) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2692:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
                    {
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleSIMPLEINSTANCEREF6026); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
                        
                    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF6041); 

                    		current.merge(this_LONG_2);
                        
                     
                        newLeafNode(this_LONG_2, grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSIMPLEINSTANCEREF6059); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2710:3: (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==63) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2711:2: kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )?
            	    {
            	    kw=(Token)match(input,63,FOLLOW_63_in_ruleSIMPLEINSTANCEREF6075); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            	        
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF6090); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2723:1: (kw= '[' this_LONG_7= RULE_LONG kw= ']' )?
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==12) ) {
            	        alt59=1;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2724:2: kw= '[' this_LONG_7= RULE_LONG kw= ']'
            	            {
            	            kw=(Token)match(input,12,FOLLOW_12_in_ruleSIMPLEINSTANCEREF6109); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            	                
            	            this_LONG_7=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF6124); 

            	            		current.merge(this_LONG_7);
            	                
            	             
            	                newLeafNode(this_LONG_7, grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            	                
            	            kw=(Token)match(input,13,FOLLOW_13_in_ruleSIMPLEINSTANCEREF6142); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSIMPLEINSTANCEREF"


    // $ANTLR start "entryRuleINSTANCEREFWITHPARENT"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2750:1: entryRuleINSTANCEREFWITHPARENT returns [String current=null] : iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF ;
    public final String entryRuleINSTANCEREFWITHPARENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINSTANCEREFWITHPARENT = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2751:2: (iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2752:2: iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF
            {
             newCompositeNode(grammarAccess.getINSTANCEREFWITHPARENTRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT6187);
            iv_ruleINSTANCEREFWITHPARENT=ruleINSTANCEREFWITHPARENT();

            state._fsp--;

             current =iv_ruleINSTANCEREFWITHPARENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT6198); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleINSTANCEREFWITHPARENT"


    // $ANTLR start "ruleINSTANCEREFWITHPARENT"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2759:1: ruleINSTANCEREFWITHPARENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) ) ;
    public final AntlrDatatypeRuleToken ruleINSTANCEREFWITHPARENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        Token this_LONG_3=null;
        Token this_ID_6=null;
        Token this_LONG_8=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2762:28: ( (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2763:1: (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2763:1: (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==64) ) {
                alt64=1;
            }
            else if ( (LA64_0==RULE_ID) ) {
                alt64=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2764:2: kw= 'parent'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleINSTANCEREFWITHPARENT6236); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getParentKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2770:6: (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2770:6: (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2770:11: this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )*
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT6258); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_0()); 
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2777:1: (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+
                    int cnt61=0;
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==12) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2778:2: kw= '[' this_LONG_3= RULE_LONG kw= ']'
                    	    {
                    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREFWITHPARENT6277); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_1_0()); 
                    	        
                    	    this_LONG_3=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT6292); 

                    	    		current.merge(this_LONG_3);
                    	        
                    	     
                    	        newLeafNode(this_LONG_3, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_1_1()); 
                    	        
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREFWITHPARENT6310); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_1_2()); 
                    	        

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

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2796:3: (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )*
                    loop63:
                    do {
                        int alt63=2;
                        int LA63_0 = input.LA(1);

                        if ( (LA63_0==63) ) {
                            alt63=1;
                        }


                        switch (alt63) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2797:2: kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+
                    	    {
                    	    kw=(Token)match(input,63,FOLLOW_63_in_ruleINSTANCEREFWITHPARENT6326); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getFullStopKeyword_1_2_0()); 
                    	        
                    	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT6341); 

                    	    		current.merge(this_ID_6);
                    	        
                    	     
                    	        newLeafNode(this_ID_6, grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_2_1()); 
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2809:1: (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+
                    	    int cnt62=0;
                    	    loop62:
                    	    do {
                    	        int alt62=2;
                    	        int LA62_0 = input.LA(1);

                    	        if ( (LA62_0==12) ) {
                    	            alt62=1;
                    	        }


                    	        switch (alt62) {
                    	    	case 1 :
                    	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2810:2: kw= '[' this_LONG_8= RULE_LONG kw= ']'
                    	    	    {
                    	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREFWITHPARENT6360); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_2_2_0()); 
                    	    	        
                    	    	    this_LONG_8=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT6375); 

                    	    	    		current.merge(this_LONG_8);
                    	    	        
                    	    	     
                    	    	        newLeafNode(this_LONG_8, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_2_2_1()); 
                    	    	        
                    	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREFWITHPARENT6393); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_2_2_2()); 
                    	    	        

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


                    	    }
                    	    break;

                    	default :
                    	    break loop63;
                        }
                    } while (true);


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
    // $ANTLR end "ruleINSTANCEREFWITHPARENT"


    // $ANTLR start "entryRuleCONNINSTREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2836:1: entryRuleCONNINSTREF returns [String current=null] : iv_ruleCONNINSTREF= ruleCONNINSTREF EOF ;
    public final String entryRuleCONNINSTREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCONNINSTREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2837:2: (iv_ruleCONNINSTREF= ruleCONNINSTREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2838:2: iv_ruleCONNINSTREF= ruleCONNINSTREF EOF
            {
             newCompositeNode(grammarAccess.getCONNINSTREFRule()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF6439);
            iv_ruleCONNINSTREF=ruleCONNINSTREF();

            state._fsp--;

             current =iv_ruleCONNINSTREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONNINSTREF6450); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCONNINSTREF"


    // $ANTLR start "ruleCONNINSTREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2845:1: ruleCONNINSTREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG ) ;
    public final AntlrDatatypeRuleToken ruleCONNINSTREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LONG_0=null;
        Token kw=null;
        Token this_LONG_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2848:28: ( ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2849:1: ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2849:1: ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2849:2: (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2849:2: (this_LONG_0= RULE_LONG kw= '.' )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_LONG) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==63) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2849:7: this_LONG_0= RULE_LONG kw= '.'
                    {
                    this_LONG_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleCONNINSTREF6491); 

                    		current.merge(this_LONG_0);
                        
                     
                        newLeafNode(this_LONG_0, grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_0_0()); 
                        
                    kw=(Token)match(input,63,FOLLOW_63_in_ruleCONNINSTREF6509); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCONNINSTREFAccess().getFullStopKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleCONNINSTREF6526); 

            		current.merge(this_LONG_2);
                
             
                newLeafNode(this_LONG_2, grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCONNINSTREF"


    // $ANTLR start "entryRuleFLOWELEMENTREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2877:1: entryRuleFLOWELEMENTREF returns [String current=null] : iv_ruleFLOWELEMENTREF= ruleFLOWELEMENTREF EOF ;
    public final String entryRuleFLOWELEMENTREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFLOWELEMENTREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2878:2: (iv_ruleFLOWELEMENTREF= ruleFLOWELEMENTREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2879:2: iv_ruleFLOWELEMENTREF= ruleFLOWELEMENTREF EOF
            {
             newCompositeNode(grammarAccess.getFLOWELEMENTREFRule()); 
            pushFollow(FOLLOW_ruleFLOWELEMENTREF_in_entryRuleFLOWELEMENTREF6572);
            iv_ruleFLOWELEMENTREF=ruleFLOWELEMENTREF();

            state._fsp--;

             current =iv_ruleFLOWELEMENTREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFLOWELEMENTREF6583); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFLOWELEMENTREF"


    // $ANTLR start "ruleFLOWELEMENTREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2886:1: ruleFLOWELEMENTREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) ) ) ;
    public final AntlrDatatypeRuleToken ruleFLOWELEMENTREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_LONG_5=null;
        Token this_ID_6=null;
        Token this_LONG_8=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2889:28: ( ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2890:1: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2890:1: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2890:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2890:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )*
            loop67:
            do {
                int alt67=2;
                alt67 = dfa67.predict(input);
                switch (alt67) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2890:7: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFLOWELEMENTREF6624); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFLOWELEMENTREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2897:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )*
            	    loop66:
            	    do {
            	        int alt66=2;
            	        int LA66_0 = input.LA(1);

            	        if ( (LA66_0==12) ) {
            	            alt66=1;
            	        }


            	        switch (alt66) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2898:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
            	    	    {
            	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleFLOWELEMENTREF6643); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getLeftSquareBracketKeyword_0_1_0()); 
            	    	        
            	    	    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF6658); 

            	    	    		current.merge(this_LONG_2);
            	    	        
            	    	     
            	    	        newLeafNode(this_LONG_2, grammarAccess.getFLOWELEMENTREFAccess().getLONGTerminalRuleCall_0_1_1()); 
            	    	        
            	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleFLOWELEMENTREF6676); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getRightSquareBracketKeyword_0_1_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop66;
            	        }
            	    } while (true);

            	    kw=(Token)match(input,63,FOLLOW_63_in_ruleFLOWELEMENTREF6691); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getFullStopKeyword_0_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2922:3: (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_LONG) ) {
                alt69=1;
            }
            else if ( (LA69_0==RULE_ID) ) {
                alt69=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2922:8: this_LONG_5= RULE_LONG
                    {
                    this_LONG_5=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF6709); 

                    		current.merge(this_LONG_5);
                        
                     
                        newLeafNode(this_LONG_5, grammarAccess.getFLOWELEMENTREFAccess().getLONGTerminalRuleCall_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2930:6: (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2930:6: (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2930:11: this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )*
                    {
                    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFLOWELEMENTREF6736); 

                    		current.merge(this_ID_6);
                        
                     
                        newLeafNode(this_ID_6, grammarAccess.getFLOWELEMENTREFAccess().getIDTerminalRuleCall_1_1_0()); 
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2937:1: (kw= '[' this_LONG_8= RULE_LONG kw= ']' )*
                    loop68:
                    do {
                        int alt68=2;
                        int LA68_0 = input.LA(1);

                        if ( (LA68_0==12) ) {
                            alt68=1;
                        }


                        switch (alt68) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2938:2: kw= '[' this_LONG_8= RULE_LONG kw= ']'
                    	    {
                    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleFLOWELEMENTREF6755); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getLeftSquareBracketKeyword_1_1_1_0()); 
                    	        
                    	    this_LONG_8=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF6770); 

                    	    		current.merge(this_LONG_8);
                    	        
                    	     
                    	        newLeafNode(this_LONG_8, grammarAccess.getFLOWELEMENTREFAccess().getLONGTerminalRuleCall_1_1_1_1()); 
                    	        
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleFLOWELEMENTREF6788); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getRightSquareBracketKeyword_1_1_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop68;
                        }
                    } while (true);


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
    // $ANTLR end "ruleFLOWELEMENTREF"


    // $ANTLR start "entryRuleMODEINSTREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2964:1: entryRuleMODEINSTREF returns [String current=null] : iv_ruleMODEINSTREF= ruleMODEINSTREF EOF ;
    public final String entryRuleMODEINSTREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMODEINSTREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2965:2: (iv_ruleMODEINSTREF= ruleMODEINSTREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2966:2: iv_ruleMODEINSTREF= ruleMODEINSTREF EOF
            {
             newCompositeNode(grammarAccess.getMODEINSTREFRule()); 
            pushFollow(FOLLOW_ruleMODEINSTREF_in_entryRuleMODEINSTREF6833);
            iv_ruleMODEINSTREF=ruleMODEINSTREF();

            state._fsp--;

             current =iv_ruleMODEINSTREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMODEINSTREF6844); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMODEINSTREF"


    // $ANTLR start "ruleMODEINSTREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2973:1: ruleMODEINSTREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleMODEINSTREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2976:28: ( ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2977:1: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2977:1: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2977:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2977:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_ID) ) {
                    int LA71_1 = input.LA(2);

                    if ( (LA71_1==12||LA71_1==63) ) {
                        alt71=1;
                    }


                }


                switch (alt71) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2977:7: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEINSTREF6885); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getMODEINSTREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2984:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )*
            	    loop70:
            	    do {
            	        int alt70=2;
            	        int LA70_0 = input.LA(1);

            	        if ( (LA70_0==12) ) {
            	            alt70=1;
            	        }


            	        switch (alt70) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2985:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
            	    	    {
            	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleMODEINSTREF6904); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getMODEINSTREFAccess().getLeftSquareBracketKeyword_0_1_0()); 
            	    	        
            	    	    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleMODEINSTREF6919); 

            	    	    		current.merge(this_LONG_2);
            	    	        
            	    	     
            	    	        newLeafNode(this_LONG_2, grammarAccess.getMODEINSTREFAccess().getLONGTerminalRuleCall_0_1_1()); 
            	    	        
            	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleMODEINSTREF6937); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getMODEINSTREFAccess().getRightSquareBracketKeyword_0_1_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop70;
            	        }
            	    } while (true);

            	    kw=(Token)match(input,63,FOLLOW_63_in_ruleMODEINSTREF6952); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getMODEINSTREFAccess().getFullStopKeyword_0_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEINSTREF6969); 

            		current.merge(this_ID_5);
                
             
                newLeafNode(this_ID_5, grammarAccess.getMODEINSTREFAccess().getIDTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMODEINSTREF"


    // $ANTLR start "entryRuleSOMREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3024:1: entryRuleSOMREF returns [String current=null] : iv_ruleSOMREF= ruleSOMREF EOF ;
    public final String entryRuleSOMREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSOMREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3025:2: (iv_ruleSOMREF= ruleSOMREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3026:2: iv_ruleSOMREF= ruleSOMREF EOF
            {
             newCompositeNode(grammarAccess.getSOMREFRule()); 
            pushFollow(FOLLOW_ruleSOMREF_in_entryRuleSOMREF7015);
            iv_ruleSOMREF=ruleSOMREF();

            state._fsp--;

             current =iv_ruleSOMREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSOMREF7026); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSOMREF"


    // $ANTLR start "ruleSOMREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3033:1: ruleSOMREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_LONG_0= RULE_LONG ;
    public final AntlrDatatypeRuleToken ruleSOMREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LONG_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3036:28: (this_LONG_0= RULE_LONG )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3037:5: this_LONG_0= RULE_LONG
            {
            this_LONG_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleSOMREF7065); 

            		current.merge(this_LONG_0);
                
             
                newLeafNode(this_LONG_0, grammarAccess.getSOMREFAccess().getLONGTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSOMREF"


    // $ANTLR start "entryRuleMTNAME"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3052:1: entryRuleMTNAME returns [String current=null] : iv_ruleMTNAME= ruleMTNAME EOF ;
    public final String entryRuleMTNAME() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMTNAME = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3053:2: (iv_ruleMTNAME= ruleMTNAME EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3054:2: iv_ruleMTNAME= ruleMTNAME EOF
            {
             newCompositeNode(grammarAccess.getMTNAMERule()); 
            pushFollow(FOLLOW_ruleMTNAME_in_entryRuleMTNAME7110);
            iv_ruleMTNAME=ruleMTNAME();

            state._fsp--;

             current =iv_ruleMTNAME.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMTNAME7121); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMTNAME"


    // $ANTLR start "ruleMTNAME"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3061:1: ruleMTNAME returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleMTNAME() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3064:28: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3065:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3065:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:3065:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMTNAME7161); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getMTNAMEAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,63,FOLLOW_63_in_ruleMTNAME7179); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMTNAMEAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMTNAME7194); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getMTNAMEAccess().getIDTerminalRuleCall_2()); 
                
            kw=(Token)match(input,63,FOLLOW_63_in_ruleMTNAME7212); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMTNAMEAccess().getFullStopKeyword_3()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMTNAME7227); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getMTNAMEAccess().getIDTerminalRuleCall_4()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMTNAME"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA67 dfa67 = new DFA67(this);
    static final String DFA1_eotS =
        "\13\uffff";
    static final String DFA1_eofS =
        "\13\uffff";
    static final String DFA1_minS =
        "\1\13\7\uffff\1\4\2\uffff";
    static final String DFA1_maxS =
        "\1\75\7\uffff\1\40\2\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\7";
    static final String DFA1_specialS =
        "\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1\10\uffff\1\2\1\uffff\1\4\2\uffff\1\5\1\6\1\uffff\2\7\1\10\2\uffff\1\11\1\2\11\uffff\10\3\1\uffff\3\3\6\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\7\33\uffff\1\12",
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
            return "()* loopback of 139:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) ) | ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) ) )*";
        }
    }
    static final String DFA20_eotS =
        "\12\uffff";
    static final String DFA20_eofS =
        "\12\uffff";
    static final String DFA20_minS =
        "\1\13\7\uffff\1\4\1\uffff";
    static final String DFA20_maxS =
        "\1\75\7\uffff\1\40\1\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\10\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\7";
    static final String DFA20_specialS =
        "\12\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1\10\uffff\1\2\1\uffff\1\4\2\uffff\1\5\1\6\1\uffff\2\7\1\10\3\uffff\1\2\11\uffff\10\3\1\uffff\3\3\6\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\7\33\uffff\1\11",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "()* loopback of 848:1: ( ( (lv_featureInstance_29_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_30_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_31_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_32_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_33_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_34_0= ruleModeInstance ) ) | ( (lv_modeTransitionInstance_35_0= ruleModeTransitionInstance ) ) )*";
        }
    }
    static final String DFA48_eotS =
        "\22\uffff";
    static final String DFA48_eofS =
        "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String DFA48_minS =
        "\1\54\7\uffff\1\4\1\uffff\1\4\1\55\6\uffff";
    static final String DFA48_maxS =
        "\1\67\7\uffff\1\64\1\uffff\1\64\1\62\6\uffff";
    static final String DFA48_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\16\1\15";
    static final String DFA48_specialS =
        "\22\uffff}>";
    static final String[] DFA48_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\57\uffff\1\15",
            "",
            "\1\16\57\uffff\1\17",
            "\1\21\4\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "2159:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String DFA67_eotS =
        "\7\uffff";
    static final String DFA67_eofS =
        "\2\uffff\1\1\3\uffff\1\1";
    static final String DFA67_minS =
        "\1\4\1\uffff\1\11\1\5\1\uffff\1\15\1\11";
    static final String DFA67_maxS =
        "\1\5\1\uffff\1\77\1\5\1\uffff\1\15\1\77";
    static final String DFA67_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA67_specialS =
        "\7\uffff}>";
    static final String[] DFA67_transitionS = {
            "\1\2\1\1",
            "",
            "\1\1\2\uffff\1\3\7\uffff\1\1\3\uffff\1\1\46\uffff\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\1\2\uffff\1\3\7\uffff\1\1\3\uffff\1\1\46\uffff\1\4"
    };

    static final short[] DFA67_eot = DFA.unpackEncodedString(DFA67_eotS);
    static final short[] DFA67_eof = DFA.unpackEncodedString(DFA67_eofS);
    static final char[] DFA67_min = DFA.unpackEncodedStringToUnsignedChars(DFA67_minS);
    static final char[] DFA67_max = DFA.unpackEncodedStringToUnsignedChars(DFA67_maxS);
    static final short[] DFA67_accept = DFA.unpackEncodedString(DFA67_acceptS);
    static final short[] DFA67_special = DFA.unpackEncodedString(DFA67_specialS);
    static final short[][] DFA67_transition;

    static {
        int numStates = DFA67_transitionS.length;
        DFA67_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA67_transition[i] = DFA.unpackEncodedString(DFA67_transitionS[i]);
        }
    }

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = DFA67_eot;
            this.eof = DFA67_eof;
            this.min = DFA67_min;
            this.max = DFA67_max;
            this.accept = DFA67_accept;
            this.special = DFA67_special;
            this.transition = DFA67_transition;
        }
        public String getDescription() {
            return "()* loopback of 2890:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleSystemInstance131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemInstance148 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleSystemInstance165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_ruleSystemInstance188 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleSystemInstance200 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleSystemInstance222 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleSystemInstance249 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleSystemInstance276 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleSystemInstance303 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleSystemInstance330 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleSystemInstance357 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_ruleSystemInstance384 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance411 = new BitSet(new long[]{0x3FEFF00676500800L});
    public static final BitSet FOLLOW_11_in_ruleSystemInstance425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance461 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_ruleFeatureInstance517 = new BitSet(new long[]{0x00000FF800000000L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance538 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance555 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleFeatureInstance573 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFeatureInstance590 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFeatureInstance607 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFeatureInstance621 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFEATREF_in_ruleFeatureInstance644 = new BitSet(new long[]{0x0000000000084402L});
    public static final BitSet FOLLOW_14_in_ruleFeatureInstance657 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureInstance669 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFeatureInstance681 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance705 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance731 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFeatureInstance745 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance769 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance795 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureInstance810 = new BitSet(new long[]{0x0000000000080402L});
    public static final BitSet FOLLOW_19_in_ruleFeatureInstance825 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureInstance837 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFeatureInstance849 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance873 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance899 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFeatureInstance913 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance937 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance963 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureInstance978 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_ruleFeatureInstance993 = new BitSet(new long[]{0x0000000400100800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance1014 = new BitSet(new long[]{0x0000000400100800L});
    public static final BitSet FOLLOW_11_in_ruleFeatureInstance1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance1065 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleComponentInstance1121 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance1138 = new BitSet(new long[]{0x0000000000101200L});
    public static final BitSet FOLLOW_12_in_ruleComponentInstance1156 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleComponentInstance1173 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleComponentInstance1190 = new BitSet(new long[]{0x0000000000101200L});
    public static final BitSet FOLLOW_20_in_ruleComponentInstance1205 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleComponentInstance1217 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1229 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance1249 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1262 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance1282 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance1296 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleComponentInstance1310 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleComponentInstance1333 = new BitSet(new long[]{0x0000000000084402L});
    public static final BitSet FOLLOW_14_in_ruleComponentInstance1346 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance1358 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1370 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1393 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1406 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1429 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance1443 = new BitSet(new long[]{0x0000000000080402L});
    public static final BitSet FOLLOW_19_in_ruleComponentInstance1458 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance1470 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1482 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1505 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1518 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1541 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance1555 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_ruleComponentInstance1570 = new BitSet(new long[]{0x3FEFF00476500800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1592 = new BitSet(new long[]{0x3FEFF00476500800L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleComponentInstance1619 = new BitSet(new long[]{0x3FEFF00476500800L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1646 = new BitSet(new long[]{0x3FEFF00476500800L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1673 = new BitSet(new long[]{0x3FEFF00476500800L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance1700 = new BitSet(new long[]{0x3FEFF00476500800L});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleComponentInstance1727 = new BitSet(new long[]{0x3FEFF00476500800L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance1754 = new BitSet(new long[]{0x3FEFF00476500800L});
    public static final BitSet FOLLOW_11_in_ruleComponentInstance1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1806 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance1816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance1859 = new BitSet(new long[]{0x3F00000000400000L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1894 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConnectionInstance1911 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleConnectionInstance1928 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1951 = new BitSet(new long[]{0x0000000001800000L});
    public static final BitSet FOLLOW_23_in_ruleConnectionInstance1970 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_24_in_ruleConnectionInstance2001 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2025 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_20_in_ruleConnectionInstance2038 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleConnectionInstance2050 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleConnectionInstance2062 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSOMREF_in_ruleConnectionInstance2085 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleConnectionInstance2098 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSOMREF_in_ruleConnectionInstance2121 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleConnectionInstance2135 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleConnectionInstance2149 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_ruleConnectionInstance2170 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_ruleConnectionInstance2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference2219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2277 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleConnectionReference2289 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2312 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleConnectionReference2324 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleConnectionReference2347 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConnectionReference2359 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_ruleConnectionReference2382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFlowSpecificationInstance2465 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2482 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFlowSpecificationInstance2499 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2522 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2535 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2558 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFlowSpecificationInstance2571 = new BitSet(new long[]{0x0000000000100200L});
    public static final BitSet FOLLOW_20_in_ruleFlowSpecificationInstance2584 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleFlowSpecificationInstance2596 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFlowSpecificationInstance2608 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2628 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFlowSpecificationInstance2641 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2661 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFlowSpecificationInstance2675 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFlowSpecificationInstance2689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFEATREF_in_ruleFlowSpecificationInstance2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance2748 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndToEndFlowInstance2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleEndToEndFlowInstance2795 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleEndToEndFlowInstance2807 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleEndToEndFlowInstance2819 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEndToEndFlowInstance2831 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance2848 = new BitSet(new long[]{0x0000000000100230L});
    public static final BitSet FOLLOW_ruleFLOWELEMENTREF_in_ruleEndToEndFlowInstance2877 = new BitSet(new long[]{0x0000000001100200L});
    public static final BitSet FOLLOW_24_in_ruleEndToEndFlowInstance2890 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleFLOWELEMENTREF_in_ruleEndToEndFlowInstance2913 = new BitSet(new long[]{0x0000000001100200L});
    public static final BitSet FOLLOW_20_in_ruleEndToEndFlowInstance2930 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleEndToEndFlowInstance2942 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleEndToEndFlowInstance2954 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSOMREF_in_ruleEndToEndFlowInstance2977 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleEndToEndFlowInstance2990 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSOMREF_in_ruleEndToEndFlowInstance3013 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleEndToEndFlowInstance3027 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleEndToEndFlowInstance3041 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleEndToEndFlowInstance3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_entryRuleModeInstance3100 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeInstance3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleModeInstance3153 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_29_in_ruleModeInstance3185 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleModeInstance3211 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3228 = new BitSet(new long[]{0x0000000080084200L});
    public static final BitSet FOLLOW_31_in_ruleModeInstance3246 = new BitSet(new long[]{0x0000000000010010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3267 = new BitSet(new long[]{0x0000000000084200L});
    public static final BitSet FOLLOW_16_in_ruleModeInstance3286 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3306 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModeInstance3319 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance3339 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleModeInstance3353 = new BitSet(new long[]{0x0000000000084200L});
    public static final BitSet FOLLOW_14_in_ruleModeInstance3370 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModeInstance3382 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModeInstance3394 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSOMREF_in_ruleModeInstance3417 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleModeInstance3430 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSOMREF_in_ruleModeInstance3453 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleModeInstance3467 = new BitSet(new long[]{0x0000000000080200L});
    public static final BitSet FOLLOW_19_in_ruleModeInstance3482 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModeInstance3494 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModeInstance3506 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSOMREF_in_ruleModeInstance3529 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleModeInstance3542 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleSOMREF_in_ruleModeInstance3565 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleModeInstance3579 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleModeInstance3593 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMODEREF_in_ruleModeInstance3616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance3652 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransitionInstance3662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleModeTransitionInstance3699 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleModeTransitionInstance3711 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMTNAME_in_ruleModeTransitionInstance3732 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance3752 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleModeTransitionInstance3764 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance3784 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleModeTransitionInstance3796 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMODEREF_in_ruleModeTransitionInstance3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode3855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSystemOperationMode3902 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSystemOperationMode3919 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleMODEINSTREF_in_ruleSystemOperationMode3948 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleSystemOperationMode3961 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMODEINSTREF_in_ruleSystemOperationMode3984 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType4025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType4036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDirectionType4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleDirectionType4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleDirectionType4113 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleDirectionType4126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory4168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory4179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleFeatureCategory4217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleFeatureCategory4236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleFeatureCategory4255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleFeatureCategory4274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleFeatureCategory4293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleFeatureCategory4312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleFeatureCategory4331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleFeatureCategory4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleFeatureCategory4369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory4410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory4421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleComponentCategory4459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleComponentCategory4478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleComponentCategory4497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleComponentCategory4516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleComponentCategory4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleComponentCategory4554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleComponentCategory4573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleComponentCategory4592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleComponentCategory4612 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleComponentCategory4625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleComponentCategory4645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleComponentCategory4665 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_52_in_ruleComponentCategory4678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleComponentCategory4698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleComponentCategory4718 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleComponentCategory4731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleComponentCategory4752 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_50_in_ruleComponentCategory4765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind4807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind4818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleConnectionKind4856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleConnectionKind4875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleConnectionKind4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleConnectionKind4913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleConnectionKind4932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleConnectionKind4951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF4992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMPLREF5003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF5044 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleIMPLREF5062 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF5079 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleIMPLREF5097 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF5112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_entryRuleFEATREF5158 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFEATREF5169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF5210 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleFEATREF5228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF5245 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleFEATREF5263 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF5278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_entryRuleSUBREF5324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSUBREF5335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF5376 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleSUBREF5394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF5411 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleSUBREF5429 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF5444 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleSUBREF5462 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF5477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMODEREF_in_entryRuleMODEREF5523 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMODEREF5534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEREF5575 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleMODEREF5593 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEREF5610 = new BitSet(new long[]{0xC000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleMODEREF5629 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEREF5644 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleMODEREF5664 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEREF5679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF5725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREF5736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF5776 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREF5795 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREF5810 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREF5828 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_63_in_ruleINSTANCEREF5844 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF5859 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREF5878 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREF5893 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREF5911 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_entryRuleSIMPLEINSTANCEREF5956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSIMPLEINSTANCEREF5967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF6007 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSIMPLEINSTANCEREF6026 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF6041 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSIMPLEINSTANCEREF6059 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleSIMPLEINSTANCEREF6075 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF6090 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSIMPLEINSTANCEREF6109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF6124 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSIMPLEINSTANCEREF6142 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT6187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT6198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleINSTANCEREFWITHPARENT6236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT6258 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREFWITHPARENT6277 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT6292 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREFWITHPARENT6310 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_63_in_ruleINSTANCEREFWITHPARENT6326 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT6341 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREFWITHPARENT6360 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT6375 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREFWITHPARENT6393 = new BitSet(new long[]{0x8000000000001002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF6439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONNINSTREF6450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleCONNINSTREF6491 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleCONNINSTREF6509 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleCONNINSTREF6526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFLOWELEMENTREF_in_entryRuleFLOWELEMENTREF6572 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFLOWELEMENTREF6583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFLOWELEMENTREF6624 = new BitSet(new long[]{0x8000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFLOWELEMENTREF6643 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF6658 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFLOWELEMENTREF6676 = new BitSet(new long[]{0x8000000000001000L});
    public static final BitSet FOLLOW_63_in_ruleFLOWELEMENTREF6691 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF6709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFLOWELEMENTREF6736 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleFLOWELEMENTREF6755 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF6770 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFLOWELEMENTREF6788 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleMODEINSTREF_in_entryRuleMODEINSTREF6833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMODEINSTREF6844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEINSTREF6885 = new BitSet(new long[]{0x8000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMODEINSTREF6904 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleMODEINSTREF6919 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleMODEINSTREF6937 = new BitSet(new long[]{0x8000000000001000L});
    public static final BitSet FOLLOW_63_in_ruleMODEINSTREF6952 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEINSTREF6969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMREF_in_entryRuleSOMREF7015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSOMREF7026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleSOMREF7065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMTNAME_in_entryRuleMTNAME7110 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMTNAME7121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMTNAME7161 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleMTNAME7179 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMTNAME7194 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleMTNAME7212 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMTNAME7227 = new BitSet(new long[]{0x0000000000000002L});

}