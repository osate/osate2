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
    public String getGrammarFileName() { return "../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g"; }


     
     	private CategoriesGrammarAccess grammarAccess;
     	
     	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
     	
     	{
    		tokenNameToValue.put("FullStop", "'.'");
    		tokenNameToValue.put("LeftSquareBracket", "'['");
    		tokenNameToValue.put("RightSquareBracket", "']'");
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:78:1: entryRuleCategoriesDefinitions : ruleCategoriesDefinitions EOF ;
    public final void entryRuleCategoriesDefinitions() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:79:1: ( ruleCategoriesDefinitions EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:80:1: ruleCategoriesDefinitions EOF
            {
             before(grammarAccess.getCategoriesDefinitionsRule()); 
            pushFollow(FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions54);
            ruleCategoriesDefinitions();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategoriesDefinitions61); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:87:1: ruleCategoriesDefinitions : ( ( rule__CategoriesDefinitions__CategoriesAssignment )* ) ;
    public final void ruleCategoriesDefinitions() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:91:5: ( ( ( rule__CategoriesDefinitions__CategoriesAssignment )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:92:1: ( ( rule__CategoriesDefinitions__CategoriesAssignment )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:92:1: ( ( rule__CategoriesDefinitions__CategoriesAssignment )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:93:1: ( rule__CategoriesDefinitions__CategoriesAssignment )*
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:94:1: ( rule__CategoriesDefinitions__CategoriesAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:94:2: rule__CategoriesDefinitions__CategoriesAssignment
            	    {
            	    pushFollow(FOLLOW_rule__CategoriesDefinitions__CategoriesAssignment_in_ruleCategoriesDefinitions91);
            	    rule__CategoriesDefinitions__CategoriesAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesAssignment()); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:106:1: entryRuleCategories : ruleCategories EOF ;
    public final void entryRuleCategories() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:107:1: ( ruleCategories EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:108:1: ruleCategories EOF
            {
             before(grammarAccess.getCategoriesRule()); 
            pushFollow(FOLLOW_ruleCategories_in_entryRuleCategories119);
            ruleCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategories126); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:115:1: ruleCategories : ( ( rule__Categories__Group__0 ) ) ;
    public final void ruleCategories() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:119:5: ( ( ( rule__Categories__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:120:1: ( ( rule__Categories__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:120:1: ( ( rule__Categories__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:121:1: ( rule__Categories__Group__0 )
            {
             before(grammarAccess.getCategoriesAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:122:1: ( rule__Categories__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:122:2: rule__Categories__Group__0
            {
            pushFollow(FOLLOW_rule__Categories__Group__0_in_ruleCategories156);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:134:1: entryRuleCategory : ruleCategory EOF ;
    public final void entryRuleCategory() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:135:1: ( ruleCategory EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:136:1: ruleCategory EOF
            {
             before(grammarAccess.getCategoryRule()); 
            pushFollow(FOLLOW_ruleCategory_in_entryRuleCategory183);
            ruleCategory();

            state._fsp--;

             after(grammarAccess.getCategoryRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCategory190); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:143:1: ruleCategory : ( ( rule__Category__NameAssignment ) ) ;
    public final void ruleCategory() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:147:5: ( ( ( rule__Category__NameAssignment ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:148:1: ( ( rule__Category__NameAssignment ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:148:1: ( ( rule__Category__NameAssignment ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:149:1: ( rule__Category__NameAssignment )
            {
             before(grammarAccess.getCategoryAccess().getNameAssignment()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:150:1: ( rule__Category__NameAssignment )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:150:2: rule__Category__NameAssignment
            {
            pushFollow(FOLLOW_rule__Category__NameAssignment_in_ruleCategory220);
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


    // $ANTLR start "entryRuleCatRef"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:164:1: entryRuleCatRef : ruleCatRef EOF ;
    public final void entryRuleCatRef() throws RecognitionException {
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:165:1: ( ruleCatRef EOF )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:166:1: ruleCatRef EOF
            {
             before(grammarAccess.getCatRefRule()); 
            pushFollow(FOLLOW_ruleCatRef_in_entryRuleCatRef249);
            ruleCatRef();

            state._fsp--;

             after(grammarAccess.getCatRefRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCatRef256); 

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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:173:1: ruleCatRef : ( ( rule__CatRef__Group__0 ) ) ;
    public final void ruleCatRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:177:5: ( ( ( rule__CatRef__Group__0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:178:1: ( ( rule__CatRef__Group__0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:178:1: ( ( rule__CatRef__Group__0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:179:1: ( rule__CatRef__Group__0 )
            {
             before(grammarAccess.getCatRefAccess().getGroup()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:180:1: ( rule__CatRef__Group__0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:180:2: rule__CatRef__Group__0
            {
            pushFollow(FOLLOW_rule__CatRef__Group__0_in_ruleCatRef286);
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


    // $ANTLR start "rule__Categories__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:194:1: rule__Categories__Group__0 : rule__Categories__Group__0__Impl rule__Categories__Group__1 ;
    public final void rule__Categories__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:198:1: ( rule__Categories__Group__0__Impl rule__Categories__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:199:2: rule__Categories__Group__0__Impl rule__Categories__Group__1
            {
            pushFollow(FOLLOW_rule__Categories__Group__0__Impl_in_rule__Categories__Group__0320);
            rule__Categories__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Categories__Group__1_in_rule__Categories__Group__0323);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:206:1: rule__Categories__Group__0__Impl : ( ( rule__Categories__NameAssignment_0 ) ) ;
    public final void rule__Categories__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:210:1: ( ( ( rule__Categories__NameAssignment_0 ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:211:1: ( ( rule__Categories__NameAssignment_0 ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:211:1: ( ( rule__Categories__NameAssignment_0 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:212:1: ( rule__Categories__NameAssignment_0 )
            {
             before(grammarAccess.getCategoriesAccess().getNameAssignment_0()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:213:1: ( rule__Categories__NameAssignment_0 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:213:2: rule__Categories__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Categories__NameAssignment_0_in_rule__Categories__Group__0__Impl350);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:223:1: rule__Categories__Group__1 : rule__Categories__Group__1__Impl rule__Categories__Group__2 ;
    public final void rule__Categories__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:227:1: ( rule__Categories__Group__1__Impl rule__Categories__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:228:2: rule__Categories__Group__1__Impl rule__Categories__Group__2
            {
            pushFollow(FOLLOW_rule__Categories__Group__1__Impl_in_rule__Categories__Group__1380);
            rule__Categories__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Categories__Group__2_in_rule__Categories__Group__1383);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:235:1: rule__Categories__Group__1__Impl : ( LeftSquareBracket ) ;
    public final void rule__Categories__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:239:1: ( ( LeftSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:240:1: ( LeftSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:240:1: ( LeftSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:241:1: LeftSquareBracket
            {
             before(grammarAccess.getCategoriesAccess().getLeftSquareBracketKeyword_1()); 
            match(input,LeftSquareBracket,FOLLOW_LeftSquareBracket_in_rule__Categories__Group__1__Impl411); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:254:1: rule__Categories__Group__2 : rule__Categories__Group__2__Impl rule__Categories__Group__3 ;
    public final void rule__Categories__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:258:1: ( rule__Categories__Group__2__Impl rule__Categories__Group__3 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:259:2: rule__Categories__Group__2__Impl rule__Categories__Group__3
            {
            pushFollow(FOLLOW_rule__Categories__Group__2__Impl_in_rule__Categories__Group__2442);
            rule__Categories__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Categories__Group__3_in_rule__Categories__Group__2445);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:266:1: rule__Categories__Group__2__Impl : ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) ) ;
    public final void rule__Categories__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:270:1: ( ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:271:1: ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:271:1: ( ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:272:1: ( ( rule__Categories__CategoryAssignment_2 ) ) ( ( rule__Categories__CategoryAssignment_2 )* )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:272:1: ( ( rule__Categories__CategoryAssignment_2 ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:273:1: ( rule__Categories__CategoryAssignment_2 )
            {
             before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:274:1: ( rule__Categories__CategoryAssignment_2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:274:2: rule__Categories__CategoryAssignment_2
            {
            pushFollow(FOLLOW_rule__Categories__CategoryAssignment_2_in_rule__Categories__Group__2__Impl474);
            rule__Categories__CategoryAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 

            }

            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:277:1: ( ( rule__Categories__CategoryAssignment_2 )* )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:278:1: ( rule__Categories__CategoryAssignment_2 )*
            {
             before(grammarAccess.getCategoriesAccess().getCategoryAssignment_2()); 
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:279:1: ( rule__Categories__CategoryAssignment_2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_ID) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:279:2: rule__Categories__CategoryAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Categories__CategoryAssignment_2_in_rule__Categories__Group__2__Impl486);
            	    rule__Categories__CategoryAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:290:1: rule__Categories__Group__3 : rule__Categories__Group__3__Impl ;
    public final void rule__Categories__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:294:1: ( rule__Categories__Group__3__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:295:2: rule__Categories__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Categories__Group__3__Impl_in_rule__Categories__Group__3519);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:301:1: rule__Categories__Group__3__Impl : ( RightSquareBracket ) ;
    public final void rule__Categories__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:305:1: ( ( RightSquareBracket ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:306:1: ( RightSquareBracket )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:306:1: ( RightSquareBracket )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:307:1: RightSquareBracket
            {
             before(grammarAccess.getCategoriesAccess().getRightSquareBracketKeyword_3()); 
            match(input,RightSquareBracket,FOLLOW_RightSquareBracket_in_rule__Categories__Group__3__Impl547); 
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


    // $ANTLR start "rule__CatRef__Group__0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:329:1: rule__CatRef__Group__0 : rule__CatRef__Group__0__Impl rule__CatRef__Group__1 ;
    public final void rule__CatRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:333:1: ( rule__CatRef__Group__0__Impl rule__CatRef__Group__1 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:334:2: rule__CatRef__Group__0__Impl rule__CatRef__Group__1
            {
            pushFollow(FOLLOW_rule__CatRef__Group__0__Impl_in_rule__CatRef__Group__0587);
            rule__CatRef__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CatRef__Group__1_in_rule__CatRef__Group__0590);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:341:1: rule__CatRef__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__CatRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:345:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:346:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:346:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:347:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CatRef__Group__0__Impl617); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:358:1: rule__CatRef__Group__1 : rule__CatRef__Group__1__Impl rule__CatRef__Group__2 ;
    public final void rule__CatRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:362:1: ( rule__CatRef__Group__1__Impl rule__CatRef__Group__2 )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:363:2: rule__CatRef__Group__1__Impl rule__CatRef__Group__2
            {
            pushFollow(FOLLOW_rule__CatRef__Group__1__Impl_in_rule__CatRef__Group__1646);
            rule__CatRef__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CatRef__Group__2_in_rule__CatRef__Group__1649);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:370:1: rule__CatRef__Group__1__Impl : ( FullStop ) ;
    public final void rule__CatRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:374:1: ( ( FullStop ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:375:1: ( FullStop )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:375:1: ( FullStop )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:376:1: FullStop
            {
             before(grammarAccess.getCatRefAccess().getFullStopKeyword_1()); 
            match(input,FullStop,FOLLOW_FullStop_in_rule__CatRef__Group__1__Impl677); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:389:1: rule__CatRef__Group__2 : rule__CatRef__Group__2__Impl ;
    public final void rule__CatRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:393:1: ( rule__CatRef__Group__2__Impl )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:394:2: rule__CatRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__CatRef__Group__2__Impl_in_rule__CatRef__Group__2708);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:400:1: rule__CatRef__Group__2__Impl : ( RULE_ID ) ;
    public final void rule__CatRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:404:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:405:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:405:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:406:1: RULE_ID
            {
             before(grammarAccess.getCatRefAccess().getIDTerminalRuleCall_2()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__CatRef__Group__2__Impl735); 
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


    // $ANTLR start "rule__CategoriesDefinitions__CategoriesAssignment"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:424:1: rule__CategoriesDefinitions__CategoriesAssignment : ( ruleCategories ) ;
    public final void rule__CategoriesDefinitions__CategoriesAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:428:1: ( ( ruleCategories ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:429:1: ( ruleCategories )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:429:1: ( ruleCategories )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:430:1: ruleCategories
            {
             before(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleCategories_in_rule__CategoriesDefinitions__CategoriesAssignment775);
            ruleCategories();

            state._fsp--;

             after(grammarAccess.getCategoriesDefinitionsAccess().getCategoriesCategoriesParserRuleCall_0()); 

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
    // $ANTLR end "rule__CategoriesDefinitions__CategoriesAssignment"


    // $ANTLR start "rule__Categories__NameAssignment_0"
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:439:1: rule__Categories__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Categories__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:443:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:444:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:444:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:445:1: RULE_ID
            {
             before(grammarAccess.getCategoriesAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Categories__NameAssignment_0806); 
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:454:1: rule__Categories__CategoryAssignment_2 : ( ruleCategory ) ;
    public final void rule__Categories__CategoryAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:458:1: ( ( ruleCategory ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:459:1: ( ruleCategory )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:459:1: ( ruleCategory )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:460:1: ruleCategory
            {
             before(grammarAccess.getCategoriesAccess().getCategoryCategoryParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleCategory_in_rule__Categories__CategoryAssignment_2837);
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
    // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:469:1: rule__Category__NameAssignment : ( RULE_ID ) ;
    public final void rule__Category__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:473:1: ( ( RULE_ID ) )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:474:1: ( RULE_ID )
            {
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:474:1: ( RULE_ID )
            // ../org.osate.categories.ui/src-gen/org/osate/categories/ui/contentassist/antlr/internal/InternalCategoriesParser.g:475:1: RULE_ID
            {
             before(grammarAccess.getCategoryAccess().getNameIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Category__NameAssignment868); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleCategoriesDefinitions_in_entryRuleCategoriesDefinitions54 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategoriesDefinitions61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CategoriesDefinitions__CategoriesAssignment_in_ruleCategoriesDefinitions91 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleCategories_in_entryRuleCategories119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategories126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__Group__0_in_ruleCategories156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategory_in_entryRuleCategory183 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCategory190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Category__NameAssignment_in_ruleCategory220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCatRef_in_entryRuleCatRef249 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCatRef256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CatRef__Group__0_in_ruleCatRef286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__Group__0__Impl_in_rule__Categories__Group__0320 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Categories__Group__1_in_rule__Categories__Group__0323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__NameAssignment_0_in_rule__Categories__Group__0__Impl350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__Group__1__Impl_in_rule__Categories__Group__1380 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__Categories__Group__2_in_rule__Categories__Group__1383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftSquareBracket_in_rule__Categories__Group__1__Impl411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__Group__2__Impl_in_rule__Categories__Group__2442 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__Categories__Group__3_in_rule__Categories__Group__2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Categories__CategoryAssignment_2_in_rule__Categories__Group__2__Impl474 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Categories__CategoryAssignment_2_in_rule__Categories__Group__2__Impl486 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_rule__Categories__Group__3__Impl_in_rule__Categories__Group__3519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RightSquareBracket_in_rule__Categories__Group__3__Impl547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CatRef__Group__0__Impl_in_rule__CatRef__Group__0587 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__CatRef__Group__1_in_rule__CatRef__Group__0590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CatRef__Group__0__Impl617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CatRef__Group__1__Impl_in_rule__CatRef__Group__1646 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__CatRef__Group__2_in_rule__CatRef__Group__1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FullStop_in_rule__CatRef__Group__1__Impl677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CatRef__Group__2__Impl_in_rule__CatRef__Group__2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__CatRef__Group__2__Impl735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategories_in_rule__CategoriesDefinitions__CategoriesAssignment775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Categories__NameAssignment_0806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCategory_in_rule__Categories__CategoryAssignment_2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Category__NameAssignment868 = new BitSet(new long[]{0x0000000000000002L});

}