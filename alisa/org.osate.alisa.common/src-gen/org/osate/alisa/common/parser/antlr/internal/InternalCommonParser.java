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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'.'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int T__11=11;
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

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:154:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:157:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:158:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:158:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
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
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:177:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:177:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:178:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:178:1: (otherlv_1= RULE_ID )
                    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:179:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement339); 

                    		newLeafNode(otherlv_1, grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
                    	

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


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:198:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:199:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:200:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath375);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath385); 

            }

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
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:207:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:210:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:211:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:211:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:211:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:211:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:212:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:212:1: (otherlv_0= RULE_ID )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:213:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath430); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:224:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:224:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleReferencePath443); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:228:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:229:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:229:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:230:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath464);
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


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:258:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:259:2: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:260:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString506);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString517); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueString"


    // $ANTLR start "ruleValueString"
    // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:267:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:270:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.alisa.common/src-gen/org/osate/alisa/common/parser/antlr/internal/InternalCommon.g:271:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString556); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getValueStringAccess().getSTRINGTerminalRuleCall()); 
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueString"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleModel130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription220 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath430 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleReferencePath443 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString556 = new BitSet(new long[]{0x0000000000000002L});

}