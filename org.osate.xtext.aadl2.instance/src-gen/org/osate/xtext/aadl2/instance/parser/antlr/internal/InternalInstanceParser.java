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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_LONG", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "':'", "'{'", "'}'", "'['", "']'", "'source'", "'of'", "'('", "','", "')'", "'destination'", "'complete'", "'<->'", "'->'", "'in'", "'flow'", "'som'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'featureConnection'", "'accessConnection'", "'parameterConnection'", "'portConnection'", "'modeTransitionConnection'", "'featureGroupConnection'", "'::'", "'.'", "'parent'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__10=10;
    public static final int T__54=54;
    public static final int T__9=9;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:76:1: ruleSystemInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_systemOperationMode_9_0= ruleSystemOperationMode ) ) )* otherlv_10= '}' ) ;
    public final EObject ruleSystemInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_5_0 = null;

        EObject lv_componentInstance_6_0 = null;

        EObject lv_connectionInstance_7_0 = null;

        EObject lv_flowSpecification_8_0 = null;

        EObject lv_systemOperationMode_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:79:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_systemOperationMode_9_0= ruleSystemOperationMode ) ) )* otherlv_10= '}' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_systemOperationMode_9_0= ruleSystemOperationMode ) ) )* otherlv_10= '}' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_systemOperationMode_9_0= ruleSystemOperationMode ) ) )* otherlv_10= '}' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_systemOperationMode_9_0= ruleSystemOperationMode ) ) )* otherlv_10= '}'
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
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:139:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_7_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_8_0= ruleFlowSpecificationInstance ) ) | ( (lv_systemOperationMode_9_0= ruleSystemOperationMode ) ) )*
            loop1:
            do {
                int alt1=6;
                switch ( input.LA(1) ) {
                case 23:
                case 26:
                    {
                    alt1=1;
                    }
                    break;
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 45:
                case 46:
                case 47:
                    {
                    alt1=2;
                    }
                    break;
                case 20:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:215:6: ( (lv_systemOperationMode_9_0= ruleSystemOperationMode ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:215:6: ( (lv_systemOperationMode_9_0= ruleSystemOperationMode ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:216:1: (lv_systemOperationMode_9_0= ruleSystemOperationMode )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:216:1: (lv_systemOperationMode_9_0= ruleSystemOperationMode )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:217:3: lv_systemOperationMode_9_0= ruleSystemOperationMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance330);
            	    lv_systemOperationMode_9_0=ruleSystemOperationMode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systemOperationMode",
            	            		lv_systemOperationMode_9_0, 
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

            otherlv_10=(Token)match(input,11,FOLLOW_11_in_ruleSystemInstance344); 

                	newLeafNode(otherlv_10, grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:245:1: entryRuleFeatureInstance returns [EObject current=null] : iv_ruleFeatureInstance= ruleFeatureInstance EOF ;
    public final EObject entryRuleFeatureInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:246:2: (iv_ruleFeatureInstance= ruleFeatureInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:247:2: iv_ruleFeatureInstance= ruleFeatureInstance EOF
            {
             newCompositeNode(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance380);
            iv_ruleFeatureInstance=ruleFeatureInstance();

            state._fsp--;

             current =iv_ruleFeatureInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance390); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:254:1: ruleFeatureInstance returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:257:28: ( ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:258:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:258:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:258:2: ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )? (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )? (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:258:2: ( (lv_direction_0_0= ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:259:1: (lv_direction_0_0= ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:259:1: (lv_direction_0_0= ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:260:3: lv_direction_0_0= ruleDirectionType
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDirectionType_in_ruleFeatureInstance436);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:276:2: ( (lv_category_1_0= ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:277:1: (lv_category_1_0= ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:277:1: (lv_category_1_0= ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:278:3: lv_category_1_0= ruleFeatureCategory
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance457);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:294:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:295:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:295:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:296:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance474); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:312:2: (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:312:4: otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleFeatureInstance492); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:316:1: ( (lv_index_4_0= RULE_LONG ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:317:1: (lv_index_4_0= RULE_LONG )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:317:1: (lv_index_4_0= RULE_LONG )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:318:3: lv_index_4_0= RULE_LONG
                    {
                    lv_index_4_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFeatureInstance509); 

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

                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleFeatureInstance526); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,9,FOLLOW_9_in_ruleFeatureInstance540); 

                	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:342:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:343:1: ( ruleFEATREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:343:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:344:3: ruleFEATREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFEATREF_in_ruleFeatureInstance563);
            ruleFEATREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:357:2: (otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:357:4: otherlv_8= 'source' otherlv_9= 'of' otherlv_10= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) ) (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )* otherlv_16= ')'
                    {
                    otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleFeatureInstance576); 

                        	newLeafNode(otherlv_8, grammarAccess.getFeatureInstanceAccess().getSourceKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleFeatureInstance588); 

                        	newLeafNode(otherlv_9, grammarAccess.getFeatureInstanceAccess().getOfKeyword_6_1());
                        
                    otherlv_10=(Token)match(input,16,FOLLOW_16_in_ruleFeatureInstance600); 

                        	newLeafNode(otherlv_10, grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:369:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_12= RULE_ID ) ) )
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
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:369:2: ( ( ruleCONNINSTREF ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:369:2: ( ( ruleCONNINSTREF ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:370:1: ( ruleCONNINSTREF )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:370:1: ( ruleCONNINSTREF )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:371:3: ruleCONNINSTREF
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance624);
                            ruleCONNINSTREF();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:385:6: ( (otherlv_12= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:385:6: ( (otherlv_12= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:386:1: (otherlv_12= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:386:1: (otherlv_12= RULE_ID )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:387:3: otherlv_12= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                            otherlv_12=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance650); 

                            		newLeafNode(otherlv_12, grammarAccess.getFeatureInstanceAccess().getSrcFlowSpecFlowSpecificationInstanceCrossReference_6_3_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:398:3: (otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==17) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:398:5: otherlv_13= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) )
                    	    {
                    	    otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleFeatureInstance664); 

                    	        	newLeafNode(otherlv_13, grammarAccess.getFeatureInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:402:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_15= RULE_ID ) ) )
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
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:402:2: ( ( ruleCONNINSTREF ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:402:2: ( ( ruleCONNINSTREF ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:403:1: ( ruleCONNINSTREF )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:403:1: ( ruleCONNINSTREF )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:404:3: ruleCONNINSTREF
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_6_4_1_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance688);
                    	            ruleCONNINSTREF();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:418:6: ( (otherlv_15= RULE_ID ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:418:6: ( (otherlv_15= RULE_ID ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:419:1: (otherlv_15= RULE_ID )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:419:1: (otherlv_15= RULE_ID )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:420:3: otherlv_15= RULE_ID
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	            otherlv_15=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance714); 

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

                    otherlv_16=(Token)match(input,18,FOLLOW_18_in_ruleFeatureInstance729); 

                        	newLeafNode(otherlv_16, grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:435:3: (otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:435:5: otherlv_17= 'destination' otherlv_18= 'of' otherlv_19= '(' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) ) (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )* otherlv_25= ')'
                    {
                    otherlv_17=(Token)match(input,19,FOLLOW_19_in_ruleFeatureInstance744); 

                        	newLeafNode(otherlv_17, grammarAccess.getFeatureInstanceAccess().getDestinationKeyword_7_0());
                        
                    otherlv_18=(Token)match(input,15,FOLLOW_15_in_ruleFeatureInstance756); 

                        	newLeafNode(otherlv_18, grammarAccess.getFeatureInstanceAccess().getOfKeyword_7_1());
                        
                    otherlv_19=(Token)match(input,16,FOLLOW_16_in_ruleFeatureInstance768); 

                        	newLeafNode(otherlv_19, grammarAccess.getFeatureInstanceAccess().getLeftParenthesisKeyword_7_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:447:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_21= RULE_ID ) ) )
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
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:447:2: ( ( ruleCONNINSTREF ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:447:2: ( ( ruleCONNINSTREF ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:448:1: ( ruleCONNINSTREF )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:448:1: ( ruleCONNINSTREF )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:449:3: ruleCONNINSTREF
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_3_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance792);
                            ruleCONNINSTREF();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:463:6: ( (otherlv_21= RULE_ID ) )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:463:6: ( (otherlv_21= RULE_ID ) )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:464:1: (otherlv_21= RULE_ID )
                            {
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:464:1: (otherlv_21= RULE_ID )
                            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:465:3: otherlv_21= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                            	        }
                                    
                            otherlv_21=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance818); 

                            		newLeafNode(otherlv_21, grammarAccess.getFeatureInstanceAccess().getDstFlowSpecFlowSpecificationInstanceCrossReference_7_3_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:476:3: (otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==17) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:476:5: otherlv_22= ',' ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) )
                    	    {
                    	    otherlv_22=(Token)match(input,17,FOLLOW_17_in_ruleFeatureInstance832); 

                    	        	newLeafNode(otherlv_22, grammarAccess.getFeatureInstanceAccess().getCommaKeyword_7_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:480:1: ( ( ( ruleCONNINSTREF ) ) | ( (otherlv_24= RULE_ID ) ) )
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
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:480:2: ( ( ruleCONNINSTREF ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:480:2: ( ( ruleCONNINSTREF ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:481:1: ( ruleCONNINSTREF )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:481:1: ( ruleCONNINSTREF )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:482:3: ruleCONNINSTREF
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_7_4_1_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance856);
                    	            ruleCONNINSTREF();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:496:6: ( (otherlv_24= RULE_ID ) )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:496:6: ( (otherlv_24= RULE_ID ) )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:497:1: (otherlv_24= RULE_ID )
                    	            {
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:497:1: (otherlv_24= RULE_ID )
                    	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:498:3: otherlv_24= RULE_ID
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
                    	            	        }
                    	                    
                    	            otherlv_24=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance882); 

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

                    otherlv_25=(Token)match(input,18,FOLLOW_18_in_ruleFeatureInstance897); 

                        	newLeafNode(otherlv_25, grammarAccess.getFeatureInstanceAccess().getRightParenthesisKeyword_7_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:513:3: (otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==10) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:513:5: otherlv_26= '{' ( (lv_featureInstance_27_0= ruleFeatureInstance ) )* otherlv_28= '}'
                    {
                    otherlv_26=(Token)match(input,10,FOLLOW_10_in_ruleFeatureInstance912); 

                        	newLeafNode(otherlv_26, grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_8_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:517:1: ( (lv_featureInstance_27_0= ruleFeatureInstance ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==23||LA11_0==26) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:518:1: (lv_featureInstance_27_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:518:1: (lv_featureInstance_27_0= ruleFeatureInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:519:3: lv_featureInstance_27_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_8_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance933);
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

                    otherlv_28=(Token)match(input,11,FOLLOW_11_in_ruleFeatureInstance946); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:547:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:548:2: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:549:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance984);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance994); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:556:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) )* otherlv_26= '}' )? ) ;
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
        Token otherlv_26=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_22_0 = null;

        EObject lv_componentInstance_23_0 = null;

        EObject lv_connectionInstance_24_0 = null;

        EObject lv_flowSpecification_25_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:559:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) )* otherlv_26= '}' )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:560:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) )* otherlv_26= '}' )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:560:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) )* otherlv_26= '}' )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:560:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )? (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )? (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) )* otherlv_26= '}' )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:560:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:561:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:561:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:562:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleComponentInstance1040);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:578:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:579:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:579:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:580:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance1057); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:596:2: (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==12) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:596:4: otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']'
            	    {
            	    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleComponentInstance1075); 

            	        	newLeafNode(otherlv_2, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0());
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:600:1: ( (lv_index_3_0= RULE_LONG ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:601:1: (lv_index_3_0= RULE_LONG )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:601:1: (lv_index_3_0= RULE_LONG )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:602:3: lv_index_3_0= RULE_LONG
            	    {
            	    lv_index_3_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleComponentInstance1092); 

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

            	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleComponentInstance1109); 

            	        	newLeafNode(otherlv_4, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_5=(Token)match(input,9,FOLLOW_9_in_ruleComponentInstance1123); 

                	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:626:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:627:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:627:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:628:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleComponentInstance1146);
            ruleSUBREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:641:2: (otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:641:4: otherlv_7= 'source' otherlv_8= 'of' otherlv_9= '(' ( ( ruleCONNINSTREF ) ) (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_13= ')'
                    {
                    otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleComponentInstance1159); 

                        	newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getSourceKeyword_5_0());
                        
                    otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance1171); 

                        	newLeafNode(otherlv_8, grammarAccess.getComponentInstanceAccess().getOfKeyword_5_1());
                        
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1183); 

                        	newLeafNode(otherlv_9, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_5_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:653:1: ( ( ruleCONNINSTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:654:1: ( ruleCONNINSTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:654:1: ( ruleCONNINSTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:655:3: ruleCONNINSTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1206);
                    ruleCONNINSTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:668:2: (otherlv_11= ',' ( ( ruleCONNINSTREF ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==17) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:668:4: otherlv_11= ',' ( ( ruleCONNINSTREF ) )
                    	    {
                    	    otherlv_11=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1219); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getComponentInstanceAccess().getCommaKeyword_5_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:672:1: ( ( ruleCONNINSTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:673:1: ( ruleCONNINSTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:673:1: ( ruleCONNINSTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:674:3: ruleCONNINSTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSrcConnectionInstanceConnectionInstanceCrossReference_5_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1242);
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

                    otherlv_13=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance1256); 

                        	newLeafNode(otherlv_13, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_5_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:691:3: (otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==19) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:691:5: otherlv_14= 'destination' otherlv_15= 'of' otherlv_16= '(' ( ( ruleCONNINSTREF ) ) (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )* otherlv_20= ')'
                    {
                    otherlv_14=(Token)match(input,19,FOLLOW_19_in_ruleComponentInstance1271); 

                        	newLeafNode(otherlv_14, grammarAccess.getComponentInstanceAccess().getDestinationKeyword_6_0());
                        
                    otherlv_15=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance1283); 

                        	newLeafNode(otherlv_15, grammarAccess.getComponentInstanceAccess().getOfKeyword_6_1());
                        
                    otherlv_16=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance1295); 

                        	newLeafNode(otherlv_16, grammarAccess.getComponentInstanceAccess().getLeftParenthesisKeyword_6_2());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:703:1: ( ( ruleCONNINSTREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:704:1: ( ruleCONNINSTREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:704:1: ( ruleCONNINSTREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:705:3: ruleCONNINSTREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1318);
                    ruleCONNINSTREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:718:2: (otherlv_18= ',' ( ( ruleCONNINSTREF ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==17) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:718:4: otherlv_18= ',' ( ( ruleCONNINSTREF ) )
                    	    {
                    	    otherlv_18=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance1331); 

                    	        	newLeafNode(otherlv_18, grammarAccess.getComponentInstanceAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:722:1: ( ( ruleCONNINSTREF ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:723:1: ( ruleCONNINSTREF )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:723:1: ( ruleCONNINSTREF )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:724:3: ruleCONNINSTREF
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getDstConnectionInstanceConnectionInstanceCrossReference_6_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1354);
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

                    otherlv_20=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance1368); 

                        	newLeafNode(otherlv_20, grammarAccess.getComponentInstanceAccess().getRightParenthesisKeyword_6_5());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:741:3: (otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) )* otherlv_26= '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==10) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:741:5: otherlv_21= '{' ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) )* otherlv_26= '}'
                    {
                    otherlv_21=(Token)match(input,10,FOLLOW_10_in_ruleComponentInstance1383); 

                        	newLeafNode(otherlv_21, grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_7_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:745:1: ( ( (lv_featureInstance_22_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_23_0= ruleComponentInstance ) ) | ( (lv_connectionInstance_24_0= ruleConnectionInstance ) ) | ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) ) )*
                    loop18:
                    do {
                        int alt18=5;
                        switch ( input.LA(1) ) {
                        case 23:
                        case 26:
                            {
                            alt18=1;
                            }
                            break;
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 45:
                        case 46:
                        case 47:
                            {
                            alt18=2;
                            }
                            break;
                        case 20:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                            {
                            alt18=3;
                            }
                            break;
                        case 24:
                            {
                            alt18=4;
                            }
                            break;

                        }

                        switch (alt18) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:745:2: ( (lv_featureInstance_22_0= ruleFeatureInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:745:2: ( (lv_featureInstance_22_0= ruleFeatureInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:746:1: (lv_featureInstance_22_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:746:1: (lv_featureInstance_22_0= ruleFeatureInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:747:3: lv_featureInstance_22_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1405);
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
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:764:6: ( (lv_componentInstance_23_0= ruleComponentInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:764:6: ( (lv_componentInstance_23_0= ruleComponentInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:765:1: (lv_componentInstance_23_0= ruleComponentInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:765:1: (lv_componentInstance_23_0= ruleComponentInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:766:3: lv_componentInstance_23_0= ruleComponentInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleComponentInstance1432);
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
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:783:6: ( (lv_connectionInstance_24_0= ruleConnectionInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:783:6: ( (lv_connectionInstance_24_0= ruleConnectionInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:784:1: (lv_connectionInstance_24_0= ruleConnectionInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:784:1: (lv_connectionInstance_24_0= ruleConnectionInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:785:3: lv_connectionInstance_24_0= ruleConnectionInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_7_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1459);
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
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:802:6: ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:802:6: ( (lv_flowSpecification_25_0= ruleFlowSpecificationInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:803:1: (lv_flowSpecification_25_0= ruleFlowSpecificationInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:803:1: (lv_flowSpecification_25_0= ruleFlowSpecificationInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:804:3: lv_flowSpecification_25_0= ruleFlowSpecificationInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecificationInstanceParserRuleCall_7_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1486);
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

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    otherlv_26=(Token)match(input,11,FOLLOW_11_in_ruleComponentInstance1500); 

                        	newLeafNode(otherlv_26, grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_7_2());
                        

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:832:1: entryRuleConnectionInstance returns [EObject current=null] : iv_ruleConnectionInstance= ruleConnectionInstance EOF ;
    public final EObject entryRuleConnectionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:833:2: (iv_ruleConnectionInstance= ruleConnectionInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:834:2: iv_ruleConnectionInstance= ruleConnectionInstance EOF
            {
             newCompositeNode(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1538);
            iv_ruleConnectionInstance=ruleConnectionInstance();

            state._fsp--;

             current =iv_ruleConnectionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance1548); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:841:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}' ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:844:28: ( ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:845:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:845:1: ( ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:845:2: ( (lv_complete_0_0= 'complete' ) )? ( (lv_kind_1_0= ruleConnectionKind ) ) ( (lv_name_2_0= RULE_STRING ) ) otherlv_3= ':' ( ( ruleINSTANCEREF ) ) ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' ) ( ( ruleINSTANCEREF ) ) otherlv_8= '{' ( (lv_connectionReference_9_0= ruleConnectionReference ) )+ otherlv_10= '}'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:845:2: ( (lv_complete_0_0= 'complete' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==20) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:846:1: (lv_complete_0_0= 'complete' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:846:1: (lv_complete_0_0= 'complete' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:847:3: lv_complete_0_0= 'complete'
                    {
                    lv_complete_0_0=(Token)match(input,20,FOLLOW_20_in_ruleConnectionInstance1591); 

                            newLeafNode(lv_complete_0_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "complete", true, "complete");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:860:3: ( (lv_kind_1_0= ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:861:1: (lv_kind_1_0= ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:861:1: (lv_kind_1_0= ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:862:3: lv_kind_1_0= ruleConnectionKind
            {
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1626);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:878:2: ( (lv_name_2_0= RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:879:1: (lv_name_2_0= RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:879:1: (lv_name_2_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:880:3: lv_name_2_0= RULE_STRING
            {
            lv_name_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleConnectionInstance1643); 

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

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleConnectionInstance1660); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:900:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:901:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:901:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:902:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1683);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:915:2: ( ( (lv_bidirectional_5_0= '<->' ) ) | otherlv_6= '->' )
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
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:915:3: ( (lv_bidirectional_5_0= '<->' ) )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:915:3: ( (lv_bidirectional_5_0= '<->' ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:916:1: (lv_bidirectional_5_0= '<->' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:916:1: (lv_bidirectional_5_0= '<->' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:917:3: lv_bidirectional_5_0= '<->'
                    {
                    lv_bidirectional_5_0=(Token)match(input,21,FOLLOW_21_in_ruleConnectionInstance1702); 

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
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:931:7: otherlv_6= '->'
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance1733); 

                        	newLeafNode(otherlv_6, grammarAccess.getConnectionInstanceAccess().getHyphenMinusGreaterThanSignKeyword_5_1());
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:935:2: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:936:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:936:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:937:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1757);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,10,FOLLOW_10_in_ruleConnectionInstance1769); 

                	newLeafNode(otherlv_8, grammarAccess.getConnectionInstanceAccess().getLeftCurlyBracketKeyword_7());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:954:1: ( (lv_connectionReference_9_0= ruleConnectionReference ) )+
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:955:1: (lv_connectionReference_9_0= ruleConnectionReference )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:955:1: (lv_connectionReference_9_0= ruleConnectionReference )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:956:3: lv_connectionReference_9_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionReference_in_ruleConnectionInstance1790);
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

            otherlv_10=(Token)match(input,11,FOLLOW_11_in_ruleConnectionInstance1803); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:984:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:985:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:986:2: iv_ruleConnectionReference= ruleConnectionReference EOF
            {
             newCompositeNode(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference1839);
            iv_ruleConnectionReference=ruleConnectionReference();

            state._fsp--;

             current =iv_ruleConnectionReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference1849); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:993:1: ruleConnectionReference returns [EObject current=null] : ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:996:28: ( ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:997:1: ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:997:1: ( ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:997:2: ( ( ruleINSTANCEREF ) ) otherlv_1= '->' ( ( ruleINSTANCEREF ) ) otherlv_3= ':' ( ( ruleSUBREF ) ) otherlv_5= 'in' ( ( ruleINSTANCEREFWITHPARENT ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:997:2: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:998:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:998:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:999:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference1897);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleConnectionReference1909); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getHyphenMinusGreaterThanSignKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1016:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1017:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1017:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1018:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference1932);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleConnectionReference1944); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionReferenceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1035:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1036:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1036:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1037:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleConnectionReference1967);
            ruleSUBREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleConnectionReference1979); 

                	newLeafNode(otherlv_5, grammarAccess.getConnectionReferenceAccess().getInKeyword_5());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1054:1: ( ( ruleINSTANCEREFWITHPARENT ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1055:1: ( ruleINSTANCEREFWITHPARENT )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1055:1: ( ruleINSTANCEREFWITHPARENT )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1056:3: ruleINSTANCEREFWITHPARENT
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_ruleConnectionReference2002);
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1077:1: entryRuleFlowSpecificationInstance returns [EObject current=null] : iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF ;
    public final EObject entryRuleFlowSpecificationInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecificationInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1078:2: (iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1079:2: iv_ruleFlowSpecificationInstance= ruleFlowSpecificationInstance EOF
            {
             newCompositeNode(grammarAccess.getFlowSpecificationInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2038);
            iv_ruleFlowSpecificationInstance=ruleFlowSpecificationInstance();

            state._fsp--;

             current =iv_ruleFlowSpecificationInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2048); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1086:1: ruleFlowSpecificationInstance returns [EObject current=null] : (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) ) ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1089:28: ( (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1090:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1090:1: (otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1090:3: otherlv_0= 'flow' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_4= '->' ( ( ruleSIMPLEINSTANCEREF ) )? otherlv_6= ')' otherlv_7= ':' ( ( ruleFEATREF ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleFlowSpecificationInstance2085); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecificationInstanceAccess().getFlowKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1094:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1095:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1095:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1096:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2102); 

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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_ruleFlowSpecificationInstance2119); 

                	newLeafNode(otherlv_2, grammarAccess.getFlowSpecificationInstanceAccess().getLeftParenthesisKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1116:1: ( ( ruleSIMPLEINSTANCEREF ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1117:1: ( ruleSIMPLEINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1117:1: ( ruleSIMPLEINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1118:3: ruleSIMPLEINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getSourceFeatureInstanceCrossReference_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2142);
                    ruleSIMPLEINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecificationInstance2155); 

                	newLeafNode(otherlv_4, grammarAccess.getFlowSpecificationInstanceAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1135:1: ( ( ruleSIMPLEINSTANCEREF ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1136:1: ( ruleSIMPLEINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1136:1: ( ruleSIMPLEINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1137:3: ruleSIMPLEINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getDestinationFeatureInstanceCrossReference_5_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2178);
                    ruleSIMPLEINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleFlowSpecificationInstance2191); 

                	newLeafNode(otherlv_6, grammarAccess.getFlowSpecificationInstanceAccess().getRightParenthesisKeyword_6());
                
            otherlv_7=(Token)match(input,9,FOLLOW_9_in_ruleFlowSpecificationInstance2203); 

                	newLeafNode(otherlv_7, grammarAccess.getFlowSpecificationInstanceAccess().getColonKeyword_7());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1158:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1159:1: ( ruleFEATREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1159:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1160:3: ruleFEATREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecificationInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFlowSpecificationInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_ruleFEATREF_in_ruleFlowSpecificationInstance2226);
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


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1181:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1182:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1183:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode2262);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode2272); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1190:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1193:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1194:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1194:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1194:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleSystemOperationMode2309); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1198:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1199:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1199:1: (lv_name_1_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1200:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSystemOperationMode2326); 

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


            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1224:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1225:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1226:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType2368);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType2379); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1233:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1236:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1237:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1237:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt25=3;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==23) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==26) ) {
                    alt25=3;
                }
                else if ( (LA25_1==EOF||(LA25_1>=27 && LA25_1<=35)) ) {
                    alt25=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA25_0==26) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1238:2: kw= 'in'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleDirectionType2417); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1245:2: kw= 'out'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleDirectionType2436); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1251:6: (kw= 'in' kw= 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1251:6: (kw= 'in' kw= 'out' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1252:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleDirectionType2456); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleDirectionType2469); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1271:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1272:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1273:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory2511);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory2522); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1280:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1283:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1284:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1284:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            int alt26=9;
            switch ( input.LA(1) ) {
            case 27:
                {
                alt26=1;
                }
                break;
            case 28:
                {
                alt26=2;
                }
                break;
            case 29:
                {
                alt26=3;
                }
                break;
            case 30:
                {
                alt26=4;
                }
                break;
            case 31:
                {
                alt26=5;
                }
                break;
            case 32:
                {
                alt26=6;
                }
                break;
            case 33:
                {
                alt26=7;
                }
                break;
            case 34:
                {
                alt26=8;
                }
                break;
            case 35:
                {
                alt26=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1285:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleFeatureCategory2560); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1292:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleFeatureCategory2579); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1299:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleFeatureCategory2598); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1306:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleFeatureCategory2617); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1313:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleFeatureCategory2636); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1320:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleFeatureCategory2655); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1327:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleFeatureCategory2674); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1334:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleFeatureCategory2693); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1341:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleFeatureCategory2712); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1354:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1355:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1356:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory2753);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory2764); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1363:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1366:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1367:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1367:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt27=14;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1368:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleComponentCategory2802); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1375:2: kw= 'bus'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleComponentCategory2821); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1382:2: kw= 'data'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleComponentCategory2840); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1389:2: kw= 'device'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleComponentCategory2859); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1396:2: kw= 'memory'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleComponentCategory2878); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1403:2: kw= 'process'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleComponentCategory2897); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1410:2: kw= 'processor'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleComponentCategory2916); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1417:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleComponentCategory2935); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1423:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1423:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1424:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleComponentCategory2955); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleComponentCategory2968); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1437:2: kw= 'system'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleComponentCategory2988); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1443:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1443:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1444:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleComponentCategory3008); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleComponentCategory3021); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1457:2: kw= 'thread'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleComponentCategory3041); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1463:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1463:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1464:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleComponentCategory3061); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleComponentCategory3074); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1476:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1476:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1477:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleComponentCategory3095); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleComponentCategory3108); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1496:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1497:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1498:2: iv_ruleConnectionKind= ruleConnectionKind EOF
            {
             newCompositeNode(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind3150);
            iv_ruleConnectionKind=ruleConnectionKind();

            state._fsp--;

             current =iv_ruleConnectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind3161); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1505:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1508:28: ( (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1509:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1509:1: (kw= 'featureConnection' | kw= 'accessConnection' | kw= 'parameterConnection' | kw= 'portConnection' | kw= 'modeTransitionConnection' | kw= 'featureGroupConnection' )
            int alt28=6;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt28=1;
                }
                break;
            case 49:
                {
                alt28=2;
                }
                break;
            case 50:
                {
                alt28=3;
                }
                break;
            case 51:
                {
                alt28=4;
                }
                break;
            case 52:
                {
                alt28=5;
                }
                break;
            case 53:
                {
                alt28=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1510:2: kw= 'featureConnection'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleConnectionKind3199); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureConnectionKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1517:2: kw= 'accessConnection'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleConnectionKind3218); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessConnectionKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1524:2: kw= 'parameterConnection'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleConnectionKind3237); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterConnectionKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1531:2: kw= 'portConnection'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleConnectionKind3256); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortConnectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1538:2: kw= 'modeTransitionConnection'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleConnectionKind3275); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getModeTransitionConnectionKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1545:2: kw= 'featureGroupConnection'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleConnectionKind3294); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1558:1: entryRuleIMPLREF returns [String current=null] : iv_ruleIMPLREF= ruleIMPLREF EOF ;
    public final String entryRuleIMPLREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMPLREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1559:2: (iv_ruleIMPLREF= ruleIMPLREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1560:2: iv_ruleIMPLREF= ruleIMPLREF EOF
            {
             newCompositeNode(grammarAccess.getIMPLREFRule()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF3335);
            iv_ruleIMPLREF=ruleIMPLREF();

            state._fsp--;

             current =iv_ruleIMPLREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMPLREF3346); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1567:1: ruleIMPLREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMPLREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1570:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1571:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1571:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1571:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1571:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    int LA29_1 = input.LA(2);

                    if ( (LA29_1==54) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1571:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF3387); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,54,FOLLOW_54_in_ruleIMPLREF3405); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF3422); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,55,FOLLOW_55_in_ruleIMPLREF3440); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF3455); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1612:1: entryRuleFEATREF returns [String current=null] : iv_ruleFEATREF= ruleFEATREF EOF ;
    public final String entryRuleFEATREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFEATREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1613:2: (iv_ruleFEATREF= ruleFEATREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1614:2: iv_ruleFEATREF= ruleFEATREF EOF
            {
             newCompositeNode(grammarAccess.getFEATREFRule()); 
            pushFollow(FOLLOW_ruleFEATREF_in_entryRuleFEATREF3501);
            iv_ruleFEATREF=ruleFEATREF();

            state._fsp--;

             current =iv_ruleFEATREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFEATREF3512); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1621:1: ruleFEATREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleFEATREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1624:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1625:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1625:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1625:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1625:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==54) ) {
                        int LA30_2 = input.LA(3);

                        if ( (LA30_2==RULE_ID) ) {
                            int LA30_3 = input.LA(4);

                            if ( (LA30_3==54) ) {
                                alt30=1;
                            }


                        }


                    }


                }


                switch (alt30) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1625:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF3553); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,54,FOLLOW_54_in_ruleFEATREF3571); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFEATREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF3588); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,54,FOLLOW_54_in_ruleFEATREF3606); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getFEATREFAccess().getColonColonKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF3621); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1666:1: entryRuleSUBREF returns [String current=null] : iv_ruleSUBREF= ruleSUBREF EOF ;
    public final String entryRuleSUBREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSUBREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1667:2: (iv_ruleSUBREF= ruleSUBREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1668:2: iv_ruleSUBREF= ruleSUBREF EOF
            {
             newCompositeNode(grammarAccess.getSUBREFRule()); 
            pushFollow(FOLLOW_ruleSUBREF_in_entryRuleSUBREF3667);
            iv_ruleSUBREF=ruleSUBREF();

            state._fsp--;

             current =iv_ruleSUBREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSUBREF3678); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1675:1: ruleSUBREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSUBREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1678:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1679:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1679:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1679:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1679:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID) ) {
                    int LA31_1 = input.LA(2);

                    if ( (LA31_1==54) ) {
                        alt31=1;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1679:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF3719); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,54,FOLLOW_54_in_ruleSUBREF3737); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF3754); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,55,FOLLOW_55_in_ruleSUBREF3772); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF3787); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 
                
            kw=(Token)match(input,54,FOLLOW_54_in_ruleSUBREF3805); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 
                
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF3820); 

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


    // $ANTLR start "entryRuleINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1733:1: entryRuleINSTANCEREF returns [String current=null] : iv_ruleINSTANCEREF= ruleINSTANCEREF EOF ;
    public final String entryRuleINSTANCEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINSTANCEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1734:2: (iv_ruleINSTANCEREF= ruleINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1735:2: iv_ruleINSTANCEREF= ruleINSTANCEREF EOF
            {
             newCompositeNode(grammarAccess.getINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF3866);
            iv_ruleINSTANCEREF=ruleINSTANCEREF();

            state._fsp--;

             current =iv_ruleINSTANCEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREF3877); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1742:1: ruleINSTANCEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* ) ;
    public final AntlrDatatypeRuleToken ruleINSTANCEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_ID_5=null;
        Token this_LONG_7=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1745:28: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1746:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1746:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )* )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1746:6: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )* (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF3917); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1753:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==12) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1754:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
            	    {
            	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREF3936); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
            	        
            	    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREF3951); 

            	    		current.merge(this_LONG_2);
            	        
            	     
            	        newLeafNode(this_LONG_2, grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
            	        
            	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREF3969); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1772:3: (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )* )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==55) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1773:2: kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )*
            	    {
            	    kw=(Token)match(input,55,FOLLOW_55_in_ruleINSTANCEREF3985); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            	        
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF4000); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1785:1: (kw= '[' this_LONG_7= RULE_LONG kw= ']' )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==12) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1786:2: kw= '[' this_LONG_7= RULE_LONG kw= ']'
            	    	    {
            	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREF4019); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            	    	        
            	    	    this_LONG_7=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREF4034); 

            	    	    		current.merge(this_LONG_7);
            	    	        
            	    	     
            	    	        newLeafNode(this_LONG_7, grammarAccess.getINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            	    	        
            	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREF4052); 

            	    	            current.merge(kw);
            	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            	    	        

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop33;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1812:1: entryRuleSIMPLEINSTANCEREF returns [String current=null] : iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF ;
    public final String entryRuleSIMPLEINSTANCEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSIMPLEINSTANCEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1813:2: (iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1814:2: iv_ruleSIMPLEINSTANCEREF= ruleSIMPLEINSTANCEREF EOF
            {
             newCompositeNode(grammarAccess.getSIMPLEINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleSIMPLEINSTANCEREF_in_entryRuleSIMPLEINSTANCEREF4097);
            iv_ruleSIMPLEINSTANCEREF=ruleSIMPLEINSTANCEREF();

            state._fsp--;

             current =iv_ruleSIMPLEINSTANCEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSIMPLEINSTANCEREF4108); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1821:1: ruleSIMPLEINSTANCEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* ) ;
    public final AntlrDatatypeRuleToken ruleSIMPLEINSTANCEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_LONG_2=null;
        Token this_ID_5=null;
        Token this_LONG_7=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1824:28: ( (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1825:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1825:1: (this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )* )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1825:6: this_ID_0= RULE_ID (kw= '[' this_LONG_2= RULE_LONG kw= ']' )? (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF4148); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1832:1: (kw= '[' this_LONG_2= RULE_LONG kw= ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==12) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1833:2: kw= '[' this_LONG_2= RULE_LONG kw= ']'
                    {
                    kw=(Token)match(input,12,FOLLOW_12_in_ruleSIMPLEINSTANCEREF4167); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_1_0()); 
                        
                    this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF4182); 

                    		current.merge(this_LONG_2);
                        
                     
                        newLeafNode(this_LONG_2, grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_1_1()); 
                        
                    kw=(Token)match(input,13,FOLLOW_13_in_ruleSIMPLEINSTANCEREF4200); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_1_2()); 
                        

                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1851:3: (kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )? )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==55) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1852:2: kw= '.' this_ID_5= RULE_ID (kw= '[' this_LONG_7= RULE_LONG kw= ']' )?
            	    {
            	    kw=(Token)match(input,55,FOLLOW_55_in_ruleSIMPLEINSTANCEREF4216); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getFullStopKeyword_2_0()); 
            	        
            	    this_ID_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF4231); 

            	    		current.merge(this_ID_5);
            	        
            	     
            	        newLeafNode(this_ID_5, grammarAccess.getSIMPLEINSTANCEREFAccess().getIDTerminalRuleCall_2_1()); 
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1864:1: (kw= '[' this_LONG_7= RULE_LONG kw= ']' )?
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==12) ) {
            	        alt36=1;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1865:2: kw= '[' this_LONG_7= RULE_LONG kw= ']'
            	            {
            	            kw=(Token)match(input,12,FOLLOW_12_in_ruleSIMPLEINSTANCEREF4250); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getLeftSquareBracketKeyword_2_2_0()); 
            	                
            	            this_LONG_7=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF4265); 

            	            		current.merge(this_LONG_7);
            	                
            	             
            	                newLeafNode(this_LONG_7, grammarAccess.getSIMPLEINSTANCEREFAccess().getLONGTerminalRuleCall_2_2_1()); 
            	                
            	            kw=(Token)match(input,13,FOLLOW_13_in_ruleSIMPLEINSTANCEREF4283); 

            	                    current.merge(kw);
            	                    newLeafNode(kw, grammarAccess.getSIMPLEINSTANCEREFAccess().getRightSquareBracketKeyword_2_2_2()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1891:1: entryRuleINSTANCEREFWITHPARENT returns [String current=null] : iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF ;
    public final String entryRuleINSTANCEREFWITHPARENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINSTANCEREFWITHPARENT = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1892:2: (iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1893:2: iv_ruleINSTANCEREFWITHPARENT= ruleINSTANCEREFWITHPARENT EOF
            {
             newCompositeNode(grammarAccess.getINSTANCEREFWITHPARENTRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT4328);
            iv_ruleINSTANCEREFWITHPARENT=ruleINSTANCEREFWITHPARENT();

            state._fsp--;

             current =iv_ruleINSTANCEREFWITHPARENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT4339); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1900:1: ruleINSTANCEREFWITHPARENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) ) ;
    public final AntlrDatatypeRuleToken ruleINSTANCEREFWITHPARENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;
        Token this_LONG_3=null;
        Token this_ID_6=null;
        Token this_LONG_8=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1903:28: ( (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1904:1: (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1904:1: (kw= 'parent' | (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==56) ) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_ID) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1905:2: kw= 'parent'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleINSTANCEREFWITHPARENT4377); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getParentKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1911:6: (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1911:6: (this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )* )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1911:11: this_ID_1= RULE_ID (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+ (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )*
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT4399); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_0()); 
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1918:1: (kw= '[' this_LONG_3= RULE_LONG kw= ']' )+
                    int cnt38=0;
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==12) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1919:2: kw= '[' this_LONG_3= RULE_LONG kw= ']'
                    	    {
                    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREFWITHPARENT4418); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_1_0()); 
                    	        
                    	    this_LONG_3=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT4433); 

                    	    		current.merge(this_LONG_3);
                    	        
                    	     
                    	        newLeafNode(this_LONG_3, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_1_1()); 
                    	        
                    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREFWITHPARENT4451); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_1_2()); 
                    	        

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

                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1937:3: (kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+ )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==55) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1938:2: kw= '.' this_ID_6= RULE_ID (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+
                    	    {
                    	    kw=(Token)match(input,55,FOLLOW_55_in_ruleINSTANCEREFWITHPARENT4467); 

                    	            current.merge(kw);
                    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getFullStopKeyword_1_2_0()); 
                    	        
                    	    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT4482); 

                    	    		current.merge(this_ID_6);
                    	        
                    	     
                    	        newLeafNode(this_ID_6, grammarAccess.getINSTANCEREFWITHPARENTAccess().getIDTerminalRuleCall_1_2_1()); 
                    	        
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1950:1: (kw= '[' this_LONG_8= RULE_LONG kw= ']' )+
                    	    int cnt39=0;
                    	    loop39:
                    	    do {
                    	        int alt39=2;
                    	        int LA39_0 = input.LA(1);

                    	        if ( (LA39_0==12) ) {
                    	            alt39=1;
                    	        }


                    	        switch (alt39) {
                    	    	case 1 :
                    	    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1951:2: kw= '[' this_LONG_8= RULE_LONG kw= ']'
                    	    	    {
                    	    	    kw=(Token)match(input,12,FOLLOW_12_in_ruleINSTANCEREFWITHPARENT4501); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLeftSquareBracketKeyword_1_2_2_0()); 
                    	    	        
                    	    	    this_LONG_8=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT4516); 

                    	    	    		current.merge(this_LONG_8);
                    	    	        
                    	    	     
                    	    	        newLeafNode(this_LONG_8, grammarAccess.getINSTANCEREFWITHPARENTAccess().getLONGTerminalRuleCall_1_2_2_1()); 
                    	    	        
                    	    	    kw=(Token)match(input,13,FOLLOW_13_in_ruleINSTANCEREFWITHPARENT4534); 

                    	    	            current.merge(kw);
                    	    	            newLeafNode(kw, grammarAccess.getINSTANCEREFWITHPARENTAccess().getRightSquareBracketKeyword_1_2_2_2()); 
                    	    	        

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt39 >= 1 ) break loop39;
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(39, input);
                    	                throw eee;
                    	        }
                    	        cnt39++;
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1977:1: entryRuleCONNINSTREF returns [String current=null] : iv_ruleCONNINSTREF= ruleCONNINSTREF EOF ;
    public final String entryRuleCONNINSTREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCONNINSTREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1978:2: (iv_ruleCONNINSTREF= ruleCONNINSTREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1979:2: iv_ruleCONNINSTREF= ruleCONNINSTREF EOF
            {
             newCompositeNode(grammarAccess.getCONNINSTREFRule()); 
            pushFollow(FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF4580);
            iv_ruleCONNINSTREF=ruleCONNINSTREF();

            state._fsp--;

             current =iv_ruleCONNINSTREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCONNINSTREF4591); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1986:1: ruleCONNINSTREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG ) ;
    public final AntlrDatatypeRuleToken ruleCONNINSTREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_LONG_0=null;
        Token kw=null;
        Token this_LONG_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1989:28: ( ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1990:1: ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1990:1: ( (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1990:2: (this_LONG_0= RULE_LONG kw= '.' )? this_LONG_2= RULE_LONG
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1990:2: (this_LONG_0= RULE_LONG kw= '.' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_LONG) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==55) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1990:7: this_LONG_0= RULE_LONG kw= '.'
                    {
                    this_LONG_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleCONNINSTREF4632); 

                    		current.merge(this_LONG_0);
                        
                     
                        newLeafNode(this_LONG_0, grammarAccess.getCONNINSTREFAccess().getLONGTerminalRuleCall_0_0()); 
                        
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleCONNINSTREF4650); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCONNINSTREFAccess().getFullStopKeyword_0_1()); 
                        

                    }
                    break;

            }

            this_LONG_2=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleCONNINSTREF4667); 

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

    // Delegated rules


    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA27_eotS =
        "\22\uffff";
    static final String DFA27_eofS =
        "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String DFA27_minS =
        "\1\44\7\uffff\1\4\1\uffff\1\4\1\45\6\uffff";
    static final String DFA27_maxS =
        "\1\57\7\uffff\1\54\1\uffff\1\54\1\52\6\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\16\1\15";
    static final String DFA27_specialS =
        "\22\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\47\uffff\1\15",
            "",
            "\1\16\47\uffff\1\17",
            "\1\21\4\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "1367:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleSystemInstance131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemInstance148 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleSystemInstance165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_ruleSystemInstance188 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleSystemInstance200 = new BitSet(new long[]{0x003FEFF007900800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleSystemInstance222 = new BitSet(new long[]{0x003FEFF007900800L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleSystemInstance249 = new BitSet(new long[]{0x003FEFF007900800L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleSystemInstance276 = new BitSet(new long[]{0x003FEFF007900800L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleSystemInstance303 = new BitSet(new long[]{0x003FEFF007900800L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance330 = new BitSet(new long[]{0x003FEFF007900800L});
    public static final BitSet FOLLOW_11_in_ruleSystemInstance344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_ruleFeatureInstance436 = new BitSet(new long[]{0x0000000FF8000000L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance457 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance474 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleFeatureInstance492 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFeatureInstance509 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFeatureInstance526 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFeatureInstance540 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFEATREF_in_ruleFeatureInstance563 = new BitSet(new long[]{0x0000000000084402L});
    public static final BitSet FOLLOW_14_in_ruleFeatureInstance576 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureInstance588 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFeatureInstance600 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance624 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance650 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFeatureInstance664 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance688 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance714 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureInstance729 = new BitSet(new long[]{0x0000000000080402L});
    public static final BitSet FOLLOW_19_in_ruleFeatureInstance744 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureInstance756 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFeatureInstance768 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance792 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance818 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleFeatureInstance832 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleFeatureInstance856 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance882 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureInstance897 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_ruleFeatureInstance912 = new BitSet(new long[]{0x0000000004800800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance933 = new BitSet(new long[]{0x0000000004800800L});
    public static final BitSet FOLLOW_11_in_ruleFeatureInstance946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance984 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleComponentInstance1040 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance1057 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleComponentInstance1075 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleComponentInstance1092 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleComponentInstance1109 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_9_in_ruleComponentInstance1123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleComponentInstance1146 = new BitSet(new long[]{0x0000000000084402L});
    public static final BitSet FOLLOW_14_in_ruleComponentInstance1159 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance1171 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1183 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1206 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1219 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1242 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance1256 = new BitSet(new long[]{0x0000000000080402L});
    public static final BitSet FOLLOW_19_in_ruleComponentInstance1271 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance1283 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance1295 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1318 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance1331 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_ruleComponentInstance1354 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance1368 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_ruleComponentInstance1383 = new BitSet(new long[]{0x003FEFF005900800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleComponentInstance1405 = new BitSet(new long[]{0x003FEFF005900800L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleComponentInstance1432 = new BitSet(new long[]{0x003FEFF005900800L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleComponentInstance1459 = new BitSet(new long[]{0x003FEFF005900800L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_ruleComponentInstance1486 = new BitSet(new long[]{0x003FEFF005900800L});
    public static final BitSet FOLLOW_11_in_ruleComponentInstance1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance1538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance1548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleConnectionInstance1591 = new BitSet(new long[]{0x003F000000100000L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_ruleConnectionInstance1626 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleConnectionInstance1643 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleConnectionInstance1660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1683 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_21_in_ruleConnectionInstance1702 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance1733 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance1757 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleConnectionInstance1769 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_ruleConnectionInstance1790 = new BitSet(new long[]{0x0000000000000810L});
    public static final BitSet FOLLOW_11_in_ruleConnectionInstance1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference1839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference1849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference1897 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionReference1909 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference1932 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleConnectionReference1944 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleConnectionReference1967 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleConnectionReference1979 = new BitSet(new long[]{0x0100000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_ruleConnectionReference2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecificationInstance_in_entryRuleFlowSpecificationInstance2038 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecificationInstance2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFlowSpecificationInstance2085 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecificationInstance2102 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleFlowSpecificationInstance2119 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2142 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecificationInstance2155 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_ruleFlowSpecificationInstance2178 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFlowSpecificationInstance2191 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFlowSpecificationInstance2203 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFEATREF_in_ruleFlowSpecificationInstance2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode2262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode2272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleSystemOperationMode2309 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSystemOperationMode2326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType2368 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDirectionType2417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleDirectionType2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleDirectionType2456 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleDirectionType2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory2511 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory2522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleFeatureCategory2560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleFeatureCategory2579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleFeatureCategory2598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleFeatureCategory2617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleFeatureCategory2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleFeatureCategory2655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleFeatureCategory2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleFeatureCategory2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleFeatureCategory2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory2753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory2764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComponentCategory2802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleComponentCategory2821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleComponentCategory2840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleComponentCategory2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleComponentCategory2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleComponentCategory2897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleComponentCategory2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleComponentCategory2935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleComponentCategory2955 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleComponentCategory2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleComponentCategory2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleComponentCategory3008 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44_in_ruleComponentCategory3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleComponentCategory3041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleComponentCategory3061 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleComponentCategory3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleComponentCategory3095 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleComponentCategory3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind3150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind3161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleConnectionKind3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleConnectionKind3218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleConnectionKind3237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleConnectionKind3256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleConnectionKind3275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleConnectionKind3294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF3335 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMPLREF3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF3387 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleIMPLREF3405 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF3422 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleIMPLREF3440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF3455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_entryRuleFEATREF3501 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFEATREF3512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF3553 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleFEATREF3571 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF3588 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleFEATREF3606 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF3621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_entryRuleSUBREF3667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSUBREF3678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF3719 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleSUBREF3737 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF3754 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleSUBREF3772 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF3787 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_54_in_ruleSUBREF3805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF3820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF3866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREF3877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF3917 = new BitSet(new long[]{0x0080000000001002L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREF3936 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREF3951 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREF3969 = new BitSet(new long[]{0x0080000000001002L});
    public static final BitSet FOLLOW_55_in_ruleINSTANCEREF3985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF4000 = new BitSet(new long[]{0x0080000000001002L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREF4019 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREF4034 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREF4052 = new BitSet(new long[]{0x0080000000001002L});
    public static final BitSet FOLLOW_ruleSIMPLEINSTANCEREF_in_entryRuleSIMPLEINSTANCEREF4097 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSIMPLEINSTANCEREF4108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF4148 = new BitSet(new long[]{0x0080000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSIMPLEINSTANCEREF4167 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF4182 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSIMPLEINSTANCEREF4200 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_55_in_ruleSIMPLEINSTANCEREF4216 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSIMPLEINSTANCEREF4231 = new BitSet(new long[]{0x0080000000001002L});
    public static final BitSet FOLLOW_12_in_ruleSIMPLEINSTANCEREF4250 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleSIMPLEINSTANCEREF4265 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSIMPLEINSTANCEREF4283 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREFWITHPARENT_in_entryRuleINSTANCEREFWITHPARENT4328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREFWITHPARENT4339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleINSTANCEREFWITHPARENT4377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT4399 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREFWITHPARENT4418 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT4433 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREFWITHPARENT4451 = new BitSet(new long[]{0x0080000000001002L});
    public static final BitSet FOLLOW_55_in_ruleINSTANCEREFWITHPARENT4467 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREFWITHPARENT4482 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleINSTANCEREFWITHPARENT4501 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleINSTANCEREFWITHPARENT4516 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleINSTANCEREFWITHPARENT4534 = new BitSet(new long[]{0x0080000000001002L});
    public static final BitSet FOLLOW_ruleCONNINSTREF_in_entryRuleCONNINSTREF4580 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCONNINSTREF4591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleCONNINSTREF4632 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleCONNINSTREF4650 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleCONNINSTREF4667 = new BitSet(new long[]{0x0000000000000002L});

}