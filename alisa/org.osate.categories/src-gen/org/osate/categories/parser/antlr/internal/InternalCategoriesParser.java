package org.osate.categories.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.categories.services.CategoriesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCategoriesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Verification", "Requirement", "Categories", "Selection", "LeftSquareBracket", "RightSquareBracket", "LeftCurlyBracket", "RightCurlyBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=12;
    public static final int Categories=6;
    public static final int RULE_WS=17;
    public static final int Selection=7;
    public static final int LeftCurlyBracket=10;
    public static final int Verification=4;
    public static final int RULE_STRING=14;
    public static final int RULE_ANY_OTHER=18;
    public static final int RULE_SL_COMMENT=16;
    public static final int Requirement=5;
    public static final int RULE_INT=13;
    public static final int RULE_ML_COMMENT=15;
    public static final int LeftSquareBracket=8;
    public static final int RightCurlyBracket=11;
    public static final int EOF=-1;
    public static final int RightSquareBracket=9;

    // delegates
    // delegators


        public InternalCategoriesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCategoriesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCategoriesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g"; }




    	private CategoriesGrammarAccess grammarAccess;
    	 	
    	public InternalCategoriesParser(TokenStream input, CategoriesGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Categories";	
    	} 
    	   	   	
    	@Override
    	protected CategoriesGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:61:1: entryRuleCategories returns [EObject current=null] : iv_ruleCategories= ruleCategories EOF ;
    public final EObject entryRuleCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:62:2: (iv_ruleCategories= ruleCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:63:2: iv_ruleCategories= ruleCategories EOF
            {
             newCompositeNode(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_ruleCategories_in_entryRuleCategories67);
            iv_ruleCategories=ruleCategories();

            state._fsp--;

             current =iv_ruleCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategories77); 

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
    // $ANTLR end "entryRuleCategories"


    // $ANTLR start "ruleCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:70:1: ruleCategories returns [EObject current=null] : (this_RequirementCategories_0= ruleRequirementCategories | this_VerificationCategories_1= ruleVerificationCategories | this_SelectionCategories_2= ruleSelectionCategories ) ;
    public final EObject ruleCategories() throws RecognitionException {
        EObject current = null;

        EObject this_RequirementCategories_0 = null;

        EObject this_VerificationCategories_1 = null;

        EObject this_SelectionCategories_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:73:28: ( (this_RequirementCategories_0= ruleRequirementCategories | this_VerificationCategories_1= ruleVerificationCategories | this_SelectionCategories_2= ruleSelectionCategories ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:74:1: (this_RequirementCategories_0= ruleRequirementCategories | this_VerificationCategories_1= ruleVerificationCategories | this_SelectionCategories_2= ruleSelectionCategories )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:74:1: (this_RequirementCategories_0= ruleRequirementCategories | this_VerificationCategories_1= ruleVerificationCategories | this_SelectionCategories_2= ruleSelectionCategories )
            int alt1=3;
            switch ( input.LA(1) ) {
            case Requirement:
                {
                alt1=1;
                }
                break;
            case Verification:
                {
                alt1=2;
                }
                break;
            case Selection:
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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:75:5: this_RequirementCategories_0= ruleRequirementCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRequirementCategories_in_ruleCategories124);
                    this_RequirementCategories_0=ruleRequirementCategories();

                    state._fsp--;


                            current = this_RequirementCategories_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:85:5: this_VerificationCategories_1= ruleVerificationCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVerificationCategories_in_ruleCategories151);
                    this_VerificationCategories_1=ruleVerificationCategories();

                    state._fsp--;


                            current = this_VerificationCategories_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:95:5: this_SelectionCategories_2= ruleSelectionCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getSelectionCategoriesParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSelectionCategories_in_ruleCategories178);
                    this_SelectionCategories_2=ruleSelectionCategories();

                    state._fsp--;


                            current = this_SelectionCategories_2;
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
    // $ANTLR end "ruleCategories"


    // $ANTLR start "entryRuleRequirementCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:111:1: entryRuleRequirementCategories returns [EObject current=null] : iv_ruleRequirementCategories= ruleRequirementCategories EOF ;
    public final EObject entryRuleRequirementCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:112:2: (iv_ruleRequirementCategories= ruleRequirementCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:113:2: iv_ruleRequirementCategories= ruleRequirementCategories EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories212);
            iv_ruleRequirementCategories=ruleRequirementCategories();

            state._fsp--;

             current =iv_ruleRequirementCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategories222); 

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
    // $ANTLR end "entryRuleRequirementCategories"


    // $ANTLR start "ruleRequirementCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:120:1: ruleRequirementCategories returns [EObject current=null] : (otherlv_0= Requirement otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= RightSquareBracket ) ;
    public final EObject ruleRequirementCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:123:28: ( (otherlv_0= Requirement otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:124:1: (otherlv_0= Requirement otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:124:1: (otherlv_0= Requirement otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:2: otherlv_0= Requirement otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Requirement,FOLLOW_Requirement_in_ruleRequirementCategories260); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0());
                
            otherlv_1=(Token)match(input,Categories,FOLLOW_Categories_in_ruleRequirementCategories272); 

                	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleRequirementCategories284); 

                	newLeafNode(otherlv_2, grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:139:1: ( (lv_category_3_0= ruleRequirementCategory ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:140:1: (lv_category_3_0= ruleRequirementCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:140:1: (lv_category_3_0= ruleRequirementCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:141:3: lv_category_3_0= ruleRequirementCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories304);
            	    lv_category_3_0=ruleRequirementCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"RequirementCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleRequirementCategories318); 

                	newLeafNode(otherlv_4, grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleRequirementCategories"


    // $ANTLR start "entryRuleVerificationCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:170:1: entryRuleVerificationCategories returns [EObject current=null] : iv_ruleVerificationCategories= ruleVerificationCategories EOF ;
    public final EObject entryRuleVerificationCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:171:2: (iv_ruleVerificationCategories= ruleVerificationCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:172:2: iv_ruleVerificationCategories= ruleVerificationCategories EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoriesRule()); 
            pushFollow(FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories352);
            iv_ruleVerificationCategories=ruleVerificationCategories();

            state._fsp--;

             current =iv_ruleVerificationCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategories362); 

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
    // $ANTLR end "entryRuleVerificationCategories"


    // $ANTLR start "ruleVerificationCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:179:1: ruleVerificationCategories returns [EObject current=null] : (otherlv_0= Verification otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= RightSquareBracket ) ;
    public final EObject ruleVerificationCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:182:28: ( (otherlv_0= Verification otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:183:1: (otherlv_0= Verification otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:183:1: (otherlv_0= Verification otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:184:2: otherlv_0= Verification otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Verification,FOLLOW_Verification_in_ruleVerificationCategories400); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0());
                
            otherlv_1=(Token)match(input,Categories,FOLLOW_Categories_in_ruleVerificationCategories412); 

                	newLeafNode(otherlv_1, grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleVerificationCategories424); 

                	newLeafNode(otherlv_2, grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:198:1: ( (lv_category_3_0= ruleVerificationCategory ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:199:1: (lv_category_3_0= ruleVerificationCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:199:1: (lv_category_3_0= ruleVerificationCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:200:3: lv_category_3_0= ruleVerificationCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories444);
            	    lv_category_3_0=ruleVerificationCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVerificationCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"VerificationCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleVerificationCategories458); 

                	newLeafNode(otherlv_4, grammarAccess.getVerificationCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleVerificationCategories"


    // $ANTLR start "entryRuleSelectionCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:229:1: entryRuleSelectionCategories returns [EObject current=null] : iv_ruleSelectionCategories= ruleSelectionCategories EOF ;
    public final EObject entryRuleSelectionCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:230:2: (iv_ruleSelectionCategories= ruleSelectionCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:231:2: iv_ruleSelectionCategories= ruleSelectionCategories EOF
            {
             newCompositeNode(grammarAccess.getSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories492);
            iv_ruleSelectionCategories=ruleSelectionCategories();

            state._fsp--;

             current =iv_ruleSelectionCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategories502); 

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
    // $ANTLR end "entryRuleSelectionCategories"


    // $ANTLR start "ruleSelectionCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:238:1: ruleSelectionCategories returns [EObject current=null] : (otherlv_0= Selection otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= RightSquareBracket ) ;
    public final EObject ruleSelectionCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:241:28: ( (otherlv_0= Selection otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:242:1: (otherlv_0= Selection otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:242:1: (otherlv_0= Selection otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:243:2: otherlv_0= Selection otherlv_1= Categories otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= RightSquareBracket
            {
            otherlv_0=(Token)match(input,Selection,FOLLOW_Selection_in_ruleSelectionCategories540); 

                	newLeafNode(otherlv_0, grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_0());
                
            otherlv_1=(Token)match(input,Categories,FOLLOW_Categories_in_ruleSelectionCategories552); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleSelectionCategories564); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:257:1: ( (lv_category_3_0= ruleSelectionCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:258:1: (lv_category_3_0= ruleSelectionCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:258:1: (lv_category_3_0= ruleSelectionCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:259:3: lv_category_3_0= ruleSelectionCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectionCategory_in_ruleSelectionCategories584);
            	    lv_category_3_0=ruleSelectionCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSelectionCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"SelectionCategory");
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

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleSelectionCategories598); 

                	newLeafNode(otherlv_4, grammarAccess.getSelectionCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleSelectionCategories"


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:290:1: entryRuleRequirementCategory returns [EObject current=null] : iv_ruleRequirementCategory= ruleRequirementCategory EOF ;
    public final EObject entryRuleRequirementCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:291:2: (iv_ruleRequirementCategory= ruleRequirementCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:292:2: iv_ruleRequirementCategory= ruleRequirementCategory EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory634);
            iv_ruleRequirementCategory=ruleRequirementCategory();

            state._fsp--;

             current =iv_ruleRequirementCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory644); 

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
    // $ANTLR end "entryRuleRequirementCategory"


    // $ANTLR start "ruleRequirementCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:299:1: ruleRequirementCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? ) ;
    public final EObject ruleRequirementCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:302:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:303:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:303:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:303:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:303:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:304:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:304:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:305:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategory686); 

            			newLeafNode(lv_name_0_0, grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:321:2: (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LeftCurlyBracket) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:322:2: otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket
                    {
                    otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_ruleRequirementCategory705); 

                        	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoryAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:326:1: ( ( ruleCatRef ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:327:1: ( ruleCatRef )
                    	    {
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:327:1: ( ruleCatRef )
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:328:3: ruleCatRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getRequirementCategoryAccess().getSubCategoriesRequirementCategoryCrossReference_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirementCategory727);
                    	    ruleCatRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_ruleRequirementCategory741); 

                        	newLeafNode(otherlv_3, grammarAccess.getRequirementCategoryAccess().getRightCurlyBracketKeyword_1_2());
                        

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
    // $ANTLR end "ruleRequirementCategory"


    // $ANTLR start "entryRuleVerificationCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:354:1: entryRuleVerificationCategory returns [EObject current=null] : iv_ruleVerificationCategory= ruleVerificationCategory EOF ;
    public final EObject entryRuleVerificationCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:355:2: (iv_ruleVerificationCategory= ruleVerificationCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:356:2: iv_ruleVerificationCategory= ruleVerificationCategory EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory777);
            iv_ruleVerificationCategory=ruleVerificationCategory();

            state._fsp--;

             current =iv_ruleVerificationCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory787); 

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
    // $ANTLR end "entryRuleVerificationCategory"


    // $ANTLR start "ruleVerificationCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:363:1: ruleVerificationCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? ) ;
    public final EObject ruleVerificationCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:366:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:367:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:367:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:367:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:367:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:368:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:368:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:369:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationCategory829); 

            			newLeafNode(lv_name_0_0, grammarAccess.getVerificationCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVerificationCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:385:2: (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LeftCurlyBracket) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:386:2: otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket
                    {
                    otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_ruleVerificationCategory848); 

                        	newLeafNode(otherlv_1, grammarAccess.getVerificationCategoryAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:390:1: ( ( ruleCatRef ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:391:1: ( ruleCatRef )
                    	    {
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:391:1: ( ruleCatRef )
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:392:3: ruleCatRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getVerificationCategoryRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getVerificationCategoryAccess().getSubCategoriesVerificationCategoryCrossReference_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCatRef_in_ruleVerificationCategory870);
                    	    ruleCatRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_ruleVerificationCategory884); 

                        	newLeafNode(otherlv_3, grammarAccess.getVerificationCategoryAccess().getRightCurlyBracketKeyword_1_2());
                        

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
    // $ANTLR end "ruleVerificationCategory"


    // $ANTLR start "entryRuleSelectionCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:418:1: entryRuleSelectionCategory returns [EObject current=null] : iv_ruleSelectionCategory= ruleSelectionCategory EOF ;
    public final EObject entryRuleSelectionCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:419:2: (iv_ruleSelectionCategory= ruleSelectionCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:420:2: iv_ruleSelectionCategory= ruleSelectionCategory EOF
            {
             newCompositeNode(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory920);
            iv_ruleSelectionCategory=ruleSelectionCategory();

            state._fsp--;

             current =iv_ruleSelectionCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory930); 

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
    // $ANTLR end "entryRuleSelectionCategory"


    // $ANTLR start "ruleSelectionCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:427:1: ruleSelectionCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? ) ;
    public final EObject ruleSelectionCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:430:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:431:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:431:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:431:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:431:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:432:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:432:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:433:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectionCategory972); 

            			newLeafNode(lv_name_0_0, grammarAccess.getSelectionCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSelectionCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:449:2: (otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LeftCurlyBracket) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:450:2: otherlv_1= LeftCurlyBracket ( ( ruleCatRef ) )* otherlv_3= RightCurlyBracket
                    {
                    otherlv_1=(Token)match(input,LeftCurlyBracket,FOLLOW_LeftCurlyBracket_in_ruleSelectionCategory991); 

                        	newLeafNode(otherlv_1, grammarAccess.getSelectionCategoryAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:454:1: ( ( ruleCatRef ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:455:1: ( ruleCatRef )
                    	    {
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:455:1: ( ruleCatRef )
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:456:3: ruleCatRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSelectionCategoryRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSelectionCategoryAccess().getSubCategoriesSelectionCategoryCrossReference_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCatRef_in_ruleSelectionCategory1013);
                    	    ruleCatRef();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,RightCurlyBracket,FOLLOW_RightCurlyBracket_in_ruleSelectionCategory1027); 

                        	newLeafNode(otherlv_3, grammarAccess.getSelectionCategoryAccess().getRightCurlyBracketKeyword_1_2());
                        

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
    // $ANTLR end "ruleSelectionCategory"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:482:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:483:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:484:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef1064);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef1075); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:491:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:495:6: (this_ID_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:496:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef1114); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategories_in_entryRuleCategories67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategories77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_ruleCategories124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_ruleCategories151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_ruleCategories178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Requirement_in_ruleRequirementCategories260 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Categories_in_ruleRequirementCategories272 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleRequirementCategories284 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories304 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleRequirementCategories318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories352 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategories362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Verification_in_ruleVerificationCategories400 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Categories_in_ruleVerificationCategories412 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleVerificationCategories424 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories444 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleVerificationCategories458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategories502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Selection_in_ruleSelectionCategories540 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Categories_in_ruleSelectionCategories552 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleSelectionCategories564 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_ruleSelectionCategories584 = new BitSet(new long[]{0x0000000000001200L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleSelectionCategories598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory634 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategory686 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_ruleRequirementCategory705 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirementCategory727 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_ruleRequirementCategory741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory777 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationCategory829 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_ruleVerificationCategory848 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleVerificationCategory870 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_ruleVerificationCategory884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectionCategory972 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_LeftCurlyBracket_in_ruleSelectionCategory991 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleSelectionCategory1013 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_RightCurlyBracket_in_ruleSelectionCategory1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef1064 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef1114 = new BitSet(new long[]{0x0000000000000002L});

}