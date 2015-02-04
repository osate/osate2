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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Specification", "Description", "Requirement", "Stakeholder", "Conflicts", "Constants", "Mitigates", "Rationale", "Category", "Document", "Include", "Refines", "Section", "Assert", "Folder", "Goals", "Goal", "This", "With", "For", "See", "ExclamationMarkEqualsSign", "FullStopAsterisk", "ColonColon", "LessThanSignEqualsSign", "GreaterThanSignEqualsSign", "NumberSign", "PercentSign", "Ampersand", "FullStop", "Solidus", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=41;
    public static final int Specification=4;
    public static final int Constants=9;
    public static final int Assert=17;
    public static final int RULE_ANY_OTHER=47;
    public static final int RightSquareBracket=40;
    public static final int Mitigates=10;
    public static final int Requirement=6;
    public static final int Solidus=34;
    public static final int EOF=-1;
    public static final int GreaterThanSign=38;
    public static final int FullStop=33;
    public static final int PercentSign=31;
    public static final int LessThanSign=36;
    public static final int RULE_INT=42;
    public static final int LeftSquareBracket=39;
    public static final int Refines=15;
    public static final int Conflicts=8;
    public static final int ExclamationMarkEqualsSign=25;
    public static final int Stakeholder=7;
    public static final int This=21;
    public static final int FullStopAsterisk=26;
    public static final int LessThanSignEqualsSign=28;
    public static final int Colon=35;
    public static final int RULE_SL_COMMENT=45;
    public static final int For=23;
    public static final int Include=14;
    public static final int NumberSign=30;
    public static final int Rationale=11;
    public static final int With=22;
    public static final int RULE_ML_COMMENT=44;
    public static final int Goal=20;
    public static final int Ampersand=32;
    public static final int Goals=19;
    public static final int ColonColon=27;
    public static final int Document=13;
    public static final int Description=5;
    public static final int RULE_STRING=43;
    public static final int Folder=18;
    public static final int See=24;
    public static final int Section=16;
    public static final int GreaterThanSignEqualsSign=29;
    public static final int Category=12;
    public static final int RULE_WS=46;
    public static final int EqualsSign=37;

    // delegates
    // delegators


        public InternalReqSpecParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReqSpecParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReqSpecParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g"; }




    	private ReqSpecGrammarAccess grammarAccess;
    	 	
    	public InternalReqSpecParser(TokenStream input, ReqSpecGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "ReqSpec";	
    	} 
    	   	   	
    	@Override
    	protected ReqSpecGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleReqSpec"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:61:1: entryRuleReqSpec returns [EObject current=null] : iv_ruleReqSpec= ruleReqSpec EOF ;
    public final EObject entryRuleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpec = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:62:2: (iv_ruleReqSpec= ruleReqSpec EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:63:2: iv_ruleReqSpec= ruleReqSpec EOF
            {
             newCompositeNode(grammarAccess.getReqSpecRule()); 
            pushFollow(FOLLOW_ruleReqSpec_in_entryRuleReqSpec67);
            iv_ruleReqSpec=ruleReqSpec();

            state._fsp--;

             current =iv_ruleReqSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpec77); 

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
    // $ANTLR end "entryRuleReqSpec"


    // $ANTLR start "ruleReqSpec"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:70:1: ruleReqSpec returns [EObject current=null] : (this_ReqSpecs_0= ruleReqSpecs | this_StakeholderGoals_1= ruleStakeholderGoals | this_ReqDocument_2= ruleReqDocument ) ;
    public final EObject ruleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject this_ReqSpecs_0 = null;

        EObject this_StakeholderGoals_1 = null;

        EObject this_ReqDocument_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:73:28: ( (this_ReqSpecs_0= ruleReqSpecs | this_StakeholderGoals_1= ruleStakeholderGoals | this_ReqDocument_2= ruleReqDocument ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:1: (this_ReqSpecs_0= ruleReqSpecs | this_StakeholderGoals_1= ruleStakeholderGoals | this_ReqDocument_2= ruleReqDocument )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:1: (this_ReqSpecs_0= ruleReqSpecs | this_StakeholderGoals_1= ruleStakeholderGoals | this_ReqDocument_2= ruleReqDocument )
            int alt1=3;
            switch ( input.LA(1) ) {
            case Requirement:
                {
                alt1=1;
                }
                break;
            case Stakeholder:
                {
                alt1=2;
                }
                break;
            case Document:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:5: this_ReqSpecs_0= ruleReqSpecs
                    {
                     
                            newCompositeNode(grammarAccess.getReqSpecAccess().getReqSpecsParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleReqSpecs_in_ruleReqSpec124);
                    this_ReqSpecs_0=ruleReqSpecs();

                    state._fsp--;


                            current = this_ReqSpecs_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:85:5: this_StakeholderGoals_1= ruleStakeholderGoals
                    {
                     
                            newCompositeNode(grammarAccess.getReqSpecAccess().getStakeholderGoalsParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleStakeholderGoals_in_ruleReqSpec151);
                    this_StakeholderGoals_1=ruleStakeholderGoals();

                    state._fsp--;


                            current = this_StakeholderGoals_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:95:5: this_ReqDocument_2= ruleReqDocument
                    {
                     
                            newCompositeNode(grammarAccess.getReqSpecAccess().getReqDocumentParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleReqDocument_in_ruleReqSpec178);
                    this_ReqDocument_2=ruleReqDocument();

                    state._fsp--;


                            current = this_ReqDocument_2;
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
    // $ANTLR end "ruleReqSpec"


    // $ANTLR start "entryRuleStakeholderGoals"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:117:1: entryRuleStakeholderGoals returns [EObject current=null] : iv_ruleStakeholderGoals= ruleStakeholderGoals EOF ;
    public final EObject entryRuleStakeholderGoals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStakeholderGoals = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:118:2: (iv_ruleStakeholderGoals= ruleStakeholderGoals EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:119:2: iv_ruleStakeholderGoals= ruleStakeholderGoals EOF
            {
             newCompositeNode(grammarAccess.getStakeholderGoalsRule()); 
            pushFollow(FOLLOW_ruleStakeholderGoals_in_entryRuleStakeholderGoals218);
            iv_ruleStakeholderGoals=ruleStakeholderGoals();

            state._fsp--;

             current =iv_ruleStakeholderGoals; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStakeholderGoals228); 

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
    // $ANTLR end "entryRuleStakeholderGoals"


    // $ANTLR start "ruleStakeholderGoals"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:126:1: ruleStakeholderGoals returns [EObject current=null] : (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder ) ) ) otherlv_12= RightSquareBracket ) ;
    public final EObject ruleStakeholderGoals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_title_4_0 = null;

        AntlrDatatypeRuleToken lv_targetDescription_7_0 = null;

        EObject lv_description_9_0 = null;

        EObject lv_content_11_1 = null;

        EObject lv_content_11_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:129:28: ( (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder ) ) ) otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:130:1: (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder ) ) ) otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:130:1: (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder ) ) ) otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:131:2: otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder ) ) ) otherlv_12= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleStakeholderGoals266); 

                	newLeafNode(otherlv_0, grammarAccess.getStakeholderGoalsAccess().getStakeholderKeyword_0());
                
            otherlv_1=(Token)match(input,Goals,FOLLOW_Goals_in_ruleStakeholderGoals278); 

                	newLeafNode(otherlv_1, grammarAccess.getStakeholderGoalsAccess().getGoalsKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:140:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:141:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:141:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:142:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStakeholderGoals294); 

            			newLeafNode(lv_name_2_0, grammarAccess.getStakeholderGoalsAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStakeholderGoalsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:158:2: (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Colon) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:159:2: otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) )
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleStakeholderGoals313); 

                        	newLeafNode(otherlv_3, grammarAccess.getStakeholderGoalsAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:163:1: ( (lv_title_4_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:164:1: (lv_title_4_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:164:1: (lv_title_4_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:165:3: lv_title_4_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getTitleValueStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholderGoals333);
                    lv_title_4_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_4_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:181:4: (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==For) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:182:2: otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
                    {
                    otherlv_5=(Token)match(input,For,FOLLOW_For_in_ruleStakeholderGoals349); 

                        	newLeafNode(otherlv_5, grammarAccess.getStakeholderGoalsAccess().getForKeyword_4_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:186:1: ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==RULE_ID) ) {
                        alt3=1;
                    }
                    else if ( (LA3_0==RULE_STRING) ) {
                        alt3=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 0, input);

                        throw nvae;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:186:2: ( ( ruleAadlClassifierReference ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:186:2: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:187:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:187:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:188:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getStakeholderGoalsRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getTargetClassifierCrossReference_4_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleStakeholderGoals372);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:202:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:202:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:203:1: (lv_targetDescription_7_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:203:1: (lv_targetDescription_7_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:204:3: lv_targetDescription_7_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getTargetDescriptionValueStringParserRuleCall_4_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleStakeholderGoals399);
                            lv_targetDescription_7_0=ruleValueString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"targetDescription",
                                    		lv_targetDescription_7_0, 
                                    		"ValueString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:220:5: (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Description) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:221:2: otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) )
                    {
                    otherlv_8=(Token)match(input,Description,FOLLOW_Description_in_ruleStakeholderGoals416); 

                        	newLeafNode(otherlv_8, grammarAccess.getStakeholderGoalsAccess().getDescriptionKeyword_5_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:225:1: ( (lv_description_9_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:226:1: (lv_description_9_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:226:1: (lv_description_9_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:227:3: lv_description_9_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getDescriptionMultiLineStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleStakeholderGoals436);
                    lv_description_9_0=ruleMultiLineString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_9_0, 
                            		"MultiLineString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals451); 

                	newLeafNode(otherlv_10, grammarAccess.getStakeholderGoalsAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:248:1: ( ( (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:249:1: ( (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:249:1: ( (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:250:1: (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:250:1: (lv_content_11_1= ruleGoal | lv_content_11_2= ruleGoalFolder )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Goal) ) {
                alt6=1;
            }
            else if ( (LA6_0==Folder) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:251:3: lv_content_11_1= ruleGoal
                    {
                     
                    	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getContentGoalParserRuleCall_7_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleGoal_in_ruleStakeholderGoals473);
                    lv_content_11_1=ruleGoal();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
                    	        }
                           		add(
                           			current, 
                           			"content",
                            		lv_content_11_1, 
                            		"Goal");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:266:8: lv_content_11_2= ruleGoalFolder
                    {
                     
                    	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getContentGoalFolderParserRuleCall_7_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleGoalFolder_in_ruleStakeholderGoals492);
                    lv_content_11_2=ruleGoalFolder();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getStakeholderGoalsRule());
                    	        }
                           		add(
                           			current, 
                           			"content",
                            		lv_content_11_2, 
                            		"GoalFolder");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

            }


            }


            }

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleStakeholderGoals508); 

                	newLeafNode(otherlv_12, grammarAccess.getStakeholderGoalsAccess().getRightSquareBracketKeyword_8());
                

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
    // $ANTLR end "ruleStakeholderGoals"


    // $ANTLR start "entryRuleReqDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:297:1: entryRuleReqDocument returns [EObject current=null] : iv_ruleReqDocument= ruleReqDocument EOF ;
    public final EObject entryRuleReqDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:298:2: (iv_ruleReqDocument= ruleReqDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:299:2: iv_ruleReqDocument= ruleReqDocument EOF
            {
             newCompositeNode(grammarAccess.getReqDocumentRule()); 
            pushFollow(FOLLOW_ruleReqDocument_in_entryRuleReqDocument542);
            iv_ruleReqDocument=ruleReqDocument();

            state._fsp--;

             current =iv_ruleReqDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqDocument552); 

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
    // $ANTLR end "entryRuleReqDocument"


    // $ANTLR start "ruleReqDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:306:1: ruleReqDocument returns [EObject current=null] : (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket ) ;
    public final EObject ruleReqDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_5_0 = null;

        EObject lv_content_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:309:28: ( (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:310:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:310:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:311:2: otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Document,FOLLOW_Document_in_ruleReqDocument590); 

                	newLeafNode(otherlv_0, grammarAccess.getReqDocumentAccess().getDocumentKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:315:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:316:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:316:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:317:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqDocument606); 

            			newLeafNode(lv_name_1_0, grammarAccess.getReqDocumentAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReqDocumentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:333:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Colon) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:334:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqDocument625); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqDocumentAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:338:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:339:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:339:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:340:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqDocumentAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqDocument645);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqDocumentRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:356:4: (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Description) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:357:2: otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) )
                    {
                    otherlv_4=(Token)match(input,Description,FOLLOW_Description_in_ruleReqDocument661); 

                        	newLeafNode(otherlv_4, grammarAccess.getReqDocumentAccess().getDescriptionKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:361:1: ( (lv_description_5_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:362:1: (lv_description_5_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:362:1: (lv_description_5_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:363:3: lv_description_5_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqDocumentAccess().getDescriptionMultiLineStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqDocument681);
                    lv_description_5_0=ruleMultiLineString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqDocumentRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_5_0, 
                            		"MultiLineString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqDocument696); 

                	newLeafNode(otherlv_6, grammarAccess.getReqDocumentAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:384:1: ( (lv_content_7_0= ruleDocumentSection ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:385:1: (lv_content_7_0= ruleDocumentSection )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:385:1: (lv_content_7_0= ruleDocumentSection )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:386:3: lv_content_7_0= ruleDocumentSection
            {
             
            	        newCompositeNode(grammarAccess.getReqDocumentAccess().getContentDocumentSectionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDocumentSection_in_ruleReqDocument716);
            lv_content_7_0=ruleDocumentSection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReqDocumentRule());
            	        }
                   		add(
                   			current, 
                   			"content",
                    		lv_content_7_0, 
                    		"DocumentSection");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqDocument729); 

                	newLeafNode(otherlv_8, grammarAccess.getReqDocumentAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleReqDocument"


    // $ANTLR start "entryRuleDocumentSection"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:415:1: entryRuleDocumentSection returns [EObject current=null] : iv_ruleDocumentSection= ruleDocumentSection EOF ;
    public final EObject entryRuleDocumentSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentSection = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:416:2: (iv_ruleDocumentSection= ruleDocumentSection EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:417:2: iv_ruleDocumentSection= ruleDocumentSection EOF
            {
             newCompositeNode(grammarAccess.getDocumentSectionRule()); 
            pushFollow(FOLLOW_ruleDocumentSection_in_entryRuleDocumentSection763);
            iv_ruleDocumentSection=ruleDocumentSection();

            state._fsp--;

             current =iv_ruleDocumentSection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentSection773); 

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
    // $ANTLR end "entryRuleDocumentSection"


    // $ANTLR start "ruleDocumentSection"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:424:1: ruleDocumentSection returns [EObject current=null] : (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket ) ;
    public final EObject ruleDocumentSection() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_label_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_5_0 = null;

        EObject lv_content_7_1 = null;

        EObject lv_content_7_2 = null;

        EObject lv_content_7_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:427:28: ( (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:428:1: (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:428:1: (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:429:2: otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Section,FOLLOW_Section_in_ruleDocumentSection811); 

                	newLeafNode(otherlv_0, grammarAccess.getDocumentSectionAccess().getSectionKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:433:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:434:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:434:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:435:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDocumentSection827); 

            			newLeafNode(lv_label_1_0, grammarAccess.getDocumentSectionAccess().getLabelIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDocumentSectionRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:451:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Colon) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:452:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleDocumentSection846); 

                        	newLeafNode(otherlv_2, grammarAccess.getDocumentSectionAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:456:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:457:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:457:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:458:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleDocumentSection866);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:474:4: (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Description) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:475:2: otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) )
                    {
                    otherlv_4=(Token)match(input,Description,FOLLOW_Description_in_ruleDocumentSection882); 

                        	newLeafNode(otherlv_4, grammarAccess.getDocumentSectionAccess().getDescriptionKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:479:1: ( (lv_description_5_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:480:1: (lv_description_5_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:480:1: (lv_description_5_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:481:3: lv_description_5_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getDescriptionMultiLineStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleDocumentSection902);
                    lv_description_5_0=ruleMultiLineString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
                    	        }
                           		set(
                           			current, 
                           			"description",
                            		lv_description_5_0, 
                            		"MultiLineString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleDocumentSection917); 

                	newLeafNode(otherlv_6, grammarAccess.getDocumentSectionAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:502:1: ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==Requirement||LA12_0==Section||LA12_0==Goal) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:503:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:503:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:504:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:504:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection )
            	    int alt11=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt11=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt11=2;
            	        }
            	        break;
            	    case Section:
            	        {
            	        alt11=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt11) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:505:3: lv_content_7_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentGoalParserRuleCall_5_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleDocumentSection939);
            	            lv_content_7_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_7_1, 
            	                    		"Goal");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:520:8: lv_content_7_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentRequirementParserRuleCall_5_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleDocumentSection958);
            	            lv_content_7_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_7_2, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:535:8: lv_content_7_3= ruleDocumentSection
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocumentSectionParserRuleCall_5_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDocumentSection_in_ruleDocumentSection977);
            	            lv_content_7_3=ruleDocumentSection();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getDocumentSectionRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_7_3, 
            	                    		"DocumentSection");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_8=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleDocumentSection994); 

                	newLeafNode(otherlv_8, grammarAccess.getDocumentSectionAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleDocumentSection"


    // $ANTLR start "entryRuleReqSpecs"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:566:1: entryRuleReqSpecs returns [EObject current=null] : iv_ruleReqSpecs= ruleReqSpecs EOF ;
    public final EObject entryRuleReqSpecs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecs = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:567:2: (iv_ruleReqSpecs= ruleReqSpecs EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:568:2: iv_ruleReqSpecs= ruleReqSpecs EOF
            {
             newCompositeNode(grammarAccess.getReqSpecsRule()); 
            pushFollow(FOLLOW_ruleReqSpecs_in_entryRuleReqSpecs1028);
            iv_ruleReqSpecs=ruleReqSpecs();

            state._fsp--;

             current =iv_ruleReqSpecs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecs1038); 

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
    // $ANTLR end "entryRuleReqSpecs"


    // $ANTLR start "ruleReqSpecs"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:575:1: ruleReqSpecs returns [EObject current=null] : (otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* ) ) ) otherlv_15= RightSquareBracket ) ;
    public final EObject ruleReqSpecs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        AntlrDatatypeRuleToken lv_title_4_0 = null;

        AntlrDatatypeRuleToken lv_targetDescription_7_0 = null;

        EObject lv_constants_13_0 = null;

        EObject lv_content_14_1 = null;

        EObject lv_content_14_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:578:28: ( (otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* ) ) ) otherlv_15= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:579:1: (otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* ) ) ) otherlv_15= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:579:1: (otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* ) ) ) otherlv_15= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:580:2: otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* ) ) ) otherlv_15= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleReqSpecs1076); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecsAccess().getRequirementKeyword_0());
                
            otherlv_1=(Token)match(input,Specification,FOLLOW_Specification_in_ruleReqSpecs1088); 

                	newLeafNode(otherlv_1, grammarAccess.getReqSpecsAccess().getSpecificationKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:589:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:590:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:590:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:591:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecs1104); 

            			newLeafNode(lv_name_2_0, grammarAccess.getReqSpecsAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReqSpecsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:607:2: (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Colon) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:608:2: otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) )
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqSpecs1123); 

                        	newLeafNode(otherlv_3, grammarAccess.getReqSpecsAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:612:1: ( (lv_title_4_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:613:1: (lv_title_4_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:613:1: (lv_title_4_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:614:3: lv_title_4_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTitleValueStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecs1143);
                    lv_title_4_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_4_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:630:4: (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==For) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:631:2: otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
                    {
                    otherlv_5=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecs1159); 

                        	newLeafNode(otherlv_5, grammarAccess.getReqSpecsAccess().getForKeyword_4_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:635:1: ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==RULE_ID) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==RULE_STRING) ) {
                        alt14=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:635:2: ( ( ruleAadlClassifierReference ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:635:2: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:636:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:636:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:637:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getReqSpecsRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTargetClassifierCrossReference_4_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecs1182);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:651:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:651:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:652:1: (lv_targetDescription_7_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:652:1: (lv_targetDescription_7_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:3: lv_targetDescription_7_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTargetDescriptionValueStringParserRuleCall_4_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecs1209);
                            lv_targetDescription_7_0=ruleValueString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"targetDescription",
                                    		lv_targetDescription_7_0, 
                                    		"ValueString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:669:5: (otherlv_8= Include ( ( ruleQualifiedName ) )+ )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==Include) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:670:2: otherlv_8= Include ( ( ruleQualifiedName ) )+
                    {
                    otherlv_8=(Token)match(input,Include,FOLLOW_Include_in_ruleReqSpecs1226); 

                        	newLeafNode(otherlv_8, grammarAccess.getReqSpecsAccess().getIncludeKeyword_5_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:674:1: ( ( ruleQualifiedName ) )+
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
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:675:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:675:1: ( ruleQualifiedName )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:676:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getReqSpecsRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecsAccess().getOtherreqspecsReqSpecsCrossReference_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleReqSpecs1248);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
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
                    break;

            }

            otherlv_10=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecs1264); 

                	newLeafNode(otherlv_10, grammarAccess.getReqSpecsAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:694:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:696:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:696:1: ( ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:697:2: ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:700:2: ( ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:701:3: ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:701:3: ( ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) ) )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( LA21_0 ==Constants && getUnorderedGroupHelper().canSelect(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7(), 0) ) {
                    alt21=1;
                }
                else if ( (LA21_0==Requirement||LA21_0==Folder) && getUnorderedGroupHelper().canSelect(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7(), 1) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:703:4: ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:703:4: ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:704:5: {...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleReqSpecs", "getUnorderedGroupHelper().canSelect(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:704:105: ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:705:6: ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:708:6: ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:708:7: {...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleReqSpecs", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:708:16: (otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:709:2: otherlv_12= Constants ( (lv_constants_13_0= ruleConstantDecl ) )+
            	    {
            	    otherlv_12=(Token)match(input,Constants,FOLLOW_Constants_in_ruleReqSpecs1322); 

            	        	newLeafNode(otherlv_12, grammarAccess.getReqSpecsAccess().getConstantsKeyword_7_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:713:1: ( (lv_constants_13_0= ruleConstantDecl ) )+
            	    int cnt18=0;
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==RULE_ID) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:714:1: (lv_constants_13_0= ruleConstantDecl )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:714:1: (lv_constants_13_0= ruleConstantDecl )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:715:3: lv_constants_13_0= ruleConstantDecl
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getReqSpecsAccess().getConstantsConstantDeclParserRuleCall_7_0_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleConstantDecl_in_ruleReqSpecs1342);
            	    	    lv_constants_13_0=ruleConstantDecl();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"constants",
            	    	            		lv_constants_13_0, 
            	    	            		"ConstantDecl");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt18 >= 1 ) break loop18;
            	                EarlyExitException eee =
            	                    new EarlyExitException(18, input);
            	                throw eee;
            	        }
            	        cnt18++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:738:4: ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:738:4: ({...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:739:5: {...}? => ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleReqSpecs", "getUnorderedGroupHelper().canSelect(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:739:105: ( ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:740:6: ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:743:6: ({...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) ) )+
            	    int cnt20=0;
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Requirement) ) {
            	            int LA20_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt20=1;
            	            }


            	        }
            	        else if ( (LA20_0==Folder) ) {
            	            int LA20_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt20=1;
            	            }


            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:743:7: {...}? => ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleReqSpecs", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:743:16: ( ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:744:1: ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:744:1: ( (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:745:1: (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:745:1: (lv_content_14_1= ruleRequirement | lv_content_14_2= ruleReqSpecFolder )
            	    	    int alt19=2;
            	    	    int LA19_0 = input.LA(1);

            	    	    if ( (LA19_0==Requirement) ) {
            	    	        alt19=1;
            	    	    }
            	    	    else if ( (LA19_0==Folder) ) {
            	    	        alt19=2;
            	    	    }
            	    	    else {
            	    	        NoViableAltException nvae =
            	    	            new NoViableAltException("", 19, 0, input);

            	    	        throw nvae;
            	    	    }
            	    	    switch (alt19) {
            	    	        case 1 :
            	    	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:746:3: lv_content_14_1= ruleRequirement
            	    	            {
            	    	             
            	    	            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getContentRequirementParserRuleCall_7_1_0_0()); 
            	    	            	    
            	    	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecs1421);
            	    	            lv_content_14_1=ruleRequirement();

            	    	            state._fsp--;


            	    	            	        if (current==null) {
            	    	            	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
            	    	            	        }
            	    	                   		add(
            	    	                   			current, 
            	    	                   			"content",
            	    	                    		lv_content_14_1, 
            	    	                    		"Requirement");
            	    	            	        afterParserOrEnumRuleCall();
            	    	            	    

            	    	            }
            	    	            break;
            	    	        case 2 :
            	    	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:761:8: lv_content_14_2= ruleReqSpecFolder
            	    	            {
            	    	             
            	    	            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getContentReqSpecFolderParserRuleCall_7_1_0_1()); 
            	    	            	    
            	    	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecs1440);
            	    	            lv_content_14_2=ruleReqSpecFolder();

            	    	            state._fsp--;


            	    	            	        if (current==null) {
            	    	            	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
            	    	            	        }
            	    	                   		add(
            	    	                   			current, 
            	    	                   			"content",
            	    	                    		lv_content_14_2, 
            	    	                    		"ReqSpecFolder");
            	    	            	        afterParserOrEnumRuleCall();
            	    	            	    

            	    	            }
            	    	            break;

            	    	    }


            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt20 >= 1 ) break loop20;
            	                EarlyExitException eee =
            	                    new EarlyExitException(20, input);
            	                throw eee;
            	        }
            	        cnt20++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getReqSpecsAccess().getUnorderedGroup_7());
            	

            }

            otherlv_15=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecs1497); 

                	newLeafNode(otherlv_15, grammarAccess.getReqSpecsAccess().getRightSquareBracketKeyword_8());
                

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
    // $ANTLR end "ruleReqSpecs"


    // $ANTLR start "entryRuleReqSpecFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:808:1: entryRuleReqSpecFolder returns [EObject current=null] : iv_ruleReqSpecFolder= ruleReqSpecFolder EOF ;
    public final EObject entryRuleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:809:2: (iv_ruleReqSpecFolder= ruleReqSpecFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:810:2: iv_ruleReqSpecFolder= ruleReqSpecFolder EOF
            {
             newCompositeNode(grammarAccess.getReqSpecFolderRule()); 
            pushFollow(FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1533);
            iv_ruleReqSpecFolder=ruleReqSpecFolder();

            state._fsp--;

             current =iv_ruleReqSpecFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecFolder1543); 

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
    // $ANTLR end "entryRuleReqSpecFolder"


    // $ANTLR start "ruleReqSpecFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:817:1: ruleReqSpecFolder returns [EObject current=null] : (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket ) ;
    public final EObject ruleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_label_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_content_5_1 = null;

        EObject lv_content_5_2 = null;

        EObject lv_content_5_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:820:28: ( (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:821:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:821:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:822:2: otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleReqSpecFolder1581); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:826:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:827:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:827:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:828:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecFolder1597); 

            			newLeafNode(lv_label_1_0, grammarAccess.getReqSpecFolderAccess().getLabelIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReqSpecFolderRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:844:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Colon) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:845:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqSpecFolder1616); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecFolderAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:849:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:850:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:850:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:851:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecFolder1636);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1651); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:872:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==Requirement||LA24_0==Folder||LA24_0==Goal) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:873:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:873:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:874:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:874:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    int alt23=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt23=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt23=2;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt23=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt23) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:875:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecFolder1673);
            	            lv_content_5_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:890:8: lv_content_5_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentRequirementParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecFolder1692);
            	            lv_content_5_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:905:8: lv_content_5_3= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentReqSpecFolderParserRuleCall_4_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1711);
            	            lv_content_5_3=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_3, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1728); 

                	newLeafNode(otherlv_6, grammarAccess.getReqSpecFolderAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleReqSpecFolder"


    // $ANTLR start "entryRuleGoalFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:936:1: entryRuleGoalFolder returns [EObject current=null] : iv_ruleGoalFolder= ruleGoalFolder EOF ;
    public final EObject entryRuleGoalFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:937:2: (iv_ruleGoalFolder= ruleGoalFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:938:2: iv_ruleGoalFolder= ruleGoalFolder EOF
            {
             newCompositeNode(grammarAccess.getGoalFolderRule()); 
            pushFollow(FOLLOW_ruleGoalFolder_in_entryRuleGoalFolder1762);
            iv_ruleGoalFolder=ruleGoalFolder();

            state._fsp--;

             current =iv_ruleGoalFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalFolder1772); 

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
    // $ANTLR end "entryRuleGoalFolder"


    // $ANTLR start "ruleGoalFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:945:1: ruleGoalFolder returns [EObject current=null] : (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket ) ;
    public final EObject ruleGoalFolder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_label_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_content_5_1 = null;

        EObject lv_content_5_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:948:28: ( (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:949:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:949:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:950:2: otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleGoalFolder1810); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:954:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:955:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:955:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:956:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoalFolder1826); 

            			newLeafNode(lv_label_1_0, grammarAccess.getGoalFolderAccess().getLabelIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getGoalFolderRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"label",
                    		lv_label_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:972:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Colon) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:973:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoalFolder1845); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalFolderAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:977:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:978:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:978:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:979:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalFolderAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoalFolder1865);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGoalFolderRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoalFolder1880); 

                	newLeafNode(otherlv_4, grammarAccess.getGoalFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1000:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==Folder||LA27_0==Goal) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1001:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1001:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1002:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1002:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder )
            	    int alt26=2;
            	    int LA26_0 = input.LA(1);

            	    if ( (LA26_0==Goal) ) {
            	        alt26=1;
            	    }
            	    else if ( (LA26_0==Folder) ) {
            	        alt26=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt26) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1003:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getGoalFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleGoalFolder1902);
            	            lv_content_5_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getGoalFolderRule());
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1018:8: lv_content_5_2= ruleGoalFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getGoalFolderAccess().getContentGoalFolderParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoalFolder_in_ruleGoalFolder1921);
            	            lv_content_5_2=ruleGoalFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getGoalFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_2, 
            	                    		"GoalFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoalFolder1938); 

                	newLeafNode(otherlv_6, grammarAccess.getGoalFolderAccess().getRightSquareBracketKeyword_5());
                

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
    // $ANTLR end "ruleGoalFolder"


    // $ANTLR start "entryRuleGoal"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1049:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1050:2: (iv_ruleGoal= ruleGoal EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1051:2: iv_ruleGoal= ruleGoal EOF
            {
             newCompositeNode(grammarAccess.getGoalRule()); 
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal1972);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal1982); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1058:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket ) ;
    public final EObject ruleGoal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        AntlrDatatypeRuleToken lv_targetDescription_6_0 = null;

        EObject lv_description_12_0 = null;

        AntlrDatatypeRuleToken lv_rationale_14_0 = null;

        EObject lv_docReference_28_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1061:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1062:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1062:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1063:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal2020); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1067:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1068:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1068:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1069:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal2036); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1085:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Colon) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1086:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoal2055); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1090:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1092:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoal2075);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getGoalRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1108:4: (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==For) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1109:2: otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleGoal2091); 

                        	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1113:1: ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_ID) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_STRING) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1113:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1113:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1114:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1114:1: (otherlv_5= RULE_ID )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1115:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getGoalRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal2111); 

                            		newLeafNode(otherlv_5, grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_3_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1127:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1127:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1128:1: (lv_targetDescription_6_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1128:1: (lv_targetDescription_6_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1129:3: lv_targetDescription_6_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getGoalAccess().getTargetDescriptionValueStringParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleGoal2138);
                            lv_targetDescription_6_0=ruleValueString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getGoalRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"targetDescription",
                                    		lv_targetDescription_6_0, 
                                    		"ValueString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal2154); 

                	newLeafNode(otherlv_7, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1150:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1152:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1152:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1153:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1156:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1157:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1157:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )*
            loop36:
            do {
                int alt36=9;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1159:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1159:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1160:5: {...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1160:101: ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1161:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1164:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1164:7: {...}? => (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1164:16: (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1165:2: otherlv_9= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_9=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal2212); 

            	        	newLeafNode(otherlv_9, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1169:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1170:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1170:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1171:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal2234);
            	    ruleCatRef();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1191:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1191:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1192:5: {...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1192:101: ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1193:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1196:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1196:7: {...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1196:16: (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1197:2: otherlv_11= Description ( (lv_description_12_0= ruleDescription ) )
            	    {
            	    otherlv_11=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal2303); 

            	        	newLeafNode(otherlv_11, grammarAccess.getGoalAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1201:1: ( (lv_description_12_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1202:1: (lv_description_12_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1202:1: (lv_description_12_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:3: lv_description_12_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal2323);
            	    lv_description_12_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_12_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1226:4: ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1226:4: ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1227:5: {...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1227:101: ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1228:6: ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1231:6: ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1231:7: {...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1231:16: (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1232:2: otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) )
            	    {
            	    otherlv_13=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal2392); 

            	        	newLeafNode(otherlv_13, grammarAccess.getGoalAccess().getRationaleKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1236:1: ( (lv_rationale_14_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1237:1: (lv_rationale_14_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1237:1: (lv_rationale_14_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1238:3: lv_rationale_14_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleValueStringParserRuleCall_5_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal2412);
            	    lv_rationale_14_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_14_0, 
            	            		"ValueString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1261:4: ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1261:4: ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1262:5: {...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1262:101: ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1263:6: ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1266:6: ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1266:7: {...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1266:16: (otherlv_15= Refines ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1267:2: otherlv_15= Refines ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_15=(Token)match(input,Refines,FOLLOW_Refines_in_ruleGoal2481); 

            	        	newLeafNode(otherlv_15, grammarAccess.getGoalAccess().getRefinesKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1271:1: ( ( ruleQualifiedName ) )+
            	    int cnt31=0;
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==RULE_ID) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1272:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1272:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1273:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2503);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


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


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1293:4: ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1293:4: ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1294:5: {...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1294:101: ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1295:6: ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1298:6: ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1298:7: {...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1298:16: (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1299:2: otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_17=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2573); 

            	        	newLeafNode(otherlv_17, grammarAccess.getGoalAccess().getConflictsKeyword_5_4_0());
            	        
            	    otherlv_18=(Token)match(input,With,FOLLOW_With_in_ruleGoal2585); 

            	        	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getWithKeyword_5_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1308:1: ( ( ruleQualifiedName ) )+
            	    int cnt32=0;
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==RULE_ID) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1309:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1309:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1310:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_4_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2607);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt32 >= 1 ) break loop32;
            	                EarlyExitException eee =
            	                    new EarlyExitException(32, input);
            	                throw eee;
            	        }
            	        cnt32++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1330:4: ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1330:4: ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1331:5: {...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1331:101: ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1332:6: ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1335:6: ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1335:7: {...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1335:16: (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1336:2: otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_20=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2677); 

            	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getStakeholderKeyword_5_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1340:1: ( ( ruleQualifiedName ) )+
            	    int cnt33=0;
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==RULE_ID) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1341:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1341:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1342:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_5_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2699);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt33 >= 1 ) break loop33;
            	                EarlyExitException eee =
            	                    new EarlyExitException(33, input);
            	                throw eee;
            	        }
            	        cnt33++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1362:4: ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1362:4: ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1363:5: {...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1363:101: ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1364:6: ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1367:6: ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1367:7: {...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1367:16: (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1368:2: otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_22=(Token)match(input,See,FOLLOW_See_in_ruleGoal2769); 

            	        	newLeafNode(otherlv_22, grammarAccess.getGoalAccess().getSeeKeyword_5_6_0());
            	        
            	    otherlv_23=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal2781); 

            	        	newLeafNode(otherlv_23, grammarAccess.getGoalAccess().getDocumentKeyword_5_6_1());
            	        
            	    otherlv_24=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal2793); 

            	        	newLeafNode(otherlv_24, grammarAccess.getGoalAccess().getRequirementKeyword_5_6_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1382:1: ( ( ruleQualifiedName ) )+
            	    int cnt34=0;
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==RULE_ID) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1383:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1383:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1384:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocumentRequirementContractualElementCrossReference_5_6_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2815);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1404:4: ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1404:4: ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1405:5: {...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1405:101: ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1406:6: ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1409:6: ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1409:7: {...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1409:16: (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1410:2: otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+
            	    {
            	    otherlv_26=(Token)match(input,See,FOLLOW_See_in_ruleGoal2885); 

            	        	newLeafNode(otherlv_26, grammarAccess.getGoalAccess().getSeeKeyword_5_7_0());
            	        
            	    otherlv_27=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal2897); 

            	        	newLeafNode(otherlv_27, grammarAccess.getGoalAccess().getDocumentKeyword_5_7_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1419:1: ( (lv_docReference_28_0= ruleExternalDocument ) )+
            	    int cnt35=0;
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==RULE_ID) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1420:1: (lv_docReference_28_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1420:1: (lv_docReference_28_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1421:3: lv_docReference_28_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_7_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal2917);
            	    	    lv_docReference_28_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_28_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


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


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	

            }

            otherlv_29=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal2972); 

                	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1464:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1465:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1466:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement3006);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement3016); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1473:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket ) ;
    public final EObject ruleRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token lv_rationale_18_0=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        AntlrDatatypeRuleToken lv_targetDescription_6_0 = null;

        EObject lv_description_12_0 = null;

        EObject lv_constants_14_0 = null;

        EObject lv_assert_16_0 = null;

        AntlrDatatypeRuleToken lv_exceptionText_24_0 = null;

        EObject lv_docReference_37_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1476:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1477:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1477:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1478:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement3054); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1482:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1484:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3070); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1500:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==Colon) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1501:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleRequirement3089); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1505:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1506:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1506:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1507:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3109);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
                    	        }
                           		set(
                           			current, 
                           			"title",
                            		lv_title_3_0, 
                            		"ValueString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1523:4: (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==For) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1524:2: otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleRequirement3125); 

                        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1528:1: ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_ID) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==RULE_STRING) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1528:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1528:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1529:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1529:1: (otherlv_5= RULE_ID )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1530:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getRequirementRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3145); 

                            		newLeafNode(otherlv_5, grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_3_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1542:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1542:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1543:1: (lv_targetDescription_6_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1543:1: (lv_targetDescription_6_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1544:3: lv_targetDescription_6_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getRequirementAccess().getTargetDescriptionValueStringParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3172);
                            lv_targetDescription_6_0=ruleValueString();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRequirementRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"targetDescription",
                                    		lv_targetDescription_6_0, 
                                    		"ValueString");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3188); 

                	newLeafNode(otherlv_7, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1565:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1567:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1567:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1568:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1571:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1572:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1572:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )*
            loop47:
            do {
                int alt47=12;
                alt47 = dfa47.predict(input);
                switch (alt47) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1574:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1574:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1575:5: {...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1575:108: ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1576:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1579:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1579:7: {...}? => (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1579:16: (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1580:2: otherlv_9= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_9=(Token)match(input,Category,FOLLOW_Category_in_ruleRequirement3246); 

            	        	newLeafNode(otherlv_9, grammarAccess.getRequirementAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1584:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1585:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1585:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1586:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3268);
            	    ruleCatRef();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1607:5: {...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1607:108: ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1608:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:7: {...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:16: (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1612:2: otherlv_11= Description ( (lv_description_12_0= ruleDescription ) )
            	    {
            	    otherlv_11=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3337); 

            	        	newLeafNode(otherlv_11, grammarAccess.getRequirementAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1616:1: ( (lv_description_12_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1617:1: (lv_description_12_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1617:1: (lv_description_12_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1618:3: lv_description_12_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3357);
            	    lv_description_12_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_12_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1641:4: ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1641:4: ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1642:5: {...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1642:108: ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1643:6: ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1646:6: ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1646:7: {...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1646:16: (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1647:2: otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+
            	    {
            	    otherlv_13=(Token)match(input,Constants,FOLLOW_Constants_in_ruleRequirement3426); 

            	        	newLeafNode(otherlv_13, grammarAccess.getRequirementAccess().getConstantsKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1651:1: ( (lv_constants_14_0= ruleConstantDecl ) )+
            	    int cnt40=0;
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==RULE_ID) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1652:1: (lv_constants_14_0= ruleConstantDecl )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1652:1: (lv_constants_14_0= ruleConstantDecl )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1653:3: lv_constants_14_0= ruleConstantDecl
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getConstantsConstantDeclParserRuleCall_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleConstantDecl_in_ruleRequirement3446);
            	    	    lv_constants_14_0=ruleConstantDecl();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"constants",
            	    	            		lv_constants_14_0, 
            	    	            		"ConstantDecl");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt40 >= 1 ) break loop40;
            	                EarlyExitException eee =
            	                    new EarlyExitException(40, input);
            	                throw eee;
            	        }
            	        cnt40++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1676:4: ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1676:4: ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1677:5: {...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1677:108: ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1678:6: ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1681:6: ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1681:7: {...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1681:16: (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1682:2: otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) )
            	    {
            	    otherlv_15=(Token)match(input,Assert,FOLLOW_Assert_in_ruleRequirement3516); 

            	        	newLeafNode(otherlv_15, grammarAccess.getRequirementAccess().getAssertKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1686:1: ( (lv_assert_16_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1687:1: (lv_assert_16_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1687:1: (lv_assert_16_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1688:3: lv_assert_16_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertPredicateExpressionParserRuleCall_5_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleRequirement3536);
            	    lv_assert_16_0=rulePredicateExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_16_0, 
            	            		"PredicateExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1711:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1711:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1712:5: {...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1712:108: ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1713:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1716:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1716:7: {...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1716:16: (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1717:2: otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) )
            	    {
            	    otherlv_17=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement3605); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getRationaleKeyword_5_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1721:1: ( (lv_rationale_18_0= RULE_STRING ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1722:1: (lv_rationale_18_0= RULE_STRING )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1722:1: (lv_rationale_18_0= RULE_STRING )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1723:3: lv_rationale_18_0= RULE_STRING
            	    {
            	    lv_rationale_18_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRequirement3621); 

            	    			newLeafNode(lv_rationale_18_0, grammarAccess.getRequirementAccess().getRationaleSTRINGTerminalRuleCall_5_4_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_18_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1746:4: ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1746:4: ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1747:5: {...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1747:108: ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1748:6: ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1751:6: ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1751:7: {...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1751:16: (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1752:2: otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_19=(Token)match(input,See,FOLLOW_See_in_ruleRequirement3695); 

            	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getSeeKeyword_5_5_0());
            	        
            	    otherlv_20=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement3707); 

            	        	newLeafNode(otherlv_20, grammarAccess.getRequirementAccess().getGoalKeyword_5_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1761:1: ( ( ruleQualifiedName ) )+
            	    int cnt41=0;
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==RULE_ID) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1762:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1762:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1763:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_5_5_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3729);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt41 >= 1 ) break loop41;
            	                EarlyExitException eee =
            	                    new EarlyExitException(41, input);
            	                throw eee;
            	        }
            	        cnt41++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:4: ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:4: ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1784:5: {...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1784:108: ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1785:6: ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1788:6: ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1788:7: {...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1788:16: (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1789:2: otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) )
            	    {
            	    otherlv_22=(Token)match(input,Mitigates,FOLLOW_Mitigates_in_ruleRequirement3799); 

            	        	newLeafNode(otherlv_22, grammarAccess.getRequirementAccess().getMitigatesKeyword_5_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1793:1: ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) )
            	    int alt42=2;
            	    int LA42_0 = input.LA(1);

            	    if ( (LA42_0==RULE_ID) ) {
            	        alt42=1;
            	    }
            	    else if ( (LA42_0==RULE_STRING) ) {
            	        alt42=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 42, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt42) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1793:2: ( (otherlv_23= RULE_ID ) )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1793:2: ( (otherlv_23= RULE_ID ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1794:1: (otherlv_23= RULE_ID )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1794:1: (otherlv_23= RULE_ID )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1795:3: otherlv_23= RULE_ID
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRequirementRule());
            	            	        }
            	                    
            	            otherlv_23=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3819); 

            	            		newLeafNode(otherlv_23, grammarAccess.getRequirementAccess().getExceptionEObjectCrossReference_5_6_1_0_0()); 
            	            	

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1807:6: ( (lv_exceptionText_24_0= ruleValueString ) )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1807:6: ( (lv_exceptionText_24_0= ruleValueString ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1808:1: (lv_exceptionText_24_0= ruleValueString )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1808:1: (lv_exceptionText_24_0= ruleValueString )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1809:3: lv_exceptionText_24_0= ruleValueString
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getRequirementAccess().getExceptionTextValueStringParserRuleCall_5_6_1_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3846);
            	            lv_exceptionText_24_0=ruleValueString();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	            	        }
            	                   		set(
            	                   			current, 
            	                   			"exceptionText",
            	                    		lv_exceptionText_24_0, 
            	                    		"ValueString");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1832:4: ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1832:4: ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1833:5: {...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1833:108: ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1834:6: ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1837:6: ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1837:7: {...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1837:16: (otherlv_25= Refines ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:2: otherlv_25= Refines ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_25=(Token)match(input,Refines,FOLLOW_Refines_in_ruleRequirement3916); 

            	        	newLeafNode(otherlv_25, grammarAccess.getRequirementAccess().getRefinesKeyword_5_7_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1842:1: ( ( ruleQualifiedName ) )+
            	    int cnt43=0;
            	    loop43:
            	    do {
            	        int alt43=2;
            	        int LA43_0 = input.LA(1);

            	        if ( (LA43_0==RULE_ID) ) {
            	            alt43=1;
            	        }


            	        switch (alt43) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1843:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1843:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1844:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinedReferenceRequirementCrossReference_5_7_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3938);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt43 >= 1 ) break loop43;
            	                EarlyExitException eee =
            	                    new EarlyExitException(43, input);
            	                throw eee;
            	        }
            	        cnt43++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1864:4: ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1864:4: ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1865:5: {...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1865:108: ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1866:6: ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1869:6: ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1869:7: {...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1869:16: (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1870:2: otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_27=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4008); 

            	        	newLeafNode(otherlv_27, grammarAccess.getRequirementAccess().getSeeKeyword_5_8_0());
            	        
            	    otherlv_28=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement4020); 

            	        	newLeafNode(otherlv_28, grammarAccess.getRequirementAccess().getDocumentKeyword_5_8_1());
            	        
            	    otherlv_29=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4032); 

            	        	newLeafNode(otherlv_29, grammarAccess.getRequirementAccess().getGoalKeyword_5_8_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1884:1: ( ( ruleQualifiedName ) )+
            	    int cnt44=0;
            	    loop44:
            	    do {
            	        int alt44=2;
            	        int LA44_0 = input.LA(1);

            	        if ( (LA44_0==RULE_ID) ) {
            	            alt44=1;
            	        }


            	        switch (alt44) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1885:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1885:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1886:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_5_8_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4054);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt44 >= 1 ) break loop44;
            	                EarlyExitException eee =
            	                    new EarlyExitException(44, input);
            	                throw eee;
            	        }
            	        cnt44++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1906:4: ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1906:4: ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1907:5: {...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1907:108: ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1908:6: ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1911:6: ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1911:7: {...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1911:16: (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1912:2: otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_31=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4124); 

            	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getSeeKeyword_5_9_0());
            	        
            	    otherlv_32=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement4136); 

            	        	newLeafNode(otherlv_32, grammarAccess.getRequirementAccess().getDocumentKeyword_5_9_1());
            	        
            	    otherlv_33=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement4148); 

            	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getRequirementKeyword_5_9_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:1: ( ( ruleQualifiedName ) )+
            	    int cnt45=0;
            	    loop45:
            	    do {
            	        int alt45=2;
            	        int LA45_0 = input.LA(1);

            	        if ( (LA45_0==RULE_ID) ) {
            	            alt45=1;
            	        }


            	        switch (alt45) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1927:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1927:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1928:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocumentRequirementContractualElementCrossReference_5_9_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4170);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt45 >= 1 ) break loop45;
            	                EarlyExitException eee =
            	                    new EarlyExitException(45, input);
            	                throw eee;
            	        }
            	        cnt45++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1948:4: ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1948:4: ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:5: {...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:109: ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1950:6: ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:6: ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:7: {...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:16: (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1954:2: otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+
            	    {
            	    otherlv_35=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4240); 

            	        	newLeafNode(otherlv_35, grammarAccess.getRequirementAccess().getSeeKeyword_5_10_0());
            	        
            	    otherlv_36=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement4252); 

            	        	newLeafNode(otherlv_36, grammarAccess.getRequirementAccess().getDocumentKeyword_5_10_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1963:1: ( (lv_docReference_37_0= ruleExternalDocument ) )+
            	    int cnt46=0;
            	    loop46:
            	    do {
            	        int alt46=2;
            	        int LA46_0 = input.LA(1);

            	        if ( (LA46_0==RULE_ID) ) {
            	            alt46=1;
            	        }


            	        switch (alt46) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1964:1: (lv_docReference_37_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1964:1: (lv_docReference_37_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1965:3: lv_docReference_37_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_10_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4272);
            	    	    lv_docReference_37_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_37_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


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


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	

            }

            otherlv_38=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement4327); 

                	newLeafNode(otherlv_38, grammarAccess.getRequirementAccess().getRightSquareBracketKeyword_6());
                

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


    // $ANTLR start "entryRuleExternalDocument"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2008:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2009:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2010:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument4361);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument4371); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2017:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2020:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2021:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2021:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2021:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2021:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2022:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2022:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2023:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument4417);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2039:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==NumberSign) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2040:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument4431); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2044:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2045:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2045:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2046:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument4451);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2070:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2071:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2072:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH4489);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH4500); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2079:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2083:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2084:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2084:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2084:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2084:2: (this_ID_0= RULE_ID kw= Solidus )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_ID) ) {
                    int LA49_1 = input.LA(2);

                    if ( (LA49_1==Solidus) ) {
                        alt49=1;
                    }


                }


                switch (alt49) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2084:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4541); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH4559); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4576); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH4594); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4609); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2125:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2126:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2127:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT4654);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT4665); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2134:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2138:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2139:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2139:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2139:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4705); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2146:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==FullStop) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2147:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT4724); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4739); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop50;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2169:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2170:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2171:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription4787);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription4797); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2178:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2181:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2182:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2182:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==This||LA51_0==Ampersand||LA51_0==RULE_ID||LA51_0==RULE_STRING) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2183:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2183:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2184:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription4842);
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
            	    if ( cnt51 >= 1 ) break loop51;
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2208:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2209:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2210:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement4877);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement4887); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2217:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_2_0=null;
        Token lv_thisTarget_3_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2220:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2221:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2221:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt52=1;
                }
                break;
            case RULE_ID:
                {
                alt52=2;
                }
                break;
            case Ampersand:
                {
                alt52=3;
                }
                break;
            case This:
                {
                alt52=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2221:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2221:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2222:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2222:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2223:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement4929); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2240:6: ( (lv_value_1_0= ruleShowValue ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2240:6: ( (lv_value_1_0= ruleShowValue ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2241:1: (lv_value_1_0= ruleShowValue )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2241:1: (lv_value_1_0= ruleShowValue )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2242:3: lv_value_1_0= ruleShowValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getValueShowValueParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShowValue_in_ruleDescriptionElement4961);
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2259:6: ( (lv_newline_2_0= Ampersand ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2259:6: ( (lv_newline_2_0= Ampersand ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2260:1: (lv_newline_2_0= Ampersand )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2260:1: (lv_newline_2_0= Ampersand )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2261:3: lv_newline_2_0= Ampersand
                    {
                    lv_newline_2_0=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_ruleDescriptionElement4986); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2276:6: ( (lv_thisTarget_3_0= This ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2276:6: ( (lv_thisTarget_3_0= This ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2277:1: (lv_thisTarget_3_0= This )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2277:1: (lv_thisTarget_3_0= This )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2278:3: lv_thisTarget_3_0= This
                    {
                    lv_thisTarget_3_0=(Token)match(input,This,FOLLOW_This_in_ruleDescriptionElement5022); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2300:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2301:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2302:2: iv_ruleShowValue= ruleShowValue EOF
            {
             newCompositeNode(grammarAccess.getShowValueRule()); 
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue5068);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;

             current =iv_ruleShowValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue5078); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2309:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_unit_2_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2312:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2313:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2313:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2313:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2313:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2314:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2314:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2315:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getShowValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue5123); 

            		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefConstantDeclCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2326:2: (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==PercentSign) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2327:2: otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,PercentSign,FOLLOW_PercentSign_in_ruleShowValue5137); 

                        	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2331:1: ( (lv_unit_2_0= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2332:1: (lv_unit_2_0= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2332:1: (lv_unit_2_0= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2333:3: lv_unit_2_0= RULE_ID
                    {
                    lv_unit_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue5153); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2357:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2358:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2359:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath5195);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath5205); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2366:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2369:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2370:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2370:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2370:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2370:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2371:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2371:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2372:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath5250); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2383:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2384:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath5264); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2388:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2389:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2389:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2390:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath5284);
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


    // $ANTLR start "entryRulePredicateExpression"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2414:1: entryRulePredicateExpression returns [EObject current=null] : iv_rulePredicateExpression= rulePredicateExpression EOF ;
    public final EObject entryRulePredicateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateExpression = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2415:2: (iv_rulePredicateExpression= rulePredicateExpression EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2416:2: iv_rulePredicateExpression= rulePredicateExpression EOF
            {
             newCompositeNode(grammarAccess.getPredicateExpressionRule()); 
            pushFollow(FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression5320);
            iv_rulePredicateExpression=rulePredicateExpression();

            state._fsp--;

             current =iv_rulePredicateExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePredicateExpression5330); 

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
    // $ANTLR end "entryRulePredicateExpression"


    // $ANTLR start "rulePredicateExpression"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2423:1: rulePredicateExpression returns [EObject current=null] : (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject rulePredicateExpression() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        Token lv_op_1_5=null;
        Token lv_op_1_6=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2426:28: ( (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) ( (otherlv_2= RULE_ID ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2427:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) ( (otherlv_2= RULE_ID ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2427:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) ( (otherlv_2= RULE_ID ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2427:2: this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) ( (otherlv_2= RULE_ID ) )
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression5366); 
             
                newLeafNode(this_ID_0, grammarAccess.getPredicateExpressionAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2431:1: ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2432:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2432:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2433:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2433:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            int alt54=6;
            switch ( input.LA(1) ) {
            case EqualsSign:
                {
                alt54=1;
                }
                break;
            case ExclamationMarkEqualsSign:
                {
                alt54=2;
                }
                break;
            case LessThanSign:
                {
                alt54=3;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt54=4;
                }
                break;
            case GreaterThanSign:
                {
                alt54=5;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt54=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2434:3: lv_op_1_1= EqualsSign
                    {
                    lv_op_1_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_rulePredicateExpression5386); 

                            newLeafNode(lv_op_1_1, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2447:8: lv_op_1_2= ExclamationMarkEqualsSign
                    {
                    lv_op_1_2=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression5414); 

                            newLeafNode(lv_op_1_2, grammarAccess.getPredicateExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2460:8: lv_op_1_3= LessThanSign
                    {
                    lv_op_1_3=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_rulePredicateExpression5442); 

                            newLeafNode(lv_op_1_3, grammarAccess.getPredicateExpressionAccess().getOpLessThanSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2473:8: lv_op_1_4= LessThanSignEqualsSign
                    {
                    lv_op_1_4=(Token)match(input,LessThanSignEqualsSign,FOLLOW_LessThanSignEqualsSign_in_rulePredicateExpression5470); 

                            newLeafNode(lv_op_1_4, grammarAccess.getPredicateExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2486:8: lv_op_1_5= GreaterThanSign
                    {
                    lv_op_1_5=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_rulePredicateExpression5498); 

                            newLeafNode(lv_op_1_5, grammarAccess.getPredicateExpressionAccess().getOpGreaterThanSignKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2499:8: lv_op_1_6= GreaterThanSignEqualsSign
                    {
                    lv_op_1_6=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression5526); 

                            newLeafNode(lv_op_1_6, grammarAccess.getPredicateExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_6, null);
                    	    

                    }
                    break;

            }


            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2515:2: ( (otherlv_2= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2516:1: (otherlv_2= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2516:1: (otherlv_2= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2517:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression5560); 

            		newLeafNode(otherlv_2, grammarAccess.getPredicateExpressionAccess().getLimitConstantDeclCrossReference_2_0()); 
            	

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
    // $ANTLR end "rulePredicateExpression"


    // $ANTLR start "entryRuleConstantDecl"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2536:1: entryRuleConstantDecl returns [EObject current=null] : iv_ruleConstantDecl= ruleConstantDecl EOF ;
    public final EObject entryRuleConstantDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDecl = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2537:2: (iv_ruleConstantDecl= ruleConstantDecl EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2538:2: iv_ruleConstantDecl= ruleConstantDecl EOF
            {
             newCompositeNode(grammarAccess.getConstantDeclRule()); 
            pushFollow(FOLLOW_ruleConstantDecl_in_entryRuleConstantDecl5595);
            iv_ruleConstantDecl=ruleConstantDecl();

            state._fsp--;

             current =iv_ruleConstantDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDecl5605); 

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
    // $ANTLR end "entryRuleConstantDecl"


    // $ANTLR start "ruleConstantDecl"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:1: ruleConstantDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_constantvalue_2_0= ruleConstantValue ) ) ) ;
    public final EObject ruleConstantDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_constantvalue_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2548:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_constantvalue_2_0= ruleConstantValue ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2549:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_constantvalue_2_0= ruleConstantValue ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2549:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_constantvalue_2_0= ruleConstantValue ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2549:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_constantvalue_2_0= ruleConstantValue ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2549:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2550:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2550:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2551:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstantDecl5647); 

            			newLeafNode(lv_name_0_0, grammarAccess.getConstantDeclAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantDeclRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleConstantDecl5665); 

                	newLeafNode(otherlv_1, grammarAccess.getConstantDeclAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2572:1: ( (lv_constantvalue_2_0= ruleConstantValue ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2573:1: (lv_constantvalue_2_0= ruleConstantValue )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2573:1: (lv_constantvalue_2_0= ruleConstantValue )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2574:3: lv_constantvalue_2_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getConstantDeclAccess().getConstantvalueConstantValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleConstantValue_in_ruleConstantDecl5685);
            lv_constantvalue_2_0=ruleConstantValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDeclRule());
            	        }
                   		set(
                   			current, 
                   			"constantvalue",
                    		lv_constantvalue_2_0, 
                    		"ConstantValue");
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
    // $ANTLR end "ruleConstantDecl"


    // $ANTLR start "entryRuleConstantValue"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2598:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2599:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2600:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_ruleConstantValue_in_entryRuleConstantValue5720);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantValue5730); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2607:1: ruleConstantValue returns [EObject current=null] : (this_StringTerm_0= ruleStringTerm | this_RealTerm_1= ruleRealTerm | this_IntegerTerm_2= ruleIntegerTerm ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject this_StringTerm_0 = null;

        EObject this_RealTerm_1 = null;

        EObject this_IntegerTerm_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2610:28: ( (this_StringTerm_0= ruleStringTerm | this_RealTerm_1= ruleRealTerm | this_IntegerTerm_2= ruleIntegerTerm ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2611:1: (this_StringTerm_0= ruleStringTerm | this_RealTerm_1= ruleRealTerm | this_IntegerTerm_2= ruleIntegerTerm )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2611:1: (this_StringTerm_0= ruleStringTerm | this_RealTerm_1= ruleRealTerm | this_IntegerTerm_2= ruleIntegerTerm )
            int alt55=3;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_STRING) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_INT) ) {
                int LA55_2 = input.LA(2);

                if ( (LA55_2==FullStop) ) {
                    alt55=2;
                }
                else if ( (LA55_2==EOF||(LA55_2>=Description && LA55_2<=Requirement)||(LA55_2>=Constants && LA55_2<=Category)||LA55_2==Refines||(LA55_2>=Assert && LA55_2<=Folder)||LA55_2==See||(LA55_2>=RightSquareBracket && LA55_2<=RULE_ID)) ) {
                    alt55=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 55, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2612:5: this_StringTerm_0= ruleStringTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getStringTermParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStringTerm_in_ruleConstantValue5777);
                    this_StringTerm_0=ruleStringTerm();

                    state._fsp--;


                            current = this_StringTerm_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2622:5: this_RealTerm_1= ruleRealTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getRealTermParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleRealTerm_in_ruleConstantValue5804);
                    this_RealTerm_1=ruleRealTerm();

                    state._fsp--;


                            current = this_RealTerm_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2632:5: this_IntegerTerm_2= ruleIntegerTerm
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getIntegerTermParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleIntegerTerm_in_ruleConstantValue5831);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2648:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2649:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2650:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm5865);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm5875); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2657:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2660:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2661:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2661:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2662:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2662:1: (lv_value_0_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2663:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringTerm5916); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2687:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2688:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2689:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm5955);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm5965); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2696:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token lv_unit_1_0=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2699:28: ( ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2700:1: ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2700:1: ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2700:2: ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2700:2: ( (lv_value_0_0= ruleREAL ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2701:1: (lv_value_0_0= ruleREAL )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2701:1: (lv_value_0_0= ruleREAL )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2702:3: lv_value_0_0= ruleREAL
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueREALParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleREAL_in_ruleRealTerm6011);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2718:2: ( (lv_unit_1_0= RULE_ID ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==EOF||(LA56_1>=Description && LA56_1<=Requirement)||(LA56_1>=Constants && LA56_1<=Category)||LA56_1==Refines||(LA56_1>=Assert && LA56_1<=Folder)||LA56_1==See||(LA56_1>=RightSquareBracket && LA56_1<=RULE_ID)) ) {
                    alt56=1;
                }
            }
            switch (alt56) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2719:1: (lv_unit_1_0= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2719:1: (lv_unit_1_0= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2720:3: lv_unit_1_0= RULE_ID
                    {
                    lv_unit_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealTerm6028); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2744:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2745:1: (iv_ruleREAL= ruleREAL EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2746:2: iv_ruleREAL= ruleREAL EOF
            {
             newCompositeNode(grammarAccess.getREALRule()); 
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL6070);
            iv_ruleREAL=ruleREAL();

            state._fsp--;

             current =iv_ruleREAL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL6081); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2753:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2757:6: ( (this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2758:1: (this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2758:1: (this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2758:6: this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL6121); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleREAL6139); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL6154); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2786:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2787:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2788:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm6198);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm6208); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2795:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_unit_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:28: ( ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:2: ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:2: ( (lv_value_0_0= RULE_INT ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2800:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2800:1: (lv_value_0_0= RULE_INT )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2801:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntegerTerm6250); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2817:2: ( (lv_unit_1_0= RULE_ID ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==EOF||(LA57_1>=Description && LA57_1<=Requirement)||(LA57_1>=Constants && LA57_1<=Category)||LA57_1==Refines||(LA57_1>=Assert && LA57_1<=Folder)||LA57_1==See||(LA57_1>=RightSquareBracket && LA57_1<=RULE_ID)) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2818:1: (lv_unit_1_0= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2818:1: (lv_unit_1_0= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2819:3: lv_unit_1_0= RULE_ID
                    {
                    lv_unit_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerTerm6272); 

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


    // $ANTLR start "entryRuleMultiLineString"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2843:1: entryRuleMultiLineString returns [EObject current=null] : iv_ruleMultiLineString= ruleMultiLineString EOF ;
    public final EObject entryRuleMultiLineString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiLineString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2844:2: (iv_ruleMultiLineString= ruleMultiLineString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2845:2: iv_ruleMultiLineString= ruleMultiLineString EOF
            {
             newCompositeNode(grammarAccess.getMultiLineStringRule()); 
            pushFollow(FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString6313);
            iv_ruleMultiLineString=ruleMultiLineString();

            state._fsp--;

             current =iv_ruleMultiLineString; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiLineString6323); 

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
    // $ANTLR end "entryRuleMultiLineString"


    // $ANTLR start "ruleMultiLineString"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2852:1: ruleMultiLineString returns [EObject current=null] : ( (lv_description_0_0= ruleTextElement ) )+ ;
    public final EObject ruleMultiLineString() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2855:28: ( ( (lv_description_0_0= ruleTextElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2856:1: ( (lv_description_0_0= ruleTextElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2856:1: ( (lv_description_0_0= ruleTextElement ) )+
            int cnt58=0;
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==Ampersand||LA58_0==RULE_STRING) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2857:1: (lv_description_0_0= ruleTextElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2857:1: (lv_description_0_0= ruleTextElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2858:3: lv_description_0_0= ruleTextElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiLineStringAccess().getDescriptionTextElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTextElement_in_ruleMultiLineString6368);
            	    lv_description_0_0=ruleTextElement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMultiLineStringRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"description",
            	            		lv_description_0_0, 
            	            		"TextElement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt58 >= 1 ) break loop58;
                        EarlyExitException eee =
                            new EarlyExitException(58, input);
                        throw eee;
                }
                cnt58++;
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
    // $ANTLR end "ruleMultiLineString"


    // $ANTLR start "entryRuleTextElement"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2882:1: entryRuleTextElement returns [EObject current=null] : iv_ruleTextElement= ruleTextElement EOF ;
    public final EObject entryRuleTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2883:2: (iv_ruleTextElement= ruleTextElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2884:2: iv_ruleTextElement= ruleTextElement EOF
            {
             newCompositeNode(grammarAccess.getTextElementRule()); 
            pushFollow(FOLLOW_ruleTextElement_in_entryRuleTextElement6403);
            iv_ruleTextElement=ruleTextElement();

            state._fsp--;

             current =iv_ruleTextElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextElement6413); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2891:1: ruleTextElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) ) ;
    public final EObject ruleTextElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2894:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2895:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2895:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_STRING) ) {
                alt59=1;
            }
            else if ( (LA59_0==Ampersand) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2895:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2895:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2896:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2896:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2897:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextElement6455); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2914:6: ( (lv_newline_1_0= Ampersand ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2914:6: ( (lv_newline_1_0= Ampersand ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2915:1: (lv_newline_1_0= Ampersand )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2915:1: (lv_newline_1_0= Ampersand )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2916:3: lv_newline_1_0= Ampersand
                    {
                    lv_newline_1_0=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_ruleTextElement6485); 

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


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2938:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2939:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2940:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString6532);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString6543); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2947:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2951:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2952:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString6582); 

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


    // $ANTLR start "entryRuleAadlClassifierReference"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2967:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2968:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2969:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6626);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference6637); 

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
    // $ANTLR end "entryRuleAadlClassifierReference"


    // $ANTLR start "ruleAadlClassifierReference"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2976:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2980:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2981:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2981:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2981:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2981:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_ID) ) {
                    int LA60_1 = input.LA(2);

                    if ( (LA60_1==ColonColon) ) {
                        alt60=1;
                    }


                }


                switch (alt60) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2981:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6678); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference6696); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6713); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3001:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==FullStop) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3002:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference6732); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6747); 

                    		current.merge(this_ID_4);
                        
                     
                        newLeafNode(this_ID_4, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_2_1()); 
                        

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
    // $ANTLR end "ruleAadlClassifierReference"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3022:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3023:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3024:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef6794);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef6805); 

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
    // $ANTLR end "entryRuleCatRef"


    // $ANTLR start "ruleCatRef"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3031:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3035:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3036:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef6844); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleCatRef"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3051:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3052:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3053:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6888);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName6899); 

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3060:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3064:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3065:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3065:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3065:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6939); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3072:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==FullStop) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3073:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName6958); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6973); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop62;
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
    // $ANTLR end "ruleQualifiedName"

    // Delegated rules


    protected DFA36 dfa36 = new DFA36(this);
    protected DFA47 dfa47 = new DFA47(this);
    static final String DFA36_eotS =
        "\14\uffff";
    static final String DFA36_eofS =
        "\14\uffff";
    static final String DFA36_minS =
        "\1\5\7\uffff\1\15\1\6\2\uffff";
    static final String DFA36_maxS =
        "\1\50\7\uffff\1\15\1\51\2\uffff";
    static final String DFA36_acceptS =
        "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\10\1\7";
    static final String DFA36_specialS =
        "\1\1\7\uffff\1\2\1\0\2\uffff}>";
    static final String[] DFA36_transitionS = {
            "\1\3\1\uffff\1\7\1\6\2\uffff\1\4\1\2\2\uffff\1\5\10\uffff\1"+
            "\10\17\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11",
            "\1\13\42\uffff\1\12",
            "",
            ""
    };

    static final short[] DFA36_eot = DFA.unpackEncodedString(DFA36_eotS);
    static final short[] DFA36_eof = DFA.unpackEncodedString(DFA36_eofS);
    static final char[] DFA36_min = DFA.unpackEncodedStringToUnsignedChars(DFA36_minS);
    static final char[] DFA36_max = DFA.unpackEncodedStringToUnsignedChars(DFA36_maxS);
    static final short[] DFA36_accept = DFA.unpackEncodedString(DFA36_acceptS);
    static final short[] DFA36_special = DFA.unpackEncodedString(DFA36_specialS);
    static final short[][] DFA36_transition;

    static {
        int numStates = DFA36_transitionS.length;
        DFA36_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA36_transition[i] = DFA.unpackEncodedString(DFA36_transitionS[i]);
        }
    }

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = DFA36_eot;
            this.eof = DFA36_eof;
            this.min = DFA36_min;
            this.max = DFA36_max;
            this.accept = DFA36_accept;
            this.special = DFA36_special;
            this.transition = DFA36_transition;
        }
        public String getDescription() {
            return "()* loopback of 1157:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA36_9 = input.LA(1);

                         
                        int index36_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA36_9 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {s = 10;}

                        else if ( LA36_9 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {s = 11;}

                         
                        input.seek(index36_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA36_0 = input.LA(1);

                         
                        int index36_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA36_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA36_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA36_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA36_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA36_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA36_0 ==Conflicts && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA36_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA36_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) ) {s = 8;}

                         
                        input.seek(index36_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA36_8 = input.LA(1);

                         
                        int index36_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA36_8 ==Document && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) ) {s = 9;}

                         
                        input.seek(index36_8);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 36, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA47_eotS =
        "\17\uffff";
    static final String DFA47_eofS =
        "\17\uffff";
    static final String DFA47_minS =
        "\1\5\6\uffff\1\15\2\uffff\1\6\4\uffff";
    static final String DFA47_maxS =
        "\1\50\6\uffff\1\24\2\uffff\1\51\4\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\14\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\uffff\1\6"+
        "\1\12\1\11\1\13";
    static final String DFA47_specialS =
        "\1\0\6\uffff\1\2\2\uffff\1\1\4\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\3\3\uffff\1\4\1\10\1\6\1\2\2\uffff\1\11\1\uffff\1\5\6\uffff"+
            "\1\7\17\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\6\uffff\1\13",
            "",
            "",
            "\1\14\15\uffff\1\15\24\uffff\1\16",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "()* loopback of 1572:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA47_0 = input.LA(1);

                         
                        int index47_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA47_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA47_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA47_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA47_0 ==Constants && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA47_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA47_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA47_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) ) {s = 7;}

                        else if ( LA47_0 ==Mitigates && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA47_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                         
                        input.seek(index47_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA47_10 = input.LA(1);

                         
                        int index47_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA47_10 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) {s = 12;}

                        else if ( LA47_10 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) ) {s = 13;}

                        else if ( LA47_10 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) ) {s = 14;}

                         
                        input.seek(index47_10);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA47_7 = input.LA(1);

                         
                        int index47_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA47_7 ==Document && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) ) {s = 10;}

                        else if ( LA47_7 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) {s = 11;}

                         
                        input.seek(index47_7);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleReqSpec_in_entryRuleReqSpec67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpec77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecs_in_ruleReqSpec124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholderGoals_in_ruleReqSpec151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_ruleReqSpec178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholderGoals_in_entryRuleStakeholderGoals218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholderGoals228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleStakeholderGoals266 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_Goals_in_ruleStakeholderGoals278 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholderGoals294 = new BitSet(new long[]{0x0000008800800020L});
    public static final BitSet FOLLOW_Colon_in_ruleStakeholderGoals313 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholderGoals333 = new BitSet(new long[]{0x0000008000800020L});
    public static final BitSet FOLLOW_For_in_ruleStakeholderGoals349 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleStakeholderGoals372 = new BitSet(new long[]{0x0000008000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholderGoals399 = new BitSet(new long[]{0x0000008000000020L});
    public static final BitSet FOLLOW_Description_in_ruleStakeholderGoals416 = new BitSet(new long[]{0x0000080100000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleStakeholderGoals436 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals451 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleStakeholderGoals473 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleGoalFolder_in_ruleStakeholderGoals492 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleStakeholderGoals508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_entryRuleReqDocument542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqDocument552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Document_in_ruleReqDocument590 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqDocument606 = new BitSet(new long[]{0x0000008800000020L});
    public static final BitSet FOLLOW_Colon_in_ruleReqDocument625 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqDocument645 = new BitSet(new long[]{0x0000008000000020L});
    public static final BitSet FOLLOW_Description_in_ruleReqDocument661 = new BitSet(new long[]{0x0000080100000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqDocument681 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqDocument696 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_ruleReqDocument716 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqDocument729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_entryRuleDocumentSection763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentSection773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Section_in_ruleDocumentSection811 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDocumentSection827 = new BitSet(new long[]{0x0000008800000020L});
    public static final BitSet FOLLOW_Colon_in_ruleDocumentSection846 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleDocumentSection866 = new BitSet(new long[]{0x0000008000000020L});
    public static final BitSet FOLLOW_Description_in_ruleDocumentSection882 = new BitSet(new long[]{0x0000080100000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleDocumentSection902 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleDocumentSection917 = new BitSet(new long[]{0x0000010000110040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleDocumentSection939 = new BitSet(new long[]{0x0000010000110040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleDocumentSection958 = new BitSet(new long[]{0x0000010000110040L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_ruleDocumentSection977 = new BitSet(new long[]{0x0000010000110040L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleDocumentSection994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecs_in_entryRuleReqSpecs1028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecs1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleReqSpecs1076 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Specification_in_ruleReqSpecs1088 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecs1104 = new BitSet(new long[]{0x0000008800804000L});
    public static final BitSet FOLLOW_Colon_in_ruleReqSpecs1123 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecs1143 = new BitSet(new long[]{0x0000008000804000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecs1159 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecs1182 = new BitSet(new long[]{0x0000008000004000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecs1209 = new BitSet(new long[]{0x0000008000004000L});
    public static final BitSet FOLLOW_Include_in_ruleReqSpecs1226 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleReqSpecs1248 = new BitSet(new long[]{0x0000028000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecs1264 = new BitSet(new long[]{0x0000010000040240L});
    public static final BitSet FOLLOW_Constants_in_ruleReqSpecs1322 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleConstantDecl_in_ruleReqSpecs1342 = new BitSet(new long[]{0x0000030000040240L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecs1421 = new BitSet(new long[]{0x0000010000040240L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecs1440 = new BitSet(new long[]{0x0000010000040240L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecs1497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1533 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecFolder1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleReqSpecFolder1581 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecFolder1597 = new BitSet(new long[]{0x0000008800000000L});
    public static final BitSet FOLLOW_Colon_in_ruleReqSpecFolder1616 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecFolder1636 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1651 = new BitSet(new long[]{0x0000010000140240L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecFolder1673 = new BitSet(new long[]{0x0000010000140240L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecFolder1692 = new BitSet(new long[]{0x0000010000140240L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1711 = new BitSet(new long[]{0x0000010000140240L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalFolder_in_entryRuleGoalFolder1762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalFolder1772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleGoalFolder1810 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoalFolder1826 = new BitSet(new long[]{0x0000008800000000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoalFolder1845 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoalFolder1865 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoalFolder1880 = new BitSet(new long[]{0x0000010000140000L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoalFolder1902 = new BitSet(new long[]{0x0000010000140000L});
    public static final BitSet FOLLOW_ruleGoalFolder_in_ruleGoalFolder1921 = new BitSet(new long[]{0x0000010000140000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoalFolder1938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal1972 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal1982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal2020 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal2036 = new BitSet(new long[]{0x0000008800800000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoal2055 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2075 = new BitSet(new long[]{0x0000008000800000L});
    public static final BitSet FOLLOW_For_in_ruleGoal2091 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal2111 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2138 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal2154 = new BitSet(new long[]{0x00000100010099A0L});
    public static final BitSet FOLLOW_Category_in_ruleGoal2212 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal2234 = new BitSet(new long[]{0x00000100010099A0L});
    public static final BitSet FOLLOW_Description_in_ruleGoal2303 = new BitSet(new long[]{0x00000A0100200000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal2323 = new BitSet(new long[]{0x00000100010099A0L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal2392 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2412 = new BitSet(new long[]{0x00000100010099A0L});
    public static final BitSet FOLLOW_Refines_in_ruleGoal2481 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2503 = new BitSet(new long[]{0x00000300010099A0L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2573 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_With_in_ruleGoal2585 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2607 = new BitSet(new long[]{0x00000300010099A0L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2677 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2699 = new BitSet(new long[]{0x00000300010099A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2769 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal2781 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal2793 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2815 = new BitSet(new long[]{0x00000300010099A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2885 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal2897 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal2917 = new BitSet(new long[]{0x00000300010099A0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement3006 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement3016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement3054 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3070 = new BitSet(new long[]{0x0000008800800000L});
    public static final BitSet FOLLOW_Colon_in_ruleRequirement3089 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3109 = new BitSet(new long[]{0x0000008000800000L});
    public static final BitSet FOLLOW_For_in_ruleRequirement3125 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3145 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3172 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3188 = new BitSet(new long[]{0x0000010001029E20L});
    public static final BitSet FOLLOW_Category_in_ruleRequirement3246 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3268 = new BitSet(new long[]{0x0000010001029E20L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3337 = new BitSet(new long[]{0x00000A0100200000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3357 = new BitSet(new long[]{0x0000010001029E20L});
    public static final BitSet FOLLOW_Constants_in_ruleRequirement3426 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleConstantDecl_in_ruleRequirement3446 = new BitSet(new long[]{0x0000030001029E20L});
    public static final BitSet FOLLOW_Assert_in_ruleRequirement3516 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleRequirement3536 = new BitSet(new long[]{0x0000010001029E20L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement3605 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRequirement3621 = new BitSet(new long[]{0x0000010001029E20L});
    public static final BitSet FOLLOW_See_in_ruleRequirement3695 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement3707 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3729 = new BitSet(new long[]{0x0000030001029E20L});
    public static final BitSet FOLLOW_Mitigates_in_ruleRequirement3799 = new BitSet(new long[]{0x00000A0000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3819 = new BitSet(new long[]{0x0000010001029E20L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3846 = new BitSet(new long[]{0x0000010001029E20L});
    public static final BitSet FOLLOW_Refines_in_ruleRequirement3916 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3938 = new BitSet(new long[]{0x0000030001029E20L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4008 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement4020 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4032 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4054 = new BitSet(new long[]{0x0000030001029E20L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4124 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement4136 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement4148 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4170 = new BitSet(new long[]{0x0000030001029E20L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4240 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement4252 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4272 = new BitSet(new long[]{0x0000030001029E20L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement4327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument4361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument4371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument4417 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument4431 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument4451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH4489 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH4500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4541 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH4559 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4576 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH4594 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT4654 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4705 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT4724 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4739 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription4787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription4797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription4842 = new BitSet(new long[]{0x00000A0100200002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement4877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement4887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement4929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement4961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ampersand_in_ruleDescriptionElement4986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_This_in_ruleDescriptionElement5022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue5068 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue5078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue5123 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_PercentSign_in_ruleShowValue5137 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue5153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath5195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath5205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath5250 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath5264 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath5284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression5320 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePredicateExpression5330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression5366 = new BitSet(new long[]{0x0000007032000000L});
    public static final BitSet FOLLOW_EqualsSign_in_rulePredicateExpression5386 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression5414 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_LessThanSign_in_rulePredicateExpression5442 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_LessThanSignEqualsSign_in_rulePredicateExpression5470 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_GreaterThanSign_in_rulePredicateExpression5498 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression5526 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression5560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDecl_in_entryRuleConstantDecl5595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDecl5605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstantDecl5647 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleConstantDecl5665 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleConstantDecl5685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue5720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue5730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_ruleConstantValue5777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_ruleConstantValue5804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_ruleConstantValue5831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm5865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm5875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringTerm5916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm5955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm5965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleRealTerm6011 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm6028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL6070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL6081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL6121 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleREAL6139 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL6154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm6198 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm6208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntegerTerm6250 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm6272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString6313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiLineString6323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_ruleMultiLineString6368 = new BitSet(new long[]{0x0000080100000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_entryRuleTextElement6403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextElement6413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextElement6455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ampersand_in_ruleTextElement6485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString6532 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString6543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString6582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6626 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference6637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6678 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference6696 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6713 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference6732 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef6794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef6805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef6844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName6899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6939 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName6958 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6973 = new BitSet(new long[]{0x0000000200000002L});

}
