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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Specification", "Description", "Requirement", "Stakeholder", "Decomposed", "Parameters", "Conflicts", "Mitigated", "Rationale", "Category", "Document", "Evolved", "Evolves", "Library", "Refined", "Warning", "Assert", "Folder", "Hazard", "Import", "Issues", "Error", "Goals", "Title", "Goal", "Info", "With", "ApostropheApostropheApostrophe", "For", "See", "ExclamationMarkEqualsSign", "FullStopAsterisk", "ColonColon", "EqualsSignLessThanSign", "GreaterThanSignEqualsSign", "By", "Of", "To", "NumberSign", "LeftParenthesis", "RightParenthesis", "Comma", "FullStop", "Solidus", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Parameters=9;
    public static final int RULE_ID=54;
    public static final int RightParenthesis=44;
    public static final int Specification=4;
    public static final int Mitigated=11;
    public static final int Assert=20;
    public static final int Evolved=15;
    public static final int RULE_ANY_OTHER=60;
    public static final int LeftParenthesis=43;
    public static final int Issues=24;
    public static final int RightSquareBracket=53;
    public static final int Requirement=6;
    public static final int Library=17;
    public static final int Solidus=47;
    public static final int EOF=-1;
    public static final int GreaterThanSign=51;
    public static final int FullStop=46;
    public static final int Evolves=16;
    public static final int EqualsSignLessThanSign=37;
    public static final int To=41;
    public static final int ApostropheApostropheApostrophe=31;
    public static final int LessThanSign=49;
    public static final int RULE_INT=55;
    public static final int LeftSquareBracket=52;
    public static final int Conflicts=10;
    public static final int ExclamationMarkEqualsSign=34;
    public static final int Hazard=22;
    public static final int Stakeholder=7;
    public static final int Import=23;
    public static final int Decomposed=8;
    public static final int Refined=18;
    public static final int Warning=19;
    public static final int FullStopAsterisk=35;
    public static final int Colon=48;
    public static final int RULE_SL_COMMENT=58;
    public static final int For=32;
    public static final int NumberSign=42;
    public static final int Rationale=12;
    public static final int With=30;
    public static final int Goal=28;
    public static final int RULE_ML_COMMENT=57;
    public static final int By=39;
    public static final int Goals=26;
    public static final int ColonColon=36;
    public static final int Description=5;
    public static final int Document=14;
    public static final int Folder=21;
    public static final int RULE_STRING=56;
    public static final int See=33;
    public static final int Title=27;
    public static final int Error=25;
    public static final int GreaterThanSignEqualsSign=38;
    public static final int Category=13;
    public static final int RULE_WS=59;
    public static final int Info=29;
    public static final int Comma=45;
    public static final int EqualsSign=50;
    public static final int Of=40;

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:391:1: ruleReqSpecLibrary returns [EObject current=null] : (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleMultiLineString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket ) ;
    public final EObject ruleReqSpecLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_importedNamespace_3_0 = null;

        EObject lv_content_7_1 = null;

        EObject lv_content_7_2 = null;

        EObject lv_content_7_3 = null;

        EObject lv_content_7_4 = null;

        AntlrDatatypeRuleToken lv_issue_10_0 = null;

        AntlrDatatypeRuleToken lv_issue_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:394:28: ( (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleMultiLineString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:395:1: (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleMultiLineString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:395:1: (otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleMultiLineString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:396:2: otherlv_0= Library ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )? (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )? otherlv_6= LeftSquareBracket ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder ) ) )* (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleMultiLineString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) ) )* otherlv_13= RightSquareBracket )? otherlv_14= RightSquareBracket
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:418:2: (otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==Import) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:419:2: otherlv_2= Import ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) )
                    {
                    otherlv_2=(Token)match(input,Import,FOLLOW_Import_in_ruleReqSpecLibrary795); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecLibraryAccess().getImportKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:423:1: ( (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:424:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:424:1: (lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:425:3: lv_importedNamespace_3_0= ruleQualifiedNameWithWildCard
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:441:4: (otherlv_4= For ( ( ruleAadlClassifierReference ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==For) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:442:2: otherlv_4= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecLibrary831); 

                        	newLeafNode(otherlv_4, grammarAccess.getReqSpecLibraryAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:446:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:447:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:447:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:448:3: ruleAadlClassifierReference
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
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:466:1: ( ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Requirement||(LA5_0>=Folder && LA5_0<=Hazard)||LA5_0==Goal) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:467:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:467:1: ( (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:468:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:468:1: (lv_content_7_1= ruleGoal | lv_content_7_2= ruleRequirement | lv_content_7_3= ruleHazard | lv_content_7_4= ruleReqSpecFolder )
            	    int alt4=4;
            	    switch ( input.LA(1) ) {
            	    case Goal:
            	        {
            	        alt4=1;
            	        }
            	        break;
            	    case Requirement:
            	        {
            	        alt4=2;
            	        }
            	        break;
            	    case Hazard:
            	        {
            	        alt4=3;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt4=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt4) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:469:3: lv_content_7_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentGoalParserRuleCall_5_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecLibrary890);
            	            lv_content_7_1=ruleGoal();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:484:8: lv_content_7_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentRequirementParserRuleCall_5_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecLibrary909);
            	            lv_content_7_2=ruleRequirement();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:499:8: lv_content_7_3= ruleHazard
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentHazardParserRuleCall_5_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleHazard_in_ruleReqSpecLibrary928);
            	            lv_content_7_3=ruleHazard();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_7_3, 
            	                    		"Hazard");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:514:8: lv_content_7_4= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getContentReqSpecFolderParserRuleCall_5_0_3()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecLibrary947);
            	            lv_content_7_4=ruleReqSpecFolder();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"content",
            	                    		lv_content_7_4, 
            	                    		"ReqSpecFolder");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:532:3: (otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleMultiLineString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) ) )* otherlv_13= RightSquareBracket )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Issues) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:533:2: otherlv_8= Issues otherlv_9= LeftSquareBracket ( (lv_issue_10_0= ruleMultiLineString ) ) (otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) ) )* otherlv_13= RightSquareBracket
                    {
                    otherlv_8=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecLibrary965); 

                        	newLeafNode(otherlv_8, grammarAccess.getReqSpecLibraryAccess().getIssuesKeyword_6_0());
                        
                    otherlv_9=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary977); 

                        	newLeafNode(otherlv_9, grammarAccess.getReqSpecLibraryAccess().getLeftSquareBracketKeyword_6_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:542:1: ( (lv_issue_10_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:543:1: (lv_issue_10_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:543:1: (lv_issue_10_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:544:3: lv_issue_10_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getIssueMultiLineStringParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqSpecLibrary997);
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

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:560:2: (otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==Comma) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:561:2: otherlv_11= Comma ( (lv_issue_12_0= ruleMultiLineString ) )
                    	    {
                    	    otherlv_11=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecLibrary1011); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getReqSpecLibraryAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:565:1: ( (lv_issue_12_0= ruleMultiLineString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:566:1: (lv_issue_12_0= ruleMultiLineString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:566:1: (lv_issue_12_0= ruleMultiLineString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:567:3: lv_issue_12_0= ruleMultiLineString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecLibraryAccess().getIssueMultiLineStringParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqSpecLibrary1031);
                    	    lv_issue_12_0=ruleMultiLineString();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getReqSpecLibraryRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"issue",
                    	            		lv_issue_12_0, 
                    	            		"MultiLineString");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1046); 

                        	newLeafNode(otherlv_13, grammarAccess.getReqSpecLibraryAccess().getRightSquareBracketKeyword_6_4());
                        

                    }
                    break;

            }

            otherlv_14=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1060); 

                	newLeafNode(otherlv_14, grammarAccess.getReqSpecLibraryAccess().getRightSquareBracketKeyword_7());
                

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:601:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:602:1: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:603:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1095);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildCard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1106); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:610:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:614:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:615:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:615:1: (this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:616:5: this_QualifiedName_0= ruleQualifiedName (kw= FullStopAsterisk )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1153);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:626:1: (kw= FullStopAsterisk )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FullStopAsterisk) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:627:2: kw= FullStopAsterisk
                    {
                    kw=(Token)match(input,FullStopAsterisk,FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildCard1172); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:640:1: entryRuleReqSpecFolder returns [EObject current=null] : iv_ruleReqSpecFolder= ruleReqSpecFolder EOF ;
    public final EObject entryRuleReqSpecFolder() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReqSpecFolder = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:641:2: (iv_ruleReqSpecFolder= ruleReqSpecFolder EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:642:2: iv_ruleReqSpecFolder= ruleReqSpecFolder EOF
            {
             newCompositeNode(grammarAccess.getReqSpecFolderRule()); 
            pushFollow(FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1213);
            iv_ruleReqSpecFolder=ruleReqSpecFolder();

            state._fsp--;

             current =iv_ruleReqSpecFolder; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReqSpecFolder1223); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:649:1: ruleReqSpecFolder returns [EObject current=null] : (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:652:28: ( (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:653:1: (otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:654:2: otherlv_0= Folder ( (lv_label_1_0= RULE_ID ) ) (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )? otherlv_4= LeftSquareBracket ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )* (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )? otherlv_12= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Folder,FOLLOW_Folder_in_ruleReqSpecFolder1261); 

                	newLeafNode(otherlv_0, grammarAccess.getReqSpecFolderAccess().getFolderKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:658:1: ( (lv_label_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:659:1: (lv_label_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:659:1: (lv_label_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:660:3: lv_label_1_0= RULE_ID
            {
            lv_label_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReqSpecFolder1277); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:676:2: (otherlv_2= For ( ( ruleAadlClassifierReference ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==For) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:677:2: otherlv_2= For ( ( ruleAadlClassifierReference ) )
                    {
                    otherlv_2=(Token)match(input,For,FOLLOW_For_in_ruleReqSpecFolder1296); 

                        	newLeafNode(otherlv_2, grammarAccess.getReqSpecFolderAccess().getForKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:681:1: ( ( ruleAadlClassifierReference ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:682:1: ( ruleAadlClassifierReference )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:682:1: ( ruleAadlClassifierReference )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:683:3: ruleAadlClassifierReference
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReqSpecFolderRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getTargetClassifierCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecFolder1318);
                    ruleAadlClassifierReference();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1333); 

                	newLeafNode(otherlv_4, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:701:1: ( ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Requirement||(LA11_0>=Folder && LA11_0<=Hazard)||LA11_0==Goal) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:702:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:702:1: ( (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:703:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:703:1: (lv_content_5_1= ruleGoal | lv_content_5_2= ruleRequirement | lv_content_5_3= ruleHazard | lv_content_5_4= ruleReqSpecFolder )
            	    int alt10=4;
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
            	    case Hazard:
            	        {
            	        alt10=3;
            	        }
            	        break;
            	    case Folder:
            	        {
            	        alt10=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:704:3: lv_content_5_1= ruleGoal
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentGoalParserRuleCall_4_0_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleGoal_in_ruleReqSpecFolder1355);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:719:8: lv_content_5_2= ruleRequirement
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentRequirementParserRuleCall_4_0_1()); 
            	            	    
            	            pushFollow(FOLLOW_ruleRequirement_in_ruleReqSpecFolder1374);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:734:8: lv_content_5_3= ruleHazard
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentHazardParserRuleCall_4_0_2()); 
            	            	    
            	            pushFollow(FOLLOW_ruleHazard_in_ruleReqSpecFolder1393);
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
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:749:8: lv_content_5_4= ruleReqSpecFolder
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getContentReqSpecFolderParserRuleCall_4_0_3()); 
            	            	    
            	            pushFollow(FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1412);
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
            	    break loop11;
                }
            } while (true);

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:767:3: (otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Issues) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:768:2: otherlv_6= Issues otherlv_7= LeftSquareBracket ( (lv_issue_8_0= ruleMultiLineString ) ) (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )* otherlv_11= RightSquareBracket
                    {
                    otherlv_6=(Token)match(input,Issues,FOLLOW_Issues_in_ruleReqSpecFolder1430); 

                        	newLeafNode(otherlv_6, grammarAccess.getReqSpecFolderAccess().getIssuesKeyword_5_0());
                        
                    otherlv_7=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1442); 

                        	newLeafNode(otherlv_7, grammarAccess.getReqSpecFolderAccess().getLeftSquareBracketKeyword_5_1());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:777:1: ( (lv_issue_8_0= ruleMultiLineString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:778:1: (lv_issue_8_0= ruleMultiLineString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:778:1: (lv_issue_8_0= ruleMultiLineString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:779:3: lv_issue_8_0= ruleMultiLineString
                    {
                     
                    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getIssueMultiLineStringParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqSpecFolder1462);
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

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:795:2: (otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Comma) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:796:2: otherlv_9= Comma ( (lv_issue_10_0= ruleMultiLineString ) )
                    	    {
                    	    otherlv_9=(Token)match(input,Comma,FOLLOW_Comma_in_ruleReqSpecFolder1476); 

                    	        	newLeafNode(otherlv_9, grammarAccess.getReqSpecFolderAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:800:1: ( (lv_issue_10_0= ruleMultiLineString ) )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:801:1: (lv_issue_10_0= ruleMultiLineString )
                    	    {
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:801:1: (lv_issue_10_0= ruleMultiLineString )
                    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:802:3: lv_issue_10_0= ruleMultiLineString
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getReqSpecFolderAccess().getIssueMultiLineStringParserRuleCall_5_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleReqSpecFolder1496);
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
                    	    break loop12;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1511); 

                        	newLeafNode(otherlv_11, grammarAccess.getReqSpecFolderAccess().getRightSquareBracketKeyword_5_4());
                        

                    }
                    break;

            }

            otherlv_12=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1525); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:836:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:837:2: (iv_ruleGoal= ruleGoal EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:838:2: iv_ruleGoal= ruleGoal EOF
            {
             newCompositeNode(grammarAccess.getGoalRule()); 
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal1559);
            iv_ruleGoal=ruleGoal();

            state._fsp--;

             current =iv_ruleGoal; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal1569); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:845:1: ruleGoal returns [EObject current=null] : (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:848:28: ( (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:849:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:849:1: (otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:850:2: otherlv_0= Goal ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_8= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_62= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal1607); 

                	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:854:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:855:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:855:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:856:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1623); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:872:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Colon) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:873:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleGoal1642); 

                        	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:877:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:878:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:878:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:879:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getGoalAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleGoal1662);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:895:4: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==For) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:896:2: otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
                    {
                    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleGoal1678); 

                        	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getForKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:900:1: ( (otherlv_5= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:901:1: (otherlv_5= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:901:1: (otherlv_5= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:902:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getGoalRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal1697); 

                    		newLeafNode(otherlv_5, grammarAccess.getGoalAccess().getTargetNamedElementCrossReference_3_1_0()); 
                    	

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:913:2: (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==Of) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:914:2: otherlv_6= Of ( ( ruleAadlClassifierReference ) )
                            {
                            otherlv_6=(Token)match(input,Of,FOLLOW_Of_in_ruleGoal1711); 

                                	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getOfKeyword_3_2_0());
                                
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:918:1: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:919:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:920:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getGoalRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getGoalAccess().getTargetContextClassifierCrossReference_3_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleGoal1733);
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

            otherlv_8=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleGoal1750); 

                	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_4());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:938:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:940:1: ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:940:1: ( ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:941:2: ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:944:2: ( ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:945:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:945:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop27:
            do {
                int alt27=15;
                alt27 = dfa27.predict(input);
                switch (alt27) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:947:4: ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:947:4: ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:948:5: {...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:948:101: ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:949:6: ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:952:6: ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:952:7: {...}? => (otherlv_10= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:952:16: (otherlv_10= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:953:2: otherlv_10= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_10=(Token)match(input,Category,FOLLOW_Category_in_ruleGoal1808); 

            	        	newLeafNode(otherlv_10, grammarAccess.getGoalAccess().getCategoryKeyword_5_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:957:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:958:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:958:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:959:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getCategoryRequirementCategoryCrossReference_5_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleGoal1830);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:979:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:979:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:980:5: {...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:980:101: ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:981:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:984:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:984:7: {...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:984:16: (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:985:2: otherlv_12= Description ( (lv_description_13_0= ruleDescription ) )
            	    {
            	    otherlv_12=(Token)match(input,Description,FOLLOW_Description_in_ruleGoal1899); 

            	        	newLeafNode(otherlv_12, grammarAccess.getGoalAccess().getDescriptionKeyword_5_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:989:1: ( (lv_description_13_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:990:1: (lv_description_13_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:990:1: (lv_description_13_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:991:3: lv_description_13_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDescriptionDescriptionParserRuleCall_5_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleGoal1919);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1014:4: ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1014:4: ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1015:5: {...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1015:101: ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1016:6: ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1019:6: ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1019:7: {...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1019:16: (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1020:2: otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) )
            	    {
            	    otherlv_14=(Token)match(input,Assert,FOLLOW_Assert_in_ruleGoal1988); 

            	        	newLeafNode(otherlv_14, grammarAccess.getGoalAccess().getAssertKeyword_5_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1024:1: ( (lv_assert_15_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1025:1: (lv_assert_15_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1025:1: (lv_assert_15_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1026:3: lv_assert_15_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getAssertPredicateExpressionParserRuleCall_5_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleGoal2008);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1049:4: ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1049:4: ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1050:5: {...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1050:101: ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1051:6: ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:6: ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:7: {...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1054:16: (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1055:2: otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) )
            	    {
            	    otherlv_16=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleGoal2077); 

            	        	newLeafNode(otherlv_16, grammarAccess.getGoalAccess().getRationaleKeyword_5_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1059:1: ( (lv_rationale_17_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1060:1: (lv_rationale_17_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1060:1: (lv_rationale_17_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1061:3: lv_rationale_17_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRationaleMultiLineStringParserRuleCall_5_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleGoal2097);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1084:4: ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1084:4: ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1085:5: {...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1085:101: ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1086:6: ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1089:6: ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1089:7: {...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1089:16: (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1090:2: otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )*
            	    {
            	    otherlv_18=(Token)match(input,Issues,FOLLOW_Issues_in_ruleGoal2166); 

            	        	newLeafNode(otherlv_18, grammarAccess.getGoalAccess().getIssuesKeyword_5_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1094:1: ( (lv_issue_19_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1095:1: (lv_issue_19_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1095:1: (lv_issue_19_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1096:3: lv_issue_19_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueMultiLineStringParserRuleCall_5_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleGoal2186);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1112:2: (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )*
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==Comma) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1113:2: otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) )
            	    	    {
            	    	    otherlv_20=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2200); 

            	    	        	newLeafNode(otherlv_20, grammarAccess.getGoalAccess().getCommaKeyword_5_4_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1117:1: ( (lv_issue_21_0= ruleMultiLineString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1118:1: (lv_issue_21_0= ruleMultiLineString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1118:1: (lv_issue_21_0= ruleMultiLineString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1119:3: lv_issue_21_0= ruleMultiLineString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getIssueMultiLineStringParserRuleCall_5_4_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleGoal2220);
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
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:4: ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1142:4: ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:5: {...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1143:101: ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1144:6: ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1147:6: ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1147:7: {...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1147:16: (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1148:2: otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_22=(Token)match(input,Refined,FOLLOW_Refined_in_ruleGoal2291); 

            	        	newLeafNode(otherlv_22, grammarAccess.getGoalAccess().getRefinedKeyword_5_5_0());
            	        
            	    otherlv_23=(Token)match(input,To,FOLLOW_To_in_ruleGoal2303); 

            	        	newLeafNode(otherlv_23, grammarAccess.getGoalAccess().getToKeyword_5_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1157:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1158:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1158:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1159:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2325);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1172:2: (otherlv_25= Comma ( ( ruleQualifiedName ) ) )*
            	    loop18:
            	    do {
            	        int alt18=2;
            	        int LA18_0 = input.LA(1);

            	        if ( (LA18_0==Comma) ) {
            	            alt18=1;
            	        }


            	        switch (alt18) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1173:2: otherlv_25= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_25=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2339); 

            	    	        	newLeafNode(otherlv_25, grammarAccess.getGoalAccess().getCommaKeyword_5_5_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1177:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1178:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1178:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1179:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getRefinesReferenceGoalCrossReference_5_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2361);
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
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1199:4: ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1199:4: ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1200:5: {...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1200:101: ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1201:6: ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1204:6: ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+
            	    int cnt19=0;
            	    loop19:
            	    do {
            	        int alt19=2;
            	        int LA19_0 = input.LA(1);

            	        if ( (LA19_0==Goal) ) {
            	            int LA19_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt19=1;
            	            }


            	        }


            	        switch (alt19) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1204:7: {...}? => ( (lv_subgoal_27_0= ruleGoal ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1204:16: ( (lv_subgoal_27_0= ruleGoal ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1205:1: (lv_subgoal_27_0= ruleGoal )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1205:1: (lv_subgoal_27_0= ruleGoal )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1206:3: lv_subgoal_27_0= ruleGoal
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSubgoalGoalParserRuleCall_5_6_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleGoal_in_ruleGoal2439);
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
            	    	    if ( cnt19 >= 1 ) break loop19;
            	                EarlyExitException eee =
            	                    new EarlyExitException(19, input);
            	                throw eee;
            	        }
            	        cnt19++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1229:4: ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1229:4: ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1230:5: {...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1230:101: ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1231:6: ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1234:6: ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1234:7: {...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1234:16: (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1235:2: otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_28=(Token)match(input,Decomposed,FOLLOW_Decomposed_in_ruleGoal2508); 

            	        	newLeafNode(otherlv_28, grammarAccess.getGoalAccess().getDecomposedKeyword_5_7_0());
            	        
            	    otherlv_29=(Token)match(input,To,FOLLOW_To_in_ruleGoal2520); 

            	        	newLeafNode(otherlv_29, grammarAccess.getGoalAccess().getToKeyword_5_7_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1244:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1245:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1245:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1246:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_5_7_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2542);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1259:2: (otherlv_31= Comma ( ( ruleQualifiedName ) ) )*
            	    loop20:
            	    do {
            	        int alt20=2;
            	        int LA20_0 = input.LA(1);

            	        if ( (LA20_0==Comma) ) {
            	            alt20=1;
            	        }


            	        switch (alt20) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1260:2: otherlv_31= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_31=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2556); 

            	    	        	newLeafNode(otherlv_31, grammarAccess.getGoalAccess().getCommaKeyword_5_7_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1264:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1265:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1265:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1266:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDecomposesReferenceGoalCrossReference_5_7_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2578);
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
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1286:4: ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1286:4: ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1287:5: {...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1287:101: ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1288:6: ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1291:6: ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1291:7: {...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1291:16: (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1292:2: otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_33=(Token)match(input,Evolved,FOLLOW_Evolved_in_ruleGoal2649); 

            	        	newLeafNode(otherlv_33, grammarAccess.getGoalAccess().getEvolvedKeyword_5_8_0());
            	        
            	    otherlv_34=(Token)match(input,To,FOLLOW_To_in_ruleGoal2661); 

            	        	newLeafNode(otherlv_34, grammarAccess.getGoalAccess().getToKeyword_5_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1301:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1302:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1302:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1303:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_5_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2683);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1316:2: (otherlv_36= Comma ( ( ruleQualifiedName ) ) )*
            	    loop21:
            	    do {
            	        int alt21=2;
            	        int LA21_0 = input.LA(1);

            	        if ( (LA21_0==Comma) ) {
            	            alt21=1;
            	        }


            	        switch (alt21) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1317:2: otherlv_36= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_36=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2697); 

            	    	        	newLeafNode(otherlv_36, grammarAccess.getGoalAccess().getCommaKeyword_5_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1321:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1322:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1322:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1323:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getEvolvesReferenceGoalCrossReference_5_8_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2719);
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
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1343:4: ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1343:4: ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1344:5: {...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1344:101: ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1345:6: ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1348:6: ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1348:7: {...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1348:16: (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1349:2: otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_38=(Token)match(input,Conflicts,FOLLOW_Conflicts_in_ruleGoal2790); 

            	        	newLeafNode(otherlv_38, grammarAccess.getGoalAccess().getConflictsKeyword_5_9_0());
            	        
            	    otherlv_39=(Token)match(input,With,FOLLOW_With_in_ruleGoal2802); 

            	        	newLeafNode(otherlv_39, grammarAccess.getGoalAccess().getWithKeyword_5_9_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1358:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1359:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1359:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1360:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_9_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2824);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1373:2: (otherlv_41= Comma ( ( ruleQualifiedName ) ) )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Comma) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1374:2: otherlv_41= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_41=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2838); 

            	    	        	newLeafNode(otherlv_41, grammarAccess.getGoalAccess().getCommaKeyword_5_9_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1378:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1379:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1379:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1380:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getConflictsReferenceGoalCrossReference_5_9_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2860);
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
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1400:4: ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1400:4: ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1401:5: {...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1401:102: ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1402:6: ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1405:6: ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1405:7: {...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1405:16: (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1406:2: otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_43=(Token)match(input,Stakeholder,FOLLOW_Stakeholder_in_ruleGoal2931); 

            	        	newLeafNode(otherlv_43, grammarAccess.getGoalAccess().getStakeholderKeyword_5_10_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1410:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1411:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1411:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1412:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2953);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1425:2: (otherlv_45= Comma ( ( ruleQualifiedName ) ) )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        int LA23_0 = input.LA(1);

            	        if ( (LA23_0==Comma) ) {
            	            alt23=1;
            	        }


            	        switch (alt23) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1426:2: otherlv_45= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_45=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal2967); 

            	    	        	newLeafNode(otherlv_45, grammarAccess.getGoalAccess().getCommaKeyword_5_10_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1430:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1431:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1431:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1432:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderReferenceStakeholderCrossReference_5_10_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal2989);
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
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1452:4: ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1452:4: ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1453:5: {...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1453:102: ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1454:6: ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1457:6: ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1457:7: {...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1457:16: (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1458:2: otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_47=(Token)match(input,See,FOLLOW_See_in_ruleGoal3060); 

            	        	newLeafNode(otherlv_47, grammarAccess.getGoalAccess().getSeeKeyword_5_11_0());
            	        
            	    otherlv_48=(Token)match(input,Goal,FOLLOW_Goal_in_ruleGoal3072); 

            	        	newLeafNode(otherlv_48, grammarAccess.getGoalAccess().getGoalKeyword_5_11_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1467:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1468:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1468:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1469:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_5_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3094);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1482:2: (otherlv_50= Comma ( ( ruleQualifiedName ) ) )*
            	    loop24:
            	    do {
            	        int alt24=2;
            	        int LA24_0 = input.LA(1);

            	        if ( (LA24_0==Comma) ) {
            	            alt24=1;
            	        }


            	        switch (alt24) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1483:2: otherlv_50= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_50=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3108); 

            	    	        	newLeafNode(otherlv_50, grammarAccess.getGoalAccess().getCommaKeyword_5_11_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1487:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1488:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1488:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1489:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getStakeholderRequirementReferenceGoalCrossReference_5_11_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3130);
            	    	    ruleQualifiedName();

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:4: ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1509:4: ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1510:5: {...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1510:102: ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1511:6: ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1514:6: ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1514:7: {...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1514:16: (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1515:2: otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_52=(Token)match(input,See,FOLLOW_See_in_ruleGoal3201); 

            	        	newLeafNode(otherlv_52, grammarAccess.getGoalAccess().getSeeKeyword_5_12_0());
            	        
            	    otherlv_53=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleGoal3213); 

            	        	newLeafNode(otherlv_53, grammarAccess.getGoalAccess().getRequirementKeyword_5_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1524:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1525:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1525:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1526:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_5_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3235);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1539:2: (otherlv_55= Comma ( ( ruleQualifiedName ) ) )*
            	    loop25:
            	    do {
            	        int alt25=2;
            	        int LA25_0 = input.LA(1);

            	        if ( (LA25_0==Comma) ) {
            	            alt25=1;
            	        }


            	        switch (alt25) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1540:2: otherlv_55= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_55=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3249); 

            	    	        	newLeafNode(otherlv_55, grammarAccess.getGoalAccess().getCommaKeyword_5_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1544:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1545:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1545:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1546:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getGoalRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getSystemRequirementReferenceContractualElementCrossReference_5_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleGoal3271);
            	    	    ruleQualifiedName();

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1566:4: ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1566:4: ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1567:5: {...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1567:102: ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1568:6: ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1571:6: ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1571:7: {...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleGoal", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1571:16: (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1572:2: otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_57=(Token)match(input,See,FOLLOW_See_in_ruleGoal3342); 

            	        	newLeafNode(otherlv_57, grammarAccess.getGoalAccess().getSeeKeyword_5_13_0());
            	        
            	    otherlv_58=(Token)match(input,Document,FOLLOW_Document_in_ruleGoal3354); 

            	        	newLeafNode(otherlv_58, grammarAccess.getGoalAccess().getDocumentKeyword_5_13_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1581:1: ( (lv_docReference_59_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1582:1: (lv_docReference_59_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1582:1: (lv_docReference_59_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1583:3: lv_docReference_59_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_13_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3374);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1599:2: (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==Comma) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1600:2: otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_60=(Token)match(input,Comma,FOLLOW_Comma_in_ruleGoal3388); 

            	    	        	newLeafNode(otherlv_60, grammarAccess.getGoalAccess().getCommaKeyword_5_13_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1604:1: ( (lv_docReference_61_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1605:1: (lv_docReference_61_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1605:1: (lv_docReference_61_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1606:3: lv_docReference_61_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getGoalAccess().getDocReferenceExternalDocumentParserRuleCall_5_13_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleGoal3408);
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
            	    	    break loop26;
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
            	    break loop27;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getGoalAccess().getUnorderedGroup_5());
            	

            }

            otherlv_62=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleGoal3464); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1649:1: entryRuleRequirement returns [EObject current=null] : iv_ruleRequirement= ruleRequirement EOF ;
    public final EObject entryRuleRequirement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1650:2: (iv_ruleRequirement= ruleRequirement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1651:2: iv_ruleRequirement= ruleRequirement EOF
            {
             newCompositeNode(grammarAccess.getRequirementRule()); 
            pushFollow(FOLLOW_ruleRequirement_in_entryRuleRequirement3498);
            iv_ruleRequirement=ruleRequirement();

            state._fsp--;

             current =iv_ruleRequirement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirement3508); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1658:1: ruleRequirement returns [EObject current=null] : (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1661:28: ( (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1662:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1662:1: (otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1663:2: otherlv_0= Requirement ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )? (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )? (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )? otherlv_11= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) ) otherlv_60= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement3546); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementAccess().getRequirementKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1667:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1668:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1668:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1669:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3562); 

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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1685:2: (otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==Colon) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1686:2: otherlv_2= Colon ( (lv_title_3_0= ruleValueString ) )
                    {
                    otherlv_2=(Token)match(input,Colon,FOLLOW_Colon_in_ruleRequirement3581); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementAccess().getColonKeyword_2_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1690:1: ( (lv_title_3_0= ruleValueString ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1691:1: (lv_title_3_0= ruleValueString )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1691:1: (lv_title_3_0= ruleValueString )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1692:3: lv_title_3_0= ruleValueString
                    {
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getTitleValueStringParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueString_in_ruleRequirement3601);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1708:4: (otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==LeftParenthesis) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1709:2: otherlv_4= LeftParenthesis ( ( ruleCatRef ) ) otherlv_6= RightParenthesis
                    {
                    otherlv_4=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_ruleRequirement3617); 

                        	newLeafNode(otherlv_4, grammarAccess.getRequirementAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1713:1: ( ( ruleCatRef ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1714:1: ( ruleCatRef )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1714:1: ( ruleCatRef )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1715:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRequirementAccess().getCategoryRequirementCategoryCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirement3639);
                    ruleCatRef();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_ruleRequirement3652); 

                        	newLeafNode(otherlv_6, grammarAccess.getRequirementAccess().getRightParenthesisKeyword_3_2());
                        

                    }
                    break;

            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1733:3: (otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )? )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==For) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1734:2: otherlv_7= For ( (otherlv_8= RULE_ID ) ) (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )?
                    {
                    otherlv_7=(Token)match(input,For,FOLLOW_For_in_ruleRequirement3667); 

                        	newLeafNode(otherlv_7, grammarAccess.getRequirementAccess().getForKeyword_4_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1738:1: ( (otherlv_8= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1739:1: (otherlv_8= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1739:1: (otherlv_8= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1740:3: otherlv_8= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementRule());
                    	        }
                            
                    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirement3686); 

                    		newLeafNode(otherlv_8, grammarAccess.getRequirementAccess().getTargetNamedElementCrossReference_4_1_0()); 
                    	

                    }


                    }

                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1751:2: (otherlv_9= Of ( ( ruleAadlClassifierReference ) ) )?
                    int alt30=2;
                    int LA30_0 = input.LA(1);

                    if ( (LA30_0==Of) ) {
                        alt30=1;
                    }
                    switch (alt30) {
                        case 1 :
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1752:2: otherlv_9= Of ( ( ruleAadlClassifierReference ) )
                            {
                            otherlv_9=(Token)match(input,Of,FOLLOW_Of_in_ruleRequirement3700); 

                                	newLeafNode(otherlv_9, grammarAccess.getRequirementAccess().getOfKeyword_4_2_0());
                                
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1756:1: ( ( ruleAadlClassifierReference ) )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1757:1: ( ruleAadlClassifierReference )
                            {
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1757:1: ( ruleAadlClassifierReference )
                            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1758:3: ruleAadlClassifierReference
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getRequirementRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getRequirementAccess().getTargetContextClassifierCrossReference_4_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleRequirement3722);
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

            otherlv_11=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirement3739); 

                	newLeafNode(otherlv_11, grammarAccess.getRequirementAccess().getLeftSquareBracketKeyword_5());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1776:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1778:1: ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1778:1: ( ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1779:2: ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1782:2: ( ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1783:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )*
            loop42:
            do {
                int alt42=14;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1785:4: ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1785:4: ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1786:5: {...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1786:108: ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1787:6: ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1790:6: ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1790:7: {...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1790:16: (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1791:2: otherlv_13= Description ( (lv_description_14_0= ruleDescription ) )
            	    {
            	    otherlv_13=(Token)match(input,Description,FOLLOW_Description_in_ruleRequirement3797); 

            	        	newLeafNode(otherlv_13, grammarAccess.getRequirementAccess().getDescriptionKeyword_6_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1795:1: ( (lv_description_14_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1796:1: (lv_description_14_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1796:1: (lv_description_14_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1797:3: lv_description_14_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDescriptionDescriptionParserRuleCall_6_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleRequirement3817);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1820:4: ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1820:4: ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1821:5: {...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1821:108: ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1822:6: ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1825:6: ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1825:7: {...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1825:16: (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1826:2: otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+
            	    {
            	    otherlv_15=(Token)match(input,Parameters,FOLLOW_Parameters_in_ruleRequirement3886); 

            	        	newLeafNode(otherlv_15, grammarAccess.getRequirementAccess().getParametersKeyword_6_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1830:1: ( (lv_parameters_16_0= ruleFinalValue ) )+
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
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1831:1: (lv_parameters_16_0= ruleFinalValue )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1831:1: (lv_parameters_16_0= ruleFinalValue )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1832:3: lv_parameters_16_0= ruleFinalValue
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getParametersFinalValueParserRuleCall_6_1_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleFinalValue_in_ruleRequirement3906);
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
            	    	    if ( cnt32 >= 1 ) break loop32;
            	                EarlyExitException eee =
            	                    new EarlyExitException(32, input);
            	                throw eee;
            	        }
            	        cnt32++;
            	    } while (true);


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1855:4: ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1855:4: ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1856:5: {...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1856:108: ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1857:6: ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1860:6: ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1860:7: {...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1860:16: (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1861:2: otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) )
            	    {
            	    otherlv_17=(Token)match(input,Assert,FOLLOW_Assert_in_ruleRequirement3976); 

            	        	newLeafNode(otherlv_17, grammarAccess.getRequirementAccess().getAssertKeyword_6_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1865:1: ( (lv_assert_18_0= rulePredicateExpression ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1866:1: (lv_assert_18_0= rulePredicateExpression )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1866:1: (lv_assert_18_0= rulePredicateExpression )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1867:3: lv_assert_18_0= rulePredicateExpression
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getAssertPredicateExpressionParserRuleCall_6_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePredicateExpression_in_ruleRequirement3996);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1890:4: ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1890:4: ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1891:5: {...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1891:108: ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1892:6: ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1895:6: ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1895:7: {...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1895:16: (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1896:2: otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) )
            	    {
            	    otherlv_19=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleRequirement4065); 

            	        	newLeafNode(otherlv_19, grammarAccess.getRequirementAccess().getRationaleKeyword_6_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1900:1: ( (lv_rationale_20_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1901:1: (lv_rationale_20_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1901:1: (lv_rationale_20_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1902:3: lv_rationale_20_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRationaleMultiLineStringParserRuleCall_6_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleRequirement4085);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1925:4: ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1925:4: ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:5: {...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1926:108: ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1927:6: ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1930:6: ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1930:7: {...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1930:16: (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1931:2: otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )*
            	    {
            	    otherlv_21=(Token)match(input,Issues,FOLLOW_Issues_in_ruleRequirement4154); 

            	        	newLeafNode(otherlv_21, grammarAccess.getRequirementAccess().getIssuesKeyword_6_4_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1935:1: ( (lv_issue_22_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1936:1: (lv_issue_22_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1936:1: (lv_issue_22_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1937:3: lv_issue_22_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueMultiLineStringParserRuleCall_6_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleRequirement4174);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1953:2: (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )*
            	    loop33:
            	    do {
            	        int alt33=2;
            	        int LA33_0 = input.LA(1);

            	        if ( (LA33_0==Comma) ) {
            	            alt33=1;
            	        }


            	        switch (alt33) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1954:2: otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) )
            	    	    {
            	    	    otherlv_23=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4188); 

            	    	        	newLeafNode(otherlv_23, grammarAccess.getRequirementAccess().getCommaKeyword_6_4_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1958:1: ( (lv_issue_24_0= ruleMultiLineString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1959:1: (lv_issue_24_0= ruleMultiLineString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1959:1: (lv_issue_24_0= ruleMultiLineString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1960:3: lv_issue_24_0= ruleMultiLineString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getIssueMultiLineStringParserRuleCall_6_4_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleRequirement4208);
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
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:4: ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1983:4: ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1984:5: {...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1984:108: ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1985:6: ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1988:6: ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1988:7: {...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1988:16: (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1989:2: otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_25=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4279); 

            	        	newLeafNode(otherlv_25, grammarAccess.getRequirementAccess().getSeeKeyword_6_5_0());
            	        
            	    otherlv_26=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4291); 

            	        	newLeafNode(otherlv_26, grammarAccess.getRequirementAccess().getGoalKeyword_6_5_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1998:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1999:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:1999:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2000:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_6_5_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4313);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2013:2: (otherlv_28= Comma ( ( ruleQualifiedName ) ) )*
            	    loop34:
            	    do {
            	        int alt34=2;
            	        int LA34_0 = input.LA(1);

            	        if ( (LA34_0==Comma) ) {
            	            alt34=1;
            	        }


            	        switch (alt34) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2014:2: otherlv_28= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_28=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4327); 

            	    	        	newLeafNode(otherlv_28, grammarAccess.getRequirementAccess().getCommaKeyword_6_5_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2018:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2019:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2019:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2020:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getGoalReferenceGoalCrossReference_6_5_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4349);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2040:4: ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2040:4: ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2041:5: {...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2041:108: ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2042:6: ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2045:6: ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2045:7: {...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2045:16: (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2046:2: otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_30=(Token)match(input,Refined,FOLLOW_Refined_in_ruleRequirement4420); 

            	        	newLeafNode(otherlv_30, grammarAccess.getRequirementAccess().getRefinedKeyword_6_6_0());
            	        
            	    otherlv_31=(Token)match(input,To,FOLLOW_To_in_ruleRequirement4432); 

            	        	newLeafNode(otherlv_31, grammarAccess.getRequirementAccess().getToKeyword_6_6_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2055:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2056:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2056:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2057:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinedReferenceRequirementCrossReference_6_6_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4454);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2070:2: (otherlv_33= Comma ( ( ruleQualifiedName ) ) )*
            	    loop35:
            	    do {
            	        int alt35=2;
            	        int LA35_0 = input.LA(1);

            	        if ( (LA35_0==Comma) ) {
            	            alt35=1;
            	        }


            	        switch (alt35) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2071:2: otherlv_33= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_33=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4468); 

            	    	        	newLeafNode(otherlv_33, grammarAccess.getRequirementAccess().getCommaKeyword_6_6_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2075:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2076:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2076:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2077:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getRefinesReferenceRequirementCrossReference_6_6_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4490);
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
            	case 8 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2097:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2097:4: ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2098:5: {...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2098:108: ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2099:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2102:6: ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+
            	    int cnt36=0;
            	    loop36:
            	    do {
            	        int alt36=2;
            	        int LA36_0 = input.LA(1);

            	        if ( (LA36_0==Requirement) ) {
            	            int LA36_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt36=1;
            	            }


            	        }


            	        switch (alt36) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2102:7: {...}? => ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    	    }
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2102:16: ( (lv_subrequirement_35_0= ruleRequirement ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2103:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2103:1: (lv_subrequirement_35_0= ruleRequirement )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2104:3: lv_subrequirement_35_0= ruleRequirement
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSubrequirementRequirementParserRuleCall_6_7_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleRequirement_in_ruleRequirement4568);
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
            	    	    if ( cnt36 >= 1 ) break loop36;
            	                EarlyExitException eee =
            	                    new EarlyExitException(36, input);
            	                throw eee;
            	        }
            	        cnt36++;
            	    } while (true);

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2127:4: ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2127:4: ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2128:5: {...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2128:108: ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2129:6: ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2132:6: ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2132:7: {...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2132:16: (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2133:2: otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_36=(Token)match(input,Decomposed,FOLLOW_Decomposed_in_ruleRequirement4637); 

            	        	newLeafNode(otherlv_36, grammarAccess.getRequirementAccess().getDecomposedKeyword_6_8_0());
            	        
            	    otherlv_37=(Token)match(input,To,FOLLOW_To_in_ruleRequirement4649); 

            	        	newLeafNode(otherlv_37, grammarAccess.getRequirementAccess().getToKeyword_6_8_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2142:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2143:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2143:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2144:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposedReferenceRequirementCrossReference_6_8_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4671);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2157:2: (otherlv_39= Comma ( ( ruleQualifiedName ) ) )*
            	    loop37:
            	    do {
            	        int alt37=2;
            	        int LA37_0 = input.LA(1);

            	        if ( (LA37_0==Comma) ) {
            	            alt37=1;
            	        }


            	        switch (alt37) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2158:2: otherlv_39= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_39=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4685); 

            	    	        	newLeafNode(otherlv_39, grammarAccess.getRequirementAccess().getCommaKeyword_6_8_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2162:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2163:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2163:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2164:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDecomposesReferenceRequirementCrossReference_6_8_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4707);
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
            	case 10 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2184:4: ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2184:4: ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2185:5: {...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2185:108: ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2186:6: ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2189:6: ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2189:7: {...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2189:16: (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2190:2: otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_41=(Token)match(input,Evolves,FOLLOW_Evolves_in_ruleRequirement4778); 

            	        	newLeafNode(otherlv_41, grammarAccess.getRequirementAccess().getEvolvesKeyword_6_9_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2194:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2195:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2195:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2196:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_6_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4800);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2209:2: (otherlv_43= Comma ( ( ruleQualifiedName ) ) )*
            	    loop38:
            	    do {
            	        int alt38=2;
            	        int LA38_0 = input.LA(1);

            	        if ( (LA38_0==Comma) ) {
            	            alt38=1;
            	        }


            	        switch (alt38) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2210:2: otherlv_43= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_43=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4814); 

            	    	        	newLeafNode(otherlv_43, grammarAccess.getRequirementAccess().getCommaKeyword_6_9_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2214:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2215:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2215:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2216:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getEvolvesReferenceRequirementCrossReference_6_9_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4836);
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
            	case 11 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2236:4: ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2236:4: ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2237:5: {...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2237:109: ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2238:6: ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2241:6: ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2241:7: {...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2241:16: (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2242:2: otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_45=(Token)match(input,See,FOLLOW_See_in_ruleRequirement4907); 

            	        	newLeafNode(otherlv_45, grammarAccess.getRequirementAccess().getSeeKeyword_6_10_0());
            	        
            	    otherlv_46=(Token)match(input,Goal,FOLLOW_Goal_in_ruleRequirement4919); 

            	        	newLeafNode(otherlv_46, grammarAccess.getRequirementAccess().getGoalKeyword_6_10_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2251:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2252:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2252:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2253:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_6_10_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4941);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2266:2: (otherlv_48= Comma ( ( ruleQualifiedName ) ) )*
            	    loop39:
            	    do {
            	        int alt39=2;
            	        int LA39_0 = input.LA(1);

            	        if ( (LA39_0==Comma) ) {
            	            alt39=1;
            	        }


            	        switch (alt39) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2267:2: otherlv_48= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_48=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement4955); 

            	    	        	newLeafNode(otherlv_48, grammarAccess.getRequirementAccess().getCommaKeyword_6_10_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2271:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2272:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2272:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2273:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getStakeholderRequirementReferenceGoalCrossReference_6_10_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement4977);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
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
            	case 12 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2293:4: ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2293:4: ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2294:5: {...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2294:109: ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2295:6: ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2298:6: ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2298:7: {...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2298:16: (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2299:2: otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_50=(Token)match(input,See,FOLLOW_See_in_ruleRequirement5048); 

            	        	newLeafNode(otherlv_50, grammarAccess.getRequirementAccess().getSeeKeyword_6_11_0());
            	        
            	    otherlv_51=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirement5060); 

            	        	newLeafNode(otherlv_51, grammarAccess.getRequirementAccess().getRequirementKeyword_6_11_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2308:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2309:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2309:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2310:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_6_11_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement5082);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2323:2: (otherlv_53= Comma ( ( ruleQualifiedName ) ) )*
            	    loop40:
            	    do {
            	        int alt40=2;
            	        int LA40_0 = input.LA(1);

            	        if ( (LA40_0==Comma) ) {
            	            alt40=1;
            	        }


            	        switch (alt40) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2324:2: otherlv_53= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_53=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement5096); 

            	    	        	newLeafNode(otherlv_53, grammarAccess.getRequirementAccess().getCommaKeyword_6_11_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2328:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2329:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2329:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2330:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getRequirementRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getSystemRequirementReferenceContractualElementCrossReference_6_11_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleRequirement5118);
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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2350:4: ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2350:4: ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2351:5: {...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2351:109: ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2352:6: ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2355:6: ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2355:7: {...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleRequirement", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2355:16: (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2356:2: otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )*
            	    {
            	    otherlv_55=(Token)match(input,See,FOLLOW_See_in_ruleRequirement5189); 

            	        	newLeafNode(otherlv_55, grammarAccess.getRequirementAccess().getSeeKeyword_6_12_0());
            	        
            	    otherlv_56=(Token)match(input,Document,FOLLOW_Document_in_ruleRequirement5201); 

            	        	newLeafNode(otherlv_56, grammarAccess.getRequirementAccess().getDocumentKeyword_6_12_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2365:1: ( (lv_docReference_57_0= ruleExternalDocument ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2366:1: (lv_docReference_57_0= ruleExternalDocument )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2366:1: (lv_docReference_57_0= ruleExternalDocument )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2367:3: lv_docReference_57_0= ruleExternalDocument
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_6_12_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement5221);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2383:2: (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )*
            	    loop41:
            	    do {
            	        int alt41=2;
            	        int LA41_0 = input.LA(1);

            	        if ( (LA41_0==Comma) ) {
            	            alt41=1;
            	        }


            	        switch (alt41) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2384:2: otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) )
            	    	    {
            	    	    otherlv_58=(Token)match(input,Comma,FOLLOW_Comma_in_ruleRequirement5235); 

            	    	        	newLeafNode(otherlv_58, grammarAccess.getRequirementAccess().getCommaKeyword_6_12_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2388:1: ( (lv_docReference_59_0= ruleExternalDocument ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2389:1: (lv_docReference_59_0= ruleExternalDocument )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2389:1: (lv_docReference_59_0= ruleExternalDocument )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2390:3: lv_docReference_59_0= ruleExternalDocument
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getRequirementAccess().getDocReferenceExternalDocumentParserRuleCall_6_12_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleExternalDocument_in_ruleRequirement5255);
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
            	    	    break loop41;
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
            	    break loop42;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getRequirementAccess().getUnorderedGroup_6());
            	

            }

            otherlv_60=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirement5311); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2433:1: entryRuleHazard returns [EObject current=null] : iv_ruleHazard= ruleHazard EOF ;
    public final EObject entryRuleHazard() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazard = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2434:2: (iv_ruleHazard= ruleHazard EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2435:2: iv_ruleHazard= ruleHazard EOF
            {
             newCompositeNode(grammarAccess.getHazardRule()); 
            pushFollow(FOLLOW_ruleHazard_in_entryRuleHazard5345);
            iv_ruleHazard=ruleHazard();

            state._fsp--;

             current =iv_ruleHazard; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazard5355); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2442:1: ruleHazard returns [EObject current=null] : (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2445:28: ( (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2446:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2446:1: (otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2447:2: otherlv_0= Hazard ( (lv_name_1_0= RULE_ID ) ) otherlv_2= LeftSquareBracket ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) ) otherlv_25= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Hazard,FOLLOW_Hazard_in_ruleHazard5393); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardAccess().getHazardKeyword_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2451:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2452:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2452:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2453:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard5409); 

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

            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleHazard5427); 

                	newLeafNode(otherlv_2, grammarAccess.getHazardAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2474:1: ( ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2476:1: ( ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2477:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2480:2: ( ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )*
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2481:3: ( ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) ) | ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) )*
            loop46:
            do {
                int alt46=8;
                int LA46_0 = input.LA(1);

                if ( LA46_0 ==For && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
                    alt46=1;
                }
                else if ( LA46_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
                    alt46=2;
                }
                else if ( LA46_0 ==Title && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
                    alt46=3;
                }
                else if ( LA46_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
                    alt46=4;
                }
                else if ( LA46_0 ==Mitigated && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
                    alt46=5;
                }
                else if ( LA46_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
                    alt46=6;
                }
                else if ( LA46_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
                    alt46=7;
                }


                switch (alt46) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2483:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2483:4: ({...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2484:5: {...}? => ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2484:103: ( ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2485:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 0);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2488:6: ({...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2488:7: {...}? => (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2488:16: (otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )? )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2489:2: otherlv_4= For ( (otherlv_5= RULE_ID ) ) (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
            	    {
            	    otherlv_4=(Token)match(input,For,FOLLOW_For_in_ruleHazard5485); 

            	        	newLeafNode(otherlv_4, grammarAccess.getHazardAccess().getForKeyword_3_0_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2493:1: ( (otherlv_5= RULE_ID ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2494:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2494:1: (otherlv_5= RULE_ID )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2495:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazard5504); 

            	    		newLeafNode(otherlv_5, grammarAccess.getHazardAccess().getTargetNamedElementCrossReference_3_0_1_0()); 
            	    	

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2506:2: (otherlv_6= Of ( ( ruleAadlClassifierReference ) ) )?
            	    int alt43=2;
            	    int LA43_0 = input.LA(1);

            	    if ( (LA43_0==Of) ) {
            	        alt43=1;
            	    }
            	    switch (alt43) {
            	        case 1 :
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2507:2: otherlv_6= Of ( ( ruleAadlClassifierReference ) )
            	            {
            	            otherlv_6=(Token)match(input,Of,FOLLOW_Of_in_ruleHazard5518); 

            	                	newLeafNode(otherlv_6, grammarAccess.getHazardAccess().getOfKeyword_3_0_2_0());
            	                
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2511:1: ( ( ruleAadlClassifierReference ) )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2512:1: ( ruleAadlClassifierReference )
            	            {
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2512:1: ( ruleAadlClassifierReference )
            	            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2513:3: ruleAadlClassifierReference
            	            {

            	            			if (current==null) {
            	            	            current = createModelElement(grammarAccess.getHazardRule());
            	            	        }
            	                    
            	             
            	            	        newCompositeNode(grammarAccess.getHazardAccess().getTargetContextClassifierCrossReference_3_0_2_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleAadlClassifierReference_in_ruleHazard5540);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2533:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2533:4: ({...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2534:5: {...}? => ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2534:103: ( ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2535:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 1);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2538:6: ({...}? => (otherlv_8= Category ( ( ruleCatRef ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2538:7: {...}? => (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2538:16: (otherlv_8= Category ( ( ruleCatRef ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2539:2: otherlv_8= Category ( ( ruleCatRef ) )
            	    {
            	    otherlv_8=(Token)match(input,Category,FOLLOW_Category_in_ruleHazard5611); 

            	        	newLeafNode(otherlv_8, grammarAccess.getHazardAccess().getCategoryKeyword_3_1_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2543:1: ( ( ruleCatRef ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2544:1: ( ruleCatRef )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2544:1: ( ruleCatRef )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2545:3: ruleCatRef
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getCategoryHazardCategoryCrossReference_3_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCatRef_in_ruleHazard5633);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2565:4: ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2565:4: ({...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2566:5: {...}? => ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2566:103: ( ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2567:6: ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 2);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2570:6: ({...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2570:7: {...}? => (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2570:16: (otherlv_10= Title ( (lv_title_11_0= ruleValueString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2571:2: otherlv_10= Title ( (lv_title_11_0= ruleValueString ) )
            	    {
            	    otherlv_10=(Token)match(input,Title,FOLLOW_Title_in_ruleHazard5702); 

            	        	newLeafNode(otherlv_10, grammarAccess.getHazardAccess().getTitleKeyword_3_2_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2575:1: ( (lv_title_11_0= ruleValueString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2576:1: (lv_title_11_0= ruleValueString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2576:1: (lv_title_11_0= ruleValueString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2577:3: lv_title_11_0= ruleValueString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getTitleValueStringParserRuleCall_3_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueString_in_ruleHazard5722);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2600:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2600:4: ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2601:5: {...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2601:103: ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2602:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 3);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2605:6: ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2605:7: {...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2605:16: (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2606:2: otherlv_12= Description ( (lv_description_13_0= ruleDescription ) )
            	    {
            	    otherlv_12=(Token)match(input,Description,FOLLOW_Description_in_ruleHazard5791); 

            	        	newLeafNode(otherlv_12, grammarAccess.getHazardAccess().getDescriptionKeyword_3_3_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2610:1: ( (lv_description_13_0= ruleDescription ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2611:1: (lv_description_13_0= ruleDescription )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2611:1: (lv_description_13_0= ruleDescription )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2612:3: lv_description_13_0= ruleDescription
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getDescriptionDescriptionParserRuleCall_3_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescription_in_ruleHazard5811);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2635:4: ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2635:4: ({...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2636:5: {...}? => ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2636:103: ( ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2637:6: ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 4);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2640:6: ({...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2640:7: {...}? => (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2640:16: (otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2641:2: otherlv_14= Mitigated otherlv_15= By ( ( ruleQualifiedName ) ) (otherlv_17= Comma ( ( ruleQualifiedName ) ) )*
            	    {
            	    otherlv_14=(Token)match(input,Mitigated,FOLLOW_Mitigated_in_ruleHazard5880); 

            	        	newLeafNode(otherlv_14, grammarAccess.getHazardAccess().getMitigatedKeyword_3_4_0());
            	        
            	    otherlv_15=(Token)match(input,By,FOLLOW_By_in_ruleHazard5892); 

            	        	newLeafNode(otherlv_15, grammarAccess.getHazardAccess().getByKeyword_3_4_1());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2650:1: ( ( ruleQualifiedName ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2651:1: ( ruleQualifiedName )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2651:1: ( ruleQualifiedName )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2652:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getHazardReferenceRequirementCrossReference_3_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleHazard5914);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2665:2: (otherlv_17= Comma ( ( ruleQualifiedName ) ) )*
            	    loop44:
            	    do {
            	        int alt44=2;
            	        int LA44_0 = input.LA(1);

            	        if ( (LA44_0==Comma) ) {
            	            alt44=1;
            	        }


            	        switch (alt44) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2666:2: otherlv_17= Comma ( ( ruleQualifiedName ) )
            	    	    {
            	    	    otherlv_17=(Token)match(input,Comma,FOLLOW_Comma_in_ruleHazard5928); 

            	    	        	newLeafNode(otherlv_17, grammarAccess.getHazardAccess().getCommaKeyword_3_4_3_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2670:1: ( ( ruleQualifiedName ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2671:1: ( ruleQualifiedName )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2671:1: ( ruleQualifiedName )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2672:3: ruleQualifiedName
            	    	    {

            	    	    			if (current==null) {
            	    	    	            current = createModelElement(grammarAccess.getHazardRule());
            	    	    	        }
            	    	            
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getHazardReferenceRequirementCrossReference_3_4_3_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleHazard5950);
            	    	    ruleQualifiedName();

            	    	    state._fsp--;

            	    	     
            	    	    	        afterParserOrEnumRuleCall();
            	    	    	    

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

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2692:4: ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2692:4: ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2693:5: {...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2693:103: ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2694:6: ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 5);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2697:6: ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2697:7: {...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2697:16: (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2698:2: otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) )
            	    {
            	    otherlv_19=(Token)match(input,Rationale,FOLLOW_Rationale_in_ruleHazard6021); 

            	        	newLeafNode(otherlv_19, grammarAccess.getHazardAccess().getRationaleKeyword_3_5_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2702:1: ( (lv_rationale_20_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2703:1: (lv_rationale_20_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2703:1: (lv_rationale_20_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2704:3: lv_rationale_20_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getRationaleMultiLineStringParserRuleCall_3_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleHazard6041);
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2727:4: ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2727:4: ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2728:5: {...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "getUnorderedGroupHelper().canSelect(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6)");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2728:103: ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2729:6: ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getHazardAccess().getUnorderedGroup_3(), 6);
            	    	 				
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2732:6: ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2732:7: {...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleHazard", "true");
            	    }
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2732:16: (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2733:2: otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )*
            	    {
            	    otherlv_21=(Token)match(input,Issues,FOLLOW_Issues_in_ruleHazard6110); 

            	        	newLeafNode(otherlv_21, grammarAccess.getHazardAccess().getIssuesKeyword_3_6_0());
            	        
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2737:1: ( (lv_issue_22_0= ruleMultiLineString ) )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2738:1: (lv_issue_22_0= ruleMultiLineString )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2738:1: (lv_issue_22_0= ruleMultiLineString )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2739:3: lv_issue_22_0= ruleMultiLineString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueMultiLineStringParserRuleCall_3_6_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleHazard6130);
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

            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2755:2: (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )*
            	    loop45:
            	    do {
            	        int alt45=2;
            	        int LA45_0 = input.LA(1);

            	        if ( (LA45_0==Comma) ) {
            	            alt45=1;
            	        }


            	        switch (alt45) {
            	    	case 1 :
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2756:2: otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) )
            	    	    {
            	    	    otherlv_23=(Token)match(input,Comma,FOLLOW_Comma_in_ruleHazard6144); 

            	    	        	newLeafNode(otherlv_23, grammarAccess.getHazardAccess().getCommaKeyword_3_6_2_0());
            	    	        
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2760:1: ( (lv_issue_24_0= ruleMultiLineString ) )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2761:1: (lv_issue_24_0= ruleMultiLineString )
            	    	    {
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2761:1: (lv_issue_24_0= ruleMultiLineString )
            	    	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2762:3: lv_issue_24_0= ruleMultiLineString
            	    	    {
            	    	     
            	    	    	        newCompositeNode(grammarAccess.getHazardAccess().getIssueMultiLineStringParserRuleCall_3_6_2_1_0()); 
            	    	    	    
            	    	    pushFollow(FOLLOW_ruleMultiLineString_in_ruleHazard6164);
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
            	    	    break loop45;
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
            	    break loop46;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getHazardAccess().getUnorderedGroup_3());
            	

            }

            otherlv_25=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleHazard6220); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2805:1: entryRuleExternalDocument returns [EObject current=null] : iv_ruleExternalDocument= ruleExternalDocument EOF ;
    public final EObject entryRuleExternalDocument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalDocument = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2806:2: (iv_ruleExternalDocument= ruleExternalDocument EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2807:2: iv_ruleExternalDocument= ruleExternalDocument EOF
            {
             newCompositeNode(grammarAccess.getExternalDocumentRule()); 
            pushFollow(FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument6254);
            iv_ruleExternalDocument=ruleExternalDocument();

            state._fsp--;

             current =iv_ruleExternalDocument; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalDocument6264); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2814:1: ruleExternalDocument returns [EObject current=null] : ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) ;
    public final EObject ruleExternalDocument() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_docReference_0_0 = null;

        AntlrDatatypeRuleToken lv_docFragment_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2817:28: ( ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2818:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2818:1: ( ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2818:2: ( (lv_docReference_0_0= ruleDOCPATH ) ) (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2818:2: ( (lv_docReference_0_0= ruleDOCPATH ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2819:1: (lv_docReference_0_0= ruleDOCPATH )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2819:1: (lv_docReference_0_0= ruleDOCPATH )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2820:3: lv_docReference_0_0= ruleDOCPATH
            {
             
            	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocReferenceDOCPATHParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleDOCPATH_in_ruleExternalDocument6310);
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

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2836:2: (otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==NumberSign) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2837:2: otherlv_1= NumberSign ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    {
                    otherlv_1=(Token)match(input,NumberSign,FOLLOW_NumberSign_in_ruleExternalDocument6324); 

                        	newLeafNode(otherlv_1, grammarAccess.getExternalDocumentAccess().getNumberSignKeyword_1_0());
                        
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2841:1: ( (lv_docFragment_2_0= ruleDOCFRAGMENT ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2842:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2842:1: (lv_docFragment_2_0= ruleDOCFRAGMENT )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2843:3: lv_docFragment_2_0= ruleDOCFRAGMENT
                    {
                     
                    	        newCompositeNode(grammarAccess.getExternalDocumentAccess().getDocFragmentDOCFRAGMENTParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument6344);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2867:1: entryRuleDOCPATH returns [String current=null] : iv_ruleDOCPATH= ruleDOCPATH EOF ;
    public final String entryRuleDOCPATH() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCPATH = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2868:1: (iv_ruleDOCPATH= ruleDOCPATH EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2869:2: iv_ruleDOCPATH= ruleDOCPATH EOF
            {
             newCompositeNode(grammarAccess.getDOCPATHRule()); 
            pushFollow(FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH6382);
            iv_ruleDOCPATH=ruleDOCPATH();

            state._fsp--;

             current =iv_ruleDOCPATH.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCPATH6393); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2876:1: ruleDOCPATH returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleDOCPATH() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2880:6: ( ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:1: ( (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:2: (this_ID_0= RULE_ID kw= Solidus )* this_ID_2= RULE_ID kw= FullStop this_ID_4= RULE_ID
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:2: (this_ID_0= RULE_ID kw= Solidus )*
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
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2881:7: this_ID_0= RULE_ID kw= Solidus
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6434); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,Solidus,FOLLOW_Solidus_in_ruleDOCPATH6452); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCPATHAccess().getSolidusKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6469); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getDOCPATHAccess().getIDTerminalRuleCall_1()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCPATH6487); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getDOCPATHAccess().getFullStopKeyword_2()); 
                
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCPATH6502); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2922:1: entryRuleDOCFRAGMENT returns [String current=null] : iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF ;
    public final String entryRuleDOCFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDOCFRAGMENT = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2923:1: (iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2924:2: iv_ruleDOCFRAGMENT= ruleDOCFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getDOCFRAGMENTRule()); 
            pushFollow(FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT6547);
            iv_ruleDOCFRAGMENT=ruleDOCFRAGMENT();

            state._fsp--;

             current =iv_ruleDOCFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDOCFRAGMENT6558); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2931:1: ruleDOCFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleDOCFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2935:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2936:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2936:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2936:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6598); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getDOCFRAGMENTAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2943:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==FullStop) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2944:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleDOCFRAGMENT6617); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getDOCFRAGMENTAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6632); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2966:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2967:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2968:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription6680);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription6690); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2975:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2978:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2979:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2979:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID||LA50_0==RULE_STRING) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2980:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2980:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:2981:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription6735);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3005:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3006:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3007:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6770);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement6780); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3014:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3017:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3018:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3018:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_STRING) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_ID) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3018:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3018:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3019:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3019:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3020:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement6822); 

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
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3037:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3037:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3038:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3038:1: (otherlv_1= RULE_ID )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3039:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement6853); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3058:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3059:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3060:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath6888);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath6898); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3067:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3070:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3071:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3071:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3071:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3071:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3072:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3072:1: (otherlv_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3073:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath6943); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3084:2: (otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3085:2: otherlv_1= FullStop ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleReferencePath6957); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3089:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3090:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3090:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3091:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath6977);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3115:1: entryRulePredicateExpression returns [EObject current=null] : iv_rulePredicateExpression= rulePredicateExpression EOF ;
    public final EObject entryRulePredicateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePredicateExpression = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3116:2: (iv_rulePredicateExpression= rulePredicateExpression EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3117:2: iv_rulePredicateExpression= rulePredicateExpression EOF
            {
             newCompositeNode(grammarAccess.getPredicateExpressionRule()); 
            pushFollow(FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression7013);
            iv_rulePredicateExpression=rulePredicateExpression();

            state._fsp--;

             current =iv_rulePredicateExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePredicateExpression7023); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3124:1: rulePredicateExpression returns [EObject current=null] : (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) ;
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
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3127:28: ( (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3128:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3128:1: (this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3128:2: this_ID_0= RULE_ID ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) ) this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression7059); 
             
                newLeafNode(this_ID_0, grammarAccess.getPredicateExpressionAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3132:1: ( ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3133:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3133:1: ( (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3134:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3134:1: (lv_op_1_1= EqualsSign | lv_op_1_2= ExclamationMarkEqualsSign | lv_op_1_3= LessThanSign | lv_op_1_4= EqualsSignLessThanSign | lv_op_1_5= GreaterThanSign | lv_op_1_6= GreaterThanSignEqualsSign )
            int alt52=6;
            switch ( input.LA(1) ) {
            case EqualsSign:
                {
                alt52=1;
                }
                break;
            case ExclamationMarkEqualsSign:
                {
                alt52=2;
                }
                break;
            case LessThanSign:
                {
                alt52=3;
                }
                break;
            case EqualsSignLessThanSign:
                {
                alt52=4;
                }
                break;
            case GreaterThanSign:
                {
                alt52=5;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt52=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3135:3: lv_op_1_1= EqualsSign
                    {
                    lv_op_1_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_rulePredicateExpression7079); 

                            newLeafNode(lv_op_1_1, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3148:8: lv_op_1_2= ExclamationMarkEqualsSign
                    {
                    lv_op_1_2=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression7107); 

                            newLeafNode(lv_op_1_2, grammarAccess.getPredicateExpressionAccess().getOpExclamationMarkEqualsSignKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3161:8: lv_op_1_3= LessThanSign
                    {
                    lv_op_1_3=(Token)match(input,LessThanSign,FOLLOW_LessThanSign_in_rulePredicateExpression7135); 

                            newLeafNode(lv_op_1_3, grammarAccess.getPredicateExpressionAccess().getOpLessThanSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3174:8: lv_op_1_4= EqualsSignLessThanSign
                    {
                    lv_op_1_4=(Token)match(input,EqualsSignLessThanSign,FOLLOW_EqualsSignLessThanSign_in_rulePredicateExpression7163); 

                            newLeafNode(lv_op_1_4, grammarAccess.getPredicateExpressionAccess().getOpEqualsSignLessThanSignKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3187:8: lv_op_1_5= GreaterThanSign
                    {
                    lv_op_1_5=(Token)match(input,GreaterThanSign,FOLLOW_GreaterThanSign_in_rulePredicateExpression7191); 

                            newLeafNode(lv_op_1_5, grammarAccess.getPredicateExpressionAccess().getOpGreaterThanSignKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getPredicateExpressionRule());
                    	        }
                           		setWithLastConsumed(current, "op", lv_op_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3200:8: lv_op_1_6= GreaterThanSignEqualsSign
                    {
                    lv_op_1_6=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression7219); 

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

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePredicateExpression7244); 
             
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3228:1: entryRuleFinalValue returns [EObject current=null] : iv_ruleFinalValue= ruleFinalValue EOF ;
    public final EObject entryRuleFinalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFinalValue = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3229:2: (iv_ruleFinalValue= ruleFinalValue EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3230:2: iv_ruleFinalValue= ruleFinalValue EOF
            {
             newCompositeNode(grammarAccess.getFinalValueRule()); 
            pushFollow(FOLLOW_ruleFinalValue_in_entryRuleFinalValue7278);
            iv_ruleFinalValue=ruleFinalValue();

            state._fsp--;

             current =iv_ruleFinalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFinalValue7288); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3237:1: ruleFinalValue returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) ;
    public final EObject ruleFinalValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3240:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3241:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3241:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3241:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= EqualsSign ( (lv_value_2_0= ruleValueString ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3241:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3242:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3242:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3243:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFinalValue7330); 

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

            otherlv_1=(Token)match(input,EqualsSign,FOLLOW_EqualsSign_in_ruleFinalValue7348); 

                	newLeafNode(otherlv_1, grammarAccess.getFinalValueAccess().getEqualsSignKeyword_1());
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3264:1: ( (lv_value_2_0= ruleValueString ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3265:1: (lv_value_2_0= ruleValueString )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3265:1: (lv_value_2_0= ruleValueString )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3266:3: lv_value_2_0= ruleValueString
            {
             
            	        newCompositeNode(grammarAccess.getFinalValueAccess().getValueValueStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueString_in_ruleFinalValue7368);
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3292:1: entryRuleMultiLineString returns [String current=null] : iv_ruleMultiLineString= ruleMultiLineString EOF ;
    public final String entryRuleMultiLineString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMultiLineString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3293:1: (iv_ruleMultiLineString= ruleMultiLineString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3294:2: iv_ruleMultiLineString= ruleMultiLineString EOF
            {
             newCompositeNode(grammarAccess.getMultiLineStringRule()); 
            pushFollow(FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString7406);
            iv_ruleMultiLineString=ruleMultiLineString();

            state._fsp--;

             current =iv_ruleMultiLineString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiLineString7417); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3301:1: ruleMultiLineString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe ) ;
    public final AntlrDatatypeRuleToken ruleMultiLineString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_STRING_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3305:6: ( (kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3306:1: (kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3306:1: (kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3307:2: kw= ApostropheApostropheApostrophe (this_STRING_1= RULE_STRING )* kw= ApostropheApostropheApostrophe
            {
            kw=(Token)match(input,ApostropheApostropheApostrophe,FOLLOW_ApostropheApostropheApostrophe_in_ruleMultiLineString7455); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getMultiLineStringAccess().getApostropheApostropheApostropheKeyword_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3312:1: (this_STRING_1= RULE_STRING )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==RULE_STRING) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3312:6: this_STRING_1= RULE_STRING
            	    {
            	    this_STRING_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleMultiLineString7471); 

            	    		current.merge(this_STRING_1);
            	        
            	     
            	        newLeafNode(this_STRING_1, grammarAccess.getMultiLineStringAccess().getSTRINGTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            kw=(Token)match(input,ApostropheApostropheApostrophe,FOLLOW_ApostropheApostropheApostrophe_in_ruleMultiLineString7491); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3333:1: entryRuleValueString returns [String current=null] : iv_ruleValueString= ruleValueString EOF ;
    public final String entryRuleValueString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValueString = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3334:1: (iv_ruleValueString= ruleValueString EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3335:2: iv_ruleValueString= ruleValueString EOF
            {
             newCompositeNode(grammarAccess.getValueStringRule()); 
            pushFollow(FOLLOW_ruleValueString_in_entryRuleValueString7531);
            iv_ruleValueString=ruleValueString();

            state._fsp--;

             current =iv_ruleValueString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueString7542); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3342:1: ruleValueString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleValueString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3346:6: (this_STRING_0= RULE_STRING )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3347:5: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleValueString7581); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3362:1: entryRuleAadlClassifierReference returns [String current=null] : iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF ;
    public final String entryRuleAadlClassifierReference() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAadlClassifierReference = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3363:1: (iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3364:2: iv_ruleAadlClassifierReference= ruleAadlClassifierReference EOF
            {
             newCompositeNode(grammarAccess.getAadlClassifierReferenceRule()); 
            pushFollow(FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference7625);
            iv_ruleAadlClassifierReference=ruleAadlClassifierReference();

            state._fsp--;

             current =iv_ruleAadlClassifierReference.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAadlClassifierReference7636); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3371:1: ruleAadlClassifierReference returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAadlClassifierReference() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3375:6: ( ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3376:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3376:1: ( (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )? )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3376:2: (this_ID_0= RULE_ID kw= ColonColon )* this_ID_2= RULE_ID (kw= FullStop this_ID_4= RULE_ID )?
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3376:2: (this_ID_0= RULE_ID kw= ColonColon )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID) ) {
                    int LA54_1 = input.LA(2);

                    if ( (LA54_1==ColonColon) ) {
                        alt54=1;
                    }


                }


                switch (alt54) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3376:7: this_ID_0= RULE_ID kw= ColonColon
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7677); 

            	    		current.merge(this_ID_0);
            	        
            	     
            	        newLeafNode(this_ID_0, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_0_0()); 
            	        
            	    kw=(Token)match(input,ColonColon,FOLLOW_ColonColon_in_ruleAadlClassifierReference7695); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getColonColonKeyword_0_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7712); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getAadlClassifierReferenceAccess().getIDTerminalRuleCall_1()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3396:1: (kw= FullStop this_ID_4= RULE_ID )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==FullStop) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3397:2: kw= FullStop this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleAadlClassifierReference7731); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getAadlClassifierReferenceAccess().getFullStopKeyword_2_0()); 
                        
                    this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAadlClassifierReference7746); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3417:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3418:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3419:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef7793);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef7804); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3426:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3430:6: (this_ID_0= RULE_ID )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3431:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef7843); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3446:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3447:1: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3448:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7887);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName7898); 

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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3455:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3459:6: ( (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3460:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3460:1: (this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )* )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3460:6: this_ID_0= RULE_ID (kw= FullStop this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7938); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3467:1: (kw= FullStop this_ID_2= RULE_ID )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==FullStop) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3468:2: kw= FullStop this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleQualifiedName7957); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName7972); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop56;
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
    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3490:1: ruleIssueType returns [Enumerator current=null] : ( (enumLiteral_0= Error ) | (enumLiteral_1= Warning ) | (enumLiteral_2= Info ) ) ;
    public final Enumerator ruleIssueType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3492:28: ( ( (enumLiteral_0= Error ) | (enumLiteral_1= Warning ) | (enumLiteral_2= Info ) ) )
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3493:1: ( (enumLiteral_0= Error ) | (enumLiteral_1= Warning ) | (enumLiteral_2= Info ) )
            {
            // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3493:1: ( (enumLiteral_0= Error ) | (enumLiteral_1= Warning ) | (enumLiteral_2= Info ) )
            int alt57=3;
            switch ( input.LA(1) ) {
            case Error:
                {
                alt57=1;
                }
                break;
            case Warning:
                {
                alt57=2;
                }
                break;
            case Info:
                {
                alt57=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3493:2: (enumLiteral_0= Error )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3493:2: (enumLiteral_0= Error )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3493:7: enumLiteral_0= Error
                    {
                    enumLiteral_0=(Token)match(input,Error,FOLLOW_Error_in_ruleIssueType8038); 

                            current = grammarAccess.getIssueTypeAccess().getERROREnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getIssueTypeAccess().getERROREnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3499:6: (enumLiteral_1= Warning )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3499:6: (enumLiteral_1= Warning )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3499:11: enumLiteral_1= Warning
                    {
                    enumLiteral_1=(Token)match(input,Warning,FOLLOW_Warning_in_ruleIssueType8060); 

                            current = grammarAccess.getIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getIssueTypeAccess().getWARNINGEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3505:6: (enumLiteral_2= Info )
                    {
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3505:6: (enumLiteral_2= Info )
                    // ../org.osate.reqspec/src-gen/org/osate/reqspec/parser/antlr/internal/InternalReqSpecParser.g:3505:11: enumLiteral_2= Info
                    {
                    enumLiteral_2=(Token)match(input,Info,FOLLOW_Info_in_ruleIssueType8082); 

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


    protected DFA27 dfa27 = new DFA27(this);
    protected DFA42 dfa42 = new DFA42(this);
    static final String DFA27_eotS =
        "\21\uffff";
    static final String DFA27_eofS =
        "\21\uffff";
    static final String DFA27_minS =
        "\1\5\14\uffff\1\6\3\uffff";
    static final String DFA27_maxS =
        "\1\65\14\uffff\1\34\3\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\17\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1"+
        "\uffff\1\15\1\16\1\14";
    static final String DFA27_specialS =
        "\1\1\14\uffff\1\0\3\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\3\1\uffff\1\14\1\11\1\uffff\1\13\1\uffff\1\5\1\2\1\uffff"+
            "\1\12\2\uffff\1\7\1\uffff\1\4\3\uffff\1\6\3\uffff\1\10\4\uffff"+
            "\1\15\23\uffff\1\1",
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
            "\1\16\7\uffff\1\17\15\uffff\1\20",
            "",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "()* loopback of 945:3: ( ({...}? => ( ({...}? => (otherlv_10= Category ( ( ruleCatRef ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_12= Description ( (lv_description_13_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_14= Assert ( (lv_assert_15_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_16= Rationale ( (lv_rationale_17_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_18= Issues ( (lv_issue_19_0= ruleMultiLineString ) ) (otherlv_20= Comma ( (lv_issue_21_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_22= Refined otherlv_23= To ( ( ruleQualifiedName ) ) (otherlv_25= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subgoal_27_0= ruleGoal ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_28= Decomposed otherlv_29= To ( ( ruleQualifiedName ) ) (otherlv_31= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_33= Evolved otherlv_34= To ( ( ruleQualifiedName ) ) (otherlv_36= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_38= Conflicts otherlv_39= With ( ( ruleQualifiedName ) ) (otherlv_41= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_43= Stakeholder ( ( ruleQualifiedName ) ) (otherlv_45= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_47= See otherlv_48= Goal ( ( ruleQualifiedName ) ) (otherlv_50= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_52= See otherlv_53= Requirement ( ( ruleQualifiedName ) ) (otherlv_55= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_57= See otherlv_58= Document ( (lv_docReference_59_0= ruleExternalDocument ) ) (otherlv_60= Comma ( (lv_docReference_61_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_13 = input.LA(1);

                         
                        int index27_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA27_13 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) {s = 14;}

                        else if ( LA27_13 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) ) {s = 15;}

                        else if ( LA27_13 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) ) {s = 16;}

                         
                        input.seek(index27_13);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_0 = input.LA(1);

                         
                        int index27_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA27_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA27_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 0) ) {s = 2;}

                        else if ( LA27_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 1) ) {s = 3;}

                        else if ( LA27_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 2) ) {s = 4;}

                        else if ( LA27_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 3) ) {s = 5;}

                        else if ( LA27_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 4) ) {s = 6;}

                        else if ( LA27_0 ==Refined && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 5) ) {s = 7;}

                        else if ( LA27_0 ==Goal && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 6) ) {s = 8;}

                        else if ( LA27_0 ==Decomposed && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 7) ) {s = 9;}

                        else if ( LA27_0 ==Evolved && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 8) ) {s = 10;}

                        else if ( LA27_0 ==Conflicts && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 9) ) {s = 11;}

                        else if ( LA27_0 ==Stakeholder && getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 10) ) {s = 12;}

                        else if ( LA27_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 11) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 13) || getUnorderedGroupHelper().canSelect(grammarAccess.getGoalAccess().getUnorderedGroup_5(), 12) ) ) {s = 13;}

                         
                        input.seek(index27_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\22\uffff";
    static final String DFA42_eofS =
        "\22\uffff";
    static final String DFA42_minS =
        "\1\5\6\uffff\1\6\5\uffff\1\66\1\uffff\1\0\2\uffff";
    static final String DFA42_maxS =
        "\1\65\6\uffff\1\34\5\uffff\1\66\1\uffff\1\0\2\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\16\1\1\1\2\1\3\1\4\1\5\1\uffff\1\7\1\10\1\11\1\12\1"+
        "\14\1\uffff\1\15\1\uffff\1\6\1\13";
    static final String DFA42_specialS =
        "\1\3\6\uffff\1\2\5\uffff\1\1\1\uffff\1\0\2\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\2\1\11\1\uffff\1\12\1\3\2\uffff\1\5\3\uffff\1\13\1\uffff"+
            "\1\10\1\uffff\1\4\3\uffff\1\6\10\uffff\1\7\23\uffff\1\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\7\uffff\1\16\15\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            "\1\17",
            "",
            "\1\uffff",
            "",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()* loopback of 1783:3: ( ({...}? => ( ({...}? => (otherlv_13= Description ( (lv_description_14_0= ruleDescription ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_15= Parameters ( (lv_parameters_16_0= ruleFinalValue ) )+ ) ) ) ) | ({...}? => ( ({...}? => (otherlv_17= Assert ( (lv_assert_18_0= rulePredicateExpression ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_19= Rationale ( (lv_rationale_20_0= ruleMultiLineString ) ) ) ) ) ) | ({...}? => ( ({...}? => (otherlv_21= Issues ( (lv_issue_22_0= ruleMultiLineString ) ) (otherlv_23= Comma ( (lv_issue_24_0= ruleMultiLineString ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_25= See otherlv_26= Goal ( ( ruleQualifiedName ) ) (otherlv_28= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_30= Refined otherlv_31= To ( ( ruleQualifiedName ) ) (otherlv_33= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => ( (lv_subrequirement_35_0= ruleRequirement ) ) )+ ) ) | ({...}? => ( ({...}? => (otherlv_36= Decomposed otherlv_37= To ( ( ruleQualifiedName ) ) (otherlv_39= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_41= Evolves ( ( ruleQualifiedName ) ) (otherlv_43= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_45= See otherlv_46= Goal ( ( ruleQualifiedName ) ) (otherlv_48= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_50= See otherlv_51= Requirement ( ( ruleQualifiedName ) ) (otherlv_53= Comma ( ( ruleQualifiedName ) ) )* ) ) ) ) | ({...}? => ( ({...}? => (otherlv_55= See otherlv_56= Document ( (lv_docReference_57_0= ruleExternalDocument ) ) (otherlv_58= Comma ( (lv_docReference_59_0= ruleExternalDocument ) ) )* ) ) ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA42_15 = input.LA(1);

                         
                        int index42_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) {s = 16;}

                        else if ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) ) {s = 17;}

                         
                        input.seek(index42_15);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA42_13 = input.LA(1);

                         
                        int index42_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA42_13 ==RULE_ID && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) ) {s = 15;}

                         
                        input.seek(index42_13);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA42_7 = input.LA(1);

                         
                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( LA42_7 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) ) {s = 12;}

                        else if ( LA42_7 ==Goal && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) ) ) {s = 13;}

                        else if ( LA42_7 ==Document && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) {s = 14;}

                         
                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA42_0 = input.LA(1);

                         
                        int index42_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA42_0==RightSquareBracket) ) {s = 1;}

                        else if ( LA42_0 ==Description && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 0) ) {s = 2;}

                        else if ( LA42_0 ==Parameters && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 1) ) {s = 3;}

                        else if ( LA42_0 ==Assert && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 2) ) {s = 4;}

                        else if ( LA42_0 ==Rationale && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 3) ) {s = 5;}

                        else if ( LA42_0 ==Issues && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 4) ) {s = 6;}

                        else if ( LA42_0 ==See && ( getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 10) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 5) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 11) || getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 12) ) ) {s = 7;}

                        else if ( LA42_0 ==Refined && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 6) ) {s = 8;}

                        else if ( LA42_0 ==Requirement && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 7) ) {s = 9;}

                        else if ( LA42_0 ==Decomposed && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 8) ) {s = 10;}

                        else if ( LA42_0 ==Evolves && getUnorderedGroupHelper().canSelect(grammarAccess.getRequirementAccess().getUnorderedGroup_6(), 9) ) {s = 11;}

                         
                        input.seek(index42_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
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
    public static final BitSet FOLLOW_Specification_in_ruleSystemSpec272 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSystemSpec288 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_For_in_ruleSystemSpec306 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleSystemSpec328 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleSystemSpec341 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSystemSpec363 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleSystemSpec376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStakeholderGoals_in_entryRuleStakeholderGoals410 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStakeholderGoals420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goals_in_ruleStakeholderGoals458 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStakeholderGoals474 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleStakeholderGoals492 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleStakeholderGoals514 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleStakeholderGoals527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqDocument_in_entryRuleReqDocument561 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqDocument571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Document_in_ruleReqDocument609 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqDocument625 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqDocument643 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleReqDocument665 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqDocument678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecLibrary_in_entryRuleReqSpecLibrary712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecLibrary722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Library_in_ruleReqSpecLibrary760 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecLibrary776 = new BitSet(new long[]{0x0010000100800000L});
    public static final BitSet FOLLOW_Import_in_ruleReqSpecLibrary795 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleReqSpecLibrary815 = new BitSet(new long[]{0x0010000100000000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecLibrary831 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecLibrary853 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary868 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecLibrary890 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecLibrary909 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_ruleHazard_in_ruleReqSpecLibrary928 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecLibrary947 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecLibrary965 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecLibrary977 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqSpecLibrary997 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecLibrary1011 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqSpecLibrary1031 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1046 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecLibrary1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard1095 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard1106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard1153 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_FullStopAsterisk_in_ruleQualifiedNameWithWildCard1172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_entryRuleReqSpecFolder1213 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReqSpecFolder1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Folder_in_ruleReqSpecFolder1261 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReqSpecFolder1277 = new BitSet(new long[]{0x0010000100000000L});
    public static final BitSet FOLLOW_For_in_ruleReqSpecFolder1296 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleReqSpecFolder1318 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1333 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleReqSpecFolder1355 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleReqSpecFolder1374 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_ruleHazard_in_ruleReqSpecFolder1393 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_ruleReqSpecFolder_in_ruleReqSpecFolder1412 = new BitSet(new long[]{0x0020000011600040L});
    public static final BitSet FOLLOW_Issues_in_ruleReqSpecFolder1430 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleReqSpecFolder1442 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqSpecFolder1462 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_Comma_in_ruleReqSpecFolder1476 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleReqSpecFolder1496 = new BitSet(new long[]{0x0020200000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1511 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleReqSpecFolder1525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal1559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal1607 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1623 = new BitSet(new long[]{0x0011000100000000L});
    public static final BitSet FOLLOW_Colon_in_ruleGoal1642 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleGoal1662 = new BitSet(new long[]{0x0010000100000000L});
    public static final BitSet FOLLOW_For_in_ruleGoal1678 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal1697 = new BitSet(new long[]{0x0010010000000000L});
    public static final BitSet FOLLOW_Of_in_ruleGoal1711 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleGoal1733 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleGoal1750 = new BitSet(new long[]{0x002000021114B5A0L});
    public static final BitSet FOLLOW_Category_in_ruleGoal1808 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleGoal1830 = new BitSet(new long[]{0x002000021114B5A0L});
    public static final BitSet FOLLOW_Description_in_ruleGoal1899 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleGoal1919 = new BitSet(new long[]{0x002000021114B5A0L});
    public static final BitSet FOLLOW_Assert_in_ruleGoal1988 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleGoal2008 = new BitSet(new long[]{0x002000021114B5A0L});
    public static final BitSet FOLLOW_Rationale_in_ruleGoal2077 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleGoal2097 = new BitSet(new long[]{0x002000021114B5A0L});
    public static final BitSet FOLLOW_Issues_in_ruleGoal2166 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleGoal2186 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2200 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleGoal2220 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Refined_in_ruleGoal2291 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2303 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2325 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2339 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2361 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_ruleGoal_in_ruleGoal2439 = new BitSet(new long[]{0x002000021114B5A0L});
    public static final BitSet FOLLOW_Decomposed_in_ruleGoal2508 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2520 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2542 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2556 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2578 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Evolved_in_ruleGoal2649 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_To_in_ruleGoal2661 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2683 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2697 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2719 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Conflicts_in_ruleGoal2790 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_With_in_ruleGoal2802 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2824 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2838 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2860 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Stakeholder_in_ruleGoal2931 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2953 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal2967 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal2989 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal3060 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Goal_in_ruleGoal3072 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3094 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3108 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3130 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal3201 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleGoal3213 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3235 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3249 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleGoal3271 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_See_in_ruleGoal3342 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_Document_in_ruleGoal3354 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3374 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_Comma_in_ruleGoal3388 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleGoal3408 = new BitSet(new long[]{0x002020021114B5A0L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleGoal3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirement_in_entryRuleRequirement3498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirement3508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement3546 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3562 = new BitSet(new long[]{0x0011080100000000L});
    public static final BitSet FOLLOW_Colon_in_ruleRequirement3581 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleRequirement3601 = new BitSet(new long[]{0x0010080100000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_ruleRequirement3617 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirement3639 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_ruleRequirement3652 = new BitSet(new long[]{0x0010000100000000L});
    public static final BitSet FOLLOW_For_in_ruleRequirement3667 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirement3686 = new BitSet(new long[]{0x0010010000000000L});
    public static final BitSet FOLLOW_Of_in_ruleRequirement3700 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleRequirement3722 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirement3739 = new BitSet(new long[]{0x0020000201151360L});
    public static final BitSet FOLLOW_Description_in_ruleRequirement3797 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleRequirement3817 = new BitSet(new long[]{0x0020000201151360L});
    public static final BitSet FOLLOW_Parameters_in_ruleRequirement3886 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleFinalValue_in_ruleRequirement3906 = new BitSet(new long[]{0x0060000201151360L});
    public static final BitSet FOLLOW_Assert_in_ruleRequirement3976 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_ruleRequirement3996 = new BitSet(new long[]{0x0020000201151360L});
    public static final BitSet FOLLOW_Rationale_in_ruleRequirement4065 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleRequirement4085 = new BitSet(new long[]{0x0020000201151360L});
    public static final BitSet FOLLOW_Issues_in_ruleRequirement4154 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleRequirement4174 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4188 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleRequirement4208 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4279 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4291 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4313 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4327 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4349 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Refined_in_ruleRequirement4420 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_To_in_ruleRequirement4432 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4454 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4468 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4490 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_ruleRequirement_in_ruleRequirement4568 = new BitSet(new long[]{0x0020000201151360L});
    public static final BitSet FOLLOW_Decomposed_in_ruleRequirement4637 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_To_in_ruleRequirement4649 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4671 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4685 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4707 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Evolves_in_ruleRequirement4778 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4800 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4814 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4836 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_See_in_ruleRequirement4907 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Goal_in_ruleRequirement4919 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4941 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement4955 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement4977 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_See_in_ruleRequirement5048 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirement5060 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement5082 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement5096 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRequirement5118 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_See_in_ruleRequirement5189 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_Document_in_ruleRequirement5201 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement5221 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_Comma_in_ruleRequirement5235 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_ruleRequirement5255 = new BitSet(new long[]{0x0020200201151360L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirement5311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazard_in_entryRuleHazard5345 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazard5355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Hazard_in_ruleHazard5393 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard5409 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleHazard5427 = new BitSet(new long[]{0x0020000109003820L});
    public static final BitSet FOLLOW_For_in_ruleHazard5485 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazard5504 = new BitSet(new long[]{0x0020010109003820L});
    public static final BitSet FOLLOW_Of_in_ruleHazard5518 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_ruleHazard5540 = new BitSet(new long[]{0x0020000109003820L});
    public static final BitSet FOLLOW_Category_in_ruleHazard5611 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleHazard5633 = new BitSet(new long[]{0x0020000109003820L});
    public static final BitSet FOLLOW_Title_in_ruleHazard5702 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleHazard5722 = new BitSet(new long[]{0x0020000109003820L});
    public static final BitSet FOLLOW_Description_in_ruleHazard5791 = new BitSet(new long[]{0x0140000000000000L});
    public static final BitSet FOLLOW_ruleDescription_in_ruleHazard5811 = new BitSet(new long[]{0x0020000109003820L});
    public static final BitSet FOLLOW_Mitigated_in_ruleHazard5880 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_By_in_ruleHazard5892 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleHazard5914 = new BitSet(new long[]{0x0020200109003820L});
    public static final BitSet FOLLOW_Comma_in_ruleHazard5928 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleHazard5950 = new BitSet(new long[]{0x0020200109003820L});
    public static final BitSet FOLLOW_Rationale_in_ruleHazard6021 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleHazard6041 = new BitSet(new long[]{0x0020000109003820L});
    public static final BitSet FOLLOW_Issues_in_ruleHazard6110 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleHazard6130 = new BitSet(new long[]{0x0020200109003820L});
    public static final BitSet FOLLOW_Comma_in_ruleHazard6144 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_ruleHazard6164 = new BitSet(new long[]{0x0020200109003820L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleHazard6220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalDocument_in_entryRuleExternalDocument6254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalDocument6264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_ruleExternalDocument6310 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_NumberSign_in_ruleExternalDocument6324 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_ruleExternalDocument6344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCPATH_in_entryRuleDOCPATH6382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCPATH6393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6434 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_Solidus_in_ruleDOCPATH6452 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6469 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCPATH6487 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCPATH6502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDOCFRAGMENT_in_entryRuleDOCFRAGMENT6547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDOCFRAGMENT6558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6598 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleDOCFRAGMENT6617 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDOCFRAGMENT6632 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription6680 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription6690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription6735 = new BitSet(new long[]{0x0140000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement6770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement6780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement6822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement6853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath6888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath6898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath6943 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_FullStop_in_ruleReferencePath6957 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath6977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePredicateExpression_in_entryRulePredicateExpression7013 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePredicateExpression7023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression7059 = new BitSet(new long[]{0x000E006400000000L});
    public static final BitSet FOLLOW_EqualsSign_in_rulePredicateExpression7079 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_ExclamationMarkEqualsSign_in_rulePredicateExpression7107 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_LessThanSign_in_rulePredicateExpression7135 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_EqualsSignLessThanSign_in_rulePredicateExpression7163 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_GreaterThanSign_in_rulePredicateExpression7191 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_GreaterThanSignEqualsSign_in_rulePredicateExpression7219 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePredicateExpression7244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFinalValue_in_entryRuleFinalValue7278 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFinalValue7288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFinalValue7330 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_EqualsSign_in_ruleFinalValue7348 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleValueString_in_ruleFinalValue7368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiLineString_in_entryRuleMultiLineString7406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiLineString7417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ApostropheApostropheApostrophe_in_ruleMultiLineString7455 = new BitSet(new long[]{0x0100000080000000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleMultiLineString7471 = new BitSet(new long[]{0x0100000080000000L});
    public static final BitSet FOLLOW_ApostropheApostropheApostrophe_in_ruleMultiLineString7491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueString_in_entryRuleValueString7531 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueString7542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleValueString7581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAadlClassifierReference_in_entryRuleAadlClassifierReference7625 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAadlClassifierReference7636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7677 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ColonColon_in_ruleAadlClassifierReference7695 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7712 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleAadlClassifierReference7731 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAadlClassifierReference7746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef7793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef7804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef7843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7887 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7938 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_FullStop_in_ruleQualifiedName7957 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName7972 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_Error_in_ruleIssueType8038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Warning_in_ruleIssueType8060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Info_in_ruleIssueType8082 = new BitSet(new long[]{0x0000000000000002L});

}
