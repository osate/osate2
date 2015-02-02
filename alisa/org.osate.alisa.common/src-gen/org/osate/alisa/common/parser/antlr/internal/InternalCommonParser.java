package org.osate.alisa.common.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.alisa.common.services.CommonGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCommonParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'&'", "'this'", "'%'", "'.'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalCommonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCommonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCommonParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g"; }



     	private CommonGrammarAccess grammarAccess;
     	
        public InternalCommonParser(TokenStream input, CommonGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected CommonGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:76:1: ruleModel returns [EObject current=null] : ( (lv_content_0_0= ruleDescription ) ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_content_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:79:28: ( ( (lv_content_0_0= ruleDescription ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:80:1: ( (lv_content_0_0= ruleDescription ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:80:1: ( (lv_content_0_0= ruleDescription ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:81:1: (lv_content_0_0= ruleDescription )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:81:1: (lv_content_0_0= ruleDescription )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:82:3: lv_content_0_0= ruleDescription
            {
             
            	        newCompositeNode(grammarAccess.getModelAccess().getContentDescriptionParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleDescription_in_ruleModel130);
            lv_content_0_0=ruleDescription();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModelRule());
            	        }
                   		set(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"Description");
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:106:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:107:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:108:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription165);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription175); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescription"


    // $ANTLR start "ruleDescription"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:115:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:118:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:119:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:119:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||(LA1_0>=11 && LA1_0<=12)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:120:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:120:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:121:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription220);
            	    lv_description_0_0=ruleDescriptionElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"description",
            	            		lv_description_0_0, 
            	            		"DescriptionElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleDescriptionElement"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:145:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:146:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:147:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement256);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement266); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDescriptionElement"


    // $ANTLR start "ruleDescriptionElement"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:154:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= '&' ) ) | ( (lv_thisTarget_3_0= 'this' ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_2_0=null;
        Token lv_thisTarget_3_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:157:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= '&' ) ) | ( (lv_thisTarget_3_0= 'this' ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:158:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= '&' ) ) | ( (lv_thisTarget_3_0= 'this' ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:158:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= '&' ) ) | ( (lv_thisTarget_3_0= 'this' ) ) )
            int alt2=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt2=1;
                }
                break;
            case RULE_ID:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            case 12:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:158:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:158:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:159:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:159:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:160:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement308); 

                    			newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"text",
                            		lv_text_0_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:177:6: ( (lv_value_1_0= ruleShowValue ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:177:6: ( (lv_value_1_0= ruleShowValue ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:178:1: (lv_value_1_0= ruleShowValue )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:178:1: (lv_value_1_0= ruleShowValue )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:179:3: lv_value_1_0= ruleShowValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getValueShowValueParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShowValue_in_ruleDescriptionElement340);
                    lv_value_1_0=ruleShowValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_1_0, 
                            		"ShowValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:196:6: ( (lv_newline_2_0= '&' ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:196:6: ( (lv_newline_2_0= '&' ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:197:1: (lv_newline_2_0= '&' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:197:1: (lv_newline_2_0= '&' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:198:3: lv_newline_2_0= '&'
                    {
                    lv_newline_2_0=(Token)match(input,11,FOLLOW_11_in_ruleDescriptionElement364); 

                            newLeafNode(lv_newline_2_0, grammarAccess.getDescriptionElementAccess().getNewlineAmpersandKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                           		setWithLastConsumed(current, "newline", true, "&");
                    	    

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:212:6: ( (lv_thisTarget_3_0= 'this' ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:212:6: ( (lv_thisTarget_3_0= 'this' ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:213:1: (lv_thisTarget_3_0= 'this' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:213:1: (lv_thisTarget_3_0= 'this' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:214:3: lv_thisTarget_3_0= 'this'
                    {
                    lv_thisTarget_3_0=(Token)match(input,12,FOLLOW_12_in_ruleDescriptionElement401); 

                            newLeafNode(lv_thisTarget_3_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                           		setWithLastConsumed(current, "thisTarget", true, "this");
                    	    

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
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleShowValue"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:235:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:236:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:237:2: iv_ruleShowValue= ruleShowValue EOF
            {
             newCompositeNode(grammarAccess.getShowValueRule()); 
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue450);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;

             current =iv_ruleShowValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue460); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShowValue"


    // $ANTLR start "ruleShowValue"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:244:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_unit_2_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:247:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )? ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:248:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )? )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:248:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:248:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )?
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:248:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:249:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:249:1: (otherlv_0= RULE_ID )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:250:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getShowValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue505); 

            		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:261:2: (otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:261:4: otherlv_1= '%' ( (lv_unit_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleShowValue518); 

                        	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                        
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:265:1: ( (lv_unit_2_0= RULE_ID ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:266:1: (lv_unit_2_0= RULE_ID )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:266:1: (lv_unit_2_0= RULE_ID )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:267:3: lv_unit_2_0= RULE_ID
                    {
                    lv_unit_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue535); 

                    			newLeafNode(lv_unit_2_0, grammarAccess.getShowValueAccess().getUnitIDTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getShowValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"unit",
                            		lv_unit_2_0, 
                            		"ID");
                    	    

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
    // $ANTLR end "ruleShowValue"


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:291:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:292:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:293:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath578);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath588); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferencePath"


    // $ANTLR start "ruleReferencePath"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:300:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:303:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:304:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:304:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:304:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:304:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:305:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:305:1: (otherlv_0= RULE_ID )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:306:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath633); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:317:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:317:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleReferencePath646); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:321:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:322:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:322:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:323:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath667);
            lv_subpath_2_0=ruleReferencePath();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferencePathRule());
            	        }
                   		set(
                   			current, 
                   			"subpath",
                    		lv_subpath_2_0, 
                    		"ReferencePath");
            	        afterParserOrEnumRuleCall();
            	    

            }


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
    // $ANTLR end "ruleReferencePath"


    // $ANTLR start "entryRuleConstantValue"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:351:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:352:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:353:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_ruleConstantValue_in_entryRuleConstantValue708);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantValue718); 

            }

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:360:1: ruleConstantValue returns [EObject current=null] : (this_StringTerm_0= ruleStringTerm | this_RealTerm_1= ruleRealTerm | this_IntegerTerm_2= ruleIntegerTerm ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject this_StringTerm_0 = null;

        EObject this_RealTerm_1 = null;

        EObject this_IntegerTerm_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:363:28: ( (this_StringTerm_0= ruleStringTerm | this_RealTerm_1= ruleRealTerm | this_IntegerTerm_2= ruleIntegerTerm ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:364:1: (this_StringTerm_0= ruleStringTerm | this_RealTerm_1= ruleRealTerm | this_IntegerTerm_2= ruleIntegerTerm )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:364:1: (this_StringTerm_0= ruleStringTerm | this_RealTerm_1= ruleRealTerm | this_IntegerTerm_2= ruleIntegerTerm )
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_INT) ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==14) ) {
                    alt4=2;
                }
                else if ( (LA4_2==EOF||LA4_2==RULE_ID) ) {
                    alt4=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:365:5: this_StringTerm_0= ruleStringTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getStringTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleConstantValue765);
                    this_StringTerm_0=ruleStringTerm();

                    state._fsp--;

                     
                            current = this_StringTerm_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:375:5: this_RealTerm_1= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getRealTermParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleConstantValue792);
                    this_RealTerm_1=ruleRealTerm();

                    state._fsp--;

                     
                            current = this_RealTerm_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:385:5: this_IntegerTerm_2= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getIntegerTermParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleConstantValue819);
                    this_IntegerTerm_2=ruleIntegerTerm();

                    state._fsp--;

                     
                            current = this_IntegerTerm_2; 
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
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleStringTerm"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:401:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:402:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:403:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm854);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm864); 

            }

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:410:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:413:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:414:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:414:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:415:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:415:1: (lv_value_0_0= RULE_STRING )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:416:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringTerm905); 

            			newLeafNode(lv_value_0_0, grammarAccess.getStringTermAccess().getValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringTermRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"STRING");
            	    

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


    // $ANTLR start "entryRuleRealTerm"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:440:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:441:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:442:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm945);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm955); 

            }

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:449:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token lv_unit_1_0=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:452:28: ( ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:453:1: ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:453:1: ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:453:2: ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )?
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:453:2: ( (lv_value_0_0= ruleREAL ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:454:1: (lv_value_0_0= ruleREAL )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:454:1: (lv_value_0_0= ruleREAL )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:455:3: lv_value_0_0= ruleREAL
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueREALParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleREAL_in_ruleRealTerm1001);
            lv_value_0_0=ruleREAL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRealTermRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"REAL");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:471:2: ( (lv_unit_1_0= RULE_ID ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:472:1: (lv_unit_1_0= RULE_ID )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:472:1: (lv_unit_1_0= RULE_ID )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:473:3: lv_unit_1_0= RULE_ID
                    {
                    lv_unit_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealTerm1018); 

                    			newLeafNode(lv_unit_1_0, grammarAccess.getRealTermAccess().getUnitIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getRealTermRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"unit",
                            		lv_unit_1_0, 
                            		"ID");
                    	    

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


    // $ANTLR start "entryRuleREAL"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:497:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:498:2: (iv_ruleREAL= ruleREAL EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:499:2: iv_ruleREAL= ruleREAL EOF
            {
             newCompositeNode(grammarAccess.getREALRule()); 
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL1061);
            iv_ruleREAL=ruleREAL();

            state._fsp--;

             current =iv_ruleREAL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL1072); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleREAL"


    // $ANTLR start "ruleREAL"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:506:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:509:28: ( (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:510:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:510:1: (this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:510:6: this_INT_0= RULE_INT kw= '.' this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL1112); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                
            kw=(Token)match(input,14,FOLLOW_14_in_ruleREAL1130); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL1145); 

            		current.merge(this_INT_2);
                
             
                newLeafNode(this_INT_2, grammarAccess.getREALAccess().getINTTerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleREAL"


    // $ANTLR start "entryRuleIntegerTerm"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:538:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:539:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:540:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm1190);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm1200); 

            }

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:547:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_unit_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:550:28: ( ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:551:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:551:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:551:2: ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )?
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:551:2: ( (lv_value_0_0= RULE_INT ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:552:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:552:1: (lv_value_0_0= RULE_INT )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:553:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntegerTerm1242); 

            			newLeafNode(lv_value_0_0, grammarAccess.getIntegerTermAccess().getValueINTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerTermRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"INT");
            	    

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:569:2: ( (lv_unit_1_0= RULE_ID ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:570:1: (lv_unit_1_0= RULE_ID )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:570:1: (lv_unit_1_0= RULE_ID )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:571:3: lv_unit_1_0= RULE_ID
                    {
                    lv_unit_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerTerm1264); 

                    			newLeafNode(lv_unit_1_0, grammarAccess.getIntegerTermAccess().getUnitIDTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getIntegerTermRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"unit",
                            		lv_unit_1_0, 
                            		"ID");
                    	    

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


    // $ANTLR start "entryRuleTextElement"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:597:1: entryRuleTextElement returns [EObject current=null] : iv_ruleTextElement= ruleTextElement EOF ;
    public final EObject entryRuleTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextElement = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:598:2: (iv_ruleTextElement= ruleTextElement EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:599:2: iv_ruleTextElement= ruleTextElement EOF
            {
             newCompositeNode(grammarAccess.getTextElementRule()); 
            pushFollow(FOLLOW_ruleTextElement_in_entryRuleTextElement1308);
            iv_ruleTextElement=ruleTextElement();

            state._fsp--;

             current =iv_ruleTextElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextElement1318); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextElement"


    // $ANTLR start "ruleTextElement"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:606:1: ruleTextElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= '&' ) ) ) ;
    public final EObject ruleTextElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:609:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= '&' ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:610:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= '&' ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:610:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= '&' ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_STRING) ) {
                alt7=1;
            }
            else if ( (LA7_0==11) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:610:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:610:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:611:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:611:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:612:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextElement1360); 

                    			newLeafNode(lv_text_0_0, grammarAccess.getTextElementAccess().getTextSTRINGTerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTextElementRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"text",
                            		lv_text_0_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:629:6: ( (lv_newline_1_0= '&' ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:629:6: ( (lv_newline_1_0= '&' ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:630:1: (lv_newline_1_0= '&' )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:630:1: (lv_newline_1_0= '&' )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:631:3: lv_newline_1_0= '&'
                    {
                    lv_newline_1_0=(Token)match(input,11,FOLLOW_11_in_ruleTextElement1389); 

                            newLeafNode(lv_newline_1_0, grammarAccess.getTextElementAccess().getNewlineAmpersandKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTextElementRule());
                    	        }
                           		setWithLastConsumed(current, "newline", true, "&");
                    	    

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
    // $ANTLR end "ruleTextElement"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription220 = new BitSet(new long[]{0x0000000000001832L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleDescriptionElement364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleDescriptionElement401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue450 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue505 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_ruleShowValue518 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath578 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath633 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleReferencePath646 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue708 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleConstantValue765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleConstantValue792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleConstantValue819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringTerm905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleRealTerm1001 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm1018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL1061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL1072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL1112 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleREAL1130 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL1145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm1190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm1200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntegerTerm1242 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_entryRuleTextElement1308 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextElement1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextElement1360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleTextElement1389 = new BitSet(new long[]{0x0000000000000002L});

}