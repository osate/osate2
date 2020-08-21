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

/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
@SuppressWarnings("all")
public class InternalCategoriesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'filter'", "'any'", "'.'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_WS=9;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__15=15;
    public static final int RULE_INT=5;
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
    public String getGrammarFileName() { return "InternalCategories.g"; }



     	private CategoriesGrammarAccess grammarAccess;

        public InternalCategoriesParser(TokenStream input, CategoriesGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "CategoriesDefinitions";
       	}

       	@Override
       	protected CategoriesGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleCategoriesDefinitions"
    // InternalCategories.g:84:1: entryRuleCategoriesDefinitions returns [EObject current=null] : iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF ;
    public final EObject entryRuleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoriesDefinitions = null;


        try {
            // InternalCategories.g:84:62: (iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF )
            // InternalCategories.g:85:2: iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF
            {
             newCompositeNode(grammarAccess.getCategoriesDefinitionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategoriesDefinitions=ruleCategoriesDefinitions();

            state._fsp--;

             current =iv_ruleCategoriesDefinitions; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCategoriesDefinitions"


    // $ANTLR start "ruleCategoriesDefinitions"
    // InternalCategories.g:91:1: ruleCategoriesDefinitions returns [EObject current=null] : ( ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )* ) ;
    public final EObject ruleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject lv_categories_0_0 = null;

        EObject lv_categoryFilters_1_0 = null;



        	enterRule();

        try {
            // InternalCategories.g:97:2: ( ( ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )* ) )
            // InternalCategories.g:98:2: ( ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )* )
            {
            // InternalCategories.g:98:2: ( ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )* )
            // InternalCategories.g:99:3: ( (lv_categories_0_0= ruleCategories ) )* ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )*
            {
            // InternalCategories.g:99:3: ( (lv_categories_0_0= ruleCategories ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCategories.g:100:4: (lv_categories_0_0= ruleCategories )
            	    {
            	    // InternalCategories.g:100:4: (lv_categories_0_0= ruleCategories )
            	    // InternalCategories.g:101:5: lv_categories_0_0= ruleCategories
            	    {

            	    					newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_categories_0_0=ruleCategories();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"categories",
            	    						lv_categories_0_0,
            	    						"org.osate.categories.Categories.Categories");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalCategories.g:118:3: ( (lv_categoryFilters_1_0= ruleCategoryFilter ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCategories.g:119:4: (lv_categoryFilters_1_0= ruleCategoryFilter )
            	    {
            	    // InternalCategories.g:119:4: (lv_categoryFilters_1_0= ruleCategoryFilter )
            	    // InternalCategories.g:120:5: lv_categoryFilters_1_0= ruleCategoryFilter
            	    {

            	    					newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersCategoryFilterParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_4);
            	    lv_categoryFilters_1_0=ruleCategoryFilter();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"categoryFilters",
            	    						lv_categoryFilters_1_0,
            	    						"org.osate.categories.Categories.CategoryFilter");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // $ANTLR end "ruleCategoriesDefinitions"


    // $ANTLR start "entryRuleCategories"
    // InternalCategories.g:141:1: entryRuleCategories returns [EObject current=null] : iv_ruleCategories= ruleCategories EOF ;
    public final EObject entryRuleCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategories = null;


        try {
            // InternalCategories.g:141:51: (iv_ruleCategories= ruleCategories EOF )
            // InternalCategories.g:142:2: iv_ruleCategories= ruleCategories EOF
            {
             newCompositeNode(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategories=ruleCategories();

            state._fsp--;

             current =iv_ruleCategories; 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCategories.g:148:1: ruleCategories returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= ']' ) ;
    public final EObject ruleCategories() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_category_2_0 = null;



        	enterRule();

        try {
            // InternalCategories.g:154:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= ']' ) )
            // InternalCategories.g:155:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= ']' )
            {
            // InternalCategories.g:155:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= ']' )
            // InternalCategories.g:156:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= ']'
            {
            // InternalCategories.g:156:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalCategories.g:157:4: (lv_name_0_0= RULE_ID )
            {
            // InternalCategories.g:157:4: (lv_name_0_0= RULE_ID )
            // InternalCategories.g:158:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_0_0, grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCategoriesRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalCategories.g:178:3: ( (lv_category_2_0= ruleCategory ) )+
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
            	    // InternalCategories.g:179:4: (lv_category_2_0= ruleCategory )
            	    {
            	    // InternalCategories.g:179:4: (lv_category_2_0= ruleCategory )
            	    // InternalCategories.g:180:5: lv_category_2_0= ruleCategory
            	    {

            	    					newCompositeNode(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_7);
            	    lv_category_2_0=ruleCategory();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getCategoriesRule());
            	    					}
            	    					add(
            	    						current,
            	    						"category",
            	    						lv_category_2_0,
            	    						"org.osate.categories.Categories.Category");
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

            otherlv_3=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3());
            		

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


    // $ANTLR start "entryRuleCategory"
    // InternalCategories.g:205:1: entryRuleCategory returns [EObject current=null] : iv_ruleCategory= ruleCategory EOF ;
    public final EObject entryRuleCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategory = null;


        try {
            // InternalCategories.g:205:49: (iv_ruleCategory= ruleCategory EOF )
            // InternalCategories.g:206:2: iv_ruleCategory= ruleCategory EOF
            {
             newCompositeNode(grammarAccess.getCategoryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategory=ruleCategory();

            state._fsp--;

             current =iv_ruleCategory; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCategory"


    // $ANTLR start "ruleCategory"
    // InternalCategories.g:212:1: ruleCategory returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalCategories.g:218:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalCategories.g:219:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalCategories.g:219:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalCategories.g:220:3: (lv_name_0_0= RULE_ID )
            {
            // InternalCategories.g:220:3: (lv_name_0_0= RULE_ID )
            // InternalCategories.g:221:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getCategoryRule());
            				}
            				setWithLastConsumed(
            					current,
            					"name",
            					lv_name_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

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
    // $ANTLR end "ruleCategory"


    // $ANTLR start "entryRuleCategoryFilter"
    // InternalCategories.g:240:1: entryRuleCategoryFilter returns [EObject current=null] : iv_ruleCategoryFilter= ruleCategoryFilter EOF ;
    public final EObject entryRuleCategoryFilter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoryFilter = null;


        try {
            // InternalCategories.g:240:55: (iv_ruleCategoryFilter= ruleCategoryFilter EOF )
            // InternalCategories.g:241:2: iv_ruleCategoryFilter= ruleCategoryFilter EOF
            {
             newCompositeNode(grammarAccess.getCategoryFilterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCategoryFilter=ruleCategoryFilter();

            state._fsp--;

             current =iv_ruleCategoryFilter; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleCategoryFilter"


    // $ANTLR start "ruleCategoryFilter"
    // InternalCategories.g:247:1: ruleCategoryFilter returns [EObject current=null] : (otherlv_0= 'filter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= 'any' ) )? otherlv_5= ']' ) ;
    public final EObject ruleCategoryFilter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_anyCategory_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalCategories.g:253:2: ( (otherlv_0= 'filter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= 'any' ) )? otherlv_5= ']' ) )
            // InternalCategories.g:254:2: (otherlv_0= 'filter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= 'any' ) )? otherlv_5= ']' )
            {
            // InternalCategories.g:254:2: (otherlv_0= 'filter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= 'any' ) )? otherlv_5= ']' )
            // InternalCategories.g:255:3: otherlv_0= 'filter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '[' ( ( ruleCatRef ) )* ( (lv_anyCategory_4_0= 'any' ) )? otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getCategoryFilterAccess().getFilterKeyword_0());
            		
            // InternalCategories.g:259:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalCategories.g:260:4: (lv_name_1_0= RULE_ID )
            {
            // InternalCategories.g:260:4: (lv_name_1_0= RULE_ID )
            // InternalCategories.g:261:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getCategoryFilterAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCategoryFilterRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_8); 

            			newLeafNode(otherlv_2, grammarAccess.getCategoryFilterAccess().getLeftSquareBracketKeyword_2());
            		
            // InternalCategories.g:281:3: ( ( ruleCatRef ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCategories.g:282:4: ( ruleCatRef )
            	    {
            	    // InternalCategories.g:282:4: ( ruleCatRef )
            	    // InternalCategories.g:283:5: ruleCatRef
            	    {

            	    					if (current==null) {
            	    						current = createModelElement(grammarAccess.getCategoryFilterRule());
            	    					}
            	    				

            	    					newCompositeNode(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0());
            	    				
            	    pushFollow(FOLLOW_8);
            	    ruleCatRef();

            	    state._fsp--;


            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            // InternalCategories.g:297:3: ( (lv_anyCategory_4_0= 'any' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalCategories.g:298:4: (lv_anyCategory_4_0= 'any' )
                    {
                    // InternalCategories.g:298:4: (lv_anyCategory_4_0= 'any' )
                    // InternalCategories.g:299:5: lv_anyCategory_4_0= 'any'
                    {
                    lv_anyCategory_4_0=(Token)match(input,14,FOLLOW_9); 

                    					newLeafNode(lv_anyCategory_4_0, grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getCategoryFilterRule());
                    					}
                    					setWithLastConsumed(current, "anyCategory", true, "any");
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,12,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_5());
            		

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
    // $ANTLR end "ruleCategoryFilter"


    // $ANTLR start "entryRuleCatRef"
    // InternalCategories.g:319:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // InternalCategories.g:319:46: (iv_ruleCatRef= ruleCatRef EOF )
            // InternalCategories.g:320:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_2); 

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
    // InternalCategories.g:326:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalCategories.g:332:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) )
            // InternalCategories.g:333:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            {
            // InternalCategories.g:333:2: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
            // InternalCategories.g:334:3: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_10); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0());
            		
            kw=(Token)match(input,15,FOLLOW_6); 

            			current.merge(kw);
            			newLeafNode(kw, grammarAccess.getCatRefAccess().getFullStopKeyword_1());
            		
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); 

            			current.merge(this_ID_2);
            		

            			newLeafNode(this_ID_2, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2());
            		

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
    // $ANTLR end "ruleCatRef"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000005010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008000L});

}