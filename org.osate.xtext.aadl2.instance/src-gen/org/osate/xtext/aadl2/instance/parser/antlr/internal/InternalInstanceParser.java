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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INTEGER_LIT", "RULE_SL_COMMENT", "RULE_WS", "':'", "'{'", "'}'", "'instance'", "'['", "']'", "'of'", "'in'", "'mode'", "'end'", "'initial'", "'transition'", "'src'", "'dst'", "'flowspec'", "'etef'", "'som'", "'connection'", "'complete'", "'bidirectional'", "'context'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'eventport'", "'dataport'", "'eventdataport'", "'parameter'", "'busaccess'", "'dataaccess'", "'subprogramaccess'", "'subprogramgroupaccess'", "'featuregroup'", "'abstractfeature'", "'out'", "'inout'", "'feature'", "'access'", "'port'", "'modetransition'", "'::'", "'.'", "'#'"
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
    public static final int RULE_INTEGER_LIT=6;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:76:1: ruleSystemInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQCREF ) ) otherlv_4= '{' ( (lv_systemOperationMode_5_0= ruleSystemOperationMode ) )* otherlv_6= '}' ) ;
    public final EObject ruleSystemInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_systemOperationMode_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:79:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQCREF ) ) otherlv_4= '{' ( (lv_systemOperationMode_5_0= ruleSystemOperationMode ) )* otherlv_6= '}' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQCREF ) ) otherlv_4= '{' ( (lv_systemOperationMode_5_0= ruleSystemOperationMode ) )* otherlv_6= '}' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQCREF ) ) otherlv_4= '{' ( (lv_systemOperationMode_5_0= ruleSystemOperationMode ) )* otherlv_6= '}' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleFQCREF ) ) otherlv_4= '{' ( (lv_systemOperationMode_5_0= ruleSystemOperationMode ) )* otherlv_6= '}'
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
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:120:1: ( ( ruleFQCREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:121:1: ( ruleFQCREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:121:1: ( ruleFQCREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:122:3: ruleFQCREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getComponentImplementationComponentImplementationCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleFQCREF_in_ruleSystemInstance188);
            ruleFQCREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,10,FOLLOW_10_in_ruleSystemInstance200); 

                	newLeafNode(otherlv_4, grammarAccess.getSystemInstanceAccess().getLeftCurlyBracketKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:139:1: ( (lv_systemOperationMode_5_0= ruleSystemOperationMode ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==25) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:140:1: (lv_systemOperationMode_5_0= ruleSystemOperationMode )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:140:1: (lv_systemOperationMode_5_0= ruleSystemOperationMode )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:141:3: lv_systemOperationMode_5_0= ruleSystemOperationMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance221);
            	    lv_systemOperationMode_5_0=ruleSystemOperationMode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systemOperationMode",
            	            		lv_systemOperationMode_5_0, 
            	            		"SystemOperationMode");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_6=(Token)match(input,11,FOLLOW_11_in_ruleSystemInstance234); 

                	newLeafNode(otherlv_6, grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:169:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:170:2: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:171:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance270);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance280); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:178:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end' ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:181:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:182:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:182:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:182:2: ( (lv_category_0_0= ruleComponentCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_featureInstance_8_0= ruleFeatureInstance ) )* ( (lv_componentInstance_9_0= ruleComponentInstance ) )* ( (lv_modeInstance_10_0= ruleModeInstance ) )* ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )* ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )* ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )* ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )* (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )? otherlv_18= 'end'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:182:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:183:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:183:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:184:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleComponentInstance326);
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

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleComponentInstance338); 

                	newLeafNode(otherlv_1, grammarAccess.getComponentInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:204:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:205:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:205:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:206:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance355); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:222:2: (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:222:4: otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) )+ otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleComponentInstance373); 

                        	newLeafNode(otherlv_3, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:226:1: ( (lv_index_4_0= ruleINTVALUE ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_INTEGER_LIT) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:227:1: (lv_index_4_0= ruleINTVALUE )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:227:1: (lv_index_4_0= ruleINTVALUE )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:228:3: lv_index_4_0= ruleINTVALUE
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleINTVALUE_in_ruleComponentInstance394);
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
                    	    if ( cnt2 >= 1 ) break loop2;
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleComponentInstance407); 

                        	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleComponentInstance421); 

                	newLeafNode(otherlv_6, grammarAccess.getComponentInstanceAccess().getOfKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:252:1: ( (otherlv_7= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:253:1: (otherlv_7= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:253:1: (otherlv_7= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:254:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance441); 

            		newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_5_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:265:2: ( (lv_featureInstance_8_0= ruleFeatureInstance ) )*
            loop4:
            do {
                int alt4=2;
                switch ( input.LA(1) ) {
                case 45:
                    {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==12) ) {
                        alt4=1;
                    }


                    }
                    break;
                case 50:
                    {
                    int LA4_3 = input.LA(2);

                    if ( (LA4_3==12) ) {
                        alt4=1;
                    }


                    }
                    break;
                case 42:
                case 43:
                case 44:
                case 46:
                case 47:
                case 48:
                case 49:
                case 51:
                    {
                    alt4=1;
                    }
                    break;

                }

                switch (alt4) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:266:1: (lv_featureInstance_8_0= ruleFeatureInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:266:1: (lv_featureInstance_8_0= ruleFeatureInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:267:3: lv_featureInstance_8_0= ruleFeatureInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleComponentInstance462);
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
            	    break loop4;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:283:3: ( (lv_componentInstance_9_0= ruleComponentInstance ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=30 && LA5_0<=37)||(LA5_0>=39 && LA5_0<=41)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:284:1: (lv_componentInstance_9_0= ruleComponentInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:284:1: (lv_componentInstance_9_0= ruleComponentInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:285:3: lv_componentInstance_9_0= ruleComponentInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_7_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleComponentInstance484);
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
            	    break loop5;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:301:3: ( (lv_modeInstance_10_0= ruleModeInstance ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1==12) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:302:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:302:1: (lv_modeInstance_10_0= ruleModeInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:303:3: lv_modeInstance_10_0= ruleModeInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeInstanceModeInstanceParserRuleCall_8_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModeInstance_in_ruleComponentInstance506);
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
            	    break loop6;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:319:3: ( (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==17) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:320:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:320:1: (lv_modeTransitionInstance_11_0= ruleModeTransitionInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:321:3: lv_modeTransitionInstance_11_0= ruleModeTransitionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getModeTransitionInstanceModeTransitionInstanceParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance528);
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
            	    break loop7;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:337:3: ( (lv_flowSpecification_12_0= ruleFlowSpecInstance ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==23) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:338:1: (lv_flowSpecification_12_0= ruleFlowSpecInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:338:1: (lv_flowSpecification_12_0= ruleFlowSpecInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:339:3: lv_flowSpecification_12_0= ruleFlowSpecInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFlowSpecificationFlowSpecInstanceParserRuleCall_10_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFlowSpecInstance_in_ruleComponentInstance550);
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
            	    break loop8;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:355:3: ( (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:356:1: (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:356:1: (lv_endToEndFlow_13_0= ruleEndToEndFlowInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:357:3: lv_endToEndFlow_13_0= ruleEndToEndFlowInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getEndToEndFlowEndToEndFlowInstanceParserRuleCall_11_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance572);
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
            	    break loop9;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:373:3: ( (lv_connectionInstance_14_0= ruleConnectionInstance ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==45||LA10_0==50||(LA10_0>=54 && LA10_0<=57)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:374:1: (lv_connectionInstance_14_0= ruleConnectionInstance )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:374:1: (lv_connectionInstance_14_0= ruleConnectionInstance )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:375:3: lv_connectionInstance_14_0= ruleConnectionInstance
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getConnectionInstanceConnectionInstanceParserRuleCall_12_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionInstance_in_ruleComponentInstance594);
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
            	    break loop10;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:391:3: (otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:391:5: otherlv_15= 'in' otherlv_16= 'mode' ( (otherlv_17= RULE_ID ) )
                    {
                    otherlv_15=(Token)match(input,16,FOLLOW_16_in_ruleComponentInstance608); 

                        	newLeafNode(otherlv_15, grammarAccess.getComponentInstanceAccess().getInKeyword_13_0());
                        
                    otherlv_16=(Token)match(input,17,FOLLOW_17_in_ruleComponentInstance620); 

                        	newLeafNode(otherlv_16, grammarAccess.getComponentInstanceAccess().getModeKeyword_13_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:399:1: ( (otherlv_17= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:400:1: (otherlv_17= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:400:1: (otherlv_17= RULE_ID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:401:3: otherlv_17= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getComponentInstanceRule());
                    	        }
                            
                    otherlv_17=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance640); 

                    		newLeafNode(otherlv_17, grammarAccess.getComponentInstanceAccess().getInModeModeInstanceCrossReference_13_2_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_18=(Token)match(input,18,FOLLOW_18_in_ruleComponentInstance654); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:424:1: entryRuleFeatureInstance returns [EObject current=null] : iv_ruleFeatureInstance= ruleFeatureInstance EOF ;
    public final EObject entryRuleFeatureInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:425:2: (iv_ruleFeatureInstance= ruleFeatureInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:426:2: iv_ruleFeatureInstance= ruleFeatureInstance EOF
            {
             newCompositeNode(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance690);
            iv_ruleFeatureInstance=ruleFeatureInstance();

            state._fsp--;

             current =iv_ruleFeatureInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance700); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:433:1: ruleFeatureInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end' ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:436:28: ( ( ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:437:1: ( ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:437:1: ( ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:437:2: ( (lv_category_0_0= ruleFeatureCategory ) ) otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )? otherlv_6= 'of' ( (otherlv_7= RULE_ID ) ) ( (lv_direction_8_0= ruleDirectionType ) ) ( (lv_featureInstance_9_0= ruleFeatureInstance ) ) otherlv_10= 'end'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:437:2: ( (lv_category_0_0= ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:438:1: (lv_category_0_0= ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:438:1: (lv_category_0_0= ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:439:3: lv_category_0_0= ruleFeatureCategory
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance746);
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

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleFeatureInstance758); 

                	newLeafNode(otherlv_1, grammarAccess.getFeatureInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:459:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:460:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:460:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:461:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance775); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:477:2: (otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==13) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:477:4: otherlv_3= '[' ( (lv_index_4_0= ruleINTVALUE ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleFeatureInstance793); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:481:1: ( (lv_index_4_0= ruleINTVALUE ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:482:1: (lv_index_4_0= ruleINTVALUE )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:482:1: (lv_index_4_0= ruleINTVALUE )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:483:3: lv_index_4_0= ruleINTVALUE
                    {
                     
                    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getIndexINTVALUEParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINTVALUE_in_ruleFeatureInstance814);
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

                    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleFeatureInstance826); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleFeatureInstance840); 

                	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getOfKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:507:1: ( (otherlv_7= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:508:1: (otherlv_7= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:508:1: (otherlv_7= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:509:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance860); 

            		newLeafNode(otherlv_7, grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:520:2: ( (lv_direction_8_0= ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:521:1: (lv_direction_8_0= ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:521:1: (lv_direction_8_0= ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:522:3: lv_direction_8_0= ruleDirectionType
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleDirectionType_in_ruleFeatureInstance881);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:538:2: ( (lv_featureInstance_9_0= ruleFeatureInstance ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:539:1: (lv_featureInstance_9_0= ruleFeatureInstance )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:539:1: (lv_featureInstance_9_0= ruleFeatureInstance )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:540:3: lv_featureInstance_9_0= ruleFeatureInstance
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance902);
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

            otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleFeatureInstance914); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:568:1: entryRuleModeInstance returns [EObject current=null] : iv_ruleModeInstance= ruleModeInstance EOF ;
    public final EObject entryRuleModeInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:569:2: (iv_ruleModeInstance= ruleModeInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:570:2: iv_ruleModeInstance= ruleModeInstance EOF
            {
             newCompositeNode(grammarAccess.getModeInstanceRule()); 
            pushFollow(FOLLOW_ruleModeInstance_in_entryRuleModeInstance950);
            iv_ruleModeInstance=ruleModeInstance();

            state._fsp--;

             current =iv_ruleModeInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeInstance960); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:577:1: ruleModeInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end' ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:580:28: ( (otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:581:1: (otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:581:1: (otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:581:3: otherlv_0= 'mode' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( (lv_initial_5_0= 'initial' ) )? otherlv_6= 'end'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleModeInstance997); 

                	newLeafNode(otherlv_0, grammarAccess.getModeInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleModeInstance1009); 

                	newLeafNode(otherlv_1, grammarAccess.getModeInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:589:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:590:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:590:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:591:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance1026); 

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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleModeInstance1043); 

                	newLeafNode(otherlv_3, grammarAccess.getModeInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:611:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:612:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:612:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:613:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeInstanceRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeInstance1063); 

            		newLeafNode(otherlv_4, grammarAccess.getModeInstanceAccess().getModeModeCrossReference_4_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:624:2: ( (lv_initial_5_0= 'initial' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:625:1: (lv_initial_5_0= 'initial' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:625:1: (lv_initial_5_0= 'initial' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:626:3: lv_initial_5_0= 'initial'
                    {
                    lv_initial_5_0=(Token)match(input,19,FOLLOW_19_in_ruleModeInstance1081); 

                            newLeafNode(lv_initial_5_0, grammarAccess.getModeInstanceAccess().getInitialInitialKeyword_5_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModeInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "initial", true, "initial");
                    	    

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleModeInstance1107); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:651:1: entryRuleModeTransitionInstance returns [EObject current=null] : iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF ;
    public final EObject entryRuleModeTransitionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModeTransitionInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:652:2: (iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:653:2: iv_ruleModeTransitionInstance= ruleModeTransitionInstance EOF
            {
             newCompositeNode(grammarAccess.getModeTransitionInstanceRule()); 
            pushFollow(FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance1143);
            iv_ruleModeTransitionInstance=ruleModeTransitionInstance();

            state._fsp--;

             current =iv_ruleModeTransitionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModeTransitionInstance1153); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:660:1: ruleModeTransitionInstance returns [EObject current=null] : (otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end' ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:663:28: ( (otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:664:1: (otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:664:1: (otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:664:3: otherlv_0= 'mode' otherlv_1= 'transition' otherlv_2= 'instance' ( (lv_name_3_0= RULE_ID ) ) otherlv_4= 'of' ( (otherlv_5= RULE_ID ) ) otherlv_6= 'src' ( (otherlv_7= RULE_ID ) ) otherlv_8= 'dst' ( (otherlv_9= RULE_ID ) ) otherlv_10= 'end'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleModeTransitionInstance1190); 

                	newLeafNode(otherlv_0, grammarAccess.getModeTransitionInstanceAccess().getModeKeyword_0());
                
            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleModeTransitionInstance1202); 

                	newLeafNode(otherlv_1, grammarAccess.getModeTransitionInstanceAccess().getTransitionKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleModeTransitionInstance1214); 

                	newLeafNode(otherlv_2, grammarAccess.getModeTransitionInstanceAccess().getInstanceKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:676:1: ( (lv_name_3_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:677:1: (lv_name_3_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:677:1: (lv_name_3_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:678:3: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance1231); 

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

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_ruleModeTransitionInstance1248); 

                	newLeafNode(otherlv_4, grammarAccess.getModeTransitionInstanceAccess().getOfKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:698:1: ( (otherlv_5= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:699:1: (otherlv_5= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:699:1: (otherlv_5= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:700:3: otherlv_5= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance1268); 

            		newLeafNode(otherlv_5, grammarAccess.getModeTransitionInstanceAccess().getModeTransitionModeTransitionCrossReference_5_0()); 
            	

            }


            }

            otherlv_6=(Token)match(input,21,FOLLOW_21_in_ruleModeTransitionInstance1280); 

                	newLeafNode(otherlv_6, grammarAccess.getModeTransitionInstanceAccess().getSrcKeyword_6());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:715:1: ( (otherlv_7= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:716:1: (otherlv_7= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:716:1: (otherlv_7= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:717:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance1300); 

            		newLeafNode(otherlv_7, grammarAccess.getModeTransitionInstanceAccess().getSourceModeInstanceCrossReference_7_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleModeTransitionInstance1312); 

                	newLeafNode(otherlv_8, grammarAccess.getModeTransitionInstanceAccess().getDstKeyword_8());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:732:1: ( (otherlv_9= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:733:1: (otherlv_9= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:733:1: (otherlv_9= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:734:3: otherlv_9= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModeTransitionInstanceRule());
            	        }
                    
            otherlv_9=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModeTransitionInstance1332); 

            		newLeafNode(otherlv_9, grammarAccess.getModeTransitionInstanceAccess().getDestinationModeInstanceCrossReference_9_0()); 
            	

            }


            }

            otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleModeTransitionInstance1344); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:757:1: entryRuleFlowSpecInstance returns [EObject current=null] : iv_ruleFlowSpecInstance= ruleFlowSpecInstance EOF ;
    public final EObject entryRuleFlowSpecInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFlowSpecInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:758:2: (iv_ruleFlowSpecInstance= ruleFlowSpecInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:759:2: iv_ruleFlowSpecInstance= ruleFlowSpecInstance EOF
            {
             newCompositeNode(grammarAccess.getFlowSpecInstanceRule()); 
            pushFollow(FOLLOW_ruleFlowSpecInstance_in_entryRuleFlowSpecInstance1380);
            iv_ruleFlowSpecInstance=ruleFlowSpecInstance();

            state._fsp--;

             current =iv_ruleFlowSpecInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFlowSpecInstance1390); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:766:1: ruleFlowSpecInstance returns [EObject current=null] : (otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end' ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:769:28: ( (otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:770:1: (otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:770:1: (otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:770:3: otherlv_0= 'flowspec' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )? (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )? otherlv_15= 'end'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleFlowSpecInstance1427); 

                	newLeafNode(otherlv_0, grammarAccess.getFlowSpecInstanceAccess().getFlowspecKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleFlowSpecInstance1439); 

                	newLeafNode(otherlv_1, grammarAccess.getFlowSpecInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:778:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:779:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:779:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:780:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecInstance1456); 

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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleFlowSpecInstance1473); 

                	newLeafNode(otherlv_3, grammarAccess.getFlowSpecInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:800:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:801:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:801:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:802:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecInstance1493); 

            		newLeafNode(otherlv_4, grammarAccess.getFlowSpecInstanceAccess().getFlowSpecificationFlowSpecificationCrossReference_4_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:813:2: (otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==21) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:813:4: otherlv_5= 'src' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleFlowSpecInstance1506); 

                        	newLeafNode(otherlv_5, grammarAccess.getFlowSpecInstanceAccess().getSrcKeyword_5_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:817:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:818:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:818:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:819:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecInstanceAccess().getSourceFeatureInstanceCrossReference_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1529);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:832:4: (otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:832:6: otherlv_7= 'dst' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleFlowSpecInstance1544); 

                        	newLeafNode(otherlv_7, grammarAccess.getFlowSpecInstanceAccess().getDstKeyword_6_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:836:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:837:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:837:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:838:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecInstanceAccess().getDestinationFeatureInstanceCrossReference_6_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1567);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:851:4: (otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==16) ) {
                int LA16_1 = input.LA(2);

                if ( (LA16_1==17) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:851:6: otherlv_9= 'in' otherlv_10= 'mode' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleFlowSpecInstance1582); 

                        	newLeafNode(otherlv_9, grammarAccess.getFlowSpecInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleFlowSpecInstance1594); 

                        	newLeafNode(otherlv_10, grammarAccess.getFlowSpecInstanceAccess().getModeKeyword_7_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:859:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:860:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:860:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:861:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getFlowSpecInstanceAccess().getInModeModeInstanceCrossReference_7_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1617);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:874:4: (otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==16) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:874:6: otherlv_12= 'in' otherlv_13= 'transition' ( (otherlv_14= RULE_ID ) )
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleFlowSpecInstance1632); 

                        	newLeafNode(otherlv_12, grammarAccess.getFlowSpecInstanceAccess().getInKeyword_8_0());
                        
                    otherlv_13=(Token)match(input,20,FOLLOW_20_in_ruleFlowSpecInstance1644); 

                        	newLeafNode(otherlv_13, grammarAccess.getFlowSpecInstanceAccess().getTransitionKeyword_8_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:882:1: ( (otherlv_14= RULE_ID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:883:1: (otherlv_14= RULE_ID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:883:1: (otherlv_14= RULE_ID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:884:3: otherlv_14= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getFlowSpecInstanceRule());
                    	        }
                            
                    otherlv_14=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFlowSpecInstance1664); 

                    		newLeafNode(otherlv_14, grammarAccess.getFlowSpecInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_8_2_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_15=(Token)match(input,18,FOLLOW_18_in_ruleFlowSpecInstance1678); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:907:1: entryRuleEndToEndFlowInstance returns [EObject current=null] : iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF ;
    public final EObject entryRuleEndToEndFlowInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndToEndFlowInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:908:2: (iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:909:2: iv_ruleEndToEndFlowInstance= ruleEndToEndFlowInstance EOF
            {
             newCompositeNode(grammarAccess.getEndToEndFlowInstanceRule()); 
            pushFollow(FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance1714);
            iv_ruleEndToEndFlowInstance=ruleEndToEndFlowInstance();

            state._fsp--;

             current =iv_ruleEndToEndFlowInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEndToEndFlowInstance1724); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:916:1: ruleEndToEndFlowInstance returns [EObject current=null] : (otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end' ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:919:28: ( (otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:920:1: (otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:920:1: (otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:920:3: otherlv_0= 'etef' otherlv_1= 'instance' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= 'of' ( (otherlv_4= RULE_ID ) ) ( ( ruleINSTANCEREF ) )* (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )? (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? otherlv_12= 'end'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleEndToEndFlowInstance1761); 

                	newLeafNode(otherlv_0, grammarAccess.getEndToEndFlowInstanceAccess().getEtefKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleEndToEndFlowInstance1773); 

                	newLeafNode(otherlv_1, grammarAccess.getEndToEndFlowInstanceAccess().getInstanceKeyword_1());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:928:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:929:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:929:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:930:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance1790); 

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

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleEndToEndFlowInstance1807); 

                	newLeafNode(otherlv_3, grammarAccess.getEndToEndFlowInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:950:1: ( (otherlv_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:951:1: (otherlv_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:951:1: (otherlv_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:952:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance1827); 

            		newLeafNode(otherlv_4, grammarAccess.getEndToEndFlowInstanceAccess().getEndToEndFlowEndToEndFlowCrossReference_4_0()); 
            	

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:963:2: ( ( ruleINSTANCEREF ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:964:1: ( ruleINSTANCEREF )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:964:1: ( ruleINSTANCEREF )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:965:3: ruleINSTANCEREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getFlowElementFlowElementInstanceCrossReference_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleEndToEndFlowInstance1850);
            	    ruleINSTANCEREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:978:3: (otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==16) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==17) ) {
                    alt19=1;
                }
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:978:5: otherlv_6= 'in' otherlv_7= 'mode' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleEndToEndFlowInstance1864); 

                        	newLeafNode(otherlv_6, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_6_0());
                        
                    otherlv_7=(Token)match(input,17,FOLLOW_17_in_ruleEndToEndFlowInstance1876); 

                        	newLeafNode(otherlv_7, grammarAccess.getEndToEndFlowInstanceAccess().getModeKeyword_6_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:986:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:987:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:987:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:988:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInModeModeInstanceCrossReference_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleEndToEndFlowInstance1899);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1001:4: (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==16) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1001:6: otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) )
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleEndToEndFlowInstance1914); 

                        	newLeafNode(otherlv_9, grammarAccess.getEndToEndFlowInstanceAccess().getInKeyword_7_0());
                        
                    otherlv_10=(Token)match(input,25,FOLLOW_25_in_ruleEndToEndFlowInstance1926); 

                        	newLeafNode(otherlv_10, grammarAccess.getEndToEndFlowInstanceAccess().getSomKeyword_7_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1009:1: ( ( ruleSOMID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1010:1: ( ruleSOMID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1010:1: ( ruleSOMID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1011:3: ruleSOMID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getEndToEndFlowInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getEndToEndFlowInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_7_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSOMID_in_ruleEndToEndFlowInstance1949);
                    ruleSOMID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_12=(Token)match(input,18,FOLLOW_18_in_ruleEndToEndFlowInstance1963); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1036:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1037:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1038:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode1999);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode2009); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1045:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1048:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1049:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1049:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1049:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleSystemOperationMode2046); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1053:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1054:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1054:1: (lv_name_1_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1055:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSystemOperationMode2063); 

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


    // $ANTLR start "entryRuleConnectionInstance"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1079:1: entryRuleConnectionInstance returns [EObject current=null] : iv_ruleConnectionInstance= ruleConnectionInstance EOF ;
    public final EObject entryRuleConnectionInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1080:2: (iv_ruleConnectionInstance= ruleConnectionInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1081:2: iv_ruleConnectionInstance= ruleConnectionInstance EOF
            {
             newCompositeNode(grammarAccess.getConnectionInstanceRule()); 
            pushFollow(FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance2104);
            iv_ruleConnectionInstance=ruleConnectionInstance();

            state._fsp--;

             current =iv_ruleConnectionInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionInstance2114); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1088:1: ruleConnectionInstance returns [EObject current=null] : ( ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end' ) ;
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
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1091:28: ( ( ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1092:1: ( ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1092:1: ( ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1092:2: ( (lv_kind_0_0= ruleConnectionKind ) ) otherlv_1= 'connection' otherlv_2= 'instance' otherlv_3= 'of' ( (lv_connectionReference_4_0= ruleConnectionReference ) )+ otherlv_5= 'src' ( ( ruleINSTANCEREF ) ) otherlv_7= 'dst' ( ( ruleINSTANCEREF ) ) (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )? (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )? ( (lv_complete_15_0= 'complete' ) )? ( (lv_bidirectional_16_0= 'bidirectional' ) )? otherlv_17= 'end'
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1092:2: ( (lv_kind_0_0= ruleConnectionKind ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1093:1: (lv_kind_0_0= ruleConnectionKind )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1093:1: (lv_kind_0_0= ruleConnectionKind )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1094:3: lv_kind_0_0= ruleConnectionKind
            {
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getKindConnectionKindParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConnectionKind_in_ruleConnectionInstance2160);
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

            otherlv_1=(Token)match(input,26,FOLLOW_26_in_ruleConnectionInstance2172); 

                	newLeafNode(otherlv_1, grammarAccess.getConnectionInstanceAccess().getConnectionKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleConnectionInstance2184); 

                	newLeafNode(otherlv_2, grammarAccess.getConnectionInstanceAccess().getInstanceKeyword_2());
                
            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleConnectionInstance2196); 

                	newLeafNode(otherlv_3, grammarAccess.getConnectionInstanceAccess().getOfKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1122:1: ( (lv_connectionReference_4_0= ruleConnectionReference ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==15) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1123:1: (lv_connectionReference_4_0= ruleConnectionReference )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1123:1: (lv_connectionReference_4_0= ruleConnectionReference )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1124:3: lv_connectionReference_4_0= ruleConnectionReference
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getConnectionReferenceConnectionReferenceParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConnectionReference_in_ruleConnectionInstance2217);
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
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);

            otherlv_5=(Token)match(input,21,FOLLOW_21_in_ruleConnectionInstance2230); 

                	newLeafNode(otherlv_5, grammarAccess.getConnectionInstanceAccess().getSrcKeyword_5());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1144:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1145:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1145:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1146:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getSourceConnectionInstanceEndCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2253);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,22,FOLLOW_22_in_ruleConnectionInstance2265); 

                	newLeafNode(otherlv_7, grammarAccess.getConnectionInstanceAccess().getDstKeyword_7());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1163:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1164:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1164:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1165:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getDestinationConnectionInstanceEndCrossReference_8_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2288);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1178:2: (otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==16) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==25) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1178:4: otherlv_9= 'in' otherlv_10= 'som' ( ( ruleSOMID ) )
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleConnectionInstance2301); 

                        	newLeafNode(otherlv_9, grammarAccess.getConnectionInstanceAccess().getInKeyword_9_0());
                        
                    otherlv_10=(Token)match(input,25,FOLLOW_25_in_ruleConnectionInstance2313); 

                        	newLeafNode(otherlv_10, grammarAccess.getConnectionInstanceAccess().getSomKeyword_9_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1186:1: ( ( ruleSOMID ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1187:1: ( ruleSOMID )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1187:1: ( ruleSOMID )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1188:3: ruleSOMID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInSystemOperationModeSystemOperationModeCrossReference_9_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleSOMID_in_ruleConnectionInstance2336);
                    ruleSOMID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1201:4: (otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==16) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1201:6: otherlv_12= 'in' otherlv_13= 'transition' ( ( ruleINSTANCEREF ) )
                    {
                    otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleConnectionInstance2351); 

                        	newLeafNode(otherlv_12, grammarAccess.getConnectionInstanceAccess().getInKeyword_10_0());
                        
                    otherlv_13=(Token)match(input,20,FOLLOW_20_in_ruleConnectionInstance2363); 

                        	newLeafNode(otherlv_13, grammarAccess.getConnectionInstanceAccess().getTransitionKeyword_10_1());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1209:1: ( ( ruleINSTANCEREF ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1210:1: ( ruleINSTANCEREF )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1210:1: ( ruleINSTANCEREF )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1211:3: ruleINSTANCEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getConnectionInstanceAccess().getInModeTransitionModeTransitionInstanceCrossReference_10_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2386);
                    ruleINSTANCEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1224:4: ( (lv_complete_15_0= 'complete' ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==27) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1225:1: (lv_complete_15_0= 'complete' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1225:1: (lv_complete_15_0= 'complete' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1226:3: lv_complete_15_0= 'complete'
                    {
                    lv_complete_15_0=(Token)match(input,27,FOLLOW_27_in_ruleConnectionInstance2406); 

                            newLeafNode(lv_complete_15_0, grammarAccess.getConnectionInstanceAccess().getCompleteCompleteKeyword_11_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "complete", true, "complete");
                    	    

                    }


                    }
                    break;

            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1239:3: ( (lv_bidirectional_16_0= 'bidirectional' ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==28) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1240:1: (lv_bidirectional_16_0= 'bidirectional' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1240:1: (lv_bidirectional_16_0= 'bidirectional' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1241:3: lv_bidirectional_16_0= 'bidirectional'
                    {
                    lv_bidirectional_16_0=(Token)match(input,28,FOLLOW_28_in_ruleConnectionInstance2438); 

                            newLeafNode(lv_bidirectional_16_0, grammarAccess.getConnectionInstanceAccess().getBidirectionalBidirectionalKeyword_12_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConnectionInstanceRule());
                    	        }
                           		setWithLastConsumed(current, "bidirectional", true, "bidirectional");
                    	    

                    }


                    }
                    break;

            }

            otherlv_17=(Token)match(input,18,FOLLOW_18_in_ruleConnectionInstance2464); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1266:1: entryRuleConnectionReference returns [EObject current=null] : iv_ruleConnectionReference= ruleConnectionReference EOF ;
    public final EObject entryRuleConnectionReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnectionReference = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1267:2: (iv_ruleConnectionReference= ruleConnectionReference EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1268:2: iv_ruleConnectionReference= ruleConnectionReference EOF
            {
             newCompositeNode(grammarAccess.getConnectionReferenceRule()); 
            pushFollow(FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference2500);
            iv_ruleConnectionReference=ruleConnectionReference();

            state._fsp--;

             current =iv_ruleConnectionReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionReference2510); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1275:1: ruleConnectionReference returns [EObject current=null] : (otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) ) ) ;
    public final EObject ruleConnectionReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1278:28: ( (otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1279:1: (otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1279:1: (otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1279:3: otherlv_0= 'of' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'src' ( ( ruleINSTANCEREF ) ) otherlv_4= 'dst' ( ( ruleINSTANCEREF ) ) otherlv_6= 'context' ( ( ruleINSTANCEREF ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleConnectionReference2547); 

                	newLeafNode(otherlv_0, grammarAccess.getConnectionReferenceAccess().getOfKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1283:1: ( (otherlv_1= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1284:1: (otherlv_1= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1284:1: (otherlv_1= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1285:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConnectionReference2567); 

            		newLeafNode(otherlv_1, grammarAccess.getConnectionReferenceAccess().getConnectionConnectionCrossReference_1_0()); 
            	

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleConnectionReference2579); 

                	newLeafNode(otherlv_2, grammarAccess.getConnectionReferenceAccess().getSrcKeyword_2());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1300:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1301:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1301:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1302:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getSourceConnectionInstanceEndCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2602);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleConnectionReference2614); 

                	newLeafNode(otherlv_4, grammarAccess.getConnectionReferenceAccess().getDstKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1319:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1320:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1320:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1321:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getDestinationConnectionInstanceEndCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2637);
            ruleINSTANCEREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleConnectionReference2649); 

                	newLeafNode(otherlv_6, grammarAccess.getConnectionReferenceAccess().getContextKeyword_6());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1338:1: ( ( ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1339:1: ( ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1339:1: ( ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1340:3: ruleINSTANCEREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConnectionReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConnectionReferenceAccess().getContextComponentInstanceCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2672);
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1361:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1362:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1363:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory2709);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory2720); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1370:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1373:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1374:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1374:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt26=14;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1375:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleComponentCategory2758); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1382:2: kw= 'bus'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleComponentCategory2777); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1389:2: kw= 'data'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleComponentCategory2796); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1396:2: kw= 'device'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleComponentCategory2815); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1403:2: kw= 'memory'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleComponentCategory2834); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1410:2: kw= 'process'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleComponentCategory2853); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1417:2: kw= 'processor'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleComponentCategory2872); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1424:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleComponentCategory2891); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1430:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1430:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1431:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleComponentCategory2911); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleComponentCategory2924); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1444:2: kw= 'system'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_ruleComponentCategory2944); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1450:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1450:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1451:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleComponentCategory2964); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleComponentCategory2977); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1464:2: kw= 'thread'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_ruleComponentCategory2997); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1470:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1470:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1471:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleComponentCategory3017); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleComponentCategory3030); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1483:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1483:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1484:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleComponentCategory3051); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleComponentCategory3064); 

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


    // $ANTLR start "entryRuleFeatureCategory"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1503:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1504:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1505:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory3106);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory3117); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1512:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'eventport' | kw= 'dataport' | kw= 'eventdataport' | kw= 'parameter' | kw= 'busaccess' | kw= 'dataaccess' | kw= 'subprogramaccess' | kw= 'subprogramgroupaccess' | kw= 'featuregroup' | kw= 'abstractfeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1515:28: ( (kw= 'eventport' | kw= 'dataport' | kw= 'eventdataport' | kw= 'parameter' | kw= 'busaccess' | kw= 'dataaccess' | kw= 'subprogramaccess' | kw= 'subprogramgroupaccess' | kw= 'featuregroup' | kw= 'abstractfeature' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1516:1: (kw= 'eventport' | kw= 'dataport' | kw= 'eventdataport' | kw= 'parameter' | kw= 'busaccess' | kw= 'dataaccess' | kw= 'subprogramaccess' | kw= 'subprogramgroupaccess' | kw= 'featuregroup' | kw= 'abstractfeature' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1516:1: (kw= 'eventport' | kw= 'dataport' | kw= 'eventdataport' | kw= 'parameter' | kw= 'busaccess' | kw= 'dataaccess' | kw= 'subprogramaccess' | kw= 'subprogramgroupaccess' | kw= 'featuregroup' | kw= 'abstractfeature' )
            int alt27=10;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt27=1;
                }
                break;
            case 43:
                {
                alt27=2;
                }
                break;
            case 44:
                {
                alt27=3;
                }
                break;
            case 45:
                {
                alt27=4;
                }
                break;
            case 46:
                {
                alt27=5;
                }
                break;
            case 47:
                {
                alt27=6;
                }
                break;
            case 48:
                {
                alt27=7;
                }
                break;
            case 49:
                {
                alt27=8;
                }
                break;
            case 50:
                {
                alt27=9;
                }
                break;
            case 51:
                {
                alt27=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1517:2: kw= 'eventport'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleFeatureCategory3155); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventportKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1524:2: kw= 'dataport'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleFeatureCategory3174); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataportKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1531:2: kw= 'eventdataport'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleFeatureCategory3193); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventdataportKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1538:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleFeatureCategory3212); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1545:2: kw= 'busaccess'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleFeatureCategory3231); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusaccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1552:2: kw= 'dataaccess'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_ruleFeatureCategory3250); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataaccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1559:2: kw= 'subprogramaccess'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_ruleFeatureCategory3269); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramaccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1566:2: kw= 'subprogramgroupaccess'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_ruleFeatureCategory3288); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramgroupaccessKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1573:2: kw= 'featuregroup'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleFeatureCategory3307); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeaturegroupKeyword_8()); 
                        

                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1580:2: kw= 'abstractfeature'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_ruleFeatureCategory3326); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1593:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1594:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1595:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType3367);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType3378); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1602:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | kw= 'inout' ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1605:28: ( (kw= 'in' | kw= 'out' | kw= 'inout' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1606:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1606:1: (kw= 'in' | kw= 'out' | kw= 'inout' )
            int alt28=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt28=1;
                }
                break;
            case 52:
                {
                alt28=2;
                }
                break;
            case 53:
                {
                alt28=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1607:2: kw= 'in'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleDirectionType3416); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1614:2: kw= 'out'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_ruleDirectionType3435); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1621:2: kw= 'inout'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_ruleDirectionType3454); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1634:1: entryRuleConnectionKind returns [String current=null] : iv_ruleConnectionKind= ruleConnectionKind EOF ;
    public final String entryRuleConnectionKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConnectionKind = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1635:2: (iv_ruleConnectionKind= ruleConnectionKind EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1636:2: iv_ruleConnectionKind= ruleConnectionKind EOF
            {
             newCompositeNode(grammarAccess.getConnectionKindRule()); 
            pushFollow(FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind3495);
            iv_ruleConnectionKind=ruleConnectionKind();

            state._fsp--;

             current =iv_ruleConnectionKind.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConnectionKind3506); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1643:1: ruleConnectionKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'feature' | kw= 'access' | kw= 'parameter' | kw= 'port' | kw= 'modetransition' | kw= 'featuregroup' ) ;
    public final AntlrDatatypeRuleToken ruleConnectionKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1646:28: ( (kw= 'feature' | kw= 'access' | kw= 'parameter' | kw= 'port' | kw= 'modetransition' | kw= 'featuregroup' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1647:1: (kw= 'feature' | kw= 'access' | kw= 'parameter' | kw= 'port' | kw= 'modetransition' | kw= 'featuregroup' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1647:1: (kw= 'feature' | kw= 'access' | kw= 'parameter' | kw= 'port' | kw= 'modetransition' | kw= 'featuregroup' )
            int alt29=6;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt29=1;
                }
                break;
            case 55:
                {
                alt29=2;
                }
                break;
            case 45:
                {
                alt29=3;
                }
                break;
            case 56:
                {
                alt29=4;
                }
                break;
            case 57:
                {
                alt29=5;
                }
                break;
            case 50:
                {
                alt29=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1648:2: kw= 'feature'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleConnectionKind3544); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getFeatureKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1655:2: kw= 'access'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleConnectionKind3563); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getAccessKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1662:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleConnectionKind3582); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getParameterKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1669:2: kw= 'port'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleConnectionKind3601); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getPortKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1676:2: kw= 'modetransition'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleConnectionKind3620); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getConnectionKindAccess().getModetransitionKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1683:2: kw= 'featuregroup'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_ruleConnectionKind3639); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1696:1: entryRuleFQCREF returns [String current=null] : iv_ruleFQCREF= ruleFQCREF EOF ;
    public final String entryRuleFQCREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQCREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1697:2: (iv_ruleFQCREF= ruleFQCREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1698:2: iv_ruleFQCREF= ruleFQCREF EOF
            {
             newCompositeNode(grammarAccess.getFQCREFRule()); 
            pushFollow(FOLLOW_ruleFQCREF_in_entryRuleFQCREF3680);
            iv_ruleFQCREF=ruleFQCREF();

            state._fsp--;

             current =iv_ruleFQCREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQCREF3691); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1705:1: ruleFQCREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleFQCREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1708:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1709:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1709:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1709:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1709:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==58) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1709:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQCREF3732); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,58,FOLLOW_58_in_ruleFQCREF3750); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQCREFAccess().getColonColonKeyword_0_1()); 
            	        

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQCREF3767); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getFQCREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1729:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==59) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1730:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,59,FOLLOW_59_in_ruleFQCREF3786); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFQCREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFQCREF3801); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1750:1: entryRuleINSTANCEREF returns [String current=null] : iv_ruleINSTANCEREF= ruleINSTANCEREF EOF ;
    public final String entryRuleINSTANCEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINSTANCEREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1751:2: (iv_ruleINSTANCEREF= ruleINSTANCEREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1752:2: iv_ruleINSTANCEREF= ruleINSTANCEREF EOF
            {
             newCompositeNode(grammarAccess.getINSTANCEREFRule()); 
            pushFollow(FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF3849);
            iv_ruleINSTANCEREF=ruleINSTANCEREF();

            state._fsp--;

             current =iv_ruleINSTANCEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINSTANCEREF3860); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1759:1: ruleINSTANCEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleINSTANCEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1762:28: ( ( (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1763:1: ( (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1763:1: ( (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1763:2: (this_ID_0= RULE_ID kw= '.' )* this_ID_2= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1763:2: (this_ID_0= RULE_ID kw= '.' )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==59) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1763:7: this_ID_0= RULE_ID kw= '.'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF3901); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getINSTANCEREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,59,FOLLOW_59_in_ruleINSTANCEREF3919); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getINSTANCEREFAccess().getFullStopKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleINSTANCEREF3936); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1791:1: entryRuleSOMID returns [String current=null] : iv_ruleSOMID= ruleSOMID EOF ;
    public final String entryRuleSOMID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSOMID = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1792:2: (iv_ruleSOMID= ruleSOMID EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1793:2: iv_ruleSOMID= ruleSOMID EOF
            {
             newCompositeNode(grammarAccess.getSOMIDRule()); 
            pushFollow(FOLLOW_ruleSOMID_in_entryRuleSOMID3982);
            iv_ruleSOMID=ruleSOMID();

            state._fsp--;

             current =iv_ruleSOMID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSOMID3993); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1800:1: ruleSOMID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF ) ;
    public final AntlrDatatypeRuleToken ruleSOMID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_INSTANCEREF_0 = null;

        AntlrDatatypeRuleToken this_INSTANCEREF_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1803:28: ( ( (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1804:1: ( (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1804:1: ( (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1804:2: (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )* this_INSTANCEREF_2= ruleINSTANCEREF
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1804:2: (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )*
            loop33:
            do {
                int alt33=2;
                alt33 = dfa33.predict(input);
                switch (alt33) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1805:5: this_INSTANCEREF_0= ruleINSTANCEREF kw= '#'
            	    {
            	     
            	            newCompositeNode(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_0_0()); 
            	        
            	    pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleSOMID4041);
            	    this_INSTANCEREF_0=ruleINSTANCEREF();

            	    state._fsp--;


            	    		current.merge(this_INSTANCEREF_0);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    kw=(Token)match(input,60,FOLLOW_60_in_ruleSOMID4059); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSOMIDAccess().getNumberSignKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getSOMIDAccess().getINSTANCEREFParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleINSTANCEREF_in_ruleSOMID4083);
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1840:1: entryRuleINTVALUE returns [String current=null] : iv_ruleINTVALUE= ruleINTVALUE EOF ;
    public final String entryRuleINTVALUE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleINTVALUE = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1841:2: (iv_ruleINTVALUE= ruleINTVALUE EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1842:2: iv_ruleINTVALUE= ruleINTVALUE EOF
            {
             newCompositeNode(grammarAccess.getINTVALUERule()); 
            pushFollow(FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE4129);
            iv_ruleINTVALUE=ruleINTVALUE();

            state._fsp--;

             current =iv_ruleINTVALUE.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleINTVALUE4140); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1849:1: ruleINTVALUE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INTEGER_LIT_0= RULE_INTEGER_LIT ;
    public final AntlrDatatypeRuleToken ruleINTVALUE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INTEGER_LIT_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1852:28: (this_INTEGER_LIT_0= RULE_INTEGER_LIT )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:1853:5: this_INTEGER_LIT_0= RULE_INTEGER_LIT
            {
            this_INTEGER_LIT_0=(Token)match(input,RULE_INTEGER_LIT,FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE4179); 

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


    protected DFA26 dfa26 = new DFA26(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA26_eotS =
        "\22\uffff";
    static final String DFA26_eofS =
        "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String DFA26_minS =
        "\1\36\7\uffff\1\4\1\uffff\1\4\1\37\6\uffff";
    static final String DFA26_maxS =
        "\1\51\7\uffff\1\46\1\uffff\1\46\1\44\6\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\15\1\16";
    static final String DFA26_specialS =
        "\22\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\7\uffff\1\14\31\uffff\1\15",
            "",
            "\1\16\7\uffff\1\16\31\uffff\1\17",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "1374:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
    static final String DFA33_eotS =
        "\5\uffff";
    static final String DFA33_eofS =
        "\1\uffff\1\3\3\uffff";
    static final String DFA33_minS =
        "\1\4\1\20\2\uffff\1\4";
    static final String DFA33_maxS =
        "\1\4\1\74\2\uffff\1\4";
    static final String DFA33_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA33_specialS =
        "\5\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\1",
            "\1\3\1\uffff\1\3\10\uffff\2\3\36\uffff\1\4\1\2",
            "",
            "",
            "\1\1"
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
            return "()* loopback of 1804:2: (this_INSTANCEREF_0= ruleINSTANCEREF kw= '#' )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleSystemInstance131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemInstance148 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleSystemInstance165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFQCREF_in_ruleSystemInstance188 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleSystemInstance200 = new BitSet(new long[]{0x0000000002000800L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance221 = new BitSet(new long[]{0x0000000002000800L});
    public static final BitSet FOLLOW_11_in_ruleSystemInstance234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance270 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleComponentInstance326 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleComponentInstance338 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance355 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_13_in_ruleComponentInstance373 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_ruleComponentInstance394 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_14_in_ruleComponentInstance407 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleComponentInstance421 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance441 = new BitSet(new long[]{0x03CFFFBFC1870000L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleComponentInstance462 = new BitSet(new long[]{0x03CFFFBFC1870000L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleComponentInstance484 = new BitSet(new long[]{0x03C423BFC1870000L});
    public static final BitSet FOLLOW_ruleModeInstance_in_ruleComponentInstance506 = new BitSet(new long[]{0x03C4200001870000L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_ruleComponentInstance528 = new BitSet(new long[]{0x03C4200001870000L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_ruleComponentInstance550 = new BitSet(new long[]{0x03C4200001850000L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_ruleComponentInstance572 = new BitSet(new long[]{0x03C4200001050000L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_ruleComponentInstance594 = new BitSet(new long[]{0x03C4200000050000L});
    public static final BitSet FOLLOW_16_in_ruleComponentInstance608 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleComponentInstance620 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance640 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleComponentInstance654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance690 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance746 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFeatureInstance758 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance775 = new BitSet(new long[]{0x000000000000A000L});
    public static final BitSet FOLLOW_13_in_ruleFeatureInstance793 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_ruleFeatureInstance814 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleFeatureInstance826 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFeatureInstance840 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance860 = new BitSet(new long[]{0x0030000000010000L});
    public static final BitSet FOLLOW_ruleDirectionType_in_ruleFeatureInstance881 = new BitSet(new long[]{0x000FFC0000000000L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance902 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFeatureInstance914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeInstance_in_entryRuleModeInstance950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeInstance960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleModeInstance997 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModeInstance1009 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance1026 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModeInstance1043 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeInstance1063 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_19_in_ruleModeInstance1081 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModeInstance1107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModeTransitionInstance_in_entryRuleModeTransitionInstance1143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModeTransitionInstance1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleModeTransitionInstance1190 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleModeTransitionInstance1202 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModeTransitionInstance1214 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance1231 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleModeTransitionInstance1248 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance1268 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleModeTransitionInstance1280 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance1300 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleModeTransitionInstance1312 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModeTransitionInstance1332 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModeTransitionInstance1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFlowSpecInstance_in_entryRuleFlowSpecInstance1380 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFlowSpecInstance1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFlowSpecInstance1427 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFlowSpecInstance1439 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecInstance1456 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleFlowSpecInstance1473 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecInstance1493 = new BitSet(new long[]{0x0000000000650000L});
    public static final BitSet FOLLOW_21_in_ruleFlowSpecInstance1506 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1529 = new BitSet(new long[]{0x0000000000450000L});
    public static final BitSet FOLLOW_22_in_ruleFlowSpecInstance1544 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1567 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleFlowSpecInstance1582 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleFlowSpecInstance1594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleFlowSpecInstance1617 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleFlowSpecInstance1632 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleFlowSpecInstance1644 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFlowSpecInstance1664 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleFlowSpecInstance1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEndToEndFlowInstance_in_entryRuleEndToEndFlowInstance1714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEndToEndFlowInstance1724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleEndToEndFlowInstance1761 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleEndToEndFlowInstance1773 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance1790 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEndToEndFlowInstance1807 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEndToEndFlowInstance1827 = new BitSet(new long[]{0x0000000000050010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleEndToEndFlowInstance1850 = new BitSet(new long[]{0x0000000000050010L});
    public static final BitSet FOLLOW_16_in_ruleEndToEndFlowInstance1864 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleEndToEndFlowInstance1876 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleEndToEndFlowInstance1899 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_16_in_ruleEndToEndFlowInstance1914 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleEndToEndFlowInstance1926 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSOMID_in_ruleEndToEndFlowInstance1949 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleEndToEndFlowInstance1963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode1999 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode2009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleSystemOperationMode2046 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSystemOperationMode2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionInstance_in_entryRuleConnectionInstance2104 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionInstance2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_ruleConnectionInstance2160 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleConnectionInstance2172 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleConnectionInstance2184 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleConnectionInstance2196 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_ruleConnectionInstance2217 = new BitSet(new long[]{0x0000000000208000L});
    public static final BitSet FOLLOW_21_in_ruleConnectionInstance2230 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2253 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionInstance2265 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2288 = new BitSet(new long[]{0x0000000018050000L});
    public static final BitSet FOLLOW_16_in_ruleConnectionInstance2301 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleConnectionInstance2313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSOMID_in_ruleConnectionInstance2336 = new BitSet(new long[]{0x0000000018050000L});
    public static final BitSet FOLLOW_16_in_ruleConnectionInstance2351 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleConnectionInstance2363 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionInstance2386 = new BitSet(new long[]{0x0000000018040000L});
    public static final BitSet FOLLOW_27_in_ruleConnectionInstance2406 = new BitSet(new long[]{0x0000000010040000L});
    public static final BitSet FOLLOW_28_in_ruleConnectionInstance2438 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleConnectionInstance2464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionReference_in_entryRuleConnectionReference2500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionReference2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleConnectionReference2547 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConnectionReference2567 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleConnectionReference2579 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2602 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleConnectionReference2614 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2637 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleConnectionReference2649 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleConnectionReference2672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory2709 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory2720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleComponentCategory2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleComponentCategory2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleComponentCategory2796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleComponentCategory2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleComponentCategory2834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleComponentCategory2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComponentCategory2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleComponentCategory2891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleComponentCategory2911 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleComponentCategory2924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleComponentCategory2944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleComponentCategory2964 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleComponentCategory2977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleComponentCategory2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleComponentCategory3017 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleComponentCategory3030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleComponentCategory3051 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleComponentCategory3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory3106 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory3117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleFeatureCategory3155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleFeatureCategory3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleFeatureCategory3193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleFeatureCategory3212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleFeatureCategory3231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleFeatureCategory3250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleFeatureCategory3269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleFeatureCategory3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleFeatureCategory3307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_ruleFeatureCategory3326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType3367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType3378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDirectionType3416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleDirectionType3435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleDirectionType3454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConnectionKind_in_entryRuleConnectionKind3495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConnectionKind3506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleConnectionKind3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleConnectionKind3563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleConnectionKind3582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleConnectionKind3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleConnectionKind3620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleConnectionKind3639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQCREF_in_entryRuleFQCREF3680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQCREF3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF3732 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_58_in_ruleFQCREF3750 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF3767 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_59_in_ruleFQCREF3786 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFQCREF3801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_entryRuleINSTANCEREF3849 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINSTANCEREF3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF3901 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_59_in_ruleINSTANCEREF3919 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleINSTANCEREF3936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSOMID_in_entryRuleSOMID3982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSOMID3993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleSOMID4041 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_60_in_ruleSOMID4059 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleINSTANCEREF_in_ruleSOMID4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleINTVALUE_in_entryRuleINTVALUE4129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleINTVALUE4140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_LIT_in_ruleINTVALUE4179 = new BitSet(new long[]{0x0000000000000002L});

}