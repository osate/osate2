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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'['", "']'", "'verification'", "'selection'", "'{'", "'}'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int RULE_INT=5;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:76:1: ruleCategories returns [EObject current=null] : (this_RequirementCategories_0= ruleRequirementCategories | this_VerificationCategories_1= ruleVerificationCategories | this_SelectionCategories_2= ruleSelectionCategories ) ;
    public final EObject ruleCategories() throws RecognitionException {
        EObject current = null;

        EObject this_RequirementCategories_0 = null;

        EObject this_VerificationCategories_1 = null;

        EObject this_SelectionCategories_2 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:79:28: ( (this_RequirementCategories_0= ruleRequirementCategories | this_VerificationCategories_1= ruleVerificationCategories | this_SelectionCategories_2= ruleSelectionCategories ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:80:1: (this_RequirementCategories_0= ruleRequirementCategories | this_VerificationCategories_1= ruleVerificationCategories | this_SelectionCategories_2= ruleSelectionCategories )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:80:1: (this_RequirementCategories_0= ruleRequirementCategories | this_VerificationCategories_1= ruleVerificationCategories | this_SelectionCategories_2= ruleSelectionCategories )
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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:91:5: this_VerificationCategories_1= ruleVerificationCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getVerificationCategoriesParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVerificationCategories_in_ruleCategories159);
                    this_VerificationCategories_1=ruleVerificationCategories();

                    state._fsp--;

                     
                            current = this_VerificationCategories_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:101:5: this_SelectionCategories_2= ruleSelectionCategories
                    {
                     
                            newCompositeNode(grammarAccess.getCategoriesAccess().getSelectionCategoriesParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSelectionCategories_in_ruleCategories186);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:126:1: ruleRequirementCategories returns [EObject current=null] : (otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleRequirementCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:129:28: ( (otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:130:1: (otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:130:1: (otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:130:3: otherlv_0= 'requirement' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleRequirementCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleRequirementCategories268); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleRequirementCategories280); 

                	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleRequirementCategories292); 

                	newLeafNode(otherlv_2, grammarAccess.getRequirementCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:142:1: ( (lv_category_3_0= ruleRequirementCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:143:1: (lv_category_3_0= ruleRequirementCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:143:1: (lv_category_3_0= ruleRequirementCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:144:3: lv_category_3_0= ruleRequirementCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories313);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleRequirementCategories326); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:172:1: entryRuleVerificationCategories returns [EObject current=null] : iv_ruleVerificationCategories= ruleVerificationCategories EOF ;
    public final EObject entryRuleVerificationCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:173:2: (iv_ruleVerificationCategories= ruleVerificationCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:174:2: iv_ruleVerificationCategories= ruleVerificationCategories EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoriesRule()); 
            pushFollow(FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories362);
            iv_ruleVerificationCategories=ruleVerificationCategories();

            state._fsp--;

             current =iv_ruleVerificationCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategories372); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:181:1: ruleVerificationCategories returns [EObject current=null] : (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleVerificationCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:184:28: ( (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:185:1: (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:185:1: (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:185:3: otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleVerificationCategories409); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleVerificationCategories421); 

                	newLeafNode(otherlv_1, grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleVerificationCategories433); 

                	newLeafNode(otherlv_2, grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:197:1: ( (lv_category_3_0= ruleVerificationCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:198:1: (lv_category_3_0= ruleVerificationCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:198:1: (lv_category_3_0= ruleVerificationCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:199:3: lv_category_3_0= ruleVerificationCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories454);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleVerificationCategories467); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:227:1: entryRuleSelectionCategories returns [EObject current=null] : iv_ruleSelectionCategories= ruleSelectionCategories EOF ;
    public final EObject entryRuleSelectionCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:228:2: (iv_ruleSelectionCategories= ruleSelectionCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:229:2: iv_ruleSelectionCategories= ruleSelectionCategories EOF
            {
             newCompositeNode(grammarAccess.getSelectionCategoriesRule()); 
            pushFollow(FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories503);
            iv_ruleSelectionCategories=ruleSelectionCategories();

            state._fsp--;

             current =iv_ruleSelectionCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategories513); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:236:1: ruleSelectionCategories returns [EObject current=null] : (otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleSelectionCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:239:28: ( (otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:240:1: (otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:240:1: (otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:240:3: otherlv_0= 'selection' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleSelectionCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleSelectionCategories550); 

                	newLeafNode(otherlv_0, grammarAccess.getSelectionCategoriesAccess().getSelectionKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleSelectionCategories562); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectionCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleSelectionCategories574); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectionCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:252:1: ( (lv_category_3_0= ruleSelectionCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:253:1: (lv_category_3_0= ruleSelectionCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:253:1: (lv_category_3_0= ruleSelectionCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:254:3: lv_category_3_0= ruleSelectionCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSelectionCategoriesAccess().getCategorySelectionCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSelectionCategory_in_ruleSelectionCategories595);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleSelectionCategories608); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:284:1: entryRuleRequirementCategory returns [EObject current=null] : iv_ruleRequirementCategory= ruleRequirementCategory EOF ;
    public final EObject entryRuleRequirementCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:285:2: (iv_ruleRequirementCategory= ruleRequirementCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:286:2: iv_ruleRequirementCategory= ruleRequirementCategory EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory646);
            iv_ruleRequirementCategory=ruleRequirementCategory();

            state._fsp--;

             current =iv_ruleRequirementCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory656); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:293:1: ruleRequirementCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleRequirementCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:296:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:297:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:297:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:297:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:297:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:298:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:298:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:299:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategory698); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:315:2: (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:315:4: otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleRequirementCategory716); 

                        	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoryAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:319:1: ( ( ruleCatRef ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:320:1: ( ruleCatRef )
                    	    {
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:320:1: ( ruleCatRef )
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:321:3: ruleCatRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getRequirementCategoryAccess().getSubCategoriesRequirementCategoryCrossReference_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirementCategory739);
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

                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleRequirementCategory752); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:346:1: entryRuleVerificationCategory returns [EObject current=null] : iv_ruleVerificationCategory= ruleVerificationCategory EOF ;
    public final EObject entryRuleVerificationCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:347:2: (iv_ruleVerificationCategory= ruleVerificationCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:348:2: iv_ruleVerificationCategory= ruleVerificationCategory EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory790);
            iv_ruleVerificationCategory=ruleVerificationCategory();

            state._fsp--;

             current =iv_ruleVerificationCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory800); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:355:1: ruleVerificationCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleVerificationCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:358:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:359:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:359:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:359:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:359:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:360:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:360:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:361:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationCategory842); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:377:2: (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==17) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:377:4: otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleVerificationCategory860); 

                        	newLeafNode(otherlv_1, grammarAccess.getVerificationCategoryAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:381:1: ( ( ruleCatRef ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:382:1: ( ruleCatRef )
                    	    {
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:382:1: ( ruleCatRef )
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:383:3: ruleCatRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getVerificationCategoryRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getVerificationCategoryAccess().getSubCategoriesVerificationCategoryCrossReference_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCatRef_in_ruleVerificationCategory883);
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

                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleVerificationCategory896); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:408:1: entryRuleSelectionCategory returns [EObject current=null] : iv_ruleSelectionCategory= ruleSelectionCategory EOF ;
    public final EObject entryRuleSelectionCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectionCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:409:2: (iv_ruleSelectionCategory= ruleSelectionCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:410:2: iv_ruleSelectionCategory= ruleSelectionCategory EOF
            {
             newCompositeNode(grammarAccess.getSelectionCategoryRule()); 
            pushFollow(FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory934);
            iv_ruleSelectionCategory=ruleSelectionCategory();

            state._fsp--;

             current =iv_ruleSelectionCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelectionCategory944); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:417:1: ruleSelectionCategory returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? ) ;
    public final EObject ruleSelectionCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:420:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:421:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:421:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:421:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )?
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:421:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:422:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:422:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:423:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSelectionCategory986); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:439:2: (otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==17) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:439:4: otherlv_1= '{' ( ( ruleCatRef ) )* otherlv_3= '}'
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleSelectionCategory1004); 

                        	newLeafNode(otherlv_1, grammarAccess.getSelectionCategoryAccess().getLeftCurlyBracketKeyword_1_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:443:1: ( ( ruleCatRef ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:444:1: ( ruleCatRef )
                    	    {
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:444:1: ( ruleCatRef )
                    	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:445:3: ruleCatRef
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSelectionCategoryRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSelectionCategoryAccess().getSubCategoriesSelectionCategoryCrossReference_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCatRef_in_ruleSelectionCategory1027);
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

                    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleSelectionCategory1040); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:470:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:471:2: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:472:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef1079);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef1090); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:479:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:482:28: (this_ID_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:483:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef1129); 

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
    public static final BitSet FOLLOW_ruleVerificationCategories_in_ruleCategories159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_ruleCategories186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRequirementCategories268 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRequirementCategories280 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRequirementCategories292 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories313 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleRequirementCategories326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategories372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleVerificationCategories409 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVerificationCategories421 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVerificationCategories433 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories454 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleVerificationCategories467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategories_in_entryRuleSelectionCategories503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategories513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleSelectionCategories550 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleSelectionCategories562 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleSelectionCategories574 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_ruleSelectionCategories595 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleSelectionCategories608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategory698 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleRequirementCategory716 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirementCategory739 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleRequirementCategory752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory790 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationCategory842 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleVerificationCategory860 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleVerificationCategory883 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleVerificationCategory896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelectionCategory_in_entryRuleSelectionCategory934 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelectionCategory944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSelectionCategory986 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleSelectionCategory1004 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleSelectionCategory1027 = new BitSet(new long[]{0x0000000000040010L});
    public static final BitSet FOLLOW_18_in_ruleSelectionCategory1040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef1079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef1129 = new BitSet(new long[]{0x0000000000000002L});

}