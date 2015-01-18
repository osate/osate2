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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Specification", "Description", "Requirement", "Stakeholder", "Decomposed", "Conflicts", "Constants", "Mitigated", "Rationale", "Category", "Document", "Evolved", "Evolves", "Library", "Refined", "Assert", "Folder", "Hazard", "Import", "Goals", "Goal", "With", "For", "See", "ExclamationMarkEqualsSign", "FullStopAsterisk", "ColonColon", "EqualsSignLessThanSign", "GreaterThanSignEqualsSign", "By", "To", "NumberSign", "Comma", "FullStop", "Solidus", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=45;
    public static final int Specification=4;
    public static final int Constants=10;
    public static final int Mitigated=11;
    public static final int Assert=19;
    public static final int Evolved=15;
    public static final int RULE_ANY_OTHER=51;
    public static final int RightSquareBracket=44;
    public static final int Requirement=6;
    public static final int Library=17;
    public static final int Solidus=38;
    public static final int EOF=-1;
    public static final int GreaterThanSign=42;
    public static final int FullStop=37;
    public static final int EqualsSignLessThanSign=31;
    public static final int Evolves=16;
    public static final int To=34;
    public static final int LessThanSign=40;
    public static final int RULE_INT=46;
    public static final int LeftSquareBracket=43;
    public static final int Conflicts=9;
    public static final int ExclamationMarkEqualsSign=28;
    public static final int Hazard=21;
    public static final int Stakeholder=7;
    public static final int Import=22;
    public static final int Decomposed=8;
    public static final int Refined=18;
    public static final int FullStopAsterisk=29;
    public static final int Colon=39;
    public static final int RULE_SL_COMMENT=49;
    public static final int For=26;
    public static final int NumberSign=35;
    public static final int Rationale=12;
    public static final int With=25;
    public static final int RULE_ML_COMMENT=48;
    public static final int Goal=24;
    public static final int Goals=23;
    public static final int By=33;
    public static final int ColonColon=30;
    public static final int Description=5;
    public static final int Document=14;
    public static final int Folder=20;
    public static final int RULE_STRING=47;
    public static final int See=27;
    public static final int GreaterThanSignEqualsSign=32;
    public static final int Category=13;
    public static final int RULE_WS=50;
    public static final int EqualsSign=41;
    public static final int Comma=36;

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:70:1: ruleReqSpec returns [EObject current=null] : ( ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) ) ) ;
    public final EObject ruleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_0_1 = null;

        EObject lv_contents_0_2 = null;

        EObject lv_contents_0_3 = null;

        EObject lv_contents_0_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:73:28: ( ( ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:1: ( ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:1: ( ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:1: ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:1: ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:76:1: (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:76:1: (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument )
            int alt1=4;
            switch ( input.LA(1) ) {
            case Library:
                {
                alt1=1;
                }
                break;
            case Specification:
                {
                alt1=2;
                }
                break;
            case Goals:
                {
                alt1=3;
                }
                break;
            case Document:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:77:3: lv_contents_0_1= ruleReqSpecLibrary
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecAccess().getContentsReqSpecLibraryParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleReqSpecLibrary_in_ruleReqSpec124);
                    lv_contents_0_1=ruleReqSpecLibrary();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecRule());
                    	        }
                           		add(
                           			current, 
                           			"contents",
                            		lv_contents_0_1, 
                            		"ReqSpecLibrary");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:92:8: lv_contents_0_2= ruleSystemSpec
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecAccess().getContentsSystemSpecParserRuleCall_0_1()); 
                    	    
                    pushFollow(FOLLOW_ruleSystemSpec_in_ruleReqSpec143);
                    lv_contents_0_2=ruleSystemSpec();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecRule());
                    	        }
                           		add(
                           			current, 
                           			"contents",
                            		lv_contents_0_2, 
                            		"SystemSpec");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:107:8: lv_contents_0_3= ruleStakeholderGoals
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecAccess().getContentsStakeholderGoalsParserRuleCall_0_2()); 
                    	    
                    pushFollow(FOLLOW_ruleStakeholderGoals_in_ruleReqSpec162);
                    lv_contents_0_3=ruleStakeholderGoals();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecRule());
                    	        }
                           		add(
                           			current, 
                           			"contents",
                            		lv_contents_0_3, 
                            		"StakeholderGoals");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }
                    break;
                case 4 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:122:8: lv_contents_0_4= ruleReqDocument
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecAccess().getContentsReqDocumentParserRuleCall_0_3()); 
                    	    
                    pushFollow(FOLLOW_ruleReqDocument_in_ruleReqSpec181);
                    lv_contents_0_4=ruleReqDocument();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecRule());
                    	        }
                           		add(
                           			current, 
                           			"contents",
                            		lv_contents_0_4, 
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


    // $ANTLR start "entryRuleSystemSpec"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:154:1: entryRuleSystemSpec returns [EObject current=null] : iv_ruleSystemSpec= ruleSystemSpec EOF ;
    public final EObject entryRuleSystemSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemSpec = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:155:2: (iv_ruleSystemSpec= ruleSystemSpec EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:156:2: iv_ruleSystemSpec= ruleSystemSpec EOF
            {
             newCompositeNode(grammarAccess.getSystemSpecRule()); 
            pushFollow(FOLLOW_ruleSystemSpec_in_entryRuleSystemSpec224);
            iv_ruleSystemSpec=ruleSystemSpec();

            state._fsp--;

             current =iv_ruleSystemSpec; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSystemSpec234); 

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
    // $ANTLR end "entryRuleSystemSpec"


    // $ANTLR start "ruleSystemSpec"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:163:1: ruleSystemSpec returns [EObject current=null] : (otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket ) ;
    public final EObject ruleSystemSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:166:28: ( (otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:167:1: (otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:167:1: (otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:168:2: otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Specification,FOLLOW_Specification_in_ruleSystemSpec272); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemSpecAccess().getSpecificationKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:172:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:173:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:173:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:174:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSystemSpec288); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSystemSpecAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemSpecRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleSystemSpec306); 

                	newLeafNode(otherlv_2, grammarAccess.getSystemSpecAccess().getForKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:195:1: ( ( ruleAadlClassifierReference ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:196:1: ( ruleAadlClassifierReference )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:196:1: ( ruleAadlClassifierReference )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:197:3: ruleAadlClassifierReference
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemSpecRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSystemSpecAccess().getTargetClassifierCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleSystemSpec328);
            ruleAadlClassifierReference();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleSystemSpec341); 

                	newLeafNode(otherlv_4, grammarAccess.getSystemSpecAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:215:1: ( ( ruleQualifiedName ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:216:1: ( ruleQualifiedName )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:216:1: ( ruleQualifiedName )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:217:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSystemSpecRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSystemSpecAccess().getConsistsOfReqSpecLibraryCrossReference_5_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSystemSpec363);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleSystemSpec376); 

                	newLeafNode(otherlv_6, grammarAccess.getSystemSpecAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleSystemSpec"


    // $ANTLR start "entryRuleStakeholderGoals"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:243:1: entryRuleStakeholderGoals returns [EObject current=null] : iv_ruleStakeholderGoals= ruleStakeholderGoals EOF ;
    public final EObject entryRuleStakeholderGoals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStakeholderGoals = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:244:2: (iv_ruleStakeholderGoals= ruleStakeholderGoals EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:245:2: iv_ruleStakeholderGoals= ruleStakeholderGoals EOF
            {
             newCompositeNode(grammarAccess.getStakeholderGoalsRule()); 
            pushFollow(FOLLOW_ruleStakeholderGoals_in_entryRuleStakeholderGoals410);
            iv_ruleStakeholderGoals=ruleStakeholderGoals();

            state._fsp--;

             current =iv_ruleStakeholderGoals; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStakeholderGoals420); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:252:1: ruleStakeholderGoals returns [EObject current=null] : (otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket ) ;
    public final EObject ruleStakeholderGoals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:255:28: ( (otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:256:1: (otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:256:1: (otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:257:2: otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goals,FOLLOW_Goals_in_ruleStakeholderGoals458); 

                	newLeafNode(otherlv_0, grammarAccess.getStakeholderGoalsAccess().getGoalsKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:261:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:262:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:262:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:263:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStakeholderGoals474); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStakeholderGoalsAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStakeholderGoalsRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals492); 

                	newLeafNode(otherlv_2, grammarAccess.getStakeholderGoalsAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:284:1: ( ( ruleQualifiedName ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:285:1: ( ruleQualifiedName )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:285:1: ( ruleQualifiedName )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:286:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getStakeholderGoalsRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getStakeholderGoalsAccess().getConsistsOfReqSpecLibraryCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleStakeholderGoals514);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleStakeholderGoals527); 

                	newLeafNode(otherlv_4, grammarAccess.getStakeholderGoalsAccess().getRightSquareBracketKeyword_4());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:312:1: entryRuleReqDocument returns [EObject current=null] : iv_ruleReqDocument= ruleReqDocument EOF ;
    public final EObject entryRuleReqDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:313:2: (iv_ruleReqDocument= ruleReqDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:314:2: iv_ruleReqDocument= ruleReqDocument EOF
            {
             newCompositeNode(grammarAccess.getReqDocumentRule()); 
            pushFollow(FOLLOW_ruleReqDocument_in_entryRuleReqDocument561);
            iv_ruleReqDocument=ruleReqDocument();

            state._fsp--;

             current =iv_ruleReqDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqDocument571); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:321:1: ruleReqDocument returns [EObject current=null] : (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket ) ;
    public final EObject ruleReqDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:324:28: ( (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:325:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:325:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:326:2: otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Document,FOLLOW_Document_in_ruleReqDocument609); 

                	newLeafNode(otherlv_0, grammarAccess.getReqDocumentAccess().getDocumentKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:330:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:331:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:331:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:332:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqDocument625); 

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

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqDocument643); 

                	newLeafNode(otherlv_2, grammarAccess.getReqDocumentAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:353:1: ( ( ruleQualifiedName ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:354:1: ( ruleQualifiedName )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:354:1: ( ruleQualifiedName )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:355:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReqDocumentRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getReqDocumentAccess().getConsistsOfReqSpecLibraryCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleReqDocument665);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqDocument678); 

                	newLeafNode(otherlv_4, grammarAccess.getReqDocumentAccess().getRightSquareBracketKeyword_4());
                

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


    // $ANTLR start "entryRuleReqSpecLibrary"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:381:1: entryRuleReqSpecLibrary returns [EObject current=null] : iv_ruleReqSpecLibrary= ruleReqSpecLibrary EOF ;
    public final EObject entryRuleReqSpecLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecLibrary = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:382:2: (iv_ruleReqSpecLibrary= ruleReqSpecLibrary EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:383:2: iv_ruleReqSpecLibrary= ruleReqSpecLibrary EOF
            {
             newCompositeNode(grammarAccess.getReqSpecLibraryRule()); 
            pushFollow(FOLLOW_ruleReqSpecLibrary_in_entryRuleReqSpecLibrary712);
            iv_ruleReqSpecLibrary=ruleReqSpecLibrary();

            state._fsp--;

             current =iv_ruleReqSpecLibrary; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecLibrary722); 

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
    // $ANTLR end "entryRuleReqSpecLibrary"


    // $ANTLR start "ruleReqSpecLibrary"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:390:1: ruleReqSpecLibrary returns [EObject current=null] : (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket (otherlv_7= Constants ( (lv_constants_8_0= ruleFinalValue ) )+ )? ( ( (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder ) ) )* otherlv_10= RightSquareBracket ) ;
    public final EObject ruleReqSpecLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;

        EObject lv_constants_8_0 = null;

        EObject lv_content_9_1 = null;

        EObject lv_content_9_2 = null;

        EObject lv_content_9_3 = null;

        EObject lv_content_9_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:393:28: ( (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket (otherlv_7= Constants ( (lv_constants_8_0= ruleFinalValue ) )+ )? ( ( (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder ) ) )* otherlv_10= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:394:1: (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket (otherlv_7= Constants ( (lv_constants_8_0= ruleFinalValue ) )+ )? ( ( (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder ) ) )* otherlv_10= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:394:1: (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket (otherlv_7= Constants ( (lv_constants_8_0= ruleFinalValue ) )+ )? ( ( (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder ) ) )* otherlv_10= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:395:2: otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket (otherlv_7= Constants ( (lv_constants_8_0= ruleFinalValue ) )+ )? ( ( (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder ) ) )* otherlv_10= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Library,FOLLOW_Library_in_ruleReqSpecLibrary760); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecLibraryAccess().getLibraryKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:399:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:400:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:400:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:401:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecLibrary776); 

            			newLeafNode(lv_name_1_0, grammarAccess.getReqSpecLibraryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getReqSpecLibraryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:417:2: (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Import) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:418:2: otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) )
                    {
                    otherlv_2=(Token)match(input,Import,FOLLOW_Import_in_ruleReqSpecLibrary795); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecLibraryAccess().getImportKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:422:1: ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:423:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:423:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:424:3: lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_ruleReqSpecLibrary815);
                    lv_importedNamespace_3_0=ruleQualifiedNameWithWildCard();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
                    	        }
                           		set(
                           			current, 
                           			"importedNamespace",
                            		lv_importedNamespace_3_0, 
                            		"QualifiedNameWithWildCard");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:440:4: (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==For) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:441:2: otherlv_4= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecLibrary831); 

                        	newLeafNode(otherlv_4, grammarAccess.getReqSpecLibraryAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:445:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:446:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:446:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:447:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecLibraryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getTargetClassifierCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecLibrary853);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary868); 

                	newLeafNode(otherlv_6, grammarAccess.getReqSpecLibraryAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:465:1: (otherlv_7= Constants ( (lv_constants_8_0= ruleFinalValue ) )+ )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Constants) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:466:2: otherlv_7= Constants ( (lv_constants_8_0= ruleFinalValue ) )+
                    {
                    otherlv_7=(Token)match(input,Constants,FOLLOW_Constants_in_ruleReqSpecLibrary881); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecLibraryAccess().getConstantsKeyword_5_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:470:1: ( (lv_constants_8_0= ruleFinalValue ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==RULE_ID) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:471:1: (lv_constants_8_0= ruleFinalValue )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:471:1: (lv_constants_8_0= ruleFinalValue )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:472:3: lv_constants_8_0= ruleFinalValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getConstantsFinalValueParserRuleCall_5_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleFinalValue_in_ruleReqSpecLibrary901);
                    	    lv_constants_8_0=ruleFinalValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constants",
                    	            		lv_constants_8_0, 
                    	            		"FinalValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:488:5: ( ( (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Requirement||(LA7_0>=Folder && LA7_0<=Hazard)||LA7_0==Goal) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:489:1: ( (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:489:1: ( (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:490:1: (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:490:1: (lv_content_9_1= ruleGoal | lv_content_9_2= ruleRequirement | lv_content_9_3= ruleHazard | lv_content_9_4= ruleReqSpecFolder )
            	    int alt6=4;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt6=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt6=2;
            	        }
            	        break;
            	    case Hazard:
            	        {
            	        alt6=3;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt6=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 6, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt6) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:491:3: lv_content_9_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentGoalParserRuleCall_6_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecLibrary927);
            	            lv_content_9_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_9_1, 
            	                    		"Goal");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:506:8: lv_content_9_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentRequirementParserRuleCall_6_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecLibrary946);
            	            lv_content_9_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_9_2, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:521:8: lv_content_9_3= ruleHazard
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentHazardParserRuleCall_6_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleHazard_in_ruleReqSpecLibrary965);
            	            lv_content_9_3=ruleHazard();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_9_3, 
            	                    		"Hazard");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:536:8: lv_content_9_4= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentReqSpecFolderParserRuleCall_6_0_3()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecLibrary984);
            	            lv_content_9_4=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_9_4, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_10=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1001); 

                	newLeafNode(otherlv_10, grammarAccess.getReqSpecLibraryAccess().getRightSquareBracketKeyword_7());
                

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
    // $ANTLR end "ruleReqSpecLibrary"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:567:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:568:1: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:569:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1036);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildCard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1047); 

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
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:576:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:580:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:581:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:581:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:582:5: this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1094);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:592:1: (kw= FullStopAsterisk )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FullStopAsterisk) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:593:2: kw= FullStopAsterisk
                    {
                    kw=(Token)match(input,FullStopAsterisk,FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildCard1113); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
                        

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
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleReqSpecFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:606:1: entryRuleReqSpecFolder returns [EObject current=null] : iv_ruleReqSpecFolder= ruleReqSpecFolder EOF ;
    public final EObject entryRuleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:607:2: (iv_ruleReqSpecFolder= ruleReqSpecFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:608:2: iv_ruleReqSpecFolder= ruleReqSpecFolder EOF
            {
             newCompositeNode(grammarAccess.getReqSpecFolderRule()); 
            pushFollow(FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1154);
            iv_ruleReqSpecFolder=ruleReqSpecFolder();

            state._fsp--;

             current =iv_ruleReqSpecFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecFolder1164); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:615:1: ruleReqSpecFolder returns [EObject current=null] : (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder ) ) )* otherlv_4= RightSquareBracket ) ;
    public final EObject ruleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_label_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_content_3_1 = null;

        EObject lv_content_3_2 = null;

        EObject lv_content_3_3 = null;

        EObject lv_content_3_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:618:28: ( (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder ) ) )* otherlv_4= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:619:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder ) ) )* otherlv_4= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:619:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder ) ) )* otherlv_4= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:620:2: otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder ) ) )* otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleReqSpecFolder1202); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:624:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:625:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:625:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:626:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecFolder1218); 

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

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1236); 

                	newLeafNode(otherlv_2, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:647:1: ( ( (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Requirement||(LA10_0>=Folder && LA10_0<=Hazard)||LA10_0==Goal) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:648:1: ( (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:648:1: ( (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:649:1: (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:649:1: (lv_content_3_1= ruleGoal | lv_content_3_2= ruleRequirement | lv_content_3_3= ruleHazard | lv_content_3_4= ruleReqSpecFolder )
            	    int alt9=4;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt9=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt9=2;
            	        }
            	        break;
            	    case Hazard:
            	        {
            	        alt9=3;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt9=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt9) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:650:3: lv_content_3_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentGoalParserRuleCall_3_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecFolder1258);
            	            lv_content_3_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_3_1, 
            	                    		"Goal");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:665:8: lv_content_3_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentRequirementParserRuleCall_3_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecFolder1277);
            	            lv_content_3_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_3_2, 
            	                    		"Requirement");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:680:8: lv_content_3_3= ruleHazard
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentHazardParserRuleCall_3_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleHazard_in_ruleReqSpecFolder1296);
            	            lv_content_3_3=ruleHazard();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_3_3, 
            	                    		"Hazard");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:695:8: lv_content_3_4= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentReqSpecFolderParserRuleCall_3_0_3()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1315);
            	            lv_content_3_4=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_3_4, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1332); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecFolderAccess().getRightSquareBracketKeyword_4());
                

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


    // $ANTLR start "entryRuleGoal"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:726:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:727:2: (iv_ruleGoal= ruleGoal EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:728:2: iv_ruleGoal= ruleGoal EOF
            {
             newCompositeNode(grammarAccess.getGoalRule()); 
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal1366);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal1376); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:735:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_56= RightSquareBracket ) ;
    public final EObject ruleGoal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token lv_rationale_15_0=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        Token otherlv_35=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_42=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token otherlv_47=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_52=null;
        Token otherlv_54=null;
        Token otherlv_56=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_11_0 = null;

        EObject lv_assert_13_0 = null;

        EObject lv_subgoal_21_0 = null;

        EObject lv_docReference_53_0 = null;

        EObject lv_docReference_55_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:738:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_56= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:739:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_56= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:739:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_56= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:740:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_56= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal1414); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:744:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:745:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:745:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:746:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1430); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:762:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Colon) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:763:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoal1449); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:767:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:769:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1469);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:785:4: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==For) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:786:2: otherlv_4= For ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleGoal1485); 

                        	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:790:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:791:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:791:1: (otherlv_5= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:792:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGoalRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1504); 

                    		newLeafNode(otherlv_5, grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal1519); 

                	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:808:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:810:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:810:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:811:2: ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:814:2: ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:815:3: ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:815:3: ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop22:
            do {
                int alt22=14;
                alt22 = dfa22.predict(input);
                switch (alt22) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:817:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:817:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:818:5: {...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:818:101: ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:819:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:822:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:822:7: {...}? => (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:822:16: (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:823:2: otherlv_8= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_8=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal1577); 

            	        	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:827:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:828:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:828:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:829:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal1599);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:849:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:849:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:850:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:850:101: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:851:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:854:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:854:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:854:16: (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:855:2: otherlv_10= Description ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal1668); 

            	        	newLeafNode(otherlv_10, grammarAccess.getGoalAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:859:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:860:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:860:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:861:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal1688);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:884:4: ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:884:4: ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:885:5: {...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:885:101: ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:886:6: ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:889:6: ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:889:7: {...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:889:16: (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:890:2: otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) )
            	    {
            	    otherlv_12=(Token)match(input,Assert,FOLLOW_Assert_in_ruleGoal1757); 

            	        	newLeafNode(otherlv_12, grammarAccess.getGoalAccess().getAssertKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:894:1: ( (lv_assert_13_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:895:1: (lv_assert_13_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:895:1: (lv_assert_13_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:3: lv_assert_13_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getAssertPredicateExpressionParserRuleCall_5_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleGoal1777);
            	    lv_assert_13_0=rulePredicateExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_13_0, 
            	            		"PredicateExpression");
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:4: ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:920:5: {...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:920:101: ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:921:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:924:6: ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:924:7: {...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:924:16: (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:925:2: otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) )
            	    {
            	    otherlv_14=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal1846); 

            	        	newLeafNode(otherlv_14, grammarAccess.getGoalAccess().getRationaleKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:929:1: ( (lv_rationale_15_0= RULE_STRING ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:930:1: (lv_rationale_15_0= RULE_STRING )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:930:1: (lv_rationale_15_0= RULE_STRING )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:931:3: lv_rationale_15_0= RULE_STRING
            	    {
            	    lv_rationale_15_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleGoal1862); 

            	    			newLeafNode(lv_rationale_15_0, grammarAccess.getGoalAccess().getRationaleSTRINGTerminalRuleCall_5_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_15_0, 
            	            		"STRING");
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:954:4: ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:954:4: ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:955:5: {...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:955:101: ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:956:6: ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:959:6: ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:959:7: {...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:959:16: (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:960:2: otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_16=(Token)match(input,Refined,FOLLOW_Refined_in_ruleGoal1936); 

            	        	newLeafNode(otherlv_16, grammarAccess.getGoalAccess().getRefinedKeyword_5_4_0());
            	        
            	    otherlv_17=(Token)match(input,To,FOLLOW_To_in_ruleGoal1948); 

            	        	newLeafNode(otherlv_17, grammarAccess.getGoalAccess().getToKeyword_5_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:969:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:970:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:970:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:971:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal1970);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:984:2: (otherlv_19= Comma ( ( ruleQualifiedName ) ) )*
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( (LA13_0==Comma) ) {
            	            alt13=1;
            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:985:2: otherlv_19= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_19=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal1984); 

            	    	        	newLeafNode(otherlv_19, grammarAccess.getGoalAccess().getCommaKeyword_5_4_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:989:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:990:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:990:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:991:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_4_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2006);
            	    	    ruleQualifiedName();

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1011:4: ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1011:4: ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1012:5: {...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1012:101: ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1013:6: ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1016:6: ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+
            	    int cnt14=0;
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==Goal) ) {
            	            int LA14_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt14=1;
            	            }


            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1016:7: {...}? => ( (lv_subgoal_21_0= ruleGoal ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1016:16: ( (lv_subgoal_21_0= ruleGoal ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1017:1: (lv_subgoal_21_0= ruleGoal )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1017:1: (lv_subgoal_21_0= ruleGoal )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1018:3: lv_subgoal_21_0= ruleGoal
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSubgoalGoalParserRuleCall_5_5_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleGoal_in_ruleGoal2084);
            	    	    lv_subgoal_21_0=ruleGoal();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subgoal",
            	    	            		lv_subgoal_21_0, 
            	    	            		"Goal");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt14 >= 1 ) break loop14;
            	                EarlyExitException eee =
            	                    new EarlyExitException(14, input);
            	                throw eee;
            	        }
            	        cnt14++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1041:4: ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1041:4: ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1042:5: {...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1042:101: ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1043:6: ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1046:6: ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1046:7: {...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1046:16: (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1047:2: otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_22=(Token)match(input,Decomposed,FOLLOW_Decomposed_in_ruleGoal2153); 

            	        	newLeafNode(otherlv_22, grammarAccess.getGoalAccess().getDecomposedKeyword_5_6_0());
            	        
            	    otherlv_23=(Token)match(input,To,FOLLOW_To_in_ruleGoal2165); 

            	        	newLeafNode(otherlv_23, grammarAccess.getGoalAccess().getToKeyword_5_6_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1056:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1057:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1057:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1058:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_5_6_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2187);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1071:2: (otherlv_25= Comma ( ( ruleQualifiedName ) ) )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==Comma) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1072:2: otherlv_25= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_25=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2201); 

            	    	        	newLeafNode(otherlv_25, grammarAccess.getGoalAccess().getCommaKeyword_5_6_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1076:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1077:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1077:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1078:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_5_6_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2223);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1098:4: ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1098:4: ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1099:5: {...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1099:101: ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1100:6: ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1103:6: ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1103:7: {...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1103:16: (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1104:2: otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_27=(Token)match(input,Evolved,FOLLOW_Evolved_in_ruleGoal2294); 

            	        	newLeafNode(otherlv_27, grammarAccess.getGoalAccess().getEvolvedKeyword_5_7_0());
            	        
            	    otherlv_28=(Token)match(input,To,FOLLOW_To_in_ruleGoal2306); 

            	        	newLeafNode(otherlv_28, grammarAccess.getGoalAccess().getToKeyword_5_7_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1113:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1114:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1114:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1115:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_5_7_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2328);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1128:2: (otherlv_30= Comma ( ( ruleQualifiedName ) ) )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==Comma) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1129:2: otherlv_30= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_30=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2342); 

            	    	        	newLeafNode(otherlv_30, grammarAccess.getGoalAccess().getCommaKeyword_5_7_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1133:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1134:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1134:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1135:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_5_7_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2364);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1155:4: ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1155:4: ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1156:5: {...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1156:101: ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1157:6: ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1160:6: ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1160:7: {...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1160:16: (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1161:2: otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_32=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2435); 

            	        	newLeafNode(otherlv_32, grammarAccess.getGoalAccess().getConflictsKeyword_5_8_0());
            	        
            	    otherlv_33=(Token)match(input,With,FOLLOW_With_in_ruleGoal2447); 

            	        	newLeafNode(otherlv_33, grammarAccess.getGoalAccess().getWithKeyword_5_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1170:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1171:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1171:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2469);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1185:2: (otherlv_35= Comma ( ( ruleQualifiedName ) ) )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==Comma) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1186:2: otherlv_35= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_35=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2483); 

            	    	        	newLeafNode(otherlv_35, grammarAccess.getGoalAccess().getCommaKeyword_5_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1190:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1191:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1191:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1192:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_8_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2505);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop17;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1212:4: ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1212:4: ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1213:5: {...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1213:101: ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1214:6: ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1217:6: ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1217:7: {...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1217:16: (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1218:2: otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_37=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2576); 

            	        	newLeafNode(otherlv_37, grammarAccess.getGoalAccess().getStakeholderKeyword_5_9_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1222:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1223:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1223:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1224:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2598);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1237:2: (otherlv_39= Comma ( ( ruleQualifiedName ) ) )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==Comma) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1238:2: otherlv_39= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_39=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2612); 

            	    	        	newLeafNode(otherlv_39, grammarAccess.getGoalAccess().getCommaKeyword_5_9_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1242:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1243:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1243:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1244:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_9_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2634);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1264:4: ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1264:4: ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1265:5: {...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1265:102: ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1266:6: ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1269:6: ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1269:7: {...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1269:16: (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1270:2: otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_41=(Token)match(input,See,FOLLOW_See_in_ruleGoal2705); 

            	        	newLeafNode(otherlv_41, grammarAccess.getGoalAccess().getSeeKeyword_5_10_0());
            	        
            	    otherlv_42=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal2717); 

            	        	newLeafNode(otherlv_42, grammarAccess.getGoalAccess().getGoalKeyword_5_10_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1279:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1280:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1280:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1281:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_5_10_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2739);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1294:2: (otherlv_44= Comma ( ( ruleQualifiedName ) ) )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==Comma) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1295:2: otherlv_44= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_44=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2753); 

            	    	        	newLeafNode(otherlv_44, grammarAccess.getGoalAccess().getCommaKeyword_5_10_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1299:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1300:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1300:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1301:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_5_10_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2775);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1321:4: ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1321:4: ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1322:5: {...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1322:102: ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1323:6: ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1326:6: ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1326:7: {...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1326:16: (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1327:2: otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_46=(Token)match(input,See,FOLLOW_See_in_ruleGoal2846); 

            	        	newLeafNode(otherlv_46, grammarAccess.getGoalAccess().getSeeKeyword_5_11_0());
            	        
            	    otherlv_47=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal2858); 

            	        	newLeafNode(otherlv_47, grammarAccess.getGoalAccess().getRequirementKeyword_5_11_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1336:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1337:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1337:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1338:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_5_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2880);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1351:2: (otherlv_49= Comma ( ( ruleQualifiedName ) ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Comma) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1352:2: otherlv_49= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_49=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2894); 

            	    	        	newLeafNode(otherlv_49, grammarAccess.getGoalAccess().getCommaKeyword_5_11_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1356:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1357:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1357:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1358:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_5_11_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2916);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1378:4: ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1378:4: ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1379:5: {...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1379:102: ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1380:6: ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1383:6: ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1383:7: {...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1383:16: (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1384:2: otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_51=(Token)match(input,See,FOLLOW_See_in_ruleGoal2987); 

            	        	newLeafNode(otherlv_51, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0());
            	        
            	    otherlv_52=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal2999); 

            	        	newLeafNode(otherlv_52, grammarAccess.getGoalAccess().getDocumentKeyword_5_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1393:1: ( (lv_docReference_53_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1394:1: (lv_docReference_53_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1394:1: (lv_docReference_53_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1395:3: lv_docReference_53_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3019);
            	    lv_docReference_53_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_53_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1411:2: (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==Comma) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1412:2: otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_54=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3033); 

            	    	        	newLeafNode(otherlv_54, grammarAccess.getGoalAccess().getCommaKeyword_5_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1416:1: ( (lv_docReference_55_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1417:1: (lv_docReference_55_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1417:1: (lv_docReference_55_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1418:3: lv_docReference_55_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3053);
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


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop21;
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
            	    break loop22;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	

            }

            otherlv_56=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal3109); 

                	newLeafNode(otherlv_56, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1461:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1462:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1463:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement3143);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement3153); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1470:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_53= RightSquareBracket ) ;
    public final EObject ruleRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token lv_rationale_17_0=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_24=null;
        Token otherlv_26=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_44=null;
        Token otherlv_46=null;
        Token otherlv_48=null;
        Token otherlv_49=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_11_0 = null;

        EObject lv_constants_13_0 = null;

        EObject lv_assert_15_0 = null;

        EObject lv_subrequirement_28_0 = null;

        EObject lv_docReference_50_0 = null;

        EObject lv_docReference_52_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1473:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_53= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1474:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_53= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1474:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_53= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1475:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )? otherlv_6= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_53= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement3191); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1479:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1480:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1480:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1481:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3207); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1497:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Colon) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1498:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleRequirement3226); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1502:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1503:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1503:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1504:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3246);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1520:4: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==For) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1521:2: otherlv_4= For ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleRequirement3262); 

                        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1525:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1526:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1526:1: (otherlv_5= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1527:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3281); 

                    		newLeafNode(otherlv_5, grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3296); 

                	newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1543:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1545:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1545:1: ( ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1546:2: ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1549:2: ( ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1550:3: ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1550:3: ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop34:
            do {
                int alt34=14;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1552:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1552:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1553:5: {...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1553:108: ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1554:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1557:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1557:7: {...}? => (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1557:16: (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1558:2: otherlv_8= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_8=(Token)match(input,Category,FOLLOW_Category_in_ruleRequirement3354); 

            	        	newLeafNode(otherlv_8, grammarAccess.getRequirementAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1562:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1563:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1563:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1564:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3376);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1584:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1584:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1585:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1585:108: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1586:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1589:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1589:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1589:16: (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1590:2: otherlv_10= Description ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3445); 

            	        	newLeafNode(otherlv_10, grammarAccess.getRequirementAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1594:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1595:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1595:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1596:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3465);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1619:4: ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1619:4: ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1620:5: {...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1620:108: ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1621:6: ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1624:6: ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1624:7: {...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1624:16: (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1625:2: otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+
            	    {
            	    otherlv_12=(Token)match(input,Constants,FOLLOW_Constants_in_ruleRequirement3534); 

            	        	newLeafNode(otherlv_12, grammarAccess.getRequirementAccess().getConstantsKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1629:1: ( (lv_constants_13_0= ruleFinalValue ) )+
            	    int cnt25=0;
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==RULE_ID) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1630:1: (lv_constants_13_0= ruleFinalValue )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1630:1: (lv_constants_13_0= ruleFinalValue )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1631:3: lv_constants_13_0= ruleFinalValue
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getConstantsFinalValueParserRuleCall_5_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleFinalValue_in_ruleRequirement3554);
            	    	    lv_constants_13_0=ruleFinalValue();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"constants",
            	    	            		lv_constants_13_0, 
            	    	            		"FinalValue");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt25 >= 1 ) break loop25;
            	                EarlyExitException eee =
            	                    new EarlyExitException(25, input);
            	                throw eee;
            	        }
            	        cnt25++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1654:4: ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1654:4: ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1655:5: {...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1655:108: ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1656:6: ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1659:6: ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1659:7: {...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1659:16: (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1660:2: otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) )
            	    {
            	    otherlv_14=(Token)match(input,Assert,FOLLOW_Assert_in_ruleRequirement3624); 

            	        	newLeafNode(otherlv_14, grammarAccess.getRequirementAccess().getAssertKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1664:1: ( (lv_assert_15_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1665:1: (lv_assert_15_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1665:1: (lv_assert_15_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1666:3: lv_assert_15_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertPredicateExpressionParserRuleCall_5_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleRequirement3644);
            	    lv_assert_15_0=rulePredicateExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_15_0, 
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1689:4: ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1689:4: ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1690:5: {...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1690:108: ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1691:6: ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1694:6: ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1694:7: {...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1694:16: (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1695:2: otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) )
            	    {
            	    otherlv_16=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement3713); 

            	        	newLeafNode(otherlv_16, grammarAccess.getRequirementAccess().getRationaleKeyword_5_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1699:1: ( (lv_rationale_17_0= RULE_STRING ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1700:1: (lv_rationale_17_0= RULE_STRING )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1700:1: (lv_rationale_17_0= RULE_STRING )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1701:3: lv_rationale_17_0= RULE_STRING
            	    {
            	    lv_rationale_17_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleRequirement3729); 

            	    			newLeafNode(lv_rationale_17_0, grammarAccess.getRequirementAccess().getRationaleSTRINGTerminalRuleCall_5_4_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	           		setWithLastConsumed(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_17_0, 
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1724:4: ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1724:4: ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1725:5: {...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1725:108: ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1726:6: ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1729:6: ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1729:7: {...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1729:16: (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1730:2: otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_18=(Token)match(input,See,FOLLOW_See_in_ruleRequirement3803); 

            	        	newLeafNode(otherlv_18, grammarAccess.getRequirementAccess().getSeeKeyword_5_5_0());
            	        
            	    otherlv_19=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement3815); 

            	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getGoalKeyword_5_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1739:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1740:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1740:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1741:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_5_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3837);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1754:2: (otherlv_21= Comma ( ( ruleQualifiedName ) ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==Comma) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1755:2: otherlv_21= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_21=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement3851); 

            	    	        	newLeafNode(otherlv_21, grammarAccess.getRequirementAccess().getCommaKeyword_5_5_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1759:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1760:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1760:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1761:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_5_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3873);
            	    	    ruleQualifiedName();

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1781:4: ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1781:4: ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1782:5: {...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1782:108: ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:6: ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1786:6: ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1786:7: {...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1786:16: (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1787:2: otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_23=(Token)match(input,Refined,FOLLOW_Refined_in_ruleRequirement3944); 

            	        	newLeafNode(otherlv_23, grammarAccess.getRequirementAccess().getRefinedKeyword_5_6_0());
            	        
            	    otherlv_24=(Token)match(input,To,FOLLOW_To_in_ruleRequirement3956); 

            	        	newLeafNode(otherlv_24, grammarAccess.getRequirementAccess().getToKeyword_5_6_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1796:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1797:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1797:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1798:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinedReferenceRequirementCrossReference_5_6_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement3978);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1811:2: (otherlv_26= Comma ( ( ruleQualifiedName ) ) )*
            	    loop27:
            	    do {
            	        int alt27=2;
            	        int LA27_0 = input.LA(1);

            	        if ( (LA27_0==Comma) ) {
            	            alt27=1;
            	        }


            	        switch (alt27) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1812:2: otherlv_26= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_26=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement3992); 

            	    	        	newLeafNode(otherlv_26, grammarAccess.getRequirementAccess().getCommaKeyword_5_6_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1816:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1817:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1817:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1818:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_5_6_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4014);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:4: ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:4: ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1839:5: {...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1839:108: ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1840:6: ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1843:6: ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+
            	    int cnt28=0;
            	    loop28:
            	    do {
            	        int alt28=2;
            	        int LA28_0 = input.LA(1);

            	        if ( (LA28_0==Requirement) ) {
            	            int LA28_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt28=1;
            	            }


            	        }


            	        switch (alt28) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1843:7: {...}? => ( (lv_subrequirement_28_0= ruleRequirement ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1843:16: ( (lv_subrequirement_28_0= ruleRequirement ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1844:1: (lv_subrequirement_28_0= ruleRequirement )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1844:1: (lv_subrequirement_28_0= ruleRequirement )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1845:3: lv_subrequirement_28_0= ruleRequirement
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSubrequirementRequirementParserRuleCall_5_7_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRequirement_in_ruleRequirement4092);
            	    	    lv_subrequirement_28_0=ruleRequirement();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subrequirement",
            	    	            		lv_subrequirement_28_0, 
            	    	            		"Requirement");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt28 >= 1 ) break loop28;
            	                EarlyExitException eee =
            	                    new EarlyExitException(28, input);
            	                throw eee;
            	        }
            	        cnt28++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1868:4: ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1868:4: ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1869:5: {...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1869:108: ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1870:6: ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1873:6: ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1873:7: {...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1873:16: (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1874:2: otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_29=(Token)match(input,Decomposed,FOLLOW_Decomposed_in_ruleRequirement4161); 

            	        	newLeafNode(otherlv_29, grammarAccess.getRequirementAccess().getDecomposedKeyword_5_8_0());
            	        
            	    otherlv_30=(Token)match(input,To,FOLLOW_To_in_ruleRequirement4173); 

            	        	newLeafNode(otherlv_30, grammarAccess.getRequirementAccess().getToKeyword_5_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1883:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1884:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1884:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1885:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposedReferenceRequirementCrossReference_5_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4195);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1898:2: (otherlv_32= Comma ( ( ruleQualifiedName ) ) )*
            	    loop29:
            	    do {
            	        int alt29=2;
            	        int LA29_0 = input.LA(1);

            	        if ( (LA29_0==Comma) ) {
            	            alt29=1;
            	        }


            	        switch (alt29) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1899:2: otherlv_32= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_32=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4209); 

            	    	        	newLeafNode(otherlv_32, grammarAccess.getRequirementAccess().getCommaKeyword_5_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1903:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1904:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1904:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1905:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_5_8_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4231);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1925:4: ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1925:4: ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:5: {...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:108: ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1927:6: ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1930:6: ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1930:7: {...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1930:16: (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1931:2: otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_34=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleRequirement4302); 

            	        	newLeafNode(otherlv_34, grammarAccess.getRequirementAccess().getEvolvesKeyword_5_9_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1935:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1936:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1936:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1937:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4324);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1950:2: (otherlv_36= Comma ( ( ruleQualifiedName ) ) )*
            	    loop30:
            	    do {
            	        int alt30=2;
            	        int LA30_0 = input.LA(1);

            	        if ( (LA30_0==Comma) ) {
            	            alt30=1;
            	        }


            	        switch (alt30) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1951:2: otherlv_36= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_36=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4338); 

            	    	        	newLeafNode(otherlv_36, grammarAccess.getRequirementAccess().getCommaKeyword_5_9_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1955:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1956:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1956:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1957:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_5_9_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4360);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1977:4: ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1977:4: ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1978:5: {...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1978:109: ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1979:6: ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1982:6: ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1982:7: {...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1982:16: (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:2: otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_38=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4431); 

            	        	newLeafNode(otherlv_38, grammarAccess.getRequirementAccess().getSeeKeyword_5_10_0());
            	        
            	    otherlv_39=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4443); 

            	        	newLeafNode(otherlv_39, grammarAccess.getRequirementAccess().getGoalKeyword_5_10_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1992:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1993:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1993:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1994:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_5_10_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4465);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2007:2: (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Comma) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2008:2: otherlv_41= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4479); 

            	    	        	newLeafNode(otherlv_41, grammarAccess.getRequirementAccess().getCommaKeyword_5_10_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2012:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2013:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2013:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2014:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_5_10_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4501);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2034:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2034:4: ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2035:5: {...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2035:109: ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2036:6: ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2039:6: ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2039:7: {...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2039:16: (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2040:2: otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_43=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4572); 

            	        	newLeafNode(otherlv_43, grammarAccess.getRequirementAccess().getSeeKeyword_5_11_0());
            	        
            	    otherlv_44=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement4584); 

            	        	newLeafNode(otherlv_44, grammarAccess.getRequirementAccess().getRequirementKeyword_5_11_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2049:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2050:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2050:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2051:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_5_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4606);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2064:2: (otherlv_46= Comma ( ( ruleQualifiedName ) ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Comma) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2065:2: otherlv_46= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_46=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4620); 

            	    	        	newLeafNode(otherlv_46, grammarAccess.getRequirementAccess().getCommaKeyword_5_11_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2069:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2070:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2070:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2071:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_5_11_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4642);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2091:4: ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2091:4: ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2092:5: {...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2092:109: ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2093:6: ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2096:6: ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2096:7: {...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2096:16: (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2097:2: otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_48=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4713); 

            	        	newLeafNode(otherlv_48, grammarAccess.getRequirementAccess().getSeeKeyword_5_12_0());
            	        
            	    otherlv_49=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement4725); 

            	        	newLeafNode(otherlv_49, grammarAccess.getRequirementAccess().getDocumentKeyword_5_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2106:1: ( (lv_docReference_50_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2107:1: (lv_docReference_50_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2107:1: (lv_docReference_50_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2108:3: lv_docReference_50_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4745);
            	    lv_docReference_50_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_50_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2124:2: (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Comma) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2125:2: otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_51=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4759); 

            	    	        	newLeafNode(otherlv_51, grammarAccess.getRequirementAccess().getCommaKeyword_5_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2129:1: ( (lv_docReference_52_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2130:1: (lv_docReference_52_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2130:1: (lv_docReference_52_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2131:3: lv_docReference_52_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_5_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement4779);
            	    	    lv_docReference_52_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_52_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_5());
            	

            }

            otherlv_53=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement4835); 

                	newLeafNode(otherlv_53, grammarAccess.getRequirementAccess().getRightSquareBracketKeyword_6());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2174:1: entryRuleHazard returns [EObject current=null] : iv_ruleHazard= ruleHazard EOF ;
    public final EObject entryRuleHazard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2175:2: (iv_ruleHazard= ruleHazard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2176:2: iv_ruleHazard= ruleHazard EOF
            {
             newCompositeNode(grammarAccess.getHazardRule()); 
            pushFollow(FOLLOW_ruleHazard_in_entryRuleHazard4869);
            iv_ruleHazard=ruleHazard();

            state._fsp--;

             current =iv_ruleHazard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazard4879); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2183:1: ruleHazard returns [EObject current=null] : (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_19= RightSquareBracket ) ;
    public final EObject ruleHazard() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token lv_rationale_18_0=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2186:28: ( (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_19= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2187:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_19= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2187:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_19= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2188:2: otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) ) otherlv_19= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Hazard,FOLLOW_Hazard_in_ruleHazard4917); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardAccess().getHazardKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2192:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2193:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2193:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2194:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard4933); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2210:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==Colon) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2211:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleHazard4952); 

                        	newLeafNode(otherlv_2, grammarAccess.getHazardAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2215:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2216:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2216:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2217:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getHazardAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleHazard4972);
                    lv_title_3_0=ruleValueString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getHazardRule());
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2233:4: ( ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2235:1: ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2235:1: ( ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2236:2: ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?)
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2239:2: ( ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?)
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2240:3: ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+ {...}?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2240:3: ( ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=5;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==For||LA39_0==LeftSquareBracket) && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
                    alt39=1;
                }
                else if ( LA39_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
                    alt39=2;
                }
                else if ( LA39_0 ==Mitigated && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
                    alt39=3;
                }
                else if ( LA39_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
                    alt39=4;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2242:4: ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2242:4: ({...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2243:5: {...}? => ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2243:103: ( ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2244:6: ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2247:6: ({...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2247:7: {...}? => ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2247:16: ( (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )? )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2247:17: (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )? otherlv_7= LeftSquareBracket (otherlv_8= Category ( ( ruleCatRef ) ) )?
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2247:17: (otherlv_5= For ( (otherlv_6= RULE_ID ) ) )?
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==For) ) {
            	        alt36=1;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2248:2: otherlv_5= For ( (otherlv_6= RULE_ID ) )
            	            {
            	            otherlv_5=(Token)match(input,For,FOLLOW_For_in_ruleHazard5034); 

            	                	newLeafNode(otherlv_5, grammarAccess.getHazardAccess().getForKeyword_3_0_0_0());
            	                
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2252:1: ( (otherlv_6= RULE_ID ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2253:1: (otherlv_6= RULE_ID )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2253:1: (otherlv_6= RULE_ID )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2254:3: otherlv_6= RULE_ID
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getHazardRule());
            	            	        }
            	                    
            	            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard5053); 

            	            		newLeafNode(otherlv_6, grammarAccess.getHazardAccess().getTargetNamedElementCrossReference_3_0_0_1_0()); 
            	            	

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleHazard5068); 

            	        	newLeafNode(otherlv_7, grammarAccess.getHazardAccess().getLeftSquareBracketKeyword_3_0_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2270:1: (otherlv_8= Category ( ( ruleCatRef ) ) )?
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==Category) ) {
            	        alt37=1;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2271:2: otherlv_8= Category ( ( ruleCatRef ) )
            	            {
            	            otherlv_8=(Token)match(input,Category,FOLLOW_Category_in_ruleHazard5081); 

            	                	newLeafNode(otherlv_8, grammarAccess.getHazardAccess().getCategoryKeyword_3_0_2_0());
            	                
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2275:1: ( ( ruleCatRef ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2276:1: ( ruleCatRef )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2276:1: ( ruleCatRef )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2277:3: ruleCatRef
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getHazardRule());
            	            	        }
            	                    
            	             
            	            	        newCompositeNode(grammarAccess.getHazardAccess().getCategoryHazardCategoryCrossReference_3_0_2_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleCatRef_in_ruleHazard5103);
            	            ruleCatRef();

            	            state._fsp--;

            	             
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2297:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2297:4: ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2298:5: {...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2298:103: ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2299:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2302:6: ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2302:7: {...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2302:16: (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2303:2: otherlv_10= Description ( (lv_description_11_0= ruleDescription ) )
            	    {
            	    otherlv_10=(Token)match(input,Description,FOLLOW_Description_in_ruleHazard5174); 

            	        	newLeafNode(otherlv_10, grammarAccess.getHazardAccess().getDescriptionKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2307:1: ( (lv_description_11_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2308:1: (lv_description_11_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2308:1: (lv_description_11_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2309:3: lv_description_11_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getDescriptionDescriptionParserRuleCall_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleHazard5194);
            	    lv_description_11_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2332:4: ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2332:4: ({...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2333:5: {...}? => ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2333:103: ( ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2334:6: ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2337:6: ({...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2337:7: {...}? => (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2337:16: (otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2338:2: otherlv_12= Mitigated otherlv_13= By ( ( ruleQualifiedName ) ) (otherlv_15= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_12=(Token)match(input,Mitigated,FOLLOW_Mitigated_in_ruleHazard5263); 

            	        	newLeafNode(otherlv_12, grammarAccess.getHazardAccess().getMitigatedKeyword_3_2_0());
            	        
            	    otherlv_13=(Token)match(input,By,FOLLOW_By_in_ruleHazard5275); 

            	        	newLeafNode(otherlv_13, grammarAccess.getHazardAccess().getByKeyword_3_2_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2347:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2348:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2348:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2349:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getHazardReferenceRequirementCrossReference_3_2_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleHazard5297);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2362:2: (otherlv_15= Comma ( ( ruleQualifiedName ) ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Comma) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2363:2: otherlv_15= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_15=(Token)match(input,Comma,FOLLOW_Comma_in_ruleHazard5311); 

            	    	        	newLeafNode(otherlv_15, grammarAccess.getHazardAccess().getCommaKeyword_3_2_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2367:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2368:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2369:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getHazardReferenceRequirementCrossReference_3_2_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleHazard5333);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2389:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2389:4: ({...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2390:5: {...}? => ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2390:103: ( ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2391:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2394:6: ({...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2394:7: {...}? => (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2394:16: (otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2395:2: otherlv_17= Rationale ( (lv_rationale_18_0= RULE_STRING ) )
            	    {
            	    otherlv_17=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleHazard5404); 

            	        	newLeafNode(otherlv_17, grammarAccess.getHazardAccess().getRationaleKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2399:1: ( (lv_rationale_18_0= RULE_STRING ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2400:1: (lv_rationale_18_0= RULE_STRING )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2400:1: (lv_rationale_18_0= RULE_STRING )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2401:3: lv_rationale_18_0= RULE_STRING
            	    {
            	    lv_rationale_18_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleHazard5420); 

            	    			newLeafNode(lv_rationale_18_0, grammarAccess.getHazardAccess().getRationaleSTRINGTerminalRuleCall_3_3_1_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


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

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getHazardAccess().getUnorderedGroup_3()) ) {
                throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canLeave(grammarAccess.getHazardAccess().getUnorderedGroup_3())");
            }

            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	

            }

            otherlv_19=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleHazard5485); 

                	newLeafNode(otherlv_19, grammarAccess.getHazardAccess().getRightSquareBracketKeyword_4());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2445:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2446:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2447:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument5519);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument5529); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2454:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2457:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2458:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2458:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2458:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2458:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2459:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2459:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2460:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument5575);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==NumberSign) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2477:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument5589); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2483:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument5609);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2507:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2508:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2509:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH5647);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH5658); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2516:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2520:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2521:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2521:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2521:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2521:2: (this_ID_0= RULE_ID kw= Solidus )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID) ) {
                    int LA41_1 = input.LA(2);

                    if ( (LA41_1==Solidus) ) {
                        alt41=1;
                    }


                }


                switch (alt41) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2521:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5699); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH5717); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5734); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH5752); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH5767); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2562:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2563:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2564:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT5812);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT5823); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2571:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2575:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2576:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2576:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2576:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5863); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2583:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==FullStop) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2584:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT5882); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5897); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop42;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2606:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2607:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2608:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription5945);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription5955); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2615:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2618:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2619:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2619:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_ID||LA43_0==RULE_STRING) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2620:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2620:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2621:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription6000);
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
            	    if ( cnt43 >= 1 ) break loop43;
                        EarlyExitException eee =
                            new EarlyExitException(43, input);
                        throw eee;
                }
                cnt43++;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2645:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2646:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2647:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6035);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement6045); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2654:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2657:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2658:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2658:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_STRING) ) {
                alt44=1;
            }
            else if ( (LA44_0==RULE_ID) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2658:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2658:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2659:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2659:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2660:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement6087); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2677:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2677:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2678:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2678:1: (otherlv_1= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2679:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement6118); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2698:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2699:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2700:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath6153);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath6163); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2707:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2710:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2711:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2711:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2711:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2711:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2712:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2712:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2713:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath6208); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2724:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2725:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath6222); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2729:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2730:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2730:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2731:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath6242);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2755:1: entryRulePredicateExpression returns [EObject current=null] : iv_rulePredicateExpression= rulePredicateExpression EOF ;
    public final EObject entryRulePredicateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateExpression = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2756:2: (iv_rulePredicateExpression= rulePredicateExpression EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2757:2: iv_rulePredicateExpression= rulePredicateExpression EOF
            {
             newCompositeNode(grammarAccess.getPredicateExpressionRule()); 
            pushFollow(FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression6278);
            iv_rulePredicateExpression=rulePredicateExpression();

            state._fsp--;

             current =iv_rulePredicateExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePredicateExpression6288); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2764:1: rulePredicateExpression returns [EObject current=null] : (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2767:28: ( (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2768:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2768:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2768:2: this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression6324); 
             
                newLeafNode(this_ID_0, grammarAccess.getPredicateExpressionAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2772:1: ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2773:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2773:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2774:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2774:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            int alt45=6;
            switch ( input.LA(1) ) {
            case EqualsSign:
                {
                alt45=1;
                }
                break;
            case ExclamationMarkEqualsSign:
                {
                alt45=2;
                }
                break;
            case LessThanSign:
                {
                alt45=3;
                }
                break;
            case EqualsSignLessThanSign:
                {
                alt45=4;
                }
                break;
            case GreaterThanSign:
                {
                alt45=5;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt45=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2775:3: lv_op_1_1= EqualsSign
                    {
                    lv_op_1_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_rulePredicateExpression6344); 

                            newLeafNode(lv_op_1_1, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2788:8: lv_op_1_2= ExclamationMarkEqualsSign
                    {
                    lv_op_1_2=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression6372); 

                            newLeafNode(lv_op_1_2, grammarAccess.getPredicateExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2801:8: lv_op_1_3= LessThanSign
                    {
                    lv_op_1_3=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_rulePredicateExpression6400); 

                            newLeafNode(lv_op_1_3, grammarAccess.getPredicateExpressionAccess().getOpLessThanSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2814:8: lv_op_1_4= EqualsSignLessThanSign
                    {
                    lv_op_1_4=(Token)match(input,EqualsSignLessThanSign,FOLLOW_EqualsSignLessThanSign_in_rulePredicateExpression6428); 

                            newLeafNode(lv_op_1_4, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignLessThanSignKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2827:8: lv_op_1_5= GreaterThanSign
                    {
                    lv_op_1_5=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_rulePredicateExpression6456); 

                            newLeafNode(lv_op_1_5, grammarAccess.getPredicateExpressionAccess().getOpGreaterThanSignKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2840:8: lv_op_1_6= GreaterThanSignEqualsSign
                    {
                    lv_op_1_6=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression6484); 

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression6509); 
             
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2868:1: entryRuleFinalValue returns [EObject current=null] : iv_ruleFinalValue= ruleFinalValue EOF ;
    public final EObject entryRuleFinalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinalValue = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2869:2: (iv_ruleFinalValue= ruleFinalValue EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2870:2: iv_ruleFinalValue= ruleFinalValue EOF
            {
             newCompositeNode(grammarAccess.getFinalValueRule()); 
            pushFollow(FOLLOW_ruleFinalValue_in_entryRuleFinalValue6543);
            iv_ruleFinalValue=ruleFinalValue();

            state._fsp--;

             current =iv_ruleFinalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFinalValue6553); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2877:1: ruleFinalValue returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) ;
    public final EObject ruleFinalValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2880:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2882:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2882:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2883:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFinalValue6595); 

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

            otherlv_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleFinalValue6613); 

                	newLeafNode(otherlv_1, grammarAccess.getFinalValueAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2904:1: ( (lv_value_2_0= ruleValueString ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2905:1: (lv_value_2_0= ruleValueString )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2905:1: (lv_value_2_0= ruleValueString )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2906:3: lv_value_2_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getFinalValueAccess().getValueValueStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleFinalValue6633);
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


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2930:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2931:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2932:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString6669);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString6680); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2939:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2943:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2944:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString6719); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2959:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2960:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2961:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6763);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference6774); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2968:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2972:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2973:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2973:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2973:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2973:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    int LA46_1 = input.LA(2);

                    if ( (LA46_1==ColonColon) ) {
                        alt46=1;
                    }


                }


                switch (alt46) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2973:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6815); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference6833); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6850); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2993:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==FullStop) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2994:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference6869); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference6884); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3014:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3015:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3016:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef6931);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef6942); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3023:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3027:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3028:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef6981); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3043:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3044:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3045:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7025);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7036); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3052:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3056:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3057:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3057:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3057:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7076); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3064:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==FullStop) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3065:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName7095); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7110); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop48;
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


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA34 dfa34 = new DFA34(this);
    static final String DFA22_eotS =
        "\20\uffff";
    static final String DFA22_eofS =
        "\20\uffff";
    static final String DFA22_minS =
        "\1\5\13\uffff\1\6\3\uffff";
    static final String DFA22_maxS =
        "\1\54\13\uffff\1\30\3\uffff";
    static final String DFA22_acceptS =
        "\1\uffff\1\16\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\uffff"+
        "\1\13\1\14\1\15";
    static final String DFA22_specialS =
        "\1\1\13\uffff\1\0\3\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\3\1\uffff\1\13\1\10\1\12\2\uffff\1\5\1\2\1\uffff\1\11\2"+
            "\uffff\1\6\1\4\4\uffff\1\7\2\uffff\1\14\20\uffff\1\1",
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
            "\1\16\7\uffff\1\17\11\uffff\1\15",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "()* loopback of 815:3: ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Assert ( (lv_assert_13_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Rationale ( (lv_rationale_15_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Refined otherlv_17= To ( ( ruleQualifiedName ) ) (otherlv_19= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_21_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_22= Decomposed otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_27= Evolved otherlv_28= To ( ( ruleQualifiedName ) ) (otherlv_30= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_32= Conflicts otherlv_33= With ( ( ruleQualifiedName ) ) (otherlv_35= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_37= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= See otherlv_42= Goal ( ( ruleQualifiedName ) ) (otherlv_44= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_46= See otherlv_47= Requirement ( ( ruleQualifiedName ) ) (otherlv_49= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_51= See otherlv_52= Document ( (lv_docReference_53_0= ruleExternalDocument ) ) (otherlv_54= Comma ( (lv_docReference_55_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_12 = input.LA(1);

                         
                        int index22_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA22_12 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) ) {s = 13;}

                        else if ( LA22_12 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) ) {s = 14;}

                        else if ( LA22_12 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) {s = 15;}

                         
                        input.seek(index22_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_0 = input.LA(1);

                         
                        int index22_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA22_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA22_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA22_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA22_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA22_0 ==Refined && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA22_0 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA22_0 ==Decomposed && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA22_0 ==Evolved && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( LA22_0 ==Conflicts && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8) ) {s = 10;}

                        else if ( LA22_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9) ) {s = 11;}

                        else if ( LA22_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) ) {s = 12;}

                         
                        input.seek(index22_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA34_eotS =
        "\22\uffff";
    static final String DFA34_eofS =
        "\22\uffff";
    static final String DFA34_minS =
        "\1\5\6\uffff\1\6\4\uffff\1\55\2\uffff\1\0\2\uffff";
    static final String DFA34_maxS =
        "\1\54\6\uffff\1\30\4\uffff\1\55\2\uffff\1\0\2\uffff";
    static final String DFA34_acceptS =
        "\1\uffff\1\16\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\11\1\12\1"+
        "\uffff\1\14\1\15\1\uffff\1\6\1\13";
    static final String DFA34_specialS =
        "\1\0\6\uffff\1\1\4\uffff\1\3\2\uffff\1\2\2\uffff}>";
    static final String[] DFA34_transitionS = {
            "\1\3\1\11\1\uffff\1\12\1\uffff\1\4\1\uffff\1\6\1\2\2\uffff"+
            "\1\13\1\uffff\1\10\1\5\7\uffff\1\7\20\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\7\uffff\1\16\11\uffff\1\14",
            "",
            "",
            "",
            "",
            "\1\17",
            "",
            "",
            "\1\uffff",
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
            return "()* loopback of 1550:3: ( ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Description ( (lv_description_11_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Constants ( (lv_constants_13_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= RULE_STRING ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= See otherlv_19= Goal ( ( ruleQualifiedName ) ) (otherlv_21= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_23= Refined otherlv_24= To ( ( ruleQualifiedName ) ) (otherlv_26= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_28_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_29= Decomposed otherlv_30= To ( ( ruleQualifiedName ) ) (otherlv_32= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_34= Evolves ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= See otherlv_39= Goal ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= See otherlv_44= Requirement ( ( ruleQualifiedName ) ) (otherlv_46= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_48= See otherlv_49= Document ( (lv_docReference_50_0= ruleExternalDocument ) ) (otherlv_51= Comma ( (lv_docReference_52_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_0 = input.LA(1);

                         
                        int index34_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA34_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA34_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA34_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA34_0 ==Constants && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA34_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA34_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA34_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 12) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 11) ) ) {s = 7;}

                        else if ( LA34_0 ==Refined && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA34_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( LA34_0 ==Decomposed && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 8) ) {s = 10;}

                        else if ( LA34_0 ==Evolves && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 9) ) {s = 11;}

                         
                        input.seek(index34_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA34_7 = input.LA(1);

                         
                        int index34_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA34_7 ==Goal && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) ) {s = 12;}

                        else if ( LA34_7 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 11) ) {s = 13;}

                        else if ( LA34_7 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 12) ) {s = 14;}

                         
                        input.seek(index34_7);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA34_15 = input.LA(1);

                         
                        int index34_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) ) {s = 17;}

                         
                        input.seek(index34_15);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA34_12 = input.LA(1);

                         
                        int index34_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA34_12 ==RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_5(), 5) ) ) {s = 15;}

                         
                        input.seek(index34_12);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_ruleReqSpec_in_entryRuleReqSpec67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpec77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecLibrary_in_ruleReqSpec124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemSpec_in_ruleReqSpec143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholderGoals_in_ruleReqSpec162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_ruleReqSpec181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSystemSpec_in_entryRuleSystemSpec224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSystemSpec234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Specification_in_ruleSystemSpec272 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemSpec288 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_For_in_ruleSystemSpec306 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleSystemSpec328 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleSystemSpec341 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSystemSpec363 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleSystemSpec376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholderGoals_in_entryRuleStakeholderGoals410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholderGoals420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goals_in_ruleStakeholderGoals458 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholderGoals474 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals492 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleStakeholderGoals514 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleStakeholderGoals527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_entryRuleReqDocument561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqDocument571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Document_in_ruleReqDocument609 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqDocument625 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqDocument643 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleReqDocument665 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqDocument678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecLibrary_in_entryRuleReqSpecLibrary712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecLibrary722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Library_in_ruleReqSpecLibrary760 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecLibrary776 = new BitSet(new long[]{0x0000080004400000L});
    public static final BitSet FOLLOW_Import_in_ruleReqSpecLibrary795 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleReqSpecLibrary815 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecLibrary831 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecLibrary853 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary868 = new BitSet(new long[]{0x0000100001300440L});
    public static final BitSet FOLLOW_Constants_in_ruleReqSpecLibrary881 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleFinalValue_in_ruleReqSpecLibrary901 = new BitSet(new long[]{0x0000300001300040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecLibrary927 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecLibrary946 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_ruleHazard_in_ruleReqSpecLibrary965 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecLibrary984 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1036 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1094 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildCard1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecFolder1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleReqSpecFolder1202 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecFolder1218 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1236 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecFolder1258 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecFolder1277 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_ruleHazard_in_ruleReqSpecFolder1296 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1315 = new BitSet(new long[]{0x0000100001300040L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal1366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal1414 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1430 = new BitSet(new long[]{0x0000088004000000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoal1449 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1469 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_For_in_ruleGoal1485 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1504 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal1519 = new BitSet(new long[]{0x00001000090CB3A0L});
    public static final BitSet FOLLOW_Category_in_ruleGoal1577 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal1599 = new BitSet(new long[]{0x00001000090CB3A0L});
    public static final BitSet FOLLOW_Description_in_ruleGoal1668 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal1688 = new BitSet(new long[]{0x00001000090CB3A0L});
    public static final BitSet FOLLOW_Assert_in_ruleGoal1757 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleGoal1777 = new BitSet(new long[]{0x00001000090CB3A0L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal1846 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleGoal1862 = new BitSet(new long[]{0x00001000090CB3A0L});
    public static final BitSet FOLLOW_Refined_in_ruleGoal1936 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal1948 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal1970 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal1984 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2006 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoal2084 = new BitSet(new long[]{0x00001000090CB3A0L});
    public static final BitSet FOLLOW_Decomposed_in_ruleGoal2153 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2165 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2187 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2201 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2223 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Evolved_in_ruleGoal2294 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2306 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2328 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2342 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2364 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2435 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_With_in_ruleGoal2447 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2469 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2483 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2505 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2576 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2598 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2612 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2634 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2705 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal2717 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2739 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2753 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2775 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2846 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal2858 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2880 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2894 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2916 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2987 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal2999 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3019 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3033 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3053 = new BitSet(new long[]{0x00001010090CB3A0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal3109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement3143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement3153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement3191 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3207 = new BitSet(new long[]{0x0000088004000000L});
    public static final BitSet FOLLOW_Colon_in_ruleRequirement3226 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3246 = new BitSet(new long[]{0x0000080004000000L});
    public static final BitSet FOLLOW_For_in_ruleRequirement3262 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3281 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3296 = new BitSet(new long[]{0x00001000080D3560L});
    public static final BitSet FOLLOW_Category_in_ruleRequirement3354 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3376 = new BitSet(new long[]{0x00001000080D3560L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3445 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3465 = new BitSet(new long[]{0x00001000080D3560L});
    public static final BitSet FOLLOW_Constants_in_ruleRequirement3534 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleFinalValue_in_ruleRequirement3554 = new BitSet(new long[]{0x00003000080D3560L});
    public static final BitSet FOLLOW_Assert_in_ruleRequirement3624 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleRequirement3644 = new BitSet(new long[]{0x00001000080D3560L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement3713 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleRequirement3729 = new BitSet(new long[]{0x00001000080D3560L});
    public static final BitSet FOLLOW_See_in_ruleRequirement3803 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement3815 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3837 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement3851 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3873 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Refined_in_ruleRequirement3944 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_To_in_ruleRequirement3956 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement3978 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement3992 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4014 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleRequirement4092 = new BitSet(new long[]{0x00001000080D3560L});
    public static final BitSet FOLLOW_Decomposed_in_ruleRequirement4161 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_To_in_ruleRequirement4173 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4195 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4209 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4231 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Evolves_in_ruleRequirement4302 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4324 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4338 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4360 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4431 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4443 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4465 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4479 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4501 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4572 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement4584 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4606 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4620 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4642 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4713 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement4725 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4745 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4759 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement4779 = new BitSet(new long[]{0x00001010080D3560L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement4835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazard_in_entryRuleHazard4869 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazard4879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hazard_in_ruleHazard4917 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard4933 = new BitSet(new long[]{0x0000088004001820L});
    public static final BitSet FOLLOW_Colon_in_ruleHazard4952 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard4972 = new BitSet(new long[]{0x0000080004001820L});
    public static final BitSet FOLLOW_For_in_ruleHazard5034 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard5053 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleHazard5068 = new BitSet(new long[]{0x0000180004003820L});
    public static final BitSet FOLLOW_Category_in_ruleHazard5081 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleHazard5103 = new BitSet(new long[]{0x0000180004001820L});
    public static final BitSet FOLLOW_Description_in_ruleHazard5174 = new BitSet(new long[]{0x0000A00000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleHazard5194 = new BitSet(new long[]{0x0000180004001820L});
    public static final BitSet FOLLOW_Mitigated_in_ruleHazard5263 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_By_in_ruleHazard5275 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleHazard5297 = new BitSet(new long[]{0x0000181004001820L});
    public static final BitSet FOLLOW_Comma_in_ruleHazard5311 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleHazard5333 = new BitSet(new long[]{0x0000181004001820L});
    public static final BitSet FOLLOW_Rationale_in_ruleHazard5404 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleHazard5420 = new BitSet(new long[]{0x0000180004001820L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleHazard5485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument5519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument5529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument5575 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument5589 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument5609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH5647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH5658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5699 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH5717 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5734 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH5752 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH5767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT5812 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT5823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5863 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT5882 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT5897 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription5945 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription5955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription6000 = new BitSet(new long[]{0x0000A00000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6035 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement6045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement6087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement6118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath6153 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath6163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath6208 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath6222 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath6242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression6278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePredicateExpression6288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression6324 = new BitSet(new long[]{0x0000070190000000L});
    public static final BitSet FOLLOW_EqualsSign_in_rulePredicateExpression6344 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression6372 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_LessThanSign_in_rulePredicateExpression6400 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_EqualsSignLessThanSign_in_rulePredicateExpression6428 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GreaterThanSign_in_rulePredicateExpression6456 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression6484 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression6509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFinalValue_in_entryRuleFinalValue6543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFinalValue6553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFinalValue6595 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleFinalValue6613 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleFinalValue6633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString6669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString6680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString6719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference6763 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference6774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6815 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference6833 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6850 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference6869 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference6884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef6931 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef6942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef6981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7025 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7076 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName7095 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7110 = new BitSet(new long[]{0x0000002000000002L});

}
