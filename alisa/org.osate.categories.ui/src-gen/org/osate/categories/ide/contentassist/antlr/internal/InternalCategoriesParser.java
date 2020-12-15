package org.osate.categories.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'filter'", "'.'", "'any'"
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

    	public void setGrammarAccess(CategoriesGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleCategoriesDefinitions"
    // InternalCategories.g:73:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // InternalCategories.g:74:1: ( ruleCategoriesDefinitions EOF )
            // InternalCategories.g:75:1: ruleCategoriesDefinitions EOF
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
    // InternalCategories.g:82:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__Group__0 ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:86:2: ( ( ( rule__CategoriesDefinitions__Group__0 ) ) )
            // InternalCategories.g:87:2: ( ( rule__CategoriesDefinitions__Group__0 ) )
            {
            // InternalCategories.g:87:2: ( ( rule__CategoriesDefinitions__Group__0 ) )
            // InternalCategories.g:88:3: ( rule__CategoriesDefinitions__Group__0 )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getGroup()); 
            // InternalCategories.g:89:3: ( rule__CategoriesDefinitions__Group__0 )
            // InternalCategories.g:89:4: rule__CategoriesDefinitions__Group__0
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
    // InternalCategories.g:98:1: entryRuleCategories : ruleCategories EOF ;
    public final void entryRuleCategories() throws RecognitionException {
        try {
            // InternalCategories.g:99:1: ( ruleCategories EOF )
            // InternalCategories.g:100:1: ruleCategories EOF
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
    // InternalCategories.g:107:1: ruleCategories : ( ( rule__Categories__Group__0 ) ) ;
    public final void ruleCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:111:2: ( ( ( rule__Categories__Group__0 ) ) )
            // InternalCategories.g:112:2: ( ( rule__Categories__Group__0 ) )
            {
            // InternalCategories.g:112:2: ( ( rule__Categories__Group__0 ) )
            // InternalCategories.g:113:3: ( rule__Categories__Group__0 )
            {
             before(grammarAccess.getCategoriesAccess().getGroup()); 
            // InternalCategories.g:114:3: ( rule__Categories__Group__0 )
            // InternalCategories.g:114:4: rule__Categories__Group__0
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
    // InternalCategories.g:123:1: entryRuleCategory : ruleCategory EOF ;
    public final void entryRuleCategory() throws RecognitionException {
        try {
            // InternalCategories.g:124:1: ( ruleCategory EOF )
            // InternalCategories.g:125:1: ruleCategory EOF
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
    // InternalCategories.g:132:1: ruleCategory : ( ( rule__Category__NameAssignment ) ) ;
    public final void ruleCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:136:2: ( ( ( rule__Category__NameAssignment ) ) )
            // InternalCategories.g:137:2: ( ( rule__Category__NameAssignment ) )
            {
            // InternalCategories.g:137:2: ( ( rule__Category__NameAssignment ) )
            // InternalCategories.g:138:3: ( rule__Category__NameAssignment )
            {
             before(grammarAccess.getCategoryAccess().getNameAssignment()); 
            // InternalCategories.g:139:3: ( rule__Category__NameAssignment )
            // InternalCategories.g:139:4: rule__Category__NameAssignment
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
    // InternalCategories.g:148:1: entryRuleCategoryFilter : ruleCategoryFilter EOF ;
    public final void entryRuleCategoryFilter() throws RecognitionException {
        try {
            // InternalCategories.g:149:1: ( ruleCategoryFilter EOF )
            // InternalCategories.g:150:1: ruleCategoryFilter EOF
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
    // InternalCategories.g:157:1: ruleCategoryFilter : ( ( rule__CategoryFilter__Group__0 ) ) ;
    public final void ruleCategoryFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:161:2: ( ( ( rule__CategoryFilter__Group__0 ) ) )
            // InternalCategories.g:162:2: ( ( rule__CategoryFilter__Group__0 ) )
            {
            // InternalCategories.g:162:2: ( ( rule__CategoryFilter__Group__0 ) )
            // InternalCategories.g:163:3: ( rule__CategoryFilter__Group__0 )
            {
             before(grammarAccess.getCategoryFilterAccess().getGroup()); 
            // InternalCategories.g:164:3: ( rule__CategoryFilter__Group__0 )
            // InternalCategories.g:164:4: rule__CategoryFilter__Group__0
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
    // InternalCategories.g:173:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // InternalCategories.g:174:1: ( ruleCatRef EOF )
            // InternalCategories.g:175:1: ruleCatRef EOF
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
    // InternalCategories.g:182:1: ruleCatRef : ( ( rule__CatRef__Group__0 ) ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:186:2: ( ( ( rule__CatRef__Group__0 ) ) )
            // InternalCategories.g:187:2: ( ( rule__CatRef__Group__0 ) )
            {
            // InternalCategories.g:187:2: ( ( rule__CatRef__Group__0 ) )
            // InternalCategories.g:188:3: ( rule__CatRef__Group__0 )
            {
             before(grammarAccess.getCatRefAccess().getGroup()); 
            // InternalCategories.g:189:3: ( rule__CatRef__Group__0 )
            // InternalCategories.g:189:4: rule__CatRef__Group__0
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
    // InternalCategories.g:197:1: rule__CategoriesDefinitions__Group__0 : rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1 ;
    public final void rule__CategoriesDefinitions__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:201:1: ( rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1 )
            // InternalCategories.g:202:2: rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1
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
    // InternalCategories.g:209:1: rule__CategoriesDefinitions__Group__0__Impl : ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* ) ;
    public final void rule__CategoriesDefinitions__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:213:1: ( ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* ) )
            // InternalCategories.g:214:1: ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* )
            {
            // InternalCategories.g:214:1: ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* )
            // InternalCategories.g:215:2: ( rule__CategoriesDefinitions__CategoriesAssignment_0 )*
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment_0()); 
            // InternalCategories.g:216:2: ( rule__CategoriesDefinitions__CategoriesAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCategories.g:216:3: rule__CategoriesDefinitions__CategoriesAssignment_0
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
    // InternalCategories.g:224:1: rule__CategoriesDefinitions__Group__1 : rule__CategoriesDefinitions__Group__1__Impl ;
    public final void rule__CategoriesDefinitions__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:228:1: ( rule__CategoriesDefinitions__Group__1__Impl )
            // InternalCategories.g:229:2: rule__CategoriesDefinitions__Group__1__Impl
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
    // InternalCategories.g:235:1: rule__CategoriesDefinitions__Group__1__Impl : ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* ) ;
    public final void rule__CategoriesDefinitions__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:239:1: ( ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* ) )
            // InternalCategories.g:240:1: ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* )
            {
            // InternalCategories.g:240:1: ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* )
            // InternalCategories.g:241:2: ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )*
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersAssignment_1()); 
            // InternalCategories.g:242:2: ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==13) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCategories.g:242:3: rule__CategoriesDefinitions__CategoryFiltersAssignment_1
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
    // InternalCategories.g:251:1: rule__Categories__Group__0 : rule__Categories__Group__0__Impl rule__Categories__Group__1 ;
    public final void rule__Categories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:255:1: ( rule__Categories__Group__0__Impl rule__Categories__Group__1 )
            // InternalCategories.g:256:2: rule__Categories__Group__0__Impl rule__Categories__Group__1
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
    // InternalCategories.g:263:1: rule__Categories__Group__0__Impl : ( ( rule__Categories__NameAssignment_0 ) ) ;
    public final void rule__Categories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:267:1: ( ( ( rule__Categories__NameAssignment_0 ) ) )
            // InternalCategories.g:268:1: ( ( rule__Categories__NameAssignment_0 ) )
            {
            // InternalCategories.g:268:1: ( ( rule__Categories__NameAssignment_0 ) )
            // InternalCategories.g:269:2: ( rule__Categories__NameAssignment_0 )
            {
             before(grammarAccess.getCategoriesAccess().getNameAssignment_0()); 
            // InternalCategories.g:270:2: ( rule__Categories__NameAssignment_0 )
            // InternalCategories.g:270:3: rule__Categories__NameAssignment_0
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
    // InternalCategories.g:278:1: rule__Categories__Group__1 : rule__Categories__Group__1__Impl rule__Categories__Group__2 ;
    public final void rule__Categories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:282:1: ( rule__Categories__Group__1__Impl rule__Categories__Group__2 )
            // InternalCategories.g:283:2: rule__Categories__Group__1__Impl rule__Categories__Group__2
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
    // InternalCategories.g:290:1: rule__Categories__Group__1__Impl : ( '[' ) ;
    public final void rule__Categories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:294:1: ( ( '[' ) )
            // InternalCategories.g:295:1: ( '[' )
            {
            // InternalCategories.g:295:1: ( '[' )
            // InternalCategories.g:296:2: '['
            {
             before(grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1()); 
            match(input,11,FOLLOW_2); 
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
    // InternalCategories.g:305:1: rule__Categories__Group__2 : rule__Categories__Group__2__Impl rule__Categories__Group__3 ;
    public final void rule__Categories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:309:1: ( rule__Categories__Group__2__Impl rule__Categories__Group__3 )
            // InternalCategories.g:310:2: rule__Categories__Group__2__Impl rule__Categories__Group__3
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
    // InternalCategories.g:317:1: rule__Categories__Group__2__Impl : ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) ) ;
    public final void rule__Categories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:321:1: ( ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) ) )
            // InternalCategories.g:322:1: ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) )
            {
            // InternalCategories.g:322:1: ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) )
            // InternalCategories.g:323:2: ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* )
            {
            // InternalCategories.g:323:2: ( ( rule__Categories__CategoryAssignment_2 ) )
            // InternalCategories.g:324:3: ( rule__Categories__CategoryAssignment_2 )
            {
             before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 
            // InternalCategories.g:325:3: ( rule__Categories__CategoryAssignment_2 )
            // InternalCategories.g:325:4: rule__Categories__CategoryAssignment_2
            {
            pushFollow(FOLLOW_4);
            rule__Categories__CategoryAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 

            }

            // InternalCategories.g:328:2: ( ( rule__Categories__CategoryAssignment_2 )* )
            // InternalCategories.g:329:3: ( rule__Categories__CategoryAssignment_2 )*
            {
             before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 
            // InternalCategories.g:330:3: ( rule__Categories__CategoryAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCategories.g:330:4: rule__Categories__CategoryAssignment_2
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
    // InternalCategories.g:339:1: rule__Categories__Group__3 : rule__Categories__Group__3__Impl ;
    public final void rule__Categories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:343:1: ( rule__Categories__Group__3__Impl )
            // InternalCategories.g:344:2: rule__Categories__Group__3__Impl
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
    // InternalCategories.g:350:1: rule__Categories__Group__3__Impl : ( ']' ) ;
    public final void rule__Categories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:354:1: ( ( ']' ) )
            // InternalCategories.g:355:1: ( ']' )
            {
            // InternalCategories.g:355:1: ( ']' )
            // InternalCategories.g:356:2: ']'
            {
             before(grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3()); 
            match(input,12,FOLLOW_2); 
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
    // InternalCategories.g:366:1: rule__CategoryFilter__Group__0 : rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1 ;
    public final void rule__CategoryFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:370:1: ( rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1 )
            // InternalCategories.g:371:2: rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1
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
    // InternalCategories.g:378:1: rule__CategoryFilter__Group__0__Impl : ( 'filter' ) ;
    public final void rule__CategoryFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:382:1: ( ( 'filter' ) )
            // InternalCategories.g:383:1: ( 'filter' )
            {
            // InternalCategories.g:383:1: ( 'filter' )
            // InternalCategories.g:384:2: 'filter'
            {
             before(grammarAccess.getCategoryFilterAccess().getFilterKeyword_0()); 
            match(input,13,FOLLOW_2); 
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
    // InternalCategories.g:393:1: rule__CategoryFilter__Group__1 : rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2 ;
    public final void rule__CategoryFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:397:1: ( rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2 )
            // InternalCategories.g:398:2: rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2
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
    // InternalCategories.g:405:1: rule__CategoryFilter__Group__1__Impl : ( ( rule__CategoryFilter__NameAssignment_1 ) ) ;
    public final void rule__CategoryFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:409:1: ( ( ( rule__CategoryFilter__NameAssignment_1 ) ) )
            // InternalCategories.g:410:1: ( ( rule__CategoryFilter__NameAssignment_1 ) )
            {
            // InternalCategories.g:410:1: ( ( rule__CategoryFilter__NameAssignment_1 ) )
            // InternalCategories.g:411:2: ( rule__CategoryFilter__NameAssignment_1 )
            {
             before(grammarAccess.getCategoryFilterAccess().getNameAssignment_1()); 
            // InternalCategories.g:412:2: ( rule__CategoryFilter__NameAssignment_1 )
            // InternalCategories.g:412:3: rule__CategoryFilter__NameAssignment_1
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
    // InternalCategories.g:420:1: rule__CategoryFilter__Group__2 : rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3 ;
    public final void rule__CategoryFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:424:1: ( rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3 )
            // InternalCategories.g:425:2: rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3
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
    // InternalCategories.g:432:1: rule__CategoryFilter__Group__2__Impl : ( '[' ) ;
    public final void rule__CategoryFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:436:1: ( ( '[' ) )
            // InternalCategories.g:437:1: ( '[' )
            {
            // InternalCategories.g:437:1: ( '[' )
            // InternalCategories.g:438:2: '['
            {
             before(grammarAccess.getCategoryFilterAccess().getLeftSquareBracketKeyword_2()); 
            match(input,11,FOLLOW_2); 
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
    // InternalCategories.g:447:1: rule__CategoryFilter__Group__3 : rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4 ;
    public final void rule__CategoryFilter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:451:1: ( rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4 )
            // InternalCategories.g:452:2: rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4
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
    // InternalCategories.g:459:1: rule__CategoryFilter__Group__3__Impl : ( ( rule__CategoryFilter__CategoryAssignment_3 )* ) ;
    public final void rule__CategoryFilter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:463:1: ( ( ( rule__CategoryFilter__CategoryAssignment_3 )* ) )
            // InternalCategories.g:464:1: ( ( rule__CategoryFilter__CategoryAssignment_3 )* )
            {
            // InternalCategories.g:464:1: ( ( rule__CategoryFilter__CategoryAssignment_3 )* )
            // InternalCategories.g:465:2: ( rule__CategoryFilter__CategoryAssignment_3 )*
            {
             before(grammarAccess.getCategoryFilterAccess().getCategoryAssignment_3()); 
            // InternalCategories.g:466:2: ( rule__CategoryFilter__CategoryAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCategories.g:466:3: rule__CategoryFilter__CategoryAssignment_3
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
    // InternalCategories.g:474:1: rule__CategoryFilter__Group__4 : rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5 ;
    public final void rule__CategoryFilter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:478:1: ( rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5 )
            // InternalCategories.g:479:2: rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5
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
    // InternalCategories.g:486:1: rule__CategoryFilter__Group__4__Impl : ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? ) ;
    public final void rule__CategoryFilter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:490:1: ( ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? ) )
            // InternalCategories.g:491:1: ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? )
            {
            // InternalCategories.g:491:1: ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? )
            // InternalCategories.g:492:2: ( rule__CategoryFilter__AnyCategoryAssignment_4 )?
            {
             before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAssignment_4()); 
            // InternalCategories.g:493:2: ( rule__CategoryFilter__AnyCategoryAssignment_4 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalCategories.g:493:3: rule__CategoryFilter__AnyCategoryAssignment_4
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
    // InternalCategories.g:501:1: rule__CategoryFilter__Group__5 : rule__CategoryFilter__Group__5__Impl ;
    public final void rule__CategoryFilter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:505:1: ( rule__CategoryFilter__Group__5__Impl )
            // InternalCategories.g:506:2: rule__CategoryFilter__Group__5__Impl
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
    // InternalCategories.g:512:1: rule__CategoryFilter__Group__5__Impl : ( ']' ) ;
    public final void rule__CategoryFilter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:516:1: ( ( ']' ) )
            // InternalCategories.g:517:1: ( ']' )
            {
            // InternalCategories.g:517:1: ( ']' )
            // InternalCategories.g:518:2: ']'
            {
             before(grammarAccess.getCategoryFilterAccess().getRightSquareBracketKeyword_5()); 
            match(input,12,FOLLOW_2); 
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
    // InternalCategories.g:528:1: rule__CatRef__Group__0 : rule__CatRef__Group__0__Impl rule__CatRef__Group__1 ;
    public final void rule__CatRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:532:1: ( rule__CatRef__Group__0__Impl rule__CatRef__Group__1 )
            // InternalCategories.g:533:2: rule__CatRef__Group__0__Impl rule__CatRef__Group__1
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
    // InternalCategories.g:540:1: rule__CatRef__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__CatRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:544:1: ( ( RULE_ID ) )
            // InternalCategories.g:545:1: ( RULE_ID )
            {
            // InternalCategories.g:545:1: ( RULE_ID )
            // InternalCategories.g:546:2: RULE_ID
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
    // InternalCategories.g:555:1: rule__CatRef__Group__1 : rule__CatRef__Group__1__Impl rule__CatRef__Group__2 ;
    public final void rule__CatRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:559:1: ( rule__CatRef__Group__1__Impl rule__CatRef__Group__2 )
            // InternalCategories.g:560:2: rule__CatRef__Group__1__Impl rule__CatRef__Group__2
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
    // InternalCategories.g:567:1: rule__CatRef__Group__1__Impl : ( '.' ) ;
    public final void rule__CatRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:571:1: ( ( '.' ) )
            // InternalCategories.g:572:1: ( '.' )
            {
            // InternalCategories.g:572:1: ( '.' )
            // InternalCategories.g:573:2: '.'
            {
             before(grammarAccess.getCatRefAccess().getFullStopKeyword_1()); 
            match(input,14,FOLLOW_2); 
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
    // InternalCategories.g:582:1: rule__CatRef__Group__2 : rule__CatRef__Group__2__Impl ;
    public final void rule__CatRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:586:1: ( rule__CatRef__Group__2__Impl )
            // InternalCategories.g:587:2: rule__CatRef__Group__2__Impl
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
    // InternalCategories.g:593:1: rule__CatRef__Group__2__Impl : ( RULE_ID ) ;
    public final void rule__CatRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:597:1: ( ( RULE_ID ) )
            // InternalCategories.g:598:1: ( RULE_ID )
            {
            // InternalCategories.g:598:1: ( RULE_ID )
            // InternalCategories.g:599:2: RULE_ID
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
    // InternalCategories.g:609:1: rule__CategoriesDefinitions__CategoriesAssignment_0 : ( ruleCategories ) ;
    public final void rule__CategoriesDefinitions__CategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:613:1: ( ( ruleCategories ) )
            // InternalCategories.g:614:2: ( ruleCategories )
            {
            // InternalCategories.g:614:2: ( ruleCategories )
            // InternalCategories.g:615:3: ruleCategories
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
    // InternalCategories.g:624:1: rule__CategoriesDefinitions__CategoryFiltersAssignment_1 : ( ruleCategoryFilter ) ;
    public final void rule__CategoriesDefinitions__CategoryFiltersAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:628:1: ( ( ruleCategoryFilter ) )
            // InternalCategories.g:629:2: ( ruleCategoryFilter )
            {
            // InternalCategories.g:629:2: ( ruleCategoryFilter )
            // InternalCategories.g:630:3: ruleCategoryFilter
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
    // InternalCategories.g:639:1: rule__Categories__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Categories__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:643:1: ( ( RULE_ID ) )
            // InternalCategories.g:644:2: ( RULE_ID )
            {
            // InternalCategories.g:644:2: ( RULE_ID )
            // InternalCategories.g:645:3: RULE_ID
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
    // InternalCategories.g:654:1: rule__Categories__CategoryAssignment_2 : ( ruleCategory ) ;
    public final void rule__Categories__CategoryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:658:1: ( ( ruleCategory ) )
            // InternalCategories.g:659:2: ( ruleCategory )
            {
            // InternalCategories.g:659:2: ( ruleCategory )
            // InternalCategories.g:660:3: ruleCategory
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
    // InternalCategories.g:669:1: rule__Category__NameAssignment : ( RULE_ID ) ;
    public final void rule__Category__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:673:1: ( ( RULE_ID ) )
            // InternalCategories.g:674:2: ( RULE_ID )
            {
            // InternalCategories.g:674:2: ( RULE_ID )
            // InternalCategories.g:675:3: RULE_ID
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
    // InternalCategories.g:684:1: rule__CategoryFilter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CategoryFilter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:688:1: ( ( RULE_ID ) )
            // InternalCategories.g:689:2: ( RULE_ID )
            {
            // InternalCategories.g:689:2: ( RULE_ID )
            // InternalCategories.g:690:3: RULE_ID
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
    // InternalCategories.g:699:1: rule__CategoryFilter__CategoryAssignment_3 : ( ( ruleCatRef ) ) ;
    public final void rule__CategoryFilter__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:703:1: ( ( ( ruleCatRef ) ) )
            // InternalCategories.g:704:2: ( ( ruleCatRef ) )
            {
            // InternalCategories.g:704:2: ( ( ruleCatRef ) )
            // InternalCategories.g:705:3: ( ruleCatRef )
            {
             before(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0()); 
            // InternalCategories.g:706:3: ( ruleCatRef )
            // InternalCategories.g:707:4: ruleCatRef
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
    // InternalCategories.g:718:1: rule__CategoryFilter__AnyCategoryAssignment_4 : ( ( 'any' ) ) ;
    public final void rule__CategoryFilter__AnyCategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalCategories.g:722:1: ( ( ( 'any' ) ) )
            // InternalCategories.g:723:2: ( ( 'any' ) )
            {
            // InternalCategories.g:723:2: ( ( 'any' ) )
            // InternalCategories.g:724:3: ( 'any' )
            {
             before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); 
            // InternalCategories.g:725:3: ( 'any' )
            // InternalCategories.g:726:4: 'any'
            {
             before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); 
            match(input,15,FOLLOW_2); 
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000004000L});

}