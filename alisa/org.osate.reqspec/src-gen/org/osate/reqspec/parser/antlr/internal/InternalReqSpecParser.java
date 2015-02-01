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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Specification", "Description", "Requirement", "Stakeholder", "Conflicts", "Constants", "Mitigates", "Rationale", "Category", "Document", "Include", "Library", "Refines", "Section", "Assert", "Folder", "Goals", "Goal", "This", "With", "For", "See", "ExclamationMarkEqualsSign", "FullStopAsterisk", "ColonColon", "LessThanSignEqualsSign", "GreaterThanSignEqualsSign", "NumberSign", "PercentSign", "Ampersand", "FullStop", "Solidus", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=42;
    public static final int Specification=4;
    public static final int Constants=9;
    public static final int Assert=18;
    public static final int RULE_ANY_OTHER=48;
    public static final int RightSquareBracket=41;
    public static final int Mitigates=10;
    public static final int Requirement=6;
    public static final int Library=15;
    public static final int Solidus=35;
    public static final int EOF=-1;
    public static final int GreaterThanSign=39;
    public static final int FullStop=34;
    public static final int PercentSign=32;
    public static final int LessThanSign=37;
    public static final int RULE_INT=43;
    public static final int LeftSquareBracket=40;
    public static final int Refines=16;
    public static final int Conflicts=8;
    public static final int ExclamationMarkEqualsSign=26;
    public static final int Stakeholder=7;
    public static final int This=22;
    public static final int FullStopAsterisk=27;
    public static final int LessThanSignEqualsSign=29;
    public static final int Colon=36;
    public static final int RULE_SL_COMMENT=46;
    public static final int For=24;
    public static final int Include=14;
    public static final int NumberSign=31;
    public static final int Rationale=11;
    public static final int With=23;
    public static final int RULE_ML_COMMENT=45;
    public static final int Goal=21;
    public static final int Ampersand=33;
    public static final int Goals=20;
    public static final int ColonColon=28;
    public static final int Document=13;
    public static final int Description=5;
    public static final int RULE_STRING=44;
    public static final int Folder=19;
    public static final int See=25;
    public static final int Section=17;
    public static final int GreaterThanSignEqualsSign=30;
    public static final int Category=12;
    public static final int RULE_WS=47;
    public static final int EqualsSign=38;

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:126:1: ruleStakeholderGoals returns [EObject current=null] : (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket ) ;
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


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:129:28: ( (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:130:1: (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:130:1: (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:131:2: otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket
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
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:248:1: ( ( ruleQualifiedName ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:249:1: ( ruleQualifiedName )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:249:1: ( ruleQualifiedName )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:250:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStakeholderGoalsRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getConsistsOfGoalFolderCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleStakeholderGoals473);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleStakeholderGoals486); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:276:1: entryRuleReqDocument returns [EObject current=null] : iv_ruleReqDocument= ruleReqDocument EOF ;
    public final EObject entryRuleReqDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:277:2: (iv_ruleReqDocument= ruleReqDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:278:2: iv_ruleReqDocument= ruleReqDocument EOF
            {
             newCompositeNode(grammarAccess.getReqDocumentRule()); 
            pushFollow(FOLLOW_ruleReqDocument_in_entryRuleReqDocument520);
            iv_ruleReqDocument=ruleReqDocument();

            state._fsp--;

             current =iv_ruleReqDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqDocument530); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:285:1: ruleReqDocument returns [EObject current=null] : (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:288:28: ( (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:289:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:289:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:290:2: otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Document,FOLLOW_Document_in_ruleReqDocument568); 

                	newLeafNode(otherlv_0, grammarAccess.getReqDocumentAccess().getDocumentKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:294:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:295:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:295:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:296:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqDocument584); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:312:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Colon) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:313:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqDocument603); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqDocumentAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:317:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:318:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:318:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:319:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqDocumentAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqDocument623);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:335:4: (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Description) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:336:2: otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) )
                    {
                    otherlv_4=(Token)match(input,Description,FOLLOW_Description_in_ruleReqDocument639); 

                        	newLeafNode(otherlv_4, grammarAccess.getReqDocumentAccess().getDescriptionKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:340:1: ( (lv_description_5_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:341:1: (lv_description_5_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:341:1: (lv_description_5_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:342:3: lv_description_5_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqDocumentAccess().getDescriptionMultiLineStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqDocument659);
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

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqDocument674); 

                	newLeafNode(otherlv_6, grammarAccess.getReqDocumentAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:363:1: ( (lv_content_7_0= ruleDocumentSection ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:364:1: (lv_content_7_0= ruleDocumentSection )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:364:1: (lv_content_7_0= ruleDocumentSection )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:365:3: lv_content_7_0= ruleDocumentSection
            {
             
            	        newCompositeNode(grammarAccess.getReqDocumentAccess().getContentDocumentSectionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDocumentSection_in_ruleReqDocument694);
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

            otherlv_8=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqDocument707); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:394:1: entryRuleDocumentSection returns [EObject current=null] : iv_ruleDocumentSection= ruleDocumentSection EOF ;
    public final EObject entryRuleDocumentSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentSection = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:395:2: (iv_ruleDocumentSection= ruleDocumentSection EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:396:2: iv_ruleDocumentSection= ruleDocumentSection EOF
            {
             newCompositeNode(grammarAccess.getDocumentSectionRule()); 
            pushFollow(FOLLOW_ruleDocumentSection_in_entryRuleDocumentSection741);
            iv_ruleDocumentSection=ruleDocumentSection();

            state._fsp--;

             current =iv_ruleDocumentSection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentSection751); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:403:1: ruleDocumentSection returns [EObject current=null] : (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:406:28: ( (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:407:1: (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:407:1: (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:408:2: otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Section,FOLLOW_Section_in_ruleDocumentSection789); 

                	newLeafNode(otherlv_0, grammarAccess.getDocumentSectionAccess().getSectionKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:412:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:413:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:413:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:414:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDocumentSection805); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:430:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Colon) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:431:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleDocumentSection824); 

                        	newLeafNode(otherlv_2, grammarAccess.getDocumentSectionAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:435:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:436:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:436:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:437:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleDocumentSection844);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:453:4: (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Description) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:454:2: otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) )
                    {
                    otherlv_4=(Token)match(input,Description,FOLLOW_Description_in_ruleDocumentSection860); 

                        	newLeafNode(otherlv_4, grammarAccess.getDocumentSectionAccess().getDescriptionKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:458:1: ( (lv_description_5_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:459:1: (lv_description_5_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:459:1: (lv_description_5_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:460:3: lv_description_5_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getDescriptionMultiLineStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleDocumentSection880);
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

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleDocumentSection895); 

                	newLeafNode(otherlv_6, grammarAccess.getDocumentSectionAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:481:1: ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Requirement||LA11_0==Section||LA11_0==Goal) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:482:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:482:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:483:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:483:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection )
            	    int alt10=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    case Section:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:484:3: lv_content_7_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentGoalParserRuleCall_5_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleDocumentSection917);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:499:8: lv_content_7_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentRequirementParserRuleCall_5_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleDocumentSection936);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:514:8: lv_content_7_3= ruleDocumentSection
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocumentSectionParserRuleCall_5_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDocumentSection_in_ruleDocumentSection955);
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
            	    break loop11;
                }
            } while (true);

            otherlv_8=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleDocumentSection972); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:545:1: entryRuleReqSpecs returns [EObject current=null] : iv_ruleReqSpecs= ruleReqSpecs EOF ;
    public final EObject entryRuleReqSpecs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecs = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:546:2: (iv_ruleReqSpecs= ruleReqSpecs EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:547:2: iv_ruleReqSpecs= ruleReqSpecs EOF
            {
             newCompositeNode(grammarAccess.getReqSpecsRule()); 
            pushFollow(FOLLOW_ruleReqSpecs_in_entryRuleReqSpecs1006);
            iv_ruleReqSpecs=ruleReqSpecs();

            state._fsp--;

             current =iv_ruleReqSpecs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecs1016); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:554:1: ruleReqSpecs returns [EObject current=null] : (otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket (otherlv_11= Constants ( (lv_constants_12_0= ruleConstantDecl ) )+ )? ( ( (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder ) ) )* otherlv_14= RightSquareBracket ) ;
    public final EObject ruleReqSpecs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_title_4_0 = null;

        AntlrDatatypeRuleToken lv_targetDescription_7_0 = null;

        EObject lv_constants_12_0 = null;

        EObject lv_content_13_1 = null;

        EObject lv_content_13_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:557:28: ( (otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket (otherlv_11= Constants ( (lv_constants_12_0= ruleConstantDecl ) )+ )? ( ( (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder ) ) )* otherlv_14= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:558:1: (otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket (otherlv_11= Constants ( (lv_constants_12_0= ruleConstantDecl ) )+ )? ( ( (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder ) ) )* otherlv_14= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:558:1: (otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket (otherlv_11= Constants ( (lv_constants_12_0= ruleConstantDecl ) )+ )? ( ( (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder ) ) )* otherlv_14= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:559:2: otherlv_0= Requirement otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Include ( ( ruleQualifiedName ) )+ )? otherlv_10= LeftSquareBracket (otherlv_11= Constants ( (lv_constants_12_0= ruleConstantDecl ) )+ )? ( ( (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder ) ) )* otherlv_14= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleReqSpecs1054); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecsAccess().getRequirementKeyword_0());
                
            otherlv_1=(Token)match(input,Specification,FOLLOW_Specification_in_ruleReqSpecs1066); 

                	newLeafNode(otherlv_1, grammarAccess.getReqSpecsAccess().getSpecificationKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:568:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:569:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:569:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:570:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecs1082); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:586:2: (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Colon) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:587:2: otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) )
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqSpecs1101); 

                        	newLeafNode(otherlv_3, grammarAccess.getReqSpecsAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:591:1: ( (lv_title_4_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:592:1: (lv_title_4_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:592:1: (lv_title_4_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:593:3: lv_title_4_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTitleValueStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecs1121);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:609:4: (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==For) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:610:2: otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
                    {
                    otherlv_5=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecs1137); 

                        	newLeafNode(otherlv_5, grammarAccess.getReqSpecsAccess().getForKeyword_4_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:614:1: ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==RULE_ID) ) {
                        alt13=1;
                    }
                    else if ( (LA13_0==RULE_STRING) ) {
                        alt13=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:614:2: ( ( ruleAadlClassifierReference ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:614:2: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:615:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:615:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:616:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getReqSpecsRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTargetClassifierCrossReference_4_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecs1160);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:630:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:630:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:631:1: (lv_targetDescription_7_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:631:1: (lv_targetDescription_7_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:632:3: lv_targetDescription_7_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTargetDescriptionValueStringParserRuleCall_4_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecs1187);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:648:5: (otherlv_8= Include ( ( ruleQualifiedName ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Include) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:649:2: otherlv_8= Include ( ( ruleQualifiedName ) )+
                    {
                    otherlv_8=(Token)match(input,Include,FOLLOW_Include_in_ruleReqSpecs1204); 

                        	newLeafNode(otherlv_8, grammarAccess.getReqSpecsAccess().getIncludeKeyword_5_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:1: ( ( ruleQualifiedName ) )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_ID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:654:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:654:1: ( ruleQualifiedName )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:655:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getReqSpecsRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecsAccess().getLibrariesReqLibCrossReference_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleReqSpecs1226);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecs1242); 

                	newLeafNode(otherlv_10, grammarAccess.getReqSpecsAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:673:1: (otherlv_11= Constants ( (lv_constants_12_0= ruleConstantDecl ) )+ )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==Constants) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:674:2: otherlv_11= Constants ( (lv_constants_12_0= ruleConstantDecl ) )+
                    {
                    otherlv_11=(Token)match(input,Constants,FOLLOW_Constants_in_ruleReqSpecs1255); 

                        	newLeafNode(otherlv_11, grammarAccess.getReqSpecsAccess().getConstantsKeyword_7_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:678:1: ( (lv_constants_12_0= ruleConstantDecl ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:679:1: (lv_constants_12_0= ruleConstantDecl )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:679:1: (lv_constants_12_0= ruleConstantDecl )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:680:3: lv_constants_12_0= ruleConstantDecl
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecsAccess().getConstantsConstantDeclParserRuleCall_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConstantDecl_in_ruleReqSpecs1275);
                    	    lv_constants_12_0=ruleConstantDecl();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constants",
                    	            		lv_constants_12_0, 
                    	            		"ConstantDecl");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:696:5: ( ( (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==Requirement||LA20_0==Folder) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:697:1: ( (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:697:1: ( (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:698:1: (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:698:1: (lv_content_13_1= ruleRequirement | lv_content_13_2= ruleReqSpecFolder )
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:699:3: lv_content_13_1= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getContentRequirementParserRuleCall_8_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecs1301);
            	            lv_content_13_1=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_13_1, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:714:8: lv_content_13_2= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getContentReqSpecFolderParserRuleCall_8_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecs1320);
            	            lv_content_13_2=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_13_2, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_14=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecs1337); 

                	newLeafNode(otherlv_14, grammarAccess.getReqSpecsAccess().getRightSquareBracketKeyword_9());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:749:1: entryRuleReqSpecFolder returns [EObject current=null] : iv_ruleReqSpecFolder= ruleReqSpecFolder EOF ;
    public final EObject entryRuleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:750:2: (iv_ruleReqSpecFolder= ruleReqSpecFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:751:2: iv_ruleReqSpecFolder= ruleReqSpecFolder EOF
            {
             newCompositeNode(grammarAccess.getReqSpecFolderRule()); 
            pushFollow(FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1375);
            iv_ruleReqSpecFolder=ruleReqSpecFolder();

            state._fsp--;

             current =iv_ruleReqSpecFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecFolder1385); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:758:1: ruleReqSpecFolder returns [EObject current=null] : (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:761:28: ( (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:762:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:762:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:763:2: otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )* otherlv_6= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleReqSpecFolder1423); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:767:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:769:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecFolder1439); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:785:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Colon) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:786:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqSpecFolder1458); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecFolderAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:790:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:791:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:791:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:792:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecFolder1478);
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

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1493); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:813:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==Requirement||LA23_0==Folder||LA23_0==Goal) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:814:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:814:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:815:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:815:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    int alt22=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt22=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt22=2;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt22=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt22) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:816:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecFolder1515);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:831:8: lv_content_5_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentRequirementParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecFolder1534);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:846:8: lv_content_5_3= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentReqSpecFolderParserRuleCall_4_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1553);
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
            	    break loop23;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1570); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:877:1: entryRuleGoalFolder returns [EObject current=null] : iv_ruleGoalFolder= ruleGoalFolder EOF ;
    public final EObject entryRuleGoalFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:878:2: (iv_ruleGoalFolder= ruleGoalFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:879:2: iv_ruleGoalFolder= ruleGoalFolder EOF
            {
             newCompositeNode(grammarAccess.getGoalFolderRule()); 
            pushFollow(FOLLOW_ruleGoalFolder_in_entryRuleGoalFolder1604);
            iv_ruleGoalFolder=ruleGoalFolder();

            state._fsp--;

             current =iv_ruleGoalFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalFolder1614); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:886:1: ruleGoalFolder returns [EObject current=null] : (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:889:28: ( (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:890:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:890:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:891:2: otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )* otherlv_6= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleGoalFolder1652); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:895:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:897:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoalFolder1668); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:913:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==Colon) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:914:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoalFolder1687); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalFolderAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:918:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:920:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalFolderAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoalFolder1707);
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

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoalFolder1722); 

                	newLeafNode(otherlv_4, grammarAccess.getGoalFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:941:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==Folder||LA26_0==Goal) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:942:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:942:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:943:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:943:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder )
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==Goal) ) {
            	        alt25=1;
            	    }
            	    else if ( (LA25_0==Folder) ) {
            	        alt25=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 25, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:944:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getGoalFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleGoalFolder1744);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:959:8: lv_content_5_2= ruleGoalFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getGoalFolderAccess().getContentGoalFolderParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoalFolder_in_ruleGoalFolder1763);
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
            	    break loop26;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoalFolder1780); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:990:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:991:2: (iv_ruleGoal= ruleGoal EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:992:2: iv_ruleGoal= ruleGoal EOF
            {
             newCompositeNode(grammarAccess.getGoalRule()); 
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal1814);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal1824); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:999:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1002:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1003:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1003:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1004:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_29= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal1862); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1008:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1009:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1009:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1010:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1878); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1026:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==Colon) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1027:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoal1897); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1031:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1032:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1032:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1033:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1917);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1049:4: (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==For) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1050:2: otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleGoal1933); 

                        	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:1: ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==RULE_ID) ) {
                        alt28=1;
                    }
                    else if ( (LA28_0==RULE_STRING) ) {
                        alt28=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 28, 0, input);

                        throw nvae;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1055:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1055:1: (otherlv_5= RULE_ID )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1056:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getGoalRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1953); 

                            		newLeafNode(otherlv_5, grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_3_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1068:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1068:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1069:1: (lv_targetDescription_6_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1069:1: (lv_targetDescription_6_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1070:3: lv_targetDescription_6_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getGoalAccess().getTargetDescriptionValueStringParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleGoal1980);
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

            otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal1996); 

                	newLeafNode(otherlv_7, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1093:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1093:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1094:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1097:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1098:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1098:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )*
            loop35:
            do {
                int alt35=9;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1100:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1100:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1101:5: {...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1101:101: ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1102:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1105:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1105:7: {...}? => (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1105:16: (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1106:2: otherlv_9= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_9=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal2054); 

            	        	newLeafNode(otherlv_9, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1110:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1111:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1111:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1112:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal2076);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1132:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1132:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1133:5: {...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1133:101: ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1134:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1137:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1137:7: {...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1137:16: (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1138:2: otherlv_11= Description ( (lv_description_12_0= ruleDescription ) )
            	    {
            	    otherlv_11=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal2145); 

            	        	newLeafNode(otherlv_11, grammarAccess.getGoalAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:1: ( (lv_description_12_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:1: (lv_description_12_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:1: (lv_description_12_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1144:3: lv_description_12_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal2165);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1167:4: ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1167:4: ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1168:5: {...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1168:101: ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1169:6: ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:6: ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:7: {...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:16: (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1173:2: otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) )
            	    {
            	    otherlv_13=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal2234); 

            	        	newLeafNode(otherlv_13, grammarAccess.getGoalAccess().getRationaleKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1177:1: ( (lv_rationale_14_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1178:1: (lv_rationale_14_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1178:1: (lv_rationale_14_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1179:3: lv_rationale_14_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleValueStringParserRuleCall_5_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal2254);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1202:4: ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1202:4: ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:5: {...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:101: ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1204:6: ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1207:6: ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1207:7: {...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1207:16: (otherlv_15= Refines ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1208:2: otherlv_15= Refines ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_15=(Token)match(input,Refines,FOLLOW_Refines_in_ruleGoal2323); 

            	        	newLeafNode(otherlv_15, grammarAccess.getGoalAccess().getRefinesKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1212:1: ( ( ruleQualifiedName ) )+
            	    int cnt30=0;
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==RULE_ID) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1213:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1213:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1214:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2345);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


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


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1234:4: ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1234:4: ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1235:5: {...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1235:101: ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1236:6: ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1239:6: ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1239:7: {...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1239:16: (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1240:2: otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_17=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2415); 

            	        	newLeafNode(otherlv_17, grammarAccess.getGoalAccess().getConflictsKeyword_5_4_0());
            	        
            	    otherlv_18=(Token)match(input,With,FOLLOW_With_in_ruleGoal2427); 

            	        	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getWithKeyword_5_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1249:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1250:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1250:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1251:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_4_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2449);
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
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1271:4: ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1271:4: ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1272:5: {...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1272:101: ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1273:6: ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1276:6: ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1276:7: {...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1276:16: (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1277:2: otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_20=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2519); 

            	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getStakeholderKeyword_5_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1281:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1282:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1282:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1283:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_5_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2541);
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
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1303:4: ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1303:4: ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1304:5: {...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1304:101: ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1305:6: ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1308:6: ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1308:7: {...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1308:16: (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1309:2: otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_22=(Token)match(input,See,FOLLOW_See_in_ruleGoal2611); 

            	        	newLeafNode(otherlv_22, grammarAccess.getGoalAccess().getSeeKeyword_5_6_0());
            	        
            	    otherlv_23=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal2623); 

            	        	newLeafNode(otherlv_23, grammarAccess.getGoalAccess().getDocumentKeyword_5_6_1());
            	        
            	    otherlv_24=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal2635); 

            	        	newLeafNode(otherlv_24, grammarAccess.getGoalAccess().getRequirementKeyword_5_6_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1323:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1324:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1324:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1325:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocumentRequirementContractualElementCrossReference_5_6_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2657);
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
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1345:4: ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1345:4: ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1346:5: {...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1346:101: ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1347:6: ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1350:6: ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1350:7: {...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1350:16: (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1351:2: otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+
            	    {
            	    otherlv_26=(Token)match(input,See,FOLLOW_See_in_ruleGoal2727); 

            	        	newLeafNode(otherlv_26, grammarAccess.getGoalAccess().getSeeKeyword_5_7_0());
            	        
            	    otherlv_27=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal2739); 

            	        	newLeafNode(otherlv_27, grammarAccess.getGoalAccess().getDocumentKeyword_5_7_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1360:1: ( (lv_docReference_28_0= ruleExternalDocument ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1361:1: (lv_docReference_28_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1361:1: (lv_docReference_28_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1362:3: lv_docReference_28_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_7_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal2759);
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

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	

            }

            otherlv_29=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal2814); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1405:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1406:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1407:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement2848);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement2858); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1414:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1417:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1418:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1418:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1419:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) ) otherlv_38= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement2896); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1423:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1424:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1424:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1425:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement2912); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1441:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==Colon) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1442:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleRequirement2931); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1446:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1447:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1447:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1448:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement2951);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1464:4: (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==For) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1465:2: otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleRequirement2967); 

                        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1469:1: ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==RULE_ID) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==RULE_STRING) ) {
                        alt37=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;
                    }
                    switch (alt37) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1469:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1469:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1470:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1470:1: (otherlv_5= RULE_ID )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1471:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getRequirementRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement2987); 

                            		newLeafNode(otherlv_5, grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_3_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1484:1: (lv_targetDescription_6_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1484:1: (lv_targetDescription_6_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1485:3: lv_targetDescription_6_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getRequirementAccess().getTargetDescriptionValueStringParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3014);
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

            otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3030); 

                	newLeafNode(otherlv_7, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1506:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1508:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1508:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1512:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1513:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1513:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )*
            loop46:
            do {
                int alt46=12;
                alt46 = dfa46.predict(input);
                switch (alt46) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1515:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1515:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1516:5: {...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1516:108: ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1517:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1520:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1520:7: {...}? => (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1520:16: (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1521:2: otherlv_9= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_9=(Token)match(input,Category,FOLLOW_Category_in_ruleRequirement3088); 

            	        	newLeafNode(otherlv_9, grammarAccess.getRequirementAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1525:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1526:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1526:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1527:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3110);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1547:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1547:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1548:5: {...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1548:108: ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1549:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1552:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1552:7: {...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1552:16: (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1553:2: otherlv_11= Description ( (lv_description_12_0= ruleDescription ) )
            	    {
            	    otherlv_11=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3179); 

            	        	newLeafNode(otherlv_11, grammarAccess.getRequirementAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1557:1: ( (lv_description_12_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1558:1: (lv_description_12_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1558:1: (lv_description_12_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1559:3: lv_description_12_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3199);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1582:4: ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1582:4: ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1583:5: {...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1583:108: ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1584:6: ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1587:6: ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1587:7: {...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1587:16: (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1588:2: otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+
            	    {
            	    otherlv_13=(Token)match(input,Constants,FOLLOW_Constants_in_ruleRequirement3268); 

            	        	newLeafNode(otherlv_13, grammarAccess.getRequirementAccess().getConstantsKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1592:1: ( (lv_constants_14_0= ruleConstantDecl ) )+
            	    int cnt39=0;
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==RULE_ID) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1593:1: (lv_constants_14_0= ruleConstantDecl )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1593:1: (lv_constants_14_0= ruleConstantDecl )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1594:3: lv_constants_14_0= ruleConstantDecl
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getConstantsConstantDeclParserRuleCall_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleConstantDecl_in_ruleRequirement3288);
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
            	    	    if ( cnt39 >= 1 ) break loop39;
            	                EarlyExitException eee =
            	                    new EarlyExitException(39, input);
            	                throw eee;
            	        }
            	        cnt39++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1617:4: ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1617:4: ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1618:5: {...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1618:108: ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1619:6: ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1622:6: ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1622:7: {...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1622:16: (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1623:2: otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) )
            	    {
            	    otherlv_15=(Token)match(input,Assert,FOLLOW_Assert_in_ruleRequirement3358); 

            	        	newLeafNode(otherlv_15, grammarAccess.getRequirementAccess().getAssertKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1627:1: ( (lv_assert_16_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1628:1: (lv_assert_16_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1628:1: (lv_assert_16_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1629:3: lv_assert_16_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertPredicateExpressionParserRuleCall_5_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleRequirement3378);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1652:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1652:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1653:5: {...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1653:108: ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1654:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1657:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1657:7: {...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1657:16: (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1658:2: otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) )
            	    {
            	    otherlv_17=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement3447); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getRationaleKeyword_5_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1662:1: ( (lv_rationale_18_0= RULE_STRING ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1663:1: (lv_rationale_18_0= RULE_STRING )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1663:1: (lv_rationale_18_0= RULE_STRING )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1664:3: lv_rationale_18_0= RULE_STRING
            	    {
            	    lv_rationale_18_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRequirement3463); 

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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1687:4: ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1687:4: ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1688:5: {...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1688:108: ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1689:6: ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1692:6: ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1692:7: {...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1692:16: (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1693:2: otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_19=(Token)match(input,See,FOLLOW_See_in_ruleRequirement3537); 

            	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getSeeKeyword_5_5_0());
            	        
            	    otherlv_20=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement3549); 

            	        	newLeafNode(otherlv_20, grammarAccess.getRequirementAccess().getGoalKeyword_5_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1702:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1703:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1703:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1704:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_5_5_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3571);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1724:4: ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1724:4: ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1725:5: {...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1725:108: ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1726:6: ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1729:6: ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1729:7: {...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1729:16: (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1730:2: otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) )
            	    {
            	    otherlv_22=(Token)match(input,Mitigates,FOLLOW_Mitigates_in_ruleRequirement3641); 

            	        	newLeafNode(otherlv_22, grammarAccess.getRequirementAccess().getMitigatesKeyword_5_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1734:1: ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) )
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==RULE_ID) ) {
            	        alt41=1;
            	    }
            	    else if ( (LA41_0==RULE_STRING) ) {
            	        alt41=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 41, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1734:2: ( (otherlv_23= RULE_ID ) )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1734:2: ( (otherlv_23= RULE_ID ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1735:1: (otherlv_23= RULE_ID )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1735:1: (otherlv_23= RULE_ID )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1736:3: otherlv_23= RULE_ID
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRequirementRule());
            	            	        }
            	                    
            	            otherlv_23=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3661); 

            	            		newLeafNode(otherlv_23, grammarAccess.getRequirementAccess().getExceptionEObjectCrossReference_5_6_1_0_0()); 
            	            	

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1748:6: ( (lv_exceptionText_24_0= ruleValueString ) )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1748:6: ( (lv_exceptionText_24_0= ruleValueString ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1749:1: (lv_exceptionText_24_0= ruleValueString )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1749:1: (lv_exceptionText_24_0= ruleValueString )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1750:3: lv_exceptionText_24_0= ruleValueString
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getRequirementAccess().getExceptionTextValueStringParserRuleCall_5_6_1_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3688);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1773:4: ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1773:4: ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1774:5: {...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1774:108: ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1775:6: ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1778:6: ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1778:7: {...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1778:16: (otherlv_25= Refines ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1779:2: otherlv_25= Refines ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_25=(Token)match(input,Refines,FOLLOW_Refines_in_ruleRequirement3758); 

            	        	newLeafNode(otherlv_25, grammarAccess.getRequirementAccess().getRefinesKeyword_5_7_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:1: ( ( ruleQualifiedName ) )+
            	    int cnt42=0;
            	    loop42:
            	    do {
            	        int alt42=2;
            	        int LA42_0 = input.LA(1);

            	        if ( (LA42_0==RULE_ID) ) {
            	            alt42=1;
            	        }


            	        switch (alt42) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1784:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1784:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1785:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinedReferenceRequirementCrossReference_5_7_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3780);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt42 >= 1 ) break loop42;
            	                EarlyExitException eee =
            	                    new EarlyExitException(42, input);
            	                throw eee;
            	        }
            	        cnt42++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1805:4: ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1805:4: ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1806:5: {...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1806:108: ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1807:6: ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1810:6: ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1810:7: {...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1810:16: (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1811:2: otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_27=(Token)match(input,See,FOLLOW_See_in_ruleRequirement3850); 

            	        	newLeafNode(otherlv_27, grammarAccess.getRequirementAccess().getSeeKeyword_5_8_0());
            	        
            	    otherlv_28=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement3862); 

            	        	newLeafNode(otherlv_28, grammarAccess.getRequirementAccess().getDocumentKeyword_5_8_1());
            	        
            	    otherlv_29=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement3874); 

            	        	newLeafNode(otherlv_29, grammarAccess.getRequirementAccess().getGoalKeyword_5_8_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1825:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1826:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1826:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1827:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_5_8_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3896);
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
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1847:4: ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1847:4: ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1848:5: {...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1848:108: ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1849:6: ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1852:6: ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1852:7: {...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1852:16: (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1853:2: otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+
            	    {
            	    otherlv_31=(Token)match(input,See,FOLLOW_See_in_ruleRequirement3966); 

            	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getSeeKeyword_5_9_0());
            	        
            	    otherlv_32=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement3978); 

            	        	newLeafNode(otherlv_32, grammarAccess.getRequirementAccess().getDocumentKeyword_5_9_1());
            	        
            	    otherlv_33=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement3990); 

            	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getRequirementKeyword_5_9_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1867:1: ( ( ruleQualifiedName ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1868:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1868:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1869:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocumentRequirementContractualElementCrossReference_5_9_3_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4012);
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
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1889:4: ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1889:4: ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1890:5: {...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1890:109: ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1891:6: ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1894:6: ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1894:7: {...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1894:16: (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1895:2: otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+
            	    {
            	    otherlv_35=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4082); 

            	        	newLeafNode(otherlv_35, grammarAccess.getRequirementAccess().getSeeKeyword_5_10_0());
            	        
            	    otherlv_36=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement4094); 

            	        	newLeafNode(otherlv_36, grammarAccess.getRequirementAccess().getDocumentKeyword_5_10_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1904:1: ( (lv_docReference_37_0= ruleExternalDocument ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1905:1: (lv_docReference_37_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1905:1: (lv_docReference_37_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1906:3: lv_docReference_37_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_10_2_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4114);
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

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	

            }

            otherlv_38=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement4169); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1950:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1951:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument4203);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument4213); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1958:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1961:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1962:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1962:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1962:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1962:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1963:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1963:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1964:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument4259);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1980:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==NumberSign) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1981:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument4273); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1985:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1986:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1986:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1987:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument4293);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2011:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2012:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2013:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH4331);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH4342); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2020:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2024:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2025:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2025:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2025:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2025:2: (this_ID_0= RULE_ID kw= Solidus )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID) ) {
                    int LA48_1 = input.LA(2);

                    if ( (LA48_1==Solidus) ) {
                        alt48=1;
                    }


                }


                switch (alt48) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2025:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4383); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH4401); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4418); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH4436); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4451); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2066:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2067:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2068:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT4496);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT4507); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2075:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2079:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2080:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2080:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2080:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4547); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2087:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==FullStop) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2088:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT4566); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4581); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop49;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2110:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2111:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2112:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription4629);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription4639); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2119:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2122:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2123:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2123:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==This||LA50_0==Ampersand||LA50_0==RULE_ID||LA50_0==RULE_STRING) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2124:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2124:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2125:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription4684);
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
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2149:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2150:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2151:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement4719);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement4729); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2158:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_2_0=null;
        Token lv_thisTarget_3_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2161:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2162:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2162:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_value_1_0= ruleShowValue ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) )
            int alt51=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt51=1;
                }
                break;
            case RULE_ID:
                {
                alt51=2;
                }
                break;
            case Ampersand:
                {
                alt51=3;
                }
                break;
            case This:
                {
                alt51=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2162:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2162:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2163:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2163:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2164:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement4771); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2181:6: ( (lv_value_1_0= ruleShowValue ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2181:6: ( (lv_value_1_0= ruleShowValue ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2182:1: (lv_value_1_0= ruleShowValue )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2182:1: (lv_value_1_0= ruleShowValue )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2183:3: lv_value_1_0= ruleShowValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getDescriptionElementAccess().getValueShowValueParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleShowValue_in_ruleDescriptionElement4803);
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2200:6: ( (lv_newline_2_0= Ampersand ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2200:6: ( (lv_newline_2_0= Ampersand ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2201:1: (lv_newline_2_0= Ampersand )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2201:1: (lv_newline_2_0= Ampersand )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2202:3: lv_newline_2_0= Ampersand
                    {
                    lv_newline_2_0=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_ruleDescriptionElement4828); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2217:6: ( (lv_thisTarget_3_0= This ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2217:6: ( (lv_thisTarget_3_0= This ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2218:1: (lv_thisTarget_3_0= This )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2218:1: (lv_thisTarget_3_0= This )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2219:3: lv_thisTarget_3_0= This
                    {
                    lv_thisTarget_3_0=(Token)match(input,This,FOLLOW_This_in_ruleDescriptionElement4864); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2241:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2242:2: (iv_ruleShowValue= ruleShowValue EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2243:2: iv_ruleShowValue= ruleShowValue EOF
            {
             newCompositeNode(grammarAccess.getShowValueRule()); 
            pushFollow(FOLLOW_ruleShowValue_in_entryRuleShowValue4910);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;

             current =iv_ruleShowValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleShowValue4920); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2250:1: ruleShowValue returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_unit_2_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2253:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2255:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2256:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getShowValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue4965); 

            		newLeafNode(otherlv_0, grammarAccess.getShowValueAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2267:2: (otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==PercentSign) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2268:2: otherlv_1= PercentSign ( (lv_unit_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,PercentSign,FOLLOW_PercentSign_in_ruleShowValue4979); 

                        	newLeafNode(otherlv_1, grammarAccess.getShowValueAccess().getPercentSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2272:1: ( (lv_unit_2_0= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2273:1: (lv_unit_2_0= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2273:1: (lv_unit_2_0= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2274:3: lv_unit_2_0= RULE_ID
                    {
                    lv_unit_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleShowValue4995); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2298:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2299:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2300:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath5037);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath5047); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2307:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2310:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2311:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2311:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2311:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2311:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2312:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2312:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2313:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath5092); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2324:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2325:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath5106); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2329:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2330:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2330:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2331:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath5126);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2355:1: entryRulePredicateExpression returns [EObject current=null] : iv_rulePredicateExpression= rulePredicateExpression EOF ;
    public final EObject entryRulePredicateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateExpression = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2356:2: (iv_rulePredicateExpression= rulePredicateExpression EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2357:2: iv_rulePredicateExpression= rulePredicateExpression EOF
            {
             newCompositeNode(grammarAccess.getPredicateExpressionRule()); 
            pushFollow(FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression5162);
            iv_rulePredicateExpression=rulePredicateExpression();

            state._fsp--;

             current =iv_rulePredicateExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePredicateExpression5172); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2364:1: rulePredicateExpression returns [EObject current=null] : (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) ;
    public final EObject rulePredicateExpression() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        Token lv_op_1_3=null;
        Token lv_op_1_4=null;
        Token lv_op_1_5=null;
        Token lv_op_1_6=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2367:28: ( (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:2: this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression5208); 
             
                newLeafNode(this_ID_0, grammarAccess.getPredicateExpressionAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2372:1: ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2373:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2373:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2374:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2374:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= LessThanSignEqualsSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            int alt53=6;
            switch ( input.LA(1) ) {
            case EqualsSign:
                {
                alt53=1;
                }
                break;
            case ExclamationMarkEqualsSign:
                {
                alt53=2;
                }
                break;
            case LessThanSign:
                {
                alt53=3;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt53=4;
                }
                break;
            case GreaterThanSign:
                {
                alt53=5;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt53=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2375:3: lv_op_1_1= EqualsSign
                    {
                    lv_op_1_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_rulePredicateExpression5228); 

                            newLeafNode(lv_op_1_1, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2388:8: lv_op_1_2= ExclamationMarkEqualsSign
                    {
                    lv_op_1_2=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression5256); 

                            newLeafNode(lv_op_1_2, grammarAccess.getPredicateExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2401:8: lv_op_1_3= LessThanSign
                    {
                    lv_op_1_3=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_rulePredicateExpression5284); 

                            newLeafNode(lv_op_1_3, grammarAccess.getPredicateExpressionAccess().getOpLessThanSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2414:8: lv_op_1_4= LessThanSignEqualsSign
                    {
                    lv_op_1_4=(Token)match(input,LessThanSignEqualsSign,FOLLOW_LessThanSignEqualsSign_in_rulePredicateExpression5312); 

                            newLeafNode(lv_op_1_4, grammarAccess.getPredicateExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2427:8: lv_op_1_5= GreaterThanSign
                    {
                    lv_op_1_5=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_rulePredicateExpression5340); 

                            newLeafNode(lv_op_1_5, grammarAccess.getPredicateExpressionAccess().getOpGreaterThanSignKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2440:8: lv_op_1_6= GreaterThanSignEqualsSign
                    {
                    lv_op_1_6=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression5368); 

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression5393); 
             
                newLeafNode(this_ID_2, grammarAccess.getPredicateExpressionAccess().getIDTerminalRuleCall_2()); 
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2468:1: entryRuleConstantDecl returns [EObject current=null] : iv_ruleConstantDecl= ruleConstantDecl EOF ;
    public final EObject entryRuleConstantDecl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDecl = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2469:2: (iv_ruleConstantDecl= ruleConstantDecl EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2470:2: iv_ruleConstantDecl= ruleConstantDecl EOF
            {
             newCompositeNode(grammarAccess.getConstantDeclRule()); 
            pushFollow(FOLLOW_ruleConstantDecl_in_entryRuleConstantDecl5427);
            iv_ruleConstantDecl=ruleConstantDecl();

            state._fsp--;

             current =iv_ruleConstantDecl; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDecl5437); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2477:1: ruleConstantDecl returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) ;
    public final EObject ruleConstantDecl() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2480:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2483:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleConstantDecl5479); 

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

            otherlv_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleConstantDecl5497); 

                	newLeafNode(otherlv_1, grammarAccess.getConstantDeclAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2504:1: ( (lv_value_2_0= ruleValueString ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2505:1: (lv_value_2_0= ruleValueString )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2505:1: (lv_value_2_0= ruleValueString )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2506:3: lv_value_2_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getConstantDeclAccess().getValueValueStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleConstantDecl5517);
            lv_value_2_0=ruleValueString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDeclRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
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
    // $ANTLR end "ruleConstantDecl"


    // $ANTLR start "entryRuleStringTerm"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2532:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2533:2: (iv_ruleStringTerm= ruleStringTerm EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2534:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
             newCompositeNode(grammarAccess.getStringTermRule()); 
            pushFollow(FOLLOW_ruleStringTerm_in_entryRuleStringTerm5554);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;

             current =iv_ruleStringTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringTerm5564); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2541:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2544:28: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2546:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2546:1: (lv_value_0_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2547:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringTerm5605); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2571:1: entryRuleRealTerm returns [EObject current=null] : iv_ruleRealTerm= ruleRealTerm EOF ;
    public final EObject entryRuleRealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealTerm = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2572:2: (iv_ruleRealTerm= ruleRealTerm EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2573:2: iv_ruleRealTerm= ruleRealTerm EOF
            {
             newCompositeNode(grammarAccess.getRealTermRule()); 
            pushFollow(FOLLOW_ruleRealTerm_in_entryRuleRealTerm5644);
            iv_ruleRealTerm=ruleRealTerm();

            state._fsp--;

             current =iv_ruleRealTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRealTerm5654); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2580:1: ruleRealTerm returns [EObject current=null] : ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? ) ;
    public final EObject ruleRealTerm() throws RecognitionException {
        EObject current = null;

        Token lv_unit_1_0=null;
        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2583:28: ( ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2584:1: ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2584:1: ( ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2584:2: ( (lv_value_0_0= ruleREAL ) ) ( (lv_unit_1_0= RULE_ID ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2584:2: ( (lv_value_0_0= ruleREAL ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2585:1: (lv_value_0_0= ruleREAL )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2585:1: (lv_value_0_0= ruleREAL )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2586:3: lv_value_0_0= ruleREAL
            {
             
            	        newCompositeNode(grammarAccess.getRealTermAccess().getValueREALParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleREAL_in_ruleRealTerm5700);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2602:2: ( (lv_unit_1_0= RULE_ID ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2603:1: (lv_unit_1_0= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2603:1: (lv_unit_1_0= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2604:3: lv_unit_1_0= RULE_ID
                    {
                    lv_unit_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRealTerm5717); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2628:1: entryRuleREAL returns [String current=null] : iv_ruleREAL= ruleREAL EOF ;
    public final String entryRuleREAL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleREAL = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2629:1: (iv_ruleREAL= ruleREAL EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2630:2: iv_ruleREAL= ruleREAL EOF
            {
             newCompositeNode(grammarAccess.getREALRule()); 
            pushFollow(FOLLOW_ruleREAL_in_entryRuleREAL5759);
            iv_ruleREAL=ruleREAL();

            state._fsp--;

             current =iv_ruleREAL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleREAL5770); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2637:1: ruleREAL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleREAL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2641:6: ( (this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2642:1: (this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2642:1: (this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2642:6: this_INT_0= RULE_INT kw= FullStop this_INT_2= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL5810); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getREALAccess().getINTTerminalRuleCall_0()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleREAL5828); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getREALAccess().getFullStopKeyword_1()); 
                
            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleREAL5843); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2670:1: entryRuleIntegerTerm returns [EObject current=null] : iv_ruleIntegerTerm= ruleIntegerTerm EOF ;
    public final EObject entryRuleIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerTerm = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2671:2: (iv_ruleIntegerTerm= ruleIntegerTerm EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2672:2: iv_ruleIntegerTerm= ruleIntegerTerm EOF
            {
             newCompositeNode(grammarAccess.getIntegerTermRule()); 
            pushFollow(FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm5887);
            iv_ruleIntegerTerm=ruleIntegerTerm();

            state._fsp--;

             current =iv_ruleIntegerTerm; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerTerm5897); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2679:1: ruleIntegerTerm returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? ) ;
    public final EObject ruleIntegerTerm() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_unit_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2682:28: ( ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2683:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2683:1: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2683:2: ( (lv_value_0_0= RULE_INT ) ) ( (lv_unit_1_0= RULE_ID ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2683:2: ( (lv_value_0_0= RULE_INT ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2684:1: (lv_value_0_0= RULE_INT )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2684:1: (lv_value_0_0= RULE_INT )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2685:3: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntegerTerm5939); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2701:2: ( (lv_unit_1_0= RULE_ID ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2702:1: (lv_unit_1_0= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2702:1: (lv_unit_1_0= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2703:3: lv_unit_1_0= RULE_ID
                    {
                    lv_unit_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIntegerTerm5961); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2727:1: entryRuleMultiLineString returns [EObject current=null] : iv_ruleMultiLineString= ruleMultiLineString EOF ;
    public final EObject entryRuleMultiLineString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiLineString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2728:2: (iv_ruleMultiLineString= ruleMultiLineString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2729:2: iv_ruleMultiLineString= ruleMultiLineString EOF
            {
             newCompositeNode(grammarAccess.getMultiLineStringRule()); 
            pushFollow(FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString6002);
            iv_ruleMultiLineString=ruleMultiLineString();

            state._fsp--;

             current =iv_ruleMultiLineString; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiLineString6012); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2736:1: ruleMultiLineString returns [EObject current=null] : ( (lv_description_0_0= ruleTextElement ) )+ ;
    public final EObject ruleMultiLineString() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2739:28: ( ( (lv_description_0_0= ruleTextElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2740:1: ( (lv_description_0_0= ruleTextElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2740:1: ( (lv_description_0_0= ruleTextElement ) )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==Ampersand||LA56_0==RULE_STRING) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2741:1: (lv_description_0_0= ruleTextElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2741:1: (lv_description_0_0= ruleTextElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2742:3: lv_description_0_0= ruleTextElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiLineStringAccess().getDescriptionTextElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTextElement_in_ruleMultiLineString6057);
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
            	    if ( cnt56 >= 1 ) break loop56;
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2766:1: entryRuleTextElement returns [EObject current=null] : iv_ruleTextElement= ruleTextElement EOF ;
    public final EObject entryRuleTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2767:2: (iv_ruleTextElement= ruleTextElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2768:2: iv_ruleTextElement= ruleTextElement EOF
            {
             newCompositeNode(grammarAccess.getTextElementRule()); 
            pushFollow(FOLLOW_ruleTextElement_in_entryRuleTextElement6092);
            iv_ruleTextElement=ruleTextElement();

            state._fsp--;

             current =iv_ruleTextElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextElement6102); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2775:1: ruleTextElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) ) ;
    public final EObject ruleTextElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2778:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2779:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2779:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_STRING) ) {
                alt57=1;
            }
            else if ( (LA57_0==Ampersand) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2779:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2779:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2780:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2780:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2781:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextElement6144); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:6: ( (lv_newline_1_0= Ampersand ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:6: ( (lv_newline_1_0= Ampersand ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:1: (lv_newline_1_0= Ampersand )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:1: (lv_newline_1_0= Ampersand )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2800:3: lv_newline_1_0= Ampersand
                    {
                    lv_newline_1_0=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_ruleTextElement6174); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2822:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2823:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2824:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString6221);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString6232); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2831:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2835:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2836:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString6271); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2851:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2852:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2853:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6315);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference6326); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2860:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2864:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2865:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2865:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2865:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2865:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID) ) {
                    int LA58_1 = input.LA(2);

                    if ( (LA58_1==ColonColon) ) {
                        alt58=1;
                    }


                }


                switch (alt58) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2865:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6367); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference6385); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6402); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2885:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==FullStop) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2886:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference6421); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6436); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2906:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2907:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2908:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef6483);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef6494); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2915:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2919:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2920:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef6533); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2935:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2936:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2937:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6577);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName6588); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2944:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2948:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2949:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2949:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2949:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6628); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2956:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==FullStop) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2957:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName6647); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6662); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop60;
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


    protected DFA35 dfa35 = new DFA35(this);
    protected DFA46 dfa46 = new DFA46(this);
    static final String DFA35_eotS =
        "\14\uffff";
    static final String DFA35_eofS =
        "\14\uffff";
    static final String DFA35_minS =
        "\1\5\7\uffff\1\15\1\6\2\uffff";
    static final String DFA35_maxS =
        "\1\51\7\uffff\1\15\1\52\2\uffff";
    static final String DFA35_acceptS =
        "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\2\uffff\1\7\1\10";
    static final String DFA35_specialS =
        "\1\2\7\uffff\1\0\1\1\2\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\3\1\uffff\1\7\1\6\2\uffff\1\4\1\2\3\uffff\1\5\10\uffff\1"+
            "\10\17\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11",
            "\1\12\43\uffff\1\13",
            "",
            ""
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "()* loopback of 1098:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Conflicts otherlv_18= With ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_20= Stakeholder ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= See otherlv_23= Document otherlv_24= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_26= See otherlv_27= Document ( (lv_docReference_28_0= ruleExternalDocument ) )+ ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA35_8 = input.LA(1);

                         
                        int index35_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA35_8 ==Document && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) ) {s = 9;}

                         
                        input.seek(index35_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA35_9 = input.LA(1);

                         
                        int index35_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA35_9 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {s = 10;}

                        else if ( LA35_9 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {s = 11;}

                         
                        input.seek(index35_9);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA35_0 = input.LA(1);

                         
                        int index35_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA35_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA35_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA35_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA35_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA35_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA35_0 ==Conflicts && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA35_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA35_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) ) {s = 8;}

                         
                        input.seek(index35_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 35, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA46_eotS =
        "\17\uffff";
    static final String DFA46_eofS =
        "\17\uffff";
    static final String DFA46_minS =
        "\1\5\6\uffff\1\15\2\uffff\1\6\4\uffff";
    static final String DFA46_maxS =
        "\1\51\6\uffff\1\25\2\uffff\1\52\4\uffff";
    static final String DFA46_acceptS =
        "\1\uffff\1\14\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\uffff\1\6"+
        "\1\11\1\13\1\12";
    static final String DFA46_specialS =
        "\1\1\6\uffff\1\2\2\uffff\1\0\4\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\3\3\uffff\1\4\1\10\1\6\1\2\3\uffff\1\11\1\uffff\1\5\6\uffff"+
            "\1\7\17\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\7\uffff\1\13",
            "",
            "",
            "\1\16\16\uffff\1\14\24\uffff\1\15",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "()* loopback of 1513:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleConstantDecl ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Mitigates ( ( (otherlv_23= RULE_ID ) ) | ( (lv_exceptionText_24_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= Refines ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= See otherlv_28= Document otherlv_29= Goal ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Document otherlv_33= Requirement ( ( ruleQualifiedName ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_35= See otherlv_36= Document ( (lv_docReference_37_0= ruleExternalDocument ) )+ ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_10 = input.LA(1);

                         
                        int index46_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA46_10 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) ) {s = 12;}

                        else if ( LA46_10 ==RULE_ID && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) ) {s = 13;}

                        else if ( LA46_10 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) {s = 14;}

                         
                        input.seek(index46_10);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_0 = input.LA(1);

                         
                        int index46_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA46_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA46_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA46_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA46_0 ==Constants && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA46_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA46_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA46_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) ) {s = 7;}

                        else if ( LA46_0 ==Mitigates && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA46_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                         
                        input.seek(index46_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA46_7 = input.LA(1);

                         
                        int index46_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA46_7 ==Document && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) ) {s = 10;}

                        else if ( LA46_7 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) {s = 11;}

                         
                        input.seek(index46_7);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
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
    public static final BitSet FOLLOW_Stakeholder_in_ruleStakeholderGoals266 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Goals_in_ruleStakeholderGoals278 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholderGoals294 = new BitSet(new long[]{0x0000011001000020L});
    public static final BitSet FOLLOW_Colon_in_ruleStakeholderGoals313 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholderGoals333 = new BitSet(new long[]{0x0000010001000020L});
    public static final BitSet FOLLOW_For_in_ruleStakeholderGoals349 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleStakeholderGoals372 = new BitSet(new long[]{0x0000010000000020L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholderGoals399 = new BitSet(new long[]{0x0000010000000020L});
    public static final BitSet FOLLOW_Description_in_ruleStakeholderGoals416 = new BitSet(new long[]{0x0000100200000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleStakeholderGoals436 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals451 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleStakeholderGoals473 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleStakeholderGoals486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_entryRuleReqDocument520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqDocument530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Document_in_ruleReqDocument568 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqDocument584 = new BitSet(new long[]{0x0000011000000020L});
    public static final BitSet FOLLOW_Colon_in_ruleReqDocument603 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqDocument623 = new BitSet(new long[]{0x0000010000000020L});
    public static final BitSet FOLLOW_Description_in_ruleReqDocument639 = new BitSet(new long[]{0x0000100200000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqDocument659 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqDocument674 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_ruleReqDocument694 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqDocument707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_entryRuleDocumentSection741 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentSection751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Section_in_ruleDocumentSection789 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDocumentSection805 = new BitSet(new long[]{0x0000011000000020L});
    public static final BitSet FOLLOW_Colon_in_ruleDocumentSection824 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleDocumentSection844 = new BitSet(new long[]{0x0000010000000020L});
    public static final BitSet FOLLOW_Description_in_ruleDocumentSection860 = new BitSet(new long[]{0x0000100200000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleDocumentSection880 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleDocumentSection895 = new BitSet(new long[]{0x0000020000220040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleDocumentSection917 = new BitSet(new long[]{0x0000020000220040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleDocumentSection936 = new BitSet(new long[]{0x0000020000220040L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_ruleDocumentSection955 = new BitSet(new long[]{0x0000020000220040L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleDocumentSection972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecs_in_entryRuleReqSpecs1006 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecs1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleReqSpecs1054 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Specification_in_ruleReqSpecs1066 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecs1082 = new BitSet(new long[]{0x0000011001004000L});
    public static final BitSet FOLLOW_Colon_in_ruleReqSpecs1101 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecs1121 = new BitSet(new long[]{0x0000010001004000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecs1137 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecs1160 = new BitSet(new long[]{0x0000010000004000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecs1187 = new BitSet(new long[]{0x0000010000004000L});
    public static final BitSet FOLLOW_Include_in_ruleReqSpecs1204 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleReqSpecs1226 = new BitSet(new long[]{0x0000050000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecs1242 = new BitSet(new long[]{0x0000020000080240L});
    public static final BitSet FOLLOW_Constants_in_ruleReqSpecs1255 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleConstantDecl_in_ruleReqSpecs1275 = new BitSet(new long[]{0x0000060000080040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecs1301 = new BitSet(new long[]{0x0000020000080040L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecs1320 = new BitSet(new long[]{0x0000020000080040L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecs1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1375 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecFolder1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleReqSpecFolder1423 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecFolder1439 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_Colon_in_ruleReqSpecFolder1458 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecFolder1478 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1493 = new BitSet(new long[]{0x0000020000280040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecFolder1515 = new BitSet(new long[]{0x0000020000280040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecFolder1534 = new BitSet(new long[]{0x0000020000280040L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1553 = new BitSet(new long[]{0x0000020000280040L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalFolder_in_entryRuleGoalFolder1604 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalFolder1614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleGoalFolder1652 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoalFolder1668 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoalFolder1687 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoalFolder1707 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoalFolder1722 = new BitSet(new long[]{0x0000020000280000L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoalFolder1744 = new BitSet(new long[]{0x0000020000280000L});
    public static final BitSet FOLLOW_ruleGoalFolder_in_ruleGoalFolder1763 = new BitSet(new long[]{0x0000020000280000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoalFolder1780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal1814 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal1824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal1862 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1878 = new BitSet(new long[]{0x0000011001000000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoal1897 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1917 = new BitSet(new long[]{0x0000010001000000L});
    public static final BitSet FOLLOW_For_in_ruleGoal1933 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1953 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1980 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal1996 = new BitSet(new long[]{0x00000200020119A0L});
    public static final BitSet FOLLOW_Category_in_ruleGoal2054 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal2076 = new BitSet(new long[]{0x00000200020119A0L});
    public static final BitSet FOLLOW_Description_in_ruleGoal2145 = new BitSet(new long[]{0x0000140200400000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal2165 = new BitSet(new long[]{0x00000200020119A0L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal2234 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2254 = new BitSet(new long[]{0x00000200020119A0L});
    public static final BitSet FOLLOW_Refines_in_ruleGoal2323 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2345 = new BitSet(new long[]{0x00000600020119A0L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2415 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_With_in_ruleGoal2427 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2449 = new BitSet(new long[]{0x00000600020119A0L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2519 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2541 = new BitSet(new long[]{0x00000600020119A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2611 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal2623 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal2635 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2657 = new BitSet(new long[]{0x00000600020119A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2727 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal2739 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal2759 = new BitSet(new long[]{0x00000600020119A0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement2848 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement2858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement2896 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement2912 = new BitSet(new long[]{0x0000011001000000L});
    public static final BitSet FOLLOW_Colon_in_ruleRequirement2931 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement2951 = new BitSet(new long[]{0x0000010001000000L});
    public static final BitSet FOLLOW_For_in_ruleRequirement2967 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement2987 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3014 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3030 = new BitSet(new long[]{0x0000020002051E20L});
    public static final BitSet FOLLOW_Category_in_ruleRequirement3088 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3110 = new BitSet(new long[]{0x0000020002051E20L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3179 = new BitSet(new long[]{0x0000140200400000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3199 = new BitSet(new long[]{0x0000020002051E20L});
    public static final BitSet FOLLOW_Constants_in_ruleRequirement3268 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleConstantDecl_in_ruleRequirement3288 = new BitSet(new long[]{0x0000060002051E20L});
    public static final BitSet FOLLOW_Assert_in_ruleRequirement3358 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleRequirement3378 = new BitSet(new long[]{0x0000020002051E20L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement3447 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRequirement3463 = new BitSet(new long[]{0x0000020002051E20L});
    public static final BitSet FOLLOW_See_in_ruleRequirement3537 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement3549 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3571 = new BitSet(new long[]{0x0000060002051E20L});
    public static final BitSet FOLLOW_Mitigates_in_ruleRequirement3641 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3661 = new BitSet(new long[]{0x0000020002051E20L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3688 = new BitSet(new long[]{0x0000020002051E20L});
    public static final BitSet FOLLOW_Refines_in_ruleRequirement3758 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3780 = new BitSet(new long[]{0x0000060002051E20L});
    public static final BitSet FOLLOW_See_in_ruleRequirement3850 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement3862 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement3874 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3896 = new BitSet(new long[]{0x0000060002051E20L});
    public static final BitSet FOLLOW_See_in_ruleRequirement3966 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement3978 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement3990 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4012 = new BitSet(new long[]{0x0000060002051E20L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4082 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement4094 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4114 = new BitSet(new long[]{0x0000060002051E20L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement4169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument4203 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument4213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument4259 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument4273 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument4293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH4331 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH4342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4383 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH4401 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4418 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH4436 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT4496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT4507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4547 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT4566 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4581 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription4629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription4639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription4684 = new BitSet(new long[]{0x0000140200400002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement4719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement4771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_ruleDescriptionElement4803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ampersand_in_ruleDescriptionElement4828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_This_in_ruleDescriptionElement4864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleShowValue_in_entryRuleShowValue4910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleShowValue4920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue4965 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_PercentSign_in_ruleShowValue4979 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleShowValue4995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath5037 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath5047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath5092 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath5106 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath5126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression5162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePredicateExpression5172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression5208 = new BitSet(new long[]{0x000000E064000000L});
    public static final BitSet FOLLOW_EqualsSign_in_rulePredicateExpression5228 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression5256 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_LessThanSign_in_rulePredicateExpression5284 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_LessThanSignEqualsSign_in_rulePredicateExpression5312 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_GreaterThanSign_in_rulePredicateExpression5340 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression5368 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression5393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDecl_in_entryRuleConstantDecl5427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDecl5437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleConstantDecl5479 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleConstantDecl5497 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleConstantDecl5517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringTerm_in_entryRuleStringTerm5554 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringTerm5564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringTerm5605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRealTerm_in_entryRuleRealTerm5644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRealTerm5654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_ruleRealTerm5700 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRealTerm5717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleREAL_in_entryRuleREAL5759 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleREAL5770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL5810 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleREAL5828 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleREAL5843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerTerm_in_entryRuleIntegerTerm5887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerTerm5897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntegerTerm5939 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIntegerTerm5961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString6002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiLineString6012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_ruleMultiLineString6057 = new BitSet(new long[]{0x0000100200000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_entryRuleTextElement6092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextElement6102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextElement6144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ampersand_in_ruleTextElement6174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString6221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString6232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString6271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference6326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6367 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference6385 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6402 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference6421 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef6483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef6494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef6533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6577 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName6588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6628 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName6647 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6662 = new BitSet(new long[]{0x0000000400000002L});

}
