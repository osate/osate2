package org.osate.results.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.results.services.ResultsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalResultsParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'report'", "':'", "'['", "'root'", "'description'", "'heading'", "'data'", "']'", "'entry'", "'target'", "'result'", "'issues'", "'contributor'", "'='", "'error'", "'warning'", "'success'", "'info'"
    };
    public static final int RULE_ID=4;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalResultsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalResultsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalResultsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g"; }



     	private ResultsGrammarAccess grammarAccess;
     	
        public InternalResultsParser(TokenStream input, ResultsGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ResultReport";	
       	}
       	
       	@Override
       	protected ResultsGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleResultReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:68:1: entryRuleResultReport returns [EObject current=null] : iv_ruleResultReport= ruleResultReport EOF ;
    public final EObject entryRuleResultReport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReport = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:69:2: (iv_ruleResultReport= ruleResultReport EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:70:2: iv_ruleResultReport= ruleResultReport EOF
            {
             newCompositeNode(grammarAccess.getResultReportRule()); 
            pushFollow(FOLLOW_ruleResultReport_in_entryRuleResultReport75);
            iv_ruleResultReport=ruleResultReport();

            state._fsp--;

             current =iv_ruleResultReport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReport85); 

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
    // $ANTLR end "entryRuleResultReport"


    // $ANTLR start "ruleResultReport"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:77:1: ruleResultReport returns [EObject current=null] : (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'root' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultReportEntry ) )* )? (otherlv_12= 'data' ( (lv_resultData_13_0= ruleResultData ) ) )? otherlv_14= ']' ) ;
    public final EObject ruleResultReport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_decription_8_0=null;
        Token otherlv_9=null;
        Token lv_heading_10_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject lv_content_11_0 = null;

        EObject lv_resultData_13_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:80:28: ( (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'root' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultReportEntry ) )* )? (otherlv_12= 'data' ( (lv_resultData_13_0= ruleResultData ) ) )? otherlv_14= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:81:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'root' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultReportEntry ) )* )? (otherlv_12= 'data' ( (lv_resultData_13_0= ruleResultData ) ) )? otherlv_14= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:81:1: (otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'root' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultReportEntry ) )* )? (otherlv_12= 'data' ( (lv_resultData_13_0= ruleResultData ) ) )? otherlv_14= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:81:3: otherlv_0= 'report' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'root' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultReportEntry ) )* )? (otherlv_12= 'data' ( (lv_resultData_13_0= ruleResultData ) ) )? otherlv_14= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleResultReport122); 

                	newLeafNode(otherlv_0, grammarAccess.getResultReportAccess().getReportKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:85:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:86:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:86:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:87:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultReport139); 

            			newLeafNode(lv_name_1_0, grammarAccess.getResultReportAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:103:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:103:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleResultReport157); 

                        	newLeafNode(otherlv_2, grammarAccess.getResultReportAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:107:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:108:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:108:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:109:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport174); 

                    			newLeafNode(lv_title_3_0, grammarAccess.getResultReportAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleResultReport193); 

                	newLeafNode(otherlv_4, grammarAccess.getResultReportAccess().getLeftSquareBracketKeyword_3());
                
            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleResultReport205); 

                	newLeafNode(otherlv_5, grammarAccess.getResultReportAccess().getRootKeyword_4());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:133:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:134:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:134:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:135:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResultReportAccess().getRootEObjectCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleResultReport228);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:148:2: (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==15) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:148:4: otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleResultReport241); 

                        	newLeafNode(otherlv_7, grammarAccess.getResultReportAccess().getDescriptionKeyword_6_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:152:1: ( (lv_decription_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:153:1: (lv_decription_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:153:1: (lv_decription_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:154:3: lv_decription_8_0= RULE_STRING
                    {
                    lv_decription_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport258); 

                    			newLeafNode(lv_decription_8_0, grammarAccess.getResultReportAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"decription",
                            		lv_decription_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:170:4: (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultReportEntry ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:170:6: otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) ( (lv_content_11_0= ruleResultReportEntry ) )*
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleResultReport278); 

                        	newLeafNode(otherlv_9, grammarAccess.getResultReportAccess().getHeadingKeyword_7_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:174:1: ( (lv_heading_10_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:175:1: (lv_heading_10_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:175:1: (lv_heading_10_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:176:3: lv_heading_10_0= RULE_STRING
                    {
                    lv_heading_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReport295); 

                    			newLeafNode(lv_heading_10_0, grammarAccess.getResultReportAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"heading",
                            		lv_heading_10_0, 
                            		"STRING");
                    	    

                    }


                    }

                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:192:2: ( (lv_content_11_0= ruleResultReportEntry ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==19) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:193:1: (lv_content_11_0= ruleResultReportEntry )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:193:1: (lv_content_11_0= ruleResultReportEntry )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:194:3: lv_content_11_0= ruleResultReportEntry
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultReportAccess().getContentResultReportEntryParserRuleCall_7_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleResultReportEntry_in_ruleResultReport321);
                    	    lv_content_11_0=ruleResultReportEntry();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultReportRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"content",
                    	            		lv_content_11_0, 
                    	            		"ResultReportEntry");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:5: (otherlv_12= 'data' ( (lv_resultData_13_0= ruleResultData ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:210:7: otherlv_12= 'data' ( (lv_resultData_13_0= ruleResultData ) )
                    {
                    otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleResultReport337); 

                        	newLeafNode(otherlv_12, grammarAccess.getResultReportAccess().getDataKeyword_8_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:214:1: ( (lv_resultData_13_0= ruleResultData ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_resultData_13_0= ruleResultData )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:215:1: (lv_resultData_13_0= ruleResultData )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:216:3: lv_resultData_13_0= ruleResultData
                    {
                     
                    	        newCompositeNode(grammarAccess.getResultReportAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleResultData_in_ruleResultReport358);
                    lv_resultData_13_0=ruleResultData();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getResultReportRule());
                    	        }
                           		set(
                           			current, 
                           			"resultData",
                            		lv_resultData_13_0, 
                            		"ResultData");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_14=(Token)match(input,18,FOLLOW_18_in_ruleResultReport372); 

                	newLeafNode(otherlv_14, grammarAccess.getResultReportAccess().getRightSquareBracketKeyword_9());
                

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
    // $ANTLR end "ruleResultReport"


    // $ANTLR start "entryRuleResultReportEntry"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:244:1: entryRuleResultReportEntry returns [EObject current=null] : iv_ruleResultReportEntry= ruleResultReportEntry EOF ;
    public final EObject entryRuleResultReportEntry() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultReportEntry = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:245:2: (iv_ruleResultReportEntry= ruleResultReportEntry EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:246:2: iv_ruleResultReportEntry= ruleResultReportEntry EOF
            {
             newCompositeNode(grammarAccess.getResultReportEntryRule()); 
            pushFollow(FOLLOW_ruleResultReportEntry_in_entryRuleResultReportEntry408);
            iv_ruleResultReportEntry=ruleResultReportEntry();

            state._fsp--;

             current =iv_ruleResultReportEntry; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultReportEntry418); 

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
    // $ANTLR end "entryRuleResultReportEntry"


    // $ANTLR start "ruleResultReportEntry"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:253:1: ruleResultReportEntry returns [EObject current=null] : (otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) )? (otherlv_11= 'result' ( (lv_resultData_12_0= ruleResultData ) ) )? ( (lv_row_13_0= ruleResultContributor ) )* (otherlv_14= 'issues' ( (lv_issue_15_0= ruleReportIssue ) )* )? otherlv_16= ']' ) ;
    public final EObject ruleResultReportEntry() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_title_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_decription_8_0=null;
        Token otherlv_9=null;
        Token lv_heading_10_0=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_resultData_12_0 = null;

        EObject lv_row_13_0 = null;

        EObject lv_issue_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:256:28: ( (otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) )? (otherlv_11= 'result' ( (lv_resultData_12_0= ruleResultData ) ) )? ( (lv_row_13_0= ruleResultContributor ) )* (otherlv_14= 'issues' ( (lv_issue_15_0= ruleReportIssue ) )* )? otherlv_16= ']' ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:257:1: (otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) )? (otherlv_11= 'result' ( (lv_resultData_12_0= ruleResultData ) ) )? ( (lv_row_13_0= ruleResultContributor ) )* (otherlv_14= 'issues' ( (lv_issue_15_0= ruleReportIssue ) )* )? otherlv_16= ']' )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:257:1: (otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) )? (otherlv_11= 'result' ( (lv_resultData_12_0= ruleResultData ) ) )? ( (lv_row_13_0= ruleResultContributor ) )* (otherlv_14= 'issues' ( (lv_issue_15_0= ruleReportIssue ) )* )? otherlv_16= ']' )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:257:3: otherlv_0= 'entry' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )? otherlv_4= '[' otherlv_5= 'target' ( ( ruleURIID ) ) (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )? (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) )? (otherlv_11= 'result' ( (lv_resultData_12_0= ruleResultData ) ) )? ( (lv_row_13_0= ruleResultContributor ) )* (otherlv_14= 'issues' ( (lv_issue_15_0= ruleReportIssue ) )* )? otherlv_16= ']'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleResultReportEntry455); 

                	newLeafNode(otherlv_0, grammarAccess.getResultReportEntryAccess().getEntryKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:261:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:262:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:262:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:263:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleResultReportEntry472); 

            			newLeafNode(lv_name_1_0, grammarAccess.getResultReportEntryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportEntryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:279:2: (otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==12) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:279:4: otherlv_2= ':' ( (lv_title_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleResultReportEntry490); 

                        	newLeafNode(otherlv_2, grammarAccess.getResultReportEntryAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:283:1: ( (lv_title_3_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:284:1: (lv_title_3_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:284:1: (lv_title_3_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:285:3: lv_title_3_0= RULE_STRING
                    {
                    lv_title_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportEntry507); 

                    			newLeafNode(lv_title_3_0, grammarAccess.getResultReportEntryAccess().getTitleSTRINGTerminalRuleCall_2_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportEntryRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleResultReportEntry526); 

                	newLeafNode(otherlv_4, grammarAccess.getResultReportEntryAccess().getLeftSquareBracketKeyword_3());
                
            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleResultReportEntry538); 

                	newLeafNode(otherlv_5, grammarAccess.getResultReportEntryAccess().getTargetKeyword_4());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:309:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:310:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:310:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:311:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResultReportEntryRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResultReportEntryAccess().getTargetEObjectCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleResultReportEntry561);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:324:2: (otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:324:4: otherlv_7= 'description' ( (lv_decription_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleResultReportEntry574); 

                        	newLeafNode(otherlv_7, grammarAccess.getResultReportEntryAccess().getDescriptionKeyword_6_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:328:1: ( (lv_decription_8_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:329:1: (lv_decription_8_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:329:1: (lv_decription_8_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:330:3: lv_decription_8_0= RULE_STRING
                    {
                    lv_decription_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportEntry591); 

                    			newLeafNode(lv_decription_8_0, grammarAccess.getResultReportEntryAccess().getDecriptionSTRINGTerminalRuleCall_6_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportEntryRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"decription",
                            		lv_decription_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:346:4: (otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:346:6: otherlv_9= 'heading' ( (lv_heading_10_0= RULE_STRING ) )
                    {
                    otherlv_9=(Token)match(input,16,FOLLOW_16_in_ruleResultReportEntry611); 

                        	newLeafNode(otherlv_9, grammarAccess.getResultReportEntryAccess().getHeadingKeyword_7_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:350:1: ( (lv_heading_10_0= RULE_STRING ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:351:1: (lv_heading_10_0= RULE_STRING )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:351:1: (lv_heading_10_0= RULE_STRING )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:352:3: lv_heading_10_0= RULE_STRING
                    {
                    lv_heading_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultReportEntry628); 

                    			newLeafNode(lv_heading_10_0, grammarAccess.getResultReportEntryAccess().getHeadingSTRINGTerminalRuleCall_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getResultReportEntryRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"heading",
                            		lv_heading_10_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:368:4: (otherlv_11= 'result' ( (lv_resultData_12_0= ruleResultData ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:368:6: otherlv_11= 'result' ( (lv_resultData_12_0= ruleResultData ) )
                    {
                    otherlv_11=(Token)match(input,21,FOLLOW_21_in_ruleResultReportEntry648); 

                        	newLeafNode(otherlv_11, grammarAccess.getResultReportEntryAccess().getResultKeyword_8_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:372:1: ( (lv_resultData_12_0= ruleResultData ) )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:373:1: (lv_resultData_12_0= ruleResultData )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:373:1: (lv_resultData_12_0= ruleResultData )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:374:3: lv_resultData_12_0= ruleResultData
                    {
                     
                    	        newCompositeNode(grammarAccess.getResultReportEntryAccess().getResultDataResultDataParserRuleCall_8_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleResultData_in_ruleResultReportEntry669);
                    lv_resultData_12_0=ruleResultData();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getResultReportEntryRule());
                    	        }
                           		set(
                           			current, 
                           			"resultData",
                            		lv_resultData_12_0, 
                            		"ResultData");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:390:4: ( (lv_row_13_0= ruleResultContributor ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:391:1: (lv_row_13_0= ruleResultContributor )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:391:1: (lv_row_13_0= ruleResultContributor )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:392:3: lv_row_13_0= ruleResultContributor
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getResultReportEntryAccess().getRowResultContributorParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultReportEntry692);
            	    lv_row_13_0=ruleResultContributor();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getResultReportEntryRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"row",
            	            		lv_row_13_0, 
            	            		"ResultContributor");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:408:3: (otherlv_14= 'issues' ( (lv_issue_15_0= ruleReportIssue ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==22) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:408:5: otherlv_14= 'issues' ( (lv_issue_15_0= ruleReportIssue ) )*
                    {
                    otherlv_14=(Token)match(input,22,FOLLOW_22_in_ruleResultReportEntry706); 

                        	newLeafNode(otherlv_14, grammarAccess.getResultReportEntryAccess().getIssuesKeyword_10_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:412:1: ( (lv_issue_15_0= ruleReportIssue ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0>=25 && LA11_0<=28)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:413:1: (lv_issue_15_0= ruleReportIssue )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:413:1: (lv_issue_15_0= ruleReportIssue )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:414:3: lv_issue_15_0= ruleReportIssue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultReportEntryAccess().getIssueReportIssueParserRuleCall_10_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleReportIssue_in_ruleResultReportEntry727);
                    	    lv_issue_15_0=ruleReportIssue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultReportEntryRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issue",
                    	            		lv_issue_15_0, 
                    	            		"ReportIssue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,18,FOLLOW_18_in_ruleResultReportEntry742); 

                	newLeafNode(otherlv_16, grammarAccess.getResultReportEntryAccess().getRightSquareBracketKeyword_11());
                

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
    // $ANTLR end "ruleResultReportEntry"


    // $ANTLR start "entryRuleResultContributor"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:442:1: entryRuleResultContributor returns [EObject current=null] : iv_ruleResultContributor= ruleResultContributor EOF ;
    public final EObject entryRuleResultContributor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultContributor = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:443:2: (iv_ruleResultContributor= ruleResultContributor EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:444:2: iv_ruleResultContributor= ruleResultContributor EOF
            {
             newCompositeNode(grammarAccess.getResultContributorRule()); 
            pushFollow(FOLLOW_ruleResultContributor_in_entryRuleResultContributor778);
            iv_ruleResultContributor=ruleResultContributor();

            state._fsp--;

             current =iv_ruleResultContributor; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultContributor788); 

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
    // $ANTLR end "entryRuleResultContributor"


    // $ANTLR start "ruleResultContributor"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:451:1: ruleResultContributor returns [EObject current=null] : (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= 'data' ( (lv_cell_3_0= RULE_STRING ) )+ (otherlv_4= '[' ( (lv_subcontributor_5_0= ruleResultContributor ) )* otherlv_6= ']' )? ) ;
    public final EObject ruleResultContributor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_cell_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_subcontributor_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:454:28: ( (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= 'data' ( (lv_cell_3_0= RULE_STRING ) )+ (otherlv_4= '[' ( (lv_subcontributor_5_0= ruleResultContributor ) )* otherlv_6= ']' )? ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:455:1: (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= 'data' ( (lv_cell_3_0= RULE_STRING ) )+ (otherlv_4= '[' ( (lv_subcontributor_5_0= ruleResultContributor ) )* otherlv_6= ']' )? )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:455:1: (otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= 'data' ( (lv_cell_3_0= RULE_STRING ) )+ (otherlv_4= '[' ( (lv_subcontributor_5_0= ruleResultContributor ) )* otherlv_6= ']' )? )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:455:3: otherlv_0= 'contributor' ( ( ruleURIID ) ) otherlv_2= 'data' ( (lv_cell_3_0= RULE_STRING ) )+ (otherlv_4= '[' ( (lv_subcontributor_5_0= ruleResultContributor ) )* otherlv_6= ']' )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleResultContributor825); 

                	newLeafNode(otherlv_0, grammarAccess.getResultContributorAccess().getContributorKeyword_0());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:459:1: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:460:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:460:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:461:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getResultContributorRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getResultContributorAccess().getContributorEObjectCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleResultContributor848);
            ruleURIID();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleResultContributor860); 

                	newLeafNode(otherlv_2, grammarAccess.getResultContributorAccess().getDataKeyword_2());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:478:1: ( (lv_cell_3_0= RULE_STRING ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_STRING) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:479:1: (lv_cell_3_0= RULE_STRING )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:479:1: (lv_cell_3_0= RULE_STRING )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:480:3: lv_cell_3_0= RULE_STRING
            	    {
            	    lv_cell_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleResultContributor877); 

            	    			newLeafNode(lv_cell_3_0, grammarAccess.getResultContributorAccess().getCellSTRINGTerminalRuleCall_3_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getResultContributorRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"cell",
            	            		lv_cell_3_0, 
            	            		"STRING");
            	    	    

            	    }


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

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:496:3: (otherlv_4= '[' ( (lv_subcontributor_5_0= ruleResultContributor ) )* otherlv_6= ']' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==13) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:496:5: otherlv_4= '[' ( (lv_subcontributor_5_0= ruleResultContributor ) )* otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleResultContributor896); 

                        	newLeafNode(otherlv_4, grammarAccess.getResultContributorAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:500:1: ( (lv_subcontributor_5_0= ruleResultContributor ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==23) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:501:1: (lv_subcontributor_5_0= ruleResultContributor )
                    	    {
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:501:1: (lv_subcontributor_5_0= ruleResultContributor )
                    	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:502:3: lv_subcontributor_5_0= ruleResultContributor
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getResultContributorAccess().getSubcontributorResultContributorParserRuleCall_4_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleResultContributor_in_ruleResultContributor917);
                    	    lv_subcontributor_5_0=ruleResultContributor();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getResultContributorRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"subcontributor",
                    	            		lv_subcontributor_5_0, 
                    	            		"ResultContributor");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleResultContributor930); 

                        	newLeafNode(otherlv_6, grammarAccess.getResultContributorAccess().getRightSquareBracketKeyword_4_2());
                        

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
    // $ANTLR end "ruleResultContributor"


    // $ANTLR start "entryRuleReportIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:530:1: entryRuleReportIssue returns [EObject current=null] : iv_ruleReportIssue= ruleReportIssue EOF ;
    public final EObject entryRuleReportIssue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReportIssue = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:531:2: (iv_ruleReportIssue= ruleReportIssue EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:532:2: iv_ruleReportIssue= ruleReportIssue EOF
            {
             newCompositeNode(grammarAccess.getReportIssueRule()); 
            pushFollow(FOLLOW_ruleReportIssue_in_entryRuleReportIssue968);
            iv_ruleReportIssue=ruleReportIssue();

            state._fsp--;

             current =iv_ruleReportIssue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReportIssue978); 

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
    // $ANTLR end "entryRuleReportIssue"


    // $ANTLR start "ruleReportIssue"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:539:1: ruleReportIssue returns [EObject current=null] : ( ( (lv_issueType_0_0= ruleIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) ) ) ;
    public final EObject ruleReportIssue() throws RecognitionException {
        EObject current = null;

        Token lv_title_1_0=null;
        Enumerator lv_issueType_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:542:28: ( ( ( (lv_issueType_0_0= ruleIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:543:1: ( ( (lv_issueType_0_0= ruleIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:543:1: ( ( (lv_issueType_0_0= ruleIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:543:2: ( (lv_issueType_0_0= ruleIssueType ) ) ( (lv_title_1_0= RULE_STRING ) ) ( ( ruleURIID ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:543:2: ( (lv_issueType_0_0= ruleIssueType ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:544:1: (lv_issueType_0_0= ruleIssueType )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:544:1: (lv_issueType_0_0= ruleIssueType )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:545:3: lv_issueType_0_0= ruleIssueType
            {
             
            	        newCompositeNode(grammarAccess.getReportIssueAccess().getIssueTypeIssueTypeEnumRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleIssueType_in_ruleReportIssue1024);
            lv_issueType_0_0=ruleIssueType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReportIssueRule());
            	        }
                   		set(
                   			current, 
                   			"issueType",
                    		lv_issueType_0_0, 
                    		"IssueType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:561:2: ( (lv_title_1_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:562:1: (lv_title_1_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:562:1: (lv_title_1_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:563:3: lv_title_1_0= RULE_STRING
            {
            lv_title_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleReportIssue1041); 

            			newLeafNode(lv_title_1_0, grammarAccess.getReportIssueAccess().getTitleSTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReportIssueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"title",
                    		lv_title_1_0, 
                    		"STRING");
            	    

            }


            }

            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:579:2: ( ( ruleURIID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:580:1: ( ruleURIID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:580:1: ( ruleURIID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:581:3: ruleURIID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReportIssueRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getReportIssueAccess().getTargetEObjectCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleURIID_in_ruleReportIssue1069);
            ruleURIID();

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
    // $ANTLR end "ruleReportIssue"


    // $ANTLR start "entryRuleResultData"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:602:1: entryRuleResultData returns [EObject current=null] : iv_ruleResultData= ruleResultData EOF ;
    public final EObject entryRuleResultData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultData = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:603:2: (iv_ruleResultData= ruleResultData EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:604:2: iv_ruleResultData= ruleResultData EOF
            {
             newCompositeNode(grammarAccess.getResultDataRule()); 
            pushFollow(FOLLOW_ruleResultData_in_entryRuleResultData1105);
            iv_ruleResultData=ruleResultData();

            state._fsp--;

             current =iv_ruleResultData; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultData1115); 

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
    // $ANTLR end "entryRuleResultData"


    // $ANTLR start "ruleResultData"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:611:1: ruleResultData returns [EObject current=null] : ( (lv_data_0_0= ruleNameValuePair ) )+ ;
    public final EObject ruleResultData() throws RecognitionException {
        EObject current = null;

        EObject lv_data_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:614:28: ( ( (lv_data_0_0= ruleNameValuePair ) )+ )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:1: ( (lv_data_0_0= ruleNameValuePair ) )+
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:615:1: ( (lv_data_0_0= ruleNameValuePair ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:1: (lv_data_0_0= ruleNameValuePair )
            	    {
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:616:1: (lv_data_0_0= ruleNameValuePair )
            	    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:617:3: lv_data_0_0= ruleNameValuePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getResultDataAccess().getDataNameValuePairParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNameValuePair_in_ruleResultData1160);
            	    lv_data_0_0=ruleNameValuePair();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getResultDataRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"data",
            	            		lv_data_0_0, 
            	            		"NameValuePair");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
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
    // $ANTLR end "ruleResultData"


    // $ANTLR start "entryRuleNameValuePair"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:641:1: entryRuleNameValuePair returns [EObject current=null] : iv_ruleNameValuePair= ruleNameValuePair EOF ;
    public final EObject entryRuleNameValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameValuePair = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:642:2: (iv_ruleNameValuePair= ruleNameValuePair EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:643:2: iv_ruleNameValuePair= ruleNameValuePair EOF
            {
             newCompositeNode(grammarAccess.getNameValuePairRule()); 
            pushFollow(FOLLOW_ruleNameValuePair_in_entryRuleNameValuePair1196);
            iv_ruleNameValuePair=ruleNameValuePair();

            state._fsp--;

             current =iv_ruleNameValuePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameValuePair1206); 

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
    // $ANTLR end "entryRuleNameValuePair"


    // $ANTLR start "ruleNameValuePair"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:650:1: ruleNameValuePair returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleNameValuePair() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:653:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:654:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:654:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:654:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:654:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:655:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:655:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:656:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleNameValuePair1248); 

            			newLeafNode(lv_name_0_0, grammarAccess.getNameValuePairAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNameValuePairRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleNameValuePair1265); 

                	newLeafNode(otherlv_1, grammarAccess.getNameValuePairAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:676:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:677:1: (lv_value_2_0= RULE_STRING )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:677:1: (lv_value_2_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:678:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleNameValuePair1282); 

            			newLeafNode(lv_value_2_0, grammarAccess.getNameValuePairAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNameValuePairRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
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
    // $ANTLR end "ruleNameValuePair"


    // $ANTLR start "entryRuleURIID"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:702:1: entryRuleURIID returns [String current=null] : iv_ruleURIID= ruleURIID EOF ;
    public final String entryRuleURIID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleURIID = null;


        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:703:2: (iv_ruleURIID= ruleURIID EOF )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:704:2: iv_ruleURIID= ruleURIID EOF
            {
             newCompositeNode(grammarAccess.getURIIDRule()); 
            pushFollow(FOLLOW_ruleURIID_in_entryRuleURIID1324);
            iv_ruleURIID=ruleURIID();

            state._fsp--;

             current =iv_ruleURIID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleURIID1335); 

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
    // $ANTLR end "entryRuleURIID"


    // $ANTLR start "ruleURIID"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:711:1: ruleURIID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleURIID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:714:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:715:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleURIID1374); 

            		current.merge(this_STRING_0);
                
             
                newLeafNode(this_STRING_0, grammarAccess.getURIIDAccess().getSTRINGTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleURIID"


    // $ANTLR start "ruleIssueType"
    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:730:1: ruleIssueType returns [Enumerator current=null] : ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'success' ) | (enumLiteral_3= 'info' ) ) ;
    public final Enumerator ruleIssueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:732:28: ( ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'success' ) | (enumLiteral_3= 'info' ) ) )
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:733:1: ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'success' ) | (enumLiteral_3= 'info' ) )
            {
            // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:733:1: ( (enumLiteral_0= 'error' ) | (enumLiteral_1= 'warning' ) | (enumLiteral_2= 'success' ) | (enumLiteral_3= 'info' ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt17=1;
                }
                break;
            case 26:
                {
                alt17=2;
                }
                break;
            case 27:
                {
                alt17=3;
                }
                break;
            case 28:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:733:2: (enumLiteral_0= 'error' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:733:2: (enumLiteral_0= 'error' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:733:4: enumLiteral_0= 'error'
                    {
                    enumLiteral_0=(Token)match(input,25,FOLLOW_25_in_ruleIssueType1432); 

                            current = grammarAccess.getIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:739:6: (enumLiteral_1= 'warning' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:739:6: (enumLiteral_1= 'warning' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:739:8: enumLiteral_1= 'warning'
                    {
                    enumLiteral_1=(Token)match(input,26,FOLLOW_26_in_ruleIssueType1449); 

                            current = grammarAccess.getIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:745:6: (enumLiteral_2= 'success' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:745:6: (enumLiteral_2= 'success' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:745:8: enumLiteral_2= 'success'
                    {
                    enumLiteral_2=(Token)match(input,27,FOLLOW_27_in_ruleIssueType1466); 

                            current = grammarAccess.getIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getIssueTypeAccess().getSUCCESSEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:751:6: (enumLiteral_3= 'info' )
                    {
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:751:6: (enumLiteral_3= 'info' )
                    // ../org.osate.results/src-gen/org/osate/results/parser/antlr/internal/InternalResults.g:751:8: enumLiteral_3= 'info'
                    {
                    enumLiteral_3=(Token)match(input,28,FOLLOW_28_in_ruleIssueType1483); 

                            current = grammarAccess.getIssueTypeAccess().getINFOEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getIssueTypeAccess().getINFOEnumLiteralDeclaration_3()); 
                        

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
    // $ANTLR end "ruleIssueType"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleResultReport_in_entryRuleResultReport75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReport85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleResultReport122 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultReport139 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleResultReport157 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport174 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleResultReport193 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleResultReport205 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultReport228 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_15_in_ruleResultReport241 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport258 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_16_in_ruleResultReport278 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReport295 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_ruleResultReportEntry_in_ruleResultReport321 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_17_in_ruleResultReport337 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultReport358 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleResultReport372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultReportEntry_in_entryRuleResultReportEntry408 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultReportEntry418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleResultReportEntry455 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleResultReportEntry472 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleResultReportEntry490 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportEntry507 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleResultReportEntry526 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleResultReportEntry538 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultReportEntry561 = new BitSet(new long[]{0x0000000000E58000L});
    public static final BitSet FOLLOW_15_in_ruleResultReportEntry574 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportEntry591 = new BitSet(new long[]{0x0000000000E50000L});
    public static final BitSet FOLLOW_16_in_ruleResultReportEntry611 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultReportEntry628 = new BitSet(new long[]{0x0000000000E40000L});
    public static final BitSet FOLLOW_21_in_ruleResultReportEntry648 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleResultData_in_ruleResultReportEntry669 = new BitSet(new long[]{0x0000000000C40000L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultReportEntry692 = new BitSet(new long[]{0x0000000000C40000L});
    public static final BitSet FOLLOW_22_in_ruleResultReportEntry706 = new BitSet(new long[]{0x000000001E040000L});
    public static final BitSet FOLLOW_ruleReportIssue_in_ruleResultReportEntry727 = new BitSet(new long[]{0x000000001E040000L});
    public static final BitSet FOLLOW_18_in_ruleResultReportEntry742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultContributor_in_entryRuleResultContributor778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultContributor788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleResultContributor825 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleResultContributor848 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleResultContributor860 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleResultContributor877 = new BitSet(new long[]{0x0000000000002022L});
    public static final BitSet FOLLOW_13_in_ruleResultContributor896 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_ruleResultContributor_in_ruleResultContributor917 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_18_in_ruleResultContributor930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReportIssue_in_entryRuleReportIssue968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReportIssue978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIssueType_in_ruleReportIssue1024 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleReportIssue1041 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleURIID_in_ruleReportIssue1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultData_in_entryRuleResultData1105 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultData1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameValuePair_in_ruleResultData1160 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleNameValuePair_in_entryRuleNameValuePair1196 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameValuePair1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleNameValuePair1248 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleNameValuePair1265 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleNameValuePair1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleURIID_in_entryRuleURIID1324 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleURIID1335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleURIID1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleIssueType1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleIssueType1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleIssueType1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleIssueType1483 = new BitSet(new long[]{0x0000000000000002L});

}