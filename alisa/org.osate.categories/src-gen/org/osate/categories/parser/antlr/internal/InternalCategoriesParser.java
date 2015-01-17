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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'['", "']'", "'hazard'", "'verification'", "'selection'", "'assertfail'", "'executionfail'", "'extends'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

    // delegates
    // delegators


        public InternalCategoriesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCategoriesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCategoriesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g"; }



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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:67:1: entryRuleCategories returns [EObject current=null] : iv_ruleCategories= ruleCategories EOF ;
    public final EObject entryRuleCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:68:2: (iv_ruleCategories= ruleCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:69:2: iv_ruleCategories= ruleCategories EOF
            {
             newCompositeNode(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_ruleCategories_in_entryRuleCategories75);
            iv_ruleCategories=ruleCategories();

            state._fsp--;

             current =iv_ruleCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategories85); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:76:1: ruleCategories returns [EObject current=null] : (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories | this_VerificationCategories_2= ruleVerificationCategories | this_SelectionCategories_3= ruleSelectionCategories | this_AssertFailCategories_4= ruleAssertFailCategories | this_ExecutionFailCategories_5= ruleExecutionFailCategories ) ;
    public final EObject ruleCategories() throws RecognitionException {
        EObject current = null;

        EObject this_RequirementCategories_0 = null;

        EObject this_HazardCategories_1 = null;

        EObject this_VerificationCategories_2 = null;

        EObject this_SelectionCategories_3 = null;

        EObject this_AssertFailCategories_4 = null;

        EObject this_ExecutionFailCategories_5 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:79:28: ( (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories | this_VerificationCategories_2= ruleVerificationCategories | this_SelectionCategories_3= ruleSelectionCategories | this_AssertFailCategories_4= ruleAssertFailCategories | this_ExecutionFailCategories_5= ruleExecutionFailCategories ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:80:1: (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories | this_VerificationCategories_2= ruleVerificationCategories | this_SelectionCategories_3= ruleSelectionCategories | this_AssertFailCategories_4= ruleAssertFailCategories | this_ExecutionFailCategories_5= ruleExecutionFailCategories )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:80:1: (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories | this_VerificationCategories_2= ruleVerificationCategories | this_SelectionCategories_3= ruleSelectionCategories | this_AssertFailCategories_4= ruleAssertFailCategories | this_ExecutionFailCategories_5= ruleExecutionFailCategories )
            int alt1=6;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt1=1;
                }
                break;
            case 15:
                {
                alt1=2;
                }
                break;
            case 16:
                {
                alt1=3;
                }
                break;
            case 17:
                {
                alt1=4;
                }
                break;
            case 18:
                {
                alt1=5;
                }
                break;
            case 19:
                {
                alt1=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:81:5: this_RequirementCategories_0= ruleRequirementCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getRequirementCategoriesParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleRequirementCategories_in_ruleCategories132);
                    this_RequirementCategories_0=ruleRequirementCategories();

                    state._fsp--;

                     
                            current = this_RequirementCategories_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:91:5: this_HazardCategories_1= ruleHazardCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getHazardCategoriesParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleHazardCategories_in_ruleCategories159);
                    this_HazardCategories_1=ruleHazardCategories();

                    state._fsp--;

                     
                            current = this_HazardCategories_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:101:5: this_VerificationCategories_2= ruleVerificationCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVerificationCategories_in_ruleCategories186);
                    this_VerificationCategories_2=ruleVerificationCategories();

                    state._fsp--;

                     
                            current = this_VerificationCategories_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:111:5: this_SelectionCategories_3= ruleSelectionCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getSelectionCategoriesParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleSelectionCategories_in_ruleCategories213);
                    this_SelectionCategories_3=ruleSelectionCategories();

                    state._fsp--;

                     
                            current = this_SelectionCategories_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:121:5: this_AssertFailCategories_4= ruleAssertFailCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getAssertFailCategoriesParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleAssertFailCategories_in_ruleCategories240);
                    this_AssertFailCategories_4=ruleAssertFailCategories();

                    state._fsp--;

                     
                            current = this_AssertFailCategories_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:131:5: this_ExecutionFailCategories_5= ruleExecutionFailCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getExecutionFailCategoriesParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleExecutionFailCategories_in_ruleCategories267);
                    this_ExecutionFailCategories_5=ruleExecutionFailCategories();

                    state._fsp--;

                     
                            current = this_ExecutionFailCategories_5; 
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:147:1: entryRuleRequirementCategories returns [EObject current=null] : iv_ruleRequirementCategories= ruleRequirementCategories EOF ;
    public final EObject entryRuleRequirementCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:148:2: (iv_ruleRequirementCategories= ruleRequirementCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:149:2: iv_ruleRequirementCategories= ruleRequirementCategories EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories302);
            iv_ruleRequirementCategories=ruleRequirementCategories();

            state._fsp--;

             current =iv_ruleRequirementCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategories312); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:156:1: ruleRequirementCategories returns [EObject current=null] : (otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleRequirementCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:159:28: ( (otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:160:1: (otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:160:1: (otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:160:3: otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleRequirementCategories349); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleRequirementCategories361); 

                	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleRequirementCategories373); 

                	newLeafNode(otherlv_2, grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:172:1: ( (lv_category_3_0= ruleRequirementCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:173:1: (lv_category_3_0= ruleRequirementCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:173:1: (lv_category_3_0= ruleRequirementCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:174:3: lv_category_3_0= ruleRequirementCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories394);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleRequirementCategories407); 

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


    // $ANTLR start "entryRuleHazardCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:202:1: entryRuleHazardCategories returns [EObject current=null] : iv_ruleHazardCategories= ruleHazardCategories EOF ;
    public final EObject entryRuleHazardCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazardCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:203:2: (iv_ruleHazardCategories= ruleHazardCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:204:2: iv_ruleHazardCategories= ruleHazardCategories EOF
            {
             newCompositeNode(grammarAccess.getHazardCategoriesRule()); 
            pushFollow(FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories443);
            iv_ruleHazardCategories=ruleHazardCategories();

            state._fsp--;

             current =iv_ruleHazardCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategories453); 

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
    // $ANTLR end "entryRuleHazardCategories"


    // $ANTLR start "ruleHazardCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:211:1: ruleHazardCategories returns [EObject current=null] : (otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleHazardCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:214:28: ( (otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:215:1: (otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:215:1: (otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:215:3: otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleHazardCategories490); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardCategoriesAccess().getHazardKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleHazardCategories502); 

                	newLeafNode(otherlv_1, grammarAccess.getHazardCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleHazardCategories514); 

                	newLeafNode(otherlv_2, grammarAccess.getHazardCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:227:1: ( (lv_category_3_0= ruleHazardCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:228:1: (lv_category_3_0= ruleHazardCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:228:1: (lv_category_3_0= ruleHazardCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:229:3: lv_category_3_0= ruleHazardCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleHazardCategory_in_ruleHazardCategories535);
            	    lv_category_3_0=ruleHazardCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"HazardCategory");
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleHazardCategories548); 

                	newLeafNode(otherlv_4, grammarAccess.getHazardCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleHazardCategories"


    // $ANTLR start "entryRuleVerificationCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:257:1: entryRuleVerificationCategories returns [EObject current=null] : iv_ruleVerificationCategories= ruleVerificationCategories EOF ;
    public final EObject entryRuleVerificationCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:258:2: (iv_ruleVerificationCategories= ruleVerificationCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:259:2: iv_ruleVerificationCategories= ruleVerificationCategories EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoriesRule()); 
            pushFollow(FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories584);
            iv_ruleVerificationCategories=ruleVerificationCategories();

            state._fsp--;

             current =iv_ruleVerificationCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategories594); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:266:1: ruleVerificationCategories returns [EObject current=null] : (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleVerificationCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:269:28: ( (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:270:1: (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:270:1: (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:270:3: otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVerificationCategories631); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleVerificationCategories643); 

                	newLeafNode(otherlv_1, grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleVerificationCategories655); 

                	newLeafNode(otherlv_2, grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:282:1: ( (lv_category_3_0= ruleVerificationCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:283:1: (lv_category_3_0= ruleVerificationCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:283:1: (lv_category_3_0= ruleVerificationCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:284:3: lv_category_3_0= ruleVerificationCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories676);
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
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleVerificationCategories689); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:312:1: entryRuleSelectionCategories returns [EObject current=null] : iv_ruleSelectionCategories= ruleSelectionCategories EOF ;
    public final EObject entryRuleSelectionCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:313:2: (iv_ruleSelectionCategories= ruleSelectionCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:314:2: iv_ruleSelectionCategories= ruleSelectionCategories EOF
            {
             newCompositeNode(grammarAccess.getSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories725);
            iv_ruleSelectionCategories=ruleSelectionCategories();

            state._fsp--;

             current =iv_ruleSelectionCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategories735); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:321:1: ruleSelectionCategories returns [EObject current=null] : (otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleSelectionCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:324:28: ( (otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:325:1: (otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:325:1: (otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:325:3: otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleSelectionCategories772); 

                	newLeafNode(otherlv_0, grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleSelectionCategories784); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleSelectionCategories796); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:337:1: ( (lv_category_3_0= ruleSelectionCategory ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:338:1: (lv_category_3_0= ruleSelectionCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:338:1: (lv_category_3_0= ruleSelectionCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:339:3: lv_category_3_0= ruleSelectionCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectionCategory_in_ruleSelectionCategories817);
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
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleSelectionCategories830); 

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


    // $ANTLR start "entryRuleAssertFailCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:367:1: entryRuleAssertFailCategories returns [EObject current=null] : iv_ruleAssertFailCategories= ruleAssertFailCategories EOF ;
    public final EObject entryRuleAssertFailCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertFailCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:368:2: (iv_ruleAssertFailCategories= ruleAssertFailCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:369:2: iv_ruleAssertFailCategories= ruleAssertFailCategories EOF
            {
             newCompositeNode(grammarAccess.getAssertFailCategoriesRule()); 
            pushFollow(FOLLOW_ruleAssertFailCategories_in_entryRuleAssertFailCategories866);
            iv_ruleAssertFailCategories=ruleAssertFailCategories();

            state._fsp--;

             current =iv_ruleAssertFailCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssertFailCategories876); 

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
    // $ANTLR end "entryRuleAssertFailCategories"


    // $ANTLR start "ruleAssertFailCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:376:1: ruleAssertFailCategories returns [EObject current=null] : (otherlv_0= 'assertfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleAssertFailCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleAssertFailCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:379:28: ( (otherlv_0= 'assertfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleAssertFailCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:380:1: (otherlv_0= 'assertfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleAssertFailCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:380:1: (otherlv_0= 'assertfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleAssertFailCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:380:3: otherlv_0= 'assertfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleAssertFailCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleAssertFailCategories913); 

                	newLeafNode(otherlv_0, grammarAccess.getAssertFailCategoriesAccess().getAssertfailKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleAssertFailCategories925); 

                	newLeafNode(otherlv_1, grammarAccess.getAssertFailCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleAssertFailCategories937); 

                	newLeafNode(otherlv_2, grammarAccess.getAssertFailCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:392:1: ( (lv_category_3_0= ruleAssertFailCategory ) )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:393:1: (lv_category_3_0= ruleAssertFailCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:393:1: (lv_category_3_0= ruleAssertFailCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:394:3: lv_category_3_0= ruleAssertFailCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getAssertFailCategoriesAccess().getCategoryAssertFailCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAssertFailCategory_in_ruleAssertFailCategories958);
            	    lv_category_3_0=ruleAssertFailCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getAssertFailCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"AssertFailCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleAssertFailCategories971); 

                	newLeafNode(otherlv_4, grammarAccess.getAssertFailCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleAssertFailCategories"


    // $ANTLR start "entryRuleExecutionFailCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:422:1: entryRuleExecutionFailCategories returns [EObject current=null] : iv_ruleExecutionFailCategories= ruleExecutionFailCategories EOF ;
    public final EObject entryRuleExecutionFailCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutionFailCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:423:2: (iv_ruleExecutionFailCategories= ruleExecutionFailCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:424:2: iv_ruleExecutionFailCategories= ruleExecutionFailCategories EOF
            {
             newCompositeNode(grammarAccess.getExecutionFailCategoriesRule()); 
            pushFollow(FOLLOW_ruleExecutionFailCategories_in_entryRuleExecutionFailCategories1007);
            iv_ruleExecutionFailCategories=ruleExecutionFailCategories();

            state._fsp--;

             current =iv_ruleExecutionFailCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionFailCategories1017); 

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
    // $ANTLR end "entryRuleExecutionFailCategories"


    // $ANTLR start "ruleExecutionFailCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:431:1: ruleExecutionFailCategories returns [EObject current=null] : (otherlv_0= 'executionfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleExecutionFailCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleExecutionFailCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:434:28: ( (otherlv_0= 'executionfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleExecutionFailCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:435:1: (otherlv_0= 'executionfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleExecutionFailCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:435:1: (otherlv_0= 'executionfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleExecutionFailCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:435:3: otherlv_0= 'executionfail' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleExecutionFailCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleExecutionFailCategories1054); 

                	newLeafNode(otherlv_0, grammarAccess.getExecutionFailCategoriesAccess().getExecutionfailKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleExecutionFailCategories1066); 

                	newLeafNode(otherlv_1, grammarAccess.getExecutionFailCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleExecutionFailCategories1078); 

                	newLeafNode(otherlv_2, grammarAccess.getExecutionFailCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:447:1: ( (lv_category_3_0= ruleExecutionFailCategory ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:448:1: (lv_category_3_0= ruleExecutionFailCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:448:1: (lv_category_3_0= ruleExecutionFailCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:449:3: lv_category_3_0= ruleExecutionFailCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExecutionFailCategoriesAccess().getCategoryExecutionFailCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleExecutionFailCategory_in_ruleExecutionFailCategories1099);
            	    lv_category_3_0=ruleExecutionFailCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExecutionFailCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"ExecutionFailCategory");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleExecutionFailCategories1112); 

                	newLeafNode(otherlv_4, grammarAccess.getExecutionFailCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleExecutionFailCategories"


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:479:1: entryRuleRequirementCategory returns [EObject current=null] : iv_ruleRequirementCategory= ruleRequirementCategory EOF ;
    public final EObject entryRuleRequirementCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:480:2: (iv_ruleRequirementCategory= ruleRequirementCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:481:2: iv_ruleRequirementCategory= ruleRequirementCategory EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory1150);
            iv_ruleRequirementCategory=ruleRequirementCategory();

            state._fsp--;

             current =iv_ruleRequirementCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory1160); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:488:1: ruleRequirementCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleRequirementCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:491:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:492:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:492:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:492:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:492:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:493:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:493:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:494:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategory1202); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:510:2: (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:510:4: otherlv_1= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleRequirementCategory1220); 

                        	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:514:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:515:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:515:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:516:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirementCategory1243);
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


    // $ANTLR start "entryRuleHazardCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:537:1: entryRuleHazardCategory returns [EObject current=null] : iv_ruleHazardCategory= ruleHazardCategory EOF ;
    public final EObject entryRuleHazardCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazardCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:538:2: (iv_ruleHazardCategory= ruleHazardCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:539:2: iv_ruleHazardCategory= ruleHazardCategory EOF
            {
             newCompositeNode(grammarAccess.getHazardCategoryRule()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory1281);
            iv_ruleHazardCategory=ruleHazardCategory();

            state._fsp--;

             current =iv_ruleHazardCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategory1291); 

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
    // $ANTLR end "entryRuleHazardCategory"


    // $ANTLR start "ruleHazardCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:546:1: ruleHazardCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleHazardCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:549:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:550:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:550:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:550:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:550:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:551:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:551:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:552:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazardCategory1333); 

            			newLeafNode(lv_name_0_0, grammarAccess.getHazardCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getHazardCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:568:2: (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:568:4: otherlv_1= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleHazardCategory1351); 

                        	newLeafNode(otherlv_1, grammarAccess.getHazardCategoryAccess().getExtendsKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:572:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:573:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:573:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:574:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getHazardCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleHazardCategory1374);
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
    // $ANTLR end "ruleHazardCategory"


    // $ANTLR start "entryRuleVerificationCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:595:1: entryRuleVerificationCategory returns [EObject current=null] : iv_ruleVerificationCategory= ruleVerificationCategory EOF ;
    public final EObject entryRuleVerificationCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:596:2: (iv_ruleVerificationCategory= ruleVerificationCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:597:2: iv_ruleVerificationCategory= ruleVerificationCategory EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory1412);
            iv_ruleVerificationCategory=ruleVerificationCategory();

            state._fsp--;

             current =iv_ruleVerificationCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory1422); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:604:1: ruleVerificationCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleVerificationCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:607:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:608:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:608:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:608:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:608:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:609:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:609:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:610:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationCategory1464); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:626:2: (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==20) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:626:4: otherlv_1= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleVerificationCategory1482); 

                        	newLeafNode(otherlv_1, grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:630:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:631:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:631:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:632:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getVerificationCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleVerificationCategory1505);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:653:1: entryRuleSelectionCategory returns [EObject current=null] : iv_ruleSelectionCategory= ruleSelectionCategory EOF ;
    public final EObject entryRuleSelectionCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:654:2: (iv_ruleSelectionCategory= ruleSelectionCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:655:2: iv_ruleSelectionCategory= ruleSelectionCategory EOF
            {
             newCompositeNode(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory1543);
            iv_ruleSelectionCategory=ruleSelectionCategory();

            state._fsp--;

             current =iv_ruleSelectionCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory1553); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:662:1: ruleSelectionCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleSelectionCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:665:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:666:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:666:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:666:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:666:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:667:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:667:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:668:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectionCategory1595); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:684:2: (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:684:4: otherlv_1= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleSelectionCategory1613); 

                        	newLeafNode(otherlv_1, grammarAccess.getSelectionCategoryAccess().getExtendsKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:688:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:689:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:689:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:690:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSelectionCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSelectionCategoryAccess().getExtendsSelectionCategoryCrossReference_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleSelectionCategory1636);
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


    // $ANTLR start "entryRuleAssertFailCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:711:1: entryRuleAssertFailCategory returns [EObject current=null] : iv_ruleAssertFailCategory= ruleAssertFailCategory EOF ;
    public final EObject entryRuleAssertFailCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssertFailCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:712:2: (iv_ruleAssertFailCategory= ruleAssertFailCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:713:2: iv_ruleAssertFailCategory= ruleAssertFailCategory EOF
            {
             newCompositeNode(grammarAccess.getAssertFailCategoryRule()); 
            pushFollow(FOLLOW_ruleAssertFailCategory_in_entryRuleAssertFailCategory1674);
            iv_ruleAssertFailCategory=ruleAssertFailCategory();

            state._fsp--;

             current =iv_ruleAssertFailCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssertFailCategory1684); 

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
    // $ANTLR end "entryRuleAssertFailCategory"


    // $ANTLR start "ruleAssertFailCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:720:1: ruleAssertFailCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleAssertFailCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:723:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:724:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:724:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:724:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:724:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:725:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:725:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:726:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAssertFailCategory1726); 

            			newLeafNode(lv_name_0_0, grammarAccess.getAssertFailCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAssertFailCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:742:2: (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:742:4: otherlv_1= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleAssertFailCategory1744); 

                        	newLeafNode(otherlv_1, grammarAccess.getAssertFailCategoryAccess().getExtendsKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:746:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:747:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:747:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:748:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getAssertFailCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getAssertFailCategoryAccess().getExtendsAssertFailCategoryCrossReference_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleAssertFailCategory1767);
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
    // $ANTLR end "ruleAssertFailCategory"


    // $ANTLR start "entryRuleExecutionFailCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:769:1: entryRuleExecutionFailCategory returns [EObject current=null] : iv_ruleExecutionFailCategory= ruleExecutionFailCategory EOF ;
    public final EObject entryRuleExecutionFailCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutionFailCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:770:2: (iv_ruleExecutionFailCategory= ruleExecutionFailCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:771:2: iv_ruleExecutionFailCategory= ruleExecutionFailCategory EOF
            {
             newCompositeNode(grammarAccess.getExecutionFailCategoryRule()); 
            pushFollow(FOLLOW_ruleExecutionFailCategory_in_entryRuleExecutionFailCategory1805);
            iv_ruleExecutionFailCategory=ruleExecutionFailCategory();

            state._fsp--;

             current =iv_ruleExecutionFailCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionFailCategory1815); 

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
    // $ANTLR end "entryRuleExecutionFailCategory"


    // $ANTLR start "ruleExecutionFailCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:778:1: ruleExecutionFailCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleExecutionFailCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:781:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:782:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:782:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:782:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:782:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:783:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:783:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:784:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExecutionFailCategory1857); 

            			newLeafNode(lv_name_0_0, grammarAccess.getExecutionFailCategoryAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExecutionFailCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:800:2: (otherlv_1= 'extends' ( ( ruleCatRef ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==20) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:800:4: otherlv_1= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleExecutionFailCategory1875); 

                        	newLeafNode(otherlv_1, grammarAccess.getExecutionFailCategoryAccess().getExtendsKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:804:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:805:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:805:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:806:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getExecutionFailCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getExecutionFailCategoryAccess().getExtendsExecutionFailCategoryCrossReference_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleExecutionFailCategory1898);
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
    // $ANTLR end "ruleExecutionFailCategory"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:827:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:828:2: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:829:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef1937);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef1948); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:836:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:839:28: (this_ID_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:840:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef1987); 

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


 

    public static final BitSet FOLLOW_ruleCategories_in_entryRuleCategories75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategories85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_ruleCategories132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_ruleCategories159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_ruleCategories186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_ruleCategories213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertFailCategories_in_ruleCategories240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionFailCategories_in_ruleCategories267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRequirementCategories349 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRequirementCategories361 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRequirementCategories373 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories394 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleRequirementCategories407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories443 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategories453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleHazardCategories490 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleHazardCategories502 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleHazardCategories514 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_ruleHazardCategories535 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleHazardCategories548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategories594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVerificationCategories631 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVerificationCategories643 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVerificationCategories655 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories676 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleVerificationCategories689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories725 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategories735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSelectionCategories772 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSelectionCategories784 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSelectionCategories796 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_ruleSelectionCategories817 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleSelectionCategories830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertFailCategories_in_entryRuleAssertFailCategories866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssertFailCategories876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleAssertFailCategories913 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleAssertFailCategories925 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleAssertFailCategories937 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAssertFailCategory_in_ruleAssertFailCategories958 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleAssertFailCategories971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionFailCategories_in_entryRuleExecutionFailCategories1007 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionFailCategories1017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleExecutionFailCategories1054 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleExecutionFailCategories1066 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleExecutionFailCategories1078 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExecutionFailCategory_in_ruleExecutionFailCategories1099 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleExecutionFailCategories1112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory1150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory1160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategory1202 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleRequirementCategory1220 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirementCategory1243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory1281 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategory1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazardCategory1333 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleHazardCategory1351 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleHazardCategory1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory1412 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationCategory1464 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleVerificationCategory1482 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleVerificationCategory1505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory1543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectionCategory1595 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleSelectionCategory1613 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleSelectionCategory1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssertFailCategory_in_entryRuleAssertFailCategory1674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssertFailCategory1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAssertFailCategory1726 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleAssertFailCategory1744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleAssertFailCategory1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionFailCategory_in_entryRuleExecutionFailCategory1805 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionFailCategory1815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExecutionFailCategory1857 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleExecutionFailCategory1875 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleExecutionFailCategory1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef1937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef1987 = new BitSet(new long[]{0x0000000000000002L});

}