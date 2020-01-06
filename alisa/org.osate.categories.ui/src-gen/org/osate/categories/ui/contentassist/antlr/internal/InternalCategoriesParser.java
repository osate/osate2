package org.osate.categories.ui.contentassist.antlr.internal; 

import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
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
public class InternalCategoriesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Filter", "Any", "FullStop", "LeftSquareBracket", "RightSquareBracket", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int FullStop=6;
    public static final int RULE_ID=9;
    public static final int RULE_WS=14;
    public static final int RULE_STRING=11;
    public static final int RULE_ANY_OTHER=15;
    public static final int Any=5;
    public static final int RULE_SL_COMMENT=13;
    public static final int Filter=4;
    public static final int RULE_INT=10;
    public static final int RULE_ML_COMMENT=12;
    public static final int LeftSquareBracket=7;
    public static final int EOF=-1;
    public static final int RightSquareBracket=8;

    // delegates
    // delegators


        public InternalCategoriesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCategoriesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCategoriesParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCategoriesParser.g"; }


     
     	private CategoriesGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
    		tokenNameToValue.put("Any", "'any'");
    		tokenNameToValue.put("Filter", "'filter'");
     	}
     	
        public void setGrammarAccess(CategoriesGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }

    	@Override
        protected String getValueForTokenName(String tokenName) {
        	String result = tokenNameToValue.get(tokenName);
        	if (result == null)
        		result = tokenName;
        	return result;
        }



    // $ANTLR start "entryRuleCategoriesDefinitions"
    // InternalCategoriesParser.g:88:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:89:1: ( ruleCategoriesDefinitions EOF )
            // InternalCategoriesParser.g:90:1: ruleCategoriesDefinitions EOF
            {
             before(grammarAccess.getCategoriesDefinitionsRule()); 
            pushFollow(FOLLOW_1);
            ruleCategoriesDefinitions();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCategoriesDefinitions"


    // $ANTLR start "ruleCategoriesDefinitions"
    // InternalCategoriesParser.g:97:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__Group__0 ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:101:5: ( ( ( rule__CategoriesDefinitions__Group__0 ) ) )
            // InternalCategoriesParser.g:102:1: ( ( rule__CategoriesDefinitions__Group__0 ) )
            {
            // InternalCategoriesParser.g:102:1: ( ( rule__CategoriesDefinitions__Group__0 ) )
            // InternalCategoriesParser.g:103:1: ( rule__CategoriesDefinitions__Group__0 )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getGroup()); 
            // InternalCategoriesParser.g:104:1: ( rule__CategoriesDefinitions__Group__0 )
            // InternalCategoriesParser.g:104:2: rule__CategoriesDefinitions__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CategoriesDefinitions__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesDefinitionsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategoriesDefinitions"


    // $ANTLR start "entryRuleCategories"
    // InternalCategoriesParser.g:116:1: entryRuleCategories : ruleCategories EOF ;
    public final void entryRuleCategories() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:117:1: ( ruleCategories EOF )
            // InternalCategoriesParser.g:118:1: ruleCategories EOF
            {
             before(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_1);
            ruleCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCategories"


    // $ANTLR start "ruleCategories"
    // InternalCategoriesParser.g:125:1: ruleCategories : ( ( rule__Categories__Group__0 ) ) ;
    public final void ruleCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:129:5: ( ( ( rule__Categories__Group__0 ) ) )
            // InternalCategoriesParser.g:130:1: ( ( rule__Categories__Group__0 ) )
            {
            // InternalCategoriesParser.g:130:1: ( ( rule__Categories__Group__0 ) )
            // InternalCategoriesParser.g:131:1: ( rule__Categories__Group__0 )
            {
             before(grammarAccess.getCategoriesAccess().getGroup()); 
            // InternalCategoriesParser.g:132:1: ( rule__Categories__Group__0 )
            // InternalCategoriesParser.g:132:2: rule__Categories__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Categories__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategories"


    // $ANTLR start "entryRuleCategory"
    // InternalCategoriesParser.g:144:1: entryRuleCategory : ruleCategory EOF ;
    public final void entryRuleCategory() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:145:1: ( ruleCategory EOF )
            // InternalCategoriesParser.g:146:1: ruleCategory EOF
            {
             before(grammarAccess.getCategoryRule()); 
            pushFollow(FOLLOW_1);
            ruleCategory();

            state._fsp--;

             after(grammarAccess.getCategoryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCategory"


    // $ANTLR start "ruleCategory"
    // InternalCategoriesParser.g:153:1: ruleCategory : ( ( rule__Category__NameAssignment ) ) ;
    public final void ruleCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:157:5: ( ( ( rule__Category__NameAssignment ) ) )
            // InternalCategoriesParser.g:158:1: ( ( rule__Category__NameAssignment ) )
            {
            // InternalCategoriesParser.g:158:1: ( ( rule__Category__NameAssignment ) )
            // InternalCategoriesParser.g:159:1: ( rule__Category__NameAssignment )
            {
             before(grammarAccess.getCategoryAccess().getNameAssignment()); 
            // InternalCategoriesParser.g:160:1: ( rule__Category__NameAssignment )
            // InternalCategoriesParser.g:160:2: rule__Category__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__Category__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getCategoryAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategory"


    // $ANTLR start "entryRuleCategoryFilter"
    // InternalCategoriesParser.g:172:1: entryRuleCategoryFilter : ruleCategoryFilter EOF ;
    public final void entryRuleCategoryFilter() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:173:1: ( ruleCategoryFilter EOF )
            // InternalCategoriesParser.g:174:1: ruleCategoryFilter EOF
            {
             before(grammarAccess.getCategoryFilterRule()); 
            pushFollow(FOLLOW_1);
            ruleCategoryFilter();

            state._fsp--;

             after(grammarAccess.getCategoryFilterRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCategoryFilter"


    // $ANTLR start "ruleCategoryFilter"
    // InternalCategoriesParser.g:181:1: ruleCategoryFilter : ( ( rule__CategoryFilter__Group__0 ) ) ;
    public final void ruleCategoryFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:185:5: ( ( ( rule__CategoryFilter__Group__0 ) ) )
            // InternalCategoriesParser.g:186:1: ( ( rule__CategoryFilter__Group__0 ) )
            {
            // InternalCategoriesParser.g:186:1: ( ( rule__CategoryFilter__Group__0 ) )
            // InternalCategoriesParser.g:187:1: ( rule__CategoryFilter__Group__0 )
            {
             before(grammarAccess.getCategoryFilterAccess().getGroup()); 
            // InternalCategoriesParser.g:188:1: ( rule__CategoryFilter__Group__0 )
            // InternalCategoriesParser.g:188:2: rule__CategoryFilter__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CategoryFilter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCategoryFilterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCategoryFilter"


    // $ANTLR start "entryRuleCatRef"
    // InternalCategoriesParser.g:200:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:201:1: ( ruleCatRef EOF )
            // InternalCategoriesParser.g:202:1: ruleCatRef EOF
            {
             before(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_1);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCatRefRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCatRef"


    // $ANTLR start "ruleCatRef"
    // InternalCategoriesParser.g:209:1: ruleCatRef : ( ( rule__CatRef__Group__0 ) ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:213:5: ( ( ( rule__CatRef__Group__0 ) ) )
            // InternalCategoriesParser.g:214:1: ( ( rule__CatRef__Group__0 ) )
            {
            // InternalCategoriesParser.g:214:1: ( ( rule__CatRef__Group__0 ) )
            // InternalCategoriesParser.g:215:1: ( rule__CatRef__Group__0 )
            {
             before(grammarAccess.getCatRefAccess().getGroup()); 
            // InternalCategoriesParser.g:216:1: ( rule__CatRef__Group__0 )
            // InternalCategoriesParser.g:216:2: rule__CatRef__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CatRef__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCatRefAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCatRef"


    // $ANTLR start "rule__CategoriesDefinitions__Group__0"
    // InternalCategoriesParser.g:230:1: rule__CategoriesDefinitions__Group__0 : rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1 ;
    public final void rule__CategoriesDefinitions__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:234:1: ( rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1 )
            // InternalCategoriesParser.g:235:2: rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__CategoriesDefinitions__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CategoriesDefinitions__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__Group__0"


    // $ANTLR start "rule__CategoriesDefinitions__Group__0__Impl"
    // InternalCategoriesParser.g:242:1: rule__CategoriesDefinitions__Group__0__Impl : ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* ) ;
    public final void rule__CategoriesDefinitions__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:246:1: ( ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* ) )
            // InternalCategoriesParser.g:247:1: ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* )
            {
            // InternalCategoriesParser.g:247:1: ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* )
            // InternalCategoriesParser.g:248:1: ( rule__CategoriesDefinitions__CategoriesAssignment_0 )*
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment_0()); 
            // InternalCategoriesParser.g:249:1: ( rule__CategoriesDefinitions__CategoriesAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCategoriesParser.g:249:2: rule__CategoriesDefinitions__CategoriesAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__CategoriesDefinitions__CategoriesAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__Group__0__Impl"


    // $ANTLR start "rule__CategoriesDefinitions__Group__1"
    // InternalCategoriesParser.g:259:1: rule__CategoriesDefinitions__Group__1 : rule__CategoriesDefinitions__Group__1__Impl ;
    public final void rule__CategoriesDefinitions__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:263:1: ( rule__CategoriesDefinitions__Group__1__Impl )
            // InternalCategoriesParser.g:264:2: rule__CategoriesDefinitions__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CategoriesDefinitions__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__Group__1"


    // $ANTLR start "rule__CategoriesDefinitions__Group__1__Impl"
    // InternalCategoriesParser.g:270:1: rule__CategoriesDefinitions__Group__1__Impl : ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* ) ;
    public final void rule__CategoriesDefinitions__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:274:1: ( ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* ) )
            // InternalCategoriesParser.g:275:1: ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* )
            {
            // InternalCategoriesParser.g:275:1: ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* )
            // InternalCategoriesParser.g:276:1: ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )*
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersAssignment_1()); 
            // InternalCategoriesParser.g:277:1: ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Filter) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCategoriesParser.g:277:2: rule__CategoriesDefinitions__CategoryFiltersAssignment_1
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__CategoriesDefinitions__CategoryFiltersAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

             after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__Group__1__Impl"


    // $ANTLR start "rule__Categories__Group__0"
    // InternalCategoriesParser.g:291:1: rule__Categories__Group__0 : rule__Categories__Group__0__Impl rule__Categories__Group__1 ;
    public final void rule__Categories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:295:1: ( rule__Categories__Group__0__Impl rule__Categories__Group__1 )
            // InternalCategoriesParser.g:296:2: rule__Categories__Group__0__Impl rule__Categories__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__Categories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Categories__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__Group__0"


    // $ANTLR start "rule__Categories__Group__0__Impl"
    // InternalCategoriesParser.g:303:1: rule__Categories__Group__0__Impl : ( ( rule__Categories__NameAssignment_0 ) ) ;
    public final void rule__Categories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:307:1: ( ( ( rule__Categories__NameAssignment_0 ) ) )
            // InternalCategoriesParser.g:308:1: ( ( rule__Categories__NameAssignment_0 ) )
            {
            // InternalCategoriesParser.g:308:1: ( ( rule__Categories__NameAssignment_0 ) )
            // InternalCategoriesParser.g:309:1: ( rule__Categories__NameAssignment_0 )
            {
             before(grammarAccess.getCategoriesAccess().getNameAssignment_0()); 
            // InternalCategoriesParser.g:310:1: ( rule__Categories__NameAssignment_0 )
            // InternalCategoriesParser.g:310:2: rule__Categories__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Categories__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__Group__0__Impl"


    // $ANTLR start "rule__Categories__Group__1"
    // InternalCategoriesParser.g:320:1: rule__Categories__Group__1 : rule__Categories__Group__1__Impl rule__Categories__Group__2 ;
    public final void rule__Categories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:324:1: ( rule__Categories__Group__1__Impl rule__Categories__Group__2 )
            // InternalCategoriesParser.g:325:2: rule__Categories__Group__1__Impl rule__Categories__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__Categories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Categories__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__Group__1"


    // $ANTLR start "rule__Categories__Group__1__Impl"
    // InternalCategoriesParser.g:332:1: rule__Categories__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__Categories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:336:1: ( ( LeftSquareBracket ) )
            // InternalCategoriesParser.g:337:1: ( LeftSquareBracket )
            {
            // InternalCategoriesParser.g:337:1: ( LeftSquareBracket )
            // InternalCategoriesParser.g:338:1: LeftSquareBracket
            {
             before(grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__Group__1__Impl"


    // $ANTLR start "rule__Categories__Group__2"
    // InternalCategoriesParser.g:351:1: rule__Categories__Group__2 : rule__Categories__Group__2__Impl rule__Categories__Group__3 ;
    public final void rule__Categories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:355:1: ( rule__Categories__Group__2__Impl rule__Categories__Group__3 )
            // InternalCategoriesParser.g:356:2: rule__Categories__Group__2__Impl rule__Categories__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Categories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Categories__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__Group__2"


    // $ANTLR start "rule__Categories__Group__2__Impl"
    // InternalCategoriesParser.g:363:1: rule__Categories__Group__2__Impl : ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) ) ;
    public final void rule__Categories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:367:1: ( ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) ) )
            // InternalCategoriesParser.g:368:1: ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) )
            {
            // InternalCategoriesParser.g:368:1: ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) )
            // InternalCategoriesParser.g:369:1: ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* )
            {
            // InternalCategoriesParser.g:369:1: ( ( rule__Categories__CategoryAssignment_2 ) )
            // InternalCategoriesParser.g:370:1: ( rule__Categories__CategoryAssignment_2 )
            {
             before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 
            // InternalCategoriesParser.g:371:1: ( rule__Categories__CategoryAssignment_2 )
            // InternalCategoriesParser.g:371:2: rule__Categories__CategoryAssignment_2
            {
            pushFollow(FOLLOW_4);
            rule__Categories__CategoryAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 

            }

            // InternalCategoriesParser.g:374:1: ( ( rule__Categories__CategoryAssignment_2 )* )
            // InternalCategoriesParser.g:375:1: ( rule__Categories__CategoryAssignment_2 )*
            {
             before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 
            // InternalCategoriesParser.g:376:1: ( rule__Categories__CategoryAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCategoriesParser.g:376:2: rule__Categories__CategoryAssignment_2
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Categories__CategoryAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__Group__2__Impl"


    // $ANTLR start "rule__Categories__Group__3"
    // InternalCategoriesParser.g:387:1: rule__Categories__Group__3 : rule__Categories__Group__3__Impl ;
    public final void rule__Categories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:391:1: ( rule__Categories__Group__3__Impl )
            // InternalCategoriesParser.g:392:2: rule__Categories__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Categories__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__Group__3"


    // $ANTLR start "rule__Categories__Group__3__Impl"
    // InternalCategoriesParser.g:398:1: rule__Categories__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Categories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:402:1: ( ( RightSquareBracket ) )
            // InternalCategoriesParser.g:403:1: ( RightSquareBracket )
            {
            // InternalCategoriesParser.g:403:1: ( RightSquareBracket )
            // InternalCategoriesParser.g:404:1: RightSquareBracket
            {
             before(grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__Group__3__Impl"


    // $ANTLR start "rule__CategoryFilter__Group__0"
    // InternalCategoriesParser.g:425:1: rule__CategoryFilter__Group__0 : rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1 ;
    public final void rule__CategoryFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:429:1: ( rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1 )
            // InternalCategoriesParser.g:430:2: rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__CategoryFilter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CategoryFilter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__0"


    // $ANTLR start "rule__CategoryFilter__Group__0__Impl"
    // InternalCategoriesParser.g:437:1: rule__CategoryFilter__Group__0__Impl : ( Filter ) ;
    public final void rule__CategoryFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:441:1: ( ( Filter ) )
            // InternalCategoriesParser.g:442:1: ( Filter )
            {
            // InternalCategoriesParser.g:442:1: ( Filter )
            // InternalCategoriesParser.g:443:1: Filter
            {
             before(grammarAccess.getCategoryFilterAccess().getFilterKeyword_0()); 
            match(input,Filter,FOLLOW_2); 
             after(grammarAccess.getCategoryFilterAccess().getFilterKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__0__Impl"


    // $ANTLR start "rule__CategoryFilter__Group__1"
    // InternalCategoriesParser.g:456:1: rule__CategoryFilter__Group__1 : rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2 ;
    public final void rule__CategoryFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:460:1: ( rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2 )
            // InternalCategoriesParser.g:461:2: rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__CategoryFilter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CategoryFilter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__1"


    // $ANTLR start "rule__CategoryFilter__Group__1__Impl"
    // InternalCategoriesParser.g:468:1: rule__CategoryFilter__Group__1__Impl : ( ( rule__CategoryFilter__NameAssignment_1 ) ) ;
    public final void rule__CategoryFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:472:1: ( ( ( rule__CategoryFilter__NameAssignment_1 ) ) )
            // InternalCategoriesParser.g:473:1: ( ( rule__CategoryFilter__NameAssignment_1 ) )
            {
            // InternalCategoriesParser.g:473:1: ( ( rule__CategoryFilter__NameAssignment_1 ) )
            // InternalCategoriesParser.g:474:1: ( rule__CategoryFilter__NameAssignment_1 )
            {
             before(grammarAccess.getCategoryFilterAccess().getNameAssignment_1()); 
            // InternalCategoriesParser.g:475:1: ( rule__CategoryFilter__NameAssignment_1 )
            // InternalCategoriesParser.g:475:2: rule__CategoryFilter__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__CategoryFilter__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCategoryFilterAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__1__Impl"


    // $ANTLR start "rule__CategoryFilter__Group__2"
    // InternalCategoriesParser.g:485:1: rule__CategoryFilter__Group__2 : rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3 ;
    public final void rule__CategoryFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:489:1: ( rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3 )
            // InternalCategoriesParser.g:490:2: rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3
            {
            pushFollow(FOLLOW_9);
            rule__CategoryFilter__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CategoryFilter__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__2"


    // $ANTLR start "rule__CategoryFilter__Group__2__Impl"
    // InternalCategoriesParser.g:497:1: rule__CategoryFilter__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__CategoryFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:501:1: ( ( LeftSquareBracket ) )
            // InternalCategoriesParser.g:502:1: ( LeftSquareBracket )
            {
            // InternalCategoriesParser.g:502:1: ( LeftSquareBracket )
            // InternalCategoriesParser.g:503:1: LeftSquareBracket
            {
             before(grammarAccess.getCategoryFilterAccess().getLeftSquareBracketKeyword_2()); 
            match(input,LeftSquareBracket,FOLLOW_2); 
             after(grammarAccess.getCategoryFilterAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__2__Impl"


    // $ANTLR start "rule__CategoryFilter__Group__3"
    // InternalCategoriesParser.g:516:1: rule__CategoryFilter__Group__3 : rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4 ;
    public final void rule__CategoryFilter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:520:1: ( rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4 )
            // InternalCategoriesParser.g:521:2: rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__CategoryFilter__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CategoryFilter__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__3"


    // $ANTLR start "rule__CategoryFilter__Group__3__Impl"
    // InternalCategoriesParser.g:528:1: rule__CategoryFilter__Group__3__Impl : ( ( rule__CategoryFilter__CategoryAssignment_3 )* ) ;
    public final void rule__CategoryFilter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:532:1: ( ( ( rule__CategoryFilter__CategoryAssignment_3 )* ) )
            // InternalCategoriesParser.g:533:1: ( ( rule__CategoryFilter__CategoryAssignment_3 )* )
            {
            // InternalCategoriesParser.g:533:1: ( ( rule__CategoryFilter__CategoryAssignment_3 )* )
            // InternalCategoriesParser.g:534:1: ( rule__CategoryFilter__CategoryAssignment_3 )*
            {
             before(grammarAccess.getCategoryFilterAccess().getCategoryAssignment_3()); 
            // InternalCategoriesParser.g:535:1: ( rule__CategoryFilter__CategoryAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCategoriesParser.g:535:2: rule__CategoryFilter__CategoryAssignment_3
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__CategoryFilter__CategoryAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getCategoryFilterAccess().getCategoryAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__3__Impl"


    // $ANTLR start "rule__CategoryFilter__Group__4"
    // InternalCategoriesParser.g:545:1: rule__CategoryFilter__Group__4 : rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5 ;
    public final void rule__CategoryFilter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:549:1: ( rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5 )
            // InternalCategoriesParser.g:550:2: rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5
            {
            pushFollow(FOLLOW_9);
            rule__CategoryFilter__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CategoryFilter__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__4"


    // $ANTLR start "rule__CategoryFilter__Group__4__Impl"
    // InternalCategoriesParser.g:557:1: rule__CategoryFilter__Group__4__Impl : ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? ) ;
    public final void rule__CategoryFilter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:561:1: ( ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? ) )
            // InternalCategoriesParser.g:562:1: ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? )
            {
            // InternalCategoriesParser.g:562:1: ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? )
            // InternalCategoriesParser.g:563:1: ( rule__CategoryFilter__AnyCategoryAssignment_4 )?
            {
             before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAssignment_4()); 
            // InternalCategoriesParser.g:564:1: ( rule__CategoryFilter__AnyCategoryAssignment_4 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Any) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalCategoriesParser.g:564:2: rule__CategoryFilter__AnyCategoryAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__CategoryFilter__AnyCategoryAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCategoryFilterAccess().getAnyCategoryAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__4__Impl"


    // $ANTLR start "rule__CategoryFilter__Group__5"
    // InternalCategoriesParser.g:574:1: rule__CategoryFilter__Group__5 : rule__CategoryFilter__Group__5__Impl ;
    public final void rule__CategoryFilter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:578:1: ( rule__CategoryFilter__Group__5__Impl )
            // InternalCategoriesParser.g:579:2: rule__CategoryFilter__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CategoryFilter__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__5"


    // $ANTLR start "rule__CategoryFilter__Group__5__Impl"
    // InternalCategoriesParser.g:585:1: rule__CategoryFilter__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__CategoryFilter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:589:1: ( ( RightSquareBracket ) )
            // InternalCategoriesParser.g:590:1: ( RightSquareBracket )
            {
            // InternalCategoriesParser.g:590:1: ( RightSquareBracket )
            // InternalCategoriesParser.g:591:1: RightSquareBracket
            {
             before(grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_5()); 
            match(input,RightSquareBracket,FOLLOW_2); 
             after(grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__Group__5__Impl"


    // $ANTLR start "rule__CatRef__Group__0"
    // InternalCategoriesParser.g:616:1: rule__CatRef__Group__0 : rule__CatRef__Group__0__Impl rule__CatRef__Group__1 ;
    public final void rule__CatRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:620:1: ( rule__CatRef__Group__0__Impl rule__CatRef__Group__1 )
            // InternalCategoriesParser.g:621:2: rule__CatRef__Group__0__Impl rule__CatRef__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__CatRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CatRef__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CatRef__Group__0"


    // $ANTLR start "rule__CatRef__Group__0__Impl"
    // InternalCategoriesParser.g:628:1: rule__CatRef__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__CatRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:632:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:633:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:633:1: ( RULE_ID )
            // InternalCategoriesParser.g:634:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CatRef__Group__0__Impl"


    // $ANTLR start "rule__CatRef__Group__1"
    // InternalCategoriesParser.g:645:1: rule__CatRef__Group__1 : rule__CatRef__Group__1__Impl rule__CatRef__Group__2 ;
    public final void rule__CatRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:649:1: ( rule__CatRef__Group__1__Impl rule__CatRef__Group__2 )
            // InternalCategoriesParser.g:650:2: rule__CatRef__Group__1__Impl rule__CatRef__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__CatRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CatRef__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CatRef__Group__1"


    // $ANTLR start "rule__CatRef__Group__1__Impl"
    // InternalCategoriesParser.g:657:1: rule__CatRef__Group__1__Impl : ( FullStop ) ;
    public final void rule__CatRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:661:1: ( ( FullStop ) )
            // InternalCategoriesParser.g:662:1: ( FullStop )
            {
            // InternalCategoriesParser.g:662:1: ( FullStop )
            // InternalCategoriesParser.g:663:1: FullStop
            {
             before(grammarAccess.getCatRefAccess().getFullStopKeyword_1()); 
            match(input,FullStop,FOLLOW_2); 
             after(grammarAccess.getCatRefAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CatRef__Group__1__Impl"


    // $ANTLR start "rule__CatRef__Group__2"
    // InternalCategoriesParser.g:676:1: rule__CatRef__Group__2 : rule__CatRef__Group__2__Impl ;
    public final void rule__CatRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:680:1: ( rule__CatRef__Group__2__Impl )
            // InternalCategoriesParser.g:681:2: rule__CatRef__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CatRef__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CatRef__Group__2"


    // $ANTLR start "rule__CatRef__Group__2__Impl"
    // InternalCategoriesParser.g:687:1: rule__CatRef__Group__2__Impl : ( RULE_ID ) ;
    public final void rule__CatRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:691:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:692:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:692:1: ( RULE_ID )
            // InternalCategoriesParser.g:693:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CatRef__Group__2__Impl"


    // $ANTLR start "rule__CategoriesDefinitions__CategoriesAssignment_0"
    // InternalCategoriesParser.g:711:1: rule__CategoriesDefinitions__CategoriesAssignment_0 : ( ruleCategories ) ;
    public final void rule__CategoriesDefinitions__CategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:715:1: ( ( ruleCategories ) )
            // InternalCategoriesParser.g:716:1: ( ruleCategories )
            {
            // InternalCategoriesParser.g:716:1: ( ruleCategories )
            // InternalCategoriesParser.g:717:1: ruleCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__CategoriesAssignment_0"


    // $ANTLR start "rule__CategoriesDefinitions__CategoryFiltersAssignment_1"
    // InternalCategoriesParser.g:726:1: rule__CategoriesDefinitions__CategoryFiltersAssignment_1 : ( ruleCategoryFilter ) ;
    public final void rule__CategoriesDefinitions__CategoryFiltersAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:730:1: ( ( ruleCategoryFilter ) )
            // InternalCategoriesParser.g:731:1: ( ruleCategoryFilter )
            {
            // InternalCategoriesParser.g:731:1: ( ruleCategoryFilter )
            // InternalCategoriesParser.g:732:1: ruleCategoryFilter
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersCategoryFilterParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCategoryFilter();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersCategoryFilterParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoriesDefinitions__CategoryFiltersAssignment_1"


    // $ANTLR start "rule__Categories__NameAssignment_0"
    // InternalCategoriesParser.g:741:1: rule__Categories__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Categories__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:745:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:746:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:746:1: ( RULE_ID )
            // InternalCategoriesParser.g:747:1: RULE_ID
            {
             before(grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__NameAssignment_0"


    // $ANTLR start "rule__Categories__CategoryAssignment_2"
    // InternalCategoriesParser.g:756:1: rule__Categories__CategoryAssignment_2 : ( ruleCategory ) ;
    public final void rule__Categories__CategoryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:760:1: ( ( ruleCategory ) )
            // InternalCategoriesParser.g:761:1: ( ruleCategory )
            {
            // InternalCategoriesParser.g:761:1: ( ruleCategory )
            // InternalCategoriesParser.g:762:1: ruleCategory
            {
             before(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleCategory();

            state._fsp--;

             after(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Categories__CategoryAssignment_2"


    // $ANTLR start "rule__Category__NameAssignment"
    // InternalCategoriesParser.g:771:1: rule__Category__NameAssignment : ( RULE_ID ) ;
    public final void rule__Category__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:775:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:776:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:776:1: ( RULE_ID )
            // InternalCategoriesParser.g:777:1: RULE_ID
            {
             before(grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Category__NameAssignment"


    // $ANTLR start "rule__CategoryFilter__NameAssignment_1"
    // InternalCategoriesParser.g:786:1: rule__CategoryFilter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CategoryFilter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:790:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:791:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:791:1: ( RULE_ID )
            // InternalCategoriesParser.g:792:1: RULE_ID
            {
             before(grammarAccess.getCategoryFilterAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getCategoryFilterAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__NameAssignment_1"


    // $ANTLR start "rule__CategoryFilter__CategoryAssignment_3"
    // InternalCategoriesParser.g:801:1: rule__CategoryFilter__CategoryAssignment_3 : ( ( ruleCatRef ) ) ;
    public final void rule__CategoryFilter__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:805:1: ( ( ( ruleCatRef ) ) )
            // InternalCategoriesParser.g:806:1: ( ( ruleCatRef ) )
            {
            // InternalCategoriesParser.g:806:1: ( ( ruleCatRef ) )
            // InternalCategoriesParser.g:807:1: ( ruleCatRef )
            {
             before(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0()); 
            // InternalCategoriesParser.g:808:1: ( ruleCatRef )
            // InternalCategoriesParser.g:809:1: ruleCatRef
            {
             before(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCatRefParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_2);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCatRefParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__CategoryAssignment_3"


    // $ANTLR start "rule__CategoryFilter__AnyCategoryAssignment_4"
    // InternalCategoriesParser.g:820:1: rule__CategoryFilter__AnyCategoryAssignment_4 : ( ( Any ) ) ;
    public final void rule__CategoryFilter__AnyCategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:824:1: ( ( ( Any ) ) )
            // InternalCategoriesParser.g:825:1: ( ( Any ) )
            {
            // InternalCategoriesParser.g:825:1: ( ( Any ) )
            // InternalCategoriesParser.g:826:1: ( Any )
            {
             before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); 
            // InternalCategoriesParser.g:827:1: ( Any )
            // InternalCategoriesParser.g:828:1: Any
            {
             before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); 
            match(input,Any,FOLLOW_2); 
             after(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); 

            }

             after(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CategoryFilter__AnyCategoryAssignment_4"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000320L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000040L});

}