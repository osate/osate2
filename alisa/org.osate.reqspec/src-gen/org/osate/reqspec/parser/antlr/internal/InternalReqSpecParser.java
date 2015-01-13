package org.osate.reqspec.parser.antlr.internal; 

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
import org.osate.reqspec.services.ReqSpecGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalReqSpecParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Specification", "Description", "Requirement", "Stakeholder", "Decomposed", "Parameters", "Conflicts", "Mitigated", "Rationale", "Category", "Document", "Evolved", "Evolves", "Library", "Refined", "Warning", "Assert", "Folder", "Hazard", "Issues", "Error", "Goals", "Title", "Goal", "Info", "With", "ApostropheApostropheApostrophe", "For", "See", "ExclamationMarkEqualsSign", "ColonColon", "EqualsSignLessThanSign", "GreaterThanSignEqualsSign", "By", "Of", "To", "NumberSign", "LeftParenthesis", "RightParenthesis", "Comma", "FullStop", "Solidus", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Parameters=9;
    public static final int RULE_ID=52;
    public static final int RightParenthesis=42;
    public static final int Specification=4;
    public static final int Mitigated=11;
    public static final int Assert=20;
    public static final int Evolved=15;
    public static final int RULE_ANY_OTHER=58;
    public static final int LeftParenthesis=41;
    public static final int Issues=23;
    public static final int RightSquareBracket=51;
    public static final int Requirement=6;
    public static final int Library=17;
    public static final int Solidus=45;
    public static final int EOF=-1;
    public static final int GreaterThanSign=49;
    public static final int FullStop=44;
    public static final int Evolves=16;
    public static final int EqualsSignLessThanSign=35;
    public static final int To=39;
    public static final int ApostropheApostropheApostrophe=30;
    public static final int LessThanSign=47;
    public static final int RULE_INT=53;
    public static final int LeftSquareBracket=50;
    public static final int Conflicts=10;
    public static final int ExclamationMarkEqualsSign=33;
    public static final int Hazard=22;
    public static final int Stakeholder=7;
    public static final int Decomposed=8;
    public static final int Refined=18;
    public static final int Warning=19;
    public static final int Colon=46;
    public static final int RULE_SL_COMMENT=56;
    public static final int For=31;
    public static final int NumberSign=40;
    public static final int Rationale=12;
    public static final int With=29;
    public static final int RULE_ML_COMMENT=55;
    public static final int Goal=27;
    public static final int By=37;
    public static final int Goals=25;
    public static final int ColonColon=34;
    public static final int Description=5;
    public static final int Document=14;
    public static final int Folder=21;
    public static final int RULE_STRING=54;
    public static final int See=32;
    public static final int Title=26;
    public static final int Error=24;
    public static final int GreaterThanSignEqualsSign=36;
    public static final int Category=13;
    public static final int RULE_WS=57;
    public static final int Info=28;
    public static final int Comma=43;
    public static final int EqualsSign=48;
    public static final int Of=38;

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:62:1: entryRuleReqSpec returns [EObject current=null] : iv_ruleReqSpec= ruleReqSpec EOF ;
    public final EObject entryRuleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpec = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:63:2: (iv_ruleReqSpec= ruleReqSpec EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:64:2: iv_ruleReqSpec= ruleReqSpec EOF
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:71:1: ruleReqSpec returns [EObject current=null] : ( ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) ) ) ;
    public final EObject ruleReqSpec() throws RecognitionException {
        EObject current = null;

        EObject lv_contents_0_1 = null;

        EObject lv_contents_0_2 = null;

        EObject lv_contents_0_3 = null;

        EObject lv_contents_0_4 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:74:28: ( ( ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:1: ( ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:75:1: ( ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:76:1: ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:76:1: ( (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:77:1: (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:77:1: (lv_contents_0_1= ruleReqSpecLibrary | lv_contents_0_2= ruleSystemSpec | lv_contents_0_3= ruleStakeholderGoals | lv_contents_0_4= ruleReqDocument )
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:78:3: lv_contents_0_1= ruleReqSpecLibrary
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:93:8: lv_contents_0_2= ruleSystemSpec
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:108:8: lv_contents_0_3= ruleStakeholderGoals
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:123:8: lv_contents_0_4= ruleReqDocument
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:155:1: entryRuleSystemSpec returns [EObject current=null] : iv_ruleSystemSpec= ruleSystemSpec EOF ;
    public final EObject entryRuleSystemSpec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystemSpec = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:156:2: (iv_ruleSystemSpec= ruleSystemSpec EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:157:2: iv_ruleSystemSpec= ruleSystemSpec EOF
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:164:1: ruleSystemSpec returns [EObject current=null] : (otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket ) ;
    public final EObject ruleSystemSpec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:167:28: ( (otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:168:1: (otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:168:1: (otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:169:2: otherlv_0= Specification ( (lv_name_1_0= RULE_ID ) ) otherlv_2= For ( ( ruleAadlClassifierReference ) ) otherlv_4= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_6= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Specification,FOLLOW_Specification_in_ruleSystemSpec272); 

                	newLeafNode(otherlv_0, grammarAccess.getSystemSpecAccess().getSpecificationKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:173:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:174:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:174:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:175:3: lv_name_1_0= RULE_ID
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
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:196:1: ( ( ruleAadlClassifierReference ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:197:1: ( ruleAadlClassifierReference )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:197:1: ( ruleAadlClassifierReference )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:198:3: ruleAadlClassifierReference
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
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:216:1: ( ( ruleQualifiedName ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:217:1: ( ruleQualifiedName )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:217:1: ( ruleQualifiedName )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:218:3: ruleQualifiedName
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:244:1: entryRuleStakeholderGoals returns [EObject current=null] : iv_ruleStakeholderGoals= ruleStakeholderGoals EOF ;
    public final EObject entryRuleStakeholderGoals() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStakeholderGoals = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:245:2: (iv_ruleStakeholderGoals= ruleStakeholderGoals EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:246:2: iv_ruleStakeholderGoals= ruleStakeholderGoals EOF
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:253:1: ruleStakeholderGoals returns [EObject current=null] : (otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket ) ;
    public final EObject ruleStakeholderGoals() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:256:28: ( (otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:257:1: (otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:257:1: (otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:258:2: otherlv_0= Goals ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goals,FOLLOW_Goals_in_ruleStakeholderGoals458); 

                	newLeafNode(otherlv_0, grammarAccess.getStakeholderGoalsAccess().getGoalsKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:262:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:263:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:263:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:264:3: lv_name_1_0= RULE_ID
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
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:285:1: ( ( ruleQualifiedName ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:286:1: ( ruleQualifiedName )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:286:1: ( ruleQualifiedName )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:287:3: ruleQualifiedName
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:313:1: entryRuleReqDocument returns [EObject current=null] : iv_ruleReqDocument= ruleReqDocument EOF ;
    public final EObject entryRuleReqDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:314:2: (iv_ruleReqDocument= ruleReqDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:315:2: iv_ruleReqDocument= ruleReqDocument EOF
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:322:1: ruleReqDocument returns [EObject current=null] : (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket ) ;
    public final EObject ruleReqDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:325:28: ( (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:326:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:326:1: (otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:327:2: otherlv_0= Document ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ruleQualifiedName ) ) otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Document,FOLLOW_Document_in_ruleReqDocument609); 

                	newLeafNode(otherlv_0, grammarAccess.getReqDocumentAccess().getDocumentKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:331:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:332:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:332:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:333:3: lv_name_1_0= RULE_ID
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
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:354:1: ( ( ruleQualifiedName ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:355:1: ( ruleQualifiedName )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:355:1: ( ruleQualifiedName )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:356:3: ruleQualifiedName
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:382:1: entryRuleReqSpecLibrary returns [EObject current=null] : iv_ruleReqSpecLibrary= ruleReqSpecLibrary EOF ;
    public final EObject entryRuleReqSpecLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecLibrary = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:383:2: (iv_ruleReqSpecLibrary= ruleReqSpecLibrary EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:384:2: iv_ruleReqSpecLibrary= ruleReqSpecLibrary EOF
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:391:1: ruleReqSpecLibrary returns [EObject current=null] : (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) ;
    public final EObject ruleReqSpecLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_content_5_1 = null;

        EObject lv_content_5_2 = null;

        EObject lv_content_5_3 = null;

        EObject lv_content_5_4 = null;

        AntlrDatatypeRuleToken lv_issue_8_0 = null;

        AntlrDatatypeRuleToken lv_issue_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:394:28: ( (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:395:1: (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:395:1: (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:396:2: otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Library,FOLLOW_Library_in_ruleReqSpecLibrary760); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecLibraryAccess().getLibraryKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:400:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:401:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:401:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:402:3: lv_name_1_0= RULE_ID
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:418:2: (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==For) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:419:2: otherlv_2= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecLibrary795); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecLibraryAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:423:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:424:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:424:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:425:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecLibraryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getTargetClassifierCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecLibrary817);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary832); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecLibraryAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:443:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Requirement||(LA4_0>=Folder && LA4_0<=Hazard)||LA4_0==Goal) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:444:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:444:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:445:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:445:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder )
            	    int alt3=4;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt3=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt3=2;
            	        }
            	        break;
            	    case Hazard:
            	        {
            	        alt3=3;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt3=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 3, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt3) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:446:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecLibrary854);
            	            lv_content_5_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:461:8: lv_content_5_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentRequirementParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecLibrary873);
            	            lv_content_5_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:476:8: lv_content_5_3= ruleHazard
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentHazardParserRuleCall_4_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleHazard_in_ruleReqSpecLibrary892);
            	            lv_content_5_3=ruleHazard();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_3, 
            	                    		"Hazard");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:491:8: lv_content_5_4= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentReqSpecFolderParserRuleCall_4_0_3()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecLibrary911);
            	            lv_content_5_4=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_4, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:509:3: (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Issues) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:510:2: otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket
                    {
                    otherlv_6=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecLibrary929); 

                        	newLeafNode(otherlv_6, grammarAccess.getReqSpecLibraryAccess().getIssuesKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary941); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecLibraryAccess().getLeftSquareBracketKeyword_5_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:519:1: ( (lv_issue_8_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:520:1: (lv_issue_8_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:520:1: (lv_issue_8_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:521:3: lv_issue_8_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getIssueMultiLineStringParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqSpecLibrary961);
                    lv_issue_8_0=ruleMultiLineString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
                    	        }
                           		add(
                           			current, 
                           			"issue",
                            		lv_issue_8_0, 
                            		"MultiLineString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:537:2: (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==Comma) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:538:2: otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecLibrary975); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getReqSpecLibraryAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:542:1: ( (lv_issue_10_0= ruleMultiLineString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:543:1: (lv_issue_10_0= ruleMultiLineString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:543:1: (lv_issue_10_0= ruleMultiLineString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:544:3: lv_issue_10_0= ruleMultiLineString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getIssueMultiLineStringParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqSpecLibrary995);
                    	    lv_issue_10_0=ruleMultiLineString();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issue",
                    	            		lv_issue_10_0, 
                    	            		"MultiLineString");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1010); 

                        	newLeafNode(otherlv_11, grammarAccess.getReqSpecLibraryAccess().getRightSquareBracketKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1024); 

                	newLeafNode(otherlv_12, grammarAccess.getReqSpecLibraryAccess().getRightSquareBracketKeyword_6());
                

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


    // $ANTLR start "entryRuleReqSpecFolder"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:578:1: entryRuleReqSpecFolder returns [EObject current=null] : iv_ruleReqSpecFolder= ruleReqSpecFolder EOF ;
    public final EObject entryRuleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:579:2: (iv_ruleReqSpecFolder= ruleReqSpecFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:580:2: iv_ruleReqSpecFolder= ruleReqSpecFolder EOF
            {
             newCompositeNode(grammarAccess.getReqSpecFolderRule()); 
            pushFollow(FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1058);
            iv_ruleReqSpecFolder=ruleReqSpecFolder();

            state._fsp--;

             current =iv_ruleReqSpecFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecFolder1068); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:587:1: ruleReqSpecFolder returns [EObject current=null] : (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) ;
    public final EObject ruleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_label_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_content_5_1 = null;

        EObject lv_content_5_2 = null;

        EObject lv_content_5_3 = null;

        EObject lv_content_5_4 = null;

        AntlrDatatypeRuleToken lv_issue_8_0 = null;

        AntlrDatatypeRuleToken lv_issue_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:590:28: ( (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:591:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:591:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:592:2: otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleReqSpecFolder1106); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:596:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:597:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:597:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:598:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecFolder1122); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:614:2: (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==For) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:615:2: otherlv_2= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecFolder1141); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecFolderAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:619:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:620:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:620:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:621:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecFolderRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getTargetClassifierCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecFolder1163);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1178); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:639:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==Requirement||(LA9_0>=Folder && LA9_0<=Hazard)||LA9_0==Goal) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:640:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:640:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:641:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:641:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder )
            	    int alt8=4;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt8=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt8=2;
            	        }
            	        break;
            	    case Hazard:
            	        {
            	        alt8=3;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt8=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt8) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:642:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecFolder1200);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:657:8: lv_content_5_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentRequirementParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecFolder1219);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:672:8: lv_content_5_3= ruleHazard
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentHazardParserRuleCall_4_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleHazard_in_ruleReqSpecFolder1238);
            	            lv_content_5_3=ruleHazard();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_3, 
            	                    		"Hazard");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:687:8: lv_content_5_4= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentReqSpecFolderParserRuleCall_4_0_3()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1257);
            	            lv_content_5_4=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_5_4, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:705:3: (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Issues) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:706:2: otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket
                    {
                    otherlv_6=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecFolder1275); 

                        	newLeafNode(otherlv_6, grammarAccess.getReqSpecFolderAccess().getIssuesKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1287); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_5_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:715:1: ( (lv_issue_8_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:716:1: (lv_issue_8_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:716:1: (lv_issue_8_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:717:3: lv_issue_8_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getIssueMultiLineStringParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqSpecFolder1307);
                    lv_issue_8_0=ruleMultiLineString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
                    	        }
                           		add(
                           			current, 
                           			"issue",
                            		lv_issue_8_0, 
                            		"MultiLineString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:733:2: (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==Comma) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:734:2: otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecFolder1321); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getReqSpecFolderAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:738:1: ( (lv_issue_10_0= ruleMultiLineString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:739:1: (lv_issue_10_0= ruleMultiLineString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:739:1: (lv_issue_10_0= ruleMultiLineString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:740:3: lv_issue_10_0= ruleMultiLineString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getIssueMultiLineStringParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqSpecFolder1341);
                    	    lv_issue_10_0=ruleMultiLineString();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecFolderRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issue",
                    	            		lv_issue_10_0, 
                    	            		"MultiLineString");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1356); 

                        	newLeafNode(otherlv_11, grammarAccess.getReqSpecFolderAccess().getRightSquareBracketKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1370); 

                	newLeafNode(otherlv_12, grammarAccess.getReqSpecFolderAccess().getRightSquareBracketKeyword_6());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:774:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:775:2: (iv_ruleGoal= ruleGoal EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:776:2: iv_ruleGoal= ruleGoal EOF
            {
             newCompositeNode(grammarAccess.getGoalRule()); 
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal1404);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal1414); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:783:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket ) ;
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
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_34=null;
        Token otherlv_36=null;
        Token otherlv_38=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_45=null;
        Token otherlv_47=null;
        Token otherlv_48=null;
        Token otherlv_50=null;
        Token otherlv_52=null;
        Token otherlv_53=null;
        Token otherlv_55=null;
        Token otherlv_57=null;
        Token otherlv_58=null;
        Token otherlv_60=null;
        Token otherlv_62=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_13_0 = null;

        EObject lv_assert_15_0 = null;

        AntlrDatatypeRuleToken lv_rationale_17_0 = null;

        AntlrDatatypeRuleToken lv_issue_19_0 = null;

        AntlrDatatypeRuleToken lv_issue_21_0 = null;

        EObject lv_subgoal_27_0 = null;

        EObject lv_docReference_59_0 = null;

        EObject lv_docReference_61_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:786:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:787:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:787:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:788:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal1452); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:792:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:793:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:793:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:794:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1468); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:810:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==Colon) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:811:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoal1487); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:815:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:816:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:816:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:817:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1507);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:833:4: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==For) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:834:2: otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleGoal1523); 

                        	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:838:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:839:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:839:1: (otherlv_5= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:840:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGoalRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1542); 

                    		newLeafNode(otherlv_5, grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_3_1_0()); 
                    	

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:851:2: (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==Of) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:852:2: otherlv_6= Of ( ( ruleAadlClassifierReference ) )
                            {
                            otherlv_6=(Token)match(input,Of,FOLLOW_Of_in_ruleGoal1556); 

                                	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getOfKeyword_3_2_0());
                                
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:856:1: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:857:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:857:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:858:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getGoalRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getGoalAccess().getTargetContextClassifierCrossReference_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleGoal1578);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal1595); 

                	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:876:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:878:1: ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:878:1: ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:879:2: ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:882:2: ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:883:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:883:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop25:
            do {
                int alt25=15;
                alt25 = dfa25.predict(input);
                switch (alt25) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:885:4: ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:885:4: ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:886:5: {...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:886:101: ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:887:6: ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:890:6: ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:890:7: {...}? => (otherlv_10= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:890:16: (otherlv_10= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:891:2: otherlv_10= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_10=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal1653); 

            	        	newLeafNode(otherlv_10, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:895:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:897:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal1675);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:917:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:917:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:918:5: {...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:918:101: ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:922:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:922:7: {...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:922:16: (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:923:2: otherlv_12= Description ( (lv_description_13_0= ruleDescription ) )
            	    {
            	    otherlv_12=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal1744); 

            	        	newLeafNode(otherlv_12, grammarAccess.getGoalAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:927:1: ( (lv_description_13_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:928:1: (lv_description_13_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:928:1: (lv_description_13_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:929:3: lv_description_13_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal1764);
            	    lv_description_13_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_13_0, 
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:952:4: ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:952:4: ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:953:5: {...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:953:101: ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:954:6: ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:957:6: ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:957:7: {...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:957:16: (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:958:2: otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) )
            	    {
            	    otherlv_14=(Token)match(input,Assert,FOLLOW_Assert_in_ruleGoal1833); 

            	        	newLeafNode(otherlv_14, grammarAccess.getGoalAccess().getAssertKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:962:1: ( (lv_assert_15_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:963:1: (lv_assert_15_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:963:1: (lv_assert_15_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:964:3: lv_assert_15_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getAssertPredicateExpressionParserRuleCall_5_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleGoal1853);
            	    lv_assert_15_0=rulePredicateExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:987:4: ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:987:4: ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:988:5: {...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:988:101: ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:989:6: ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:992:6: ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:992:7: {...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:992:16: (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:993:2: otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) )
            	    {
            	    otherlv_16=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal1922); 

            	        	newLeafNode(otherlv_16, grammarAccess.getGoalAccess().getRationaleKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:997:1: ( (lv_rationale_17_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:998:1: (lv_rationale_17_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:998:1: (lv_rationale_17_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:999:3: lv_rationale_17_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleMultiLineStringParserRuleCall_5_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleGoal1942);
            	    lv_rationale_17_0=ruleMultiLineString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_17_0, 
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
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1022:4: ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1022:4: ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1023:5: {...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1023:101: ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1024:6: ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1027:6: ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1027:7: {...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1027:16: (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1028:2: otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )*
            	    {
            	    otherlv_18=(Token)match(input,Issues,FOLLOW_Issues_in_ruleGoal2011); 

            	        	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getIssuesKeyword_5_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1032:1: ( (lv_issue_19_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1033:1: (lv_issue_19_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1033:1: (lv_issue_19_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1034:3: lv_issue_19_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueMultiLineStringParserRuleCall_5_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleGoal2031);
            	    lv_issue_19_0=ruleMultiLineString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_19_0, 
            	            		"MultiLineString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1050:2: (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==Comma) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1051:2: otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) )
            	    	    {
            	    	    otherlv_20=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2045); 

            	    	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getCommaKeyword_5_4_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1055:1: ( (lv_issue_21_0= ruleMultiLineString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1056:1: (lv_issue_21_0= ruleMultiLineString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1056:1: (lv_issue_21_0= ruleMultiLineString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1057:3: lv_issue_21_0= ruleMultiLineString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueMultiLineStringParserRuleCall_5_4_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleGoal2065);
            	    	    lv_issue_21_0=ruleMultiLineString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_21_0, 
            	    	            		"MultiLineString");
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
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1080:4: ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1080:4: ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1081:5: {...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1081:101: ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1082:6: ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1085:6: ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1085:7: {...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1085:16: (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1086:2: otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_22=(Token)match(input,Refined,FOLLOW_Refined_in_ruleGoal2136); 

            	        	newLeafNode(otherlv_22, grammarAccess.getGoalAccess().getRefinedKeyword_5_5_0());
            	        
            	    otherlv_23=(Token)match(input,To,FOLLOW_To_in_ruleGoal2148); 

            	        	newLeafNode(otherlv_23, grammarAccess.getGoalAccess().getToKeyword_5_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1095:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1096:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1096:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1097:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2170);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1110:2: (otherlv_25= Comma ( ( ruleQualifiedName ) ) )*
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==Comma) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1111:2: otherlv_25= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_25=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2184); 

            	    	        	newLeafNode(otherlv_25, grammarAccess.getGoalAccess().getCommaKeyword_5_5_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1115:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1116:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1116:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1117:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2206);
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
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1137:4: ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1137:4: ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1138:5: {...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1138:101: ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1139:6: ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:6: ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==Goal) ) {
            	            int LA17_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt17=1;
            	            }


            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:7: {...}? => ( (lv_subgoal_27_0= ruleGoal ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:16: ( (lv_subgoal_27_0= ruleGoal ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:1: (lv_subgoal_27_0= ruleGoal )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:1: (lv_subgoal_27_0= ruleGoal )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1144:3: lv_subgoal_27_0= ruleGoal
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSubgoalGoalParserRuleCall_5_6_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleGoal_in_ruleGoal2284);
            	    	    lv_subgoal_27_0=ruleGoal();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"subgoal",
            	    	            		lv_subgoal_27_0, 
            	    	            		"Goal");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1167:4: ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1167:4: ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1168:5: {...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1168:101: ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1169:6: ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:6: ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:7: {...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:16: (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1173:2: otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_28=(Token)match(input,Decomposed,FOLLOW_Decomposed_in_ruleGoal2353); 

            	        	newLeafNode(otherlv_28, grammarAccess.getGoalAccess().getDecomposedKeyword_5_7_0());
            	        
            	    otherlv_29=(Token)match(input,To,FOLLOW_To_in_ruleGoal2365); 

            	        	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getToKeyword_5_7_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1182:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1183:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1183:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1184:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_5_7_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2387);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1197:2: (otherlv_31= Comma ( ( ruleQualifiedName ) ) )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==Comma) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1198:2: otherlv_31= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_31=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2401); 

            	    	        	newLeafNode(otherlv_31, grammarAccess.getGoalAccess().getCommaKeyword_5_7_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1202:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1203:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1204:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_5_7_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2423);
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
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1224:4: ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1224:4: ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1225:5: {...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1225:101: ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1226:6: ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1229:6: ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1229:7: {...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1229:16: (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1230:2: otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_33=(Token)match(input,Evolved,FOLLOW_Evolved_in_ruleGoal2494); 

            	        	newLeafNode(otherlv_33, grammarAccess.getGoalAccess().getEvolvedKeyword_5_8_0());
            	        
            	    otherlv_34=(Token)match(input,To,FOLLOW_To_in_ruleGoal2506); 

            	        	newLeafNode(otherlv_34, grammarAccess.getGoalAccess().getToKeyword_5_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1239:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1240:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1240:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1241:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_5_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2528);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1254:2: (otherlv_36= Comma ( ( ruleQualifiedName ) ) )*
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==Comma) ) {
            	            alt19=1;
            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1255:2: otherlv_36= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_36=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2542); 

            	    	        	newLeafNode(otherlv_36, grammarAccess.getGoalAccess().getCommaKeyword_5_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1259:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1260:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1260:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1261:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_5_8_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2564);
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
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1281:4: ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1281:4: ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1282:5: {...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1282:101: ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1283:6: ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1286:6: ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1286:7: {...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1286:16: (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1287:2: otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_38=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2635); 

            	        	newLeafNode(otherlv_38, grammarAccess.getGoalAccess().getConflictsKeyword_5_9_0());
            	        
            	    otherlv_39=(Token)match(input,With,FOLLOW_With_in_ruleGoal2647); 

            	        	newLeafNode(otherlv_39, grammarAccess.getGoalAccess().getWithKeyword_5_9_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1296:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1297:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1297:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1298:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_9_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2669);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1311:2: (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Comma) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1312:2: otherlv_41= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2683); 

            	    	        	newLeafNode(otherlv_41, grammarAccess.getGoalAccess().getCommaKeyword_5_9_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1316:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1317:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1317:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1318:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_9_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2705);
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
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1338:4: ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1338:4: ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1339:5: {...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1339:102: ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1340:6: ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1343:6: ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1343:7: {...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1343:16: (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1344:2: otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_43=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2776); 

            	        	newLeafNode(otherlv_43, grammarAccess.getGoalAccess().getStakeholderKeyword_5_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1348:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1349:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1349:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1350:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2798);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1363:2: (otherlv_45= Comma ( ( ruleQualifiedName ) ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==Comma) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1364:2: otherlv_45= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_45=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2812); 

            	    	        	newLeafNode(otherlv_45, grammarAccess.getGoalAccess().getCommaKeyword_5_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1368:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1369:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1369:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1370:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2834);
            	    	    ruleQualifiedName();

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1390:4: ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1390:4: ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1391:5: {...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1391:102: ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1392:6: ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1395:6: ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1395:7: {...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1395:16: (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1396:2: otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_47=(Token)match(input,See,FOLLOW_See_in_ruleGoal2905); 

            	        	newLeafNode(otherlv_47, grammarAccess.getGoalAccess().getSeeKeyword_5_11_0());
            	        
            	    otherlv_48=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal2917); 

            	        	newLeafNode(otherlv_48, grammarAccess.getGoalAccess().getGoalKeyword_5_11_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1405:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1406:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1406:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1407:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_5_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2939);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1420:2: (otherlv_50= Comma ( ( ruleQualifiedName ) ) )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Comma) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1421:2: otherlv_50= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_50=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2953); 

            	    	        	newLeafNode(otherlv_50, grammarAccess.getGoalAccess().getCommaKeyword_5_11_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1425:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1426:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1426:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1427:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_5_11_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2975);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1447:4: ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1447:4: ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1448:5: {...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1448:102: ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1449:6: ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1452:6: ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1452:7: {...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1452:16: (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1453:2: otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_52=(Token)match(input,See,FOLLOW_See_in_ruleGoal3046); 

            	        	newLeafNode(otherlv_52, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0());
            	        
            	    otherlv_53=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal3058); 

            	        	newLeafNode(otherlv_53, grammarAccess.getGoalAccess().getRequirementKeyword_5_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1462:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1463:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1463:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1464:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_5_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3080);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1477:2: (otherlv_55= Comma ( ( ruleQualifiedName ) ) )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==Comma) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1478:2: otherlv_55= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_55=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3094); 

            	    	        	newLeafNode(otherlv_55, grammarAccess.getGoalAccess().getCommaKeyword_5_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1482:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1484:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_5_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3116);
            	    	    ruleQualifiedName();

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1504:4: ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1504:4: ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1505:5: {...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1505:102: ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1506:6: ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:6: ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:7: {...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:16: (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1510:2: otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_57=(Token)match(input,See,FOLLOW_See_in_ruleGoal3187); 

            	        	newLeafNode(otherlv_57, grammarAccess.getGoalAccess().getSeeKeyword_5_13_0());
            	        
            	    otherlv_58=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal3199); 

            	        	newLeafNode(otherlv_58, grammarAccess.getGoalAccess().getDocumentKeyword_5_13_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1519:1: ( (lv_docReference_59_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1520:1: (lv_docReference_59_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1520:1: (lv_docReference_59_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1521:3: lv_docReference_59_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_13_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3219);
            	    lv_docReference_59_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_59_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1537:2: (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Comma) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1538:2: otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_60=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3233); 

            	    	        	newLeafNode(otherlv_60, grammarAccess.getGoalAccess().getCommaKeyword_5_13_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1542:1: ( (lv_docReference_61_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1543:1: (lv_docReference_61_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1543:1: (lv_docReference_61_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1544:3: lv_docReference_61_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_13_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3253);
            	    	    lv_docReference_61_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getGoalRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_61_0, 
            	    	            		"ExternalDocument");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	

            }

            otherlv_62=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal3309); 

                	newLeafNode(otherlv_62, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_6());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1587:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1588:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1589:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement3343);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement3353); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1596:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket ) ;
    public final EObject ruleRequirement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        Token otherlv_33=null;
        Token otherlv_36=null;
        Token otherlv_37=null;
        Token otherlv_39=null;
        Token otherlv_41=null;
        Token otherlv_43=null;
        Token otherlv_45=null;
        Token otherlv_46=null;
        Token otherlv_48=null;
        Token otherlv_50=null;
        Token otherlv_51=null;
        Token otherlv_53=null;
        Token otherlv_55=null;
        Token otherlv_56=null;
        Token otherlv_58=null;
        Token otherlv_60=null;
        AntlrDatatypeRuleToken lv_title_3_0 = null;

        EObject lv_description_14_0 = null;

        EObject lv_parameters_16_0 = null;

        EObject lv_assert_18_0 = null;

        AntlrDatatypeRuleToken lv_rationale_20_0 = null;

        AntlrDatatypeRuleToken lv_issue_22_0 = null;

        AntlrDatatypeRuleToken lv_issue_24_0 = null;

        EObject lv_subrequirement_35_0 = null;

        EObject lv_docReference_57_0 = null;

        EObject lv_docReference_59_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1599:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1600:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1600:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1601:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement3391); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1605:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1607:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3407); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1623:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==Colon) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1624:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleRequirement3426); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1628:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1629:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1629:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1630:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3446);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1646:4: (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==LeftParenthesis) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1647:2: otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis
                    {
                    otherlv_4=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleRequirement3462); 

                        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1651:1: ( ( ruleCatRef ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1652:1: ( ruleCatRef )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1652:1: ( ruleCatRef )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1653:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3484);
                    ruleCatRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleRequirement3497); 

                        	newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getRightParenthesisKeyword_3_2());
                        

                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1671:3: (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==For) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1672:2: otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )?
                    {
                    otherlv_7=(Token)match(input,For,FOLLOW_For_in_ruleRequirement3512); 

                        	newLeafNode(otherlv_7, grammarAccess.getRequirementAccess().getForKeyword_4_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1676:1: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1677:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1677:1: (otherlv_8= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1678:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3531); 

                    		newLeafNode(otherlv_8, grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_4_1_0()); 
                    	

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1689:2: (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==Of) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1690:2: otherlv_9= Of ( ( ruleAadlClassifierReference ) )
                            {
                            otherlv_9=(Token)match(input,Of,FOLLOW_Of_in_ruleRequirement3545); 

                                	newLeafNode(otherlv_9, grammarAccess.getRequirementAccess().getOfKeyword_4_2_0());
                                
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1694:1: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1695:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1695:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1696:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getRequirementRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getRequirementAccess().getTargetContextClassifierCrossReference_4_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleRequirement3567);
                            ruleAadlClassifierReference();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3584); 

                	newLeafNode(otherlv_11, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_5());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1714:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1716:1: ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1716:1: ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1717:2: ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1720:2: ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1721:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1721:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop40:
            do {
                int alt40=14;
                alt40 = dfa40.predict(input);
                switch (alt40) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1723:4: ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1723:4: ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1724:5: {...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1724:108: ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1725:6: ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1728:6: ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1728:7: {...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1728:16: (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1729:2: otherlv_13= Description ( (lv_description_14_0= ruleDescription ) )
            	    {
            	    otherlv_13=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3642); 

            	        	newLeafNode(otherlv_13, grammarAccess.getRequirementAccess().getDescriptionKeyword_6_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1733:1: ( (lv_description_14_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1734:1: (lv_description_14_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1734:1: (lv_description_14_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1735:3: lv_description_14_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_6_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3662);
            	    lv_description_14_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_14_0, 
            	            		"Description");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1758:4: ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1758:4: ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1759:5: {...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1759:108: ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1760:6: ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1763:6: ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1763:7: {...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1763:16: (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1764:2: otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+
            	    {
            	    otherlv_15=(Token)match(input,Parameters,FOLLOW_Parameters_in_ruleRequirement3731); 

            	        	newLeafNode(otherlv_15, grammarAccess.getRequirementAccess().getParametersKeyword_6_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1768:1: ( (lv_parameters_16_0= ruleFinalValue ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1769:1: (lv_parameters_16_0= ruleFinalValue )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1769:1: (lv_parameters_16_0= ruleFinalValue )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1770:3: lv_parameters_16_0= ruleFinalValue
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getParametersFinalValueParserRuleCall_6_1_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleFinalValue_in_ruleRequirement3751);
            	    	    lv_parameters_16_0=ruleFinalValue();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"parameters",
            	    	            		lv_parameters_16_0, 
            	    	            		"FinalValue");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1793:4: ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1793:4: ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1794:5: {...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1794:108: ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1795:6: ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1798:6: ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1798:7: {...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1798:16: (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1799:2: otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) )
            	    {
            	    otherlv_17=(Token)match(input,Assert,FOLLOW_Assert_in_ruleRequirement3821); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getAssertKeyword_6_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1803:1: ( (lv_assert_18_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1804:1: (lv_assert_18_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1804:1: (lv_assert_18_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1805:3: lv_assert_18_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertPredicateExpressionParserRuleCall_6_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleRequirement3841);
            	    lv_assert_18_0=rulePredicateExpression();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"assert",
            	            		lv_assert_18_0, 
            	            		"PredicateExpression");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1828:4: ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1828:4: ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1829:5: {...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1829:108: ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1830:6: ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1833:6: ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1833:7: {...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1833:16: (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1834:2: otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) )
            	    {
            	    otherlv_19=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement3910); 

            	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getRationaleKeyword_6_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1838:1: ( (lv_rationale_20_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1839:1: (lv_rationale_20_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1839:1: (lv_rationale_20_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1840:3: lv_rationale_20_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRationaleMultiLineStringParserRuleCall_6_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleRequirement3930);
            	    lv_rationale_20_0=ruleMultiLineString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_20_0, 
            	            		"MultiLineString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1863:4: ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1863:4: ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1864:5: {...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1864:108: ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1865:6: ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1868:6: ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1868:7: {...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1868:16: (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1869:2: otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )*
            	    {
            	    otherlv_21=(Token)match(input,Issues,FOLLOW_Issues_in_ruleRequirement3999); 

            	        	newLeafNode(otherlv_21, grammarAccess.getRequirementAccess().getIssuesKeyword_6_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1873:1: ( (lv_issue_22_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1874:1: (lv_issue_22_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1874:1: (lv_issue_22_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1875:3: lv_issue_22_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueMultiLineStringParserRuleCall_6_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleRequirement4019);
            	    lv_issue_22_0=ruleMultiLineString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_22_0, 
            	            		"MultiLineString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1891:2: (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Comma) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1892:2: otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) )
            	    	    {
            	    	    otherlv_23=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4033); 

            	    	        	newLeafNode(otherlv_23, grammarAccess.getRequirementAccess().getCommaKeyword_6_4_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:1: ( (lv_issue_24_0= ruleMultiLineString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1897:1: (lv_issue_24_0= ruleMultiLineString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1897:1: (lv_issue_24_0= ruleMultiLineString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1898:3: lv_issue_24_0= ruleMultiLineString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueMultiLineStringParserRuleCall_6_4_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleRequirement4053);
            	    	    lv_issue_24_0=ruleMultiLineString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_24_0, 
            	    	            		"MultiLineString");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1921:4: ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1921:4: ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1922:5: {...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1922:108: ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1923:6: ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:6: ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:7: {...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:16: (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1927:2: otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_25=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4124); 

            	        	newLeafNode(otherlv_25, grammarAccess.getRequirementAccess().getSeeKeyword_6_5_0());
            	        
            	    otherlv_26=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4136); 

            	        	newLeafNode(otherlv_26, grammarAccess.getRequirementAccess().getGoalKeyword_6_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1936:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1937:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1937:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1938:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_6_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4158);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1951:2: (otherlv_28= Comma ( ( ruleQualifiedName ) ) )*
            	    loop32:
            	    do {
            	        int alt32=2;
            	        int LA32_0 = input.LA(1);

            	        if ( (LA32_0==Comma) ) {
            	            alt32=1;
            	        }


            	        switch (alt32) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1952:2: otherlv_28= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_28=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4172); 

            	    	        	newLeafNode(otherlv_28, grammarAccess.getRequirementAccess().getCommaKeyword_6_5_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1956:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1957:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1957:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1958:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_6_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4194);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1978:4: ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1978:4: ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1979:5: {...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1979:108: ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1980:6: ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:6: ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:7: {...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:16: (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1984:2: otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_30=(Token)match(input,Refined,FOLLOW_Refined_in_ruleRequirement4265); 

            	        	newLeafNode(otherlv_30, grammarAccess.getRequirementAccess().getRefinedKeyword_6_6_0());
            	        
            	    otherlv_31=(Token)match(input,To,FOLLOW_To_in_ruleRequirement4277); 

            	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getToKeyword_6_6_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1993:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1994:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1994:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1995:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinedReferenceRequirementCrossReference_6_6_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4299);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2008:2: (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Comma) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2009:2: otherlv_33= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4313); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getCommaKeyword_6_6_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2013:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2014:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2014:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2015:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_6_6_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4335);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2035:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2035:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2036:5: {...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2036:108: ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2037:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2040:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    int cnt34=0;
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==Requirement) ) {
            	            int LA34_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt34=1;
            	            }


            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2040:7: {...}? => ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2040:16: ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2041:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2041:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2042:3: lv_subrequirement_35_0= ruleRequirement
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSubrequirementRequirementParserRuleCall_6_7_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRequirement_in_ruleRequirement4413);
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
            	    	    if ( cnt34 >= 1 ) break loop34;
            	                EarlyExitException eee =
            	                    new EarlyExitException(34, input);
            	                throw eee;
            	        }
            	        cnt34++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2065:4: ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2065:4: ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2066:5: {...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2066:108: ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2067:6: ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2070:6: ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2070:7: {...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2070:16: (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2071:2: otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_36=(Token)match(input,Decomposed,FOLLOW_Decomposed_in_ruleRequirement4482); 

            	        	newLeafNode(otherlv_36, grammarAccess.getRequirementAccess().getDecomposedKeyword_6_8_0());
            	        
            	    otherlv_37=(Token)match(input,To,FOLLOW_To_in_ruleRequirement4494); 

            	        	newLeafNode(otherlv_37, grammarAccess.getRequirementAccess().getToKeyword_6_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2080:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2081:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2081:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2082:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposedReferenceRequirementCrossReference_6_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4516);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2095:2: (otherlv_39= Comma ( ( ruleQualifiedName ) ) )*
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==Comma) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2096:2: otherlv_39= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_39=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4530); 

            	    	        	newLeafNode(otherlv_39, grammarAccess.getRequirementAccess().getCommaKeyword_6_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2100:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2101:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2101:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2102:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_6_8_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4552);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2122:4: ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2122:4: ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2123:5: {...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2123:108: ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2124:6: ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2127:6: ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2127:7: {...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2127:16: (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2128:2: otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_41=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleRequirement4623); 

            	        	newLeafNode(otherlv_41, grammarAccess.getRequirementAccess().getEvolvesKeyword_6_9_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2132:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2133:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2133:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2134:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_6_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4645);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2147:2: (otherlv_43= Comma ( ( ruleQualifiedName ) ) )*
            	    loop36:
            	    do {
            	        int alt36=2;
            	        int LA36_0 = input.LA(1);

            	        if ( (LA36_0==Comma) ) {
            	            alt36=1;
            	        }


            	        switch (alt36) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2148:2: otherlv_43= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_43=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4659); 

            	    	        	newLeafNode(otherlv_43, grammarAccess.getRequirementAccess().getCommaKeyword_6_9_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2152:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2153:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2153:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2154:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_6_9_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4681);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2174:4: ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2174:4: ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2175:5: {...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2175:109: ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2176:6: ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2179:6: ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2179:7: {...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2179:16: (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2180:2: otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_45=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4752); 

            	        	newLeafNode(otherlv_45, grammarAccess.getRequirementAccess().getSeeKeyword_6_10_0());
            	        
            	    otherlv_46=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4764); 

            	        	newLeafNode(otherlv_46, grammarAccess.getRequirementAccess().getGoalKeyword_6_10_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2189:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2190:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2190:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2191:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_6_10_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4786);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2204:2: (otherlv_48= Comma ( ( ruleQualifiedName ) ) )*
            	    loop37:
            	    do {
            	        int alt37=2;
            	        int LA37_0 = input.LA(1);

            	        if ( (LA37_0==Comma) ) {
            	            alt37=1;
            	        }


            	        switch (alt37) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2205:2: otherlv_48= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_48=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4800); 

            	    	        	newLeafNode(otherlv_48, grammarAccess.getRequirementAccess().getCommaKeyword_6_10_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2209:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2210:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2210:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2211:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_6_10_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4822);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop37;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2231:4: ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2231:4: ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2232:5: {...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2232:109: ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2233:6: ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2236:6: ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2236:7: {...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2236:16: (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2237:2: otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_50=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4893); 

            	        	newLeafNode(otherlv_50, grammarAccess.getRequirementAccess().getSeeKeyword_6_11_0());
            	        
            	    otherlv_51=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement4905); 

            	        	newLeafNode(otherlv_51, grammarAccess.getRequirementAccess().getRequirementKeyword_6_11_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2246:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2247:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2247:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2248:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_6_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4927);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2261:2: (otherlv_53= Comma ( ( ruleQualifiedName ) ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Comma) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2262:2: otherlv_53= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_53=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4941); 

            	    	        	newLeafNode(otherlv_53, grammarAccess.getRequirementAccess().getCommaKeyword_6_11_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2266:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2267:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2267:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2268:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_6_11_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4963);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2288:4: ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2288:4: ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2289:5: {...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2289:109: ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2290:6: ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2293:6: ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2293:7: {...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2293:16: (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2294:2: otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_55=(Token)match(input,See,FOLLOW_See_in_ruleRequirement5034); 

            	        	newLeafNode(otherlv_55, grammarAccess.getRequirementAccess().getSeeKeyword_6_12_0());
            	        
            	    otherlv_56=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement5046); 

            	        	newLeafNode(otherlv_56, grammarAccess.getRequirementAccess().getDocumentKeyword_6_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2303:1: ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2304:1: (lv_docReference_57_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2304:1: (lv_docReference_57_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2305:3: lv_docReference_57_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_6_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement5066);
            	    lv_docReference_57_0=ruleExternalDocument();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"docReference",
            	            		lv_docReference_57_0, 
            	            		"ExternalDocument");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2321:2: (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )*
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==Comma) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2322:2: otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_58=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement5080); 

            	    	        	newLeafNode(otherlv_58, grammarAccess.getRequirementAccess().getCommaKeyword_6_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2326:1: ( (lv_docReference_59_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2327:1: (lv_docReference_59_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2327:1: (lv_docReference_59_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2328:3: lv_docReference_59_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_6_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement5100);
            	    	    lv_docReference_59_0=ruleExternalDocument();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"docReference",
            	    	            		lv_docReference_59_0, 
            	    	            		"ExternalDocument");
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop39;
            	        }
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	

            }

            otherlv_60=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement5156); 

                	newLeafNode(otherlv_60, grammarAccess.getRequirementAccess().getRightSquareBracketKeyword_7());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2371:1: entryRuleHazard returns [EObject current=null] : iv_ruleHazard= ruleHazard EOF ;
    public final EObject entryRuleHazard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2372:2: (iv_ruleHazard= ruleHazard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2373:2: iv_ruleHazard= ruleHazard EOF
            {
             newCompositeNode(grammarAccess.getHazardRule()); 
            pushFollow(FOLLOW_ruleHazard_in_entryRuleHazard5190);
            iv_ruleHazard=ruleHazard();

            state._fsp--;

             current =iv_ruleHazard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazard5200); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2380:1: ruleHazard returns [EObject current=null] : (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket ) ;
    public final EObject ruleHazard() throws RecognitionException {
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
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        AntlrDatatypeRuleToken lv_title_11_0 = null;

        EObject lv_description_13_0 = null;

        AntlrDatatypeRuleToken lv_rationale_20_0 = null;

        AntlrDatatypeRuleToken lv_issue_22_0 = null;

        AntlrDatatypeRuleToken lv_issue_24_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2383:28: ( (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2384:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2384:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2385:2: otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Hazard,FOLLOW_Hazard_in_ruleHazard5238); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardAccess().getHazardKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2389:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2390:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2390:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2391:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard5254); 

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

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleHazard5272); 

                	newLeafNode(otherlv_2, grammarAccess.getHazardAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2412:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2414:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2414:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2415:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2418:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2419:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2419:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )*
            loop44:
            do {
                int alt44=8;
                int LA44_0 = input.LA(1);

                if ( LA44_0 ==For && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
                    alt44=1;
                }
                else if ( LA44_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
                    alt44=2;
                }
                else if ( LA44_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
                    alt44=3;
                }
                else if ( LA44_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
                    alt44=4;
                }
                else if ( LA44_0 ==Mitigated && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
                    alt44=5;
                }
                else if ( LA44_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
                    alt44=6;
                }
                else if ( LA44_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
                    alt44=7;
                }


                switch (alt44) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2421:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2421:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2422:5: {...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2422:103: ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2423:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2426:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2426:7: {...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2426:16: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2427:2: otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
            	    {
            	    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleHazard5330); 

            	        	newLeafNode(otherlv_4, grammarAccess.getHazardAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2431:1: ( (otherlv_5= RULE_ID ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2432:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2432:1: (otherlv_5= RULE_ID )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2433:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard5349); 

            	    		newLeafNode(otherlv_5, grammarAccess.getHazardAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2444:2: (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( (LA41_0==Of) ) {
            	        alt41=1;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2445:2: otherlv_6= Of ( ( ruleAadlClassifierReference ) )
            	            {
            	            otherlv_6=(Token)match(input,Of,FOLLOW_Of_in_ruleHazard5363); 

            	                	newLeafNode(otherlv_6, grammarAccess.getHazardAccess().getOfKeyword_3_0_2_0());
            	                
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2449:1: ( ( ruleAadlClassifierReference ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2450:1: ( ruleAadlClassifierReference )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2450:1: ( ruleAadlClassifierReference )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2451:3: ruleAadlClassifierReference
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getHazardRule());
            	            	        }
            	                    
            	             
            	            	        newCompositeNode(grammarAccess.getHazardAccess().getTargetContextClassifierCrossReference_3_0_2_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleHazard5385);
            	            ruleAadlClassifierReference();

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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2471:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2471:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2472:5: {...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2472:103: ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2473:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:7: {...}? => (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:16: (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2477:2: otherlv_8= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_8=(Token)match(input,Category,FOLLOW_Category_in_ruleHazard5456); 

            	        	newLeafNode(otherlv_8, grammarAccess.getHazardAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2482:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2483:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getCategoryHazardCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleHazard5478);
            	    ruleCatRef();

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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2503:4: ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2503:4: ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2504:5: {...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2504:103: ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2505:6: ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2508:6: ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2508:7: {...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2508:16: (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2509:2: otherlv_10= Title ( (lv_title_11_0= ruleValueString ) )
            	    {
            	    otherlv_10=(Token)match(input,Title,FOLLOW_Title_in_ruleHazard5547); 

            	        	newLeafNode(otherlv_10, grammarAccess.getHazardAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2513:1: ( (lv_title_11_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2514:1: (lv_title_11_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2514:1: (lv_title_11_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2515:3: lv_title_11_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5567);
            	    lv_title_11_0=ruleValueString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"title",
            	            		lv_title_11_0, 
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2538:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2538:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2539:5: {...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2539:103: ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2540:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2543:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2543:7: {...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2543:16: (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2544:2: otherlv_12= Description ( (lv_description_13_0= ruleDescription ) )
            	    {
            	    otherlv_12=(Token)match(input,Description,FOLLOW_Description_in_ruleHazard5636); 

            	        	newLeafNode(otherlv_12, grammarAccess.getHazardAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2548:1: ( (lv_description_13_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2549:1: (lv_description_13_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2549:1: (lv_description_13_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2550:3: lv_description_13_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getDescriptionDescriptionParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleHazard5656);
            	    lv_description_13_0=ruleDescription();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"description",
            	            		lv_description_13_0, 
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
            	case 5 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2573:4: ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2573:4: ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2574:5: {...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2574:103: ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2575:6: ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2578:6: ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2578:7: {...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2578:16: (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2579:2: otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_14=(Token)match(input,Mitigated,FOLLOW_Mitigated_in_ruleHazard5725); 

            	        	newLeafNode(otherlv_14, grammarAccess.getHazardAccess().getMitigatedKeyword_3_4_0());
            	        
            	    otherlv_15=(Token)match(input,By,FOLLOW_By_in_ruleHazard5737); 

            	        	newLeafNode(otherlv_15, grammarAccess.getHazardAccess().getByKeyword_3_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2588:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2589:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2589:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2590:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getHazardReferenceRequirementCrossReference_3_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleHazard5759);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2603:2: (otherlv_17= Comma ( ( ruleQualifiedName ) ) )*
            	    loop42:
            	    do {
            	        int alt42=2;
            	        int LA42_0 = input.LA(1);

            	        if ( (LA42_0==Comma) ) {
            	            alt42=1;
            	        }


            	        switch (alt42) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2604:2: otherlv_17= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_17=(Token)match(input,Comma,FOLLOW_Comma_in_ruleHazard5773); 

            	    	        	newLeafNode(otherlv_17, grammarAccess.getHazardAccess().getCommaKeyword_3_4_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2608:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2609:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2609:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2610:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getHazardReferenceRequirementCrossReference_3_4_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleHazard5795);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2630:4: ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2630:4: ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2631:5: {...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2631:103: ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2632:6: ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2635:6: ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2635:7: {...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2635:16: (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2636:2: otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) )
            	    {
            	    otherlv_19=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleHazard5866); 

            	        	newLeafNode(otherlv_19, grammarAccess.getHazardAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2640:1: ( (lv_rationale_20_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2641:1: (lv_rationale_20_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2641:1: (lv_rationale_20_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2642:3: lv_rationale_20_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getRationaleMultiLineStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleHazard5886);
            	    lv_rationale_20_0=ruleMultiLineString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"rationale",
            	            		lv_rationale_20_0, 
            	            		"MultiLineString");
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2665:4: ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2665:4: ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2666:5: {...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2666:103: ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2667:6: ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2670:6: ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2670:7: {...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2670:16: (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2671:2: otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )*
            	    {
            	    otherlv_21=(Token)match(input,Issues,FOLLOW_Issues_in_ruleHazard5955); 

            	        	newLeafNode(otherlv_21, grammarAccess.getHazardAccess().getIssuesKeyword_3_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2675:1: ( (lv_issue_22_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2676:1: (lv_issue_22_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2676:1: (lv_issue_22_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2677:3: lv_issue_22_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueMultiLineStringParserRuleCall_3_6_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleHazard5975);
            	    lv_issue_22_0=ruleMultiLineString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"issue",
            	            		lv_issue_22_0, 
            	            		"MultiLineString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2693:2: (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )*
            	    loop43:
            	    do {
            	        int alt43=2;
            	        int LA43_0 = input.LA(1);

            	        if ( (LA43_0==Comma) ) {
            	            alt43=1;
            	        }


            	        switch (alt43) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2694:2: otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) )
            	    	    {
            	    	    otherlv_23=(Token)match(input,Comma,FOLLOW_Comma_in_ruleHazard5989); 

            	    	        	newLeafNode(otherlv_23, grammarAccess.getHazardAccess().getCommaKeyword_3_6_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2698:1: ( (lv_issue_24_0= ruleMultiLineString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2699:1: (lv_issue_24_0= ruleMultiLineString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2699:1: (lv_issue_24_0= ruleMultiLineString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2700:3: lv_issue_24_0= ruleMultiLineString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueMultiLineStringParserRuleCall_3_6_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleHazard6009);
            	    	    lv_issue_24_0=ruleMultiLineString();

            	    	    state._fsp--;


            	    	    	        if (current==null) {
            	    	    	            current = createModelElementForParent(grammarAccess.getHazardRule());
            	    	    	        }
            	    	           		add(
            	    	           			current, 
            	    	           			"issue",
            	    	            		lv_issue_24_0, 
            	    	            		"MultiLineString");
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

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

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	

            }

            otherlv_25=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleHazard6065); 

                	newLeafNode(otherlv_25, grammarAccess.getHazardAccess().getRightSquareBracketKeyword_4());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2743:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2744:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2745:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument6099);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument6109); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2752:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2755:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2756:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2756:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2756:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2756:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2757:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2757:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2758:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument6155);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2774:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==NumberSign) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2775:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument6169); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2779:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2780:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2780:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2781:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument6189);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2805:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2806:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2807:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH6227);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH6238); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2814:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2818:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2819:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2819:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2819:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2819:2: (this_ID_0= RULE_ID kw= Solidus )*
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2819:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6279); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH6297); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6314); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH6332); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6347); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2860:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2861:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2862:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT6392);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT6403); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2869:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2873:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2874:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2874:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2874:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6443); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==FullStop) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2882:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT6462); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6477); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2904:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2905:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2906:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription6525);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription6535); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2913:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2916:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2917:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2917:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt48=0;
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_ID||LA48_0==RULE_STRING) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2918:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2918:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2919:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription6580);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2943:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2944:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2945:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6615);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement6625); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2952:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2955:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2956:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2956:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_STRING) ) {
                alt49=1;
            }
            else if ( (LA49_0==RULE_ID) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2956:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2956:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2957:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2957:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2958:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement6667); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2975:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2975:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2976:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2976:1: (otherlv_1= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2977:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement6698); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2996:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2997:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2998:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath6733);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath6743); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3005:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3008:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3009:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3009:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3009:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3009:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3010:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3010:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3011:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath6788); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3022:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3023:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath6802); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3027:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3028:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3028:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3029:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath6822);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3053:1: entryRulePredicateExpression returns [EObject current=null] : iv_rulePredicateExpression= rulePredicateExpression EOF ;
    public final EObject entryRulePredicateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateExpression = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3054:2: (iv_rulePredicateExpression= rulePredicateExpression EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3055:2: iv_rulePredicateExpression= rulePredicateExpression EOF
            {
             newCompositeNode(grammarAccess.getPredicateExpressionRule()); 
            pushFollow(FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression6858);
            iv_rulePredicateExpression=rulePredicateExpression();

            state._fsp--;

             current =iv_rulePredicateExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePredicateExpression6868); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3062:1: rulePredicateExpression returns [EObject current=null] : (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3065:28: ( (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3066:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3066:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3066:2: this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression6904); 
             
                newLeafNode(this_ID_0, grammarAccess.getPredicateExpressionAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3070:1: ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3071:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3071:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3072:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3072:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3073:3: lv_op_1_1= EqualsSign
                    {
                    lv_op_1_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_rulePredicateExpression6924); 

                            newLeafNode(lv_op_1_1, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3086:8: lv_op_1_2= ExclamationMarkEqualsSign
                    {
                    lv_op_1_2=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression6952); 

                            newLeafNode(lv_op_1_2, grammarAccess.getPredicateExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3099:8: lv_op_1_3= LessThanSign
                    {
                    lv_op_1_3=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_rulePredicateExpression6980); 

                            newLeafNode(lv_op_1_3, grammarAccess.getPredicateExpressionAccess().getOpLessThanSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3112:8: lv_op_1_4= EqualsSignLessThanSign
                    {
                    lv_op_1_4=(Token)match(input,EqualsSignLessThanSign,FOLLOW_EqualsSignLessThanSign_in_rulePredicateExpression7008); 

                            newLeafNode(lv_op_1_4, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignLessThanSignKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3125:8: lv_op_1_5= GreaterThanSign
                    {
                    lv_op_1_5=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_rulePredicateExpression7036); 

                            newLeafNode(lv_op_1_5, grammarAccess.getPredicateExpressionAccess().getOpGreaterThanSignKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3138:8: lv_op_1_6= GreaterThanSignEqualsSign
                    {
                    lv_op_1_6=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression7064); 

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression7089); 
             
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3166:1: entryRuleFinalValue returns [EObject current=null] : iv_ruleFinalValue= ruleFinalValue EOF ;
    public final EObject entryRuleFinalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinalValue = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3167:2: (iv_ruleFinalValue= ruleFinalValue EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3168:2: iv_ruleFinalValue= ruleFinalValue EOF
            {
             newCompositeNode(grammarAccess.getFinalValueRule()); 
            pushFollow(FOLLOW_ruleFinalValue_in_entryRuleFinalValue7123);
            iv_ruleFinalValue=ruleFinalValue();

            state._fsp--;

             current =iv_ruleFinalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFinalValue7133); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3175:1: ruleFinalValue returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) ;
    public final EObject ruleFinalValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3178:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3179:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3179:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3179:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3179:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3180:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3180:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3181:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFinalValue7175); 

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

            otherlv_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleFinalValue7193); 

                	newLeafNode(otherlv_1, grammarAccess.getFinalValueAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3202:1: ( (lv_value_2_0= ruleValueString ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3203:1: (lv_value_2_0= ruleValueString )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3203:1: (lv_value_2_0= ruleValueString )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3204:3: lv_value_2_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getFinalValueAccess().getValueValueStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleFinalValue7213);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3230:1: entryRuleMultiLineString returns [String current=null] : iv_ruleMultiLineString= ruleMultiLineString EOF ;
    public final String entryRuleMultiLineString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiLineString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3231:1: (iv_ruleMultiLineString= ruleMultiLineString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3232:2: iv_ruleMultiLineString= ruleMultiLineString EOF
            {
             newCompositeNode(grammarAccess.getMultiLineStringRule()); 
            pushFollow(FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString7251);
            iv_ruleMultiLineString=ruleMultiLineString();

            state._fsp--;

             current =iv_ruleMultiLineString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiLineString7262); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3239:1: ruleMultiLineString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe ) ;
    public final AntlrDatatypeRuleToken ruleMultiLineString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_STRING_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3243:6: ( (kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3244:1: (kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3244:1: (kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3245:2: kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe
            {
            kw=(Token)match(input,ApostropheApostropheApostrophe,FOLLOW_ApostropheApostropheApostrophe_in_ruleMultiLineString7300); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMultiLineStringAccess().getApostropheApostropheApostropheKeyword_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3250:1: (this_STRING_1= RULE_STRING )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==RULE_STRING) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3250:6: this_STRING_1= RULE_STRING
            	    {
            	    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMultiLineString7316); 

            	    		current.merge(this_STRING_1);
            	        
            	     
            	        newLeafNode(this_STRING_1, grammarAccess.getMultiLineStringAccess().getSTRINGTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            kw=(Token)match(input,ApostropheApostropheApostrophe,FOLLOW_ApostropheApostropheApostrophe_in_ruleMultiLineString7336); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMultiLineStringAccess().getApostropheApostropheApostropheKeyword_2()); 
                

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
    // $ANTLR end "ruleMultiLineString"


    // $ANTLR start "entryRuleValueString"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3271:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3272:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3273:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString7376);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString7387); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3280:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3284:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3285:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString7426); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3300:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3301:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3302:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference7470);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference7481); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3309:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3313:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3314:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3314:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3314:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3314:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==RULE_ID) ) {
                    int LA52_1 = input.LA(2);

                    if ( (LA52_1==ColonColon) ) {
                        alt52=1;
                    }


                }


                switch (alt52) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3314:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7522); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference7540); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop52;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7557); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3334:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==FullStop) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3335:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference7576); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7591); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3355:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3356:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3357:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef7638);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef7649); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3364:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3368:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3369:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef7688); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3384:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3385:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3386:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7732);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7743); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3393:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3397:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3398:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3398:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3398:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7783); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3405:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==FullStop) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3406:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName7802); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7817); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop54;
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


    // $ANTLR start "ruleIssueType"
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3428:1: ruleIssueType returns [Enumerator current=null] : ( (enumLiteral_0= Error ) | (enumLiteral_1= Warning ) | (enumLiteral_2= Info ) ) ;
    public final Enumerator ruleIssueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3430:28: ( ( (enumLiteral_0= Error ) | (enumLiteral_1= Warning ) | (enumLiteral_2= Info ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3431:1: ( (enumLiteral_0= Error ) | (enumLiteral_1= Warning ) | (enumLiteral_2= Info ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3431:1: ( (enumLiteral_0= Error ) | (enumLiteral_1= Warning ) | (enumLiteral_2= Info ) )
            int alt55=3;
            switch ( input.LA(1) ) {
            case Error:
                {
                alt55=1;
                }
                break;
            case Warning:
                {
                alt55=2;
                }
                break;
            case Info:
                {
                alt55=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3431:2: (enumLiteral_0= Error )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3431:2: (enumLiteral_0= Error )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3431:7: enumLiteral_0= Error
                    {
                    enumLiteral_0=(Token)match(input,Error,FOLLOW_Error_in_ruleIssueType7883); 

                            current = grammarAccess.getIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3437:6: (enumLiteral_1= Warning )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3437:6: (enumLiteral_1= Warning )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3437:11: enumLiteral_1= Warning
                    {
                    enumLiteral_1=(Token)match(input,Warning,FOLLOW_Warning_in_ruleIssueType7905); 

                            current = grammarAccess.getIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3443:6: (enumLiteral_2= Info )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3443:6: (enumLiteral_2= Info )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3443:11: enumLiteral_2= Info
                    {
                    enumLiteral_2=(Token)match(input,Info,FOLLOW_Info_in_ruleIssueType7927); 

                            current = grammarAccess.getIssueTypeAccess().getINFOEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getIssueTypeAccess().getINFOEnumLiteralDeclaration_2()); 
                        

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


    protected DFA25 dfa25 = new DFA25(this);
    protected DFA40 dfa40 = new DFA40(this);
    static final String DFA25_eotS =
        "\21\uffff";
    static final String DFA25_eofS =
        "\21\uffff";
    static final String DFA25_minS =
        "\1\5\14\uffff\1\6\3\uffff";
    static final String DFA25_maxS =
        "\1\63\14\uffff\1\33\3\uffff";
    static final String DFA25_acceptS =
        "\1\uffff\1\17\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\uffff\1\16\1\15\1\14";
    static final String DFA25_specialS =
        "\1\1\14\uffff\1\0\3\uffff}>";
    static final String[] DFA25_transitionS = {
            "\1\3\1\uffff\1\14\1\11\1\uffff\1\13\1\uffff\1\5\1\2\1\uffff"+
            "\1\12\2\uffff\1\7\1\uffff\1\4\2\uffff\1\6\3\uffff\1\10\4\uffff"+
            "\1\15\22\uffff\1\1",
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
            "\1\17\7\uffff\1\16\14\uffff\1\20",
            "",
            "",
            ""
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "()* loopback of 883:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA25_13 = input.LA(1);

                         
                        int index25_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA25_13 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) ) {s = 14;}

                        else if ( LA25_13 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) {s = 15;}

                        else if ( LA25_13 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) ) {s = 16;}

                         
                        input.seek(index25_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA25_0 = input.LA(1);

                         
                        int index25_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA25_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA25_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA25_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA25_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA25_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA25_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA25_0 ==Refined && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA25_0 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA25_0 ==Decomposed && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( LA25_0 ==Evolved && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8) ) {s = 10;}

                        else if ( LA25_0 ==Conflicts && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9) ) {s = 11;}

                        else if ( LA25_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) ) {s = 12;}

                        else if ( LA25_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) ) {s = 13;}

                         
                        input.seek(index25_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 25, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA40_eotS =
        "\22\uffff";
    static final String DFA40_eofS =
        "\22\uffff";
    static final String DFA40_minS =
        "\1\5\6\uffff\1\6\4\uffff\1\64\2\uffff\1\0\2\uffff";
    static final String DFA40_maxS =
        "\1\63\6\uffff\1\33\4\uffff\1\64\2\uffff\1\0\2\uffff";
    static final String DFA40_acceptS =
        "\1\uffff\1\16\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\11\1\12\1"+
        "\uffff\1\14\1\15\1\uffff\1\6\1\13";
    static final String DFA40_specialS =
        "\1\1\6\uffff\1\0\4\uffff\1\2\2\uffff\1\3\2\uffff}>";
    static final String[] DFA40_transitionS = {
            "\1\2\1\11\1\uffff\1\12\1\3\2\uffff\1\5\3\uffff\1\13\1\uffff"+
            "\1\10\1\uffff\1\4\2\uffff\1\6\10\uffff\1\7\22\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\15\7\uffff\1\16\14\uffff\1\14",
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

    static final short[] DFA40_eot = DFA.unpackEncodedString(DFA40_eotS);
    static final short[] DFA40_eof = DFA.unpackEncodedString(DFA40_eofS);
    static final char[] DFA40_min = DFA.unpackEncodedStringToUnsignedChars(DFA40_minS);
    static final char[] DFA40_max = DFA.unpackEncodedStringToUnsignedChars(DFA40_maxS);
    static final short[] DFA40_accept = DFA.unpackEncodedString(DFA40_acceptS);
    static final short[] DFA40_special = DFA.unpackEncodedString(DFA40_specialS);
    static final short[][] DFA40_transition;

    static {
        int numStates = DFA40_transitionS.length;
        DFA40_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA40_transition[i] = DFA.unpackEncodedString(DFA40_transitionS[i]);
        }
    }

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = DFA40_eot;
            this.eof = DFA40_eof;
            this.min = DFA40_min;
            this.max = DFA40_max;
            this.accept = DFA40_accept;
            this.special = DFA40_special;
            this.transition = DFA40_transition;
        }
        public String getDescription() {
            return "()* loopback of 1721:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_7 = input.LA(1);

                         
                        int index40_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA40_7 ==Goal && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) ) {s = 12;}

                        else if ( LA40_7 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) ) {s = 13;}

                        else if ( LA40_7 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) {s = 14;}

                         
                        input.seek(index40_7);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_0 = input.LA(1);

                         
                        int index40_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA40_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA40_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0) ) {s = 2;}

                        else if ( LA40_0 ==Parameters && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1) ) {s = 3;}

                        else if ( LA40_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2) ) {s = 4;}

                        else if ( LA40_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3) ) {s = 5;}

                        else if ( LA40_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4) ) {s = 6;}

                        else if ( LA40_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) ) {s = 7;}

                        else if ( LA40_0 ==Refined && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6) ) {s = 8;}

                        else if ( LA40_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7) ) {s = 9;}

                        else if ( LA40_0 ==Decomposed && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8) ) {s = 10;}

                        else if ( LA40_0 ==Evolves && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9) ) {s = 11;}

                         
                        input.seek(index40_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_12 = input.LA(1);

                         
                        int index40_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA40_12 ==RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) ) {s = 15;}

                         
                        input.seek(index40_12);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA40_15 = input.LA(1);

                         
                        int index40_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) ) {s = 17;}

                         
                        input.seek(index40_15);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
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
    public static final BitSet FOLLOW_Specification_in_ruleSystemSpec272 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemSpec288 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_For_in_ruleSystemSpec306 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleSystemSpec328 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleSystemSpec341 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSystemSpec363 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleSystemSpec376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholderGoals_in_entryRuleStakeholderGoals410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholderGoals420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goals_in_ruleStakeholderGoals458 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholderGoals474 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals492 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleStakeholderGoals514 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleStakeholderGoals527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_entryRuleReqDocument561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqDocument571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Document_in_ruleReqDocument609 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqDocument625 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqDocument643 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleReqDocument665 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqDocument678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecLibrary_in_entryRuleReqSpecLibrary712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecLibrary722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Library_in_ruleReqSpecLibrary760 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecLibrary776 = new BitSet(new long[]{0x0004000080000000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecLibrary795 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecLibrary817 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary832 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecLibrary854 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecLibrary873 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_ruleHazard_in_ruleReqSpecLibrary892 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecLibrary911 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecLibrary929 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary941 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqSpecLibrary961 = new BitSet(new long[]{0x0008080000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecLibrary975 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqSpecLibrary995 = new BitSet(new long[]{0x0008080000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1010 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1058 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecFolder1068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleReqSpecFolder1106 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecFolder1122 = new BitSet(new long[]{0x0004000080000000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecFolder1141 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecFolder1163 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1178 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecFolder1200 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecFolder1219 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_ruleHazard_in_ruleReqSpecFolder1238 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1257 = new BitSet(new long[]{0x0008000008E00040L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecFolder1275 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1287 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqSpecFolder1307 = new BitSet(new long[]{0x0008080000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecFolder1321 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqSpecFolder1341 = new BitSet(new long[]{0x0008080000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1356 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal1404 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal1452 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1468 = new BitSet(new long[]{0x0004400080000000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoal1487 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1507 = new BitSet(new long[]{0x0004000080000000L});
    public static final BitSet FOLLOW_For_in_ruleGoal1523 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1542 = new BitSet(new long[]{0x0004004000000000L});
    public static final BitSet FOLLOW_Of_in_ruleGoal1556 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleGoal1578 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal1595 = new BitSet(new long[]{0x000800010894B5A0L});
    public static final BitSet FOLLOW_Category_in_ruleGoal1653 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal1675 = new BitSet(new long[]{0x000800010894B5A0L});
    public static final BitSet FOLLOW_Description_in_ruleGoal1744 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal1764 = new BitSet(new long[]{0x000800010894B5A0L});
    public static final BitSet FOLLOW_Assert_in_ruleGoal1833 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleGoal1853 = new BitSet(new long[]{0x000800010894B5A0L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal1922 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleGoal1942 = new BitSet(new long[]{0x000800010894B5A0L});
    public static final BitSet FOLLOW_Issues_in_ruleGoal2011 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleGoal2031 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2045 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleGoal2065 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Refined_in_ruleGoal2136 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2148 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2170 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2184 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2206 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoal2284 = new BitSet(new long[]{0x000800010894B5A0L});
    public static final BitSet FOLLOW_Decomposed_in_ruleGoal2353 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2365 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2387 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2401 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2423 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Evolved_in_ruleGoal2494 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2506 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2528 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2542 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2564 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2635 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_With_in_ruleGoal2647 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2669 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2683 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2705 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2776 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2798 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2812 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2834 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal2905 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal2917 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2939 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2953 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2975 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal3046 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal3058 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3080 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3094 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3116 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal3187 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal3199 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3219 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3233 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3253 = new BitSet(new long[]{0x000808010894B5A0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal3309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement3343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement3353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement3391 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3407 = new BitSet(new long[]{0x0004420080000000L});
    public static final BitSet FOLLOW_Colon_in_ruleRequirement3426 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3446 = new BitSet(new long[]{0x0004020080000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleRequirement3462 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3484 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleRequirement3497 = new BitSet(new long[]{0x0004000080000000L});
    public static final BitSet FOLLOW_For_in_ruleRequirement3512 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3531 = new BitSet(new long[]{0x0004004000000000L});
    public static final BitSet FOLLOW_Of_in_ruleRequirement3545 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleRequirement3567 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3584 = new BitSet(new long[]{0x0008000100951360L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3642 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3662 = new BitSet(new long[]{0x0008000100951360L});
    public static final BitSet FOLLOW_Parameters_in_ruleRequirement3731 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleFinalValue_in_ruleRequirement3751 = new BitSet(new long[]{0x0018000100951360L});
    public static final BitSet FOLLOW_Assert_in_ruleRequirement3821 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleRequirement3841 = new BitSet(new long[]{0x0008000100951360L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement3910 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleRequirement3930 = new BitSet(new long[]{0x0008000100951360L});
    public static final BitSet FOLLOW_Issues_in_ruleRequirement3999 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleRequirement4019 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4033 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleRequirement4053 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4124 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4136 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4158 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4172 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4194 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Refined_in_ruleRequirement4265 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_To_in_ruleRequirement4277 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4299 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4313 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4335 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleRequirement4413 = new BitSet(new long[]{0x0008000100951360L});
    public static final BitSet FOLLOW_Decomposed_in_ruleRequirement4482 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_To_in_ruleRequirement4494 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4516 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4530 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4552 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Evolves_in_ruleRequirement4623 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4645 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4659 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4681 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4752 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4764 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4786 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4800 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4822 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4893 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement4905 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4927 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4941 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4963 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_See_in_ruleRequirement5034 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement5046 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement5066 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement5080 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement5100 = new BitSet(new long[]{0x0008080100951360L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement5156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazard_in_entryRuleHazard5190 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazard5200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hazard_in_ruleHazard5238 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard5254 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleHazard5272 = new BitSet(new long[]{0x0008000084803820L});
    public static final BitSet FOLLOW_For_in_ruleHazard5330 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard5349 = new BitSet(new long[]{0x0008004084803820L});
    public static final BitSet FOLLOW_Of_in_ruleHazard5363 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleHazard5385 = new BitSet(new long[]{0x0008000084803820L});
    public static final BitSet FOLLOW_Category_in_ruleHazard5456 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleHazard5478 = new BitSet(new long[]{0x0008000084803820L});
    public static final BitSet FOLLOW_Title_in_ruleHazard5547 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5567 = new BitSet(new long[]{0x0008000084803820L});
    public static final BitSet FOLLOW_Description_in_ruleHazard5636 = new BitSet(new long[]{0x0050000000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleHazard5656 = new BitSet(new long[]{0x0008000084803820L});
    public static final BitSet FOLLOW_Mitigated_in_ruleHazard5725 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_By_in_ruleHazard5737 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleHazard5759 = new BitSet(new long[]{0x0008080084803820L});
    public static final BitSet FOLLOW_Comma_in_ruleHazard5773 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleHazard5795 = new BitSet(new long[]{0x0008080084803820L});
    public static final BitSet FOLLOW_Rationale_in_ruleHazard5866 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleHazard5886 = new BitSet(new long[]{0x0008000084803820L});
    public static final BitSet FOLLOW_Issues_in_ruleHazard5955 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleHazard5975 = new BitSet(new long[]{0x0008080084803820L});
    public static final BitSet FOLLOW_Comma_in_ruleHazard5989 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleHazard6009 = new BitSet(new long[]{0x0008080084803820L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleHazard6065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument6099 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument6109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument6155 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument6169 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument6189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH6227 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH6238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6279 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH6297 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6314 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH6332 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT6392 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT6403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6443 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT6462 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6477 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription6525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription6535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription6580 = new BitSet(new long[]{0x0050000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement6625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement6667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement6698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath6733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath6743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath6788 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath6802 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath6822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression6858 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePredicateExpression6868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression6904 = new BitSet(new long[]{0x0003801A00000000L});
    public static final BitSet FOLLOW_EqualsSign_in_rulePredicateExpression6924 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression6952 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LessThanSign_in_rulePredicateExpression6980 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_EqualsSignLessThanSign_in_rulePredicateExpression7008 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_GreaterThanSign_in_rulePredicateExpression7036 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression7064 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression7089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFinalValue_in_entryRuleFinalValue7123 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFinalValue7133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFinalValue7175 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleFinalValue7193 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleFinalValue7213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString7251 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiLineString7262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ApostropheApostropheApostrophe_in_ruleMultiLineString7300 = new BitSet(new long[]{0x0040000040000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiLineString7316 = new BitSet(new long[]{0x0040000040000000L});
    public static final BitSet FOLLOW_ApostropheApostropheApostrophe_in_ruleMultiLineString7336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString7376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString7387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString7426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference7470 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7522 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference7540 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7557 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference7576 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef7638 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef7649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef7688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7783 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName7802 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7817 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_Error_in_ruleIssueType7883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Warning_in_ruleIssueType7905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Info_in_ruleIssueType7927 = new BitSet(new long[]{0x0000000000000002L});

}
