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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Category", "Quality", "Phase", "Any", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int Category=4;
    public static final int Phase=6;
    public static final int RULE_ID=10;
    public static final int RULE_WS=15;
    public static final int RULE_STRING=12;
    public static final int RULE_ANY_OTHER=16;
    public static final int Any=7;
    public static final int RULE_SL_COMMENT=14;
    public static final int Quality=5;
    public static final int RULE_INT=11;
    public static final int RULE_ML_COMMENT=13;
    public static final int LeftSquareBracket=8;
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
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:82:1: ruleCategoriesDefinitions returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )* ) ) ) ;
    public final EObject ruleCategoriesDefinitions() throws RecognitionException {
        EObject current = null;

        EObject lv_userCategories_1_0 = null;

        EObject lv_phaseCategories_2_0 = null;

        EObject lv_qualityCategories_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:85:28: ( ( ( ( ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )* ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:86:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )* ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:86:1: ( ( ( ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )* ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:1: ( ( ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )* ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:88:1: ( ( ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )* ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:89:2: ( ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )* )
            {
             
            	  getUnorderedGroupHelper().enter(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:92:2: ( ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )* )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:93:3: ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )*
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:93:3: ( ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) ) )*
            loop1:
            do {
                int alt1=4;
                int LA1_0 = input.LA(1);

                if ( LA1_0 ==Category && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
                    alt1=1;
                }
                else if ( LA1_0 ==Phase && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
                    alt1=2;
                }
                else if ( LA1_0 ==Quality && getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
                    alt1=3;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:95:4: ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:95:4: ({...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:96:5: {...}? => ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:96:116: ( ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:97:6: ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 0);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:6: ({...}? => ( (lv_userCategories_1_0= ruleUserCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:7: {...}? => ( (lv_userCategories_1_0= ruleUserCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:100:16: ( (lv_userCategories_1_0= ruleUserCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:101:1: (lv_userCategories_1_0= ruleUserCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:101:1: (lv_userCategories_1_0= ruleUserCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:102:3: lv_userCategories_1_0= ruleUserCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getUserCategoriesUserCategoriesParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUserCategories_in_ruleCategoriesDefinitions167);
            	    lv_userCategories_1_0=ruleUserCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"userCategories",
            	            		lv_userCategories_1_0, 
            	            		"UserCategories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:4: ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:125:4: ({...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:126:5: {...}? => ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:126:116: ( ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:127:6: ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 1);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:6: ({...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:7: {...}? => ( (lv_phaseCategories_2_0= rulePhaseCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:130:16: ( (lv_phaseCategories_2_0= rulePhaseCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:131:1: (lv_phaseCategories_2_0= rulePhaseCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:131:1: (lv_phaseCategories_2_0= rulePhaseCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:132:3: lv_phaseCategories_2_0= rulePhaseCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getPhaseCategoriesPhaseCategoriesParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePhaseCategories_in_ruleCategoriesDefinitions242);
            	    lv_phaseCategories_2_0=rulePhaseCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"phaseCategories",
            	            		lv_phaseCategories_2_0, 
            	            		"PhaseCategories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:155:4: ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:155:4: ({...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:156:5: {...}? => ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "getUnorderedGroupHelper().canSelect(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2)");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:156:116: ( ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:157:6: ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) )
            	    {
            	     
            	    	 				  getUnorderedGroupHelper().select(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup(), 2);
            	    	 				
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:6: ({...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:7: {...}? => ( (lv_qualityCategories_3_0= ruleQualityCategories ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleCategoriesDefinitions", "true");
            	    }
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:160:16: ( (lv_qualityCategories_3_0= ruleQualityCategories ) )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:161:1: (lv_qualityCategories_3_0= ruleQualityCategories )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:161:1: (lv_qualityCategories_3_0= ruleQualityCategories )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:162:3: lv_qualityCategories_3_0= ruleQualityCategories
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCategoriesDefinitionsAccess().getQualityCategoriesQualityCategoriesParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualityCategories_in_ruleCategoriesDefinitions317);
            	    lv_qualityCategories_3_0=ruleQualityCategories();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCategoriesDefinitionsRule());
            	    	        }
            	           		set(
            	           			current, 
            	           			"qualityCategories",
            	            		lv_qualityCategories_3_0, 
            	            		"QualityCategories");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }

            	     
            	    	 				  getUnorderedGroupHelper().returnFromSelection(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	    	 				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             
            	  getUnorderedGroupHelper().leave(grammarAccess.getCategoriesDefinitionsAccess().getUnorderedGroup());
            	

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


    // $ANTLR start "entryRuleUserCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:200:1: entryRuleUserCategories returns [EObject current=null] : iv_ruleUserCategories= ruleUserCategories EOF ;
    public final EObject entryRuleUserCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:201:2: (iv_ruleUserCategories= ruleUserCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:202:2: iv_ruleUserCategories= ruleUserCategories EOF
            {
             newCompositeNode(grammarAccess.getUserCategoriesRule()); 
            pushFollow(FOLLOW_ruleUserCategories_in_entryRuleUserCategories391);
            iv_ruleUserCategories=ruleUserCategories();

            state._fsp--;

             current =iv_ruleUserCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserCategories401); 

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
    // $ANTLR end "entryRuleUserCategories"


    // $ANTLR start "ruleUserCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:209:1: ruleUserCategories returns [EObject current=null] : ( () otherlv_1= Category otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleUserCategory ) )+ otherlv_4= RightSquareBracket ) ;
    public final EObject ruleUserCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:212:28: ( ( () otherlv_1= Category otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleUserCategory ) )+ otherlv_4= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:213:1: ( () otherlv_1= Category otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleUserCategory ) )+ otherlv_4= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:213:1: ( () otherlv_1= Category otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleUserCategory ) )+ otherlv_4= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:213:2: () otherlv_1= Category otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleUserCategory ) )+ otherlv_4= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:213:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:214:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUserCategoriesAccess().getUserCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Category,FOLLOW_Category_in_ruleUserCategories448); 

                	newLeafNode(otherlv_1, grammarAccess.getUserCategoriesAccess().getCategoryKeyword_1());
                
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleUserCategories460); 

                	newLeafNode(otherlv_2, grammarAccess.getUserCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:229:1: ( (lv_category_3_0= ruleUserCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:230:1: (lv_category_3_0= ruleUserCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:230:1: (lv_category_3_0= ruleUserCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:231:3: lv_category_3_0= ruleUserCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getUserCategoriesAccess().getCategoryUserCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleUserCategory_in_ruleUserCategories480);
            	    lv_category_3_0=ruleUserCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getUserCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"UserCategory");
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

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleUserCategories494); 

                	newLeafNode(otherlv_4, grammarAccess.getUserCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleUserCategories"


    // $ANTLR start "entryRuleQualityCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:260:1: entryRuleQualityCategories returns [EObject current=null] : iv_ruleQualityCategories= ruleQualityCategories EOF ;
    public final EObject entryRuleQualityCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:261:2: (iv_ruleQualityCategories= ruleQualityCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:262:2: iv_ruleQualityCategories= ruleQualityCategories EOF
            {
             newCompositeNode(grammarAccess.getQualityCategoriesRule()); 
            pushFollow(FOLLOW_ruleQualityCategories_in_entryRuleQualityCategories528);
            iv_ruleQualityCategories=ruleQualityCategories();

            state._fsp--;

             current =iv_ruleQualityCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategories538); 

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
    // $ANTLR end "entryRuleQualityCategories"


    // $ANTLR start "ruleQualityCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:269:1: ruleQualityCategories returns [EObject current=null] : ( () otherlv_1= Quality otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleQualityCategory ) )+ otherlv_4= RightSquareBracket ) ;
    public final EObject ruleQualityCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:272:28: ( ( () otherlv_1= Quality otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleQualityCategory ) )+ otherlv_4= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:273:1: ( () otherlv_1= Quality otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleQualityCategory ) )+ otherlv_4= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:273:1: ( () otherlv_1= Quality otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleQualityCategory ) )+ otherlv_4= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:273:2: () otherlv_1= Quality otherlv_2= LeftSquareBracket ( (lv_category_3_0= ruleQualityCategory ) )+ otherlv_4= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:273:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:274:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getQualityCategoriesAccess().getQualityCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Quality,FOLLOW_Quality_in_ruleQualityCategories585); 

                	newLeafNode(otherlv_1, grammarAccess.getQualityCategoriesAccess().getQualityKeyword_1());
                
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_ruleQualityCategories597); 

                	newLeafNode(otherlv_2, grammarAccess.getQualityCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:289:1: ( (lv_category_3_0= ruleQualityCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:290:1: (lv_category_3_0= ruleQualityCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:290:1: (lv_category_3_0= ruleQualityCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:291:3: lv_category_3_0= ruleQualityCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getQualityCategoriesAccess().getCategoryQualityCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualityCategory_in_ruleQualityCategories617);
            	    lv_category_3_0=ruleQualityCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getQualityCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"QualityCategory");
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

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_ruleQualityCategories631); 

                	newLeafNode(otherlv_4, grammarAccess.getQualityCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "ruleQualityCategories"


    // $ANTLR start "entryRulePhaseCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:320:1: entryRulePhaseCategories returns [EObject current=null] : iv_rulePhaseCategories= rulePhaseCategories EOF ;
    public final EObject entryRulePhaseCategories() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhaseCategories = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:321:2: (iv_rulePhaseCategories= rulePhaseCategories EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:322:2: iv_rulePhaseCategories= rulePhaseCategories EOF
            {
             newCompositeNode(grammarAccess.getPhaseCategoriesRule()); 
            pushFollow(FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories665);
            iv_rulePhaseCategories=rulePhaseCategories();

            state._fsp--;

             current =iv_rulePhaseCategories; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategories675); 

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
    // $ANTLR end "entryRulePhaseCategories"


    // $ANTLR start "rulePhaseCategories"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:329:1: rulePhaseCategories returns [EObject current=null] : ( () otherlv_1= Phase otherlv_2= LeftSquareBracket ( (lv_category_3_0= rulePhaseCategory ) )+ otherlv_4= RightSquareBracket ) ;
    public final EObject rulePhaseCategories() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_category_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:332:28: ( ( () otherlv_1= Phase otherlv_2= LeftSquareBracket ( (lv_category_3_0= rulePhaseCategory ) )+ otherlv_4= RightSquareBracket ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:333:1: ( () otherlv_1= Phase otherlv_2= LeftSquareBracket ( (lv_category_3_0= rulePhaseCategory ) )+ otherlv_4= RightSquareBracket )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:333:1: ( () otherlv_1= Phase otherlv_2= LeftSquareBracket ( (lv_category_3_0= rulePhaseCategory ) )+ otherlv_4= RightSquareBracket )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:333:2: () otherlv_1= Phase otherlv_2= LeftSquareBracket ( (lv_category_3_0= rulePhaseCategory ) )+ otherlv_4= RightSquareBracket
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:333:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:334:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPhaseCategoriesAccess().getPhaseCategoriesAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,Phase,FOLLOW_Phase_in_rulePhaseCategories722); 

                	newLeafNode(otherlv_1, grammarAccess.getPhaseCategoriesAccess().getPhaseKeyword_1());
                
            otherlv_2=(Token)match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rulePhaseCategories734); 

                	newLeafNode(otherlv_2, grammarAccess.getPhaseCategoriesAccess().getLeftSquareBracketKeyword_2());
                
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:349:1: ( (lv_category_3_0= rulePhaseCategory ) )+
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
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:350:1: (lv_category_3_0= rulePhaseCategory )
            	    {
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:350:1: (lv_category_3_0= rulePhaseCategory )
            	    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:351:3: lv_category_3_0= rulePhaseCategory
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPhaseCategoriesAccess().getCategoryPhaseCategoryParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePhaseCategory_in_rulePhaseCategories754);
            	    lv_category_3_0=rulePhaseCategory();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPhaseCategoriesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"category",
            	            		lv_category_3_0, 
            	            		"PhaseCategory");
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

            otherlv_4=(Token)match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rulePhaseCategories768); 

                	newLeafNode(otherlv_4, grammarAccess.getPhaseCategoriesAccess().getRightSquareBracketKeyword_4());
                

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
    // $ANTLR end "rulePhaseCategories"


    // $ANTLR start "entryRuleUserCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:380:1: entryRuleUserCategory returns [EObject current=null] : iv_ruleUserCategory= ruleUserCategory EOF ;
    public final EObject entryRuleUserCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUserCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:381:2: (iv_ruleUserCategory= ruleUserCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:382:2: iv_ruleUserCategory= ruleUserCategory EOF
            {
             newCompositeNode(grammarAccess.getUserCategoryRule()); 
            pushFollow(FOLLOW_ruleUserCategory_in_entryRuleUserCategory802);
            iv_ruleUserCategory=ruleUserCategory();

            state._fsp--;

             current =iv_ruleUserCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUserCategory812); 

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
    // $ANTLR end "entryRuleUserCategory"


    // $ANTLR start "ruleUserCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:389:1: ruleUserCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleUserCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:392:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:393:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:393:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:393:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:393:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:394:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUserCategoryAccess().getUserCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:399:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:400:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:400:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:401:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleUserCategory863); 

            			newLeafNode(lv_name_1_0, grammarAccess.getUserCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUserCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleUserCategory"


    // $ANTLR start "entryRuleQualityCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:425:1: entryRuleQualityCategory returns [EObject current=null] : iv_ruleQualityCategory= ruleQualityCategory EOF ;
    public final EObject entryRuleQualityCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualityCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:426:2: (iv_ruleQualityCategory= ruleQualityCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:427:2: iv_ruleQualityCategory= ruleQualityCategory EOF
            {
             newCompositeNode(grammarAccess.getQualityCategoryRule()); 
            pushFollow(FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory903);
            iv_ruleQualityCategory=ruleQualityCategory();

            state._fsp--;

             current =iv_ruleQualityCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualityCategory913); 

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
    // $ANTLR end "entryRuleQualityCategory"


    // $ANTLR start "ruleQualityCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:434:1: ruleQualityCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleQualityCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:437:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:438:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:438:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:438:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:438:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:439:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getQualityCategoryAccess().getQualityCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:444:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:445:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:445:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:446:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualityCategory964); 

            			newLeafNode(lv_name_1_0, grammarAccess.getQualityCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getQualityCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "ruleQualityCategory"


    // $ANTLR start "entryRulePhaseCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:470:1: entryRulePhaseCategory returns [EObject current=null] : iv_rulePhaseCategory= rulePhaseCategory EOF ;
    public final EObject entryRulePhaseCategory() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhaseCategory = null;


        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:471:2: (iv_rulePhaseCategory= rulePhaseCategory EOF )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:472:2: iv_rulePhaseCategory= rulePhaseCategory EOF
            {
             newCompositeNode(grammarAccess.getPhaseCategoryRule()); 
            pushFollow(FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory1004);
            iv_rulePhaseCategory=rulePhaseCategory();

            state._fsp--;

             current =iv_rulePhaseCategory; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePhaseCategory1014); 

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
    // $ANTLR end "entryRulePhaseCategory"


    // $ANTLR start "rulePhaseCategory"
    // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:479:1: rulePhaseCategory returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulePhaseCategory() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:482:28: ( ( () ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:483:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:483:1: ( () ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:483:2: () ( (lv_name_1_0= RULE_ID ) )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:483:2: ()
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:484:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPhaseCategoryAccess().getPhaseCategoryAction_0(),
                        current);
                

            }

            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:489:2: ( (lv_name_1_0= RULE_ID ) )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:490:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:490:1: (lv_name_1_0= RULE_ID )
            // ../org.osate.categories/src-gen/org/osate/categories/parser/antlr/internal/InternalCategoriesParser.g:491:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePhaseCategory1065); 

            			newLeafNode(lv_name_1_0, grammarAccess.getPhaseCategoryAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getPhaseCategoryRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

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
    // $ANTLR end "rulePhaseCategory"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoriesDefinitions77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserCategories_in_ruleCategoriesDefinitions167 = new BitSet(new long[]{0x0000000000000072L});
    public static final BitSet FOLLOW_rulePhaseCategories_in_ruleCategoriesDefinitions242 = new BitSet(new long[]{0x0000000000000072L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_ruleCategoriesDefinitions317 = new BitSet(new long[]{0x0000000000000072L});
    public static final BitSet FOLLOW_ruleUserCategories_in_entryRuleUserCategories391 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserCategories401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Category_in_ruleUserCategories448 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleUserCategories460 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ruleUserCategory_in_ruleUserCategories480 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleUserCategories494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategories_in_entryRuleQualityCategories528 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategories538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Quality_in_ruleQualityCategories585 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_ruleQualityCategories597 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_ruleQualityCategories617 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RightSquareBracket_in_ruleQualityCategories631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategories_in_entryRulePhaseCategories665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategories675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Phase_in_rulePhaseCategories722 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rulePhaseCategories734 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_rulePhaseCategories754 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rulePhaseCategories768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUserCategory_in_entryRuleUserCategory802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUserCategory812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleUserCategory863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualityCategory_in_entryRuleQualityCategory903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualityCategory913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualityCategory964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePhaseCategory_in_entryRulePhaseCategory1004 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePhaseCategory1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePhaseCategory1065 = new BitSet(new long[]{0x0000000000000002L});

}
