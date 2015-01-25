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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Specification", "Requirements", "Description", "Requirement", "Stakeholder", "Documented", "Conflicts", "Constants", "Mitigates", "Rationale", "Category", "Document", "Refines", "Section", "Assert", "Folder", "Goals", "Goal", "This", "With", "For", "See", "ExclamationMarkEqualsSign", "FullStopAsterisk", "ColonColon", "EqualsSignLessThanSign", "GreaterThanSignEqualsSign", "NumberSign", "Ampersand", "Comma", "FullStop", "Solidus", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=42;
    public static final int Specification=4;
    public static final int Constants=11;
    public static final int Assert=18;
    public static final int RULE_ANY_OTHER=48;
    public static final int RightSquareBracket=41;
    public static final int Mitigates=12;
    public static final int Requirement=7;
    public static final int Solidus=35;
    public static final int EOF=-1;
    public static final int GreaterThanSign=39;
    public static final int FullStop=34;
    public static final int EqualsSignLessThanSign=29;
    public static final int LessThanSign=37;
    public static final int RULE_INT=43;
    public static final int LeftSquareBracket=40;
    public static final int Refines=16;
    public static final int Conflicts=10;
    public static final int ExclamationMarkEqualsSign=26;
    public static final int Stakeholder=8;
    public static final int This=22;
    public static final int FullStopAsterisk=27;
    public static final int Colon=36;
    public static final int RULE_SL_COMMENT=46;
    public static final int For=24;
    public static final int NumberSign=31;
    public static final int Rationale=13;
    public static final int With=23;
    public static final int RULE_ML_COMMENT=45;
    public static final int Goal=21;
    public static final int Ampersand=32;
    public static final int Goals=20;
    public static final int ColonColon=28;
    public static final int Document=15;
    public static final int Description=6;
    public static final int RULE_STRING=44;
    public static final int Folder=19;
    public static final int Documented=9;
    public static final int Requirements=5;
    public static final int See=25;
    public static final int Section=17;
    public static final int GreaterThanSignEqualsSign=30;
    public static final int Category=14;
    public static final int RULE_WS=47;
    public static final int EqualsSign=38;
    public static final int Comma=33;

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:70:1: ruleReqSpec returns [EObject current=null] : ( ( (lv_contents_0_1= ruleReqSpecs | lv_contents_0_2= ruleStakeholderGoals | lv_contents_0_3= ruleReqDocument ) ) ) ;
    public final EObject ruleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_0_1 = null;

        EObject lv_contents_0_2 = null;

        EObject lv_contents_0_3 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:73:28: ( ( ( (lv_contents_0_1= ruleReqSpecs | lv_contents_0_2= ruleStakeholderGoals | lv_contents_0_3= ruleReqDocument ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:1: ( ( (lv_contents_0_1= ruleReqSpecs | lv_contents_0_2= ruleStakeholderGoals | lv_contents_0_3= ruleReqDocument ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:1: ( ( (lv_contents_0_1= ruleReqSpecs | lv_contents_0_2= ruleStakeholderGoals | lv_contents_0_3= ruleReqDocument ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:1: ( (lv_contents_0_1= ruleReqSpecs | lv_contents_0_2= ruleStakeholderGoals | lv_contents_0_3= ruleReqDocument ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:1: ( (lv_contents_0_1= ruleReqSpecs | lv_contents_0_2= ruleStakeholderGoals | lv_contents_0_3= ruleReqDocument ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:76:1: (lv_contents_0_1= ruleReqSpecs | lv_contents_0_2= ruleStakeholderGoals | lv_contents_0_3= ruleReqDocument )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:76:1: (lv_contents_0_1= ruleReqSpecs | lv_contents_0_2= ruleStakeholderGoals | lv_contents_0_3= ruleReqDocument )
            int alt1=3;
            switch ( input.LA(1) ) {
            case Requirements:
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:77:3: lv_contents_0_1= ruleReqSpecs
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecAccess().getContentsReqSpecsParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleReqSpecs_in_ruleReqSpec124);
                    lv_contents_0_1=ruleReqSpecs();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecRule());
                    	        }
                           		add(
                           			current, 
                           			"contents",
                            		lv_contents_0_1, 
                            		"ReqSpecs");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:92:8: lv_contents_0_2= ruleStakeholderGoals
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecAccess().getContentsStakeholderGoalsParserRuleCall_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleStakeholderGoals_in_ruleReqSpec143);
                    lv_contents_0_2=ruleStakeholderGoals();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecRule());
                    	        }
                           		add(
                           			current, 
                           			"contents",
                            		lv_contents_0_2, 
                            		"StakeholderGoals");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:107:8: lv_contents_0_3= ruleReqDocument
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecAccess().getContentsReqDocumentParserRuleCall_0_2()); 
                    	    
                    pushFollow(FOLLOW_ruleReqDocument_in_ruleReqSpec162);
                    lv_contents_0_3=ruleReqDocument();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecRule());
                    	        }
                           		add(
                           			current, 
                           			"contents",
                            		lv_contents_0_3, 
                            		"ReqDocument");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;

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
    // $ANTLR end "ruleReqSpec"


    // $ANTLR start "entryRuleStakeholderGoals"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:139:1: entryRuleStakeholderGoals returns [EObject current=null] : iv_ruleStakeholderGoals= ruleStakeholderGoals EOF ;
    public final EObject entryRuleStakeholderGoals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStakeholderGoals = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:140:2: (iv_ruleStakeholderGoals= ruleStakeholderGoals EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:141:2: iv_ruleStakeholderGoals= ruleStakeholderGoals EOF
            {
             newCompositeNode(grammarAccess.getStakeholderGoalsRule()); 
            pushFollow(FOLLOW_ruleStakeholderGoals_in_entryRuleStakeholderGoals205);
            iv_ruleStakeholderGoals=ruleStakeholderGoals();

            state._fsp--;

             current =iv_ruleStakeholderGoals; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStakeholderGoals215); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:148:1: ruleStakeholderGoals returns [EObject current=null] : (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:151:28: ( (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:152:1: (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:152:1: (otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:153:2: otherlv_0= Stakeholder otherlv_1= Goals ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )? otherlv_10= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_12= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleStakeholderGoals253); 

                	newLeafNode(otherlv_0, grammarAccess.getStakeholderGoalsAccess().getStakeholderKeyword_0());
                
            otherlv_1=(Token)match(input,Goals,FOLLOW_Goals_in_ruleStakeholderGoals265); 

                	newLeafNode(otherlv_1, grammarAccess.getStakeholderGoalsAccess().getGoalsKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:162:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:163:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:163:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:164:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStakeholderGoals281); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:180:2: (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Colon) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:181:2: otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) )
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleStakeholderGoals300); 

                        	newLeafNode(otherlv_3, grammarAccess.getStakeholderGoalsAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:185:1: ( (lv_title_4_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:186:1: (lv_title_4_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:186:1: (lv_title_4_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:187:3: lv_title_4_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getTitleValueStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleStakeholderGoals320);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:203:4: (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==For) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:204:2: otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
                    {
                    otherlv_5=(Token)match(input,For,FOLLOW_For_in_ruleStakeholderGoals336); 

                        	newLeafNode(otherlv_5, grammarAccess.getStakeholderGoalsAccess().getForKeyword_4_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:208:1: ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
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
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:208:2: ( ( ruleAadlClassifierReference ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:208:2: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:209:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:209:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:210:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getStakeholderGoalsRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getTargetClassifierCrossReference_4_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleStakeholderGoals359);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:224:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:224:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:225:1: (lv_targetDescription_7_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:225:1: (lv_targetDescription_7_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:226:3: lv_targetDescription_7_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getTargetDescriptionValueStringParserRuleCall_4_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleStakeholderGoals386);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:242:5: (otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Description) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:243:2: otherlv_8= Description ( (lv_description_9_0= ruleMultiLineString ) )
                    {
                    otherlv_8=(Token)match(input,Description,FOLLOW_Description_in_ruleStakeholderGoals403); 

                        	newLeafNode(otherlv_8, grammarAccess.getStakeholderGoalsAccess().getDescriptionKeyword_5_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:247:1: ( (lv_description_9_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:248:1: (lv_description_9_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:248:1: (lv_description_9_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:249:3: lv_description_9_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getDescriptionMultiLineStringParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleStakeholderGoals423);
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

            otherlv_10=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals438); 

                	newLeafNode(otherlv_10, grammarAccess.getStakeholderGoalsAccess().getLeftSquareBracketKeyword_6());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:270:1: ( ( ruleQualifiedName ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:271:1: ( ruleQualifiedName )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:271:1: ( ruleQualifiedName )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:272:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStakeholderGoalsRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getConsistsOfGoalFolderCrossReference_7_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleStakeholderGoals460);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleStakeholderGoals473); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:298:1: entryRuleReqDocument returns [EObject current=null] : iv_ruleReqDocument= ruleReqDocument EOF ;
    public final EObject entryRuleReqDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:299:2: (iv_ruleReqDocument= ruleReqDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:300:2: iv_ruleReqDocument= ruleReqDocument EOF
            {
             newCompositeNode(grammarAccess.getReqDocumentRule()); 
            pushFollow(FOLLOW_ruleReqDocument_in_entryRuleReqDocument507);
            iv_ruleReqDocument=ruleReqDocument();

            state._fsp--;

             current =iv_ruleReqDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqDocument517); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:307:1: ruleReqDocument returns [EObject current=null] : (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:310:28: ( (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:311:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:311:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:312:2: otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( (lv_content_7_0= ruleDocumentSection ) ) otherlv_8= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Document,FOLLOW_Document_in_ruleReqDocument555); 

                	newLeafNode(otherlv_0, grammarAccess.getReqDocumentAccess().getDocumentKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:316:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:317:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:317:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:318:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqDocument571); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:334:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Colon) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:335:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqDocument590); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqDocumentAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:339:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:340:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:340:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:341:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqDocumentAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqDocument610);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:357:4: (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Description) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:358:2: otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) )
                    {
                    otherlv_4=(Token)match(input,Description,FOLLOW_Description_in_ruleReqDocument626); 

                        	newLeafNode(otherlv_4, grammarAccess.getReqDocumentAccess().getDescriptionKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:362:1: ( (lv_description_5_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:363:1: (lv_description_5_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:363:1: (lv_description_5_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:364:3: lv_description_5_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqDocumentAccess().getDescriptionMultiLineStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqDocument646);
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

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqDocument661); 

                	newLeafNode(otherlv_6, grammarAccess.getReqDocumentAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:385:1: ( (lv_content_7_0= ruleDocumentSection ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:386:1: (lv_content_7_0= ruleDocumentSection )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:386:1: (lv_content_7_0= ruleDocumentSection )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:387:3: lv_content_7_0= ruleDocumentSection
            {
             
            	        newCompositeNode(grammarAccess.getReqDocumentAccess().getContentDocumentSectionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleDocumentSection_in_ruleReqDocument681);
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

            otherlv_8=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqDocument694); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:416:1: entryRuleDocumentSection returns [EObject current=null] : iv_ruleDocumentSection= ruleDocumentSection EOF ;
    public final EObject entryRuleDocumentSection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentSection = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:417:2: (iv_ruleDocumentSection= ruleDocumentSection EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:418:2: iv_ruleDocumentSection= ruleDocumentSection EOF
            {
             newCompositeNode(grammarAccess.getDocumentSectionRule()); 
            pushFollow(FOLLOW_ruleDocumentSection_in_entryRuleDocumentSection728);
            iv_ruleDocumentSection=ruleDocumentSection();

            state._fsp--;

             current =iv_ruleDocumentSection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDocumentSection738); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:425:1: ruleDocumentSection returns [EObject current=null] : (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:428:28: ( (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:429:1: (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:429:1: (otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:430:2: otherlv_0= Section ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )* otherlv_8= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Section,FOLLOW_Section_in_ruleDocumentSection776); 

                	newLeafNode(otherlv_0, grammarAccess.getDocumentSectionAccess().getSectionKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:434:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:435:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:435:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:436:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDocumentSection792); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:452:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Colon) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:453:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleDocumentSection811); 

                        	newLeafNode(otherlv_2, grammarAccess.getDocumentSectionAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:457:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:458:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:458:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:459:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleDocumentSection831);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:475:4: (otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Description) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:476:2: otherlv_4= Description ( (lv_description_5_0= ruleMultiLineString ) )
                    {
                    otherlv_4=(Token)match(input,Description,FOLLOW_Description_in_ruleDocumentSection847); 

                        	newLeafNode(otherlv_4, grammarAccess.getDocumentSectionAccess().getDescriptionKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:480:1: ( (lv_description_5_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:481:1: (lv_description_5_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:481:1: (lv_description_5_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:482:3: lv_description_5_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getDescriptionMultiLineStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleDocumentSection867);
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

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleDocumentSection882); 

                	newLeafNode(otherlv_6, grammarAccess.getDocumentSectionAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:503:1: ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Requirement||LA11_0==Section||LA11_0==Goal) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:504:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:504:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:505:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:505:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleDocumentSection )
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:506:3: lv_content_7_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentGoalParserRuleCall_5_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleDocumentSection904);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:521:8: lv_content_7_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentRequirementParserRuleCall_5_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleDocumentSection923);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:536:8: lv_content_7_3= ruleDocumentSection
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getDocumentSectionAccess().getContentDocumentSectionParserRuleCall_5_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleDocumentSection_in_ruleDocumentSection942);
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

            otherlv_8=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleDocumentSection959); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:567:1: entryRuleReqSpecs returns [EObject current=null] : iv_ruleReqSpecs= ruleReqSpecs EOF ;
    public final EObject entryRuleReqSpecs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecs = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:568:2: (iv_ruleReqSpecs= ruleReqSpecs EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:569:2: iv_ruleReqSpecs= ruleReqSpecs EOF
            {
             newCompositeNode(grammarAccess.getReqSpecsRule()); 
            pushFollow(FOLLOW_ruleReqSpecs_in_entryRuleReqSpecs993);
            iv_ruleReqSpecs=ruleReqSpecs();

            state._fsp--;

             current =iv_ruleReqSpecs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecs1003); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:576:1: ruleReqSpecs returns [EObject current=null] : (otherlv_0= Requirements otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? otherlv_8= LeftSquareBracket (otherlv_9= Constants ( (lv_constants_10_0= ruleFinalValue ) )+ )? ( ( (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder ) ) )* otherlv_12= RightSquareBracket ) ;
    public final EObject ruleReqSpecs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_title_4_0 = null;

        AntlrDatatypeRuleToken lv_targetDescription_7_0 = null;

        EObject lv_constants_10_0 = null;

        EObject lv_content_11_1 = null;

        EObject lv_content_11_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:579:28: ( (otherlv_0= Requirements otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? otherlv_8= LeftSquareBracket (otherlv_9= Constants ( (lv_constants_10_0= ruleFinalValue ) )+ )? ( ( (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder ) ) )* otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:580:1: (otherlv_0= Requirements otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? otherlv_8= LeftSquareBracket (otherlv_9= Constants ( (lv_constants_10_0= ruleFinalValue ) )+ )? ( ( (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder ) ) )* otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:580:1: (otherlv_0= Requirements otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? otherlv_8= LeftSquareBracket (otherlv_9= Constants ( (lv_constants_10_0= ruleFinalValue ) )+ )? ( ( (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder ) ) )* otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:581:2: otherlv_0= Requirements otherlv_1= Specification ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )? (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )? otherlv_8= LeftSquareBracket (otherlv_9= Constants ( (lv_constants_10_0= ruleFinalValue ) )+ )? ( ( (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder ) ) )* otherlv_12= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirements,FOLLOW_Requirements_in_ruleReqSpecs1041); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecsAccess().getRequirementsKeyword_0());
                
            otherlv_1=(Token)match(input,Specification,FOLLOW_Specification_in_ruleReqSpecs1053); 

                	newLeafNode(otherlv_1, grammarAccess.getReqSpecsAccess().getSpecificationKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:590:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:591:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:591:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:592:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecs1069); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:608:2: (otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Colon) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:609:2: otherlv_3= Colon ( (lv_title_4_0= ruleValueString ) )
                    {
                    otherlv_3=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqSpecs1088); 

                        	newLeafNode(otherlv_3, grammarAccess.getReqSpecsAccess().getColonKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:613:1: ( (lv_title_4_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:614:1: (lv_title_4_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:614:1: (lv_title_4_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:615:3: lv_title_4_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTitleValueStringParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecs1108);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:631:4: (otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==For) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:632:2: otherlv_5= For ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
                    {
                    otherlv_5=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecs1124); 

                        	newLeafNode(otherlv_5, grammarAccess.getReqSpecsAccess().getForKeyword_4_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:636:1: ( ( ( ruleAadlClassifierReference ) ) | ( (lv_targetDescription_7_0= ruleValueString ) ) )
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
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:636:2: ( ( ruleAadlClassifierReference ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:636:2: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:637:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:637:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:638:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getReqSpecsRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTargetClassifierCrossReference_4_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecs1147);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:652:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:652:6: ( (lv_targetDescription_7_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:1: (lv_targetDescription_7_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:1: (lv_targetDescription_7_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:654:3: lv_targetDescription_7_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getTargetDescriptionValueStringParserRuleCall_4_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecs1174);
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

            otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecs1190); 

                	newLeafNode(otherlv_8, grammarAccess.getReqSpecsAccess().getLeftSquareBracketKeyword_5());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:675:1: (otherlv_9= Constants ( (lv_constants_10_0= ruleFinalValue ) )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==Constants) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:676:2: otherlv_9= Constants ( (lv_constants_10_0= ruleFinalValue ) )+
                    {
                    otherlv_9=(Token)match(input,Constants,FOLLOW_Constants_in_ruleReqSpecs1203); 

                        	newLeafNode(otherlv_9, grammarAccess.getReqSpecsAccess().getConstantsKeyword_6_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:680:1: ( (lv_constants_10_0= ruleFinalValue ) )+
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
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:681:1: (lv_constants_10_0= ruleFinalValue )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:681:1: (lv_constants_10_0= ruleFinalValue )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:682:3: lv_constants_10_0= ruleFinalValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecsAccess().getConstantsFinalValueParserRuleCall_6_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFinalValue_in_ruleReqSpecs1223);
                    	    lv_constants_10_0=ruleFinalValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constants",
                    	            		lv_constants_10_0, 
                    	            		"FinalValue");
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:698:5: ( ( (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==Requirement||LA18_0==Folder) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:699:1: ( (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:699:1: ( (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:700:1: (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:700:1: (lv_content_11_1= ruleRequirement | lv_content_11_2= ruleReqSpecFolder )
            	    int alt17=2;
            	    int LA17_0 = input.LA(1);

            	    if ( (LA17_0==Requirement) ) {
            	        alt17=1;
            	    }
            	    else if ( (LA17_0==Folder) ) {
            	        alt17=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 17, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt17) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:701:3: lv_content_11_1= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getContentRequirementParserRuleCall_7_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecs1249);
            	            lv_content_11_1=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_11_1, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:716:8: lv_content_11_2= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecsAccess().getContentReqSpecFolderParserRuleCall_7_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecs1268);
            	            lv_content_11_2=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecsRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_11_2, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecs1285); 

                	newLeafNode(otherlv_12, grammarAccess.getReqSpecsAccess().getRightSquareBracketKeyword_8());
                

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
            pushFollow(FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1321);
            iv_ruleReqSpecFolder=ruleReqSpecFolder();

            state._fsp--;

             current =iv_ruleReqSpecFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecFolder1331); 

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
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleReqSpecFolder1369); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:767:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:769:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecFolder1385); 

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
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==Colon) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:786:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleReqSpecFolder1404); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecFolderAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:790:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:791:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:791:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:792:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleReqSpecFolder1424);
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

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1439); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:813:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Requirement||LA21_0==Folder||LA21_0==Goal) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:814:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:814:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:815:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:815:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleReqSpecFolder )
            	    int alt20=3;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt20=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt20=2;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt20=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt20) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:816:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecFolder1461);
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
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecFolder1480);
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
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1499);
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
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1516); 

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
            pushFollow(FOLLOW_ruleGoalFolder_in_entryRuleGoalFolder1550);
            iv_ruleGoalFolder=ruleGoalFolder();

            state._fsp--;

             current =iv_ruleGoalFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalFolder1560); 

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
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleGoalFolder1598); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:895:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:897:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoalFolder1614); 

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
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==Colon) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:914:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoalFolder1633); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalFolderAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:918:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:920:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalFolderAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoalFolder1653);
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

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoalFolder1668); 

                	newLeafNode(otherlv_4, grammarAccess.getGoalFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:941:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==Folder||LA24_0==Goal) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:942:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:942:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:943:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:943:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleGoalFolder )
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==Goal) ) {
            	        alt23=1;
            	    }
            	    else if ( (LA23_0==Folder) ) {
            	        alt23=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:944:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getGoalFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleGoalFolder1690);
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
            	            	    
            	            pushFollow(FOLLOW_ruleGoalFolder_in_ruleGoalFolder1709);
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
            	    break loop24;
                }
            } while (true);

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoalFolder1726); 

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
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal1760);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal1770); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:999:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_39= RightSquareBracket ) ;
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
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        AntlrDatatypeRuleToken lv_targetDescription_6_0 = null;

        EObject lv_description_12_0 = null;

        AntlrDatatypeRuleToken lv_rationale_14_0 = null;

        EObject lv_docReference_36_0 = null;

        EObject lv_docReference_38_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1002:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_39= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1003:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_39= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1003:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_39= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1004:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_39= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal1808); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1008:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1009:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1009:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1010:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1824); 

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
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==Colon) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1027:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoal1843); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1031:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1032:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1032:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1033:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1863);
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
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==For) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1050:2: otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleGoal1879); 

                        	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:1: ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==RULE_ID) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==RULE_STRING) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
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
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1899); 

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
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleGoal1926);
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

            otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal1942); 

                	newLeafNode(otherlv_7, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1091:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1093:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1093:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1094:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1097:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1098:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1098:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop33:
            do {
                int alt33=9;
                alt33 = dfa33.predict(input);
                switch (alt33) {
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
            	    otherlv_9=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal2000); 

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
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal2022);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1132:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1132:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1133:5: {...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1133:101: ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1134:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1137:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1137:7: {...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1137:16: (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1138:2: otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) )
            	    {
            	    otherlv_11=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal2091); 

            	        	newLeafNode(otherlv_11, grammarAccess.getGoalAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:1: ( (lv_description_12_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:1: (lv_description_12_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:1: (lv_description_12_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1144:3: lv_description_12_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionMultiLineStringParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleGoal2111);
            	    lv_description_12_0=ruleMultiLineString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_12_0, 
            	            		"MultiLineString");
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
            	    otherlv_13=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal2180); 

            	        	newLeafNode(otherlv_13, grammarAccess.getGoalAccess().getRationaleKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1177:1: ( (lv_rationale_14_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1178:1: (lv_rationale_14_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1178:1: (lv_rationale_14_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1179:3: lv_rationale_14_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleValueStringParserRuleCall_5_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleGoal2200);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1202:4: ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1202:4: ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:5: {...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:101: ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1204:6: ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1207:6: ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1207:7: {...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1207:16: (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1208:2: otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_15=(Token)match(input,Refines,FOLLOW_Refines_in_ruleGoal2269); 

            	        	newLeafNode(otherlv_15, grammarAccess.getGoalAccess().getRefinesKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1212:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1213:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1213:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1214:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2291);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1227:2: (otherlv_17= Comma ( ( ruleQualifiedName ) ) )*
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==Comma) ) {
            	            alt28=1;
            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1228:2: otherlv_17= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_17=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2305); 

            	    	        	newLeafNode(otherlv_17, grammarAccess.getGoalAccess().getCommaKeyword_5_3_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1232:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1233:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1233:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1234:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_3_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2327);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1254:4: ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1254:4: ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1255:5: {...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1255:101: ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1256:6: ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1259:6: ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1259:7: {...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1259:16: (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1260:2: otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_19=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2398); 

            	        	newLeafNode(otherlv_19, grammarAccess.getGoalAccess().getConflictsKeyword_5_4_0());
            	        
            	    otherlv_20=(Token)match(input,With,FOLLOW_With_in_ruleGoal2410); 

            	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getWithKeyword_5_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1269:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1270:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1270:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1271:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2432);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1284:2: (otherlv_22= Comma ( ( ruleQualifiedName ) ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==Comma) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1285:2: otherlv_22= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_22=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2446); 

            	    	        	newLeafNode(otherlv_22, grammarAccess.getGoalAccess().getCommaKeyword_5_4_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1289:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1290:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1290:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1291:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_4_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2468);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1311:4: ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1311:4: ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1312:5: {...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1312:101: ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1313:6: ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1316:6: ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1316:7: {...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1316:16: (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1317:2: otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_24=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2539); 

            	        	newLeafNode(otherlv_24, grammarAccess.getGoalAccess().getStakeholderKeyword_5_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1321:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1322:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1322:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1323:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2561);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1336:2: (otherlv_26= Comma ( ( ruleQualifiedName ) ) )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==Comma) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1337:2: otherlv_26= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_26=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2575); 

            	    	        	newLeafNode(otherlv_26, grammarAccess.getGoalAccess().getCommaKeyword_5_5_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1341:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1342:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1342:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1343:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2597);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1363:4: ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1363:4: ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1364:5: {...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1364:101: ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1365:6: ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1368:6: ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1368:7: {...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1368:16: (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1369:2: otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_28=(Token)match(input,See,FOLLOW_See_in_ruleGoal2668); 

            	        	newLeafNode(otherlv_28, grammarAccess.getGoalAccess().getSeeKeyword_5_6_0());
            	        
            	    otherlv_29=(Token)match(input,Documented,FOLLOW_Documented_in_ruleGoal2680); 

            	        	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getDocumentedKeyword_5_6_1());
            	        
            	    otherlv_30=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal2692); 

            	        	newLeafNode(otherlv_30, grammarAccess.getGoalAccess().getRequirementKeyword_5_6_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1383:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1384:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1384:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1385:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocumentRequirementContractualElementCrossReference_5_6_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2714);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1398:2: (otherlv_32= Comma ( ( ruleQualifiedName ) ) )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Comma) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1399:2: otherlv_32= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_32=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2728); 

            	    	        	newLeafNode(otherlv_32, grammarAccess.getGoalAccess().getCommaKeyword_5_6_4_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1403:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1404:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1404:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1405:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocumentRequirementContractualElementCrossReference_5_6_4_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2750);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop31;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1425:4: ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1425:4: ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1426:5: {...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1426:101: ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1427:6: ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1430:6: ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1430:7: {...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1430:16: (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1431:2: otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_34=(Token)match(input,See,FOLLOW_See_in_ruleGoal2821); 

            	        	newLeafNode(otherlv_34, grammarAccess.getGoalAccess().getSeeKeyword_5_7_0());
            	        
            	    otherlv_35=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal2833); 

            	        	newLeafNode(otherlv_35, grammarAccess.getGoalAccess().getDocumentKeyword_5_7_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1440:1: ( (lv_docReference_36_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1441:1: (lv_docReference_36_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1441:1: (lv_docReference_36_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1442:3: lv_docReference_36_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_7_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal2853);
            	    lv_docReference_36_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_36_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1458:2: (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Comma) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1459:2: otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_37=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2867); 

            	    	        	newLeafNode(otherlv_37, grammarAccess.getGoalAccess().getCommaKeyword_5_7_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1463:1: ( (lv_docReference_38_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1464:1: (lv_docReference_38_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1464:1: (lv_docReference_38_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1465:3: lv_docReference_38_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_7_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal2887);
            	    	    lv_docReference_38_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_38_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop32;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	

            }

            otherlv_39=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal2943); 

                	newLeafNode(otherlv_39, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1508:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1510:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement2977);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement2987); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1517:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_48= RightSquareBracket ) ;
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
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token otherlv_48=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        AntlrDatatypeRuleToken lv_targetDescription_6_0 = null;

        EObject lv_description_12_0 = null;

        EObject lv_constants_14_0 = null;

        EObject lv_assert_16_0 = null;

        AntlrDatatypeRuleToken lv_exceptionText_26_0 = null;

        EObject lv_docReference_45_0 = null;

        EObject lv_docReference_47_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1520:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_48= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1521:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_48= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1521:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_48= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1522:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )? otherlv_7= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_48= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement3025); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1526:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1527:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1527:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1528:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3041); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1544:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==Colon) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1545:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleRequirement3060); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1549:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1550:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1550:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1551:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3080);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1567:4: (otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==For) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1568:2: otherlv_4= For ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleRequirement3096); 

                        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1572:1: ( ( (otherlv_5= RULE_ID ) ) | ( (lv_targetDescription_6_0= ruleValueString ) ) )
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_ID) ) {
                        alt35=1;
                    }
                    else if ( (LA35_0==RULE_STRING) ) {
                        alt35=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 35, 0, input);

                        throw nvae;
                    }
                    switch (alt35) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1572:2: ( (otherlv_5= RULE_ID ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1572:2: ( (otherlv_5= RULE_ID ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1573:1: (otherlv_5= RULE_ID )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1573:1: (otherlv_5= RULE_ID )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1574:3: otherlv_5= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getRequirementRule());
                            	        }
                                    
                            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3116); 

                            		newLeafNode(otherlv_5, grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_3_1_0_0()); 
                            	

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1586:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1586:6: ( (lv_targetDescription_6_0= ruleValueString ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1587:1: (lv_targetDescription_6_0= ruleValueString )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1587:1: (lv_targetDescription_6_0= ruleValueString )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1588:3: lv_targetDescription_6_0= ruleValueString
                            {
                             
                            	        newCompositeNode(grammarAccess.getRequirementAccess().getTargetDescriptionValueStringParserRuleCall_3_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3143);
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

            otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3159); 

                	newLeafNode(otherlv_7, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1609:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1611:1: ( ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1612:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1615:2: ( ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1616:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1616:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop44:
            do {
                int alt44=12;
                alt44 = dfa44.predict(input);
                switch (alt44) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1618:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1618:4: ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1619:5: {...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1619:108: ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1620:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1623:6: ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1623:7: {...}? => (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1623:16: (otherlv_9= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1624:2: otherlv_9= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_9=(Token)match(input,Category,FOLLOW_Category_in_ruleRequirement3217); 

            	        	newLeafNode(otherlv_9, grammarAccess.getRequirementAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1628:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1629:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1629:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1630:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3239);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1650:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1650:4: ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1651:5: {...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1651:108: ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1652:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1655:6: ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1655:7: {...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1655:16: (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1656:2: otherlv_11= Description ( (lv_description_12_0= ruleDescription ) )
            	    {
            	    otherlv_11=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3308); 

            	        	newLeafNode(otherlv_11, grammarAccess.getRequirementAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1660:1: ( (lv_description_12_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1661:1: (lv_description_12_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1661:1: (lv_description_12_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1662:3: lv_description_12_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3328);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1685:4: ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1685:4: ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1686:5: {...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1686:108: ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1687:6: ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1690:6: ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1690:7: {...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1690:16: (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1691:2: otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+
            	    {
            	    otherlv_13=(Token)match(input,Constants,FOLLOW_Constants_in_ruleRequirement3397); 

            	        	newLeafNode(otherlv_13, grammarAccess.getRequirementAccess().getConstantsKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1695:1: ( (lv_constants_14_0= ruleFinalValue ) )+
            	    int cnt37=0;
            	    loop37:
            	    do {
            	        int alt37=2;
            	        int LA37_0 = input.LA(1);

            	        if ( (LA37_0==RULE_ID) ) {
            	            alt37=1;
            	        }


            	        switch (alt37) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1696:1: (lv_constants_14_0= ruleFinalValue )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1696:1: (lv_constants_14_0= ruleFinalValue )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1697:3: lv_constants_14_0= ruleFinalValue
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getConstantsFinalValueParserRuleCall_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleFinalValue_in_ruleRequirement3417);
            	    	    lv_constants_14_0=ruleFinalValue();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"constants",
            	    	            		lv_constants_14_0, 
            	    	            		"FinalValue");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt37 >= 1 ) break loop37;
            	                EarlyExitException eee =
            	                    new EarlyExitException(37, input);
            	                throw eee;
            	        }
            	        cnt37++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1720:4: ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1720:4: ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1721:5: {...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1721:108: ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1722:6: ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1725:6: ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1725:7: {...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1725:16: (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1726:2: otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) )
            	    {
            	    otherlv_15=(Token)match(input,Assert,FOLLOW_Assert_in_ruleRequirement3487); 

            	        	newLeafNode(otherlv_15, grammarAccess.getRequirementAccess().getAssertKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1730:1: ( (lv_assert_16_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1731:1: (lv_assert_16_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1731:1: (lv_assert_16_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1732:3: lv_assert_16_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertPredicateExpressionParserRuleCall_5_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleRequirement3507);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1755:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1755:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1756:5: {...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1756:108: ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1757:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1760:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1760:7: {...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1760:16: (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1761:2: otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) )
            	    {
            	    otherlv_17=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement3576); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getRationaleKeyword_5_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1765:1: ( (lv_rationale_18_0= RULE_STRING ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1766:1: (lv_rationale_18_0= RULE_STRING )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1766:1: (lv_rationale_18_0= RULE_STRING )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1767:3: lv_rationale_18_0= RULE_STRING
            	    {
            	    lv_rationale_18_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRequirement3592); 

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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1790:4: ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1790:4: ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1791:5: {...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1791:108: ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1792:6: ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1795:6: ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1795:7: {...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1795:16: (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1796:2: otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_19=(Token)match(input,See,FOLLOW_See_in_ruleRequirement3666); 

            	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getSeeKeyword_5_5_0());
            	        
            	    otherlv_20=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement3678); 

            	        	newLeafNode(otherlv_20, grammarAccess.getRequirementAccess().getGoalKeyword_5_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1805:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1806:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1806:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1807:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_5_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3700);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1820:2: (otherlv_22= Comma ( ( ruleQualifiedName ) ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Comma) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1821:2: otherlv_22= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_22=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement3714); 

            	    	        	newLeafNode(otherlv_22, grammarAccess.getRequirementAccess().getCommaKeyword_5_5_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1825:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1826:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1826:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1827:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_5_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3736);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop38;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1847:4: ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1847:4: ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1848:5: {...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1848:108: ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1849:6: ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1852:6: ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1852:7: {...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1852:16: (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1853:2: otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) )
            	    {
            	    otherlv_24=(Token)match(input,Mitigates,FOLLOW_Mitigates_in_ruleRequirement3807); 

            	        	newLeafNode(otherlv_24, grammarAccess.getRequirementAccess().getMitigatesKeyword_5_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1857:1: ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) )
            	    int alt39=2;
            	    int LA39_0 = input.LA(1);

            	    if ( (LA39_0==RULE_ID) ) {
            	        alt39=1;
            	    }
            	    else if ( (LA39_0==RULE_STRING) ) {
            	        alt39=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt39) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1857:2: ( (otherlv_25= RULE_ID ) )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1857:2: ( (otherlv_25= RULE_ID ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1858:1: (otherlv_25= RULE_ID )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1858:1: (otherlv_25= RULE_ID )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1859:3: otherlv_25= RULE_ID
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getRequirementRule());
            	            	        }
            	                    
            	            otherlv_25=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3827); 

            	            		newLeafNode(otherlv_25, grammarAccess.getRequirementAccess().getExceptionEObjectCrossReference_5_6_1_0_0()); 
            	            	

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1871:6: ( (lv_exceptionText_26_0= ruleValueString ) )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1871:6: ( (lv_exceptionText_26_0= ruleValueString ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1872:1: (lv_exceptionText_26_0= ruleValueString )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1872:1: (lv_exceptionText_26_0= ruleValueString )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1873:3: lv_exceptionText_26_0= ruleValueString
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getRequirementAccess().getExceptionTextValueStringParserRuleCall_5_6_1_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3854);
            	            lv_exceptionText_26_0=ruleValueString();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	            	        }
            	                   		set(
            	                   			current, 
            	                   			"exceptionText",
            	                    		lv_exceptionText_26_0, 
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:4: ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:4: ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1897:5: {...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1897:108: ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1898:6: ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1901:6: ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1901:7: {...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1901:16: (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1902:2: otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_27=(Token)match(input,Refines,FOLLOW_Refines_in_ruleRequirement3924); 

            	        	newLeafNode(otherlv_27, grammarAccess.getRequirementAccess().getRefinesKeyword_5_7_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1906:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1907:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1907:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1908:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinedReferenceRequirementCrossReference_5_7_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3946);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1921:2: (otherlv_29= Comma ( ( ruleQualifiedName ) ) )*
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==Comma) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1922:2: otherlv_29= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_29=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement3960); 

            	    	        	newLeafNode(otherlv_29, grammarAccess.getRequirementAccess().getCommaKeyword_5_7_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1927:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1927:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1928:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_5_7_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3982);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop40;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1948:4: ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1948:4: ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:5: {...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1949:108: ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1950:6: ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:6: ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:7: {...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:16: (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1954:2: otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_31=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4053); 

            	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getSeeKeyword_5_8_0());
            	        
            	    otherlv_32=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleRequirement4065); 

            	        	newLeafNode(otherlv_32, grammarAccess.getRequirementAccess().getStakeholderKeyword_5_8_1());
            	        
            	    otherlv_33=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4077); 

            	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getGoalKeyword_5_8_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1968:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1969:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1969:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1970:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_5_8_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4099);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:2: (otherlv_35= Comma ( ( ruleQualifiedName ) ) )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==Comma) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1984:2: otherlv_35= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_35=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4113); 

            	    	        	newLeafNode(otherlv_35, grammarAccess.getRequirementAccess().getCommaKeyword_5_8_4_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1988:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1989:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1989:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1990:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_5_8_4_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4135);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop41;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2010:4: ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2010:4: ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2011:5: {...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2011:108: ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2012:6: ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2015:6: ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2015:7: {...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2015:16: (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2016:2: otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_37=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4206); 

            	        	newLeafNode(otherlv_37, grammarAccess.getRequirementAccess().getSeeKeyword_5_9_0());
            	        
            	    otherlv_38=(Token)match(input,Documented,FOLLOW_Documented_in_ruleRequirement4218); 

            	        	newLeafNode(otherlv_38, grammarAccess.getRequirementAccess().getDocumentedKeyword_5_9_1());
            	        
            	    otherlv_39=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement4230); 

            	        	newLeafNode(otherlv_39, grammarAccess.getRequirementAccess().getRequirementKeyword_5_9_2());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2030:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2031:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2031:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2032:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocumentRequirementContractualElementCrossReference_5_9_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4252);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2045:2: (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    loop42:
            	    do {
            	        int alt42=2;
            	        int LA42_0 = input.LA(1);

            	        if ( (LA42_0==Comma) ) {
            	            alt42=1;
            	        }


            	        switch (alt42) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2046:2: otherlv_41= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4266); 

            	    	        	newLeafNode(otherlv_41, grammarAccess.getRequirementAccess().getCommaKeyword_5_9_4_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2050:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2051:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2051:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2052:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocumentRequirementContractualElementCrossReference_5_9_4_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4288);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop42;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2072:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2072:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2073:5: {...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2073:109: ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2074:6: ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2077:6: ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2077:7: {...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2077:16: (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2078:2: otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_43=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4359); 

            	        	newLeafNode(otherlv_43, grammarAccess.getRequirementAccess().getSeeKeyword_5_10_0());
            	        
            	    otherlv_44=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement4371); 

            	        	newLeafNode(otherlv_44, grammarAccess.getRequirementAccess().getDocumentKeyword_5_10_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2087:1: ( (lv_docReference_45_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2088:1: (lv_docReference_45_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2088:1: (lv_docReference_45_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2089:3: lv_docReference_45_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_10_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4391);
            	    lv_docReference_45_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_45_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2105:2: (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )*
            	    loop43:
            	    do {
            	        int alt43=2;
            	        int LA43_0 = input.LA(1);

            	        if ( (LA43_0==Comma) ) {
            	            alt43=1;
            	        }


            	        switch (alt43) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2106:2: otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_46=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4405); 

            	    	        	newLeafNode(otherlv_46, grammarAccess.getRequirementAccess().getCommaKeyword_5_10_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2110:1: ( (lv_docReference_47_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2111:1: (lv_docReference_47_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2111:1: (lv_docReference_47_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2112:3: lv_docReference_47_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_10_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4425);
            	    	    lv_docReference_47_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_47_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop43;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	

            }

            otherlv_48=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement4481); 

                	newLeafNode(otherlv_48, grammarAccess.getRequirementAccess().getRightSquareBracketKeyword_6());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2155:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2156:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2157:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument4515);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument4525); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2164:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2167:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2168:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2168:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2168:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2168:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2169:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2169:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2170:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument4571);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2186:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==NumberSign) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2187:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument4585); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2191:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2192:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2192:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2193:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument4605);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2217:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2218:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2219:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH4643);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH4654); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2226:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2230:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2231:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2231:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2231:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2231:2: (this_ID_0= RULE_ID kw= Solidus )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    int LA46_1 = input.LA(2);

                    if ( (LA46_1==Solidus) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2231:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4695); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH4713); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4730); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH4748); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH4763); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2272:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2273:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2274:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT4808);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT4819); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2281:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2285:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2286:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2286:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2286:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4859); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2293:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==FullStop) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2294:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT4878); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4893); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop47;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2316:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2317:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2318:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription4941);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription4951); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2325:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2328:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2329:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2329:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==This||LA48_0==Ampersand||LA48_0==RULE_ID||LA48_0==RULE_STRING) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2330:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2330:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2331:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription4996);
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
            	    if ( cnt48 >= 1 ) break loop48;
                        EarlyExitException eee =
                            new EarlyExitException(48, input);
                        throw eee;
                }
                cnt48++;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2355:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2356:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2357:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement5031);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement5041); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2364:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;
        Token lv_newline_2_0=null;
        Token lv_thisTarget_3_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2367:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) | ( (lv_newline_2_0= Ampersand ) ) | ( (lv_thisTarget_3_0= This ) ) )
            int alt49=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt49=1;
                }
                break;
            case RULE_ID:
                {
                alt49=2;
                }
                break;
            case Ampersand:
                {
                alt49=3;
                }
                break;
            case This:
                {
                alt49=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2369:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2369:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2370:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement5083); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2387:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2387:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2388:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2388:1: (otherlv_1= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2389:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement5114); 

                    		newLeafNode(otherlv_1, grammarAccess.getDescriptionElementAccess().getRefEObjectCrossReference_1_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2401:6: ( (lv_newline_2_0= Ampersand ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2401:6: ( (lv_newline_2_0= Ampersand ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2402:1: (lv_newline_2_0= Ampersand )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2402:1: (lv_newline_2_0= Ampersand )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2403:3: lv_newline_2_0= Ampersand
                    {
                    lv_newline_2_0=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_ruleDescriptionElement5139); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2418:6: ( (lv_thisTarget_3_0= This ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2418:6: ( (lv_thisTarget_3_0= This ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2419:1: (lv_thisTarget_3_0= This )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2419:1: (lv_thisTarget_3_0= This )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2420:3: lv_thisTarget_3_0= This
                    {
                    lv_thisTarget_3_0=(Token)match(input,This,FOLLOW_This_in_ruleDescriptionElement5175); 

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


    // $ANTLR start "entryRuleReferencePath"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2442:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2443:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2444:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath5221);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath5231); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2451:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2454:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2455:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2455:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2455:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2455:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2456:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2456:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2457:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath5276); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2468:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2469:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath5290); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2473:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2474:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2474:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2475:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath5310);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2499:1: entryRulePredicateExpression returns [EObject current=null] : iv_rulePredicateExpression= rulePredicateExpression EOF ;
    public final EObject entryRulePredicateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateExpression = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2500:2: (iv_rulePredicateExpression= rulePredicateExpression EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2501:2: iv_rulePredicateExpression= rulePredicateExpression EOF
            {
             newCompositeNode(grammarAccess.getPredicateExpressionRule()); 
            pushFollow(FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression5346);
            iv_rulePredicateExpression=rulePredicateExpression();

            state._fsp--;

             current =iv_rulePredicateExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePredicateExpression5356); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2508:1: rulePredicateExpression returns [EObject current=null] : (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2511:28: ( (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2512:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2512:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2512:2: this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression5392); 
             
                newLeafNode(this_ID_0, grammarAccess.getPredicateExpressionAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2516:1: ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2517:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2517:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2518:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2518:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            int alt50=6;
            switch ( input.LA(1) ) {
            case EqualsSign:
                {
                alt50=1;
                }
                break;
            case ExclamationMarkEqualsSign:
                {
                alt50=2;
                }
                break;
            case LessThanSign:
                {
                alt50=3;
                }
                break;
            case EqualsSignLessThanSign:
                {
                alt50=4;
                }
                break;
            case GreaterThanSign:
                {
                alt50=5;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt50=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2519:3: lv_op_1_1= EqualsSign
                    {
                    lv_op_1_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_rulePredicateExpression5412); 

                            newLeafNode(lv_op_1_1, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2532:8: lv_op_1_2= ExclamationMarkEqualsSign
                    {
                    lv_op_1_2=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression5440); 

                            newLeafNode(lv_op_1_2, grammarAccess.getPredicateExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:8: lv_op_1_3= LessThanSign
                    {
                    lv_op_1_3=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_rulePredicateExpression5468); 

                            newLeafNode(lv_op_1_3, grammarAccess.getPredicateExpressionAccess().getOpLessThanSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2558:8: lv_op_1_4= EqualsSignLessThanSign
                    {
                    lv_op_1_4=(Token)match(input,EqualsSignLessThanSign,FOLLOW_EqualsSignLessThanSign_in_rulePredicateExpression5496); 

                            newLeafNode(lv_op_1_4, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignLessThanSignKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2571:8: lv_op_1_5= GreaterThanSign
                    {
                    lv_op_1_5=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_rulePredicateExpression5524); 

                            newLeafNode(lv_op_1_5, grammarAccess.getPredicateExpressionAccess().getOpGreaterThanSignKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2584:8: lv_op_1_6= GreaterThanSignEqualsSign
                    {
                    lv_op_1_6=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression5552); 

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression5577); 
             
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


    // $ANTLR start "entryRuleFinalValue"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2612:1: entryRuleFinalValue returns [EObject current=null] : iv_ruleFinalValue= ruleFinalValue EOF ;
    public final EObject entryRuleFinalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinalValue = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2613:2: (iv_ruleFinalValue= ruleFinalValue EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2614:2: iv_ruleFinalValue= ruleFinalValue EOF
            {
             newCompositeNode(grammarAccess.getFinalValueRule()); 
            pushFollow(FOLLOW_ruleFinalValue_in_entryRuleFinalValue5611);
            iv_ruleFinalValue=ruleFinalValue();

            state._fsp--;

             current =iv_ruleFinalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFinalValue5621); 

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
    // $ANTLR end "entryRuleFinalValue"


    // $ANTLR start "ruleFinalValue"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2621:1: ruleFinalValue returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) ;
    public final EObject ruleFinalValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2624:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2625:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2625:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2625:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2625:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2626:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2626:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2627:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFinalValue5663); 

            			newLeafNode(lv_name_0_0, grammarAccess.getFinalValueAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFinalValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleFinalValue5681); 

                	newLeafNode(otherlv_1, grammarAccess.getFinalValueAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2648:1: ( (lv_value_2_0= ruleValueString ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2649:1: (lv_value_2_0= ruleValueString )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2649:1: (lv_value_2_0= ruleValueString )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2650:3: lv_value_2_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getFinalValueAccess().getValueValueStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleFinalValue5701);
            lv_value_2_0=ruleValueString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getFinalValueRule());
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
    // $ANTLR end "ruleFinalValue"


    // $ANTLR start "entryRuleMultiLineString"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2674:1: entryRuleMultiLineString returns [EObject current=null] : iv_ruleMultiLineString= ruleMultiLineString EOF ;
    public final EObject entryRuleMultiLineString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiLineString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2675:2: (iv_ruleMultiLineString= ruleMultiLineString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2676:2: iv_ruleMultiLineString= ruleMultiLineString EOF
            {
             newCompositeNode(grammarAccess.getMultiLineStringRule()); 
            pushFollow(FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString5736);
            iv_ruleMultiLineString=ruleMultiLineString();

            state._fsp--;

             current =iv_ruleMultiLineString; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiLineString5746); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2683:1: ruleMultiLineString returns [EObject current=null] : ( (lv_description_0_0= ruleTextElement ) )+ ;
    public final EObject ruleMultiLineString() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2686:28: ( ( (lv_description_0_0= ruleTextElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2687:1: ( (lv_description_0_0= ruleTextElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2687:1: ( (lv_description_0_0= ruleTextElement ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==Ampersand||LA51_0==RULE_STRING) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2688:1: (lv_description_0_0= ruleTextElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2688:1: (lv_description_0_0= ruleTextElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2689:3: lv_description_0_0= ruleTextElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMultiLineStringAccess().getDescriptionTextElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTextElement_in_ruleMultiLineString5791);
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
    // $ANTLR end "ruleMultiLineString"


    // $ANTLR start "entryRuleTextElement"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2713:1: entryRuleTextElement returns [EObject current=null] : iv_ruleTextElement= ruleTextElement EOF ;
    public final EObject entryRuleTextElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTextElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2714:2: (iv_ruleTextElement= ruleTextElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2715:2: iv_ruleTextElement= ruleTextElement EOF
            {
             newCompositeNode(grammarAccess.getTextElementRule()); 
            pushFollow(FOLLOW_ruleTextElement_in_entryRuleTextElement5826);
            iv_ruleTextElement=ruleTextElement();

            state._fsp--;

             current =iv_ruleTextElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTextElement5836); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2722:1: ruleTextElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) ) ;
    public final EObject ruleTextElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_newline_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2725:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2726:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2726:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (lv_newline_1_0= Ampersand ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_STRING) ) {
                alt52=1;
            }
            else if ( (LA52_0==Ampersand) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2726:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2726:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2727:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2727:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2728:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleTextElement5878); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2745:6: ( (lv_newline_1_0= Ampersand ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2745:6: ( (lv_newline_1_0= Ampersand ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2746:1: (lv_newline_1_0= Ampersand )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2746:1: (lv_newline_1_0= Ampersand )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2747:3: lv_newline_1_0= Ampersand
                    {
                    lv_newline_1_0=(Token)match(input,Ampersand,FOLLOW_Ampersand_in_ruleTextElement5908); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2769:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2770:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2771:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString5955);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString5966); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2778:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2782:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2783:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString6005); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2798:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2799:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2800:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6049);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference6060); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2807:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2811:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2812:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2812:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2812:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2812:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_ID) ) {
                    int LA53_1 = input.LA(2);

                    if ( (LA53_1==ColonColon) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2812:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6101); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference6119); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6136); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2832:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==FullStop) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2833:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference6155); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6170); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2853:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2854:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2855:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef6217);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef6228); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2862:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2866:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2867:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef6267); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2882:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2883:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2884:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6311);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName6322); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2891:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2895:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2896:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2896:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2896:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6362); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2903:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( (LA55_0==FullStop) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2904:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName6381); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName6396); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop55;
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


    protected DFA33 dfa33 = new DFA33(this);
    protected DFA44 dfa44 = new DFA44(this);
    static final String DFA33_eotS =
        "\13\uffff";
    static final String DFA33_eofS =
        "\13\uffff";
    static final String DFA33_minS =
        "\1\6\7\uffff\1\11\2\uffff";
    static final String DFA33_maxS =
        "\1\51\7\uffff\1\17\2\uffff";
    static final String DFA33_acceptS =
        "\1\uffff\1\11\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\7";
    static final String DFA33_specialS =
        "\1\1\7\uffff\1\0\2\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\3\1\uffff\1\7\1\uffff\1\6\2\uffff\1\4\1\2\1\uffff\1\5\10"+
            "\uffff\1\10\17\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\12\5\uffff\1\11",
            "",
            ""
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
            return "()* loopback of 1098:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Rationale ( (lv_rationale_14_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Refines ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Conflicts otherlv_20= With ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_28= See otherlv_29= Documented otherlv_30= Requirement ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= See otherlv_35= Document ( (lv_docReference_36_0= ruleExternalDocument ) ) (otherlv_37= Comma ( (lv_docReference_38_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA33_8 = input.LA(1);

                         
                        int index33_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA33_8 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( LA33_8 ==Documented && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {s = 10;}

                         
                        input.seek(index33_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA33_0 = input.LA(1);

                         
                        int index33_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA33_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA33_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA33_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA33_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA33_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA33_0 ==Conflicts && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA33_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA33_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) ) {s = 8;}

                         
                        input.seek(index33_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 33, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA44_eotS =
        "\16\uffff";
    static final String DFA44_eofS =
        "\16\uffff";
    static final String DFA44_minS =
        "\1\6\6\uffff\1\10\6\uffff";
    static final String DFA44_maxS =
        "\1\51\6\uffff\1\25\6\uffff";
    static final String DFA44_acceptS =
        "\1\uffff\1\14\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\12\1\11\1"+
        "\6\1\13";
    static final String DFA44_specialS =
        "\1\1\6\uffff\1\0\6\uffff}>";
    static final String[] DFA44_transitionS = {
            "\1\3\4\uffff\1\4\1\10\1\6\1\2\1\uffff\1\11\1\uffff\1\5\6\uffff"+
            "\1\7\17\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\13\1\12\5\uffff\1\15\5\uffff\1\14",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "()* loopback of 1616:3: ( ({...}? => ( ({...}? => (otherlv_9= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_11= Description ( (lv_description_12_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_13= Constants ( (lv_constants_14_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Assert ( (lv_assert_16_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= See otherlv_20= Goal ( ( ruleQualifiedName ) ) (otherlv_22= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_24= Mitigates ( ( (otherlv_25= RULE_ID ) ) | ( (lv_exceptionText_26_0= ruleValueString ) ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Refines ( ( ruleQualifiedName ) ) (otherlv_29= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_31= See otherlv_32= Stakeholder otherlv_33= Goal ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= See otherlv_38= Documented otherlv_39= Requirement ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Document ( (lv_docReference_45_0= ruleExternalDocument ) ) (otherlv_46= Comma ( (lv_docReference_47_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_7 = input.LA(1);

                         
                        int index44_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA44_7 ==Documented && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) {s = 10;}

                        else if ( LA44_7 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) ) {s = 11;}

                        else if ( LA44_7 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) {s = 12;}

                        else if ( LA44_7 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) ) {s = 13;}

                         
                        input.seek(index44_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA44_0 = input.LA(1);

                         
                        int index44_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA44_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA44_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA44_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA44_0 ==Constants && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA44_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA44_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA44_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) ) {s = 7;}

                        else if ( LA44_0 ==Mitigates && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA44_0 ==Refines && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                         
                        input.seek(index44_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleReqSpec_in_entryRuleReqSpec67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpec77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecs_in_ruleReqSpec124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholderGoals_in_ruleReqSpec143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_ruleReqSpec162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholderGoals_in_entryRuleStakeholderGoals205 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholderGoals215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleStakeholderGoals253 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_Goals_in_ruleStakeholderGoals265 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholderGoals281 = new BitSet(new long[]{0x0000011001000040L});
    public static final BitSet FOLLOW_Colon_in_ruleStakeholderGoals300 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholderGoals320 = new BitSet(new long[]{0x0000010001000040L});
    public static final BitSet FOLLOW_For_in_ruleStakeholderGoals336 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleStakeholderGoals359 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleStakeholderGoals386 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_Description_in_ruleStakeholderGoals403 = new BitSet(new long[]{0x0000100100000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleStakeholderGoals423 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals438 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleStakeholderGoals460 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleStakeholderGoals473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_entryRuleReqDocument507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqDocument517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Document_in_ruleReqDocument555 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqDocument571 = new BitSet(new long[]{0x0000011000000040L});
    public static final BitSet FOLLOW_Colon_in_ruleReqDocument590 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqDocument610 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_Description_in_ruleReqDocument626 = new BitSet(new long[]{0x0000100100000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqDocument646 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqDocument661 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_ruleReqDocument681 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqDocument694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_entryRuleDocumentSection728 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDocumentSection738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Section_in_ruleDocumentSection776 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDocumentSection792 = new BitSet(new long[]{0x0000011000000040L});
    public static final BitSet FOLLOW_Colon_in_ruleDocumentSection811 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleDocumentSection831 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_Description_in_ruleDocumentSection847 = new BitSet(new long[]{0x0000100100000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleDocumentSection867 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleDocumentSection882 = new BitSet(new long[]{0x0000020000220080L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleDocumentSection904 = new BitSet(new long[]{0x0000020000220080L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleDocumentSection923 = new BitSet(new long[]{0x0000020000220080L});
    public static final BitSet FOLLOW_ruleDocumentSection_in_ruleDocumentSection942 = new BitSet(new long[]{0x0000020000220080L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleDocumentSection959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecs_in_entryRuleReqSpecs993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecs1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirements_in_ruleReqSpecs1041 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Specification_in_ruleReqSpecs1053 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecs1069 = new BitSet(new long[]{0x0000011001000000L});
    public static final BitSet FOLLOW_Colon_in_ruleReqSpecs1088 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecs1108 = new BitSet(new long[]{0x0000010001000000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecs1124 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecs1147 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecs1174 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecs1190 = new BitSet(new long[]{0x0000020000080880L});
    public static final BitSet FOLLOW_Constants_in_ruleReqSpecs1203 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleFinalValue_in_ruleReqSpecs1223 = new BitSet(new long[]{0x0000060000080080L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecs1249 = new BitSet(new long[]{0x0000020000080080L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecs1268 = new BitSet(new long[]{0x0000020000080080L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecs1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1321 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecFolder1331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleReqSpecFolder1369 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecFolder1385 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_Colon_in_ruleReqSpecFolder1404 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleReqSpecFolder1424 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1439 = new BitSet(new long[]{0x0000020000280080L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecFolder1461 = new BitSet(new long[]{0x0000020000280080L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecFolder1480 = new BitSet(new long[]{0x0000020000280080L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1499 = new BitSet(new long[]{0x0000020000280080L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalFolder_in_entryRuleGoalFolder1550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalFolder1560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleGoalFolder1598 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoalFolder1614 = new BitSet(new long[]{0x0000011000000000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoalFolder1633 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoalFolder1653 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoalFolder1668 = new BitSet(new long[]{0x0000020000280000L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoalFolder1690 = new BitSet(new long[]{0x0000020000280000L});
    public static final BitSet FOLLOW_ruleGoalFolder_in_ruleGoalFolder1709 = new BitSet(new long[]{0x0000020000280000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoalFolder1726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal1760 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal1808 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1824 = new BitSet(new long[]{0x0000011001000000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoal1843 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1863 = new BitSet(new long[]{0x0000010001000000L});
    public static final BitSet FOLLOW_For_in_ruleGoal1879 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1899 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1926 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal1942 = new BitSet(new long[]{0x0000020002016540L});
    public static final BitSet FOLLOW_Category_in_ruleGoal2000 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal2022 = new BitSet(new long[]{0x0000020002016540L});
    public static final BitSet FOLLOW_Description_in_ruleGoal2091 = new BitSet(new long[]{0x0000100100000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleGoal2111 = new BitSet(new long[]{0x0000020002016540L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal2180 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal2200 = new BitSet(new long[]{0x0000020002016540L});
    public static final BitSet FOLLOW_Refines_in_ruleGoal2269 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2291 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2305 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2327 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2398 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_With_in_ruleGoal2410 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2432 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2446 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2468 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2539 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2561 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2575 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2597 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_See_in_ruleGoal2668 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Documented_in_ruleGoal2680 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal2692 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2714 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2728 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2750 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_See_in_ruleGoal2821 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal2833 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal2853 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2867 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal2887 = new BitSet(new long[]{0x0000020202016540L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal2943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement2977 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement2987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement3025 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3041 = new BitSet(new long[]{0x0000011001000000L});
    public static final BitSet FOLLOW_Colon_in_ruleRequirement3060 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3080 = new BitSet(new long[]{0x0000010001000000L});
    public static final BitSet FOLLOW_For_in_ruleRequirement3096 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3116 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3143 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3159 = new BitSet(new long[]{0x0000020002057840L});
    public static final BitSet FOLLOW_Category_in_ruleRequirement3217 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3239 = new BitSet(new long[]{0x0000020002057840L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3308 = new BitSet(new long[]{0x0000140100400000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3328 = new BitSet(new long[]{0x0000020002057840L});
    public static final BitSet FOLLOW_Constants_in_ruleRequirement3397 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleFinalValue_in_ruleRequirement3417 = new BitSet(new long[]{0x0000060002057840L});
    public static final BitSet FOLLOW_Assert_in_ruleRequirement3487 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleRequirement3507 = new BitSet(new long[]{0x0000020002057840L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement3576 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRequirement3592 = new BitSet(new long[]{0x0000020002057840L});
    public static final BitSet FOLLOW_See_in_ruleRequirement3666 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement3678 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3700 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement3714 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3736 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_Mitigates_in_ruleRequirement3807 = new BitSet(new long[]{0x0000140000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3827 = new BitSet(new long[]{0x0000020002057840L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3854 = new BitSet(new long[]{0x0000020002057840L});
    public static final BitSet FOLLOW_Refines_in_ruleRequirement3924 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3946 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement3960 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3982 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4053 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleRequirement4065 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4077 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4099 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4113 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4135 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4206 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_Documented_in_ruleRequirement4218 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement4230 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4252 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4266 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4288 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4359 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement4371 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4391 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4405 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4425 = new BitSet(new long[]{0x0000020202057840L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement4481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument4515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument4525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument4571 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument4585 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH4643 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH4654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4695 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH4713 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4730 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH4748 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT4808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT4819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4859 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT4878 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT4893 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription4941 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription4951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription4996 = new BitSet(new long[]{0x0000140100400002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement5031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement5041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement5114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ampersand_in_ruleDescriptionElement5139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_This_in_ruleDescriptionElement5175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath5221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath5231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath5276 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath5290 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath5310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression5346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePredicateExpression5356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression5392 = new BitSet(new long[]{0x000000E064000000L});
    public static final BitSet FOLLOW_EqualsSign_in_rulePredicateExpression5412 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression5440 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_LessThanSign_in_rulePredicateExpression5468 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_EqualsSignLessThanSign_in_rulePredicateExpression5496 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_GreaterThanSign_in_rulePredicateExpression5524 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression5552 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression5577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFinalValue_in_entryRuleFinalValue5611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFinalValue5621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFinalValue5663 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleFinalValue5681 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleFinalValue5701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString5736 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiLineString5746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_ruleMultiLineString5791 = new BitSet(new long[]{0x0000100100000002L});
    public static final BitSet FOLLOW_ruleTextElement_in_entryRuleTextElement5826 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTextElement5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleTextElement5878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ampersand_in_ruleTextElement5908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString5955 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString5966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString6005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference6060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6101 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference6119 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6136 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference6155 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef6217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef6228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef6267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName6311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName6322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6362 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName6381 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName6396 = new BitSet(new long[]{0x0000000400000002L});

}
