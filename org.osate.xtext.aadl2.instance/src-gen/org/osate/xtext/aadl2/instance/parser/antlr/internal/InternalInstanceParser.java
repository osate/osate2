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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER_LIT", "RULE_SL_COMMENT", "RULE_WS", "'rootinstance'", "'of'", "'end'", "'instance'", "'['", "']'", "'in'", "'mode'", "'initial'", "'transition'", "'src'", "'dst'", "'flowspec'", "'etef'", "'som'", "'connection'", "'complete'", "'bidirectional'", "'context'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'threadgroup'", "'thread'", "'virtual'", "'virtualprocessor'", "'eventport'", "'dataport'", "'eventdataport'", "'parameter'", "'busaccess'", "'dataaccess'", "'subprogramaccess'", "'subprogramgroupaccess'", "'featuregroup'", "'abstractfeature'", "'out'", "'inout'", "'feature'", "'access'", "'port'", "'modetransition'", "'::'", "'.'", "'#'"
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
    public static final int T__8=8;
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
    public static final int RULE_INTEGER_LIT=5;
    public static final int T__21=21;
    public static final int RULE_SL_COMMENT=6;
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
    public static final int RULE_WS=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:76:1: ruleSystemInstance returns [EObject current=null] : (otherlv_0= 'rootinstance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_category_2_0= ruleComponentCategory ) ) otherlv_3= 'of' ( ( ruleFQCREF ) ) ( (lv_featureInstance_5_0= ruleFeatureInstance ) )* ( (lv_componentInstance_6_0= ruleComponentInstance ) )* ( (lv_modeInstance_7_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_8_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_9_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_10_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_11_0= ruleConnectionInstance ) )* ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )* otherlv_13= 'end' ) ;
    public final EObject ruleSystemInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_3=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_category_2_0 = null;

        EObject lv_featureInstance_5_0 = null;

        EObject lv_componentInstance_6_0 = null;

        EObject lv_modeInstance_7_0 = null;

        EObject lv_modeTransitionInstance_8_0 = null;

        EObject lv_flowSpecification_9_0 = null;

        EObject lv_endToEndFlow_10_0 = null;

        EObject lv_connectionInstance_11_0 = null;

        EObject lv_systemOperationMode_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:79:28: ( (otherlv_0= 'rootinstance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_category_2_0= ruleComponentCategory ) ) otherlv_3= 'of' ( ( ruleFQCREF ) ) ( (lv_featureInstance_5_0= ruleFeatureInstance ) )* ( (lv_componentInstance_6_0= ruleComponentInstance ) )* ( (lv_modeInstance_7_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_8_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_9_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_10_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_11_0= ruleConnectionInstance ) )* ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )* otherlv_13= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: (otherlv_0= 'rootinstance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_category_2_0= ruleComponentCategory ) ) otherlv_3= 'of' ( ( ruleFQCREF ) ) ( (lv_featureInstance_5_0= ruleFeatureInstance ) )* ( (lv_componentInstance_6_0= ruleComponentInstance ) )* ( (lv_modeInstance_7_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_8_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_9_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_10_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_11_0= ruleConnectionInstance ) )* ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )* otherlv_13= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: (otherlv_0= 'rootinstance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_category_2_0= ruleComponentCategory ) ) otherlv_3= 'of' ( ( ruleFQCREF ) ) ( (lv_featureInstance_5_0= ruleFeatureInstance ) )* ( (lv_componentInstance_6_0= ruleComponentInstance ) )* ( (lv_modeInstance_7_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_8_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_9_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_10_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_11_0= ruleConnectionInstance ) )* ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )* otherlv_13= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:3: otherlv_0= 'rootinstance' ( (lv_name_1_0= RULE_ID ) ) ( (lv_category_2_0= ruleComponentCategory ) ) otherlv_3= 'of' ( ( ruleFQCREF ) ) ( (lv_featureInstance_5_0= ruleFeatureInstance ) )* ( (lv_componentInstance_6_0= ruleComponentInstance ) )* ( (lv_modeInstance_7_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_8_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_9_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_10_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_11_0= ruleConnectionInstance ) )* ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )* otherlv_13= 'end'
            {
            otherlv_0=(Token)match(input,8,FOLLOW_8_in_ruleSystemInstance122); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemInstanceAccess().getRootinstanceKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:84:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:85:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:85:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:86:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemInstance139); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:102:2: ( (lv_category_2_0= ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:103:1: (lv_category_2_0= ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:103:1: (lv_category_2_0= ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:104:3: lv_category_2_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getCategoryComponentCategoryParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleSystemInstance165);
            lv_category_2_0=ruleComponentCategory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_2_0, 
                    		"ComponentCategory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleSystemInstance177); 

                	newLeafNode(otherlv_3, grammarAccess.getSystemInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:124:1: ( ( ruleFQCREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:125:1: ( ruleFQCREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:125:1: ( ruleFQCREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:126:3: ruleFQCREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleFQCREF_in_ruleSystemInstance200);
            ruleFQCREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:139:2: ( (lv_featureInstance_5_0= ruleFeatureInstance ) )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case 44:
                    {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==11) ) {
                        alt1=1;
                    }


                    }
                    break;
                case 49:
                    {
                    int LA1_3 = input.LA(2);

                    if ( (LA1_3==11) ) {
                        alt1=1;
                    }


                    }
                    break;
                case 41:
                case 42:
                case 43:
                case 45:
                case 46:
                case 47:
                case 48:
                case 50:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:140:1: (lv_featureInstance_5_0= ruleFeatureInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:140:1: (lv_featureInstance_5_0= ruleFeatureInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:141:3: lv_featureInstance_5_0= ruleFeatureInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleSystemInstance221);
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
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:157:3: ( (lv_componentInstance_6_0= ruleComponentInstance ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=27 && LA2_0<=34)||(LA2_0>=36 && LA2_0<=40)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:158:1: (lv_componentInstance_6_0= ruleComponentInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:158:1: (lv_componentInstance_6_0= ruleComponentInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:159:3: lv_componentInstance_6_0= ruleComponentInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleSystemInstance243);
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
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:175:3: ( (lv_modeInstance_7_0= ruleModeInstance ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    int LA3_1 = input.LA(2);

                    if ( (LA3_1==11) ) {
                        alt3=1;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:176:1: (lv_modeInstance_7_0= ruleModeInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:176:1: (lv_modeInstance_7_0= ruleModeInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:177:3: lv_modeInstance_7_0= ruleModeInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getModeInstanceModeInstanceParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModeInstance_in_ruleSystemInstance265);
            	    lv_modeInstance_7_0=ruleModeInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modeInstance",
            	            		lv_modeInstance_7_0, 
            	            		"ModeInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:193:3: ( (lv_modeTransitionInstance_8_0= ruleModeTransitionInstance ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:194:1: (lv_modeTransitionInstance_8_0= ruleModeTransitionInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:194:1: (lv_modeTransitionInstance_8_0= ruleModeTransitionInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:195:3: lv_modeTransitionInstance_8_0= ruleModeTransitionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModeTransitionInstance_in_ruleSystemInstance287);
            	    lv_modeTransitionInstance_8_0=ruleModeTransitionInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modeTransitionInstance",
            	            		lv_modeTransitionInstance_8_0, 
            	            		"ModeTransitionInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:211:3: ( (lv_flowSpecification_9_0= ruleFlowSpecInstance ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:212:1: (lv_flowSpecification_9_0= ruleFlowSpecInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:212:1: (lv_flowSpecification_9_0= ruleFlowSpecInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:213:3: lv_flowSpecification_9_0= ruleFlowSpecInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFlowSpecInstance_in_ruleSystemInstance309);
            	    lv_flowSpecification_9_0=ruleFlowSpecInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"flowSpecification",
            	            		lv_flowSpecification_9_0, 
            	            		"FlowSpecInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:229:3: ( (lv_endToEndFlow_10_0= ruleEndToEndFlowInstance ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==21) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:230:1: (lv_endToEndFlow_10_0= ruleEndToEndFlowInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:230:1: (lv_endToEndFlow_10_0= ruleEndToEndFlowInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:231:3: lv_endToEndFlow_10_0= ruleEndToEndFlowInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_ruleSystemInstance331);
            	    lv_endToEndFlow_10_0=ruleEndToEndFlowInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"endToEndFlow",
            	            		lv_endToEndFlow_10_0, 
            	            		"EndToEndFlowInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:247:3: ( (lv_connectionInstance_11_0= ruleConnectionInstance ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==44||LA7_0==49||(LA7_0>=53 && LA7_0<=56)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:248:1: (lv_connectionInstance_11_0= ruleConnectionInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:248:1: (lv_connectionInstance_11_0= ruleConnectionInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:249:3: lv_connectionInstance_11_0= ruleConnectionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_11_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleSystemInstance353);
            	    lv_connectionInstance_11_0=ruleConnectionInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionInstance",
            	            		lv_connectionInstance_11_0, 
            	            		"ConnectionInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:265:3: ( (lv_systemOperationMode_12_0= ruleSystemOperationMode ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==22) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:266:1: (lv_systemOperationMode_12_0= ruleSystemOperationMode )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:266:1: (lv_systemOperationMode_12_0= ruleSystemOperationMode )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:267:3: lv_systemOperationMode_12_0= ruleSystemOperationMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_12_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance375);
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
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_13=(Token)match(input,10,FOLLOW_10_in_ruleSystemInstance388); 

                	newLeafNode(otherlv_13, grammarAccess.getSystemInstanceAccess().getEndKeyword_13());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleComponentInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:295:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:296:2: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:297:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance424);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance434); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:304:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end' ) ;
    public final EObject ruleComponentInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        AntlrDatatypeRuleToken lv_index_4_0 = null;

        EObject lv_featureInstance_8_0 = null;

        EObject lv_componentInstance_9_0 = null;

        EObject lv_modeInstance_10_0 = null;

        EObject lv_modeTransitionInstance_11_0 = null;

        EObject lv_flowSpecification_12_0 = null;

        EObject lv_endToEndFlow_13_0 = null;

        EObject lv_connectionInstance_14_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:307:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:308:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:308:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:308:2: ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:308:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:309:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:309:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:310:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleComponentInstance480);
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

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleComponentInstance492); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:330:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:331:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:331:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:332:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance509); 

            			newLeafNode(lv_name_2_0, grammarAccess.getComponentInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:348:2: (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:348:4: otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleComponentInstance527); 

                        	newLeafNode(otherlv_3, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:352:1: ( (lv_index_4_0= ruleINTVALUE ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_INTEGER_LIT) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:353:1: (lv_index_4_0= ruleINTVALUE )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:353:1: (lv_index_4_0= ruleINTVALUE )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:354:3: lv_index_4_0= ruleINTVALUE
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleINTVALUE_in_ruleComponentInstance548);
                    	    lv_index_4_0=ruleINTVALUE();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"index",
                    	            		lv_index_4_0, 
                    	            		"INTVALUE");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);

                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleComponentInstance561); 

                        	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,9,FOLLOW_9_in_ruleComponentInstance575); 

                	newLeafNode(otherlv_6, grammarAccess.getComponentInstanceAccess().getOfKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:378:1: ( (otherlv_7= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:379:1: (otherlv_7= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:379:1: (otherlv_7= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:380:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance595); 

            		newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_5_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:391:2: ( (lv_featureInstance_8_0= ruleFeatureInstance ) )*
            loop11:
            do {
                int alt11=2;
                switch ( input.LA(1) ) {
                case 44:
                    {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2==11) ) {
                        alt11=1;
                    }


                    }
                    break;
                case 49:
                    {
                    int LA11_3 = input.LA(2);

                    if ( (LA11_3==11) ) {
                        alt11=1;
                    }


                    }
                    break;
                case 41:
                case 42:
                case 43:
                case 45:
                case 46:
                case 47:
                case 48:
                case 50:
                    {
                    alt11=1;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:392:1: (lv_featureInstance_8_0= ruleFeatureInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:392:1: (lv_featureInstance_8_0= ruleFeatureInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:393:3: lv_featureInstance_8_0= ruleFeatureInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleComponentInstance616);
            	    lv_featureInstance_8_0=ruleFeatureInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"featureInstance",
            	            		lv_featureInstance_8_0, 
            	            		"FeatureInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:409:3: ( (lv_componentInstance_9_0= ruleComponentInstance ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=27 && LA12_0<=34)||(LA12_0>=36 && LA12_0<=40)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:410:1: (lv_componentInstance_9_0= ruleComponentInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:410:1: (lv_componentInstance_9_0= ruleComponentInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:411:3: lv_componentInstance_9_0= ruleComponentInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleComponentInstance638);
            	    lv_componentInstance_9_0=ruleComponentInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"componentInstance",
            	            		lv_componentInstance_9_0, 
            	            		"ComponentInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:427:3: ( (lv_modeInstance_10_0= ruleModeInstance ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==15) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==11) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:428:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:428:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:429:3: lv_modeInstance_10_0= ruleModeInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModeInstance_in_ruleComponentInstance660);
            	    lv_modeInstance_10_0=ruleModeInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modeInstance",
            	            		lv_modeInstance_10_0, 
            	            		"ModeInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:445:3: ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==15) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:446:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:446:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:447:3: lv_modeTransitionInstance_11_0= ruleModeTransitionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance682);
            	    lv_modeTransitionInstance_11_0=ruleModeTransitionInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"modeTransitionInstance",
            	            		lv_modeTransitionInstance_11_0, 
            	            		"ModeTransitionInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:463:3: ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==20) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:464:1: (lv_flowSpecification_12_0= ruleFlowSpecInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:464:1: (lv_flowSpecification_12_0= ruleFlowSpecInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:465:3: lv_flowSpecification_12_0= ruleFlowSpecInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFlowSpecInstance_in_ruleComponentInstance704);
            	    lv_flowSpecification_12_0=ruleFlowSpecInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"flowSpecification",
            	            		lv_flowSpecification_12_0, 
            	            		"FlowSpecInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:481:3: ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==21) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:482:1: (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:482:1: (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:483:3: lv_endToEndFlow_13_0= ruleEndToEndFlowInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_11_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance726);
            	    lv_endToEndFlow_13_0=ruleEndToEndFlowInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"endToEndFlow",
            	            		lv_endToEndFlow_13_0, 
            	            		"EndToEndFlowInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:499:3: ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==44||LA17_0==49||(LA17_0>=53 && LA17_0<=56)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:500:1: (lv_connectionInstance_14_0= ruleConnectionInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:500:1: (lv_connectionInstance_14_0= ruleConnectionInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:501:3: lv_connectionInstance_14_0= ruleConnectionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_12_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleComponentInstance748);
            	    lv_connectionInstance_14_0=ruleConnectionInstance();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getComponentInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionInstance",
            	            		lv_connectionInstance_14_0, 
            	            		"ConnectionInstance");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:517:3: (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==14) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:517:5: otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) )
                    {
                    otherlv_15=(Token)match(input,14,FOLLOW_14_in_ruleComponentInstance762); 

                        	newLeafNode(otherlv_15, grammarAccess.getComponentInstanceAccess().getInKeyword_13_0());
                        
                    otherlv_16=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance774); 

                        	newLeafNode(otherlv_16, grammarAccess.getComponentInstanceAccess().getModeKeyword_13_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:525:1: ( (otherlv_17= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:526:1: (otherlv_17= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:526:1: (otherlv_17= RULE_ID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:527:3: otherlv_17= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance794); 

                    		newLeafNode(otherlv_17, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_13_2_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_18=(Token)match(input,10,FOLLOW_10_in_ruleComponentInstance808); 

                	newLeafNode(otherlv_18, grammarAccess.getComponentInstanceAccess().getEndKeyword_14());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleFeatureInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:550:1: entryRuleFeatureInstance returns [EObject current=null] : iv_ruleFeatureInstance= ruleFeatureInstance EOF ;
    public final EObject entryRuleFeatureInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:551:2: (iv_ruleFeatureInstance= ruleFeatureInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:552:2: iv_ruleFeatureInstance= ruleFeatureInstance EOF
            {
             newCompositeNode(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance844);
            iv_ruleFeatureInstance=ruleFeatureInstance();

            state._fsp--;

             current =iv_ruleFeatureInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance854); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:559:1: ruleFeatureInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end' ) ;
    public final EObject ruleFeatureInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        AntlrDatatypeRuleToken lv_index_4_0 = null;

        AntlrDatatypeRuleToken lv_direction_8_0 = null;

        EObject lv_featureInstance_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:562:28: ( ( ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:563:1: ( ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:563:1: ( ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:563:2: ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:563:2: ( (lv_category_0_0= ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:564:1: (lv_category_0_0= ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:564:1: (lv_category_0_0= ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:565:3: lv_category_0_0= ruleFeatureCategory
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance900);
            lv_category_0_0=ruleFeatureCategory();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"category",
                    		lv_category_0_0, 
                    		"FeatureCategory");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleFeatureInstance912); 

                	newLeafNode(otherlv_1, grammarAccess.getFeatureInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:585:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:586:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:586:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:587:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance929); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:603:2: (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==12) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:603:4: otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleFeatureInstance947); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:607:1: ( (lv_index_4_0= ruleINTVALUE ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:608:1: (lv_index_4_0= ruleINTVALUE )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:608:1: (lv_index_4_0= ruleINTVALUE )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:609:3: lv_index_4_0= ruleINTVALUE
                    {
                     
                    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINTVALUE_in_ruleFeatureInstance968);
                    lv_index_4_0=ruleINTVALUE();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
                    	        }
                           		set(
                           			current, 
                           			"index",
                            		lv_index_4_0, 
                            		"INTVALUE");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleFeatureInstance980); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,9,FOLLOW_9_in_ruleFeatureInstance994); 

                	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getOfKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:633:1: ( (otherlv_7= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:634:1: (otherlv_7= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:634:1: (otherlv_7= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:635:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance1014); 

            		newLeafNode(otherlv_7, grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:646:2: ( (lv_direction_8_0= ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:647:1: (lv_direction_8_0= ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:647:1: (lv_direction_8_0= ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:648:3: lv_direction_8_0= ruleDirectionType
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleDirectionType_in_ruleFeatureInstance1035);
            lv_direction_8_0=ruleDirectionType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFeatureInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"direction",
                    		lv_direction_8_0, 
                    		"DirectionType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:664:2: ( (lv_featureInstance_9_0= ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:665:1: (lv_featureInstance_9_0= ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:665:1: (lv_featureInstance_9_0= ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:666:3: lv_featureInstance_9_0= ruleFeatureInstance
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance1056);
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

            otherlv_10=(Token)match(input,10,FOLLOW_10_in_ruleFeatureInstance1068); 

                	newLeafNode(otherlv_10, grammarAccess.getFeatureInstanceAccess().getEndKeyword_8());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleModeInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:694:1: entryRuleModeInstance returns [EObject current=null] : iv_ruleModeInstance= ruleModeInstance EOF ;
    public final EObject entryRuleModeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:695:2: (iv_ruleModeInstance= ruleModeInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:696:2: iv_ruleModeInstance= ruleModeInstance EOF
            {
             newCompositeNode(grammarAccess.getModeInstanceRule()); 
            pushFollow(FOLLOW_ruleModeInstance_in_entryRuleModeInstance1104);
            iv_ruleModeInstance=ruleModeInstance();

            state._fsp--;

             current =iv_ruleModeInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeInstance1114); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:703:1: ruleModeInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end' ) ;
    public final EObject ruleModeInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_initial_5_0=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:706:28: ( (otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:707:1: (otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:707:1: (otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:707:3: otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleModeInstance1151); 

                	newLeafNode(otherlv_0, grammarAccess.getModeInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleModeInstance1163); 

                	newLeafNode(otherlv_1, grammarAccess.getModeInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:715:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:716:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:716:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:717:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance1180); 

            			newLeafNode(lv_name_2_0, grammarAccess.getModeInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleModeInstance1197); 

                	newLeafNode(otherlv_3, grammarAccess.getModeInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:737:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:738:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:738:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:739:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance1217); 

            		newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getModeModeCrossReference_4_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:750:2: ( (lv_initial_5_0= 'initial' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==16) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:751:1: (lv_initial_5_0= 'initial' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:751:1: (lv_initial_5_0= 'initial' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:752:3: lv_initial_5_0= 'initial'
                    {
                    lv_initial_5_0=(Token)match(input,16,FOLLOW_16_in_ruleModeInstance1235); 

                            newLeafNode(lv_initial_5_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,10,FOLLOW_10_in_ruleModeInstance1261); 

                	newLeafNode(otherlv_6, grammarAccess.getModeInstanceAccess().getEndKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:777:1: entryRuleModeTransitionInstance returns [EObject current=null] : iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF ;
    public final EObject entryRuleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransitionInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:778:2: (iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:779:2: iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionInstanceRule()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance1297);
            iv_ruleModeTransitionInstance=ruleModeTransitionInstance();

            state._fsp--;

             current =iv_ruleModeTransitionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransitionInstance1307); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:786:1: ruleModeTransitionInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end' ) ;
    public final EObject ruleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:789:28: ( (otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:790:1: (otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:790:1: (otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:790:3: otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleModeTransitionInstance1344); 

                	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleModeTransitionInstance1356); 

                	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
                
            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleModeTransitionInstance1368); 

                	newLeafNode(otherlv_2, grammarAccess.getModeTransitionInstanceAccess().getInstanceKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:802:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:803:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:803:1: (lv_name_3_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:804:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance1385); 

            			newLeafNode(lv_name_3_0, grammarAccess.getModeTransitionInstanceAccess().getNameIDTerminalRuleCall_3_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ID");
            	    

            }


            }

            otherlv_4=(Token)match(input,9,FOLLOW_9_in_ruleModeTransitionInstance1402); 

                	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getOfKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:824:1: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:825:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:825:1: (otherlv_5= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:826:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance1422); 

            		newLeafNode(otherlv_5, grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleModeTransitionInstance1434); 

                	newLeafNode(otherlv_6, grammarAccess.getModeTransitionInstanceAccess().getSrcKeyword_6());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:841:1: ( (otherlv_7= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:842:1: (otherlv_7= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:842:1: (otherlv_7= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:843:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance1454); 

            		newLeafNode(otherlv_7, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_7_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleModeTransitionInstance1466); 

                	newLeafNode(otherlv_8, grammarAccess.getModeTransitionInstanceAccess().getDstKeyword_8());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:858:1: ( (otherlv_9= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:859:1: (otherlv_9= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:859:1: (otherlv_9= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:860:3: otherlv_9= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance1486); 

            		newLeafNode(otherlv_9, grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_9_0()); 
            	

            }


            }

            otherlv_10=(Token)match(input,10,FOLLOW_10_in_ruleModeTransitionInstance1498); 

                	newLeafNode(otherlv_10, grammarAccess.getModeTransitionInstanceAccess().getEndKeyword_10());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleFlowSpecInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:883:1: entryRuleFlowSpecInstance returns [EObject current=null] : iv_ruleFlowSpecInstance= ruleFlowSpecInstance EOF ;
    public final EObject entryRuleFlowSpecInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:884:2: (iv_ruleFlowSpecInstance= ruleFlowSpecInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:885:2: iv_ruleFlowSpecInstance= ruleFlowSpecInstance EOF
            {
             newCompositeNode(grammarAccess.getFlowSpecInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecInstance_in_entryRuleFlowSpecInstance1534);
            iv_ruleFlowSpecInstance=ruleFlowSpecInstance();

            state._fsp--;

             current =iv_ruleFlowSpecInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecInstance1544); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlowSpecInstance"


    // $ANTLR start "ruleFlowSpecInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:892:1: ruleFlowSpecInstance returns [EObject current=null] : (otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end' ) ;
    public final EObject ruleFlowSpecInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:895:28: ( (otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:896:1: (otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:896:1: (otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:896:3: otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleFlowSpecInstance1581); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecInstanceAccess().getFlowspecKeyword_0());
                
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleFlowSpecInstance1593); 

                	newLeafNode(otherlv_1, grammarAccess.getFlowSpecInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:904:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:905:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:905:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:906:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecInstance1610); 

            			newLeafNode(lv_name_2_0, grammarAccess.getFlowSpecInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleFlowSpecInstance1627); 

                	newLeafNode(otherlv_3, grammarAccess.getFlowSpecInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:926:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:927:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:927:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:928:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecInstance1647); 

            		newLeafNode(otherlv_4, grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_4_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:939:2: (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==18) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:939:4: otherlv_5= 'src' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleFlowSpecInstance1660); 

                        	newLeafNode(otherlv_5, grammarAccess.getFlowSpecInstanceAccess().getSrcKeyword_5_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:943:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:944:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:944:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:945:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceCrossReference_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1683);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:958:4: (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==19) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:958:6: otherlv_7= 'dst' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleFlowSpecInstance1698); 

                        	newLeafNode(otherlv_7, grammarAccess.getFlowSpecInstanceAccess().getDstKeyword_6_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:962:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:963:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:963:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:964:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceCrossReference_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1721);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:977:4: (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==14) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==15) ) {
                    alt23=1;
                }
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:977:6: otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_9=(Token)match(input,14,FOLLOW_14_in_ruleFlowSpecInstance1736); 

                        	newLeafNode(otherlv_9, grammarAccess.getFlowSpecInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleFlowSpecInstance1748); 

                        	newLeafNode(otherlv_10, grammarAccess.getFlowSpecInstanceAccess().getModeKeyword_7_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:985:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:986:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:986:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:987:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceCrossReference_7_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1771);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1000:4: (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==14) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1000:6: otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) )
                    {
                    otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleFlowSpecInstance1786); 

                        	newLeafNode(otherlv_12, grammarAccess.getFlowSpecInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleFlowSpecInstance1798); 

                        	newLeafNode(otherlv_13, grammarAccess.getFlowSpecInstanceAccess().getTransitionKeyword_8_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1008:1: ( (otherlv_14= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1009:1: (otherlv_14= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1009:1: (otherlv_14= RULE_ID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1010:3: otherlv_14= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
                    	        }
                            
                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecInstance1818); 

                    		newLeafNode(otherlv_14, grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_2_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,10,FOLLOW_10_in_ruleFlowSpecInstance1832); 

                	newLeafNode(otherlv_15, grammarAccess.getFlowSpecInstanceAccess().getEndKeyword_9());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlowSpecInstance"


    // $ANTLR start "entryRuleEndToEndFlowInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1033:1: entryRuleEndToEndFlowInstance returns [EObject current=null] : iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF ;
    public final EObject entryRuleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndToEndFlowInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1034:2: (iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1035:2: iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF
            {
             newCompositeNode(grammarAccess.getEndToEndFlowInstanceRule()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance1868);
            iv_ruleEndToEndFlowInstance=ruleEndToEndFlowInstance();

            state._fsp--;

             current =iv_ruleEndToEndFlowInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndToEndFlowInstance1878); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1042:1: ruleEndToEndFlowInstance returns [EObject current=null] : (otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end' ) ;
    public final EObject ruleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1045:28: ( (otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1046:1: (otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1046:1: (otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1046:3: otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleEndToEndFlowInstance1915); 

                	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEtefKeyword_0());
                
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleEndToEndFlowInstance1927); 

                	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1054:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1055:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1055:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1056:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance1944); 

            			newLeafNode(lv_name_2_0, grammarAccess.getEndToEndFlowInstanceAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleEndToEndFlowInstance1961); 

                	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1076:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1077:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1077:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1078:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance1981); 

            		newLeafNode(otherlv_4, grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_4_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1089:2: ( ( ruleINSTANCEREF ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1090:1: ( ruleINSTANCEREF )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1090:1: ( ruleINSTANCEREF )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1091:3: ruleINSTANCEREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleEndToEndFlowInstance2004);
            	    ruleINSTANCEREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1104:3: (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==14) ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1==15) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1104:5: otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleEndToEndFlowInstance2018); 

                        	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0());
                        
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleEndToEndFlowInstance2030); 

                        	newLeafNode(otherlv_7, grammarAccess.getEndToEndFlowInstanceAccess().getModeKeyword_6_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1112:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1113:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1113:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1114:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceCrossReference_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleEndToEndFlowInstance2053);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1127:4: (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==14) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1127:6: otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) )
                    {
                    otherlv_9=(Token)match(input,14,FOLLOW_14_in_ruleEndToEndFlowInstance2068); 

                        	newLeafNode(otherlv_9, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleEndToEndFlowInstance2080); 

                        	newLeafNode(otherlv_10, grammarAccess.getEndToEndFlowInstanceAccess().getSomKeyword_7_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1135:1: ( ( ruleSOMID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1136:1: ( ruleSOMID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1136:1: ( ruleSOMID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1137:3: ruleSOMID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSOMID_in_ruleEndToEndFlowInstance2103);
                    ruleSOMID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,10,FOLLOW_10_in_ruleEndToEndFlowInstance2117); 

                	newLeafNode(otherlv_12, grammarAccess.getEndToEndFlowInstanceAccess().getEndKeyword_8());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1162:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1163:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1164:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode2153);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode2163); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1171:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= ruleSOMID ) ) ( ( ruleINSTANCEREF ) )* otherlv_3= 'end' ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1174:28: ( (otherlv_0= 'som' ( (lv_name_1_0= ruleSOMID ) ) ( ( ruleINSTANCEREF ) )* otherlv_3= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1175:1: (otherlv_0= 'som' ( (lv_name_1_0= ruleSOMID ) ) ( ( ruleINSTANCEREF ) )* otherlv_3= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1175:1: (otherlv_0= 'som' ( (lv_name_1_0= ruleSOMID ) ) ( ( ruleINSTANCEREF ) )* otherlv_3= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1175:3: otherlv_0= 'som' ( (lv_name_1_0= ruleSOMID ) ) ( ( ruleINSTANCEREF ) )* otherlv_3= 'end'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleSystemOperationMode2200); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1179:1: ( (lv_name_1_0= ruleSOMID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1180:1: (lv_name_1_0= ruleSOMID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1180:1: (lv_name_1_0= ruleSOMID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1181:3: lv_name_1_0= ruleSOMID
            {
             
            	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getNameSOMIDParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleSOMID_in_ruleSystemOperationMode2221);
            lv_name_1_0=ruleSOMID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSystemOperationModeRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"SOMID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1197:2: ( ( ruleINSTANCEREF ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1198:1: ( ruleINSTANCEREF )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1198:1: ( ruleINSTANCEREF )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1199:3: ruleINSTANCEREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getSystemOperationModeRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getSystemOperationModeAccess().getCurrentModeModeInstanceCrossReference_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleSystemOperationMode2244);
            	    ruleINSTANCEREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_3=(Token)match(input,10,FOLLOW_10_in_ruleSystemOperationMode2257); 

                	newLeafNode(otherlv_3, grammarAccess.getSystemOperationModeAccess().getEndKeyword_3());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleConnectionInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1224:1: entryRuleConnectionInstance returns [EObject current=null] : iv_ruleConnectionInstance= ruleConnectionInstance EOF ;
    public final EObject entryRuleConnectionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1225:2: (iv_ruleConnectionInstance= ruleConnectionInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1226:2: iv_ruleConnectionInstance= ruleConnectionInstance EOF
            {
             newCompositeNode(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance2293);
            iv_ruleConnectionInstance=ruleConnectionInstance();

            state._fsp--;

             current =iv_ruleConnectionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance2303); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1233:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end' ) ;
    public final EObject ruleConnectionInstance() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token lv_complete_15_0=null;
        Token lv_bidirectional_16_0=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_kind_0_0 = null;

        EObject lv_connectionReference_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1236:28: ( ( ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1237:1: ( ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1237:1: ( ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1237:2: ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1237:2: ( (lv_kind_0_0= ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1238:1: (lv_kind_0_0= ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1238:1: (lv_kind_0_0= ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1239:3: lv_kind_0_0= ruleConnectionKind
            {
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConnectionKind_in_ruleConnectionInstance2349);
            lv_kind_0_0=ruleConnectionKind();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	        }
                   		set(
                   			current, 
                   			"kind",
                    		lv_kind_0_0, 
                    		"ConnectionKind");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,23,FOLLOW_23_in_ruleConnectionInstance2361); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionInstanceAccess().getConnectionKeyword_1());
                
            otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleConnectionInstance2373); 

                	newLeafNode(otherlv_2, grammarAccess.getConnectionInstanceAccess().getInstanceKeyword_2());
                
            otherlv_3=(Token)match(input,9,FOLLOW_9_in_ruleConnectionInstance2385); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1267:1: ( (lv_connectionReference_4_0= ruleConnectionReference ) )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==9) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1268:1: (lv_connectionReference_4_0= ruleConnectionReference )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1268:1: (lv_connectionReference_4_0= ruleConnectionReference )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1269:3: lv_connectionReference_4_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionReference_in_ruleConnectionInstance2406);
            	    lv_connectionReference_4_0=ruleConnectionReference();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConnectionInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"connectionReference",
            	            		lv_connectionReference_4_0, 
            	            		"ConnectionReference");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleConnectionInstance2419); 

                	newLeafNode(otherlv_5, grammarAccess.getConnectionInstanceAccess().getSrcKeyword_5());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1289:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1290:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1290:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1291:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2442);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleConnectionInstance2454); 

                	newLeafNode(otherlv_7, grammarAccess.getConnectionInstanceAccess().getDstKeyword_7());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1308:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1309:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1309:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1310:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2477);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1323:2: (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==14) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==22) ) {
                    alt30=1;
                }
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1323:4: otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) )
                    {
                    otherlv_9=(Token)match(input,14,FOLLOW_14_in_ruleConnectionInstance2490); 

                        	newLeafNode(otherlv_9, grammarAccess.getConnectionInstanceAccess().getInKeyword_9_0());
                        
                    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance2502); 

                        	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getSomKeyword_9_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1331:1: ( ( ruleSOMID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1332:1: ( ruleSOMID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1332:1: ( ruleSOMID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1333:3: ruleSOMID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_9_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSOMID_in_ruleConnectionInstance2525);
                    ruleSOMID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1346:4: (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==14) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1346:6: otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleConnectionInstance2540); 

                        	newLeafNode(otherlv_12, grammarAccess.getConnectionInstanceAccess().getInKeyword_10_0());
                        
                    otherlv_13=(Token)match(input,17,FOLLOW_17_in_ruleConnectionInstance2552); 

                        	newLeafNode(otherlv_13, grammarAccess.getConnectionInstanceAccess().getTransitionKeyword_10_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1354:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1355:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1355:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1356:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_10_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2575);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1369:4: ( (lv_complete_15_0= 'complete' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==24) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1370:1: (lv_complete_15_0= 'complete' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1370:1: (lv_complete_15_0= 'complete' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1371:3: lv_complete_15_0= 'complete'
                    {
                    lv_complete_15_0=(Token)match(input,24,FOLLOW_24_in_ruleConnectionInstance2595); 

                            newLeafNode(lv_complete_15_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "complete", true, "complete");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1384:3: ( (lv_bidirectional_16_0= 'bidirectional' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==25) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1385:1: (lv_bidirectional_16_0= 'bidirectional' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1385:1: (lv_bidirectional_16_0= 'bidirectional' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1386:3: lv_bidirectional_16_0= 'bidirectional'
                    {
                    lv_bidirectional_16_0=(Token)match(input,25,FOLLOW_25_in_ruleConnectionInstance2627); 

                            newLeafNode(lv_bidirectional_16_0, grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "bidirectional", true, "bidirectional");
                    	    

                    }


                    }
                    break;

            }

            otherlv_17=(Token)match(input,10,FOLLOW_10_in_ruleConnectionInstance2653); 

                	newLeafNode(otherlv_17, grammarAccess.getConnectionInstanceAccess().getEndKeyword_13());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1411:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1412:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1413:2: iv_ruleConnectionReference= ruleConnectionReference EOF
            {
             newCompositeNode(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference2689);
            iv_ruleConnectionReference=ruleConnectionReference();

            state._fsp--;

             current =iv_ruleConnectionReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference2699); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1420:1: ruleConnectionReference returns [EObject current=null] : (otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1423:28: ( (otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1424:1: (otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1424:1: (otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1424:3: otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) )
            {
            otherlv_0=(Token)match(input,9,FOLLOW_9_in_ruleConnectionReference2736); 

                	newLeafNode(otherlv_0, grammarAccess.getConnectionReferenceAccess().getOfKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1428:1: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1429:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1429:1: (otherlv_1= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1430:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionReference2756); 

            		newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleConnectionReference2768); 

                	newLeafNode(otherlv_2, grammarAccess.getConnectionReferenceAccess().getSrcKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1445:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1446:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1446:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1447:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2791);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleConnectionReference2803); 

                	newLeafNode(otherlv_4, grammarAccess.getConnectionReferenceAccess().getDstKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1464:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1465:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1465:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1466:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2826);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleConnectionReference2838); 

                	newLeafNode(otherlv_6, grammarAccess.getConnectionReferenceAccess().getContextKeyword_6());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1483:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1484:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1484:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1485:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2861);
            ruleINSTANCEREF();

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


    // $ANTLR start "entryRuleComponentCategory"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1506:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1507:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1508:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory2898);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory2909); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1515:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | kw= 'threadgroup' | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | kw= 'virtualprocessor' ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1518:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | kw= 'threadgroup' | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | kw= 'virtualprocessor' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1519:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | kw= 'threadgroup' | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | kw= 'virtualprocessor' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1519:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | kw= 'threadgroup' | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | kw= 'virtualprocessor' )
            int alt34=14;
            alt34 = dfa34.predict(input);
            switch (alt34) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1520:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleComponentCategory2947); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1527:2: kw= 'bus'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleComponentCategory2966); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1534:2: kw= 'data'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleComponentCategory2985); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1541:2: kw= 'device'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleComponentCategory3004); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1548:2: kw= 'memory'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleComponentCategory3023); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1555:2: kw= 'process'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleComponentCategory3042); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1562:2: kw= 'processor'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleComponentCategory3061); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1569:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleComponentCategory3080); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1575:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1575:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1576:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleComponentCategory3100); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleComponentCategory3113); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1589:2: kw= 'system'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleComponentCategory3133); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1596:2: kw= 'threadgroup'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleComponentCategory3152); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadgroupKeyword_10()); 
                        

                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1603:2: kw= 'thread'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleComponentCategory3171); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1609:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1609:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1610:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleComponentCategory3191); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleComponentCategory3204); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1623:2: kw= 'virtualprocessor'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleComponentCategory3224); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualprocessorKeyword_13()); 
                        

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


    // $ANTLR start "entryRuleFeatureCategory"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1636:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1637:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1638:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory3265);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory3276); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1645:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'eventport' | kw= 'dataport' | kw= 'eventdataport' | kw= 'parameter' | kw= 'busaccess' | kw= 'dataaccess' | kw= 'subprogramaccess' | kw= 'subprogramgroupaccess' | kw= 'featuregroup' | kw= 'abstractfeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1648:28: ( (kw= 'eventport' | kw= 'dataport' | kw= 'eventdataport' | kw= 'parameter' | kw= 'busaccess' | kw= 'dataaccess' | kw= 'subprogramaccess' | kw= 'subprogramgroupaccess' | kw= 'featuregroup' | kw= 'abstractfeature' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1649:1: (kw= 'eventport' | kw= 'dataport' | kw= 'eventdataport' | kw= 'parameter' | kw= 'busaccess' | kw= 'dataaccess' | kw= 'subprogramaccess' | kw= 'subprogramgroupaccess' | kw= 'featuregroup' | kw= 'abstractfeature' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1649:1: (kw= 'eventport' | kw= 'dataport' | kw= 'eventdataport' | kw= 'parameter' | kw= 'busaccess' | kw= 'dataaccess' | kw= 'subprogramaccess' | kw= 'subprogramgroupaccess' | kw= 'featuregroup' | kw= 'abstractfeature' )
            int alt35=10;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt35=1;
                }
                break;
            case 42:
                {
                alt35=2;
                }
                break;
            case 43:
                {
                alt35=3;
                }
                break;
            case 44:
                {
                alt35=4;
                }
                break;
            case 45:
                {
                alt35=5;
                }
                break;
            case 46:
                {
                alt35=6;
                }
                break;
            case 47:
                {
                alt35=7;
                }
                break;
            case 48:
                {
                alt35=8;
                }
                break;
            case 49:
                {
                alt35=9;
                }
                break;
            case 50:
                {
                alt35=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1650:2: kw= 'eventport'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleFeatureCategory3314); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventportKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1657:2: kw= 'dataport'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleFeatureCategory3333); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataportKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1664:2: kw= 'eventdataport'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleFeatureCategory3352); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventdataportKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1671:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleFeatureCategory3371); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1678:2: kw= 'busaccess'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleFeatureCategory3390); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusaccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1685:2: kw= 'dataaccess'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleFeatureCategory3409); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataaccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1692:2: kw= 'subprogramaccess'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleFeatureCategory3428); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramaccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1699:2: kw= 'subprogramgroupaccess'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleFeatureCategory3447); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramgroupaccessKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1706:2: kw= 'featuregroup'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleFeatureCategory3466); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeaturegroupKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1713:2: kw= 'abstractfeature'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleFeatureCategory3485); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getAbstractfeatureKeyword_9()); 
                        

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


    // $ANTLR start "entryRuleDirectionType"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1726:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1727:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1728:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType3526);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType3537); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1735:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1738:28: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1739:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1739:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt36=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt36=1;
                }
                break;
            case 51:
                {
                alt36=2;
                }
                break;
            case 52:
                {
                alt36=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1740:2: kw= 'in'
                    {
                    kw=(Token)match(input,14,FOLLOW_14_in_ruleDirectionType3575); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1747:2: kw= 'out'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleDirectionType3594); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1754:2: kw= 'inout'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleDirectionType3613); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInoutKeyword_2()); 
                        

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


    // $ANTLR start "entryRuleConnectionKind"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1767:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1768:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1769:2: iv_ruleConnectionKind= ruleConnectionKind EOF
            {
             newCompositeNode(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind3654);
            iv_ruleConnectionKind=ruleConnectionKind();

            state._fsp--;

             current =iv_ruleConnectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind3665); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1776:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'feature' | kw= 'access' | kw= 'parameter' | kw= 'port' | kw= 'modetransition' | kw= 'featuregroup' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1779:28: ( (kw= 'feature' | kw= 'access' | kw= 'parameter' | kw= 'port' | kw= 'modetransition' | kw= 'featuregroup' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1780:1: (kw= 'feature' | kw= 'access' | kw= 'parameter' | kw= 'port' | kw= 'modetransition' | kw= 'featuregroup' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1780:1: (kw= 'feature' | kw= 'access' | kw= 'parameter' | kw= 'port' | kw= 'modetransition' | kw= 'featuregroup' )
            int alt37=6;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt37=1;
                }
                break;
            case 54:
                {
                alt37=2;
                }
                break;
            case 44:
                {
                alt37=3;
                }
                break;
            case 55:
                {
                alt37=4;
                }
                break;
            case 56:
                {
                alt37=5;
                }
                break;
            case 49:
                {
                alt37=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1781:2: kw= 'feature'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleConnectionKind3703); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1788:2: kw= 'access'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleConnectionKind3722); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1795:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleConnectionKind3741); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1802:2: kw= 'port'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleConnectionKind3760); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1809:2: kw= 'modetransition'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleConnectionKind3779); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getModetransitionKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1816:2: kw= 'featuregroup'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleConnectionKind3798); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeaturegroupKeyword_5()); 
                        

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


    // $ANTLR start "entryRuleFQCREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1829:1: entryRuleFQCREF returns [String current=null] : iv_ruleFQCREF= ruleFQCREF EOF ;
    public final String entryRuleFQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1830:2: (iv_ruleFQCREF= ruleFQCREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1831:2: iv_ruleFQCREF= ruleFQCREF EOF
            {
             newCompositeNode(grammarAccess.getFQCREFRule()); 
            pushFollow(FOLLOW_ruleFQCREF_in_entryRuleFQCREF3839);
            iv_ruleFQCREF=ruleFQCREF();

            state._fsp--;

             current =iv_ruleFQCREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQCREF3850); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFQCREF"


    // $ANTLR start "ruleFQCREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1838:1: ruleFQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleFQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1841:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1842:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1842:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1842:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1842:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    int LA38_1 = input.LA(2);

                    if ( (LA38_1==57) ) {
                        alt38=1;
                    }


                }


                switch (alt38) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1842:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQCREF3891); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,57,FOLLOW_57_in_ruleFQCREF3909); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQCREFAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQCREF3926); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1862:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==58) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1863:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleFQCREF3945); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFQCREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQCREF3960); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_2_1()); 
                        

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
    // $ANTLR end "ruleFQCREF"


    // $ANTLR start "entryRuleINSTANCEREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1883:1: entryRuleINSTANCEREF returns [String current=null] : iv_ruleINSTANCEREF= ruleINSTANCEREF EOF ;
    public final String entryRuleINSTANCEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINSTANCEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1884:2: (iv_ruleINSTANCEREF= ruleINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1885:2: iv_ruleINSTANCEREF= ruleINSTANCEREF EOF
            {
             newCompositeNode(grammarAccess.getINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF4008);
            iv_ruleINSTANCEREF=ruleINSTANCEREF();

            state._fsp--;

             current =iv_ruleINSTANCEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREF4019); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1892:1: ruleINSTANCEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleINSTANCEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1895:28: ( ( (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1896:1: ( (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1896:1: ( (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1896:2: (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1896:2: (this_ID_0= RULE_ID kw= '.' )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_ID) ) {
                    int LA40_1 = input.LA(2);

                    if ( (LA40_1==58) ) {
                        alt40=1;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1896:7: this_ID_0= RULE_ID kw= '.'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF4060); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,58,FOLLOW_58_in_ruleINSTANCEREF4078); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF4095); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleSOMID"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1924:1: entryRuleSOMID returns [String current=null] : iv_ruleSOMID= ruleSOMID EOF ;
    public final String entryRuleSOMID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSOMID = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1925:2: (iv_ruleSOMID= ruleSOMID EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1926:2: iv_ruleSOMID= ruleSOMID EOF
            {
             newCompositeNode(grammarAccess.getSOMIDRule()); 
            pushFollow(FOLLOW_ruleSOMID_in_entryRuleSOMID4141);
            iv_ruleSOMID=ruleSOMID();

            state._fsp--;

             current =iv_ruleSOMID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSOMID4152); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSOMID"


    // $ANTLR start "ruleSOMID"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1933:1: ruleSOMID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF ) ;
    public final AntlrDatatypeRuleToken ruleSOMID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_INSTANCEREF_0 = null;

        AntlrDatatypeRuleToken this_INSTANCEREF_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1936:28: ( ( (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1937:1: ( (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1937:1: ( (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1937:2: (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1937:2: (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )*
            loop41:
            do {
                int alt41=2;
                alt41 = dfa41.predict(input);
                switch (alt41) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1938:5: this_INSTANCEREF_0= ruleINSTANCEREF kw= '#'
            	    {
            	     
            	            newCompositeNode(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_0_0()); 
            	        
            	    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleSOMID4200);
            	    this_INSTANCEREF_0=ruleINSTANCEREF();

            	    state._fsp--;


            	    		current.merge(this_INSTANCEREF_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    kw=(Token)match(input,59,FOLLOW_59_in_ruleSOMID4218); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSOMIDAccess().getNumberSignKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleSOMID4242);
            this_INSTANCEREF_2=ruleINSTANCEREF();

            state._fsp--;


            		current.merge(this_INSTANCEREF_2);
                
             
                    afterParserOrEnumRuleCall();
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSOMID"


    // $ANTLR start "entryRuleINTVALUE"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1973:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1974:2: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1975:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
             newCompositeNode(grammarAccess.getINTVALUERule()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE4288);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;

             current =iv_ruleINTVALUE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTVALUE4299); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1982:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1985:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1986:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE4338); 

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

    // Delegated rules


    protected DFA34 dfa34 = new DFA34(this);
    protected DFA41 dfa41 = new DFA41(this);
    static final String DFA34_eotS =
        "\20\uffff";
    static final String DFA34_eofS =
        "\10\uffff\1\16\7\uffff";
    static final String DFA34_minS =
        "\1\33\7\uffff\1\11\7\uffff";
    static final String DFA34_maxS =
        "\1\50\7\uffff\1\43\7\uffff";
    static final String DFA34_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\1\13\1\14\1\15\1\16\1\10\1\11";
    static final String DFA34_specialS =
        "\20\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13\1\14\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\1\16\27\uffff\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "1519:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | kw= 'threadgroup' | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | kw= 'virtualprocessor' )";
        }
    }
    static final String DFA41_eotS =
        "\5\uffff";
    static final String DFA41_eofS =
        "\1\uffff\1\2\3\uffff";
    static final String DFA41_minS =
        "\2\4\1\uffff\1\4\1\uffff";
    static final String DFA41_maxS =
        "\1\4\1\73\1\uffff\1\4\1\uffff";
    static final String DFA41_acceptS =
        "\2\uffff\1\2\1\uffff\1\1";
    static final String DFA41_specialS =
        "\5\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\1",
            "\1\2\5\uffff\1\2\3\uffff\1\2\11\uffff\2\2\40\uffff\1\3\1\4",
            "",
            "\1\1",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "()* loopback of 1937:2: (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_ruleSystemInstance122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemInstance139 = new BitSet(new long[]{0x000001F7F8000000L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleSystemInstance165 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleSystemInstance177 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQCREF_in_ruleSystemInstance200 = new BitSet(new long[]{0x01E7FFF7F8708400L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleSystemInstance221 = new BitSet(new long[]{0x01E7FFF7F8708400L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleSystemInstance243 = new BitSet(new long[]{0x01E211F7F8708400L});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleSystemInstance265 = new BitSet(new long[]{0x01E2100000708400L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_ruleSystemInstance287 = new BitSet(new long[]{0x01E2100000708400L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_ruleSystemInstance309 = new BitSet(new long[]{0x01E2100000700400L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleSystemInstance331 = new BitSet(new long[]{0x01E2100000600400L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleSystemInstance353 = new BitSet(new long[]{0x01E2100000400400L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance375 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_10_in_ruleSystemInstance388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleComponentInstance480 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleComponentInstance492 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance509 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleComponentInstance527 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_ruleComponentInstance548 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_13_in_ruleComponentInstance561 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleComponentInstance575 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance595 = new BitSet(new long[]{0x01E7FFF7F830C400L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleComponentInstance616 = new BitSet(new long[]{0x01E7FFF7F830C400L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleComponentInstance638 = new BitSet(new long[]{0x01E211F7F830C400L});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleComponentInstance660 = new BitSet(new long[]{0x01E210000030C400L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance682 = new BitSet(new long[]{0x01E210000030C400L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_ruleComponentInstance704 = new BitSet(new long[]{0x01E2100000304400L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance726 = new BitSet(new long[]{0x01E2100000204400L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleComponentInstance748 = new BitSet(new long[]{0x01E2100000004400L});
    public static final BitSet FOLLOW_14_in_ruleComponentInstance762 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance774 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance794 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleComponentInstance808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance844 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance900 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleFeatureInstance912 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance929 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleFeatureInstance947 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_ruleFeatureInstance968 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFeatureInstance980 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFeatureInstance994 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance1014 = new BitSet(new long[]{0x0018000000004000L});
    public static final BitSet FOLLOW_ruleDirectionType_in_ruleFeatureInstance1035 = new BitSet(new long[]{0x0007FE0000000000L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance1056 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleFeatureInstance1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_entryRuleModeInstance1104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeInstance1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleModeInstance1151 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleModeInstance1163 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance1180 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleModeInstance1197 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance1217 = new BitSet(new long[]{0x0000000000010400L});
    public static final BitSet FOLLOW_16_in_ruleModeInstance1235 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleModeInstance1261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance1297 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransitionInstance1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleModeTransitionInstance1344 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModeTransitionInstance1356 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleModeTransitionInstance1368 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance1385 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleModeTransitionInstance1402 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance1422 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModeTransitionInstance1434 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance1454 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleModeTransitionInstance1466 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance1486 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleModeTransitionInstance1498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_entryRuleFlowSpecInstance1534 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecInstance1544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFlowSpecInstance1581 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleFlowSpecInstance1593 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecInstance1610 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFlowSpecInstance1627 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecInstance1647 = new BitSet(new long[]{0x00000000000C4400L});
    public static final BitSet FOLLOW_18_in_ruleFlowSpecInstance1660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1683 = new BitSet(new long[]{0x0000000000084400L});
    public static final BitSet FOLLOW_19_in_ruleFlowSpecInstance1698 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1721 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_14_in_ruleFlowSpecInstance1736 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFlowSpecInstance1748 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1771 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_14_in_ruleFlowSpecInstance1786 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleFlowSpecInstance1798 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecInstance1818 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleFlowSpecInstance1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance1868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndToEndFlowInstance1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleEndToEndFlowInstance1915 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleEndToEndFlowInstance1927 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance1944 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleEndToEndFlowInstance1961 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance1981 = new BitSet(new long[]{0x0000000000004410L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleEndToEndFlowInstance2004 = new BitSet(new long[]{0x0000000000004410L});
    public static final BitSet FOLLOW_14_in_ruleEndToEndFlowInstance2018 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEndToEndFlowInstance2030 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleEndToEndFlowInstance2053 = new BitSet(new long[]{0x0000000000004400L});
    public static final BitSet FOLLOW_14_in_ruleEndToEndFlowInstance2068 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleEndToEndFlowInstance2080 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSOMID_in_ruleEndToEndFlowInstance2103 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleEndToEndFlowInstance2117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode2153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleSystemOperationMode2200 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSOMID_in_ruleSystemOperationMode2221 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleSystemOperationMode2244 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_10_in_ruleSystemOperationMode2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance2293 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_ruleConnectionInstance2349 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleConnectionInstance2361 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleConnectionInstance2373 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleConnectionInstance2385 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_ruleConnectionInstance2406 = new BitSet(new long[]{0x0000000000040200L});
    public static final BitSet FOLLOW_18_in_ruleConnectionInstance2419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2442 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleConnectionInstance2454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2477 = new BitSet(new long[]{0x0000000003004400L});
    public static final BitSet FOLLOW_14_in_ruleConnectionInstance2490 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance2502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSOMID_in_ruleConnectionInstance2525 = new BitSet(new long[]{0x0000000003004400L});
    public static final BitSet FOLLOW_14_in_ruleConnectionInstance2540 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleConnectionInstance2552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2575 = new BitSet(new long[]{0x0000000003000400L});
    public static final BitSet FOLLOW_24_in_ruleConnectionInstance2595 = new BitSet(new long[]{0x0000000002000400L});
    public static final BitSet FOLLOW_25_in_ruleConnectionInstance2627 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleConnectionInstance2653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference2689 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_9_in_ruleConnectionReference2736 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionReference2756 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleConnectionReference2768 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2791 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleConnectionReference2803 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2826 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleConnectionReference2838 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory2898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory2909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleComponentCategory2947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleComponentCategory2966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleComponentCategory2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleComponentCategory3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleComponentCategory3023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleComponentCategory3042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleComponentCategory3061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleComponentCategory3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleComponentCategory3100 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleComponentCategory3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComponentCategory3133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleComponentCategory3152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleComponentCategory3171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleComponentCategory3191 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleComponentCategory3204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleComponentCategory3224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory3265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory3276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleFeatureCategory3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleFeatureCategory3333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleFeatureCategory3352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFeatureCategory3371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFeatureCategory3390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleFeatureCategory3409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFeatureCategory3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleFeatureCategory3447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleFeatureCategory3466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleFeatureCategory3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType3526 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType3537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleDirectionType3575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleDirectionType3594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleDirectionType3613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind3654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleConnectionKind3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleConnectionKind3722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleConnectionKind3741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleConnectionKind3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleConnectionKind3779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleConnectionKind3798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQCREF_in_entryRuleFQCREF3839 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQCREF3850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF3891 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleFQCREF3909 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF3926 = new BitSet(new long[]{0x0400000000000002L});
    public static final BitSet FOLLOW_58_in_ruleFQCREF3945 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF3960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF4008 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREF4019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF4060 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleINSTANCEREF4078 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF4095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_entryRuleSOMID4141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSOMID4152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleSOMID4200 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleSOMID4218 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleSOMID4242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE4288 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTVALUE4299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE4338 = new BitSet(new long[]{0x0000000000000002L});

}