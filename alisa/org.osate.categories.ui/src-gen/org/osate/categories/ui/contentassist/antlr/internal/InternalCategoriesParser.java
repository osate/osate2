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
    // InternalCategoriesParser.g:80:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:81:1: ( ruleCategoriesDefinitions EOF )
            // InternalCategoriesParser.g:82:1: ruleCategoriesDefinitions EOF
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
    // InternalCategoriesParser.g:89:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__Group__0 ) ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:93:5: ( ( ( rule__CategoriesDefinitions__Group__0 ) ) )
            // InternalCategoriesParser.g:94:1: ( ( rule__CategoriesDefinitions__Group__0 ) )
            {
            // InternalCategoriesParser.g:94:1: ( ( rule__CategoriesDefinitions__Group__0 ) )
            // InternalCategoriesParser.g:95:1: ( rule__CategoriesDefinitions__Group__0 )
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getGroup()); 
            // InternalCategoriesParser.g:96:1: ( rule__CategoriesDefinitions__Group__0 )
            // InternalCategoriesParser.g:96:2: rule__CategoriesDefinitions__Group__0
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
    // InternalCategoriesParser.g:108:1: entryRuleCategories : ruleCategories EOF ;
    public final void entryRuleCategories() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:109:1: ( ruleCategories EOF )
            // InternalCategoriesParser.g:110:1: ruleCategories EOF
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
    // InternalCategoriesParser.g:117:1: ruleCategories : ( ( rule__Categories__Group__0 ) ) ;
    public final void ruleCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:121:5: ( ( ( rule__Categories__Group__0 ) ) )
            // InternalCategoriesParser.g:122:1: ( ( rule__Categories__Group__0 ) )
            {
            // InternalCategoriesParser.g:122:1: ( ( rule__Categories__Group__0 ) )
            // InternalCategoriesParser.g:123:1: ( rule__Categories__Group__0 )
            {
             before(grammarAccess.getCategoriesAccess().getGroup()); 
            // InternalCategoriesParser.g:124:1: ( rule__Categories__Group__0 )
            // InternalCategoriesParser.g:124:2: rule__Categories__Group__0
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
    // InternalCategoriesParser.g:136:1: entryRuleCategory : ruleCategory EOF ;
    public final void entryRuleCategory() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:137:1: ( ruleCategory EOF )
            // InternalCategoriesParser.g:138:1: ruleCategory EOF
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
    // InternalCategoriesParser.g:145:1: ruleCategory : ( ( rule__Category__NameAssignment ) ) ;
    public final void ruleCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:149:5: ( ( ( rule__Category__NameAssignment ) ) )
            // InternalCategoriesParser.g:150:1: ( ( rule__Category__NameAssignment ) )
            {
            // InternalCategoriesParser.g:150:1: ( ( rule__Category__NameAssignment ) )
            // InternalCategoriesParser.g:151:1: ( rule__Category__NameAssignment )
            {
             before(grammarAccess.getCategoryAccess().getNameAssignment()); 
            // InternalCategoriesParser.g:152:1: ( rule__Category__NameAssignment )
            // InternalCategoriesParser.g:152:2: rule__Category__NameAssignment
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
    // InternalCategoriesParser.g:164:1: entryRuleCategoryFilter : ruleCategoryFilter EOF ;
    public final void entryRuleCategoryFilter() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:165:1: ( ruleCategoryFilter EOF )
            // InternalCategoriesParser.g:166:1: ruleCategoryFilter EOF
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
    // InternalCategoriesParser.g:173:1: ruleCategoryFilter : ( ( rule__CategoryFilter__Group__0 ) ) ;
    public final void ruleCategoryFilter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:177:5: ( ( ( rule__CategoryFilter__Group__0 ) ) )
            // InternalCategoriesParser.g:178:1: ( ( rule__CategoryFilter__Group__0 ) )
            {
            // InternalCategoriesParser.g:178:1: ( ( rule__CategoryFilter__Group__0 ) )
            // InternalCategoriesParser.g:179:1: ( rule__CategoryFilter__Group__0 )
            {
             before(grammarAccess.getCategoryFilterAccess().getGroup()); 
            // InternalCategoriesParser.g:180:1: ( rule__CategoryFilter__Group__0 )
            // InternalCategoriesParser.g:180:2: rule__CategoryFilter__Group__0
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
    // InternalCategoriesParser.g:192:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // InternalCategoriesParser.g:193:1: ( ruleCatRef EOF )
            // InternalCategoriesParser.g:194:1: ruleCatRef EOF
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
    // InternalCategoriesParser.g:201:1: ruleCatRef : ( ( rule__CatRef__Group__0 ) ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:205:5: ( ( ( rule__CatRef__Group__0 ) ) )
            // InternalCategoriesParser.g:206:1: ( ( rule__CatRef__Group__0 ) )
            {
            // InternalCategoriesParser.g:206:1: ( ( rule__CatRef__Group__0 ) )
            // InternalCategoriesParser.g:207:1: ( rule__CatRef__Group__0 )
            {
             before(grammarAccess.getCatRefAccess().getGroup()); 
            // InternalCategoriesParser.g:208:1: ( rule__CatRef__Group__0 )
            // InternalCategoriesParser.g:208:2: rule__CatRef__Group__0
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
    // InternalCategoriesParser.g:222:1: rule__CategoriesDefinitions__Group__0 : rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1 ;
    public final void rule__CategoriesDefinitions__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:226:1: ( rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1 )
            // InternalCategoriesParser.g:227:2: rule__CategoriesDefinitions__Group__0__Impl rule__CategoriesDefinitions__Group__1
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
    // InternalCategoriesParser.g:234:1: rule__CategoriesDefinitions__Group__0__Impl : ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* ) ;
    public final void rule__CategoriesDefinitions__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:238:1: ( ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* ) )
            // InternalCategoriesParser.g:239:1: ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* )
            {
            // InternalCategoriesParser.g:239:1: ( ( rule__CategoriesDefinitions__CategoriesAssignment_0 )* )
            // InternalCategoriesParser.g:240:1: ( rule__CategoriesDefinitions__CategoriesAssignment_0 )*
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment_0()); 
            // InternalCategoriesParser.g:241:1: ( rule__CategoriesDefinitions__CategoriesAssignment_0 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCategoriesParser.g:241:2: rule__CategoriesDefinitions__CategoriesAssignment_0
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
    // InternalCategoriesParser.g:251:1: rule__CategoriesDefinitions__Group__1 : rule__CategoriesDefinitions__Group__1__Impl ;
    public final void rule__CategoriesDefinitions__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:255:1: ( rule__CategoriesDefinitions__Group__1__Impl )
            // InternalCategoriesParser.g:256:2: rule__CategoriesDefinitions__Group__1__Impl
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
    // InternalCategoriesParser.g:262:1: rule__CategoriesDefinitions__Group__1__Impl : ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* ) ;
    public final void rule__CategoriesDefinitions__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:266:1: ( ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* ) )
            // InternalCategoriesParser.g:267:1: ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* )
            {
            // InternalCategoriesParser.g:267:1: ( ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )* )
            // InternalCategoriesParser.g:268:1: ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )*
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoryFiltersAssignment_1()); 
            // InternalCategoriesParser.g:269:1: ( rule__CategoriesDefinitions__CategoryFiltersAssignment_1 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Filter) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalCategoriesParser.g:269:2: rule__CategoriesDefinitions__CategoryFiltersAssignment_1
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
    // InternalCategoriesParser.g:283:1: rule__Categories__Group__0 : rule__Categories__Group__0__Impl rule__Categories__Group__1 ;
    public final void rule__Categories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:287:1: ( rule__Categories__Group__0__Impl rule__Categories__Group__1 )
            // InternalCategoriesParser.g:288:2: rule__Categories__Group__0__Impl rule__Categories__Group__1
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
    // InternalCategoriesParser.g:295:1: rule__Categories__Group__0__Impl : ( ( rule__Categories__NameAssignment_0 ) ) ;
    public final void rule__Categories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:299:1: ( ( ( rule__Categories__NameAssignment_0 ) ) )
            // InternalCategoriesParser.g:300:1: ( ( rule__Categories__NameAssignment_0 ) )
            {
            // InternalCategoriesParser.g:300:1: ( ( rule__Categories__NameAssignment_0 ) )
            // InternalCategoriesParser.g:301:1: ( rule__Categories__NameAssignment_0 )
            {
             before(grammarAccess.getCategoriesAccess().getNameAssignment_0()); 
            // InternalCategoriesParser.g:302:1: ( rule__Categories__NameAssignment_0 )
            // InternalCategoriesParser.g:302:2: rule__Categories__NameAssignment_0
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
    // InternalCategoriesParser.g:312:1: rule__Categories__Group__1 : rule__Categories__Group__1__Impl rule__Categories__Group__2 ;
    public final void rule__Categories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:316:1: ( rule__Categories__Group__1__Impl rule__Categories__Group__2 )
            // InternalCategoriesParser.g:317:2: rule__Categories__Group__1__Impl rule__Categories__Group__2
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
    // InternalCategoriesParser.g:324:1: rule__Categories__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__Categories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:328:1: ( ( LeftSquareBracket ) )
            // InternalCategoriesParser.g:329:1: ( LeftSquareBracket )
            {
            // InternalCategoriesParser.g:329:1: ( LeftSquareBracket )
            // InternalCategoriesParser.g:330:1: LeftSquareBracket
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
    // InternalCategoriesParser.g:343:1: rule__Categories__Group__2 : rule__Categories__Group__2__Impl rule__Categories__Group__3 ;
    public final void rule__Categories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:347:1: ( rule__Categories__Group__2__Impl rule__Categories__Group__3 )
            // InternalCategoriesParser.g:348:2: rule__Categories__Group__2__Impl rule__Categories__Group__3
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
    // InternalCategoriesParser.g:355:1: rule__Categories__Group__2__Impl : ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) ) ;
    public final void rule__Categories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:359:1: ( ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) ) )
            // InternalCategoriesParser.g:360:1: ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) )
            {
            // InternalCategoriesParser.g:360:1: ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) )
            // InternalCategoriesParser.g:361:1: ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* )
            {
            // InternalCategoriesParser.g:361:1: ( ( rule__Categories__CategoryAssignment_2 ) )
            // InternalCategoriesParser.g:362:1: ( rule__Categories__CategoryAssignment_2 )
            {
             before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 
            // InternalCategoriesParser.g:363:1: ( rule__Categories__CategoryAssignment_2 )
            // InternalCategoriesParser.g:363:2: rule__Categories__CategoryAssignment_2
            {
            pushFollow(FOLLOW_4);
            rule__Categories__CategoryAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 

            }

            // InternalCategoriesParser.g:366:1: ( ( rule__Categories__CategoryAssignment_2 )* )
            // InternalCategoriesParser.g:367:1: ( rule__Categories__CategoryAssignment_2 )*
            {
             before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 
            // InternalCategoriesParser.g:368:1: ( rule__Categories__CategoryAssignment_2 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalCategoriesParser.g:368:2: rule__Categories__CategoryAssignment_2
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
    // InternalCategoriesParser.g:379:1: rule__Categories__Group__3 : rule__Categories__Group__3__Impl ;
    public final void rule__Categories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:383:1: ( rule__Categories__Group__3__Impl )
            // InternalCategoriesParser.g:384:2: rule__Categories__Group__3__Impl
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
    // InternalCategoriesParser.g:390:1: rule__Categories__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Categories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:394:1: ( ( RightSquareBracket ) )
            // InternalCategoriesParser.g:395:1: ( RightSquareBracket )
            {
            // InternalCategoriesParser.g:395:1: ( RightSquareBracket )
            // InternalCategoriesParser.g:396:1: RightSquareBracket
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
    // InternalCategoriesParser.g:417:1: rule__CategoryFilter__Group__0 : rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1 ;
    public final void rule__CategoryFilter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:421:1: ( rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1 )
            // InternalCategoriesParser.g:422:2: rule__CategoryFilter__Group__0__Impl rule__CategoryFilter__Group__1
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
    // InternalCategoriesParser.g:429:1: rule__CategoryFilter__Group__0__Impl : ( Filter ) ;
    public final void rule__CategoryFilter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:433:1: ( ( Filter ) )
            // InternalCategoriesParser.g:434:1: ( Filter )
            {
            // InternalCategoriesParser.g:434:1: ( Filter )
            // InternalCategoriesParser.g:435:1: Filter
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
    // InternalCategoriesParser.g:448:1: rule__CategoryFilter__Group__1 : rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2 ;
    public final void rule__CategoryFilter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:452:1: ( rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2 )
            // InternalCategoriesParser.g:453:2: rule__CategoryFilter__Group__1__Impl rule__CategoryFilter__Group__2
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
    // InternalCategoriesParser.g:460:1: rule__CategoryFilter__Group__1__Impl : ( ( rule__CategoryFilter__NameAssignment_1 ) ) ;
    public final void rule__CategoryFilter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:464:1: ( ( ( rule__CategoryFilter__NameAssignment_1 ) ) )
            // InternalCategoriesParser.g:465:1: ( ( rule__CategoryFilter__NameAssignment_1 ) )
            {
            // InternalCategoriesParser.g:465:1: ( ( rule__CategoryFilter__NameAssignment_1 ) )
            // InternalCategoriesParser.g:466:1: ( rule__CategoryFilter__NameAssignment_1 )
            {
             before(grammarAccess.getCategoryFilterAccess().getNameAssignment_1()); 
            // InternalCategoriesParser.g:467:1: ( rule__CategoryFilter__NameAssignment_1 )
            // InternalCategoriesParser.g:467:2: rule__CategoryFilter__NameAssignment_1
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
    // InternalCategoriesParser.g:477:1: rule__CategoryFilter__Group__2 : rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3 ;
    public final void rule__CategoryFilter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:481:1: ( rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3 )
            // InternalCategoriesParser.g:482:2: rule__CategoryFilter__Group__2__Impl rule__CategoryFilter__Group__3
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
    // InternalCategoriesParser.g:489:1: rule__CategoryFilter__Group__2__Impl : ( LeftSquareBracket ) ;
    public final void rule__CategoryFilter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:493:1: ( ( LeftSquareBracket ) )
            // InternalCategoriesParser.g:494:1: ( LeftSquareBracket )
            {
            // InternalCategoriesParser.g:494:1: ( LeftSquareBracket )
            // InternalCategoriesParser.g:495:1: LeftSquareBracket
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
    // InternalCategoriesParser.g:508:1: rule__CategoryFilter__Group__3 : rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4 ;
    public final void rule__CategoryFilter__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:512:1: ( rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4 )
            // InternalCategoriesParser.g:513:2: rule__CategoryFilter__Group__3__Impl rule__CategoryFilter__Group__4
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
    // InternalCategoriesParser.g:520:1: rule__CategoryFilter__Group__3__Impl : ( ( rule__CategoryFilter__CategoryAssignment_3 )* ) ;
    public final void rule__CategoryFilter__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:524:1: ( ( ( rule__CategoryFilter__CategoryAssignment_3 )* ) )
            // InternalCategoriesParser.g:525:1: ( ( rule__CategoryFilter__CategoryAssignment_3 )* )
            {
            // InternalCategoriesParser.g:525:1: ( ( rule__CategoryFilter__CategoryAssignment_3 )* )
            // InternalCategoriesParser.g:526:1: ( rule__CategoryFilter__CategoryAssignment_3 )*
            {
             before(grammarAccess.getCategoryFilterAccess().getCategoryAssignment_3()); 
            // InternalCategoriesParser.g:527:1: ( rule__CategoryFilter__CategoryAssignment_3 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalCategoriesParser.g:527:2: rule__CategoryFilter__CategoryAssignment_3
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
    // InternalCategoriesParser.g:537:1: rule__CategoryFilter__Group__4 : rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5 ;
    public final void rule__CategoryFilter__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:541:1: ( rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5 )
            // InternalCategoriesParser.g:542:2: rule__CategoryFilter__Group__4__Impl rule__CategoryFilter__Group__5
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
    // InternalCategoriesParser.g:549:1: rule__CategoryFilter__Group__4__Impl : ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? ) ;
    public final void rule__CategoryFilter__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:553:1: ( ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? ) )
            // InternalCategoriesParser.g:554:1: ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? )
            {
            // InternalCategoriesParser.g:554:1: ( ( rule__CategoryFilter__AnyCategoryAssignment_4 )? )
            // InternalCategoriesParser.g:555:1: ( rule__CategoryFilter__AnyCategoryAssignment_4 )?
            {
             before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAssignment_4()); 
            // InternalCategoriesParser.g:556:1: ( rule__CategoryFilter__AnyCategoryAssignment_4 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Any) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalCategoriesParser.g:556:2: rule__CategoryFilter__AnyCategoryAssignment_4
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
    // InternalCategoriesParser.g:566:1: rule__CategoryFilter__Group__5 : rule__CategoryFilter__Group__5__Impl ;
    public final void rule__CategoryFilter__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:570:1: ( rule__CategoryFilter__Group__5__Impl )
            // InternalCategoriesParser.g:571:2: rule__CategoryFilter__Group__5__Impl
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
    // InternalCategoriesParser.g:577:1: rule__CategoryFilter__Group__5__Impl : ( RightSquareBracket ) ;
    public final void rule__CategoryFilter__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:581:1: ( ( RightSquareBracket ) )
            // InternalCategoriesParser.g:582:1: ( RightSquareBracket )
            {
            // InternalCategoriesParser.g:582:1: ( RightSquareBracket )
            // InternalCategoriesParser.g:583:1: RightSquareBracket
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
    // InternalCategoriesParser.g:608:1: rule__CatRef__Group__0 : rule__CatRef__Group__0__Impl rule__CatRef__Group__1 ;
    public final void rule__CatRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:612:1: ( rule__CatRef__Group__0__Impl rule__CatRef__Group__1 )
            // InternalCategoriesParser.g:613:2: rule__CatRef__Group__0__Impl rule__CatRef__Group__1
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
    // InternalCategoriesParser.g:620:1: rule__CatRef__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__CatRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:624:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:625:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:625:1: ( RULE_ID )
            // InternalCategoriesParser.g:626:1: RULE_ID
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
    // InternalCategoriesParser.g:637:1: rule__CatRef__Group__1 : rule__CatRef__Group__1__Impl rule__CatRef__Group__2 ;
    public final void rule__CatRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:641:1: ( rule__CatRef__Group__1__Impl rule__CatRef__Group__2 )
            // InternalCategoriesParser.g:642:2: rule__CatRef__Group__1__Impl rule__CatRef__Group__2
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
    // InternalCategoriesParser.g:649:1: rule__CatRef__Group__1__Impl : ( FullStop ) ;
    public final void rule__CatRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:653:1: ( ( FullStop ) )
            // InternalCategoriesParser.g:654:1: ( FullStop )
            {
            // InternalCategoriesParser.g:654:1: ( FullStop )
            // InternalCategoriesParser.g:655:1: FullStop
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
    // InternalCategoriesParser.g:668:1: rule__CatRef__Group__2 : rule__CatRef__Group__2__Impl ;
    public final void rule__CatRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:672:1: ( rule__CatRef__Group__2__Impl )
            // InternalCategoriesParser.g:673:2: rule__CatRef__Group__2__Impl
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
    // InternalCategoriesParser.g:679:1: rule__CatRef__Group__2__Impl : ( RULE_ID ) ;
    public final void rule__CatRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:683:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:684:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:684:1: ( RULE_ID )
            // InternalCategoriesParser.g:685:1: RULE_ID
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
    // InternalCategoriesParser.g:703:1: rule__CategoriesDefinitions__CategoriesAssignment_0 : ( ruleCategories ) ;
    public final void rule__CategoriesDefinitions__CategoriesAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:707:1: ( ( ruleCategories ) )
            // InternalCategoriesParser.g:708:1: ( ruleCategories )
            {
            // InternalCategoriesParser.g:708:1: ( ruleCategories )
            // InternalCategoriesParser.g:709:1: ruleCategories
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
    // InternalCategoriesParser.g:718:1: rule__CategoriesDefinitions__CategoryFiltersAssignment_1 : ( ruleCategoryFilter ) ;
    public final void rule__CategoriesDefinitions__CategoryFiltersAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:722:1: ( ( ruleCategoryFilter ) )
            // InternalCategoriesParser.g:723:1: ( ruleCategoryFilter )
            {
            // InternalCategoriesParser.g:723:1: ( ruleCategoryFilter )
            // InternalCategoriesParser.g:724:1: ruleCategoryFilter
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
    // InternalCategoriesParser.g:733:1: rule__Categories__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Categories__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:737:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:738:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:738:1: ( RULE_ID )
            // InternalCategoriesParser.g:739:1: RULE_ID
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
    // InternalCategoriesParser.g:748:1: rule__Categories__CategoryAssignment_2 : ( ruleCategory ) ;
    public final void rule__Categories__CategoryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:752:1: ( ( ruleCategory ) )
            // InternalCategoriesParser.g:753:1: ( ruleCategory )
            {
            // InternalCategoriesParser.g:753:1: ( ruleCategory )
            // InternalCategoriesParser.g:754:1: ruleCategory
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
    // InternalCategoriesParser.g:763:1: rule__Category__NameAssignment : ( RULE_ID ) ;
    public final void rule__Category__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:767:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:768:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:768:1: ( RULE_ID )
            // InternalCategoriesParser.g:769:1: RULE_ID
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
    // InternalCategoriesParser.g:778:1: rule__CategoryFilter__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__CategoryFilter__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:782:1: ( ( RULE_ID ) )
            // InternalCategoriesParser.g:783:1: ( RULE_ID )
            {
            // InternalCategoriesParser.g:783:1: ( RULE_ID )
            // InternalCategoriesParser.g:784:1: RULE_ID
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
    // InternalCategoriesParser.g:793:1: rule__CategoryFilter__CategoryAssignment_3 : ( ( ruleCatRef ) ) ;
    public final void rule__CategoryFilter__CategoryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:797:1: ( ( ( ruleCatRef ) ) )
            // InternalCategoriesParser.g:798:1: ( ( ruleCatRef ) )
            {
            // InternalCategoriesParser.g:798:1: ( ( ruleCatRef ) )
            // InternalCategoriesParser.g:799:1: ( ruleCatRef )
            {
             before(grammarAccess.getCategoryFilterAccess().getCategoryCategoryCrossReference_3_0()); 
            // InternalCategoriesParser.g:800:1: ( ruleCatRef )
            // InternalCategoriesParser.g:801:1: ruleCatRef
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
    // InternalCategoriesParser.g:812:1: rule__CategoryFilter__AnyCategoryAssignment_4 : ( ( Any ) ) ;
    public final void rule__CategoryFilter__AnyCategoryAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // InternalCategoriesParser.g:816:1: ( ( ( Any ) ) )
            // InternalCategoriesParser.g:817:1: ( ( Any ) )
            {
            // InternalCategoriesParser.g:817:1: ( ( Any ) )
            // InternalCategoriesParser.g:818:1: ( Any )
            {
             before(grammarAccess.getCategoryFilterAccess().getAnyCategoryAnyKeyword_4_0()); 
            // InternalCategoriesParser.g:819:1: ( Any )
            // InternalCategoriesParser.g:820:1: Any
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