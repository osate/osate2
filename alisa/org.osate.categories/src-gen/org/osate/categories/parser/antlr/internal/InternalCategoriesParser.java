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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requirement'", "'categories'", "'{'", "'}'", "'hazard'", "'category'", "'extends'", "'.'"
    };
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:76:1: ruleCategories returns [EObject current=null] : (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories ) ;
    public final EObject ruleCategories() throws RecognitionException {
        EObject current = null;

        EObject this_RequirementCategories_0 = null;

        EObject this_HazardCategories_1 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:79:28: ( (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:80:1: (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:80:1: (this_RequirementCategories_0= ruleRequirementCategories | this_HazardCategories_1= ruleHazardCategories )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:107:1: entryRuleRequirementCategories returns [EObject current=null] : iv_ruleRequirementCategories= ruleRequirementCategories EOF ;
    public final EObject entryRuleRequirementCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:108:2: (iv_ruleRequirementCategories= ruleRequirementCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:109:2: iv_ruleRequirementCategories= ruleRequirementCategories EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoriesRule()); 
            pushFollow(FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories194);
            iv_ruleRequirementCategories=ruleRequirementCategories();

            state._fsp--;

             current =iv_ruleRequirementCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategories204); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:116:1: ruleRequirementCategories returns [EObject current=null] : (otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= '}' ) ;
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:119:28: ( (otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= '}' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:120:1: (otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= '}' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:120:1: (otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= '}' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:120:3: otherlv_0= 'requirement' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleRequirementCategory ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleRequirementCategories241); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementCategoriesAccess().getRequirementKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleRequirementCategories253); 

                	newLeafNode(otherlv_1, grammarAccess.getRequirementCategoriesAccess().getCategoriesKeyword_1());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:128:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:129:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:129:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:130:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategories270); 

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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleRequirementCategories287); 

                	newLeafNode(otherlv_3, grammarAccess.getRequirementCategoriesAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:150:1: ( (lv_category_4_0= ruleRequirementCategory ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:151:1: (lv_category_4_0= ruleRequirementCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:151:1: (lv_category_4_0= ruleRequirementCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:152:3: lv_category_4_0= ruleRequirementCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getRequirementCategoriesAccess().getCategoryRequirementCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories308);
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleRequirementCategories321); 

                	newLeafNode(otherlv_5, grammarAccess.getRequirementCategoriesAccess().getRightCurlyBracketKeyword_5());
                

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:180:1: entryRuleHazardCategories returns [EObject current=null] : iv_ruleHazardCategories= ruleHazardCategories EOF ;
    public final EObject entryRuleHazardCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazardCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:181:2: (iv_ruleHazardCategories= ruleHazardCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:182:2: iv_ruleHazardCategories= ruleHazardCategories EOF
            {
             newCompositeNode(grammarAccess.getHazardCategoriesRule()); 
            pushFollow(FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories357);
            iv_ruleHazardCategories=ruleHazardCategories();

            state._fsp--;

             current =iv_ruleHazardCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategories367); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:189:1: ruleHazardCategories returns [EObject current=null] : (otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= '}' ) ;
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
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:192:28: ( (otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= '}' ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:193:1: (otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= '}' )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:193:1: (otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= '}' )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:193:3: otherlv_0= 'hazard' otherlv_1= 'categories' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (lv_category_4_0= ruleHazardCategory ) )+ otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_ruleHazardCategories404); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardCategoriesAccess().getHazardKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleHazardCategories416); 

                	newLeafNode(otherlv_1, grammarAccess.getHazardCategoriesAccess().getCategoriesKeyword_1());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:201:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:202:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:202:1: (lv_name_2_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:203:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazardCategories433); 

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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleHazardCategories450); 

                	newLeafNode(otherlv_3, grammarAccess.getHazardCategoriesAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:223:1: ( (lv_category_4_0= ruleHazardCategory ) )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==16) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:224:1: (lv_category_4_0= ruleHazardCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:224:1: (lv_category_4_0= ruleHazardCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:225:3: lv_category_4_0= ruleHazardCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getHazardCategoriesAccess().getCategoryHazardCategoryParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleHazardCategory_in_ruleHazardCategories471);
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

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleHazardCategories484); 

                	newLeafNode(otherlv_5, grammarAccess.getHazardCategoriesAccess().getRightCurlyBracketKeyword_5());
                

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


    // $ANTLR start "entryRuleRequirementCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:255:1: entryRuleRequirementCategory returns [EObject current=null] : iv_ruleRequirementCategory= ruleRequirementCategory EOF ;
    public final EObject entryRuleRequirementCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequirementCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:256:2: (iv_ruleRequirementCategory= ruleRequirementCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:257:2: iv_ruleRequirementCategory= ruleRequirementCategory EOF
            {
             newCompositeNode(grammarAccess.getRequirementCategoryRule()); 
            pushFollow(FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory522);
            iv_ruleRequirementCategory=ruleRequirementCategory();

            state._fsp--;

             current =iv_ruleRequirementCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRequirementCategory532); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:264:1: ruleRequirementCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) ;
    public final EObject ruleRequirementCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:267:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:268:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:268:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:268:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleRequirementCategory569); 

                	newLeafNode(otherlv_0, grammarAccess.getRequirementCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:272:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:273:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:273:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:274:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRequirementCategory586); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:290:2: (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:290:4: otherlv_2= 'extends' ( ( ruleCATREF ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleRequirementCategory604); 

                        	newLeafNode(otherlv_2, grammarAccess.getRequirementCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:294:1: ( ( ruleCATREF ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:295:1: ( ruleCATREF )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:295:1: ( ruleCATREF )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:296:3: ruleCATREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRequirementCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getRequirementCategoryAccess().getExtendsRequirementCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCATREF_in_ruleRequirementCategory627);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:317:1: entryRuleHazardCategory returns [EObject current=null] : iv_ruleHazardCategory= ruleHazardCategory EOF ;
    public final EObject entryRuleHazardCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHazardCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:318:2: (iv_ruleHazardCategory= ruleHazardCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:319:2: iv_ruleHazardCategory= ruleHazardCategory EOF
            {
             newCompositeNode(grammarAccess.getHazardCategoryRule()); 
            pushFollow(FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory665);
            iv_ruleHazardCategory=ruleHazardCategory();

            state._fsp--;

             current =iv_ruleHazardCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHazardCategory675); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:326:1: ruleHazardCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) ;
    public final EObject ruleHazardCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:329:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:330:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:330:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:330:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleHazardCategory712); 

                	newLeafNode(otherlv_0, grammarAccess.getHazardCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:334:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:335:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:335:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:336:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleHazardCategory729); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:352:2: (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==17) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:352:4: otherlv_2= 'extends' ( ( ruleCATREF ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleHazardCategory747); 

                        	newLeafNode(otherlv_2, grammarAccess.getHazardCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:356:1: ( ( ruleCATREF ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:357:1: ( ruleCATREF )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:357:1: ( ruleCATREF )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:358:3: ruleCATREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getHazardCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getHazardCategoryAccess().getExtendsHazardCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCATREF_in_ruleHazardCategory770);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:379:1: entryRuleVerificationCategory returns [EObject current=null] : iv_ruleVerificationCategory= ruleVerificationCategory EOF ;
    public final EObject entryRuleVerificationCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVerificationCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:380:2: (iv_ruleVerificationCategory= ruleVerificationCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:381:2: iv_ruleVerificationCategory= ruleVerificationCategory EOF
            {
             newCompositeNode(grammarAccess.getVerificationCategoryRule()); 
            pushFollow(FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory808);
            iv_ruleVerificationCategory=ruleVerificationCategory();

            state._fsp--;

             current =iv_ruleVerificationCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVerificationCategory818); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:388:1: ruleVerificationCategory returns [EObject current=null] : (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) ;
    public final EObject ruleVerificationCategory() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:391:28: ( (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:392:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:392:1: (otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )? )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:392:3: otherlv_0= 'category' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleVerificationCategory855); 

                	newLeafNode(otherlv_0, grammarAccess.getVerificationCategoryAccess().getCategoryKeyword_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:396:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:397:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:397:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:398:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVerificationCategory872); 

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

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:414:2: (otherlv_2= 'extends' ( ( ruleCATREF ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:414:4: otherlv_2= 'extends' ( ( ruleCATREF ) )
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleVerificationCategory890); 

                        	newLeafNode(otherlv_2, grammarAccess.getVerificationCategoryAccess().getExtendsKeyword_2_0());
                        
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:418:1: ( ( ruleCATREF ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:419:1: ( ruleCATREF )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:419:1: ( ruleCATREF )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:420:3: ruleCATREF
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getVerificationCategoryRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getVerificationCategoryAccess().getExtendsVerificationCategoryCrossReference_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCATREF_in_ruleVerificationCategory913);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:443:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:444:2: (iv_ruleDescription= ruleDescription EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:445:2: iv_ruleDescription= ruleDescription EOF
            {
             newCompositeNode(grammarAccess.getDescriptionRule()); 
            pushFollow(FOLLOW_ruleDescription_in_entryRuleDescription953);
            iv_ruleDescription=ruleDescription();

            state._fsp--;

             current =iv_ruleDescription; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescription963); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:452:1: ruleDescription returns [EObject current=null] : ( (lv_description_0_0= ruleDescriptionElement ) )+ ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        EObject lv_description_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:455:28: ( ( (lv_description_0_0= ruleDescriptionElement ) )+ )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:456:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:456:1: ( (lv_description_0_0= ruleDescriptionElement ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_ID && LA7_0<=RULE_STRING)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:457:1: (lv_description_0_0= ruleDescriptionElement )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:457:1: (lv_description_0_0= ruleDescriptionElement )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:458:3: lv_description_0_0= ruleDescriptionElement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDescriptionElement_in_ruleDescription1008);
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
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:482:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:483:2: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:484:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
             newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            pushFollow(FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1044);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;

             current =iv_ruleDescriptionElement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDescriptionElement1054); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:491:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:494:28: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:495:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:495:1: ( ( (lv_text_0_0= RULE_STRING ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:495:2: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:495:2: ( (lv_text_0_0= RULE_STRING ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:496:1: (lv_text_0_0= RULE_STRING )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:496:1: (lv_text_0_0= RULE_STRING )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:497:3: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDescriptionElement1096); 

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
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:514:6: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:514:6: ( (otherlv_1= RULE_ID ) )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:515:1: (otherlv_1= RULE_ID )
                    {
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:515:1: (otherlv_1= RULE_ID )
                    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:516:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getDescriptionElementRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDescriptionElement1127); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:535:1: entryRuleReferencePath returns [EObject current=null] : iv_ruleReferencePath= ruleReferencePath EOF ;
    public final EObject entryRuleReferencePath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferencePath = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:536:2: (iv_ruleReferencePath= ruleReferencePath EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:537:2: iv_ruleReferencePath= ruleReferencePath EOF
            {
             newCompositeNode(grammarAccess.getReferencePathRule()); 
            pushFollow(FOLLOW_ruleReferencePath_in_entryRuleReferencePath1163);
            iv_ruleReferencePath=ruleReferencePath();

            state._fsp--;

             current =iv_ruleReferencePath; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferencePath1173); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:544:1: ruleReferencePath returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) ;
    public final EObject ruleReferencePath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_subpath_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:547:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:548:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:548:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:548:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:548:2: ( (otherlv_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:549:1: (otherlv_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:549:1: (otherlv_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:550:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferencePathRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferencePath1218); 

            		newLeafNode(otherlv_0, grammarAccess.getReferencePathAccess().getRefEObjectCrossReference_0_0()); 
            	

            }


            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:561:2: (otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:561:4: otherlv_1= '.' ( (lv_subpath_2_0= ruleReferencePath ) )
            {
            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleReferencePath1231); 

                	newLeafNode(otherlv_1, grammarAccess.getReferencePathAccess().getFullStopKeyword_1_0());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:565:1: ( (lv_subpath_2_0= ruleReferencePath ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:566:1: (lv_subpath_2_0= ruleReferencePath )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:566:1: (lv_subpath_2_0= ruleReferencePath )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:567:3: lv_subpath_2_0= ruleReferencePath
            {
             
            	        newCompositeNode(grammarAccess.getReferencePathAccess().getSubpathReferencePathParserRuleCall_1_1_0()); 
            	    
            pushFollow(FOLLOW_ruleReferencePath_in_ruleReferencePath1252);
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:597:1: entryRuleCATREF returns [String current=null] : iv_ruleCATREF= ruleCATREF EOF ;
    public final String entryRuleCATREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCATREF = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:598:2: (iv_ruleCATREF= ruleCATREF EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:599:2: iv_ruleCATREF= ruleCATREF EOF
            {
             newCompositeNode(grammarAccess.getCATREFRule()); 
            pushFollow(FOLLOW_ruleCATREF_in_entryRuleCATREF1296);
            iv_ruleCATREF=ruleCATREF();

            state._fsp--;

             current =iv_ruleCATREF.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCATREF1307); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:606:1: ruleCATREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleCATREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:609:28: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:610:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:610:1: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategories.g:610:6: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCATREF1347); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getCATREFAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,18,FOLLOW_18_in_ruleCATREF1365); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getCATREFAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCATREF1380); 

            		current.merge(this_ID_2);
                
             
                newLeafNode(this_ID_2, grammarAccess.getCATREFAccess().getIDTerminalRuleCall_2()); 
                

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
    public static final BitSet FOLLOW_ruleRequirementCategories_in_entryRuleRequirementCategories194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategories204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleRequirementCategories241 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleRequirementCategories253 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategories270 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRequirementCategories287 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_ruleRequirementCategories308 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleRequirementCategories321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategories_in_entryRuleHazardCategories357 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategories367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleHazardCategories404 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleHazardCategories416 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazardCategories433 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleHazardCategories450 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_ruleHazardCategories471 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_14_in_ruleHazardCategories484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRequirementCategory_in_entryRuleRequirementCategory522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRequirementCategory532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleRequirementCategory569 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRequirementCategory586 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleRequirementCategory604 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleRequirementCategory627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHazardCategory_in_entryRuleHazardCategory665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHazardCategory675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleHazardCategory712 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleHazardCategory729 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleHazardCategory747 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleHazardCategory770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVerificationCategory_in_entryRuleVerificationCategory808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVerificationCategory818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleVerificationCategory855 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVerificationCategory872 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleVerificationCategory890 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleCATREF_in_ruleVerificationCategory913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescription_in_entryRuleDescription953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescription963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_ruleDescription1008 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_ruleDescriptionElement_in_entryRuleDescriptionElement1044 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDescriptionElement1054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDescriptionElement1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDescriptionElement1127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferencePath_in_entryRuleReferencePath1163 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferencePath1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferencePath1218 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleReferencePath1231 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleReferencePath_in_ruleReferencePath1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCATREF_in_entryRuleCATREF1296 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCATREF1307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCATREF1347 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleCATREF1365 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCATREF1380 = new BitSet(new long[]{0x0000000000000002L});

}