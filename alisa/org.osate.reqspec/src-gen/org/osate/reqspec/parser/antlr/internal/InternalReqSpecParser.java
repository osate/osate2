package org.osate.reqspec.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.reqspec.services.ReqSpecGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReqSpecParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'container'", "'['", "'for'", "'issues'", "','", "']'", "'val'", "'='", "'goal'", "'category'", "'title'", "'description'", "'assertion'", "'rationale'", "'refined'", "'to'", "'decomposed'", "'evolves'", "'conflicts'", "'stakeholder'", "'see'", "'requirement'", "'document'", "'hazard'", "'refines'", "'decomposes'", "'mitigated'", "'by'", "'#'", "'/'", "'.'", "'::'"
    };
    public static final int T__42=42;
    public static final int RULE_ID=4;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__29=29;
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
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__37=37;
    public static final int T__12=12;
    public static final int T__38=38;
    public static final int T__11=11;
    public static final int T__39=39;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalReqSpecParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReqSpecParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReqSpecParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g"; }



     	private ReqSpecGrammarAccess grammarAccess;
     	
        public InternalReqSpecParser(TokenStream input, ReqSpecGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "ReqSpecModel";	
       	}
       	
       	@Override
       	protected ReqSpecGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleReqSpecModel"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:67:1: entryRuleReqSpecModel returns [EObject current=null] : iv_ruleReqSpecModel= ruleReqSpecModel EOF ;
    public final EObject entryRuleReqSpecModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecModel = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:68:2: (iv_ruleReqSpecModel= ruleReqSpecModel EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:69:2: iv_ruleReqSpecModel= ruleReqSpecModel EOF
            {
             newCompositeNode(grammarAccess.getReqSpecModelRule()); 
            pushFollow(FOLLOW_ruleReqSpecModel_in_entryRuleReqSpecModel75);
            iv_ruleReqSpecModel=ruleReqSpecModel();

            state._fsp--;

             current =iv_ruleReqSpecModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecModel85); 

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
    // $ANTLR end "entryRuleReqSpecModel"


    // $ANTLR start "ruleReqSpecModel"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:76:1: ruleReqSpecModel returns [EObject current=null] : this_ReqSpecContainer_0= ruleReqSpecContainer ;
    public final EObject ruleReqSpecModel() throws RecognitionException {
        EObject current = null;

        EObject this_ReqSpecContainer_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:79:28: (this_ReqSpecContainer_0= ruleReqSpecContainer )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:81:5: this_ReqSpecContainer_0= ruleReqSpecContainer
            {
             
                    newCompositeNode(grammarAccess.getReqSpecModelAccess().getReqSpecContainerParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleReqSpecContainer_in_ruleReqSpecModel131);
            this_ReqSpecContainer_0=ruleReqSpecContainer();

            state._fsp--;

             
                    current = this_ReqSpecContainer_0; 
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleReqSpecModel"


    // $ANTLR start "entryRuleReqSpecContainer"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:99:1: entryRuleReqSpecContainer returns [EObject current=null] : iv_ruleReqSpecContainer= ruleReqSpecContainer EOF ;
    public final EObject entryRuleReqSpecContainer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecContainer = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:100:2: (iv_ruleReqSpecContainer= ruleReqSpecContainer EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:101:2: iv_ruleReqSpecContainer= ruleReqSpecContainer EOF
            {
             newCompositeNode(grammarAccess.getReqSpecContainerRule()); 
            pushFollow(FOLLOW_ruleReqSpecContainer_in_entryRuleReqSpecContainer167);
            iv_ruleReqSpecContainer=ruleReqSpecContainer();

            state._fsp--;

             current =iv_ruleReqSpecContainer; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecContainer177); 

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
    // $ANTLR end "entryRuleReqSpecContainer"


    // $ANTLR start "ruleReqSpecContainer"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:108:1: ruleReqSpecContainer returns [EObject current=null] : (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' (otherlv_3= 'for' ( ( ruleQNEREF ) ) )? ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer ) ) )* (otherlv_6= 'issues' otherlv_7= '[' ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= ']' )? otherlv_12= ']' ) ;
    public final EObject ruleReqSpecContainer() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_content_5_1 = null;

        EObject lv_content_5_2 = null;

        EObject lv_content_5_3 = null;

        AntlrDatatypeRuleToken lv_issue_8_0 = null;

        AntlrDatatypeRuleToken lv_issue_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:111:28: ( (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' (otherlv_3= 'for' ( ( ruleQNEREF ) ) )? ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer ) ) )* (otherlv_6= 'issues' otherlv_7= '[' ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= ']' )? otherlv_12= ']' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:112:1: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' (otherlv_3= 'for' ( ( ruleQNEREF ) ) )? ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer ) ) )* (otherlv_6= 'issues' otherlv_7= '[' ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= ']' )? otherlv_12= ']' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:112:1: (otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' (otherlv_3= 'for' ( ( ruleQNEREF ) ) )? ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer ) ) )* (otherlv_6= 'issues' otherlv_7= '[' ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= ']' )? otherlv_12= ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:112:3: otherlv_0= 'container' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' (otherlv_3= 'for' ( ( ruleQNEREF ) ) )? ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer ) ) )* (otherlv_6= 'issues' otherlv_7= '[' ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= ']' )? otherlv_12= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleReqSpecContainer214); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecContainerAccess().getContainerKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:116:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:117:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:117:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:118:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecContainer231); 

            			newLeafNode(lv_name_1_0, grammarAccess.getReqSpecContainerAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReqSpecContainerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleReqSpecContainer248); 

                	newLeafNode(otherlv_2, grammarAccess.getReqSpecContainerAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:138:1: (otherlv_3= 'for' ( ( ruleQNEREF ) ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:138:3: otherlv_3= 'for' ( ( ruleQNEREF ) )
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleReqSpecContainer261); 

                        	newLeafNode(otherlv_3, grammarAccess.getReqSpecContainerAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:142:1: ( ( ruleQNEREF ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:143:1: ( ruleQNEREF )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:143:1: ( ruleQNEREF )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:144:3: ruleQNEREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecContainerRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecContainerAccess().getTargetNamedElementCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQNEREF_in_ruleReqSpecContainer284);
                    ruleQNEREF();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:157:4: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11||LA3_0==19||LA3_0==32) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:158:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:158:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:159:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:159:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecContainer )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case 19:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case 11:
            	        {
            	        alt2=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:160:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecContainerAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecContainer309);
            	            lv_content_5_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecContainerRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_1, 
            	                    		"Goal");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:175:8: lv_content_5_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecContainerAccess().getContentRequirementParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecContainer328);
            	            lv_content_5_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecContainerRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_2, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:190:8: lv_content_5_3= ruleReqSpecContainer
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecContainerAccess().getContentReqSpecContainerParserRuleCall_4_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecContainer_in_ruleReqSpecContainer347);
            	            lv_content_5_3=ruleReqSpecContainer();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecContainerRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_3, 
            	                    		"ReqSpecContainer");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:208:3: (otherlv_6= 'issues' otherlv_7= '[' ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= ']' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:208:5: otherlv_6= 'issues' otherlv_7= '[' ( (lv_issue_8_0= ruleValueString ) ) (otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) ) )* otherlv_11= ']'
                    {
                    otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleReqSpecContainer364); 

                        	newLeafNode(otherlv_6, grammarAccess.getReqSpecContainerAccess().getIssuesKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,12,FOLLOW_12_in_ruleReqSpecContainer376); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecContainerAccess().getLeftSquareBracketKeyword_5_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:216:1: ( (lv_issue_8_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:217:1: (lv_issue_8_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:217:1: (lv_issue_8_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:218:3: lv_issue_8_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecContainerAccess().getIssueValueStringParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecContainer397);
                    lv_issue_8_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecContainerRule());
                    	        }
                           		add(
                           			current, 
                           			"issue",
                            		lv_issue_8_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:234:2: (otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==15) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:234:4: otherlv_9= ',' ( (lv_issue_10_0= ruleValueString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,15,FOLLOW_15_in_ruleReqSpecContainer410); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getReqSpecContainerAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:238:1: ( (lv_issue_10_0= ruleValueString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:239:1: (lv_issue_10_0= ruleValueString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:239:1: (lv_issue_10_0= ruleValueString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:240:3: lv_issue_10_0= ruleValueString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecContainerAccess().getIssueValueStringParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecContainer431);
                    	    lv_issue_10_0=ruleValueString();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecContainerRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issue",
                    	            		lv_issue_10_0, 
                    	            		"ValueString");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,16,FOLLOW_16_in_ruleReqSpecContainer445); 

                        	newLeafNode(otherlv_11, grammarAccess.getReqSpecContainerAccess().getRightSquareBracketKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,16,FOLLOW_16_in_ruleReqSpecContainer459); 

                	newLeafNode(otherlv_12, grammarAccess.getReqSpecContainerAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleReqSpecContainer"


    // $ANTLR start "entryRuleRSLVariable"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:272:1: entryRuleRSLVariable returns [EObject current=null] : iv_ruleRSLVariable= ruleRSLVariable EOF ;
    public final EObject entryRuleRSLVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRSLVariable = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:273:2: (iv_ruleRSLVariable= ruleRSLVariable EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:274:2: iv_ruleRSLVariable= ruleRSLVariable EOF
            {
             newCompositeNode(grammarAccess.getRSLVariableRule()); 
            pushFollow(FOLLOW_ruleRSLVariable_in_entryRuleRSLVariable495);
            iv_ruleRSLVariable=ruleRSLVariable();

            state._fsp--;

             current =iv_ruleRSLVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRSLVariable505); 

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
    // $ANTLR end "entryRuleRSLVariable"


    // $ANTLR start "ruleRSLVariable"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:281:1: ruleRSLVariable returns [EObject current=null] : (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueString ) ) ) ;
    public final EObject ruleRSLVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:284:28: ( (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueString ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:285:1: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueString ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:285:1: (otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueString ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:285:3: otherlv_0= 'val' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_value_3_0= ruleValueString ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleRSLVariable542); 

                	newLeafNode(otherlv_0, grammarAccess.getRSLVariableAccess().getValKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:289:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:290:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:290:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:291:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRSLVariable559); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRSLVariableAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRSLVariableRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleRSLVariable576); 

                	newLeafNode(otherlv_2, grammarAccess.getRSLVariableAccess().getEqualsSignKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:311:1: ( (lv_value_3_0= ruleValueString ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:312:1: (lv_value_3_0= ruleValueString )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:312:1: (lv_value_3_0= ruleValueString )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:313:3: lv_value_3_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getRSLVariableAccess().getValueValueStringParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleRSLVariable597);
            lv_value_3_0=ruleValueString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRSLVariableRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"ValueString");
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
    // $ANTLR end "ruleRSLVariable"


    // $ANTLR start "entryRuleGoal"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:337:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:338:2: (iv_ruleGoal= ruleGoal EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:339:2: iv_ruleGoal= ruleGoal EOF
            {
             newCompositeNode(grammarAccess.getGoalRule()); 
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal633);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal643); 

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
    // $ANTLR end "entryRuleGoal"


    // $ANTLR start "ruleGoal"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:346:1: ruleGoal returns [EObject current=null] : (otherlv_0= 'goal' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= ']' ) ;
    public final EObject ruleGoal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        Token otherlv_54=null;
        Token otherlv_56=null;
        Token otherlv_58=null;
        AntlrDatatypeRuleToken lv_title_9_0 = null;

        EObject lv_description_11_0 = null;

        AntlrDatatypeRuleToken lv_assert_13_0 = null;

        AntlrDatatypeRuleToken lv_rationale_15_0 = null;

        AntlrDatatypeRuleToken lv_issue_17_0 = null;

        AntlrDatatypeRuleToken lv_issue_19_0 = null;

        EObject lv_subgoal_25_0 = null;

        EObject lv_docReference_55_0 = null;

        EObject lv_docReference_57_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:349:28: ( (otherlv_0= 'goal' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= ']' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:350:1: (otherlv_0= 'goal' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= ']' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:350:1: (otherlv_0= 'goal' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:350:3: otherlv_0= 'goal' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_58= ']'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleGoal680); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:354:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:355:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:355:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:356:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal697); 

            			newLeafNode(lv_name_1_0, grammarAccess.getGoalAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGoalRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleGoal714); 

                	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:376:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:378:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:378:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:379:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:382:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:383:3: ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:383:3: ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop16:
            do {
                int alt16=17;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:385:4: ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:385:4: ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:386:5: {...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:386:101: ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:387:6: ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:390:6: ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:390:7: {...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:390:16: (otherlv_4= 'for' ( ( ruleQNEREF ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:390:18: otherlv_4= 'for' ( ( ruleQNEREF ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleGoal772); 

            	        	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:394:1: ( ( ruleQNEREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:395:1: ( ruleQNEREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:395:1: ( ruleQNEREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:396:3: ruleQNEREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQNEREF_in_ruleGoal795);
            	    ruleQNEREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:416:4: ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:416:4: ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:417:5: {...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:417:101: ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:418:6: ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:421:6: ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:421:7: {...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:421:16: (otherlv_6= 'category' ( ( ruleCATREF ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:421:18: otherlv_6= 'category' ( ( ruleCATREF ) )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleGoal863); 

            	        	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:425:1: ( ( ruleCATREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:426:1: ( ruleCATREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:426:1: ( ruleCATREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:427:3: ruleCATREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCATREF_in_ruleGoal886);
            	    ruleCATREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:447:4: ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:447:4: ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:448:5: {...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:448:101: ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:449:6: ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:452:6: ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:452:7: {...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:452:16: (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:452:18: otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleGoal954); 

            	        	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:456:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:457:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:457:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:458:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal975);
            	    lv_title_9_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_9_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:481:4: ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:481:4: ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:482:5: {...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:482:101: ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:483:6: ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:486:6: ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:486:7: {...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:486:16: (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:486:18: otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleGoal1043); 

            	        	newLeafNode(otherlv_10, grammarAccess.getGoalAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:490:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:491:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:491:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:492:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal1064);
            	    lv_description_11_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_11_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:515:4: ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:515:4: ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:516:5: {...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:516:101: ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:517:6: ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:520:6: ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:520:7: {...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:520:16: (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:520:18: otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) )
            	    {
            	    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleGoal1132); 

            	        	newLeafNode(otherlv_12, grammarAccess.getGoalAccess().getAssertionKeyword_3_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:524:1: ( (lv_assert_13_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:525:1: (lv_assert_13_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:525:1: (lv_assert_13_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:526:3: lv_assert_13_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getAssertValueStringParserRuleCall_3_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1153);
            	    lv_assert_13_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_13_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:549:4: ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:549:4: ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:550:5: {...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:550:101: ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:551:6: ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:554:6: ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:554:7: {...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:554:16: (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:554:18: otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) )
            	    {
            	    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleGoal1221); 

            	        	newLeafNode(otherlv_14, grammarAccess.getGoalAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:558:1: ( (lv_rationale_15_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:559:1: (lv_rationale_15_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:559:1: (lv_rationale_15_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:560:3: lv_rationale_15_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleValueStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1242);
            	    lv_rationale_15_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_15_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:583:4: ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:583:4: ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:584:5: {...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:584:101: ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:585:6: ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:588:6: ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:588:7: {...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:588:16: (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:588:18: otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )*
            	    {
            	    otherlv_16=(Token)match(input,14,FOLLOW_14_in_ruleGoal1310); 

            	        	newLeafNode(otherlv_16, grammarAccess.getGoalAccess().getIssuesKeyword_3_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:592:1: ( (lv_issue_17_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:593:1: (lv_issue_17_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:593:1: (lv_issue_17_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:594:3: lv_issue_17_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueValueStringParserRuleCall_3_6_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1331);
            	    lv_issue_17_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_17_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:610:2: (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==15) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:610:4: otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_18=(Token)match(input,15,FOLLOW_15_in_ruleGoal1344); 

            	    	        	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getCommaKeyword_3_6_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:614:1: ( (lv_issue_19_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:615:1: (lv_issue_19_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:615:1: (lv_issue_19_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:616:3: lv_issue_19_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueValueStringParserRuleCall_3_6_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1365);
            	    	    lv_issue_19_0=ruleValueString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_19_0, 
            	    	            		"ValueString");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:639:4: ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:639:4: ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:640:5: {...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:640:101: ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:641:6: ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:644:6: ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:644:7: {...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:644:16: (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:644:18: otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_20=(Token)match(input,25,FOLLOW_25_in_ruleGoal1435); 

            	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getRefinedKeyword_3_7_0());
            	        
            	    otherlv_21=(Token)match(input,26,FOLLOW_26_in_ruleGoal1447); 

            	        	newLeafNode(otherlv_21, grammarAccess.getGoalAccess().getToKeyword_3_7_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:652:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:653:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:653:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:654:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_3_7_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal1470);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:667:2: (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==15) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:667:4: otherlv_23= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_23=(Token)match(input,15,FOLLOW_15_in_ruleGoal1483); 

            	    	        	newLeafNode(otherlv_23, grammarAccess.getGoalAccess().getCommaKeyword_3_7_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:671:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:672:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:672:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:673:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_3_7_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal1506);
            	    	    ruleDOTTEDREF();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:693:4: ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:693:4: ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:694:5: {...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:694:101: ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:695:6: ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:698:6: ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==19) ) {
            	            int LA8_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt8=1;
            	            }


            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:698:7: {...}? => ( (lv_subgoal_25_0= ruleGoal ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:698:16: ( (lv_subgoal_25_0= ruleGoal ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:699:1: (lv_subgoal_25_0= ruleGoal )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:699:1: (lv_subgoal_25_0= ruleGoal )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:700:3: lv_subgoal_25_0= ruleGoal
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSubgoalGoalParserRuleCall_3_8_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleGoal_in_ruleGoal1584);
            	    	    lv_subgoal_25_0=ruleGoal();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subgoal",
            	    	            		lv_subgoal_25_0, 
            	    	            		"Goal");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:723:4: ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:723:4: ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:724:5: {...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:724:101: ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:725:6: ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:728:6: ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:728:7: {...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:728:16: (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:728:18: otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_26=(Token)match(input,27,FOLLOW_27_in_ruleGoal1652); 

            	        	newLeafNode(otherlv_26, grammarAccess.getGoalAccess().getDecomposedKeyword_3_9_0());
            	        
            	    otherlv_27=(Token)match(input,26,FOLLOW_26_in_ruleGoal1664); 

            	        	newLeafNode(otherlv_27, grammarAccess.getGoalAccess().getToKeyword_3_9_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:736:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:737:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:737:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:738:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_3_9_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal1687);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:751:2: (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==15) ) {
            	            alt9=1;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:751:4: otherlv_29= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_29=(Token)match(input,15,FOLLOW_15_in_ruleGoal1700); 

            	    	        	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getCommaKeyword_3_9_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:755:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:756:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:756:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:757:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_3_9_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal1723);
            	    	    ruleDOTTEDREF();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop9;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:777:4: ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:777:4: ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:778:5: {...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:778:102: ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:779:6: ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:782:6: ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:782:7: {...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:782:16: (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:782:18: otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_31=(Token)match(input,28,FOLLOW_28_in_ruleGoal1793); 

            	        	newLeafNode(otherlv_31, grammarAccess.getGoalAccess().getEvolvesKeyword_3_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:786:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:787:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:787:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:788:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_3_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal1816);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:801:2: (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==15) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:801:4: otherlv_33= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,15,FOLLOW_15_in_ruleGoal1829); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getGoalAccess().getCommaKeyword_3_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:805:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:806:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:806:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:807:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_3_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal1852);
            	    	    ruleDOTTEDREF();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop10;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:827:4: ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:827:4: ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:828:5: {...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:828:102: ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:829:6: ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:832:6: ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:832:7: {...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:832:16: (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:832:18: otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_35=(Token)match(input,29,FOLLOW_29_in_ruleGoal1922); 

            	        	newLeafNode(otherlv_35, grammarAccess.getGoalAccess().getConflictsKeyword_3_11_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:836:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:837:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:837:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:838:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_3_11_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal1945);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:851:2: (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==15) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:851:4: otherlv_37= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_37=(Token)match(input,15,FOLLOW_15_in_ruleGoal1958); 

            	    	        	newLeafNode(otherlv_37, grammarAccess.getGoalAccess().getCommaKeyword_3_11_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:855:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:856:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:856:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:857:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_3_11_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal1981);
            	    	    ruleDOTTEDREF();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop11;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:877:4: ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:877:4: ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:878:5: {...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:878:102: ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:879:6: ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:882:6: ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:882:7: {...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:882:16: (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:882:18: otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_39=(Token)match(input,30,FOLLOW_30_in_ruleGoal2051); 

            	        	newLeafNode(otherlv_39, grammarAccess.getGoalAccess().getStakeholderKeyword_3_12_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:886:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:887:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:887:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:888:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_3_12_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal2074);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:901:2: (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==15) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:901:4: otherlv_41= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,15,FOLLOW_15_in_ruleGoal2087); 

            	    	        	newLeafNode(otherlv_41, grammarAccess.getGoalAccess().getCommaKeyword_3_12_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:905:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:906:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:906:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:907:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_3_12_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal2110);
            	    	    ruleDOTTEDREF();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop12;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:927:4: ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:927:4: ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:928:5: {...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:928:102: ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:929:6: ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:932:6: ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:932:7: {...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:932:16: (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:932:18: otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_43=(Token)match(input,31,FOLLOW_31_in_ruleGoal2180); 

            	        	newLeafNode(otherlv_43, grammarAccess.getGoalAccess().getSeeKeyword_3_13_0());
            	        
            	    otherlv_44=(Token)match(input,19,FOLLOW_19_in_ruleGoal2192); 

            	        	newLeafNode(otherlv_44, grammarAccess.getGoalAccess().getGoalKeyword_3_13_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:940:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:941:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:941:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:942:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_3_13_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal2215);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:955:2: (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( (LA13_0==15) ) {
            	            alt13=1;
            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:955:4: otherlv_46= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_46=(Token)match(input,15,FOLLOW_15_in_ruleGoal2228); 

            	    	        	newLeafNode(otherlv_46, grammarAccess.getGoalAccess().getCommaKeyword_3_13_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:959:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:960:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:960:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:961:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_3_13_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal2251);
            	    	    ruleDOTTEDREF();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop13;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:981:4: ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:981:4: ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:982:5: {...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 14)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:982:102: ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:983:6: ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 14);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:986:6: ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:986:7: {...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:986:16: (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:986:18: otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_48=(Token)match(input,31,FOLLOW_31_in_ruleGoal2321); 

            	        	newLeafNode(otherlv_48, grammarAccess.getGoalAccess().getSeeKeyword_3_14_0());
            	        
            	    otherlv_49=(Token)match(input,32,FOLLOW_32_in_ruleGoal2333); 

            	        	newLeafNode(otherlv_49, grammarAccess.getGoalAccess().getRequirementKeyword_3_14_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:994:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:995:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:995:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:996:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_3_14_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal2356);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1009:2: (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==15) ) {
            	            alt14=1;
            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1009:4: otherlv_51= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_51=(Token)match(input,15,FOLLOW_15_in_ruleGoal2369); 

            	    	        	newLeafNode(otherlv_51, grammarAccess.getGoalAccess().getCommaKeyword_3_14_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1013:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1014:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1014:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1015:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_3_14_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleGoal2392);
            	    	    ruleDOTTEDREF();

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


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 16 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1035:4: ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1035:4: ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1036:5: {...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 15)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1036:102: ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1037:6: ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 15);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1040:6: ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1040:7: {...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1040:16: (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1040:18: otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_53=(Token)match(input,31,FOLLOW_31_in_ruleGoal2462); 

            	        	newLeafNode(otherlv_53, grammarAccess.getGoalAccess().getSeeKeyword_3_15_0());
            	        
            	    otherlv_54=(Token)match(input,33,FOLLOW_33_in_ruleGoal2474); 

            	        	newLeafNode(otherlv_54, grammarAccess.getGoalAccess().getDocumentKeyword_3_15_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1048:1: ( (lv_docReference_55_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1049:1: (lv_docReference_55_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1049:1: (lv_docReference_55_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1050:3: lv_docReference_55_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_3_15_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal2495);
            	    lv_docReference_55_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_55_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1066:2: (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==15) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1066:4: otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_56=(Token)match(input,15,FOLLOW_15_in_ruleGoal2508); 

            	    	        	newLeafNode(otherlv_56, grammarAccess.getGoalAccess().getCommaKeyword_3_15_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1070:1: ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1071:1: (lv_docReference_57_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1071:1: (lv_docReference_57_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1072:3: lv_docReference_57_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_3_15_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal2529);
            	    	    lv_docReference_57_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_57_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop15;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_3());
            	

            }

            otherlv_58=(Token)match(input,16,FOLLOW_16_in_ruleGoal2584); 

                	newLeafNode(otherlv_58, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleGoal"


    // $ANTLR start "entryRuleRequirement"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1114:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1115:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1116:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement2620);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement2630); 

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
    // $ANTLR end "entryRuleRequirement"


    // $ANTLR start "ruleRequirement"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1123:1: ruleRequirement returns [EObject current=null] : (otherlv_0= 'requirement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= ']' ) ;
    public final EObject ruleRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_40=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_45=null;
        Token otherlv_47=null;
        Token otherlv_49=null;
        Token otherlv_50=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_55=null;
        Token otherlv_57=null;
        Token otherlv_59=null;
        AntlrDatatypeRuleToken lv_title_9_0 = null;

        EObject lv_description_11_0 = null;

        AntlrDatatypeRuleToken lv_assert_13_0 = null;

        AntlrDatatypeRuleToken lv_rationale_15_0 = null;

        EObject lv_reqValue_16_0 = null;

        AntlrDatatypeRuleToken lv_issue_18_0 = null;

        AntlrDatatypeRuleToken lv_issue_20_0 = null;

        AntlrDatatypeRuleToken lv_hazardReference_28_0 = null;

        AntlrDatatypeRuleToken lv_hazardReference_30_0 = null;

        EObject lv_subrequirement_35_0 = null;

        EObject lv_docReference_56_0 = null;

        EObject lv_docReference_58_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1126:28: ( (otherlv_0= 'requirement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= ']' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1127:1: (otherlv_0= 'requirement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= ']' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1127:1: (otherlv_0= 'requirement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1127:3: otherlv_0= 'requirement' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_59= ']'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleRequirement2667); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1131:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1132:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1132:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1133:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement2684); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRequirementAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRequirementRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleRequirement2701); 

                	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1153:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1155:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1155:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1156:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1159:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1160:3: ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1160:3: ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop28:
            do {
                int alt28=18;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1162:4: ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1162:4: ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1163:5: {...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1163:108: ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1164:6: ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1167:6: ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1167:7: {...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1167:16: (otherlv_4= 'for' ( ( ruleQNEREF ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1167:18: otherlv_4= 'for' ( ( ruleQNEREF ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleRequirement2759); 

            	        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1171:1: ( ( ruleQNEREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1172:1: ( ruleQNEREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1172:1: ( ruleQNEREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1173:3: ruleQNEREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQNEREF_in_ruleRequirement2782);
            	    ruleQNEREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1193:4: ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1193:4: ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1194:5: {...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1194:108: ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1195:6: ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1198:6: ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1198:7: {...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1198:16: (otherlv_6= 'category' ( ( ruleCATREF ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1198:18: otherlv_6= 'category' ( ( ruleCATREF ) )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleRequirement2850); 

            	        	newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1202:1: ( ( ruleCATREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1203:1: ( ruleCATREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1203:1: ( ruleCATREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1204:3: ruleCATREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCATREF_in_ruleRequirement2873);
            	    ruleCATREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1224:4: ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1224:4: ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1225:5: {...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1225:108: ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1226:6: ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1229:6: ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1229:7: {...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1229:16: (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1229:18: otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleRequirement2941); 

            	        	newLeafNode(otherlv_8, grammarAccess.getRequirementAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1233:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1234:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1234:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1235:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement2962);
            	    lv_title_9_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_9_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1258:4: ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1258:4: ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1259:5: {...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1259:108: ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1260:6: ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1263:6: ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1263:7: {...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1263:16: (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1263:18: otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleRequirement3030); 

            	        	newLeafNode(otherlv_10, grammarAccess.getRequirementAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1267:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1268:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1268:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1269:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3051);
            	    lv_description_11_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_11_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1292:4: ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1292:4: ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1293:5: {...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1293:108: ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1294:6: ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1297:6: ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1297:7: {...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1297:16: (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1297:18: otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) )
            	    {
            	    otherlv_12=(Token)match(input,23,FOLLOW_23_in_ruleRequirement3119); 

            	        	newLeafNode(otherlv_12, grammarAccess.getRequirementAccess().getAssertionKeyword_3_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1301:1: ( (lv_assert_13_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1302:1: (lv_assert_13_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1302:1: (lv_assert_13_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1303:3: lv_assert_13_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertValueStringParserRuleCall_3_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3140);
            	    lv_assert_13_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_13_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1326:4: ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1326:4: ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1327:5: {...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1327:108: ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1328:6: ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1331:6: ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1331:7: {...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1331:16: (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1331:18: otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) )
            	    {
            	    otherlv_14=(Token)match(input,24,FOLLOW_24_in_ruleRequirement3208); 

            	        	newLeafNode(otherlv_14, grammarAccess.getRequirementAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1335:1: ( (lv_rationale_15_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1336:1: (lv_rationale_15_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1336:1: (lv_rationale_15_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1337:3: lv_rationale_15_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRationaleValueStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3229);
            	    lv_rationale_15_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_15_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1360:4: ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1360:4: ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1361:5: {...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1361:108: ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1362:6: ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1365:6: ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==17) ) {
            	            int LA17_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt17=1;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1365:7: {...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1365:16: ( (lv_reqValue_16_0= ruleRSLVariable ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1366:1: (lv_reqValue_16_0= ruleRSLVariable )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1366:1: (lv_reqValue_16_0= ruleRSLVariable )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1367:3: lv_reqValue_16_0= ruleRSLVariable
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getReqValueRSLVariableParserRuleCall_3_6_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRSLVariable_in_ruleRequirement3305);
            	    	    lv_reqValue_16_0=ruleRSLVariable();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"reqValue",
            	    	            		lv_reqValue_16_0, 
            	    	            		"RSLVariable");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1390:4: ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1390:4: ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1391:5: {...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1391:108: ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1392:6: ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1395:6: ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1395:7: {...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1395:16: (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1395:18: otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )*
            	    {
            	    otherlv_17=(Token)match(input,14,FOLLOW_14_in_ruleRequirement3373); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getIssuesKeyword_3_7_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1399:1: ( (lv_issue_18_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1400:1: (lv_issue_18_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1400:1: (lv_issue_18_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1401:3: lv_issue_18_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueValueStringParserRuleCall_3_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3394);
            	    lv_issue_18_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_18_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1417:2: (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==15) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1417:4: otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_19=(Token)match(input,15,FOLLOW_15_in_ruleRequirement3407); 

            	    	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getCommaKeyword_3_7_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1421:1: ( (lv_issue_20_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1422:1: (lv_issue_20_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1422:1: (lv_issue_20_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1423:3: lv_issue_20_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueValueStringParserRuleCall_3_7_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3428);
            	    	    lv_issue_20_0=ruleValueString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_20_0, 
            	    	            		"ValueString");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop18;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1446:4: ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1446:4: ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1447:5: {...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1447:108: ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1448:6: ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1451:6: ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1451:7: {...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1451:16: (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1451:18: otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )*
            	    {
            	    otherlv_21=(Token)match(input,31,FOLLOW_31_in_ruleRequirement3498); 

            	        	newLeafNode(otherlv_21, grammarAccess.getRequirementAccess().getSeeKeyword_3_8_0());
            	        
            	    otherlv_22=(Token)match(input,19,FOLLOW_19_in_ruleRequirement3510); 

            	        	newLeafNode(otherlv_22, grammarAccess.getRequirementAccess().getGoalKeyword_3_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1459:1: ( (otherlv_23= RULE_ID ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1460:1: (otherlv_23= RULE_ID )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1460:1: (otherlv_23= RULE_ID )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1461:3: otherlv_23= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	    otherlv_23=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3530); 

            	    		newLeafNode(otherlv_23, grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_3_8_2_0()); 
            	    	

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1472:2: (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==15) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1472:4: otherlv_24= ',' ( (otherlv_25= RULE_ID ) )
            	    	    {
            	    	    otherlv_24=(Token)match(input,15,FOLLOW_15_in_ruleRequirement3543); 

            	    	        	newLeafNode(otherlv_24, grammarAccess.getRequirementAccess().getCommaKeyword_3_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1476:1: ( (otherlv_25= RULE_ID ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1477:1: (otherlv_25= RULE_ID )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1477:1: (otherlv_25= RULE_ID )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1478:3: otherlv_25= RULE_ID
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	    otherlv_25=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3563); 

            	    	    		newLeafNode(otherlv_25, grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_3_8_3_1_0()); 
            	    	    	

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop19;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1496:4: ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1496:4: ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1497:5: {...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1497:108: ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1498:6: ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1501:6: ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1501:7: {...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1501:16: (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1501:18: otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )*
            	    {
            	    otherlv_26=(Token)match(input,31,FOLLOW_31_in_ruleRequirement3633); 

            	        	newLeafNode(otherlv_26, grammarAccess.getRequirementAccess().getSeeKeyword_3_9_0());
            	        
            	    otherlv_27=(Token)match(input,34,FOLLOW_34_in_ruleRequirement3645); 

            	        	newLeafNode(otherlv_27, grammarAccess.getRequirementAccess().getHazardKeyword_3_9_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1509:1: ( (lv_hazardReference_28_0= ruleQNEREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1510:1: (lv_hazardReference_28_0= ruleQNEREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1510:1: (lv_hazardReference_28_0= ruleQNEREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1511:3: lv_hazardReference_28_0= ruleQNEREF
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getHazardReferenceQNEREFParserRuleCall_3_9_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQNEREF_in_ruleRequirement3666);
            	    lv_hazardReference_28_0=ruleQNEREF();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"hazardReference",
            	            		lv_hazardReference_28_0, 
            	            		"QNEREF");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1527:2: (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==15) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1527:4: otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) )
            	    	    {
            	    	    otherlv_29=(Token)match(input,15,FOLLOW_15_in_ruleRequirement3679); 

            	    	        	newLeafNode(otherlv_29, grammarAccess.getRequirementAccess().getCommaKeyword_3_9_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1531:1: ( (lv_hazardReference_30_0= ruleQNEREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1532:1: (lv_hazardReference_30_0= ruleQNEREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1532:1: (lv_hazardReference_30_0= ruleQNEREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1533:3: lv_hazardReference_30_0= ruleQNEREF
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getHazardReferenceQNEREFParserRuleCall_3_9_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQNEREF_in_ruleRequirement3700);
            	    	    lv_hazardReference_30_0=ruleQNEREF();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"hazardReference",
            	    	            		lv_hazardReference_30_0, 
            	    	            		"QNEREF");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop20;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1556:4: ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1556:4: ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1557:5: {...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1557:109: ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1558:6: ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1561:6: ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1561:7: {...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1561:16: (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1561:18: otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_31=(Token)match(input,35,FOLLOW_35_in_ruleRequirement3770); 

            	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getRefinesKeyword_3_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1565:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1566:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1566:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1567:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_3_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement3793);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1580:2: (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==15) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1580:4: otherlv_33= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,15,FOLLOW_15_in_ruleRequirement3806); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getCommaKeyword_3_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1584:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1585:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1585:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1586:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_3_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement3829);
            	    	    ruleDOTTEDREF();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop21;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1606:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1606:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1607:5: {...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1607:109: ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1608:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1611:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    int cnt22=0;
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==32) ) {
            	            int LA22_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt22=1;
            	            }


            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1611:7: {...}? => ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1611:16: ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1612:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1612:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1613:3: lv_subrequirement_35_0= ruleRequirement
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSubrequirementRequirementParserRuleCall_3_11_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRequirement_in_ruleRequirement3907);
            	    	    lv_subrequirement_35_0=ruleRequirement();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subrequirement",
            	    	            		lv_subrequirement_35_0, 
            	    	            		"Requirement");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1636:4: ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1636:4: ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1637:5: {...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1637:109: ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1638:6: ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1641:6: ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1641:7: {...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1641:16: (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1641:18: otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_36=(Token)match(input,36,FOLLOW_36_in_ruleRequirement3975); 

            	        	newLeafNode(otherlv_36, grammarAccess.getRequirementAccess().getDecomposesKeyword_3_12_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1645:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1646:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1646:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1647:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_3_12_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement3998);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1660:2: (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==15) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1660:4: otherlv_38= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_38=(Token)match(input,15,FOLLOW_15_in_ruleRequirement4011); 

            	    	        	newLeafNode(otherlv_38, grammarAccess.getRequirementAccess().getCommaKeyword_3_12_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1664:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1665:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1665:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1666:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_3_12_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement4034);
            	    	    ruleDOTTEDREF();

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


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1686:4: ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1686:4: ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1687:5: {...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1687:109: ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1688:6: ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1691:6: ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1691:7: {...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1691:16: (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1691:18: otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_40=(Token)match(input,28,FOLLOW_28_in_ruleRequirement4104); 

            	        	newLeafNode(otherlv_40, grammarAccess.getRequirementAccess().getEvolvesKeyword_3_13_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1695:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1696:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1696:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1697:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_3_13_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement4127);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1710:2: (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==15) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1710:4: otherlv_42= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_42=(Token)match(input,15,FOLLOW_15_in_ruleRequirement4140); 

            	    	        	newLeafNode(otherlv_42, grammarAccess.getRequirementAccess().getCommaKeyword_3_13_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1714:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1715:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1715:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1716:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_3_13_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement4163);
            	    	    ruleDOTTEDREF();

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


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1736:4: ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1736:4: ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1737:5: {...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1737:109: ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1738:6: ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1741:6: ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1741:7: {...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1741:16: (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1741:18: otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_44=(Token)match(input,31,FOLLOW_31_in_ruleRequirement4233); 

            	        	newLeafNode(otherlv_44, grammarAccess.getRequirementAccess().getSeeKeyword_3_14_0());
            	        
            	    otherlv_45=(Token)match(input,19,FOLLOW_19_in_ruleRequirement4245); 

            	        	newLeafNode(otherlv_45, grammarAccess.getRequirementAccess().getGoalKeyword_3_14_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1749:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1750:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1750:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1751:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_3_14_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement4268);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1764:2: (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==15) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1764:4: otherlv_47= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_47=(Token)match(input,15,FOLLOW_15_in_ruleRequirement4281); 

            	    	        	newLeafNode(otherlv_47, grammarAccess.getRequirementAccess().getCommaKeyword_3_14_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1768:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1769:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1769:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1770:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_3_14_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement4304);
            	    	    ruleDOTTEDREF();

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


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 16 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1790:4: ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1790:4: ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1791:5: {...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1791:109: ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1792:6: ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1795:6: ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1795:7: {...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1795:16: (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1795:18: otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )*
            	    {
            	    otherlv_49=(Token)match(input,31,FOLLOW_31_in_ruleRequirement4374); 

            	        	newLeafNode(otherlv_49, grammarAccess.getRequirementAccess().getSeeKeyword_3_15_0());
            	        
            	    otherlv_50=(Token)match(input,32,FOLLOW_32_in_ruleRequirement4386); 

            	        	newLeafNode(otherlv_50, grammarAccess.getRequirementAccess().getRequirementKeyword_3_15_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1803:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1804:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1804:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1805:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_3_15_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement4409);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1818:2: (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==15) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1818:4: otherlv_52= ',' ( ( ruleDOTTEDREF ) )
            	    	    {
            	    	    otherlv_52=(Token)match(input,15,FOLLOW_15_in_ruleRequirement4422); 

            	    	        	newLeafNode(otherlv_52, grammarAccess.getRequirementAccess().getCommaKeyword_3_15_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1822:1: ( ( ruleDOTTEDREF ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1823:1: ( ruleDOTTEDREF )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1823:1: ( ruleDOTTEDREF )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1824:3: ruleDOTTEDREF
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_3_15_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleRequirement4445);
            	    	    ruleDOTTEDREF();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 17 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1844:4: ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1844:4: ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1845:5: {...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1845:109: ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1846:6: ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1849:6: ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1849:7: {...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1849:16: (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1849:18: otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_54=(Token)match(input,31,FOLLOW_31_in_ruleRequirement4515); 

            	        	newLeafNode(otherlv_54, grammarAccess.getRequirementAccess().getSeeKeyword_3_16_0());
            	        
            	    otherlv_55=(Token)match(input,33,FOLLOW_33_in_ruleRequirement4527); 

            	        	newLeafNode(otherlv_55, grammarAccess.getRequirementAccess().getDocumentKeyword_3_16_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1857:1: ( (lv_docReference_56_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1858:1: (lv_docReference_56_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1858:1: (lv_docReference_56_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1859:3: lv_docReference_56_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_3_16_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4548);
            	    lv_docReference_56_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_56_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1875:2: (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==15) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1875:4: otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_57=(Token)match(input,15,FOLLOW_15_in_ruleRequirement4561); 

            	    	        	newLeafNode(otherlv_57, grammarAccess.getRequirementAccess().getCommaKeyword_3_16_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1879:1: ( (lv_docReference_58_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1880:1: (lv_docReference_58_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1880:1: (lv_docReference_58_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1881:3: lv_docReference_58_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_3_16_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4582);
            	    	    lv_docReference_58_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_58_0, 
            	    	            		"ExternalDocument");
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


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_3());
            	

            }

            otherlv_59=(Token)match(input,16,FOLLOW_16_in_ruleRequirement4637); 

                	newLeafNode(otherlv_59, grammarAccess.getRequirementAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleRequirement"


    // $ANTLR start "entryRuleHazard"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1923:1: entryRuleHazard returns [EObject current=null] : iv_ruleHazard= ruleHazard EOF ;
    public final EObject entryRuleHazard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1924:2: (iv_ruleHazard= ruleHazard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1925:2: iv_ruleHazard= ruleHazard EOF
            {
             newCompositeNode(grammarAccess.getHazardRule()); 
            pushFollow(FOLLOW_ruleHazard_in_entryRuleHazard4673);
            iv_ruleHazard=ruleHazard();

            state._fsp--;

             current =iv_ruleHazard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazard4683); 

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
    // $ANTLR end "entryRuleHazard"


    // $ANTLR start "ruleHazard"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1932:1: ruleHazard returns [EObject current=null] : (otherlv_0= 'hazard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= ']' ) ;
    public final EObject ruleHazard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_title_9_0 = null;

        AntlrDatatypeRuleToken lv_description_11_0 = null;

        AntlrDatatypeRuleToken lv_rationale_16_0 = null;

        AntlrDatatypeRuleToken lv_issue_18_0 = null;

        AntlrDatatypeRuleToken lv_issue_20_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1935:28: ( (otherlv_0= 'hazard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= ']' ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1936:1: (otherlv_0= 'hazard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= ']' )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1936:1: (otherlv_0= 'hazard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= ']' )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1936:3: otherlv_0= 'hazard' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) ) otherlv_21= ']'
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleHazard4720); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardAccess().getHazardKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1940:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1941:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1941:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1942:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard4737); 

            			newLeafNode(lv_name_1_0, grammarAccess.getHazardAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getHazardRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleHazard4754); 

                	newLeafNode(otherlv_2, grammarAccess.getHazardAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1962:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1964:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1964:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1965:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1968:2: ( ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1969:3: ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1969:3: ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) )*
            loop30:
            do {
                int alt30=8;
                int LA30_0 = input.LA(1);

                if ( LA30_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
                    alt30=1;
                }
                else if ( LA30_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
                    alt30=2;
                }
                else if ( LA30_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
                    alt30=3;
                }
                else if ( LA30_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
                    alt30=4;
                }
                else if ( LA30_0 ==37 && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
                    alt30=5;
                }
                else if ( LA30_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
                    alt30=6;
                }
                else if ( LA30_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
                    alt30=7;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1971:4: ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1971:4: ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1972:5: {...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1972:103: ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1973:6: ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1976:6: ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1976:7: {...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1976:16: (otherlv_4= 'for' ( ( ruleQNEREF ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1976:18: otherlv_4= 'for' ( ( ruleQNEREF ) )
            	    {
            	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleHazard4812); 

            	        	newLeafNode(otherlv_4, grammarAccess.getHazardAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1980:1: ( ( ruleQNEREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1981:1: ( ruleQNEREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1981:1: ( ruleQNEREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:1982:3: ruleQNEREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQNEREF_in_ruleHazard4835);
            	    ruleQNEREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2002:4: ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2002:4: ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2003:5: {...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2003:103: ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2004:6: ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2007:6: ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2007:7: {...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2007:16: (otherlv_6= 'category' ( ( ruleCATREF ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2007:18: otherlv_6= 'category' ( ( ruleCATREF ) )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleHazard4903); 

            	        	newLeafNode(otherlv_6, grammarAccess.getHazardAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2011:1: ( ( ruleCATREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2012:1: ( ruleCATREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2012:1: ( ruleCATREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2013:3: ruleCATREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getCategoryHazardCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCATREF_in_ruleHazard4926);
            	    ruleCATREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2033:4: ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2033:4: ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2034:5: {...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2034:103: ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2035:6: ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2038:6: ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2038:7: {...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2038:16: (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2038:18: otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) )
            	    {
            	    otherlv_8=(Token)match(input,21,FOLLOW_21_in_ruleHazard4994); 

            	        	newLeafNode(otherlv_8, grammarAccess.getHazardAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2042:1: ( (lv_title_9_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2043:1: (lv_title_9_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2043:1: (lv_title_9_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2044:3: lv_title_9_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5015);
            	    lv_title_9_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_9_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2067:4: ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2067:4: ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2068:5: {...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2068:103: ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2069:6: ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2072:6: ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2072:7: {...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2072:16: (otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2072:18: otherlv_10= 'description' ( (lv_description_11_0= ruleValueString ) )
            	    {
            	    otherlv_10=(Token)match(input,22,FOLLOW_22_in_ruleHazard5083); 

            	        	newLeafNode(otherlv_10, grammarAccess.getHazardAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2076:1: ( (lv_description_11_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2077:1: (lv_description_11_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2077:1: (lv_description_11_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2078:3: lv_description_11_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getDescriptionValueStringParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5104);
            	    lv_description_11_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_11_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2101:4: ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2101:4: ({...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2102:5: {...}? => ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2102:103: ( ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2103:6: ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2106:6: ({...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2106:7: {...}? => (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2106:16: (otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2106:18: otherlv_12= 'mitigated' otherlv_13= 'by' ( ( ruleDOTTEDREF ) )
            	    {
            	    otherlv_12=(Token)match(input,37,FOLLOW_37_in_ruleHazard5172); 

            	        	newLeafNode(otherlv_12, grammarAccess.getHazardAccess().getMitigatedKeyword_3_4_0());
            	        
            	    otherlv_13=(Token)match(input,38,FOLLOW_38_in_ruleHazard5184); 

            	        	newLeafNode(otherlv_13, grammarAccess.getHazardAccess().getByKeyword_3_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2114:1: ( ( ruleDOTTEDREF ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2115:1: ( ruleDOTTEDREF )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2115:1: ( ruleDOTTEDREF )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2116:3: ruleDOTTEDREF
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getMitigatedRequirementCrossReference_3_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDOTTEDREF_in_ruleHazard5207);
            	    ruleDOTTEDREF();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2136:4: ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2136:4: ({...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2137:5: {...}? => ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2137:103: ( ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2138:6: ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2141:6: ({...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2141:7: {...}? => (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2141:16: (otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2141:18: otherlv_15= 'rationale' ( (lv_rationale_16_0= ruleValueString ) )
            	    {
            	    otherlv_15=(Token)match(input,24,FOLLOW_24_in_ruleHazard5275); 

            	        	newLeafNode(otherlv_15, grammarAccess.getHazardAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2145:1: ( (lv_rationale_16_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2146:1: (lv_rationale_16_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2146:1: (lv_rationale_16_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2147:3: lv_rationale_16_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getRationaleValueStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5296);
            	    lv_rationale_16_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_16_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2170:4: ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2170:4: ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2171:5: {...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2171:103: ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2172:6: ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2175:6: ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2175:7: {...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2175:16: (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2175:18: otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )*
            	    {
            	    otherlv_17=(Token)match(input,14,FOLLOW_14_in_ruleHazard5364); 

            	        	newLeafNode(otherlv_17, grammarAccess.getHazardAccess().getIssuesKeyword_3_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2179:1: ( (lv_issue_18_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2180:1: (lv_issue_18_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2180:1: (lv_issue_18_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2181:3: lv_issue_18_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueValueStringParserRuleCall_3_6_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5385);
            	    lv_issue_18_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_18_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2197:2: (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==15) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2197:4: otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) )
            	    	    {
            	    	    otherlv_19=(Token)match(input,15,FOLLOW_15_in_ruleHazard5398); 

            	    	        	newLeafNode(otherlv_19, grammarAccess.getHazardAccess().getCommaKeyword_3_6_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2201:1: ( (lv_issue_20_0= ruleValueString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2202:1: (lv_issue_20_0= ruleValueString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2202:1: (lv_issue_20_0= ruleValueString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2203:3: lv_issue_20_0= ruleValueString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueValueStringParserRuleCall_3_6_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5419);
            	    	    lv_issue_20_0=ruleValueString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_20_0, 
            	    	            		"ValueString");
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


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	

            }

            otherlv_21=(Token)match(input,16,FOLLOW_16_in_ruleHazard5474); 

                	newLeafNode(otherlv_21, grammarAccess.getHazardAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleHazard"


    // $ANTLR start "entryRuleExternalDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2245:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2246:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2247:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument5510);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument5520); 

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
    // $ANTLR end "entryRuleExternalDocument"


    // $ANTLR start "ruleExternalDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2254:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= '#' ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2257:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= '#' ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2258:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= '#' ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2258:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= '#' ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2258:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= '#' ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2258:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2259:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2259:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2260:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument5566);
            lv_docReference_0_0=ruleDOCPATH();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExternalDocumentRule());
            	        }
                   		set(
                   			current, 
                   			"docReference",
                    		lv_docReference_0_0, 
                    		"DOCPATH");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2276:2: (otherlv_1= '#' ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==39) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2276:4: otherlv_1= '#' ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleExternalDocument5579); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2280:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2281:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2281:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2282:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument5600);
                    lv_docFragment_2_0=ruleDOCFRAGMENT();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExternalDocumentRule());
                    	        }
                           		set(
                           			current, 
                           			"docFragment",
                            		lv_docFragment_2_0, 
                            		"DOCFRAGMENT");
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
    // $ANTLR end "ruleExternalDocument"


    // $ANTLR start "entryRuleDOCPATH"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2306:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2307:2: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2308:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH5639);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH5650); 

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
    // $ANTLR end "entryRuleDOCPATH"


    // $ANTLR start "ruleDOCPATH"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2315:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2318:28: ( ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2319:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2319:1: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2319:2: (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2319:2: (this_ID_0= RULE_ID kw= '/' )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==40) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2319:7: this_ID_0= RULE_ID kw= '/'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5691); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,40,FOLLOW_40_in_ruleDOCPATH5709); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5726); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,41,FOLLOW_41_in_ruleDOCPATH5744); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5759); 

            		current.merge(this_ID_4);
                
             
                newLeafNode(this_ID_4, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_3()); 
                

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
    // $ANTLR end "ruleDOCPATH"


    // $ANTLR start "entryRuleDOCFRAGMENT"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2360:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2361:2: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2362:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT5805);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT5816); 

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
    // $ANTLR end "entryRuleDOCFRAGMENT"


    // $ANTLR start "ruleDOCFRAGMENT"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2369:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2372:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2373:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2373:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2373:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5856); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2380:1: (kw= '.' this_ID_2= RULE_ID )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==41) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2381:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,41,FOLLOW_41_in_ruleDOCFRAGMENT5875); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5890); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop33;
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
    // $ANTLR end "ruleDOCFRAGMENT"


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2403:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2404:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2405:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription5939);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription5949); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2412:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2415:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2416:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2416:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_STRING)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2417:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2417:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2418:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription5994);
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
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2442:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2443:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2444:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6030);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement6040); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2451:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2454:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2455:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2455:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_STRING) ) {
                alt35=1;
            }
            else if ( (LA35_0==RULE_ID) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2455:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2455:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2456:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2456:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2457:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement6082); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2474:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2474:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2475:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2475:1: (otherlv_1= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2476:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement6113); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2495:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2496:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2497:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath6149);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath6159); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2504:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2507:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2508:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2508:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2508:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2508:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2509:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2509:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2510:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath6204); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2521:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2521:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleReferencePath6217); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2525:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2526:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2526:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2527:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath6238);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2551:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2552:2: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2553:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString6276);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString6287); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2560:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2563:28: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2564:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString6326); 

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


    // $ANTLR start "entryRuleDOTTEDREF"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2579:1: entryRuleDOTTEDREF returns [String current=null] : iv_ruleDOTTEDREF= ruleDOTTEDREF EOF ;
    public final String entryRuleDOTTEDREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOTTEDREF = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2580:2: (iv_ruleDOTTEDREF= ruleDOTTEDREF EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2581:2: iv_ruleDOTTEDREF= ruleDOTTEDREF EOF
            {
             newCompositeNode(grammarAccess.getDOTTEDREFRule()); 
            pushFollow(FOLLOW_ruleDOTTEDREF_in_entryRuleDOTTEDREF6371);
            iv_ruleDOTTEDREF=ruleDOTTEDREF();

            state._fsp--;

             current =iv_ruleDOTTEDREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOTTEDREF6382); 

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
    // $ANTLR end "entryRuleDOTTEDREF"


    // $ANTLR start "ruleDOTTEDREF"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2588:1: ruleDOTTEDREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOTTEDREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2591:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2592:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2592:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2592:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOTTEDREF6422); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOTTEDREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2599:1: (kw= '.' this_ID_2= RULE_ID )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==41) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2600:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,41,FOLLOW_41_in_ruleDOTTEDREF6441); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOTTEDREFAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOTTEDREF6456); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getDOTTEDREFAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop36;
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
    // $ANTLR end "ruleDOTTEDREF"


    // $ANTLR start "entryRuleQNEREF"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2620:1: entryRuleQNEREF returns [String current=null] : iv_ruleQNEREF= ruleQNEREF EOF ;
    public final String entryRuleQNEREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQNEREF = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2621:2: (iv_ruleQNEREF= ruleQNEREF EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2622:2: iv_ruleQNEREF= ruleQNEREF EOF
            {
             newCompositeNode(grammarAccess.getQNEREFRule()); 
            pushFollow(FOLLOW_ruleQNEREF_in_entryRuleQNEREF6504);
            iv_ruleQNEREF=ruleQNEREF();

            state._fsp--;

             current =iv_ruleQNEREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQNEREF6515); 

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
    // $ANTLR end "entryRuleQNEREF"


    // $ANTLR start "ruleQNEREF"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2629:1: ruleQNEREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleQNEREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2632:28: ( ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2633:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2633:1: ( (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2633:2: (this_ID_0= RULE_ID kw= '::' )* this_ID_2= RULE_ID (kw= '.' this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2633:2: (this_ID_0= RULE_ID kw= '::' )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    int LA37_1 = input.LA(2);

                    if ( (LA37_1==42) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2633:7: this_ID_0= RULE_ID kw= '::'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQNEREF6556); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getQNEREFAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,42,FOLLOW_42_in_ruleQNEREF6574); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQNEREFAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQNEREF6591); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getQNEREFAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2653:1: (kw= '.' this_ID_4= RULE_ID )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==41) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2654:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_ruleQNEREF6610); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQNEREFAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQNEREF6625); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getQNEREFAccess().getIDTerminalRuleCall_2_1()); 
                        

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
    // $ANTLR end "ruleQNEREF"


    // $ANTLR start "entryRuleCATREF"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2674:1: entryRuleCATREF returns [String current=null] : iv_ruleCATREF= ruleCATREF EOF ;
    public final String entryRuleCATREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCATREF = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2675:2: (iv_ruleCATREF= ruleCATREF EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2676:2: iv_ruleCATREF= ruleCATREF EOF
            {
             newCompositeNode(grammarAccess.getCATREFRule()); 
            pushFollow(FOLLOW_ruleCATREF_in_entryRuleCATREF6673);
            iv_ruleCATREF=ruleCATREF();

            state._fsp--;

             current =iv_ruleCATREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCATREF6684); 

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
    // $ANTLR end "entryRuleCATREF"


    // $ANTLR start "ruleCATREF"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2683:1: ruleCATREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleCATREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2686:28: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2687:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2687:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpec.g:2687:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCATREF6724); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getCATREFAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,41,FOLLOW_41_in_ruleCATREF6742); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getCATREFAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCATREF6757); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getCATREFAccess().getIDTerminalRuleCall_2()); 
                

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
    // $ANTLR end "ruleCATREF"

    // Delegated rules


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA16_eotS =
        "\23\uffff";
    static final String DFA16_eofS =
        "\23\uffff";
    static final String DFA16_minS =
        "\1\15\16\uffff\1\23\3\uffff";
    static final String DFA16_maxS =
        "\1\37\16\uffff\1\41\3\uffff";
    static final String DFA16_acceptS =
        "\1\uffff\1\21\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\14\1\15\1\uffff\1\17\1\20\1\16";
    static final String DFA16_specialS =
        "\1\1\16\uffff\1\0\3\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\2\1\10\1\uffff\1\1\2\uffff\1\12\1\3\1\4\1\5\1\6\1\7\1\11"+
            "\1\uffff\1\13\1\14\1\15\1\16\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\22\14\uffff\1\20\1\21",
            "",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "()* loopback of 383:3: ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= 'issues' ( (lv_issue_17_0= ruleValueString ) ) (otherlv_18= ',' ( (lv_issue_19_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= 'refined' otherlv_21= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_23= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_25_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_26= 'decomposed' otherlv_27= 'to' ( ( ruleDOTTEDREF ) ) (otherlv_29= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= 'conflicts' ( ( ruleDOTTEDREF ) ) (otherlv_37= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_39= 'stakeholder' ( ( ruleDOTTEDREF ) ) (otherlv_41= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= 'see' otherlv_44= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_46= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= 'see' otherlv_49= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_51= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_53= 'see' otherlv_54= 'document' ( (lv_docReference_55_0= ruleExternalDocument ) ) (otherlv_56= ',' ( (lv_docReference_57_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_15 = input.LA(1);

                         
                        int index16_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA16_15 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 14) ) {s = 16;}

                        else if ( LA16_15 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 15) ) {s = 17;}

                        else if ( LA16_15 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 13) ) {s = 18;}

                         
                        input.seek(index16_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_0==16) ) {s = 1;}

                        else if ( LA16_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA16_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA16_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA16_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA16_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA16_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA16_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA16_0 ==25 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA16_0 ==19 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 8) ) {s = 10;}

                        else if ( LA16_0 ==27 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 9) ) {s = 11;}

                        else if ( LA16_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 10) ) {s = 12;}

                        else if ( LA16_0 ==29 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 11) ) {s = 13;}

                        else if ( LA16_0 ==30 && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 12) ) {s = 14;}

                        else if ( LA16_0 ==31 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 13) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 14) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_3(), 15) ) ) {s = 15;}

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA28_eotS =
        "\26\uffff";
    static final String DFA28_eofS =
        "\26\uffff";
    static final String DFA28_minS =
        "\1\15\11\uffff\1\23\4\uffff\1\4\3\uffff\1\0\2\uffff";
    static final String DFA28_maxS =
        "\1\44\11\uffff\1\42\4\uffff\1\4\3\uffff\1\0\2\uffff";
    static final String DFA28_acceptS =
        "\1\uffff\1\22\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\uffff\1\13\1\14"+
        "\1\15\1\16\1\uffff\1\21\1\20\1\12\1\uffff\1\11\1\17";
    static final String DFA28_specialS =
        "\1\0\11\uffff\1\3\4\uffff\1\2\3\uffff\1\1\2\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\1\11\1\uffff\1\1\1\10\2\uffff\1\3\1\4\1\5\1\6\1\7\3\uffff"+
            "\1\16\2\uffff\1\12\1\14\2\uffff\1\13\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\17\14\uffff\1\21\1\20\1\22",
            "",
            "",
            "",
            "",
            "\1\23",
            "",
            "",
            "",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()* loopback of 1160:3: ( ({...}? => ( ({...}? => (otherlv_4= 'for' ( ( ruleQNEREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_6= 'category' ( ( ruleCATREF ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= 'title' ( (lv_title_9_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= 'description' ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= 'assertion' ( (lv_assert_13_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= 'rationale' ( (lv_rationale_15_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_reqValue_16_0= ruleRSLVariable ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_17= 'issues' ( (lv_issue_18_0= ruleValueString ) ) (otherlv_19= ',' ( (lv_issue_20_0= ruleValueString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= 'see' otherlv_22= 'goal' ( (otherlv_23= RULE_ID ) ) (otherlv_24= ',' ( (otherlv_25= RULE_ID ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= 'see' otherlv_27= 'hazard' ( (lv_hazardReference_28_0= ruleQNEREF ) ) (otherlv_29= ',' ( (lv_hazardReference_30_0= ruleQNEREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= 'refines' ( ( ruleDOTTEDREF ) ) (otherlv_33= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= 'decomposes' ( ( ruleDOTTEDREF ) ) (otherlv_38= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_40= 'evolves' ( ( ruleDOTTEDREF ) ) (otherlv_42= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_44= 'see' otherlv_45= 'goal' ( ( ruleDOTTEDREF ) ) (otherlv_47= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_49= 'see' otherlv_50= 'requirement' ( ( ruleDOTTEDREF ) ) (otherlv_52= ',' ( ( ruleDOTTEDREF ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_54= 'see' otherlv_55= 'document' ( (lv_docReference_56_0= ruleExternalDocument ) ) (otherlv_57= ',' ( (lv_docReference_58_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_0 = input.LA(1);

                         
                        int index28_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA28_0==16) ) {s = 1;}

                        else if ( LA28_0 ==13 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 0) ) {s = 2;}

                        else if ( LA28_0 ==20 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 1) ) {s = 3;}

                        else if ( LA28_0 ==21 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 2) ) {s = 4;}

                        else if ( LA28_0 ==22 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 3) ) {s = 5;}

                        else if ( LA28_0 ==23 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 4) ) {s = 6;}

                        else if ( LA28_0 ==24 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 5) ) {s = 7;}

                        else if ( LA28_0 ==17 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 6) ) {s = 8;}

                        else if ( LA28_0 ==14 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 7) ) {s = 9;}

                        else if ( LA28_0 ==31 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) ) {s = 10;}

                        else if ( LA28_0 ==35 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 10) ) {s = 11;}

                        else if ( LA28_0 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 11) ) {s = 12;}

                        else if ( LA28_0 ==36 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 12) ) {s = 13;}

                        else if ( LA28_0 ==28 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 13) ) {s = 14;}

                         
                        input.seek(index28_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA28_19 = input.LA(1);

                         
                        int index28_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) ) {s = 20;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) {s = 21;}

                         
                        input.seek(index28_19);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA28_15 = input.LA(1);

                         
                        int index28_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA28_15 ==RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) ) {s = 19;}

                         
                        input.seek(index28_15);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA28_10 = input.LA(1);

                         
                        int index28_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA28_10 ==19 && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 14) ) ) {s = 15;}

                        else if ( LA28_10 ==33 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 16) ) {s = 16;}

                        else if ( LA28_10 ==32 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 15) ) {s = 17;}

                        else if ( LA28_10 ==34 && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_3(), 9) ) {s = 18;}

                         
                        input.seek(index28_10);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleReqSpecModel_in_entryRuleReqSpecModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecContainer_in_ruleReqSpecModel131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecContainer_in_entryRuleReqSpecContainer167 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecContainer177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleReqSpecContainer214 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecContainer231 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleReqSpecContainer248 = new BitSet(new long[]{0x0000000100096800L});
    public static final BitSet FOLLOW_13_in_ruleReqSpecContainer261 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQNEREF_in_ruleReqSpecContainer284 = new BitSet(new long[]{0x0000000100094800L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecContainer309 = new BitSet(new long[]{0x0000000100094800L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecContainer328 = new BitSet(new long[]{0x0000000100094800L});
    public static final BitSet FOLLOW_ruleReqSpecContainer_in_ruleReqSpecContainer347 = new BitSet(new long[]{0x0000000100094800L});
    public static final BitSet FOLLOW_14_in_ruleReqSpecContainer364 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleReqSpecContainer376 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecContainer397 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_15_in_ruleReqSpecContainer410 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecContainer431 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_16_in_ruleReqSpecContainer445 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleReqSpecContainer459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRSLVariable_in_entryRuleRSLVariable495 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRSLVariable505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleRSLVariable542 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRSLVariable559 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRSLVariable576 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRSLVariable597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal633 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleGoal680 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal697 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleGoal714 = new BitSet(new long[]{0x00000000FBF96000L});
    public static final BitSet FOLLOW_13_in_ruleGoal772 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQNEREF_in_ruleGoal795 = new BitSet(new long[]{0x00000000FBF96000L});
    public static final BitSet FOLLOW_20_in_ruleGoal863 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleGoal886 = new BitSet(new long[]{0x00000000FBF96000L});
    public static final BitSet FOLLOW_21_in_ruleGoal954 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal975 = new BitSet(new long[]{0x00000000FBF96000L});
    public static final BitSet FOLLOW_22_in_ruleGoal1043 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal1064 = new BitSet(new long[]{0x00000000FBF96000L});
    public static final BitSet FOLLOW_23_in_ruleGoal1132 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1153 = new BitSet(new long[]{0x00000000FBF96000L});
    public static final BitSet FOLLOW_24_in_ruleGoal1221 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1242 = new BitSet(new long[]{0x00000000FBF96000L});
    public static final BitSet FOLLOW_14_in_ruleGoal1310 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1331 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal1344 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1365 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_25_in_ruleGoal1435 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleGoal1447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal1470 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal1483 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal1506 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoal1584 = new BitSet(new long[]{0x00000000FBF96000L});
    public static final BitSet FOLLOW_27_in_ruleGoal1652 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleGoal1664 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal1687 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal1700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal1723 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_28_in_ruleGoal1793 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal1816 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal1829 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal1852 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_29_in_ruleGoal1922 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal1945 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal1958 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal1981 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_30_in_ruleGoal2051 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal2074 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal2087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal2110 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_31_in_ruleGoal2180 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleGoal2192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal2215 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal2228 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal2251 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_31_in_ruleGoal2321 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleGoal2333 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal2356 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal2369 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleGoal2392 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_31_in_ruleGoal2462 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleGoal2474 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal2495 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_15_in_ruleGoal2508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal2529 = new BitSet(new long[]{0x00000000FBF9E000L});
    public static final BitSet FOLLOW_16_in_ruleGoal2584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement2620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleRequirement2667 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement2684 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRequirement2701 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_13_in_ruleRequirement2759 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQNEREF_in_ruleRequirement2782 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_20_in_ruleRequirement2850 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleRequirement2873 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_21_in_ruleRequirement2941 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement2962 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_22_in_ruleRequirement3030 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3051 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_23_in_ruleRequirement3119 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3140 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_24_in_ruleRequirement3208 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3229 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_ruleRSLVariable_in_ruleRequirement3305 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_14_in_ruleRequirement3373 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3394 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement3407 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3428 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_31_in_ruleRequirement3498 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRequirement3510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3530 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement3543 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3563 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_31_in_ruleRequirement3633 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleRequirement3645 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQNEREF_in_ruleRequirement3666 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement3679 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQNEREF_in_ruleRequirement3700 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_35_in_ruleRequirement3770 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement3793 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement3806 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement3829 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleRequirement3907 = new BitSet(new long[]{0x0000001991F36000L});
    public static final BitSet FOLLOW_36_in_ruleRequirement3975 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement3998 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement4011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement4034 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_28_in_ruleRequirement4104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement4127 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement4140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement4163 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_31_in_ruleRequirement4233 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRequirement4245 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement4268 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement4281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement4304 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_31_in_ruleRequirement4374 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleRequirement4386 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement4409 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement4422 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleRequirement4445 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_31_in_ruleRequirement4515 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleRequirement4527 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4548 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_15_in_ruleRequirement4561 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4582 = new BitSet(new long[]{0x0000001991F3E000L});
    public static final BitSet FOLLOW_16_in_ruleRequirement4637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazard_in_entryRuleHazard4673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazard4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleHazard4720 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard4737 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleHazard4754 = new BitSet(new long[]{0x0000002001716000L});
    public static final BitSet FOLLOW_13_in_ruleHazard4812 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQNEREF_in_ruleHazard4835 = new BitSet(new long[]{0x0000002001716000L});
    public static final BitSet FOLLOW_20_in_ruleHazard4903 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleHazard4926 = new BitSet(new long[]{0x0000002001716000L});
    public static final BitSet FOLLOW_21_in_ruleHazard4994 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5015 = new BitSet(new long[]{0x0000002001716000L});
    public static final BitSet FOLLOW_22_in_ruleHazard5083 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5104 = new BitSet(new long[]{0x0000002001716000L});
    public static final BitSet FOLLOW_37_in_ruleHazard5172 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleHazard5184 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_ruleHazard5207 = new BitSet(new long[]{0x0000002001716000L});
    public static final BitSet FOLLOW_24_in_ruleHazard5275 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5296 = new BitSet(new long[]{0x0000002001716000L});
    public static final BitSet FOLLOW_14_in_ruleHazard5364 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5385 = new BitSet(new long[]{0x000000200171E000L});
    public static final BitSet FOLLOW_15_in_ruleHazard5398 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5419 = new BitSet(new long[]{0x000000200171E000L});
    public static final BitSet FOLLOW_16_in_ruleHazard5474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument5510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument5520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument5566 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleExternalDocument5579 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument5600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH5639 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH5650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5691 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_40_in_ruleDOCPATH5709 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5726 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleDOCPATH5744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT5805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT5816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5856 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleDOCFRAGMENT5875 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5890 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription5939 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription5949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription5994 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6030 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement6040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement6082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement6113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath6149 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath6159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath6204 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleReferencePath6217 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath6238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString6276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString6287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString6326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOTTEDREF_in_entryRuleDOTTEDREF6371 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOTTEDREF6382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOTTEDREF6422 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleDOTTEDREF6441 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOTTEDREF6456 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_ruleQNEREF_in_entryRuleQNEREF6504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQNEREF6515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQNEREF6556 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleQNEREF6574 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQNEREF6591 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_41_in_ruleQNEREF6610 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQNEREF6625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCATREF_in_entryRuleCATREF6673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCATREF6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCATREF6724 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleCATREF6742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCATREF6757 = new BitSet(new long[]{0x0000000000000002L});

}
