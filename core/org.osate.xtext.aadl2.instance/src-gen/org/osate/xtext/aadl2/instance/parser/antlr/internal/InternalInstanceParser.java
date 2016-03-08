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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_LONG", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "':'", "'{'", "'}'", "'['", "']'", "'source'", "'of'", "'('", "','", "')'", "'destination'", "'complete'", "'<->'", "'->'", "'in'", "'flow'", "'end'", "'to'", "'initial'", "'derived'", "'mode'", "'som'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'featureConnection'", "'accessConnection'", "'parameterConnection'", "'portConnection'", "'modeTransitionConnection'", "'featureGroupConnection'", "'::'", "'.'", "'parent'"
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
    public static final int T__20=20;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:76:1: ruleSystemInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_systemOperationMode_11_0= ruleSystemOperationMode ) ) )* otherlv_12= '}' ) ;
    public final EObject ruleSystemInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_5_0 = null;

        EObject lv_componentInstance_6_0 = null;

        EObject lv_connectionInstance_7_0 = null;

        EObject lv_flowSpecification_8_0 = null;

        EObject lv_endToEndFlow_9_0 = null;

        EObject lv_modeInstance_10_0 = null;

        EObject lv_systemOperationMode_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:79:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_systemOperationMode_11_0= ruleSystemOperationMode ) ) )* otherlv_12= '}' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_systemOperationMode_11_0= ruleSystemOperationMode ) ) )* otherlv_12= '}' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_systemOperationMode_11_0= ruleSystemOperationMode ) ) )* otherlv_12= '}' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_systemOperationMode_11_0= ruleSystemOperationMode ) ) )* otherlv_12= '}'
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
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:139:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_9_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_10_0= ruleModeInstance ) ) | ( (lv_systemOperationMode_11_0= ruleSystemOperationMode ) ) )*
            loop1:
            do {
                int alt1=8;
                switch ( input.LA(1) ) {
                case 23:
                case 31:
                    {
                    alt1=1;
                    }
                    break;
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 50:
                case 51:
                case 52:
                    {
                    alt1=2;
                    }
                    break;
                case 20:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                    {
                    alt1=3;
                    }
                    break;
                case 24:
                    {
                    alt1=4;
                    }
                    break;
                case 25:
                    {
                    alt1=5;
                    }
                    break;
                case 27:
                case 28:
                case 29:
                    {
                    alt1=6;
                    }
                    break;
                case 30:
                    {
                    alt1=7;
                    }
                    break;

                }

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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:253:6: ( (lv_systemOperationMode_11_0= ruleSystemOperationMode ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:253:6: ( (lv_systemOperationMode_11_0= ruleSystemOperationMode ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:254:1: (lv_systemOperationMode_11_0= ruleSystemOperationMode )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:254:1: (lv_systemOperationMode_11_0= ruleSystemOperationMode )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:255:3: lv_systemOperationMode_11_0= ruleSystemOperationMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance384);
            	    lv_systemOperationMode_11_0=ruleSystemOperationMode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systemOperationMode",
            	            		lv_systemOperationMode_11_0, 
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

            otherlv_12=(Token)match(input,11,FOLLOW_11_in_ruleSystemInstance398); 

                	newLeafNode(otherlv_12, grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:283:1: entryRuleFeatureInstance returns [EObject current=null] : iv_ruleFeatureInstance= ruleFeatureInstance EOF ;
    public final EObject entryRuleFeatureInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:284:2: (iv_ruleFeatureInstance= ruleFeatureInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:285:2: iv_ruleFeatureInstance= ruleFeatureInstance EOF
            {
             newCompositeNode(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance434);
            iv_ruleFeatureInstance=ruleFeatureInstance();

            state._fsp--;

             current =iv_ruleFeatureInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance444); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:292:1: ruleFeatureInstance returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:295:28: ( ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:296:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:296:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:296:2: ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:296:2: ( (lv_direction_0_0= ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:297:1: (lv_direction_0_0= ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:297:1: (lv_direction_0_0= ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:298:3: lv_direction_0_0= ruleDirectionType
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDirectionType_in_ruleFeatureInstance490);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:314:2: ( (lv_category_1_0= ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:315:1: (lv_category_1_0= ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:315:1: (lv_category_1_0= ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:316:3: lv_category_1_0= ruleFeatureCategory
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance511);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:332:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:333:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:333:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:334:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance528); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:350:2: (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:350:4: otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleFeatureInstance546); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:354:1: ( (lv_index_4_0= RULE_LONG ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:355:1: (lv_index_4_0= RULE_LONG )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:355:1: (lv_index_4_0= RULE_LONG )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:356:3: lv_index_4_0= RULE_LONG
                    {
                    lv_index_4_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFeatureInstance563); 

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

                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleFeatureInstance580); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,9,FOLLOW_9_in_ruleFeatureInstance594); 

                	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:380:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:381:1: ( ruleFEATREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:381:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:382:3: ruleFEATREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFEATREF_in_ruleFeatureInstance617);
            ruleFEATREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:395:2: (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:395:4: otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')'
                    {
                    otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleFeatureInstance630); 

                        	newLeafNode(otherlv_8, grammarAccess.getFeatureInstanceAccess().getSourceKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleFeatureInstance642); 

                        	newLeafNode(otherlv_9, grammarAccess.getFeatureInstanceAccess().getOfKeyword_6_1());
                        
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleFeatureInstance654); 

                        	newLeafNode(otherlv_10, grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:407:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) )
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
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:407:2: ( ( ruleCONNINSTREF ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:407:2: ( ( ruleCONNINSTREF ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:408:1: ( ruleCONNINSTREF )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:408:1: ( ruleCONNINSTREF )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:409:3: ruleCONNINSTREF
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance678);
                            ruleCONNINSTREF();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:423:6: ( (otherlv_12= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:423:6: ( (otherlv_12= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:424:1: (otherlv_12= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:424:1: (otherlv_12= RULE_ID )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:425:3: otherlv_12= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                            otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance704); 

                            		newLeafNode(otherlv_12, grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceCrossReference_6_3_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:436:3: (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==17) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:436:5: otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) )
                    	    {
                    	    otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleFeatureInstance718); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getFeatureInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:440:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) )
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
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:440:2: ( ( ruleCONNINSTREF ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:440:2: ( ( ruleCONNINSTREF ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:441:1: ( ruleCONNINSTREF )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:441:1: ( ruleCONNINSTREF )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:442:3: ruleCONNINSTREF
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_4_1_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance742);
                    	            ruleCONNINSTREF();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:456:6: ( (otherlv_15= RULE_ID ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:456:6: ( (otherlv_15= RULE_ID ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:457:1: (otherlv_15= RULE_ID )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:457:1: (otherlv_15= RULE_ID )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:458:3: otherlv_15= RULE_ID
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	            otherlv_15=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance768); 

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

                    otherlv_16=(Token)match(input,18,FOLLOW_18_in_ruleFeatureInstance783); 

                        	newLeafNode(otherlv_16, grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:473:3: (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:473:5: otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')'
                    {
                    otherlv_17=(Token)match(input,19,FOLLOW_19_in_ruleFeatureInstance798); 

                        	newLeafNode(otherlv_17, grammarAccess.getFeatureInstanceAccess().getDestinationKeyword_7_0());
                        
                    otherlv_18=(Token)match(input,15,FOLLOW_15_in_ruleFeatureInstance810); 

                        	newLeafNode(otherlv_18, grammarAccess.getFeatureInstanceAccess().getOfKeyword_7_1());
                        
                    otherlv_19=(Token)match(input,16,FOLLOW_16_in_ruleFeatureInstance822); 

                        	newLeafNode(otherlv_19, grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:485:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) )
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
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:485:2: ( ( ruleCONNINSTREF ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:485:2: ( ( ruleCONNINSTREF ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:486:1: ( ruleCONNINSTREF )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:486:1: ( ruleCONNINSTREF )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:487:3: ruleCONNINSTREF
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance846);
                            ruleCONNINSTREF();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:501:6: ( (otherlv_21= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:501:6: ( (otherlv_21= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:502:1: (otherlv_21= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:502:1: (otherlv_21= RULE_ID )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:503:3: otherlv_21= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                            otherlv_21=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance872); 

                            		newLeafNode(otherlv_21, grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceCrossReference_7_3_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:514:3: (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==17) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:514:5: otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) )
                    	    {
                    	    otherlv_22=(Token)match(input,17,FOLLOW_17_in_ruleFeatureInstance886); 

                    	        	newLeafNode(otherlv_22, grammarAccess.getFeatureInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:518:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) )
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
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:518:2: ( ( ruleCONNINSTREF ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:518:2: ( ( ruleCONNINSTREF ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:519:1: ( ruleCONNINSTREF )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:519:1: ( ruleCONNINSTREF )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:520:3: ruleCONNINSTREF
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_4_1_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance910);
                    	            ruleCONNINSTREF();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:534:6: ( (otherlv_24= RULE_ID ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:534:6: ( (otherlv_24= RULE_ID ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:535:1: (otherlv_24= RULE_ID )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:535:1: (otherlv_24= RULE_ID )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:536:3: otherlv_24= RULE_ID
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	            otherlv_24=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance936); 

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

                    otherlv_25=(Token)match(input,18,FOLLOW_18_in_ruleFeatureInstance951); 

                        	newLeafNode(otherlv_25, grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:551:3: (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==10) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:551:5: otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}'
                    {
                    otherlv_26=(Token)match(input,10,FOLLOW_10_in_ruleFeatureInstance966); 

                        	newLeafNode(otherlv_26, grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:555:1: ( (lv_featureInstance_27_0= ruleFeatureInstance ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==23||LA11_0==31) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:556:1: (lv_featureInstance_27_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:556:1: (lv_featureInstance_27_0= ruleFeatureInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:557:3: lv_featureInstance_27_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance987);
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

                    otherlv_28=(Token)match(input,11,FOLLOW_11_in_ruleFeatureInstance1000); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:585:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:586:2: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:587:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance1038);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance1048); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:594:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_27_0= ruleModeInstance ) ) )* otherlv_28= '}' )? ) ;
    public final EObject ruleComponentInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_index_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_28=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_22_0 = null;

        EObject lv_componentInstance_23_0 = null;

        EObject lv_connectionInstance_24_0 = null;

        EObject lv_flowSpecification_25_0 = null;

        EObject lv_endToEndFlow_26_0 = null;

        EObject lv_modeInstance_27_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:597:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_27_0= ruleModeInstance ) ) )* otherlv_28= '}' )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:598:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_27_0= ruleModeInstance ) ) )* otherlv_28= '}' )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:598:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_27_0= ruleModeInstance ) ) )* otherlv_28= '}' )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:598:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_27_0= ruleModeInstance ) ) )* otherlv_28= '}' )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:598:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:599:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:599:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:600:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleComponentInstance1094);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:616:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:617:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:617:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:618:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance1111); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:634:2: (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==12) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:634:4: otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']'
            	    {
            	    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleComponentInstance1129); 

            	        	newLeafNode(otherlv_2, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0());
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:638:1: ( (lv_index_3_0= RULE_LONG ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:639:1: (lv_index_3_0= RULE_LONG )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:639:1: (lv_index_3_0= RULE_LONG )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:640:3: lv_index_3_0= RULE_LONG
            	    {
            	    lv_index_3_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleComponentInstance1146); 

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

            	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleComponentInstance1163); 

            	        	newLeafNode(otherlv_4, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_5=(Token)match(input,9,FOLLOW_9_in_ruleComponentInstance1177); 

                	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:664:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:665:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:665:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:666:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleComponentInstance1200);
            ruleSUBREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:679:2: (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:679:4: otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleComponentInstance1213); 

                        	newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getSourceKeyword_5_0());
                        
                    otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance1225); 

                        	newLeafNode(otherlv_8, grammarAccess.getComponentInstanceAccess().getOfKeyword_5_1());
                        
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1237); 

                        	newLeafNode(otherlv_9, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_5_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:691:1: ( ( ruleCONNINSTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:692:1: ( ruleCONNINSTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:692:1: ( ruleCONNINSTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:693:3: ruleCONNINSTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1260);
                    ruleCONNINSTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:706:2: (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:706:4: otherlv_11= ',' ( ( ruleCONNINSTREF ) )
                    	    {
                    	    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1273); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getComponentInstanceAccess().getCommaKeyword_5_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:710:1: ( ( ruleCONNINSTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:711:1: ( ruleCONNINSTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:711:1: ( ruleCONNINSTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:712:3: ruleCONNINSTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1296);
                    	    ruleCONNINSTREF();

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

                    otherlv_13=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance1310); 

                        	newLeafNode(otherlv_13, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_5_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:729:3: (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==19) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:729:5: otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')'
                    {
                    otherlv_14=(Token)match(input,19,FOLLOW_19_in_ruleComponentInstance1325); 

                        	newLeafNode(otherlv_14, grammarAccess.getComponentInstanceAccess().getDestinationKeyword_6_0());
                        
                    otherlv_15=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance1337); 

                        	newLeafNode(otherlv_15, grammarAccess.getComponentInstanceAccess().getOfKeyword_6_1());
                        
                    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1349); 

                        	newLeafNode(otherlv_16, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:741:1: ( ( ruleCONNINSTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:742:1: ( ruleCONNINSTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:742:1: ( ruleCONNINSTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:743:3: ruleCONNINSTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1372);
                    ruleCONNINSTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:756:2: (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==17) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:756:4: otherlv_18= ',' ( ( ruleCONNINSTREF ) )
                    	    {
                    	    otherlv_18=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1385); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getComponentInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:760:1: ( ( ruleCONNINSTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:761:1: ( ruleCONNINSTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:761:1: ( ruleCONNINSTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:762:3: ruleCONNINSTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1408);
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

                    otherlv_20=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance1422); 

                        	newLeafNode(otherlv_20, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:779:3: (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_27_0= ruleModeInstance ) ) )* otherlv_28= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==10) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:779:5: otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_27_0= ruleModeInstance ) ) )* otherlv_28= '}'
                    {
                    otherlv_21=(Token)match(input,10,FOLLOW_10_in_ruleComponentInstance1437); 

                        	newLeafNode(otherlv_21, grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:783:1: ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) | ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) ) | ( (lv_modeInstance_27_0= ruleModeInstance ) ) )*
                    loop18:
                    do {
                        int alt18=7;
                        switch ( input.LA(1) ) {
                        case 23:
                        case 31:
                            {
                            alt18=1;
                            }
                            break;
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 50:
                        case 51:
                        case 52:
                            {
                            alt18=2;
                            }
                            break;
                        case 20:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                            {
                            alt18=3;
                            }
                            break;
                        case 24:
                            {
                            alt18=4;
                            }
                            break;
                        case 25:
                            {
                            alt18=5;
                            }
                            break;
                        case 27:
                        case 28:
                        case 29:
                            {
                            alt18=6;
                            }
                            break;

                        }

                        switch (alt18) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:783:2: ( (lv_featureInstance_22_0= ruleFeatureInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:783:2: ( (lv_featureInstance_22_0= ruleFeatureInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:784:1: (lv_featureInstance_22_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:784:1: (lv_featureInstance_22_0= ruleFeatureInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:785:3: lv_featureInstance_22_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1459);
                    	    lv_featureInstance_22_0=ruleFeatureInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"featureInstance",
                    	            		lv_featureInstance_22_0, 
                    	            		"FeatureInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:802:6: ( (lv_componentInstance_23_0= ruleComponentInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:802:6: ( (lv_componentInstance_23_0= ruleComponentInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:803:1: (lv_componentInstance_23_0= ruleComponentInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:803:1: (lv_componentInstance_23_0= ruleComponentInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:804:3: lv_componentInstance_23_0= ruleComponentInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleComponentInstance1486);
                    	    lv_componentInstance_23_0=ruleComponentInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"componentInstance",
                    	            		lv_componentInstance_23_0, 
                    	            		"ComponentInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 3 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:821:6: ( (lv_connectionInstance_24_0= ruleConnectionInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:821:6: ( (lv_connectionInstance_24_0= ruleConnectionInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:822:1: (lv_connectionInstance_24_0= ruleConnectionInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:822:1: (lv_connectionInstance_24_0= ruleConnectionInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:823:3: lv_connectionInstance_24_0= ruleConnectionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1513);
                    	    lv_connectionInstance_24_0=ruleConnectionInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"connectionInstance",
                    	            		lv_connectionInstance_24_0, 
                    	            		"ConnectionInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 4 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:840:6: ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:840:6: ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:841:1: (lv_flowSpecification_25_0= ruleFlowSpecificationInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:841:1: (lv_flowSpecification_25_0= ruleFlowSpecificationInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:842:3: lv_flowSpecification_25_0= ruleFlowSpecificationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_7_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1540);
                    	    lv_flowSpecification_25_0=ruleFlowSpecificationInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"flowSpecification",
                    	            		lv_flowSpecification_25_0, 
                    	            		"FlowSpecificationInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 5 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:859:6: ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:859:6: ( (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:860:1: (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:860:1: (lv_endToEndFlow_26_0= ruleEndToEndFlowInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:861:3: lv_endToEndFlow_26_0= ruleEndToEndFlowInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_7_1_4_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance1567);
                    	    lv_endToEndFlow_26_0=ruleEndToEndFlowInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"endToEndFlow",
                    	            		lv_endToEndFlow_26_0, 
                    	            		"EndToEndFlowInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;
                    	case 6 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:878:6: ( (lv_modeInstance_27_0= ruleModeInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:878:6: ( (lv_modeInstance_27_0= ruleModeInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:879:1: (lv_modeInstance_27_0= ruleModeInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:879:1: (lv_modeInstance_27_0= ruleModeInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:880:3: lv_modeInstance_27_0= ruleModeInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_7_1_5_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModeInstance_in_ruleComponentInstance1594);
                    	    lv_modeInstance_27_0=ruleModeInstance();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modeInstance",
                    	            		lv_modeInstance_27_0, 
                    	            		"ModeInstance");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_28=(Token)match(input,11,FOLLOW_11_in_ruleComponentInstance1608); 

                        	newLeafNode(otherlv_28, grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2());
                        

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:908:1: entryRuleConnectionInstance returns [EObject current=null] : iv_ruleConnectionInstance= ruleConnectionInstance EOF ;
    public final EObject entryRuleConnectionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:909:2: (iv_ruleConnectionInstance= ruleConnectionInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:910:2: iv_ruleConnectionInstance= ruleConnectionInstance EOF
            {
             newCompositeNode(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1646);
            iv_ruleConnectionInstance=ruleConnectionInstance();

            state._fsp--;

             current =iv_ruleConnectionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance1656); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:917:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}' ) ;
    public final EObject ruleConnectionInstance() throws RecognitionException {
        EObject current = null;

        Token lv_complete_0_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_bidirectional_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_kind_1_0 = null;

        EObject lv_connectionReference_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:920:28: ( ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:921:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:921:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:921:2: ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:921:2: ( (lv_complete_0_0= 'complete' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==20) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:922:1: (lv_complete_0_0= 'complete' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:922:1: (lv_complete_0_0= 'complete' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:923:3: lv_complete_0_0= 'complete'
                    {
                    lv_complete_0_0=(Token)match(input,20,FOLLOW_20_in_ruleConnectionInstance1699); 

                            newLeafNode(lv_complete_0_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "complete", true, "complete");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:936:3: ( (lv_kind_1_0= ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:937:1: (lv_kind_1_0= ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:937:1: (lv_kind_1_0= ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:938:3: lv_kind_1_0= ruleConnectionKind
            {
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1734);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:954:2: ( (lv_name_2_0= RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:955:1: (lv_name_2_0= RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:955:1: (lv_name_2_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:956:3: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConnectionInstance1751); 

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

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleConnectionInstance1768); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:976:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:977:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:977:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:978:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1791);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:991:2: ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==21) ) {
                alt21=1;
            }
            else if ( (LA21_0==22) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:991:3: ( (lv_bidirectional_5_0= '<->' ) )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:991:3: ( (lv_bidirectional_5_0= '<->' ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:992:1: (lv_bidirectional_5_0= '<->' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:992:1: (lv_bidirectional_5_0= '<->' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:993:3: lv_bidirectional_5_0= '<->'
                    {
                    lv_bidirectional_5_0=(Token)match(input,21,FOLLOW_21_in_ruleConnectionInstance1810); 

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
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1007:7: otherlv_6= '->'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance1841); 

                        	newLeafNode(otherlv_6, grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1011:2: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1012:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1012:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1013:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1865);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,10,FOLLOW_10_in_ruleConnectionInstance1877); 

                	newLeafNode(otherlv_8, grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_7());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1030:1: ( (lv_connectionReference_9_0= ruleConnectionReference ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1031:1: (lv_connectionReference_9_0= ruleConnectionReference )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1031:1: (lv_connectionReference_9_0= ruleConnectionReference )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1032:3: lv_connectionReference_9_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionReference_in_ruleConnectionInstance1898);
            	    lv_connectionReference_9_0=ruleConnectionReference();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionReference",
            	            		lv_connectionReference_9_0, 
            	            		"ConnectionReference");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);

            otherlv_10=(Token)match(input,11,FOLLOW_11_in_ruleConnectionInstance1911); 

                	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getRightCurlyBracketKeyword_9());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1060:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1061:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1062:2: iv_ruleConnectionReference= ruleConnectionReference EOF
            {
             newCompositeNode(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference1947);
            iv_ruleConnectionReference=ruleConnectionReference();

            state._fsp--;

             current =iv_ruleConnectionReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference1957); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1069:1: ruleConnectionReference returns [EObject current=null] : ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1072:28: ( ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1073:1: ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1073:1: ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1073:2: ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1073:2: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1074:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1074:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1075:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2005);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleConnectionReference2017); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1092:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1093:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1093:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1094:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2040);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleConnectionReference2052); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionReferenceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1111:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1112:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1112:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1113:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleConnectionReference2075);
            ruleSUBREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleConnectionReference2087); 

                	newLeafNode(otherlv_5, grammarAccess.getConnectionReferenceAccess().getInKeyword_5());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1130:1: ( ( ruleINSTANCEREFWITHPARENT ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1131:1: ( ruleINSTANCEREFWITHPARENT )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1131:1: ( ruleINSTANCEREFWITHPARENT )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1132:3: ruleINSTANCEREFWITHPARENT
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_ruleConnectionReference2110);
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1153:1: entryRuleFlowSpecificationInstance returns [EObject current=null] : iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF ;
    public final EObject entryRuleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecificationInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1154:2: (iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1155:2: iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF
            {
             newCompositeNode(grammarAccess.getFlowSpecificationInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2146);
            iv_ruleFlowSpecificationInstance=ruleFlowSpecificationInstance();

            state._fsp--;

             current =iv_ruleFlowSpecificationInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2156); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1162:1: ruleFlowSpecificationInstance returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) ) ) ;
    public final EObject ruleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1165:28: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1166:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1166:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1166:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2193); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1170:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1171:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1171:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1172:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2210); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFlowSpecificationInstance2227); 

                	newLeafNode(otherlv_2, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1192:1: ( ( ruleSIMPLEINSTANCEREF ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1193:1: ( ruleSIMPLEINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1193:1: ( ruleSIMPLEINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1194:3: ruleSIMPLEINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2250);
                    ruleSIMPLEINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecificationInstance2263); 

                	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1211:1: ( ( ruleSIMPLEINSTANCEREF ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1212:1: ( ruleSIMPLEINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1212:1: ( ruleSIMPLEINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1213:3: ruleSIMPLEINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2286);
                    ruleSIMPLEINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleFlowSpecificationInstance2299); 

                	newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6());
                
            otherlv_7=(Token)match(input,9,FOLLOW_9_in_ruleFlowSpecificationInstance2311); 

                	newLeafNode(otherlv_7, grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_7());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1234:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1235:1: ( ruleFEATREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1235:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1236:3: ruleFEATREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_ruleFEATREF_in_ruleFlowSpecificationInstance2334);
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1257:1: entryRuleEndToEndFlowInstance returns [EObject current=null] : iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF ;
    public final EObject entryRuleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndToEndFlowInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1258:2: (iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1259:2: iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF
            {
             newCompositeNode(grammarAccess.getEndToEndFlowInstanceRule()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance2370);
            iv_ruleEndToEndFlowInstance=ruleEndToEndFlowInstance();

            state._fsp--;

             current =iv_ruleEndToEndFlowInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndToEndFlowInstance2380); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1266:1: ruleEndToEndFlowInstance returns [EObject current=null] : (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? otherlv_8= ':' ( ( ruleSUBREF ) ) ) ;
    public final EObject ruleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1269:28: ( (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? otherlv_8= ':' ( ( ruleSUBREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1270:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? otherlv_8= ':' ( ( ruleSUBREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1270:1: (otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? otherlv_8= ':' ( ( ruleSUBREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1270:3: otherlv_0= 'end' otherlv_1= 'to' otherlv_2= 'end' otherlv_3= 'flow' ( (lv_name_4_0= RULE_ID ) ) ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )? otherlv_8= ':' ( ( ruleSUBREF ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleEndToEndFlowInstance2417); 

                	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_0());
                
            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleEndToEndFlowInstance2429); 

                	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getToKeyword_1());
                
            otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleEndToEndFlowInstance2441); 

                	newLeafNode(otherlv_2, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_2());
                
            otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleEndToEndFlowInstance2453); 

                	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getFlowKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1286:1: ( (lv_name_4_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1287:1: (lv_name_4_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1287:1: (lv_name_4_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1288:3: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance2470); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1304:2: ( ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( ((LA26_0>=RULE_ID && LA26_0<=RULE_LONG)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1304:3: ( ( ruleFLOWELEMENTREF ) ) (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1304:3: ( ( ruleFLOWELEMENTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1305:1: ( ruleFLOWELEMENTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1305:1: ( ruleFLOWELEMENTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1306:3: ruleFLOWELEMENTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleFLOWELEMENTREF_in_ruleEndToEndFlowInstance2499);
                    ruleFLOWELEMENTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1319:2: (otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==22) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1319:4: otherlv_6= '->' ( ( ruleFLOWELEMENTREF ) )
                    	    {
                    	    otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleEndToEndFlowInstance2512); 

                    	        	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1323:1: ( ( ruleFLOWELEMENTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1324:1: ( ruleFLOWELEMENTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1324:1: ( ruleFLOWELEMENTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1325:3: ruleFLOWELEMENTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFLOWELEMENTREF_in_ruleEndToEndFlowInstance2535);
                    	    ruleFLOWELEMENTREF();

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

            otherlv_8=(Token)match(input,9,FOLLOW_9_in_ruleEndToEndFlowInstance2551); 

                	newLeafNode(otherlv_8, grammarAccess.getEndToEndFlowInstanceAccess().getColonKeyword_6());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1342:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1343:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1343:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1344:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleEndToEndFlowInstance2574);
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1365:1: entryRuleModeInstance returns [EObject current=null] : iv_ruleModeInstance= ruleModeInstance EOF ;
    public final EObject entryRuleModeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1366:2: (iv_ruleModeInstance= ruleModeInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1367:2: iv_ruleModeInstance= ruleModeInstance EOF
            {
             newCompositeNode(grammarAccess.getModeInstanceRule()); 
            pushFollow(FOLLOW_ruleModeInstance_in_entryRuleModeInstance2610);
            iv_ruleModeInstance=ruleModeInstance();

            state._fsp--;

             current =iv_ruleModeInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeInstance2620); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1374:1: ruleModeInstance returns [EObject current=null] : ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( ( ruleMODEREF ) ) ) ;
    public final EObject ruleModeInstance() throws RecognitionException {
        EObject current = null;

        Token lv_initial_0_0=null;
        Token lv_derived_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1377:28: ( ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( ( ruleMODEREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1378:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( ( ruleMODEREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1378:1: ( ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( ( ruleMODEREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1378:2: ( (lv_initial_0_0= 'initial' ) )? ( (lv_derived_1_0= 'derived' ) )? otherlv_2= 'mode' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= ':' ( ( ruleMODEREF ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1378:2: ( (lv_initial_0_0= 'initial' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==27) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1379:1: (lv_initial_0_0= 'initial' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1379:1: (lv_initial_0_0= 'initial' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1380:3: lv_initial_0_0= 'initial'
                    {
                    lv_initial_0_0=(Token)match(input,27,FOLLOW_27_in_ruleModeInstance2663); 

                            newLeafNode(lv_initial_0_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1393:3: ( (lv_derived_1_0= 'derived' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==28) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1394:1: (lv_derived_1_0= 'derived' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1394:1: (lv_derived_1_0= 'derived' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1395:3: lv_derived_1_0= 'derived'
                    {
                    lv_derived_1_0=(Token)match(input,28,FOLLOW_28_in_ruleModeInstance2695); 

                            newLeafNode(lv_derived_1_0, grammarAccess.getModeInstanceAccess().getDerivedDerivedKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "derived", true, "derived");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleModeInstance2721); 

                	newLeafNode(otherlv_2, grammarAccess.getModeInstanceAccess().getModeKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1412:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1413:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1413:1: (lv_name_3_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1414:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance2738); 

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

            otherlv_4=(Token)match(input,9,FOLLOW_9_in_ruleModeInstance2755); 

                	newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1434:1: ( ( ruleMODEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1435:1: ( ruleMODEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1435:1: ( ruleMODEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1436:3: ruleMODEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getModeInstanceAccess().getModeModeCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleMODEREF_in_ruleModeInstance2778);
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


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1457:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1458:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1459:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode2814);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode2824); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1466:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )? ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1469:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1470:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1470:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1470:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )?
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleSystemOperationMode2861); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1474:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1475:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1475:1: (lv_name_1_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1476:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSystemOperationMode2878); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1492:2: ( ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1492:3: ( ( ruleMODEINSTREF ) ) (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )*
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1492:3: ( ( ruleMODEINSTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1493:1: ( ruleMODEINSTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1493:1: ( ruleMODEINSTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1494:3: ruleMODEINSTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMODEINSTREF_in_ruleSystemOperationMode2907);
                    ruleMODEINSTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1507:2: (otherlv_3= ',' ( ( ruleMODEINSTREF ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==17) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1507:4: otherlv_3= ',' ( ( ruleMODEINSTREF ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleSystemOperationMode2920); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1511:1: ( ( ruleMODEINSTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1512:1: ( ruleMODEINSTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1512:1: ( ruleMODEINSTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1513:3: ruleMODEINSTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMODEINSTREF_in_ruleSystemOperationMode2943);
                    	    ruleMODEINSTREF();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1534:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1535:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1536:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType2984);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType2995); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1543:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1546:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1547:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1547:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt31=3;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==23) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==EOF||(LA31_1>=32 && LA31_1<=40)) ) {
                    alt31=1;
                }
                else if ( (LA31_1==31) ) {
                    alt31=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA31_0==31) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1548:2: kw= 'in'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleDirectionType3033); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1555:2: kw= 'out'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDirectionType3052); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1561:6: (kw= 'in' kw= 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1561:6: (kw= 'in' kw= 'out' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1562:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleDirectionType3072); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleDirectionType3085); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1581:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1582:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1583:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory3127);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory3138); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1590:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1593:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1594:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1594:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            int alt32=9;
            switch ( input.LA(1) ) {
            case 32:
                {
                alt32=1;
                }
                break;
            case 33:
                {
                alt32=2;
                }
                break;
            case 34:
                {
                alt32=3;
                }
                break;
            case 35:
                {
                alt32=4;
                }
                break;
            case 36:
                {
                alt32=5;
                }
                break;
            case 37:
                {
                alt32=6;
                }
                break;
            case 38:
                {
                alt32=7;
                }
                break;
            case 39:
                {
                alt32=8;
                }
                break;
            case 40:
                {
                alt32=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1595:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleFeatureCategory3176); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1602:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleFeatureCategory3195); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1609:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleFeatureCategory3214); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1616:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleFeatureCategory3233); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1623:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleFeatureCategory3252); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1630:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleFeatureCategory3271); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1637:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleFeatureCategory3290); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1644:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleFeatureCategory3309); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1651:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleFeatureCategory3328); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1664:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1665:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1666:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory3369);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory3380); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1673:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1676:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1677:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1677:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt33=14;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1678:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleComponentCategory3418); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1685:2: kw= 'bus'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleComponentCategory3437); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1692:2: kw= 'data'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleComponentCategory3456); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1699:2: kw= 'device'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleComponentCategory3475); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1706:2: kw= 'memory'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleComponentCategory3494); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1713:2: kw= 'process'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleComponentCategory3513); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1720:2: kw= 'processor'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleComponentCategory3532); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1727:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleComponentCategory3551); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1733:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1733:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1734:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleComponentCategory3571); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleComponentCategory3584); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1747:2: kw= 'system'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleComponentCategory3604); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1753:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1753:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1754:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleComponentCategory3624); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleComponentCategory3637); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1767:2: kw= 'thread'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleComponentCategory3657); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1773:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1773:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1774:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleComponentCategory3677); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleComponentCategory3690); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1786:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1786:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1787:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleComponentCategory3711); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleComponentCategory3724); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1806:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1807:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1808:2: iv_ruleConnectionKind= ruleConnectionKind EOF
            {
             newCompositeNode(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind3766);
            iv_ruleConnectionKind=ruleConnectionKind();

            state._fsp--;

             current =iv_ruleConnectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind3777); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1815:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1818:28: ( (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1819:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1819:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' )
            int alt34=6;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt34=1;
                }
                break;
            case 54:
                {
                alt34=2;
                }
                break;
            case 55:
                {
                alt34=3;
                }
                break;
            case 56:
                {
                alt34=4;
                }
                break;
            case 57:
                {
                alt34=5;
                }
                break;
            case 58:
                {
                alt34=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1820:2: kw= 'featureConnection'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleConnectionKind3815); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1827:2: kw= 'accessConnection'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleConnectionKind3834); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1834:2: kw= 'parameterConnection'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleConnectionKind3853); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1841:2: kw= 'portConnection'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleConnectionKind3872); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1848:2: kw= 'modeTransitionConnection'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleConnectionKind3891); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getModeTransitionConnectionKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1855:2: kw= 'featureGroupConnection'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleConnectionKind3910); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1868:1: entryRuleIMPLREF returns [String current=null] : iv_ruleIMPLREF= ruleIMPLREF EOF ;
    public final String entryRuleIMPLREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMPLREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1869:2: (iv_ruleIMPLREF= ruleIMPLREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1870:2: iv_ruleIMPLREF= ruleIMPLREF EOF
            {
             newCompositeNode(grammarAccess.getIMPLREFRule()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF3951);
            iv_ruleIMPLREF=ruleIMPLREF();

            state._fsp--;

             current =iv_ruleIMPLREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMPLREF3962); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1877:1: ruleIMPLREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMPLREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1880:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1881:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1881:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1881:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1881:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_ID) ) {
                    int LA35_1 = input.LA(2);

                    if ( (LA35_1==59) ) {
                        alt35=1;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1881:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF4003); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,59,FOLLOW_59_in_ruleIMPLREF4021); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF4038); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,60,FOLLOW_60_in_ruleIMPLREF4056); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF4071); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1922:1: entryRuleFEATREF returns [String current=null] : iv_ruleFEATREF= ruleFEATREF EOF ;
    public final String entryRuleFEATREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFEATREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1923:2: (iv_ruleFEATREF= ruleFEATREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1924:2: iv_ruleFEATREF= ruleFEATREF EOF
            {
             newCompositeNode(grammarAccess.getFEATREFRule()); 
            pushFollow(FOLLOW_ruleFEATREF_in_entryRuleFEATREF4117);
            iv_ruleFEATREF=ruleFEATREF();

            state._fsp--;

             current =iv_ruleFEATREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFEATREF4128); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1931:1: ruleFEATREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleFEATREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1934:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1935:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1935:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1935:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1935:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    int LA36_1 = input.LA(2);

                    if ( (LA36_1==59) ) {
                        int LA36_2 = input.LA(3);

                        if ( (LA36_2==RULE_ID) ) {
                            int LA36_3 = input.LA(4);

                            if ( (LA36_3==59) ) {
                                alt36=1;
                            }


                        }


                    }


                }


                switch (alt36) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1935:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF4169); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,59,FOLLOW_59_in_ruleFEATREF4187); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFEATREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF4204); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,59,FOLLOW_59_in_ruleFEATREF4222); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getFEATREFAccess().getColonColonKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF4237); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1976:1: entryRuleSUBREF returns [String current=null] : iv_ruleSUBREF= ruleSUBREF EOF ;
    public final String entryRuleSUBREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSUBREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1977:2: (iv_ruleSUBREF= ruleSUBREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1978:2: iv_ruleSUBREF= ruleSUBREF EOF
            {
             newCompositeNode(grammarAccess.getSUBREFRule()); 
            pushFollow(FOLLOW_ruleSUBREF_in_entryRuleSUBREF4283);
            iv_ruleSUBREF=ruleSUBREF();

            state._fsp--;

             current =iv_ruleSUBREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSUBREF4294); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1985:1: ruleSUBREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSUBREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1988:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1989:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1989:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1989:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1989:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    int LA37_1 = input.LA(2);

                    if ( (LA37_1==59) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1989:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF4335); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,59,FOLLOW_59_in_ruleSUBREF4353); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF4370); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,60,FOLLOW_60_in_ruleSUBREF4388); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF4403); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 
                
            kw=(Token)match(input,59,FOLLOW_59_in_ruleSUBREF4421); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 
                
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF4436); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2043:1: entryRuleMODEREF returns [String current=null] : iv_ruleMODEREF= ruleMODEREF EOF ;
    public final String entryRuleMODEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMODEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2044:2: (iv_ruleMODEREF= ruleMODEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2045:2: iv_ruleMODEREF= ruleMODEREF EOF
            {
             newCompositeNode(grammarAccess.getMODEREFRule()); 
            pushFollow(FOLLOW_ruleMODEREF_in_entryRuleMODEREF4482);
            iv_ruleMODEREF=ruleMODEREF();

            state._fsp--;

             current =iv_ruleMODEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMODEREF4493); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2052:1: ruleMODEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleMODEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2055:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2056:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2056:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2056:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? kw= '::' this_ID_6= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2056:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    int LA38_1 = input.LA(2);

                    if ( (LA38_1==59) ) {
                        int LA38_3 = input.LA(3);

                        if ( (LA38_3==RULE_ID) ) {
                            int LA38_4 = input.LA(4);

                            if ( ((LA38_4>=59 && LA38_4<=60)) ) {
                                alt38=1;
                            }


                        }


                    }


                }


                switch (alt38) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2056:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEREF4534); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getMODEREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,59,FOLLOW_59_in_ruleMODEREF4552); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getMODEREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEREF4569); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getMODEREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2076:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==60) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2077:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleMODEREF4588); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMODEREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEREF4603); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getMODEREFAccess().getIDTerminalRuleCall_2_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,59,FOLLOW_59_in_ruleMODEREF4623); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMODEREFAccess().getColonColonKeyword_3()); 
                
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEREF4638); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2110:1: entryRuleINSTANCEREF returns [String current=null] : iv_ruleINSTANCEREF= ruleINSTANCEREF EOF ;
    public final String entryRuleINSTANCEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINSTANCEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2111:2: (iv_ruleINSTANCEREF= ruleINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2112:2: iv_ruleINSTANCEREF= ruleINSTANCEREF EOF
            {
             newCompositeNode(grammarAccess.getINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF4684);
            iv_ruleINSTANCEREF=ruleINSTANCEREF();

            state._fsp--;

             current =iv_ruleINSTANCEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREF4695); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2119:1: ruleINSTANCEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* ) ;
    public final AntlrDatatypeRuleToken ruleINSTANCEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_ID_5=null;
        Token this_LONG_7=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2122:28: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2123:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2123:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2123:6: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF4735); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2130:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==12) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2131:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
            	    {
            	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREF4754); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
            	        
            	    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREF4769); 

            	    		current.merge(this_LONG_2);
            	        
            	     
            	        newLeafNode(this_LONG_2, grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
            	        
            	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREF4787); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2149:3: (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==60) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2150:2: kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )*
            	    {
            	    kw=(Token)match(input,60,FOLLOW_60_in_ruleINSTANCEREF4803); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            	        
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF4818); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2162:1: (kw= '[' this_LONG_7= RULE_LONG kw= ']' )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==12) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2163:2: kw= '[' this_LONG_7= RULE_LONG kw= ']'
            	    	    {
            	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREF4837); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            	    	        
            	    	    this_LONG_7=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREF4852); 

            	    	    		current.merge(this_LONG_7);
            	    	        
            	    	     
            	    	        newLeafNode(this_LONG_7, grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            	    	        
            	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREF4870); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop41;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop42;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2189:1: entryRuleSIMPLEINSTANCEREF returns [String current=null] : iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF ;
    public final String entryRuleSIMPLEINSTANCEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSIMPLEINSTANCEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2190:2: (iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2191:2: iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF
            {
             newCompositeNode(grammarAccess.getSIMPLEINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_entryRuleSIMPLEINSTANCEREF4915);
            iv_ruleSIMPLEINSTANCEREF=ruleSIMPLEINSTANCEREF();

            state._fsp--;

             current =iv_ruleSIMPLEINSTANCEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSIMPLEINSTANCEREF4926); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2198:1: ruleSIMPLEINSTANCEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* ) ;
    public final AntlrDatatypeRuleToken ruleSIMPLEINSTANCEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_ID_5=null;
        Token this_LONG_7=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2201:28: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2202:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2202:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2202:6: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF4966); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2209:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==12) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2210:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
                    {
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleSIMPLEINSTANCEREF4985); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
                        
                    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF5000); 

                    		current.merge(this_LONG_2);
                        
                     
                        newLeafNode(this_LONG_2, grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSIMPLEINSTANCEREF5018); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2228:3: (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==60) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2229:2: kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )?
            	    {
            	    kw=(Token)match(input,60,FOLLOW_60_in_ruleSIMPLEINSTANCEREF5034); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            	        
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF5049); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2241:1: (kw= '[' this_LONG_7= RULE_LONG kw= ']' )?
            	    int alt44=2;
            	    int LA44_0 = input.LA(1);

            	    if ( (LA44_0==12) ) {
            	        alt44=1;
            	    }
            	    switch (alt44) {
            	        case 1 :
            	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2242:2: kw= '[' this_LONG_7= RULE_LONG kw= ']'
            	            {
            	            kw=(Token)match(input,12,FOLLOW_12_in_ruleSIMPLEINSTANCEREF5068); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            	                
            	            this_LONG_7=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF5083); 

            	            		current.merge(this_LONG_7);
            	                
            	             
            	                newLeafNode(this_LONG_7, grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            	                
            	            kw=(Token)match(input,13,FOLLOW_13_in_ruleSIMPLEINSTANCEREF5101); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2268:1: entryRuleINSTANCEREFWITHPARENT returns [String current=null] : iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF ;
    public final String entryRuleINSTANCEREFWITHPARENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINSTANCEREFWITHPARENT = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2269:2: (iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2270:2: iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF
            {
             newCompositeNode(grammarAccess.getINSTANCEREFWITHPARENTRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT5146);
            iv_ruleINSTANCEREFWITHPARENT=ruleINSTANCEREFWITHPARENT();

            state._fsp--;

             current =iv_ruleINSTANCEREFWITHPARENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT5157); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2277:1: ruleINSTANCEREFWITHPARENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) ) ;
    public final AntlrDatatypeRuleToken ruleINSTANCEREFWITHPARENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        Token this_LONG_3=null;
        Token this_ID_6=null;
        Token this_LONG_8=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2280:28: ( (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2281:1: (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2281:1: (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==61) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_ID) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2282:2: kw= 'parent'
                    {
                    kw=(Token)match(input,61,FOLLOW_61_in_ruleINSTANCEREFWITHPARENT5195); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getParentKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2288:6: (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2288:6: (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2288:11: this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )*
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT5217); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_0()); 
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2295:1: (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==12) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2296:2: kw= '[' this_LONG_3= RULE_LONG kw= ']'
                    	    {
                    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREFWITHPARENT5236); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_1_0()); 
                    	        
                    	    this_LONG_3=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT5251); 

                    	    		current.merge(this_LONG_3);
                    	        
                    	     
                    	        newLeafNode(this_LONG_3, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_1_1()); 
                    	        
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREFWITHPARENT5269); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2314:3: (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==60) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2315:2: kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+
                    	    {
                    	    kw=(Token)match(input,60,FOLLOW_60_in_ruleINSTANCEREFWITHPARENT5285); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getFullStopKeyword_1_2_0()); 
                    	        
                    	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT5300); 

                    	    		current.merge(this_ID_6);
                    	        
                    	     
                    	        newLeafNode(this_ID_6, grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_2_1()); 
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2327:1: (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+
                    	    int cnt47=0;
                    	    loop47:
                    	    do {
                    	        int alt47=2;
                    	        int LA47_0 = input.LA(1);

                    	        if ( (LA47_0==12) ) {
                    	            alt47=1;
                    	        }


                    	        switch (alt47) {
                    	    	case 1 :
                    	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2328:2: kw= '[' this_LONG_8= RULE_LONG kw= ']'
                    	    	    {
                    	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREFWITHPARENT5319); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_2_2_0()); 
                    	    	        
                    	    	    this_LONG_8=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT5334); 

                    	    	    		current.merge(this_LONG_8);
                    	    	        
                    	    	     
                    	    	        newLeafNode(this_LONG_8, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_2_2_1()); 
                    	    	        
                    	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREFWITHPARENT5352); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_2_2_2()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt47 >= 1 ) break loop47;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(47, input);
                    	                throw eee;
                    	        }
                    	        cnt47++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2354:1: entryRuleCONNINSTREF returns [String current=null] : iv_ruleCONNINSTREF= ruleCONNINSTREF EOF ;
    public final String entryRuleCONNINSTREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCONNINSTREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2355:2: (iv_ruleCONNINSTREF= ruleCONNINSTREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2356:2: iv_ruleCONNINSTREF= ruleCONNINSTREF EOF
            {
             newCompositeNode(grammarAccess.getCONNINSTREFRule()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF5398);
            iv_ruleCONNINSTREF=ruleCONNINSTREF();

            state._fsp--;

             current =iv_ruleCONNINSTREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONNINSTREF5409); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2363:1: ruleCONNINSTREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG ) ;
    public final AntlrDatatypeRuleToken ruleCONNINSTREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LONG_0=null;
        Token kw=null;
        Token this_LONG_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2366:28: ( ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2367:1: ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2367:1: ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2367:2: (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2367:2: (this_LONG_0= RULE_LONG kw= '.' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_LONG) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==60) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2367:7: this_LONG_0= RULE_LONG kw= '.'
                    {
                    this_LONG_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleCONNINSTREF5450); 

                    		current.merge(this_LONG_0);
                        
                     
                        newLeafNode(this_LONG_0, grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_0_0()); 
                        
                    kw=(Token)match(input,60,FOLLOW_60_in_ruleCONNINSTREF5468); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCONNINSTREFAccess().getFullStopKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleCONNINSTREF5485); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2395:1: entryRuleFLOWELEMENTREF returns [String current=null] : iv_ruleFLOWELEMENTREF= ruleFLOWELEMENTREF EOF ;
    public final String entryRuleFLOWELEMENTREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFLOWELEMENTREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2396:2: (iv_ruleFLOWELEMENTREF= ruleFLOWELEMENTREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2397:2: iv_ruleFLOWELEMENTREF= ruleFLOWELEMENTREF EOF
            {
             newCompositeNode(grammarAccess.getFLOWELEMENTREFRule()); 
            pushFollow(FOLLOW_ruleFLOWELEMENTREF_in_entryRuleFLOWELEMENTREF5531);
            iv_ruleFLOWELEMENTREF=ruleFLOWELEMENTREF();

            state._fsp--;

             current =iv_ruleFLOWELEMENTREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFLOWELEMENTREF5542); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2404:1: ruleFLOWELEMENTREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) ) ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2407:28: ( ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2408:1: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2408:1: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2408:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2408:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )*
            loop52:
            do {
                int alt52=2;
                alt52 = dfa52.predict(input);
                switch (alt52) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2408:7: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFLOWELEMENTREF5583); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFLOWELEMENTREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2415:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )*
            	    loop51:
            	    do {
            	        int alt51=2;
            	        int LA51_0 = input.LA(1);

            	        if ( (LA51_0==12) ) {
            	            alt51=1;
            	        }


            	        switch (alt51) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2416:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
            	    	    {
            	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleFLOWELEMENTREF5602); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getLeftSquareBracketKeyword_0_1_0()); 
            	    	        
            	    	    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF5617); 

            	    	    		current.merge(this_LONG_2);
            	    	        
            	    	     
            	    	        newLeafNode(this_LONG_2, grammarAccess.getFLOWELEMENTREFAccess().getLONGTerminalRuleCall_0_1_1()); 
            	    	        
            	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleFLOWELEMENTREF5635); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getRightSquareBracketKeyword_0_1_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop51;
            	        }
            	    } while (true);

            	    kw=(Token)match(input,60,FOLLOW_60_in_ruleFLOWELEMENTREF5650); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getFullStopKeyword_0_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2440:3: (this_LONG_5= RULE_LONG | (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_LONG) ) {
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
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2440:8: this_LONG_5= RULE_LONG
                    {
                    this_LONG_5=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF5668); 

                    		current.merge(this_LONG_5);
                        
                     
                        newLeafNode(this_LONG_5, grammarAccess.getFLOWELEMENTREFAccess().getLONGTerminalRuleCall_1_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2448:6: (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2448:6: (this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )* )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2448:11: this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )*
                    {
                    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFLOWELEMENTREF5695); 

                    		current.merge(this_ID_6);
                        
                     
                        newLeafNode(this_ID_6, grammarAccess.getFLOWELEMENTREFAccess().getIDTerminalRuleCall_1_1_0()); 
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2455:1: (kw= '[' this_LONG_8= RULE_LONG kw= ']' )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==12) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2456:2: kw= '[' this_LONG_8= RULE_LONG kw= ']'
                    	    {
                    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleFLOWELEMENTREF5714); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getLeftSquareBracketKeyword_1_1_1_0()); 
                    	        
                    	    this_LONG_8=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF5729); 

                    	    		current.merge(this_LONG_8);
                    	        
                    	     
                    	        newLeafNode(this_LONG_8, grammarAccess.getFLOWELEMENTREFAccess().getLONGTerminalRuleCall_1_1_1_1()); 
                    	        
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleFLOWELEMENTREF5747); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getFLOWELEMENTREFAccess().getRightSquareBracketKeyword_1_1_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop53;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2482:1: entryRuleMODEINSTREF returns [String current=null] : iv_ruleMODEINSTREF= ruleMODEINSTREF EOF ;
    public final String entryRuleMODEINSTREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMODEINSTREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2483:2: (iv_ruleMODEINSTREF= ruleMODEINSTREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2484:2: iv_ruleMODEINSTREF= ruleMODEINSTREF EOF
            {
             newCompositeNode(grammarAccess.getMODEINSTREFRule()); 
            pushFollow(FOLLOW_ruleMODEINSTREF_in_entryRuleMODEINSTREF5792);
            iv_ruleMODEINSTREF=ruleMODEINSTREF();

            state._fsp--;

             current =iv_ruleMODEINSTREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMODEINSTREF5803); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2491:1: ruleMODEINSTREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleMODEINSTREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2494:28: ( ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2495:1: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2495:1: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2495:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )* this_ID_5= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2495:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_ID) ) {
                    int LA56_1 = input.LA(2);

                    if ( (LA56_1==12||LA56_1==60) ) {
                        alt56=1;
                    }


                }


                switch (alt56) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2495:7: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEINSTREF5844); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getMODEINSTREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2502:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )*
            	    loop55:
            	    do {
            	        int alt55=2;
            	        int LA55_0 = input.LA(1);

            	        if ( (LA55_0==12) ) {
            	            alt55=1;
            	        }


            	        switch (alt55) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:2503:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
            	    	    {
            	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleMODEINSTREF5863); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getMODEINSTREFAccess().getLeftSquareBracketKeyword_0_1_0()); 
            	    	        
            	    	    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleMODEINSTREF5878); 

            	    	    		current.merge(this_LONG_2);
            	    	        
            	    	     
            	    	        newLeafNode(this_LONG_2, grammarAccess.getMODEINSTREFAccess().getLONGTerminalRuleCall_0_1_1()); 
            	    	        
            	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleMODEINSTREF5896); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getMODEINSTREFAccess().getRightSquareBracketKeyword_0_1_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop55;
            	        }
            	    } while (true);

            	    kw=(Token)match(input,60,FOLLOW_60_in_ruleMODEINSTREF5911); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getMODEINSTREFAccess().getFullStopKeyword_0_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);

            this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMODEINSTREF5928); 

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

    // Delegated rules


    protected DFA33 dfa33 = new DFA33(this);
    protected DFA52 dfa52 = new DFA52(this);
    static final String DFA33_eotS =
        "\22\uffff";
    static final String DFA33_eofS =
        "\10\uffff\1\14\1\uffff\1\17\7\uffff";
    static final String DFA33_minS =
        "\1\51\7\uffff\1\4\1\uffff\1\4\1\52\6\uffff";
    static final String DFA33_maxS =
        "\1\64\7\uffff\1\61\1\uffff\1\61\1\57\6\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\13\1\14\1\15\1\16";
    static final String DFA33_specialS =
        "\22\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\54\uffff\1\15",
            "",
            "\1\17\54\uffff\1\16",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "1677:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String DFA52_eotS =
        "\7\uffff";
    static final String DFA52_eofS =
        "\2\uffff\1\1\3\uffff\1\1";
    static final String DFA52_minS =
        "\1\4\1\uffff\1\11\1\5\1\uffff\1\15\1\11";
    static final String DFA52_maxS =
        "\1\5\1\uffff\1\74\1\5\1\uffff\1\15\1\74";
    static final String DFA52_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA52_specialS =
        "\7\uffff}>";
    static final String[] DFA52_transitionS = {
            "\1\2\1\1",
            "",
            "\1\1\2\uffff\1\3\11\uffff\1\1\45\uffff\1\4",
            "\1\5",
            "",
            "\1\6",
            "\1\1\2\uffff\1\3\11\uffff\1\1\45\uffff\1\4"
    };

    static final short[] DFA52_eot = DFA.unpackEncodedString(DFA52_eotS);
    static final short[] DFA52_eof = DFA.unpackEncodedString(DFA52_eofS);
    static final char[] DFA52_min = DFA.unpackEncodedStringToUnsignedChars(DFA52_minS);
    static final char[] DFA52_max = DFA.unpackEncodedStringToUnsignedChars(DFA52_maxS);
    static final short[] DFA52_accept = DFA.unpackEncodedString(DFA52_acceptS);
    static final short[] DFA52_special = DFA.unpackEncodedString(DFA52_specialS);
    static final short[][] DFA52_transition;

    static {
        int numStates = DFA52_transitionS.length;
        DFA52_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA52_transition[i] = DFA.unpackEncodedString(DFA52_transitionS[i]);
        }
    }

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = DFA52_eot;
            this.eof = DFA52_eof;
            this.min = DFA52_min;
            this.max = DFA52_max;
            this.accept = DFA52_accept;
            this.special = DFA52_special;
            this.transition = DFA52_transition;
        }
        public String getDescription() {
            return "()* loopback of 2408:2: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* kw= '.' )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleSystemInstance131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemInstance148 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleSystemInstance165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_ruleSystemInstance188 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleSystemInstance200 = new BitSet(new long[]{0x07FDFE00FB900800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleSystemInstance222 = new BitSet(new long[]{0x07FDFE00FB900800L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleSystemInstance249 = new BitSet(new long[]{0x07FDFE00FB900800L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleSystemInstance276 = new BitSet(new long[]{0x07FDFE00FB900800L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleSystemInstance303 = new BitSet(new long[]{0x07FDFE00FB900800L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleSystemInstance330 = new BitSet(new long[]{0x07FDFE00FB900800L});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleSystemInstance357 = new BitSet(new long[]{0x07FDFE00FB900800L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance384 = new BitSet(new long[]{0x07FDFE00FB900800L});
    public static final BitSet FOLLOW_11_in_ruleSystemInstance398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_ruleFeatureInstance490 = new BitSet(new long[]{0x000001FF00000000L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance511 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance528 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleFeatureInstance546 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFeatureInstance563 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFeatureInstance580 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFeatureInstance594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFEATREF_in_ruleFeatureInstance617 = new BitSet(new long[]{0x0000000000084402L});
    public static final BitSet FOLLOW_14_in_ruleFeatureInstance630 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureInstance642 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFeatureInstance654 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance678 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance704 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFeatureInstance718 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance742 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance768 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureInstance783 = new BitSet(new long[]{0x0000000000080402L});
    public static final BitSet FOLLOW_19_in_ruleFeatureInstance798 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureInstance810 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFeatureInstance822 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance846 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance872 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFeatureInstance886 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance910 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance936 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureInstance951 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_ruleFeatureInstance966 = new BitSet(new long[]{0x0000000080800800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance987 = new BitSet(new long[]{0x0000000080800800L});
    public static final BitSet FOLLOW_11_in_ruleFeatureInstance1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance1038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance1048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleComponentInstance1094 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance1111 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleComponentInstance1129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleComponentInstance1146 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleComponentInstance1163 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_9_in_ruleComponentInstance1177 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleComponentInstance1200 = new BitSet(new long[]{0x0000000000084402L});
    public static final BitSet FOLLOW_14_in_ruleComponentInstance1213 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance1225 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1237 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1260 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1273 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1296 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance1310 = new BitSet(new long[]{0x0000000000080402L});
    public static final BitSet FOLLOW_19_in_ruleComponentInstance1325 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance1337 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1349 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1372 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1385 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1408 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance1422 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_ruleComponentInstance1437 = new BitSet(new long[]{0x07FDFE00BB900800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1459 = new BitSet(new long[]{0x07FDFE00BB900800L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleComponentInstance1486 = new BitSet(new long[]{0x07FDFE00BB900800L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1513 = new BitSet(new long[]{0x07FDFE00BB900800L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1540 = new BitSet(new long[]{0x07FDFE00BB900800L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance1567 = new BitSet(new long[]{0x07FDFE00BB900800L});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleComponentInstance1594 = new BitSet(new long[]{0x07FDFE00BB900800L});
    public static final BitSet FOLLOW_11_in_ruleComponentInstance1608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleConnectionInstance1699 = new BitSet(new long[]{0x07E0000000100000L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1734 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConnectionInstance1751 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleConnectionInstance1768 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1791 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleConnectionInstance1810 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance1841 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1865 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleConnectionInstance1877 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_ruleConnectionInstance1898 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_ruleConnectionInstance1911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference1947 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference1957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2005 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionReference2017 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2040 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleConnectionReference2052 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleConnectionReference2075 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleConnectionReference2087 = new BitSet(new long[]{0x2000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_ruleConnectionReference2110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2193 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2210 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFlowSpecificationInstance2227 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2250 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecificationInstance2263 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2286 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFlowSpecificationInstance2299 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFlowSpecificationInstance2311 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFEATREF_in_ruleFlowSpecificationInstance2334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance2370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndToEndFlowInstance2380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleEndToEndFlowInstance2417 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleEndToEndFlowInstance2429 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEndToEndFlowInstance2441 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleEndToEndFlowInstance2453 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance2470 = new BitSet(new long[]{0x0000000000000230L});
    public static final BitSet FOLLOW_ruleFLOWELEMENTREF_in_ruleEndToEndFlowInstance2499 = new BitSet(new long[]{0x0000000000400200L});
    public static final BitSet FOLLOW_22_in_ruleEndToEndFlowInstance2512 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleFLOWELEMENTREF_in_ruleEndToEndFlowInstance2535 = new BitSet(new long[]{0x0000000000400200L});
    public static final BitSet FOLLOW_9_in_ruleEndToEndFlowInstance2551 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleEndToEndFlowInstance2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_entryRuleModeInstance2610 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeInstance2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleModeInstance2663 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_28_in_ruleModeInstance2695 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleModeInstance2721 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance2738 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleModeInstance2755 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMODEREF_in_ruleModeInstance2778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode2814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode2824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleSystemOperationMode2861 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSystemOperationMode2878 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleMODEINSTREF_in_ruleSystemOperationMode2907 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleSystemOperationMode2920 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMODEINSTREF_in_ruleSystemOperationMode2943 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType2984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType2995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDirectionType3033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleDirectionType3052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDirectionType3072 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleDirectionType3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory3127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory3138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleFeatureCategory3176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleFeatureCategory3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleFeatureCategory3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleFeatureCategory3233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleFeatureCategory3252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleFeatureCategory3271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleFeatureCategory3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleFeatureCategory3309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleFeatureCategory3328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory3369 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory3380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleComponentCategory3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleComponentCategory3437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleComponentCategory3456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleComponentCategory3475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleComponentCategory3494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleComponentCategory3513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleComponentCategory3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleComponentCategory3551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleComponentCategory3571 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleComponentCategory3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleComponentCategory3604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleComponentCategory3624 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleComponentCategory3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleComponentCategory3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleComponentCategory3677 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleComponentCategory3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleComponentCategory3711 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleComponentCategory3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind3766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind3777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleConnectionKind3815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleConnectionKind3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleConnectionKind3853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleConnectionKind3872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleConnectionKind3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleConnectionKind3910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF3951 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMPLREF3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF4003 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleIMPLREF4021 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF4038 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleIMPLREF4056 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF4071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_entryRuleFEATREF4117 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFEATREF4128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF4169 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleFEATREF4187 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF4204 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleFEATREF4222 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF4237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_entryRuleSUBREF4283 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSUBREF4294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF4335 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleSUBREF4353 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF4370 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleSUBREF4388 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF4403 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleSUBREF4421 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMODEREF_in_entryRuleMODEREF4482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMODEREF4493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEREF4534 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleMODEREF4552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEREF4569 = new BitSet(new long[]{0x1800000000000000L});
    public static final BitSet FOLLOW_60_in_ruleMODEREF4588 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEREF4603 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleMODEREF4623 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEREF4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF4684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREF4695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF4735 = new BitSet(new long[]{0x1000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREF4754 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREF4769 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREF4787 = new BitSet(new long[]{0x1000000000001002L});
    public static final BitSet FOLLOW_60_in_ruleINSTANCEREF4803 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF4818 = new BitSet(new long[]{0x1000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREF4837 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREF4852 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREF4870 = new BitSet(new long[]{0x1000000000001002L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_entryRuleSIMPLEINSTANCEREF4915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSIMPLEINSTANCEREF4926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF4966 = new BitSet(new long[]{0x1000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSIMPLEINSTANCEREF4985 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF5000 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSIMPLEINSTANCEREF5018 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleSIMPLEINSTANCEREF5034 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF5049 = new BitSet(new long[]{0x1000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSIMPLEINSTANCEREF5068 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF5083 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSIMPLEINSTANCEREF5101 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT5146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT5157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleINSTANCEREFWITHPARENT5195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT5217 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREFWITHPARENT5236 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT5251 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREFWITHPARENT5269 = new BitSet(new long[]{0x1000000000001002L});
    public static final BitSet FOLLOW_60_in_ruleINSTANCEREFWITHPARENT5285 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT5300 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREFWITHPARENT5319 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT5334 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREFWITHPARENT5352 = new BitSet(new long[]{0x1000000000001002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF5398 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONNINSTREF5409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleCONNINSTREF5450 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleCONNINSTREF5468 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleCONNINSTREF5485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFLOWELEMENTREF_in_entryRuleFLOWELEMENTREF5531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFLOWELEMENTREF5542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFLOWELEMENTREF5583 = new BitSet(new long[]{0x1000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFLOWELEMENTREF5602 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF5617 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFLOWELEMENTREF5635 = new BitSet(new long[]{0x1000000000001000L});
    public static final BitSet FOLLOW_60_in_ruleFLOWELEMENTREF5650 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF5668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFLOWELEMENTREF5695 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleFLOWELEMENTREF5714 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFLOWELEMENTREF5729 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFLOWELEMENTREF5747 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_ruleMODEINSTREF_in_entryRuleMODEINSTREF5792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMODEINSTREF5803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEINSTREF5844 = new BitSet(new long[]{0x1000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleMODEINSTREF5863 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleMODEINSTREF5878 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleMODEINSTREF5896 = new BitSet(new long[]{0x1000000000001000L});
    public static final BitSet FOLLOW_60_in_ruleMODEINSTREF5911 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMODEINSTREF5928 = new BitSet(new long[]{0x0000000000000002L});

}