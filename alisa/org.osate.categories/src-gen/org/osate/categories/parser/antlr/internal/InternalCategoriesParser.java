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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'['", "']'", "'hazard'", "'Verification'", "'category'", "'extends'", "'.'"
    };
    public static final int T__19=19;
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:76:1: ruleCategories returns [EObject current=null] : (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories | this_VerificationCategories_2= ruleVerificationCategories ) ;
    public final EObject ruleCategories() throws RecognitionException {
        EObject current = null;

        EObject this_RequirementCategories_0 = null;

        EObject this_HazardCategories_1 = null;

        EObject this_VerificationCategories_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:79:28: ( (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories | this_VerificationCategories_2= ruleVerificationCategories ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:80:1: (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories | this_VerificationCategories_2= ruleVerificationCategories )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:80:1: (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories | this_VerificationCategories_2= ruleVerificationCategories )
            int alt1=3;
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:117:1: entryRuleRequirementCategories returns [EObject current=null] : iv_ruleRequirementCategories= ruleRequirementCategories EOF ;
    public final EObject entryRuleRequirementCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:118:2: (iv_ruleRequirementCategories= ruleRequirementCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:119:2: iv_ruleRequirementCategories= ruleRequirementCategories EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories221);
            iv_ruleRequirementCategories=ruleRequirementCategories();

            state._fsp--;

             current =iv_ruleRequirementCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategories231); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:126:1: ruleRequirementCategories returns [EObject current=null] : (otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= ']' ) ;
    public final EObject ruleRequirementCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:129:28: ( (otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:130:1: (otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:130:1: (otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:130:3: otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleRequirementCategories268); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleRequirementCategories280); 

                	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:138:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:139:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:139:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:140:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategories297); 

            			newLeafNode(lv_name_2_0, grammarAccess.getRequirementCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRequirementCategoriesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleRequirementCategories314); 

                	newLeafNode(otherlv_3, grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:160:1: ( (lv_category_4_0= ruleRequirementCategory ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==17) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:161:1: (lv_category_4_0= ruleRequirementCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:161:1: (lv_category_4_0= ruleRequirementCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:162:3: lv_category_4_0= ruleRequirementCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories335);
            	    lv_category_4_0=ruleRequirementCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getRequirementCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleRequirementCategories348); 

                	newLeafNode(otherlv_5, grammarAccess.getRequirementCategoriesAccess().getRightSquareBracketKeyword_5());
                

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:190:1: entryRuleHazardCategories returns [EObject current=null] : iv_ruleHazardCategories= ruleHazardCategories EOF ;
    public final EObject entryRuleHazardCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazardCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:191:2: (iv_ruleHazardCategories= ruleHazardCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:192:2: iv_ruleHazardCategories= ruleHazardCategories EOF
            {
             newCompositeNode(grammarAccess.getHazardCategoriesRule()); 
            pushFollow(FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories384);
            iv_ruleHazardCategories=ruleHazardCategories();

            state._fsp--;

             current =iv_ruleHazardCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategories394); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:199:1: ruleHazardCategories returns [EObject current=null] : (otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= ']' ) ;
    public final EObject ruleHazardCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:202:28: ( (otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:203:1: (otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:203:1: (otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:203:3: otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleHazardCategories431); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardCategoriesAccess().getHazardKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleHazardCategories443); 

                	newLeafNode(otherlv_1, grammarAccess.getHazardCategoriesAccess().getCategoriesKeyword_1());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:211:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:212:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:212:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:213:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazardCategories460); 

            			newLeafNode(lv_name_2_0, grammarAccess.getHazardCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getHazardCategoriesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleHazardCategories477); 

                	newLeafNode(otherlv_3, grammarAccess.getHazardCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:233:1: ( (lv_category_4_0= ruleHazardCategory ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==17) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:234:1: (lv_category_4_0= ruleHazardCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:234:1: (lv_category_4_0= ruleHazardCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:235:3: lv_category_4_0= ruleHazardCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleHazardCategory_in_ruleHazardCategories498);
            	    lv_category_4_0=ruleHazardCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getHazardCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleHazardCategories511); 

                	newLeafNode(otherlv_5, grammarAccess.getHazardCategoriesAccess().getRightSquareBracketKeyword_5());
                

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:263:1: entryRuleVerificationCategories returns [EObject current=null] : iv_ruleVerificationCategories= ruleVerificationCategories EOF ;
    public final EObject entryRuleVerificationCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:264:2: (iv_ruleVerificationCategories= ruleVerificationCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:265:2: iv_ruleVerificationCategories= ruleVerificationCategories EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoriesRule()); 
            pushFollow(FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories547);
            iv_ruleVerificationCategories=ruleVerificationCategories();

            state._fsp--;

             current =iv_ruleVerificationCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategories557); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:272:1: ruleVerificationCategories returns [EObject current=null] : (otherlv_0= 'Verification' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleVerificationCategory ) )+ otherlv_5= ']' ) ;
    public final EObject ruleVerificationCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_category_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:275:28: ( (otherlv_0= 'Verification' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleVerificationCategory ) )+ otherlv_5= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:276:1: (otherlv_0= 'Verification' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleVerificationCategory ) )+ otherlv_5= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:276:1: (otherlv_0= 'Verification' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleVerificationCategory ) )+ otherlv_5= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:276:3: otherlv_0= 'Verification' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '[' ( (lv_category_4_0= ruleVerificationCategory ) )+ otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVerificationCategories594); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleVerificationCategories606); 

                	newLeafNode(otherlv_1, grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:284:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:285:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:285:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:286:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationCategories623); 

            			newLeafNode(lv_name_2_0, grammarAccess.getVerificationCategoriesAccess().getNameIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVerificationCategoriesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleVerificationCategories640); 

                	newLeafNode(otherlv_3, grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:306:1: ( (lv_category_4_0= ruleVerificationCategory ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:307:1: (lv_category_4_0= ruleVerificationCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:307:1: (lv_category_4_0= ruleVerificationCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:308:3: lv_category_4_0= ruleVerificationCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories661);
            	    lv_category_4_0=ruleVerificationCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getVerificationCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_4_0, 
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleVerificationCategories674); 

                	newLeafNode(otherlv_5, grammarAccess.getVerificationCategoriesAccess().getRightSquareBracketKeyword_5());
                

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


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:336:1: entryRuleRequirementCategory returns [EObject current=null] : iv_ruleRequirementCategory= ruleRequirementCategory EOF ;
    public final EObject entryRuleRequirementCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:337:2: (iv_ruleRequirementCategory= ruleRequirementCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:338:2: iv_ruleRequirementCategory= ruleRequirementCategory EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory710);
            iv_ruleRequirementCategory=ruleRequirementCategory();

            state._fsp--;

             current =iv_ruleRequirementCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory720); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:345:1: ruleRequirementCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) ;
    public final EObject ruleRequirementCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:348:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:349:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:349:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:349:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleRequirementCategory757); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:353:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:354:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:354:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:355:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategory774); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRequirementCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:371:2: (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:371:4: otherlv_2= 'extends' ( ( ruleCATREF ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleRequirementCategory792); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:375:1: ( ( ruleCATREF ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:376:1: ( ruleCATREF )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:376:1: ( ruleCATREF )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:377:3: ruleCATREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCATREF_in_ruleRequirementCategory815);
                    ruleCATREF();

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:398:1: entryRuleHazardCategory returns [EObject current=null] : iv_ruleHazardCategory= ruleHazardCategory EOF ;
    public final EObject entryRuleHazardCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazardCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:399:2: (iv_ruleHazardCategory= ruleHazardCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:400:2: iv_ruleHazardCategory= ruleHazardCategory EOF
            {
             newCompositeNode(grammarAccess.getHazardCategoryRule()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory853);
            iv_ruleHazardCategory=ruleHazardCategory();

            state._fsp--;

             current =iv_ruleHazardCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategory863); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:407:1: ruleHazardCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) ;
    public final EObject ruleHazardCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:410:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:411:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:411:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:411:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleHazardCategory900); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:415:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:416:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:416:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:417:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazardCategory917); 

            			newLeafNode(lv_name_1_0, grammarAccess.getHazardCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getHazardCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:433:2: (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:433:4: otherlv_2= 'extends' ( ( ruleCATREF ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleHazardCategory935); 

                        	newLeafNode(otherlv_2, grammarAccess.getHazardCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:437:1: ( ( ruleCATREF ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:438:1: ( ruleCATREF )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:438:1: ( ruleCATREF )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:439:3: ruleCATREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getHazardCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCATREF_in_ruleHazardCategory958);
                    ruleCATREF();

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:460:1: entryRuleVerificationCategory returns [EObject current=null] : iv_ruleVerificationCategory= ruleVerificationCategory EOF ;
    public final EObject entryRuleVerificationCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:461:2: (iv_ruleVerificationCategory= ruleVerificationCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:462:2: iv_ruleVerificationCategory= ruleVerificationCategory EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory996);
            iv_ruleVerificationCategory=ruleVerificationCategory();

            state._fsp--;

             current =iv_ruleVerificationCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory1006); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:469:1: ruleVerificationCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) ;
    public final EObject ruleVerificationCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:472:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:473:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:473:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:473:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleVerificationCategory1043); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:477:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:478:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:478:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:479:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationCategory1060); 

            			newLeafNode(lv_name_1_0, grammarAccess.getVerificationCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVerificationCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:495:2: (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:495:4: otherlv_2= 'extends' ( ( ruleCATREF ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleVerificationCategory1078); 

                        	newLeafNode(otherlv_2, grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:499:1: ( ( ruleCATREF ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:500:1: ( ruleCATREF )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:500:1: ( ruleCATREF )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:501:3: ruleCATREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getVerificationCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCATREF_in_ruleVerificationCategory1101);
                    ruleCATREF();

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


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:524:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:525:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:526:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription1141);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription1151); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:533:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:536:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:537:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:537:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_STRING)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:538:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:538:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:539:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription1196);
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:563:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:564:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:565:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1232);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1242); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:572:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:575:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:576:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:576:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:576:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:576:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:577:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:577:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:578:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1284); 

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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:595:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:595:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:596:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:596:1: (otherlv_1= RULE_ID )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:597:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement1315); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:616:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:617:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:618:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath1351);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath1361); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:625:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:628:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:629:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:629:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:629:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:629:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:630:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:630:1: (otherlv_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:631:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath1406); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:642:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:642:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleReferencePath1419); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:646:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:647:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:647:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:648:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath1440);
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


    // $ANTLR start "entryRuleCATREF"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:678:1: entryRuleCATREF returns [String current=null] : iv_ruleCATREF= ruleCATREF EOF ;
    public final String entryRuleCATREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCATREF = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:679:2: (iv_ruleCATREF= ruleCATREF EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:680:2: iv_ruleCATREF= ruleCATREF EOF
            {
             newCompositeNode(grammarAccess.getCATREFRule()); 
            pushFollow(FOLLOW_ruleCATREF_in_entryRuleCATREF1484);
            iv_ruleCATREF=ruleCATREF();

            state._fsp--;

             current =iv_ruleCATREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCATREF1495); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:687:1: ruleCATREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleCATREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:690:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:691:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:691:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:691:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCATREF1535); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getCATREFAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:698:1: (kw= '.' this_ID_2= RULE_ID )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:699:2: kw= '.' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,19,FOLLOW_19_in_ruleCATREF1554); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCATREFAccess().getFullStopKeyword_1_0()); 
                        
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCATREF1569); 

                    		current.merge(this_ID_2);
                        
                     
                        newLeafNode(this_ID_2, grammarAccess.getCATREFAccess().getIDTerminalRuleCall_1_1()); 
                        

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
    // $ANTLR end "ruleCATREF"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategories_in_entryRuleCategories75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategories85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_ruleCategories132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_ruleCategories159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_ruleCategories186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRequirementCategories268 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRequirementCategories280 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategories297 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRequirementCategories314 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories335 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleRequirementCategories348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategories394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleHazardCategories431 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleHazardCategories443 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazardCategories460 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleHazardCategories477 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_ruleHazardCategories498 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleHazardCategories511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategories557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVerificationCategories594 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVerificationCategories606 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationCategories623 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVerificationCategories640 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories661 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleVerificationCategories674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleRequirementCategory757 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategory774 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleRequirementCategory792 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleRequirementCategory815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory853 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategory863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleHazardCategory900 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazardCategory917 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleHazardCategory935 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleHazardCategory958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory996 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory1006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVerificationCategory1043 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationCategory1060 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleVerificationCategory1078 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleVerificationCategory1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription1141 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription1196 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1232 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath1351 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath1361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath1406 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleReferencePath1419 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath1440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCATREF_in_entryRuleCATREF1484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCATREF1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCATREF1535 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleCATREF1554 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCATREF1569 = new BitSet(new long[]{0x0000000000000002L});

}