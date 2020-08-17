package org.osate.alisa.common.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.osate.alisa.common.services.CommonGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
public class InternalCommonParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_REAL_LIT", "RULE_DIGIT", "RULE_EXPONENT", "RULE_INT_EXPONENT", "RULE_EXTENDED_DIGIT", "RULE_BASED_INTEGER", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'description'", "'this'", "'boolean'", "'integer'", "'units'", "'real'", "'string'", "'model'", "'element'", "'#'", "'.'", "'%'", "'in'", "'img'", "'/'", "'or'", "'||'", "'and'", "'&&'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'><'", "'+'", "'-'", "'*'", "'div'", "'mod'", "'not'", "'('", "','", "')'", "'['", "'..'", "'delta'", "']'", "'if'", "'then'", "'else'", "'endif'", "'true'", "'false'", "'::'"
    };
    public static final int T__50=50;
    public static final int RULE_INT_EXPONENT=10;
    public static final int T__19=19;
    public static final int T__59=59;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_BASED_INTEGER=12;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_DIGIT=8;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__62=62;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_REAL_LIT=7;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=14;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=15;
    public static final int RULE_ANY_OTHER=16;
    public static final int RULE_EXPONENT=9;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int RULE_EXTENDED_DIGIT=11;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalCommonParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCommonParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCommonParser.tokenNames; }
    public String getGrammarFileName() { return "InternalCommon.g"; }



     	private CommonGrammarAccess grammarAccess;

        public InternalCommonParser(TokenStream input, CommonGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Description";
       	}

       	@Override
       	protected CommonGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleDescription"
    // InternalCommon.g:85:1: entryRuleDescription returns [EObject current=null] : iv_ruleDescription= ruleDescription EOF ;
    public final EObject entryRuleDescription() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescription = null;


        try {
            // InternalCommon.g:85:52: (iv_ruleDescription= ruleDescription EOF )
            // InternalCommon.g:86:2: iv_ruleDescription= ruleDescription EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescription=ruleDescription();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescription; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCommon.g:92:1: ruleDescription returns [EObject current=null] : (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ ) ;
    public final EObject ruleDescription() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_description_1_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:98:2: ( (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ ) )
            // InternalCommon.g:99:2: (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ )
            {
            // InternalCommon.g:99:2: (otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+ )
            // InternalCommon.g:100:3: otherlv_0= 'description' ( (lv_description_1_0= ruleDescriptionElement ) )+
            {
            otherlv_0=(Token)match(input,17,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDescriptionAccess().getDescriptionKeyword_0());
              		
            }
            // InternalCommon.g:104:3: ( (lv_description_1_0= ruleDescriptionElement ) )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)||LA1_0==18||LA1_0==30) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalCommon.g:105:4: (lv_description_1_0= ruleDescriptionElement )
            	    {
            	    // InternalCommon.g:105:4: (lv_description_1_0= ruleDescriptionElement )
            	    // InternalCommon.g:106:5: lv_description_1_0= ruleDescriptionElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDescriptionAccess().getDescriptionDescriptionElementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_description_1_0=ruleDescriptionElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDescriptionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"description",
            	      						lv_description_1_0,
            	      						"org.osate.alisa.common.Common.DescriptionElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDescription"


    // $ANTLR start "entryRuleDescriptionElement"
    // InternalCommon.g:127:1: entryRuleDescriptionElement returns [EObject current=null] : iv_ruleDescriptionElement= ruleDescriptionElement EOF ;
    public final EObject entryRuleDescriptionElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDescriptionElement = null;


        try {
            // InternalCommon.g:127:59: (iv_ruleDescriptionElement= ruleDescriptionElement EOF )
            // InternalCommon.g:128:2: iv_ruleDescriptionElement= ruleDescriptionElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDescriptionElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDescriptionElement=ruleDescriptionElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDescriptionElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCommon.g:134:1: ruleDescriptionElement returns [EObject current=null] : ( ( (lv_text_0_0= RULE_STRING ) ) | ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) ) | ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) ) | ( (lv_showValue_3_0= ruleShowValue ) ) ) ;
    public final EObject ruleDescriptionElement() throws RecognitionException {
        EObject current = null;

        Token lv_text_0_0=null;
        Token lv_thisTarget_1_0=null;
        EObject lv_image_2_0 = null;

        EObject lv_showValue_3_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:140:2: ( ( ( (lv_text_0_0= RULE_STRING ) ) | ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) ) | ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) ) | ( (lv_showValue_3_0= ruleShowValue ) ) ) )
            // InternalCommon.g:141:2: ( ( (lv_text_0_0= RULE_STRING ) ) | ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) ) | ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) ) | ( (lv_showValue_3_0= ruleShowValue ) ) )
            {
            // InternalCommon.g:141:2: ( ( (lv_text_0_0= RULE_STRING ) ) | ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) ) | ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) ) | ( (lv_showValue_3_0= ruleShowValue ) ) )
            int alt2=4;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) && (synpred1_InternalCommon())) {
                alt2=2;
            }
            else if ( (LA2_0==30) && (synpred2_InternalCommon())) {
                alt2=3;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=4;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalCommon.g:142:3: ( (lv_text_0_0= RULE_STRING ) )
                    {
                    // InternalCommon.g:142:3: ( (lv_text_0_0= RULE_STRING ) )
                    // InternalCommon.g:143:4: (lv_text_0_0= RULE_STRING )
                    {
                    // InternalCommon.g:143:4: (lv_text_0_0= RULE_STRING )
                    // InternalCommon.g:144:5: lv_text_0_0= RULE_STRING
                    {
                    lv_text_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_text_0_0, grammarAccess.getDescriptionElementAccess().getTextSTRINGTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDescriptionElementRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"text",
                      						lv_text_0_0,
                      						"org.eclipse.xtext.common.Terminals.STRING");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCommon.g:161:3: ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) )
                    {
                    // InternalCommon.g:161:3: ( ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' ) )
                    // InternalCommon.g:162:4: ( ( 'this' ) )=> (lv_thisTarget_1_0= 'this' )
                    {
                    // InternalCommon.g:166:4: (lv_thisTarget_1_0= 'this' )
                    // InternalCommon.g:167:5: lv_thisTarget_1_0= 'this'
                    {
                    lv_thisTarget_1_0=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_thisTarget_1_0, grammarAccess.getDescriptionElementAccess().getThisTargetThisKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDescriptionElementRule());
                      					}
                      					setWithLastConsumed(current, "thisTarget", true, "this");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCommon.g:180:3: ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) )
                    {
                    // InternalCommon.g:180:3: ( ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference ) )
                    // InternalCommon.g:181:4: ( ( ruleImageReference ) )=> (lv_image_2_0= ruleImageReference )
                    {
                    // InternalCommon.g:185:4: (lv_image_2_0= ruleImageReference )
                    // InternalCommon.g:186:5: lv_image_2_0= ruleImageReference
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDescriptionElementAccess().getImageImageReferenceParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_image_2_0=ruleImageReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      					}
                      					set(
                      						current,
                      						"image",
                      						lv_image_2_0,
                      						"org.osate.alisa.common.Common.ImageReference");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCommon.g:204:3: ( (lv_showValue_3_0= ruleShowValue ) )
                    {
                    // InternalCommon.g:204:3: ( (lv_showValue_3_0= ruleShowValue ) )
                    // InternalCommon.g:205:4: (lv_showValue_3_0= ruleShowValue )
                    {
                    // InternalCommon.g:205:4: (lv_showValue_3_0= ruleShowValue )
                    // InternalCommon.g:206:5: lv_showValue_3_0= ruleShowValue
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDescriptionElementAccess().getShowValueShowValueParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_showValue_3_0=ruleShowValue();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDescriptionElementRule());
                      					}
                      					set(
                      						current,
                      						"showValue",
                      						lv_showValue_3_0,
                      						"org.osate.alisa.common.Common.ShowValue");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDescriptionElement"


    // $ANTLR start "entryRuleTypeRef"
    // InternalCommon.g:227:1: entryRuleTypeRef returns [EObject current=null] : iv_ruleTypeRef= ruleTypeRef EOF ;
    public final EObject entryRuleTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeRef = null;


        try {
            // InternalCommon.g:227:48: (iv_ruleTypeRef= ruleTypeRef EOF )
            // InternalCommon.g:228:2: iv_ruleTypeRef= ruleTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeRef=ruleTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeRef"


    // $ANTLR start "ruleTypeRef"
    // InternalCommon.g:234:1: ruleTypeRef returns [EObject current=null] : ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) ;
    public final EObject ruleTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;


        	enterRule();

        try {
            // InternalCommon.g:240:2: ( ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ) )
            // InternalCommon.g:241:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            {
            // InternalCommon.g:241:2: ( ( () otherlv_1= 'boolean' ) | ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | ( () otherlv_11= 'string' ) | ( () otherlv_13= 'model' otherlv_14= 'element' ) | ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            int alt5=6;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt5=1;
                }
                break;
            case 20:
                {
                alt5=2;
                }
                break;
            case 22:
                {
                alt5=3;
                }
                break;
            case 23:
                {
                alt5=4;
                }
                break;
            case 24:
                {
                alt5=5;
                }
                break;
            case RULE_ID:
                {
                alt5=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalCommon.g:242:3: ( () otherlv_1= 'boolean' )
                    {
                    // InternalCommon.g:242:3: ( () otherlv_1= 'boolean' )
                    // InternalCommon.g:243:4: () otherlv_1= 'boolean'
                    {
                    // InternalCommon.g:243:4: ()
                    // InternalCommon.g:244:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getAadlBooleanAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,19,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeRefAccess().getBooleanKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalCommon.g:256:3: ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // InternalCommon.g:256:3: ( () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // InternalCommon.g:257:4: () otherlv_3= 'integer' (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    // InternalCommon.g:257:4: ()
                    // InternalCommon.g:258:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getAadlIntegerAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,20,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getTypeRefAccess().getIntegerKeyword_1_1());
                      			
                    }
                    // InternalCommon.g:268:4: (otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==21) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // InternalCommon.g:269:5: otherlv_4= 'units' ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            otherlv_4=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getTypeRefAccess().getUnitsKeyword_1_2_0());
                              				
                            }
                            // InternalCommon.g:273:5: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // InternalCommon.g:274:6: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // InternalCommon.g:274:6: ( ruleAADLPROPERTYREFERENCE )
                            // InternalCommon.g:275:7: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getTypeRefRule());
                              							}
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_1_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            ruleAADLPROPERTYREFERENCE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalCommon.g:292:3: ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // InternalCommon.g:292:3: ( () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // InternalCommon.g:293:4: () otherlv_7= 'real' (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    // InternalCommon.g:293:4: ()
                    // InternalCommon.g:294:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getAadlRealAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getTypeRefAccess().getRealKeyword_2_1());
                      			
                    }
                    // InternalCommon.g:304:4: (otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==21) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // InternalCommon.g:305:5: otherlv_8= 'units' ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            otherlv_8=(Token)match(input,21,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_8, grammarAccess.getTypeRefAccess().getUnitsKeyword_2_2_0());
                              				
                            }
                            // InternalCommon.g:309:5: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // InternalCommon.g:310:6: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // InternalCommon.g:310:6: ( ruleAADLPROPERTYREFERENCE )
                            // InternalCommon.g:311:7: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getTypeRefRule());
                              							}
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getTypeRefAccess().getReferencedUnitsTypeUnitsTypeCrossReference_2_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            ruleAADLPROPERTYREFERENCE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalCommon.g:328:3: ( () otherlv_11= 'string' )
                    {
                    // InternalCommon.g:328:3: ( () otherlv_11= 'string' )
                    // InternalCommon.g:329:4: () otherlv_11= 'string'
                    {
                    // InternalCommon.g:329:4: ()
                    // InternalCommon.g:330:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getAadlStringAction_3_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getTypeRefAccess().getStringKeyword_3_1());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalCommon.g:342:3: ( () otherlv_13= 'model' otherlv_14= 'element' )
                    {
                    // InternalCommon.g:342:3: ( () otherlv_13= 'model' otherlv_14= 'element' )
                    // InternalCommon.g:343:4: () otherlv_13= 'model' otherlv_14= 'element'
                    {
                    // InternalCommon.g:343:4: ()
                    // InternalCommon.g:344:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getModelRefAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_13=(Token)match(input,24,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getTypeRefAccess().getModelKeyword_4_1());
                      			
                    }
                    otherlv_14=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getTypeRefAccess().getElementKeyword_4_2());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalCommon.g:360:3: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    {
                    // InternalCommon.g:360:3: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
                    // InternalCommon.g:361:4: () ( ( ruleAADLPROPERTYREFERENCE ) )
                    {
                    // InternalCommon.g:361:4: ()
                    // InternalCommon.g:362:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTypeRefAccess().getTypeRefAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCommon.g:368:4: ( ( ruleAADLPROPERTYREFERENCE ) )
                    // InternalCommon.g:369:5: ( ruleAADLPROPERTYREFERENCE )
                    {
                    // InternalCommon.g:369:5: ( ruleAADLPROPERTYREFERENCE )
                    // InternalCommon.g:370:6: ruleAADLPROPERTYREFERENCE
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTypeRefRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeRefAccess().getRefPropertyTypeCrossReference_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleAADLPROPERTYREFERENCE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleTypeRef"


    // $ANTLR start "entryRulePropertyRef"
    // InternalCommon.g:389:1: entryRulePropertyRef returns [EObject current=null] : iv_rulePropertyRef= rulePropertyRef EOF ;
    public final EObject entryRulePropertyRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyRef = null;


        try {
            // InternalCommon.g:389:52: (iv_rulePropertyRef= rulePropertyRef EOF )
            // InternalCommon.g:390:2: iv_rulePropertyRef= rulePropertyRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPropertyRefRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePropertyRef=rulePropertyRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePropertyRef; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePropertyRef"


    // $ANTLR start "rulePropertyRef"
    // InternalCommon.g:396:1: rulePropertyRef returns [EObject current=null] : ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject rulePropertyRef() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalCommon.g:402:2: ( ( () ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // InternalCommon.g:403:2: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // InternalCommon.g:403:2: ( () ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // InternalCommon.g:404:3: () ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // InternalCommon.g:404:3: ()
            // InternalCommon.g:405:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPropertyRefAccess().getPropertyRefAction_0(),
              					current);
              			
            }

            }

            // InternalCommon.g:411:3: ( ( ruleAADLPROPERTYREFERENCE ) )
            // InternalCommon.g:412:4: ( ruleAADLPROPERTYREFERENCE )
            {
            // InternalCommon.g:412:4: ( ruleAADLPROPERTYREFERENCE )
            // InternalCommon.g:413:5: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPropertyRefRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPropertyRefAccess().getRefPropertyCrossReference_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulePropertyRef"


    // $ANTLR start "entryRuleAModelOrPropertyReference"
    // InternalCommon.g:431:1: entryRuleAModelOrPropertyReference returns [EObject current=null] : iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF ;
    public final EObject entryRuleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelOrPropertyReference = null;


        try {
            // InternalCommon.g:431:66: (iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF )
            // InternalCommon.g:432:2: iv_ruleAModelOrPropertyReference= ruleAModelOrPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelOrPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAModelOrPropertyReference=ruleAModelOrPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelOrPropertyReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAModelOrPropertyReference"


    // $ANTLR start "ruleAModelOrPropertyReference"
    // InternalCommon.g:438:1: ruleAModelOrPropertyReference returns [EObject current=null] : ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) ;
    public final EObject ruleAModelOrPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AModelReference_0 = null;

        EObject this_APropertyReference_4 = null;



        	enterRule();

        try {
            // InternalCommon.g:444:2: ( ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference ) )
            // InternalCommon.g:445:2: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            {
            // InternalCommon.g:445:2: ( (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? ) | this_APropertyReference_4= ruleAPropertyReference )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==26) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalCommon.g:446:3: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    {
                    // InternalCommon.g:446:3: (this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )? )
                    // InternalCommon.g:447:4: this_AModelReference_0= ruleAModelReference ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAModelReferenceParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_8);
                    this_AModelReference_0=ruleAModelReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_AModelReference_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalCommon.g:455:4: ( ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==26) && (synpred3_InternalCommon())) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalCommon.g:456:5: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) ) ( ( ruleAADLPROPERTYREFERENCE ) )
                            {
                            // InternalCommon.g:456:5: ( ( ( () '#' ) )=> ( () otherlv_2= '#' ) )
                            // InternalCommon.g:457:6: ( ( () '#' ) )=> ( () otherlv_2= '#' )
                            {
                            // InternalCommon.g:463:6: ( () otherlv_2= '#' )
                            // InternalCommon.g:464:7: () otherlv_2= '#'
                            {
                            // InternalCommon.g:464:7: ()
                            // InternalCommon.g:465:8: 
                            {
                            if ( state.backtracking==0 ) {

                              								current = forceCreateModelElementAndSet(
                              									grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceModelElementReferenceAction_0_1_0_0_0(),
                              									current);
                              							
                            }

                            }

                            otherlv_2=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(otherlv_2, grammarAccess.getAModelOrPropertyReferenceAccess().getNumberSignKeyword_0_1_0_0_1());
                              						
                            }

                            }


                            }

                            // InternalCommon.g:477:5: ( ( ruleAADLPROPERTYREFERENCE ) )
                            // InternalCommon.g:478:6: ( ruleAADLPROPERTYREFERENCE )
                            {
                            // InternalCommon.g:478:6: ( ruleAADLPROPERTYREFERENCE )
                            // InternalCommon.g:479:7: ruleAADLPROPERTYREFERENCE
                            {
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAModelOrPropertyReferenceRule());
                              							}
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_0_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            ruleAADLPROPERTYREFERENCE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCommon.g:496:3: this_APropertyReference_4= ruleAPropertyReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAModelOrPropertyReferenceAccess().getAPropertyReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_APropertyReference_4=ruleAPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_APropertyReference_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAModelOrPropertyReference"


    // $ANTLR start "entryRuleAModelReference"
    // InternalCommon.g:508:1: entryRuleAModelReference returns [EObject current=null] : iv_ruleAModelReference= ruleAModelReference EOF ;
    public final EObject entryRuleAModelReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAModelReference = null;


        try {
            // InternalCommon.g:508:56: (iv_ruleAModelReference= ruleAModelReference EOF )
            // InternalCommon.g:509:2: iv_ruleAModelReference= ruleAModelReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAModelReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAModelReference=ruleAModelReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAModelReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAModelReference"


    // $ANTLR start "ruleAModelReference"
    // InternalCommon.g:515:1: ruleAModelReference returns [EObject current=null] : ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) ;
    public final EObject ruleAModelReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalCommon.g:521:2: ( ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* ) )
            // InternalCommon.g:522:2: ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            {
            // InternalCommon.g:522:2: ( ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalCommon.g:523:3: ( ( ruleThisKeyword ) ) ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalCommon.g:523:3: ( ( ruleThisKeyword ) )
            // InternalCommon.g:524:4: ( ruleThisKeyword )
            {
            // InternalCommon.g:524:4: ( ruleThisKeyword )
            // InternalCommon.g:525:5: ruleThisKeyword
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAModelReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_9);
            ruleThisKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCommon.g:539:3: ( () otherlv_2= '.' ( (otherlv_3= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==27) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalCommon.g:540:4: () otherlv_2= '.' ( (otherlv_3= RULE_ID ) )
            	    {
            	    // InternalCommon.g:540:4: ()
            	    // InternalCommon.g:541:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAModelReferenceAccess().getAModelReferencePrevAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAModelReferenceAccess().getFullStopKeyword_1_1());
            	      			
            	    }
            	    // InternalCommon.g:551:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalCommon.g:552:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalCommon.g:552:5: (otherlv_3= RULE_ID )
            	    // InternalCommon.g:553:6: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getAModelReferenceRule());
            	      						}
            	      					
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_3, grammarAccess.getAModelReferenceAccess().getModelElementNamedElementCrossReference_1_2_0());
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAModelReference"


    // $ANTLR start "entryRuleAPropertyReference"
    // InternalCommon.g:569:1: entryRuleAPropertyReference returns [EObject current=null] : iv_ruleAPropertyReference= ruleAPropertyReference EOF ;
    public final EObject entryRuleAPropertyReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPropertyReference = null;


        try {
            // InternalCommon.g:569:59: (iv_ruleAPropertyReference= ruleAPropertyReference EOF )
            // InternalCommon.g:570:2: iv_ruleAPropertyReference= ruleAPropertyReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPropertyReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAPropertyReference=ruleAPropertyReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPropertyReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAPropertyReference"


    // $ANTLR start "ruleAPropertyReference"
    // InternalCommon.g:576:1: ruleAPropertyReference returns [EObject current=null] : ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) ;
    public final EObject ruleAPropertyReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalCommon.g:582:2: ( ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) ) )
            // InternalCommon.g:583:2: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            {
            // InternalCommon.g:583:2: ( () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) ) )
            // InternalCommon.g:584:3: () otherlv_1= '#' ( ( ruleAADLPROPERTYREFERENCE ) )
            {
            // InternalCommon.g:584:3: ()
            // InternalCommon.g:585:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAPropertyReferenceAccess().getAPropertyReferenceAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,26,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAPropertyReferenceAccess().getNumberSignKeyword_1());
              		
            }
            // InternalCommon.g:595:3: ( ( ruleAADLPROPERTYREFERENCE ) )
            // InternalCommon.g:596:4: ( ruleAADLPROPERTYREFERENCE )
            {
            // InternalCommon.g:596:4: ( ruleAADLPROPERTYREFERENCE )
            // InternalCommon.g:597:5: ruleAADLPROPERTYREFERENCE
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAPropertyReferenceRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAPropertyReferenceAccess().getPropertyAbstractNamedValueCrossReference_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAPropertyReference"


    // $ANTLR start "entryRuleAVariableReference"
    // InternalCommon.g:615:1: entryRuleAVariableReference returns [EObject current=null] : iv_ruleAVariableReference= ruleAVariableReference EOF ;
    public final EObject entryRuleAVariableReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAVariableReference = null;


        try {
            // InternalCommon.g:615:59: (iv_ruleAVariableReference= ruleAVariableReference EOF )
            // InternalCommon.g:616:2: iv_ruleAVariableReference= ruleAVariableReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAVariableReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAVariableReference=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAVariableReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAVariableReference"


    // $ANTLR start "ruleAVariableReference"
    // InternalCommon.g:622:1: ruleAVariableReference returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleAVariableReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalCommon.g:628:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalCommon.g:629:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalCommon.g:629:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalCommon.g:630:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalCommon.g:630:3: ()
            // InternalCommon.g:631:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAVariableReferenceAccess().getAVariableReferenceAction_0(),
              					current);
              			
            }

            }

            // InternalCommon.g:637:3: ( (otherlv_1= RULE_ID ) )
            // InternalCommon.g:638:4: (otherlv_1= RULE_ID )
            {
            // InternalCommon.g:638:4: (otherlv_1= RULE_ID )
            // InternalCommon.g:639:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAVariableReferenceRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getAVariableReferenceAccess().getVariableAVariableDeclarationCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAVariableReference"


    // $ANTLR start "entryRuleShowValue"
    // InternalCommon.g:654:1: entryRuleShowValue returns [EObject current=null] : iv_ruleShowValue= ruleShowValue EOF ;
    public final EObject entryRuleShowValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShowValue = null;


        try {
            // InternalCommon.g:654:50: (iv_ruleShowValue= ruleShowValue EOF )
            // InternalCommon.g:655:2: iv_ruleShowValue= ruleShowValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShowValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShowValue=ruleShowValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShowValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleShowValue"


    // $ANTLR start "ruleShowValue"
    // InternalCommon.g:661:1: ruleShowValue returns [EObject current=null] : ( ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )? ) ;
    public final EObject ruleShowValue() throws RecognitionException {
        EObject current = null;

        Token lv_convert_1_0=null;
        Token lv_drop_2_0=null;
        Token otherlv_3=null;
        EObject lv_expression_0_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:667:2: ( ( ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )? ) )
            // InternalCommon.g:668:2: ( ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )? )
            {
            // InternalCommon.g:668:2: ( ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )? )
            // InternalCommon.g:669:3: ( (lv_expression_0_0= ruleAVariableReference ) ) ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )?
            {
            // InternalCommon.g:669:3: ( (lv_expression_0_0= ruleAVariableReference ) )
            // InternalCommon.g:670:4: (lv_expression_0_0= ruleAVariableReference )
            {
            // InternalCommon.g:670:4: (lv_expression_0_0= ruleAVariableReference )
            // InternalCommon.g:671:5: lv_expression_0_0= ruleAVariableReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getShowValueAccess().getExpressionAVariableReferenceParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_expression_0_0=ruleAVariableReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getShowValueRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_0_0,
              						"org.osate.alisa.common.Common.AVariableReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCommon.g:688:3: ( ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=28 && LA10_0<=29)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalCommon.g:689:4: ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) ) ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalCommon.g:689:4: ( ( (lv_convert_1_0= '%' ) ) | ( (lv_drop_2_0= 'in' ) ) )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==28) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==29) ) {
                        alt9=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalCommon.g:690:5: ( (lv_convert_1_0= '%' ) )
                            {
                            // InternalCommon.g:690:5: ( (lv_convert_1_0= '%' ) )
                            // InternalCommon.g:691:6: (lv_convert_1_0= '%' )
                            {
                            // InternalCommon.g:691:6: (lv_convert_1_0= '%' )
                            // InternalCommon.g:692:7: lv_convert_1_0= '%'
                            {
                            lv_convert_1_0=(Token)match(input,28,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_convert_1_0, grammarAccess.getShowValueAccess().getConvertPercentSignKeyword_1_0_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getShowValueRule());
                              							}
                              							setWithLastConsumed(current, "convert", true, "%");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalCommon.g:705:5: ( (lv_drop_2_0= 'in' ) )
                            {
                            // InternalCommon.g:705:5: ( (lv_drop_2_0= 'in' ) )
                            // InternalCommon.g:706:6: (lv_drop_2_0= 'in' )
                            {
                            // InternalCommon.g:706:6: (lv_drop_2_0= 'in' )
                            // InternalCommon.g:707:7: lv_drop_2_0= 'in'
                            {
                            lv_drop_2_0=(Token)match(input,29,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_drop_2_0, grammarAccess.getShowValueAccess().getDropInKeyword_1_0_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getShowValueRule());
                              							}
                              							setWithLastConsumed(current, "drop", true, "in");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalCommon.g:720:4: ( (otherlv_3= RULE_ID ) )
                    // InternalCommon.g:721:5: (otherlv_3= RULE_ID )
                    {
                    // InternalCommon.g:721:5: (otherlv_3= RULE_ID )
                    // InternalCommon.g:722:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getShowValueRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getShowValueAccess().getUnitUnitLiteralCrossReference_1_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleShowValue"


    // $ANTLR start "entryRuleImageReference"
    // InternalCommon.g:738:1: entryRuleImageReference returns [EObject current=null] : iv_ruleImageReference= ruleImageReference EOF ;
    public final EObject entryRuleImageReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImageReference = null;


        try {
            // InternalCommon.g:738:55: (iv_ruleImageReference= ruleImageReference EOF )
            // InternalCommon.g:739:2: iv_ruleImageReference= ruleImageReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImageReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImageReference=ruleImageReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImageReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImageReference"


    // $ANTLR start "ruleImageReference"
    // InternalCommon.g:745:1: ruleImageReference returns [EObject current=null] : (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) ;
    public final EObject ruleImageReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_imgfile_1_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:751:2: ( (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) ) )
            // InternalCommon.g:752:2: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            {
            // InternalCommon.g:752:2: (otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) ) )
            // InternalCommon.g:753:3: otherlv_0= 'img' ( (lv_imgfile_1_0= ruleIMGREF ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImageReferenceAccess().getImgKeyword_0());
              		
            }
            // InternalCommon.g:757:3: ( (lv_imgfile_1_0= ruleIMGREF ) )
            // InternalCommon.g:758:4: (lv_imgfile_1_0= ruleIMGREF )
            {
            // InternalCommon.g:758:4: (lv_imgfile_1_0= ruleIMGREF )
            // InternalCommon.g:759:5: lv_imgfile_1_0= ruleIMGREF
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getImageReferenceAccess().getImgfileIMGREFParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_imgfile_1_0=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getImageReferenceRule());
              					}
              					set(
              						current,
              						"imgfile",
              						lv_imgfile_1_0,
              						"org.osate.alisa.common.Common.IMGREF");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleImageReference"


    // $ANTLR start "entryRuleIMGREF"
    // InternalCommon.g:780:1: entryRuleIMGREF returns [String current=null] : iv_ruleIMGREF= ruleIMGREF EOF ;
    public final String entryRuleIMGREF() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMGREF = null;


        try {
            // InternalCommon.g:780:46: (iv_ruleIMGREF= ruleIMGREF EOF )
            // InternalCommon.g:781:2: iv_ruleIMGREF= ruleIMGREF EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIMGREFRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIMGREF=ruleIMGREF();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIMGREF.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIMGREF"


    // $ANTLR start "ruleIMGREF"
    // InternalCommon.g:787:1: ruleIMGREF returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIMGREF() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;


        	enterRule();

        try {
            // InternalCommon.g:793:2: ( ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID ) )
            // InternalCommon.g:794:2: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            {
            // InternalCommon.g:794:2: ( (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID )
            // InternalCommon.g:795:3: (this_ID_0= RULE_ID kw= '/' )* this_ID_2= RULE_ID kw= '.' this_ID_4= RULE_ID
            {
            // InternalCommon.g:795:3: (this_ID_0= RULE_ID kw= '/' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==31) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // InternalCommon.g:796:4: this_ID_0= RULE_ID kw= '/'
            	    {
            	    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_0);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_0, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_0_0());
            	      			
            	    }
            	    kw=(Token)match(input,31,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getIMGREFAccess().getSolidusKeyword_0_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_2);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_2, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_1());
              		
            }
            kw=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getIMGREFAccess().getFullStopKeyword_2());
              		
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_4);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_4, grammarAccess.getIMGREFAccess().getIDTerminalRuleCall_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIMGREF"


    // $ANTLR start "entryRuleAExpression"
    // InternalCommon.g:832:1: entryRuleAExpression returns [EObject current=null] : iv_ruleAExpression= ruleAExpression EOF ;
    public final EObject entryRuleAExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAExpression = null;


        try {
            // InternalCommon.g:832:52: (iv_ruleAExpression= ruleAExpression EOF )
            // InternalCommon.g:833:2: iv_ruleAExpression= ruleAExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAExpression=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAExpression"


    // $ANTLR start "ruleAExpression"
    // InternalCommon.g:839:1: ruleAExpression returns [EObject current=null] : this_AOrExpression_0= ruleAOrExpression ;
    public final EObject ruleAExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AOrExpression_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:845:2: (this_AOrExpression_0= ruleAOrExpression )
            // InternalCommon.g:846:2: this_AOrExpression_0= ruleAOrExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getAExpressionAccess().getAOrExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_AOrExpression_0=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AOrExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAExpression"


    // $ANTLR start "entryRuleAOrExpression"
    // InternalCommon.g:857:1: entryRuleAOrExpression returns [EObject current=null] : iv_ruleAOrExpression= ruleAOrExpression EOF ;
    public final EObject entryRuleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAOrExpression = null;


        try {
            // InternalCommon.g:857:54: (iv_ruleAOrExpression= ruleAOrExpression EOF )
            // InternalCommon.g:858:2: iv_ruleAOrExpression= ruleAOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAOrExpression=ruleAOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAOrExpression"


    // $ANTLR start "ruleAOrExpression"
    // InternalCommon.g:864:1: ruleAOrExpression returns [EObject current=null] : (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) ;
    public final EObject ruleAOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAndExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:870:2: ( (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* ) )
            // InternalCommon.g:871:2: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            {
            // InternalCommon.g:871:2: (this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )* )
            // InternalCommon.g:872:3: this_AAndExpression_0= ruleAAndExpression ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAOrExpressionAccess().getAAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_13);
            this_AAndExpression_0=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCommon.g:880:3: ( ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==32) && (synpred4_InternalCommon())) {
                    alt12=1;
                }
                else if ( (LA12_0==33) && (synpred4_InternalCommon())) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalCommon.g:881:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) ) ( (lv_right_3_0= ruleAAndExpression ) )
            	    {
            	    // InternalCommon.g:881:4: ( ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) ) )
            	    // InternalCommon.g:882:5: ( ( () ( ( ruleOpOr ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    {
            	    // InternalCommon.g:892:5: ( () ( (lv_operator_2_0= ruleOpOr ) ) )
            	    // InternalCommon.g:893:6: () ( (lv_operator_2_0= ruleOpOr ) )
            	    {
            	    // InternalCommon.g:893:6: ()
            	    // InternalCommon.g:894:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAOrExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalCommon.g:900:6: ( (lv_operator_2_0= ruleOpOr ) )
            	    // InternalCommon.g:901:7: (lv_operator_2_0= ruleOpOr )
            	    {
            	    // InternalCommon.g:901:7: (lv_operator_2_0= ruleOpOr )
            	    // InternalCommon.g:902:8: lv_operator_2_0= ruleOpOr
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAOrExpressionAccess().getOperatorOpOrParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_operator_2_0=ruleOpOr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpOr");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalCommon.g:921:4: ( (lv_right_3_0= ruleAAndExpression ) )
            	    // InternalCommon.g:922:5: (lv_right_3_0= ruleAAndExpression )
            	    {
            	    // InternalCommon.g:922:5: (lv_right_3_0= ruleAAndExpression )
            	    // InternalCommon.g:923:6: lv_right_3_0= ruleAAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAOrExpressionAccess().getRightAAndExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_right_3_0=ruleAAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAOrExpression"


    // $ANTLR start "entryRuleOpOr"
    // InternalCommon.g:945:1: entryRuleOpOr returns [String current=null] : iv_ruleOpOr= ruleOpOr EOF ;
    public final String entryRuleOpOr() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpOr = null;


        try {
            // InternalCommon.g:945:44: (iv_ruleOpOr= ruleOpOr EOF )
            // InternalCommon.g:946:2: iv_ruleOpOr= ruleOpOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpOr=ruleOpOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpOr.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpOr"


    // $ANTLR start "ruleOpOr"
    // InternalCommon.g:952:1: ruleOpOr returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'or' | kw= '||' ) ;
    public final AntlrDatatypeRuleToken ruleOpOr() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalCommon.g:958:2: ( (kw= 'or' | kw= '||' ) )
            // InternalCommon.g:959:2: (kw= 'or' | kw= '||' )
            {
            // InternalCommon.g:959:2: (kw= 'or' | kw= '||' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            else if ( (LA13_0==33) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalCommon.g:960:3: kw= 'or'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOrAccess().getOrKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:966:3: kw= '||'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpOrAccess().getVerticalLineVerticalLineKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpOr"


    // $ANTLR start "entryRuleAAndExpression"
    // InternalCommon.g:975:1: entryRuleAAndExpression returns [EObject current=null] : iv_ruleAAndExpression= ruleAAndExpression EOF ;
    public final EObject entryRuleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAndExpression = null;


        try {
            // InternalCommon.g:975:55: (iv_ruleAAndExpression= ruleAAndExpression EOF )
            // InternalCommon.g:976:2: iv_ruleAAndExpression= ruleAAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAAndExpression=ruleAAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAAndExpression"


    // $ANTLR start "ruleAAndExpression"
    // InternalCommon.g:982:1: ruleAAndExpression returns [EObject current=null] : (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* ) ;
    public final EObject ruleAAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AEqualityExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:988:2: ( (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* ) )
            // InternalCommon.g:989:2: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* )
            {
            // InternalCommon.g:989:2: (this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )* )
            // InternalCommon.g:990:3: this_AEqualityExpression_0= ruleAEqualityExpression ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAAndExpressionAccess().getAEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_15);
            this_AEqualityExpression_0=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AEqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCommon.g:998:3: ( ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==34) && (synpred5_InternalCommon())) {
                    alt14=1;
                }
                else if ( (LA14_0==35) && (synpred5_InternalCommon())) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalCommon.g:999:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) ) ( (lv_right_3_0= ruleAEqualityExpression ) )
            	    {
            	    // InternalCommon.g:999:4: ( ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) ) )
            	    // InternalCommon.g:1000:5: ( ( () ( ( ruleOpAnd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    {
            	    // InternalCommon.g:1010:5: ( () ( (lv_operator_2_0= ruleOpAnd ) ) )
            	    // InternalCommon.g:1011:6: () ( (lv_operator_2_0= ruleOpAnd ) )
            	    {
            	    // InternalCommon.g:1011:6: ()
            	    // InternalCommon.g:1012:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAAndExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalCommon.g:1018:6: ( (lv_operator_2_0= ruleOpAnd ) )
            	    // InternalCommon.g:1019:7: (lv_operator_2_0= ruleOpAnd )
            	    {
            	    // InternalCommon.g:1019:7: (lv_operator_2_0= ruleOpAnd )
            	    // InternalCommon.g:1020:8: lv_operator_2_0= ruleOpAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAAndExpressionAccess().getOperatorOpAndParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_operator_2_0=ruleOpAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpAnd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalCommon.g:1039:4: ( (lv_right_3_0= ruleAEqualityExpression ) )
            	    // InternalCommon.g:1040:5: (lv_right_3_0= ruleAEqualityExpression )
            	    {
            	    // InternalCommon.g:1040:5: (lv_right_3_0= ruleAEqualityExpression )
            	    // InternalCommon.g:1041:6: lv_right_3_0= ruleAEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAAndExpressionAccess().getRightAEqualityExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_15);
            	    lv_right_3_0=ruleAEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AEqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAAndExpression"


    // $ANTLR start "entryRuleOpAnd"
    // InternalCommon.g:1063:1: entryRuleOpAnd returns [String current=null] : iv_ruleOpAnd= ruleOpAnd EOF ;
    public final String entryRuleOpAnd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAnd = null;


        try {
            // InternalCommon.g:1063:45: (iv_ruleOpAnd= ruleOpAnd EOF )
            // InternalCommon.g:1064:2: iv_ruleOpAnd= ruleOpAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAnd=ruleOpAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAnd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAnd"


    // $ANTLR start "ruleOpAnd"
    // InternalCommon.g:1070:1: ruleOpAnd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'and' | kw= '&&' ) ;
    public final AntlrDatatypeRuleToken ruleOpAnd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalCommon.g:1076:2: ( (kw= 'and' | kw= '&&' ) )
            // InternalCommon.g:1077:2: (kw= 'and' | kw= '&&' )
            {
            // InternalCommon.g:1077:2: (kw= 'and' | kw= '&&' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==34) ) {
                alt15=1;
            }
            else if ( (LA15_0==35) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalCommon.g:1078:3: kw= 'and'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAndAccess().getAndKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:1084:3: kw= '&&'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAndAccess().getAmpersandAmpersandKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpAnd"


    // $ANTLR start "entryRuleAEqualityExpression"
    // InternalCommon.g:1093:1: entryRuleAEqualityExpression returns [EObject current=null] : iv_ruleAEqualityExpression= ruleAEqualityExpression EOF ;
    public final EObject entryRuleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAEqualityExpression = null;


        try {
            // InternalCommon.g:1093:60: (iv_ruleAEqualityExpression= ruleAEqualityExpression EOF )
            // InternalCommon.g:1094:2: iv_ruleAEqualityExpression= ruleAEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAEqualityExpression=ruleAEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAEqualityExpression"


    // $ANTLR start "ruleAEqualityExpression"
    // InternalCommon.g:1100:1: ruleAEqualityExpression returns [EObject current=null] : (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) ;
    public final EObject ruleAEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ARelationalExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:1106:2: ( (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* ) )
            // InternalCommon.g:1107:2: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            {
            // InternalCommon.g:1107:2: (this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )* )
            // InternalCommon.g:1108:3: this_ARelationalExpression_0= ruleARelationalExpression ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getARelationalExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_16);
            this_ARelationalExpression_0=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ARelationalExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCommon.g:1116:3: ( ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==36) && (synpred6_InternalCommon())) {
                    alt16=1;
                }
                else if ( (LA16_0==37) && (synpred6_InternalCommon())) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalCommon.g:1117:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) ) ( (lv_right_3_0= ruleARelationalExpression ) )
            	    {
            	    // InternalCommon.g:1117:4: ( ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) ) )
            	    // InternalCommon.g:1118:5: ( ( () ( ( ruleOpEquality ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    {
            	    // InternalCommon.g:1128:5: ( () ( (lv_operator_2_0= ruleOpEquality ) ) )
            	    // InternalCommon.g:1129:6: () ( (lv_operator_2_0= ruleOpEquality ) )
            	    {
            	    // InternalCommon.g:1129:6: ()
            	    // InternalCommon.g:1130:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAEqualityExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalCommon.g:1136:6: ( (lv_operator_2_0= ruleOpEquality ) )
            	    // InternalCommon.g:1137:7: (lv_operator_2_0= ruleOpEquality )
            	    {
            	    // InternalCommon.g:1137:7: (lv_operator_2_0= ruleOpEquality )
            	    // InternalCommon.g:1138:8: lv_operator_2_0= ruleOpEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getOperatorOpEqualityParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_operator_2_0=ruleOpEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpEquality");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalCommon.g:1157:4: ( (lv_right_3_0= ruleARelationalExpression ) )
            	    // InternalCommon.g:1158:5: (lv_right_3_0= ruleARelationalExpression )
            	    {
            	    // InternalCommon.g:1158:5: (lv_right_3_0= ruleARelationalExpression )
            	    // InternalCommon.g:1159:6: lv_right_3_0= ruleARelationalExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAEqualityExpressionAccess().getRightARelationalExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_right_3_0=ruleARelationalExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.ARelationalExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAEqualityExpression"


    // $ANTLR start "entryRuleOpEquality"
    // InternalCommon.g:1181:1: entryRuleOpEquality returns [String current=null] : iv_ruleOpEquality= ruleOpEquality EOF ;
    public final String entryRuleOpEquality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpEquality = null;


        try {
            // InternalCommon.g:1181:50: (iv_ruleOpEquality= ruleOpEquality EOF )
            // InternalCommon.g:1182:2: iv_ruleOpEquality= ruleOpEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpEquality=ruleOpEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpEquality.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpEquality"


    // $ANTLR start "ruleOpEquality"
    // InternalCommon.g:1188:1: ruleOpEquality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '==' | kw= '!=' ) ;
    public final AntlrDatatypeRuleToken ruleOpEquality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalCommon.g:1194:2: ( (kw= '==' | kw= '!=' ) )
            // InternalCommon.g:1195:2: (kw= '==' | kw= '!=' )
            {
            // InternalCommon.g:1195:2: (kw= '==' | kw= '!=' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==36) ) {
                alt17=1;
            }
            else if ( (LA17_0==37) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalCommon.g:1196:3: kw= '=='
                    {
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getEqualsSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:1202:3: kw= '!='
                    {
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpEqualityAccess().getExclamationMarkEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpEquality"


    // $ANTLR start "entryRuleARelationalExpression"
    // InternalCommon.g:1211:1: entryRuleARelationalExpression returns [EObject current=null] : iv_ruleARelationalExpression= ruleARelationalExpression EOF ;
    public final EObject entryRuleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARelationalExpression = null;


        try {
            // InternalCommon.g:1211:62: (iv_ruleARelationalExpression= ruleARelationalExpression EOF )
            // InternalCommon.g:1212:2: iv_ruleARelationalExpression= ruleARelationalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARelationalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleARelationalExpression=ruleARelationalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARelationalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleARelationalExpression"


    // $ANTLR start "ruleARelationalExpression"
    // InternalCommon.g:1218:1: ruleARelationalExpression returns [EObject current=null] : (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) ;
    public final EObject ruleARelationalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AAdditiveExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:1224:2: ( (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* ) )
            // InternalCommon.g:1225:2: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            {
            // InternalCommon.g:1225:2: (this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )* )
            // InternalCommon.g:1226:3: this_AAdditiveExpression_0= ruleAAdditiveExpression ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getARelationalExpressionAccess().getAAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_17);
            this_AAdditiveExpression_0=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AAdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCommon.g:1234:3: ( ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==38) && (synpred7_InternalCommon())) {
                    alt18=1;
                }
                else if ( (LA18_0==39) && (synpred7_InternalCommon())) {
                    alt18=1;
                }
                else if ( (LA18_0==40) && (synpred7_InternalCommon())) {
                    alt18=1;
                }
                else if ( (LA18_0==41) && (synpred7_InternalCommon())) {
                    alt18=1;
                }
                else if ( (LA18_0==42) && (synpred7_InternalCommon())) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalCommon.g:1235:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) ) ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    {
            	    // InternalCommon.g:1235:4: ( ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) ) )
            	    // InternalCommon.g:1236:5: ( ( () ( ( ruleOpCompare ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    {
            	    // InternalCommon.g:1246:5: ( () ( (lv_operator_2_0= ruleOpCompare ) ) )
            	    // InternalCommon.g:1247:6: () ( (lv_operator_2_0= ruleOpCompare ) )
            	    {
            	    // InternalCommon.g:1247:6: ()
            	    // InternalCommon.g:1248:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getARelationalExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalCommon.g:1254:6: ( (lv_operator_2_0= ruleOpCompare ) )
            	    // InternalCommon.g:1255:7: (lv_operator_2_0= ruleOpCompare )
            	    {
            	    // InternalCommon.g:1255:7: (lv_operator_2_0= ruleOpCompare )
            	    // InternalCommon.g:1256:8: lv_operator_2_0= ruleOpCompare
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getARelationalExpressionAccess().getOperatorOpCompareParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_operator_2_0=ruleOpCompare();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpCompare");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalCommon.g:1275:4: ( (lv_right_3_0= ruleAAdditiveExpression ) )
            	    // InternalCommon.g:1276:5: (lv_right_3_0= ruleAAdditiveExpression )
            	    {
            	    // InternalCommon.g:1276:5: (lv_right_3_0= ruleAAdditiveExpression )
            	    // InternalCommon.g:1277:6: lv_right_3_0= ruleAAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getARelationalExpressionAccess().getRightAAdditiveExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_17);
            	    lv_right_3_0=ruleAAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getARelationalExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AAdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleARelationalExpression"


    // $ANTLR start "entryRuleOpCompare"
    // InternalCommon.g:1299:1: entryRuleOpCompare returns [String current=null] : iv_ruleOpCompare= ruleOpCompare EOF ;
    public final String entryRuleOpCompare() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpCompare = null;


        try {
            // InternalCommon.g:1299:49: (iv_ruleOpCompare= ruleOpCompare EOF )
            // InternalCommon.g:1300:2: iv_ruleOpCompare= ruleOpCompare EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpCompareRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpCompare=ruleOpCompare();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpCompare.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpCompare"


    // $ANTLR start "ruleOpCompare"
    // InternalCommon.g:1306:1: ruleOpCompare returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' ) ;
    public final AntlrDatatypeRuleToken ruleOpCompare() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalCommon.g:1312:2: ( (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' ) )
            // InternalCommon.g:1313:2: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' )
            {
            // InternalCommon.g:1313:2: (kw= '>=' | kw= '<=' | kw= '>' | kw= '<' | kw= '><' )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt19=1;
                }
                break;
            case 39:
                {
                alt19=2;
                }
                break;
            case 40:
                {
                alt19=3;
                }
                break;
            case 41:
                {
                alt19=4;
                }
                break;
            case 42:
                {
                alt19=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalCommon.g:1314:3: kw= '>='
                    {
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignEqualsSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:1320:3: kw= '<='
                    {
                    kw=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCommon.g:1326:3: kw= '>'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalCommon.g:1332:3: kw= '<'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getLessThanSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalCommon.g:1338:3: kw= '><'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpCompareAccess().getGreaterThanSignLessThanSignKeyword_4());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpCompare"


    // $ANTLR start "entryRuleAAdditiveExpression"
    // InternalCommon.g:1347:1: entryRuleAAdditiveExpression returns [EObject current=null] : iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF ;
    public final EObject entryRuleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAAdditiveExpression = null;


        try {
            // InternalCommon.g:1347:60: (iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF )
            // InternalCommon.g:1348:2: iv_ruleAAdditiveExpression= ruleAAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAAdditiveExpression=ruleAAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAAdditiveExpression"


    // $ANTLR start "ruleAAdditiveExpression"
    // InternalCommon.g:1354:1: ruleAAdditiveExpression returns [EObject current=null] : (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AMultiplicativeExpression_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:1360:2: ( (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* ) )
            // InternalCommon.g:1361:2: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            {
            // InternalCommon.g:1361:2: (this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )* )
            // InternalCommon.g:1362:3: this_AMultiplicativeExpression_0= ruleAMultiplicativeExpression ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getAMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_18);
            this_AMultiplicativeExpression_0=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AMultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCommon.g:1370:3: ( ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==43) && (synpred8_InternalCommon())) {
                    alt20=1;
                }
                else if ( (LA20_0==44) && (synpred8_InternalCommon())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalCommon.g:1371:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) ) ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    {
            	    // InternalCommon.g:1371:4: ( ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) ) )
            	    // InternalCommon.g:1372:5: ( ( () ( ( ruleOpAdd ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    {
            	    // InternalCommon.g:1382:5: ( () ( (lv_operator_2_0= ruleOpAdd ) ) )
            	    // InternalCommon.g:1383:6: () ( (lv_operator_2_0= ruleOpAdd ) )
            	    {
            	    // InternalCommon.g:1383:6: ()
            	    // InternalCommon.g:1384:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAAdditiveExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalCommon.g:1390:6: ( (lv_operator_2_0= ruleOpAdd ) )
            	    // InternalCommon.g:1391:7: (lv_operator_2_0= ruleOpAdd )
            	    {
            	    // InternalCommon.g:1391:7: (lv_operator_2_0= ruleOpAdd )
            	    // InternalCommon.g:1392:8: lv_operator_2_0= ruleOpAdd
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getOperatorOpAddParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_operator_2_0=ruleOpAdd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpAdd");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalCommon.g:1411:4: ( (lv_right_3_0= ruleAMultiplicativeExpression ) )
            	    // InternalCommon.g:1412:5: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    {
            	    // InternalCommon.g:1412:5: (lv_right_3_0= ruleAMultiplicativeExpression )
            	    // InternalCommon.g:1413:6: lv_right_3_0= ruleAMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAAdditiveExpressionAccess().getRightAMultiplicativeExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
            	    lv_right_3_0=ruleAMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AMultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAAdditiveExpression"


    // $ANTLR start "entryRuleOpAdd"
    // InternalCommon.g:1435:1: entryRuleOpAdd returns [String current=null] : iv_ruleOpAdd= ruleOpAdd EOF ;
    public final String entryRuleOpAdd() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpAdd = null;


        try {
            // InternalCommon.g:1435:45: (iv_ruleOpAdd= ruleOpAdd EOF )
            // InternalCommon.g:1436:2: iv_ruleOpAdd= ruleOpAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpAddRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpAdd=ruleOpAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpAdd.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpAdd"


    // $ANTLR start "ruleOpAdd"
    // InternalCommon.g:1442:1: ruleOpAdd returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '+' | kw= '-' ) ;
    public final AntlrDatatypeRuleToken ruleOpAdd() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalCommon.g:1448:2: ( (kw= '+' | kw= '-' ) )
            // InternalCommon.g:1449:2: (kw= '+' | kw= '-' )
            {
            // InternalCommon.g:1449:2: (kw= '+' | kw= '-' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==43) ) {
                alt21=1;
            }
            else if ( (LA21_0==44) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalCommon.g:1450:3: kw= '+'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:1456:3: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpAddAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpAdd"


    // $ANTLR start "entryRuleAMultiplicativeExpression"
    // InternalCommon.g:1465:1: entryRuleAMultiplicativeExpression returns [EObject current=null] : iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF ;
    public final EObject entryRuleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAMultiplicativeExpression = null;


        try {
            // InternalCommon.g:1465:66: (iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF )
            // InternalCommon.g:1466:2: iv_ruleAMultiplicativeExpression= ruleAMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAMultiplicativeExpression=ruleAMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAMultiplicativeExpression"


    // $ANTLR start "ruleAMultiplicativeExpression"
    // InternalCommon.g:1472:1: ruleAMultiplicativeExpression returns [EObject current=null] : (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* ) ;
    public final EObject ruleAMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AUnaryOperation_0 = null;

        AntlrDatatypeRuleToken lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:1478:2: ( (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* ) )
            // InternalCommon.g:1479:2: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* )
            {
            // InternalCommon.g:1479:2: (this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )* )
            // InternalCommon.g:1480:3: this_AUnaryOperation_0= ruleAUnaryOperation ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getAUnaryOperationParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_19);
            this_AUnaryOperation_0=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AUnaryOperation_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCommon.g:1488:3: ( ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==45) && (synpred9_InternalCommon())) {
                    alt22=1;
                }
                else if ( (LA22_0==31) && (synpred9_InternalCommon())) {
                    alt22=1;
                }
                else if ( (LA22_0==46) && (synpred9_InternalCommon())) {
                    alt22=1;
                }
                else if ( (LA22_0==47) && (synpred9_InternalCommon())) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalCommon.g:1489:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) ) ( (lv_right_3_0= ruleAUnaryOperation ) )
            	    {
            	    // InternalCommon.g:1489:4: ( ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) ) )
            	    // InternalCommon.g:1490:5: ( ( () ( ( ruleOpMulti ) ) ) )=> ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    {
            	    // InternalCommon.g:1500:5: ( () ( (lv_operator_2_0= ruleOpMulti ) ) )
            	    // InternalCommon.g:1501:6: () ( (lv_operator_2_0= ruleOpMulti ) )
            	    {
            	    // InternalCommon.g:1501:6: ()
            	    // InternalCommon.g:1502:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getAMultiplicativeExpressionAccess().getABinaryOperationLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalCommon.g:1508:6: ( (lv_operator_2_0= ruleOpMulti ) )
            	    // InternalCommon.g:1509:7: (lv_operator_2_0= ruleOpMulti )
            	    {
            	    // InternalCommon.g:1509:7: (lv_operator_2_0= ruleOpMulti )
            	    // InternalCommon.g:1510:8: lv_operator_2_0= ruleOpMulti
            	    {
            	    if ( state.backtracking==0 ) {

            	      								newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getOperatorOpMultiParserRuleCall_1_0_0_1_0());
            	      							
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_operator_2_0=ruleOpMulti();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      								}
            	      								set(
            	      									current,
            	      									"operator",
            	      									lv_operator_2_0,
            	      									"org.osate.alisa.common.Common.OpMulti");
            	      								afterParserOrEnumRuleCall();
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalCommon.g:1529:4: ( (lv_right_3_0= ruleAUnaryOperation ) )
            	    // InternalCommon.g:1530:5: (lv_right_3_0= ruleAUnaryOperation )
            	    {
            	    // InternalCommon.g:1530:5: (lv_right_3_0= ruleAUnaryOperation )
            	    // InternalCommon.g:1531:6: lv_right_3_0= ruleAUnaryOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAMultiplicativeExpressionAccess().getRightAUnaryOperationParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_right_3_0=ruleAUnaryOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.osate.alisa.common.Common.AUnaryOperation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAMultiplicativeExpression"


    // $ANTLR start "entryRuleOpMulti"
    // InternalCommon.g:1553:1: entryRuleOpMulti returns [String current=null] : iv_ruleOpMulti= ruleOpMulti EOF ;
    public final String entryRuleOpMulti() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpMulti = null;


        try {
            // InternalCommon.g:1553:47: (iv_ruleOpMulti= ruleOpMulti EOF )
            // InternalCommon.g:1554:2: iv_ruleOpMulti= ruleOpMulti EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpMultiRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpMulti=ruleOpMulti();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpMulti.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpMulti"


    // $ANTLR start "ruleOpMulti"
    // InternalCommon.g:1560:1: ruleOpMulti returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) ;
    public final AntlrDatatypeRuleToken ruleOpMulti() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalCommon.g:1566:2: ( (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' ) )
            // InternalCommon.g:1567:2: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            {
            // InternalCommon.g:1567:2: (kw= '*' | kw= '/' | kw= 'div' | kw= 'mod' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt23=1;
                }
                break;
            case 31:
                {
                alt23=2;
                }
                break;
            case 46:
                {
                alt23=3;
                }
                break;
            case 47:
                {
                alt23=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalCommon.g:1568:3: kw= '*'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getAsteriskKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:1574:3: kw= '/'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getSolidusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCommon.g:1580:3: kw= 'div'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getDivKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalCommon.g:1586:3: kw= 'mod'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpMultiAccess().getModKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpMulti"


    // $ANTLR start "entryRuleAUnaryOperation"
    // InternalCommon.g:1595:1: entryRuleAUnaryOperation returns [EObject current=null] : iv_ruleAUnaryOperation= ruleAUnaryOperation EOF ;
    public final EObject entryRuleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnaryOperation = null;


        try {
            // InternalCommon.g:1595:56: (iv_ruleAUnaryOperation= ruleAUnaryOperation EOF )
            // InternalCommon.g:1596:2: iv_ruleAUnaryOperation= ruleAUnaryOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnaryOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAUnaryOperation=ruleAUnaryOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnaryOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAUnaryOperation"


    // $ANTLR start "ruleAUnaryOperation"
    // InternalCommon.g:1602:1: ruleAUnaryOperation returns [EObject current=null] : ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression ) ;
    public final EObject ruleAUnaryOperation() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_operator_1_0 = null;

        EObject lv_operand_2_0 = null;

        EObject this_AUnitExpression_3 = null;



        	enterRule();

        try {
            // InternalCommon.g:1608:2: ( ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression ) )
            // InternalCommon.g:1609:2: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression )
            {
            // InternalCommon.g:1609:2: ( ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) ) | this_AUnitExpression_3= ruleAUnitExpression )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=43 && LA24_0<=44)||LA24_0==48) ) {
                alt24=1;
            }
            else if ( ((LA24_0>=RULE_STRING && LA24_0<=RULE_REAL_LIT)||LA24_0==18||LA24_0==26||LA24_0==49||LA24_0==52||LA24_0==56||(LA24_0>=60 && LA24_0<=61)) ) {
                alt24=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // InternalCommon.g:1610:3: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    {
                    // InternalCommon.g:1610:3: ( () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) ) )
                    // InternalCommon.g:1611:4: () ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) ) ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    {
                    // InternalCommon.g:1611:4: ()
                    // InternalCommon.g:1612:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAUnaryOperationAccess().getAUnaryOperationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCommon.g:1618:4: ( ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary ) )
                    // InternalCommon.g:1619:5: ( ( ruleOpUnary ) )=> (lv_operator_1_0= ruleOpUnary )
                    {
                    // InternalCommon.g:1623:5: (lv_operator_1_0= ruleOpUnary )
                    // InternalCommon.g:1624:6: lv_operator_1_0= ruleOpUnary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperatorOpUnaryParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_operator_1_0=ruleOpUnary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operator",
                      							lv_operator_1_0,
                      							"org.osate.alisa.common.Common.OpUnary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCommon.g:1641:4: ( (lv_operand_2_0= ruleAUnaryOperation ) )
                    // InternalCommon.g:1642:5: (lv_operand_2_0= ruleAUnaryOperation )
                    {
                    // InternalCommon.g:1642:5: (lv_operand_2_0= ruleAUnaryOperation )
                    // InternalCommon.g:1643:6: lv_operand_2_0= ruleAUnaryOperation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAUnaryOperationAccess().getOperandAUnaryOperationParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_2_0=ruleAUnaryOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAUnaryOperationRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_2_0,
                      							"org.osate.alisa.common.Common.AUnaryOperation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCommon.g:1662:3: this_AUnitExpression_3= ruleAUnitExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAUnaryOperationAccess().getAUnitExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AUnitExpression_3=ruleAUnitExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AUnitExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAUnaryOperation"


    // $ANTLR start "entryRuleOpUnary"
    // InternalCommon.g:1674:1: entryRuleOpUnary returns [String current=null] : iv_ruleOpUnary= ruleOpUnary EOF ;
    public final String entryRuleOpUnary() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOpUnary = null;


        try {
            // InternalCommon.g:1674:47: (iv_ruleOpUnary= ruleOpUnary EOF )
            // InternalCommon.g:1675:2: iv_ruleOpUnary= ruleOpUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOpUnaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOpUnary=ruleOpUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOpUnary.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOpUnary"


    // $ANTLR start "ruleOpUnary"
    // InternalCommon.g:1681:1: ruleOpUnary returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'not' | kw= '-' | kw= '+' ) ;
    public final AntlrDatatypeRuleToken ruleOpUnary() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalCommon.g:1687:2: ( (kw= 'not' | kw= '-' | kw= '+' ) )
            // InternalCommon.g:1688:2: (kw= 'not' | kw= '-' | kw= '+' )
            {
            // InternalCommon.g:1688:2: (kw= 'not' | kw= '-' | kw= '+' )
            int alt25=3;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt25=1;
                }
                break;
            case 44:
                {
                alt25=2;
                }
                break;
            case 43:
                {
                alt25=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalCommon.g:1689:3: kw= 'not'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getNotKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:1695:3: kw= '-'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCommon.g:1701:3: kw= '+'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getOpUnaryAccess().getPlusSignKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleOpUnary"


    // $ANTLR start "entryRuleAUnitExpression"
    // InternalCommon.g:1710:1: entryRuleAUnitExpression returns [EObject current=null] : iv_ruleAUnitExpression= ruleAUnitExpression EOF ;
    public final EObject entryRuleAUnitExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAUnitExpression = null;


        try {
            // InternalCommon.g:1710:56: (iv_ruleAUnitExpression= ruleAUnitExpression EOF )
            // InternalCommon.g:1711:2: iv_ruleAUnitExpression= ruleAUnitExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAUnitExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAUnitExpression=ruleAUnitExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAUnitExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAUnitExpression"


    // $ANTLR start "ruleAUnitExpression"
    // InternalCommon.g:1717:1: ruleAUnitExpression returns [EObject current=null] : (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleAUnitExpression() throws RecognitionException {
        EObject current = null;

        Token lv_convert_2_0=null;
        Token lv_drop_3_0=null;
        Token otherlv_4=null;
        EObject this_APrimaryExpression_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:1723:2: ( (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? ) )
            // InternalCommon.g:1724:2: (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            {
            // InternalCommon.g:1724:2: (this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )? )
            // InternalCommon.g:1725:3: this_APrimaryExpression_0= ruleAPrimaryExpression ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAUnitExpressionAccess().getAPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_20);
            this_APrimaryExpression_0=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_APrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalCommon.g:1733:3: ( () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID||(LA27_0>=28 && LA27_0<=29)) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalCommon.g:1734:4: () ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )? ( (otherlv_4= RULE_ID ) )
                    {
                    // InternalCommon.g:1734:4: ()
                    // InternalCommon.g:1735:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAUnitExpressionAccess().getAUnitExpressionExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalCommon.g:1741:4: ( ( (lv_convert_2_0= '%' ) ) | ( (lv_drop_3_0= 'in' ) ) )?
                    int alt26=3;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==28) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==29) ) {
                        alt26=2;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalCommon.g:1742:5: ( (lv_convert_2_0= '%' ) )
                            {
                            // InternalCommon.g:1742:5: ( (lv_convert_2_0= '%' ) )
                            // InternalCommon.g:1743:6: (lv_convert_2_0= '%' )
                            {
                            // InternalCommon.g:1743:6: (lv_convert_2_0= '%' )
                            // InternalCommon.g:1744:7: lv_convert_2_0= '%'
                            {
                            lv_convert_2_0=(Token)match(input,28,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_convert_2_0, grammarAccess.getAUnitExpressionAccess().getConvertPercentSignKeyword_1_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAUnitExpressionRule());
                              							}
                              							setWithLastConsumed(current, "convert", true, "%");
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalCommon.g:1757:5: ( (lv_drop_3_0= 'in' ) )
                            {
                            // InternalCommon.g:1757:5: ( (lv_drop_3_0= 'in' ) )
                            // InternalCommon.g:1758:6: (lv_drop_3_0= 'in' )
                            {
                            // InternalCommon.g:1758:6: (lv_drop_3_0= 'in' )
                            // InternalCommon.g:1759:7: lv_drop_3_0= 'in'
                            {
                            lv_drop_3_0=(Token)match(input,29,FOLLOW_6); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_drop_3_0, grammarAccess.getAUnitExpressionAccess().getDropInKeyword_1_1_1_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAUnitExpressionRule());
                              							}
                              							setWithLastConsumed(current, "drop", true, "in");
                              						
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalCommon.g:1772:4: ( (otherlv_4= RULE_ID ) )
                    // InternalCommon.g:1773:5: (otherlv_4= RULE_ID )
                    {
                    // InternalCommon.g:1773:5: (otherlv_4= RULE_ID )
                    // InternalCommon.g:1774:6: otherlv_4= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAUnitExpressionRule());
                      						}
                      					
                    }
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_4, grammarAccess.getAUnitExpressionAccess().getUnitUnitLiteralCrossReference_1_2_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAUnitExpression"


    // $ANTLR start "entryRuleAPrimaryExpression"
    // InternalCommon.g:1790:1: entryRuleAPrimaryExpression returns [EObject current=null] : iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF ;
    public final EObject entryRuleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAPrimaryExpression = null;


        try {
            // InternalCommon.g:1790:59: (iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF )
            // InternalCommon.g:1791:2: iv_ruleAPrimaryExpression= ruleAPrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAPrimaryExpression=ruleAPrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAPrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAPrimaryExpression"


    // $ANTLR start "ruleAPrimaryExpression"
    // InternalCommon.g:1797:1: ruleAPrimaryExpression returns [EObject current=null] : (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression ) ;
    public final EObject ruleAPrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ALiteral_0 = null;

        EObject this_AVariableReference_1 = null;

        EObject this_AModelOrPropertyReference_2 = null;

        EObject this_AFunctionCall_3 = null;

        EObject this_ARangeExpression_4 = null;

        EObject this_AIfExpression_5 = null;

        EObject this_AParenthesizedExpression_6 = null;



        	enterRule();

        try {
            // InternalCommon.g:1803:2: ( (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression ) )
            // InternalCommon.g:1804:2: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression )
            {
            // InternalCommon.g:1804:2: (this_ALiteral_0= ruleALiteral | this_AVariableReference_1= ruleAVariableReference | this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference | this_AFunctionCall_3= ruleAFunctionCall | this_ARangeExpression_4= ruleARangeExpression | this_AIfExpression_5= ruleAIfExpression | this_AParenthesizedExpression_6= ruleAParenthesizedExpression )
            int alt28=7;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INT:
            case RULE_REAL_LIT:
            case 60:
            case 61:
                {
                alt28=1;
                }
                break;
            case RULE_ID:
                {
                int LA28_2 = input.LA(2);

                if ( (LA28_2==27||LA28_2==49) ) {
                    alt28=4;
                }
                else if ( (LA28_2==EOF||LA28_2==RULE_ID||(LA28_2>=28 && LA28_2<=29)||(LA28_2>=31 && LA28_2<=47)||(LA28_2>=50 && LA28_2<=51)||(LA28_2>=53 && LA28_2<=55)||(LA28_2>=57 && LA28_2<=59)) ) {
                    alt28=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 2, input);

                    throw nvae;
                }
                }
                break;
            case 18:
            case 26:
                {
                alt28=3;
                }
                break;
            case 52:
                {
                alt28=5;
                }
                break;
            case 56:
                {
                alt28=6;
                }
                break;
            case 49:
                {
                alt28=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // InternalCommon.g:1805:3: this_ALiteral_0= ruleALiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getALiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ALiteral_0=ruleALiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ALiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:1814:3: this_AVariableReference_1= ruleAVariableReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAVariableReferenceParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AVariableReference_1=ruleAVariableReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AVariableReference_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCommon.g:1823:3: this_AModelOrPropertyReference_2= ruleAModelOrPropertyReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAModelOrPropertyReferenceParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AModelOrPropertyReference_2=ruleAModelOrPropertyReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AModelOrPropertyReference_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalCommon.g:1832:3: this_AFunctionCall_3= ruleAFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAFunctionCallParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AFunctionCall_3=ruleAFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AFunctionCall_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalCommon.g:1841:3: this_ARangeExpression_4= ruleARangeExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getARangeExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ARangeExpression_4=ruleARangeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ARangeExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalCommon.g:1850:3: this_AIfExpression_5= ruleAIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAIfExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AIfExpression_5=ruleAIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AIfExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalCommon.g:1859:3: this_AParenthesizedExpression_6= ruleAParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAPrimaryExpressionAccess().getAParenthesizedExpressionParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AParenthesizedExpression_6=ruleAParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AParenthesizedExpression_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAPrimaryExpression"


    // $ANTLR start "entryRuleAFunctionCall"
    // InternalCommon.g:1871:1: entryRuleAFunctionCall returns [EObject current=null] : iv_ruleAFunctionCall= ruleAFunctionCall EOF ;
    public final EObject entryRuleAFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAFunctionCall = null;


        try {
            // InternalCommon.g:1871:54: (iv_ruleAFunctionCall= ruleAFunctionCall EOF )
            // InternalCommon.g:1872:2: iv_ruleAFunctionCall= ruleAFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAFunctionCall=ruleAFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAFunctionCall"


    // $ANTLR start "ruleAFunctionCall"
    // InternalCommon.g:1878:1: ruleAFunctionCall returns [EObject current=null] : ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleAFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_function_1_0 = null;

        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:1884:2: ( ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalCommon.g:1885:2: ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalCommon.g:1885:2: ( () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')' )
            // InternalCommon.g:1886:3: () ( (lv_function_1_0= ruleQualifiedName ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalCommon.g:1886:3: ()
            // InternalCommon.g:1887:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAFunctionCallAccess().getAFunctionCallAction_0(),
              					current);
              			
            }

            }

            // InternalCommon.g:1893:3: ( (lv_function_1_0= ruleQualifiedName ) )
            // InternalCommon.g:1894:4: (lv_function_1_0= ruleQualifiedName )
            {
            // InternalCommon.g:1894:4: (lv_function_1_0= ruleQualifiedName )
            // InternalCommon.g:1895:5: lv_function_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAFunctionCallAccess().getFunctionQualifiedNameParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_function_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
              					}
              					set(
              						current,
              						"function",
              						lv_function_1_0,
              						"org.osate.alisa.common.Common.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,49,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAFunctionCallAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalCommon.g:1916:3: ( ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_REAL_LIT)||LA30_0==18||LA30_0==26||(LA30_0>=43 && LA30_0<=44)||(LA30_0>=48 && LA30_0<=49)||LA30_0==52||LA30_0==56||(LA30_0>=60 && LA30_0<=61)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalCommon.g:1917:4: ( (lv_arguments_3_0= ruleAExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )*
                    {
                    // InternalCommon.g:1917:4: ( (lv_arguments_3_0= ruleAExpression ) )
                    // InternalCommon.g:1918:5: (lv_arguments_3_0= ruleAExpression )
                    {
                    // InternalCommon.g:1918:5: (lv_arguments_3_0= ruleAExpression )
                    // InternalCommon.g:1919:6: lv_arguments_3_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_23);
                    lv_arguments_3_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
                      						}
                      						add(
                      							current,
                      							"arguments",
                      							lv_arguments_3_0,
                      							"org.osate.alisa.common.Common.AExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalCommon.g:1936:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==50) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalCommon.g:1937:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleAExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,50,FOLLOW_14); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getAFunctionCallAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalCommon.g:1941:5: ( (lv_arguments_5_0= ruleAExpression ) )
                    	    // InternalCommon.g:1942:6: (lv_arguments_5_0= ruleAExpression )
                    	    {
                    	    // InternalCommon.g:1942:6: (lv_arguments_5_0= ruleAExpression )
                    	    // InternalCommon.g:1943:7: lv_arguments_5_0= ruleAExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getAFunctionCallAccess().getArgumentsAExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_23);
                    	    lv_arguments_5_0=ruleAExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getAFunctionCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"arguments",
                    	      								lv_arguments_5_0,
                    	      								"org.osate.alisa.common.Common.AExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getAFunctionCallAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAFunctionCall"


    // $ANTLR start "entryRuleARangeExpression"
    // InternalCommon.g:1970:1: entryRuleARangeExpression returns [EObject current=null] : iv_ruleARangeExpression= ruleARangeExpression EOF ;
    public final EObject entryRuleARangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARangeExpression = null;


        try {
            // InternalCommon.g:1970:57: (iv_ruleARangeExpression= ruleARangeExpression EOF )
            // InternalCommon.g:1971:2: iv_ruleARangeExpression= ruleARangeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARangeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleARangeExpression=ruleARangeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARangeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleARangeExpression"


    // $ANTLR start "ruleARangeExpression"
    // InternalCommon.g:1977:1: ruleARangeExpression returns [EObject current=null] : ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' ) ;
    public final EObject ruleARangeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_minimum_2_0 = null;

        EObject lv_maximum_4_0 = null;

        EObject lv_delta_6_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:1983:2: ( ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' ) )
            // InternalCommon.g:1984:2: ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' )
            {
            // InternalCommon.g:1984:2: ( () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']' )
            // InternalCommon.g:1985:3: () otherlv_1= '[' ( (lv_minimum_2_0= ruleAExpression ) ) otherlv_3= '..' ( (lv_maximum_4_0= ruleAExpression ) ) ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )? otherlv_7= ']'
            {
            // InternalCommon.g:1985:3: ()
            // InternalCommon.g:1986:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getARangeExpressionAccess().getARangeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,52,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getARangeExpressionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalCommon.g:1996:3: ( (lv_minimum_2_0= ruleAExpression ) )
            // InternalCommon.g:1997:4: (lv_minimum_2_0= ruleAExpression )
            {
            // InternalCommon.g:1997:4: (lv_minimum_2_0= ruleAExpression )
            // InternalCommon.g:1998:5: lv_minimum_2_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getARangeExpressionAccess().getMinimumAExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_minimum_2_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
              					}
              					set(
              						current,
              						"minimum",
              						lv_minimum_2_0,
              						"org.osate.alisa.common.Common.AExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,53,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getARangeExpressionAccess().getFullStopFullStopKeyword_3());
              		
            }
            // InternalCommon.g:2019:3: ( (lv_maximum_4_0= ruleAExpression ) )
            // InternalCommon.g:2020:4: (lv_maximum_4_0= ruleAExpression )
            {
            // InternalCommon.g:2020:4: (lv_maximum_4_0= ruleAExpression )
            // InternalCommon.g:2021:5: lv_maximum_4_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getARangeExpressionAccess().getMaximumAExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_maximum_4_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
              					}
              					set(
              						current,
              						"maximum",
              						lv_maximum_4_0,
              						"org.osate.alisa.common.Common.AExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCommon.g:2038:3: ( ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==54) && (synpred11_InternalCommon())) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalCommon.g:2039:4: ( ( 'delta' )=>otherlv_5= 'delta' ) ( (lv_delta_6_0= ruleAExpression ) )
                    {
                    // InternalCommon.g:2039:4: ( ( 'delta' )=>otherlv_5= 'delta' )
                    // InternalCommon.g:2040:5: ( 'delta' )=>otherlv_5= 'delta'
                    {
                    otherlv_5=(Token)match(input,54,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getARangeExpressionAccess().getDeltaKeyword_5_0());
                      				
                    }

                    }

                    // InternalCommon.g:2046:4: ( (lv_delta_6_0= ruleAExpression ) )
                    // InternalCommon.g:2047:5: (lv_delta_6_0= ruleAExpression )
                    {
                    // InternalCommon.g:2047:5: (lv_delta_6_0= ruleAExpression )
                    // InternalCommon.g:2048:6: lv_delta_6_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getARangeExpressionAccess().getDeltaAExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_26);
                    lv_delta_6_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getARangeExpressionRule());
                      						}
                      						set(
                      							current,
                      							"delta",
                      							lv_delta_6_0,
                      							"org.osate.alisa.common.Common.AExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getARangeExpressionAccess().getRightSquareBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleARangeExpression"


    // $ANTLR start "entryRuleAIfExpression"
    // InternalCommon.g:2074:1: entryRuleAIfExpression returns [EObject current=null] : iv_ruleAIfExpression= ruleAIfExpression EOF ;
    public final EObject entryRuleAIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIfExpression = null;


        try {
            // InternalCommon.g:2074:54: (iv_ruleAIfExpression= ruleAIfExpression EOF )
            // InternalCommon.g:2075:2: iv_ruleAIfExpression= ruleAIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAIfExpression=ruleAIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAIfExpression"


    // $ANTLR start "ruleAIfExpression"
    // InternalCommon.g:2081:1: ruleAIfExpression returns [EObject current=null] : ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' ) ;
    public final EObject ruleAIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_if_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:2087:2: ( ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' ) )
            // InternalCommon.g:2088:2: ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' )
            {
            // InternalCommon.g:2088:2: ( () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif' )
            // InternalCommon.g:2089:3: () otherlv_1= 'if' ( (lv_if_2_0= ruleAExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleAExpression ) ) (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )? otherlv_7= 'endif'
            {
            // InternalCommon.g:2089:3: ()
            // InternalCommon.g:2090:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAIfExpressionAccess().getAConditionalAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAIfExpressionAccess().getIfKeyword_1());
              		
            }
            // InternalCommon.g:2100:3: ( (lv_if_2_0= ruleAExpression ) )
            // InternalCommon.g:2101:4: (lv_if_2_0= ruleAExpression )
            {
            // InternalCommon.g:2101:4: (lv_if_2_0= ruleAExpression )
            // InternalCommon.g:2102:5: lv_if_2_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAIfExpressionAccess().getIfAExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_if_2_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
              					}
              					set(
              						current,
              						"if",
              						lv_if_2_0,
              						"org.osate.alisa.common.Common.AExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,57,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAIfExpressionAccess().getThenKeyword_3());
              		
            }
            // InternalCommon.g:2123:3: ( (lv_then_4_0= ruleAExpression ) )
            // InternalCommon.g:2124:4: (lv_then_4_0= ruleAExpression )
            {
            // InternalCommon.g:2124:4: (lv_then_4_0= ruleAExpression )
            // InternalCommon.g:2125:5: lv_then_4_0= ruleAExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAIfExpressionAccess().getThenAExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_then_4_0=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"org.osate.alisa.common.Common.AExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalCommon.g:2142:3: (otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==58) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalCommon.g:2143:4: otherlv_5= 'else' ( (lv_else_6_0= ruleAExpression ) )
                    {
                    otherlv_5=(Token)match(input,58,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getAIfExpressionAccess().getElseKeyword_5_0());
                      			
                    }
                    // InternalCommon.g:2147:4: ( (lv_else_6_0= ruleAExpression ) )
                    // InternalCommon.g:2148:5: (lv_else_6_0= ruleAExpression )
                    {
                    // InternalCommon.g:2148:5: (lv_else_6_0= ruleAExpression )
                    // InternalCommon.g:2149:6: lv_else_6_0= ruleAExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAIfExpressionAccess().getElseAExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
                    lv_else_6_0=ruleAExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAIfExpressionRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_6_0,
                      							"org.osate.alisa.common.Common.AExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,59,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getAIfExpressionAccess().getEndifKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAIfExpression"


    // $ANTLR start "entryRuleALiteral"
    // InternalCommon.g:2175:1: entryRuleALiteral returns [EObject current=null] : iv_ruleALiteral= ruleALiteral EOF ;
    public final EObject entryRuleALiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleALiteral = null;


        try {
            // InternalCommon.g:2175:49: (iv_ruleALiteral= ruleALiteral EOF )
            // InternalCommon.g:2176:2: iv_ruleALiteral= ruleALiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getALiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleALiteral=ruleALiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleALiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleALiteral"


    // $ANTLR start "ruleALiteral"
    // InternalCommon.g:2182:1: ruleALiteral returns [EObject current=null] : (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm ) ;
    public final EObject ruleALiteral() throws RecognitionException {
        EObject current = null;

        EObject this_ABooleanLiteral_0 = null;

        EObject this_ARealTerm_1 = null;

        EObject this_AIntegerTerm_2 = null;

        EObject this_StringTerm_3 = null;



        	enterRule();

        try {
            // InternalCommon.g:2188:2: ( (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm ) )
            // InternalCommon.g:2189:2: (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm )
            {
            // InternalCommon.g:2189:2: (this_ABooleanLiteral_0= ruleABooleanLiteral | this_ARealTerm_1= ruleARealTerm | this_AIntegerTerm_2= ruleAIntegerTerm | this_StringTerm_3= ruleStringTerm )
            int alt33=4;
            switch ( input.LA(1) ) {
            case 60:
            case 61:
                {
                alt33=1;
                }
                break;
            case RULE_REAL_LIT:
                {
                alt33=2;
                }
                break;
            case RULE_INT:
                {
                alt33=3;
                }
                break;
            case RULE_STRING:
                {
                alt33=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalCommon.g:2190:3: this_ABooleanLiteral_0= ruleABooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getALiteralAccess().getABooleanLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ABooleanLiteral_0=ruleABooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ABooleanLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalCommon.g:2199:3: this_ARealTerm_1= ruleARealTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getALiteralAccess().getARealTermParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ARealTerm_1=ruleARealTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ARealTerm_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalCommon.g:2208:3: this_AIntegerTerm_2= ruleAIntegerTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getALiteralAccess().getAIntegerTermParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AIntegerTerm_2=ruleAIntegerTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AIntegerTerm_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalCommon.g:2217:3: this_StringTerm_3= ruleStringTerm
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getALiteralAccess().getStringTermParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringTerm_3=ruleStringTerm();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringTerm_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleALiteral"


    // $ANTLR start "entryRuleAIntegerTerm"
    // InternalCommon.g:2229:1: entryRuleAIntegerTerm returns [EObject current=null] : iv_ruleAIntegerTerm= ruleAIntegerTerm EOF ;
    public final EObject entryRuleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAIntegerTerm = null;


        try {
            // InternalCommon.g:2229:53: (iv_ruleAIntegerTerm= ruleAIntegerTerm EOF )
            // InternalCommon.g:2230:2: iv_ruleAIntegerTerm= ruleAIntegerTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntegerTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAIntegerTerm=ruleAIntegerTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAIntegerTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAIntegerTerm"


    // $ANTLR start "ruleAIntegerTerm"
    // InternalCommon.g:2236:1: ruleAIntegerTerm returns [EObject current=null] : ( (lv_value_0_0= ruleAInt ) ) ;
    public final EObject ruleAIntegerTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:2242:2: ( ( (lv_value_0_0= ruleAInt ) ) )
            // InternalCommon.g:2243:2: ( (lv_value_0_0= ruleAInt ) )
            {
            // InternalCommon.g:2243:2: ( (lv_value_0_0= ruleAInt ) )
            // InternalCommon.g:2244:3: (lv_value_0_0= ruleAInt )
            {
            // InternalCommon.g:2244:3: (lv_value_0_0= ruleAInt )
            // InternalCommon.g:2245:4: lv_value_0_0= ruleAInt
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getAIntegerTermAccess().getValueAIntParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getAIntegerTermRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.alisa.common.Common.AInt");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAIntegerTerm"


    // $ANTLR start "entryRuleAInt"
    // InternalCommon.g:2265:1: entryRuleAInt returns [String current=null] : iv_ruleAInt= ruleAInt EOF ;
    public final String entryRuleAInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAInt = null;


        try {
            // InternalCommon.g:2265:44: (iv_ruleAInt= ruleAInt EOF )
            // InternalCommon.g:2266:2: iv_ruleAInt= ruleAInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAIntRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAInt=ruleAInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAInt.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAInt"


    // $ANTLR start "ruleAInt"
    // InternalCommon.g:2272:1: ruleAInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleAInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;


        	enterRule();

        try {
            // InternalCommon.g:2278:2: (this_INT_0= RULE_INT )
            // InternalCommon.g:2279:2: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_INT_0, grammarAccess.getAIntAccess().getINTTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAInt"


    // $ANTLR start "entryRuleARealTerm"
    // InternalCommon.g:2289:1: entryRuleARealTerm returns [EObject current=null] : iv_ruleARealTerm= ruleARealTerm EOF ;
    public final EObject entryRuleARealTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleARealTerm = null;


        try {
            // InternalCommon.g:2289:50: (iv_ruleARealTerm= ruleARealTerm EOF )
            // InternalCommon.g:2290:2: iv_ruleARealTerm= ruleARealTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleARealTerm=ruleARealTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleARealTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleARealTerm"


    // $ANTLR start "ruleARealTerm"
    // InternalCommon.g:2296:1: ruleARealTerm returns [EObject current=null] : ( (lv_value_0_0= ruleAReal ) ) ;
    public final EObject ruleARealTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:2302:2: ( ( (lv_value_0_0= ruleAReal ) ) )
            // InternalCommon.g:2303:2: ( (lv_value_0_0= ruleAReal ) )
            {
            // InternalCommon.g:2303:2: ( (lv_value_0_0= ruleAReal ) )
            // InternalCommon.g:2304:3: (lv_value_0_0= ruleAReal )
            {
            // InternalCommon.g:2304:3: (lv_value_0_0= ruleAReal )
            // InternalCommon.g:2305:4: lv_value_0_0= ruleAReal
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getARealTermAccess().getValueARealParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getARealTermRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.alisa.common.Common.AReal");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleARealTerm"


    // $ANTLR start "entryRuleAReal"
    // InternalCommon.g:2325:1: entryRuleAReal returns [String current=null] : iv_ruleAReal= ruleAReal EOF ;
    public final String entryRuleAReal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAReal = null;


        try {
            // InternalCommon.g:2325:45: (iv_ruleAReal= ruleAReal EOF )
            // InternalCommon.g:2326:2: iv_ruleAReal= ruleAReal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getARealRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAReal=ruleAReal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAReal.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAReal"


    // $ANTLR start "ruleAReal"
    // InternalCommon.g:2332:1: ruleAReal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_REAL_LIT_0= RULE_REAL_LIT ;
    public final AntlrDatatypeRuleToken ruleAReal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_REAL_LIT_0=null;


        	enterRule();

        try {
            // InternalCommon.g:2338:2: (this_REAL_LIT_0= RULE_REAL_LIT )
            // InternalCommon.g:2339:2: this_REAL_LIT_0= RULE_REAL_LIT
            {
            this_REAL_LIT_0=(Token)match(input,RULE_REAL_LIT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_REAL_LIT_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_REAL_LIT_0, grammarAccess.getARealAccess().getREAL_LITTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAReal"


    // $ANTLR start "entryRuleABooleanLiteral"
    // InternalCommon.g:2349:1: entryRuleABooleanLiteral returns [EObject current=null] : iv_ruleABooleanLiteral= ruleABooleanLiteral EOF ;
    public final EObject entryRuleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleABooleanLiteral = null;


        try {
            // InternalCommon.g:2349:56: (iv_ruleABooleanLiteral= ruleABooleanLiteral EOF )
            // InternalCommon.g:2350:2: iv_ruleABooleanLiteral= ruleABooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getABooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleABooleanLiteral=ruleABooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleABooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleABooleanLiteral"


    // $ANTLR start "ruleABooleanLiteral"
    // InternalCommon.g:2356:1: ruleABooleanLiteral returns [EObject current=null] : ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) ;
    public final EObject ruleABooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalCommon.g:2362:2: ( ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) ) )
            // InternalCommon.g:2363:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            {
            // InternalCommon.g:2363:2: ( () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' ) )
            // InternalCommon.g:2364:3: () ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            {
            // InternalCommon.g:2364:3: ()
            // InternalCommon.g:2365:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getABooleanLiteralAccess().getBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalCommon.g:2371:3: ( ( (lv_value_1_0= 'true' ) ) | otherlv_2= 'false' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==60) ) {
                alt34=1;
            }
            else if ( (LA34_0==61) ) {
                alt34=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalCommon.g:2372:4: ( (lv_value_1_0= 'true' ) )
                    {
                    // InternalCommon.g:2372:4: ( (lv_value_1_0= 'true' ) )
                    // InternalCommon.g:2373:5: (lv_value_1_0= 'true' )
                    {
                    // InternalCommon.g:2373:5: (lv_value_1_0= 'true' )
                    // InternalCommon.g:2374:6: lv_value_1_0= 'true'
                    {
                    lv_value_1_0=(Token)match(input,60,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getABooleanLiteralAccess().getValueTrueKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getABooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "value", true, "true");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalCommon.g:2387:4: otherlv_2= 'false'
                    {
                    otherlv_2=(Token)match(input,61,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getABooleanLiteralAccess().getFalseKeyword_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleABooleanLiteral"


    // $ANTLR start "entryRuleStringTerm"
    // InternalCommon.g:2396:1: entryRuleStringTerm returns [EObject current=null] : iv_ruleStringTerm= ruleStringTerm EOF ;
    public final EObject entryRuleStringTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringTerm = null;


        try {
            // InternalCommon.g:2396:51: (iv_ruleStringTerm= ruleStringTerm EOF )
            // InternalCommon.g:2397:2: iv_ruleStringTerm= ruleStringTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringTermRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringTerm=ruleStringTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringTerm; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStringTerm"


    // $ANTLR start "ruleStringTerm"
    // InternalCommon.g:2403:1: ruleStringTerm returns [EObject current=null] : ( (lv_value_0_0= ruleNoQuoteString ) ) ;
    public final EObject ruleStringTerm() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalCommon.g:2409:2: ( ( (lv_value_0_0= ruleNoQuoteString ) ) )
            // InternalCommon.g:2410:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            {
            // InternalCommon.g:2410:2: ( (lv_value_0_0= ruleNoQuoteString ) )
            // InternalCommon.g:2411:3: (lv_value_0_0= ruleNoQuoteString )
            {
            // InternalCommon.g:2411:3: (lv_value_0_0= ruleNoQuoteString )
            // InternalCommon.g:2412:4: lv_value_0_0= ruleNoQuoteString
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getStringTermAccess().getValueNoQuoteStringParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getStringTermRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.osate.alisa.common.Common.NoQuoteString");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStringTerm"


    // $ANTLR start "entryRuleNoQuoteString"
    // InternalCommon.g:2432:1: entryRuleNoQuoteString returns [String current=null] : iv_ruleNoQuoteString= ruleNoQuoteString EOF ;
    public final String entryRuleNoQuoteString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNoQuoteString = null;


        try {
            // InternalCommon.g:2432:53: (iv_ruleNoQuoteString= ruleNoQuoteString EOF )
            // InternalCommon.g:2433:2: iv_ruleNoQuoteString= ruleNoQuoteString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNoQuoteStringRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNoQuoteString=ruleNoQuoteString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNoQuoteString.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNoQuoteString"


    // $ANTLR start "ruleNoQuoteString"
    // InternalCommon.g:2439:1: ruleNoQuoteString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleNoQuoteString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalCommon.g:2445:2: (this_STRING_0= RULE_STRING )
            // InternalCommon.g:2446:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_STRING_0, grammarAccess.getNoQuoteStringAccess().getSTRINGTerminalRuleCall());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNoQuoteString"


    // $ANTLR start "entryRuleAParenthesizedExpression"
    // InternalCommon.g:2456:1: entryRuleAParenthesizedExpression returns [EObject current=null] : iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF ;
    public final EObject entryRuleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAParenthesizedExpression = null;


        try {
            // InternalCommon.g:2456:65: (iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF )
            // InternalCommon.g:2457:2: iv_ruleAParenthesizedExpression= ruleAParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAParenthesizedExpression=ruleAParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAParenthesizedExpression"


    // $ANTLR start "ruleAParenthesizedExpression"
    // InternalCommon.g:2463:1: ruleAParenthesizedExpression returns [EObject current=null] : (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) ;
    public final EObject ruleAParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_AExpression_1 = null;



        	enterRule();

        try {
            // InternalCommon.g:2469:2: ( (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' ) )
            // InternalCommon.g:2470:2: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            {
            // InternalCommon.g:2470:2: (otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')' )
            // InternalCommon.g:2471:3: otherlv_0= '(' this_AExpression_1= ruleAExpression otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAParenthesizedExpressionAccess().getLeftParenthesisKeyword_0());
              		
            }
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAParenthesizedExpressionAccess().getAExpressionParserRuleCall_1());
              		
            }
            pushFollow(FOLLOW_30);
            this_AExpression_1=ruleAExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AExpression_1;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_2=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAParenthesizedExpressionAccess().getRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAParenthesizedExpression"


    // $ANTLR start "entryRuleAADLPROPERTYREFERENCE"
    // InternalCommon.g:2491:1: entryRuleAADLPROPERTYREFERENCE returns [String current=null] : iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF ;
    public final String entryRuleAADLPROPERTYREFERENCE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAADLPROPERTYREFERENCE = null;


        try {
            // InternalCommon.g:2491:61: (iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF )
            // InternalCommon.g:2492:2: iv_ruleAADLPROPERTYREFERENCE= ruleAADLPROPERTYREFERENCE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAADLPROPERTYREFERENCERule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAADLPROPERTYREFERENCE=ruleAADLPROPERTYREFERENCE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAADLPROPERTYREFERENCE.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAADLPROPERTYREFERENCE"


    // $ANTLR start "ruleAADLPROPERTYREFERENCE"
    // InternalCommon.g:2498:1: ruleAADLPROPERTYREFERENCE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleAADLPROPERTYREFERENCE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalCommon.g:2504:2: ( (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? ) )
            // InternalCommon.g:2505:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            {
            // InternalCommon.g:2505:2: (this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )? )
            // InternalCommon.g:2506:3: this_ID_0= RULE_ID (kw= '::' this_ID_2= RULE_ID )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalCommon.g:2513:3: (kw= '::' this_ID_2= RULE_ID )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==62) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalCommon.g:2514:4: kw= '::' this_ID_2= RULE_ID
                    {
                    kw=(Token)match(input,62,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getAADLPROPERTYREFERENCEAccess().getColonColonKeyword_1_0());
                      			
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_2, grammarAccess.getAADLPROPERTYREFERENCEAccess().getIDTerminalRuleCall_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAADLPROPERTYREFERENCE"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalCommon.g:2531:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalCommon.g:2531:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalCommon.g:2532:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalCommon.g:2538:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalCommon.g:2544:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalCommon.g:2545:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalCommon.g:2545:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalCommon.g:2546:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalCommon.g:2553:3: (kw= '.' this_ID_2= RULE_ID )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==27) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalCommon.g:2554:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,27,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleThisKeyword"
    // InternalCommon.g:2571:1: entryRuleThisKeyword returns [String current=null] : iv_ruleThisKeyword= ruleThisKeyword EOF ;
    public final String entryRuleThisKeyword() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleThisKeyword = null;


        try {
            // InternalCommon.g:2571:51: (iv_ruleThisKeyword= ruleThisKeyword EOF )
            // InternalCommon.g:2572:2: iv_ruleThisKeyword= ruleThisKeyword EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getThisKeywordRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleThisKeyword=ruleThisKeyword();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleThisKeyword.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleThisKeyword"


    // $ANTLR start "ruleThisKeyword"
    // InternalCommon.g:2578:1: ruleThisKeyword returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'this' ;
    public final AntlrDatatypeRuleToken ruleThisKeyword() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalCommon.g:2584:2: (kw= 'this' )
            // InternalCommon.g:2585:2: kw= 'this'
            {
            kw=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getThisKeywordAccess().getThisKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleThisKeyword"

    // $ANTLR start synpred1_InternalCommon
    public final void synpred1_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:162:4: ( ( 'this' ) )
        // InternalCommon.g:162:5: ( 'this' )
        {
        // InternalCommon.g:162:5: ( 'this' )
        // InternalCommon.g:163:5: 'this'
        {
        match(input,18,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalCommon

    // $ANTLR start synpred2_InternalCommon
    public final void synpred2_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:181:4: ( ( ruleImageReference ) )
        // InternalCommon.g:181:5: ( ruleImageReference )
        {
        // InternalCommon.g:181:5: ( ruleImageReference )
        // InternalCommon.g:182:5: ruleImageReference
        {
        pushFollow(FOLLOW_2);
        ruleImageReference();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred2_InternalCommon

    // $ANTLR start synpred3_InternalCommon
    public final void synpred3_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:457:6: ( ( () '#' ) )
        // InternalCommon.g:457:7: ( () '#' )
        {
        // InternalCommon.g:457:7: ( () '#' )
        // InternalCommon.g:458:7: () '#'
        {
        // InternalCommon.g:458:7: ()
        // InternalCommon.g:459:7: 
        {
        }

        match(input,26,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalCommon

    // $ANTLR start synpred4_InternalCommon
    public final void synpred4_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:882:5: ( ( () ( ( ruleOpOr ) ) ) )
        // InternalCommon.g:882:6: ( () ( ( ruleOpOr ) ) )
        {
        // InternalCommon.g:882:6: ( () ( ( ruleOpOr ) ) )
        // InternalCommon.g:883:6: () ( ( ruleOpOr ) )
        {
        // InternalCommon.g:883:6: ()
        // InternalCommon.g:884:6: 
        {
        }

        // InternalCommon.g:885:6: ( ( ruleOpOr ) )
        // InternalCommon.g:886:7: ( ruleOpOr )
        {
        // InternalCommon.g:886:7: ( ruleOpOr )
        // InternalCommon.g:887:8: ruleOpOr
        {
        pushFollow(FOLLOW_2);
        ruleOpOr();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred4_InternalCommon

    // $ANTLR start synpred5_InternalCommon
    public final void synpred5_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:1000:5: ( ( () ( ( ruleOpAnd ) ) ) )
        // InternalCommon.g:1000:6: ( () ( ( ruleOpAnd ) ) )
        {
        // InternalCommon.g:1000:6: ( () ( ( ruleOpAnd ) ) )
        // InternalCommon.g:1001:6: () ( ( ruleOpAnd ) )
        {
        // InternalCommon.g:1001:6: ()
        // InternalCommon.g:1002:6: 
        {
        }

        // InternalCommon.g:1003:6: ( ( ruleOpAnd ) )
        // InternalCommon.g:1004:7: ( ruleOpAnd )
        {
        // InternalCommon.g:1004:7: ( ruleOpAnd )
        // InternalCommon.g:1005:8: ruleOpAnd
        {
        pushFollow(FOLLOW_2);
        ruleOpAnd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred5_InternalCommon

    // $ANTLR start synpred6_InternalCommon
    public final void synpred6_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:1118:5: ( ( () ( ( ruleOpEquality ) ) ) )
        // InternalCommon.g:1118:6: ( () ( ( ruleOpEquality ) ) )
        {
        // InternalCommon.g:1118:6: ( () ( ( ruleOpEquality ) ) )
        // InternalCommon.g:1119:6: () ( ( ruleOpEquality ) )
        {
        // InternalCommon.g:1119:6: ()
        // InternalCommon.g:1120:6: 
        {
        }

        // InternalCommon.g:1121:6: ( ( ruleOpEquality ) )
        // InternalCommon.g:1122:7: ( ruleOpEquality )
        {
        // InternalCommon.g:1122:7: ( ruleOpEquality )
        // InternalCommon.g:1123:8: ruleOpEquality
        {
        pushFollow(FOLLOW_2);
        ruleOpEquality();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred6_InternalCommon

    // $ANTLR start synpred7_InternalCommon
    public final void synpred7_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:1236:5: ( ( () ( ( ruleOpCompare ) ) ) )
        // InternalCommon.g:1236:6: ( () ( ( ruleOpCompare ) ) )
        {
        // InternalCommon.g:1236:6: ( () ( ( ruleOpCompare ) ) )
        // InternalCommon.g:1237:6: () ( ( ruleOpCompare ) )
        {
        // InternalCommon.g:1237:6: ()
        // InternalCommon.g:1238:6: 
        {
        }

        // InternalCommon.g:1239:6: ( ( ruleOpCompare ) )
        // InternalCommon.g:1240:7: ( ruleOpCompare )
        {
        // InternalCommon.g:1240:7: ( ruleOpCompare )
        // InternalCommon.g:1241:8: ruleOpCompare
        {
        pushFollow(FOLLOW_2);
        ruleOpCompare();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred7_InternalCommon

    // $ANTLR start synpred8_InternalCommon
    public final void synpred8_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:1372:5: ( ( () ( ( ruleOpAdd ) ) ) )
        // InternalCommon.g:1372:6: ( () ( ( ruleOpAdd ) ) )
        {
        // InternalCommon.g:1372:6: ( () ( ( ruleOpAdd ) ) )
        // InternalCommon.g:1373:6: () ( ( ruleOpAdd ) )
        {
        // InternalCommon.g:1373:6: ()
        // InternalCommon.g:1374:6: 
        {
        }

        // InternalCommon.g:1375:6: ( ( ruleOpAdd ) )
        // InternalCommon.g:1376:7: ( ruleOpAdd )
        {
        // InternalCommon.g:1376:7: ( ruleOpAdd )
        // InternalCommon.g:1377:8: ruleOpAdd
        {
        pushFollow(FOLLOW_2);
        ruleOpAdd();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred8_InternalCommon

    // $ANTLR start synpred9_InternalCommon
    public final void synpred9_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:1490:5: ( ( () ( ( ruleOpMulti ) ) ) )
        // InternalCommon.g:1490:6: ( () ( ( ruleOpMulti ) ) )
        {
        // InternalCommon.g:1490:6: ( () ( ( ruleOpMulti ) ) )
        // InternalCommon.g:1491:6: () ( ( ruleOpMulti ) )
        {
        // InternalCommon.g:1491:6: ()
        // InternalCommon.g:1492:6: 
        {
        }

        // InternalCommon.g:1493:6: ( ( ruleOpMulti ) )
        // InternalCommon.g:1494:7: ( ruleOpMulti )
        {
        // InternalCommon.g:1494:7: ( ruleOpMulti )
        // InternalCommon.g:1495:8: ruleOpMulti
        {
        pushFollow(FOLLOW_2);
        ruleOpMulti();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred9_InternalCommon

    // $ANTLR start synpred11_InternalCommon
    public final void synpred11_InternalCommon_fragment() throws RecognitionException {   
        // InternalCommon.g:2040:5: ( 'delta' )
        // InternalCommon.g:2040:6: 'delta'
        {
        match(input,54,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalCommon

    // Delegated rules

    public final boolean synpred2_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalCommon() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalCommon_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000040040030L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000040040032L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x31131800440400F0L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000003000000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000007C000000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000E00080000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000030000022L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x311B1800440400F0L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0C00000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x4000000000000002L});

}
