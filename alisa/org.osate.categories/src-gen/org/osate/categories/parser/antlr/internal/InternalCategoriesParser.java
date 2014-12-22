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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'['", "']'", "'hazard'", "'verification'", "'category'", "'extends'", "'.'", "'.*'"
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
    public static final int T__20=20;
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

                if ( (LA2_0==17) ) {
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


    // $ANTLR start "entryRuleHazardCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:172:1: entryRuleHazardCategories returns [EObject current=null] : iv_ruleHazardCategories= ruleHazardCategories EOF ;
    public final EObject entryRuleHazardCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazardCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:173:2: (iv_ruleHazardCategories= ruleHazardCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:174:2: iv_ruleHazardCategories= ruleHazardCategories EOF
            {
             newCompositeNode(grammarAccess.getHazardCategoriesRule()); 
            pushFollow(FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories362);
            iv_ruleHazardCategories=ruleHazardCategories();

            state._fsp--;

             current =iv_ruleHazardCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategories372); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:181:1: ruleHazardCategories returns [EObject current=null] : (otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleHazardCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:184:28: ( (otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:185:1: (otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:185:1: (otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:185:3: otherlv_0= 'hazard' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleHazardCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleHazardCategories409); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardCategoriesAccess().getHazardKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleHazardCategories421); 

                	newLeafNode(otherlv_1, grammarAccess.getHazardCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleHazardCategories433); 

                	newLeafNode(otherlv_2, grammarAccess.getHazardCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:197:1: ( (lv_category_3_0= ruleHazardCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:198:1: (lv_category_3_0= ruleHazardCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:198:1: (lv_category_3_0= ruleHazardCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:199:3: lv_category_3_0= ruleHazardCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleHazardCategory_in_ruleHazardCategories454);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleHazardCategories467); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:227:1: entryRuleVerificationCategories returns [EObject current=null] : iv_ruleVerificationCategories= ruleVerificationCategories EOF ;
    public final EObject entryRuleVerificationCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:228:2: (iv_ruleVerificationCategories= ruleVerificationCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:229:2: iv_ruleVerificationCategories= ruleVerificationCategories EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoriesRule()); 
            pushFollow(FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories503);
            iv_ruleVerificationCategories=ruleVerificationCategories();

            state._fsp--;

             current =iv_ruleVerificationCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategories513); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:236:1: ruleVerificationCategories returns [EObject current=null] : (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' ) ;
    public final EObject ruleVerificationCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:239:28: ( (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:240:1: (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:240:1: (otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:240:3: otherlv_0= 'verification' otherlv_1= 'categories' otherlv_2= '[' ( (lv_category_3_0= ruleVerificationCategory ) )+ otherlv_4= ']'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVerificationCategories550); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationCategoriesAccess().getVerificationKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleVerificationCategories562); 

                	newLeafNode(otherlv_1, grammarAccess.getVerificationCategoriesAccess().getCategoriesKeyword_1());
                
            otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleVerificationCategories574); 

                	newLeafNode(otherlv_2, grammarAccess.getVerificationCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:252:1: ( (lv_category_3_0= ruleVerificationCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:253:1: (lv_category_3_0= ruleVerificationCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:253:1: (lv_category_3_0= ruleVerificationCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:254:3: lv_category_3_0= ruleVerificationCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getVerificationCategoriesAccess().getCategoryVerificationCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories595);
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

            otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleVerificationCategories608); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:293:1: ruleRequirementCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleRequirementCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:296:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:297:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:297:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:297:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleRequirementCategory693); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:301:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:302:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:302:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:303:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategory710); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:319:2: (otherlv_2= 'extends' ( ( ruleCatRef ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:319:4: otherlv_2= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleRequirementCategory728); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:323:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:324:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:324:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:325:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleRequirementCategory751);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:346:1: entryRuleHazardCategory returns [EObject current=null] : iv_ruleHazardCategory= ruleHazardCategory EOF ;
    public final EObject entryRuleHazardCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazardCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:347:2: (iv_ruleHazardCategory= ruleHazardCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:348:2: iv_ruleHazardCategory= ruleHazardCategory EOF
            {
             newCompositeNode(grammarAccess.getHazardCategoryRule()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory789);
            iv_ruleHazardCategory=ruleHazardCategory();

            state._fsp--;

             current =iv_ruleHazardCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategory799); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:355:1: ruleHazardCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleHazardCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:358:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:359:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:359:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:359:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleHazardCategory836); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:363:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:364:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:364:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:365:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazardCategory853); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:381:2: (otherlv_2= 'extends' ( ( ruleCatRef ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==18) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:381:4: otherlv_2= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleHazardCategory871); 

                        	newLeafNode(otherlv_2, grammarAccess.getHazardCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:385:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:386:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:386:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:387:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getHazardCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleHazardCategory894);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:408:1: entryRuleVerificationCategory returns [EObject current=null] : iv_ruleVerificationCategory= ruleVerificationCategory EOF ;
    public final EObject entryRuleVerificationCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:409:2: (iv_ruleVerificationCategory= ruleVerificationCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:410:2: iv_ruleVerificationCategory= ruleVerificationCategory EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory932);
            iv_ruleVerificationCategory=ruleVerificationCategory();

            state._fsp--;

             current =iv_ruleVerificationCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory942); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:417:1: ruleVerificationCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? ) ;
    public final EObject ruleVerificationCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:420:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:421:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:421:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:421:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCatRef ) ) )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleVerificationCategory979); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:425:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:426:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:426:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:427:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationCategory996); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:443:2: (otherlv_2= 'extends' ( ( ruleCatRef ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:443:4: otherlv_2= 'extends' ( ( ruleCatRef ) )
                    {
                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleVerificationCategory1014); 

                        	newLeafNode(otherlv_2, grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:447:1: ( ( ruleCatRef ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:448:1: ( ruleCatRef )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:448:1: ( ruleCatRef )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:449:3: ruleCatRef
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getVerificationCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCatRef_in_ruleVerificationCategory1037);
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


    // $ANTLR start "entryRuleDescription"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:472:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:473:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:474:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription1077);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription1087); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:481:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:484:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:485:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:485:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:486:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:486:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:487:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription1132);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:511:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:512:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:513:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1168);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1178); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:520:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:523:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:524:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:524:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:524:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:524:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:525:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:525:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:526:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1220); 

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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:543:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:543:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:544:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:544:1: (otherlv_1= RULE_ID )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:545:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement1251); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:564:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:565:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:566:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath1287);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath1297); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:573:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:576:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:577:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:577:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:577:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:577:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:578:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:578:1: (otherlv_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:579:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath1342); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:590:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:590:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleReferencePath1355); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:594:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:595:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:595:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:596:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath1376);
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:624:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:625:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:626:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1418);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1429); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:633:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:636:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:637:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:637:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:637:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1469); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:644:1: (kw= '.' this_ID_2= RULE_ID )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==19) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:645:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,19,FOLLOW_19_in_ruleQualifiedName1488); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName1503); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop10;
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


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:665:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:666:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:667:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1551);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1562); 

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
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:674:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:677:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:678:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:678:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:679:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard1609);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:689:1: (kw= '.*' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==20) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:690:2: kw= '.*'
                    {
                    kw=(Token)match(input,20,FOLLOW_20_in_ruleQualifiedNameWithWildcard1628); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
                        

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
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:705:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:706:2: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:707:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef1673);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef1684); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:714:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:717:28: (this_ID_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:718:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef1723); 

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
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories221 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRequirementCategories268 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRequirementCategories280 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRequirementCategories292 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories313 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleRequirementCategories326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategories372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleHazardCategories409 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleHazardCategories421 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleHazardCategories433 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_ruleHazardCategories454 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleHazardCategories467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategories_in_entryRuleVerificationCategories503 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategories513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVerificationCategories550 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleVerificationCategories562 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleVerificationCategories574 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_ruleVerificationCategories595 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleVerificationCategories608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleRequirementCategory693 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategory710 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleRequirementCategory728 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleRequirementCategory751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory789 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategory799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleHazardCategory836 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazardCategory853 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleHazardCategory871 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleHazardCategory894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory932 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleVerificationCategory979 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationCategory996 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleVerificationCategory1014 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCatRef_in_ruleVerificationCategory1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription1077 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription1132 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath1287 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath1297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath1342 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleReferencePath1355 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath1376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1418 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1469 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleQualifiedName1488 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName1503 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1551 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard1609 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleQualifiedNameWithWildcard1628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef1673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef1684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef1723 = new BitSet(new long[]{0x0000000000000002L});

}