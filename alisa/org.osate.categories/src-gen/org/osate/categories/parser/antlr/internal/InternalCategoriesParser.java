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
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */
@SuppressWarnings("all")
public class InternalCategoriesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Any", "FullStop", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int FullStop=5;
    public static final int RULE_ID=8;
    public static final int RULE_WS=13;
    public static final int RULE_STRING=10;
    public static final int RULE_ANY_OTHER=14;
    public static final int Any=4;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_INT=9;
    public static final int RULE_ML_COMMENT=11;
    public static final int LeftSquareBracket=6;
    public static final int EOF=-1;
    public static final int RightSquareBracket=7;

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
    		return "CategoriesDefinitions";	
    	} 
    	   	   	
    	@Override
    	protected CategoriesGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleCategoriesDefinitions"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:73:1: entryRuleCategoriesDefinitions returns [EObject current=null] : iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF ;
    public final EObject entryRuleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategoriesDefinitions = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:74:2: (iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:75:2: iv_ruleCategoriesDefinitions= ruleCategoriesDefinitions EOF
            {
             newCompositeNode(grammarAccess.getCategoriesDefinitionsRule()); 
            pushFollow(FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions67);
            iv_ruleCategoriesDefinitions=ruleCategoriesDefinitions();

            state._fsp--;

             current =iv_ruleCategoriesDefinitions; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategoriesDefinitions77); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:82:1: ruleCategoriesDefinitions returns [EObject current=null] : ( (lv_categories_0_0= ruleCategories ) )* ;
    public final EObject ruleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject lv_categories_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:85:28: ( ( (lv_categories_0_0= ruleCategories ) )* )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:86:1: ( (lv_categories_0_0= ruleCategories ) )*
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:86:1: ( (lv_categories_0_0= ruleCategories ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:87:1: (lv_categories_0_0= ruleCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:87:1: (lv_categories_0_0= ruleCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:3: lv_categories_0_0= ruleCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCategories_in_ruleCategoriesDefinitions122);
            	    lv_categories_0_0=ruleCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"categories",
            	            		lv_categories_0_0, 
            	            		"Categories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "ruleCategoriesDefinitions"


    // $ANTLR start "entryRuleCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:112:1: entryRuleCategories returns [EObject current=null] : iv_ruleCategories= ruleCategories EOF ;
    public final EObject entryRuleCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:113:2: (iv_ruleCategories= ruleCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:114:2: iv_ruleCategories= ruleCategories EOF
            {
             newCompositeNode(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_ruleCategories_in_entryRuleCategories157);
            iv_ruleCategories=ruleCategories();

            state._fsp--;

             current =iv_ruleCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategories167); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:121:1: ruleCategories returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket ) ;
    public final EObject ruleCategories() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_category_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:124:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= LeftSquareBracket ( (lv_category_2_0= ruleCategory ) )+ otherlv_3= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:2: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:126:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:126:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:127:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCategories209); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCategoriesRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleCategories227); 

                	newLeafNode(otherlv_1, grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:148:1: ( (lv_category_2_0= ruleCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:149:1: (lv_category_2_0= ruleCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:149:1: (lv_category_2_0= ruleCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:150:3: lv_category_2_0= ruleCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCategory_in_ruleCategories247);
            	    lv_category_2_0=ruleCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_2_0, 
            	            		"Category");
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

            otherlv_3=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleCategories261); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:179:1: entryRuleCategory returns [EObject current=null] : iv_ruleCategory= ruleCategory EOF ;
    public final EObject entryRuleCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:180:2: (iv_ruleCategory= ruleCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:181:2: iv_ruleCategory= ruleCategory EOF
            {
             newCompositeNode(grammarAccess.getCategoryRule()); 
            pushFollow(FOLLOW_ruleCategory_in_entryRuleCategory295);
            iv_ruleCategory=ruleCategory();

            state._fsp--;

             current =iv_ruleCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategory305); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:188:1: ruleCategory returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:191:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:192:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:192:1: ( (lv_name_0_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:193:1: (lv_name_0_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:193:1: (lv_name_0_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:194:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCategory346); 

            			newLeafNode(lv_name_0_0, grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

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


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:220:1: entryRuleCatRef returns [String current=null] : iv_ruleCatRef= ruleCatRef EOF ;
    public final String entryRuleCatRef() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCatRef = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:221:1: (iv_ruleCatRef= ruleCatRef EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:222:2: iv_ruleCatRef= ruleCatRef EOF
            {
             newCompositeNode(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef388);
            iv_ruleCatRef=ruleCatRef();

            state._fsp--;

             current =iv_ruleCatRef.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef399); 

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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:229:1: ruleCatRef returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleCatRef() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:233:6: ( (this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:234:1: (this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:234:1: (this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:234:6: this_ID_0= RULE_ID kw= FullStop this_ID_2= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef439); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); 
                
            kw=(Token)match(input,FullStop,FOLLOW_FullStop_in_ruleCatRef457); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getCatRefAccess().getFullStopKeyword_1()); 
                
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCatRef472); 

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


 

    public static final BitSet FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoriesDefinitions77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategories_in_ruleCategoriesDefinitions122 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleCategories_in_entryRuleCategories157 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategories167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCategories209 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleCategories227 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ruleCategory_in_ruleCategories247 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleCategories261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategory_in_entryRuleCategory295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategory305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCategory346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef388 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef439 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_FullStop_in_ruleCatRef457 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCatRef472 = new BitSet(new long[]{0x0000000000000002L});

}