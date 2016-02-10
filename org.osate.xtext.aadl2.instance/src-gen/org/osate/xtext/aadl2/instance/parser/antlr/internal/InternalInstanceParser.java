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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_LONG", "RULE_STRING", "RULE_SL_COMMENT", "RULE_WS", "':'", "'{'", "'}'", "'['", "']'", "'som'", "'in'", "'out'", "'dataPort'", "'eventPort'", "'eventDataPort'", "'parameter'", "'busAccess'", "'subprogramAccess'", "'subprogramGroupAccess'", "'featureGroup'", "'abstractFeature'", "'abstract'", "'bus'", "'data'", "'device'", "'memory'", "'process'", "'processor'", "'subprogram'", "'group'", "'system'", "'thread'", "'virtual'", "'::'", "'.'"
    };
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=7;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__10=10;
    public static final int T__32=32;
    public static final int T__9=9;
    public static final int RULE_ID=4;
    public static final int RULE_WS=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int RULE_LONG=5;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:76:1: ruleSystemInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_systemOperationMode_7_0= ruleSystemOperationMode ) ) )* otherlv_8= '}' ) ;
    public final EObject ruleSystemInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_5_0 = null;

        EObject lv_componentInstance_6_0 = null;

        EObject lv_systemOperationMode_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:79:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_systemOperationMode_7_0= ruleSystemOperationMode ) ) )* otherlv_8= '}' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_systemOperationMode_7_0= ruleSystemOperationMode ) ) )* otherlv_8= '}' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_systemOperationMode_7_0= ruleSystemOperationMode ) ) )* otherlv_8= '}' )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:80:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( ( ruleIMPLREF ) ) otherlv_4= '{' ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_systemOperationMode_7_0= ruleSystemOperationMode ) ) )* otherlv_8= '}'
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
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:139:1: ( ( (lv_featureInstance_5_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_6_0= ruleComponentInstance ) ) | ( (lv_systemOperationMode_7_0= ruleSystemOperationMode ) ) )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case 15:
                case 16:
                    {
                    alt1=1;
                    }
                    break;
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 35:
                case 36:
                case 37:
                    {
                    alt1=2;
                    }
                    break;
                case 14:
                    {
                    alt1=3;
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
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:177:6: ( (lv_systemOperationMode_7_0= ruleSystemOperationMode ) )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:177:6: ( (lv_systemOperationMode_7_0= ruleSystemOperationMode ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:178:1: (lv_systemOperationMode_7_0= ruleSystemOperationMode )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:178:1: (lv_systemOperationMode_7_0= ruleSystemOperationMode )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:179:3: lv_systemOperationMode_7_0= ruleSystemOperationMode
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSystemInstanceAccess().getSystemOperationModeSystemOperationModeParserRuleCall_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance276);
            	    lv_systemOperationMode_7_0=ruleSystemOperationMode();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSystemInstanceRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"systemOperationMode",
            	            		lv_systemOperationMode_7_0, 
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

            otherlv_8=(Token)match(input,11,FOLLOW_11_in_ruleSystemInstance290); 

                	newLeafNode(otherlv_8, grammarAccess.getSystemInstanceAccess().getRightCurlyBracketKeyword_6());
                

            }


            }

             leaveRule(); 
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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:207:1: entryRuleFeatureInstance returns [EObject current=null] : iv_ruleFeatureInstance= ruleFeatureInstance EOF ;
    public final EObject entryRuleFeatureInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:208:2: (iv_ruleFeatureInstance= ruleFeatureInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:209:2: iv_ruleFeatureInstance= ruleFeatureInstance EOF
            {
             newCompositeNode(grammarAccess.getFeatureInstanceRule()); 
            pushFollow(FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance326);
            iv_ruleFeatureInstance=ruleFeatureInstance();

            state._fsp--;

             current =iv_ruleFeatureInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureInstance336); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:216:1: ruleFeatureInstance returns [EObject current=null] : ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= '{' ( (lv_featureInstance_9_0= ruleFeatureInstance ) )* otherlv_10= '}' )? ) ;
    public final EObject ruleFeatureInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_index_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_direction_0_0 = null;

        AntlrDatatypeRuleToken lv_category_1_0 = null;

        EObject lv_featureInstance_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:219:28: ( ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= '{' ( (lv_featureInstance_9_0= ruleFeatureInstance ) )* otherlv_10= '}' )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:220:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= '{' ( (lv_featureInstance_9_0= ruleFeatureInstance ) )* otherlv_10= '}' )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:220:1: ( ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= '{' ( (lv_featureInstance_9_0= ruleFeatureInstance ) )* otherlv_10= '}' )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:220:2: ( (lv_direction_0_0= ruleDirectionType ) ) ( (lv_category_1_0= ruleFeatureCategory ) ) ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )? otherlv_6= ':' ( ( ruleFEATREF ) ) (otherlv_8= '{' ( (lv_featureInstance_9_0= ruleFeatureInstance ) )* otherlv_10= '}' )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:220:2: ( (lv_direction_0_0= ruleDirectionType ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:221:1: (lv_direction_0_0= ruleDirectionType )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:221:1: (lv_direction_0_0= ruleDirectionType )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:222:3: lv_direction_0_0= ruleDirectionType
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getDirectionDirectionTypeParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDirectionType_in_ruleFeatureInstance382);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:238:2: ( (lv_category_1_0= ruleFeatureCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:239:1: (lv_category_1_0= ruleFeatureCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:239:1: (lv_category_1_0= ruleFeatureCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:240:3: lv_category_1_0= ruleFeatureCategory
            {
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getCategoryFeatureCategoryParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance403);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:256:2: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:257:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:257:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:258:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFeatureInstance420); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:274:2: (otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:274:4: otherlv_3= '[' ( (lv_index_4_0= RULE_LONG ) ) otherlv_5= ']'
                    {
                    otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleFeatureInstance438); 

                        	newLeafNode(otherlv_3, grammarAccess.getFeatureInstanceAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:278:1: ( (lv_index_4_0= RULE_LONG ) )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:279:1: (lv_index_4_0= RULE_LONG )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:279:1: (lv_index_4_0= RULE_LONG )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:280:3: lv_index_4_0= RULE_LONG
                    {
                    lv_index_4_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleFeatureInstance455); 

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

                    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleFeatureInstance472); 

                        	newLeafNode(otherlv_5, grammarAccess.getFeatureInstanceAccess().getRightSquareBracketKeyword_3_2());
                        

                    }
                    break;

            }

            otherlv_6=(Token)match(input,9,FOLLOW_9_in_ruleFeatureInstance486); 

                	newLeafNode(otherlv_6, grammarAccess.getFeatureInstanceAccess().getColonKeyword_4());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:304:1: ( ( ruleFEATREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:305:1: ( ruleFEATREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:305:1: ( ruleFEATREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:306:3: ruleFEATREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFeatureInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureFeatureCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleFEATREF_in_ruleFeatureInstance509);
            ruleFEATREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:319:2: (otherlv_8= '{' ( (lv_featureInstance_9_0= ruleFeatureInstance ) )* otherlv_10= '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==10) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:319:4: otherlv_8= '{' ( (lv_featureInstance_9_0= ruleFeatureInstance ) )* otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,10,FOLLOW_10_in_ruleFeatureInstance522); 

                        	newLeafNode(otherlv_8, grammarAccess.getFeatureInstanceAccess().getLeftCurlyBracketKeyword_6_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:323:1: ( (lv_featureInstance_9_0= ruleFeatureInstance ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=15 && LA3_0<=16)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:324:1: (lv_featureInstance_9_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:324:1: (lv_featureInstance_9_0= ruleFeatureInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:325:3: lv_featureInstance_9_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getFeatureInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance543);
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
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,11,FOLLOW_11_in_ruleFeatureInstance556); 

                        	newLeafNode(otherlv_10, grammarAccess.getFeatureInstanceAccess().getRightCurlyBracketKeyword_6_2());
                        

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:353:1: entryRuleComponentInstance returns [EObject current=null] : iv_ruleComponentInstance= ruleComponentInstance EOF ;
    public final EObject entryRuleComponentInstance() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentInstance = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:354:2: (iv_ruleComponentInstance= ruleComponentInstance EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:355:2: iv_ruleComponentInstance= ruleComponentInstance EOF
            {
             newCompositeNode(grammarAccess.getComponentInstanceRule()); 
            pushFollow(FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance594);
            iv_ruleComponentInstance=ruleComponentInstance();

            state._fsp--;

             current =iv_ruleComponentInstance; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentInstance604); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:362:1: ruleComponentInstance returns [EObject current=null] : ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= '{' ( ( (lv_featureInstance_8_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_9_0= ruleComponentInstance ) ) )* otherlv_10= '}' )? ) ;
    public final EObject ruleComponentInstance() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_index_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_category_0_0 = null;

        EObject lv_featureInstance_8_0 = null;

        EObject lv_componentInstance_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:365:28: ( ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= '{' ( ( (lv_featureInstance_8_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_9_0= ruleComponentInstance ) ) )* otherlv_10= '}' )? ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:366:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= '{' ( ( (lv_featureInstance_8_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_9_0= ruleComponentInstance ) ) )* otherlv_10= '}' )? )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:366:1: ( ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= '{' ( ( (lv_featureInstance_8_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_9_0= ruleComponentInstance ) ) )* otherlv_10= '}' )? )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:366:2: ( (lv_category_0_0= ruleComponentCategory ) ) ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )* otherlv_5= ':' ( ( ruleSUBREF ) ) (otherlv_7= '{' ( ( (lv_featureInstance_8_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_9_0= ruleComponentInstance ) ) )* otherlv_10= '}' )?
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:366:2: ( (lv_category_0_0= ruleComponentCategory ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:367:1: (lv_category_0_0= ruleComponentCategory )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:367:1: (lv_category_0_0= ruleComponentCategory )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:368:3: lv_category_0_0= ruleComponentCategory
            {
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getCategoryComponentCategoryParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleComponentCategory_in_ruleComponentInstance650);
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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:384:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:385:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:385:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:386:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleComponentInstance667); 

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

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:402:2: (otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==12) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:402:4: otherlv_2= '[' ( (lv_index_3_0= RULE_LONG ) ) otherlv_4= ']'
            	    {
            	    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleComponentInstance685); 

            	        	newLeafNode(otherlv_2, grammarAccess.getComponentInstanceAccess().getLeftSquareBracketKeyword_2_0());
            	        
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:406:1: ( (lv_index_3_0= RULE_LONG ) )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:407:1: (lv_index_3_0= RULE_LONG )
            	    {
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:407:1: (lv_index_3_0= RULE_LONG )
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:408:3: lv_index_3_0= RULE_LONG
            	    {
            	    lv_index_3_0=(Token)match(input,RULE_LONG,FOLLOW_RULE_LONG_in_ruleComponentInstance702); 

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

            	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleComponentInstance719); 

            	        	newLeafNode(otherlv_4, grammarAccess.getComponentInstanceAccess().getRightSquareBracketKeyword_2_2());
            	        

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_5=(Token)match(input,9,FOLLOW_9_in_ruleComponentInstance733); 

                	newLeafNode(otherlv_5, grammarAccess.getComponentInstanceAccess().getColonKeyword_3());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:432:1: ( ( ruleSUBREF ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:433:1: ( ruleSUBREF )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:433:1: ( ruleSUBREF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:434:3: ruleSUBREF
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getComponentInstanceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getSubcomponentSubcomponentCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleSUBREF_in_ruleComponentInstance756);
            ruleSUBREF();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:447:2: (otherlv_7= '{' ( ( (lv_featureInstance_8_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_9_0= ruleComponentInstance ) ) )* otherlv_10= '}' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==10) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:447:4: otherlv_7= '{' ( ( (lv_featureInstance_8_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_9_0= ruleComponentInstance ) ) )* otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,10,FOLLOW_10_in_ruleComponentInstance769); 

                        	newLeafNode(otherlv_7, grammarAccess.getComponentInstanceAccess().getLeftCurlyBracketKeyword_5_0());
                        
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:451:1: ( ( (lv_featureInstance_8_0= ruleFeatureInstance ) ) | ( (lv_componentInstance_9_0= ruleComponentInstance ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>=15 && LA6_0<=16)) ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>=26 && LA6_0<=33)||(LA6_0>=35 && LA6_0<=37)) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:451:2: ( (lv_featureInstance_8_0= ruleFeatureInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:451:2: ( (lv_featureInstance_8_0= ruleFeatureInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:452:1: (lv_featureInstance_8_0= ruleFeatureInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:452:1: (lv_featureInstance_8_0= ruleFeatureInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:453:3: lv_featureInstance_8_0= ruleFeatureInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getFeatureInstanceFeatureInstanceParserRuleCall_5_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFeatureInstance_in_ruleComponentInstance791);
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


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:470:6: ( (lv_componentInstance_9_0= ruleComponentInstance ) )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:470:6: ( (lv_componentInstance_9_0= ruleComponentInstance ) )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:471:1: (lv_componentInstance_9_0= ruleComponentInstance )
                    	    {
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:471:1: (lv_componentInstance_9_0= ruleComponentInstance )
                    	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:472:3: lv_componentInstance_9_0= ruleComponentInstance
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getComponentInstanceAccess().getComponentInstanceComponentInstanceParserRuleCall_5_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleComponentInstance_in_ruleComponentInstance818);
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


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,11,FOLLOW_11_in_ruleComponentInstance832); 

                        	newLeafNode(otherlv_10, grammarAccess.getComponentInstanceAccess().getRightCurlyBracketKeyword_5_2());
                        

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


    // $ANTLR start "entryRuleSystemOperationMode"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:500:1: entryRuleSystemOperationMode returns [EObject current=null] : iv_ruleSystemOperationMode= ruleSystemOperationMode EOF ;
    public final EObject entryRuleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemOperationMode = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:501:2: (iv_ruleSystemOperationMode= ruleSystemOperationMode EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:502:2: iv_ruleSystemOperationMode= ruleSystemOperationMode EOF
            {
             newCompositeNode(grammarAccess.getSystemOperationModeRule()); 
            pushFollow(FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode870);
            iv_ruleSystemOperationMode=ruleSystemOperationMode();

            state._fsp--;

             current =iv_ruleSystemOperationMode; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemOperationMode880); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:509:1: ruleSystemOperationMode returns [EObject current=null] : (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleSystemOperationMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:512:28: ( (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:513:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:513:1: (otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:513:3: otherlv_0= 'som' ( (lv_name_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_14_in_ruleSystemOperationMode917); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemOperationModeAccess().getSomKeyword_0());
                
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:517:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:518:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:518:1: (lv_name_1_0= RULE_STRING )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:519:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSystemOperationMode934); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:543:1: entryRuleDirectionType returns [String current=null] : iv_ruleDirectionType= ruleDirectionType EOF ;
    public final String entryRuleDirectionType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDirectionType = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:544:2: (iv_ruleDirectionType= ruleDirectionType EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:545:2: iv_ruleDirectionType= ruleDirectionType EOF
            {
             newCompositeNode(grammarAccess.getDirectionTypeRule()); 
            pushFollow(FOLLOW_ruleDirectionType_in_entryRuleDirectionType976);
            iv_ruleDirectionType=ruleDirectionType();

            state._fsp--;

             current =iv_ruleDirectionType.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDirectionType987); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:552:1: ruleDirectionType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) ;
    public final AntlrDatatypeRuleToken ruleDirectionType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:555:28: ( (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:556:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:556:1: (kw= 'in' | kw= 'out' | (kw= 'in' kw= 'out' ) )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==15) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==16) ) {
                    alt8=3;
                }
                else if ( (LA8_1==EOF||(LA8_1>=17 && LA8_1<=25)) ) {
                    alt8=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA8_0==16) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:557:2: kw= 'in'
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleDirectionType1025); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:564:2: kw= 'out'
                    {
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleDirectionType1044); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getOutKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:570:6: (kw= 'in' kw= 'out' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:570:6: (kw= 'in' kw= 'out' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:571:2: kw= 'in' kw= 'out'
                    {
                    kw=(Token)match(input,15,FOLLOW_15_in_ruleDirectionType1064); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getDirectionTypeAccess().getInKeyword_2_0()); 
                        
                    kw=(Token)match(input,16,FOLLOW_16_in_ruleDirectionType1077); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:590:1: entryRuleFeatureCategory returns [String current=null] : iv_ruleFeatureCategory= ruleFeatureCategory EOF ;
    public final String entryRuleFeatureCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFeatureCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:591:2: (iv_ruleFeatureCategory= ruleFeatureCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:592:2: iv_ruleFeatureCategory= ruleFeatureCategory EOF
            {
             newCompositeNode(grammarAccess.getFeatureCategoryRule()); 
            pushFollow(FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory1119);
            iv_ruleFeatureCategory=ruleFeatureCategory();

            state._fsp--;

             current =iv_ruleFeatureCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFeatureCategory1130); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:599:1: ruleFeatureCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) ;
    public final AntlrDatatypeRuleToken ruleFeatureCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:602:28: ( (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:603:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:603:1: (kw= 'dataPort' | kw= 'eventPort' | kw= 'eventDataPort' | kw= 'parameter' | kw= 'busAccess' | kw= 'subprogramAccess' | kw= 'subprogramGroupAccess' | kw= 'featureGroup' | kw= 'abstractFeature' )
            int alt9=9;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt9=1;
                }
                break;
            case 18:
                {
                alt9=2;
                }
                break;
            case 19:
                {
                alt9=3;
                }
                break;
            case 20:
                {
                alt9=4;
                }
                break;
            case 21:
                {
                alt9=5;
                }
                break;
            case 22:
                {
                alt9=6;
                }
                break;
            case 23:
                {
                alt9=7;
                }
                break;
            case 24:
                {
                alt9=8;
                }
                break;
            case 25:
                {
                alt9=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:604:2: kw= 'dataPort'
                    {
                    kw=(Token)match(input,17,FOLLOW_17_in_ruleFeatureCategory1168); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getDataPortKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:611:2: kw= 'eventPort'
                    {
                    kw=(Token)match(input,18,FOLLOW_18_in_ruleFeatureCategory1187); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventPortKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:618:2: kw= 'eventDataPort'
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleFeatureCategory1206); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getEventDataPortKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:625:2: kw= 'parameter'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleFeatureCategory1225); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getParameterKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:632:2: kw= 'busAccess'
                    {
                    kw=(Token)match(input,21,FOLLOW_21_in_ruleFeatureCategory1244); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getBusAccessKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:639:2: kw= 'subprogramAccess'
                    {
                    kw=(Token)match(input,22,FOLLOW_22_in_ruleFeatureCategory1263); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramAccessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:646:2: kw= 'subprogramGroupAccess'
                    {
                    kw=(Token)match(input,23,FOLLOW_23_in_ruleFeatureCategory1282); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getSubprogramGroupAccessKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:653:2: kw= 'featureGroup'
                    {
                    kw=(Token)match(input,24,FOLLOW_24_in_ruleFeatureCategory1301); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getFeatureCategoryAccess().getFeatureGroupKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:660:2: kw= 'abstractFeature'
                    {
                    kw=(Token)match(input,25,FOLLOW_25_in_ruleFeatureCategory1320); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:673:1: entryRuleComponentCategory returns [String current=null] : iv_ruleComponentCategory= ruleComponentCategory EOF ;
    public final String entryRuleComponentCategory() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleComponentCategory = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:674:2: (iv_ruleComponentCategory= ruleComponentCategory EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:675:2: iv_ruleComponentCategory= ruleComponentCategory EOF
            {
             newCompositeNode(grammarAccess.getComponentCategoryRule()); 
            pushFollow(FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory1361);
            iv_ruleComponentCategory=ruleComponentCategory();

            state._fsp--;

             current =iv_ruleComponentCategory.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComponentCategory1372); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:682:1: ruleComponentCategory returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) ;
    public final AntlrDatatypeRuleToken ruleComponentCategory() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:685:28: ( (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:686:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:686:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )
            int alt10=14;
            alt10 = dfa10.predict(input);
            switch (alt10) {
                case 1 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:687:2: kw= 'abstract'
                    {
                    kw=(Token)match(input,26,FOLLOW_26_in_ruleComponentCategory1410); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getAbstractKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:694:2: kw= 'bus'
                    {
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleComponentCategory1429); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:701:2: kw= 'data'
                    {
                    kw=(Token)match(input,28,FOLLOW_28_in_ruleComponentCategory1448); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDataKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:708:2: kw= 'device'
                    {
                    kw=(Token)match(input,29,FOLLOW_29_in_ruleComponentCategory1467); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getDeviceKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:715:2: kw= 'memory'
                    {
                    kw=(Token)match(input,30,FOLLOW_30_in_ruleComponentCategory1486); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getMemoryKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:722:2: kw= 'process'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleComponentCategory1505); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:729:2: kw= 'processor'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleComponentCategory1524); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getProcessorKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:736:2: kw= 'subprogram'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleComponentCategory1543); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_7()); 
                        

                    }
                    break;
                case 9 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:742:6: (kw= 'subprogram' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:742:6: (kw= 'subprogram' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:743:2: kw= 'subprogram' kw= 'group'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleComponentCategory1563); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSubprogramKeyword_8_0()); 
                        
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleComponentCategory1576); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_8_1()); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:756:2: kw= 'system'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_ruleComponentCategory1596); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getSystemKeyword_9()); 
                        

                    }
                    break;
                case 11 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:762:6: (kw= 'thread' kw= 'group' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:762:6: (kw= 'thread' kw= 'group' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:763:2: kw= 'thread' kw= 'group'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleComponentCategory1616); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_10_0()); 
                        
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleComponentCategory1629); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getGroupKeyword_10_1()); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:776:2: kw= 'thread'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleComponentCategory1649); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getThreadKeyword_11()); 
                        

                    }
                    break;
                case 13 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:782:6: (kw= 'virtual' kw= 'bus' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:782:6: (kw= 'virtual' kw= 'bus' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:783:2: kw= 'virtual' kw= 'bus'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleComponentCategory1669); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_12_0()); 
                        
                    kw=(Token)match(input,27,FOLLOW_27_in_ruleComponentCategory1682); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getBusKeyword_12_1()); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:795:6: (kw= 'virtual' kw= 'processor' )
                    {
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:795:6: (kw= 'virtual' kw= 'processor' )
                    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:796:2: kw= 'virtual' kw= 'processor'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_ruleComponentCategory1703); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getComponentCategoryAccess().getVirtualKeyword_13_0()); 
                        
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleComponentCategory1716); 

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


    // $ANTLR start "entryRuleIMPLREF"
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:815:1: entryRuleIMPLREF returns [String current=null] : iv_ruleIMPLREF= ruleIMPLREF EOF ;
    public final String entryRuleIMPLREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMPLREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:816:2: (iv_ruleIMPLREF= ruleIMPLREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:817:2: iv_ruleIMPLREF= ruleIMPLREF EOF
            {
             newCompositeNode(grammarAccess.getIMPLREFRule()); 
            pushFollow(FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF1758);
            iv_ruleIMPLREF=ruleIMPLREF();

            state._fsp--;

             current =iv_ruleIMPLREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIMPLREF1769); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:824:1: ruleIMPLREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMPLREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:827:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:828:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:828:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:828:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:828:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==38) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:828:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF1810); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,38,FOLLOW_38_in_ruleIMPLREF1828); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getIMPLREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF1845); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getIMPLREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,39,FOLLOW_39_in_ruleIMPLREF1863); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getIMPLREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIMPLREF1878); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:869:1: entryRuleFEATREF returns [String current=null] : iv_ruleFEATREF= ruleFEATREF EOF ;
    public final String entryRuleFEATREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFEATREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:870:2: (iv_ruleFEATREF= ruleFEATREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:871:2: iv_ruleFEATREF= ruleFEATREF EOF
            {
             newCompositeNode(grammarAccess.getFEATREFRule()); 
            pushFollow(FOLLOW_ruleFEATREF_in_entryRuleFEATREF1924);
            iv_ruleFEATREF=ruleFEATREF();

            state._fsp--;

             current =iv_ruleFEATREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFEATREF1935); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:878:1: ruleFEATREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleFEATREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:881:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:882:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:882:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:882:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '::' this_ID_4= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:882:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==38) ) {
                        int LA12_2 = input.LA(3);

                        if ( (LA12_2==RULE_ID) ) {
                            int LA12_3 = input.LA(4);

                            if ( (LA12_3==38) ) {
                                alt12=1;
                            }


                        }


                    }


                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:882:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF1976); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,38,FOLLOW_38_in_ruleFEATREF1994); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFEATREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF2011); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getFEATREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,38,FOLLOW_38_in_ruleFEATREF2029); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getFEATREFAccess().getColonColonKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFEATREF2044); 

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:923:1: entryRuleSUBREF returns [String current=null] : iv_ruleSUBREF= ruleSUBREF EOF ;
    public final String entryRuleSUBREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSUBREF = null;


        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:924:2: (iv_ruleSUBREF= ruleSUBREF EOF )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:925:2: iv_ruleSUBREF= ruleSUBREF EOF
            {
             newCompositeNode(grammarAccess.getSUBREFRule()); 
            pushFollow(FOLLOW_ruleSUBREF_in_entryRuleSUBREF2090);
            iv_ruleSUBREF=ruleSUBREF();

            state._fsp--;

             current =iv_ruleSUBREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSUBREF2101); 

            }

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
    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:932:1: ruleSUBREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleSUBREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:935:28: ( ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID ) )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:936:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID )
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:936:1: ( (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID )
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:936:2: (this_ID_0= RULE_ID kw= '::' )+ this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID kw= '::' this_ID_6= RULE_ID
            {
            // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:936:2: (this_ID_0= RULE_ID kw= '::' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==38) ) {
                        alt13=1;
                    }


                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.xtext.aadl2.instance/src-gen/org/osate/xtext/aadl2/instance/parser/antlr/internal/InternalInstance.g:936:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF2142); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,38,FOLLOW_38_in_ruleSUBREF2160); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getSUBREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF2177); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,39,FOLLOW_39_in_ruleSUBREF2195); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSUBREFAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF2210); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getSUBREFAccess().getIDTerminalRuleCall_3()); 
                
            kw=(Token)match(input,38,FOLLOW_38_in_ruleSUBREF2228); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getSUBREFAccess().getColonColonKeyword_4()); 
                
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSUBREF2243); 

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

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\22\uffff";
    static final String DFA10_eofS =
        "\10\uffff\1\14\1\uffff\1\16\7\uffff";
    static final String DFA10_minS =
        "\1\32\7\uffff\1\4\1\uffff\1\4\1\33\6\uffff";
    static final String DFA10_maxS =
        "\1\45\7\uffff\1\42\1\uffff\1\42\1\40\6\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\12\2\uffff\1\10\1\11\1\14\1\13\1\16\1\15";
    static final String DFA10_specialS =
        "\22\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\11\1\12\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\35\uffff\1\15",
            "",
            "\1\16\35\uffff\1\17",
            "\1\21\4\uffff\1\20",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "686:1: (kw= 'abstract' | kw= 'bus' | kw= 'data' | kw= 'device' | kw= 'memory' | kw= 'process' | kw= 'processor' | kw= 'subprogram' | (kw= 'subprogram' kw= 'group' ) | kw= 'system' | (kw= 'thread' kw= 'group' ) | kw= 'thread' | (kw= 'virtual' kw= 'bus' ) | (kw= 'virtual' kw= 'processor' ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleSystemInstance_in_entryRuleSystemInstance75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemInstance85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleSystemInstance131 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemInstance148 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleSystemInstance165 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_ruleSystemInstance188 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_ruleSystemInstance200 = new BitSet(new long[]{0x0000003BFC01C800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleSystemInstance222 = new BitSet(new long[]{0x0000003BFC01C800L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleSystemInstance249 = new BitSet(new long[]{0x0000003BFC01C800L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_ruleSystemInstance276 = new BitSet(new long[]{0x0000003BFC01C800L});
    public static final BitSet FOLLOW_11_in_ruleSystemInstance290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_entryRuleFeatureInstance326 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureInstance336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_ruleFeatureInstance382 = new BitSet(new long[]{0x0000000003FE0000L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_ruleFeatureInstance403 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFeatureInstance420 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleFeatureInstance438 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleFeatureInstance455 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleFeatureInstance472 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_ruleFeatureInstance486 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleFEATREF_in_ruleFeatureInstance509 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_ruleFeatureInstance522 = new BitSet(new long[]{0x0000000000018800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleFeatureInstance543 = new BitSet(new long[]{0x0000000000018800L});
    public static final BitSet FOLLOW_11_in_ruleFeatureInstance556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_entryRuleComponentInstance594 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentInstance604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_ruleComponentInstance650 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleComponentInstance667 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_12_in_ruleComponentInstance685 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_LONG_in_ruleComponentInstance702 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleComponentInstance719 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_9_in_ruleComponentInstance733 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSUBREF_in_ruleComponentInstance756 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_10_in_ruleComponentInstance769 = new BitSet(new long[]{0x0000003BFC018800L});
    public static final BitSet FOLLOW_ruleFeatureInstance_in_ruleComponentInstance791 = new BitSet(new long[]{0x0000003BFC018800L});
    public static final BitSet FOLLOW_ruleComponentInstance_in_ruleComponentInstance818 = new BitSet(new long[]{0x0000003BFC018800L});
    public static final BitSet FOLLOW_11_in_ruleComponentInstance832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemOperationMode_in_entryRuleSystemOperationMode870 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemOperationMode880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleSystemOperationMode917 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSystemOperationMode934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDirectionType_in_entryRuleDirectionType976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDirectionType987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDirectionType1025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleDirectionType1044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleDirectionType1064 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleDirectionType1077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFeatureCategory_in_entryRuleFeatureCategory1119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFeatureCategory1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleFeatureCategory1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleFeatureCategory1187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleFeatureCategory1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleFeatureCategory1225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleFeatureCategory1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleFeatureCategory1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleFeatureCategory1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleFeatureCategory1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleFeatureCategory1320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComponentCategory_in_entryRuleComponentCategory1361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComponentCategory1372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleComponentCategory1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleComponentCategory1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleComponentCategory1448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleComponentCategory1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleComponentCategory1486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleComponentCategory1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleComponentCategory1524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleComponentCategory1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleComponentCategory1563 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleComponentCategory1576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleComponentCategory1596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComponentCategory1616 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleComponentCategory1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComponentCategory1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleComponentCategory1669 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleComponentCategory1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleComponentCategory1703 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleComponentCategory1716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIMPLREF_in_entryRuleIMPLREF1758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIMPLREF1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF1810 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleIMPLREF1828 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF1845 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleIMPLREF1863 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIMPLREF1878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFEATREF_in_entryRuleFEATREF1924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFEATREF1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF1976 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleFEATREF1994 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF2011 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleFEATREF2029 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFEATREF2044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSUBREF_in_entryRuleSUBREF2090 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSUBREF2101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF2142 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleSUBREF2160 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF2177 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleSUBREF2195 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF2210 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleSUBREF2228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSUBREF2243 = new BitSet(new long[]{0x0000000000000002L});

}